package com.bytedance.pangle;

import android.os.Build;
import com.bytedance.pangle.flipped.C6122a;
import com.bytedance.pangle.flipped.C6123b;
import com.bytedance.pangle.flipped.FlippedV2Impl;
import com.bytedance.pangle.flipped.InterfaceC6124c;

/* renamed from: com.bytedance.pangle.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6065b {
    /* renamed from: a */
    public static void m37267a() {
        InterfaceC6124c c6122a;
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i >= 30 || (i == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            c6122a = new FlippedV2Impl();
        } else {
            if (i >= 28 || (i == 27 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                z = true;
            }
            if (z) {
                c6122a = new C6123b();
            } else {
                c6122a = new C6122a();
            }
        }
        c6122a.invokeHiddenApiRestrictions();
    }
}
