package com.acse.ottn.d;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.b1;
import com.acse.ottn.d.b.A;
import com.acse.ottn.d.i;
import com.acse.ottn.util.ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b implements i.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f5412a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f5413b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f5414c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(i iVar, AppCompatActivity appCompatActivity, int i4) {
        this.f5414c = iVar;
        this.f5412a = appCompatActivity;
        this.f5413b = i4;
    }

    @Override // com.acse.ottn.d.i.a
    public void a(boolean z3) {
        if (z3) {
            A.a((Activity) this.f5412a, this.f5413b);
        } else {
            ra.b(b1.f5166b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
