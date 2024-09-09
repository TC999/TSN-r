package io.netty.buffer;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultByteBufHolder implements ByteBufHolder {
    private final ByteBuf data;

    public DefaultByteBufHolder(ByteBuf byteBuf) {
        if (byteBuf != null) {
            this.data = byteBuf;
            return;
        }
        throw new NullPointerException("data");
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        if (this.data.refCnt() > 0) {
            return this.data;
        }
        throw new IllegalReferenceCountException(this.data.refCnt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String contentToString() {
        return this.data.toString();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder copy() {
        return replace(this.data.copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder duplicate() {
        return replace(this.data.duplicate());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ByteBufHolder) {
            return this.data.equals(((ByteBufHolder) obj).content());
        }
        return false;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.data.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.data.release();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf byteBuf) {
        return new DefaultByteBufHolder(byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retainedDuplicate() {
        return replace(this.data.retainedDuplicate());
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + contentToString() + ')';
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i4) {
        return this.data.release(i4);
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder retain() {
        this.data.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder touch() {
        this.data.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder retain(int i4) {
        this.data.retain(i4);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder touch(Object obj) {
        this.data.touch(obj);
        return this;
    }
}
