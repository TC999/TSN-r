package OcOsO.RddINbhi.wn.EFApGV.EE.r;

import dalvik.annotation.optimization.FastNative;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public class DexParserBridge {
    @FastNative
    public static native void closeDex(long j4);

    @FastNative
    public static native Object openDex(ByteBuffer byteBuffer, long[] jArr);

    @FastNative
    public static native void visitClass(long j4, Object obj, Class cls, Class cls2, Method method, Method method2, Method method3, Method method4, Method method5);
}
