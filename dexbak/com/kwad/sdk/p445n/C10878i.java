package com.kwad.sdk.p445n;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.n.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10878i {
    private static final String CLAZZ_NAME = "com.kwad.sdk.n.i";
    private static final ThreadLocal<C10880a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static final Map<Context, Context> sResContextCache = new WeakHashMap();
    private static final AtomicBoolean aTn = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.n.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10880a {
        private WeakReference<Context> aiJ;
        private int aiK;
        private StackTraceElement[] aiL;
        private int aiM;
        private long aiN;

        private C10880a() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
        }

        /* renamed from: c */
        static /* synthetic */ int m24583c(C10880a c10880a) {
            int i = c10880a.aiK;
            c10880a.aiK = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
            this.aiN = 0L;
        }

        /* renamed from: g */
        static /* synthetic */ int m24579g(C10880a c10880a) {
            int i = c10880a.aiM;
            c10880a.aiM = i + 1;
            return i;
        }

        /* synthetic */ C10880a(byte b) {
            this();
        }
    }

    /* renamed from: NY */
    public static boolean m24595NY() {
        return aTn.get();
    }

    /* renamed from: a */
    private static void m24594a(final Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (context instanceof Activity) {
            C10232b.m26625DD();
            C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.sdk.n.i.1
                @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
                /* renamed from: onActivityDestroyed */
                public final void mo24589b(@NonNull Activity activity) {
                    if (activity == context) {
                        C10232b.m26625DD();
                        C10232b.m26621b((InterfaceC10246c) this);
                        C10878i.onDestroy(context);
                    }
                }
            });
        }
    }

    /* renamed from: cj */
    public static void m24592cj(boolean z) {
        aTn.set(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: dk */
    public static Context m24591dk(Context context) {
        if (context instanceof InterfaceC10869a) {
            context = ((InterfaceC10869a) context).getDelegatedContext();
        }
        if (C10887l.m24554ds(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i = 0; i < 10; i++) {
            if (runtimeException == null) {
                boolean mo24336ys = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24336ys();
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + mo24336ys);
                ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            if (C10881j.m24576ar(context)) {
                context = C10881j.m24577aq(context);
            }
            if (context instanceof InterfaceC10869a) {
                context = ((InterfaceC10869a) context).getDelegatedContext();
            }
            if (C10887l.m24554ds(context)) {
                return context;
            }
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: dl */
    public static Context m24590dl(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(m24591dk(context).getApplicationContext());
        if (origApplicationContext instanceof Application) {
            return origApplicationContext;
        }
        for (int i = 0; i < 10; i++) {
            origApplicationContext = StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext());
            if (origApplicationContext instanceof Application) {
                return origApplicationContext;
            }
            if (origApplicationContext instanceof InterfaceC10869a) {
                origApplicationContext = ((InterfaceC10869a) origApplicationContext).getDelegatedContext();
            }
        }
        return origApplicationContext;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static void onDestroy(Context context) {
        sResContextCache.remove(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader classLoader2 = C10873e.m24602NV().getClassLoader();
        return classLoader2 != null ? classLoader2 : classLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources resources = C10873e.m24602NV().getResources();
        if (resources != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = resources.newTheme();
                newTheme.applyStyle(i, true);
                return newTheme;
            }
            return theme2;
        }
        return theme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<C10880a> threadLocal = sAutoUnWrapModelTL;
        C10880a c10880a = threadLocal.get();
        if (c10880a != null) {
            if (c10880a.aiJ.get() == context && Math.abs(System.currentTimeMillis() - c10880a.aiN) < 150) {
                C10880a.m24583c(c10880a);
                if (c10880a.aiK >= (context instanceof Application ? 15 : 5) && m24593a(context, c10880a)) {
                    c10880a.clear();
                    return true;
                }
            } else {
                c10880a.clear();
                c10880a.aiJ = new WeakReference(context);
                c10880a.aiN = System.currentTimeMillis();
            }
        } else {
            threadLocal.set(new C10880a((byte) 0));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context wrapContextIfNeed(Context context) {
        Context context2;
        if (context == null) {
            ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        } else if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp() && !(context instanceof InterfaceC10869a)) {
            if (C10881j.m24576ar(context)) {
                context = C10881j.unwrapContextIfNeed(context);
                if (C10881j.m24576ar(context)) {
                    ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                    return context;
                }
            }
            Context context3 = sResContextCache.get(context);
            if (context3 instanceof InterfaceC10869a) {
                return context3;
            }
            if (C10882k.m24569dm(context)) {
                return context;
            }
            if (returnUnWrappedContext(context)) {
                ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: " + context.getClass().getName()));
                return context;
            }
            if (context instanceof Application) {
                try {
                    ApplicationC10875f applicationC10875f = new ApplicationC10875f((Application) context, new C10876g(context, C10873e.m24602NV()));
                    C10887l.m24564a(applicationC10875f);
                    context2 = applicationC10875f;
                } catch (Throwable unused) {
                    boolean mo24336ys = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24336ys();
                    ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(new RuntimeException("wrapper Application fail --context:" + context.getClass().getName() + "--initFinish:" + mo24336ys));
                    return context;
                }
            } else if (context instanceof ContextThemeWrapper) {
                context2 = new C10870b((ContextThemeWrapper) context);
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                context2 = new C10871c((androidx.appcompat.view.ContextThemeWrapper) context);
            } else if (context instanceof ContextWrapper) {
                context2 = new C10872d(context);
            } else {
                context2 = new C10872d(context);
            }
            m24594a(context, context2);
            return context2;
        } else {
            return context;
        }
    }

    /* renamed from: a */
    private static boolean m24593a(Context context, C10880a c10880a) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, c10880a.aiL)) {
            C10880a.m24579g(c10880a);
            c10880a.aiL = stackTrace;
            if (c10880a.aiM >= 5) {
                Log.d("Wrapper", "needAutoUnWrap true 连续相同堆栈");
                return true;
            }
            return false;
        } else if (c10880a.aiL == null) {
            c10880a.aiL = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str) && className.contains(str)) {
                        Log.d("Wrapper", "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            c10880a.clear();
            return false;
        }
    }
}
