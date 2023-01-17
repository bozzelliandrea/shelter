package org.shelter.core.middleware;

import org.shelter.core.Request;
import org.shelter.core.Response;

@FunctionalInterface
public interface Middleware {

    void handler(Request request, Response response);
}
