package utez.edu.mx.sagg.services;

public interface EmailService {
    void sendPasswordResetEmail(String emailTo, String token);
}
