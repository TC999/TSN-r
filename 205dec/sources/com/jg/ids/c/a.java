package com.jg.ids.c;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;
import java.util.Objects;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class a extends g {

    /* renamed from: b  reason: collision with root package name */
    private KeyguardManager f37812b;

    public a(Context context) {
        super(context);
        if (this.f37822a != null) {
            this.f37812b = (KeyguardManager) this.f37822a.getSystemService("keyguard");
            if (d()) {
                try {
                    Object invoke = this.f37812b.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f37812b, new Object[0]);
                    if (invoke != null) {
                        c(invoke.toString());
                    }
                } catch (Exception e4) {
                }
            }
        }
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        return new Intent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.g
    public final void a(IBinder iBinder) {
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f37822a != null && this.f37812b != null) {
            try {
                return ((Boolean) Objects.requireNonNull(this.f37812b.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f37812b, new Object[0]))).booleanValue();
            } catch (Exception e4) {
                return false;
            }
        }
        return false;
    }
}
