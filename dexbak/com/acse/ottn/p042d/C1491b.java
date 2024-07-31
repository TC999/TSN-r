package com.acse.ottn.p042d;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.p042d.C1530i;
import com.acse.ottn.p042d.p044b.C1492A;
import com.acse.ottn.util.C1694ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1491b implements C1530i.InterfaceC1531a {

    /* renamed from: a */
    final /* synthetic */ AppCompatActivity f2737a;

    /* renamed from: b */
    final /* synthetic */ int f2738b;

    /* renamed from: c */
    final /* synthetic */ C1530i f2739c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1491b(C1530i c1530i, AppCompatActivity appCompatActivity, int i) {
        this.f2739c = c1530i;
        this.f2737a = appCompatActivity;
        this.f2738b = i;
    }

    @Override // com.acse.ottn.p042d.C1530i.InterfaceC1531a
    /* renamed from: a */
    public void mo56497a(boolean z) {
        if (z) {
            C1492A.m56655a((Activity) this.f2737a, this.f2738b);
        } else {
            C1694ra.m55915b("FloatWindowManager", "ROM:360, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
