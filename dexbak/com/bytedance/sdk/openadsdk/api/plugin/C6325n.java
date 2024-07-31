package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5934b;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.Initializer;
import com.bykv.p110vk.openvk.api.proto.Result;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.AbstractC6281ok;
import com.bytedance.sdk.openadsdk.api.C6280bl;
import com.bytedance.sdk.openadsdk.api.plugin.C6330s;
import com.bytedance.sdk.openadsdk.api.plugin.p137ok.C6329ok;
import com.bytedance.sdk.openadsdk.downloadnew.C6410s;
import com.bytedance.sdk.openadsdk.live.C6424a;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import com.bytedance.sdk.openadsdk.p174n.C6496ok;
import com.bytedance.sdk.openadsdk.p175ok.InterfaceC6499a;
import com.stub.StubApp;
import com.umeng.ccg.CcgConstant;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6325n extends AbstractC6281ok {

    /* renamed from: ok */
    private static final C6327ok f22447ok = new C6327ok();

    /* renamed from: a */
    private volatile Initializer f22448a;

    /* renamed from: bl */
    private C6321bl f22449bl;

    /* renamed from: s */
    private InterfaceC6499a f22450s = new InterfaceC6499a() { // from class: com.bytedance.sdk.openadsdk.api.plugin.n.1
        @Override // com.bytedance.sdk.openadsdk.p175ok.InterfaceC6499a
        /* renamed from: ok */
        public Bridge mo36200ok(int i) {
            return C6325n.this.m36586ok(i);
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.n$ok */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private static final class C6327ok extends AbstractC6281ok.AbstractC6284bl {
        private C6327ok() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.AbstractC6284bl
        /* renamed from: ok */
        protected void mo36580ok(Throwable th) {
            C6330s.m36549ok(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.AbstractC6284bl
        /* renamed from: ok */
        protected Object mo36581ok(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                C6330s.m36562ok(TTAppContextHolder.getContext()).m36560ok((TTPluginListener) obj);
            }
            if (!z) {
                return obj instanceof ILiveAdCustomConfig ? C6424a.m36312ok((ILiveAdCustomConfig) obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return C6330s.m36562ok(TTAppContextHolder.getContext()).m36550ok(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok
    /* renamed from: a */
    public boolean mo36590a(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.mo36590a(context, adConfig, initCallback);
        this.f22449bl = C6321bl.m36604ok("duration");
        if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
            return false;
        }
        C6314a.m36632ok(adConfig);
        if (Build.VERSION.SDK_INT < 21) {
            m36760a(C5934b.m37914b().m37910f(false).m37913c(4204).m37911e("Only support >= 5.0").m37915a());
            return false;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok
    /* renamed from: bl */
    protected InterfaceC6499a mo36588bl() {
        return this.f22450s;
    }

    @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok
    /* renamed from: ok */
    protected void mo36584ok(Result result) {
        if (result.isSuccess()) {
            Bundle bundle = new Bundle();
            bundle.putInt(CcgConstant.f38549t, 0);
            ExecutorService executorService = (ExecutorService) TTAdSdk.getAdManager().getExtra(ExecutorService.class, bundle);
            if (executorService != null) {
                C6496ok.m36207ok().m36203ok(executorService);
            }
            C6314a.m36634ok();
            return;
        }
        C6314a.m36633ok(result.code(), result.message(), 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok
    /* renamed from: a */
    public void mo36591a(Context context, C5930a c5930a) {
        C6321bl c6321bl = this.f22449bl;
        if (c6321bl == null) {
            c6321bl = C6321bl.m36604ok("duration");
        }
        c6321bl.m36606a("wait_asyn_cost");
        try {
            Initializer m36583ok = m36583ok(c6321bl);
            try {
                if (m36583ok != null) {
                    m36758ok(m36583ok.getManager());
                    try {
                        c6321bl.m36605ok();
                        JSONObject jSONObject = new JSONObject();
                        c6321bl.m36603ok(jSONObject, 20L);
                        jSONObject.put("zeus", C6330s.m36562ok(TTAppContextHolder.getContext()).m36564ok());
                        m36583ok.init(context, c5930a.m37919h(9, jSONObject).m37926a());
                        if (context != null) {
                            Zeus.hookHuaWeiVerifier((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()));
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        Zeus.unInstallPlugin("com.byted.pangle.m");
                        m36760a(C5934b.m37914b().m37910f(false).m37913c(4207).m37911e("Init error").m37915a());
                        throw e;
                    }
                }
                m36760a(C5934b.m37914b().m37910f(false).m37913c(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED).m37911e("Init error").m37915a());
            } catch (Throwable th) {
                th.printStackTrace();
                C5934b m37913c = C5934b.m37914b().m37910f(false).m37913c(4203);
                m36760a(m37913c.m37911e("UnExpected initializer error :" + th.getMessage()).m37915a());
            }
        } catch (C6328ok e2) {
            e2.printStackTrace();
            m36760a(C5934b.m37914b().m37910f(false).m37913c(e2.m36579ok()).m37911e(e2.getMessage()).m37915a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public Bridge m36586ok(int i) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return null;
                }
                return C6329ok.m36578ok();
            }
            return C6410s.m36390ok(TTAppContextHolder.getContext());
        }
        return C6424a.m36314ok();
    }

    @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok
    /* renamed from: ok */
    public boolean mo36585ok(Context context, C5930a c5930a) {
        if (this.f22448a != null) {
            this.f22448a.init(context, c5930a.m37926a());
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok
    /* renamed from: ok */
    public boolean mo36587ok() {
        if (this.f22448a != null) {
            return this.f22448a.isInitSuccess();
        }
        return false;
    }

    /* renamed from: ok */
    private Initializer m36583ok(C6321bl c6321bl) throws C6328ok {
        if (this.f22448a == null) {
            synchronized (this) {
                if (this.f22448a == null) {
                    C6280bl.m36774a("TTPluginManager", "Create initializer");
                    this.f22448a = m36589a(c6321bl);
                }
            }
        }
        return this.f22448a;
    }

    @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok
    /* renamed from: a */
    public AbstractC6281ok.AbstractC6284bl mo36592a() {
        return f22447ok;
    }

    /* renamed from: a */
    private static Initializer m36589a(C6321bl c6321bl) throws C6328ok {
        try {
            c6321bl.m36606a("call_create_initializer");
            BaseDexClassLoader m36558ok = C6330s.m36562ok(TTAppContextHolder.getContext()).m36558ok(c6321bl);
            if (m36558ok != null) {
                Class<?> loadClass = m36558ok.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                c6321bl.m36606a("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putLong("call_init_time", c6321bl.m36607a());
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new C6330s.C6337bl());
                c6321bl.m36606a("create_bundle_cost");
                Method declaredMethod = loadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                c6321bl.m36606a("get_init_method_cost");
                Initializer initializer = (Initializer) declaredMethod.invoke(null, bundle);
                c6321bl.m36606a("get_init_instance_cost");
                C6280bl.m36774a("TTPluginManager", "Create initializer success");
                return initializer;
            }
            throw new C6328ok(4205, "Get initializer failed");
        } catch (Throwable th) {
            if (th instanceof C6328ok) {
                throw new C6328ok(4205, "(" + th.m36579ok() + ", " + th.getMessage() + ")");
            }
            throw new C6328ok(4206, th.getMessage());
        }
    }
}
