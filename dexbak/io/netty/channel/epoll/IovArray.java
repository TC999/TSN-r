package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        int i = addressSize * 2;
        IOV_SIZE = i;
        CAPACITY = Native.IOV_MAX * i;
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
    public long memoryAddress(int i) {
        return this.memoryAddress + (IOV_SIZE * i);
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
    public long processWritten(int i, long j) {
        long memoryAddress = memoryAddress(i);
        int i2 = ADDRESS_SIZE;
        long j2 = i2 + memoryAddress;
        if (i2 == 8) {
            long j3 = PlatformDependent.getLong(j2);
            if (j3 > j) {
                PlatformDependent.putLong(memoryAddress, PlatformDependent.getLong(memoryAddress) + j);
                PlatformDependent.putLong(j2, j3 - j);
                return -1L;
            }
            return j3;
        }
        long j4 = PlatformDependent.getInt(j2);
        if (j4 > j) {
            PlatformDependent.putInt(memoryAddress, (int) (PlatformDependent.getInt(memoryAddress) + j));
            PlatformDependent.putInt(j2, (int) (j4 - j));
            return -1L;
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        PlatformDependent.freeMemory(this.memoryAddress);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long size() {
        return this.size;
    }

    private boolean add(long j, int i, int i2) {
        if (i2 == 0) {
            return true;
        }
        int i3 = this.count;
        this.count = i3 + 1;
        long memoryAddress = memoryAddress(i3);
        int i4 = ADDRESS_SIZE;
        long j2 = i4 + memoryAddress;
        long j3 = i2;
        long j4 = this.size;
        if (Native.SSIZE_MAX - j3 < j4) {
            return false;
        }
        this.size = j4 + j3;
        if (i4 == 8) {
            PlatformDependent.putLong(memoryAddress, j + i);
            PlatformDependent.putLong(j2, j3);
            return true;
        }
        PlatformDependent.putInt(memoryAddress, ((int) j) + i);
        PlatformDependent.putInt(j2, i2);
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
