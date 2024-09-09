package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.c;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import com.stub.StubApp;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends com.bytedance.sdk.openadsdk.api.c {

    /* renamed from: c  reason: collision with root package name */
    private static final c f31471c = new c();
    private ux sr;
    private SharedPreferences ux;

    /* renamed from: w  reason: collision with root package name */
    private volatile Initializer f31474w = ux();
    private volatile Initializer xv = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31472f = false;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.xv.w f31473r = new com.bytedance.sdk.openadsdk.xv.w() { // from class: com.bytedance.sdk.openadsdk.api.plugin.r.1
        @Override // com.bytedance.sdk.openadsdk.xv.w
        public Bridge c(int i4) {
            return r.this.c(i4);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c extends c.xv {
        private c() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.c.xv
        protected void c(Throwable th) {
            f.c(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.c.xv
        protected Object c(Object obj) {
            boolean z3 = obj instanceof TTPluginListener;
            if (z3) {
                f.c(TTAppContextHolder.getContext()).c((TTPluginListener) obj);
            }
            if (!z3) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.w.c((ILiveAdCustomConfig) obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return f.c(TTAppContextHolder.getContext()).c(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w {

        /* renamed from: c  reason: collision with root package name */
        private static final w f31479c = new w();

        /* renamed from: w  reason: collision with root package name */
        private volatile Initializer f31480w;

        private w() {
        }

        private static Initializer w(ux uxVar) throws xv {
            try {
                uxVar.w("call_create_initializer");
                BaseDexClassLoader c4 = f.c(TTAppContextHolder.getContext()).c(uxVar, 600000);
                if (c4 != null) {
                    Class<?> loadClass = c4.loadClass("com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder");
                    uxVar.w("get_init_class_cost");
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("_pl_update_event_listener_", new f.xv());
                    uxVar.w("create_bundle_cost");
                    Method declaredMethod = loadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                    uxVar.w("get_init_method_cost");
                    Initializer initializer = (Initializer) declaredMethod.invoke(null, bundle);
                    uxVar.w("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.xv.w("TTPluginManager", "Create initializer success");
                    return initializer;
                }
                throw new xv(4205, "Get initializer failed");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.xv.sr("TTPluginManager", "Create initializer failed");
                if (th instanceof xv) {
                    throw new xv(4205, "(" + th.c() + ", " + th.getMessage() + ")");
                }
                th.printStackTrace();
                throw new xv(4206, th.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Initializer c(ux uxVar) throws xv {
            if (this.f31480w == null) {
                synchronized (this) {
                    if (this.f31480w == null) {
                        this.f31480w = w(uxVar);
                    }
                }
            }
            return this.f31480w;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ExecutorService executorService = (ExecutorService) c(ExecutorService.class, 1);
        if (executorService != null) {
            com.bytedance.sdk.component.gd.a.f29806w.c((ThreadPoolExecutor) executorService);
            com.bytedance.sdk.openadsdk.ia.c.c().c(executorService);
        }
        ExecutorService executorService2 = (ExecutorService) c(ExecutorService.class, 2);
        if (executorService2 != null) {
            com.bytedance.sdk.component.gd.a.f29806w.w((ThreadPoolExecutor) executorService2);
        }
        ExecutorService executorService3 = (ExecutorService) c(ExecutorService.class, 3);
        if (executorService3 != null) {
            com.bytedance.sdk.component.gd.a.f29806w.c((ScheduledExecutorService) executorService3);
        }
    }

    private static Initializer ux() {
        try {
            Class<?> loadClass = TTAdSdk.class.getClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder");
            Bundle bundle = new Bundle();
            bundle.putSerializable("_pl_update_event_listener_", new f.xv());
            return (Initializer) loadClass.getDeclaredMethod("getNewInstance", Bundle.class).invoke(null, bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            com.bytedance.sdk.openadsdk.api.xv.ux("_tt_ad_sdk_", "Get direct initializer failed");
            return null;
        }
    }

    public boolean sr() {
        if (this.ux == null) {
            this.ux = com.bytedance.sdk.openadsdk.api.plugin.w.w(TTAppContextHolder.getContext(), "sp_bidding_opt_libra", 0);
        }
        return this.ux.getInt("_use_pl_", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.api.c
    protected com.bytedance.sdk.openadsdk.xv.w xv() {
        return this.f31473r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.api.c
    public boolean w(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.w(context, adConfig, initCallback);
        this.sr = ux.c("duration");
        if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21) {
            w(com.bykv.c.c.c.c.a.a().e(false).b(4204).d("Only support >= 5.0").f());
            return false;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.c
    protected void c(Result result) {
        sr.c();
    }

    @Override // com.bytedance.sdk.openadsdk.api.c
    public void w(Context context, final b bVar) {
        com.bytedance.sdk.openadsdk.api.xv.xv("_tt_ad_sdk_", "async init");
        if (this.f31472f && Build.VERSION.SDK_INT < 26) {
            com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "lower 26");
            return;
        }
        this.sr.w("wait_asyn_cost");
        f.c(TTAppContextHolder.getContext()).c(new EventListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.r.2
            @Override // com.bykv.vk.openvk.api.proto.EventListener
            public ValueSet onEvent(int i4, Result result) {
                if (i4 == 0) {
                    if (result.isSuccess() && r.this.xv == null) {
                        com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "from event");
                        r.this.sr.w("wait_pl_install");
                        r rVar = r.this;
                        rVar.c(rVar.sr, bVar);
                        return null;
                    }
                    com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "failed event");
                    return null;
                } else if (i4 == 1 && result.isSuccess() && r.this.xv == null && bVar != null) {
                    r.this.sr = ux.c("duration");
                    bVar.f(1, SystemClock.elapsedRealtime());
                    return null;
                } else {
                    return null;
                }
            }
        });
        if (!c(context)) {
            com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "no pl");
            return;
        }
        com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "start pl load");
        c(this.sr, bVar);
    }

    @Override // com.bytedance.sdk.openadsdk.api.c
    public boolean c(Context context, b bVar) {
        if (c(context) && sr()) {
            com.bytedance.sdk.openadsdk.api.xv.xv("_tt_ad_sdk_", "use pl Init");
            return false;
        } else if (this.f31474w != null) {
            this.f31472f = true;
            c(this.f31474w.getManager());
            this.f31474w.init(context, bVar.l());
            return false;
        } else {
            w(com.bykv.c.c.c.c.a.a().e(false).b(4206).f());
            return true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.c
    public boolean c() {
        if (this.f31474w != null) {
            return this.f31474w.isInitSuccess();
        }
        return false;
    }

    private boolean c(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.w.sr(context);
    }

    @Override // com.bytedance.sdk.openadsdk.api.c
    public c.xv w() {
        return f31471c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bridge c(int i4) {
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    return null;
                }
                return com.bytedance.sdk.openadsdk.api.plugin.c.c.c();
            }
            return com.bytedance.sdk.openadsdk.downloadnew.sr.c(TTAppContextHolder.getContext());
        }
        return com.bytedance.sdk.openadsdk.live.w.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Manager manager) {
        if (manager != null) {
            manager.getBridge(1).call(16, b.b(1).j(17, true).l(), Void.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ux uxVar, b bVar) {
        if (this.xv == null || !this.xv.isInitSuccess()) {
            b k4 = b.k(bVar.l());
            k4.h(15, new EventListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.r.3
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i4, Result result) {
                    com.bytedance.sdk.openadsdk.api.xv.xv("_tt_ad_sdk_", "Load p_init: " + result.code() + ", message: " + result.message());
                    if (result.isSuccess() && r.this.xv != null) {
                        if (r.this.f31472f && r.this.f31474w != null && r.this.f31474w.isInitSuccess()) {
                            r rVar = r.this;
                            rVar.w(rVar.f31474w.getManager());
                        }
                        r rVar2 = r.this;
                        rVar2.f31474w = rVar2.xv;
                        r rVar3 = r.this;
                        rVar3.c(rVar3.f31474w.getManager());
                        r.this.f();
                    }
                    if (r.this.f31472f) {
                        return null;
                    }
                    r.this.w(result);
                    return null;
                }
            });
            try {
                if (this.xv == null) {
                    synchronized (w.class) {
                        if (this.xv == null) {
                            Initializer c4 = w.f31479c.c(uxVar);
                            this.xv = c4;
                            c(c4, uxVar, k4);
                        }
                    }
                }
            } catch (xv e4) {
                com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "Load p_init failed: " + e4.c() + ", message: " + e4.getMessage());
                sr.c(e4.c(), e4.getMessage(), 0L);
            } catch (Exception e5) {
                sr.c(4206, "Load p_init failed: " + e5.getMessage(), 0L);
                com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "Load p_init failed: " + e5.getMessage());
            }
        }
    }

    private <T> T c(Class<T> cls, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", i4);
        return (T) w().getExtra(cls, bundle);
    }

    private static void c(Initializer initializer, ux uxVar, b bVar) throws xv {
        if (initializer != null) {
            try {
                uxVar.c();
                JSONObject jSONObject = new JSONObject();
                uxVar.c(jSONObject, 20L);
                jSONObject.put("zeus", f.c(TTAppContextHolder.getContext()).c());
                initializer.init(TTAppContextHolder.getContext(), bVar.h(9, jSONObject).l());
                if (TTAppContextHolder.getContext() != null) {
                    Zeus.hookHuaWeiVerifier((Application) StubApp.getOrigApplicationContext(TTAppContextHolder.getContext().getApplicationContext()));
                }
                com.bytedance.sdk.component.utils.a.w("_tt_ad_sdk_", "Initialized done");
                return;
            } catch (Exception e4) {
                Zeus.unInstallPlugin("com.byted.pangle");
                throw new xv(4207, "Init error: " + e4.getMessage());
            }
        }
        throw new xv(4201, "Init error");
    }
}
