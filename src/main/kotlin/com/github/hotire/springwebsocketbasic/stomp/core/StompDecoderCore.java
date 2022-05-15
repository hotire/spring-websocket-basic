package com.github.hotire.springwebsocketbasic.stomp.core;

import java.io.ByteArrayOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.stomp.StompConversionException;
import org.springframework.messaging.simp.stomp.StompDecoder;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;

/**
 * @see StompDecoder
 */
public class StompDecoderCore {

    /**
     * @see StompDecoder#decodeMessage(ByteBuffer, MultiValueMap)
     */
    private Message<byte[]> decodeMessage(ByteBuffer byteBuffer, @Nullable MultiValueMap<String, String> headers) {
        return null;
    }

    /**
     * @see StompDecoder#readCommand(ByteBuffer)
     */
    private String readCommand(ByteBuffer byteBuffer) {
        ByteArrayOutputStream command = new ByteArrayOutputStream(256);
        while (byteBuffer.remaining() > 0 && !tryConsumeEndOfLine(byteBuffer)) command.write(byteBuffer.get());
        return StreamUtils.copyToString(command, StandardCharsets.UTF_8);
    }

    private boolean tryConsumeEndOfLine(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            if (b == '\n') return true;
            else if (b == '\r') if (byteBuffer.remaining() > 0 && byteBuffer.get() == '\n') {
                return true;
            } else {
                throw new StompConversionException("'\\r' must be followed by '\\n'");
            }
            // Explicit cast for compatibility with covariant return type on JDK 9's ByteBuffer
            ((Buffer) byteBuffer).position(byteBuffer.position() - 1);
        }
        return false;
    }
}
