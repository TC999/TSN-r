package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import com.bytedance.msdk.adapter.util.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: IntervalEffectiveTime.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f {
    public static long a(long j4) {
        Date date;
        Date date2 = new Date();
        int minutes = date2.getMinutes();
        if (j4 >= 3600000) {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 0, 0);
        } else if (minutes <= 30) {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 0, 0);
        } else {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 30, 0);
        }
        return a(date.getTime(), j4);
    }

    public static String b(long j4) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j4));
    }

    private static long a(long j4, long j5) {
        Date date = new Date(j5 + j4);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        Logger.d("TTMediationSDK_IntervalEffectiveTime", "old time " + j4 + " new time = " + simpleDateFormat.format(date) + " \u6beb\u79d2 = " + time);
        return time;
    }
}
