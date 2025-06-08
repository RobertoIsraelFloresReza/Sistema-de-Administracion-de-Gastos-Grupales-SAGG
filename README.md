# 💰 Sistema de Administración de Gastos Grupales (SAGG)

Un sistema web para registrar, dividir y monitorear gastos compartidos entre grupos de usuarios, de manera equitativa, eficiente y segura.

---

## 🎯 Objetivo Principal

Desarrollar una aplicación web que permita a grupos (sin límite de miembros) gestionar sus finanzas compartidas con funcionalidades clave como:

- División automática de gastos (igual o porcentajes personalizados).
- Cálculo de saldos individuales.
- Notificaciones de pagos pendientes.
- Reportes visuales y exportables.

---

## 👥 Usuarios y Roles

- **Administrador General**  
  - Gestiona todas las cuentas de usuario del sistema (crear/eliminar).

- **Administrador de Grupo**  
  - Crea y administra grupos, añade miembros por correo o código, define categorías y porcentajes de división.

- **Usuario Regular**  
  - Registra gastos, visualiza saldos y genera reportes personales.

---

## 📋 Módulos Principales

- **Gestión de Usuarios:** Registro, login, cambio de contraseña, manejo de roles.
- **Gestión de Grupos:** Crear/join por código, invitar por correo, asignar administradores.
- **Gestión de Categorías:** Alimentos y Servicios (por defecto) + categorías personalizables.
- **Registro de Gastos:** Monto, descripción, fecha automática, división igualitaria o por porcentaje.
- **Cálculo de Aportes:** Saldos por usuario, saldos a favor/deudas.
- **Notificaciones:** Alertas 5 días antes del fin de mes por pagos pendientes.
- **Reportes y Estadísticas:** Gráficos por mes/persona, exportables a PDF/Excel.
- **Historial:** Visualización de gastos pasados (no editables).
- **Seguridad:** Autenticación robusta, cifrado de contraseñas, bloqueo tras intentos fallidos.

---

## 🧑‍💻 Tecnologías Utilizadas
Frontend: React.js – Interfaz web moderna, modular y dinámica.

Backend: Spring Boot – Framework robusto para lógica de negocio y APIs RESTful.

Base de Datos: MySQL – Almacenamiento relacional de datos estructurados.
