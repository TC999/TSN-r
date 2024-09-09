package com.bytedance.sdk.openadsdk.core.eq;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.ia;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, c> f33219c = Collections.synchronizedMap(new HashMap());

    /* renamed from: w  reason: collision with root package name */
    private static com.bytedance.sdk.openadsdk.core.ia f33220w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void w();

        void xv();
    }

    public static void sr(String str) {
        c(str, 3);
    }

    public static c ux(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f33219c.remove(str);
    }

    static /* synthetic */ com.bytedance.sdk.openadsdk.core.ia w() {
        return xv();
    }

    public static void xv(com.bytedance.sdk.openadsdk.core.u.me meVar, Context context, String str) {
        int fp = com.bytedance.sdk.openadsdk.core.u.ia.fp(meVar);
        if (meVar == null || context == null) {
            return;
        }
        if (meVar.v() == 4 || fp != 0) {
            com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(context, meVar, str);
            if (c4 instanceof com.bytedance.sdk.openadsdk.core.p.xv.f) {
                ((com.bytedance.sdk.openadsdk.core.p.xv.f) c4).c().c(false);
            }
            c4.w(com.bytedance.sdk.openadsdk.core.u.me.ux(meVar));
        }
    }

    public static void c(Context context, String str, String str2, String str3, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.c(context, str, str2, str3);
    }

    public static void w(final Context context, final String str, final String str2, final String str3, final c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.f.2
            @Override // java.lang.Runnable
            public void run() {
                boolean c4 = com.bytedance.sdk.openadsdk.core.k.sr().c(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                    if (f.f33219c.containsKey(str)) {
                        return;
                    }
                    if (!wv.sr() && !c4) {
                        return;
                    }
                }
                f.c(str, cVar);
                TTDelegateActivity.w(context, str, str2, str3);
            }
        });
    }

    public static void c(final Context context, final String str, final String str2, final String str3, final c cVar, final com.bytedance.sdk.openadsdk.core.ugeno.r.r rVar, final com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.f.1
            @Override // java.lang.Runnable
            public void run() {
                boolean c4 = com.bytedance.sdk.openadsdk.core.k.sr().c(true);
                if (!com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
                    if (f.f33219c.containsKey(str)) {
                        return;
                    }
                    if (!wv.sr() && !c4) {
                        return;
                    }
                }
                f.c(str, cVar);
                TTDelegateActivity.c(context, str, str2, str3, rVar, meVar);
            }
        });
    }

    public static void w(final com.bytedance.sdk.openadsdk.core.u.me meVar, final Context context, final String str) {
        if (meVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, meVar.jr(), meVar.o(), new c() { // from class: com.bytedance.sdk.openadsdk.core.eq.f.4
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                f.xv(com.bytedance.sdk.openadsdk.core.u.me.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
            }
        });
    }

    public static void xv(String str) {
        c(str, 2);
    }

    private static com.bytedance.sdk.openadsdk.core.ia xv() {
        if (f33220w == null) {
            f33220w = ia.c.c(com.bytedance.sdk.openadsdk.core.multipro.aidl.c.c(com.bytedance.sdk.openadsdk.core.ls.getContext()).c(2));
        }
        return f33220w;
    }

    public static void c(String str) {
        Map<String, c> map = f33219c;
        if (map != null) {
            map.remove(str);
        }
    }

    public static void w(Context context, String str, String str2, c cVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, cVar);
        TTDelegateActivity.xv(context, str2, str);
    }

    public static void c(Context context, String str, c cVar, String str2) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.w(context, str, str2);
    }

    public static void w(String str) {
        c(str, 1);
    }

    public static void c(final com.bytedance.sdk.openadsdk.core.u.me meVar, final Context context, final String str) {
        if (meVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, meVar.jr(), new c() { // from class: com.bytedance.sdk.openadsdk.core.eq.f.3
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                f.xv(com.bytedance.sdk.openadsdk.core.u.me.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
            }
        }, meVar.o());
    }

    public static void c(Context context, String str, String str2, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.c(context, str, str2);
    }

    public static void c(final Context context, final com.bytedance.sdk.openadsdk.core.u.me meVar, final String str) {
        if (meVar == null) {
            return;
        }
        String jr = meVar.jr();
        if (TextUtils.isEmpty(jr)) {
            return;
        }
        c(jr, new c() { // from class: com.bytedance.sdk.openadsdk.core.eq.f.5
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                f.xv(com.bytedance.sdk.openadsdk.core.u.me.this, context, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
            }
        });
        com.bytedance.sdk.openadsdk.core.u.ux zg = meVar.zg();
        if (zg == null) {
            return;
        }
        TTDelegateActivity.xv(context, jr, zg.gd());
    }

    public static void c(Context context, String str) {
        TTDelegateActivity.c(context, str);
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(str);
    }

    public static void c(Context context, String str, String str2, String str3, String str4, String str5, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.c(context, str, str2, str3, str4, str5);
    }

    public static void c(Context context, String str, boolean z3, c cVar) {
        if (z3) {
            TTDelegateActivity.c(context, str, z3);
        } else if (TextUtils.isEmpty(str) || cVar == null) {
        } else {
            c(str, cVar);
            TTDelegateActivity.c(context, str, z3);
        }
    }

    public static void c(final String str, final c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("addDialogListener") { // from class: com.bytedance.sdk.openadsdk.core.eq.f.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        f.w().c(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.w.c(cVar));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        } else {
            f33219c.put(str, cVar);
        }
    }

    private static void c(final String str, final int i4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.w.xv()) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("doHandler") { // from class: com.bytedance.sdk.openadsdk.core.eq.f.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        f.w().c(str, i4);
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
            return;
        }
        c ux = ux(str);
        if (ux == null) {
            return;
        }
        if (i4 == 1) {
            ux.c();
        } else if (i4 == 2) {
            ux.w();
        } else if (i4 != 3) {
            ux.xv();
        } else {
            ux.xv();
        }
    }

    public static void c(Context context, String str, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        TTDelegateActivity.c(context, str, meVar);
    }

    public static void c(Context context, final com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return;
        }
        new c.C0472c().ux(meVar.jr()).c("pangle_logo").w("open_policy").sr(meVar.cf()).c(new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.f.8
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_info", com.bytedance.sdk.openadsdk.core.u.me.this.py());
                jSONObject2.put("ad_slot_type", wv.ev(com.bytedance.sdk.openadsdk.core.u.me.this));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
        TTDelegateActivity.w(context, meVar.py());
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null || meVar.ds() || meVar.iw() == null || com.bytedance.sdk.openadsdk.core.u.ia.k(meVar) == 1 || meVar.v() != 4 || com.bytedance.sdk.openadsdk.core.u.ia.p(meVar) == 0) {
            return false;
        }
        int r3 = meVar.r();
        return r3 == 4 || r3 == 5;
    }
}
