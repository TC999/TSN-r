package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Errors {
    public static final int ERRNO_ENOTCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoENOTCONN();
    public static final int ERRNO_EBADF_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEBADF();
    public static final int ERRNO_EPIPE_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEPIPE();
    public static final int ERRNO_ECONNRESET_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoECONNRESET();
    public static final int ERRNO_EAGAIN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEAGAIN();
    public static final int ERRNO_EWOULDBLOCK_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEWOULDBLOCK();
    public static final int ERRNO_EINPROGRESS_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEINPROGRESS();
    public static final int ERROR_ECONNREFUSED_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorECONNREFUSED();
    public static final int ERROR_EISCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEISCONN();
    public static final int ERROR_EALREADY_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEALREADY();
    public static final int ERROR_ENETUNREACH_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorENETUNREACH();
    private static final String[] ERRORS = new String[512];

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static final class NativeConnectException extends ConnectException {
        private static final long serialVersionUID = -5532328671712318161L;
        private final int expectedErr;

        /* JADX INFO: Access modifiers changed from: package-private */
        public NativeConnectException(String str, int i) {
            super(str);
            this.expectedErr = i;
        }

        int expectedErr() {
            return this.expectedErr;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class NativeIoException extends IOException {
        private static final long serialVersionUID = 8222160204268655526L;
        private final int expectedErr;

        public NativeIoException(String str, int i) {
            super(str);
            this.expectedErr = i;
        }

        public int expectedErr() {
            return this.expectedErr;
        }
    }

    static {
        int i = 0;
        while (true) {
            String[] strArr = ERRORS;
            if (i >= strArr.length) {
                return;
            }
            strArr[i] = ErrorsStaticallyReferencedJniMethods.strError(i);
            i++;
        }
    }

    private Errors() {
    }

    public static int ioResult(String str, int i, NativeIoException nativeIoException, ClosedChannelException closedChannelException) throws IOException {
        if (i == ERRNO_EAGAIN_NEGATIVE || i == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (i != nativeIoException.expectedErr()) {
            if (i != ERRNO_EBADF_NEGATIVE) {
                if (i == ERRNO_ENOTCONN_NEGATIVE) {
                    throw new NotYetConnectedException();
                }
                throw newIOException(str, i);
            }
            throw closedChannelException;
        }
        throw nativeIoException;
    }

    public static NativeIoException newConnectionResetException(String str, int i) {
        NativeIoException newIOException = newIOException(str, i);
        newIOException.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
        return newIOException;
    }

    public static NativeIoException newIOException(String str, int i) {
        return new NativeIoException(str + "() failed: " + ERRORS[-i], i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwConnectException(String str, NativeConnectException nativeConnectException, int i) throws IOException {
        if (i != nativeConnectException.expectedErr()) {
            if (i != ERROR_EALREADY_NEGATIVE) {
                if (i != ERROR_ENETUNREACH_NEGATIVE) {
                    if (i == ERROR_EISCONN_NEGATIVE) {
                        throw new AlreadyConnectedException();
                    }
                    throw new ConnectException(str + "() failed: " + ERRORS[-i]);
                }
                throw new NoRouteToHostException();
            }
            throw new ConnectionPendingException();
        }
        throw nativeConnectException;
    }
}
