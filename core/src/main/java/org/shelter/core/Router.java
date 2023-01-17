package org.shelter.core;

import com.sun.net.httpserver.HttpServer;
import org.shelter.core.http.HttpMethod;
import org.shelter.core.lib.Callback;
import org.shelter.core.middleware.Middleware;
import org.shelter.core.middleware.Servlet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class Router {

    private final List<Middleware> registeredMiddlewares = new ArrayList<>();

    private HttpServer httpServer;

    public Router get(Middleware middleware) {
        registeredMiddlewares.add(new Servlet(HttpMethod.GET, middleware));
        return this;
    }

    public Router get(String path, Middleware middleware) {
        registeredMiddlewares.add(new Servlet(HttpMethod.GET, middleware));
        return this;
    }

    public Router post(Middleware middleware) {
        registeredMiddlewares.add(new Servlet(HttpMethod.POST, middleware));
        return this;
    }

    public Router post(String path, Middleware middleware) {
        registeredMiddlewares.add(new Servlet(HttpMethod.POST, middleware));
        return this;
    }

    public Router put(Middleware middleware) {
        registeredMiddlewares.add(new Servlet(HttpMethod.PUT, middleware));
        return this;
    }

    public Router put(String path, Middleware middleware) {
        registeredMiddlewares.add(new Servlet(HttpMethod.PUT, middleware));
        return this;
    }

    public Router delete(Middleware middleware) {
        registeredMiddlewares.add(new Servlet(HttpMethod.DELETE, middleware));
        return this;
    }

    public Router delete(String path, Middleware middleware) {
        registeredMiddlewares.add(new Servlet(HttpMethod.DELETE, middleware));
        return this;
    }

    public void listen() {
        listen(8080, null);
    }

    public void listen(Callback callback) {
        listen(8080, callback);
    }

    public void listen(int port, Callback callback) {

        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);

            httpServer.setExecutor(null);
            httpServer.start();

            if (callback != null)
                callback.fire();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (httpServer != null) {

            httpServer.stop(0);
        }
    }

}
