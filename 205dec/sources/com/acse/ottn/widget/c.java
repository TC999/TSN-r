package com.acse.ottn.widget;

import android.app.Activity;
import android.view.View;
import com.acse.ottn.activity.AcseHelpManager;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f6966a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ CustomWarnLayout f6967b;

    c(CustomWarnLayout customWarnLayout, Activity activity) {
        this.f6967b = customWarnLayout;
        this.f6966a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f6966a, 10010);
    }
}
