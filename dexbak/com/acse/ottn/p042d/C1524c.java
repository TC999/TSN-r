package com.acse.ottn.p042d;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.p042d.C1530i;
import com.acse.ottn.p042d.p044b.C1505h;
import com.acse.ottn.util.C1694ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1524c implements C1530i.InterfaceC1531a {

    /* renamed from: a */
    final /* synthetic */ AppCompatActivity f2813a;

    /* renamed from: b */
    final /* synthetic */ int f2814b;

    /* renamed from: c */
    final /* synthetic */ C1530i f2815c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1524c(C1530i c1530i, AppCompatActivity appCompatActivity, int i) {
        this.f2815c = c1530i;
        this.f2813a = appCompatActivity;
        this.f2814b = i;
    }

    @Override // com.acse.ottn.p042d.C1530i.InterfaceC1531a
    /* renamed from: a */
    public void mo56497a(boolean z) {
        if (z) {
            C1505h.m56620a((Activity) this.f2813a, this.f2814b);
        } else {
            C1694ra.m55915b("FloatWindowManager", "ROM:huawei, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
