package com.kwad.sdk.n;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class i {
    private static final String CLAZZ_NAME = "com.kwad.sdk.n.i";
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static final Map<Context, Context> sResContextCache = new WeakHashMap();
    private static final AtomicBoolean aTn = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private WeakReference<Context> aiJ;
        private int aiK;
        private StackTraceElement[] aiL;
        private int aiM;
        private long aiN;

        private a() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
        }

        static /* synthetic */ int c(a aVar) {
            int i4 = aVar.aiK;
            aVar.aiK = i4 + 1;
            return i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
            this.aiN = 0L;
        }

        static /* synthetic */ int g(a aVar) {
            int i4 = aVar.aiM;
            aVar.aiM = i4 + 1;
            return i4;
        }

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    public static boolean NY() {
        return aTn.get();
    }

    private static void a(final Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (context instanceof Activity) {
            com.kwad.sdk.core.c.b.DD();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.n.i.1
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityDestroyed */
                public final void b(@NonNull Activity activity) {
                    if (activity == context) {
                        com.kwad.sdk.core.c.b.DD();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        i.onDestroy(context);
                    }
                }
            });
        }
    }

    public static void cj(boolean z3) {
        aTn.set(z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context dk(Context context) {
        if (context instanceof com.kwad.sdk.n.a) {
            context = ((com.kwad.sdk.n.a) context).getDelegatedContext();
        }
        if (l.ds(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i4 = 0; i4 < 10; i4++) {
            if (runtimeException == null) {
                boolean ys = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys();
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ys);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            if (j.ar(context)) {
                context = j.aq(context);
            }
            if (context instanceof com.kwad.sdk.n.a) {
                context = ((com.kwad.sdk.n.a) context).getDelegatedContext();
            }
            if (l.ds(context)) {
                return context;
            }
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context dl(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(dk(context).getApplicationContext());
        if (origApplicationContext instanceof Application) {
            return origApplicationContext;
        }
        for (int i4 = 0; i4 < 10; i4++) {
            origApplicationContext = StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext());
            if (origApplicationContext instanceof Application) {
                return origApplicationContext;
            }
            if (origApplicationContext instanceof com.kwad.sdk.n.a) {
                origApplicationContext = ((com.kwad.sdk.n.a) origApplicationContext).getDelegatedContext();
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
        ClassLoader classLoader2 = e.NV().getClassLoader();
        return classLoader2 != null ? classLoader2 : classLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i4) {
        Resources resources = e.NV().getResources();
        if (resources != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = resources.newTheme();
                newTheme.applyStyle(i4, true);
                return newTheme;
            }
            return theme2;
        }
        return theme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<a> threadLocal = sAutoUnWrapModelTL;
        a aVar = threadLocal.get();
        if (aVar != null) {
            if (aVar.aiJ.get() == context && Math.abs(System.currentTimeMillis() - aVar.aiN) < 150) {
                a.c(aVar);
                if (aVar.aiK >= (context instanceof Application ? 15 : 5) && a(context, aVar)) {
                    aVar.clear();
                    return true;
                }
            } else {
                aVar.clear();
                aVar.aiJ = new WeakReference(context);
                aVar.aiN = System.currentTimeMillis();
            }
        } else {
            threadLocal.set(new a((byte) 0));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context wrapContextIfNeed(Context context) {
        Context context2;
        if (context == null) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        } else if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp() && !(context instanceof com.kwad.sdk.n.a)) {
            if (j.ar(context)) {
                context = j.unwrapContextIfNeed(context);
                if (j.ar(context)) {
                    ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                    return context;
                }
            }
            Context context3 = sResContextCache.get(context);
            if (context3 instanceof com.kwad.sdk.n.a) {
                return context3;
            }
            if (k.dm(context)) {
                return context;
            }
            if (returnUnWrappedContext(context)) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: " + context.getClass().getName()));
                return context;
            }
            if (context instanceof Application) {
                try {
                    f fVar = new f((Application) context, new g(context, e.NV()));
                    l.a(fVar);
                    context2 = fVar;
                } catch (Throwable unused) {
                    boolean ys = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys();
                    ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("wrapper Application fail --context:" + context.getClass().getName() + "--initFinish:" + ys));
                    return context;
                }
            } else if (context instanceof ContextThemeWrapper) {
                context2 = new b((ContextThemeWrapper) context);
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                context2 = new c((androidx.appcompat.view.ContextThemeWrapper) context);
            } else if (context instanceof ContextWrapper) {
                context2 = new d(context);
            } else {
                context2 = new d(context);
            }
            a(context, context2);
            return context2;
        } else {
            return context;
        }
    }

    private static boolean a(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, aVar.aiL)) {
            a.g(aVar);
            aVar.aiL = stackTrace;
            if (aVar.aiM >= 5) {
                Log.d("Wrapper", "needAutoUnWrap true \u8fde\u7eed\u76f8\u540c\u5806\u6808");
                return true;
            }
            return false;
        } else if (aVar.aiL == null) {
            aVar.aiL = stackTrace;
            int i4 = 0;
            int i5 = 0;
            while (i4 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i4];
                String className = stackTraceElement.getClassName();
                for (String str : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str) && className.contains(str)) {
                        Log.d("Wrapper", "needAutoUnWrap true \u547d\u4e2d\u767d\u540d\u5355");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i4++;
                if (i4 < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i4];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i5 = i5 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            aVar.clear();
            return false;
        }
    }
}
