package com.bytedance.sdk.component.ux.xv;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.ux.bk;
import com.bytedance.sdk.component.ux.fz;
import com.bytedance.sdk.component.ux.p;
import com.bytedance.sdk.component.ux.xv.xv;
import com.bytedance.sdk.component.ux.ys;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;

@ATS(single = true, value = {"img_service"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements ys {

    /* renamed from: c  reason: collision with root package name */
    private volatile f f30313c;

    @ATSMethod
    private w(Context context, bk bkVar) {
        w(context, bkVar);
    }

    public static ys c(Context context, bk bkVar) {
        return new w(context, bkVar);
    }

    private void w(Context context, bk bkVar) {
        if (this.f30313c != null) {
            Log.w("ImageLoader", "already init!");
        }
        if (bkVar == null) {
            bkVar = ux.c(context);
        }
        this.f30313c = new f(context, bkVar);
    }

    @Override // com.bytedance.sdk.component.ux.ys
    @ATSMethod(4)
    public void xv(double d4) {
        if (this.f30313c != null) {
            c(this.f30313c.xv(), d4);
        }
    }

    @Override // com.bytedance.sdk.component.ux.ys
    @ATSMethod(1)
    public p c(String str) {
        return new xv.w(this.f30313c).c(str);
    }

    @Override // com.bytedance.sdk.component.ux.ys
    @ATSMethod(2)
    public void c(double d4) {
        w(d4);
        xv(d4);
    }

    private void c(Collection<? extends com.bytedance.sdk.component.ux.c> collection, double d4) {
        if (collection == null) {
            return;
        }
        for (com.bytedance.sdk.component.ux.c cVar : collection) {
            cVar.c(d4);
        }
    }

    @Override // com.bytedance.sdk.component.ux.ys
    @ATSMethod(3)
    public void w(double d4) {
        if (this.f30313c != null) {
            c(this.f30313c.c(), d4);
            c(this.f30313c.w(), d4);
        }
    }

    @Override // com.bytedance.sdk.component.ux.ys
    @ATSMethod(5)
    public void c() {
        xv(0.0d);
        w(0.0d);
    }

    @Override // com.bytedance.sdk.component.ux.ys
    @ATSMethod(8)
    public boolean w(String str, String str2, String str3) {
        if (this.f30313c == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.ux.xv.xv.xv.c(str);
        }
        com.bytedance.sdk.component.ux.xv c4 = this.f30313c.c(str3);
        if (c4 != null) {
            return c4.w(str2);
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.ux.ys
    @ATSMethod(6)
    public InputStream c(String str, String str2) {
        if (this.f30313c != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.ux.xv.xv.xv.c(str);
            }
            Collection<fz> w3 = this.f30313c.w();
            if (w3 != null) {
                for (fz fzVar : w3) {
                    byte[] c4 = fzVar.c((fz) str2);
                    if (c4 != null) {
                        return new ByteArrayInputStream(c4);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.ux.xv> xv = this.f30313c.xv();
            if (xv != null) {
                for (com.bytedance.sdk.component.ux.xv xvVar : xv) {
                    InputStream c5 = xvVar.c(str2);
                    if (c5 != null) {
                        return c5;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ux.ys
    @ATSMethod(7)
    public InputStream c(String str, String str2, String str3) {
        if (this.f30313c == null || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str2 = com.bytedance.sdk.component.ux.xv.xv.xv.c(str);
        }
        com.bytedance.sdk.component.ux.xv c4 = this.f30313c.c(str3);
        if (c4 != null) {
            return c4.c(str2);
        }
        return null;
    }
}
