package com.bytedance.sdk.component.xv.w;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class ck {
    public static ck c(i iVar, String str) {
        Charset charset = com.bytedance.sdk.component.xv.w.c.xv.ux;
        if (iVar != null) {
            Charset xv = iVar.xv();
            if (xv == null) {
                iVar = i.c(iVar + "; charset=utf-8");
            } else {
                charset = xv;
            }
        }
        return c(iVar, str.getBytes(charset));
    }

    public abstract i c();

    public abstract void c(com.bytedance.sdk.component.xv.c.sr srVar) throws IOException;

    public long w() throws IOException {
        return -1L;
    }

    public static ck c(i iVar, byte[] bArr) {
        return c(iVar, bArr, 0, bArr.length);
    }

    public static ck c(final i iVar, final byte[] bArr, final int i4, final int i5) {
        if (bArr != null) {
            com.bytedance.sdk.component.xv.w.c.xv.c(bArr.length, i4, i5);
            return new ck() { // from class: com.bytedance.sdk.component.xv.w.ck.1
                @Override // com.bytedance.sdk.component.xv.w.ck
                public i c() {
                    return i.this;
                }

                @Override // com.bytedance.sdk.component.xv.w.ck
                public long w() {
                    return i5;
                }

                @Override // com.bytedance.sdk.component.xv.w.ck
                public void c(com.bytedance.sdk.component.xv.c.sr srVar) throws IOException {
                    srVar.xv(bArr, i4, i5);
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
