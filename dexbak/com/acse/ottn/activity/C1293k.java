package com.acse.ottn.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.acse.ottn.util.C1633I;

/* renamed from: com.acse.ottn.activity.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1293k implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1293k(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2193a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AppCompatCheckBox appCompatCheckBox;
        if (z) {
            appCompatCheckBox = this.f2193a.f2068o;
            appCompatCheckBox.setSupportButtonTintList(ColorStateList.valueOf(Color.parseColor(C1633I.m56254a().m56238e(this.f2193a))));
        }
    }
}
