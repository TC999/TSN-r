package com.p518qq.p519e.comm.managers;

import android.content.Context;
import android.text.TextUtils;
import com.p518qq.p519e.ads.dfa.GDTAppDialogClickListener;
import com.p518qq.p519e.comm.managers.GDTAdSdk;
import com.p518qq.p519e.comm.managers.devtool.DevTools;
import com.p518qq.p519e.comm.managers.plugin.C11819PM;
import com.p518qq.p519e.comm.managers.plugin.C11828e;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.util.GDTLogger;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.qq.e.comm.managers.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11815a implements IGDTAdManager {

    /* renamed from: g */
    public static final ExecutorService f32896g = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    private volatile boolean f32897a;

    /* renamed from: b */
    private volatile boolean f32898b;

    /* renamed from: c */
    private volatile Context f32899c;

    /* renamed from: d */
    private volatile C11819PM f32900d;

    /* renamed from: e */
    private volatile DevTools f32901e;

    /* renamed from: f */
    private volatile String f32902f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.comm.managers.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC11816a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ GDTAdSdk.OnStartListener f32903a;

        RunnableC11816a(GDTAdSdk.OnStartListener onStartListener) {
            this.f32903a = onStartListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                POFactory pOFactory = C11815a.this.f32900d.getPOFactory(false, false);
                if (pOFactory != null) {
                    pOFactory.start(C11815a.this.f32900d.getStartCaller(1));
                    GDTAdSdk.OnStartListener onStartListener = this.f32903a;
                    if (onStartListener != null) {
                        onStartListener.onStartSuccess();
                    }
                } else {
                    GDTAdSdk.OnStartListener onStartListener2 = this.f32903a;
                    if (onStartListener2 != null) {
                        onStartListener2.onStartFailed(new Exception("GDTAdSdk start异常"));
                    }
                }
            } catch (C11828e e) {
                GDTLogger.m20306e(e.getMessage(), e);
                GDTAdSdk.OnStartListener onStartListener3 = this.f32903a;
                if (onStartListener3 != null) {
                    onStartListener3.onStartFailed(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.qq.e.comm.managers.a$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C11817b {

        /* renamed from: a */
        private static C11815a f32905a = new C11815a(null);
    }

    private C11815a() {
        this.f32897a = false;
        this.f32898b = false;
    }

    /* synthetic */ C11815a(RunnableC11816a runnableC11816a) {
        this();
    }

    /* renamed from: b */
    public static C11815a m20349b() {
        return C11817b.f32905a;
    }

    /* renamed from: a */
    public String m20354a() {
        return this.f32902f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m20352a(GDTAdSdk.OnStartListener onStartListener) {
        if (this.f32897a) {
            f32896g.submit(new RunnableC11816a(onStartListener));
            return;
        }
        GDTLogger.m20307e("在调用start方法前请先调用initWithoutStart方法");
        if (onStartListener != null) {
            onStartListener.onStartFailed(new Exception("在调用start方法前请先调用initWithoutStart方法"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean m20353a(Context context, String str, boolean z) {
        if (this.f32897a) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.m20307e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        this.f32902f = str;
        this.f32899c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f32900d = new C11819PM(this.f32899c, null);
        f32896g.submit(new RunnableC11818b(this, z));
        this.f32897a = true;
        return true;
    }

    /* renamed from: c */
    public C11819PM m20348c() {
        return this.f32900d;
    }

    /* renamed from: d */
    public boolean m20347d() {
        if (this.f32897a) {
            return true;
        }
        GDTLogger.m20307e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.initWithoutStart() 初始化");
        return false;
    }

    @Override // com.p518qq.p519e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (m20347d()) {
            try {
                return this.f32900d.getPOFactory().getBuyerId(map);
            } catch (Exception e) {
                GDTLogger.m20306e("SDK 初始化异常", e);
                return "";
            }
        }
        return "";
    }

    @Override // com.p518qq.p519e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f32901e == null) {
            this.f32901e = new DevTools();
        }
        return this.f32901e;
    }

    @Override // com.p518qq.p519e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (m20347d()) {
            try {
                return this.f32900d.getPOFactory().getSDKInfo(str);
            } catch (Exception e) {
                GDTLogger.m20306e("SDK 初始化异常", e);
                return "";
            }
        }
        return "";
    }

    @Override // com.p518qq.p519e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (this.f32898b) {
            try {
                return this.f32900d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
            } catch (Exception e) {
                GDTLogger.m20306e("SDK 初始化异常", e);
                return 0;
            }
        }
        return 0;
    }
}
