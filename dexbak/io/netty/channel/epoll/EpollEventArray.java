package io.netty.channel.epoll;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class EpollEventArray {
    private int length;
    private long memoryAddress;
    private static final int EPOLL_EVENT_SIZE = Native.sizeofEpollEvent();
    private static final int EPOLL_DATA_OFFSET = Native.offsetofEpollData();

    /* JADX INFO: Access modifiers changed from: package-private */
    public EpollEventArray(int i) {
        if (i >= 1) {
            this.length = i;
            this.memoryAddress = allocate(i);
            return;
        }
        throw new IllegalArgumentException("length must be >= 1 but was " + i);
    }

    private static long allocate(int i) {
        return PlatformDependent.allocateMemory(i * EPOLL_EVENT_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int events(int i) {
        return PlatformDependent.getInt(this.memoryAddress + (i * EPOLL_EVENT_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: fd */
    public int m12691fd(int i) {
        return PlatformDependent.getInt(this.memoryAddress + (i * EPOLL_EVENT_SIZE) + EPOLL_DATA_OFFSET);
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
