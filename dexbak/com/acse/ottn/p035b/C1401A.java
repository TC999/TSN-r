package com.acse.ottn.p035b;

import android.app.Activity;
import android.widget.TextView;
import com.acse.ottn.p035b.C1403C;
import com.acse.ottn.util.C1633I;
import com.acse.ottn.util.C1648S;

/* renamed from: com.acse.ottn.b.A */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1401A implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ TextView f2510a;

    /* renamed from: b */
    final /* synthetic */ C1403C.InterfaceC1404a f2511b;

    /* renamed from: c */
    final /* synthetic */ Activity f2512c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1401A(TextView textView, C1403C.InterfaceC1404a interfaceC1404a, Activity activity) {
        this.f2510a = textView;
        this.f2511b = interfaceC1404a;
        this.f2512c = activity;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        TextView textView = this.f2510a;
        textView.setText("请下拉阅读(" + (j / 1000) + "s)");
        this.f2510a.setOnClickListener(null);
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        this.f2510a.setText("我已知晓并同意");
        this.f2510a.setOnClickListener(new View$OnClickListenerC1442z(this));
        C1633I.m56254a().m56241c(this.f2512c, this.f2510a);
    }
}
