package com.kwad.sdk.core.p391c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11065bo;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.core.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10232b implements InterfaceC10246c<Activity> {
    private static volatile C10232b avd;
    private static final List<InterfaceC10246c> mListeners = new CopyOnWriteArrayList();

    /* renamed from: JB */
    private final AtomicBoolean f29532JB = new AtomicBoolean(false);
    @Nullable
    private Application mApplication;

    private C10232b() {
    }

    /* renamed from: DD */
    public static C10232b m26625DD() {
        if (avd == null) {
            synchronized (C10232b.class) {
                if (avd == null) {
                    avd = new C10232b();
                }
            }
        }
        return avd;
    }

    /* renamed from: DE */
    public static boolean m26624DE() {
        try {
            if (C11065bo.m23855az(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion(), "3.3.26")) {
                return KSLifecycleObserver.getInstance().isEnable();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Nullable
    public static Activity getCurrentActivity() {
        if (m26624DE()) {
            return KSLifecycleObserver.getInstance().getCurrentActivity();
        }
        if (C10230a.m26630DB().isEnable()) {
            return C10230a.m26630DB().getCurrentActivity();
        }
        return null;
    }

    public static boolean isAppOnForeground() {
        if (m26624DE()) {
            return KSLifecycleObserver.getInstance().isAppOnForeground();
        }
        if (C10230a.m26630DB().isEnable()) {
            return C10230a.m26630DB().isAppOnForeground();
        }
        return false;
    }

    public static boolean isEnable() {
        return m26624DE() || C10230a.m26630DB().isEnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.p391c.InterfaceC10246c
    /* renamed from: onActivityCreated */
    public void mo24393a(final Activity activity, final Bundle bundle) {
        m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: c */
            public void accept(InterfaceC10246c interfaceC10246c) {
                interfaceC10246c.mo24393a(activity, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.p391c.InterfaceC10246c
    /* renamed from: onActivityDestroyed */
    public void mo24589b(final Activity activity) {
        m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: c */
            public void accept(InterfaceC10246c interfaceC10246c) {
                interfaceC10246c.mo24589b(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.p391c.InterfaceC10246c
    /* renamed from: onActivityPaused */
    public void mo26607c(final Activity activity) {
        m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: c */
            public void accept(InterfaceC10246c interfaceC10246c) {
                interfaceC10246c.mo26607c(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.p391c.InterfaceC10246c
    /* renamed from: onActivityResumed */
    public void mo26606d(final Activity activity) {
        m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: c */
            public void accept(InterfaceC10246c interfaceC10246c) {
                interfaceC10246c.mo26606d(activity);
            }
        });
    }

    @Nullable
    public final Application getApplication() {
        return this.mApplication;
    }

    public final void init(Context context) {
        if (this.f29532JB.get() || context == null) {
            return;
        }
        this.f29532JB.set(true);
        try {
            if (C11065bo.m23855az(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion(), "3.3.26")) {
                this.mApplication = KSLifecycleObserver.getInstance().getApplication();
                KSLifecycleObserver.getInstance().registerLifecycleListener(new KSLifecycleListener() { // from class: com.kwad.sdk.core.c.b.1
                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
                        C10232b c10232b = C10232b.this;
                        C10232b.m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.1.1
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.p434g.InterfaceC10761a
                            /* renamed from: c */
                            public void accept(InterfaceC10246c interfaceC10246c) {
                                interfaceC10246c.mo24393a(activity, bundle);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityDestroyed(final Activity activity) {
                        C10232b c10232b = C10232b.this;
                        C10232b.m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.1.4
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.p434g.InterfaceC10761a
                            /* renamed from: c */
                            public void accept(InterfaceC10246c interfaceC10246c) {
                                interfaceC10246c.mo24589b(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityPaused(final Activity activity) {
                        C10232b c10232b = C10232b.this;
                        C10232b.m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.1.3
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.p434g.InterfaceC10761a
                            /* renamed from: c */
                            public void accept(InterfaceC10246c interfaceC10246c) {
                                interfaceC10246c.mo26607c(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityResumed(final Activity activity) {
                        C10232b c10232b = C10232b.this;
                        C10232b.m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.1.2
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.p434g.InterfaceC10761a
                            /* renamed from: c */
                            public void accept(InterfaceC10246c interfaceC10246c) {
                                interfaceC10246c.mo26606d(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToBackground() {
                        C10331c.m26257T("LifecycleHolder", "onBackToBackground");
                        C10232b c10232b = C10232b.this;
                        C10232b.m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.1.6
                            /* renamed from: c */
                            private static void m26614c(InterfaceC10246c interfaceC10246c) {
                                interfaceC10246c.onBackToBackground();
                            }

                            @Override // com.kwad.sdk.p434g.InterfaceC10761a
                            public final /* synthetic */ void accept(InterfaceC10246c interfaceC10246c) {
                                m26614c(interfaceC10246c);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToForeground() {
                        C10331c.m26257T("LifecycleHolder", "onBackToForeground");
                        C10232b c10232b = C10232b.this;
                        C10232b.m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.1.5
                            /* renamed from: c */
                            private static void m26615c(InterfaceC10246c interfaceC10246c) {
                                interfaceC10246c.onBackToForeground();
                            }

                            @Override // com.kwad.sdk.p434g.InterfaceC10761a
                            public final /* synthetic */ void accept(InterfaceC10246c interfaceC10246c) {
                                m26615c(interfaceC10246c);
                            }
                        });
                    }
                });
            } else {
                C10331c.m26257T("LifecycleHolder", "init KSLifecycleObserver not support");
            }
        } catch (Throwable unused) {
        }
        Application m24567Ob = C10887l.m24567Ob();
        if (m24567Ob != null) {
            this.mApplication = m24567Ob;
            C10230a.m26630DB().init(this.mApplication);
            C10230a.m26630DB().m26628a(this);
        }
    }

    @Override // com.kwad.sdk.core.p391c.InterfaceC10246c
    public final void onBackToBackground() {
        C10331c.m26257T("LifecycleHolder", "onBackToBackground old");
        m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.7
            /* renamed from: c */
            private static void m26608c(InterfaceC10246c interfaceC10246c) {
                interfaceC10246c.onBackToBackground();
            }

            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            public final /* synthetic */ void accept(InterfaceC10246c interfaceC10246c) {
                m26608c(interfaceC10246c);
            }
        });
    }

    @Override // com.kwad.sdk.core.p391c.InterfaceC10246c
    public final void onBackToForeground() {
        C10331c.m26257T("LifecycleHolder", "onBackToForeground old");
        m26620c(new InterfaceC10761a<InterfaceC10246c>() { // from class: com.kwad.sdk.core.c.b.6
            /* renamed from: c */
            private static void m26609c(InterfaceC10246c interfaceC10246c) {
                interfaceC10246c.onBackToForeground();
            }

            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            public final /* synthetic */ void accept(InterfaceC10246c interfaceC10246c) {
                m26609c(interfaceC10246c);
            }
        });
    }

    /* renamed from: b */
    public static void m26621b(InterfaceC10246c interfaceC10246c) {
        mListeners.remove(interfaceC10246c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static <T> void m26620c(InterfaceC10761a<InterfaceC10246c> interfaceC10761a) {
        for (InterfaceC10246c interfaceC10246c : mListeners) {
            if (interfaceC10246c != null) {
                interfaceC10761a.accept(interfaceC10246c);
            }
        }
    }

    /* renamed from: a */
    public static void m26622a(InterfaceC10246c interfaceC10246c) {
        mListeners.add(interfaceC10246c);
    }
}
