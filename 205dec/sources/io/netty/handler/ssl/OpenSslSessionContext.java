package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import org.apache.tomcat.jni.SSLContext;
import org.apache.tomcat.jni.SessionTicketKey;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class OpenSslSessionContext implements SSLSessionContext {
    private static final Enumeration<byte[]> EMPTY = new EmptyEnumeration();
    final ReferenceCountedOpenSslContext context;
    private final OpenSslSessionStats stats;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static final class EmptyEnumeration implements Enumeration<byte[]> {
        private EmptyEnumeration() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public byte[] nextElement() {
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSslSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext) {
        this.context = referenceCountedOpenSslContext;
        this.stats = new OpenSslSessionStats(referenceCountedOpenSslContext);
    }

    @Override // javax.net.ssl.SSLSessionContext
    public Enumeration<byte[]> getIds() {
        return EMPTY;
    }

    @Override // javax.net.ssl.SSLSessionContext
    public SSLSession getSession(byte[] bArr) {
        if (bArr != null) {
            return null;
        }
        throw new NullPointerException("bytes");
    }

    public abstract boolean isSessionCacheEnabled();

    public abstract void setSessionCacheEnabled(boolean z3);

    @Deprecated
    public void setTicketKeys(byte[] bArr) {
        ObjectUtil.checkNotNull(bArr, "keys");
        SSLContext.clearOptions(this.context.ctx, 16384);
        SSLContext.setSessionTicketKeys(this.context.ctx, bArr);
    }

    public OpenSslSessionStats stats() {
        return this.stats;
    }

    public void setTicketKeys(OpenSslSessionTicketKey... openSslSessionTicketKeyArr) {
        ObjectUtil.checkNotNull(openSslSessionTicketKeyArr, "keys");
        SSLContext.clearOptions(this.context.ctx, 16384);
        int length = openSslSessionTicketKeyArr.length;
        SessionTicketKey[] sessionTicketKeyArr = new SessionTicketKey[length];
        for (int i4 = 0; i4 < length; i4++) {
            sessionTicketKeyArr[i4] = openSslSessionTicketKeyArr[i4].key;
        }
        SSLContext.setSessionTicketKeys(this.context.ctx, sessionTicketKeyArr);
    }
}
