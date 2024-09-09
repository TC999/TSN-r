package com.bytedance.sdk.openadsdk.core.p.xv.xv;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    protected Context f34383c;
    protected boolean sr = true;

    /* renamed from: w  reason: collision with root package name */
    protected me f34384w;
    protected int xv;

    public void c(Context context) {
        this.f34383c = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sr() {
        int xv = ys.xv(this.f34383c);
        me meVar = this.f34384w;
        if (meVar == null) {
            return false;
        }
        int bk = ia.bk(meVar);
        if (bk != -1) {
            if (bk != 0) {
                if (bk != 2) {
                    if (bk != 3) {
                        if (k.sr().xv(xv)) {
                            return false;
                        }
                        int i4 = 104857600;
                        com.bytedance.sdk.openadsdk.core.u.sr ix = this.f34384w.ix();
                        if (ix != null && ix.r() > 0) {
                            i4 = ix.r();
                        }
                        if (i4 <= ia.t(this.f34384w)) {
                            return false;
                        }
                    }
                } else if (xv == 4) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return !k.sr().xv(xv);
    }

    public int w() {
        return this.xv;
    }

    abstract boolean xv();

    public void c(me meVar) {
        this.f34384w = meVar;
    }

    public void c(boolean z3) {
        this.sr = z3;
    }

    public boolean c() {
        Context context;
        if (this.f34384w == null || (context = this.f34383c) == null) {
            return true;
        }
        if (this.sr) {
            if (ys.xv(context) == 0) {
                try {
                    Context context2 = this.f34383c;
                    Toast.makeText(context2, i.c(context2, "tt_no_network"), 0).show();
                } catch (Throwable unused) {
                }
            }
            boolean xv = xv();
            if (xv) {
                f.f34385c = true;
                f.xv = true;
            }
            return xv;
        }
        return false;
    }
}
