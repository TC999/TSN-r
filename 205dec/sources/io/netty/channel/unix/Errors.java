package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static final class NativeConnectException extends ConnectException {
        private static final long serialVersionUID = -5532328671712318161L;
        private final int expectedErr;

        /* JADX INFO: Access modifiers changed from: package-private */
        public NativeConnectException(String str, int i4) {
            super(str);
            this.expectedErr = i4;
        }

        int expectedErr() {
            return this.expectedErr;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class NativeIoException extends IOException {
        private static final long serialVersionUID = 8222160204268655526L;
        private final int expectedErr;

        public NativeIoException(String str, int i4) {
            super(str);
            this.expectedErr = i4;
        }

        public int expectedErr() {
            return this.expectedErr;
        }
    }

    static {
        int i4 = 0;
        while (true) {
            String[] strArr = ERRORS;
            if (i4 >= strArr.length) {
                return;
            }
            strArr[i4] = ErrorsStaticallyReferencedJniMethods.strError(i4);
            i4++;
        }
    }

    private Errors() {
    }

    public static int ioResult(String str, int i4, NativeIoException nativeIoException, ClosedChannelException closedChannelException) throws IOException {
        if (i4 == ERRNO_EAGAIN_NEGATIVE || i4 == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (i4 != nativeIoException.expectedErr()) {
            if (i4 != ERRNO_EBADF_NEGATIVE) {
                if (i4 == ERRNO_ENOTCONN_NEGATIVE) {
                    throw new NotYetConnectedException();
                }
                throw newIOException(str, i4);
            }
            throw closedChannelException;
        }
        throw nativeIoException;
    }

    public static NativeIoException newConnectionResetException(String str, int i4) {
        NativeIoException newIOException = newIOException(str, i4);
        newIOException.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
        return newIOException;
    }

    public static NativeIoException newIOException(String str, int i4) {
        return new NativeIoException(str + "() failed: " + ERRORS[-i4], i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwConnectException(String str, NativeConnectException nativeConnectException, int i4) throws IOException {
        if (i4 != nativeConnectException.expectedErr()) {
            if (i4 != ERROR_EALREADY_NEGATIVE) {
                if (i4 != ERROR_ENETUNREACH_NEGATIVE) {
                    if (i4 == ERROR_EISCONN_NEGATIVE) {
                        throw new AlreadyConnectedException();
                    }
                    throw new ConnectException(str + "() failed: " + ERRORS[-i4]);
                }
                throw new NoRouteToHostException();
            }
            throw new ConnectionPendingException();
        }
        throw nativeConnectException;
    }
}
