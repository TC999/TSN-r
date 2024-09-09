package com.bytedance.sdk.openadsdk.core.ls.sr;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.ls.gd;
import com.bytedance.sdk.openadsdk.core.ls.w;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.xv.ux;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends gd implements w {

    /* renamed from: w  reason: collision with root package name */
    private static volatile c f33884w;
    private static long xv;

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f33885c = new AtomicBoolean(false);

    private c() {
    }

    private static boolean c(int i4) {
        return i4 >= 1 && i4 <= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        try {
            AtomicBoolean atomicBoolean = this.f33885c;
            if (atomicBoolean == null || atomicBoolean.getAndSet(true)) {
                return;
            }
            c(ls.getContext());
        } catch (Throwable th) {
            a.w("lqmt", "rdt_exception:" + th.getMessage());
        }
    }

    public static void f() {
        xv().sr();
    }

    private static int gd() {
        try {
            return ux.c().z();
        } catch (Exception e4) {
            a.w("lqmt", "gdl_exception:" + e4.getMessage());
            return 0;
        }
    }

    public static boolean r() {
        long currentTimeMillis = System.currentTimeMillis() - xv;
        return currentTimeMillis <= PolicyConfig.THREAD_BLOCK_TIMEOUT && currentTimeMillis > 0;
    }

    public static int ux() {
        try {
            String ba = ux.c().ba();
            a.w("lqmt", "qualityList:" + ba);
            if (TextUtils.isEmpty(ba)) {
                return -1;
            }
            return new JSONObject(ba).optInt(com.bytedance.sdk.openadsdk.core.ls.xv.c.sr(), 0);
        } catch (Exception e4) {
            a.w("lqmt", "gnq_exception:" + e4.getMessage());
            return -1;
        }
    }

    private static int w(int i4, int i5) {
        if (i4 != 0) {
            if (i4 == 4 && i5 == 0) {
                return 2;
            }
        } else if (i5 == 0 || i5 == 1) {
            return 2;
        }
        return 3;
    }

    public static c xv() {
        if (f33884w == null) {
            synchronized (c.class) {
                if (f33884w == null) {
                    f33884w = new c();
                }
            }
        }
        return f33884w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.w
    public String c() {
        return "splash";
    }

    public void sr() {
        a.w("lqmt", "SplashLoadStrategy execute..");
        ev.w(new p("pity_splopt") { // from class: com.bytedance.sdk.openadsdk.core.ls.sr.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.ev();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.gd
    public JSONObject w(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("business_name", "common");
            jSONObject.put("business_type", 2);
            jSONObject.put("general_params", new JSONObject());
        } catch (Exception e4) {
            a.w("lqmt", "exception:" + e4.getMessage());
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.gd
    public void c(int i4, com.bytedance.sdk.openadsdk.core.ls.ev evVar) {
        if (k.sr().ba()) {
            try {
                a.f("lqmt", "onPredictResult : type: " + i4);
                a.f("lqmt", "onPredictResult : resultModel  isSuccess: " + evVar.xv().isSuccess());
                a.f("lqmt", "===============");
                Field[] declaredFields = evVar.xv().getClass().getDeclaredFields();
                for (int i5 = 0; i5 < declaredFields.length; i5++) {
                    declaredFields[i5].setAccessible(true);
                    a.w("lqmt", declaredFields[i5] + ":" + declaredFields[i5].get(evVar.xv()));
                }
                a.f("lqmt", "===============");
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.gd
    public boolean w() {
        return com.bytedance.sdk.openadsdk.core.ls.p.xv();
    }

    public static int c(int i4, int i5) {
        try {
            xv = System.currentTimeMillis();
            n c4 = n.c("");
            c4.w("00");
            if (com.bytedance.sdk.openadsdk.core.ls.p.xv()) {
                c4.w("1");
                if (i5 != 0 && i5 != 4) {
                    c4.w("2");
                    int gd = gd();
                    if (gd == -1000) {
                        return i5;
                    }
                    c4.w("3");
                    a.w("lqmt", "getDevL:" + gd);
                    int ux = ux();
                    if (ux == -1) {
                        return i5;
                    }
                    c4.w("4");
                    a.w("lqmt", "getNetQ:" + ux);
                    int c5 = c(i4, ux, gd);
                    a.w("lqmt", "getDCS:" + c5);
                    c4.w("5");
                    if (c(c5)) {
                        return c5;
                    }
                    int w3 = w(ux, gd);
                    c4.w("6");
                    a.w("lqmt", "getLS:" + w3);
                    return c(w3) ? w3 : i5;
                }
                return i5;
            }
            return i5;
        } catch (Throwable th) {
            a.w("lqmt", "gslt_exception:" + th.getMessage());
            return i5;
        }
    }

    private static int c(int i4, int i5, int i6) {
        try {
            String c4 = com.bytedance.sdk.openadsdk.core.ls.c.c().c("splash", "spl_load_strategy");
            a.w("lqmt", "config: " + c4);
            if (TextUtils.isEmpty(c4)) {
                return -1;
            }
            JSONObject jSONObject = new JSONObject(c4);
            String valueOf = String.valueOf(i4);
            JSONObject optJSONObject = jSONObject.has(valueOf) ? jSONObject.optJSONObject(valueOf) : jSONObject.optJSONObject("ot");
            String str = i5 + "" + i6;
            return optJSONObject.has(str) ? optJSONObject.optInt(str, 2) : optJSONObject.optInt("ot", 2);
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.w
    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            return ux.c().y();
        }
        return com.bytedance.sdk.component.f.xv.w.w.c(c(), ls.getContext()).w(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.w
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            ux.c().ba(str2);
        } else {
            com.bytedance.sdk.component.f.xv.w.w.c(c(), ls.getContext()).c(str, str2);
        }
    }
}
