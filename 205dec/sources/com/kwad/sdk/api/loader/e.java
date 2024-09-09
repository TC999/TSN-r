package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class e {
    private static final List<String> amh;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a extends DexClassLoader {
        private final ClassLoader ami;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.ami = classLoader;
            classLoader.getClass();
        }

        private static boolean cb(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api");
        }

        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z3) {
            if (cb(str)) {
                return getParent().loadClass(str);
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            return findLoadedClass != null ? findLoadedClass : super.loadClass(str, z3);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        amh = arrayList;
        arrayList.add("com.kwad.sdk");
        arrayList.add("com.ksad");
        arrayList.add("com.kwai");
        arrayList.add("kwad.support");
        arrayList.add("android.support.rastermill");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static ClassLoader a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (t.b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new a(str, str2, str3, classLoader);
    }
}
