package nng;

import static nng.Nng.NN_MSG;
import static nng.Nng.SocketOption.*;
import static nng.NngNativeLibrary.*;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.EnumSet;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import nng.Nng.Domain;
import nng.Nng.Error;
import nng.Nng.OptionLevel;
import nng.Nng.SocketFlag;
import nng.Nng.SocketOption;
import nng.Nng.SocketType;
import nng.exception.AgainException;
import nng.exception.NngException;


public class AbstractSocket implements ISocket {
  protected final int fd;
  protected boolean closed = false;
  protected boolean open = false;

  public AbstractSocket(final Domain domain, final SocketType protocol) {
    this.fd = nng_socket(domain.value(), protocol.value());
    this.open = true;

    this.setSocketOpt(SocketOption.NN_SNDTIMEO, 600);
    this.setSocketOpt(SocketOption.NN_RCVTIMEO, 600);
  }

  @Override
  public synchronized void close() throws NngException {
	    if (!this.open) return;
	    if (this.closed) return;
    
	  this.closed = true;
	  final int rc = nng_close(this.fd);
	
	  if (rc < 0) {
	    Nng.handleError(rc);
	  }
  }

	@Override
	public IDialer dial(String url, DialFlag flags) throws NngException {
		// TODO Auto-generated method stub
		return null;
	}


  public synchronized void bind(final String dir) throws NngException {
    final int rc = nn_bind(this.fd, dir);

    if (rc < 0) {
      Nng.handleError(rc);
    }
  }

  public synchronized void connect(final String dir) throws NngException {
    final int rc = nn_connect(this.fd, dir);

    if (rc < 0) {
      Nng.handleError(rc);
    }
  }

  public int send(final String data, final EnumSet<SocketFlag> flags)
    throws NngException {

      final Charset encoding = Charset.forName("UTF-8");
      return this.send(data.getBytes(encoding), flags);
  }

  public int send(final String data)
    throws NngException {

    return this.send(data, EnumSet.noneOf(SocketFlag.class));
  }

  public synchronized int send(final byte[] data, final EnumSet<SocketFlag> flagSet)
    throws NngException {

    int flags = 0;
    if (flagSet.contains(SocketFlag.NN_DONTWAIT)){
      flags |= SocketFlag.NN_DONTWAIT.value();
    }

    final int rc = nn_send(this.fd, data, data.length, flags);

    if (rc < 0) {
      Nng.handleError(rc);
    }

    return rc;
  }

  public int send(final byte[] data) throws NngException {
    return this.send(data, EnumSet.noneOf(SocketFlag.class));
  }

  public String recvString(final EnumSet<SocketFlag> flagSet) throws NngException {
    final byte[] received = this.recvBytes(flagSet);
    final Charset encoding = Charset.forName("UTF-8");
    return new String(received, encoding);
  }

  public String recvString() throws NngException {
    return this.recvString(EnumSet.noneOf(SocketFlag.class));
  }

  public synchronized byte[] recvBytes(final EnumSet<SocketFlag> flagSet)
    throws NngException {

    final PointerByReference ptrBuff = new PointerByReference();

    int flags = 0;
    if (flagSet.contains(SocketFlag.NN_DONTWAIT)){
      flags |= SocketFlag.NN_DONTWAIT.value();
    }

    final int rc = nn_recv(this.fd, ptrBuff, NN_MSG, flags);

    if (rc < 0) {
      Nng.handleError(rc);
    }

    final Pointer result = ptrBuff.getValue();
    final byte[] bytesResult = result.getByteArray(0, rc);

    return bytesResult;
  }

  public byte[] recvBytes() throws NngException {
    return this.recvBytes(EnumSet.noneOf(SocketFlag.class));
  }

  public ByteBuffer recv(final EnumSet<SocketFlag> flagSet) throws NngException {
    final PointerByReference ptrBuff = new PointerByReference();

    int flags = 0;
    if (flagSet.contains(SocketFlag.NN_DONTWAIT)){
      flags |= SocketFlag.NN_DONTWAIT.value();
    }

    final int rc = nn_recv(this.fd, ptrBuff, NN_MSG, flags);

    if (rc < 0) {
      Nng.handleError(rc);
    }

    final Pointer result = ptrBuff.getValue();
    final ByteBuffer buffer = result.getByteBuffer(0, rc);

    return buffer;
  }

  public ByteBuffer recv() throws NngException {
    return this.recv(EnumSet.noneOf(SocketFlag.class));
  }

  public synchronized int send(final ByteBuffer data,
                               final EnumSet<SocketFlag> flagSet)
    throws NngException {

    int flags = 0;
    if (flagSet.contains(SocketFlag.NN_DONTWAIT)){
      flags |= SocketFlag.NN_DONTWAIT.value();
    }

    final int rc = nn_send(this.fd, data, data.limit(), flags);

    if (rc < 0) {
      Nng.handleError(rc);
    }

    return rc;
  }

  public synchronized int send(final ByteBuffer data) throws NngException {
    return this.send(data, EnumSet.noneOf(SocketFlag.class));
  }

  public void subscribe(final String topic)
    throws NngException {

    try {
      this.subscribe(topic.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  public void subscribe(final byte[] topic) throws NngException {
    throw new UnsupportedOperationException("You can use subscribe on this socket.");
  }

  public void unsubscribe(final String topic)
    throws NngException {

    try {
      this.unsubscribe(topic.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  public void unsubscribe(final byte[] topic) throws NngException {
    throw new UnsupportedOperationException("You can use unsubscribe on this socket.");
  }

  public int getFd() {
    return this.fd;
  }

  public int getRcvFd() throws NngException {
    return getSocketFd(SocketOption.NN_RCVFD);
  }

  public int getSndFd() throws NngException {
    return getSocketFd(SocketOption.NN_SNDFD);
  }

  /**
   * Get file descriptor.
   *
   * @return file descriptor.
   */
  private synchronized int getSocketFd(SocketOption opt) throws NngException {
    final int flag = opt.value();
    final IntByReference fd = new IntByReference();
    final IntByReference size_t = new IntByReference(Native.SIZE_T_SIZE);

    final int rc = NngNativeLibrary.nn_getsockopt(this.fd,
                                               OptionLevel.NN_SOL_SOCKET.value(),
                                               flag, fd.getPointer(),
                                               size_t.getPointer());
    if (rc < 0) {
      Nng.handleError(rc);
    }

    return fd.getValue();
  }

  public void setSocketOpt(SocketOption type, Object value){
    int rc = 0;
    int typeVal = type.value();

    final int socket_level = OptionLevel.NN_SOL_SOCKET.value();
    final int sub_level = SocketType.NN_SUB.value();

    switch(type) {
    case NN_LINGER:
    case NN_SNDBUF:
    case NN_RCVBUF:
    case NN_RCVMAXSIZE:
    case NN_SNDTIMEO:
    case NN_RCVTIMEO:
    case NN_RECONNECT_IVL:
    case NN_RECONNECT_IVL_MAX:
    case NN_SNDPRIO:
    case NN_RCVPRIO:
    case NN_IPV4ONLY:
      final IntByReference valueRef = new IntByReference((Integer)value);
      final Pointer valuePtr = valueRef.getPointer();

      rc = nn_setsockopt(this.fd, socket_level, typeVal, valuePtr, 4);
      break;

    case NN_SUB_UNSUBSCRIBE:
    case NN_SUB_SUBSCRIBE:
      {
        byte[] topic;
        if (value instanceof byte[]) {
          topic = (byte[]) value;
        } else if (value instanceof String) {
          try {
            topic = ((String)value).getBytes("UTF-8");
          } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
          }
        } else {
          throw new RuntimeException("Wrong type.");
        }

        final Memory mem = new Memory(topic.length);
        mem.write(0, topic, 0, topic.length);
        rc = nn_setsockopt(this.fd, sub_level, type.value(), mem, topic.length);
      }
      break;

    case NN_SOCKET_NAME:
      {
        byte[] name;
        if (value instanceof byte[]) {
          name = (byte[]) value;
        } else if (value instanceof String) {
          try {
            name = ((String)value).getBytes("UTF-8");
          } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
          }
        } else {
          throw new RuntimeException("Wrong type.");
        }

        final Memory mem = new Memory(name.length);
        mem.write(0, name, 0, name.length);

        rc = nn_setsockopt(this.fd, socket_level, type.value(), mem, name.length);
      }
      break;

    default:
      throw new RuntimeException("Wrong property or value type.");
    }

    if (rc < 0) {
      Nng.handleError(rc);
    }
  }

@Override
public IListener listen(String url, ListenFlag flags) throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Buffer recv(RecvFlag flags) throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void send(Buffer buf, SendFlag flags) throws NngException {
	// TODO Auto-generated method stub
	
}

@Override
public Integer socket_id() throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Object getopt(String opt) throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Boolean getopt(String opt, Boolean val) throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Integer getopt(String opt, Integer val) throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Duration getopt(String opt, Duration val) throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public short[] getopt(String opt, short[] val) throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Size getopt(String opt, Size val) throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getopt(String opt, String val) throws NngException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setopt(String opt) throws NngException {
	// TODO Auto-generated method stub
	
}

@Override
public void setopt(String opt, Boolean val) throws NngException {
	// TODO Auto-generated method stub
	
}

@Override
public void setopt(String opt, Integer val) throws NngException {
	// TODO Auto-generated method stub
	
}

@Override
public void setopt(String opt, Duration val) throws NngException {
	// TODO Auto-generated method stub
	
}

@Override
public void setopt(String opt, short[] val) throws NngException {
	// TODO Auto-generated method stub
	
}

@Override
public void setopt(String opt, Size val) throws NngException {
	// TODO Auto-generated method stub
	
}

@Override
public void setopt(String opt, String val) throws NngException {
	// TODO Auto-generated method stub
	
}

}
