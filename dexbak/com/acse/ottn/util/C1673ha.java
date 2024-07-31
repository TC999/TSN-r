package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.ha */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1673ha implements Consumer<Throwable> {

    /* renamed from: a */
    final /* synthetic */ AcseHelpManager.OnOpenPermission f3323a;

    /* renamed from: b */
    final /* synthetic */ C1685na f3324b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1673ha(C1685na c1685na, AcseHelpManager.OnOpenPermission onOpenPermission) {
        this.f3324b = c1685na;
        this.f3323a = onOpenPermission;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable th) throws Exception {
        AcseHelpManager.OnOpenPermission onOpenPermission = this.f3323a;
        if (onOpenPermission != null) {
            onOpenPermission.openPermission(false);
        }
        C1703va.m55903a().m55901a("open_app");
    }
}
