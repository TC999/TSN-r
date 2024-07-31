package com.kwad.library.p355b.p356a;

import android.app.Activity;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.library.b.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9587a extends PathClassLoader {
    private static final List<ClassLoader> aiD = new CopyOnWriteArrayList();
    private final BaseDexClassLoader aiC;

    public C9587a(BaseDexClassLoader baseDexClassLoader) {
        super("", baseDexClassLoader);
        this.aiC = baseDexClassLoader;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected final Class<?> findClass(String str) {
        Class<?> loadClass;
        Class<?> loadClass2;
        Class<?> cls = null;
        try {
            loadClass2 = this.aiC.loadClass(str);
        } catch (Throwable th) {
            th = th;
        }
        if (Activity.class.isAssignableFrom(loadClass2)) {
            return loadClass2;
        }
        th = null;
        cls = loadClass2;
        if (cls == null) {
            for (ClassLoader classLoader : aiD) {
                try {
                    loadClass = classLoader.loadClass(str);
                } catch (Throwable unused) {
                }
                if (loadClass != null) {
                    return loadClass;
                }
            }
            if (th instanceof ClassNotFoundException) {
                throw th;
            }
            throw new ClassNotFoundException(str, th);
        }
        return cls;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        return this.aiC.findLibrary(str);
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        return this.aiC.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public final InputStream getResourceAsStream(String str) {
        return this.aiC.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public final Enumeration<URL> getResources(String str) {
        return this.aiC.getResources(str);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str) {
        return findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader
    public final String toString() {
        return this.aiC.toString();
    }
}
