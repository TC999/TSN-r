package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class m {

    /* renamed from: c  reason: collision with root package name */
    private static long f34711c = 27000;

    /* renamed from: w  reason: collision with root package name */
    private static int f34712w = 5;
    private static int xv;

    /* renamed from: a  reason: collision with root package name */
    private int f34713a;
    private int ba;
    private int bk;
    private boolean ck;
    private double ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34714f;
    private boolean fp;
    private double fz;
    private ArrayList<ox> gb;
    private boolean gd;

    /* renamed from: i  reason: collision with root package name */
    private int f34715i;
    private double ia;

    /* renamed from: j  reason: collision with root package name */
    private boolean f34716j;

    /* renamed from: k  reason: collision with root package name */
    private String f34717k;
    private boolean ls;

    /* renamed from: n  reason: collision with root package name */
    private gw f34718n;

    /* renamed from: p  reason: collision with root package name */
    private double f34719p;

    /* renamed from: q  reason: collision with root package name */
    private int f34720q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f34721r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f34722s;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private int f34723t;

    /* renamed from: u  reason: collision with root package name */
    private int f34724u;
    private int ux;
    private int ys;

    /* renamed from: z  reason: collision with root package name */
    private boolean f34725z;

    public m(JSONObject jSONObject) {
        this.f34720q = 0;
        this.f34716j = false;
        this.ls = false;
        this.gb = new ArrayList<>();
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("reward");
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("retain_dialog_config");
            if (optJSONArray != null) {
                this.gb = new ArrayList<>();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                    if (optJSONObject2 != null) {
                        this.gb.add(new ox(optJSONObject2));
                    }
                }
            }
            this.f34718n = new gw(optJSONObject);
            this.f34725z = optJSONObject.optBoolean("endcard_transform_enabled", false);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("reward_data");
        if (optJSONObject3 != null) {
            this.ux = optJSONObject3.optInt("reward_amount", 0);
            this.sr = optJSONObject3.optString("reward_name", "");
            this.f34714f = optJSONObject3.optBoolean("reward_info_show", false);
            this.bk = optJSONObject3.optInt("reward_back_type", 0);
            this.f34723t = optJSONObject3.optInt("reward_backup_timing", 0);
            this.ys = optJSONObject3.optInt("reward_backup_duration", Integer.MAX_VALUE);
            this.ba = optJSONObject3.optInt("reward_is_callback", 0);
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("reward_advanced_config");
            if (optJSONObject4 != null) {
                JSONObject optJSONObject5 = optJSONObject4.optJSONObject("easy_playable");
                if (optJSONObject5 != null) {
                    this.f34721r = optJSONObject5.optBoolean("enable");
                    double optDouble = optJSONObject5.optDouble("propose_reward", 0.0d);
                    this.ev = optDouble;
                    if (optDouble < 0.0d) {
                        this.ev = 0.0d;
                    }
                }
                JSONObject optJSONObject6 = optJSONObject4.optJSONObject("play_complete");
                if (optJSONObject6 != null) {
                    this.gd = optJSONObject6.optBoolean("enable");
                    double optDouble2 = optJSONObject6.optDouble("propose_reward", 0.0d);
                    this.f34719p = optDouble2;
                    if (optDouble2 < 0.0d) {
                        this.f34719p = 0.0d;
                    }
                    this.f34717k = optJSONObject6.optString("tip_toast");
                    this.f34713a = optJSONObject6.optInt("min_duration");
                }
                JSONObject optJSONObject7 = optJSONObject4.optJSONObject("playable_interactive");
                if (optJSONObject7 != null) {
                    this.fp = optJSONObject7.optBoolean("enable");
                    this.ia = optJSONObject7.optDouble("propose_reward", 0.0d);
                }
                JSONObject optJSONObject8 = optJSONObject4.optJSONObject("click_landing");
                if (optJSONObject8 != null) {
                    this.f34722s = optJSONObject8.optBoolean("enable");
                    this.fz = optJSONObject8.optDouble("propose_reward", 0.0d);
                    this.f34724u = optJSONObject8.optInt("landing_view_time", 5);
                }
            }
        }
        this.f34715i = jSONObject.optInt("reward_full_play_time", 30);
        this.f34720q = jSONObject.optInt("reward_full_time_type", 0);
        this.ck = jSONObject.optBoolean("interstitial_bg_transparent", false);
        this.f34716j = jSONObject.optBoolean("__is_use_local_time", false);
        this.ls = jSONObject.optBoolean("__is_click_landing_reward", false);
    }

    public static double a(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return 0.0d;
        }
        return n4.ia;
    }

    public static boolean bk(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return false;
        }
        return n4.f34722s;
    }

    public static void c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            try {
                f34711c = optJSONObject.optLong("reward_time_limited", 27000L);
                f34712w = optJSONObject.optInt("reward_force_close_max_count", 5);
                xv = optJSONObject.optInt("reward_local_countdown_close_style", 0);
            } catch (Exception unused) {
            }
        }
    }

    public static double ev(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return 0.0d;
        }
        return n4.f34719p;
    }

    public static double f(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return 0.0d;
        }
        return n4.ev;
    }

    public static int fp(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return 0;
        }
        return n4.f34720q;
    }

    public static boolean fz(me meVar) {
        m n4 = n(meVar);
        if (n4 != null && n4.ls) {
            return bk(meVar);
        }
        return false;
    }

    public static boolean gb(me meVar) {
        m n4 = n(meVar);
        return n4 != null && n4.ba == 1;
    }

    public static String gd(me meVar) {
        m n4 = n(meVar);
        return n4 == null ? "" : TextUtils.isEmpty(n4.f34717k) ? "\u522b\u6025\u7740\u8df3\u8fc7\uff0c\u7ee7\u7eed\u89c2\u770b\u5b8c\u6574\u89c6\u9891\uff0c\u53ef\u83b7\u5f97\u66f4\u591a\u989d\u5916\u5956\u52b1\uff5e" : n4.f34717k;
    }

    public static boolean i(me meVar) {
        m n4 = n(meVar);
        return n4 != null && n4.f34723t == 1;
    }

    public static boolean ia(me meVar) {
        m n4 = n(meVar);
        if (n4 != null && n4.f34716j) {
            return fp.sr(meVar) || fp(meVar) == 1 || fp(meVar) == 2;
        }
        return false;
    }

    public static boolean j(me meVar) {
        m n4 = n(meVar);
        if (n4 != null) {
            return n4.ck;
        }
        return false;
    }

    public static boolean k(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return false;
        }
        return n4.fp;
    }

    public static boolean ls(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return false;
        }
        return n4.f34725z;
    }

    private static m n(me meVar) {
        if (meVar == null) {
            return null;
        }
        return meVar.ba();
    }

    public static int p(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return 30000;
        }
        int max = Math.max(n4.f34713a, 30);
        return (max <= 60 ? max : 30) * 1000;
    }

    public static gw q(me meVar) {
        m n4 = n(meVar);
        if (n4 != null) {
            return n4.f34718n;
        }
        return null;
    }

    public static boolean r(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return false;
        }
        return n4.gd;
    }

    public static boolean s(me meVar) {
        m n4 = n(meVar);
        return n4 != null && n4.f34716j && fp(meVar) == 1;
    }

    public static boolean sr(me meVar) {
        m n4 = n(meVar);
        return n4 != null && n4.bk == 1;
    }

    public static int t(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return 5;
        }
        return Math.max(5, n4.f34724u);
    }

    public static ArrayList<ox> u(me meVar) {
        m n4 = n(meVar);
        if (n4 != null) {
            return n4.gb;
        }
        return new ArrayList<>();
    }

    public static boolean ux(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return false;
        }
        return n4.f34721r;
    }

    public static void w(com.bytedance.sdk.component.f.c cVar) {
        f34711c = cVar.w("reward_time_limited", 27000L);
        f34712w = cVar.w("reward_force_close_max_count", 5);
        xv = cVar.w("reward_local_countdown_close_style", 0);
    }

    public static boolean xv(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return false;
        }
        return n4.f34714f;
    }

    public static int ys(me meVar) {
        int i4;
        m n4 = n(meVar);
        if (n4 != null && (i4 = n4.f34715i) >= 10 && i4 <= 60) {
            return i4;
        }
        return 30;
    }

    public static boolean xv() {
        return xv == 1;
    }

    public void w(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<ox> arrayList = this.gb;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<ox> it = this.gb.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().c());
                }
            }
            jSONObject2.put("retain_dialog_config", jSONArray);
            gw gwVar = this.f34718n;
            if (gwVar != null) {
                gwVar.c(jSONObject2);
            }
            jSONObject2.put("endcard_transform_enabled", this.f34725z);
            jSONObject.put("reward", jSONObject2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("reward_name", this.sr);
            jSONObject3.put("reward_amount", this.ux);
            jSONObject3.put("reward_info_show", this.f34714f);
            jSONObject3.put("reward_back_type", this.bk);
            jSONObject3.put("reward_backup_timing", this.f34723t);
            jSONObject3.put("reward_backup_duration", this.ys);
            jSONObject3.put("reward_is_callback", this.ba);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("enable", this.f34721r);
            jSONObject5.put("propose_reward", this.ev);
            jSONObject4.put("easy_playable", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("enable", this.gd);
            jSONObject6.put("propose_reward", this.f34719p);
            jSONObject6.put("tip_toast", this.f34717k);
            jSONObject6.put("min_duration", this.f34713a);
            jSONObject4.put("play_complete", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("enable", this.fp);
            jSONObject7.put("propose_reward", this.ia);
            jSONObject4.put("playable_interactive", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("enable", this.f34722s);
            jSONObject8.put("propose_reward", this.fz);
            jSONObject8.put("landing_view_time", this.f34724u);
            jSONObject4.put("click_landing", jSONObject8);
            jSONObject3.put("reward_advanced_config", jSONObject4);
            jSONObject.put("reward_data", jSONObject3);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("reward_full_play_time", this.f34715i);
            jSONObject.put("reward_full_time_type", this.f34720q);
            jSONObject.put("interstitial_bg_transparent", this.ck);
            jSONObject.put("__is_use_local_time", this.f34716j);
            jSONObject.put("__is_click_landing_reward", this.ls);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    public static void c(com.bytedance.sdk.component.f.c cVar) {
        cVar.c("reward_time_limited", f34711c);
        cVar.c("reward_force_close_max_count", f34712w);
        cVar.c("reward_local_countdown_close_style", xv);
    }

    public static String c(me meVar) {
        m n4 = n(meVar);
        return n4 == null ? "" : n4.sr;
    }

    public static long c() {
        return f34711c;
    }

    public static float c(me meVar, int i4) {
        double f4;
        if (i4 != 0) {
            if (i4 == 1) {
                f4 = f(meVar);
            } else if (i4 == 2) {
                f4 = ev(meVar);
            } else if (i4 != 3) {
                return 0.0f;
            } else {
                f4 = a(meVar);
            }
            return (float) f4;
        }
        return 1.0f;
    }

    public static void c(me meVar, boolean z3) {
        m n4 = n(meVar);
        if (n4 != null) {
            n4.f34716j = z3;
        }
    }

    public static int w(me meVar) {
        m n4 = n(meVar);
        if (n4 == null) {
            return 0;
        }
        return n4.ux;
    }

    public static long w() {
        int i4 = f34712w;
        if (i4 < 2) {
            return 5L;
        }
        return i4;
    }

    public static void w(me meVar, boolean z3) {
        m n4 = n(meVar);
        if (n4 != null) {
            n4.ls = z3;
        }
    }

    public static int w(me meVar, int i4) {
        int i5;
        m n4 = n(meVar);
        return (n4 != null && (i5 = n4.ys) > 0) ? Math.min(i4, i5) : i4;
    }
}
