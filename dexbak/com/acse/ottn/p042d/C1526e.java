package com.acse.ottn.p042d;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.p042d.C1530i;
import com.acse.ottn.p042d.p044b.C1509l;
import com.acse.ottn.util.C1694ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1526e implements C1530i.InterfaceC1531a {

    /* renamed from: a */
    final /* synthetic */ AppCompatActivity f2819a;

    /* renamed from: b */
    final /* synthetic */ int f2820b;

    /* renamed from: c */
    final /* synthetic */ C1530i f2821c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1526e(C1530i c1530i, AppCompatActivity appCompatActivity, int i) {
        this.f2821c = c1530i;
        this.f2819a = appCompatActivity;
        this.f2820b = i;
    }

    @Override // com.acse.ottn.p042d.C1530i.InterfaceC1531a
    /* renamed from: a */
    public void mo56497a(boolean z) {
        if (z) {
            C1509l.m56589a((Activity) this.f2819a, this.f2820b);
        } else {
            C1694ra.m55915b("FloatWindowManager", "ROM:miui, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
