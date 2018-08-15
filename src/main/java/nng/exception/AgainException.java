package nng.exception;

public class AgainException extends Exception {
    final String msg;
    final int errno;

    public AgainException(final String msg, final int errno) {
        super();
        this.msg = msg;
        this.errno = errno;
    }
}
