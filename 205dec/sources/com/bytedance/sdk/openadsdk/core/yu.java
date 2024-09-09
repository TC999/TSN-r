package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class yu {
    private Bridge ev;
    private static final yu sr = new yu();

    /* renamed from: r  reason: collision with root package name */
    private static int f35674r = -1;
    private static String gd = "ext_plugin";

    /* renamed from: c  reason: collision with root package name */
    private volatile Bridge f35675c = null;

    /* renamed from: w  reason: collision with root package name */
    private volatile Bridge f35677w = null;
    private volatile Bridge xv = null;
    private AtomicBoolean ux = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f35676f = new AtomicBoolean(false);

    private yu() {
    }

    private static String a() {
        if (eq.f33190w >= 5003) {
            return w(eq.sr);
        }
        return c(ls.getContext());
    }

    private Bridge bk() {
        try {
            if (this.ev == null) {
                this.ev = (Bridge) ((ClassLoader) k.sr().wv().call(4, b.b(1).i(0, "com.byted.csj.ext").l(), ClassLoader.class)).loadClass("com.byted.csj.ext_impl.ServiceManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            return this.ev;
        } catch (Throwable th) {
            String str = gd;
            com.bytedance.sdk.component.utils.a.f(str, "getServiceManager:" + th.getMessage());
            return null;
        }
    }

    public static yu c() {
        return sr;
    }

    private static String ev() {
        int i4 = eq.f33190w;
        if (i4 != 5001 && i4 != 5002) {
            return gd();
        }
        return p();
    }

    private Integer f() {
        Integer num;
        Bridge bk = bk();
        if (bk == null || (num = (Integer) bk.call(1004, null, Integer.class)) == null) {
            return -1;
        }
        return num;
    }

    private static String gd() {
        return (String) k.sr().wv().call(8, b.b(1).i(0, "com.byted.csj.ext").l(), String.class);
    }

    private static String k() {
        try {
            Integer f4 = c().f();
            if (f4.intValue() != -1) {
                return w(f4.intValue());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String p() {
        try {
            Bridge wv = k.sr().wv();
            JSONObject optJSONObject = k.sr().fz().optJSONObject("com.byted.csj.ext");
            if (!((Boolean) wv.call(6, b.b(1).i(0, "com.byted.csj.ext").l(), Boolean.class)).booleanValue()) {
                return optJSONObject == null ? "0.0.0.0" : (String) optJSONObject.opt("plugin_version");
            } else if (c().sr()) {
                return k();
            } else {
                return null;
            }
        } catch (Throwable th) {
            String str = gd;
            com.bytedance.sdk.component.utils.a.f(str, "ignore:" + th.getMessage());
            th.printStackTrace();
            return "0.0.0.0";
        }
    }

    private Bridge r() {
        Bridge bk;
        com.bytedance.sdk.openadsdk.core.ls.xv xvVar = (com.bytedance.sdk.openadsdk.core.ls.xv) AutoService.c(com.bytedance.sdk.openadsdk.core.ls.xv.class);
        if (xvVar != null && xvVar.xv()) {
            if (sr()) {
                Integer f4 = f();
                String str = gd;
                com.bytedance.sdk.component.utils.a.w(str, "pit v " + f4);
                if (f4.intValue() < 1100) {
                    return null;
                }
                if (this.xv == null) {
                    synchronized (yu.class) {
                        if (this.xv == null && (bk = bk()) != null) {
                            this.xv = (Bridge) bk.call(10003, null, Bridge.class);
                        }
                    }
                }
                String str2 = gd;
                StringBuilder sb = new StringBuilder();
                sb.append("pit service:");
                sb.append(this.xv != null);
                com.bytedance.sdk.component.utils.a.w(str2, sb.toString());
                return this.xv;
            }
            return null;
        }
        com.bytedance.sdk.component.utils.a.f(gd, "can use pitaya false");
        return null;
    }

    public static int w() {
        if (f35674r == -1) {
            f35674r = c().f().intValue();
        }
        return f35674r;
    }

    public static void xv() {
        if (eq.f33190w < 5001) {
            return;
        }
        if (ls.w().fp()) {
            Bundle bundle = new Bundle();
            Bundle c4 = c(k.sr().ev());
            if (c4 != null) {
                bundle.putBundle("com.byted.csj.ext", c4);
            }
            k.sr().c(bundle);
            return;
        }
        JSONObject fz = k.sr().fz();
        if (fz != null) {
            fz.remove("com.byted.csj.ext");
        }
    }

    public boolean sr() {
        try {
        } catch (Throwable th) {
            String str = gd;
            com.bytedance.sdk.component.utils.a.f(str, "pit_ext_error:" + th.getMessage());
        }
        if (eq.f33190w >= 5001 && ls.w().fp()) {
            if (this.ux.get()) {
                return true;
            }
            if (this.f35676f.compareAndSet(false, true)) {
                final Bridge wv = k.sr().wv();
                ValueSet l4 = b.b(1).i(0, "com.byted.csj.ext").l();
                if (((Boolean) wv.call(6, l4, Boolean.class)).booleanValue()) {
                    if (((Boolean) wv.call(7, l4, Boolean.class)).booleanValue()) {
                        this.ux.set(true);
                        this.f35676f.set(false);
                    } else {
                        com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.yu.1
                            @Override // java.lang.Runnable
                            public void run() {
                                yu.this.c(wv, true);
                            }
                        });
                    }
                } else {
                    this.f35676f.set(false);
                }
            }
            return false;
        }
        return false;
    }

    public f0.a ux() {
        if (eq.f33190w >= 5001 && com.bytedance.sdk.openadsdk.core.s.w.c(ls.w().q()) && sr()) {
            return (f0.a) AutoService.c(f0.a.class);
        }
        return null;
    }

    public Bridge c(int i4) {
        try {
            if (eq.c() && i4 == 10003) {
                return r();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String w(int i4) {
        char[] charArray = String.valueOf(i4).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < charArray.length; i5++) {
            sb.append(charArray[i5]);
            if (i5 < charArray.length - 1) {
                sb.append(".");
            }
        }
        String sb2 = sb.toString();
        if (i4 < 100 || i4 >= 1000) {
            return sb2;
        }
        return "0." + sb2;
    }

    private static Bundle c(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", str);
            String ev = ev();
            if (TextUtils.isEmpty(ev)) {
                return null;
            }
            bundle.putString("plugin_version", ev);
            bundle.putString("sdk_version", a());
            return bundle;
        } catch (Throwable th) {
            String str2 = gd;
            com.bytedance.sdk.component.utils.a.f(str2, "error:" + th.getMessage());
            th.printStackTrace();
            return null;
        }
    }

    private static String c(Context context) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("ZEUS_PLUGIN_com.byted.csj.ext");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return w(new JSONObject(string).optInt("apiVersionCode"));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean c(Bridge bridge, boolean z3) {
        try {
            if (this.ux.get()) {
                return true;
            }
            if (!z3) {
                this.f35676f.set(true);
            }
            Boolean bool = (Boolean) bridge.call(5, b.b(1).i(0, "com.byted.csj.ext").l(), Boolean.class);
            this.ux.set(bool.booleanValue());
            this.f35676f.set(false);
            return bool.booleanValue();
        } catch (Throwable th) {
            String str = gd;
            com.bytedance.sdk.component.utils.a.f(str, ":" + th.getMessage());
            return false;
        }
    }
}
