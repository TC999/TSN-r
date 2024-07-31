package com.p521ss.android.socialbase.downloader.p551kf;

import androidx.annotation.NonNull;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.kf.t */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12591t {
    /* renamed from: a */
    public static long m17194a(@NonNull List<C12584q> list) {
        long j;
        long j2;
        long j3 = 0;
        loop0: while (true) {
            j = -1;
            j2 = -1;
            for (C12584q c12584q : list) {
                if (j == -1) {
                    if (c12584q.m17287ok() > 0) {
                        j = c12584q.m17293bl();
                        j2 = c12584q.m17280s();
                    }
                } else if (c12584q.m17293bl() <= j2) {
                    if (c12584q.m17280s() > j2) {
                        j2 = c12584q.m17280s();
                    }
                } else {
                    j3 += j2 - j;
                    if (c12584q.m17287ok() > 0) {
                        j = c12584q.m17293bl();
                        j2 = c12584q.m17280s();
                    }
                }
            }
        }
        return (j < 0 || j2 <= j) ? j3 : j3 + (j2 - j);
    }

    /* renamed from: ok */
    public static long m17193ok(@NonNull List<C12584q> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            C12584q c12584q = list.get(i);
            if (c12584q.m17293bl() > j) {
                break;
            }
            if (c12584q.m17288n() > j) {
                j = c12584q.m17288n();
            }
        }
        return j;
    }
}
