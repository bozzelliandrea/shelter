package org.shelter.core;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.util.HashMap;

public class Request {

    private final HttpExchange exchange;
    private final String method;
    private final InputStream body;
    private final Headers headers;

    private HashMap<String, String> params;

    public Request(HttpExchange exchange) {
        this.exchange = exchange;
        this.method = exchange.getRequestMethod();
        this.body = exchange.getRequestBody();
        this.headers = exchange.getRequestHeaders();
    }

    public InputStream body() {
        return body;
    }

    public Headers headers() {
        return headers;
    }

    public String method() {
        return method;
    }

    public HashMap<String, String> params() {
        return params;
    }
}
