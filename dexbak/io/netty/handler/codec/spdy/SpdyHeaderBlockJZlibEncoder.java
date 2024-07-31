package io.netty.handler.codec.spdy;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.compression.CompressionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SpdyHeaderBlockJZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private boolean finished;

    /* renamed from: z */
    private final Deflater f40266z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdyHeaderBlockJZlibEncoder(SpdyVersion spdyVersion, int i, int i2, int i3) {
        super(spdyVersion);
        Deflater deflater = new Deflater();
        this.f40266z = deflater;
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        } else if (i2 < 9 || i2 > 15) {
            throw new IllegalArgumentException("windowBits: " + i2 + " (expected: 9-15)");
        } else if (i3 >= 1 && i3 <= 9) {
            int deflateInit = deflater.deflateInit(i, i2, i3, JZlib.W_ZLIB);
            if (deflateInit == 0) {
                byte[] bArr = SpdyCodecUtil.SPDY_DICT;
                int deflateSetDictionary = deflater.deflateSetDictionary(bArr, bArr.length);
                if (deflateSetDictionary == 0) {
                    return;
                }
                throw new CompressionException("failed to set the SPDY dictionary: " + deflateSetDictionary);
            }
            throw new CompressionException("failed to initialize an SPDY header block deflater: " + deflateInit);
        } else {
            throw new IllegalArgumentException("memLevel: " + i3 + " (expected: 1-9)");
        }
    }

    private ByteBuf encode(ByteBufAllocator byteBufAllocator) {
        ByteBuf byteBuf;
        try {
            int i = this.f40266z.next_in_index;
            int i2 = this.f40266z.next_out_index;
            double length = this.f40266z.next_in.length;
            Double.isNaN(length);
            int ceil = ((int) Math.ceil(length * 1.001d)) + 12;
            byteBuf = byteBufAllocator.heapBuffer(ceil);
            try {
                this.f40266z.next_out = byteBuf.array();
                this.f40266z.next_out_index = byteBuf.arrayOffset() + byteBuf.writerIndex();
                this.f40266z.avail_out = ceil;
                int deflate = this.f40266z.deflate(2);
                byteBuf.skipBytes(this.f40266z.next_in_index - i);
                if (deflate == 0) {
                    int i3 = this.f40266z.next_out_index - i2;
                    if (i3 > 0) {
                        byteBuf.writerIndex(byteBuf.writerIndex() + i3);
                    }
                    this.f40266z.next_in = null;
                    this.f40266z.next_out = null;
                    return byteBuf;
                }
                throw new CompressionException("compression failure: " + deflate);
            } catch (Throwable th) {
                th = th;
                this.f40266z.next_in = null;
                this.f40266z.next_out = null;
                if (byteBuf != null) {
                    byteBuf.release();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteBuf = null;
        }
    }

    private void setInput(ByteBuf byteBuf) {
        byte[] bArr;
        int i;
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bArr = byteBuf.array();
            i = byteBuf.arrayOffset() + byteBuf.readerIndex();
        } else {
            bArr = new byte[readableBytes];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            i = 0;
        }
        this.f40266z.next_in = bArr;
        this.f40266z.next_in_index = i;
        this.f40266z.avail_in = readableBytes;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        this.f40266z.deflateEnd();
        this.f40266z.next_in = null;
        this.f40266z.next_out = null;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        if (spdyHeadersFrame != null) {
            if (this.finished) {
                return Unpooled.EMPTY_BUFFER;
            }
            ByteBuf encode = super.encode(byteBufAllocator, spdyHeadersFrame);
            try {
                if (!encode.isReadable()) {
                    return Unpooled.EMPTY_BUFFER;
                }
                setInput(encode);
                return encode(byteBufAllocator);
            } finally {
                encode.release();
            }
        }
        throw new IllegalArgumentException("frame");
    }
}
