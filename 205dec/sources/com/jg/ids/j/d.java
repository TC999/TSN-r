package com.jg.ids.j;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class d extends g {
    public d(Context context) {
        super(context);
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.g
    public final void a(IBinder iBinder) {
        try {
            a a4 = b.a(iBinder);
            if (a4 != null) {
                String b4 = a4.b(this.f37822a.getPackageName());
                String a5 = a4.a(this.f37822a.getPackageName());
                String a6 = a4.a();
                a(b4);
                b(a5);
                c(a6);
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
            return this.f37822a.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e4) {
            return false;
        }
    }
}
