package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import io.reactivex.functions.Consumer;

/* renamed from: com.acse.ottn.util.ja */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1677ja implements Consumer<Throwable> {

    /* renamed from: a */
    final /* synthetic */ AcseHelpManager.OnOpenPermission f3330a;

    /* renamed from: b */
    final /* synthetic */ C1685na f3331b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1677ja(C1685na c1685na, AcseHelpManager.OnOpenPermission onOpenPermission) {
        this.f3331b = c1685na;
        this.f3330a = onOpenPermission;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        AcseHelpManager.OnOpenPermission onOpenPermission = this.f3330a;
        if (onOpenPermission != null) {
            onOpenPermission.openPermission(AcseHelpManager.isOPenPermission());
        }
    }
}
