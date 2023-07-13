package denshchikov.dmitry.stackoverflowclient.controller;

import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                               HttpStatusCode status, WebRequest request) {
        var problemDetail = ProblemDetail.forStatus(status);

        var errors = new StringBuilder();

        for (var objectErr : ex.getBindingResult().getAllErrors()) {
            var name = objectErr instanceof FieldError fieldErr
                    ? fieldErr.getField()
                    : objectErr.getObjectName();
            errors.append(name)
                    .append(": ");

            var reason = objectErr.getDefaultMessage() == null
                    ? "No message"
                    : objectErr.getDefaultMessage();
            errors.append(reason)
                    .append(", ");
        }

        errors.delete(errors.length() - 2, errors.length());
        problemDetail.setDetail(errors.toString());


        var title = status instanceof HttpStatus httpStatus
                ? httpStatus.getReasonPhrase()
                : HttpStatus.valueOf(status.value()).getReasonPhrase();
        problemDetail.setTitle(title);


        var pathStr = ((ServletWebRequest) request).getRequest().getRequestURI();
        var path = URI.create(pathStr);
        problemDetail.setInstance(path);

        return new ResponseEntity<>(problemDetail, headers, status);
    }

}