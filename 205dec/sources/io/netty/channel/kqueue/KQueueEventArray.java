package io.netty.channel.kqueue;

import io.netty.channel.unix.Buffer;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class KQueueEventArray {
    private int capacity;
    private ByteBuffer memory;
    private long memoryAddress;
    private int size;
    private static final int KQUEUE_EVENT_SIZE = Native.sizeofKEvent();
    private static final int KQUEUE_IDENT_OFFSET = Native.offsetofKEventIdent();
    private static final int KQUEUE_FILTER_OFFSET = Native.offsetofKEventFilter();
    private static final int KQUEUE_FFLAGS_OFFSET = Native.offsetofKEventFFlags();
    private static final int KQUEUE_FLAGS_OFFSET = Native.offsetofKEventFlags();
    private static final int KQUEUE_DATA_OFFSET = Native.offsetofKeventData();

    /* JADX INFO: Access modifiers changed from: package-private */
    public KQueueEventArray(int i4) {
        if (i4 >= 1) {
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i4));
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
            this.capacity = i4;
            return;
        }
        throw new IllegalArgumentException("capacity must be >= 1 but was " + i4);
    }

    private static int calculateBufferCapacity(int i4) {
        return i4 * KQUEUE_EVENT_SIZE;
    }

    private static native void evSet(long j4, int i4, short s3, short s4, int i5);

    private static int getKEventOffset(int i4) {
        return i4 * KQUEUE_EVENT_SIZE;
    }

    private long getKEventOffsetAddress(int i4) {
        return getKEventOffset(i4) + this.memoryAddress;
    }

    private short getShort(int i4, int i5) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getShort(getKEventOffsetAddress(i4) + i5);
        }
        return this.memory.getShort(getKEventOffset(i4) + i5);
    }

    private void reallocIfNeeded() {
        if (this.size == this.capacity) {
            realloc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int capacity() {
        return this.capacity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.size = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long data(int i4) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getLong(getKEventOffsetAddress(i4) + KQUEUE_DATA_OFFSET);
        }
        return this.memory.getLong(getKEventOffset(i4) + KQUEUE_DATA_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void evSet(AbstractKQueueChannel abstractKQueueChannel, short s3, short s4, int i4) {
        reallocIfNeeded();
        int i5 = this.size;
        this.size = i5 + 1;
        evSet(getKEventOffset(i5) + this.memoryAddress, abstractKQueueChannel.socket.intValue(), s3, s4, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fd(int i4) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getInt(getKEventOffsetAddress(i4) + KQUEUE_IDENT_OFFSET);
        }
        return this.memory.getInt(getKEventOffset(i4) + KQUEUE_IDENT_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short fflags(int i4) {
        return getShort(i4, KQUEUE_FFLAGS_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short filter(int i4) {
        return getShort(i4, KQUEUE_FILTER_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short flags(int i4) {
        return getShort(i4, KQUEUE_FLAGS_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free() {
        Buffer.free(this.memory);
        this.capacity = 0;
        this.size = 0;
        this.memoryAddress = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long memoryAddress() {
        return this.memoryAddress;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void realloc(boolean z3) {
        int i4 = this.capacity;
        int i5 = i4 <= 65536 ? i4 << 1 : (i4 + i4) >> 1;
        try {
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i5));
            this.memory.position(0).limit(this.size);
            allocateDirectWithNativeOrder.put(this.memory);
            allocateDirectWithNativeOrder.position(0);
            Buffer.free(this.memory);
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
        } catch (OutOfMemoryError e4) {
            if (z3) {
                OutOfMemoryError outOfMemoryError = new OutOfMemoryError("unable to allocate " + i5 + " new bytes! Existing capacity is: " + this.capacity);
                outOfMemoryError.initCause(e4);
                throw outOfMemoryError;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return this.size;
    }
}
