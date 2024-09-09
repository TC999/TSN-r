package com.acse.ottn.d;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.b1;
import com.acse.ottn.d.i;
import com.acse.ottn.util.ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c implements i.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f5491a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f5492b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f5493c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(i iVar, AppCompatActivity appCompatActivity, int i4) {
        this.f5493c = iVar;
        this.f5491a = appCompatActivity;
        this.f5492b = i4;
    }

    @Override // com.acse.ottn.d.i.a
    public void a(boolean z3) {
        if (z3) {
            com.acse.ottn.d.b.h.a((Activity) this.f5491a, this.f5492b);
        } else {
            ra.b(b1.f5166b, "ROM:huawei, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
