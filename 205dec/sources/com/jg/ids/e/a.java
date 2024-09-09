package com.jg.ids.e;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class a extends g {
    public a(Context context) {
        super(context);
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.g
    public final void a(IBinder iBinder) {
        b a4 = c.a(iBinder);
        if (a4 != null) {
            String a5 = a4.a();
            a("");
            b("");
            c(a5);
        }
    }
}
