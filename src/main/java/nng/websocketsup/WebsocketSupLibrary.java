package nng.websocketsup;
import nng.core.nng_sockaddr;
import nng.core.nng_url;
import nng.httpapi.HttpApiLibrary.nng_http_req;
import nng.httpapi.HttpApiLibrary.nng_http_res;
import nng.tlsapi.TlsApiLibrary.nng_aio;
import nng.tlsapi.TlsApiLibrary.nng_tls_config;
import org.bridj.BridJ;
import org.bridj.CRuntime;
import org.bridj.Callback;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Name;
import org.bridj.ann.Ptr;
import org.bridj.ann.Runtime;
/**
 * Wrapper for library <b>websocketSup</b><br>
 * This file was autogenerated by <a href="https://github.com/nativelibs4java/JNAerator">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="https://github.com/nativelibs4java">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("websocketSup") 
@Runtime(CRuntime.class) 
public class WebsocketSupLibrary {
	static {
		BridJ.register();
	}
	/** <i>native declaration : supplemental/websocket/websocket.h:3</i> */
	public static abstract class nni_ws_listen_hook extends Callback<nni_ws_listen_hook > {
		public int apply(Pointer<? > voidPtr1, Pointer<nng_http_req > nng_http_reqPtr1, Pointer<nng_http_res > nng_http_resPtr1) {
			return apply(Pointer.getPeer(voidPtr1), Pointer.getPeer(nng_http_reqPtr1), Pointer.getPeer(nng_http_resPtr1));
		}
		public int apply(@Ptr long voidPtr1, @Ptr long nng_http_reqPtr1, @Ptr long nng_http_resPtr1) {
			return apply(Pointer.pointerToAddress(voidPtr1), (Pointer)Pointer.pointerToAddress(nng_http_reqPtr1, nng_http_req.class), (Pointer)Pointer.pointerToAddress(nng_http_resPtr1, nng_http_res.class));
		}
	};
	/**
	 * makes no sense.  (TBD: return NNG_EADDRINVAL, or try loopback?)<br>
	 * Original signature : <code>int nni_ws_listener_init(nni_ws_listener**, nni_url*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:8</i>
	 */
	@Name("nni_ws_listener_init") 
	public static int nniWsListenerInit(Pointer<Pointer<WebsocketSupLibrary.nni_ws_listener > > nni_ws_listenerPtrPtr1, Pointer<nng_url > nni_urlPtr1) {
		return nniWsListenerInit(Pointer.getPeer(nni_ws_listenerPtrPtr1), Pointer.getPeer(nni_urlPtr1));
	}
	@Name("nni_ws_listener_init") 
	protected native static int nniWsListenerInit(@Ptr long nni_ws_listenerPtrPtr1, @Ptr long nni_urlPtr1);
	/**
	 * Original signature : <code>void nni_ws_listener_fini(nni_ws_listener*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:10</i>
	 */
	@Name("nni_ws_listener_fini") 
	public static void nniWsListenerFini(Pointer<WebsocketSupLibrary.nni_ws_listener > nni_ws_listenerPtr1) {
		nniWsListenerFini(Pointer.getPeer(nni_ws_listenerPtr1));
	}
	@Name("nni_ws_listener_fini") 
	protected native static void nniWsListenerFini(@Ptr long nni_ws_listenerPtr1);
	/**
	 * Original signature : <code>void nni_ws_listener_close(nni_ws_listener*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:12</i>
	 */
	@Name("nni_ws_listener_close") 
	public static void nniWsListenerClose(Pointer<WebsocketSupLibrary.nni_ws_listener > nni_ws_listenerPtr1) {
		nniWsListenerClose(Pointer.getPeer(nni_ws_listenerPtr1));
	}
	@Name("nni_ws_listener_close") 
	protected native static void nniWsListenerClose(@Ptr long nni_ws_listenerPtr1);
	/**
	 * Original signature : <code>int nni_ws_listener_proto(nni_ws_listener*, const char*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:14</i>
	 */
	@Name("nni_ws_listener_proto") 
	public static int nniWsListenerProto(Pointer<WebsocketSupLibrary.nni_ws_listener > nni_ws_listenerPtr1, Pointer<Byte > charPtr1) {
		return nniWsListenerProto(Pointer.getPeer(nni_ws_listenerPtr1), Pointer.getPeer(charPtr1));
	}
	@Name("nni_ws_listener_proto") 
	protected native static int nniWsListenerProto(@Ptr long nni_ws_listenerPtr1, @Ptr long charPtr1);
	/**
	 * Original signature : <code>int nni_ws_listener_listen(nni_ws_listener*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:16</i>
	 */
	@Name("nni_ws_listener_listen") 
	public static int nniWsListenerListen(Pointer<WebsocketSupLibrary.nni_ws_listener > nni_ws_listenerPtr1) {
		return nniWsListenerListen(Pointer.getPeer(nni_ws_listenerPtr1));
	}
	@Name("nni_ws_listener_listen") 
	protected native static int nniWsListenerListen(@Ptr long nni_ws_listenerPtr1);
	/**
	 * Original signature : <code>void nni_ws_listener_accept(nni_ws_listener*, nng_aio*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:18</i>
	 */
	@Name("nni_ws_listener_accept") 
	public static void nniWsListenerAccept(Pointer<WebsocketSupLibrary.nni_ws_listener > nni_ws_listenerPtr1, Pointer<nng_aio > nng_aioPtr1) {
		nniWsListenerAccept(Pointer.getPeer(nni_ws_listenerPtr1), Pointer.getPeer(nng_aioPtr1));
	}
	@Name("nni_ws_listener_accept") 
	protected native static void nniWsListenerAccept(@Ptr long nni_ws_listenerPtr1, @Ptr long nng_aioPtr1);
	/**
	 * Original signature : <code>void nni_ws_listener_hook(nni_ws_listener*, nni_ws_listen_hook, void*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:20</i>
	 */
	@Name("nni_ws_listener_hook") 
	public static void nniWsListenerHook(Pointer<WebsocketSupLibrary.nni_ws_listener > nni_ws_listenerPtr1, Pointer<WebsocketSupLibrary.nni_ws_listen_hook > nni_ws_listen_hook1, Pointer<? > voidPtr1) {
		nniWsListenerHook(Pointer.getPeer(nni_ws_listenerPtr1), Pointer.getPeer(nni_ws_listen_hook1), Pointer.getPeer(voidPtr1));
	}
	@Name("nni_ws_listener_hook") 
	protected native static void nniWsListenerHook(@Ptr long nni_ws_listenerPtr1, @Ptr long nni_ws_listen_hook1, @Ptr long voidPtr1);
	/**
	 * Original signature : <code>int nni_ws_listener_set_tls(nni_ws_listener*, nng_tls_config*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:22</i>
	 */
	@Name("nni_ws_listener_set_tls") 
	public static int nniWsListenerSetTls(Pointer<WebsocketSupLibrary.nni_ws_listener > nni_ws_listenerPtr1, Pointer<nng_tls_config > nng_tls_configPtr1) {
		return nniWsListenerSetTls(Pointer.getPeer(nni_ws_listenerPtr1), Pointer.getPeer(nng_tls_configPtr1));
	}
	@Name("nni_ws_listener_set_tls") 
	protected native static int nniWsListenerSetTls(@Ptr long nni_ws_listenerPtr1, @Ptr long nng_tls_configPtr1);
	/**
	 * Original signature : <code>int nni_ws_listener_get_tls(nni_ws_listener*, nng_tls_config**)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:24</i>
	 */
	@Name("nni_ws_listener_get_tls") 
	public static int nniWsListenerGetTls(Pointer<WebsocketSupLibrary.nni_ws_listener > nni_ws_listenerPtr1, Pointer<Pointer<nng_tls_config > > s) {
		return nniWsListenerGetTls(Pointer.getPeer(nni_ws_listenerPtr1), Pointer.getPeer(s));
	}
	@Name("nni_ws_listener_get_tls") 
	protected native static int nniWsListenerGetTls(@Ptr long nni_ws_listenerPtr1, @Ptr long s);
	/**
	 * Original signature : <code>void nni_ws_listener_set_maxframe(nni_ws_listener*, size_t)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:26</i>
	 */
	@Name("nni_ws_listener_set_maxframe") 
	public static void nniWsListenerSetMaxframe(Pointer<WebsocketSupLibrary.nni_ws_listener > nni_ws_listenerPtr1, long size_t1) {
		nniWsListenerSetMaxframe(Pointer.getPeer(nni_ws_listenerPtr1), size_t1);
	}
	@Name("nni_ws_listener_set_maxframe") 
	protected native static void nniWsListenerSetMaxframe(@Ptr long nni_ws_listenerPtr1, long size_t1);
	/**
	 * Original signature : <code>int nni_ws_dialer_init(nni_ws_dialer**, nni_url*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:28</i>
	 */
	@Name("nni_ws_dialer_init") 
	public static int nniWsDialerInit(Pointer<Pointer<WebsocketSupLibrary.nni_ws_dialer > > nni_ws_dialerPtrPtr1, Pointer<nng_url > nni_urlPtr1) {
		return nniWsDialerInit(Pointer.getPeer(nni_ws_dialerPtrPtr1), Pointer.getPeer(nni_urlPtr1));
	}
	@Name("nni_ws_dialer_init") 
	protected native static int nniWsDialerInit(@Ptr long nni_ws_dialerPtrPtr1, @Ptr long nni_urlPtr1);
	/**
	 * Original signature : <code>void nni_ws_dialer_fini(nni_ws_dialer*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:30</i>
	 */
	@Name("nni_ws_dialer_fini") 
	public static void nniWsDialerFini(Pointer<WebsocketSupLibrary.nni_ws_dialer > nni_ws_dialerPtr1) {
		nniWsDialerFini(Pointer.getPeer(nni_ws_dialerPtr1));
	}
	@Name("nni_ws_dialer_fini") 
	protected native static void nniWsDialerFini(@Ptr long nni_ws_dialerPtr1);
	/**
	 * Original signature : <code>void nni_ws_dialer_close(nni_ws_dialer*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:32</i>
	 */
	@Name("nni_ws_dialer_close") 
	public static void nniWsDialerClose(Pointer<WebsocketSupLibrary.nni_ws_dialer > nni_ws_dialerPtr1) {
		nniWsDialerClose(Pointer.getPeer(nni_ws_dialerPtr1));
	}
	@Name("nni_ws_dialer_close") 
	protected native static void nniWsDialerClose(@Ptr long nni_ws_dialerPtr1);
	/**
	 * Original signature : <code>int nni_ws_dialer_proto(nni_ws_dialer*, const char*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:34</i>
	 */
	@Name("nni_ws_dialer_proto") 
	public static int nniWsDialerProto(Pointer<WebsocketSupLibrary.nni_ws_dialer > nni_ws_dialerPtr1, Pointer<Byte > charPtr1) {
		return nniWsDialerProto(Pointer.getPeer(nni_ws_dialerPtr1), Pointer.getPeer(charPtr1));
	}
	@Name("nni_ws_dialer_proto") 
	protected native static int nniWsDialerProto(@Ptr long nni_ws_dialerPtr1, @Ptr long charPtr1);
	/**
	 * Original signature : <code>int nni_ws_dialer_header(nni_ws_dialer*, const char*, const char*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:36</i>
	 */
	@Name("nni_ws_dialer_header") 
	public static int nniWsDialerHeader(Pointer<WebsocketSupLibrary.nni_ws_dialer > nni_ws_dialerPtr1, Pointer<Byte > charPtr1, Pointer<Byte > charPtr2) {
		return nniWsDialerHeader(Pointer.getPeer(nni_ws_dialerPtr1), Pointer.getPeer(charPtr1), Pointer.getPeer(charPtr2));
	}
	@Name("nni_ws_dialer_header") 
	protected native static int nniWsDialerHeader(@Ptr long nni_ws_dialerPtr1, @Ptr long charPtr1, @Ptr long charPtr2);
	/**
	 * Original signature : <code>void nni_ws_dialer_set_maxframe(nni_ws_dialer*, size_t)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:38</i>
	 */
	@Name("nni_ws_dialer_set_maxframe") 
	public static void nniWsDialerSetMaxframe(Pointer<WebsocketSupLibrary.nni_ws_dialer > nni_ws_dialerPtr1, long size_t1) {
		nniWsDialerSetMaxframe(Pointer.getPeer(nni_ws_dialerPtr1), size_t1);
	}
	@Name("nni_ws_dialer_set_maxframe") 
	protected native static void nniWsDialerSetMaxframe(@Ptr long nni_ws_dialerPtr1, long size_t1);
	/**
	 * Original signature : <code>void nni_ws_dialer_dial(nni_ws_dialer*, nng_aio*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:40</i>
	 */
	@Name("nni_ws_dialer_dial") 
	public static void nniWsDialerDial(Pointer<WebsocketSupLibrary.nni_ws_dialer > nni_ws_dialerPtr1, Pointer<nng_aio > nng_aioPtr1) {
		nniWsDialerDial(Pointer.getPeer(nni_ws_dialerPtr1), Pointer.getPeer(nng_aioPtr1));
	}
	@Name("nni_ws_dialer_dial") 
	protected native static void nniWsDialerDial(@Ptr long nni_ws_dialerPtr1, @Ptr long nng_aioPtr1);
	/**
	 * Original signature : <code>int nni_ws_dialer_set_tls(nni_ws_dialer*, nng_tls_config*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:42</i>
	 */
	@Name("nni_ws_dialer_set_tls") 
	public static int nniWsDialerSetTls(Pointer<WebsocketSupLibrary.nni_ws_dialer > nni_ws_dialerPtr1, Pointer<nng_tls_config > nng_tls_configPtr1) {
		return nniWsDialerSetTls(Pointer.getPeer(nni_ws_dialerPtr1), Pointer.getPeer(nng_tls_configPtr1));
	}
	@Name("nni_ws_dialer_set_tls") 
	protected native static int nniWsDialerSetTls(@Ptr long nni_ws_dialerPtr1, @Ptr long nng_tls_configPtr1);
	/**
	 * Original signature : <code>int nni_ws_dialer_get_tls(nni_ws_dialer*, nng_tls_config**)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:44</i>
	 */
	@Name("nni_ws_dialer_get_tls") 
	public static int nniWsDialerGetTls(Pointer<WebsocketSupLibrary.nni_ws_dialer > nni_ws_dialerPtr1, Pointer<Pointer<nng_tls_config > > nng_tls_configPtrPtr1) {
		return nniWsDialerGetTls(Pointer.getPeer(nni_ws_dialerPtr1), Pointer.getPeer(nng_tls_configPtrPtr1));
	}
	@Name("nni_ws_dialer_get_tls") 
	protected native static int nniWsDialerGetTls(@Ptr long nni_ws_dialerPtr1, @Ptr long nng_tls_configPtrPtr1);
	/**
	 * a websocket close).<br>
	 * Original signature : <code>void nni_ws_send_msg(nni_ws*, nng_aio*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:49</i>
	 */
	@Name("nni_ws_send_msg") 
	public static void nniWsSendMsg(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1, Pointer<nng_aio > nng_aioPtr1) {
		nniWsSendMsg(Pointer.getPeer(nni_wsPtr1), Pointer.getPeer(nng_aioPtr1));
	}
	@Name("nni_ws_send_msg") 
	protected native static void nniWsSendMsg(@Ptr long nni_wsPtr1, @Ptr long nng_aioPtr1);
	/**
	 * Original signature : <code>void nni_ws_recv_msg(nni_ws*, nng_aio*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:51</i>
	 */
	@Name("nni_ws_recv_msg") 
	public static void nniWsRecvMsg(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1, Pointer<nng_aio > nng_aioPtr1) {
		nniWsRecvMsg(Pointer.getPeer(nni_wsPtr1), Pointer.getPeer(nng_aioPtr1));
	}
	@Name("nni_ws_recv_msg") 
	protected native static void nniWsRecvMsg(@Ptr long nni_wsPtr1, @Ptr long nng_aioPtr1);
	/**
	 * Original signature : <code>nng_http_res* nni_ws_response(nni_ws*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:53</i>
	 */
	@Name("nni_ws_response") 
	public static Pointer<nng_http_res > nniWsResponse(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1) {
		return (Pointer)Pointer.pointerToAddress(nniWsResponse(Pointer.getPeer(nni_wsPtr1)), nng_http_res.class);
	}
	@Name("nni_ws_response") 
	@Ptr 
	protected native static long nniWsResponse(@Ptr long nni_wsPtr1);
	/**
	 * Original signature : <code>nng_http_req* nni_ws_request(nni_ws*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:55</i>
	 */
	@Name("nni_ws_request") 
	public static Pointer<nng_http_req > nniWsRequest(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1) {
		return (Pointer)Pointer.pointerToAddress(nniWsRequest(Pointer.getPeer(nni_wsPtr1)), nng_http_req.class);
	}
	@Name("nni_ws_request") 
	@Ptr 
	protected native static long nniWsRequest(@Ptr long nni_wsPtr1);
	/**
	 * Original signature : <code>int nni_ws_sock_addr(nni_ws*, nni_sockaddr*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:57</i>
	 */
	@Name("nni_ws_sock_addr") 
	public static int nniWsSockAddr(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1, Pointer<nng_sockaddr > nni_sockaddrPtr1) {
		return nniWsSockAddr(Pointer.getPeer(nni_wsPtr1), Pointer.getPeer(nni_sockaddrPtr1));
	}
	@Name("nni_ws_sock_addr") 
	protected native static int nniWsSockAddr(@Ptr long nni_wsPtr1, @Ptr long nni_sockaddrPtr1);
	/**
	 * Original signature : <code>int nni_ws_peer_addr(nni_ws*, nni_sockaddr*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:59</i>
	 */
	@Name("nni_ws_peer_addr") 
	public static int nniWsPeerAddr(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1, Pointer<nng_sockaddr > nni_sockaddrPtr1) {
		return nniWsPeerAddr(Pointer.getPeer(nni_wsPtr1), Pointer.getPeer(nni_sockaddrPtr1));
	}
	@Name("nni_ws_peer_addr") 
	protected native static int nniWsPeerAddr(@Ptr long nni_wsPtr1, @Ptr long nni_sockaddrPtr1);
	/**
	 * Original signature : <code>void nni_ws_close(nni_ws*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:61</i>
	 */
	@Name("nni_ws_close") 
	public static void nniWsClose(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1) {
		nniWsClose(Pointer.getPeer(nni_wsPtr1));
	}
	@Name("nni_ws_close") 
	protected native static void nniWsClose(@Ptr long nni_wsPtr1);
	/**
	 * Original signature : <code>void nni_ws_close_error(nni_ws*, uint16_t)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:63</i>
	 */
	@Name("nni_ws_close_error") 
	public static void nniWsCloseError(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1, short uint16_t1) {
		nniWsCloseError(Pointer.getPeer(nni_wsPtr1), uint16_t1);
	}
	@Name("nni_ws_close_error") 
	protected native static void nniWsCloseError(@Ptr long nni_wsPtr1, short uint16_t1);
	/**
	 * Original signature : <code>void nni_ws_fini(nni_ws*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:65</i>
	 */
	@Name("nni_ws_fini") 
	public static void nniWsFini(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1) {
		nniWsFini(Pointer.getPeer(nni_wsPtr1));
	}
	@Name("nni_ws_fini") 
	protected native static void nniWsFini(@Ptr long nni_wsPtr1);
	/**
	 * Original signature : <code>char* nni_ws_response_headers(nni_ws*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:67</i>
	 */
	@Name("nni_ws_response_headers") 
	public static Pointer<Byte > nniWsResponseHeaders(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1) {
		return (Pointer)Pointer.pointerToAddress(nniWsResponseHeaders(Pointer.getPeer(nni_wsPtr1)), Byte.class);
	}
	@Name("nni_ws_response_headers") 
	@Ptr 
	protected native static long nniWsResponseHeaders(@Ptr long nni_wsPtr1);
	/**
	 * Original signature : <code>char* nni_ws_request_headers(nni_ws*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:69</i>
	 */
	@Name("nni_ws_request_headers") 
	public static Pointer<Byte > nniWsRequestHeaders(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1) {
		return (Pointer)Pointer.pointerToAddress(nniWsRequestHeaders(Pointer.getPeer(nni_wsPtr1)), Byte.class);
	}
	@Name("nni_ws_request_headers") 
	@Ptr 
	protected native static long nniWsRequestHeaders(@Ptr long nni_wsPtr1);
	/**
	 * Original signature : <code>bool nni_ws_tls_verified(nni_ws*)</code><br>
	 * <i>native declaration : supplemental/websocket/websocket.h:71</i>
	 */
	@Name("nni_ws_tls_verified") 
	public static boolean nniWsTlsVerified(Pointer<WebsocketSupLibrary.nni_ws > nni_wsPtr1) {
		return nniWsTlsVerified(Pointer.getPeer(nni_wsPtr1));
	}
	@Name("nni_ws_tls_verified") 
	protected native static boolean nniWsTlsVerified(@Ptr long nni_wsPtr1);
	/** Undefined type */
	public static interface nni_ws {
		
	};
	/** Undefined type */
	public static interface nni_ws_dialer {
		
	};
	/** Undefined type */
	public static interface nni_ws_listener {
		
	};
}
