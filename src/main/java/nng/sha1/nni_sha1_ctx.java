package nng.sha1;
import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Array;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * <i>native declaration : supplemental/sha1/sha1.h:9</i><br>
 * This file was autogenerated by <a href="https://github.com/nativelibs4java/JNAerator">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="https://github.com/nativelibs4java">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("sha1") 
public class nni_sha1_ctx extends StructObject {
	static {
		BridJ.register();
	}
	/**
	 * resulting digest<br>
	 * C type : uint32_t[5]
	 */
	@Array({5}) 
	@Field(0) 
	public Pointer<Integer > digest() {
		return this.io.getPointerField(this, 0);
	}
	/** length in bits */
	@Field(1) 
	public long len() {
		return this.io.getLongField(this, 1);
	}
	/** length in bits */
	@Field(1) 
	public nni_sha1_ctx len(long len) {
		this.io.setLongField(this, 1, len);
		return this;
	}
	/**
	 * message block<br>
	 * C type : uint8_t[64]
	 */
	@Array({64}) 
	@Field(2) 
	public Pointer<Byte > blk() {
		return this.io.getPointerField(this, 2);
	}
	/** index of next byte in block */
	@Field(3) 
	public int idx() {
		return this.io.getIntField(this, 3);
	}
	/** index of next byte in block */
	@Field(3) 
	public nni_sha1_ctx idx(int idx) {
		this.io.setIntField(this, 3, idx);
		return this;
	}
	public nni_sha1_ctx() {
		super();
	}
	public nni_sha1_ctx(Pointer pointer) {
		super(pointer);
	}
}
