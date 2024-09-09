package io.netty.handler.codec.http2;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class InboundHttp2ToHttpPriorityAdapterBuilder extends AbstractInboundHttp2ToHttpAdapterBuilder<InboundHttp2ToHttpPriorityAdapter, InboundHttp2ToHttpPriorityAdapterBuilder> {
    public InboundHttp2ToHttpPriorityAdapterBuilder(Http2Connection http2Connection) {
        super(http2Connection);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpPriorityAdapterBuilder maxContentLength(int i4) {
        return (InboundHttp2ToHttpPriorityAdapterBuilder) super.maxContentLength(i4);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpPriorityAdapterBuilder propagateSettings(boolean z3) {
        return (InboundHttp2ToHttpPriorityAdapterBuilder) super.propagateSettings(z3);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpPriorityAdapterBuilder validateHttpHeaders(boolean z3) {
        return (InboundHttp2ToHttpPriorityAdapterBuilder) super.validateHttpHeaders(z3);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpPriorityAdapter build() {
        return (InboundHttp2ToHttpPriorityAdapter) super.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpPriorityAdapter build(Http2Connection http2Connection, int i4, boolean z3, boolean z4) throws Exception {
        return new InboundHttp2ToHttpPriorityAdapter(http2Connection, i4, z3, z4);
    }
}
