package com.acse.ottn.b;

import android.app.Activity;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.S;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class q implements S.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f5147a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnClickCallBack f5148b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        this.f5147a = activity;
        this.f5148b = onClickCallBack;
    }

    @Override // com.acse.ottn.util.S.a
    public void a(long j4) {
        TextView textView;
        textView = s.f5153c;
        textView.setText(((j4 / 1000) - 1) + "\u79d2");
    }

    @Override // com.acse.ottn.util.S.a
    public void onFinish() {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        if (this.f5147a.isFinishing()) {
            return;
        }
        alertDialog = s.f5151a;
        if (alertDialog.isShowing()) {
            Activity activity = this.f5147a;
            alertDialog2 = s.f5151a;
            s.a(activity, alertDialog2);
            this.f5148b.onDismiss();
        }
    }
}
