package io.netty.channel.epoll;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class EpollEventArray {
    private int length;
    private long memoryAddress;
    private static final int EPOLL_EVENT_SIZE = Native.sizeofEpollEvent();
    private static final int EPOLL_DATA_OFFSET = Native.offsetofEpollData();

    /* JADX INFO: Access modifiers changed from: package-private */
    public EpollEventArray(int i4) {
        if (i4 >= 1) {
            this.length = i4;
            this.memoryAddress = allocate(i4);
            return;
        }
        throw new IllegalArgumentException("length must be >= 1 but was " + i4);
    }

    private static long allocate(int i4) {
        return PlatformDependent.allocateMemory(i4 * EPOLL_EVENT_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int events(int i4) {
        return PlatformDependent.getInt(this.memoryAddress + (i4 * EPOLL_EVENT_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int fd(int i4) {
        return PlatformDependent.getInt(this.memoryAddress + (i4 * EPOLL_EVENT_SIZE) + EPOLL_DATA_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free() {
        PlatformDependent.freeMemory(this.memoryAddress);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void increase() {
        this.length <<= 1;
        free();
        this.memoryAddress = allocate(this.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int length() {
        return this.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long memoryAddress() {
        return this.memoryAddress;
    }
}
