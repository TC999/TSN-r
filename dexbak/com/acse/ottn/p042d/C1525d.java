package com.acse.ottn.p042d;

import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.p042d.C1530i;
import com.acse.ottn.p042d.p044b.C1506i;
import com.acse.ottn.util.C1694ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1525d implements C1530i.InterfaceC1531a {

    /* renamed from: a */
    final /* synthetic */ AppCompatActivity f2816a;

    /* renamed from: b */
    final /* synthetic */ int f2817b;

    /* renamed from: c */
    final /* synthetic */ C1530i f2818c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1525d(C1530i c1530i, AppCompatActivity appCompatActivity, int i) {
        this.f2818c = c1530i;
        this.f2816a = appCompatActivity;
        this.f2817b = i;
    }

    @Override // com.acse.ottn.p042d.C1530i.InterfaceC1531a
    /* renamed from: a */
    public void mo56497a(boolean z) {
        if (z) {
            C1506i.m56594a(this.f2816a, this.f2817b);
        } else {
            C1694ra.m55915b("FloatWindowManager", "ROM:meizu, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
