### README

# Proyecto de Búsqueda y ProxyService

## Descripción del Proyecto

Este proyecto está dividido en dos repositorios para gestionar el `ProxyService` y los servicios de búsqueda (`linearsearch` y `binarysearch`). Aquí se proporciona una explicación detallada de la arquitectura, la solución y los módulos principales.

## Arquitectura

La arquitectura del proyecto se basa en una aplicación Spring Boot que actúa como un proxy para los servicios de búsqueda. La aplicación proxy recibe solicitudes de búsqueda y las redirige a los servicios correspondientes (`linearsearch` y `binarysearch`). La arquitectura se divide en los siguientes componentes:

1. **ProxyService**: Este servicio actúa como intermediario entre el cliente y los servicios de búsqueda. Recibe las solicitudes del cliente y las redirige al servicio de búsqueda adecuado.
2. **Servicios de Búsqueda**: Estos servicios realizan las operaciones de búsqueda (lineal y binaria) y devuelven los resultados al `ProxyService`.
### Manejo de Búsqueda Lineal y Binaria

En este proyecto, se implementan dos tipos de búsqueda: búsqueda lineal y búsqueda binaria. Ambas búsquedas se manejan a través de servicios separados que son llamados por el `ProxyService`.

#### Búsqueda Lineal

La búsqueda lineal es un algoritmo simple que recorre cada elemento de la lista hasta encontrar el valor buscado o hasta que se hayan revisado todos los elementos. Este tipo de búsqueda es útil para listas pequeñas o no ordenadas.

**Proceso de Búsqueda Lineal:**
1. El `ProxyService` recibe una solicitud de búsqueda lineal.
2. El `ProxyService` selecciona una instancia de servicio disponible y redirige la solicitud a la URL correspondiente del servicio de búsqueda lineal.
3. El servicio de búsqueda lineal procesa la solicitud, recorre la lista y busca el valor especificado.
4. El resultado de la búsqueda se devuelve al `ProxyService`, que a su vez lo envía de vuelta al cliente.

#### Búsqueda Binaria

La búsqueda binaria es un algoritmo más eficiente que requiere que la lista esté ordenada. Divide repetidamente la lista en mitades y compara el valor buscado con el elemento central, reduciendo así el rango de búsqueda a la mitad en cada paso.

**Proceso de Búsqueda Binaria:**
1. El `ProxyService` recibe una solicitud de búsqueda binaria.
2. El `ProxyService` selecciona una instancia de servicio disponible y redirige la solicitud a la URL correspondiente del servicio de búsqueda binaria.
3. El servicio de búsqueda binaria procesa la solicitud, verifica que la lista esté ordenada y realiza la búsqueda dividiendo la lista en mitades.
4. El resultado de la búsqueda se devuelve al `ProxyService`, que a su vez lo envía de vuelta al cliente.

### Resumen

Ambos tipos de búsqueda se manejan de manera similar en términos de flujo de solicitud y respuesta, pero utilizan diferentes algoritmos para encontrar el valor buscado. El `ProxyService` actúa como intermediario, asegurando que las solicitudes se redirijan al servicio adecuado y que los resultados se devuelvan al cliente de manera eficiente.

# Solución

La solución se implementa utilizando Spring Boot y se divide en dos servicios corriendo en diferentes puertos:

1. **ProxyService**: Contiene la lógica del proxy que redirige las solicitudes a los servicios de búsqueda.
2. **Servicios de Búsqueda**: Contiene la lógica para realizar las búsquedas lineal y binaria.

### Pasos para Ejecutar la Solución

1. **Clonar el repositorio**:
    ```sh
    git clone https://github.com/juanjoseEci/Parcial2Arp
    ```

2. **Iniciar los Servicios de Búsqueda**:
    Navegue al directorio del servicio de búsqueda y ejecute:
    ```sh
    mvn spring-boot:run
    ```

3. **Iniciar el ProxyService**:
    Navegue al directorio del serivicio del `ProxyService` y ejecute:
    ```sh
    mvn spring-boot:run
    ```
## Módulos Principales

### ProxyService

- **ProxyService.java**: Controlador principal que maneja las solicitudes de búsqueda y las redirige a los servicios de búsqueda.
- **application.properties**: Archivo de configuración que contiene las instancias de los servicios de búsqueda.

### Servicios de Búsqueda

- **LinearSearchService.java**: Implementa la lógica para realizar la búsqueda lineal.
- **BinarySearchService.java**: Implementa la lógica para realizar la búsqueda binaria.
- **application.properties**: Archivo de configuración para los servicios de búsqueda.
