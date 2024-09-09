package com.bytedance.sdk.openadsdk.ux.w;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.ls.xv;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Map<String, Map<String, Integer>>> f36307c = new HashMap();

    public static void c(String str, me meVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xv xvVar = (xv) AutoService.c(xv.class);
        if (xvVar == null || xvVar.xv()) {
            try {
                String valueOf = String.valueOf(wv.ev(meVar));
                String c4 = wv.c(meVar, "-1");
                char c5 = '\uffff';
                switch (str.hashCode()) {
                    case -2093321865:
                        if (str.equals("load_video_cancel")) {
                            c5 = 1;
                            break;
                        }
                        break;
                    case -1643912491:
                        if (str.equals("feed_over")) {
                            c5 = '\b';
                            break;
                        }
                        break;
                    case -1643892427:
                        if (str.equals("feed_play")) {
                            c5 = 5;
                            break;
                        }
                        break;
                    case 3529469:
                        if (str.equals("show")) {
                            c5 = '\n';
                            break;
                        }
                        break;
                    case 211925867:
                        if (str.equals("load_video_error")) {
                            c5 = 3;
                            break;
                        }
                        break;
                    case 224898501:
                        if (str.equals("load_video_start")) {
                            c5 = 0;
                            break;
                        }
                        break;
                    case 566194974:
                        if (str.equals("feed_break")) {
                            c5 = 6;
                            break;
                        }
                        break;
                    case 578633749:
                        if (str.equals("feed_pause")) {
                            c5 = 7;
                            break;
                        }
                        break;
                    case 1409113254:
                        if (str.equals("load_video_success")) {
                            c5 = 2;
                            break;
                        }
                        break;
                    case 1912965437:
                        if (str.equals("play_error")) {
                            c5 = '\t';
                            break;
                        }
                        break;
                    case 1925938071:
                        if (str.equals("play_start")) {
                            c5 = 4;
                            break;
                        }
                        break;
                }
                switch (c5) {
                    case 0:
                        ev(valueOf, c4);
                        return;
                    case 1:
                        k(valueOf, c4);
                        return;
                    case 2:
                        gd(valueOf, c4);
                        return;
                    case 3:
                        p(valueOf, c4);
                        return;
                    case 4:
                        w(valueOf, c4);
                        return;
                    case 5:
                        xv(valueOf, c4);
                        return;
                    case 6:
                        f(valueOf, c4);
                        return;
                    case 7:
                        ux(valueOf, c4);
                        return;
                    case '\b':
                        sr(valueOf, c4);
                        return;
                    case '\t':
                        r(valueOf, c4);
                        return;
                    case '\n':
                        c(valueOf, c4);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void ev(String str, String str2) {
        c(str, str2, "lvs_c");
    }

    private static void f(String str, String str2) {
        c(str, str2, "fb_c");
    }

    private static void gd(String str, String str2) {
        c(str, str2, "lvsu_c");
    }

    private static void k(String str, String str2) {
        c(str, str2, "lvc_c");
    }

    private static void p(String str, String str2) {
        c(str, str2, "lve_c");
    }

    private static void r(String str, String str2) {
        c(str, str2, "pe_c");
    }

    private static void sr(String str, String str2) {
        c(str, str2, "fo_c");
    }

    private static void ux(String str, String str2) {
        c(str, str2, "fpu_c");
    }

    private static void w(String str, String str2) {
        c(str, str2, "ps_c");
    }

    private static void xv(String str, String str2) {
        c(str, str2, "fpl_c");
    }

    private static void c(String str, String str2) {
        c(str, str2, "show_c");
    }

    private static void c(String str, String str2, String str3) {
        Map<String, Map<String, Integer>> map = f36307c.get(str);
        if (map == null) {
            map = new HashMap<>();
            f36307c.put(str, map);
        }
        Map<String, Integer> map2 = map.get(str2);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(str2, map2);
        }
        Integer num = map2.get(str3);
        if (num == null) {
            map2.put(str3, 1);
        } else {
            map2.put(str3, Integer.valueOf(num.intValue() + 1));
        }
    }

    public static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        if (f36307c.isEmpty()) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : f36307c.entrySet()) {
                String key = entry.getKey();
                Map<String, Map<String, Integer>> value = entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                if (value != null) {
                    for (Map.Entry<String, Map<String, Integer>> entry2 : value.entrySet()) {
                        String key2 = entry2.getKey();
                        Map<String, Integer> value2 = entry2.getValue();
                        JSONObject jSONObject3 = new JSONObject();
                        if (value2 != null) {
                            for (Map.Entry<String, Integer> entry3 : value2.entrySet()) {
                                jSONObject3.put(entry3.getKey(), entry3.getValue());
                            }
                        }
                        jSONObject2.put(key2, jSONObject3);
                    }
                }
                jSONObject.put(key, jSONObject2);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }
}
