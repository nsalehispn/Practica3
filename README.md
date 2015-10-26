# Las clases Java DatagramPacket y DatagramSocket

El objetivo de esta práctica es mostrar el modo de funcionamiento de las
clases Java para definir datagramas y sockets de datagrama.

## La clase DatagramPacket

  La clase DatagramPacket proporciona un constructor que permite crear instancias de
  un array de bytes para: 
    * el mensaje, 
    * la longitud del mensaje, 
    * la dirección Internet y 
    * el puerto local del socket de destino

  Los objetos del tipo DatagramPacket se pueden transmitir entre procesos cuando un
  proceso los envía y otro los recibe.

  Esta clase proporciona otro constructor para usarlo cuando se recibe un mensaje. 
  Sus argumentos especifican un array de bytes en el que recibir el mensaje y 
  la longitud del array. 
  Cuando se recibe un mensaje se pone en el DatagramPacket junto con su longitud,
  la dirección de Internet y el puerto del socket de envío.
  Se puede obtener el mensaje del objeto DatagramPacket mediante el método getData().
  Los métodos getPort() y getAddress() permiten obtener el puerto y la dirección
  Internet del objeto de tipo DatagramPacket.
  El proceso receptor del mensaje tiene que especificar un array de bytes de un tamaño
  determinado en el cual recibir el mensaje, esto es, ha de predecir el Tamaño del Mensaje. 
  Si el mensaje es muy grande que el array, se trunca cuando llega. 

## La clase DatagramSocket

  La clase DatagramSocket da soporte a sockets para el envío y recepción de datagramas UDP.
  Se proporciona un constructor que toma un puerto como argumento, para que sea
  usado por los procesos que necesitan usar un puerto particular. 
  También se proporciona un constructor sin argumentos que permite al sistema escoger un 
  puerto local libre. 
  Estos constructores pueden lanzar una excepción del tipo SocketException si el puerto ya
  está en uso o si está reservado.
  Esta clase cuenta con los siguientes métodos:

  * send() y receive().
    Estos métodos permiten transmitir datagramas entre un par de sockets. 
    El argumento del send es una instancia de un DatagramPacket que contiene un mensaje
    y su destino. 
    El argumento del receive es un objeto DatagramPacket vacío en el cual se pondrá el mensaje, 
    su longitud y su origen. 
    Tanto el método send() como el receive() pueden lanzar una IOException.
 
  * setSoTimeout().
    Este método permite establecer un tiempo de espera. 
    Con un tiempo de espera establecido, el método receive() se bloqueará por el tiempo 
    especificado y entonces lanzará una InterruptedIOException().

  * connect().
    Este método se utiliza para conectar a un puerto remoto particular y una dirección
    de Internet, en este caso el socket sólo es capaz de enviar y recibir mensajes desde
    esa dirección.

## Ejercicios.

  El código almacenado en el directorio src/ utiliza sockets datagrama para intercambiar 
  una única cadena de datos. 
  El emisor crea un paquete datagrama que contiene una dirección de destino, mientras que 
  el paquete datagrama del receptor no incluye una dirección de destino.

  El socket el emisor se enlaza a un número de puerto no especificado, mientras que el
  socket del receptor se enlaza a un número de puerto específico, para que el emisor pueda
  escribir este número de puerto en su datagrama como destino.

   1. Compile y ejecute el código del ejemplo en una máquina usando “localhost” como
      nombre de máquina. Por ejemplo se puede introducir el comando:
   
          `java Example1Sender localhost 12345 Hola`
 
      Ejecute los dos programas arrancando primero al receptor y después al emisor. 
      El mensaje que se envíe no debería exceder la longitud máxima permitida que es 
      de 10 caracteres.
      Describa el resultado de la ejecución.
 
   2. Repita el ejercicio anterior utilizando dos máquinas distintas. 
 
   3. Vuelva a ejecutar las aplicaciones del apartado 1, esta vez ejecutando primero al
      emisor y luego al receptor.
      Describa y explique el resultado.
 
   4. Repita el apartado 1, esta vez mandando un mensaje de longitud mayor que la
      máxima longitud permitida.
      Describa y explique la salida producida.
 
   5. Añada código al proceso receptor de manera que el plazo máximo de bloqueo del
      `receive` sea de cinco segundos. 
      Lance el proceso receptor pero no el proceso emisor.
      ¿Cuál es el resultado? Descríbalo y explíquelo.
 
   6. Modifique el código original de manera que el receptor ejecute indefinidamente un
      bucle que reciba y muestre los datos recibidos. 
      Compílelo y ejecutelo de la siguiente forma:
        - lance al receptor
        - ejecute el emisor enviando un mensaje “mensaje 1”
        - en otra ventana, lanzar otra instancia del emisor, mandando un mensaje “mensaje 2”.
      Describa y explique el resultado.
 
   7. Modifique el código original de manera que el emisor utilice el mismo socket para
      enviar el mismo mensaje a dos receptores diferentes. 
      Primero lance los dos receptores y después al emisor. 
      ¿Cada receptor recibe el mensaje? Describa y explique el resultado.
 
   8. Modifique el código original de manera que el emisor utilice dos socket distintos
      para enviar el mismo mensaje a dos receptores diferentes. 
      Primero lance los dos receptores y después al emisor. 
      ¿Cada receptor recibe el mensaje? 
      Describa y explique el resultado.
 
   9. Modifique el código del último paso de modo que el emisor envíe de forma permanente,
      suspendiéndose durante 3 segundos entre cada envío.
      Modifique el receptor de manera que ejecute un bucle que repetidamente reciba datos
      y luego los muestre.
      Compile y ejecute los programas durante unos cuentos segundos antes de teminarlos
      con “Ctrl-C”.
      Describa y explique el resultado.
 
  10. Modifique el código original de modo que el emisor también reciba un mensaje del
      receptor. Utilizar sólo un socket en cada proceso. 
