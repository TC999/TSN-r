package com.acse.ottn.d;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.b1;
import com.acse.ottn.d.b.z;
import com.acse.ottn.d.i;
import com.acse.ottn.util.ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f implements i.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f5506a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f5507b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f5508c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(i iVar, AppCompatActivity appCompatActivity, int i4) {
        this.f5508c = iVar;
        this.f5506a = appCompatActivity;
        this.f5507b = i4;
    }

    @Override // com.acse.ottn.d.i.a
    public void a(boolean z3) {
        if (z3) {
            z.a((Activity) this.f5506a, this.f5507b);
        } else {
            ra.b(b1.f5166b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
