package io.netty.handler.codec.redis;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ArrayRedisMessage extends AbstractReferenceCounted implements RedisMessage {
    private final List<RedisMessage> children;
    public static final ArrayRedisMessage NULL_INSTANCE = new ArrayRedisMessage() { // from class: io.netty.handler.codec.redis.ArrayRedisMessage.1
        @Override // io.netty.handler.codec.redis.ArrayRedisMessage
        public boolean isNull() {
            return true;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public boolean release() {
            return false;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public boolean release(int i4) {
            return false;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage retain() {
            return this;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage retain(int i4) {
            return this;
        }

        @Override // io.netty.handler.codec.redis.ArrayRedisMessage
        public String toString() {
            return "NullArrayRedisMessage";
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage touch() {
            return this;
        }

        @Override // io.netty.handler.codec.redis.ArrayRedisMessage, io.netty.util.ReferenceCounted
        public ArrayRedisMessage touch(Object obj) {
            return this;
        }
    };
    public static final ArrayRedisMessage EMPTY_INSTANCE = new ArrayRedisMessage() { // from class: io.netty.handler.codec.redis.ArrayRedisMessage.2
        @Override // io.netty.handler.codec.redis.ArrayRedisMessage
        public boolean isNull() {
            return false;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public boolean release() {
            return false;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public boolean release(int i4) {
            return false;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage retain() {
            return this;
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage retain(int i4) {
            return this;
        }

        @Override // io.netty.handler.codec.redis.ArrayRedisMessage
        public String toString() {
            return "EmptyArrayRedisMessage";
        }

        @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ArrayRedisMessage touch() {
            return this;
        }

        @Override // io.netty.handler.codec.redis.ArrayRedisMessage, io.netty.util.ReferenceCounted
        public ArrayRedisMessage touch(Object obj) {
            return this;
        }
    };

    public final List<RedisMessage> children() {
        return this.children;
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        for (RedisMessage redisMessage : this.children) {
            ReferenceCountUtil.release(redisMessage);
        }
    }

    public boolean isNull() {
        return false;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[children=" + this.children.size() + ']';
    }

    private ArrayRedisMessage() {
        this.children = Collections.emptyList();
    }

    @Override // io.netty.util.ReferenceCounted
    public ArrayRedisMessage touch(Object obj) {
        for (RedisMessage redisMessage : this.children) {
            ReferenceCountUtil.touch(redisMessage);
        }
        return this;
    }

    public ArrayRedisMessage(List<RedisMessage> list) {
        this.children = (List) ObjectUtil.checkNotNull(list, "children");
    }
}
