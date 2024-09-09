package com.acse.ottn.d;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.b1;
import com.acse.ottn.d.b.l;
import com.acse.ottn.d.i;
import com.acse.ottn.util.ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e implements i.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f5501a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f5502b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f5503c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(i iVar, AppCompatActivity appCompatActivity, int i4) {
        this.f5503c = iVar;
        this.f5501a = appCompatActivity;
        this.f5502b = i4;
    }

    @Override // com.acse.ottn.d.i.a
    public void a(boolean z3) {
        if (z3) {
            l.a((Activity) this.f5501a, this.f5502b);
        } else {
            ra.b(b1.f5166b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
        }
    }
}
