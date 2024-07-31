package io.netty.handler.codec.socksx;

import io.netty.handler.codec.DecoderResult;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractSocksMessage implements SocksMessage {
    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        if (decoderResult != null) {
            this.decoderResult = decoderResult;
            return;
        }
        throw new NullPointerException("decoderResult");
    }
}
