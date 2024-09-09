package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationTTLiveTokenInjectionAuthImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    private TTAdSdk.InitCallback f31369c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class AbstractC0466c<T> {
        private AbstractC0466c() {
        }

        abstract void c(w<T> wVar, int i4);

        void c(Throwable th) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class sr implements EventListener {
        private sr() {
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i4, Result result) {
            c.this.w(result);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w<T> {
        void c(T t3);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class xv implements TTAdManager {

        /* renamed from: c  reason: collision with root package name */
        private volatile Manager f31397c;

        /* renamed from: w  reason: collision with root package name */
        private volatile boolean f31398w;
        private List<WeakReference<w<Manager>>> xv = new CopyOnWriteArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.sdk.openadsdk.api.c$xv$1  reason: invalid class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public class AnonymousClass1 extends AbstractC0466c<Loader> {

            /* renamed from: c  reason: collision with root package name */
            Loader f31400c;

            /* renamed from: w  reason: collision with root package name */
            final w<Manager> f31401w;
            final /* synthetic */ SoftReference xv;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SoftReference softReference) {
                super();
                this.xv = softReference;
                this.f31401w = new w<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.c.xv.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.c.w
                    public void c(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.f31400c = manager.createLoader((Context) anonymousClass1.xv.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.c.AbstractC0466c
            public void c(final w<Loader> wVar, int i4) {
                Loader loader = this.f31400c;
                if (loader != null) {
                    wVar.c(loader);
                } else {
                    xv.this.call(new w<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.c.xv.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.c.w
                        public void c(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            xv.this.c(anonymousClass1.f31401w);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.f31400c = manager.createLoader((Context) anonymousClass12.xv.get());
                            wVar.c(AnonymousClass1.this.f31400c);
                        }
                    }, i4 + 10000);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final w<Manager> wVar, final int i4) {
            if (this.f31397c != null) {
                try {
                    wVar.c(this.f31397c);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    c(th);
                }
            } else if (!this.f31398w && i4 > 10000) {
                throw new IllegalStateException("\u5e7f\u544aSDK\u672aReady, \u8bf7\u5728load(\u8bf7\u6c42\u5e7f\u544a\uff09\u4e4b\u524d\uff0c\u5148\u8c03\u7528init and start\u65b9\u6cd5\uff0c\u4ee5\u907f\u514d\u65e0\u6cd5\u8bf7\u6c42\u5e7f\u544a");
            } else {
                com.bytedance.sdk.openadsdk.ia.c.c().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.c.xv.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (xv.this.f31397c != null) {
                                wVar.c(xv.this.f31397c);
                            } else {
                                com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "Not ready, no manager: " + i4);
                            }
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                            xv.this.c(th2);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T w(Manager manager, Class<T> cls, Bundle bundle) {
            return (T) manager.getBridge(1).call(6, b.b(2).h(9, cls).h(10, bundle).l(), cls);
        }

        protected Object c(Object obj) {
            return obj;
        }

        protected void c(Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            return new ux(new AnonymousClass1(new SoftReference(context))).c();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (this.f31397c != null) {
                return (T) w(this.f31397c, cls, bundle);
            }
            call(new w<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.c.xv.4
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Manager manager) {
                    xv.w(xv.this.f31397c, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.f31397c != null ? this.f31397c.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "6.1.0.6";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.f31397c != null) {
                return this.f31397c.values().intValue(11);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            call(new w<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.c.xv.2
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Manager manager) {
                    manager.getBridge(1).call(4, b.b(1).h(8, xv.this.c(obj)).l(), Void.class);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            call(new w<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.c.xv.5
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Manager manager) {
                    manager.getBridge(1).call(3, b.b(1).h(7, context).l(), Void.class);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i4) {
            call(new w<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.c.xv.6
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Manager manager) {
                    manager.getBridge(1).call(1, b.a().e(11, i4).l(), Void.class);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            HashMap hashMap = new HashMap();
            hashMap.put("activity", activity);
            hashMap.put("exitInstallListener", exitInstallListener);
            return ((Boolean) DownloadBridgeFactory.getDownloadBridge(TTAppContextHolder.getContext()).call(0, b.b(1).h(0, hashMap).l(), Boolean.class)).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            call(new w<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.c.xv.3
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Manager manager) {
                    manager.getBridge(1).call(5, b.b(1).h(8, obj).l(), Void.class);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z3, int i4) {
            if (i4 <= 0) {
                i4 = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet l4 = b.k(com.bytedance.sdk.openadsdk.ys.c.xv.w.w(adSlot)).j(13, z3).e(14, i4).l();
            if (this.f31397c != null) {
                return (String) this.f31397c.getBridge(1).call(2, l4, String.class);
            }
            return null;
        }

        public void c(boolean z3) {
            this.f31398w = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Manager manager) {
            this.f31397c = manager;
            if (this.f31397c != null) {
                Iterator<WeakReference<w<Manager>>> it = this.xv.iterator();
                while (it.hasNext()) {
                    WeakReference<w<Manager>> next = it.next();
                    w<Manager> wVar = next != null ? next.get() : null;
                    if (wVar != null) {
                        wVar.c(manager);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(w<Manager> wVar) {
            this.xv.add(new WeakReference<>(wVar));
        }
    }

    public void c(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        com.bytedance.sdk.openadsdk.xv.xv.c().c(xv());
        if (w(context, adConfig, initCallback)) {
            this.f31369c = initCallback;
            final b k4 = b.k(com.bytedance.sdk.openadsdk.ys.c.xv.c.c(adConfig));
            k4.f(1, SystemClock.elapsedRealtime());
            k4.i(5, "main");
            k4.j(4, true);
            k4.e(6, 999);
            k4.e(10, 6106);
            k4.i(11, "6.1.0.6");
            k4.i(12, "com.byted.pangle");
            k4.j(14, true);
            k4.h(16, com.bytedance.sdk.openadsdk.xv.xv.c());
            Thread currentThread = Thread.currentThread();
            k4.i(2, currentThread.getName());
            k4.e(3, currentThread.getPriority());
            k4.h(15, new sr());
            k4.h(8301, new MediationInitCLassLoader());
            if (adConfig instanceof TTAdConfig) {
                k4.h(8318, new MediationTTLiveTokenInjectionAuthImpl(((TTAdConfig) adConfig).getInjectionAuth()));
            }
            if (adConfig != null) {
                MediationApiLog.setDebug(Boolean.valueOf(adConfig.isDebug()));
            }
            if (!c(context, k4)) {
                com.bytedance.sdk.openadsdk.ia.c.c().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.w(context, k4);
                    }
                });
            }
            w().c(true);
        }
    }

    protected void c(Result result) {
    }

    public abstract boolean c();

    public abstract boolean c(Context context, b bVar);

    public abstract xv w();

    public abstract void w(Context context, b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(Result result) {
        c(result);
        if (result.isSuccess()) {
            com.bytedance.sdk.openadsdk.api.xv.w("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.f31369c;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            com.bytedance.sdk.openadsdk.api.xv.ux("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.f31369c;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.f31369c = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    protected abstract com.bytedance.sdk.openadsdk.xv.w xv();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class ux extends com.bytedance.sdk.openadsdk.ys.c.w {

        /* renamed from: c  reason: collision with root package name */
        private AbstractC0466c<Loader> f31375c;

        ux(AbstractC0466c<Loader> abstractC0466c) {
            this.f31375c = abstractC0466c;
        }

        private void c(w<Loader> wVar, int i4) {
            try {
                com.bytedance.sdk.openadsdk.api.xv.w("_tt_ad_sdk_", "load ad slot type: " + i4);
                this.f31375c.c(wVar, i4);
            } catch (Throwable th) {
                this.f31375c.c(th);
                throw th;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void ev(final ValueSet valueSet, final Bridge bridge) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.10
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(9, b.k(valueSet).j(2, true).h(1, bridge).l(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void f(final ValueSet valueSet, final Bridge bridge) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.8
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(8, b.k(valueSet).h(1, bridge).l(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void gd(final ValueSet valueSet, final Bridge bridge) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.2
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(1, b.k(valueSet).j(2, true).h(1, bridge).l(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void r(final ValueSet valueSet, final Bridge bridge) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.9
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(5, b.k(valueSet).j(2, true).h(1, bridge).l(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void sr(final ValueSet valueSet, final Bridge bridge) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.5
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(1, b.k(valueSet).h(1, bridge).l(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void ux(final ValueSet valueSet, final Bridge bridge) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.7
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(7, b.k(valueSet).h(1, bridge).l(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void w(final ValueSet valueSet, final Bridge bridge) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.3
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(6, b.k(valueSet).h(1, bridge).l(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void xv(final ValueSet valueSet, final Bridge bridge) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.4
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(9, b.k(valueSet).h(1, bridge).l(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void c(final ValueSet valueSet, final Bridge bridge) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.1
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(5, b.k(valueSet).h(1, bridge).l(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public void c(final ValueSet valueSet, final Bridge bridge, final int i4) {
            c(new w<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.c.ux.6
                @Override // com.bytedance.sdk.openadsdk.api.c.w
                public void c(Loader loader) {
                    loader.load(3, b.k(valueSet).e(3, i4).h(1, bridge).l(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.ys.c.w
        public Pair<Integer, String> c(Exception exc) {
            com.bytedance.sdk.openadsdk.api.xv.sr("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "\u5e7f\u544aSDK\u672aReady, \u8bf7\u5728load(\u8bf7\u6c42\u5e7f\u544a\uff09\u4e4b\u524d\uff0c\u5148\u8c03\u7528init and start\u65b9\u6cd5\uff0c\u4ee5\u907f\u514d\u65e0\u6cd5\u8bf7\u6c42\u5e7f\u544a".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(4202, "Load ad failed: " + exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Manager manager) {
        com.bytedance.sdk.openadsdk.api.xv.w("_tt_ad_sdk_", "update manager");
        w().c(manager);
        w().register(com.bytedance.sdk.openadsdk.xv.xv.c());
    }
}
