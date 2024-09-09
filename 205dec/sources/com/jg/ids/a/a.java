package com.jg.ids.a;

import android.content.ComponentName;
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
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.g
    public final void a(IBinder iBinder) {
        try {
            b a4 = c.a(iBinder);
            if (a4 != null) {
                String e4 = a4.e();
                String d4 = a4.d();
                String c4 = a4.c();
                a(e4);
                b(d4);
                c(c4);
            }
            b();
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f37822a == null) {
            return false;
        }
        try {
            return this.f37822a.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e4) {
            return false;
        }
    }
}
