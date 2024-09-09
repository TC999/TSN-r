package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class JdkZlibDecoder extends ZlibDecoder {
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FRESERVED = 224;
    private final ByteBufChecksum crc;
    private boolean decideZlibOrNone;
    private final byte[] dictionary;
    private volatile boolean finished;
    private int flags;
    private GzipState gzipState;
    private Inflater inflater;
    private int xlen;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.compression.JdkZlibDecoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[GzipState.values().length];
            $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState = iArr;
            try {
                iArr[GzipState.FOOTER_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.HEADER_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.FLG_READ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.XLEN_READ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.SKIP_FNAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.SKIP_COMMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.PROCESS_FHCRC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.HEADER_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr2;
            try {
                iArr2[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB_OR_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum GzipState {
        HEADER_START,
        HEADER_END,
        FLG_READ,
        XLEN_READ,
        SKIP_FNAME,
        SKIP_COMMENT,
        PROCESS_FHCRC,
        FOOTER_START
    }

    public JdkZlibDecoder() {
        this(ZlibWrapper.ZLIB, null);
    }

    private static boolean looksLikeZlib(short s3) {
        return (s3 & 30720) == 30720 && s3 % 31 == 0;
    }

    private boolean readGZIPFooter(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 8) {
            return false;
        }
        verifyCrc(byteBuf);
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            i4 |= byteBuf.readUnsignedByte() << (i5 * 8);
        }
        int totalOut = this.inflater.getTotalOut();
        if (i4 == totalOut) {
            return true;
        }
        throw new DecompressionException("Number of bytes mismatch. Expected: " + i4 + ", Got: " + totalOut);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean readGZIPHeader(io.netty.buffer.ByteBuf r8) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.JdkZlibDecoder.readGZIPHeader(io.netty.buffer.ByteBuf):boolean");
    }

    private void verifyCrc(ByteBuf byteBuf) {
        long j4 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            j4 |= byteBuf.readUnsignedByte() << (i4 * 8);
        }
        long value = this.crc.getValue();
        if (j4 == value) {
            return;
        }
        throw new DecompressionException("CRC value missmatch. Expected: " + j4 + ", Got: " + value);
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
        boolean z3 = false;
        if (this.decideZlibOrNone) {
            if (readableBytes < 2) {
                return;
            }
            this.inflater = new Inflater(!looksLikeZlib(byteBuf.getShort(byteBuf.readerIndex())));
            this.decideZlibOrNone = false;
        }
        if (this.crc != null) {
            if (AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[this.gzipState.ordinal()] != 1) {
                if (this.gzipState != GzipState.HEADER_END && !readGZIPHeader(byteBuf)) {
                    return;
                }
                readableBytes = byteBuf.readableBytes();
            } else if (readGZIPFooter(byteBuf)) {
                this.finished = true;
                return;
            } else {
                return;
            }
        }
        if (byteBuf.hasArray()) {
            this.inflater.setInput(byteBuf.array(), byteBuf.arrayOffset() + byteBuf.readerIndex(), readableBytes);
        } else {
            byte[] bArr = new byte[readableBytes];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            this.inflater.setInput(bArr);
        }
        int remaining = this.inflater.getRemaining() << 1;
        ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer(remaining);
        try {
            try {
                byte[] array = heapBuffer.array();
                while (true) {
                    if (this.inflater.needsInput()) {
                        break;
                    }
                    int writerIndex = heapBuffer.writerIndex();
                    int arrayOffset = heapBuffer.arrayOffset() + writerIndex;
                    int writableBytes = heapBuffer.writableBytes();
                    if (writableBytes == 0) {
                        list.add(heapBuffer);
                        heapBuffer = channelHandlerContext.alloc().heapBuffer(remaining);
                        array = heapBuffer.array();
                    } else {
                        int inflate = this.inflater.inflate(array, arrayOffset, writableBytes);
                        if (inflate > 0) {
                            heapBuffer.writerIndex(writerIndex + inflate);
                            ByteBufChecksum byteBufChecksum = this.crc;
                            if (byteBufChecksum != null) {
                                byteBufChecksum.update(array, arrayOffset, inflate);
                            }
                        } else if (this.inflater.needsDictionary()) {
                            byte[] bArr2 = this.dictionary;
                            if (bArr2 != null) {
                                this.inflater.setDictionary(bArr2);
                            } else {
                                throw new DecompressionException("decompression failure, unable to set dictionary as non was specified");
                            }
                        }
                        if (this.inflater.finished()) {
                            if (this.crc == null) {
                                this.finished = true;
                            } else {
                                z3 = true;
                            }
                        }
                    }
                }
                byteBuf.skipBytes(readableBytes - this.inflater.getRemaining());
                if (z3) {
                    this.gzipState = GzipState.FOOTER_START;
                    if (readGZIPFooter(byteBuf)) {
                        this.finished = true;
                    }
                }
            } catch (DataFormatException e4) {
                throw new DecompressionException("decompression failure", e4);
            }
        } finally {
            if (heapBuffer.isReadable()) {
                list.add(heapBuffer);
            } else {
                heapBuffer.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved0(channelHandlerContext);
        Inflater inflater = this.inflater;
        if (inflater != null) {
            inflater.end();
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    public JdkZlibDecoder(byte[] bArr) {
        this(ZlibWrapper.ZLIB, bArr);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, null);
    }

    private JdkZlibDecoder(ZlibWrapper zlibWrapper, byte[] bArr) {
        this.gzipState = GzipState.HEADER_START;
        this.flags = -1;
        this.xlen = -1;
        if (zlibWrapper != null) {
            int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
            if (i4 == 1) {
                this.inflater = new Inflater(true);
                this.crc = ByteBufChecksum.wrapChecksum(new CRC32());
            } else if (i4 == 2) {
                this.inflater = new Inflater(true);
                this.crc = null;
            } else if (i4 == 3) {
                this.inflater = new Inflater();
                this.crc = null;
            } else if (i4 == 4) {
                this.decideZlibOrNone = true;
                this.crc = null;
            } else {
                throw new IllegalArgumentException("Only GZIP or ZLIB is supported, but you used " + zlibWrapper);
            }
            this.dictionary = bArr;
            return;
        }
        throw new NullPointerException("wrapper");
    }
}
