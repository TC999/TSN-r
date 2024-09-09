package com.bytedance.sdk.openadsdk.core.w.c.w;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.gb;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ok;
import com.bytedance.sdk.openadsdk.core.w.c.w.p;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ev {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ev f35303c;

    /* renamed from: w  reason: collision with root package name */
    private boolean f35305w;
    private Object xv;
    private AtomicBoolean sr = new AtomicBoolean(false);
    private AtomicInteger ux = new AtomicInteger(3);

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f35304f = new AtomicBoolean(false);

    private ev() {
        this.f35305w = false;
        try {
            a.w("WX Mini", "start to check wechat Open Sdk's version");
            Object obj = Build.class.getDeclaredField("SDK_VERSION_NAME").get(null);
            if (obj instanceof String) {
                String str = (String) obj;
                Locale locale = Locale.ROOT;
                this.f35305w = "android 5.3.1".toLowerCase(locale).compareTo(str.toLowerCase(locale)) <= 0;
                StringBuilder sb = new StringBuilder();
                sb.append("The version of wechat Open SDK : ");
                sb.append(str);
                sb.append(this.f35305w ? ", the version is OK!" : ", the version is too lower!!!");
                a.w("WX Mini", sb.toString());
            }
        } catch (Throwable th) {
            a.w("WX Mini", "Open SDK throw exception\uff0cexcept message: " + th);
            this.f35305w = false;
        }
    }

    private boolean sr() {
        Context context = ls.getContext();
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage("com.tencent.mm");
        return packageManager.queryIntentActivities(intent, 0).size() > 0 || wv.f(context);
    }

    private void ux() {
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.ev.2
            @Override // java.lang.Runnable
            public void run() {
                Toast makeText = Toast.makeText(ls.getContext(), "\u8df3\u8f6c\u5fae\u4fe1\u5931\u8d25\u3002", 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        });
    }

    public static ev xv() {
        if (f35303c == null) {
            synchronized (ev.class) {
                if (f35303c == null) {
                    f35303c = new ev();
                }
            }
        }
        return f35303c;
    }

    public boolean c() {
        return this.f35305w;
    }

    public int w() {
        return this.f35305w ? 1 : 0;
    }

    private void c(String str) {
        Method c4;
        if (!this.sr.get() && this.ux.getAndDecrement() > 0) {
            if (TextUtils.isEmpty(str)) {
                a.w("WX Mini", "appId is null");
                c("wc_init_fail", "error_appid");
            } else if (!sr()) {
                a.w("WX Mini", "no query all permission");
                c("wc_init_fail", "error_permission");
            } else if (!this.f35305w) {
                a.w("WX Mini", "not found wechat open sdk\uff0cplease import it!");
                c("wc_init_fail", "error_sdk");
            } else {
                try {
                    Method c5 = gb.c("com.tencent.mm.opensdk.openapi.WXAPIFactory", "createWXAPI", Context.class, String.class);
                    if (c5 != null) {
                        Bridge wv = k.sr().wv();
                        Object call = wv != null ? wv.call(3, null, Context.class) : null;
                        if (call == null) {
                            call = ls.getContext();
                        }
                        if (call == null && (c4 = gb.c("com.bytedance.sdk.openadsdk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                            call = c4.invoke(null, new Object[0]);
                        }
                        if (call == null) {
                            c("wc_init_fail", "error_sdk");
                            return;
                        }
                        this.xv = c5.invoke(null, call, str);
                        c("wc_init_suc", "");
                        this.sr.set(true);
                    }
                } catch (Throwable unused) {
                    a.w("WX Mini", "init wechat open sdk failed");
                    c("wc_init_fail", "error_sdk");
                }
            }
        }
    }

    private void c(String str, String str2) {
        try {
            final com.bytedance.sdk.openadsdk.core.fz.c.xv<com.bytedance.sdk.openadsdk.core.fz.c.xv> w3 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w();
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error_message", str2);
                w3.w(jSONObject.toString());
            }
            w3.c(str);
            com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.ev.1
                @Override // com.bytedance.sdk.openadsdk.p.c.c
                public com.bytedance.sdk.openadsdk.core.fz.c.c c() {
                    return w3;
                }
            }, str);
        } catch (Throwable unused) {
        }
    }

    public void c(me meVar, String str, String str2, final p.c cVar, String str3, boolean z3) {
        try {
            if (meVar == null) {
                cVar.w();
                ux();
                return;
            }
            ok si = meVar.si();
            if (si == null) {
                cVar.w();
                ux();
                return;
            }
            c(si.ev());
            if (this.xv == null) {
                cVar.w();
                ux();
                return;
            }
            Object newInstance = WXLaunchMiniProgram.Req.class.newInstance();
            Field declaredField = WXLaunchMiniProgram.Req.class.getDeclaredField("userName");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, str);
            Field declaredField2 = WXLaunchMiniProgram.Req.class.getDeclaredField("path");
            declaredField2.setAccessible(true);
            declaredField2.set(newInstance, str2);
            Field declaredField3 = WXLaunchMiniProgram.Req.class.getDeclaredField("miniprogramType");
            declaredField3.setAccessible(true);
            declaredField3.set(newInstance, WXLaunchMiniProgram.Req.class.getDeclaredField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            a.w("WX Mini", "ready to call the mini program");
            this.xv.getClass().getMethod("sendReq", WXLaunchMiniProgram.Req.class.getSuperclass()).invoke(this.xv, newInstance);
            si.w(2);
            com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.w.c.w.ev.3
                @Override // java.lang.Runnable
                public void run() {
                    cVar.c();
                }
            });
            com.bytedance.sdk.openadsdk.core.a.xv.xv(meVar, str3, "deeplink_success_realtime");
            com.bytedance.sdk.openadsdk.core.a.xv.ev(meVar, str3, "open_url_app", null);
            com.bytedance.sdk.openadsdk.core.a.f.c().c(meVar, str3, z3);
        } catch (Throwable th) {
            cVar.w();
            ux();
            a.w("WX Mini", "call the mini program fail, error message: " + th);
        }
    }
}
