package com.ss.android.socialbase.downloader.kf;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class t {
    public static long a(@NonNull List<q> list) {
        long j4;
        long j5;
        long j6 = 0;
        loop0: while (true) {
            j4 = -1;
            j5 = -1;
            for (q qVar : list) {
                if (j4 == -1) {
                    if (qVar.ok() > 0) {
                        j4 = qVar.bl();
                        j5 = qVar.s();
                    }
                } else if (qVar.bl() <= j5) {
                    if (qVar.s() > j5) {
                        j5 = qVar.s();
                    }
                } else {
                    j6 += j5 - j4;
                    if (qVar.ok() > 0) {
                        j4 = qVar.bl();
                        j5 = qVar.s();
                    }
                }
            }
        }
        return (j4 < 0 || j5 <= j4) ? j6 : j6 + (j5 - j4);
    }

    public static long ok(@NonNull List<q> list) {
        int size = list.size();
        long j4 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            q qVar = list.get(i4);
            if (qVar.bl() > j4) {
                break;
            }
            if (qVar.n() > j4) {
                j4 = qVar.n();
            }
        }
        return j4;
    }
}
