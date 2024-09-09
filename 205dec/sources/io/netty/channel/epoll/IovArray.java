package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class IovArray implements ChannelOutboundBuffer.MessageProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE;
    private static final int CAPACITY;
    private static final int IOV_SIZE;
    private int count;
    private final long memoryAddress = PlatformDependent.allocateMemory(CAPACITY);
    private long size;

    static {
        int addressSize = PlatformDependent.addressSize();
        ADDRESS_SIZE = addressSize;
        int i4 = addressSize * 2;
        IOV_SIZE = i4;
        CAPACITY = Native.IOV_MAX * i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean add(ByteBuf byteBuf) {
        if (this.count == Native.IOV_MAX) {
            return false;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return true;
        }
        return add(byteBuf.memoryAddress(), byteBuf.readerIndex(), readableBytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.count = 0;
        this.size = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int count() {
        return this.count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long memoryAddress(int i4) {
        return this.memoryAddress + (IOV_SIZE * i4);
    }

    @Override // io.netty.channel.ChannelOutboundBuffer.MessageProcessor
    public boolean processMessage(Object obj) throws Exception {
        if (obj instanceof ByteBuf) {
            if (obj instanceof CompositeByteBuf) {
                return add((CompositeByteBuf) obj);
            }
            return add((ByteBuf) obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long processWritten(int i4, long j4) {
        long memoryAddress = memoryAddress(i4);
        int i5 = ADDRESS_SIZE;
        long j5 = i5 + memoryAddress;
        if (i5 == 8) {
            long j6 = PlatformDependent.getLong(j5);
            if (j6 > j4) {
                PlatformDependent.putLong(memoryAddress, PlatformDependent.getLong(memoryAddress) + j4);
                PlatformDependent.putLong(j5, j6 - j4);
                return -1L;
            }
            return j6;
        }
        long j7 = PlatformDependent.getInt(j5);
        if (j7 > j4) {
            PlatformDependent.putInt(memoryAddress, (int) (PlatformDependent.getInt(memoryAddress) + j4));
            PlatformDependent.putInt(j5, (int) (j7 - j4));
            return -1L;
        }
        return j7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        PlatformDependent.freeMemory(this.memoryAddress);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long size() {
        return this.size;
    }

    private boolean add(long j4, int i4, int i5) {
        if (i5 == 0) {
            return true;
        }
        int i6 = this.count;
        this.count = i6 + 1;
        long memoryAddress = memoryAddress(i6);
        int i7 = ADDRESS_SIZE;
        long j5 = i7 + memoryAddress;
        long j6 = i5;
        long j7 = this.size;
        if (Native.SSIZE_MAX - j6 < j7) {
            return false;
        }
        this.size = j7 + j6;
        if (i7 == 8) {
            PlatformDependent.putLong(memoryAddress, j4 + i4);
            PlatformDependent.putLong(j5, j6);
            return true;
        }
        PlatformDependent.putInt(memoryAddress, ((int) j4) + i4);
        PlatformDependent.putInt(j5, i5);
        return true;
    }

    boolean add(CompositeByteBuf compositeByteBuf) {
        ByteBuffer[] nioBuffers = compositeByteBuf.nioBuffers();
        if (this.count + nioBuffers.length >= Native.IOV_MAX) {
            return false;
        }
        for (ByteBuffer byteBuffer : nioBuffers) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit() - byteBuffer.position();
            if (limit != 0 && !add(PlatformDependent.directBufferAddress(byteBuffer), position, limit)) {
                return false;
            }
        }
        return true;
    }
}
