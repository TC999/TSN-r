package com.bytedance.msdk.core.w;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.f.wv;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final wv f28276c = wv.c("tt_user_live_day_time", com.bytedance.msdk.core.c.getContext());

    /* renamed from: w  reason: collision with root package name */
    private static final SimpleDateFormat f28277w = new SimpleDateFormat("yyyy-MM-dd");
    private static final Calendar xv = Calendar.getInstance();

    public static void c() {
        com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "recordUserLiveDay start => enableDynamicPolicy:" + com.bytedance.msdk.core.c.w().me());
        if (com.bytedance.msdk.core.c.w().me()) {
            long currentTimeMillis = System.currentTimeMillis();
            String r3 = r();
            com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "\u5f53\u524d\u65e5\u671f(key)\uff1a" + r3);
            wv wvVar = f28276c;
            if (wvVar.ux(r3)) {
                com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "key=" + r3 + "\uff0c\u540c\u4e00\u5929\uff0c\u4e0d\u518d\u91cd\u65b0\u8bb0\u5f55");
                return;
            }
            if (TextUtils.isEmpty(wvVar.w("start_index"))) {
                wvVar.c("start_index", r3);
                com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "START_INDEX=" + r3);
            }
            wvVar.c(r3, true);
            wvVar.c("user_live_times", wvVar.w("user_live_times", 0) + 1);
            String w3 = wvVar.w("start_index");
            if (!TextUtils.equals(w3, r3)) {
                try {
                    SimpleDateFormat simpleDateFormat = f28277w;
                    Date parse = simpleDateFormat.parse(w3);
                    Date parse2 = simpleDateFormat.parse(r3);
                    if (parse2 == null) {
                        parse2 = new Date();
                    }
                    if (parse != null) {
                        int c4 = c(parse.getTime(), parse2.getTime());
                        int up = com.bytedance.msdk.core.c.w().up();
                        if (up - c4 < 0) {
                            int i4 = c4 - up;
                            String c5 = c(parse, i4);
                            if (!TextUtils.isEmpty(c5)) {
                                wvVar.c("start_index", c5);
                                c(w3, parse, i4);
                            }
                            com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "old-startIndex:" + w3 + ",diff=" + i4 + ",new-startIndex:" + c5);
                        }
                    }
                } catch (ParseException e4) {
                    com.bytedance.msdk.adapter.sr.xv.sr("AdLoadDynamicParamHandler", "\u8ba1\u7b97\u751f\u6210\u65e5\u671f\u51fa\u9519\uff1a" + e4.getMessage());
                }
            } else {
                com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "startDay:" + w3 + ",key=" + r3 + "\uff0c\u540c\u4e00\u5929\uff0c\u4e0d\u5904\u7406");
            }
            com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "recordUserLiveDay\u65b9\u6cd5\uff0c\u6267\u884c\u8017\u65f6\uff1a" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public static long ev(String str) {
        if (!com.bytedance.msdk.core.c.w().me() || str == null) {
            return -1L;
        }
        String w3 = w(str, "_show_current_time_");
        String w4 = w(str, "_show_last_time_");
        wv wvVar = f28276c;
        if (TextUtils.equals(wvVar.w("_show_gap_time_day"), r())) {
            long sr = wvVar.sr(w4);
            if (sr == 0) {
                return 0L;
            }
            return Math.round((float) ((wvVar.sr(w3) - sr) / 1000));
        }
        return 0L;
    }

    public static int f(String str) {
        if (!com.bytedance.msdk.core.c.w().me() || str == null) {
            return -1;
        }
        return gd(f28276c.w(w(str, "_click_count_")));
    }

    private static int gd(String str) {
        if (str == null) {
            return 0;
        }
        String[] split = str.split("_");
        if (split.length != 2 || split[1] == null) {
            return 0;
        }
        return Integer.parseInt(split[1]);
    }

    public static void r(String str) {
        if (!com.bytedance.msdk.core.c.w().me() || str == null) {
            return;
        }
        String w3 = w(str, "_show_current_time_");
        String w4 = w(str, "_show_last_time_");
        wv wvVar = f28276c;
        String w5 = wvVar.w("_show_gap_time_day");
        String r3 = r();
        com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "recordSameDayTwoAdIntervalTime curKey:" + w3 + ",lastKey :" + w4 + ",today:" + r3 + ",recordDate:" + w5);
        if (!TextUtils.equals(w5, r3)) {
            wvVar.c(w4, 0L);
            wvVar.c(w3, System.currentTimeMillis());
            wvVar.c("_show_gap_time_day", r3);
            return;
        }
        wvVar.c(w4, wvVar.sr(w3));
        wvVar.c(w3, System.currentTimeMillis());
    }

    public static int sr(String str) {
        if (!com.bytedance.msdk.core.c.w().me() || str == null) {
            return -1;
        }
        return gd(f28276c.w(w(str, "_show_count_")));
    }

    public static void ux(String str) {
        if (!com.bytedance.msdk.core.c.w().me() || str == null) {
            return;
        }
        c(str, "_click_count_");
    }

    public static int w() {
        if (com.bytedance.msdk.core.c.w().me()) {
            return f28276c.w("user_live_times", 0);
        }
        return -1;
    }

    public static void xv(String str) {
        if (!com.bytedance.msdk.core.c.w().me() || str == null) {
            return;
        }
        c(str, "_show_count_");
    }

    public static int ux() {
        if (com.bytedance.msdk.core.c.w().me()) {
            return c(com.bytedance.msdk.core.w.k().xv(), System.currentTimeMillis());
        }
        return -1;
    }

    public static int w(String str) {
        if (!com.bytedance.msdk.core.c.w().me() || str == null) {
            return -1;
        }
        return gd(f28276c.w(w(str, "_dislike_count_")));
    }

    public static void xv() {
        com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "recordSameDaySdkStartTimes start => enableDynamicPolicy:" + com.bytedance.msdk.core.c.w().me());
        if (com.bytedance.msdk.core.c.w().me()) {
            c((String) null, "tt_sdk_start_count_");
        }
    }

    public static long f() {
        if (com.bytedance.msdk.core.c.w().me()) {
            float ux = ((float) com.bytedance.msdk.core.w.k().ux()) / 60000.0f;
            if (ux <= 0.0f || ux >= 1.0f) {
                return Math.round(ux);
            }
            return 1L;
        }
        return -1L;
    }

    public static int sr() {
        if (com.bytedance.msdk.core.c.w().me()) {
            return gd(f28276c.w("tt_sdk_start_count_"));
        }
        return -1;
    }

    private static String w(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str + str2;
    }

    private static String r() {
        return f28277w.format(new Date());
    }

    private static void c(String str, Date date, int i4) {
        if (i4 == 1) {
            wv wvVar = f28276c;
            if (wvVar.ux(str)) {
                wvVar.c("user_live_times", Math.max(wvVar.xv("user_live_times") - 1, 0));
            }
            wvVar.f(str);
            return;
        }
        int i5 = 0;
        while (i5 < i4) {
            i5++;
            String c4 = c(date, i5);
            wv wvVar2 = f28276c;
            if (wvVar2.ux(c4)) {
                wvVar2.c("user_live_times", Math.max(wvVar2.xv("user_live_times") - 1, 0));
            }
            wvVar2.f(c4);
        }
    }

    public static void c(String str) {
        if (!com.bytedance.msdk.core.c.w().me() || str == null) {
            return;
        }
        c(str, "_dislike_count_");
    }

    private static void c(String str, String str2) {
        String w3 = w(str, str2);
        String r3 = r();
        wv wvVar = f28276c;
        String w4 = wvVar.w(w3);
        com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "saveToSpByAction key:" + w3 + ",old value:" + w4);
        int i4 = 1;
        if (!TextUtils.isEmpty(w4)) {
            String[] split = w4.split("_");
            if (split.length == 2) {
                String str3 = split[0];
                if (!TextUtils.isEmpty(str3) && TextUtils.equals(r3, str3)) {
                    i4 = 1 + Integer.parseInt(split[1]);
                    r3 = str3;
                }
                w4 = c(r3, i4);
            }
            com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "saveToSpByAction key:" + w3 + "\uff0cnew value\uff1a" + w4);
            wvVar.c(w3, w4);
            return;
        }
        wvVar.c(w3, c(r3, 1));
        com.bytedance.msdk.adapter.sr.xv.w("AdLoadDynamicParamHandler", "saveToSpByAction \u9996\u6b21\u8bb0\u5f55 key:" + w3 + "\uff0cnew value\uff1a" + c(r3, 1));
    }

    private static String c(String str, int i4) {
        return str + "_" + i4;
    }

    private static int c(long j4, long j5) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Period.between(Instant.ofEpochMilli(j4).atZone(ZoneOffset.systemDefault()).toLocalDate(), Instant.ofEpochMilli(j5).atZone(ZoneOffset.systemDefault()).toLocalDate()).getDays();
        }
        return (int) ((j5 - j4) / 86400000);
    }

    private static String c(Date date, int i4) {
        if (date == null) {
            return null;
        }
        Calendar calendar = xv;
        calendar.setTime(date);
        calendar.add(5, i4);
        return f28277w.format(calendar.getTime());
    }

    public static void c(List<com.bytedance.msdk.c.ux> list, com.bytedance.msdk.core.k.w wVar) {
        if (!com.bytedance.msdk.core.c.w().me() || list == null || wVar == null) {
            return;
        }
        for (com.bytedance.msdk.c.ux uxVar : list) {
            if (uxVar != null) {
                uxVar.getMediaExtraInfo().put("prime_rit", wVar.xk());
            }
        }
    }
}
