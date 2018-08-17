/**
 * http://java-native-access.github.io/jna/4.5.2/javadoc/overview-summary.html#structures
 */ 
package nng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

import com.sun.jna.Callback;
import com.sun.jna.IntegerType;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;

public interface INngLibrary extends INniLibrary {
	final Map<String,?> options = new HashMap<String,String>();

    /** src/supplemental/util/platform.h */
    class nng_cv extends Structure {
		private final List<String> fieldOrder;
		private nng_cv() { 
			this.fieldOrder = Arrays.asList("c");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_cv implements Structure.ByValue {}

		public nni_cv        c;
    };

    interface async_cb extends Callback {
        void callback(Pointer arg);
    }

    class nng_thread extends Structure {
		private final List<String> fieldOrder;
		private nng_thread() { 
			this.fieldOrder = Arrays.asList("task_node", "task_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nng_thread implements Structure.ByValue {}
    }

    class nng_time extends Structure {
		private final List<String> fieldOrder;
		private nng_time() { 
			this.fieldOrder = Arrays.asList("task_node", "task_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nng_time implements Structure.ByValue {}
    }

    class nng_url extends Structure {
		private final List<String> fieldOrder;
		private nng_url() { 
			this.fieldOrder = Arrays.asList("task_node", "task_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nng_url implements Structure.ByValue {}
    }

    class nng_http_res extends Structure {
		private final List<String> fieldOrder;
		private nng_http_res() { 
			this.fieldOrder = Arrays.asList("task_node", "task_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nng_http_res implements Structure.ByValue {}
    }

    class nng_http_client extends Structure {
		private final List<String> fieldOrder;
		private nng_http_client() { 
			this.fieldOrder = Arrays.asList("task_node", "task_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nng_http_client implements Structure.ByValue {}
    }

    class nng_tls_config extends Structure {
		private final List<String> fieldOrder;
		private nng_tls_config() { 
			this.fieldOrder = Arrays.asList("task_node", "task_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nng_tls_config implements Structure.ByValue {}
    }

	class nni_task extends Structure {
		private final List<String> fieldOrder;
		private nni_task() { 
			this.fieldOrder = Arrays.asList("task_node", "task_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nni_task implements Structure.ByValue {}

		public nni_list_node task_node;
		public Pointer       task_arg;
		public nni_cb        task_cb;
		/*
		public nni_taskq *   task_tq;
		public nni_thr *     task_thr; // non-NULL if the task is running
		public unsigned      task_busy;
		public boolean          task_prep;
		public boolean         task_reap; // reap task on completion
		public nni_mtx       task_mtx;
		public nni_cv        task_cv;
		*/
    }
    
    class nng_ctx extends Structure {
		private final List<String> fieldOrder;
		private nng_ctx() { 
			this.fieldOrder = Arrays.asList(
			        "o_name", "o_short", "o_val", "o_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_ctx implements Structure.ByValue {}
    }
    
    class nng_http_conn extends Structure {
		private final List<String> fieldOrder;
		private nng_http_conn() { 
			this.fieldOrder = Arrays.asList(
			        "o_name", "o_short", "o_val", "o_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_http_conn implements Structure.ByValue {}
    }
    
    class nng_http_req extends Structure {
		private final List<String> fieldOrder;
		private nng_http_req() { 
			this.fieldOrder = Arrays.asList(
			        "o_name", "o_short", "o_val", "o_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nng_http_req implements Structure.ByValue {}
    }

	/** https://nanomsg.github.io/nng/man/tip/nng_opts_parse.3supp.html  */
	class nng_optspec extends Structure {
		private final List<String> fieldOrder;
		private nng_optspec() { 
			this.fieldOrder = Arrays.asList(
			        "o_name", "o_short", "o_val", "o_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_optspec implements Structure.ByValue {}
        
        String o_name;          // Long style name (may be NULL for short only)
        int_t.ByValue o_short;  // Short option (no clustering!)
        int_t.ByValue  o_val;   // Value stored on a good parse (>0)
        bool_t.ByValue o_arg;   // Option takes an argument if true
    }

   

	/** src/core/message.c  */
	class nni_chunk extends Structure {
		private final List<String> fieldOrder;
		private nni_chunk() { 
			this.fieldOrder = Arrays.asList(
			        "ch_cap", "ch_len", "ch_buf", "ch_ptr");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nni_chunk implements Structure.ByValue {}
		
		size_t.ByValue   ch_cap; // allocated size
		size_t.ByValue   ch_len; // length in use
		uint8_t ch_buf; // underlying buffer
		uint8_t ch_ptr; // pointer to actual data
    }
    
	
	INngLibrary INST = (INngLibrary)
			Native.loadLibrary(
					Platform.isWindows() ? "msvcrt":
					Platform.isLinux() ? "c" :
					"c",
					INngLibrary.class,
					options);
	
    // TODO
    class nng_mtx extends Structure {
		private final List<String> fieldOrder;
		private nng_mtx() { 
			this.fieldOrder = Arrays.asList(
			        "ch_cap", "ch_len", "ch_buf", "ch_ptr");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nng_mtx implements Structure.ByValue {}
    }

	class nng_socket extends Structure {
		private List<String> fieldOrder;
		private nng_socket() { this.fieldOrder = Arrays.asList("id"); }
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_socket implements Structure.ByValue {}
		public NativeLong id;
	}
	
	class nng_actor extends Structure {
		private List<String> fieldOrder;
		private nng_actor() { this.fieldOrder = Arrays.asList("id"); }
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_actor implements Structure.ByValue {}
		public uint32_t id;
	}
	
	class nng_dialer extends nng_actor {}
	
	class nng_listener extends nng_actor {}
	class nng_pipe extends nng_actor {}
	

	// typedef void (*nng_pipe_cb)(nng_pipe, int, Pointer);
	interface nng_pipeCb extends Callback {
		void callback(nng_pipe p, int event, Pointer arg);
	}
	
	interface nng_voidCb extends Callback {
		void callback(Pointer arg);
	}
		
	/** src/core/message.c  */
	class nng_msg extends Structure {
		private final List<String> fieldOrder;
		private nng_msg() { 
			this.fieldOrder = Arrays.asList(
			        "m_header", "m_body", "m_expire", "m_options", "m_pipe");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_msg implements Structure.ByValue {}

		public nni_chunk m_header;
		public nni_chunk m_body;
		public nni_time m_expire;
		public nni_list m_options;
		public uint32_t m_pipe;
	};
	
	/** src/core/message.c  */
	class nng_msgopt extends Structure {
		private final List<String> fieldOrder;
		private nng_msgopt() { 
			this.fieldOrder = Arrays.asList(
			        "mo_num", "mo_sz", "mo_val", "mo_node");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_msgopt implements Structure.ByValue {}
	
		int           mo_num;
		size_t        mo_sz;
		Pointer       mo_val;
		nni_list_node mo_node;
	};

	/** src/core/message.c  */
	class nng_iov extends Structure {
		private final List<String> fieldOrder;
		private nng_iov() { 
			this.fieldOrder = Arrays.asList("iov_buf", "iov_len");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_iov implements Structure.ByValue {}
	
		Pointer iov_buf;
		size_t iov_len;
	};
	
	/** src/core/aio.c */
	class nng_aio extends Structure {
		private final List<String> fieldOrder;
		private nng_aio() { 
			this.fieldOrder = Arrays.asList("a_result", "a_count");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_aio implements Structure.ByValue {}
	
		int          a_result;  // Result code (nng_errno)
		size_t       a_count;   // Bytes transferred (I/O only)
		nni_time     a_expire;  // Absolute timeout
		nni_duration a_timeout; // Relative timeout
	
		// These fields are private to the aio framework.
		boolean      a_stop;    // shutting down (no new operations)
		boolean      a_sleep;   // sleeping with no action
		int          a_sleeprv; // result when sleep wakes
		nni_task     a_task;
	/*
		// Read/write operations.
		nni_iov *a_iov;
		unsigned a_niov;
		nni_iov  a_iovinl[4]; // inline IOVs - when the IOV list is short
		nni_iov *a_iovalloc;  // dynamically allocated IOVs
		unsigned a_niovalloc; // number of allocated IOVs
	
		// Message operations.
		nni_msg *a_msg;
	
		// User scratch data.  Consumers may store values here, which
		// must be preserved by providers and the framework.
		Pointera_user_data[4];
	
		// Operation inputs & outputs.  Up to 4 inputs and 4 outputs may be
		// specified.  The semantics of these will vary, and depend on the
		// specific operation.
		Pointera_inputs[4];
		Pointera_outputs[4];
	
		// Provider-use fields.
		nni_aio_cancelfn a_prov_cancel;
		Pointer           a_prov_data;
		nni_list_node    a_prov_node;
		Pointer           a_prov_extra[4]; // Extra data used by provider
	
		// Expire node.
		nni_list_node a_expire_node;
		*/
    };
    

	class nng_http_handler extends Structure {
		private final List<String> fieldOrder;
		private nng_http_handler() { 
			this.fieldOrder = Arrays.asList("iov_buf", "iov_len");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
		public static class ByValue extends nng_http_handler implements Structure.ByValue {}
	
		Pointer iov_buf;
		size_t iov_len;
	};

    class nng_http_server extends Structure {
		private final List<String> fieldOrder;
		private nng_http_server() { 
			this.fieldOrder = Arrays.asList("task_node", "task_arg");
		}
		@Override
		protected List<String> getFieldOrder() { return this.fieldOrder; }
        public static class ByValue extends nng_http_server implements Structure.ByValue {}
    }

    class nng_tls_mode extends int32_t {}
    public static int NNG_TLS_MODE_CLIENT = 1;
    public static int NNG_TLS_MODE_SERVER = 2;

    class nng_tls_auth_mode extends int32_t {}
    public static int NNG_TLS_AUTH_MODE_NONE = 0;
    public static int NNG_TLS_AUTH_MODE_OPTIONAL = 1;
    public static int NNG_TLS_AUTH_MODE_REQUIRED = 2;

	
  /**
   * see https://nanomsg.github.io/nng/man/v1.0.0/libnng.3.html
   */
  
  // Common Functions
	
  /** https://nanomsg.github.io/nng/man/v1.0.0/nng_alloc.3.html */
  Pointer nng_alloc (size_t size);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_free.3.html */
  void nng_free (Pointer ptr, size_t size);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_strdup.3.html */
  String nng_strdup (String src);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_strerror.3.html */
  String nng_strerror (int err);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_strfree.3.html */
  void nng_strfree (String src);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_strversion.3.html */
  String nng_version ();
  
  
  // Socket Functions
  
  /** https://nanomsg.github.io/nng/man/tip/nng_close.3.html */
  int nng_close (nng_socket.ByValue sock);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_dial.3.html */
  int nng_dial (nng_socket.ByValue sock, String url, nng_dialer dp, int flags);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_getopt.3.html */
  int nng_getopt (nng_socket.ByValue sock, String opt, Pointer val, size_t valszp);
  int nng_getopt_bool (nng_socket.ByValue sock, String opt, Pointer val, Pointer bvalp);
  int nng_getopt_int (nng_socket.ByValue sock, String opt, Pointer val, Pointer ivalp);
  int nng_getopt_ms (nng_socket.ByValue sock, String opt, Pointer val, nni_duration durp);
  int nng_getopt_ptr (nng_socket.ByValue sock, String opt, Pointer val, Pointer ptr);
  int nng_getopt_size (nng_socket.ByValue sock, String opt, Pointer val, Pointer zp);
  int nng_getopt_string (nng_socket.ByValue sock, String opt, Pointer val, Pointer strp);
  int nng_getopt_uint64 (nng_socket.ByValue sock, String opt, Pointer val, uint64_t u64p);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_listen.3.html */
  int nng_listen (nng_socket.ByValue sock, String url, nng_listener lp, int flags);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_recv.3.html */
  int nng_recv (nng_socket.ByValue sock, Pointer data, size_t sizep, int flags);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_send.3.html */
  int nng_send (nng_socket.ByValue sock, Pointer data, size_t.ByValue size, int flags);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_setopt.3.html */
  int nng_setopt (nng_socket.ByValue sock, String opt, Pointer val, size_t.ByValue valszp);
  int nng_setopt_bool (nng_socket.ByValue sock, String opt, Pointer val, int bvalp);
  int nng_setopt_int (nng_socket.ByValue sock, String opt, Pointer val, int ivalp);
  int nng_setopt_ms (nng_socket.ByValue sock, String opt, Pointer val, nni_duration.ByValue durp);
  int nng_setopt_ptr (nng_socket.ByValue sock, String opt, Pointer val, Pointer ptr);
  int nng_setopt_size (nng_socket.ByValue sock, String opt, Pointer val, size_t.ByValue zp);
  int nng_setopt_string (nng_socket.ByValue sock, String opt, Pointer val, String strp);
  int nng_setopt_uint64 (nng_socket.ByValue sock, String opt, Pointer val, uint64_t.ByValue u64p);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_socket_id.3.html */
  int nng_socket_id (nng_socket.ByValue sock);
  
  // Connection Management
  
  /** https://nanomsg.github.io/nng/man/tip/nng_dialer_close.3.html */
  int nng_dialer_close(nng_dialer.ByValue d);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_dialer_create.3.html */
  int nng_dialer_create(nng_dialer dialerp, nng_socket.ByValue s, String url);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_dialer_getopt.3.html */
  int nng_dialer_getopt(nng_dialer.ByValue d, String opt, Pointer val, size_t valszp);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_dialer_id.3.html */
  int nng_dialer_id(nng_dialer.ByValue d);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_dialer_setopt.3.html */
  int nng_dialer_setopt(nng_dialer.ByValue d, String opt, Pointer val, size_t.ByValue valsz);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_dialer_start.3.html */
  int nng_dialer_start(nng_dialer.ByValue d, int flags);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_listener_close.3.html */
  int nng_listener_close(nng_listener.ByValue l);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_listener_create.3.html */
  int nng_listener_create(nng_listener listenerp, nng_socket.ByValue s, String url);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_listener_getopt.3.html */
  int nng_listener_getopt(nng_listener.ByValue l, String opt, Pointer val, size_t valszp);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_listener_id.3.html */
  int nng_listener_id(nng_listener.ByValue l);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_listener_setopt.3.html */
  int nng_listener_setopt(nng_listener.ByValue l, String opt, Pointer val, size_t.ByValue valsz);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_listener_start.3.html */
  int nng_listener_start(nng_listener.ByValue l, int flags);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_pipe_close.3.html */
  int nng_pipe_close(nng_pipe.ByValue p);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_pipe_dialer.3.html */
  nng_dialer nng_pipe_dialer(nng_pipe.ByValue p);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_pipe_getopt.3.html */
  int nng_pipe_getopt(nng_pipe.ByValue p, String opt, Pointer val, size_t valszp);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_pipe_id.3.html */
  int nng_pipe_id(nng_pipe.ByValue p);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_pipe_listener.3.html */
  nng_listener.ByValue nng_pipe_listener(nng_pipe.ByValue p);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_pipe_notify.3.html */
  int nng_pipe_notify(nng_socket.ByValue s, int ev, nng_pipeCb cb, Pointer arg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_pipe_socket.3.html */
  nng_socket.ByValue nng_pipe_socket(nng_pipe.ByValue p);
  
  // Message Handling
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_alloc.3.html */
  int nng_msg_alloc(nng_msg[] msgp, size_t size);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_append.3.html */
  int nng_msg_append(nng_msg msg, Pointer  val, size_t size);
  int nng_msg_append_u32(nng_msg msg, uint32_t val32);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_body.3.html */
  Pointer nng_msg_body(nng_msg msg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_chop.3.html */
  int nng_msg_chop(nng_msg msg, size_t size);
  int nng_msg_chop_u32(nng_msg msg, uint32_t val32);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_clear.3.html */
  void nng_msg_clear(nng_msg msg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_dup.3.html */
  int nng_msg_dup(nng_msg[] dup, nng_msg orig);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_free.3.html */
  void nng_msg_free(nng_msg msg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_get_pipe.3.html */
  nng_pipe nng_msg_get_pipe(nng_msg msg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_insert.3.html */
  int nng_msg_insert(nng_msg msg, Pointer  val, size_t size);
  int nng_msg_insert(nng_msg msg, uint32_t val32);

  /** https://nanomsg.github.io/nng/man/tip/nng_msg_len.3.html */
  size_t nng_msg_len(nng_msg msg);

  /** https://nanomsg.github.io/nng/man/tip/nng_msg_realloc.3.html */
  int nng_msg_realloc(nng_msg msg, size_t size);

  /** https://nanomsg.github.io/nng/man/tip/nng_msg_set_pipe.3.html */
  void nng_msg_set_pipe(nng_msg msg, nng_pipe p);

  /** https://nanomsg.github.io/nng/man/tip/nng_msg_trim.3.html */
  int nng_msg_trim(nng_msg msg, size_t size);
  int nng_msg_trim_u32(nng_msg msg, uint32_t val32);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_recvmsg.3.html */
  int nng_recvmsg(nng_socket s, nng_msg[] msgp, int flags);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_sendmsg.3.html */
  int nng_sendmsg(nng_socket s, nng_msg msg, int flags);
  
  // Header Handling
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_header.3.html */
  Pointer nng_msg_header(nng_msg msg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_header_append.3.html */
  int nng_msg_header_append(nng_msg msg, Pointer  val, size_t size);
  int nng_msg_header_append_u32(nng_msg msg, uint32_t val32);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_header_chop.3.html */
  int nng_msg_header_chop(nng_msg msg, size_t size);
  int nng_msg_header_chop_u32(nng_msg msg, uint32_t val32);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_header_clear.3.html */
  void nng_msg_header_clear(nng_msg msg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_header_insert.3.html */
  int nng_msg_header_insert(nng_msg msg, Pointer  val, size_t size);
  int nng_msg_header_insert_u32(nng_msg msg, uint32_t val32);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_header_len.3.html */
  size_t nng_msg_header_len(nng_msg msg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msg_header_trim.3.html */
  int nng_msg_header_trim(nng_msg msg, size_t size);
  int nng_msg_header_trim_u32(nng_msg msg, uint32_t val32);
  
  // Asynchronous Operations
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_abort.3.html */
  void nng_aio_abort(nng_aio aio, int err);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_alloc.3.html */
  int nng_aio_alloc(nng_aio[] aiop, async_cb callb, Pointer arg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_cancel.3.html */
  void nng_aio_cancel(nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_count.3.html */
  size_t nng_aio_count(nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_finish.3.html */
  void nng_aio_finish(nng_aio aio, int err);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_free.3.html */
  void nng_aio_free(nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_get_input.3.html */
  Pointer nng_aio_get_input(nng_aio aio, uint_t index);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_get_msg.3.html */
  nng_msg nng_aio_get_msg(nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_get_output.3.html */
  Pointer nng_aio_get_output(nng_aio aio, uint_t index);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_result.3.html */
  int nng_aio_result(nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_set_input.3.html */
  void nng_aio_set_input(nng_aio aio, uint_t index, Pointer param);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_set_iov.3.html */
  int nng_aio_set_iov(nng_aio aio, uint_t niov, nng_iov iov);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_set_msg.3.html */
  void nng_aio_set_msg(nng_aio aio, nng_msg msg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_set_output.3.html */
  void nng_aio_set_output(nng_aio aio, uint_t index, Pointer result);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_set_timeout.3.html */
  void nng_aio_set_timeout(nng_aio aio, int timeout);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_stop.3.html */
  void nng_aio_stop(nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_aio_wait.3.html */
  void nng_aio_wait(nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_recv_aio.3.html */
  void nng_recv_aio(nng_socket s, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_send_aio.3.html */
  void nng_send_aio(nng_socket s, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_sleep_aio.3.html */
  void nng_sleep_aio(nni_duration msec, nng_aio aio);
  
  
  
  // Protocols
  
  /** https://nanomsg.github.io/nng/man/tip/nng_bus_open.3.html */
  int nng_bus0_open(nng_socket s);
  int nng_bus0_open_raw(nng_socket s);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_pair_open.3.html */
  int nng_pair0_open(nng_socket s);
  int nng_pair0_open_raw(nng_socket s);
  int nng_pair1_open(nng_socket s);
  int nng_pair1_open_raw(nng_socket s);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_pub_open.3.html */
  int nng_pub0_open(nng_socket s);
  int nng_pub0_open_raw(nng_socket s);

  /** https://nanomsg.github.io/nng/man/tip/nng_pull_open.3.html */
  int nng_pull0_open(nng_socket s);
  int nng_pull0_open_raw(nng_socket s);

  /** https://nanomsg.github.io/nng/man/tip/nng_push_open.3.html */
  int nng_push0_open(nng_socket s);
  int nng_push0_open_raw(nng_socket s);

  /** https://nanomsg.github.io/nng/man/tip/nng_rep_open.3.html */
  int nng_rep0_open(nng_socket s);

  /** https://nanomsg.github.io/nng/man/tip/nng_req_open.3.html */
  int nng_req0_open(nng_socket s);
  int nng_req0_open_raw(nng_socket s);

  /** https://nanomsg.github.io/nng/man/tip/nng_respondent_open.3.html */
  int nng_respondent0_open(nng_socket s);
  int nng_respondent0_open_raw(nng_socket s);

  /** https://nanomsg.github.io/nng/man/tip/nng_sub_open.3.html */
  int nng_sub0_open(nng_socket s);
  int nng_sub0_open_raw(nng_socket s);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_surveyor_open.3.html */
  int nng_surveyor0_open(nng_socket s);
  int nng_surveyor0_open_raw(nng_socket s);
  
  // Transports
  
  /** https://nanomsg.github.io/nng/man/tip/nng_inproc_register.3.html */
  int nng_inproc_register();
  
  /** https://nanomsg.github.io/nng/man/tip/nng_ipc_register.3.html */
  int nng_ipc_register();
  
  /** https://nanomsg.github.io/nng/man/tip/nng_tcp_register.3.html */
  int nng_tcp_register();
  
  /** https://nanomsg.github.io/nng/man/tip/nng_tls_register.3.html */
  int nng_tls_register();
  
  /** https://nanomsg.github.io/nng/man/tip/nng_ws_register.3.html */
  int nng_ws_register();
  
  /** https://nanomsg.github.io/nng/man/tip/nng_wss_register.3.html */
  int nng_wss_register();
  
  /** https://nanomsg.github.io/nng/man/tip/nng_zt_register.3.html */
  int nng_zt_register();
  
  // Protocol Contexts
  
  /** https://nanomsg.github.io/nng/man/tip/nng_ctx_close.3.html */
  int nng_ctx_close(nng_ctx ctx);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_ctx_getopt.3.html */
  int nng_ctx_getopt(nng_ctx ctx, String opt, Pointer val, size_t valszp);
  int nng_ctx_getopt_bool(nng_ctx ctx, String opt, bool_t bvalp);
  int nng_ctx_getopt_int(nng_ctx ctx, String opt, int_t ivalp);
  int nng_ctx_getopt_ms(nng_ctx ctx, String opt, nni_duration durp);
  int nng_ctx_getopt_size(nng_ctx ctx, String opt, size_t zp);
  int nng_ctx_getopt_string(nng_ctx ctx, String opt, String[] strp);
  int nng_ctx_getopt_uint64(nng_ctx ctx, String opt, uint64_t u64p);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_ctx_id.3.html */
  int nng_ctx_id(nng_ctx c);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_ctx_open.3.html */
  int nng_ctx_open(nng_ctx ctxp, nng_socket s);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_ctx_recv.3.html */
  void nng_ctx_recv(nng_ctx ctx, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_ctx_send.3.html */
  void nng_ctx_send(nng_ctx ctx, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_ctx_setopt.3.html */
  int nng_ctx_setopt(nng_ctx ctx, String opt, Pointer  val, size_t valsz);
  int nng_ctx_setopt_bool(nng_ctx ctx, String opt, int bval);
  int nng_ctx_setopt_int(nng_ctx ctx, String opt, int ival);
  int nng_ctx_setopt_ms(nng_ctx ctx, String opt, nni_duration dur);
  int nng_ctx_setopt_size(nng_ctx ctx, String opt, size_t z);
  int nng_ctx_setopt_string(nng_ctx ctx, String opt, String str);
  int nng_ctx_setopt_uint64(nng_ctx ctx, String opt, uint64_t u64);
  
  // URL Objects
  
  /** https://nanomsg.github.io/nng/man/tip/nng_url_clone.3.html */
  int nng_url_clone(nng_url[] dup, nng_url orig);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_url_free.3.html */
  void nng_url_free(nng_url url);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_url_parse.3.html */
  int nng_url_parse(nng_url[] urlp, String str);

  // Supplemental Functions
  // #include <nng/supplemental/util/platform.h>
  
  /** https://nanomsg.github.io/nng/man/tip/nng_clock.3supp.html */
  nni_time.ByValue nng_clock();
  
  /** https://nanomsg.github.io/nng/man/tip/nng_cv_alloc.3supp.html */
  int nng_cv_alloc(nng_cv[] cvp, nng_mtx mtx);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_cv_free.3supp.html */
  void nng_cv_free(nng_cv cv);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_cv_until.3supp.html */
  int nng_cv_until(nng_cv cv, nng_time when);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_cv_wait.3supp.html */
  void nng_cv_wait(nng_cv cv);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_cv_wake.3supp.html */
  void nng_cv_wake(nng_cv cv);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_cv_wake1.3supp.html */
  void nng_cv_wake1(nng_cv cv);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_msleep.3supp.html */
  void nng_msleep(nni_duration msec);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_mtx_alloc.3supp.html */
  int nng_mtx_alloc(nng_mtx[] mtxp);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_mtx_free.3supp.html */
  void nng_mtx_free(nng_mtx mtx);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_mtx_lock.3supp.html */
  void nng_mtx_lock(nng_mtx mtx);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_mtx_unlock.3supp.html */
  void nng_mtx_unlock(nng_mtx mtx);
  
  
  int nng_opts_parse(int argc, String argv, nng_optspec spec, int_t val, String arg, int_t idx);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_random.3supp.html */
  uint32_t nng_random();
  
  /** https://nanomsg.github.io/nng/man/tip/nng_thread_create.3supp.html */
  int nng_thread_create(nng_thread[] thrp, async_cb func, Pointer arg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_thread_destroy.3supp.html */
  void nng_thread_destroy(nng_thread thread);
  
  // HTTP Common Functions
  // #include <nng/supplemental/http/http.h>
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_conn_close.3http.html */
  void nng_http_conn_close(nng_http_conn conn);
  
  // HTTP Client Functions
  
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_conn_read.3http.html */
  void nng_http_conn_read(nng_http_conn conn, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_conn_read_all.3http.html */
  void nng_http_conn_read_all(nng_http_conn conn, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_conn_read_req.3http.html */
  void nng_http_conn_read_req(nng_http_conn conn, nng_http_req req, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_conn_read_res.3http.html */
  void nng_http_conn_read_res(nng_http_conn conn, nng_http_res res, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_conn_write.3http.html */
  void nng_http_conn_write(nng_http_conn conn, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_conn_write_all.3http.html */
  void nng_http_conn_write_all(nng_http_conn conn, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_conn_write_req.3http.html */
  void nng_http_conn_write_req(nng_http_conn conn, nng_http_req req, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_conn_write_res.3http.html */
  void nng_http_conn_write_res(nng_http_conn conn, nng_http_res res, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_add_header.3http.html */
  int nng_http_req_add_header(nng_http_req req, String key, String val);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_alloc.3http.html */
  int nng_http_req_alloc(nng_http_req[] reqp, nng_url url);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_copy_data.3http.html */
  int nng_http_req_copy_data(nng_http_req req, Pointer  body, size_t size);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_del_header.3http.html */
  int nng_http_req_del_header(nng_http_req req, String key);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_free.3http.html */
  void nng_http_req_free(nng_http_req req);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_get_header.3http.html */
  String nng_http_req_get_header(nng_http_req req, String key);
 
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_get_method.3http.html */
  String nng_http_req_get_method(nng_http_req req);
 
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_get_uri.3http.html */
  String nng_http_req_get_uri(nng_http_req req);
 
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_get_version.3http.html */
  String nng_http_req_get_version(nng_http_req req);

  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_set_data.3http.html */
  int nng_http_req_set_data(nng_http_req req, Pointer  body, size_t size);

  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_set_header.3http.html */
  int nng_http_req_set_header(nng_http_req req, String key, String val);

  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_set_method.3http.html */
  int nng_http_req_set_method(nng_http_req req, String method);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_set_uri.3http.html */
  int nng_http_req_set_uri(nng_http_req req, String uri);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_req_set_version.3http.html */
  int nng_http_req_set_version(nng_http_req req, String version);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_res_add_header.3http.html */
  int nng_http_res_add_header(nng_http_res res, String key, String val); 
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_res_alloc.3http.html */
  int nng_http_res_alloc(nng_http_res[] resp);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_res_alloc_error.3http.html */
  int nng_http_res_alloc_error(nng_http_res[] resp, uint16_t status);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_res_copy_data.3http.html */
  int nng_http_res_copy_data(nng_http_res res, Pointer  body, size_t size);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_res_del_header.3http.html */
  int nng_http_res_set_header(nng_http_res res, String key);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_res_set_reason.3http.html */
  int nng_http_res_set_reason(nng_http_res res, String reason);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_res_set_status.3http.html */
  int nng_http_res_set_status(nng_http_res res, uint16_t status);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_res_set_version.3http.html */
  int nng_http_res_set_version(nng_http_res res, String version);

  // HTTP Client Functions
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_client_alloc.3http.html */
  int nng_http_client_alloc(nng_http_client clientp, nng_url url);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_client_connect.3http.html */
  void nng_http_client_connect(nng_http_client client, nng_aio aio);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_client_free.3http.html */
  void nng_http_client_free(nng_http_client client);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_client_get_tls.3http.html */
  int nng_http_client_get_tls(nng_http_client client, nng_tls_config[] cfgp);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_client_set_tls.3http.html */
  int nng_http_client_set_tls(nng_http_client client, nng_tls_config cfg);
  

  // HTTP Server Functions
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_handler_alloc.3http.html */
  int nng_http_handler_alloc(nng_http_handler[] hp, String path, async_cb func);
  int nng_http_handler_alloc_directory(nng_http_handler[] hp, String path, String dirname);
  int nng_http_handler_alloc_file(nng_http_handler[] hp, String path, String filename);
  int nng_http_handler_alloc_static(nng_http_handler[] hp, String path,
      Pointer  data, size_t size, String content_type);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_handler_free.3http.html */
  void nng_http_handler_free(nng_http_handler h);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_handler_get_data.3http.html */
  Pointer nng_http_handler_get_data(nng_http_handler handler);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_handler_set_data.3http.html */
  int nng_http_handler_set_data(nng_http_handler handler, Pointer data, nng_voidCb dtor);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_handler_set_host.3http.html */
  int nng_http_handler_set_host(nng_http_handler handler, String host);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_handler_set_method.3http.html */
  int nng_http_handler_set_method(nng_http_handler handler, String method);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_handler_set_tree.3http.html */
  int nng_http_handler_set_tree(nng_http_handler handler);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_hijack.3http.html */
  void nng_http_hijack(nng_http_conn conn);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_add_handler.3http.html */
  int nng_http_server_add_handler(nng_http_server s, nng_http_handler h);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_del_handler.3http.html */
  int nng_http_server_del_handler(nng_http_server s, nng_http_handler h);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_get_tls.3http.html */
  int nng_http_server_get_tls(nng_http_server s, nng_tls_config[] cfgp);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_hold.3http.html */
  int nng_http_server_hold(nng_http_server[] serverp, nng_url url);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_release.3http.html */
  void nng_http_server_release(nng_http_server server);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_set_error_file.3http.html */
  int nng_http_server_set_error_file(nng_http_server server, uint16_t code, String path);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_set_error_page.3http.html */
  int nng_http_server_set_error_page(nng_http_server server, uint16_t code, String html);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_set_tls.3http.html */
  int nng_http_server_set_tls(nng_http_server s, nng_tls_config cfg);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_res_error.3http.html */
  int nng_http_server_res_error(nng_http_server server, nng_http_res response);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_start.3http.html */
  int nng_http_server_start(nng_http_server server);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_http_server_stop.3http.html */
  void nng_http_server_stop(nng_http_server server);
  
  
  // TLS Configuration Objects
  // #include <nng/supplemental/tls/tls.h>
  
  /** https://nanomsg.github.io/nng/man/tip/nng_tls_config_alloc.3tls.html */
  int nng_tls_config_alloc(nng_tls_config[] cfgp, nng_tls_mode mode);
	
  /** https://nanomsg.github.io/nng/man/tip/nng_tls_config_auth_mode.3tls.html */
  int nng_tls_config_auth_mode(nng_tls_config cfg, nng_tls_auth_mode mode);

  /** https://nanomsg.github.io/nng/man/tip/nng_tls_config_ca_chain.3tls.html */
  int nng_tls_config_ca_cert(nng_tls_config cfg, String chain, String crl);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_tls_config_ca_file.3tls.html */
  int nng_tls_config_ca_file(nng_tls_config cfg, String path);

  /** https://nanomsg.github.io/nng/man/tip/nng_tls_config_cert_key_file.3tls.html */
  int nng_tls_config_cert_key_file(nng_tls_config cfg, String path,
	    String pass);

  /** https://nanomsg.github.io/nng/man/tip/nng_tls_config_own_cert.3tls.html */
  int nng_tls_config_own_cert(nng_tls_config cfg, String cert, String key, String pass);
  
  /** https://nanomsg.github.io/nng/man/tip/nng_tls_config_free.3tls.html */
  void nng_tls_config_free(nng_tls_config cfg);

  /** https://nanomsg.github.io/nng/man/tip/nng_tls_config_server_name.3tls.html */
  int nng_tls_config_server_name(nng_tls_config cfg, String name);
  
}
