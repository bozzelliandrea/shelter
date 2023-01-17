package org.shelter.core;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.shelter.core.http.HttpHeader;
import org.shelter.core.http.HttpStatus;
import org.shelter.core.http.MediaType;

import java.io.IOException;
import java.io.OutputStream;

public class Response {

    private final HttpExchange exchange;
    private final OutputStream body;
    private final Headers headers;

    private int code = HttpStatus.OK.value();
    private int length = 0;
    private boolean closed = false;

    public Response(HttpExchange exchange) {
        this.exchange = exchange;
        this.body = exchange.getResponseBody();
        this.headers = exchange.getResponseHeaders();
    }

    public Response setHeader(String header, String value) {
        headers.add(header, value);
        return this;
    }

    public Response status(HttpStatus code) {
        return status(code.value());
    }

    public Response status(int code) {
        this.code = code;
        return this;
    }

    /**
     * Send and close the response stream.
     */
    public void send() {
        if (closed) return;

        sendHeaders();
        close();
    }

    public void send(byte[] content) {
        if (closed) return;

        try {
            length = content.length;
            body.write(content);
            send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        send();
    }

    public void sendStatus(HttpStatus code) {
        if (closed) return;

        this.code = code.value();
        send();
    }

    public void sendHeaders() {
        try {
            if (!this.headers.containsKey(HttpHeader.CONTENT_TYPE)) {
                this.headers.add(HttpHeader.CONTENT_TYPE, MediaType.TEXT_PLAIN);
            }

            this.exchange.sendResponseHeaders(code, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close the connection stream
     */
    private void close() {
        try {
            this.body.close();
            this.closed = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
