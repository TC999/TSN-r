package com.kwad.library.p355b.p356a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.library.b.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9588b extends BaseDexClassLoader {
    private final List<String> aiE;
    private final List<String> aiF;
    private final ClassLoader aiG;

    public C9588b(ClassLoader classLoader, String str, @Nullable File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.aiG = classLoader;
        this.aiE = list;
        this.aiF = list2;
        while (classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        Log.i("PluginClassLoader", "mParent is " + classLoader.getClass().getName());
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        return (TextUtils.isEmpty(findLibrary) && (this.aiG instanceof BaseDexClassLoader)) ? ((BaseDexClassLoader) this.aiG).findLibrary(str) : findLibrary;
    }

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z) {
        List<String> list = this.aiE;
        if (list != null && list.contains(str)) {
            Log.i("PluginClassLoader", "loadClass " + str + " from host by interface");
            return super.loadClass(str, z);
        }
        List<String> list2 = this.aiF;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + ".")) {
                    return super.loadClass(str, z);
                }
            }
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            try {
                return findClass(str);
            } catch (ClassNotFoundException e) {
                throw e;
            }
        } catch (ClassNotFoundException unused) {
            return getParent().loadClass(str);
        }
    }
}
