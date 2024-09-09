package io.netty.util.internal;

import sun.misc.Unsafe;

/* compiled from: R8$$SyntheticClass */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ boolean a(Unsafe unsafe, Object obj, long j4, Object obj2, Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j4, obj2, obj3)) {
            if (unsafe.getObject(obj, j4) != obj2) {
                return false;
            }
        }
        return true;
    }
}
