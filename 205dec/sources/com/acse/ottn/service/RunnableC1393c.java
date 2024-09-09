package com.acse.ottn.service;

import android.content.Intent;
import com.acse.ottn.activity.ExcessActivity;

/* renamed from: com.acse.ottn.service.c  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class RunnableC1393c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6540a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6541b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6542c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ int f6543d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f6544e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f6545f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ ExcessService f6546g;

    RunnableC1393c(ExcessService excessService, String str, String str2, String str3, int i4, String str4, String str5) {
        this.f6546g = excessService;
        this.f6540a = str;
        this.f6541b = str2;
        this.f6542c = str3;
        this.f6543d = i4;
        this.f6544e = str4;
        this.f6545f = str5;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent = new Intent(this.f6546g, ExcessActivity.class);
        intent.putExtra("password", this.f6540a);
        intent.putExtra("deeplink", this.f6541b);
        intent.putExtra("link", this.f6542c);
        intent.putExtra("time", this.f6543d);
        intent.putExtra("name", this.f6544e);
        intent.putExtra("origin_url", this.f6545f);
        intent.addFlags(268435456);
        this.f6546g.startActivity(intent);
        this.f6546g.a();
    }
}
