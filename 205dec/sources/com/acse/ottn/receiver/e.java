package com.acse.ottn.receiver;

import android.content.Intent;
import android.net.Uri;
import com.acse.ottn.util.HelpShopAppUtil;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f6225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.f6225a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f6225a.f6226a));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.addFlags(268435456);
            HelpShopAppUtil.getContext().startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
