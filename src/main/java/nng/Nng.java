package nng;

import com.sun.jna.Native;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import nng.exceptions.EAgainException;
import nng.exceptions.IOException;

import java.util.HashMap;
import java.util.Map;

public final class Nng {
  public static int NN_MSG = -1;

  /* Low level native interface wrapper */

  public static final int getErrorNumber() {
    return NngNativeLibrary.nng_errno();
  }

  public static final String getError() {
    final int currentError = Nng.getErrorNumber();
    return NngNativeLibrary.nng_strerror(currentError);
  }

  public static void handleError(int rc) {
    final int errno = getErrorNumber();
    final String msg = getError();

    if (errno == Error.EAGAIN.value()) {
      throw new EAgainException(msg, errno);
    } else {
      throw new NngException(msg, errno);
    }
  }



  public static final void terminate() {
    NngNativeLibrary.nng_term();
  }

  private static final Map<String, Integer> getSymbols() {
    HashMap<String, Integer> result = new HashMap<String, Integer>();

    int index = 0;
    while (true) {
      IntByReference valueRef = new IntByReference();
      Pointer ptr = NngNativeLibrary.nng_symbol(index, valueRef);

      if (ptr == null) {
        break;
      }

      result.put(ptr.getString(0), valueRef.getValue());
      index += 1;
    }

    return result;
  }

  public static final Map<String, Integer> nn_symbols = Nng.getSymbols();

  public enum Domain {
    AF_SP,
    AF_SP_RAW;

    public Integer value() {
      return nn_symbols.get(name());
    }
  }

  public enum SocketType {

    /* PubSub */
    NN_PUB,
    NN_SUB,

    /* ReqRep */
    NN_REQ,
    NN_REP,

    /* Pipeline */
    NN_PUSH,
    NN_PULL,

    /* Bus */
    NN_BUS,

    /* Pair */
    NN_PAIR;

    public Integer value() {
      return nn_symbols.get(name());
    }
  }

  public enum SocketOption {
    NN_SUB_UNSUBSCRIBE,
    NN_SUB_SUBSCRIBE,
    NN_SNDFD,
    NN_RCVFD,
    NN_LINGER,
    NN_SNDBUF,
    NN_RCVBUF,
    NN_RCVMAXSIZE,
    NN_SNDTIMEO,
    NN_RCVTIMEO,
    NN_RECONNECT_IVL,
    NN_RECONNECT_IVL_MAX,
    NN_SNDPRIO,
    NN_RCVPRIO,
    NN_IPV4ONLY,
    NN_SOCKET_NAME;

    public Integer value() {
      return nn_symbols.get(name());
    }
  }

  public enum SocketFlag {
    NN_DONTWAIT;

    public Integer value() {
      return nn_symbols.get(name());
    }
  }

  public enum OptionLevel {
    NN_SOL_SOCKET,
    NN_TCP;
    public Integer value() {
      return nn_symbols.get(name());
    }
  }

  public enum Error {
    EAFNOSUPPORT,
    ETERM,
    EFSM,
    EAGAIN,
    ECONNREFUSED;
    public Integer value() {
      return nn_symbols.get(name());
    }
  }
}
