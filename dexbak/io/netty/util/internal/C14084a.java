package io.netty.util.internal;

import sun.misc.Unsafe;

/* compiled from: R8$$SyntheticClass */
/* renamed from: io.netty.util.internal.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C14084a {
    /* renamed from: a */
    public static /* synthetic */ boolean m12679a(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
