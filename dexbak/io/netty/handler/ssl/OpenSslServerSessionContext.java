package io.netty.handler.ssl;

import org.apache.tomcat.jni.SSLContext;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class OpenSslServerSessionContext extends OpenSslSessionContext {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslServerSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext) {
        super(referenceCountedOpenSslContext);
    }

    @Override // javax.net.ssl.SSLSessionContext
    public int getSessionCacheSize() {
        return (int) SSLContext.getSessionCacheSize(this.context.ctx);
    }

    @Override // javax.net.ssl.SSLSessionContext
    public int getSessionTimeout() {
        return (int) SSLContext.getSessionCacheTimeout(this.context.ctx);
    }

    @Override // io.netty.handler.ssl.OpenSslSessionContext
    public boolean isSessionCacheEnabled() {
        return SSLContext.getSessionCacheMode(this.context.ctx) == 2;
    }

    @Override // io.netty.handler.ssl.OpenSslSessionContext
    public void setSessionCacheEnabled(boolean z) {
        SSLContext.setSessionCacheMode(this.context.ctx, z ? 2L : 0L);
    }

    @Override // javax.net.ssl.SSLSessionContext
    public void setSessionCacheSize(int i) {
        if (i >= 0) {
            SSLContext.setSessionCacheSize(this.context.ctx, i);
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean setSessionIdContext(byte[] bArr) {
        return SSLContext.setSessionIdContext(this.context.ctx, bArr);
    }

    @Override // javax.net.ssl.SSLSessionContext
    public void setSessionTimeout(int i) {
        if (i >= 0) {
            SSLContext.setSessionCacheTimeout(this.context.ctx, i);
            return;
        }
        throw new IllegalArgumentException();
    }
}
