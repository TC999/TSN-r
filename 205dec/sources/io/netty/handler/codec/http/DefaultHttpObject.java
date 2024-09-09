package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultHttpObject implements HttpObject {
    private static final int HASH_CODE_PRIME = 31;
    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttpObject) {
            return decoderResult().equals(((DefaultHttpObject) obj).decoderResult());
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.HttpObject
    @Deprecated
    public DecoderResult getDecoderResult() {
        return decoderResult();
    }

    public int hashCode() {
        return 31 + this.decoderResult.hashCode();
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
