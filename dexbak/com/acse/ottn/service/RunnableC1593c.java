package com.acse.ottn.service;

import android.content.Intent;
import com.acse.ottn.activity.ExcessActivity;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* renamed from: com.acse.ottn.service.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1593c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f3049a;

    /* renamed from: b */
    final /* synthetic */ String f3050b;

    /* renamed from: c */
    final /* synthetic */ String f3051c;

    /* renamed from: d */
    final /* synthetic */ int f3052d;

    /* renamed from: e */
    final /* synthetic */ String f3053e;

    /* renamed from: f */
    final /* synthetic */ String f3054f;

    /* renamed from: g */
    final /* synthetic */ ExcessService f3055g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1593c(ExcessService excessService, String str, String str2, String str3, int i, String str4, String str5) {
        this.f3055g = excessService;
        this.f3049a = str;
        this.f3050b = str2;
        this.f3051c = str3;
        this.f3052d = i;
        this.f3053e = str4;
        this.f3054f = str5;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent = new Intent(this.f3055g, ExcessActivity.class);
        intent.putExtra("password", this.f3049a);
        intent.putExtra("deeplink", this.f3050b);
        intent.putExtra("link", this.f3051c);
        intent.putExtra(RtspHeaders.Values.TIME, this.f3052d);
        intent.putExtra("name", this.f3053e);
        intent.putExtra("origin_url", this.f3054f);
        intent.addFlags(268435456);
        this.f3055g.startActivity(intent);
        this.f3055g.m56425a();
    }
}
