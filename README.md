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
- Jerarquía de productos
  - `Producto` extiende `Item`
  - `ProductoFisico` y `ProductoDigital` heredan de `Producto`

### Herencia
```
Item (Abstracta)
└── Producto (Abstracta)
    ├── ProductoFisico
    └── ProductoDigital

Usuario (Abstracta)
├── Cliente
└── Administrador
```

### Polimorfismo
- Método `getTipoProducto()` implementado diferentemente en cada tipo de producto
- Método `getTipoUsuario()` específico para cada tipo de usuario
- Sobrecarga de métodos en `Carrito` para agregar productos

## 💡 Características Principales

1. **Gestión de Productos**
   - Productos físicos y digitales
   - Control de inventario
   - Validaciones de datos

2. **Sistema de Usuarios**
   - Roles específicos (Cliente/Administrador)
   - Validación de datos de usuario
   - Gestión segura de contraseñas

3. **Carrito de Compras**
   - Múltiples formas de agregar productos
   - Cálculo automático de totales
   - Control de stock

## 🔒 Seguridad y Validaciones

- Validación de email mediante expresiones regulares
- Contraseñas con mínimo de 8 caracteres
- Protección de datos sensibles
- Control de acceso a métodos críticos

## 🚀 Mejoras Futuras

1. Implementación de base de datos
2. Sistema de pagos
3. Gestión de categorías
4. Sistema de reseñas
5. Panel administrativo completo

## 📝 Conclusiones

El proyecto demuestra la aplicación efectiva de los principios POO:

- **Encapsulamiento**: Protección de datos y validaciones robustas
- **Abstracción**: Jerarquía clara de clases con comportamientos comunes
- **Herencia**: Reutilización de código y especialización de clases
- **Polimorfismo**: Flexibilidad en el manejo de diferentes tipos de productos y usuarios

La arquitectura resultante es:
- Mantenible: Código organizado y modular
- Escalable: Fácil de extender con nuevas funcionalidades
- Segura: Datos protegidos y validados
- Reutilizable: Componentes bien definidos y modulares