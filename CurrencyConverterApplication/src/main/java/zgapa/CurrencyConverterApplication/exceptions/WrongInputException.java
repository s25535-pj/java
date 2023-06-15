package zgapa.CurrencyConverterApplication.exceptions;

public class WrongInputException extends RuntimeException{
    public WrongInputException(String errorMessage) {
        super(errorMessage);
    }
}
