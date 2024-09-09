package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.bytedance.sdk.openadsdk.api.bl;
import com.bytedance.sdk.openadsdk.bl.ok.ok.q;
import com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a implements Bridge {
    private static final a ok = new a();

    /* renamed from: a  reason: collision with root package name */
    private ITTLiveTokenInjectionAuth f35946a;
    private Bridge bl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class ok implements Bridge {
        private ILiveAdCustomConfig ok;

        ok(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.ok = iLiveAdCustomConfig;
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
                            this.ok.onEventV3(valueSet.stringValue(0), (JSONObject) valueSet.objectValue(1, JSONObject.class));
                            return null;
                        }
                        return (T) this.ok.invoke(valueSet.intValue(0), (Bundle) valueSet.objectValue(1, Bundle.class));
                    }
                    return (T) this.ok.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
                }
                return (T) this.ok.convertToEnterFromMerge(valueSet.intValue(0));
            }
            return (T) Integer.valueOf(this.ok.openLR(valueSet.stringValue(0)));
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return com.bykv.ok.ok.ok.ok.a.b().f(10000, 1).a();
        }
    }

    private a() {
    }

    private TTCustomController a(Map map) {
        Object obj = map.get("c_control");
        if (obj instanceof Bridge) {
            return new q((Bridge) obj);
        }
        return null;
    }

    private Object bl(Map<String, Object> map) {
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
            bl.a("TTLiveSDkBridge", th);
            return null;
        }
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Boolean s(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get("context"));
            Uri parse = Uri.parse(str);
            if (parse != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.ok.ok(context, parse));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            bl.a("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 5) {
            ok((Map) valueSet.objectValue(0, Map.class));
            return null;
        } else if (i4 != 9) {
            return (T) ok(cls, i4, (Map) valueSet.objectValue(0, Map.class));
        } else {
            this.bl = (Bridge) valueSet.objectValue(0, Bridge.class);
            Bridge bridge = (Bridge) com.bytedance.sdk.openadsdk.ok.bl.ok().call(10, com.bykv.ok.ok.ok.ok.a.c(1).f(0, 4).a(), Bridge.class);
            if (bridge != null) {
                bridge.call(106, com.bykv.ok.ok.ok.ok.a.c(1).h(0, new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.a.1
                    @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                    public Bundle config() {
                        return null;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                    public void onPluginListener(int i5, ClassLoader classLoader, Resources resources, Bundle bundle) {
                        if (a.this.bl != null) {
                            a.this.bl.call(3, com.bykv.ok.ok.ok.ok.a.b().f(0, i5).h(1, classLoader).h(2, resources).h(3, bundle).a(), null);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                    public String packageName() {
                        return "com.byted.live.lite";
                    }
                }).a(), Void.class);
            }
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ok.ok.ok.ok.a.b().f(10000, 2).a();
    }

    public static a ok() {
        return ok;
    }

    public static Bridge ok(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new ok(iLiveAdCustomConfig);
    }

    public void ok(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f35946a = iTTLiveTokenInjectionAuth;
    }

    private void ok(Map map) {
        ILiveHostContextParam.Builder hostActionParam = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setIsDebug(Boolean.valueOf(String.valueOf(map.get("debug"))).booleanValue()).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.a.2
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return "pangle";
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (a.this.bl != null) {
                    return a.this.bl.call(0, com.bykv.ok.ok.ok.ok.a.b().i(0, str).h(1, map2).a(), Object.class);
                }
                return null;
            }
        }).setPartnerSecret("p_secret").setHostPermission(new TTHostPermissionInner(a(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.core.ok(this.bl));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f35946a;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.core.a(iTTLiveTokenInjectionAuth));
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.a.3
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                bl.ok("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                a.this.ok(-3, str);
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                bl.a("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.ok.ok();
                a.this.ok(2, null);
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            hostActionParam.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean booleanValue = Boolean.valueOf(String.valueOf(map.get("sub_process"))).booleanValue();
        bl.ok("TTLiveSDkBridge", "execute live sdk initLive method end, (\u65b9\u6cd5\u987a\u5229\u6267\u884c\u7ed3\u679c)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.ok.ok(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), hostActionParam, iLiveInitCallback, booleanValue)), " subProcess=", Boolean.valueOf(booleanValue));
    }

    public <T> T ok(Class<T> cls, int i4, Map<String, Object> map) {
        if (i4 == 0) {
            if (!com.bytedance.sdk.openadsdk.live.ok.ok(getContext(map.get("context")), ok(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        } else if (i4 != 7) {
            if (i4 != 8) {
                return null;
            }
            return (T) s(map);
        } else {
            return (T) bl(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, String str) {
        if (this.bl != null) {
            com.bykv.ok.ok.ok.ok.a f4 = com.bykv.ok.ok.ok.ok.a.b().f(0, i4);
            if (str != null) {
                f4.i(1, str);
            }
            this.bl.call(2, f4.a(), null);
        }
    }

    private Bundle ok(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }
}
