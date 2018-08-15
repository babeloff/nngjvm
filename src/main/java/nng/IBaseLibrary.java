/**
 * http://java-native-access.github.io/jna/4.5.2/javadoc/overview-summary.html#structures
 */ 
package nng;

import com.sun.jna.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IBaseLibrary extends Library {
	final Map<String,?> options = new HashMap<String,String>();

    class bool_t extends IntegerType {
	    public static final int SIZE = Native.BOOL_SIZE;
	    public bool_t() { this(0); }
	    public bool_t(long value) { this(value, false); }
	    public bool_t(long value, boolean unsigned) { super(SIZE, value, unsigned); }
	    public static class ByValue extends bool_t implements Structure.ByValue {
	    	private static final long serialVersionUID = 1L;
		}
    }

	class int_t extends IntegerType {
	    public static final int SIZE = Native.SIZE_T_SIZE;
	    public int_t() { this(0); }
	    public int_t(long value) { this(value, false); }
	    public int_t(long value, boolean unsigned) { super(SIZE, value, unsigned); }
	    public static class ByValue extends int_t implements Structure.ByValue {
	    	private static final long serialVersionUID = 1L;
		}
	}

	class size_t extends IntegerType {
	    public static final int SIZE = Native.SIZE_T_SIZE;
	    public size_t() { this(0); }
	    public size_t(long value) { this(value, false); }
	    public size_t(long value, boolean unsigned) { super(SIZE, value, unsigned); }
	    public static class ByValue extends size_t implements Structure.ByValue {
	    	private static final long serialVersionUID = 1L;
		}
	}

	class uint_t extends IntegerType {
	    public static final int SIZE = 1; // size in chars
	    public uint_t() { this(0); }
	    public uint_t(long value) { this(value, true); }
	    public uint_t(long value, boolean unsigned) { super(SIZE, value, unsigned);  }
	    public static class ByValue extends uint_t implements Structure.ByValue {
	    	private static final long serialVersionUID = 1L;
		}
	}

	class uint8_t extends IntegerType {
	    public static final int SIZE = 1; // size in chars
	    public uint8_t() { this(0); }
	    public uint8_t(long value) { this(value, true); }
	    public uint8_t(long value, boolean unsigned) { super(SIZE, value, unsigned);  }
	    public static class ByValue extends uint8_t implements Structure.ByValue {
	    	private static final long serialVersionUID = 1L;
		}
	}

	class uint16_t extends IntegerType {
	    public static final int SIZE = 2; // size in chars
	    public uint16_t() { this(0); }
	    public uint16_t(long value) { this(value, true); }
	    public uint16_t(long value, boolean unsigned) { super(SIZE, value, unsigned);  }
	    public static class ByValue extends uint8_t implements Structure.ByValue {
	    	private static final long serialVersionUID = 1L;
		}
	}

	class uint32_t extends IntegerType {
	    private static final long serialVersionUID = 1L;
	    public static final int SIZE = 4; // size in chars
	    public uint32_t() { this(0); }
	    public uint32_t(long value) { this(value, true); }
	    public uint32_t(long value, boolean unsigned) { super(SIZE, value, unsigned);  }
	    public static class ByValue extends uint32_t implements Structure.ByValue {
	    	private static final long serialVersionUID = 1L;
		}
	}

	class int32_t extends IntegerType {
	    public static final int SIZE = 4; // size in chars
	    public int32_t() { this(0); }
	    public int32_t(long value) { this(value, false); }
	    public int32_t(long value, boolean unsigned) { super(SIZE, value, unsigned);  }
	    public static class ByValue extends int32_t implements Structure.ByValue {
	    	private static final long serialVersionUID = 1L;
		}
	}

	class uint64_t extends IntegerType {
	    public static final int SIZE = 8; // size in chars
	    public uint64_t() { this(0); }
	    public uint64_t(long value) { this(value, true); }
	    public uint64_t(long value, boolean unsigned) { super(SIZE, value, unsigned); }
	    public static class ByValue extends uint64_t implements Structure.ByValue {
	    	private static final long serialVersionUID = 1L;
		}
	}

	class pthread_cond_s

}
