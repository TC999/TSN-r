package io.netty.handler.codec.spdy;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.compression.CompressionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SpdyHeaderBlockJZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private boolean finished;

    /* renamed from: z  reason: collision with root package name */
    private final Deflater f54799z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpdyHeaderBlockJZlibEncoder(SpdyVersion spdyVersion, int i4, int i5, int i6) {
        super(spdyVersion);
        Deflater deflater = new Deflater();
        this.f54799z = deflater;
        if (i4 < 0 || i4 > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i4 + " (expected: 0-9)");
        } else if (i5 < 9 || i5 > 15) {
            throw new IllegalArgumentException("windowBits: " + i5 + " (expected: 9-15)");
        } else if (i6 >= 1 && i6 <= 9) {
            int deflateInit = deflater.deflateInit(i4, i5, i6, JZlib.W_ZLIB);
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
            throw new IllegalArgumentException("memLevel: " + i6 + " (expected: 1-9)");
        }
    }

    private ByteBuf encode(ByteBufAllocator byteBufAllocator) {
        ByteBuf byteBuf;
        try {
            int i4 = this.f54799z.next_in_index;
            int i5 = this.f54799z.next_out_index;
            double length = this.f54799z.next_in.length;
            Double.isNaN(length);
            int ceil = ((int) Math.ceil(length * 1.001d)) + 12;
            byteBuf = byteBufAllocator.heapBuffer(ceil);
            try {
                this.f54799z.next_out = byteBuf.array();
                this.f54799z.next_out_index = byteBuf.arrayOffset() + byteBuf.writerIndex();
                this.f54799z.avail_out = ceil;
                int deflate = this.f54799z.deflate(2);
                byteBuf.skipBytes(this.f54799z.next_in_index - i4);
                if (deflate == 0) {
                    int i6 = this.f54799z.next_out_index - i5;
                    if (i6 > 0) {
                        byteBuf.writerIndex(byteBuf.writerIndex() + i6);
                    }
                    this.f54799z.next_in = null;
                    this.f54799z.next_out = null;
                    return byteBuf;
                }
                throw new CompressionException("compression failure: " + deflate);
            } catch (Throwable th) {
                th = th;
                this.f54799z.next_in = null;
                this.f54799z.next_out = null;
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
        int i4;
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bArr = byteBuf.array();
            i4 = byteBuf.arrayOffset() + byteBuf.readerIndex();
        } else {
            bArr = new byte[readableBytes];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            i4 = 0;
        }
        this.f54799z.next_in = bArr;
        this.f54799z.next_in_index = i4;
        this.f54799z.avail_in = readableBytes;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        this.f54799z.deflateEnd();
        this.f54799z.next_in = null;
        this.f54799z.next_out = null;
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
