package com.bytedance.c.w.ux;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<Long> f26575a = new AtomicReference<>(0L);

    public static void a(long j4) {
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (i4 >= 5) {
                return;
            }
            AtomicReference<Long> atomicReference = f26575a;
            long longValue = atomicReference.get().longValue();
            if (atomicReference.compareAndSet(Long.valueOf(longValue), Long.valueOf(longValue | j4))) {
                return;
            }
            i4 = i5;
        }
    }
}
