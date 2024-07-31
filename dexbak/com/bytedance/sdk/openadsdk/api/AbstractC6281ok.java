package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.EventListener;
import com.bykv.p110vk.openvk.api.proto.Loader;
import com.bykv.p110vk.openvk.api.proto.Manager;
import com.bykv.p110vk.openvk.api.proto.Result;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationTTLiveTokenInjectionAuthImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl.C6342a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl.C6347ok;
import com.bytedance.sdk.openadsdk.p174n.C6496ok;
import com.bytedance.sdk.openadsdk.p175ok.C6500bl;
import com.bytedance.sdk.openadsdk.p175ok.InterfaceC6499a;
import com.clj.fastble.BleManager;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.bytedance.sdk.openadsdk.api.ok */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC6281ok {

    /* renamed from: ok */
    private TTAdSdk.InitCallback f22362ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.ok$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC6283a<T> {
        /* renamed from: ok */
        void mo36669ok(T t);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.ok$bl */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractC6284bl implements TTAdManager {

        /* renamed from: a */
        private volatile boolean f22366a;

        /* renamed from: bl */
        private List<WeakReference<InterfaceC6283a<Manager>>> f22367bl = new CopyOnWriteArrayList();

        /* renamed from: ok */
        private volatile Manager f22368ok;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.sdk.openadsdk.api.ok$bl$1 */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public class C62851 extends AbstractC6305ok<Loader> {

            /* renamed from: a */
            final InterfaceC6283a<Manager> f22369a;

            /* renamed from: bl */
            final /* synthetic */ SoftReference f22370bl;

            /* renamed from: ok */
            Loader f22371ok;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C62851(SoftReference softReference) {
                super();
                this.f22370bl = softReference;
                this.f22369a = new InterfaceC6283a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                    /* renamed from: ok  reason: avoid collision after fix types in other method */
                    public void mo36669ok(Manager manager) {
                        C62851 c62851 = C62851.this;
                        c62851.f22371ok = manager.createLoader((Context) c62851.f22370bl.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.AbstractC6305ok
            /* renamed from: ok */
            public void mo36656ok(final InterfaceC6283a<Loader> interfaceC6283a, int i) {
                Loader loader = this.f22371ok;
                if (loader != null) {
                    interfaceC6283a.mo36669ok(loader);
                } else {
                    AbstractC6284bl.this.call(new InterfaceC6283a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                        /* renamed from: ok  reason: avoid collision after fix types in other method */
                        public void mo36669ok(Manager manager) {
                            C62851 c62851 = C62851.this;
                            AbstractC6284bl.this.m36714ok(c62851.f22369a);
                            C62851 c628512 = C62851.this;
                            c628512.f22371ok = manager.createLoader((Context) c628512.f22370bl.get());
                            interfaceC6283a.mo36669ok(C62851.this.f22371ok);
                        }
                    }, i + BleManager.f22896l);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static <T> T m36739a(Manager manager, Class<T> cls, Bundle bundle) {
            return (T) manager.getBridge(1).call(6, C5930a.m37924c(2).m37919h(9, cls).m37919h(10, bundle).m37926a(), cls);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final InterfaceC6283a<Manager> interfaceC6283a, final int i) {
            if (this.f22368ok != null) {
                try {
                    interfaceC6283a.mo36669ok(this.f22368ok);
                } catch (Throwable th) {
                    C6280bl.m36761s("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    mo36580ok(th);
                }
            } else if (!this.f22366a && i > 10000) {
                throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
            } else {
                C6496ok.m36207ok().m36204ok(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (AbstractC6284bl.this.f22368ok != null) {
                                interfaceC6283a.mo36669ok(AbstractC6284bl.this.f22368ok);
                            } else {
                                C6280bl.m36761s("_tt_ad_sdk_", "Not ready, no manager: " + i);
                            }
                        } catch (Throwable th2) {
                            C6280bl.m36761s("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                            AbstractC6284bl.this.mo36580ok(th2);
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            return new C6294n(new C62851(new SoftReference(context))).m36509ok();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (this.f22368ok != null) {
                return (T) m36739a(this.f22368ok, cls, bundle);
            }
            call(new InterfaceC6283a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.4
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Manager manager) {
                    AbstractC6284bl.m36739a(AbstractC6284bl.this.f22368ok, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.f22368ok != null ? this.f22368ok.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "5.9.0.8";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.f22368ok != null) {
                return this.f22368ok.values().intValue(11);
            }
            return 0;
        }

        /* renamed from: ok */
        protected Object mo36581ok(Object obj) {
            return obj;
        }

        /* renamed from: ok */
        protected void mo36580ok(Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            call(new InterfaceC6283a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.2
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Manager manager) {
                    manager.getBridge(1).call(4, C5930a.m37924c(1).m37919h(8, AbstractC6284bl.this.mo36581ok(obj)).m37926a(), Void.class);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            call(new InterfaceC6283a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.5
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Manager manager) {
                    manager.getBridge(1).call(3, C5930a.m37924c(1).m37919h(7, context).m37926a(), Void.class);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i) {
            call(new InterfaceC6283a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.6
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Manager manager) {
                    manager.getBridge(1).call(1, C5930a.m37925b().m37921f(11, i).m37926a(), Void.class);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            HashMap hashMap = new HashMap();
            hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
            hashMap.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, exitInstallListener);
            return ((Boolean) DownloadBridgeFactory.getDownloadBridge(TTAppContextHolder.getContext()).call(0, C5930a.m37924c(1).m37919h(0, hashMap).m37926a(), Boolean.class)).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            call(new InterfaceC6283a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.3
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Manager manager) {
                    manager.getBridge(1).call(5, C5930a.m37924c(1).m37919h(8, obj).m37926a(), Void.class);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet m37926a = C5930a.m37916k(C6342a.m36536a(adSlot)).m37917j(13, z).m37921f(14, i).m37926a();
            if (this.f22368ok != null) {
                return (String) this.f22368ok.getBridge(1).call(2, m37926a, String.class);
            }
            return null;
        }

        /* renamed from: ok */
        public void m36708ok(boolean z) {
            this.f22366a = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ok */
        public void m36716ok(Manager manager) {
            this.f22368ok = manager;
            if (this.f22368ok != null) {
                Iterator<WeakReference<InterfaceC6283a<Manager>>> it = this.f22367bl.iterator();
                while (it.hasNext()) {
                    WeakReference<InterfaceC6283a<Manager>> next = it.next();
                    InterfaceC6283a<Manager> interfaceC6283a = next != null ? next.get() : null;
                    if (interfaceC6283a != null) {
                        interfaceC6283a.mo36669ok(manager);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ok */
        public void m36714ok(InterfaceC6283a<Manager> interfaceC6283a) {
            this.f22367bl.add(new WeakReference<>(interfaceC6283a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.ok$ok */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class AbstractC6305ok<T> {
        private AbstractC6305ok() {
        }

        /* renamed from: ok */
        abstract void mo36656ok(InterfaceC6283a<T> interfaceC6283a, int i);

        /* renamed from: ok */
        void m36655ok(Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.api.ok$s */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C6306s implements EventListener {
        private C6306s() {
        }

        @Override // com.bykv.p110vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i, Result result) {
            AbstractC6281ok.this.m36760a(result);
            return null;
        }
    }

    /* renamed from: a */
    public abstract AbstractC6284bl mo36592a();

    /* renamed from: a */
    public abstract void mo36591a(Context context, C5930a c5930a);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m36760a(Result result) {
        mo36584ok(result);
        if (result.isSuccess()) {
            C6280bl.m36774a("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.f22362ok;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            C6280bl.m36769n("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.f22362ok;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.f22362ok = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo36590a(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    /* renamed from: bl */
    protected abstract InterfaceC6499a mo36588bl();

    /* renamed from: ok */
    public void m36759ok(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        C6500bl.m36198ok().m36196ok(mo36588bl());
        if (mo36590a(context, adConfig, initCallback)) {
            this.f22362ok = initCallback;
            final C5930a m37916k = C5930a.m37916k(C6347ok.m36531ok(adConfig));
            m37916k.m37920g(1, SystemClock.elapsedRealtime());
            m37916k.m37918i(5, "main");
            m37916k.m37917j(4, true);
            m37916k.m37921f(6, 999);
            m37916k.m37921f(10, 5908);
            m37916k.m37918i(11, "5.9.0.8");
            m37916k.m37918i(12, "com.byted.pangle.m");
            m37916k.m37917j(14, false);
            m37916k.m37919h(16, C6500bl.m36198ok());
            Thread currentThread = Thread.currentThread();
            m37916k.m37918i(2, currentThread.getName());
            m37916k.m37921f(3, currentThread.getPriority());
            m37916k.m37919h(15, new C6306s());
            m37916k.m37919h(8301, new MediationInitCLassLoader());
            if (adConfig instanceof TTAdConfig) {
                m37916k.m37919h(8318, new MediationTTLiveTokenInjectionAuthImpl(((TTAdConfig) adConfig).getInjectionAuth()));
            }
            if (adConfig != null) {
                MediationApiLog.setDebug(Boolean.valueOf(adConfig.isDebug()));
            }
            if (!mo36585ok(context, m37916k)) {
                C6496ok.m36207ok().m36204ok(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.ok.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC6281ok.this.mo36591a(context, m37916k);
                    }
                });
            }
            mo36592a().m36708ok(true);
        }
    }

    /* renamed from: ok */
    protected void mo36584ok(Result result) {
    }

    /* renamed from: ok */
    public abstract boolean mo36587ok();

    /* renamed from: ok */
    public abstract boolean mo36585ok(Context context, C5930a c5930a);

    /* renamed from: com.bytedance.sdk.openadsdk.api.ok$n */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C6294n extends AbstractC6364ok {

        /* renamed from: ok */
        private AbstractC6305ok<Loader> f22390ok;

        C6294n(AbstractC6305ok<Loader> abstractC6305ok) {
            this.f22390ok = abstractC6305ok;
        }

        /* renamed from: ok */
        private void m36680ok(InterfaceC6283a<Loader> interfaceC6283a, int i) {
            try {
                C6280bl.m36774a("_tt_ad_sdk_", "load ad slot type: " + i);
                this.f22390ok.mo36656ok(interfaceC6283a, i);
            } catch (Throwable th) {
                this.f22390ok.m36655ok(th);
                throw th;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: a */
        public void mo36514a(final ValueSet valueSet, final Bridge bridge) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.3
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(6, C5930a.m37916k(valueSet).m37919h(1, bridge).m37926a(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: bl */
        public void mo36513bl(final ValueSet valueSet, final Bridge bridge) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.4
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(9, C5930a.m37916k(valueSet).m37919h(1, bridge).m37926a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: h */
        public void mo36512h(final ValueSet valueSet, final Bridge bridge) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.9
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(5, C5930a.m37916k(valueSet).m37917j(2, true).m37919h(1, bridge).m37926a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: kf */
        public void mo36511kf(final ValueSet valueSet, final Bridge bridge) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.8
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(8, C5930a.m37916k(valueSet).m37919h(1, bridge).m37926a(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: n */
        public void mo36510n(final ValueSet valueSet, final Bridge bridge) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.7
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(7, C5930a.m37916k(valueSet).m37919h(1, bridge).m37926a(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: p */
        public void mo36505p(final ValueSet valueSet, final Bridge bridge) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.10
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(9, C5930a.m37916k(valueSet).m37917j(2, true).m37919h(1, bridge).m37926a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: q */
        public void mo36504q(final ValueSet valueSet, final Bridge bridge) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.2
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(1, C5930a.m37916k(valueSet).m37917j(2, true).m37919h(1, bridge).m37926a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: s */
        public void mo36503s(final ValueSet valueSet, final Bridge bridge) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.5
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(1, C5930a.m37916k(valueSet).m37919h(1, bridge).m37926a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: ok */
        public void mo36508ok(final ValueSet valueSet, final Bridge bridge) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.1
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(5, C5930a.m37916k(valueSet).m37919h(1, bridge).m37926a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: ok */
        public void mo36507ok(final ValueSet valueSet, final Bridge bridge, final int i) {
            m36680ok(new InterfaceC6283a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.6
                @Override // com.bytedance.sdk.openadsdk.api.AbstractC6281ok.InterfaceC6283a
                /* renamed from: ok  reason: avoid collision after fix types in other method */
                public void mo36669ok(Loader loader) {
                    loader.load(3, C5930a.m37916k(valueSet).m37921f(3, i).m37919h(1, bridge).m37926a(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.AbstractC6364ok
        /* renamed from: ok */
        public Pair<Integer, String> mo36506ok(Exception exc) {
            C6280bl.m36761s("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            Integer valueOf = Integer.valueOf((int) TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED);
            return new Pair<>(valueOf, "Load ad failed: " + exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ok */
    public void m36758ok(Manager manager) {
        C6280bl.m36774a("_tt_ad_sdk_", "update manager");
        mo36592a().m36716ok(manager);
        mo36592a().register(C6500bl.m36198ok());
    }
}
