package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.handler.codec.DecoderResult;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultStompContentSubframe extends DefaultByteBufHolder implements StompContentSubframe {
    private DecoderResult decoderResult;

    public DefaultStompContentSubframe(ByteBuf byteBuf) {
        super(byteBuf);
        this.decoderResult = DecoderResult.SUCCESS;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        this.decoderResult = decoderResult;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        return "DefaultStompContent{decoderResult=" + this.decoderResult + '}';
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public StompContentSubframe copy() {
        return (StompContentSubframe) super.copy();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public StompContentSubframe duplicate() {
        return (StompContentSubframe) super.duplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public StompContentSubframe replace(ByteBuf byteBuf) {
        return new DefaultStompContentSubframe(byteBuf);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public StompContentSubframe retainedDuplicate() {
        return (StompContentSubframe) super.retainedDuplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public StompContentSubframe retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public StompContentSubframe touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public StompContentSubframe retain(int i) {
        super.retain(i);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public StompContentSubframe touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
