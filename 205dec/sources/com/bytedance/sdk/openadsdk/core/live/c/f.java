package com.bytedance.sdk.openadsdk.core.live.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.gb;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.eq;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.y;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends ux {

    /* renamed from: f  reason: collision with root package name */
    protected String f33850f;

    /* renamed from: r  reason: collision with root package name */
    private final AtomicBoolean f33851r = new AtomicBoolean(false);
    private volatile int ev = 0;

    public f() {
        r();
    }

    private String c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("ZEUS_PLUGIN_LIVE");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return xv(new JSONObject(string).optInt("apiVersionCode"));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void ev() {
        Bridge wv = k.sr().wv();
        if (wv == null) {
            return;
        }
        c((String) c(wv, 8, String.class));
    }

    private Map gd() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_name", ls.getContext().getPackageName());
        eq ng = ls.w().ng();
        if (ng != null) {
            hashMap.put("partner", ng.xv());
            hashMap.put("p_secret", ng.sr());
            hashMap.put("g_appid", String.valueOf(ng.w()));
        }
        hashMap.put("channel", "csj_channel");
        hashMap.put("debug", Boolean.valueOf(a.xv()));
        hashMap.put("ec_host_appid", "1371");
        com.bytedance.sdk.openadsdk.core.z.w ix = ls.w().ix();
        if (ix != null) {
            boolean c4 = ix.c();
            a.w("TTLiveSDkBridge", "INIT_SUB_PROCESS=", Boolean.valueOf(c4));
            hashMap.put("sub_process", Boolean.valueOf(c4));
        }
        hashMap.put("c_control", k.sr().ux());
        return hashMap;
    }

    private void p() {
        y sk;
        JSONArray ev;
        SoftReference<me> softReference = this.ux;
        if (softReference == null || softReference.get() == null) {
            return;
        }
        me meVar = this.ux.get();
        if (!TextUtils.equals(meVar.iy(), this.xv) || (sk = meVar.sk()) == null || (ev = sk.ev()) == null || ev.length() == 0) {
            return;
        }
        try {
            int length = ev.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = ev.optJSONObject(i4);
                if (optJSONObject.optInt("type") == 10002) {
                    optJSONObject.putOpt("status", 1);
                    return;
                }
            }
        } catch (JSONException unused) {
        }
    }

    private String xv(int i4) {
        char[] charArray = String.valueOf(i4).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < charArray.length; i5++) {
            sb.append(charArray[i5]);
            if (i5 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.ux
    public boolean f() {
        return this.ev == 2;
    }

    public void r() {
        ev();
        this.f33850f = c(ls.getContext());
        k.sr().c("com.byted.live.lite", this.f33850f, this.sr, null);
        if (this.f33848c == null) {
            this.f33848c = k.sr().f(2);
        }
        Bridge bridge = this.f33848c;
        if (bridge != null) {
            bridge.call(9, b.a().h(0, new com.bytedance.sdk.openadsdk.core.live.w.c(this)).l(), Void.class);
        } else {
            a.w("No bridge for live");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.ux, com.bytedance.sdk.openadsdk.core.live.c.xv
    public int sr() {
        Object w3;
        return (this.f33848c == null || !f() || (w3 = w("hasAuthenticated")) == null || !(w3 instanceof Boolean)) ? false : ((Boolean) w3).booleanValue() ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.ux, com.bytedance.sdk.openadsdk.core.live.c.xv
    public int w() {
        return this.ev;
    }

    private Object w(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("expand_method_name", str);
        Bridge bridge = this.f33848c;
        if (bridge != null) {
            return bridge.call(7, b.a().h(0, hashMap).l(), null);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.ux, com.bytedance.sdk.openadsdk.core.live.c.xv
    public void xv() {
        if (this.f33848c == null || !f()) {
            return;
        }
        w("warmingUpBeforeEnter");
    }

    private <T> T c(Bridge bridge, int i4, Class<T> cls) {
        return (T) bridge.call(i4, b.a().i(0, "com.byted.live.lite").l(), cls);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.c.ux, com.bytedance.sdk.openadsdk.core.live.c.c, com.bytedance.sdk.openadsdk.core.live.c.xv
    public void c() {
        if (this.f33851r.get()) {
            a.sr("TTLiveSDkBridge", "already init!");
        } else if (this.ev < 1) {
            a.sr("TTLiveSDkBridge", "plugin not Load!");
        } else if (this.ev == 2) {
            a.sr("TTLiveSDkBridge", "init started or successed:" + this.ev);
        } else if (!new com.bytedance.sdk.openadsdk.core.live.w().isValid()) {
            a.sr("TTLiveSDkBridge", "init live failed\uff01 not valid env\uff01");
        } else if (!com.bytedance.sdk.openadsdk.core.live.sr.w.xv(this.sr)) {
            a.w("TTLiveSDkBridge", "live sdk init crash more than consecutive 5 times , live plugin had uninstalled ! App cold start will request new live plugin \uff01");
            com.bytedance.sdk.openadsdk.core.live.sr.w.sr(this.sr);
        } else {
            this.f33851r.set(true);
            com.bytedance.sdk.openadsdk.core.live.sr.w.c(this.sr);
            if (this.f33848c != null) {
                a.xv("TTLiveSDkBridge", "liveSDkBridge init invoke 5500");
                this.f33848c.call(5, b.a().h(0, gd()).l(), null);
            }
            com.bytedance.sdk.openadsdk.core.live.sr.w.w(this.sr);
        }
    }

    public void c(int i4, String str) {
        this.ev = i4;
        if (i4 == -3) {
            com.bytedance.sdk.openadsdk.core.fz.a.xv(str, "com.byted.live.lite");
        } else if (i4 == 1) {
            com.bytedance.sdk.openadsdk.tools.w.xv(21, "1");
        } else if (i4 != 2) {
        } else {
            com.bytedance.sdk.openadsdk.core.fz.a.c().c(true);
            com.bytedance.sdk.openadsdk.tools.w.xv(21, "1");
            com.bytedance.sdk.openadsdk.tools.w.xv(20, "1");
            ev();
        }
    }

    public void c(boolean z3, String str) {
        String str2;
        a.w("TTLiveSDkBridge", "onAuthCallback isAuth=" + z3 + ", openUid=" + str + " listKey= " + this.xv);
        SoftReference<me> softReference = this.ux;
        if (softReference != null && softReference.get() != null) {
            me meVar = this.ux.get();
            int i4 = z3 ? 2 : 1;
            String str3 = this.f33849w;
            if (str3 == null) {
                str3 = "";
            }
            com.bytedance.sdk.openadsdk.core.a.xv.c(i4, str3, meVar);
        }
        if (!z3 || (str2 = this.xv) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ys.w.c.c cVar = (com.bytedance.sdk.openadsdk.ys.w.c.c) gb.c(str2, (Class<Object>) com.bytedance.sdk.openadsdk.ys.w.c.c.class);
        if (cVar == null) {
            a.w("TTLiveSDkBridge", "onAuthCallback listener is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("open_uid", str);
        cVar.c(1, hashMap);
        p();
    }
}
