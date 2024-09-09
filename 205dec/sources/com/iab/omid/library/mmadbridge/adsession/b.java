package com.iab.omid.library.mmadbridge.adsession;

import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b {
    public static b b(c cVar, d dVar) {
        com.iab.omid.library.mmadbridge.d.e.a();
        com.iab.omid.library.mmadbridge.d.e.d(cVar, "AdSessionConfiguration is null");
        com.iab.omid.library.mmadbridge.d.e.d(dVar, "AdSessionContext is null");
        return new h(cVar, dVar);
    }

    public abstract void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str);

    public abstract void c(ErrorType errorType, String str);

    public abstract void d();

    public abstract String e();

    public abstract com.iab.omid.library.mmadbridge.publisher.a f();

    public abstract void g(View view);

    public abstract void h();

    public abstract void i(View view);

    public abstract void j(f fVar);

    public abstract void k();
}
