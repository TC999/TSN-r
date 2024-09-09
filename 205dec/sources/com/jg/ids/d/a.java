package com.jg.ids.d;

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
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.g
    public final void a(IBinder iBinder) {
        try {
            b a4 = c.a(iBinder);
            if (a4 != null) {
                c(a4.b());
                b();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f37822a == null) {
            return false;
        }
        try {
            return this.f37822a.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e4) {
            return false;
        }
    }
}
