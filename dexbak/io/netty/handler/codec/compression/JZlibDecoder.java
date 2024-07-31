package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class JZlibDecoder extends ZlibDecoder {
    private byte[] dictionary;
    private volatile boolean finished;

    /* renamed from: z */
    private final Inflater f40207z;

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
            this.f40207z.avail_in = readableBytes;
            if (byteBuf.hasArray()) {
                this.f40207z.next_in = byteBuf.array();
                this.f40207z.next_in_index = byteBuf.arrayOffset() + byteBuf.readerIndex();
            } else {
                byte[] bArr = new byte[readableBytes];
                byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                this.f40207z.next_in = bArr;
                this.f40207z.next_in_index = 0;
            }
            int i = this.f40207z.next_in_index;
            int i2 = readableBytes << 1;
            ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer(i2);
            while (true) {
                this.f40207z.avail_out = i2;
                heapBuffer.ensureWritable(i2);
                this.f40207z.next_out = heapBuffer.array();
                this.f40207z.next_out_index = heapBuffer.arrayOffset() + heapBuffer.writerIndex();
                int i3 = this.f40207z.next_out_index;
                int inflate = this.f40207z.inflate(2);
                int i4 = this.f40207z.next_out_index - i3;
                if (i4 > 0) {
                    heapBuffer.writerIndex(heapBuffer.writerIndex() + i4);
                }
                if (inflate != -5) {
                    if (inflate != 0) {
                        if (inflate == 1) {
                            this.finished = true;
                            this.f40207z.inflateEnd();
                            break;
                        } else if (inflate != 2) {
                            ZlibUtil.fail(this.f40207z, "decompression failure", inflate);
                        } else {
                            byte[] bArr2 = this.dictionary;
                            if (bArr2 == null) {
                                ZlibUtil.fail(this.f40207z, "decompression failure", inflate);
                            } else {
                                int inflateSetDictionary = this.f40207z.inflateSetDictionary(bArr2, bArr2.length);
                                if (inflateSetDictionary != 0) {
                                    ZlibUtil.fail(this.f40207z, "failed to set the dictionary", inflateSetDictionary);
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                } else if (this.f40207z.avail_in <= 0) {
                    break;
                }
            }
            byteBuf.skipBytes(this.f40207z.next_in_index - i);
            if (heapBuffer.isReadable()) {
                list.add(heapBuffer);
            } else {
                heapBuffer.release();
            }
        } finally {
            this.f40207z.next_in = null;
            this.f40207z.next_out = null;
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper) {
        Inflater inflater = new Inflater();
        this.f40207z = inflater;
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
        this.f40207z = inflater;
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
