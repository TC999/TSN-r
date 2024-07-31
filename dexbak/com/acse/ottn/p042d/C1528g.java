package com.acse.ottn.p042d;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.p042d.C1530i;
import com.acse.ottn.util.C1694ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.d.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1528g implements C1530i.InterfaceC1531a {

    /* renamed from: a */
    final /* synthetic */ AppCompatActivity f2825a;

    /* renamed from: b */
    final /* synthetic */ int f2826b;

    /* renamed from: c */
    final /* synthetic */ C1530i f2827c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1528g(C1530i c1530i, AppCompatActivity appCompatActivity, int i) {
        this.f2827c = c1530i;
        this.f2825a = appCompatActivity;
        this.f2826b = i;
    }

    @Override // com.acse.ottn.p042d.C1530i.InterfaceC1531a
    /* renamed from: a */
    public void mo56497a(boolean z) {
        if (!z) {
            C1694ra.m55917a("FloatWindowManager", "user manually refuse OVERLAY_PERMISSION");
            return;
        }
        try {
            C1530i.m56510b(this.f2825a, this.f2826b);
        } catch (Exception e) {
            C1694ra.m55915b("FloatWindowManager", Log.getStackTraceString(e));
        }
    }
}
