package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class SocketWritableByteChannel implements WritableByteChannel {
    private final FileDescriptor fd;

    /* JADX INFO: Access modifiers changed from: protected */
    public SocketWritableByteChannel(FileDescriptor fileDescriptor) {
        this.fd = (FileDescriptor) ObjectUtil.checkNotNull(fileDescriptor, "fd");
    }

    protected abstract ByteBufAllocator alloc();

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.fd.close();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.fd.isOpen();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) throws IOException {
        int write;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            write = this.fd.write(byteBuffer, position, byteBuffer.limit());
        } else {
            int i4 = limit - position;
            ByteBuf byteBuf = null;
            try {
                if (i4 == 0) {
                    byteBuf = Unpooled.EMPTY_BUFFER;
                } else {
                    ByteBufAllocator alloc = alloc();
                    if (alloc.isDirectBufferPooled()) {
                        byteBuf = alloc.directBuffer(i4);
                    } else {
                        byteBuf = ByteBufUtil.threadLocalDirectBuffer();
                        if (byteBuf == null) {
                            byteBuf = Unpooled.directBuffer(i4);
                        }
                    }
                }
                byteBuf.writeBytes(byteBuffer.duplicate());
                ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), i4);
                write = this.fd.write(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
                byteBuf.release();
            } catch (Throwable th) {
                if (byteBuf != null) {
                    byteBuf.release();
                }
                throw th;
            }
        }
        if (write > 0) {
            byteBuffer.position(position + write);
        }
        return write;
    }
}
