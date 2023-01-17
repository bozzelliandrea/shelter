package org.shelter.core;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;

public class Request {

    private final HttpExchange exchange;
    private final String method;
    private final InputStream body;
    private final Headers headers;

    public Request(HttpExchange exchange) {
        this.exchange = exchange;
        this.method = exchange.getRequestMethod();
        this.body = exchange.getRequestBody();
        this.headers = exchange.getRequestHeaders();
    }
}
