package com.bytedance.sdk.component.ux.sr;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ux.t;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends c {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f30243c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.ux.f f30244w;

    public ux(byte[] bArr, com.bytedance.sdk.component.ux.f fVar) {
        this.f30243c = bArr;
        this.f30244w = fVar;
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "decode";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        com.bytedance.sdk.component.ux.xv.f u3 = xvVar.u();
        com.bytedance.sdk.component.ux.xv.w.c c4 = u3.c(xvVar);
        try {
            t j4 = xvVar.j();
            if (j4 != null) {
                j4.c(10, null);
            }
            Bitmap c5 = c4.c(this.f30243c);
            if (c5 != null) {
                xvVar.c(new bk(c5, this.f30244w, false));
                u3.c(xvVar.i()).c(xvVar.r(), c5);
            } else {
                c(1002, "decode failed bitmap null", null, xvVar);
            }
            if (j4 != null) {
                j4.c(11, c5);
            }
        } catch (Throwable th) {
            c(1002, "decode failed:" + th.getMessage(), th, xvVar);
        }
    }

    private void c(int i4, String str, Throwable th, com.bytedance.sdk.component.ux.xv.xv xvVar) {
        if (this.f30244w == null) {
            xvVar.c(new k());
        } else {
            xvVar.c(new ev(i4, str, th));
        }
    }
}
