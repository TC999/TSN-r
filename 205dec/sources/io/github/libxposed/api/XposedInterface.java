package io.github.libxposed.api;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.ParcelFileDescriptor;
import io.github.libxposed.api.utils.DexParser;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public interface XposedInterface {
    public static final int API = 100;
    public static final int FRAMEWORK_PRIVILEGE_APP = 2;
    public static final int FRAMEWORK_PRIVILEGE_CONTAINER = 1;
    public static final int FRAMEWORK_PRIVILEGE_EMBEDDED = 3;
    public static final int FRAMEWORK_PRIVILEGE_ROOT = 0;
    public static final int PRIORITY_DEFAULT = 50;
    public static final int PRIORITY_HIGHEST = 10000;
    public static final int PRIORITY_LOWEST = -10000;

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface AfterHookCallback {
        Object[] getArgs();

        Member getMember();

        Object getResult();

        Object getThisObject();

        Throwable getThrowable();

        boolean isSkipped();

        void setResult(Object obj);

        void setThrowable(Throwable th);
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface BeforeHookCallback {
        Object[] getArgs();

        Member getMember();

        Object getThisObject();

        void returnAndSkip(Object obj);

        void throwAndSkip(Throwable th);
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface Hooker {
    }

    /* loaded from: E:\TSN-r\205dec\155424.dex */
    public interface MethodUnhooker {
        Object getOrigin();

        void unhook();
    }

    boolean deoptimize(Constructor constructor);

    boolean deoptimize(Method method);

    ApplicationInfo getApplicationInfo();

    String getFrameworkName();

    int getFrameworkPrivilege();

    String getFrameworkVersion();

    long getFrameworkVersionCode();

    SharedPreferences getRemotePreferences(String str);

    MethodUnhooker hook(Constructor constructor, int i4, Class cls);

    MethodUnhooker hook(Constructor constructor, Class cls);

    MethodUnhooker hook(Method method, int i4, Class cls);

    MethodUnhooker hook(Method method, Class cls);

    Object invokeOrigin(Method method, Object obj, Object... objArr);

    Object invokeSpecial(Method method, Object obj, Object... objArr);

    String[] listRemoteFiles();

    void log(String str);

    void log(String str, Throwable th);

    Object newInstanceOrigin(Constructor constructor, Object... objArr);

    Object newInstanceSpecial(Constructor constructor, Class cls, Object... objArr);

    ParcelFileDescriptor openRemoteFile(String str);

    DexParser parseDex(ByteBuffer byteBuffer, boolean z3);
}
