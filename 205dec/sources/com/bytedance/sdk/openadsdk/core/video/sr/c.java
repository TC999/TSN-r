package com.bytedance.sdk.openadsdk.core.video.sr;

import com.bytedance.sdk.openadsdk.ys.w.w.ys;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    static final Map<Integer, WeakReference<ys>> f35237c = new HashMap();

    public static void c(Integer num, ys ysVar) {
        f35237c.put(num, new WeakReference<>(ysVar));
    }

    public static ys c(Integer num) {
        WeakReference<ys> weakReference = f35237c.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
