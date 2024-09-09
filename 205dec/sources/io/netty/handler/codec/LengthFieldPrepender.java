package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@ChannelHandler.Sharable
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class LengthFieldPrepender extends MessageToMessageEncoder<ByteBuf> {
    private final ByteOrder byteOrder;
    private final int lengthAdjustment;
    private final int lengthFieldLength;
    private final boolean lengthIncludesLengthFieldLength;

    public LengthFieldPrepender(int i4) {
        this(i4, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        encode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public LengthFieldPrepender(int i4, boolean z3) {
        this(i4, 0, z3);
    }

    /* renamed from: encode  reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes() + this.lengthAdjustment;
        if (this.lengthIncludesLengthFieldLength) {
            readableBytes += this.lengthFieldLength;
        }
        if (readableBytes >= 0) {
            int i4 = this.lengthFieldLength;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            list.add(channelHandlerContext.alloc().buffer(4).order(this.byteOrder).writeInt(readableBytes));
                        } else if (i4 == 8) {
                            list.add(channelHandlerContext.alloc().buffer(8).order(this.byteOrder).writeLong(readableBytes));
                        } else {
                            throw new Error("should not reach here");
                        }
                    } else if (readableBytes < 16777216) {
                        list.add(channelHandlerContext.alloc().buffer(3).order(this.byteOrder).writeMedium(readableBytes));
                    } else {
                        throw new IllegalArgumentException("length does not fit into a medium integer: " + readableBytes);
                    }
                } else if (readableBytes < 65536) {
                    list.add(channelHandlerContext.alloc().buffer(2).order(this.byteOrder).writeShort((short) readableBytes));
                } else {
                    throw new IllegalArgumentException("length does not fit into a short integer: " + readableBytes);
                }
            } else if (readableBytes < 256) {
                list.add(channelHandlerContext.alloc().buffer(1).order(this.byteOrder).writeByte((byte) readableBytes));
            } else {
                throw new IllegalArgumentException("length does not fit into a byte: " + readableBytes);
            }
            list.add(byteBuf.retain());
            return;
        }
        throw new IllegalArgumentException("Adjusted frame length (" + readableBytes + ") is less than zero");
    }

    public LengthFieldPrepender(int i4, int i5) {
        this(i4, i5, false);
    }

    public LengthFieldPrepender(int i4, int i5, boolean z3) {
        this(ByteOrder.BIG_ENDIAN, i4, i5, z3);
    }

    public LengthFieldPrepender(ByteOrder byteOrder, int i4, int i5, boolean z3) {
        if (i4 != 1 && i4 != 2 && i4 != 3 && i4 != 4 && i4 != 8) {
            throw new IllegalArgumentException("lengthFieldLength must be either 1, 2, 3, 4, or 8: " + i4);
        }
        ObjectUtil.checkNotNull(byteOrder, "byteOrder");
        this.byteOrder = byteOrder;
        this.lengthFieldLength = i4;
        this.lengthIncludesLengthFieldLength = z3;
        this.lengthAdjustment = i5;
    }
}
