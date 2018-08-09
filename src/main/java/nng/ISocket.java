package nng;

import java.nio.Buffer;
import java.time.Duration;
import java.util.EnumSet;

import nng.exception.NngException;

/**
 This interface wraps the nng Socket Functions
 https://github.com/nanomsg/nng/blob/master/docs/man/libnng.3.adoc
 
 The following functions operate on sockets.
 In general exceptions are thrown rather than error codes returned.
*/

interface ISocket {

	/** 
	* close socket 
	* https://github.com/nanomsg/nng/blob/master/docs/man/nng_close.3.adoc
	*/
	void close() throws NngException;
	
	public enum DialFlag {
	    NONE, NONBLOCK;
	    public static final EnumSet<DialFlag> ALL_OPTS = EnumSet.allOf(DialFlag.class);
	}
	/** 
	create and start dialer 
	https://github.com/nanomsg/nng/blob/master/docs/man/nng_dial.3.adoc
	*/
	IDialer dial(final String url, final DialFlag flags) throws NngException;
	

	public enum ListenFlag {
	    NONE, NONBLOCK;
	    public static final EnumSet<ListenFlag> ALL_OPTS = EnumSet.allOf(ListenFlag.class);
	}
	/** 
	 * create and start listener 
	 * https://github.com/nanomsg/nng/blob/master/docs/man/nng_listen.3.adoc
	 */
	IListener listen(final String url, final ListenFlag flags) throws NngException;
	
	

	public enum RecvFlag {
	    NONE, NONBLOCK, ALLOC;
	    public static final EnumSet<RecvFlag> ALL_OPTS = EnumSet.allOf(RecvFlag.class);
	}
	/** 
	 * receive data 
	 * https://github.com/nanomsg/nng/blob/master/docs/man/nng_recv.3.adoc
	 */
	Buffer recv(final RecvFlag flags) throws NngException;
	
	public enum SendFlag {
	    NONE, NONBLOCK, ALLOC;
	    public static final EnumSet<SendFlag> ALL_OPTS = EnumSet.allOf(SendFlag.class);
	}
	/** 
	 * send data
	 * https://github.com/nanomsg/nng/blob/master/docs/man/nng_send.3.adoc
	 */
	void send(final Buffer buf, final SendFlag flags) throws NngException;

	/** 
	 * get numeric socket identifier 
	 */
	Integer socket_id() throws NngException;

	/** 
	 * get socket option 
	 * https://github.com/nanomsg/nng/blob/master/docs/man/nng_getopt.3.adoc
	 */
	Object getopt(final String opt) throws NngException;
	Boolean getopt(final String opt, final Boolean val) throws NngException;
	Integer getopt(final String opt, final Integer val) throws NngException;
	Duration getopt(final String opt, final Duration val) throws NngException;
	short[] getopt(final String opt, final short[] val) throws NngException;
	Size getopt(final String opt, final Size val) throws NngException;
	String getopt(final String opt, final String val) throws NngException;
	
	/** 
	 * set socket option 
	 * https://github.com/nanomsg/nng/blob/master/docs/man/nng_setopt.3.adoc
	 */
	void setopt(final String opt) throws NngException;
	void setopt(final String opt, final Boolean val) throws NngException;
	void setopt(final String opt, final Integer val) throws NngException;
	void setopt(final String opt, final Duration val) throws NngException;
	void setopt(final String opt, final short[] val) throws NngException;
	void setopt(final String opt, final Size val) throws NngException;
	void setopt(final String opt, final String val) throws NngException;
	
	
}