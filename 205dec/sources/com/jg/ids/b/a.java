package com.jg.ids.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class a extends g {
    public a(Context context) {
        super(context);
        if (context instanceof Application) {
            this.f37822a = context;
        } else {
            this.f37822a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.g
    public final void a(IBinder iBinder) {
        try {
            b a4 = c.a(iBinder);
            if (a4 != null) {
                String d4 = a4.d(this.f37822a.getPackageName());
                String c4 = a4.c(this.f37822a.getPackageName());
                String b4 = a4.b(this.f37822a.getPackageName());
                a(d4);
                b(c4);
                c(b4);
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
            return this.f37822a.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e4) {
            return false;
        }
    }
}
