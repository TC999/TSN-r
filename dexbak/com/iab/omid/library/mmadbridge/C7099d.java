package com.iab.omid.library.mmadbridge;

import android.content.Context;
import com.iab.omid.library.mmadbridge.p202b.C7086b;
import com.iab.omid.library.mmadbridge.p202b.C7089d;
import com.iab.omid.library.mmadbridge.p202b.C7092f;
import com.iab.omid.library.mmadbridge.p204d.C7101b;
import com.iab.omid.library.mmadbridge.p204d.C7105e;

/* renamed from: com.iab.omid.library.mmadbridge.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7099d {

    /* renamed from: a */
    private boolean f24254a;

    /* renamed from: d */
    private void m34701d(Context context) {
        C7105e.m34671d(context, "Application Context cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m34704a() {
        return "1.3.29-Mmadbridge";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m34703b(Context context) {
        m34701d(context);
        if (m34700e()) {
            return;
        }
        m34702c(true);
        C7092f.m34717b().m34716c(context);
        C7086b.m34750a().m34749b(context);
        C7101b.m34693c(context);
        C7089d.m34738a().m34737b(context);
    }

    /* renamed from: c */
    void m34702c(boolean z) {
        this.f24254a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean m34700e() {
        return this.f24254a;
    }
}
