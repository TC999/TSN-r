package com.kwad.sdk.p369c;

import android.content.Context;
import com.kuaishou.weapon.p205p0.WeaponHI;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9778a {
    public static void init(Context context) {
        if (C9425a.f29471It.booleanValue()) {
            try {
                WeaponHI.init(context, new C9779b());
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
