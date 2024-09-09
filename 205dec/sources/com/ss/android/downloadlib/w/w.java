package com.ss.android.downloadlib.w;

import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {
    public void c(@NonNull final com.ss.android.downloadad.api.c.w wVar, @NonNull final r rVar, int i4) {
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.w.w.1
            @Override // java.lang.Runnable
            public void run() {
                if (gd.c(wVar)) {
                    rVar.c(false);
                } else if (!f.c(wVar)) {
                    rVar.c(false);
                } else {
                    f.c(wVar, new ev() { // from class: com.ss.android.downloadlib.w.w.1.1
                        @Override // com.ss.android.downloadlib.w.ev
                        public void c(boolean z3) {
                            rVar.c(z3);
                        }
                    });
                }
            }
        }, i4);
    }
}
