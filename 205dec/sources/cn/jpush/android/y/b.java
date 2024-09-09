package cn.jpush.android.y;

import android.util.Log;
import dalvik.system.DexClassLoader;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends DexClassLoader {

    /* renamed from: a  reason: collision with root package name */
    private ClassLoader f4553a;

    public b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, DexClassLoader.class.getClassLoader());
        this.f4553a = classLoader;
        Log.d("PushDexClassLoader", "init jpush cl...");
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) {
        try {
            return super.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return this.f4553a.loadClass(str);
        }
    }
}
