package com.qq.e.comm.managers;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements IGDTAdManager {

    /* renamed from: g  reason: collision with root package name */
    public static final ExecutorService f41630g = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f41631a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f41632b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Context f41633c;

    /* renamed from: d  reason: collision with root package name */
    private volatile PM f41634d;

    /* renamed from: e  reason: collision with root package name */
    private volatile DevTools f41635e;

    /* renamed from: f  reason: collision with root package name */
    private volatile String f41636f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: com.qq.e.comm.managers.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class RunnableC0777a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GDTAdSdk.OnStartListener f41637a;

        RunnableC0777a(GDTAdSdk.OnStartListener onStartListener) {
            this.f41637a = onStartListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                POFactory pOFactory = a.this.f41634d.getPOFactory(false, false);
                if (pOFactory != null) {
                    pOFactory.start(a.this.f41634d.getStartCaller(1));
                    GDTAdSdk.OnStartListener onStartListener = this.f41637a;
                    if (onStartListener != null) {
                        onStartListener.onStartSuccess();
                    }
                } else {
                    GDTAdSdk.OnStartListener onStartListener2 = this.f41637a;
                    if (onStartListener2 != null) {
                        onStartListener2.onStartFailed(new Exception("GDTAdSdk start\u5f02\u5e38"));
                    }
                }
            } catch (e e4) {
                GDTLogger.e(e4.getMessage(), e4);
                GDTAdSdk.OnStartListener onStartListener3 = this.f41637a;
                if (onStartListener3 != null) {
                    onStartListener3.onStartFailed(e4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static a f41639a = new a(null);
    }

    private a() {
        this.f41631a = false;
        this.f41632b = false;
    }

    /* synthetic */ a(RunnableC0777a runnableC0777a) {
        this();
    }

    public static a b() {
        return b.f41639a;
    }

    public String a() {
        return this.f41636f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(GDTAdSdk.OnStartListener onStartListener) {
        if (this.f41631a) {
            f41630g.submit(new RunnableC0777a(onStartListener));
            return;
        }
        GDTLogger.e("\u5728\u8c03\u7528start\u65b9\u6cd5\u524d\u8bf7\u5148\u8c03\u7528initWithoutStart\u65b9\u6cd5");
        if (onStartListener != null) {
            onStartListener.onStartFailed(new Exception("\u5728\u8c03\u7528start\u65b9\u6cd5\u524d\u8bf7\u5148\u8c03\u7528initWithoutStart\u65b9\u6cd5"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean a(Context context, String str, boolean z3) {
        if (this.f41631a) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager\u521d\u59cb\u5316\u9519\u8bef\uff0ccontext\u548cappId\u4e0d\u80fd\u4e3a\u7a7a");
            return false;
        }
        this.f41636f = str;
        this.f41633c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f41634d = new PM(this.f41633c, null);
        f41630g.submit(new com.qq.e.comm.managers.b(this, z3));
        this.f41631a = true;
        return true;
    }

    public PM c() {
        return this.f41634d;
    }

    public boolean d() {
        if (this.f41631a) {
            return true;
        }
        GDTLogger.e("SDK \u5c1a\u672a\u521d\u59cb\u5316\uff0c\u8bf7\u5728 Application \u4e2d\u8c03\u7528 GDTAdSdk.initWithoutStart() \u521d\u59cb\u5316");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (d()) {
            try {
                return this.f41634d.getPOFactory().getBuyerId(map);
            } catch (Exception e4) {
                GDTLogger.e("SDK \u521d\u59cb\u5316\u5f02\u5e38", e4);
                return "";
            }
        }
        return "";
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f41635e == null) {
            this.f41635e = new DevTools();
        }
        return this.f41635e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (d()) {
            try {
                return this.f41634d.getPOFactory().getSDKInfo(str);
            } catch (Exception e4) {
                GDTLogger.e("SDK \u521d\u59cb\u5316\u5f02\u5e38", e4);
                return "";
            }
        }
        return "";
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (this.f41632b) {
            try {
                return this.f41634d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
            } catch (Exception e4) {
                GDTLogger.e("SDK \u521d\u59cb\u5316\u5f02\u5e38", e4);
                return 0;
            }
        }
        return 0;
    }
}
