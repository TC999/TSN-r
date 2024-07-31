package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.api.loader.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9719e {
    private static final List<String> amh;

    /* renamed from: com.kwad.sdk.api.loader.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9720a extends DexClassLoader {
        private final ClassLoader ami;

        public C9720a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.ami = classLoader;
            classLoader.getClass();
        }

        /* renamed from: cb */
        private static boolean m27944cb(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api");
        }

        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) {
            if (m27944cb(str)) {
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
            return findLoadedClass != null ? findLoadedClass : super.loadClass(str, z);
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
    /* renamed from: a */
    public static ClassLoader m27945a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (C9757t.m27842b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new C9720a(str, str2, str3, classLoader);
    }
}
