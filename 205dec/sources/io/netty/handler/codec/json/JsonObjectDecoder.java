package io.netty.handler.codec.json;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class JsonObjectDecoder extends ByteToMessageDecoder {
    private static final int ST_CORRUPTED = -1;
    private static final int ST_DECODING_ARRAY_STREAM = 2;
    private static final int ST_DECODING_NORMAL = 1;
    private static final int ST_INIT = 0;
    private int idx;
    private boolean insideString;
    private final int maxObjectLength;
    private int openBraces;
    private int state;
    private final boolean streamArrayElements;

    public JsonObjectDecoder() {
        this(1048576);
    }

    private void decodeByte(byte b4, ByteBuf byteBuf, int i4) {
        if ((b4 == 123 || b4 == 91) && !this.insideString) {
            this.openBraces++;
        } else if ((b4 == 125 || b4 == 93) && !this.insideString) {
            this.openBraces--;
        } else if (b4 == 34) {
            if (!this.insideString) {
                this.insideString = true;
                return;
            }
            int i5 = 0;
            for (int i6 = i4 - 1; i6 >= 0 && byteBuf.getByte(i6) == 92; i6--) {
                i5++;
            }
            if (i5 % 2 == 0) {
                this.insideString = false;
            }
        }
    }

    private void initDecoding(byte b4) {
        this.openBraces = 1;
        if (b4 == 91 && this.streamArrayElements) {
            this.state = 2;
        } else {
            this.state = 1;
        }
    }

    private void reset() {
        this.insideString = false;
        this.state = 0;
        this.openBraces = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i4;
        if (this.state == -1) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int i5 = this.idx;
        int writerIndex = byteBuf.writerIndex();
        if (writerIndex <= this.maxObjectLength) {
            while (i5 < writerIndex) {
                byte b4 = byteBuf.getByte(i5);
                int i6 = this.state;
                if (i6 == 1) {
                    decodeByte(b4, byteBuf, i5);
                    if (this.openBraces == 0) {
                        int i7 = i5 + 1;
                        ByteBuf extractObject = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), i7 - byteBuf.readerIndex());
                        if (extractObject != null) {
                            list.add(extractObject);
                        }
                        byteBuf.readerIndex(i7);
                        reset();
                    }
                } else if (i6 == 2) {
                    decodeByte(b4, byteBuf, i5);
                    if (!this.insideString && (((i4 = this.openBraces) == 1 && b4 == 44) || (i4 == 0 && b4 == 93))) {
                        for (int readerIndex = byteBuf.readerIndex(); Character.isWhitespace(byteBuf.getByte(readerIndex)); readerIndex++) {
                            byteBuf.skipBytes(1);
                        }
                        int i8 = i5 - 1;
                        while (i8 >= byteBuf.readerIndex() && Character.isWhitespace(byteBuf.getByte(i8))) {
                            i8--;
                        }
                        ByteBuf extractObject2 = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), (i8 + 1) - byteBuf.readerIndex());
                        if (extractObject2 != null) {
                            list.add(extractObject2);
                        }
                        byteBuf.readerIndex(i5 + 1);
                        if (b4 == 93) {
                            reset();
                        }
                    }
                } else if (b4 != 123 && b4 != 91) {
                    if (Character.isWhitespace(b4)) {
                        byteBuf.skipBytes(1);
                    } else {
                        this.state = -1;
                        throw new CorruptedFrameException("invalid JSON received at byte position " + i5 + ": " + ByteBufUtil.hexDump(byteBuf));
                    }
                } else {
                    initDecoding(b4);
                    if (this.state == 2) {
                        byteBuf.skipBytes(1);
                    }
                }
                i5++;
            }
            if (byteBuf.readableBytes() == 0) {
                this.idx = 0;
                return;
            } else {
                this.idx = i5;
                return;
            }
        }
        byteBuf.skipBytes(byteBuf.readableBytes());
        reset();
        throw new TooLongFrameException("object length exceeds " + this.maxObjectLength + ": " + writerIndex + " bytes discarded");
    }

    protected ByteBuf extractObject(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i4, int i5) {
        return byteBuf.retainedSlice(i4, i5);
    }

    public JsonObjectDecoder(int i4) {
        this(i4, false);
    }

    public JsonObjectDecoder(boolean z3) {
        this(1048576, z3);
    }

    public JsonObjectDecoder(int i4, boolean z3) {
        if (i4 >= 1) {
            this.maxObjectLength = i4;
            this.streamArrayElements = z3;
            return;
        }
        throw new IllegalArgumentException("maxObjectLength must be a positive int");
    }
}
