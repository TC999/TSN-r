package com.acse.ottn.p042d;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.p042d.C1530i;
import com.acse.ottn.p042d.p044b.C1523z;
import com.acse.ottn.util.C1694ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1527f implements C1530i.InterfaceC1531a {

    /* renamed from: a */
    final /* synthetic */ AppCompatActivity f2822a;

    /* renamed from: b */
    final /* synthetic */ int f2823b;

    /* renamed from: c */
    final /* synthetic */ C1530i f2824c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1527f(C1530i c1530i, AppCompatActivity appCompatActivity, int i) {
        this.f2824c = c1530i;
        this.f2822a = appCompatActivity;
        this.f2823b = i;
    }

    @Override // com.acse.ottn.p042d.C1530i.InterfaceC1531a
    /* renamed from: a */
    public void mo56497a(boolean z) {
        if (z) {
            C1523z.m56535a((Activity) this.f2822a, this.f2823b);
        } else {
            C1694ra.m55915b("FloatWindowManager", "ROM:miui, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
