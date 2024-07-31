package com.bytedance.pangle;

import android.os.Build;
import androidx.annotation.Keep;
import com.snail.antifake.deviceid.ShellAdbUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashSet;
import java.util.List;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
        sb.append(ShellAdbUtils.f33810d);
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
            } catch (ClassNotFoundException e) {
                e = e;
            }
        } else {
            e = null;
        }
        StringBuilder sb = new StringBuilder("loadClass from :\n");
        if (cls == null && (list = this.otherPluginClassLoader) != null) {
            for (ClassLoader classLoader : list) {
                try {
                    cls = classLoader.loadClass(str);
                } catch (ClassNotFoundException e2) {
                    e = handleException(sb, e, e2);
                }
            }
        }
        if (cls == null) {
            try {
                cls = this.hostClassLoader.loadClass(str);
            } catch (ClassNotFoundException e3) {
                e = handleException(sb, e, e3);
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
