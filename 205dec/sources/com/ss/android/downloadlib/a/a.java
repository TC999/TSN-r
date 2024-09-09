package com.ss.android.downloadlib.a;

import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public void ok(@NonNull final com.ss.android.downloadad.api.ok.a aVar, @NonNull final h hVar, int i4) {
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (q.ok(aVar)) {
                    hVar.ok(false);
                } else if (!kf.ok(aVar)) {
                    hVar.ok(false);
                } else {
                    kf.ok(aVar, new p() { // from class: com.ss.android.downloadlib.a.a.1.1
                        @Override // com.ss.android.downloadlib.a.p
                        public void ok(boolean z3) {
                            hVar.ok(z3);
                        }
                    });
                }
            }
        }, i4);
    }
}
