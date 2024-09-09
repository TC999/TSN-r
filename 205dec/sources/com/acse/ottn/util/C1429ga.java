package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import io.reactivex.functions.Consumer;

/* renamed from: com.acse.ottn.util.ga  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1429ga implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnOpenPermission f6831a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1443na f6832b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1429ga(C1443na c1443na, AcseHelpManager.OnOpenPermission onOpenPermission) {
        this.f6832b = c1443na;
        this.f6831a = onOpenPermission;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r3 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r3 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        r3.openPermission(false);
     */
    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void accept(java.lang.String r3) throws java.lang.Exception {
        /*
            r2 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r3)
            java.lang.String r3 = "r"
            int r3 = r0.getInt(r3)
            r1 = 1
            if (r3 != r1) goto L23
            java.lang.String r3 = "open_plugin_permission"
            int r3 = r0.getInt(r3)
            if (r3 != r1) goto L1e
            com.acse.ottn.activity.AcseHelpManager$OnOpenPermission r3 = r2.f6831a
            if (r3 == 0) goto L2b
            r3.openPermission(r1)
            goto L2b
        L1e:
            com.acse.ottn.activity.AcseHelpManager$OnOpenPermission r3 = r2.f6831a
            if (r3 == 0) goto L2b
            goto L27
        L23:
            com.acse.ottn.activity.AcseHelpManager$OnOpenPermission r3 = r2.f6831a
            if (r3 == 0) goto L2b
        L27:
            r0 = 0
            r3.openPermission(r0)
        L2b:
            com.acse.ottn.util.va r3 = com.acse.ottn.util.va.a()
            java.lang.String r0 = "open_app"
            r3.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.util.C1429ga.accept(java.lang.String):void");
    }
}
