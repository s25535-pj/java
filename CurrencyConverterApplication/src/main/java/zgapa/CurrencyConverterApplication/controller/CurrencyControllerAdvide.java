package zgapa.CurrencyConverterApplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import zgapa.CurrencyConverterApplication.exceptions.NotFoundException;
import zgapa.CurrencyConverterApplication.exceptions.WrongInputException;

@RestControllerAdvice
public class CurrencyControllerAdvide {

    //Niepoprawna ilość dni
    @ExceptionHandler(WrongInputException.class)
    public ResponseEntity<String> handleWrongInputException(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Podano niepoprawne dane: " + ex.getMessage());
    }

    //Nie znaleziono 404
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFoundException(HttpClientErrorException.NotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nie znaleziono waluty");
    }

    //502
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> handleStatus500Exception(HttpServerErrorException.InternalServerError ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body("Zła brama" + ex.getLocalizedMessage());
    }

    //504
    @ExceptionHandler(HttpServerErrorException.ServiceUnavailable.class)
    public ResponseEntity<String> handleConnectException(HttpServerErrorException.ServiceUnavailable ex) {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
                .body("Timeout servera" + ex.getLocalizedMessage());
    }

    // Obsługa ogólna dla innych wyjątków
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Global error" + ex.getLocalizedMessage());
    }
}
