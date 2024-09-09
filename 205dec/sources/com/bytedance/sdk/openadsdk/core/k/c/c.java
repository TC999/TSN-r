package com.bytedance.sdk.openadsdk.core.k.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.interact.fp;
import com.bytedance.sdk.component.adexpress.w.k;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.eq;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.p.xv.xv.f;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.u;
import com.bytedance.sdk.openadsdk.core.w.sr;
import com.bytedance.sdk.openadsdk.core.w.xv;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends sr implements com.bytedance.sdk.component.adexpress.dynamic.ux.c, xv {

    /* renamed from: a  reason: collision with root package name */
    private int f33840a;

    /* renamed from: c  reason: collision with root package name */
    private k f33841c;

    /* renamed from: k  reason: collision with root package name */
    private fp f33842k;

    /* renamed from: p  reason: collision with root package name */
    private View f33843p;
    private WeakReference<ViewGroup> sr;
    private volatile boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f33844w;
    private me xv;

    public c(me meVar, WeakReference<ViewGroup> weakReference) {
        super(null);
        this.ux = false;
        this.f33840a = Integer.MIN_VALUE;
        this.xv = meVar;
        this.sr = weakReference;
    }

    private JSONObject sr(View view) {
        try {
            Object tag = view.getTag(2097610716);
            if (tag != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("openPlayableLandingPage", tag);
                return jSONObject;
            }
            return new JSONObject();
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    private void xv(View view) {
        try {
            c(view, ((Integer) view.getTag()).intValue());
        } catch (ArrayIndexOutOfBoundsException e4) {
            e4.printStackTrace();
            a.c(e4.getMessage());
        } catch (Exception e5) {
            a.f("DynamicClickListener", e5.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ux.c
    public void c(k kVar) {
        this.f33841c = kVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ux.c
    public void w(View view) {
        this.f35366r.c(view);
    }

    private void w() {
        WeakReference<ViewGroup> weakReference = this.sr;
        if (weakReference == null || weakReference.get() == null || !eq.c(this.sr.get())) {
            return;
        }
        this.f33840a = 1;
        xv(this.f33843p);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ux.c
    public void c(boolean z3, fp fpVar) {
        this.ux = true;
        this.f33844w = z3;
        this.f33842k = fpVar;
        WeakReference<ViewGroup> weakReference = this.sr;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        eq.c(this.sr, this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ux.c
    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f33840a = jSONObject.optInt("convertActionType", Integer.MIN_VALUE);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ux.c
    public void c(View view) {
        this.f35366r.w(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.sr
    public void c(View view, gd gdVar) {
        this.f33843p = view;
        if (this.ux) {
            this.ux = false;
        } else {
            xv(view);
        }
    }

    private void c(View view, int i4) {
        CharSequence text;
        if (this.f33841c != null) {
            if (this.f33844w && this.xv != null) {
                f.sr = true;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            View ux = this.f35366r.ux();
            if (ux != null) {
                int[] c4 = xk.c(ux);
                if (c4 != null) {
                    iArr = c4;
                }
                int[] xv = xk.xv(ux);
                if (xv != null) {
                    iArr2 = xv;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null && text.toString().contains("\u4e0b\u8f7d")) {
                    jSONObject.put("is_compliant_download", true);
                }
                jSONObject.putOpt("convertActionType", Integer.valueOf(this.f33840a));
            } catch (Throwable unused) {
            }
            this.f33841c.c(view, i4, new u.c().sr(this.f35366r.bk()).xv(this.f35366r.t()).w(this.f35366r.ys()).c(this.f35366r.fp()).w(this.f35366r.k()).c(this.f35366r.a()).c(iArr[0]).w(iArr[1]).xv(iArr2[0]).sr(iArr2[1]).c(sr(view)).xv(String.valueOf(i4)).w(String.valueOf(view.getTag(2097610714))).c(String.valueOf(view.getTag(2097610715))).sr(String.valueOf(view.getTag(2097610713))).c(this.f35366r.sr()).c(jSONObject).c(this.f35366r.gd()).c());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.xv
    public void c() {
        w();
        this.ux = false;
        fp fpVar = this.f33842k;
        if (fpVar != null) {
            fpVar.ux();
        }
    }
}
