package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ChunkedFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;
    private final RandomAccessFile file;
    private long offset;
    private final long startOffset;

    public ChunkedFile(File file) throws IOException {
        this(file, 8192);
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.file.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        return this.offset >= this.endOffset || !this.file.getChannel().isOpen();
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

    public ChunkedFile(File file, int i) throws IOException {
        this(new RandomAccessFile(file, "r"), i);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile) throws IOException {
        this(randomAccessFile, 8192);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, int i) throws IOException {
        this(randomAccessFile, 0L, randomAccessFile.length(), i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        long j = this.offset;
        long j2 = this.endOffset;
        if (j >= j2) {
            return null;
        }
        int min = (int) Math.min(this.chunkSize, j2 - j);
        ByteBuf heapBuffer = byteBufAllocator.heapBuffer(min);
        try {
            this.file.readFully(heapBuffer.array(), heapBuffer.arrayOffset(), min);
            heapBuffer.writerIndex(min);
            this.offset = j + min;
            return heapBuffer;
        } catch (Throwable th) {
            heapBuffer.release();
            throw th;
        }
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, long j, long j2, int i) throws IOException {
        if (randomAccessFile == null) {
            throw new NullPointerException(IDataSource.f43973c);
        }
        if (j < 0) {
            throw new IllegalArgumentException("offset: " + j + " (expected: 0 or greater)");
        } else if (j2 < 0) {
            throw new IllegalArgumentException("length: " + j2 + " (expected: 0 or greater)");
        } else if (i > 0) {
            this.file = randomAccessFile;
            this.startOffset = j;
            this.offset = j;
            this.endOffset = j2 + j;
            this.chunkSize = i;
            randomAccessFile.seek(j);
        } else {
            throw new IllegalArgumentException("chunkSize: " + i + " (expected: a positive integer)");
        }
    }
}