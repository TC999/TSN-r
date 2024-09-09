package io.netty.channel.unix;

import io.netty.channel.unix.Errors;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FileDescriptor {
    private static final Errors.NativeIoException READ_ADDRESS_CONNECTION_RESET_EXCEPTION;
    private static final Errors.NativeIoException READ_CONNECTION_RESET_EXCEPTION;
    private static final int STATE_ALL_MASK = 7;
    private static final int STATE_CLOSED_MASK = 1;
    private static final int STATE_INPUT_SHUTDOWN_MASK = 2;
    private static final int STATE_OUTPUT_SHUTDOWN_MASK = 4;
    private static final Errors.NativeIoException WRITEV_ADDRESSES_CONNECTION_RESET_EXCEPTION;
    private static final Errors.NativeIoException WRITEV_CONNECTION_RESET_EXCEPTION;
    private static final Errors.NativeIoException WRITE_ADDRESS_CONNECTION_RESET_EXCEPTION;
    private static final Errors.NativeIoException WRITE_CONNECTION_RESET_EXCEPTION;
    private static final AtomicIntegerFieldUpdater<FileDescriptor> stateUpdater;
    final int fd;
    volatile int state;
    private static final ClosedChannelException WRITE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "write(...)");
    private static final ClosedChannelException WRITE_ADDRESS_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "writeAddress(...)");
    private static final ClosedChannelException WRITEV_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "writev(...)");
    private static final ClosedChannelException WRITEV_ADDRESSES_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "writevAddresses(...)");
    private static final ClosedChannelException READ_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "read(...)");
    private static final ClosedChannelException READ_ADDRESS_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "readAddress(...)");

    static {
        int i4 = Errors.ERRNO_EPIPE_NEGATIVE;
        WRITE_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:write(...)", i4), FileDescriptor.class, "write(...)");
        WRITE_ADDRESS_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:write(...)", i4), FileDescriptor.class, "writeAddress(...)");
        WRITEV_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:writev(...)", i4), FileDescriptor.class, "writev(...)");
        WRITEV_ADDRESSES_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:writev(...)", i4), FileDescriptor.class, "writeAddresses(...)");
        int i5 = Errors.ERRNO_ECONNRESET_NEGATIVE;
        READ_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:read(...)", i5), FileDescriptor.class, "read(...)");
        READ_ADDRESS_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:read(...)", i5), FileDescriptor.class, "readAddress(...)");
        AtomicIntegerFieldUpdater<FileDescriptor> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(FileDescriptor.class, "state");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(FileDescriptor.class, "state");
        }
        stateUpdater = newAtomicIntegerFieldUpdater;
    }

    public FileDescriptor(int i4) {
        if (i4 >= 0) {
            this.fd = i4;
            return;
        }
        throw new IllegalArgumentException("fd must be >= 0");
    }

    private static native int close(int i4);

    public static FileDescriptor from(String str) throws IOException {
        ObjectUtil.checkNotNull(str, "path");
        int open = open(str);
        if (open >= 0) {
            return new FileDescriptor(open);
        }
        throw Errors.newIOException("open", open);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int inputShutdown(int i4) {
        return i4 | 2;
    }

    static boolean isClosed(int i4) {
        return (i4 & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isInputShutdown(int i4) {
        return (i4 & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isOutputShutdown(int i4) {
        return (i4 & 4) != 0;
    }

    private static native long newPipe();

    private static native int open(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int outputShutdown(int i4) {
        return i4 | 4;
    }

    public static FileDescriptor[] pipe() throws IOException {
        long newPipe = newPipe();
        if (newPipe >= 0) {
            return new FileDescriptor[]{new FileDescriptor((int) (newPipe >>> 32)), new FileDescriptor((int) newPipe)};
        }
        throw Errors.newIOException("newPipe", (int) newPipe);
    }

    private static native int read(int i4, ByteBuffer byteBuffer, int i5, int i6);

    private static native int readAddress(int i4, long j4, int i5, int i6);

    private static native int write(int i4, ByteBuffer byteBuffer, int i5, int i6);

    private static native int writeAddress(int i4, long j4, int i5, int i6);

    private static native long writev(int i4, ByteBuffer[] byteBufferArr, int i5, int i6);

    private static native long writevAddresses(int i4, long j4, int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean casState(int i4, int i5) {
        return stateUpdater.compareAndSet(this, i4, i5);
    }

    public void close() throws IOException {
        int i4;
        do {
            i4 = this.state;
            if (isClosed(i4)) {
                return;
            }
        } while (!casState(i4, i4 | 7));
        int close = close(this.fd);
        if (close < 0) {
            throw Errors.newIOException("close", close);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FileDescriptor) && this.fd == ((FileDescriptor) obj).fd;
    }

    public int hashCode() {
        return this.fd;
    }

    public int intValue() {
        return this.fd;
    }

    public boolean isOpen() {
        return !isClosed(this.state);
    }

    public final int read(ByteBuffer byteBuffer, int i4, int i5) throws IOException {
        int read = read(this.fd, byteBuffer, i4, i5);
        if (read > 0) {
            return read;
        }
        if (read == 0) {
            return -1;
        }
        return Errors.ioResult("read", read, READ_CONNECTION_RESET_EXCEPTION, READ_CLOSED_CHANNEL_EXCEPTION);
    }

    public final int readAddress(long j4, int i4, int i5) throws IOException {
        int readAddress = readAddress(this.fd, j4, i4, i5);
        if (readAddress > 0) {
            return readAddress;
        }
        if (readAddress == 0) {
            return -1;
        }
        return Errors.ioResult("readAddress", readAddress, READ_ADDRESS_CONNECTION_RESET_EXCEPTION, READ_ADDRESS_CLOSED_CHANNEL_EXCEPTION);
    }

    public String toString() {
        return "FileDescriptor{fd=" + this.fd + '}';
    }

    public final int write(ByteBuffer byteBuffer, int i4, int i5) throws IOException {
        int write = write(this.fd, byteBuffer, i4, i5);
        return write >= 0 ? write : Errors.ioResult("write", write, WRITE_CONNECTION_RESET_EXCEPTION, WRITE_CLOSED_CHANNEL_EXCEPTION);
    }

    public final int writeAddress(long j4, int i4, int i5) throws IOException {
        int writeAddress = writeAddress(this.fd, j4, i4, i5);
        return writeAddress >= 0 ? writeAddress : Errors.ioResult("writeAddress", writeAddress, WRITE_ADDRESS_CONNECTION_RESET_EXCEPTION, WRITE_ADDRESS_CLOSED_CHANNEL_EXCEPTION);
    }

    public final long writev(ByteBuffer[] byteBufferArr, int i4, int i5) throws IOException {
        long writev = writev(this.fd, byteBufferArr, i4, i5);
        return writev >= 0 ? writev : Errors.ioResult("writev", (int) writev, WRITEV_CONNECTION_RESET_EXCEPTION, WRITEV_CLOSED_CHANNEL_EXCEPTION);
    }

    public final long writevAddresses(long j4, int i4) throws IOException {
        long writevAddresses = writevAddresses(this.fd, j4, i4);
        return writevAddresses >= 0 ? writevAddresses : Errors.ioResult("writevAddresses", (int) writevAddresses, WRITEV_ADDRESSES_CONNECTION_RESET_EXCEPTION, WRITEV_ADDRESSES_CLOSED_CHANNEL_EXCEPTION);
    }

    public static FileDescriptor from(File file) throws IOException {
        return from(((File) ObjectUtil.checkNotNull(file, "file")).getPath());
    }
}
