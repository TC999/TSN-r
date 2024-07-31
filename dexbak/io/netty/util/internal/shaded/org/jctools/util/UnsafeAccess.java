package io.netty.util.internal.shaded.org.jctools.util;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class UnsafeAccess {
    public static final boolean SUPPORTS_GET_AND_SET;
    public static final Unsafe UNSAFE;

    static {
        boolean z = false;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            UNSAFE = (Unsafe) declaredField.get(null);
            try {
                Unsafe.class.getMethod("getAndSetObject", Object.class, Long.TYPE, Object.class);
                z = true;
            } catch (Exception unused) {
            }
            SUPPORTS_GET_AND_SET = z;
        } catch (Exception e) {
            SUPPORTS_GET_AND_SET = false;
            throw new RuntimeException(e);
        }
    }
}
