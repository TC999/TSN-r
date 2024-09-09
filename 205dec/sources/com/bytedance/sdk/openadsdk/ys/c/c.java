package com.bytedance.sdk.openadsdk.ys.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    private C0535c f36400c = new C0535c();

    /* renamed from: com.bytedance.sdk.openadsdk.ys.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    private static final class C0535c implements TTAdManager {

        /* renamed from: c  reason: collision with root package name */
        private final c f36404c;

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            return this.f36404c.w(context).c();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return this.f36404c.c(com.bytedance.sdk.openadsdk.ys.c.xv.w.w(adSlot), false, -1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(Class<T> cls, Bundle bundle) {
            return (T) this.f36404c.c(cls, bundle);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.f36404c.w();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return this.f36404c.c();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            return this.f36404c.xv();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(Object obj) {
            this.f36404c.c(obj);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(Context context) {
            this.f36404c.c(context);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(int i4) {
            this.f36404c.c(i4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, final ExitInstallListener exitInstallListener) {
            return this.f36404c.c(activity, new EventListener() { // from class: com.bytedance.sdk.openadsdk.ys.c.c.c.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i4, Result result) {
                    if (exitInstallListener == null || !result.isSuccess()) {
                        return null;
                    }
                    exitInstallListener.onExitInstall();
                    return null;
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(Object obj) {
            this.f36404c.w(obj);
        }

        private C0535c(c cVar) {
            this.f36404c = cVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z3, int i4) {
            return this.f36404c.c(com.bytedance.sdk.openadsdk.ys.c.xv.w.w(adSlot), z3, i4);
        }
    }

    public abstract <T> T c(Class<T> cls, Bundle bundle);

    public abstract String c();

    public abstract String c(ValueSet valueSet, boolean z3, int i4);

    public abstract void c(int i4);

    public abstract void c(Context context);

    public abstract void c(Object obj);

    public abstract boolean c(Activity activity, EventListener eventListener);

    public TTAdManager ux() {
        return this.f36400c;
    }

    public abstract w w(Context context);

    public abstract String w();

    public abstract void w(Object obj);

    public abstract int xv();
}
