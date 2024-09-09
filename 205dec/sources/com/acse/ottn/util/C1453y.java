package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.S;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.y  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1453y implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6897a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AccessibilityService f6898b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ A f6899c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1453y(A a4, AccessiblityModel accessiblityModel, AccessibilityService accessibilityService) {
        this.f6899c = a4;
        this.f6897a = accessiblityModel;
        this.f6898b = accessibilityService;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        String str;
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1452x(this), 0L);
        } catch (Exception e4) {
            str = A.f6686e;
            ra.a(str, "couponCountDown e =" + e4.getMessage());
        }
    }
}
