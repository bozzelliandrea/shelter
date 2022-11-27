package org.shelter.core;

import com.sun.net.httpserver.Headers;
import org.shelter.core.http.HttpHeader;
import org.shelter.core.http.HttpStatus;

import java.io.OutputStream;

public class Response {

    private final OutputStream body;
    private final Headers headers;
    private int code = HttpStatus.OK.value();

    public Response(OutputStream body, Headers headers) {
        this.body = body;
        this.headers = headers;
    }

    public Response setHeader(HttpHeader header, String value) {
        return setHeader(header.name(), value);
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
}
