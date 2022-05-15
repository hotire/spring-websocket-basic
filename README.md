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


## STOMP

- https://stomp.github.io/
- https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#websocket-stomp
- https://stomp.github.io/stomp-specification-1.2.html

~~~
COMMAND
header1:value1
header2:value2

Body^@
~~~

COMMAND + Header + Body 로 HTTP Message와 비슷하게 사용할 수 있다. 

COMMAND는 Client냐 Server냐에 따라서 다르게 사용한다.

### Handshake

~~~
CONNECT
accept-version:1.0,1.1,1.2
heart-beat:10000,10000

^@
 
CONNECTED
version:1.2
heart-beat:0,0
 
^@
~~~

Client과 CONNECT를 보내고, Server에서 문제 없으면 CONNECTED를 보내서, Handshake를 완료한다.

- https://velog.io/@gillog/Protocol-STOMP