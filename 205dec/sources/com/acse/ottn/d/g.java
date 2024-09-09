package com.acse.ottn.d;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.b1;
import com.acse.ottn.d.i;
import com.acse.ottn.util.ra;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class g implements i.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatActivity f5510a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f5511b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f5512c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(i iVar, AppCompatActivity appCompatActivity, int i4) {
        this.f5512c = iVar;
        this.f5510a = appCompatActivity;
        this.f5511b = i4;
    }

    @Override // com.acse.ottn.d.i.a
    public void a(boolean z3) {
        if (!z3) {
            ra.a(b1.f5166b, "user manually refuse OVERLAY_PERMISSION");
            return;
        }
        try {
            i.b(this.f5510a, this.f5511b);
        } catch (Exception e4) {
            ra.b(b1.f5166b, Log.getStackTraceString(e4));
        }
    }
}
