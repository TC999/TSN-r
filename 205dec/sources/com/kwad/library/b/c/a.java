package com.kwad.library.b.c;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {
    private static final String CLAZZ_NAME = "com.kwad.library.b.c.a";
    private static final ThreadLocal<C0677a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.library.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0677a {
        private WeakReference<Context> aiJ;
        private int aiK;
        private StackTraceElement[] aiL;
        private int aiM;
        private long aiN;

        private C0677a() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
        }

        static /* synthetic */ int c(C0677a c0677a) {
            int i4 = c0677a.aiK;
            c0677a.aiK = i4 + 1;
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

        static /* synthetic */ int g(C0677a c0677a) {
            int i4 = c0677a.aiM;
            c0677a.aiM = i4 + 1;
            return i4;
        }

        /* synthetic */ C0677a(byte b4) {
            this();
        }
    }

    @Nullable
    private static Context a(String str, Context context) {
        Map<String, WeakReference<Context>> map = sResContextCache;
        WeakReference<Context> weakReference = map.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static Context aq(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static boolean ar(Context context) {
        return context instanceof b;
    }

    private static boolean b(String str, Context context) {
        ThreadLocal<C0677a> threadLocal = sAutoUnWrapModelTL;
        C0677a c0677a = threadLocal.get();
        if (c0677a != null) {
            if (c0677a.aiJ.get() == context && Math.abs(System.currentTimeMillis() - c0677a.aiN) < 150) {
                C0677a.c(c0677a);
                if (c0677a.aiK >= (context instanceof Application ? 15 : 5) && a(str, context, c0677a)) {
                    c0677a.clear();
                    return true;
                }
            } else {
                c0677a.clear();
                c0677a.aiJ = new WeakReference(context);
                c0677a.aiN = System.currentTimeMillis();
            }
        } else {
            threadLocal.set(new C0677a((byte) 0));
        }
        return false;
    }

    private static com.kwad.library.b.a bD(String str) {
        return com.kwad.library.solder.a.a.i(null, str);
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

    @NonNull
    public static Context h(Context context, String str) {
        Context eVar;
        if (context == null) {
            return null;
        }
        com.kwad.library.b.a bD = bD(str);
        if (bD == null || !bD.isLoaded() || (context instanceof b) || b(str, context)) {
            return context;
        }
        Context a4 = a(str, context);
        if (a4 != null) {
            return a4;
        }
        if (context instanceof ContextThemeWrapper) {
            eVar = new c((ContextThemeWrapper) context, str);
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            eVar = new d((androidx.appcompat.view.ContextThemeWrapper) context, str);
        } else if (context instanceof ContextWrapper) {
            eVar = new e(context, str);
        } else {
            eVar = new e(context, str);
        }
        a(str, context, eVar);
        return eVar;
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (ar(context)) {
            context = aq(context);
        }
        if (ar(context)) {
            for (int i4 = 0; i4 < 10; i4++) {
                context = aq(context);
                if (!ar(context)) {
                    return context;
                }
            }
            return context;
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object wrapSystemService(Object obj, String str, Context context) {
        if ("layout_inflater".equals(str) && (obj instanceof LayoutInflater)) {
            LayoutInflater layoutInflater = (LayoutInflater) obj;
            return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
        }
        return obj;
    }

    private static void a(String str, Context context, Context context2) {
        Map<String, WeakReference<Context>> map = sResContextCache;
        map.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean a(String str, Context context, C0677a c0677a) {
        Context a4 = a(str, context);
        String name = a4 != null ? a4.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, c0677a.aiL)) {
            C0677a.g(c0677a);
            c0677a.aiL = stackTrace;
            if (c0677a.aiM >= 5) {
                Log.d("PluginWrapper", "needAutoUnWrap true \u8fde\u7eed\u76f8\u540c\u5806\u6808");
                return true;
            }
            return false;
        } else if (c0677a.aiL == null) {
            c0677a.aiL = stackTrace;
            int i4 = 0;
            int i5 = 0;
            while (i4 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i4];
                String className = stackTraceElement.getClassName();
                for (String str2 : getAutoUnWrapStackList()) {
                    if (className.contains(str2)) {
                        Log.d("PluginWrapper", "needAutoUnWrap true \u547d\u4e2d\u767d\u540d\u5355");
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
            c0677a.clear();
            return false;
        }
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwad.library.b.a bD = bD(str);
        if (bD == null || !bD.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof b) {
            return layoutInflater;
        }
        Context h4 = h(context, str);
        return h4 instanceof b ? layoutInflater.cloneInContext(h4) : layoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources a(Resources resources, String str) {
        com.kwad.library.b.a bD = bD(str);
        if (bD != null && bD.isLoaded()) {
            Resources resources2 = bD.getResources();
            a.a.a(resources2);
            return resources2 != null ? resources2 : resources;
        }
        a.a.a(bD);
        return resources;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i4, String str) {
        Resources resources;
        com.kwad.library.b.a bD = bD(str);
        if (bD == null || !bD.isLoaded() || (resources = bD.getResources()) == null) {
            return theme;
        }
        if (theme2 == null) {
            Resources.Theme newTheme = resources.newTheme();
            newTheme.applyStyle(i4, true);
            return newTheme;
        }
        return theme2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader a(ClassLoader classLoader, String str) {
        com.kwad.library.b.a.b wU;
        com.kwad.library.b.a bD = bD(str);
        return (bD == null || !bD.isLoaded() || (wU = bD.wU()) == null) ? classLoader : wU;
    }
}
