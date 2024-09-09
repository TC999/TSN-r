package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.util.ia  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1433ia implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnOpenPermission f6837a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1443na f6838b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1433ia(C1443na c1443na, AcseHelpManager.OnOpenPermission onOpenPermission) {
        this.f6838b = c1443na;
        this.f6837a = onOpenPermission;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        AcseHelpManager.OnOpenPermission onOpenPermission;
        JSONObject jSONObject = new JSONObject(str);
        if (this.f6837a != null) {
            int i4 = jSONObject.getInt("r");
            boolean z3 = true;
            if (i4 == 1) {
                onOpenPermission = this.f6837a;
                z3 = AcseHelpManager.isOPenPermission();
            } else {
                onOpenPermission = this.f6837a;
            }
            onOpenPermission.openPermission(z3);
        }
    }
}
