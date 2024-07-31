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
import com.kwad.sdk.api.C9702c;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Wrapper {
    private static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    private static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    private static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    private static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    private static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    private static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    private static final String TAG = "Wrapper";
    private static final int TIMELINE_MINIWRAP = 150;
    private static final ThreadLocal<C9711a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static Map<Context, Context> sResContextCache = new WeakHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.Wrapper$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9711a {
        private WeakReference<Context> aiJ;
        private int aiK;
        private StackTraceElement[] aiL;
        private int aiM;
        private long aiN;

        private C9711a() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
        }

        /* renamed from: c */
        static /* synthetic */ int m27963c(C9711a c9711a) {
            int i = c9711a.aiK;
            c9711a.aiK = i + 1;
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
        static /* synthetic */ int m27959g(C9711a c9711a) {
            int i = c9711a.aiM;
            c9711a.aiM = i + 1;
            return i;
        }

        /* synthetic */ C9711a(byte b) {
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
            Object obj = Reflect.m27978h(context).m27980cj("getThemeResId").get();
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

    private static boolean needAutoUnWrap(Context context, C9711a c9711a) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, c9711a.aiL)) {
            C9711a.m27959g(c9711a);
            c9711a.aiL = stackTrace;
            if (c9711a.aiM >= 5) {
                Log.d(TAG, "needAutoUnWrap true 连续相同堆栈");
                return true;
            }
            return false;
        } else if (c9711a.aiL == null) {
            c9711a.aiL = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str) && className.contains(str)) {
                        Log.d(TAG, "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && METHOD_WRAP_CONTEXT.equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            c9711a.clear();
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
    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources.Theme theme3 = (Resources.Theme) C9702c.m28017f("WRT", theme, theme2, Integer.valueOf(i));
        if (theme3 != null) {
            return theme3;
        }
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            if (theme2 == null) {
                Resources.Theme newTheme = externalResource.newTheme();
                newTheme.applyStyle(i, true);
                return newTheme;
            }
            return theme2;
        }
        return theme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<C9711a> threadLocal = sAutoUnWrapModelTL;
        C9711a c9711a = threadLocal.get();
        if (c9711a != null) {
            if (c9711a.aiJ.get() == context && Math.abs(System.currentTimeMillis() - c9711a.aiN) < 150) {
                C9711a.m27963c(c9711a);
                if (c9711a.aiK >= (context instanceof Application ? 15 : 5) && needAutoUnWrap(context, c9711a)) {
                    c9711a.clear();
                    return true;
                }
            } else {
                c9711a.clear();
                c9711a.aiJ = new WeakReference(context);
                c9711a.aiN = System.currentTimeMillis();
            }
        } else {
            threadLocal.set(new C9711a((byte) 0));
        }
        return false;
    }

    @Keep
    @Deprecated
    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = (Context) C9702c.m28017f("URC", context);
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
        Context context2 = (Context) C9702c.m28017f("WRC", context);
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
                    C9745n c9745n = new C9745n((ContextThemeWrapper) context);
                    sResContextCache.put(context, c9745n);
                    return c9745n;
                }
                return context3;
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                Context context4 = sResContextCache.get(context);
                if (context4 == null) {
                    C9746o c9746o = new C9746o((androidx.appcompat.view.ContextThemeWrapper) context);
                    sResContextCache.put(context, c9746o);
                    return c9746o;
                }
                return context4;
            } else if (context instanceof ContextWrapper) {
                Context context5 = sResContextCache.get(context);
                if (context5 == null) {
                    C9747p c9747p = new C9747p(context);
                    sResContextCache.put(context, c9747p);
                    return c9747p;
                }
                return context5;
            } else {
                Context context6 = sResContextCache.get(context);
                if (context6 == null) {
                    C9747p c9747p2 = new C9747p(context);
                    sResContextCache.put(context, c9747p2);
                    return c9747p2;
                }
                return context6;
            }
        }
        return context;
    }

    @Keep
    @Deprecated
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        LayoutInflater layoutInflater2 = (LayoutInflater) C9702c.m28017f("WRI", layoutInflater);
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
