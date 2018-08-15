package nng.exception;

public class NngException extends Exception {
	final String msg;
	final int errno;

	public NngException(final String msg, final int errno) {
		super();
		this.msg = msg;
		this.errno = errno;
	}
}