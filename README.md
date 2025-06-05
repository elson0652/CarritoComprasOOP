# TechMarket - Plataforma e-Commerce

Este proyecto implementa una plataforma de comercio electrónico utilizando Java, con énfasis en los principios de la Programación Orientada a Objetos (POO), incluyendo encapsulamiento, abstracción, herencia y polimorfismo.

## 🎯 Objetivos del Proyecto

- Implementar una plataforma e-commerce robusta y escalable
- Demostrar el uso efectivo de principios POO
- Crear un sistema seguro y mantenible

## 🏗️ Arquitectura y Diseño

### Encapsulamiento
- Todos los atributos son privados (`private`)
- Acceso controlado mediante getters y setters
- Validaciones implementadas en setters:
  - Precios no negativos
  - Stock válido
  - Formato de email
  - Contraseña segura

### Abstracción
- Clase base abstracta `Item`
  - Atributos comunes: id, nombre, descripción, precio
  - Métodos abstractos: `getTipo()`, `getDetalles()`
- Clase abstracta `GestorInventario`
  - Métodos abstractos para gestión de inventario
  - Implementaciones específicas para productos físicos y digitales
- Interfaz `ProcesoPago`
  - Define contrato para diferentes métodos de pago
  - Implementaciones para tarjeta y PayPal

### Herencia
```
Item (Abstracta)
└── Producto (Abstracta)
    ├── ProductoFisico
    └── ProductoDigital

GestorInventario (Abstracta)
├── InventarioFisico
└── InventarioDigital

Usuario (Abstracta)
├── Cliente
└── Administrador
```

### Interfaces
```
ProcesoPago
├── PagoTarjeta
└── PagoPayPal
```

## 💡 Características Principales

1. **Gestión de Productos**
   - Productos físicos y digitales
   - Control de inventario especializado
   - Validaciones de datos

2. **Sistema de Usuarios**
   - Roles específicos (Cliente/Administrador)
   - Validación de datos de usuario
   - Gestión segura de contraseñas

3. **Sistema de Pagos**
   - Múltiples métodos de pago
   - Proceso de pago seguro
   - Seguimiento del estado de pagos

4. **Gestión de Inventario**
   - Inventario físico y digital separado
   - Control de capacidad
   - Validaciones específicas por tipo

## 🔒 Seguridad y Validaciones

- Validación de email mediante expresiones regulares
- Contraseñas con mínimo de 8 caracteres
- Protección de datos sensibles
- Control de acceso a métodos críticos

## 🚀 Mejoras Futuras

1. Implementación de base de datos
2. Integración con pasarelas de pago reales
3. Sistema de notificaciones
4. Panel administrativo completo
5. Sistema de reseñas

## 📝 Conclusiones

El proyecto demuestra una implementación robusta y efectiva de los principios fundamentales de la Programación Orientada a Objetos, donde el encapsulamiento protege la integridad de los datos, la abstracción establece una estructura clara con clases abstractas e interfaces bien definidas, la herencia permite la reutilización efectiva de código, y el polimorfismo ofrece flexibilidad en el manejo de diferentes tipos de productos, inventarios y métodos de pago, resultando en una arquitectura mantenible, escalable y segura que satisface las necesidades de una plataforma de comercio electrónico moderna.