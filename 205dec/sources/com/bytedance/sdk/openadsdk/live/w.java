package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.xv;
import com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner;
import com.bytedance.sdk.openadsdk.ys.c.c.gd;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private static final w f35956c = new w();

    /* renamed from: w  reason: collision with root package name */
    private ITTLiveTokenInjectionAuth f35957w;
    private Bridge xv;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private static final class c implements Bridge {

        /* renamed from: c  reason: collision with root package name */
        private ILiveAdCustomConfig f35961c;

        c(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.f35961c = iLiveAdCustomConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                return null;
                            }
                            this.f35961c.onEventV3(valueSet.stringValue(0), (JSONObject) valueSet.objectValue(1, JSONObject.class));
                            return null;
                        }
                        return (T) this.f35961c.invoke(valueSet.intValue(0), (Bundle) valueSet.objectValue(1, Bundle.class));
                    }
                    return (T) this.f35961c.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
                }
                return (T) this.f35961c.convertToEnterFromMerge(valueSet.intValue(0));
            }
            return (T) Integer.valueOf(this.f35961c.openLR(valueSet.stringValue(0)));
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return b.a().e(10000, 1).l();
        }
    }

    private w() {
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Boolean sr(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get("context"));
            Uri parse = Uri.parse(str);
            if (parse != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.c.c(context, parse));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            xv.w("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    private TTCustomController w(Map map) {
        Object obj = map.get("c_control");
        if (obj instanceof Bridge) {
            return new gd((Bridge) obj);
        }
        return null;
    }

    private Object xv(Map<String, Object> map) {
        try {
            String str = (String) map.get("expand_method_name");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
            Object[] objArr = (Object[]) map.get("expand_method_param");
            if (objArr != null) {
                return liveRoomService.callExpandMethod(str, objArr);
            }
            return liveRoomService.callExpandMethod(str, new Object[0]);
        } catch (Throwable th) {
            xv.w("TTLiveSDkBridge", th);
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 5) {
            c((Map) valueSet.objectValue(0, Map.class));
            return null;
        } else if (i4 != 9) {
            return (T) c(cls, i4, (Map) valueSet.objectValue(0, Map.class));
        } else {
            this.xv = (Bridge) valueSet.objectValue(0, Bridge.class);
            Bridge bridge = (Bridge) com.bytedance.sdk.openadsdk.xv.xv.c().call(10, b.b(1).e(0, 4).l(), Bridge.class);
            if (bridge != null) {
                bridge.call(106, b.b(1).h(0, new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.w.1
                    @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                    public Bundle config() {
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                    public void onPluginListener(int i5, ClassLoader classLoader, Resources resources, Bundle bundle) {
                        if (w.this.xv != null) {
                            w.this.xv.call(3, b.a().e(0, i5).h(1, classLoader).h(2, resources).h(3, bundle).l(), null);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                    public String packageName() {
                        return "com.byted.live.lite";
                    }
                }).l(), Void.class);
            }
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.a().e(10000, 2).l();
    }

    public static w c() {
        return f35956c;
    }

    public static Bridge c(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new c(iLiveAdCustomConfig);
    }

    public void c(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f35957w = iTTLiveTokenInjectionAuth;
    }

    private void c(Map map) {
        ILiveHostContextParam.Builder hostActionParam = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setIsDebug(Boolean.valueOf(String.valueOf(map.get("debug"))).booleanValue()).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.w.2
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return "pangle";
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (w.this.xv != null) {
                    return w.this.xv.call(0, b.a().i(0, str).h(1, map2).l(), Object.class);
                }
                return null;
            }
        }).setPartnerSecret("p_secret").setHostPermission(new TTHostPermissionInner(w(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.core.c(this.xv));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f35957w;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.core.w(iTTLiveTokenInjectionAuth));
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.w.3
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                xv.c("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                w.this.c(-3, str);
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                xv.w("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.c.c();
                w.this.c(2, null);
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            hostActionParam.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean booleanValue = Boolean.valueOf(String.valueOf(map.get("sub_process"))).booleanValue();
        xv.c("TTLiveSDkBridge", "execute live sdk initLive method end, (\u65b9\u6cd5\u987a\u5229\u6267\u884c\u7ed3\u679c)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.c.c(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), hostActionParam, iLiveInitCallback, booleanValue)), " subProcess=", Boolean.valueOf(booleanValue));
    }

    public <T> T c(Class<T> cls, int i4, Map<String, Object> map) {
        if (i4 == 0) {
            if (!com.bytedance.sdk.openadsdk.live.c.c(getContext(map.get("context")), c(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        } else if (i4 != 7) {
            if (i4 != 8) {
                return null;
            }
            return (T) sr(map);
        } else {
            return (T) xv(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, String str) {
        if (this.xv != null) {
            b e4 = b.a().e(0, i4);
            if (str != null) {
                e4.i(1, str);
            }
            this.xv.call(2, e4.l(), null);
        }
    }

    private Bundle c(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }
}
