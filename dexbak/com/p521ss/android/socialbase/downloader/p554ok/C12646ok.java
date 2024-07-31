package com.p521ss.android.socialbase.downloader.p554ok;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.ok.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12646ok {

    /* renamed from: a */
    private InterfaceC12649bl f35653a;

    /* renamed from: bl */
    private final List<InterfaceC12650ok> f35654bl;

    /* renamed from: h */
    private volatile boolean f35655h;

    /* renamed from: kf */
    private volatile int f35656kf;

    /* renamed from: n */
    private WeakReference<Activity> f35657n;

    /* renamed from: ok */
    private Application f35658ok;

    /* renamed from: p */
    private final Application.ActivityLifecycleCallbacks f35659p;

    /* renamed from: s */
    private int f35660s;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.downloader.ok.ok$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12648a {

        /* renamed from: ok */
        private static final C12646ok f35662ok = new C12646ok();
    }

    /* renamed from: com.ss.android.socialbase.downloader.ok.ok$bl */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12649bl {
    }

    /* renamed from: com.ss.android.socialbase.downloader.ok.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12650ok {
        @MainThread
        /* renamed from: a */
        void mo16836a();

        @MainThread
        /* renamed from: bl */
        void mo16835bl();
    }

    /* renamed from: h */
    private boolean m16849h() {
        try {
            Application application = this.f35658ok;
            if (application == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) application.getSystemService(TTDownloadField.TT_ACTIVITY);
            return TextUtils.equals(application.getPackageName(), C12713kf.m16520s(application));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kf */
    public void m16848kf() {
        this.f35656kf = 0;
        Object[] m16838s = m16838s();
        if (m16838s != null) {
            for (Object obj : m16838s) {
                ((InterfaceC12650ok) obj).mo16835bl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m16847n() {
        this.f35656kf = 1;
        Object[] m16838s = m16838s();
        if (m16838s != null) {
            for (Object obj : m16838s) {
                ((InterfaceC12650ok) obj).mo16836a();
            }
        }
    }

    /* renamed from: s */
    private Object[] m16838s() {
        Object[] array;
        synchronized (this.f35654bl) {
            array = this.f35654bl.size() > 0 ? this.f35654bl.toArray() : null;
        }
        return array;
    }

    private C12646ok() {
        this.f35654bl = new ArrayList();
        this.f35656kf = -1;
        this.f35655h = false;
        this.f35659p = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.ok.ok.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                C12646ok.this.f35655h = true;
                if (C12646ok.this.f35660s != 0 || activity == null) {
                    return;
                }
                C12646ok.this.f35660s = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = C12646ok.this.f35660s;
                C12646ok.this.f35655h = false;
                C12646ok.this.f35660s = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    C12646ok.this.m16847n();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                C12646ok.this.f35657n = new WeakReference(activity);
                int i = C12646ok.this.f35660s;
                C12646ok.this.f35660s = activity != null ? activity.hashCode() : i;
                C12646ok.this.f35655h = false;
                if (i == 0) {
                    C12646ok.this.m16847n();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == C12646ok.this.f35660s) {
                    C12646ok.this.f35660s = 0;
                    C12646ok.this.m16848kf();
                }
                C12646ok.this.f35655h = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* renamed from: a */
    public boolean m16854a() {
        int i = this.f35656kf;
        int i2 = i;
        if (i == -1) {
            ?? m16849h = m16849h();
            this.f35656kf = m16849h;
            i2 = m16849h;
        }
        return i2 == 1;
    }

    /* renamed from: bl */
    public boolean m16851bl() {
        return m16854a() && !this.f35655h;
    }

    /* renamed from: ok */
    public static C12646ok m16846ok() {
        return C12648a.f35662ok;
    }

    /* renamed from: a */
    public void m16853a(InterfaceC12650ok interfaceC12650ok) {
        synchronized (this.f35654bl) {
            this.f35654bl.remove(interfaceC12650ok);
        }
    }

    /* renamed from: ok */
    public void m16845ok(Context context) {
        if (this.f35658ok == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f35658ok == null) {
                    Application application = (Application) context;
                    this.f35658ok = application;
                    application.registerActivityLifecycleCallbacks(this.f35659p);
                }
            }
        }
    }

    /* renamed from: ok */
    public void m16844ok(InterfaceC12649bl interfaceC12649bl) {
        this.f35653a = interfaceC12649bl;
    }

    /* renamed from: ok */
    public void m16843ok(InterfaceC12650ok interfaceC12650ok) {
        if (interfaceC12650ok == null) {
            return;
        }
        synchronized (this.f35654bl) {
            if (!this.f35654bl.contains(interfaceC12650ok)) {
                this.f35654bl.add(interfaceC12650ok);
            }
        }
    }
}
