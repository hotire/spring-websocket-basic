# Spring WebSocket

https://docs.spring.io/spring-framework/docs/5.3.9/reference/html/web.html#websocket 

### Getting Started

https://www.baeldung.com/websockets-spring

### Introduction to WebSocket

~~~yml
GET /spring-websocket-portfolio/portfolio HTTP/1.1
Host: localhost:8080
Upgrade: websocket 
Connection: Upgrade 
Sec-WebSocket-Key: Uc9l9TMkWGbHFD2qnFHltg==
Sec-WebSocket-Protocol: v10.stomp, v11.stomp
Sec-WebSocket-Version: 13
Origin: http://localhost:8080
~~~
1. The Upgrade header.
2. Using the Upgrade connection.

Instead of the usual 200 status code, a server with WebSocket support returns output similar to the following:

~~~yml
HTTP/1.1 101 Switching Protocols 
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Accept: 1qVdfYHU9hPOl4JYYNXF623Gzn0=
Sec-WebSocket-Protocol: v10.stomp
~~~
3. Protocol switch

