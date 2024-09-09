package io.netty.channel.kqueue;

import io.netty.channel.unix.Buffer;
import io.netty.channel.unix.Limits;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class NativeLongArray {
    private int capacity;
    private ByteBuffer memory;
    private long memoryAddress;
    private int size;

    NativeLongArray(int i4) {
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
        return i4 * Limits.SIZEOF_JLONG;
    }

    private static int idx(int i4) {
        return i4 * Limits.SIZEOF_JLONG;
    }

    private long memoryOffset(int i4) {
        return this.memoryAddress + idx(i4);
    }

    private void reallocIfNeeded() {
        int i4 = this.size;
        int i5 = this.capacity;
        if (i4 == i5) {
            int i6 = i5 <= 65536 ? i5 << 1 : (i5 + i5) >> 1;
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i6));
            this.memory.position(0).limit(this.size);
            allocateDirectWithNativeOrder.put(this.memory);
            allocateDirectWithNativeOrder.position(0);
            Buffer.free(this.memory);
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
            this.capacity = i6;
        }
    }

    void add(long j4) {
        reallocIfNeeded();
        if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putLong(memoryOffset(this.size), j4);
        } else {
            this.memory.putLong(idx(this.size), j4);
        }
        this.size++;
    }

    void clear() {
        this.size = 0;
    }

    void free() {
        Buffer.free(this.memory);
        this.memoryAddress = 0L;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    long memoryAddress() {
        return this.memoryAddress;
    }

    long memoryAddressEnd() {
        return memoryOffset(this.size);
    }

    int size() {
        return this.size;
    }

    public String toString() {
        return "memoryAddress: " + this.memoryAddress + " capacity: " + this.capacity + " size: " + this.size;
    }
}
