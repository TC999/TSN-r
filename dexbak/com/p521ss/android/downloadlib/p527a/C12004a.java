package com.p521ss.android.downloadlib.p527a;

import androidx.annotation.NonNull;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12265s;

/* renamed from: com.ss.android.downloadlib.a.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12004a {
    /* renamed from: ok */
    public void m19407ok(@NonNull final C11998a c11998a, @NonNull final InterfaceC12009h interfaceC12009h, int i) {
        C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (C12023q.m19372ok(c11998a)) {
                    interfaceC12009h.mo18607ok(false);
                } else if (!C12011kf.m19397ok(c11998a)) {
                    interfaceC12009h.mo18607ok(false);
                } else {
                    C12011kf.m19395ok(c11998a, new InterfaceC12022p() { // from class: com.ss.android.downloadlib.a.a.1.1
                        @Override // com.p521ss.android.downloadlib.p527a.InterfaceC12022p
                        /* renamed from: ok */
                        public void mo19373ok(boolean z) {
                            interfaceC12009h.mo18607ok(z);
                        }
                    });
                }
            }
        }, i);
    }
}
