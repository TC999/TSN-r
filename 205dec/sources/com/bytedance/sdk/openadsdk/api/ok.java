package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
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

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class ok {
    private TTAdSdk.InitCallback ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a<T> {
        void ok(T t3);
    }

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static abstract class bl implements TTAdManager {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f31418a;
        private List<WeakReference<a<Manager>>> bl = new CopyOnWriteArrayList();
        private volatile Manager ok;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.sdk.openadsdk.api.ok$bl$1  reason: invalid class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        public class AnonymousClass1 extends AbstractC0469ok<Loader> {

            /* renamed from: a  reason: collision with root package name */
            final a<Manager> f31419a;
            final /* synthetic */ SoftReference bl;
            Loader ok;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SoftReference softReference) {
                super();
                this.bl = softReference;
                this.f31419a = new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.ok.a
                    public void ok(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.ok = manager.createLoader((Context) anonymousClass1.bl.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.ok.AbstractC0469ok
            public void ok(final a<Loader> aVar, int i4) {
                Loader loader = this.ok;
                if (loader != null) {
                    aVar.ok(loader);
                } else {
                    bl.this.call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.ok.a
                        public void ok(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            bl.this.ok(anonymousClass1.f31419a);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.ok = manager.createLoader((Context) anonymousClass12.bl.get());
                            aVar.ok(AnonymousClass1.this.ok);
                        }
                    }, i4 + 10000);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T a(Manager manager, Class<T> cls, Bundle bundle) {
            return (T) manager.getBridge(1).call(6, com.bykv.ok.ok.ok.ok.a.c(2).h(9, cls).h(10, bundle).a(), cls);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final a<Manager> aVar, final int i4) {
            if (this.ok != null) {
                try {
                    aVar.ok(this.ok);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.bl.s("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    ok(th);
                }
            } else if (!this.f31418a && i4 > 10000) {
                throw new IllegalStateException("\u5e7f\u544aSDK\u672aReady, \u8bf7\u5728load(\u8bf7\u6c42\u5e7f\u544a\uff09\u4e4b\u524d\uff0c\u5148\u8c03\u7528init and start\u65b9\u6cd5\uff0c\u4ee5\u907f\u514d\u65e0\u6cd5\u8bf7\u6c42\u5e7f\u544a");
            } else {
                com.bytedance.sdk.openadsdk.n.ok.ok().ok(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (bl.this.ok != null) {
                                aVar.ok(bl.this.ok);
                            } else {
                                com.bytedance.sdk.openadsdk.api.bl.s("_tt_ad_sdk_", "Not ready, no manager: " + i4);
                            }
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.api.bl.s("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                            bl.this.ok(th2);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            return new n(new AnonymousClass1(new SoftReference(context))).ok();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (this.ok != null) {
                return (T) a(this.ok, cls, bundle);
            }
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.4
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    bl.a(bl.this.ok, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.ok != null ? this.ok.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "5.9.0.8";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.ok != null) {
                return this.ok.values().intValue(11);
            }
            return 0;
        }

        protected Object ok(Object obj) {
            return obj;
        }

        protected void ok(Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.2
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    manager.getBridge(1).call(4, com.bykv.ok.ok.ok.ok.a.c(1).h(8, bl.this.ok(obj)).a(), Void.class);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.5
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    manager.getBridge(1).call(3, com.bykv.ok.ok.ok.ok.a.c(1).h(7, context).a(), Void.class);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i4) {
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.6
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    manager.getBridge(1).call(1, com.bykv.ok.ok.ok.ok.a.b().f(11, i4).a(), Void.class);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            HashMap hashMap = new HashMap();
            hashMap.put("activity", activity);
            hashMap.put("exitInstallListener", exitInstallListener);
            return ((Boolean) DownloadBridgeFactory.getDownloadBridge(TTAppContextHolder.getContext()).call(0, com.bykv.ok.ok.ok.ok.a.c(1).h(0, hashMap).a(), Boolean.class)).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.3
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    manager.getBridge(1).call(5, com.bykv.ok.ok.ok.ok.a.c(1).h(8, obj).a(), Void.class);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z3, int i4) {
            if (i4 <= 0) {
                i4 = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet a4 = com.bykv.ok.ok.ok.ok.a.k(com.bytedance.sdk.openadsdk.bl.ok.bl.a.a(adSlot)).j(13, z3).f(14, i4).a();
            if (this.ok != null) {
                return (String) this.ok.getBridge(1).call(2, a4, String.class);
            }
            return null;
        }

        public void ok(boolean z3) {
            this.f31418a = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ok(Manager manager) {
            this.ok = manager;
            if (this.ok != null) {
                Iterator<WeakReference<a<Manager>>> it = this.bl.iterator();
                while (it.hasNext()) {
                    WeakReference<a<Manager>> next = it.next();
                    a<Manager> aVar = next != null ? next.get() : null;
                    if (aVar != null) {
                        aVar.ok(manager);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ok(a<Manager> aVar) {
            this.bl.add(new WeakReference<>(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static abstract class AbstractC0469ok<T> {
        private AbstractC0469ok() {
        }

        abstract void ok(a<T> aVar, int i4);

        void ok(Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class s implements EventListener {
        private s() {
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i4, Result result) {
            ok.this.a(result);
            return null;
        }
    }

    public abstract bl a();

    public abstract void a(Context context, com.bykv.ok.ok.ok.ok.a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Result result) {
        ok(result);
        if (result.isSuccess()) {
            com.bytedance.sdk.openadsdk.api.bl.a("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.ok;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            com.bytedance.sdk.openadsdk.api.bl.n("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.ok;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.ok = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    protected abstract com.bytedance.sdk.openadsdk.ok.a bl();

    public void ok(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        com.bytedance.sdk.openadsdk.ok.bl.ok().ok(bl());
        if (a(context, adConfig, initCallback)) {
            this.ok = initCallback;
            final com.bykv.ok.ok.ok.ok.a k4 = com.bykv.ok.ok.ok.ok.a.k(com.bytedance.sdk.openadsdk.bl.ok.bl.ok.ok(adConfig));
            k4.g(1, SystemClock.elapsedRealtime());
            k4.i(5, "main");
            k4.j(4, true);
            k4.f(6, 999);
            k4.f(10, 5908);
            k4.i(11, "5.9.0.8");
            k4.i(12, "com.byted.pangle.m");
            k4.j(14, false);
            k4.h(16, com.bytedance.sdk.openadsdk.ok.bl.ok());
            Thread currentThread = Thread.currentThread();
            k4.i(2, currentThread.getName());
            k4.f(3, currentThread.getPriority());
            k4.h(15, new s());
            k4.h(8301, new MediationInitCLassLoader());
            if (adConfig instanceof TTAdConfig) {
                k4.h(8318, new MediationTTLiveTokenInjectionAuthImpl(((TTAdConfig) adConfig).getInjectionAuth()));
            }
            if (adConfig != null) {
                MediationApiLog.setDebug(Boolean.valueOf(adConfig.isDebug()));
            }
            if (!ok(context, k4)) {
                com.bytedance.sdk.openadsdk.n.ok.ok().ok(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.ok.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ok.this.a(context, k4);
                    }
                });
            }
            a().ok(true);
        }
    }

    protected void ok(Result result) {
    }

    public abstract boolean ok();

    public abstract boolean ok(Context context, com.bykv.ok.ok.ok.ok.a aVar);

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class n extends com.bytedance.sdk.openadsdk.bl.ok.ok {
        private AbstractC0469ok<Loader> ok;

        n(AbstractC0469ok<Loader> abstractC0469ok) {
            this.ok = abstractC0469ok;
        }

        private void ok(a<Loader> aVar, int i4) {
            try {
                com.bytedance.sdk.openadsdk.api.bl.a("_tt_ad_sdk_", "load ad slot type: " + i4);
                this.ok.ok(aVar, i4);
            } catch (Throwable th) {
                this.ok.ok(th);
                throw th;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void a(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.3
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(6, com.bykv.ok.ok.ok.ok.a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void bl(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.4
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(9, com.bykv.ok.ok.ok.ok.a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void h(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.9
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(5, com.bykv.ok.ok.ok.ok.a.k(valueSet).j(2, true).h(1, bridge).a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void kf(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.8
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(8, com.bykv.ok.ok.ok.ok.a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void n(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.7
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(7, com.bykv.ok.ok.ok.ok.a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void p(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.10
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(9, com.bykv.ok.ok.ok.ok.a.k(valueSet).j(2, true).h(1, bridge).a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void q(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.2
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(1, com.bykv.ok.ok.ok.ok.a.k(valueSet).j(2, true).h(1, bridge).a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void s(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.5
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(1, com.bykv.ok.ok.ok.ok.a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void ok(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.1
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(5, com.bykv.ok.ok.ok.ok.a.k(valueSet).h(1, bridge).a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void ok(final ValueSet valueSet, final Bridge bridge, final int i4) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.6
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(3, com.bykv.ok.ok.ok.ok.a.k(valueSet).f(3, i4).h(1, bridge).a(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public Pair<Integer, String> ok(Exception exc) {
            com.bytedance.sdk.openadsdk.api.bl.s("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "\u5e7f\u544aSDK\u672aReady, \u8bf7\u5728load(\u8bf7\u6c42\u5e7f\u544a\uff09\u4e4b\u524d\uff0c\u5148\u8c03\u7528init and start\u65b9\u6cd5\uff0c\u4ee5\u907f\u514d\u65e0\u6cd5\u8bf7\u6c42\u5e7f\u544a".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(4202, "Load ad failed: " + exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ok(Manager manager) {
        com.bytedance.sdk.openadsdk.api.bl.a("_tt_ad_sdk_", "update manager");
        a().ok(manager);
        a().register(com.bytedance.sdk.openadsdk.ok.bl.ok());
    }
}
