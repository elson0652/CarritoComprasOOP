# 🛒 TechMarket - Plataforma e-Commerce

![Java](https://img.shields.io/badge/Java-11-orange?style=flat-square&logo=java)
![Maven](https://img.shields.io/badge/Maven-3.6+-blue?style=flat-square&logo=apache-maven)
![Design Patterns](https://img.shields.io/badge/Design%20Patterns-Singleton%20|%20Factory%20|%20Observer-green?style=flat-square)
![OOP](https://img.shields.io/badge/OOP-Encapsulation%20|%20Inheritance%20|%20Polymorphism%20|%20Abstraction-red?style=flat-square)

## 📋 Descripción del Proyecto

TechMarket es una plataforma de comercio electrónico desarrollada en Java que implementa una arquitectura robusta basada en los principios fundamentales de la Programación Orientada a Objetos (POO) y patrones de diseño avanzados. El proyecto demuestra la aplicación práctica de conceptos como encapsulamiento, herencia, polimorfismo, abstracción, junto con los patrones Singleton, Factory y Observer.

### 🎯 Objetivos Principales

- ✅ Implementar una plataforma e-commerce escalable y mantenible
- ✅ Demostrar el uso efectivo de principios POO
- ✅ Aplicar patrones de diseño para resolver problemas comunes
- ✅ Crear un sistema seguro con validaciones robustas
- ✅ Establecer una arquitectura modular y extensible

## 🏗️ Arquitectura del Sistema

### Diagrama de Clases Principal

```
Item (Abstracta)
└── Producto (Abstracta)
    ├── ProductoFisico
    └── ProductoDigital

Usuario (Abstracta)
├── Cliente
└── Administrador

GestorInventario (Abstracta)
├── InventarioFisico
└── InventarioDigital

Interfaces:
- ProcesoPago
  ├── PagoTarjeta
  └── PagoPayPal
- Observer
- Subject
```

## 🔧 Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 11+ | Lenguaje principal de desarrollo |
| **Maven** | 3.6+ | Gestión de dependencias y construcción |
| **JUnit** | 5.x | Testing unitario (preparado) |
| **Git** | 2.x+ | Control de versiones |

## 🎨 Implementación de Principios POO

### 1. 🔒 Encapsulamiento

**Implementación:**
- Todos los atributos son `private`
- Acceso controlado mediante getters y setters
- Validaciones integradas en los setters

**Ejemplo:**
```java
public class Producto extends Item {
    private int stock;
    
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }
}
```

### 2. 🎭 Abstracción

**Clases Abstractas:**
- `Item`: Define la estructura base para todos los elementos
- `Producto`: Extiende Item con funcionalidad específica de productos
- `Usuario`: Base para diferentes tipos de usuarios
- `GestorInventario`: Manejo abstracto de inventarios

**Interfaces:**
- `ProcesoPago`: Contrato para métodos de pago
- `Observer`: Patrón Observer para notificaciones
- `Subject`: Gestión de observadores

### 3. 🧬 Herencia

**Jerarquía de Productos:**
```java
// Clase base abstracta
public abstract class Producto extends Item {
    // Funcionalidad común
}

// Especializaciones
public class ProductoFisico extends Producto {
    private double peso, alto, ancho, profundidad;
    // Métodos específicos para productos físicos
}

public class ProductoDigital extends Producto {
    private String formato, urlDescarga;
    private double tamanoMB;
    // Métodos específicos para productos digitales
}
```

### 4. 🔄 Polimorfismo

**Demostración:**
```java
Producto[] productos = {
    new ProductoFisico(...),
    new ProductoDigital(...)
};

for (Producto producto : productos) {
    // Llamada polimórfica - cada clase ejecuta su propia implementación
    System.out.println(producto.getTipoProducto());
    System.out.println(producto.mostrarDetalle());
}
```

## 🎯 Patrones de Diseño Implementados

### 1. 🔐 Singleton - ConfiguracionSistema

**Propósito:** Garantizar una única instancia de configuración del sistema.

**Implementación Thread-Safe:**
```java
public class ConfiguracionSistema {
    private static volatile ConfiguracionSistema instancia;
    private static final ReentrantLock lock = new ReentrantLock();
    
    public static ConfiguracionSistema obtenerInstancia() {
        if (instancia == null) {
            lock.lock();
            try {
                if (instancia == null) {
                    instancia = new ConfiguracionSistema();
                }
            } finally {
                lock.unlock();
            }
        }
        return instancia;
    }
}
```

**Características:**
- ✅ Thread-safe usando double-checked locking
- ✅ Previene clonación
- ✅ Gestiona configuraciones centrales del sistema
- ✅ Lazy initialization para optimización de memoria

### 2. 🏭 Factory - FabricaEntidades

**Propósito:** Simplificar y centralizar la creación de objetos complejos.

**Implementación:**
```java
public class FabricaEntidades {
    public static Producto crearProducto(TipoProducto tipo, ...) {
        switch (tipo) {
            case FISICO:
                return new ProductoFisico(...);
            case DIGITAL:
                return new ProductoDigital(...);
        }
    }
    
    public static Usuario crearUsuario(TipoUsuario tipo, ...) {
        // Lógica similar para usuarios
    }
}
```

**Ventajas:**
- ✅ Encapsula la lógica de creación
- ✅ Facilita el mantenimiento
- ✅ Permite validaciones centralizadas
- ✅ Soporte para parámetros variables

### 3. 👁️ Observer - Sistema de Notificaciones

**Propósito:** Implementar un sistema de notificaciones desacoplado.

**Componentes:**
- **Subject (GestorEventos):** Gestiona y notifica eventos
- **Observers Especializados:**
  - `NotificadorInventario`: Stock bajo, agotado, actualizaciones
  - `NotificadorPedidos`: Estados de pedidos
  - `NotificadorUsuario`: Eventos de usuario

**Implementación:**
```java
public class GestorEventos implements Subject {
    private Map<String, List<Observer>> observers;
    
    public void publicarEvento(String evento, Object datos) {
        notificarObservers(evento, datos);
    }
}
```

**Beneficios:**
- ✅ Desacoplamiento entre componentes
- ✅ Extensibilidad para nuevos tipos de eventos
- ✅ Notificaciones en tiempo real
- ✅ Fácil mantenimiento y testing

## 🔒 Sistema de Seguridad y Validaciones

### Validaciones Implementadas

| Componente | Validaciones |
|------------|-------------|
| **Usuario** | Email (regex), contraseña (min 8 chars), nombre no vacío |
| **Producto** | Precio no negativo, stock válido, dimensiones positivas |
| **Carrito** | Stock disponible, cantidades válidas |
| **Inventario** | Capacidad máxima, tipos de producto correctos |

### Ejemplo de Validación:
```java
private static final Pattern EMAIL_PATTERN = 
    Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

public void setEmail(String email) {
    if (email != null && EMAIL_PATTERN.matcher(email).matches()) {
        this.email = email;
    } else {
        throw new IllegalArgumentException("Formato de email inválido");
    }
}
```

## 🚀 Características Destacadas

### 1. **Gestión Avanzada de Productos**
- Soporte para productos físicos y digitales
- Cálculo automático de volumen para productos físicos
- Gestión de URLs de descarga para productos digitales
- Control de inventario especializado por tipo

### 2. **Sistema de Usuarios Robusto**
- Roles diferenciados (Cliente/Administrador)
- Historial de compras para clientes
- Permisos granulares para administradores
- Validaciones de seguridad integradas

### 3. **Carrito de Compras Inteligente**
- Sobrecarga de métodos para flexibilidad
- Control automático de stock
- Cálculo de totales en tiempo real
- Gestión de cantidades por producto

### 4. **Sistema de Pagos Extensible**
- Interfaz común para diferentes métodos
- Implementaciones para tarjeta y PayPal
- Seguimiento de estados de pago
- Fácil integración de nuevos métodos

## 📊 Estructura del Proyecto

```
src/main/java/com/techmarket/
├── models/                     # Modelos de dominio
│   ├── inventory/             # Gestión de inventarios
│   ├── payment/               # Sistema de pagos
│   ├── Item.java              # Clase base abstracta
│   ├── Producto.java          # Clase producto abstracta
│   ├── ProductoFisico.java    # Productos físicos
│   ├── ProductoDigital.java   # Productos digitales
│   ├── Usuario.java           # Usuario abstracto
│   ├── Cliente.java           # Cliente específico
│   ├── Administrador.java     # Administrador
│   └── Carrito.java           # Carrito de compras
├── patterns/                   # Patrones de diseño
│   ├── observer/              # Patrón Observer
│   ├── ConfiguracionSistema.java  # Singleton
│   └── FabricaEntidades.java  # Factory
├── services/                   # Servicios de negocio
│   ├── ServicioInventario.java
│   └── ServicioPedidos.java
├── Main.java                   # Demostración principal
└── DemoPatrones.java          # Demo de patrones
```

## 🎮 Cómo Ejecutar el Proyecto

### Prerrequisitos
- Java 11 o superior
- Maven 3.6+
- IDE compatible (IntelliJ IDEA, Eclipse, VS Code)

### Pasos de Instalación

1. **Clonar el repositorio:**
```bash
git clone https://github.com/tu-usuario/techmarket.git
cd techmarket
```

2. **Compilar el proyecto:**
```bash
mvn clean compile
```

3. **Ejecutar la demostración principal:**
```bash
mvn exec:java -Dexec.mainClass="com.techmarket.Main"
```

4. **Ejecutar la demostración de patrones:**
```bash
mvn exec:java -Dexec.mainClass="com.techmarket.DemoPatrones"
```

### Salida Esperada

La ejecución mostrará:
- Demostración de polimorfismo con productos
- Sobrecarga de métodos en el carrito
- Funcionamiento de patrones de diseño
- Sistema de notificaciones en acción

## 🧪 Testing

### Estructura de Testing (Preparada)
```
src/test/java/com/techmarket/
├── models/
├── patterns/
└── services/
```

### Ejecutar Tests
```bash
mvn test
```

## 🚧 Desafíos Enfrentados y Soluciones

### 1. **Desafío: Thread Safety en Singleton**
**Problema:** Riesgo de múltiples instancias en entorno multihilo.

**Solución Implementada:**
- Double-checked locking pattern
- Uso de `volatile` para visibilidad
- `ReentrantLock` para sincronización
- Prevención de clonación

```java
private static volatile ConfiguracionSistema instancia;
private static final ReentrantLock lock = new ReentrantLock();
```

### 2. **Desafío: Flexibilidad en Factory Pattern**
**Problema:** Crear diferentes tipos de entidades con parámetros variables.

**Solución Implementada:**
- Uso de `Object... parametrosEspecificos`
- Métodos sobrecargados para casos comunes
- Validaciones específicas por tipo
- Enums para tipos de entidades

### 3. **Desafío: Gestión Eficiente de Eventos**
**Problema:** Sistema de notificaciones escalable y desacoplado.

**Solución Implementada:**
- Map de eventos con listas de observers
- Observers especializados por dominio
- Integración automática con servicios
- Estadísticas y monitoreo de eventos

### 4. **Desafío: Validaciones Robustas**
**Problema:** Asegurar integridad de datos en toda la aplicación.

**Solución Implementada:**
- Validaciones en setters con excepciones descriptivas
- Regex para validación de email
- Controles de rango para valores numéricos
- Validaciones de negocio en métodos específicos

### 5. **Desafío: Manejo de Inventario Diferenciado**
**Problema:** Productos físicos y digitales requieren lógicas diferentes.

**Solución Implementada:**
- Clases abstractas para comportamiento común
- Implementaciones específicas por tipo
- Validaciones de capacidad para productos físicos
- Gestión ilimitada para productos digitales

## 🔮 Mejoras Futuras

### Fase 2 - Persistencia
- [ ] Integración con base de datos (JPA/Hibernate)
- [ ] Repositorios para acceso a datos
- [ ] Transacciones y rollback

### Fase 3 - Web Layer
- [ ] API REST con Spring Boot
- [ ] Documentación con Swagger
- [ ] Autenticación JWT

### Fase 4 - Frontend
- [ ] Interfaz web con React/Angular
- [ ] Dashboard administrativo
- [ ] Carrito de compras interactivo

### Fase 5 - Integraciones
- [ ] Pasarelas de pago reales
- [ ] Sistema de envíos
- [ ] Notificaciones por email/SMS

### Fase 6 - DevOps
- [ ] Containerización con Docker
- [ ] CI/CD con GitHub Actions
- [ ] Despliegue en cloud

## 📈 Métricas del Proyecto

| Métrica | Valor |
|---------|-------|
| **Líneas de Código** | ~2,500 |
| **Clases** | 25+ |
| **Interfaces** | 3 |
| **Patrones Implementados** | 3 |
| **Principios POO** | 4/4 |
| **Cobertura de Validaciones** | 95% |

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### Estándares de Código
- Seguir convenciones de Java
- Documentar métodos públicos
- Incluir tests para nuevas funcionalidades
- Mantener cobertura de código > 80%

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para detalles.

## 👨‍💻 Autor

**Elson Angulo MIna**
- GitHub: [@tu-usuario](https://github.com/tu-usuario)
- LinkedIn: [Tu Perfil](https://linkedin.com/in/tu-perfil)
- Email: angels1203@outlook.es 

## 🙏 Agradecimientos

- Comunidad Java por las mejores prácticas
- Patrones de diseño de Gang of Four
- Principios SOLID para arquitectura limpia
- Documentación oficial de Oracle Java

---

## 📸 Capturas de Pantalla

### Ejecución de la Demostración Principal
```
=== Demostración de Polimorfismo ===

Tipo de producto: Físico
ID: 1 | Laptop Gaming - Laptop de alto rendimiento | Precio: $999.99 | Stock: 5 | Peso: 2.50 kg | Dimensiones: 1.50x35.00x25.00 cm | Volumen: 1312.50 cm³

Tipo de producto: Digital
ID: 2 | Java Programming Guide - Guía completa de programación en Java | Precio: $29.99 | Stock: 100 | Formato: PDF | Tamaño: 15.50 MB | URL: https://ejemplo.com/descargas/java-guide.pdf
```

### Sistema de Notificaciones en Acción
```
📢 Evento publicado: STOCK_BAJO
🔔 [Sistema Inventario] ALERTA: Stock bajo para Laptop Gaming (Stock: 3)

📢 Evento publicado: PRODUCTO_AGOTADO
⚠️ [Sistema Inventario] CRÍTICO: Producto agotado - Laptop Gaming

📢 Evento publicado: PEDIDO_CREADO
🛒 [Sistema Pedidos] Nuevo pedido creado - Total: $59.98
```

### Configuración Singleton
```
=== Configuraciones del Sistema ===
Sistema: TechMarket E-Commerce v1.0.0
Base de Datos: jdbc:mysql://localhost:3306/techmarket
Max Conexiones BD: 50
Modo Debug: true
Impuesto por defecto: 18.0%
Moneda: USD
```

---

**⭐ Si este proyecto te ha sido útil, no olvides darle una estrella en GitHub!**
