package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class JZlibDecoder extends ZlibDecoder {
    private byte[] dictionary;
    private volatile boolean finished;

    /* renamed from: z  reason: collision with root package name */
    private final Inflater f54782z;

    public JZlibDecoder() {
        this(ZlibWrapper.ZLIB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.finished) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return;
        }
        try {
            this.f54782z.avail_in = readableBytes;
            if (byteBuf.hasArray()) {
                this.f54782z.next_in = byteBuf.array();
                this.f54782z.next_in_index = byteBuf.arrayOffset() + byteBuf.readerIndex();
            } else {
                byte[] bArr = new byte[readableBytes];
                byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                this.f54782z.next_in = bArr;
                this.f54782z.next_in_index = 0;
            }
            int i4 = this.f54782z.next_in_index;
            int i5 = readableBytes << 1;
            ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer(i5);
            while (true) {
                this.f54782z.avail_out = i5;
                heapBuffer.ensureWritable(i5);
                this.f54782z.next_out = heapBuffer.array();
                this.f54782z.next_out_index = heapBuffer.arrayOffset() + heapBuffer.writerIndex();
                int i6 = this.f54782z.next_out_index;
                int inflate = this.f54782z.inflate(2);
                int i7 = this.f54782z.next_out_index - i6;
                if (i7 > 0) {
                    heapBuffer.writerIndex(heapBuffer.writerIndex() + i7);
                }
                if (inflate != -5) {
                    if (inflate != 0) {
                        if (inflate == 1) {
                            this.finished = true;
                            this.f54782z.inflateEnd();
                            break;
                        } else if (inflate != 2) {
                            ZlibUtil.fail(this.f54782z, "decompression failure", inflate);
                        } else {
                            byte[] bArr2 = this.dictionary;
                            if (bArr2 == null) {
                                ZlibUtil.fail(this.f54782z, "decompression failure", inflate);
                            } else {
                                int inflateSetDictionary = this.f54782z.inflateSetDictionary(bArr2, bArr2.length);
                                if (inflateSetDictionary != 0) {
                                    ZlibUtil.fail(this.f54782z, "failed to set the dictionary", inflateSetDictionary);
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                } else if (this.f54782z.avail_in <= 0) {
                    break;
                }
            }
            byteBuf.skipBytes(this.f54782z.next_in_index - i4);
            if (heapBuffer.isReadable()) {
                list.add(heapBuffer);
            } else {
                heapBuffer.release();
            }
        } finally {
            this.f54782z.next_in = null;
            this.f54782z.next_out = null;
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper) {
        Inflater inflater = new Inflater();
        this.f54782z = inflater;
        if (zlibWrapper != null) {
            int init = inflater.init(ZlibUtil.convertWrapperType(zlibWrapper));
            if (init != 0) {
                ZlibUtil.fail(inflater, "initialization failure", init);
                return;
            }
            return;
        }
        throw new NullPointerException("wrapper");
    }

    public JZlibDecoder(byte[] bArr) {
        Inflater inflater = new Inflater();
        this.f54782z = inflater;
        if (bArr != null) {
            this.dictionary = bArr;
            int inflateInit = inflater.inflateInit(JZlib.W_ZLIB);
            if (inflateInit != 0) {
                ZlibUtil.fail(inflater, "initialization failure", inflateInit);
                return;
            }
            return;
        }
        throw new NullPointerException("dictionary");
    }
}
