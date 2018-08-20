package nng.tcp;
import org.bridj.BridJ;
import org.bridj.CRuntime;
import org.bridj.ann.Library;
import org.bridj.ann.Name;
import org.bridj.ann.Runtime;
/**
 * Wrapper for library <b>tcp</b><br>
 * This file was autogenerated by <a href="https://github.com/nativelibs4java/JNAerator">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="https://github.com/nativelibs4java">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("tcp") 
@Runtime(CRuntime.class) 
public class TcpLibrary {
	static {
		BridJ.register();
	}
	/**
	 * TCP transport.  This is used for communication over TCP/IP.<br>
	 * Original signature : <code>int nng_tcp_register()</code><br>
	 * <i>native declaration : transport/tcp/tcp.h:4</i>
	 */
	@Name("nng_tcp_register") 
	public static native int nngTcpRegister();
}