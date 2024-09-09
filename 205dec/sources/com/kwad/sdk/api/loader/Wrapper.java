package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Wrapper {
    private static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    private static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    private static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    private static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    private static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    private static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    private static final String TAG = "Wrapper";
    private static final int TIMELINE_MINIWRAP = 150;
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static Map<Context, Context> sResContextCache = new WeakHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
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

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object obj = Reflect.h(context).cj("getThemeResId").get();
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            return 0;
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        } else {
            return 0;
        }
    }

    private static boolean needAutoUnWrap(Context context, a aVar) {
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

    public static void onDestroy(Context context) {
        if (context == null) {
            return;
        }
        sResContextCache.remove(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        return externalClassLoader != null ? externalClassLoader : classLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : resources;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i4) {
        Resources.Theme theme3 = (Resources.Theme) com.kwad.sdk.api.c.f("WRT", theme, theme2, Integer.valueOf(i4));
        if (theme3 != null) {
            return theme3;
        }
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = externalResource.newTheme();
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
                if (aVar.aiK >= (context instanceof Application ? 15 : 5) && needAutoUnWrap(context, aVar)) {
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

    @Keep
    @Deprecated
    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.f("URC", context);
        if (context2 != null) {
            return context2;
        }
        ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
        Context context3 = context;
        while (context3 instanceof ContextWrapper) {
            if (context3 instanceof Activity) {
                return context3;
            }
            if (context3 instanceof ResContext) {
                resContext = (ResContext) context3;
                context3 = resContext.getDelegatedContext();
            } else {
                context3 = ((ContextWrapper) context3).getBaseContext();
            }
        }
        return resContext != null ? resContext.getDelegatedContext() : context;
    }

    @NonNull
    @Keep
    public static Context wrapContextIfNeed(@Nullable Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.f("WRC", context);
        if (context2 != null) {
            return context2;
        }
        if (Loader.get().isExternalLoaded()) {
            if (context == null) {
                return null;
            }
            if ((context instanceof ResContext) || returnUnWrappedContext(context)) {
                return context;
            }
            if (context instanceof ContextThemeWrapper) {
                Context context3 = sResContextCache.get(context);
                if (context3 == null) {
                    n nVar = new n((ContextThemeWrapper) context);
                    sResContextCache.put(context, nVar);
                    return nVar;
                }
                return context3;
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                Context context4 = sResContextCache.get(context);
                if (context4 == null) {
                    o oVar = new o((androidx.appcompat.view.ContextThemeWrapper) context);
                    sResContextCache.put(context, oVar);
                    return oVar;
                }
                return context4;
            } else if (context instanceof ContextWrapper) {
                Context context5 = sResContextCache.get(context);
                if (context5 == null) {
                    p pVar = new p(context);
                    sResContextCache.put(context, pVar);
                    return pVar;
                }
                return context5;
            } else {
                Context context6 = sResContextCache.get(context);
                if (context6 == null) {
                    p pVar2 = new p(context);
                    sResContextCache.put(context, pVar2);
                    return pVar2;
                }
                return context6;
            }
        }
        return context;
    }

    @Keep
    @Deprecated
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        LayoutInflater layoutInflater2 = (LayoutInflater) com.kwad.sdk.api.c.f("WRI", layoutInflater);
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        if (Loader.get().isExternalLoaded()) {
            Context context = layoutInflater.getContext();
            if (context instanceof ResContext) {
                return layoutInflater;
            }
            Context wrapContextIfNeed = wrapContextIfNeed(context);
            return wrapContextIfNeed instanceof ResContext ? layoutInflater.cloneInContext(wrapContextIfNeed) : layoutInflater;
        }
        return layoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object wrapSystemService(Object obj, String str, Context context) {
        if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
            LayoutInflater layoutInflater = (LayoutInflater) obj;
            return layoutInflater.getContext() instanceof ResContext ? layoutInflater : layoutInflater.cloneInContext(context);
        }
        return obj;
    }
}
