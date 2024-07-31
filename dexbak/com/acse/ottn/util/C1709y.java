package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.C1648S;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.y */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1709y implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ AccessiblityModel f3387a;

    /* renamed from: b */
    final /* synthetic */ AccessibilityService f3388b;

    /* renamed from: c */
    final /* synthetic */ C1617A f3389c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1709y(C1617A c1617a, AccessiblityModel accessiblityModel, AccessibilityService accessibilityService) {
        this.f3389c = c1617a;
        this.f3387a = accessiblityModel;
        this.f3388b = accessibilityService;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        String str;
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1707x(this), 0L);
        } catch (Exception e) {
            str = C1617A.f3113e;
            C1694ra.m55917a(str, "couponCountDown e =" + e.getMessage());
        }
    }
}
