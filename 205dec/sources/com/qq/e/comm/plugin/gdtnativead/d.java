package com.qq.e.comm.plugin.gdtnativead;

import com.qq.e.ads.cfg.VideoOption;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {
    public static void a(String str, VideoOption videoOption) {
        com.qq.e.comm.plugin.d0.a.d().f().a("videoOptions", (Object) videoOption.getOptions().toString(), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("nativeExpressPreloadVideo", 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("expressInstallFilter", 1) == 1;
    }

    public static boolean d() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("bxguivcar", 0) == 1;
    }

    public static boolean b(String str) {
        return com.qq.e.comm.plugin.t.b.b(str);
    }

    public static JSONObject a(String str) {
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("videoOptions", str);
        try {
            if (c4 == null) {
                c4 = "{}";
            }
            return new JSONObject(c4);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return com.qq.e.comm.plugin.d0.a.d().f().c("aNativeJS_1_1");
    }
}
