/**
 * http://java-native-access.github.io/jna/4.5.2/javadoc/overview-summary.html#structures
 */ 
package nng;

import com.sun.jna.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IPlatformLibrary extends Library {
	final Map<String,?> options = new HashMap<String,String>();


	final int __SIZEOF_PTHREAD_COND_T = 48;

	class pthread_cond_t extends Union {
		private final List<String> fieldOrder;
		private pthread_cond_t() {
			this.fieldOrder = Arrays.asList("ll_head", "ll_offset");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nni_list implements Structure.ByValue {}

		public pthread_cond_s __data;
		public char[] __size;
	}

}
