package com.github.hotire.springwebsocketbasic

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import java.text.SimpleDateFormat
import java.util.Date

@Controller
class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    fun send(message: Message): OutputMessage {
        val time = SimpleDateFormat("HH:mm").format(Date())
        return OutputMessage(message.from, message.text, time)
    }
}
