package com.acse.ottn.widget;

import android.app.Activity;
import android.view.View;
import com.acse.ottn.activity.AcseHelpManager;

/* renamed from: com.acse.ottn.widget.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1717c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f3419a;

    /* renamed from: b */
    final /* synthetic */ CustomWarnLayout f3420b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1717c(CustomWarnLayout customWarnLayout, Activity activity) {
        this.f3420b = customWarnLayout;
        this.f3419a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f3419a, 10010);
    }
}
