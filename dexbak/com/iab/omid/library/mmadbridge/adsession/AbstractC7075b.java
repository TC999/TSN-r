package com.iab.omid.library.mmadbridge.adsession;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.p204d.C7105e;
import com.iab.omid.library.mmadbridge.publisher.AbstractC7108a;

/* renamed from: com.iab.omid.library.mmadbridge.adsession.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC7075b {
    /* renamed from: b */
    public static AbstractC7075b m34835b(C7076c c7076c, C7077d c7077d) {
        C7105e.m34674a();
        C7105e.m34671d(c7076c, "AdSessionConfiguration is null");
        C7105e.m34671d(c7077d, "AdSessionContext is null");
        return new C7081h(c7076c, c7077d);
    }

    /* renamed from: a */
    public abstract void mo34806a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str);

    /* renamed from: c */
    public abstract void mo34805c(ErrorType errorType, String str);

    /* renamed from: d */
    public abstract void mo34804d();

    /* renamed from: e */
    public abstract String mo34803e();

    /* renamed from: f */
    public abstract AbstractC7108a mo34802f();

    /* renamed from: g */
    public abstract void mo34801g(View view);

    /* renamed from: h */
    public abstract void mo34800h();

    /* renamed from: i */
    public abstract void mo34799i(View view);

    /* renamed from: j */
    public abstract void mo34798j(InterfaceC7079f interfaceC7079f);

    /* renamed from: k */
    public abstract void mo34797k();
}
