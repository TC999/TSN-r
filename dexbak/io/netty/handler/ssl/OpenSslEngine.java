package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class OpenSslEngine extends ReferenceCountedOpenSslEngine {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslEngine(OpenSslContext openSslContext, ByteBufAllocator byteBufAllocator, String str, int i) {
        super(openSslContext, byteBufAllocator, str, i, false);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}
