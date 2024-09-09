package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.i;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static AtomicInteger f34957c = new AtomicInteger();

    /* renamed from: w  reason: collision with root package name */
    private static final HashSet<String> f34958w;

    static {
        HashSet<String> hashSet = new HashSet<>();
        f34958w = hashSet;
        hashSet.add("1473");
        hashSet.add("3682");
        hashSet.add("4760");
    }

    public static int c(me meVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.gd.c fp;
        JSONObject xv;
        int optInt;
        if (meVar == null || (fp = meVar.fp()) == null || (xv = fp.xv()) == null || (optInt = xv.optInt("pre_request_ad_num", 4)) <= 0) {
            return 4;
        }
        return optInt;
    }

    public static boolean ev(me meVar) {
        return meVar != null && meVar.r() > 0;
    }

    public static boolean f(me meVar) {
        if (meVar == null) {
            return false;
        }
        return r(meVar) || ev(meVar);
    }

    public static boolean gd(me meVar) {
        return meVar != null && meVar.ld() == 7;
    }

    public static boolean k(me meVar) {
        return (meVar == null || meVar.il() == null) ? false : true;
    }

    public static boolean p(me meVar) {
        return (meVar == null || meVar.rh() == null || w(meVar.rh().p(), meVar.rh().gd()) == null) ? false : true;
    }

    public static boolean r(me meVar) {
        return (meVar == null || meVar.t() != 1 || fp.c(meVar)) ? false : true;
    }

    public static boolean sr(me meVar) {
        if (meVar == null) {
            return false;
        }
        int t3 = meVar.t();
        com.bytedance.sdk.openadsdk.core.ugeno.f.c ys = meVar.ys();
        return ys != null && t3 == 1 && ys.sr() == 3;
    }

    public static boolean ux(me meVar) {
        if (meVar == null) {
            return false;
        }
        int t3 = meVar.t();
        com.bytedance.sdk.openadsdk.core.ugeno.f.c ys = meVar.ys();
        return ys != null && t3 == 1 && ys.sr() == 2;
    }

    public static boolean w(me meVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.gd.c fp;
        JSONObject xv;
        return (meVar == null || (fp = meVar.fp()) == null || (xv = fp.xv()) == null || xv.optInt("reward_slide_type", 0) != 1) ? false : true;
    }

    public static boolean xv(me meVar) {
        if (meVar == null) {
            return false;
        }
        int t3 = meVar.t();
        com.bytedance.sdk.openadsdk.core.ugeno.f.c ys = meVar.ys();
        return ys != null && t3 == 1 && ys.sr() == 4;
    }

    public static JSONObject c(Context context, me meVar) {
        int i4;
        JSONObject mo = meVar.mo();
        JSONObject jSONObject = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.core.z.c fz = ls.w().fz(String.valueOf(wv.gd(meVar)));
            if (com.bytedance.sdk.openadsdk.core.component.reward.sr.sr.c(meVar) == 4) {
                i4 = fz.xv;
            } else {
                i4 = fz.f35739k;
            }
            boolean z3 = true;
            if (i4 != 1) {
                z3 = false;
            }
            jSONObject.put("voice_control", z3);
            mo.put("setting", jSONObject);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return mo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sr(final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.ev.w.w xv = com.bytedance.sdk.openadsdk.core.q.ux.c().w().xv();
        if (xv == null) {
            return;
        }
        xv.c(str2);
        xv.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.f.2
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                if (wVar != null) {
                    try {
                        if (!wVar.ev() || wVar.sr() == null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.xv.c().c(str, wVar.sr());
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
            }
        });
    }

    public static JSONObject w(String str, String str2) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        if (c4 == null) {
            return null;
        }
        try {
            return new JSONObject(c4.w(str, ""));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(String str, String str2, t tVar) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        com.bytedance.sdk.component.ev.w.w xv = com.bytedance.sdk.openadsdk.core.q.ux.c().w().xv();
        if (xv == null) {
            if (tVar != null) {
                tVar.w();
                return;
            }
            return;
        }
        xv.c(str2);
        com.bytedance.sdk.component.ev.w c4 = xv.c();
        if (c4 != null) {
            try {
                if (!c4.ev() || c4.sr() == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.xv.c().c(str, c4.sr());
                if (tVar != null) {
                    tVar.c();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (tVar != null) {
                    tVar.w();
                }
            }
        }
    }

    public static int w(Context context, me meVar, String str) {
        if (meVar == null) {
            return -1;
        }
        i il = meVar.il();
        if (il == null) {
            return -2;
        }
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        if (str.length() > 15) {
            return 4;
        }
        if (context == null || context.getResources().getConfiguration().orientation == 1) {
            String w3 = il.w();
            if (w(il.xv(), w3) == null) {
                return TextUtils.isEmpty(w3) ? 2 : 3;
            }
            return 1;
        }
        return 9;
    }

    public static void c(List<me> list, t tVar) {
        if (list == null || list.size() <= 0) {
            if (tVar != null) {
                tVar.w();
                return;
            }
            return;
        }
        ArrayList<me.c> arrayList = new ArrayList();
        for (me meVar : list) {
            if (meVar != null && meVar.rh() != null && gd(meVar) && (!TextUtils.isEmpty(meVar.rh().gd()) || !TextUtils.isEmpty(meVar.rh().p()))) {
                arrayList.add(meVar.rh());
            }
        }
        if (arrayList.size() <= 0) {
            tVar.w();
            return;
        }
        for (me.c cVar : arrayList) {
            c(cVar, tVar);
        }
    }

    public static void c(me.c cVar) {
        com.bytedance.sdk.component.f.c c4;
        if (cVar == null) {
            return;
        }
        final String gd = cVar.gd();
        final String p3 = cVar.p();
        if ((TextUtils.isEmpty(gd) && TextUtils.isEmpty(p3)) || (c4 = com.bytedance.sdk.openadsdk.core.xv.c()) == null) {
            return;
        }
        if (TextUtils.isEmpty(p3) || TextUtils.isEmpty(c4.w(p3, ""))) {
            ev.c(new p("saveUGenoTemplate") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.sr(p3, gd);
                }
            }, 10);
        }
    }

    public static void c(String str, String str2) {
        com.bytedance.sdk.component.f.c c4;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || (c4 = com.bytedance.sdk.openadsdk.core.xv.c()) == null) {
            return;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c4.w(str2, ""))) {
            sr(str2, str);
        }
    }

    private static void c(me.c cVar, t tVar) {
        String gd = cVar.gd();
        String p3 = cVar.p();
        if (TextUtils.isEmpty(gd) && TextUtils.isEmpty(p3)) {
            if (tVar != null) {
                tVar.w();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(p3)) {
            p3 = gd;
        }
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        if (c4 == null) {
            if (tVar != null) {
                tVar.w();
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(c4.w(p3, ""))) {
                if (TextUtils.isEmpty(gd)) {
                    tVar.w();
                }
                c(p3, gd, tVar);
            } else if (tVar != null) {
                tVar.c();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            if (tVar != null) {
                tVar.w();
            }
        }
    }

    public static void c(final String str, final String str2, final t tVar) {
        if (com.bytedance.sdk.openadsdk.core.xv.c() == null) {
            tVar.w();
        } else {
            ev.c(new p("saveUGenoTemplate") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.f.3
                @Override // java.lang.Runnable
                public void run() {
                    f.xv(str, str2, tVar);
                }
            }, 10);
        }
    }

    public static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean c(Context context, me meVar, String str) {
        return w(context, meVar, str) == 1;
    }

    public static String c(Context context, String str, me meVar, String str2) {
        i il = meVar.il();
        JSONObject tn = meVar.tn();
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(CampaignEx.JSON_KEY_ICON_URL, str2);
            }
            String ju = meVar.ju();
            if (!TextUtils.isEmpty(ju)) {
                jSONObject.put("description", ju);
            }
            if (tn != null) {
                jSONObject.put("easy_pl_material", tn.toString());
            }
            if (il != null) {
                jSONObject.put("ugen_dialog_url", il.w());
                jSONObject.put("ugen_dialog_md5", il.xv());
            }
            if (context != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    jSONObject.put("vertical", "true");
                } else {
                    jSONObject.put("vertical", "false");
                }
            }
            return jSONObject.toString();
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
