package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class TimeUtils {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i4, int i5, boolean z3, int i6) {
        if (i4 > 99 || (z3 && i6 >= 3)) {
            return i5 + 3;
        }
        if (i4 > 9 || (z3 && i6 >= 2)) {
            return i5 + 2;
        }
        if (z3 || i4 > 0) {
            return i5 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j4, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j4, 0));
        }
    }

    private static int formatDurationLocked(long j4, int i4) {
        char c4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j5 = j4;
        if (sFormatStr.length < i4) {
            sFormatStr = new char[i4];
        }
        char[] cArr = sFormatStr;
        if (j5 == 0) {
            int i10 = i4 - 1;
            while (i10 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j5 > 0) {
            c4 = '+';
        } else {
            c4 = '-';
            j5 = -j5;
        }
        int i11 = (int) (j5 % 1000);
        int floor = (int) Math.floor(j5 / 1000);
        if (floor > 86400) {
            i5 = floor / 86400;
            floor -= 86400 * i5;
        } else {
            i5 = 0;
        }
        if (floor > 3600) {
            i6 = floor / 3600;
            floor -= i6 * 3600;
        } else {
            i6 = 0;
        }
        if (floor > 60) {
            int i12 = floor / 60;
            i7 = floor - (i12 * 60);
            i8 = i12;
        } else {
            i7 = floor;
            i8 = 0;
        }
        if (i4 != 0) {
            int accumField = accumField(i5, 1, false, 0);
            int accumField2 = accumField + accumField(i6, 1, accumField > 0, 2);
            int accumField3 = accumField2 + accumField(i8, 1, accumField2 > 0, 2);
            int accumField4 = accumField3 + accumField(i7, 1, accumField3 > 0, 2);
            i9 = 0;
            for (int accumField5 = accumField4 + accumField(i11, 2, true, accumField4 > 0 ? 3 : 0) + 1; accumField5 < i4; accumField5++) {
                cArr[i9] = ' ';
                i9++;
            }
        } else {
            i9 = 0;
        }
        cArr[i9] = c4;
        int i13 = i9 + 1;
        boolean z3 = i4 != 0;
        int printField = printField(cArr, i5, 'd', i13, false, 0);
        int printField2 = printField(cArr, i6, 'h', printField, printField != i13, z3 ? 2 : 0);
        int printField3 = printField(cArr, i8, 'm', printField2, printField2 != i13, z3 ? 2 : 0);
        int printField4 = printField(cArr, i7, 's', printField3, printField3 != i13, z3 ? 2 : 0);
        int printField5 = printField(cArr, i11, 'm', printField4, true, (!z3 || printField4 == i13) ? 0 : 3);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i4, char c4, int i5, boolean z3, int i6) {
        int i7;
        if (z3 || i4 > 0) {
            if ((!z3 || i6 < 3) && i4 <= 99) {
                i7 = i5;
            } else {
                int i8 = i4 / 100;
                cArr[i5] = (char) (i8 + 48);
                i7 = i5 + 1;
                i4 -= i8 * 100;
            }
            if ((z3 && i6 >= 2) || i4 > 9 || i5 != i7) {
                int i9 = i4 / 10;
                cArr[i7] = (char) (i9 + 48);
                i7++;
                i4 -= i9 * 10;
            }
            cArr[i7] = (char) (i4 + 48);
            int i10 = i7 + 1;
            cArr[i10] = c4;
            return i10 + 1;
        }
        return i5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j4, PrintWriter printWriter, int i4) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j4, i4)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j4, PrintWriter printWriter) {
        formatDuration(j4, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j4, long j5, PrintWriter printWriter) {
        if (j4 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j4 - j5, printWriter, 0);
        }
    }
}
