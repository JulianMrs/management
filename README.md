# MANAGEMENT-micro

Este microservicio proporciona un servicio para obtener el precio de un producto en una fecha específica para un grupo de cadenas.

## API

El microservicio expone una API RESTful con los siguientes endpoints:

### Obtener Precio de Producto

Endpoint:

```
GET /price/{productId}
```

Parámetros de la ruta (path variables):

- `productId`: Identificador del producto cuyo precio se desea obtener.

Parámetros de la solicitud (request params):

- `applicationDate`: Fecha para la cual se desea obtener el precio del producto (formato: `yyyy-MM-dd'T'HH:mm:ss`).
- `productId`: Identificador de producto.
- `brandId`: Identificador de la cadena del grupo (1 = ZARA).

#### Ejemplo de solicitud:

```
GET /price/35455?brandId=1&date=2020-06-14T10:00:00
```

#### Respuesta Exitosa:

Código de estado: `200 OK`

Cuerpo de la respuesta:

```json
{
  "startDate": "2020-06-14T00:00:00",
  "endDate": "2020-12-31T23:59:59",
  "price": 35.50,
  "priceList": 1,
  "productId": 35455,
  "brandId": 1
}
```

#### Respuesta de Error:

Código de estado: `404 Not Found`

Cuerpo de la respuesta:

```json
{
  "error": "El producto con id '35456' perteneciente al grupo: '1' no existe."
}
```

## Ejecución

Para ejecutar el microservicio en un entorno local, sigue estos pasos:

1. Clona el repositorio de GitHub:

   ```
   git clone https://github.com/JulianMrs/management.git
   ```

2. Navega al directorio del proyecto:

   ```
   cd management
   ```

3. Compila el proyecto:

   ```
   mvn clean install
   ```

4. Ejecuta el microservicio:

   ```
   java -jar target/microservicio-precios.jar
   ```

El microservicio estará disponible en `http://localhost:8080`.

## Tests

Dentro de la carpeta [resources](src/main/resources) podemos encontrar un
archivo JSON que consiste en una colección de POSTMAN con los siguientes TEST a modo de ejemplos:

- Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
- Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
- Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
- Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
- Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
- Test 6: petición a las 10:00 del día 14 del producto 35456 para la brand 1 (ZARA)

[Colección de Postman](src/main/resources/Management Inditex.postman_collection.json)