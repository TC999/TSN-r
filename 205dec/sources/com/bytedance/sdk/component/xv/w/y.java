package com.bytedance.sdk.component.xv.w;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class y implements Closeable {
    public static y c(i iVar, byte[] bArr) {
        return c(iVar, bArr.length, new com.bytedance.sdk.component.xv.c.xv().xv(bArr));
    }

    private Charset r() {
        i c4 = c();
        return c4 != null ? c4.c(com.bytedance.sdk.component.xv.w.c.xv.ux) : com.bytedance.sdk.component.xv.w.c.xv.ux;
    }

    public abstract i c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.component.xv.w.c.xv.c(xv());
    }

    public final String f() throws IOException {
        com.bytedance.sdk.component.xv.c.ux xv = xv();
        try {
            String c4 = xv.c(com.bytedance.sdk.component.xv.w.c.xv.c(xv, r()));
            com.bytedance.sdk.component.xv.w.c.xv.c(xv);
            return c4;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.xv.w.c.xv.c(xv);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.xv.w.c.xv.c(xv);
            throw th;
        }
    }

    public final InputStream sr() {
        return xv().f();
    }

    public final byte[] ux() throws IOException {
        long w3 = w();
        if (w3 <= 2147483647L) {
            com.bytedance.sdk.component.xv.c.ux xv = xv();
            try {
                byte[] ia = xv.ia();
                com.bytedance.sdk.component.xv.w.c.xv.c(xv);
                if (w3 == -1 || w3 == ia.length) {
                    return ia;
                }
                throw new IOException("Content-Length (" + w3 + ") and stream length (" + ia.length + ") disagree");
            } catch (Throwable th) {
                com.bytedance.sdk.component.xv.w.c.xv.c(xv);
                throw th;
            }
        }
        throw new IOException("Cannot buffer entire body for content length: " + w3);
    }

    public abstract long w();

    public abstract com.bytedance.sdk.component.xv.c.ux xv();

    public static y c(final i iVar, final long j4, final com.bytedance.sdk.component.xv.c.ux uxVar) {
        if (uxVar != null) {
            return new y() { // from class: com.bytedance.sdk.component.xv.w.y.1
                @Override // com.bytedance.sdk.component.xv.w.y
                public i c() {
                    return i.this;
                }

                @Override // com.bytedance.sdk.component.xv.w.y
                public long w() {
                    return j4;
                }

                @Override // com.bytedance.sdk.component.xv.w.y
                public com.bytedance.sdk.component.xv.c.ux xv() {
                    return uxVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
