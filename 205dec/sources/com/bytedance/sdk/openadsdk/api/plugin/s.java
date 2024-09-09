package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.ok.ok.ok.ok.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
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
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.stub.StubApp;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class s {

    /* renamed from: j  reason: collision with root package name */
    private static volatile TTPluginListener f31482j;

    /* renamed from: s  reason: collision with root package name */
    private static volatile BaseDexClassLoader f31484s;

    /* renamed from: q  reason: collision with root package name */
    private final Context f31488q;
    private static final String ok = "next" + File.separator;

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, TTPluginListener> f31481a = new HashMap<>();
    private static final HashMap<String, Handler> bl = new HashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private static volatile s f31483n = null;
    private final CountDownLatch kf = new CountDownLatch(1);

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f31485h = false;

    /* renamed from: p  reason: collision with root package name */
    private volatile String f31487p = "none";

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f31486k = new JSONObject();

    /* renamed from: r  reason: collision with root package name */
    private EventListener f31489r = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements IZeusLogger {
        private a() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.bl.bl(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.bl.bl(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.bl.ok(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.bl.s(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.bl.a(str, str2, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class bl implements EventListener, Serializable {
        private void ok(ok okVar) {
            try {
                if (TextUtils.isEmpty(okVar.mPackageName) || !okVar.mPackageName.equals("com.byted.pangle.m")) {
                    return;
                }
                s.ok(TTAppContextHolder.getContext()).a();
            } catch (Exception unused) {
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i4, Result result) {
            com.bykv.ok.ok.ok.ok.a b4 = com.bykv.ok.ok.ok.ok.a.b();
            if (i4 == 1) {
                ValueSet values = result.values();
                if (values == null) {
                    return null;
                }
                String stringValue = values.stringValue(3);
                int code = result.code();
                if (result.isSuccess()) {
                    ok s3 = s.s(values.stringValue(2));
                    if (s3 != null && !TextUtils.isEmpty(s3.mPackageName)) {
                        com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin update received: " + s3.mPackageName);
                        if (s3.isRevert()) {
                            Zeus.unInstallPlugin(s3.mPackageName);
                        } else {
                            ok(s3);
                            if (s.a(s3)) {
                                b4.j(4, true);
                            }
                        }
                    } else {
                        com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                } else {
                    com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin update received failed");
                    s.bl(stringValue, code);
                    return null;
                }
            }
            return b4.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class ok extends PluginDownloadBean {
        public String ok = "";

        /* renamed from: a  reason: collision with root package name */
        public File f31492a = null;

        ok() {
            this.mBackupUrlList = null;
        }
    }

    private s(Context context) {
        this.f31488q = StubApp.getOrigApplicationContext(context.getApplicationContext());
        GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ok s(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return ok(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.bl.n("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                TTAdSdk.getAdManager().register(com.bykv.ok.ok.ok.ok.a.c(3).f(0, 1).i(1, str).h(2, plugin.mClassLoader).a());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.bl.ok("TTPluginManager", "initPluginService failed in " + str, th);
        }
    }

    private void a(Context context) {
        try {
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.1
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle.m".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            s.this.f31486k.put("zeus", jSONObject2);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        com.bytedance.sdk.openadsdk.api.plugin.a.ok(str, jSONObject);
                    } else {
                        com.bytedance.sdk.openadsdk.api.plugin.a.a(str, jSONObject);
                    }
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(bl(context));
            globalParam.setLogger(new a());
            globalParam.setSignature("com.byted.pangle.m", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.2
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i4, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", str + " state changed, " + i4);
                    if (i4 != 9 || TextUtils.equals(str, "com.byted.pangle.m")) {
                        return;
                    }
                    s.this.bl(str);
                }
            });
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context, true);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.3
                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i4, String str2) {
                    if (i4 == 7) {
                        s.this.a(str, i4);
                    } else if (i4 == 6) {
                        s.this.a(str, i4);
                        if (s.this.f31489r != null && "com.byted.pangle.m".equals(str)) {
                            s.this.f31489r.onEvent(0, b.b().f(true).a());
                        } else {
                            com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "no main pl");
                        }
                    }
                }
            });
            this.f31485h = true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Unexpected error for init zeus.", th);
            this.f31487p = th.getMessage();
        }
    }

    public static s ok(Context context) {
        if (f31483n == null) {
            synchronized (s.class) {
                if (f31483n == null) {
                    f31483n = new s(context);
                }
            }
        }
        return f31483n;
    }

    private static File bl(Context context) {
        return new File(new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle.m"), ok);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bl(String str, int i4) {
        com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i4);
        TTPluginListener tTPluginListener = f31481a.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public JSONObject ok() {
        return this.f31486k;
    }

    public BaseDexClassLoader ok(com.bytedance.sdk.openadsdk.api.plugin.bl blVar) throws Exception {
        return ok(blVar, 60000);
    }

    public BaseDexClassLoader ok(com.bytedance.sdk.openadsdk.api.plugin.bl blVar, int i4) throws Exception {
        if (this.f31485h) {
            if (!Zeus.isPluginInstalled("com.byted.pangle.m")) {
                try {
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "wait start");
                    this.kf.await(i4, TimeUnit.MILLISECONDS);
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "wait done");
                    blVar.a("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.ok(8, "install wait timeout");
                }
            }
            boolean z3 = false;
            if (Zeus.isPluginLoaded("com.byted.pangle.m") || Zeus.loadPlugin("com.byted.pangle.m")) {
                f31484s = Zeus.getPlugin("com.byted.pangle.m").mClassLoader;
                z3 = true;
            }
            blVar.a("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (f31484s == null) {
                if (this.kf.getCount() != 0) {
                    com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.ok(8, "install wait timeout");
                } else if (z3) {
                    com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Get null after load");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.ok(9, "Get null after load");
                }
            }
            blVar.a("get_classloader_done");
            return f31484s;
        }
        com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Zeus init failed.");
        throw new com.bytedance.sdk.openadsdk.api.plugin.ok(4, this.f31487p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i4) {
        if ("com.byted.pangle.m".equals(str) && i4 == 6) {
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "notify to end wait");
            this.kf.countDown();
        }
        ok(i4 == 6, str);
    }

    public void a(final TTPluginListener tTPluginListener) {
        com.bytedance.sdk.openadsdk.n.ok.ok().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.5
            @Override // java.lang.Runnable
            public void run() {
                String packageName = tTPluginListener.packageName();
                Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
                StringBuilder sb = new StringBuilder();
                sb.append("Find plugin:");
                sb.append(plugin != null);
                com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", sb.toString());
                if (plugin == null) {
                    TTPluginListener unused = s.f31482j = tTPluginListener;
                    return;
                }
                s.a(plugin);
                tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString("plugin_version", ok(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(ok okVar) {
        File file;
        if (okVar != null && (file = okVar.f31492a) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(okVar.mPackageName, file.getAbsolutePath());
            ok(syncInstallPlugin, okVar.mPackageName);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin config is null");
        return false;
    }

    public void a() {
        EventListener eventListener = this.f31489r;
        if (eventListener != null) {
            eventListener.onEvent(1, b.b().f(true).a());
        }
    }

    public Bundle ok(String str, Bundle bundle) {
        String ok2 = ok(str);
        if (!TextUtils.isEmpty(ok2)) {
            bundle.putString("plugin_version", ok2);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle("_pl_config_info_", bundle2);
        return bundle3;
    }

    public static String ok(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return ok(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void ok(final TTPluginListener tTPluginListener) {
        if (!this.f31485h) {
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Zeus init failed.");
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
                com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", sb.toString());
        if (plugin != null) {
            a(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            return;
        }
        f31481a.put(packageName, tTPluginListener);
        bl.put(packageName, handler);
    }

    private static ok ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ok okVar = new ok();
        okVar.mPackageName = jSONObject.optString("package_name");
        okVar.mVersionCode = jSONObject.optInt("version_code");
        okVar.mUrl = jSONObject.optString(DownloadModel.DOWNLOAD_URL);
        okVar.mMd5 = jSONObject.optString("md5");
        okVar.mApiVersionMin = jSONObject.optInt("min_version");
        okVar.mApiVersionMax = jSONObject.optInt("max_version");
        okVar.ok = jSONObject.optString("sign");
        okVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        okVar.f31492a = new File(jSONObject.optString("plugin_file"));
        return okVar;
    }

    public static String ok(int i4) {
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

    private static boolean ok(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void ok(boolean z3, String str) {
        HashMap<String, TTPluginListener> hashMap = f31481a;
        TTPluginListener tTPluginListener = hashMap.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Install dl plugin ");
        sb.append(str);
        sb.append(z3 ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", sb.toString());
        HashMap<String, Handler> hashMap2 = bl;
        Handler handler = hashMap2.get(str);
        if (z3) {
            TTPluginListener tTPluginListener2 = f31482j;
            if (!ok(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                a(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (ok(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    f31482j = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "handle installed, load failed");
                bl(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "handle installed failed");
            bl(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    public static void ok(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle.m");
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
