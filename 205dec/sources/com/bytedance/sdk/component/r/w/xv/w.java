package com.bytedance.sdk.component.r.w.xv;

import com.bytedance.sdk.component.r.c.sr;
import com.bytedance.sdk.component.r.c.ux;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static void c(AtomicLong atomicLong, int i4, ux uxVar) {
        sr sr = uxVar.sr();
        if (sr == null || !sr.xv() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i4);
    }
}
