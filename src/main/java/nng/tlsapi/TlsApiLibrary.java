package nng.tlsapi;
import nng.core.nng_sockaddr;
import org.bridj.BridJ;
import org.bridj.CRuntime;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Name;
import org.bridj.ann.Ptr;
import org.bridj.ann.Runtime;
/**
 * Wrapper for library <b>tlsApi</b><br>
 * This file was autogenerated by <a href="https://github.com/nativelibs4java/JNAerator">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="https://github.com/nativelibs4java">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("tlsApi") 
@Runtime(CRuntime.class) 
public class TlsApiLibrary {
	static {
		BridJ.register();
	}
	/**
	 * The object is created with a reference count of one.<br>
	 * Original signature : <code>int nni_tls_config_init(nng_tls_config**)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:6</i>
	 */
	@Name("nni_tls_config_init") 
	public static int nniTlsConfigInit(Pointer<Pointer<TlsApiLibrary.nng_tls_config > > nng_tls_configPtrPtr1) {
		return nniTlsConfigInit(Pointer.getPeer(nng_tls_configPtrPtr1));
	}
	@Name("nni_tls_config_init") 
	protected native static int nniTlsConfigInit(@Ptr long nng_tls_configPtrPtr1);
	/**
	 * object, deallocating if this was the last reference.<br>
	 * Original signature : <code>void nni_tls_config_fini(nng_tls_config*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:11</i>
	 */
	@Name("nni_tls_config_fini") 
	public static void nniTlsConfigFini(Pointer<TlsApiLibrary.nng_tls_config > nng_tls_configPtr1) {
		nniTlsConfigFini(Pointer.getPeer(nng_tls_configPtr1));
	}
	@Name("nni_tls_config_fini") 
	protected native static void nniTlsConfigFini(@Ptr long nng_tls_configPtr1);
	/**
	 * the configuration object is created with a hold on it.<br>
	 * Original signature : <code>void nni_tls_config_hold(nng_tls_config*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:16</i>
	 */
	@Name("nni_tls_config_hold") 
	public static void nniTlsConfigHold(Pointer<TlsApiLibrary.nng_tls_config > nng_tls_configPtr1) {
		nniTlsConfigHold(Pointer.getPeer(nng_tls_configPtr1));
	}
	@Name("nni_tls_config_hold") 
	protected native static void nniTlsConfigHold(@Ptr long nng_tls_configPtr1);
	/**
	 * Original signature : <code>int nni_tls_init(nni_tls**, nng_tls_config*, nni_tcp_conn*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:18</i>
	 */
	@Name("nni_tls_init") 
	public static int nniTlsInit(Pointer<Pointer<TlsApiLibrary.nni_tls > > nni_tlsPtrPtr1, Pointer<TlsApiLibrary.nng_tls_config > nng_tls_configPtr1, Pointer<TlsApiLibrary.nni_tcp_conn > nni_tcp_connPtr1) {
		return nniTlsInit(Pointer.getPeer(nni_tlsPtrPtr1), Pointer.getPeer(nng_tls_configPtr1), Pointer.getPeer(nni_tcp_connPtr1));
	}
	@Name("nni_tls_init") 
	protected native static int nniTlsInit(@Ptr long nni_tlsPtrPtr1, @Ptr long nng_tls_configPtr1, @Ptr long nni_tcp_connPtr1);
	/**
	 * Original signature : <code>void nni_tls_close(nni_tls*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:20</i>
	 */
	@Name("nni_tls_close") 
	public static void nniTlsClose(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1) {
		nniTlsClose(Pointer.getPeer(nni_tlsPtr1));
	}
	@Name("nni_tls_close") 
	protected native static void nniTlsClose(@Ptr long nni_tlsPtr1);
	/**
	 * Original signature : <code>void nni_tls_fini(nni_tls*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:22</i>
	 */
	@Name("nni_tls_fini") 
	public static void nniTlsFini(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1) {
		nniTlsFini(Pointer.getPeer(nni_tlsPtr1));
	}
	@Name("nni_tls_fini") 
	protected native static void nniTlsFini(@Ptr long nni_tlsPtr1);
	/**
	 * Original signature : <code>void nni_tls_send(nni_tls*, nng_aio*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:24</i>
	 */
	@Name("nni_tls_send") 
	public static void nniTlsSend(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1, Pointer<TlsApiLibrary.nng_aio > nng_aioPtr1) {
		nniTlsSend(Pointer.getPeer(nni_tlsPtr1), Pointer.getPeer(nng_aioPtr1));
	}
	@Name("nni_tls_send") 
	protected native static void nniTlsSend(@Ptr long nni_tlsPtr1, @Ptr long nng_aioPtr1);
	/**
	 * Original signature : <code>void nni_tls_recv(nni_tls*, nng_aio*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:26</i>
	 */
	@Name("nni_tls_recv") 
	public static void nniTlsRecv(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1, Pointer<TlsApiLibrary.nng_aio > nng_aioPtr1) {
		nniTlsRecv(Pointer.getPeer(nni_tlsPtr1), Pointer.getPeer(nng_aioPtr1));
	}
	@Name("nni_tls_recv") 
	protected native static void nniTlsRecv(@Ptr long nni_tlsPtr1, @Ptr long nng_aioPtr1);
	/**
	 * Original signature : <code>int nni_tls_sockname(nni_tls*, nni_sockaddr*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:28</i>
	 */
	@Name("nni_tls_sockname") 
	public static int nniTlsSockname(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1, Pointer<nng_sockaddr > nni_sockaddrPtr1) {
		return nniTlsSockname(Pointer.getPeer(nni_tlsPtr1), Pointer.getPeer(nni_sockaddrPtr1));
	}
	@Name("nni_tls_sockname") 
	protected native static int nniTlsSockname(@Ptr long nni_tlsPtr1, @Ptr long nni_sockaddrPtr1);
	/**
	 * Original signature : <code>int nni_tls_peername(nni_tls*, nni_sockaddr*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:30</i>
	 */
	@Name("nni_tls_peername") 
	public static int nniTlsPeername(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1, Pointer<nng_sockaddr > nni_sockaddrPtr1) {
		return nniTlsPeername(Pointer.getPeer(nni_tlsPtr1), Pointer.getPeer(nni_sockaddrPtr1));
	}
	@Name("nni_tls_peername") 
	protected native static int nniTlsPeername(@Ptr long nni_tlsPtr1, @Ptr long nni_sockaddrPtr1);
	/**
	 * Original signature : <code>int nni_tls_set_nodelay(nni_tls*, bool)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:32</i>
	 */
	@Name("nni_tls_set_nodelay") 
	public static int nniTlsSetNodelay(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1, boolean bool1) {
		return nniTlsSetNodelay(Pointer.getPeer(nni_tlsPtr1), bool1);
	}
	@Name("nni_tls_set_nodelay") 
	protected native static int nniTlsSetNodelay(@Ptr long nni_tlsPtr1, boolean bool1);
	/**
	 * Original signature : <code>int nni_tls_set_keepalive(nni_tls*, bool)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:34</i>
	 */
	@Name("nni_tls_set_keepalive") 
	public static int nniTlsSetKeepalive(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1, boolean bool1) {
		return nniTlsSetKeepalive(Pointer.getPeer(nni_tlsPtr1), bool1);
	}
	@Name("nni_tls_set_keepalive") 
	protected native static int nniTlsSetKeepalive(@Ptr long nni_tlsPtr1, boolean bool1);
	/**
	 * be accurate once the handshake is finished, however.<br>
	 * Original signature : <code>bool nni_tls_verified(nni_tls*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:39</i>
	 */
	@Name("nni_tls_verified") 
	public static boolean nniTlsVerified(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1) {
		return nniTlsVerified(Pointer.getPeer(nni_tlsPtr1));
	}
	@Name("nni_tls_verified") 
	protected native static boolean nniTlsVerified(@Ptr long nni_tlsPtr1);
	/**
	 * nni_tls_ciphersuite_name returns the name of the ciphersuite in use.<br>
	 * Original signature : <code>char* nni_tls_ciphersuite_name(nni_tls*)</code><br>
	 * <i>native declaration : supplemental/tls/tls_api.h:44</i>
	 */
	@Name("nni_tls_ciphersuite_name") 
	public static Pointer<Byte > nniTlsCiphersuiteName(Pointer<TlsApiLibrary.nni_tls > nni_tlsPtr1) {
		return (Pointer)Pointer.pointerToAddress(nniTlsCiphersuiteName(Pointer.getPeer(nni_tlsPtr1)), Byte.class);
	}
	@Name("nni_tls_ciphersuite_name") 
	@Ptr 
	protected native static long nniTlsCiphersuiteName(@Ptr long nni_tlsPtr1);
	/** Undefined type */
	public static interface nng_tls_config {
		
	};
	/** Undefined type */
	public static interface nni_tls {
		
	};
	/** Undefined type */
	public static interface nng_aio {
		
	};
	/** Undefined type */
	public static interface nni_tcp_conn {
		
	};
}
