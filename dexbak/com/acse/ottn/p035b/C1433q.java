package com.acse.ottn.p035b;

import android.app.Activity;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1648S;

/* renamed from: com.acse.ottn.b.q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1433q implements C1648S.InterfaceC1649a {

    /* renamed from: a */
    final /* synthetic */ Activity f2587a;

    /* renamed from: b */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f2588b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1433q(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f2587a = activity;
        this.f2588b = onClickCallBack;
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    /* renamed from: a */
    public void mo55884a(long j) {
        TextView textView;
        textView = C1435s.f2593c;
        textView.setText(((j / 1000) - 1) + "秒");
    }

    @Override // com.acse.ottn.util.C1648S.InterfaceC1649a
    public void onFinish() {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        if (this.f2587a.isFinishing()) {
            return;
        }
        alertDialog = C1435s.f2591a;
        if (alertDialog.isShowing()) {
            Activity activity = this.f2587a;
            alertDialog2 = C1435s.f2591a;
            C1435s.m56812a(activity, alertDialog2);
            this.f2588b.onDismiss();
        }
    }
}
