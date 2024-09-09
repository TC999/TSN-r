package com.acse.ottn.d;

import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.b1;
import com.acse.ottn.d.i;
import com.acse.ottn.util.ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d implements i.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f5495a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f5496b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f5497c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(i iVar, AppCompatActivity appCompatActivity, int i4) {
        this.f5497c = iVar;
        this.f5495a = appCompatActivity;
        this.f5496b = i4;
    }

    @Override // com.acse.ottn.d.i.a
    public void a(boolean z3) {
        if (z3) {
            com.acse.ottn.d.b.i.a(this.f5495a, this.f5496b);
        } else {
            ra.b(b1.f5166b, "ROM:meizu, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
