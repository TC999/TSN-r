package com.acse.ottn.b;

import android.app.Activity;
import android.widget.TextView;
import com.acse.ottn.b.C;
import com.acse.ottn.util.S;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class A implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextView f5061a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C.a f5062b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Activity f5063c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(TextView textView, C.a aVar, Activity activity) {
        this.f5061a = textView;
        this.f5062b = aVar;
        this.f5063c = activity;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        TextView textView = this.f5061a;
        textView.setText("\u8bf7\u4e0b\u62c9\u9605\u8bfb(" + (j4 / 1000) + "s)");
        this.f5061a.setOnClickListener(null);
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        this.f5061a.setText("\u6211\u5df2\u77e5\u6653\u5e76\u540c\u610f");
        this.f5061a.setOnClickListener(new z(this));
        com.acse.ottn.util.I.a().c(this.f5063c, this.f5061a);
    }
}
