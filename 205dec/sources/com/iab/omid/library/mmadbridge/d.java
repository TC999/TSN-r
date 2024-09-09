package com.iab.omid.library.mmadbridge;

import android.content.Context;
import com.iab.omid.library.mmadbridge.b.f;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f37736a;

    private void d(Context context) {
        com.iab.omid.library.mmadbridge.d.e.d(context, "Application Context cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return "1.3.29-Mmadbridge";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        d(context);
        if (e()) {
            return;
        }
        c(true);
        f.b().c(context);
        com.iab.omid.library.mmadbridge.b.b.a().b(context);
        com.iab.omid.library.mmadbridge.d.b.c(context);
        com.iab.omid.library.mmadbridge.b.d.a().b(context);
    }

    void c(boolean z3) {
        this.f37736a = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f37736a;
    }
}
