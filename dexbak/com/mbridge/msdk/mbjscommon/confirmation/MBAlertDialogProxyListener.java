package com.mbridge.msdk.mbjscommon.confirmation;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.widget.dialog.MBAlertDialogListener;

/* renamed from: com.mbridge.msdk.mbjscommon.confirmation.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MBAlertDialogProxyListener implements MBAlertDialogListener {

    /* renamed from: a */
    private static String f31447a = "MBAlertDialogProxyListener";

    /* renamed from: b */
    private MBAlertDialogListener f31448b;

    /* renamed from: c */
    private Context f31449c;

    /* renamed from: d */
    private CampaignEx f31450d;

    /* renamed from: e */
    private String f31451e;

    /* renamed from: f */
    private String f31452f;

    /* renamed from: g */
    private int f31453g = 2;

    public MBAlertDialogProxyListener(MBAlertDialogListener mBAlertDialogListener, Context context, CampaignEx campaignEx, String str, String str2) {
        this.f31448b = mBAlertDialogListener;
        this.f31449c = context;
        this.f31450d = campaignEx;
        this.f31451e = str;
        this.f31452f = str2;
    }

    /* renamed from: a */
    public final void m21491a(int i) {
        this.f31453g = i;
    }

    @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
    /* renamed from: b */
    public final void mo20508b() {
        SecondaryConfirmationManager.m21474a().m21453b();
        SameLogTool.m21738a(f31447a, "onDialogConfirm");
        C11385e.m22080a(this.f31449c, this.f31450d, this.f31451e, this.f31452f, this.f31453g, 0, 2);
        MBAlertDialogListener mBAlertDialogListener = this.f31448b;
        if (mBAlertDialogListener != null) {
            mBAlertDialogListener.mo20508b();
        }
    }

    @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
    /* renamed from: c */
    public final void mo20507c() {
        SameLogTool.m21738a(f31447a, "onDialogCancel");
        C11385e.m22080a(this.f31449c, this.f31450d, this.f31451e, this.f31452f, this.f31453g, 2, 2);
        MBAlertDialogListener mBAlertDialogListener = this.f31448b;
        if (mBAlertDialogListener != null) {
            mBAlertDialogListener.mo20507c();
        }
    }

    @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
    /* renamed from: a */
    public final void mo20509a() {
        SecondaryConfirmationManager.m21474a().m21453b();
        SameLogTool.m21738a(f31447a, "onDialogCancel");
        C11385e.m22080a(this.f31449c, this.f31450d, this.f31451e, this.f31452f, this.f31453g, 1, 2);
        MBAlertDialogListener mBAlertDialogListener = this.f31448b;
        if (mBAlertDialogListener != null) {
            mBAlertDialogListener.mo20509a();
        }
    }
}
