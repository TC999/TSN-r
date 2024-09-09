package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import io.reactivex.functions.Consumer;

/* renamed from: com.acse.ottn.util.ja  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1435ja implements Consumer<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnOpenPermission f6840a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1443na f6841b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1435ja(C1443na c1443na, AcseHelpManager.OnOpenPermission onOpenPermission) {
        this.f6841b = c1443na;
        this.f6840a = onOpenPermission;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        AcseHelpManager.OnOpenPermission onOpenPermission = this.f6840a;
        if (onOpenPermission != null) {
            onOpenPermission.openPermission(AcseHelpManager.isOPenPermission());
        }
    }
}
