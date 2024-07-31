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
import master.flame.danmaku.danmaku.parser.IDataSource;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    /* renamed from: fd */
    final int f40194fd;
    volatile int state;
    private static final ClosedChannelException WRITE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "write(...)");
    private static final ClosedChannelException WRITE_ADDRESS_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "writeAddress(...)");
    private static final ClosedChannelException WRITEV_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "writev(...)");
    private static final ClosedChannelException WRITEV_ADDRESSES_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "writevAddresses(...)");
    private static final ClosedChannelException READ_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "read(...)");
    private static final ClosedChannelException READ_ADDRESS_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), FileDescriptor.class, "readAddress(...)");

    static {
        int i = Errors.ERRNO_EPIPE_NEGATIVE;
        WRITE_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:write(...)", i), FileDescriptor.class, "write(...)");
        WRITE_ADDRESS_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:write(...)", i), FileDescriptor.class, "writeAddress(...)");
        WRITEV_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:writev(...)", i), FileDescriptor.class, "writev(...)");
        WRITEV_ADDRESSES_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:writev(...)", i), FileDescriptor.class, "writeAddresses(...)");
        int i2 = Errors.ERRNO_ECONNRESET_NEGATIVE;
        READ_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:read(...)", i2), FileDescriptor.class, "read(...)");
        READ_ADDRESS_CONNECTION_RESET_EXCEPTION = (Errors.NativeIoException) ThrowableUtil.unknownStackTrace(Errors.newConnectionResetException("syscall:read(...)", i2), FileDescriptor.class, "readAddress(...)");
        AtomicIntegerFieldUpdater<FileDescriptor> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(FileDescriptor.class, "state");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(FileDescriptor.class, "state");
        }
        stateUpdater = newAtomicIntegerFieldUpdater;
    }

    public FileDescriptor(int i) {
        if (i >= 0) {
            this.f40194fd = i;
            return;
        }
        throw new IllegalArgumentException("fd must be >= 0");
    }

    private static native int close(int i);

    public static FileDescriptor from(String str) throws IOException {
        ObjectUtil.checkNotNull(str, "path");
        int open = open(str);
        if (open >= 0) {
            return new FileDescriptor(open);
        }
        throw Errors.newIOException("open", open);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int inputShutdown(int i) {
        return i | 2;
    }

    static boolean isClosed(int i) {
        return (i & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isInputShutdown(int i) {
        return (i & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isOutputShutdown(int i) {
        return (i & 4) != 0;
    }

    private static native long newPipe();

    private static native int open(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int outputShutdown(int i) {
        return i | 4;
    }

    public static FileDescriptor[] pipe() throws IOException {
        long newPipe = newPipe();
        if (newPipe >= 0) {
            return new FileDescriptor[]{new FileDescriptor((int) (newPipe >>> 32)), new FileDescriptor((int) newPipe)};
        }
        throw Errors.newIOException("newPipe", (int) newPipe);
    }

    private static native int read(int i, ByteBuffer byteBuffer, int i2, int i3);

    private static native int readAddress(int i, long j, int i2, int i3);

    private static native int write(int i, ByteBuffer byteBuffer, int i2, int i3);

    private static native int writeAddress(int i, long j, int i2, int i3);

    private static native long writev(int i, ByteBuffer[] byteBufferArr, int i2, int i3);

    private static native long writevAddresses(int i, long j, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean casState(int i, int i2) {
        return stateUpdater.compareAndSet(this, i, i2);
    }

    public void close() throws IOException {
        int i;
        do {
            i = this.state;
            if (isClosed(i)) {
                return;
            }
        } while (!casState(i, i | 7));
        int close = close(this.f40194fd);
        if (close < 0) {
            throw Errors.newIOException("close", close);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FileDescriptor) && this.f40194fd == ((FileDescriptor) obj).f40194fd;
    }

    public int hashCode() {
        return this.f40194fd;
    }

    public int intValue() {
        return this.f40194fd;
    }

    public boolean isOpen() {
        return !isClosed(this.state);
    }

    public final int read(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        int read = read(this.f40194fd, byteBuffer, i, i2);
        if (read > 0) {
            return read;
        }
        if (read == 0) {
            return -1;
        }
        return Errors.ioResult("read", read, READ_CONNECTION_RESET_EXCEPTION, READ_CLOSED_CHANNEL_EXCEPTION);
    }

    public final int readAddress(long j, int i, int i2) throws IOException {
        int readAddress = readAddress(this.f40194fd, j, i, i2);
        if (readAddress > 0) {
            return readAddress;
        }
        if (readAddress == 0) {
            return -1;
        }
        return Errors.ioResult("readAddress", readAddress, READ_ADDRESS_CONNECTION_RESET_EXCEPTION, READ_ADDRESS_CLOSED_CHANNEL_EXCEPTION);
    }

    public String toString() {
        return "FileDescriptor{fd=" + this.f40194fd + '}';
    }

    public final int write(ByteBuffer byteBuffer, int i, int i2) throws IOException {
        int write = write(this.f40194fd, byteBuffer, i, i2);
        return write >= 0 ? write : Errors.ioResult("write", write, WRITE_CONNECTION_RESET_EXCEPTION, WRITE_CLOSED_CHANNEL_EXCEPTION);
    }

    public final int writeAddress(long j, int i, int i2) throws IOException {
        int writeAddress = writeAddress(this.f40194fd, j, i, i2);
        return writeAddress >= 0 ? writeAddress : Errors.ioResult("writeAddress", writeAddress, WRITE_ADDRESS_CONNECTION_RESET_EXCEPTION, WRITE_ADDRESS_CLOSED_CHANNEL_EXCEPTION);
    }

    public final long writev(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        long writev = writev(this.f40194fd, byteBufferArr, i, i2);
        return writev >= 0 ? writev : Errors.ioResult("writev", (int) writev, WRITEV_CONNECTION_RESET_EXCEPTION, WRITEV_CLOSED_CHANNEL_EXCEPTION);
    }

    public final long writevAddresses(long j, int i) throws IOException {
        long writevAddresses = writevAddresses(this.f40194fd, j, i);
        return writevAddresses >= 0 ? writevAddresses : Errors.ioResult("writevAddresses", (int) writevAddresses, WRITEV_ADDRESSES_CONNECTION_RESET_EXCEPTION, WRITEV_ADDRESSES_CLOSED_CHANNEL_EXCEPTION);
    }

    public static FileDescriptor from(File file) throws IOException {
        return from(((File) ObjectUtil.checkNotNull(file, IDataSource.f43973c)).getPath());
    }
}
