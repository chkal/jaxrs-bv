package de.chkal.jaxrs;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {

        String message = exception.getConstraintViolations().stream()
                .map(v -> v.getMessage())
                .findFirst().orElse("no violation");

        return Response.ok("MyExceptionHandler: " + message).build();

    }

}
