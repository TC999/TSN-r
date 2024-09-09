package com.mbridge.msdk.mbjscommon.confirmation;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: MBAlertDialogProxyListener.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements com.mbridge.msdk.widget.dialog.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f40219a = "MBAlertDialogProxyListener";

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.a f40220b;

    /* renamed from: c  reason: collision with root package name */
    private Context f40221c;

    /* renamed from: d  reason: collision with root package name */
    private CampaignEx f40222d;

    /* renamed from: e  reason: collision with root package name */
    private String f40223e;

    /* renamed from: f  reason: collision with root package name */
    private String f40224f;

    /* renamed from: g  reason: collision with root package name */
    private int f40225g = 2;

    public c(com.mbridge.msdk.widget.dialog.a aVar, Context context, CampaignEx campaignEx, String str, String str2) {
        this.f40220b = aVar;
        this.f40221c = context;
        this.f40222d = campaignEx;
        this.f40223e = str;
        this.f40224f = str2;
    }

    public final void a(int i4) {
        this.f40225g = i4;
    }

    @Override // com.mbridge.msdk.widget.dialog.a
    public final void b() {
        e.a().b();
        x.a(f40219a, "onDialogConfirm");
        com.mbridge.msdk.foundation.same.report.e.a(this.f40221c, this.f40222d, this.f40223e, this.f40224f, this.f40225g, 0, 2);
        com.mbridge.msdk.widget.dialog.a aVar = this.f40220b;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.mbridge.msdk.widget.dialog.a
    public final void c() {
        x.a(f40219a, "onDialogCancel");
        com.mbridge.msdk.foundation.same.report.e.a(this.f40221c, this.f40222d, this.f40223e, this.f40224f, this.f40225g, 2, 2);
        com.mbridge.msdk.widget.dialog.a aVar = this.f40220b;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.mbridge.msdk.widget.dialog.a
    public final void a() {
        e.a().b();
        x.a(f40219a, "onDialogCancel");
        com.mbridge.msdk.foundation.same.report.e.a(this.f40221c, this.f40222d, this.f40223e, this.f40224f, this.f40225g, 1, 2);
        com.mbridge.msdk.widget.dialog.a aVar = this.f40220b;
        if (aVar != null) {
            aVar.a();
        }
    }
}
