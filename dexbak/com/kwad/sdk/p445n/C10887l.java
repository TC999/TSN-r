package com.kwad.sdk.p445n;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11124s;
import com.stub.StubApp;

/* renamed from: com.kwad.sdk.n.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10887l {
    private static Application aTu;

    /* renamed from: Ob */
    public static Application m24567Ob() {
        checkInit();
        Application m24566Oc = m24566Oc();
        if (C10878i.m24595NY()) {
            aTu = (Application) C10878i.wrapContextIfNeed(m24566Oc);
        }
        return aTu;
    }

    /* renamed from: Oc */
    private static Application m24566Oc() {
        Context origApplicationContext;
        Application application = aTu;
        if (application != null) {
            return application;
        }
        Context m24363KO = ServiceProvider.m24363KO();
        if (m24363KO instanceof Application) {
            Application application2 = (Application) m24363KO;
            aTu = application2;
            return application2;
        }
        Context origApplicationContext2 = StubApp.getOrigApplicationContext(m24363KO.getApplicationContext());
        if (origApplicationContext2 instanceof Application) {
            Application application3 = (Application) origApplicationContext2;
            aTu = application3;
            return application3;
        }
        if (m24561ar(origApplicationContext2)) {
            origApplicationContext = C10878i.m24590dl(origApplicationContext2);
        } else if (C10881j.m24576ar(origApplicationContext2)) {
            origApplicationContext = C10881j.m24575dl(origApplicationContext2);
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(m24363KO.getApplicationContext());
        }
        if (origApplicationContext instanceof Application) {
            aTu = (Application) origApplicationContext;
        } else {
            Application application4 = C10232b.m26625DD().getApplication();
            if (application4 != null) {
                aTu = application4;
            } else if (origApplicationContext instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) origApplicationContext).getBaseContext();
                if (baseContext != null) {
                    baseContext = StubApp.getOrigApplicationContext(baseContext.getApplicationContext());
                }
                if (baseContext instanceof Application) {
                    aTu = (Application) baseContext;
                }
            }
        }
        if (aTu == null) {
            aTu = m24565Od();
        }
        Application m24555dr = m24555dr(aTu);
        aTu = m24555dr;
        return m24555dr;
    }

    /* renamed from: Od */
    private static Application m24565Od() {
        Application application = (Application) C11124s.m23705a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) C11124s.m23705a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    /* renamed from: a */
    public static View m24563a(Context context, @LayoutRes int i, @Nullable ViewGroup viewGroup, boolean z) {
        return m24552du(context).inflate(i, viewGroup, false);
    }

    /* renamed from: ar */
    private static boolean m24561ar(Context context) {
        return context instanceof InterfaceC10869a;
    }

    /* renamed from: b */
    public static LayoutInflater m24560b(Context context, Context context2) {
        LayoutInflater cloneInContext = LayoutInflater.from(m24551dv(context)).cloneInContext(context2);
        m24562a(cloneInContext);
        return cloneInContext;
    }

    private static void checkInit() {
        if (C10873e.m24602NV().m24603MA()) {
            return;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("please init KSPlugin"));
    }

    @Nullable
    /* renamed from: dn */
    public static Activity m24559dn(@Nullable Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context m24557dp = m24557dp(context);
        if (m24557dp instanceof Activity) {
            return (Activity) m24557dp;
        }
        C10232b.m26625DD();
        return C10232b.getCurrentActivity();
    }

    @NonNull
    /* renamed from: do */
    private static Context m24558do(Context context) {
        if (C10878i.m24595NY() && !m24561ar(context)) {
            boolean mo24336ys = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24336ys();
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + mo24336ys));
        } else if (!C10878i.m24595NY() && !C10881j.m24576ar(context)) {
            boolean mo24336ys2 = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24336ys();
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + mo24336ys2));
        }
        return context;
    }

    @NonNull
    /* renamed from: dp */
    public static Context m24557dp(Context context) {
        Context unwrapContextIfNeed;
        checkInit();
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp() && !m24554ds(context)) {
            if (m24561ar(context)) {
                unwrapContextIfNeed = C10878i.m24591dk(context);
            } else {
                unwrapContextIfNeed = C10881j.unwrapContextIfNeed(context);
            }
            return m24556dq(unwrapContextIfNeed);
        }
        return context;
    }

    /* renamed from: dq */
    private static Context m24556dq(Context context) {
        if (C10881j.m24576ar(context) || (context instanceof InterfaceC10869a)) {
            boolean mo24336ys = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24336ys();
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + mo24336ys));
        }
        return context;
    }

    /* renamed from: dr */
    private static Application m24555dr(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        boolean mo24336ys = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24336ys();
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + mo24336ys + "--isExternal:" + ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp()));
        return null;
    }

    /* renamed from: ds */
    public static boolean m24554ds(Context context) {
        return (m24561ar(context) || C10881j.m24576ar(context)) ? false : true;
    }

    /* renamed from: dt */
    public static Context m24553dt(Context context) {
        try {
            if (C10881j.m24576ar(context)) {
                context = C10881j.m24577aq(context);
            }
            if (context instanceof InterfaceC10869a) {
                context = ((InterfaceC10869a) context).getDelegatedContext();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        if (m24554ds(context)) {
            return context;
        }
        for (int i = 0; i < 5; i++) {
            if (C10881j.m24576ar(context)) {
                context = C10881j.m24577aq(context);
            }
            if (context instanceof InterfaceC10869a) {
                context = ((InterfaceC10869a) context).getDelegatedContext();
            }
            if (m24554ds(context)) {
                return context;
            }
        }
        return context;
    }

    /* renamed from: du */
    public static LayoutInflater m24552du(Context context) {
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        if (C10881j.m24576ar(wrapContextIfNeed)) {
            LayoutInflater from = LayoutInflater.from(wrapContextIfNeed);
            m24562a(from);
            return from;
        }
        return LayoutInflater.from(wrapContextIfNeed);
    }

    /* renamed from: dv */
    private static Context m24551dv(Context context) {
        return context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : context;
    }

    public static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object callMethod = C11124s.callMethod(context, "getThemeResId", new Object[0]);
            if (callMethod != null) {
                return ((Integer) callMethod).intValue();
            }
            return 0;
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        } else {
            return 0;
        }
    }

    /* renamed from: h */
    public static void m24550h(Activity activity) {
        C10881j.onDestroy(activity);
    }

    public static View inflate(Context context, @LayoutRes int i, @Nullable ViewGroup viewGroup) {
        return m24552du(context).inflate(i, viewGroup);
    }

    @NonNull
    public static Context wrapContextIfNeed(Context context) {
        Context wrapContextIfNeed;
        checkInit();
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp()) {
            if (C10878i.m24595NY()) {
                wrapContextIfNeed = C10878i.wrapContextIfNeed(context);
            } else {
                wrapContextIfNeed = C10881j.wrapContextIfNeed(context);
            }
            return m24558do(wrapContextIfNeed);
        }
        return context;
    }

    /* renamed from: x */
    public static void m24549x(Context context, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z).apply();
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
    }

    /* renamed from: a */
    public static void m24564a(Application application) {
        if (aTu == null) {
            aTu = application;
        }
    }

    /* renamed from: a */
    private static void m24562a(LayoutInflater layoutInflater) {
        C11124s.m23707a(layoutInflater, "mFactory", (Object) null);
        C11124s.m23707a(layoutInflater, "mFactory2", (Object) null);
    }
}
