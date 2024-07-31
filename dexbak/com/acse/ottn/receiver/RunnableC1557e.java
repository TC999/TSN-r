package com.acse.ottn.receiver;

import android.content.Intent;
import android.net.Uri;
import com.acse.ottn.util.HelpShopAppUtil;

/* renamed from: com.acse.ottn.receiver.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1557e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1558f f2922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1557e(C1558f c1558f) {
        this.f2922a = c1558f;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f2922a.f2923a));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.addFlags(268435456);
            HelpShopAppUtil.getContext().startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
