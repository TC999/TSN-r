package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ChunkedNioFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;
    private final FileChannel in;
    private long offset;
    private final long startOffset;

    public ChunkedNioFile(File file) throws IOException {
        this(new FileInputStream(file).getChannel());
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.in.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        return this.offset >= this.endOffset || !this.in.isOpen();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return this.endOffset - this.startOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset - this.startOffset;
    }

    public long startOffset() {
        return this.startOffset;
    }

    public ChunkedNioFile(File file, int i4) throws IOException {
        this(new FileInputStream(file).getChannel(), i4);
    }

    public ChunkedNioFile(FileChannel fileChannel) throws IOException {
        this(fileChannel, 8192);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public ChunkedNioFile(FileChannel fileChannel, int i4) throws IOException {
        this(fileChannel, 0L, fileChannel.size(), i4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        long j4 = this.offset;
        long j5 = this.endOffset;
        if (j4 >= j5) {
            return null;
        }
        int min = (int) Math.min(this.chunkSize, j5 - j4);
        ByteBuf buffer = byteBufAllocator.buffer(min);
        int i4 = 0;
        do {
            try {
                int writeBytes = buffer.writeBytes(this.in, min - i4);
                if (writeBytes < 0) {
                    break;
                }
                i4 += writeBytes;
            } catch (Throwable th) {
                buffer.release();
                throw th;
            }
        } while (i4 != min);
        this.offset += i4;
        return buffer;
    }

    public ChunkedNioFile(FileChannel fileChannel, long j4, long j5, int i4) throws IOException {
        if (fileChannel == null) {
            throw new NullPointerException("in");
        }
        if (j4 < 0) {
            throw new IllegalArgumentException("offset: " + j4 + " (expected: 0 or greater)");
        } else if (j5 < 0) {
            throw new IllegalArgumentException("length: " + j5 + " (expected: 0 or greater)");
        } else if (i4 > 0) {
            if (j4 != 0) {
                fileChannel.position(j4);
            }
            this.in = fileChannel;
            this.chunkSize = i4;
            this.startOffset = j4;
            this.offset = j4;
            this.endOffset = j4 + j5;
        } else {
            throw new IllegalArgumentException("chunkSize: " + i4 + " (expected: a positive integer)");
        }
    }
}
