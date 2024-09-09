package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkEncoder;
import com.ning.compress.lzf.LZFEncoder;
import com.ning.compress.lzf.util.ChunkEncoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class LzfEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_BLOCK_TO_COMPRESS = 16;
    private final ChunkEncoder encoder;
    private final BufferRecycler recycler;

    public LzfEncoder() {
        this(false, 65535);
    }

    public LzfEncoder(boolean z3) {
        this(z3, 65535);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        byte[] allocInputBuffer;
        int readableBytes = byteBuf.readableBytes();
        int readerIndex = byteBuf.readerIndex();
        int i4 = 0;
        if (byteBuf.hasArray()) {
            allocInputBuffer = byteBuf.array();
            i4 = byteBuf.arrayOffset() + readerIndex;
        } else {
            allocInputBuffer = this.recycler.allocInputBuffer(readableBytes);
            byteBuf.getBytes(readerIndex, allocInputBuffer, 0, readableBytes);
        }
        byte[] bArr = allocInputBuffer;
        byteBuf2.ensureWritable(LZFEncoder.estimateMaxWorkspaceSize(readableBytes));
        byte[] array = byteBuf2.array();
        int arrayOffset = byteBuf2.arrayOffset() + byteBuf2.writerIndex();
        byteBuf2.writerIndex(byteBuf2.writerIndex() + (LZFEncoder.appendEncoded(this.encoder, bArr, i4, readableBytes, array, arrayOffset) - arrayOffset));
        byteBuf.skipBytes(readableBytes);
        if (byteBuf.hasArray()) {
            return;
        }
        this.recycler.releaseInputBuffer(bArr);
    }

    public LzfEncoder(int i4) {
        this(false, i4);
    }

    public LzfEncoder(boolean z3, int i4) {
        super(false);
        if (i4 >= 16 && i4 <= 65535) {
            this.encoder = z3 ? ChunkEncoderFactory.safeNonAllocatingInstance(i4) : ChunkEncoderFactory.optimalNonAllocatingInstance(i4);
            this.recycler = BufferRecycler.instance();
            return;
        }
        throw new IllegalArgumentException("totalLength: " + i4 + " (expected: 16-65535)");
    }
}
