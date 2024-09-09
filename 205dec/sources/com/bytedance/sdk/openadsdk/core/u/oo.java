package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class oo {

    /* renamed from: c  reason: collision with root package name */
    private boolean f34799c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34800f;

    /* renamed from: r  reason: collision with root package name */
    private au f34801r;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private int f34802w;
    private int xv;

    public oo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("splash_card");
        if (optJSONObject != null) {
            this.f34800f = true;
            this.f34799c = optJSONObject.optBoolean("click_on_close", false);
            this.f34802w = optJSONObject.optInt("card_stay_count_down", 5);
            this.xv = optJSONObject.optInt("card_click_area", 2);
            this.ux = optJSONObject.optString("card_text", "\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
            int optInt = optJSONObject.optInt("splash_card_style_id", 0);
            this.ev = optInt;
            if (optInt == 1) {
                this.sr = optJSONObject.optString("card_top_text", "\u6447\u4e00\u6447\u6216\u70b9\u51fb\u4e86\u89e3\u66f4\u591a");
            } else {
                this.sr = optJSONObject.optString("card_top_text", "\u70b9\u51fb\u8df3\u8f6c");
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("splash_icon");
        if (optJSONObject2 != null) {
            au auVar = new au();
            auVar.w(optJSONObject2.optInt("splash_icon_height", 72));
            auVar.c(optJSONObject2.optInt("splash_icon_width", 54));
            auVar.c(optJSONObject2.optString("splash_icon_url", ""));
            auVar.sr(optJSONObject2.optInt("splash_icon_video_height", 126));
            auVar.xv(optJSONObject2.optInt("splash_icon_video_width", 71));
            auVar.ux(optJSONObject2.optInt("video_endcard_show_time"));
            auVar.w(optJSONObject2.optString("video_endcard_text"));
            auVar.f(optJSONObject2.optInt("icon_show_time", 5));
            auVar.c(optJSONObject2.optBoolean("is_skip_close", false));
            this.f34801r = auVar;
        }
    }

    public static String a(me meVar) {
        au auVar;
        oo u3 = u(meVar);
        return (u3 == null || (auVar = u3.f34801r) == null) ? "" : auVar.xv();
    }

    public static String bk(me meVar) {
        au auVar;
        oo u3 = u(meVar);
        return (u3 == null || (auVar = u3.f34801r) == null) ? "" : auVar.r();
    }

    public static int ev(me meVar) {
        int i4;
        oo u3 = u(meVar);
        if (u3 != null && (i4 = u3.f34802w) > 0 && i4 <= 5) {
            return i4;
        }
        return 5;
    }

    public static String f(me meVar) {
        oo u3 = u(meVar);
        return u3 == null ? "\u70b9\u51fb\u8df3\u8f6c" : r(meVar) == 1 ? TextUtils.isEmpty(u3.sr) ? "\u6447\u4e00\u6447\u6216\u70b9\u51fb\u4e86\u89e3\u66f4\u591a" : u3.sr : TextUtils.isEmpty(u3.sr) ? "\u70b9\u51fb\u8df3\u8f6c" : u3.sr;
    }

    public static boolean fp(me meVar) {
        if (meVar == null || meVar.kr() == null || !meVar.kr().ux() || meVar.nc() == null || meVar.nc().isEmpty() || !meVar.nc().get(0).ux() || TextUtils.isEmpty(meVar.ny())) {
            return false;
        }
        return (TextUtils.isEmpty(meVar.yh()) && (meVar.ix() == null || TextUtils.isEmpty(meVar.ix().xv()))) ? false : true;
    }

    private static boolean fz(me meVar) {
        oo u3 = u(meVar);
        return (u3 == null || u3.f34801r == null || meVar.y() == 2) ? false : true;
    }

    public static boolean gd(me meVar) {
        oo u3 = u(meVar);
        return u3 == null || u3.xv == 1;
    }

    public static boolean ia(me meVar) {
        au auVar;
        oo u3 = u(meVar);
        if (u3 == null || (auVar = u3.f34801r) == null) {
            return false;
        }
        return auVar.gd();
    }

    public static boolean k(me meVar) {
        au auVar;
        oo u3 = u(meVar);
        if (u3 == null || (auVar = u3.f34801r) == null) {
            return false;
        }
        return !TextUtils.isEmpty(auVar.xv());
    }

    public static boolean p(me meVar) {
        oo u3 = u(meVar);
        if (u3 == null) {
            return true;
        }
        return u3.f34799c;
    }

    public static int r(me meVar) {
        oo u3 = u(meVar);
        if (u3 == null) {
            return 0;
        }
        return u3.ev;
    }

    public static int s(me meVar) {
        au auVar;
        oo u3 = u(meVar);
        if (u3 == null || (auVar = u3.f34801r) == null) {
            return 5;
        }
        return auVar.ev();
    }

    public static boolean sr(me meVar) {
        return (u(meVar) == null || !fz(meVar) || meVar.qf()) ? false : true;
    }

    public static int t(me meVar) {
        au auVar;
        oo u3 = u(meVar);
        if (u3 == null || (auVar = u3.f34801r) == null) {
            return 0;
        }
        return auVar.f();
    }

    private static oo u(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.bw();
    }

    public static String ux(me meVar) {
        oo u3 = u(meVar);
        return (u3 == null || TextUtils.isEmpty(u3.ux)) ? "\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528" : u3.ux;
    }

    public static void w(me meVar) {
        oo u3 = u(meVar);
        if (u3 == null || meVar.qf() || meVar.fh() == 2 || !u3.f34800f || w() >= com.bytedance.sdk.openadsdk.core.ls.w().jd()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.xv.w(meVar, "splash_ad", "if_splash_card");
        if (fp(meVar)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.xv.w(meVar, "splash_ad", "card_show_fail");
    }

    public static boolean xv(me meVar) {
        return u(meVar) != null && fz(meVar) && meVar.qf();
    }

    public static int[] ys(me meVar) {
        int[] iArr = new int[2];
        oo u3 = u(meVar);
        if (u3 == null || u3.f34801r == null) {
            return null;
        }
        if (meVar.qf()) {
            iArr[0] = u3.f34801r.sr();
            iArr[1] = u3.f34801r.ux();
        } else {
            iArr[0] = u3.f34801r.c();
            iArr[1] = u3.f34801r.w();
        }
        return iArr;
    }

    public void c(JSONObject jSONObject) {
        try {
            if (this.f34801r != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("splash_icon_height", this.f34801r.w());
                jSONObject2.put("splash_icon_url", this.f34801r.xv());
                jSONObject2.put("splash_icon_video_height", this.f34801r.ux());
                jSONObject2.put("splash_icon_video_width", this.f34801r.sr());
                jSONObject2.put("splash_icon_width", this.f34801r.c());
                jSONObject2.put("video_endcard_show_time", this.f34801r.f());
                jSONObject2.put("video_endcard_text", this.f34801r.r());
                jSONObject2.put("icon_show_time", this.f34801r.ev());
                jSONObject2.put("is_skip_close", this.f34801r.gd());
                jSONObject.put("splash_icon", jSONObject2);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            if (this.f34800f) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("click_on_close", this.f34799c);
                jSONObject3.put("card_stay_count_down", this.f34802w);
                jSONObject3.put("card_click_area", this.xv);
                jSONObject3.put("card_text", this.ux);
                jSONObject3.put("card_top_text", this.sr);
                jSONObject3.put("splash_card_style_id", this.ev);
                jSONObject.put("splash_card", jSONObject3);
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public static int w() {
        int i4 = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.eq.ba.c(null);
        int w3 = c4.w("splash_card_show_day", -1);
        int w4 = c4.w("splash_card_show_count", 0);
        if (w3 == i4) {
            return w4;
        }
        return 0;
    }

    public static boolean c(me meVar) {
        oo u3 = u(meVar);
        if (u3 != null && !meVar.qf() && meVar.fh() != 2 && u3.f34800f && w() < com.bytedance.sdk.openadsdk.core.ls.w().jd() && fp(meVar)) {
            return u3.f34800f;
        }
        return false;
    }

    public static void c() {
        int i4 = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.eq.ba.c(null);
        int w3 = c4.w("splash_card_show_day", -1) == i4 ? c4.w("splash_card_show_count", 0) : 0;
        c4.c("splash_card_show_day", i4);
        c4.c("splash_card_show_count", w3 + 1);
    }
}
