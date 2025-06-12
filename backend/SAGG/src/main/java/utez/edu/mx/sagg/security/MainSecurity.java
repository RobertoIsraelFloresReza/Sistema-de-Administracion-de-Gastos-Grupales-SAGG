package utez.edu.mx.sagg.security;

import utez.edu.mx.sagg.security.jwt.JwtAuthenticationFilter;
import utez.edu.mx.sagg.security.jwt.JwtProvider;
import utez.edu.mx.sagg.security.service.UserDetailsImplService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MainSecurity {
    // Constantes para los roles
    private static final String ADMIN_GENERAL = "ADMIN_GENERAL";
    private static final String ADMIN_GRUPAL = "ADMIN_GRUPAL";
    private static final String USUARIO_REGULAR = "USUARIO_REGULAR";
    private static final String[] ALL_ROLES = {ADMIN_GENERAL, ADMIN_GRUPAL, USUARIO_REGULAR};

    private final UserDetailsImplService service;
    private final JwtProvider jwtProvider;

    public MainSecurity(UserDetailsImplService service, JwtProvider jwtProvider) {
        this.service = service;
        this.jwtProvider = jwtProvider;
    }

    private final String[] whiteList = {
            "/api/auth/**",
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(service);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JwtAuthenticationFilter filter() {
        return new JwtAuthenticationFilter(jwtProvider, service);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(whiteList).permitAll()
                                .requestMatchers("/api/users/request-password-reset").permitAll()
                                .requestMatchers("/api/users/reset-password").permitAll()
                                .requestMatchers("/api/users/**").permitAll()
                                .requestMatchers("/api/person/**").hasAnyAuthority(ALL_ROLES)
                                .requestMatchers("/api/role/**").hasAnyAuthority(ALL_ROLES)
                                .requestMatchers("/api/asignacion/**").hasAnyAuthority(ALL_ROLES)
                                .requestMatchers("/api/auditoria/**").hasAnyAuthority(ALL_ROLES)
                                .requestMatchers("/api/historialcita/**").hasAnyAuthority(ALL_ROLES)
                                .requestMatchers("/api/bitacora/**").hasAnyAuthority(ALL_ROLES)
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(filter(), UsernamePasswordAuthenticationFilter.class)
                .logout(out -> out.logoutUrl("/api/auth/logout").clearAuthentication(true));
        return http.build();
    }
}