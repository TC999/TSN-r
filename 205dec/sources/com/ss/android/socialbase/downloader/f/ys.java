package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ys {
    public static long c(@NonNull List<gd> list) {
        int size = list.size();
        long j4 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            gd gdVar = list.get(i4);
            if (gdVar.xv() > j4) {
                break;
            }
            if (gdVar.ux() > j4) {
                j4 = gdVar.ux();
            }
        }
        return j4;
    }

    public static long w(@NonNull List<gd> list) {
        long j4;
        long j5;
        long j6 = 0;
        loop0: while (true) {
            j4 = -1;
            j5 = -1;
            for (gd gdVar : list) {
                if (j4 == -1) {
                    if (gdVar.c() > 0) {
                        j4 = gdVar.xv();
                        j5 = gdVar.sr();
                    }
                } else if (gdVar.xv() <= j5) {
                    if (gdVar.sr() > j5) {
                        j5 = gdVar.sr();
                    }
                } else {
                    j6 += j5 - j4;
                    if (gdVar.c() > 0) {
                        j4 = gdVar.xv();
                        j5 = gdVar.sr();
                    }
                }
            }
        }
        return (j4 < 0 || j5 <= j4) ? j6 : j6 + (j5 - j4);
    }
}
