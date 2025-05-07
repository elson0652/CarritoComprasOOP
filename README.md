# TechMarket - Plataforma e-Commerce

Este proyecto implementa las clases básicas necesarias para una plataforma de comercio electrónico utilizando Java y los principios de la Programación Orientada a Objetos (POO).

## 🚀 Características

- Gestión de productos con control de inventario
- Sistema de usuarios
- Carrito de compras con funcionalidades completas
- Validaciones de datos y manejo de errores

## 📦 Estructura del Proyecto

```
src/
├── main/
│   └── java/
│       └── com/
│           └── techmarket/
│               ├── models/
│               │   ├── Producto.java
│               │   ├── Usuario.java
│               │   └── Carrito.java
│               └── Main.java
```

## 💡 Implementación

### Clase Producto
- Atributos: id, nombre, descripción, precio y stock
- Métodos para gestionar el inventario
- Validaciones para precio y stock

### Clase Usuario
- Atributos: id, nombre, email y contraseña
- Métodos para gestionar la información del usuario
- Implementación de toString() para mejor depuración

### Clase Carrito
- Gestión de lista de productos
- Cálculo automático del total
- Métodos para agregar y eliminar productos
- Control de stock al realizar operaciones

## 🔍 Características Destacadas

1. **Encapsulamiento**: Todos los atributos son privados con getters y setters apropiados
2. **Validaciones**: Control de stock y precios negativos
3. **Gestión de Memoria**: Implementación de finalize() en Usuario
4. **Colecciones**: Uso de ArrayList para el carrito
5. **Formato**: Implementación de toString() para mejor visualización

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
Producto laptop = new Producto(1, "Laptop", "Laptop gaming", 999.99, 5);
Usuario usuario = new Usuario(1, "Juan", "juan@email.com", "contraseña123");
Carrito carrito = new Carrito();

carrito.agregarProducto(laptop, 2);
carrito.mostrarCarrito();
```

## 🛠️ Mejoras Futuras

- Implementar persistencia de datos
- Agregar sistema de pagos
- Implementar historial de compras
- Añadir categorías de productos
- Implementar sistema de descuentos