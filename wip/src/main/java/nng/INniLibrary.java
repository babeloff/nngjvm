/**
 * http://java-native-access.github.io/jna/4.5.2/javadoc/overview-summary.html#structures
 */ 
package nng;

import com.sun.jna.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nng.IBaseLibrary;

public interface INniLibrary extends IBaseLibrary {
	final Map<String,?> options = new HashMap<String,String>();

	/** src/core/defs.h */
	class nni_time extends uint64_t {}
    class nni_duration extends int32_t {}

    interface nni_cb extends Callback {
        void callback(Pointer arg);
    }

    /** src/core/list.h */
	class nni_list_node extends Structure {
		private final List<String> fieldOrder;
		private nni_list_node() {
			this.fieldOrder = Arrays.asList("ln_next", "ln_prev");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nni_list_node implements Structure.ByValue {}

		public nni_list_node ln_next;
		public nni_list_node ln_prev;
	};

	class nni_list extends Structure {
		private final List<String> fieldOrder;
		private nni_list() {
			this.fieldOrder = Arrays.asList("ll_head", "ll_offset");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nni_list implements Structure.ByValue {}

		public nni_list_node ll_head;
		public size_t ll_offset;
	};

    class nni_plat_mtx extends Structure {
        private final List<String> fieldOrder;
        private nni_plat_mtx() {
            this.fieldOrder = Arrays.asList("mtx");
        }
        @Override
        protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nni_list implements Structure.ByValue {}

        public pthread_mutex_t mtx;
    }

    class nni_plat_cv extends Structure {
        private final List<String> fieldOrder;
        private nni_plat_cv() {
            this.fieldOrder = Arrays.asList("cv", "mtx");
        }
        @Override
        protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nni_list implements Structure.ByValue {}

        public pthread_cond_t cv;
        public ByReference mtx;
    }
	class nni_cv extends nni_plat_cv {}

}
