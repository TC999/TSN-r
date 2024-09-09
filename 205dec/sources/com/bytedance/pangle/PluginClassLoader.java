package com.bytedance.pangle;

import android.os.Build;
import androidx.annotation.Keep;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PluginClassLoader extends BaseDexClassLoader {
    private static final String TAG = "PluginClassLoader";
    private HashSet<String> allPluginClasses;
    private final ClassLoader hostClassLoader;
    private final List<ClassLoader> otherPluginClassLoader;

    public PluginClassLoader(String str, File file, String str2, List<ClassLoader> list) {
        super(str, file, str2, BaseDexClassLoader.getSystemClassLoader().getParent());
        this.hostClassLoader = PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = list;
    }

    private ClassNotFoundException handleException(StringBuilder sb, ClassNotFoundException classNotFoundException, ClassNotFoundException classNotFoundException2) {
        if (classNotFoundException == null) {
            return classNotFoundException2;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return classNotFoundException;
        }
        sb.append(classNotFoundException2.getCause());
        sb.append("\n");
        return new ClassNotFoundException(sb.toString(), classNotFoundException2);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) {
        List<ClassLoader> list;
        HashSet<String> hashSet = this.allPluginClasses;
        Class<?> cls = null;
        if (hashSet == null || hashSet.contains(str)) {
            try {
                cls = super.findClass(str);
                e = null;
            } catch (ClassNotFoundException e4) {
                e = e4;
            }
        } else {
            e = null;
        }
        StringBuilder sb = new StringBuilder("loadClass from :\n");
        if (cls == null && (list = this.otherPluginClassLoader) != null) {
            for (ClassLoader classLoader : list) {
                try {
                    cls = classLoader.loadClass(str);
                } catch (ClassNotFoundException e5) {
                    e = handleException(sb, e, e5);
                }
            }
        }
        if (cls == null) {
            try {
                cls = this.hostClassLoader.loadClass(str);
            } catch (ClassNotFoundException e6) {
                e = handleException(sb, e, e6);
            }
        }
        if (cls == null) {
            if (e == null) {
                throw new ClassNotFoundException(str + " class not found in PluginClassLoader");
            }
            throw e;
        }
        return cls;
    }

    public void setAllPluginClasses(HashSet<String> hashSet) {
        this.allPluginClasses = hashSet;
    }
}
