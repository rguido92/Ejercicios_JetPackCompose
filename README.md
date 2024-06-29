Proyecto de Programación Móvil con Kotlin y Jetpack Compose
Descripción del Proyecto

Este proyecto consiste en el desarrollo de una aplicación móvil utilizando Kotlin y Jetpack Compose. La aplicación abarca varios temas avanzados de Jetpack Compose, incluyendo la gestión de presupuestos para compra de productos tecnológicos, una agenda de contactos con funcionalidad CRUD, gestión de login con validación de usuarios, y funcionalidades avanzadas para listas de compra con y sin carrito de compra.
Ejercicios Avanzados Compose
1. Listado de Presupuesto para Compra de Productos Tecnológicos

    Desarrollar una aplicación que permita generar presupuestos para equipos de computación.
    Mostrar una lista de componentes de computadora con Checkbox para seleccionar/deseleccionar.
    Implementar funciones componibles para administrar el estado del costo total y el estado de selección de los componentes.
    Utilizar una data class Producto y una lista constante para representar los productos.
    Incluir imágenes de los componentes en la carpeta drawable.

2. Agenda de Contactos

    Implementar funcionalidad CRUD para gestionar una lista de contactos.
    Guardar los datos de contactos en un fichero textual en el sistema operativo Android.
    Utilizar una data class Contacto y en una versión inicial una lista mutable de contactos.

3. Gestión de Login

    Validar usuarios con un listado en memoria.
    Mostrar un mensaje de error si la validación falla, indicando los intentos restantes.

4. Lista de Compra (sin Carrito de Compra)

    Crear un componente para introducir elementos y formar una lista de compra.
    Permitir eliminar y seleccionar/deseleccionar elementos mediante Checkbox.
    Incluir un Checkbox especial en la cabecera del listado para seleccionar/deseleccionar todos los elementos.

5. Gestión de Compras (con Carrito de Compra)

    Ampliación de la app de presupuesto para incluir funcionalidades de compra.
    Mantenimiento del listado de productos con filtrado por categoría.
    Agregar elementos seleccionados a un carrito de compra.
    Simular proceso de compra con confirmación/cancelación del pedido.
    Incorporar icono de carro de compra con conteo dinámico de elementos.

Consideraciones

    Todos los temas estan implementados con elevación de estado (State Hoisting) y uso de ViewModel para mantener y gestionar el estado de la aplicación de manera eficiente.
    Se utiliza Jetpack Compose para la construcción de la interfaz de usuario, aprovechando las capacidades modernas de declaratividad y composición que ofrece.
