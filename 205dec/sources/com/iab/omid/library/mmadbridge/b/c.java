package com.iab.omid.library.mmadbridge.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final o0.a f37715a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37716b;

    /* renamed from: c  reason: collision with root package name */
    private final FriendlyObstructionPurpose f37717c;

    /* renamed from: d  reason: collision with root package name */
    private final String f37718d;

    public c(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f37715a = new o0.a(view);
        this.f37716b = view.getClass().getCanonicalName();
        this.f37717c = friendlyObstructionPurpose;
        this.f37718d = str;
    }

    public o0.a a() {
        return this.f37715a;
    }

    public String b() {
        return this.f37716b;
    }

    public FriendlyObstructionPurpose c() {
        return this.f37717c;
    }

    public String d() {
        return this.f37718d;
    }
}
