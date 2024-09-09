package OcOsO.RddINbhi.wn.EFApGV.EE.r;

import dalvik.annotation.optimization.FastNative;
import java.lang.reflect.Executable;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class HookBridge {
    public static native Object allocateObject(Class cls);

    public static native Object[][] callbackSnapshot(Class cls, Executable executable);

    public static native boolean deoptimizeMethod(Executable executable);

    public static native boolean hookMethod(boolean z3, Executable executable, Class cls, int i4, Object obj);

    @FastNative
    public static native boolean instanceOf(Object obj, Class cls);

    public static native Object invokeOriginalMethod(Executable executable, Object obj, Object... objArr);

    public static native Object invokeSpecialMethod(Executable executable, char[] cArr, Class cls, Object obj, Object... objArr);

    @FastNative
    public static native boolean setTrusted(Object obj);

    public static native boolean unhookMethod(boolean z3, Executable executable, Object obj);
}
