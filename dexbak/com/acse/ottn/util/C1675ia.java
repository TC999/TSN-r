package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.util.ia */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1675ia implements Consumer<String> {

    /* renamed from: a */
    final /* synthetic */ AcseHelpManager.OnOpenPermission f3327a;

    /* renamed from: b */
    final /* synthetic */ C1685na f3328b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1675ia(C1685na c1685na, AcseHelpManager.OnOpenPermission onOpenPermission) {
        this.f3328b = c1685na;
        this.f3327a = onOpenPermission;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        AcseHelpManager.OnOpenPermission onOpenPermission;
        JSONObject jSONObject = new JSONObject(str);
        if (this.f3327a != null) {
            int i = jSONObject.getInt("r");
            boolean z = true;
            if (i == 1) {
                onOpenPermission = this.f3327a;
                z = AcseHelpManager.isOPenPermission();
            } else {
                onOpenPermission = this.f3327a;
            }
            onOpenPermission.openPermission(z);
        }
    }
}
