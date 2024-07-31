package com.iab.omid.library.mmadbridge.p202b;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import p626o0.C15395a;

/* renamed from: com.iab.omid.library.mmadbridge.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7088c {

    /* renamed from: a */
    private final C15395a f24233a;

    /* renamed from: b */
    private final String f24234b;

    /* renamed from: c */
    private final FriendlyObstructionPurpose f24235c;

    /* renamed from: d */
    private final String f24236d;

    public C7088c(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f24233a = new C15395a(view);
        this.f24234b = view.getClass().getCanonicalName();
        this.f24235c = friendlyObstructionPurpose;
        this.f24236d = str;
    }

    /* renamed from: a */
    public C15395a m34742a() {
        return this.f24233a;
    }

    /* renamed from: b */
    public String m34741b() {
        return this.f24234b;
    }

    /* renamed from: c */
    public FriendlyObstructionPurpose m34740c() {
        return this.f24235c;
    }

    /* renamed from: d */
    public String m34739d() {
        return this.f24236d;
    }
}
