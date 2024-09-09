package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class RedisEncoder extends MessageToMessageEncoder<RedisMessage> {
    private final RedisMessagePool messagePool;

    public RedisEncoder() {
        this(FixedRedisMessagePool.INSTANCE);
    }

    private byte[] numberToBytes(long j4) {
        byte[] byteBufOfInteger = this.messagePool.getByteBufOfInteger(j4);
        return byteBufOfInteger != null ? byteBufOfInteger : RedisCodecUtil.longToAsciiBytes(j4);
    }

    private void writeArrayHeader(ByteBufAllocator byteBufAllocator, ArrayHeaderRedisMessage arrayHeaderRedisMessage, List<Object> list) {
        writeArrayHeader(byteBufAllocator, arrayHeaderRedisMessage.isNull(), arrayHeaderRedisMessage.length(), list);
    }

    private void writeArrayMessage(ByteBufAllocator byteBufAllocator, ArrayRedisMessage arrayRedisMessage, List<Object> list) {
        if (arrayRedisMessage.isNull()) {
            writeArrayHeader(byteBufAllocator, arrayRedisMessage.isNull(), -1L, list);
            return;
        }
        writeArrayHeader(byteBufAllocator, arrayRedisMessage.isNull(), arrayRedisMessage.children().size(), list);
        for (RedisMessage redisMessage : arrayRedisMessage.children()) {
            writeRedisMessage(byteBufAllocator, redisMessage, list);
        }
    }

    private static void writeBulkStringContent(ByteBufAllocator byteBufAllocator, BulkStringRedisContent bulkStringRedisContent, List<Object> list) {
        list.add(bulkStringRedisContent.content().retain());
        if (bulkStringRedisContent instanceof LastBulkStringRedisContent) {
            list.add(byteBufAllocator.ioBuffer(2).writeShort(RedisConstants.EOL_SHORT));
        }
    }

    private void writeBulkStringHeader(ByteBufAllocator byteBufAllocator, BulkStringHeaderRedisMessage bulkStringHeaderRedisMessage, List<Object> list) {
        ByteBuf ioBuffer = byteBufAllocator.ioBuffer((bulkStringHeaderRedisMessage.isNull() ? 2 : 22) + 1);
        ioBuffer.writeByte(RedisMessageType.BULK_STRING.value());
        if (bulkStringHeaderRedisMessage.isNull()) {
            ioBuffer.writeShort(RedisConstants.NULL_SHORT);
        } else {
            ioBuffer.writeBytes(numberToBytes(bulkStringHeaderRedisMessage.bulkStringLength()));
            ioBuffer.writeShort(RedisConstants.EOL_SHORT);
        }
        list.add(ioBuffer);
    }

    private static void writeErrorMessage(ByteBufAllocator byteBufAllocator, ErrorRedisMessage errorRedisMessage, List<Object> list) {
        writeString(byteBufAllocator, RedisMessageType.ERROR.value(), errorRedisMessage.content(), list);
    }

    private void writeFullBulkStringMessage(ByteBufAllocator byteBufAllocator, FullBulkStringRedisMessage fullBulkStringRedisMessage, List<Object> list) {
        if (fullBulkStringRedisMessage.isNull()) {
            ByteBuf ioBuffer = byteBufAllocator.ioBuffer(5);
            ioBuffer.writeByte(RedisMessageType.BULK_STRING.value());
            ioBuffer.writeShort(RedisConstants.NULL_SHORT);
            ioBuffer.writeShort(RedisConstants.EOL_SHORT);
            list.add(ioBuffer);
            return;
        }
        ByteBuf ioBuffer2 = byteBufAllocator.ioBuffer(23);
        ioBuffer2.writeByte(RedisMessageType.BULK_STRING.value());
        ioBuffer2.writeBytes(numberToBytes(fullBulkStringRedisMessage.content().readableBytes()));
        short s3 = RedisConstants.EOL_SHORT;
        ioBuffer2.writeShort(s3);
        list.add(ioBuffer2);
        list.add(fullBulkStringRedisMessage.content().retain());
        list.add(byteBufAllocator.ioBuffer(2).writeShort(s3));
    }

    private void writeIntegerMessage(ByteBufAllocator byteBufAllocator, IntegerRedisMessage integerRedisMessage, List<Object> list) {
        ByteBuf ioBuffer = byteBufAllocator.ioBuffer(23);
        ioBuffer.writeByte(RedisMessageType.INTEGER.value());
        ioBuffer.writeBytes(numberToBytes(integerRedisMessage.value()));
        ioBuffer.writeShort(RedisConstants.EOL_SHORT);
        list.add(ioBuffer);
    }

    private void writeRedisMessage(ByteBufAllocator byteBufAllocator, RedisMessage redisMessage, List<Object> list) {
        if (redisMessage instanceof SimpleStringRedisMessage) {
            writeSimpleStringMessage(byteBufAllocator, (SimpleStringRedisMessage) redisMessage, list);
        } else if (redisMessage instanceof ErrorRedisMessage) {
            writeErrorMessage(byteBufAllocator, (ErrorRedisMessage) redisMessage, list);
        } else if (redisMessage instanceof IntegerRedisMessage) {
            writeIntegerMessage(byteBufAllocator, (IntegerRedisMessage) redisMessage, list);
        } else if (redisMessage instanceof FullBulkStringRedisMessage) {
            writeFullBulkStringMessage(byteBufAllocator, (FullBulkStringRedisMessage) redisMessage, list);
        } else if (redisMessage instanceof BulkStringRedisContent) {
            writeBulkStringContent(byteBufAllocator, (BulkStringRedisContent) redisMessage, list);
        } else if (redisMessage instanceof BulkStringHeaderRedisMessage) {
            writeBulkStringHeader(byteBufAllocator, (BulkStringHeaderRedisMessage) redisMessage, list);
        } else if (redisMessage instanceof ArrayHeaderRedisMessage) {
            writeArrayHeader(byteBufAllocator, (ArrayHeaderRedisMessage) redisMessage, list);
        } else if (redisMessage instanceof ArrayRedisMessage) {
            writeArrayMessage(byteBufAllocator, (ArrayRedisMessage) redisMessage, list);
        } else {
            throw new CodecException("unknown message type: " + redisMessage);
        }
    }

    private static void writeSimpleStringMessage(ByteBufAllocator byteBufAllocator, SimpleStringRedisMessage simpleStringRedisMessage, List<Object> list) {
        writeString(byteBufAllocator, RedisMessageType.SIMPLE_STRING.value(), simpleStringRedisMessage.content(), list);
    }

    private static void writeString(ByteBufAllocator byteBufAllocator, byte b4, String str, List<Object> list) {
        ByteBuf ioBuffer = byteBufAllocator.ioBuffer(ByteBufUtil.utf8MaxBytes(str) + 1 + 2);
        ioBuffer.writeByte(b4);
        ByteBufUtil.writeUtf8(ioBuffer, str);
        ioBuffer.writeShort(RedisConstants.EOL_SHORT);
        list.add(ioBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, RedisMessage redisMessage, List list) throws Exception {
        encode2(channelHandlerContext, redisMessage, (List<Object>) list);
    }

    public RedisEncoder(RedisMessagePool redisMessagePool) {
        this.messagePool = (RedisMessagePool) ObjectUtil.checkNotNull(redisMessagePool, "messagePool");
    }

    private void writeArrayHeader(ByteBufAllocator byteBufAllocator, boolean z3, long j4, List<Object> list) {
        if (z3) {
            ByteBuf ioBuffer = byteBufAllocator.ioBuffer(5);
            ioBuffer.writeByte(RedisMessageType.ARRAY_HEADER.value());
            ioBuffer.writeShort(RedisConstants.NULL_SHORT);
            ioBuffer.writeShort(RedisConstants.EOL_SHORT);
            list.add(ioBuffer);
            return;
        }
        ByteBuf ioBuffer2 = byteBufAllocator.ioBuffer(23);
        ioBuffer2.writeByte(RedisMessageType.ARRAY_HEADER.value());
        ioBuffer2.writeBytes(numberToBytes(j4));
        ioBuffer2.writeShort(RedisConstants.EOL_SHORT);
        list.add(ioBuffer2);
    }

    /* renamed from: encode  reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, RedisMessage redisMessage, List<Object> list) throws Exception {
        try {
            writeRedisMessage(channelHandlerContext.alloc(), redisMessage, list);
        } catch (CodecException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new CodecException(e5);
        }
    }
}
