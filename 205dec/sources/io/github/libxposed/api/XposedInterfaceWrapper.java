package io.github.libxposed.api;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.ParcelFileDescriptor;
import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.utils.DexParser;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class XposedInterfaceWrapper implements XposedInterface {
    private final XposedInterface mBase;

    public XposedInterfaceWrapper(XposedInterface xposedInterface) {
        this.mBase = xposedInterface;
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final boolean deoptimize(Method method) {
        return this.mBase.deoptimize(method);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public ApplicationInfo getApplicationInfo() {
        return this.mBase.getApplicationInfo();
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final String getFrameworkName() {
        return this.mBase.getFrameworkName();
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final int getFrameworkPrivilege() {
        return this.mBase.getFrameworkPrivilege();
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final String getFrameworkVersion() {
        return this.mBase.getFrameworkVersion();
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final long getFrameworkVersionCode() {
        return this.mBase.getFrameworkVersionCode();
    }

    @Override // io.github.libxposed.api.XposedInterface
    public SharedPreferences getRemotePreferences(String str) {
        return this.mBase.getRemotePreferences(str);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final XposedInterface.MethodUnhooker hook(Method method, Class cls) {
        return this.mBase.hook(method, cls);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final Object invokeOrigin(Method method, Object obj, Object... objArr) {
        return this.mBase.invokeOrigin(method, obj, objArr);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final Object invokeSpecial(Method method, Object obj, Object... objArr) {
        return this.mBase.invokeSpecial(method, obj, objArr);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public String[] listRemoteFiles() {
        return this.mBase.listRemoteFiles();
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final void log(String str) {
        this.mBase.log(str);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final Object newInstanceOrigin(Constructor constructor, Object... objArr) {
        return this.mBase.newInstanceOrigin(constructor, objArr);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final Object newInstanceSpecial(Constructor constructor, Class cls, Object... objArr) {
        return this.mBase.newInstanceSpecial(constructor, cls, objArr);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public ParcelFileDescriptor openRemoteFile(String str) {
        return this.mBase.openRemoteFile(str);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final DexParser parseDex(ByteBuffer byteBuffer, boolean z3) {
        return this.mBase.parseDex(byteBuffer, z3);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final boolean deoptimize(Constructor constructor) {
        return this.mBase.deoptimize(constructor);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final XposedInterface.MethodUnhooker hook(Method method, int i4, Class cls) {
        return this.mBase.hook(method, i4, cls);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final void log(String str, Throwable th) {
        this.mBase.log(str, th);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final XposedInterface.MethodUnhooker hook(Constructor constructor, Class cls) {
        return this.mBase.hook(constructor, cls);
    }

    @Override // io.github.libxposed.api.XposedInterface
    public final XposedInterface.MethodUnhooker hook(Constructor constructor, int i4, Class cls) {
        return this.mBase.hook(constructor, i4, cls);
    }
}
