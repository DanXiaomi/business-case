# Business Case

# 1. Microservice Design

## Written Proposal

Intenté usar la arquitectura hexagonal con el fin de poder tener aislados los servicios y el dominio (negocio) para en caso de requerir alguna modificación no tenga que afectar una capa a la otra. Al momento de definir los servicios se utilizó una interface y la implementación de la interface. Considero que al tener separada la implementación cada funcionalidad no requiere y no es dependiente de la otra ya que lo único que cambiaría sería la forma en que se procesa la información en cada servicio.

Al considerar escalar los servicios por una mayor demanda se pudieran ir aumentando las instancias de los servicios correspondientes y de igual forma tener algunas funcionalidades asíncronas como son por ejemplo el envío de correos de confirmación de pago, compra o cualquier operación que no requiera que se termine para seguir adelante.

Considerar que se puede usar un balanceador de carga con el fin de evitar saturación en una instancia del servicio e intentar evitar que los servicios se queden desconectados por mucho tiempo.

Se usó la base NoSQL Mongo para almacenar toda la información ya que considero que para una gran cantidad de datos es una buena opción.

De igual forma se utiliza Redis para la parte del caché de los catálogos y para guardar la información de la sesión de usuario de manera temporal, esto para evitar hacer demasiadas consultas de la misma información a la BD.

## Diagrams

Ver imagen anexa

## Design details

Las responsabilidades de cada servicio son:

- **ProductService**: Dar de alta nuevos productos, consulta de catálogos de productos (uno o varios), modificación de la información del producto, llevar el registro del inventario de los productos.
- **OrderService**: Generar una nueva orden de compra, consulta de orden existente, modificar la orden actual, cancelar la orden, conectarse con servicio externo para realizar el cobro.
- **UserService**: Registrar nuevos usuarios, administración de perfil, autenticación del usuario.

La forma en que se relacionan los servicios es usando peticiones REST, para algunas operaciones que no requieren la finalización de las mismas para terminar los flujos se piensa utilizar message queues o eventos. Ejemplo de estas operaciones son: envío de correo al confirmar la order de compra o el pago, al detectar un inicio de sesión desde un dispositivo diferente o aún no autorizado, etc.

# 2. Backend Development (Java)

> **Nota:** Revisar repositorio en GitHub

> **Nota:** Documentación swagger 

http://localhost:8080/swagger-ui/index.html#

# 3. Database Integration

Se usó la base NoSQL Mongo para almacenar toda la información ya que considero que para una gran cantidad de datos es una buena opción.

De igual forma se utiliza Redis para la parte del caché de los catálogos y para guardar la información de la sesión de usuario de manera temporal, esto para evitar hacer demasiadas consultas de la misma información a la BD.

# Post-development Questions:

 1. **How did you ensure your microservice scales with rising demand?**
 Usando una BD NoSQL que no requiera mucha modificación al momento de tener demasiados datos teniendo por separado la implementación de las operaciones que se hacen en el repository. También el considerar cada servicio de manera independiente para que se pueda escalar de forma individual cada uno si es necesario.

2. **Which strategies were adopted or contemplated for enduring maintainability?**
Usar una codificación clara con buenas prácticas de programación para que en el futuro cualquier desarrollador pueda darle mantenimiento. Documentar los endpoints para su mejor comprehensión. Tener algunos diagramas generales de lo que se implementó.

3. **Narrate a challenging technical decision made during this assignment and defend it**
Actualmente no tengo un conocimiento sólido de la arquitectura hexagonal por lo que tuve que hacer una investigación rápida antes de poder iniciar con el diseño del mismo.

4. **As a senior developer, how would you guarantee code quality and best practices within a more extensive team framework?**
Usar alguna herramienta para verificar que el código que se esté implementando cumple con las buenas prácticas de codificación y las líneas de código estén optimizadas, por ejemplo con SonarQube. Esto se puede incluir en un paso de CI/CD con alguna herramienta de automatización como Jenkins, también agregar la ejecución de los test unitarios para evitar afectar algo que ya existe y está probado.

5. **Describe your approach to guiding a junior developer in comprehending and building on this microservice**
Primero sería explicarle la visión general de lo que trata el microservicio, para qué se utiliza y cómo se relaciona con otras entidades externas, esto con ayuda de diagramas y la demostración de algunas funcionalidades para que tenga un contexto inicial del proyecto. Después sería explicarle cómo está organizado el proyecto, qué clases y archivos se manejan y cómo están definidos. Por último, hacerle saber que si hay dudas o se atora en cualquier parte puede solicitar ayuda conmigo o con el equipo para que no pase mucho tiempo intentando solucionar un problema que tal vez alguien ya lo resolvió.

6. **How would you explain the importance of a particular technical decision to a non-technical stakeholder or team member?**
Explicar el problema que se quiere resolver para que se entienda a qué se quiere llegar, con esto poder dar a conocer las ventajas y/o desventajas de la solución propuesta intentado utilizar en lo menos posible un lenguaje técnico.

7. **Here's a basic Dockerfile for a Java application: Can you provide some modifications or comments to enhance or describe the Dockerfile?**

> Indica la imagen base sobre la que se construirá la aplicación
> dentro del contenedor

FROM openjdk:11

> Copia el archivo my-app.jar de target a /usr/src

COPY ./target/my-app.jar /usr/src/

> Establece un directorio de trabajo para las instrucciones siguientes.
> 
> **Aquí se encuentra el error porque el archivo my-app.jar está en /usr/src no en /usr/app por lo que debería ser:** 
> 
> **WORKDIR /usr/src**

WORKDIR /usr/app

> Especifica el comando CMD a ejecutar cuando se inicia un contenedor, con sus respectivos parámetros

CMD ["java", "-jar", "my-app.jar"]

Tasks:
-   Identify and fix any issues you see in the Dockerfile.
-   Add comments to describe each step of the Dockerfile to make it more clear.

8. **In Kubernetes, it's vital not to hardcode sensitive data within applications or configurations. Describe how you would manage and retrieve sensitive information, such as database passwords or API keys, in a Kubernetes environment without hardcoding them into your application?**
Usando secrets que se pueden almacenar en alguna plataforma en la nube como AWS Parameter Store (SSM) y después haciendo uso de las mismas definiendo variables de entorno para poder utilizarlas al momento de levantar los contenedores.
