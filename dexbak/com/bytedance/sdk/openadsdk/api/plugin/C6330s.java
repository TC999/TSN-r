package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5934b;
import com.bykv.p110vk.openvk.api.proto.EventListener;
import com.bykv.p110vk.openvk.api.proto.Result;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.C6280bl;
import com.bytedance.sdk.openadsdk.p174n.C6496ok;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.stub.StubApp;
import com.umeng.ccg.CcgConstant;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6330s {

    /* renamed from: j */
    private static volatile TTPluginListener f22456j;

    /* renamed from: s */
    private static volatile BaseDexClassLoader f22459s;

    /* renamed from: q */
    private final Context f22464q;

    /* renamed from: ok */
    private static final String f22458ok = "next" + File.separator;

    /* renamed from: a */
    private static final HashMap<String, TTPluginListener> f22454a = new HashMap<>();

    /* renamed from: bl */
    private static final HashMap<String, Handler> f22455bl = new HashMap<>();

    /* renamed from: n */
    private static volatile C6330s f22457n = null;

    /* renamed from: kf */
    private final CountDownLatch f22462kf = new CountDownLatch(1);

    /* renamed from: h */
    private volatile boolean f22460h = false;

    /* renamed from: p */
    private volatile String f22463p = "none";

    /* renamed from: k */
    private JSONObject f22461k = new JSONObject();

    /* renamed from: r */
    private EventListener f22465r = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.s$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6336a implements IZeusLogger {
        private C6336a() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        /* renamed from: e */
        public void mo36545e(String str, String str2, Throwable th) {
            C6280bl.m36770bl(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        /* renamed from: i */
        public void mo36544i(String str, String str2) {
            C6280bl.m36771bl(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        /* renamed from: v */
        public void mo36543v(String str, String str2) {
            C6280bl.m36765ok(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        /* renamed from: w */
        public void mo36542w(String str, String str2) {
            C6280bl.m36761s(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        /* renamed from: w */
        public void mo36541w(String str, String str2, Throwable th) {
            C6280bl.m36773a(str, str2, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.s$bl */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6337bl implements EventListener, Serializable {
        /* renamed from: ok */
        private void m36540ok(C6338ok c6338ok) {
            try {
                if (TextUtils.isEmpty(c6338ok.mPackageName) || !c6338ok.mPackageName.equals("com.byted.pangle.m")) {
                    return;
                }
                C6330s.m36562ok(TTAppContextHolder.getContext()).m36576a();
            } catch (Exception unused) {
            }
        }

        @Override // com.bykv.p110vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i, Result result) {
            C5930a m37925b = C5930a.m37925b();
            if (i == 1) {
                ValueSet values = result.values();
                if (values == null) {
                    return null;
                }
                String stringValue = values.stringValue(3);
                int code = result.code();
                if (result.isSuccess()) {
                    C6338ok m36546s = C6330s.m36546s(values.stringValue(2));
                    if (m36546s != null && !TextUtils.isEmpty(m36546s.mPackageName)) {
                        C6280bl.m36761s("TTPluginManager", "plugin update received: " + m36546s.mPackageName);
                        if (m36546s.isRevert()) {
                            Zeus.unInstallPlugin(m36546s.mPackageName);
                        } else {
                            m36540ok(m36546s);
                            if (C6330s.m36572a(m36546s)) {
                                m37925b.m37917j(4, true);
                            }
                        }
                    } else {
                        C6280bl.m36761s("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                } else {
                    C6280bl.m36761s("TTPluginManager", "plugin update received failed");
                    C6330s.m36565bl(stringValue, code);
                    return null;
                }
            }
            return m37925b.m37926a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.s$ok */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6338ok extends PluginDownloadBean {

        /* renamed from: ok */
        public String f22474ok = "";

        /* renamed from: a */
        public File f22473a = null;

        C6338ok() {
            this.mBackupUrlList = null;
        }
    }

    private C6330s(Context context) {
        this.f22464q = StubApp.getOrigApplicationContext(context.getApplicationContext());
        GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        m36575a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static C6338ok m36546s(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return m36548ok(new JSONObject(str));
        } catch (JSONException unused) {
            C6280bl.m36769n("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public void m36566bl(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                TTAdSdk.getAdManager().register(C5930a.m37924c(3).m37921f(0, 1).m37918i(1, str).m37919h(2, plugin.mClassLoader).m37926a());
            }
        } catch (Throwable th) {
            C6280bl.m36764ok("TTPluginManager", "initPluginService failed in " + str, th);
        }
    }

    /* renamed from: a */
    private void m36575a(Context context) {
        try {
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.1
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle.m".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            C6330s.this.f22461k.put("zeus", jSONObject2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        C6314a.m36631ok(str, jSONObject);
                    } else {
                        C6314a.m36639a(str, jSONObject);
                    }
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(m36568bl(context));
            globalParam.setLogger(new C6336a());
            globalParam.setSignature("com.byted.pangle.m", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.2
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i, Object... objArr) {
                    C6280bl.m36774a("TTPluginManager", str + " state changed, " + i);
                    if (i != 9 || TextUtils.equals(str, "com.byted.pangle.m")) {
                        return;
                    }
                    C6330s.this.m36566bl(str);
                }
            });
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context, true);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.3
                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i, String str2) {
                    if (i == 7) {
                        C6330s.this.m36569a(str, i);
                    } else if (i == 6) {
                        C6330s.this.m36569a(str, i);
                        if (C6330s.this.f22465r != null && "com.byted.pangle.m".equals(str)) {
                            C6330s.this.f22465r.onEvent(0, C5934b.m37914b().m37910f(true).m37915a());
                        } else {
                            C6280bl.m36774a("TTPluginManager", "no main pl");
                        }
                    }
                }
            });
            this.f22460h = true;
        } catch (Throwable th) {
            C6280bl.m36773a("TTPluginManager", "Unexpected error for init zeus.", th);
            this.f22463p = th.getMessage();
        }
    }

    /* renamed from: ok */
    public static C6330s m36562ok(Context context) {
        if (f22457n == null) {
            synchronized (C6330s.class) {
                if (f22457n == null) {
                    f22457n = new C6330s(context);
                }
            }
        }
        return f22457n;
    }

    /* renamed from: bl */
    private static File m36568bl(Context context) {
        return new File(new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle.m"), f22458ok);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public static void m36565bl(String str, int i) {
        C6280bl.m36761s("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        TTPluginListener tTPluginListener = f22454a.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    /* renamed from: ok */
    public JSONObject m36564ok() {
        return this.f22461k;
    }

    /* renamed from: ok */
    public BaseDexClassLoader m36558ok(C6321bl c6321bl) throws Exception {
        return m36557ok(c6321bl, 60000);
    }

    /* renamed from: ok */
    public BaseDexClassLoader m36557ok(C6321bl c6321bl, int i) throws Exception {
        if (this.f22460h) {
            if (!Zeus.isPluginInstalled("com.byted.pangle.m")) {
                try {
                    C6280bl.m36774a("TTPluginManager", "wait start");
                    this.f22462kf.await(i, TimeUnit.MILLISECONDS);
                    C6280bl.m36774a("TTPluginManager", "wait done");
                    c6321bl.m36606a("wait_install_cost");
                } catch (Exception unused) {
                    C6280bl.m36774a("TTPluginManager", "Install wait time out");
                    throw new C6328ok(8, "install wait timeout");
                }
            }
            boolean z = false;
            if (Zeus.isPluginLoaded("com.byted.pangle.m") || Zeus.loadPlugin("com.byted.pangle.m")) {
                f22459s = Zeus.getPlugin("com.byted.pangle.m").mClassLoader;
                z = true;
            }
            c6321bl.m36606a("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (f22459s == null) {
                if (this.f22462kf.getCount() != 0) {
                    C6280bl.m36761s("TTPluginManager", "Install wait time out");
                    throw new C6328ok(8, "install wait timeout");
                } else if (z) {
                    C6280bl.m36761s("TTPluginManager", "Get null after load");
                    throw new C6328ok(9, "Get null after load");
                }
            }
            c6321bl.m36606a("get_classloader_done");
            return f22459s;
        }
        C6280bl.m36761s("TTPluginManager", "Zeus init failed.");
        throw new C6328ok(4, this.f22463p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m36569a(String str, int i) {
        if ("com.byted.pangle.m".equals(str) && i == 6) {
            C6280bl.m36761s("TTPluginManager", "notify to end wait");
            this.f22462kf.countDown();
        }
        m36547ok(i == 6, str);
    }

    /* renamed from: a */
    public void m36573a(final TTPluginListener tTPluginListener) {
        C6496ok.m36207ok().m36211a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.5
            @Override // java.lang.Runnable
            public void run() {
                String packageName = tTPluginListener.packageName();
                Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
                StringBuilder sb = new StringBuilder();
                sb.append("Find plugin:");
                sb.append(plugin != null);
                C6280bl.m36774a("TTPluginManager", sb.toString());
                if (plugin == null) {
                    TTPluginListener unused = C6330s.f22456j = tTPluginListener;
                    return;
                }
                C6330s.m36574a(plugin);
                tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m36574a(Plugin plugin) {
        if (plugin == null) {
            C6280bl.m36761s("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(CcgConstant.f38549t, 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, m36563ok(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static boolean m36572a(C6338ok c6338ok) {
        File file;
        if (c6338ok != null && (file = c6338ok.f22473a) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(c6338ok.mPackageName, file.getAbsolutePath());
            m36547ok(syncInstallPlugin, c6338ok.mPackageName);
            return syncInstallPlugin;
        }
        C6280bl.m36761s("TTPluginManager", "plugin config is null");
        return false;
    }

    /* renamed from: a */
    public void m36576a() {
        EventListener eventListener = this.f22465r;
        if (eventListener != null) {
            eventListener.onEvent(1, C5934b.m37914b().m37910f(true).m37915a());
        }
    }

    /* renamed from: ok */
    public Bundle m36550ok(String str, Bundle bundle) {
        String m36552ok = m36552ok(str);
        if (!TextUtils.isEmpty(m36552ok)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, m36552ok);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    /* renamed from: ok */
    public static String m36552ok(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return m36563ok(plugin.getVersion());
        } catch (Throwable unused) {
            C6280bl.m36761s("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    /* renamed from: ok */
    public void m36560ok(final TTPluginListener tTPluginListener) {
        if (!this.f22460h) {
            C6280bl.m36761s("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.4
            @Override // java.lang.Runnable
            public void run() {
                C6280bl.m36774a("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("Find plugin:");
        sb.append(plugin != null);
        C6280bl.m36774a("TTPluginManager", sb.toString());
        if (plugin != null) {
            m36574a(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            return;
        }
        f22454a.put(packageName, tTPluginListener);
        f22455bl.put(packageName, handler);
    }

    /* renamed from: ok */
    private static C6338ok m36548ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C6338ok c6338ok = new C6338ok();
        c6338ok.mPackageName = jSONObject.optString("package_name");
        c6338ok.mVersionCode = jSONObject.optInt("version_code");
        c6338ok.mUrl = jSONObject.optString(DownloadModel.DOWNLOAD_URL);
        c6338ok.mMd5 = jSONObject.optString("md5");
        c6338ok.mApiVersionMin = jSONObject.optInt("min_version");
        c6338ok.mApiVersionMax = jSONObject.optInt("max_version");
        c6338ok.f22474ok = jSONObject.optString("sign");
        c6338ok.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        c6338ok.f22473a = new File(jSONObject.optString("plugin_file"));
        return c6338ok;
    }

    /* renamed from: ok */
    public static String m36563ok(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    /* renamed from: ok */
    private static boolean m36559ok(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    /* renamed from: ok */
    private static void m36547ok(boolean z, String str) {
        HashMap<String, TTPluginListener> hashMap = f22454a;
        TTPluginListener tTPluginListener = hashMap.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        C6280bl.m36774a("TTPluginManager", sb.toString());
        HashMap<String, Handler> hashMap2 = f22455bl;
        Handler handler = hashMap2.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = f22456j;
            if (!m36559ok(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                m36574a(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (m36559ok(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    f22456j = null;
                }
            } else {
                C6280bl.m36774a("TTPluginManager", "handle installed, load failed");
                m36565bl(str, 1002);
            }
        } else {
            C6280bl.m36774a("TTPluginManager", "handle installed failed");
            m36565bl(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    /* renamed from: ok */
    public static void m36549ok(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle.m");
            C6280bl.m36761s("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
