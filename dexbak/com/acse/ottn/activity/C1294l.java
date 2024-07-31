package com.acse.ottn.activity;

import androidx.appcompat.widget.AppCompatCheckBox;
import com.acse.ottn.p035b.C1403C;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.l */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1294l implements C1403C.InterfaceC1404a {

    /* renamed from: a */
    final /* synthetic */ AccessibiltyTsnPermissionGreenActivity f2194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1294l(AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity) {
        this.f2194a = accessibiltyTsnPermissionGreenActivity;
    }

    @Override // com.acse.ottn.p035b.C1403C.InterfaceC1404a
    public void onDismiss() {
        C1703va.m55903a().m55901a("refuse_service");
    }

    @Override // com.acse.ottn.p035b.C1403C.InterfaceC1404a
    public void onOpen() {
        AppCompatCheckBox appCompatCheckBox;
        C1661ba.m56097a().m56092a("is_agree_service", true);
        C1703va.m55903a().m55901a("allow_service");
        appCompatCheckBox = this.f2194a.f2068o;
        appCompatCheckBox.setChecked(true);
        this.f2194a.m57310l();
    }
}
