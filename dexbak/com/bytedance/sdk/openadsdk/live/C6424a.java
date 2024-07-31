package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.C6280bl;
import com.bytedance.sdk.openadsdk.live.core.C6431a;
import com.bytedance.sdk.openadsdk.live.core.C6433ok;
import com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6382q;
import com.bytedance.sdk.openadsdk.p175ok.C6500bl;
import com.clj.fastble.BleManager;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.live.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6424a implements Bridge {

    /* renamed from: ok */
    private static final C6424a f22593ok = new C6424a();

    /* renamed from: a */
    private ITTLiveTokenInjectionAuth f22594a;

    /* renamed from: bl */
    private Bridge f22595bl;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.live.a$ok */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6428ok implements Bridge {

        /* renamed from: ok */
        private ILiveAdCustomConfig f22599ok;

        C6428ok(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.f22599ok = iLiveAdCustomConfig;
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            this.f22599ok.onEventV3(valueSet.stringValue(0), (JSONObject) valueSet.objectValue(1, JSONObject.class));
                            return null;
                        }
                        return (T) this.f22599ok.invoke(valueSet.intValue(0), (Bundle) valueSet.objectValue(1, Bundle.class));
                    }
                    return (T) this.f22599ok.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
                }
                return (T) this.f22599ok.convertToEnterFromMerge(valueSet.intValue(0));
            }
            return (T) Integer.valueOf(this.f22599ok.openLR(valueSet.stringValue(0)));
        }

        @Override // com.bykv.p110vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return C5930a.m37925b().m37921f(BleManager.f22896l, 1).m37926a();
        }
    }

    private C6424a() {
    }

    /* renamed from: a */
    private TTCustomController m36316a(Map map) {
        Object obj = map.get(TTLiveConstants.INIT_CUSTOM_CONTROLLER);
        if (obj instanceof Bridge) {
            return new C6382q((Bridge) obj);
        }
        return null;
    }

    /* renamed from: bl */
    private Object m36315bl(Map<String, Object> map) {
        try {
            String str = (String) map.get(TTLiveConstants.EXPAND_METHOD_NAME_KEY);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
            Object[] objArr = (Object[]) map.get(TTLiveConstants.EXPAND_METHOD_PARAM_KEY);
            if (objArr != null) {
                return liveRoomService.callExpandMethod(str, objArr);
            }
            return liveRoomService.callExpandMethod(str, new Object[0]);
        } catch (Throwable th) {
            C6280bl.m36772a("TTLiveSDkBridge", th);
            return null;
        }
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    /* renamed from: s */
    private Boolean m36305s(Map<String, Object> map) {
        try {
            String str = (String) map.get(TTLiveConstants.SCHEME_URI_KEY);
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get("context"));
            Uri parse = Uri.parse(str);
            if (parse != null && context != null) {
                return Boolean.valueOf(C6434ok.m36303ok(context, parse));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            C6280bl.m36772a("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 5) {
            m36306ok((Map) valueSet.objectValue(0, Map.class));
            return null;
        } else if (i != 9) {
            return (T) m36308ok(cls, i, (Map) valueSet.objectValue(0, Map.class));
        } else {
            this.f22595bl = (Bridge) valueSet.objectValue(0, Bridge.class);
            Bridge bridge = (Bridge) C6500bl.m36198ok().call(10, C5930a.m37924c(1).m37921f(0, 4).m37926a(), Bridge.class);
            if (bridge != null) {
                bridge.call(106, C5930a.m37924c(1).m37919h(0, new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.a.1
                    @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                    public Bundle config() {
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                    public void onPluginListener(int i2, ClassLoader classLoader, Resources resources, Bundle bundle) {
                        if (C6424a.this.f22595bl != null) {
                            C6424a.this.f22595bl.call(3, C5930a.m37925b().m37921f(0, i2).m37919h(1, classLoader).m37919h(2, resources).m37919h(3, bundle).m37926a(), null);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                    public String packageName() {
                        return "com.byted.live.lite";
                    }
                }).m37926a(), Void.class);
            }
            return null;
        }
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.m37925b().m37921f(BleManager.f22896l, 2).m37926a();
    }

    /* renamed from: ok */
    public static C6424a m36314ok() {
        return f22593ok;
    }

    /* renamed from: ok */
    public static Bridge m36312ok(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new C6428ok(iLiveAdCustomConfig);
    }

    /* renamed from: ok */
    public void m36311ok(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f22594a = iTTLiveTokenInjectionAuth;
    }

    /* renamed from: ok */
    private void m36306ok(Map map) {
        ILiveHostContextParam.Builder hostActionParam = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setIsDebug(Boolean.valueOf(String.valueOf(map.get("debug"))).booleanValue()).setECHostAppId(String.valueOf(map.get(TTLiveConstants.INIT_EC_HOST_APPID))).setPartner(String.valueOf(map.get(TTLiveConstants.INIT_PARTENER))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.a.2
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return "pangle";
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (C6424a.this.f22595bl != null) {
                    return C6424a.this.f22595bl.call(0, C5930a.m37925b().m37918i(0, str).m37919h(1, map2).m37926a(), Object.class);
                }
                return null;
            }
        }).setPartnerSecret(TTLiveConstants.INIT_PARTENER_SECERET).setHostPermission(new TTHostPermissionInner(m36316a(map))).setHostActionParam(new C6433ok(this.f22595bl));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f22594a;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new C6431a(iTTLiveTokenInjectionAuth));
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.a.3
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                C6280bl.m36763ok("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                C6424a.this.m36313ok(-3, str);
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                C6280bl.m36774a("TTLiveSDkBridge", "onLiveInitFinish!");
                C6434ok.m36304ok();
                C6424a.this.m36313ok(2, null);
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            hostActionParam.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean booleanValue = Boolean.valueOf(String.valueOf(map.get(TTLiveConstants.INIT_SUB_PROCESS))).booleanValue();
        C6280bl.m36763ok("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(C6434ok.m36301ok(TTAppContextHolder.getContext(), String.valueOf(map.get(TTLiveConstants.INIT_GENERATE_APPID)), hostActionParam, iLiveInitCallback, booleanValue)), " subProcess=", Boolean.valueOf(booleanValue));
    }

    /* renamed from: ok */
    public <T> T m36308ok(Class<T> cls, int i, Map<String, Object> map) {
        if (i == 0) {
            if (!C6434ok.m36302ok(getContext(map.get("context")), m36307ok(map.get(TTLiveConstants.BUNDLE_KEY)))) {
                return (T) 2;
            }
            return (T) 0;
        } else if (i != 7) {
            if (i != 8) {
                return null;
            }
            return (T) m36305s(map);
        } else {
            return (T) m36315bl(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m36313ok(int i, String str) {
        if (this.f22595bl != null) {
            C5930a m37921f = C5930a.m37925b().m37921f(0, i);
            if (str != null) {
                m37921f.m37918i(1, str);
            }
            this.f22595bl.call(2, m37921f.m37926a(), null);
        }
    }

    /* renamed from: ok */
    private Bundle m36307ok(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }
}
