package com.kwad.library.p355b.p358c;

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
import com.kwad.library.p355b.C9586a;
import com.kwad.library.p355b.p356a.C9588b;
import com.kwad.library.solder.p359a.C9602a;
import com.kwad.sdk.utils.C11124s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p011a.R8$$SyntheticClass;

/* renamed from: com.kwad.library.b.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9596a {
    private static final String CLAZZ_NAME = "com.kwad.library.b.c.a";
    private static final ThreadLocal<C9597a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.library.b.c.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9597a {
        private WeakReference<Context> aiJ;
        private int aiK;
        private StackTraceElement[] aiL;
        private int aiM;
        private long aiN;

        private C9597a() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
        }

        /* renamed from: c */
        static /* synthetic */ int m28263c(C9597a c9597a) {
            int i = c9597a.aiK;
            c9597a.aiK = i + 1;
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
        static /* synthetic */ int m28259g(C9597a c9597a) {
            int i = c9597a.aiM;
            c9597a.aiM = i + 1;
            return i;
        }

        /* synthetic */ C9597a(byte b) {
            this();
        }
    }

    @Nullable
    /* renamed from: a */
    private static Context m28276a(String str, Context context) {
        Map<String, WeakReference<Context>> map = sResContextCache;
        WeakReference<Context> weakReference = map.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: aq */
    private static Context m28273aq(Context context) {
        return ((InterfaceC9598b) context).getDelegatedContext();
    }

    /* renamed from: ar */
    private static boolean m28272ar(Context context) {
        return context instanceof InterfaceC9598b;
    }

    /* renamed from: b */
    private static boolean m28271b(String str, Context context) {
        ThreadLocal<C9597a> threadLocal = sAutoUnWrapModelTL;
        C9597a c9597a = threadLocal.get();
        if (c9597a != null) {
            if (c9597a.aiJ.get() == context && Math.abs(System.currentTimeMillis() - c9597a.aiN) < 150) {
                C9597a.m28263c(c9597a);
                if (c9597a.aiK >= (context instanceof Application ? 15 : 5) && m28274a(str, context, c9597a)) {
                    c9597a.clear();
                    return true;
                }
            } else {
                c9597a.clear();
                c9597a.aiJ = new WeakReference(context);
                c9597a.aiN = System.currentTimeMillis();
            }
        } else {
            threadLocal.set(new C9597a((byte) 0));
        }
        return false;
    }

    /* renamed from: bD */
    private static C9586a m28270bD(String str) {
        return C9602a.m28255i(null, str);
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

    @NonNull
    /* renamed from: h */
    public static Context m28269h(Context context, String str) {
        Context c9601e;
        if (context == null) {
            return null;
        }
        C9586a m28270bD = m28270bD(str);
        if (m28270bD == null || !m28270bD.isLoaded() || (context instanceof InterfaceC9598b) || m28271b(str, context)) {
            return context;
        }
        Context m28276a = m28276a(str, context);
        if (m28276a != null) {
            return m28276a;
        }
        if (context instanceof ContextThemeWrapper) {
            c9601e = new C9599c((ContextThemeWrapper) context, str);
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            c9601e = new C9600d((androidx.appcompat.view.ContextThemeWrapper) context, str);
        } else if (context instanceof ContextWrapper) {
            c9601e = new C9601e(context, str);
        } else {
            c9601e = new C9601e(context, str);
        }
        m28275a(str, context, c9601e);
        return c9601e;
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (m28272ar(context)) {
            context = m28273aq(context);
        }
        if (m28272ar(context)) {
            for (int i = 0; i < 10; i++) {
                context = m28273aq(context);
                if (!m28272ar(context)) {
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
            return layoutInflater.getContext() instanceof InterfaceC9598b ? layoutInflater : layoutInflater.cloneInContext(context);
        }
        return obj;
    }

    /* renamed from: a */
    private static void m28275a(String str, Context context, Context context2) {
        Map<String, WeakReference<Context>> map = sResContextCache;
        map.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    /* renamed from: a */
    private static boolean m28274a(String str, Context context, C9597a c9597a) {
        Context m28276a = m28276a(str, context);
        String name = m28276a != null ? m28276a.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, c9597a.aiL)) {
            C9597a.m28259g(c9597a);
            c9597a.aiL = stackTrace;
            if (c9597a.aiM >= 5) {
                Log.d("PluginWrapper", "needAutoUnWrap true 连续相同堆栈");
                return true;
            }
            return false;
        } else if (c9597a.aiL == null) {
            c9597a.aiL = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str2 : getAutoUnWrapStackList()) {
                    if (className.contains(str2)) {
                        Log.d("PluginWrapper", "needAutoUnWrap true 命中白名单");
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
            c9597a.clear();
            return false;
        }
    }

    /* renamed from: a */
    public static LayoutInflater m28278a(LayoutInflater layoutInflater, String str) {
        C9586a m28270bD = m28270bD(str);
        if (m28270bD == null || !m28270bD.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof InterfaceC9598b) {
            return layoutInflater;
        }
        Context m28269h = m28269h(context, str);
        return m28269h instanceof InterfaceC9598b ? layoutInflater.cloneInContext(m28269h) : layoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Resources m28279a(Resources resources, String str) {
        C9586a m28270bD = m28270bD(str);
        if (m28270bD != null && m28270bD.isLoaded()) {
            Resources resources2 = m28270bD.getResources();
            R8$$SyntheticClass.m60055a(resources2);
            return resources2 != null ? resources2 : resources;
        }
        R8$$SyntheticClass.m60055a(m28270bD);
        return resources;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Resources.Theme m28280a(Resources.Theme theme, Resources.Theme theme2, int i, String str) {
        Resources resources;
        C9586a m28270bD = m28270bD(str);
        if (m28270bD == null || !m28270bD.isLoaded() || (resources = m28270bD.getResources()) == null) {
            return theme;
        }
        if (theme2 == null) {
            Resources.Theme newTheme = resources.newTheme();
            newTheme.applyStyle(i, true);
            return newTheme;
        }
        return theme2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static ClassLoader m28277a(ClassLoader classLoader, String str) {
        C9588b m28309wU;
        C9586a m28270bD = m28270bD(str);
        return (m28270bD == null || !m28270bD.isLoaded() || (m28309wU = m28270bD.m28309wU()) == null) ? classLoader : m28309wU;
    }
}
