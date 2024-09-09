package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ProtocolDetectionResult;
import io.netty.util.CharsetUtil;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class HAProxyMessageDecoder extends ByteToMessageDecoder {
    private static final byte[] BINARY_PREFIX;
    private static final int BINARY_PREFIX_LENGTH;
    private static final int DELIMITER_LENGTH = 2;
    private static final int V1_MAX_LENGTH = 108;
    private static final int V2_MAX_LENGTH = 65551;
    private static final int V2_MAX_TLV = 65319;
    private static final int V2_MIN_LENGTH = 232;
    private int discardedBytes;
    private boolean discarding;
    private boolean finished;
    private final int v2MaxHeaderSize;
    private int version;
    private static final byte[] TEXT_PREFIX = {80, 82, 79, 88, 89};
    private static final ProtocolDetectionResult<HAProxyProtocolVersion> DETECTION_RESULT_V1 = ProtocolDetectionResult.detected(HAProxyProtocolVersion.V1);
    private static final ProtocolDetectionResult<HAProxyProtocolVersion> DETECTION_RESULT_V2 = ProtocolDetectionResult.detected(HAProxyProtocolVersion.V2);

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private abstract class HeaderExtractor {
        private final int maxHeaderSize;

        protected HeaderExtractor(int i4) {
            this.maxHeaderSize = i4;
        }

        protected abstract int delimiterLength(ByteBuf byteBuf, int i4);

        public ByteBuf extract(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
            int findEndOfHeader = findEndOfHeader(byteBuf);
            if (HAProxyMessageDecoder.access$000(HAProxyMessageDecoder.this)) {
                if (findEndOfHeader >= 0) {
                    int access$200 = (HAProxyMessageDecoder.access$200(HAProxyMessageDecoder.this) + findEndOfHeader) - byteBuf.readerIndex();
                    byteBuf.readerIndex(findEndOfHeader + delimiterLength(byteBuf, findEndOfHeader));
                    HAProxyMessageDecoder.access$202(HAProxyMessageDecoder.this, 0);
                    HAProxyMessageDecoder.access$002(HAProxyMessageDecoder.this, false);
                    if (!HAProxyMessageDecoder.access$300(HAProxyMessageDecoder.this)) {
                        HAProxyMessageDecoder hAProxyMessageDecoder = HAProxyMessageDecoder.this;
                        HAProxyMessageDecoder.access$400(hAProxyMessageDecoder, channelHandlerContext, "over " + access$200);
                    }
                } else {
                    HAProxyMessageDecoder hAProxyMessageDecoder2 = HAProxyMessageDecoder.this;
                    HAProxyMessageDecoder.access$202(hAProxyMessageDecoder2, HAProxyMessageDecoder.access$200(hAProxyMessageDecoder2) + byteBuf.readableBytes());
                    byteBuf.skipBytes(byteBuf.readableBytes());
                }
                return null;
            } else if (findEndOfHeader >= 0) {
                int readerIndex = findEndOfHeader - byteBuf.readerIndex();
                if (readerIndex > this.maxHeaderSize) {
                    byteBuf.readerIndex(findEndOfHeader + delimiterLength(byteBuf, findEndOfHeader));
                    HAProxyMessageDecoder.access$100(HAProxyMessageDecoder.this, channelHandlerContext, readerIndex);
                    return null;
                }
                ByteBuf readSlice = byteBuf.readSlice(readerIndex);
                byteBuf.skipBytes(delimiterLength(byteBuf, findEndOfHeader));
                return readSlice;
            } else {
                int readableBytes = byteBuf.readableBytes();
                if (readableBytes > this.maxHeaderSize) {
                    HAProxyMessageDecoder.access$202(HAProxyMessageDecoder.this, readableBytes);
                    byteBuf.skipBytes(readableBytes);
                    HAProxyMessageDecoder.access$002(HAProxyMessageDecoder.this, true);
                    if (HAProxyMessageDecoder.access$300(HAProxyMessageDecoder.this)) {
                        HAProxyMessageDecoder hAProxyMessageDecoder3 = HAProxyMessageDecoder.this;
                        HAProxyMessageDecoder.access$400(hAProxyMessageDecoder3, channelHandlerContext, "over " + HAProxyMessageDecoder.access$200(HAProxyMessageDecoder.this));
                    }
                }
                return null;
            }
        }

        protected abstract int findEndOfHeader(ByteBuf byteBuf);
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private final class LineHeaderExtractor extends HeaderExtractor {
        LineHeaderExtractor(int i4) {
            super(i4);
        }

        @Override // io.netty.handler.codec.haproxy.HAProxyMessageDecoder.HeaderExtractor
        protected int delimiterLength(ByteBuf byteBuf, int i4) {
            return byteBuf.getByte(i4) == 13 ? 2 : 1;
        }

        @Override // io.netty.handler.codec.haproxy.HAProxyMessageDecoder.HeaderExtractor
        protected int findEndOfHeader(ByteBuf byteBuf) {
            return HAProxyMessageDecoder.access$500(byteBuf);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private final class StructHeaderExtractor extends HeaderExtractor {
        StructHeaderExtractor(int i4) {
            super(i4);
        }

        @Override // io.netty.handler.codec.haproxy.HAProxyMessageDecoder.HeaderExtractor
        protected int delimiterLength(ByteBuf byteBuf, int i4) {
            return 0;
        }

        @Override // io.netty.handler.codec.haproxy.HAProxyMessageDecoder.HeaderExtractor
        protected int findEndOfHeader(ByteBuf byteBuf) {
            return HAProxyMessageDecoder.access$600(byteBuf);
        }
    }

    static {
        byte[] bArr = {13, 10, 13, 10, 0, 13, 10, 81, 85, 73, 84, 10};
        BINARY_PREFIX = bArr;
        BINARY_PREFIX_LENGTH = bArr.length;
    }

    public HAProxyMessageDecoder() {
        this.version = -1;
        this.v2MaxHeaderSize = 65551;
    }

    private ByteBuf decodeLine(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        int findEndOfLine = findEndOfLine(byteBuf);
        if (this.discarding) {
            if (findEndOfLine >= 0) {
                byteBuf.readerIndex(findEndOfLine + (byteBuf.getByte(findEndOfLine) == 13 ? 2 : 1));
                this.discardedBytes = 0;
                this.discarding = false;
            } else {
                int readableBytes = byteBuf.readableBytes();
                this.discardedBytes = readableBytes;
                byteBuf.skipBytes(readableBytes);
            }
            return null;
        } else if (findEndOfLine >= 0) {
            int readerIndex = findEndOfLine - byteBuf.readerIndex();
            if (readerIndex > 108) {
                byteBuf.readerIndex(findEndOfLine + 2);
                failOverLimit(channelHandlerContext, readerIndex);
                return null;
            }
            ByteBuf readSlice = byteBuf.readSlice(readerIndex);
            byteBuf.skipBytes(2);
            return readSlice;
        } else {
            int readableBytes2 = byteBuf.readableBytes();
            if (readableBytes2 > 108) {
                this.discardedBytes = readableBytes2;
                byteBuf.skipBytes(readableBytes2);
                this.discarding = true;
                failOverLimit(channelHandlerContext, "over " + this.discardedBytes);
            }
            return null;
        }
    }

    private ByteBuf decodeStruct(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        int findEndOfHeader = findEndOfHeader(byteBuf);
        if (this.discarding) {
            if (findEndOfHeader >= 0) {
                byteBuf.readerIndex(findEndOfHeader);
                this.discardedBytes = 0;
                this.discarding = false;
            } else {
                int readableBytes = byteBuf.readableBytes();
                this.discardedBytes = readableBytes;
                byteBuf.skipBytes(readableBytes);
            }
            return null;
        } else if (findEndOfHeader >= 0) {
            int readerIndex = findEndOfHeader - byteBuf.readerIndex();
            if (readerIndex > this.v2MaxHeaderSize) {
                byteBuf.readerIndex(findEndOfHeader);
                failOverLimit(channelHandlerContext, readerIndex);
                return null;
            }
            return byteBuf.readSlice(readerIndex);
        } else {
            int readableBytes2 = byteBuf.readableBytes();
            if (readableBytes2 > this.v2MaxHeaderSize) {
                this.discardedBytes = readableBytes2;
                byteBuf.skipBytes(readableBytes2);
                this.discarding = true;
                failOverLimit(channelHandlerContext, "over " + this.discardedBytes);
            }
            return null;
        }
    }

    public static ProtocolDetectionResult<HAProxyProtocolVersion> detectProtocol(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 12) {
            return ProtocolDetectionResult.needsMoreData();
        }
        int readerIndex = byteBuf.readerIndex();
        if (match(BINARY_PREFIX, byteBuf, readerIndex)) {
            return DETECTION_RESULT_V2;
        }
        if (match(TEXT_PREFIX, byteBuf, readerIndex)) {
            return DETECTION_RESULT_V1;
        }
        return ProtocolDetectionResult.invalid();
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str, Throwable th) {
        this.finished = true;
        channelHandlerContext.close();
        if (str != null && th != null) {
            throw new HAProxyProtocolException(str, th);
        }
        if (str != null) {
            throw new HAProxyProtocolException(str);
        }
        if (th != null) {
        }
    }

    private void failOverLimit(ChannelHandlerContext channelHandlerContext, int i4) {
        failOverLimit(channelHandlerContext, String.valueOf(i4));
    }

    private static int findEndOfHeader(ByteBuf byteBuf) {
        int unsignedShort;
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes >= 16 && readableBytes >= (unsignedShort = byteBuf.getUnsignedShort(byteBuf.readerIndex() + 14) + 16)) {
            return unsignedShort;
        }
        return -1;
    }

    private static int findEndOfLine(ByteBuf byteBuf) {
        int writerIndex = byteBuf.writerIndex();
        for (int readerIndex = byteBuf.readerIndex(); readerIndex < writerIndex; readerIndex++) {
            if (byteBuf.getByte(readerIndex) == 13 && readerIndex < writerIndex - 1 && byteBuf.getByte(readerIndex + 1) == 10) {
                return readerIndex;
            }
        }
        return -1;
    }

    private static int findVersion(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 13) {
            return -1;
        }
        int readerIndex = byteBuf.readerIndex();
        if (match(BINARY_PREFIX, byteBuf, readerIndex)) {
            return byteBuf.getByte(readerIndex + BINARY_PREFIX_LENGTH);
        }
        return 1;
    }

    private static boolean match(byte[] bArr, ByteBuf byteBuf, int i4) {
        for (int i5 = 0; i5 < bArr.length; i5++) {
            if (byteBuf.getByte(i4 + i5) != bArr[i5]) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        super.channelRead(channelHandlerContext, obj);
        if (this.finished) {
            channelHandlerContext.pipeline().remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf decodeStruct;
        if (this.version == -1) {
            int findVersion = findVersion(byteBuf);
            this.version = findVersion;
            if (findVersion == -1) {
                return;
            }
        }
        if (this.version == 1) {
            decodeStruct = decodeLine(channelHandlerContext, byteBuf);
        } else {
            decodeStruct = decodeStruct(channelHandlerContext, byteBuf);
        }
        if (decodeStruct != null) {
            this.finished = true;
            try {
                if (this.version == 1) {
                    list.add(HAProxyMessage.decodeHeader(decodeStruct.toString(CharsetUtil.US_ASCII)));
                } else {
                    list.add(HAProxyMessage.decodeHeader(decodeStruct));
                }
            } catch (HAProxyProtocolException e4) {
                fail(channelHandlerContext, null, e4);
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public boolean isSingleDecode() {
        return true;
    }

    private void failOverLimit(ChannelHandlerContext channelHandlerContext, String str) {
        int i4 = this.version == 1 ? 108 : this.v2MaxHeaderSize;
        fail(channelHandlerContext, "header length (" + str + ") exceeds the allowed maximum (" + i4 + ')', null);
    }

    public HAProxyMessageDecoder(int i4) {
        this.version = -1;
        if (i4 < 1) {
            this.v2MaxHeaderSize = 232;
        } else if (i4 > 65319) {
            this.v2MaxHeaderSize = 65551;
        } else {
            int i5 = i4 + 232;
            if (i5 > 65551) {
                this.v2MaxHeaderSize = 65551;
            } else {
                this.v2MaxHeaderSize = i5;
            }
        }
    }
}
