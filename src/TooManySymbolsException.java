public class TooManySymbolsException extends RuntimeException{
    public TooManySymbolsException() {
    }

    public TooManySymbolsException(String message) {
        super(message);
    }

    public TooManySymbolsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManySymbolsException(Throwable cause) {
        super(cause);
    }

    public TooManySymbolsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
