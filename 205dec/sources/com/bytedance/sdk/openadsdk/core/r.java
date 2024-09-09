package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.IOaidObserver;
import com.bytedance.embedapplog.ISensitiveInfoProvider;
import com.bytedance.embedapplog.InitConfig;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private volatile String f34509c;

    /* renamed from: w  reason: collision with root package name */
    private String f34510w;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static final class c {

        /* renamed from: c  reason: collision with root package name */
        static final r f34514c = new r();
    }

    private void c(Context context) {
        final com.bytedance.sdk.openadsdk.ys.w.xv.sr ux = k.sr().ux();
        InitConfig initConfig = new InitConfig(String.valueOf(164362), "unionser_slardar_applog");
        if (ux != null) {
            boolean xv = ux.xv();
            initConfig.setImeiEnable(xv);
            if (!xv) {
                initConfig.setAppImei(ux.gd());
            }
            initConfig.setMacEnable(ux.sr());
            if (eq.f33190w >= 4600) {
                initConfig.setAndroidIdEnable(ux.f());
                if (eq.sr() && eq.f33190w >= 4900) {
                    initConfig.setCustomerAndroidId(ux.a());
                }
            }
        }
        boolean z3 = !com.bytedance.sdk.openadsdk.core.xv.f.c() ? 1 : 0;
        initConfig.setCanUseUploadPv(z3);
        initConfig.setSensitiveInfoProvider(new ISensitiveInfoProvider() { // from class: com.bytedance.sdk.openadsdk.core.r.1
            @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
            public String getCurrentProcessName(Context context2) {
                return com.bytedance.sdk.component.utils.s.w(context2);
            }

            @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
            public String getImsi() {
                com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = ux;
                return (srVar == null || srVar.xv()) ? com.bytedance.sdk.openadsdk.t.c.c() : "";
            }

            @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
            public String getMac() {
                com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar = ux;
                if (srVar == null || srVar.sr()) {
                    return com.bytedance.sdk.openadsdk.t.c.w();
                }
                return null;
            }

            @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
            public String getSdkBuildModel() {
                return i.u();
            }

            @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
            public boolean isDropTime() {
                return com.bytedance.sdk.openadsdk.core.eq.t.c();
            }

            @Override // com.bytedance.embedapplog.ISensitiveInfoProvider
            public boolean isUseLaunchStrategy() {
                return ls.w().j();
            }
        });
        initConfig.setUriConfig(0);
        com.bytedance.embedapplog.c.c(new IOaidObserver() { // from class: com.bytedance.sdk.openadsdk.core.r.2
            @Override // com.bytedance.embedapplog.IOaidObserver
            public void onOaidLoaded(IOaidObserver.Oaid oaid) {
                if (oaid != null) {
                    com.bytedance.sdk.openadsdk.core.eq.i.c(oaid.id);
                }
            }
        });
        com.bytedance.embedapplog.c.c(context, initConfig);
        HashMap hashMap = new HashMap();
        String ev = k.sr().ev();
        if (TextUtils.isEmpty(ev)) {
            ev = String.valueOf(164362);
        }
        hashMap.put("host_appid", ev);
        hashMap.put("is_plugin", Boolean.valueOf(eq.c()));
        hashMap.put("sdk_version", "6.1.0.6");
        hashMap.put("plugin_version", "6.1.0.6");
        hashMap.put("sdk_api_version", eq.xv);
        hashMap.put("channel", eq.xv());
        boolean p3 = ls.w().p();
        if (p3) {
            hashMap.put("use_apm_sdk", "1");
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().c("applog", !p3, !z3 ? 1 : 0, 1);
        com.bytedance.embedapplog.c.c(hashMap);
    }

    public String f() {
        return "unionser_slardar_applog";
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String sr() {
        return (String) com.bytedance.embedapplog.c.c("sdk_version_name", "");
    }

    public String ux() {
        return String.valueOf(164362);
    }

    public String w() {
        if (TextUtils.isEmpty(this.f34509c)) {
            this.f34509c = com.bytedance.embedapplog.c.r();
            com.bytedance.sdk.openadsdk.tools.w.xv(16, this.f34509c);
            com.bytedance.sdk.openadsdk.core.xv.ux.c().j(this.f34509c == null ? "" : this.f34509c);
        }
        return this.f34509c;
    }

    public String xv() {
        if (TextUtils.isEmpty(this.f34510w)) {
            this.f34510w = com.bytedance.embedapplog.c.gd();
        }
        return this.f34510w;
    }

    private r() {
        this.f34509c = null;
        this.f34510w = null;
        c(ls.getContext());
    }

    public static void w(String str, JSONObject jSONObject) {
        com.bytedance.embedapplog.c.c(str, jSONObject);
    }

    public static r c() {
        return c.f34514c;
    }

    public void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        com.bytedance.embedapplog.c.w(str, jSONObject);
    }
}
