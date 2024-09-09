package com.bytedance.pangle;

import android.os.Build;
import com.bytedance.pangle.flipped.FlippedV2Impl;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {
    public static void a() {
        com.bytedance.pangle.flipped.c aVar;
        int i4 = Build.VERSION.SDK_INT;
        boolean z3 = false;
        if (i4 >= 30 || (i4 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            aVar = new FlippedV2Impl();
        } else {
            if (i4 >= 28 || (i4 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                z3 = true;
            }
            if (z3) {
                aVar = new com.bytedance.pangle.flipped.b();
            } else {
                aVar = new com.bytedance.pangle.flipped.a();
            }
        }
        aVar.invokeHiddenApiRestrictions();
    }
}
