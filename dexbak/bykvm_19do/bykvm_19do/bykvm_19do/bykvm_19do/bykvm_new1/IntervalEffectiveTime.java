package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import com.bytedance.msdk.adapter.util.Logger;
import com.kuaishou.weapon.p205p0.C7193bi;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class IntervalEffectiveTime {
    /* renamed from: a */
    public static long m59609a(long j) {
        Date date;
        Date date2 = new Date();
        int minutes = date2.getMinutes();
        if (j >= C7193bi.f24584s) {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 0, 0);
        } else if (minutes <= 30) {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 0, 0);
        } else {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 30, 0);
        }
        return m59608a(date.getTime(), j);
    }

    /* renamed from: b */
    public static String m59607b(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    /* renamed from: a */
    private static long m59608a(long j, long j2) {
        Date date = new Date(j2 + j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        Logger.m37562d("TTMediationSDK_IntervalEffectiveTime", "old time " + j + " new time = " + simpleDateFormat.format(date) + " 毫秒 = " + time);
        return time;
    }
}
