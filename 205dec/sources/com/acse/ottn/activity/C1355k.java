package com.acse.ottn.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.CompoundButton;

/* renamed from: com.acse.ottn.activity.k  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1355k implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f4744a;

    C1355k(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f4744a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
        if (z3) {
            this.f4744a.f4601p.setSupportButtonTintList(ColorStateList.valueOf(Color.parseColor(com.acse.ottn.util.I.a().e(this.f4744a))));
        }
    }
}
