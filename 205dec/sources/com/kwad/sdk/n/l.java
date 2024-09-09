package com.kwad.sdk.n;

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
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l {
    private static Application aTu;

    public static Application Ob() {
        checkInit();
        Application Oc = Oc();
        if (i.NY()) {
            aTu = (Application) i.wrapContextIfNeed(Oc);
        }
        return aTu;
    }

    private static Application Oc() {
        Context origApplicationContext;
        Application application = aTu;
        if (application != null) {
            return application;
        }
        Context KO = ServiceProvider.KO();
        if (KO instanceof Application) {
            Application application2 = (Application) KO;
            aTu = application2;
            return application2;
        }
        Context origApplicationContext2 = StubApp.getOrigApplicationContext(KO.getApplicationContext());
        if (origApplicationContext2 instanceof Application) {
            Application application3 = (Application) origApplicationContext2;
            aTu = application3;
            return application3;
        }
        if (ar(origApplicationContext2)) {
            origApplicationContext = i.dl(origApplicationContext2);
        } else if (j.ar(origApplicationContext2)) {
            origApplicationContext = j.dl(origApplicationContext2);
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(KO.getApplicationContext());
        }
        if (origApplicationContext instanceof Application) {
            aTu = (Application) origApplicationContext;
        } else {
            Application application4 = com.kwad.sdk.core.c.b.DD().getApplication();
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
            aTu = Od();
        }
        Application dr = dr(aTu);
        aTu = dr;
        return dr;
    }

    private static Application Od() {
        Application application = (Application) s.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) s.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static View a(Context context, @LayoutRes int i4, @Nullable ViewGroup viewGroup, boolean z3) {
        return du(context).inflate(i4, viewGroup, false);
    }

    private static boolean ar(Context context) {
        return context instanceof a;
    }

    public static LayoutInflater b(Context context, Context context2) {
        LayoutInflater cloneInContext = LayoutInflater.from(dv(context)).cloneInContext(context2);
        a(cloneInContext);
        return cloneInContext;
    }

    private static void checkInit() {
        if (e.NV().MA()) {
            return;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("please init KSPlugin"));
    }

    @Nullable
    public static Activity dn(@Nullable Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context dp = dp(context);
        if (dp instanceof Activity) {
            return (Activity) dp;
        }
        com.kwad.sdk.core.c.b.DD();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    @NonNull
    /* renamed from: do  reason: not valid java name */
    private static Context m97do(Context context) {
        if (i.NY() && !ar(context)) {
            boolean ys = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys();
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + ys));
        } else if (!i.NY() && !j.ar(context)) {
            boolean ys2 = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys();
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + ys2));
        }
        return context;
    }

    @NonNull
    public static Context dp(Context context) {
        Context unwrapContextIfNeed;
        checkInit();
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp() && !ds(context)) {
            if (ar(context)) {
                unwrapContextIfNeed = i.dk(context);
            } else {
                unwrapContextIfNeed = j.unwrapContextIfNeed(context);
            }
            return dq(unwrapContextIfNeed);
        }
        return context;
    }

    private static Context dq(Context context) {
        if (j.ar(context) || (context instanceof a)) {
            boolean ys = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys();
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ys));
        }
        return context;
    }

    private static Application dr(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        boolean ys = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys();
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ys + "--isExternal:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp()));
        return null;
    }

    public static boolean ds(Context context) {
        return (ar(context) || j.ar(context)) ? false : true;
    }

    public static Context dt(Context context) {
        try {
            if (j.ar(context)) {
                context = j.aq(context);
            }
            if (context instanceof a) {
                context = ((a) context).getDelegatedContext();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        if (ds(context)) {
            return context;
        }
        for (int i4 = 0; i4 < 5; i4++) {
            if (j.ar(context)) {
                context = j.aq(context);
            }
            if (context instanceof a) {
                context = ((a) context).getDelegatedContext();
            }
            if (ds(context)) {
                return context;
            }
        }
        return context;
    }

    public static LayoutInflater du(Context context) {
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        if (j.ar(wrapContextIfNeed)) {
            LayoutInflater from = LayoutInflater.from(wrapContextIfNeed);
            a(from);
            return from;
        }
        return LayoutInflater.from(wrapContextIfNeed);
    }

    private static Context dv(Context context) {
        return context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : context;
    }

    public static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object callMethod = s.callMethod(context, "getThemeResId", new Object[0]);
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

    public static void h(Activity activity) {
        j.onDestroy(activity);
    }

    public static View inflate(Context context, @LayoutRes int i4, @Nullable ViewGroup viewGroup) {
        return du(context).inflate(i4, viewGroup);
    }

    @NonNull
    public static Context wrapContextIfNeed(Context context) {
        Context wrapContextIfNeed;
        checkInit();
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp()) {
            if (i.NY()) {
                wrapContextIfNeed = i.wrapContextIfNeed(context);
            } else {
                wrapContextIfNeed = j.wrapContextIfNeed(context);
            }
            return m97do(wrapContextIfNeed);
        }
        return context;
    }

    public static void x(Context context, boolean z3) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z3).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    public static void a(Application application) {
        if (aTu == null) {
            aTu = application;
        }
    }

    private static void a(LayoutInflater layoutInflater) {
        s.a(layoutInflater, "mFactory", (Object) null);
        s.a(layoutInflater, "mFactory2", (Object) null);
    }
}
