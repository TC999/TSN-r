package io.netty.handler.codec.redis;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class RedisArrayAggregator extends MessageToMessageDecoder<RedisMessage> {
    private final Deque<AggregateState> depths = new ArrayDeque(4);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class AggregateState {
        private final List<RedisMessage> children;
        private final int length;

        AggregateState(int i) {
            this.length = i;
            this.children = new ArrayList(i);
        }
    }

    private RedisMessage decodeRedisArrayHeader(ArrayHeaderRedisMessage arrayHeaderRedisMessage) {
        if (arrayHeaderRedisMessage.isNull()) {
            return ArrayRedisMessage.NULL_INSTANCE;
        }
        if (arrayHeaderRedisMessage.length() == 0) {
            return ArrayRedisMessage.EMPTY_INSTANCE;
        }
        if (arrayHeaderRedisMessage.length() > 0) {
            if (arrayHeaderRedisMessage.length() <= 2147483647L) {
                this.depths.push(new AggregateState((int) arrayHeaderRedisMessage.length()));
                return null;
            }
            throw new CodecException("this codec doesn't support longer length than 2147483647");
        }
        throw new CodecException("bad length: " + arrayHeaderRedisMessage.length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, RedisMessage redisMessage, List list) throws Exception {
        decode2(channelHandlerContext, redisMessage, (List<Object>) list);
    }

    /* renamed from: decode  reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, RedisMessage redisMessage, List<Object> list) throws Exception {
        if (redisMessage instanceof ArrayHeaderRedisMessage) {
            redisMessage = decodeRedisArrayHeader((ArrayHeaderRedisMessage) redisMessage);
            if (redisMessage == null) {
                return;
            }
        } else {
            ReferenceCountUtil.retain(redisMessage);
        }
        while (!this.depths.isEmpty()) {
            AggregateState peek = this.depths.peek();
            peek.children.add(redisMessage);
            if (peek.children.size() != peek.length) {
                return;
            }
            redisMessage = new ArrayRedisMessage(peek.children);
            this.depths.pop();
        }
        list.add(redisMessage);
    }
}
