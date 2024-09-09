package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
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

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile TTPluginListener f31453a;
    private static volatile BaseDexClassLoader sr;
    private final Context gd;

    /* renamed from: c  reason: collision with root package name */
    private static final String f31454c = "next" + File.separator;

    /* renamed from: w  reason: collision with root package name */
    private static final HashMap<String, TTPluginListener> f31455w = new HashMap<>();
    private static final HashMap<String, Handler> xv = new HashMap<>();
    private static volatile f ux = null;

    /* renamed from: f  reason: collision with root package name */
    private final CountDownLatch f31456f = new CountDownLatch(1);

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f31459r = false;
    private volatile String ev = "none";

    /* renamed from: p  reason: collision with root package name */
    private JSONObject f31458p = new JSONObject();

    /* renamed from: k  reason: collision with root package name */
    private EventListener f31457k = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c extends PluginDownloadBean {

        /* renamed from: c  reason: collision with root package name */
        public String f31467c = "";

        /* renamed from: w  reason: collision with root package name */
        public File f31468w = null;

        c() {
            this.mBackupUrlList = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w implements IZeusLogger {
        private w() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.xv.xv(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.xv.xv(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.xv.c(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.xv.sr(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.xv.w(str, str2, th);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static final class xv implements EventListener, Serializable {
        private void c(c cVar) {
            try {
                if (TextUtils.isEmpty(cVar.mPackageName) || !cVar.mPackageName.equals("com.byted.pangle")) {
                    return;
                }
                f.c(TTAppContextHolder.getContext()).w();
            } catch (Exception unused) {
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i4, Result result) {
            b a4 = b.a();
            if (i4 == 1) {
                ValueSet values = result.values();
                if (values == null) {
                    return null;
                }
                String stringValue = values.stringValue(3);
                int code = result.code();
                if (result.isSuccess()) {
                    c sr = f.sr(values.stringValue(2));
                    if (sr != null && !TextUtils.isEmpty(sr.mPackageName)) {
                        com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "plugin update received: " + sr.mPackageName);
                        if (sr.isRevert()) {
                            Zeus.unInstallPlugin(sr.mPackageName);
                        } else {
                            c(sr);
                            if (f.w(sr)) {
                                a4.j(4, true);
                            }
                        }
                    } else {
                        com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                } else {
                    com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "plugin update received failed");
                    f.xv(stringValue, code);
                    return null;
                }
            }
            return a4.l();
        }
    }

    private f(Context context) {
        this.gd = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th);
        }
        w(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    private static boolean sr(Context context) {
        File xv2 = xv(context);
        return xv2.exists() && xv2.listFiles().length != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                TTAdSdk.getAdManager().register(b.b(3).e(0, 1).i(1, str).h(2, plugin.mClassLoader).l());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.xv.c("TTPluginManager", "initPluginService failed in " + str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c sr(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.xv.ux("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    private void w(Context context) {
        try {
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.1
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            f.this.f31458p.put("zeus", jSONObject2);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        sr.c(str, jSONObject);
                    } else {
                        sr.w(str, jSONObject);
                    }
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(xv(context));
            globalParam.setLogger(new w());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.2
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i4, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", str + " state changed, " + i4);
                    if (i4 != 9 || TextUtils.equals(str, "com.byted.pangle")) {
                        return;
                    }
                    f.this.xv(str);
                }
            });
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context, true);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.3
                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i4, String str2) {
                    if (i4 == 7) {
                        f.this.w(str, i4);
                    } else if (i4 == 6) {
                        f.this.w(str, i4);
                        if (f.this.f31457k != null && "com.byted.pangle".equals(str)) {
                            f.this.f31457k.onEvent(0, com.bykv.c.c.c.c.a.a().e(true).f());
                        } else {
                            com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "no main pl");
                        }
                    }
                }
            });
            this.f31459r = true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "Unexpected error for init zeus.", th);
            this.ev = th.getMessage();
        }
    }

    public static f c(Context context) {
        if (ux == null) {
            synchronized (f.class) {
                if (ux == null) {
                    ux = new f(context);
                }
            }
        }
        return ux;
    }

    private static File xv(Context context) {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.w.c(context, "tt_pangle_bykv_file", 0), f31454c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(String str, int i4) {
        com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i4);
        TTPluginListener tTPluginListener = f31455w.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public JSONObject c() {
        return this.f31458p;
    }

    public BaseDexClassLoader c(ux uxVar, int i4) throws Exception {
        if (this.f31459r) {
            if (!Zeus.isPluginInstalled("com.byted.pangle")) {
                if (sr(this.gd)) {
                    Zeus.installFromDownloadDir();
                }
                try {
                    com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "wait start");
                    this.f31456f.await(i4, TimeUnit.MILLISECONDS);
                    com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "wait done");
                    uxVar.w("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.xv(8, "install wait timeout");
                }
            }
            boolean z3 = false;
            if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
                sr = Zeus.getPlugin("com.byted.pangle").mClassLoader;
                z3 = true;
            }
            uxVar.w("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (sr == null) {
                if (this.f31456f.getCount() != 0) {
                    com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.xv(8, "install wait timeout");
                } else if (z3) {
                    com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "Get null after load");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.xv(9, "Get null after load");
                }
            }
            uxVar.w("get_classloader_done");
            return sr;
        }
        com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "Zeus init failed.");
        throw new com.bytedance.sdk.openadsdk.api.plugin.xv(4, this.ev);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, int i4) {
        if ("com.byted.pangle".equals(str) && i4 == 6) {
            com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "notify to end wait");
            this.f31456f.countDown();
        }
        c(i4 == 6, str);
    }

    public void w(final TTPluginListener tTPluginListener) {
        com.bytedance.sdk.openadsdk.ia.c.c().w(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.5
            @Override // java.lang.Runnable
            public void run() {
                String packageName = tTPluginListener.packageName();
                Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
                StringBuilder sb = new StringBuilder();
                sb.append("Find plugin:");
                sb.append(plugin != null);
                com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", sb.toString());
                if (plugin == null) {
                    TTPluginListener unused = f.f31453a = tTPluginListener;
                    return;
                }
                f.w(plugin);
                tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString("plugin_version", c(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(c cVar) {
        File file;
        if (cVar != null && (file = cVar.f31468w) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(cVar.mPackageName, file.getAbsolutePath());
            c(syncInstallPlugin, cVar.mPackageName);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "plugin config is null");
        return false;
    }

    public void w() {
        EventListener eventListener = this.f31457k;
        if (eventListener != null) {
            eventListener.onEvent(1, com.bykv.c.c.c.c.a.a().e(true).f());
        }
    }

    public Bundle c(String str, Bundle bundle) {
        String c4 = c(str);
        if (!TextUtils.isEmpty(c4)) {
            bundle.putString("plugin_version", c4);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle("_pl_config_info_", bundle2);
        return bundle3;
    }

    public static String c(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return c(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void c(final TTPluginListener tTPluginListener) {
        if (!this.f31459r) {
            com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", sb.toString());
        if (plugin != null) {
            w(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            return;
        }
        f31455w.put(packageName, tTPluginListener);
        xv.put(packageName, handler);
    }

    public void c(EventListener eventListener) {
        this.f31457k = eventListener;
    }

    private static c c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.mPackageName = jSONObject.optString("package_name");
        cVar.mVersionCode = jSONObject.optInt("version_code");
        cVar.mUrl = jSONObject.optString(DownloadModel.DOWNLOAD_URL);
        cVar.mMd5 = jSONObject.optString("md5");
        cVar.mApiVersionMin = jSONObject.optInt("min_version");
        cVar.mApiVersionMax = jSONObject.optInt("max_version");
        cVar.f31467c = jSONObject.optString("sign");
        cVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        cVar.f31468w = new File(jSONObject.optString("plugin_file"));
        return cVar;
    }

    public static String c(int i4) {
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

    private static boolean c(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void c(boolean z3, String str) {
        HashMap<String, TTPluginListener> hashMap = f31455w;
        TTPluginListener tTPluginListener = hashMap.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Install dl plugin ");
        sb.append(str);
        sb.append(z3 ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", sb.toString());
        HashMap<String, Handler> hashMap2 = xv;
        Handler handler = hashMap2.get(str);
        if (z3) {
            TTPluginListener tTPluginListener2 = f31453a;
            if (!c(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                w(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (c(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    f31453a = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "handle installed, load failed");
                xv(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "handle installed failed");
            xv(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    public static void c(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
