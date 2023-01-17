package org.shelter.core.middleware;

import org.shelter.core.Request;
import org.shelter.core.Response;
import org.shelter.core.http.HttpMethod;

public class Servlet implements Middleware {

    private final HttpMethod method;
    private final Middleware middleware;

    public Servlet(HttpMethod method, Middleware middleware) {
        this.method = method;
        this.middleware = middleware;
    }

    @Override
    public void handler(Request request, Response response) {

    }
}
