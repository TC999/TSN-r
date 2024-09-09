package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.bykv.ok.ok.ok.ok.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Result;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.ok;
import com.bytedance.sdk.openadsdk.api.plugin.s;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import com.stub.StubApp;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class n extends com.bytedance.sdk.openadsdk.api.ok {
    private static final ok ok = new ok();

    /* renamed from: a  reason: collision with root package name */
    private volatile Initializer f31469a;
    private bl bl;

    /* renamed from: s  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ok.a f31470s = new com.bytedance.sdk.openadsdk.ok.a() { // from class: com.bytedance.sdk.openadsdk.api.plugin.n.1
        @Override // com.bytedance.sdk.openadsdk.ok.a
        public Bridge ok(int i4) {
            return n.this.ok(i4);
        }
    };

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    private static final class ok extends ok.bl {
        private ok() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.ok.bl
        protected void ok(Throwable th) {
            s.ok(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.ok.bl
        protected Object ok(Object obj) {
            boolean z3 = obj instanceof TTPluginListener;
            if (z3) {
                s.ok(TTAppContextHolder.getContext()).ok((TTPluginListener) obj);
            }
            if (!z3) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.a.ok((ILiveAdCustomConfig) obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return s.ok(TTAppContextHolder.getContext()).ok(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.api.ok
    public boolean a(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.a(context, adConfig, initCallback);
        this.bl = bl.ok("duration");
        if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
            return false;
        }
        a.ok(adConfig);
        if (Build.VERSION.SDK_INT < 21) {
            a(b.b().f(false).c(4204).e("Only support >= 5.0").a());
            return false;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    protected com.bytedance.sdk.openadsdk.ok.a bl() {
        return this.f31470s;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    protected void ok(Result result) {
        if (result.isSuccess()) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 0);
            ExecutorService executorService = (ExecutorService) TTAdSdk.getAdManager().getExtra(ExecutorService.class, bundle);
            if (executorService != null) {
                com.bytedance.sdk.openadsdk.n.ok.ok().ok(executorService);
            }
            a.ok();
            return;
        }
        a.ok(result.code(), result.message(), 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public void a(Context context, com.bykv.ok.ok.ok.ok.a aVar) {
        bl blVar = this.bl;
        if (blVar == null) {
            blVar = bl.ok("duration");
        }
        blVar.a("wait_asyn_cost");
        try {
            Initializer ok2 = ok(blVar);
            try {
                if (ok2 != null) {
                    ok(ok2.getManager());
                    try {
                        blVar.ok();
                        JSONObject jSONObject = new JSONObject();
                        blVar.ok(jSONObject, 20L);
                        jSONObject.put("zeus", s.ok(TTAppContextHolder.getContext()).ok());
                        ok2.init(context, aVar.h(9, jSONObject).a());
                        if (context != null) {
                            Zeus.hookHuaWeiVerifier((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()));
                            return;
                        }
                        return;
                    } catch (Exception e4) {
                        Zeus.unInstallPlugin("com.byted.pangle.m");
                        a(b.b().f(false).c(4207).e("Init error").a());
                        throw e4;
                    }
                }
                a(b.b().f(false).c(4201).e("Init error").a());
            } catch (Throwable th) {
                th.printStackTrace();
                b c4 = b.b().f(false).c(4203);
                a(c4.e("UnExpected initializer error :" + th.getMessage()).a());
            }
        } catch (com.bytedance.sdk.openadsdk.api.plugin.ok e5) {
            e5.printStackTrace();
            a(b.b().f(false).c(e5.ok()).e(e5.getMessage()).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bridge ok(int i4) {
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    return null;
                }
                return com.bytedance.sdk.openadsdk.api.plugin.ok.ok.ok();
            }
            return com.bytedance.sdk.openadsdk.downloadnew.s.ok(TTAppContextHolder.getContext());
        }
        return com.bytedance.sdk.openadsdk.live.a.ok();
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public boolean ok(Context context, com.bykv.ok.ok.ok.ok.a aVar) {
        if (this.f31469a != null) {
            this.f31469a.init(context, aVar.a());
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public boolean ok() {
        if (this.f31469a != null) {
            return this.f31469a.isInitSuccess();
        }
        return false;
    }

    private Initializer ok(bl blVar) throws com.bytedance.sdk.openadsdk.api.plugin.ok {
        if (this.f31469a == null) {
            synchronized (this) {
                if (this.f31469a == null) {
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Create initializer");
                    this.f31469a = a(blVar);
                }
            }
        }
        return this.f31469a;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public ok.bl a() {
        return ok;
    }

    private static Initializer a(bl blVar) throws com.bytedance.sdk.openadsdk.api.plugin.ok {
        try {
            blVar.a("call_create_initializer");
            BaseDexClassLoader ok2 = s.ok(TTAppContextHolder.getContext()).ok(blVar);
            if (ok2 != null) {
                Class<?> loadClass = ok2.loadClass("com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder");
                blVar.a("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putLong("call_init_time", blVar.a());
                bundle.putSerializable("_pl_update_event_listener_", new s.bl());
                blVar.a("create_bundle_cost");
                Method declaredMethod = loadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                blVar.a("get_init_method_cost");
                Initializer initializer = (Initializer) declaredMethod.invoke(null, bundle);
                blVar.a("get_init_instance_cost");
                com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Create initializer success");
                return initializer;
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.ok(4205, "Get initializer failed");
        } catch (Throwable th) {
            if (th instanceof com.bytedance.sdk.openadsdk.api.plugin.ok) {
                throw new com.bytedance.sdk.openadsdk.api.plugin.ok(4205, "(" + th.ok() + ", " + th.getMessage() + ")");
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.ok(4206, th.getMessage());
        }
    }
}
