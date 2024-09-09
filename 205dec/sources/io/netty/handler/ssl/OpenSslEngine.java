package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class OpenSslEngine extends ReferenceCountedOpenSslEngine {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslEngine(OpenSslContext openSslContext, ByteBufAllocator byteBufAllocator, String str, int i4) {
        super(openSslContext, byteBufAllocator, str, i4, false);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}
