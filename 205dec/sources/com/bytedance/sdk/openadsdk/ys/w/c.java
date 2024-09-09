package com.bytedance.sdk.openadsdk.ys.w;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTInitializer;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    private final w f36460c = new w();

    /* renamed from: com.bytedance.sdk.openadsdk.ys.w.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface InterfaceC0537c {
        Object c(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static final class w implements TTInitializer {

        /* renamed from: c  reason: collision with root package name */
        private final c f36463c;

        @Override // com.bytedance.sdk.openadsdk.TTInitializer
        public TTAdManager getAdManager() {
            return this.f36463c.c().ux();
        }

        @Override // com.bytedance.sdk.openadsdk.TTInitializer
        public TTAdManager init(Context context, AdConfig adConfig) {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTInitializer
        public void init(Context context, final AdConfig adConfig, final TTAdSdk.InitCallback initCallback) {
            this.f36463c.c(context, com.bytedance.sdk.openadsdk.ys.w.xv.c.c(adConfig), new InterfaceC0537c() { // from class: com.bytedance.sdk.openadsdk.ys.w.c.w.1
                @Override // com.bytedance.sdk.openadsdk.ys.w.c.InterfaceC0537c
                public Object c(String str) {
                    AdConfig adConfig2 = adConfig;
                    if (adConfig2 != null) {
                        return adConfig2.getExtra(str);
                    }
                    return null;
                }
            }, new EventListener() { // from class: com.bytedance.sdk.openadsdk.ys.w.c.w.2
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i4, Result result) {
                    if (result.isSuccess()) {
                        TTAdSdk.InitCallback initCallback2 = initCallback;
                        if (initCallback2 != null) {
                            initCallback2.success();
                            return null;
                        }
                        return null;
                    }
                    TTAdSdk.InitCallback initCallback3 = initCallback;
                    if (initCallback3 != null) {
                        initCallback3.fail(result.code(), result.message());
                        return null;
                    }
                    return null;
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTInitializer
        public boolean isInitSuccess() {
            return this.f36463c.isInitSuccess();
        }

        private w(c cVar) {
            this.f36463c = cVar;
        }
    }

    public abstract com.bytedance.sdk.openadsdk.ys.c.c c();

    public abstract void c(Context context, ValueSet valueSet, InterfaceC0537c interfaceC0537c, EventListener eventListener);

    public abstract boolean isInitSuccess();

    public Object sr() {
        return this.f36460c;
    }
}
