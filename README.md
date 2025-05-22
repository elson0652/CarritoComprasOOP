# TechMarket - Plataforma e-Commerce

Este proyecto implementa una plataforma de comercio electrónico utilizando Java y los principios de la Programación Orientada a Objetos (POO), con énfasis en la herencia, el polimorfismo y sobrecarga

## 🚀 Características

- Sistema de productos con especialización (físicos y digitales)
- Sistema de usuarios con roles específicos (clientes y administradores)
- Carrito de compras con funcionalidades completas
- Historial de compras para clientes
- Gestión de inventario para administradores

## 📦 Estructura del Proyecto

```
src/
├── main/
│   └── java/
│       └── com/
│           └── techmarket/
│               ├── models/
│               │   ├── Producto.java
│               │   ├── ProductoDigital.java
│               │   ├── ProductoFisico.java
│               │   ├── Usuario.java
│               │   ├── Cliente.java
│               │   ├── Administrador.java
│               │   └── Carrito.java
│               └── Main.java
```

## 💡 Implementación

### Jerarquía de Productos
- **Producto (Abstracta)**
  - Atributos base: id, nombre, descripción, precio y stock
  - Método abstracto: getTipoProducto()
- **ProductoDigital**
  - Atributos específicos: formato, tamañoMB, urlDescarga
- **ProductoFisico**
  - Atributos específicos: peso, dimensiones (alto, ancho, profundidad)
  - Cálculo de volumen

### Jerarquía de Usuarios
- **Usuario (Abstracta)**
  - Atributos base: id, nombre, email, contraseña
  - Método abstracto: getTipoUsuario()
- **Cliente**
  - Historial de compras
  - Información de envío
- **Administrador**
  - Gestión de inventario
  - Permisos y roles

## 🔍 Características Destacadas

1. **Herencia**: Implementación de jerarquías de clases para productos y usuarios
2. **Polimorfismo**: Uso de métodos abstractos y sobrescritura
3. **Encapsulamiento**: Atributos privados con getters y setters
4. **Validaciones**: Control de datos en todas las clases
5. **Colecciones**: Uso de ArrayList para historial y permisos

## 🚀 Cómo Ejecutar

1. Asegúrate de tener Java JDK 11 o superior instalado
2. Compila los archivos:
   ```bash
   javac src/main/java/com/techmarket/**/*.java
   ```
3. Ejecuta la clase principal:
   ```bash
   java src/main/java/com/techmarket/Main
   ```

## 💻 Ejemplo de Uso

```java
// Crear productos especializados
ProductoFisico laptop = new ProductoFisico(1, "Laptop", "Gaming", 999.99, 5, 2.5, 1.5, 35.0, 25.0);
ProductoDigital ebook = new ProductoDigital(2, "Java Guide", "Programming", 29.99, 100, "PDF", 15.5, "url");

// Crear usuarios con roles específicos
Cliente cliente = new Cliente(1, "Juan", "juan@email.com", "pass123", "Calle 123", "555-0123");
Administrador admin = new Administrador(2, "Ana", "ana@tech.com", "admin123", "Gerente", "Ventas");

// Usar el carrito
Carrito carrito = new Carrito();
carrito.agregarProducto(laptop, 1);
cliente.agregarCompra(carrito);
```

## 🛠️ Mejoras Futuras

- Sistema de pagos integrado
- Categorías de productos
- Sistema de descuentos
- Notificaciones por email
- Panel de administración
