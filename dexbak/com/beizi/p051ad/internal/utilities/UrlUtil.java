package com.beizi.p051ad.internal.utilities;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.ClickTracker;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;
import com.beizi.p051ad.p056c.AdResponseOuterClass;
import com.beizi.p051ad.p056c.ClickPositionModel;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* renamed from: com.beizi.ad.internal.utilities.UrlUtil */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UrlUtil {
    public static String CLT_TYPE = "__CLT__";
    public static String CLT_TYPE_999 = "__CLT-999__";
    public static String E_TS_E = ".EVENT_TS_END.";
    public static String E_TS_S = ".EVENT_TS_START.";
    public static String RAW_X_DOWN = ".SCRN_CLK_PT_DOWN_X.";
    public static String RAW_X_DOWN_DP = ".SCRN_CLK_PT_DOWN_X_DP.";
    public static String RAW_X_UP = ".SCRN_CLK_PT_UP_X.";
    public static String RAW_X_UP_DP = ".SCRN_CLK_PT_UP_X_DP.";
    public static String RAW_Y_DOWN = ".SCRN_CLK_PT_DOWN_Y.";
    public static String RAW_Y_DOWN_DP = ".SCRN_CLK_PT_DOWN_Y_DP.";
    public static String RAW_Y_UP = ".SCRN_CLK_PT_UP_Y.";
    public static String RAW_Y_UP_DP = ".SCRN_CLK_PT_UP_Y_DP.";

    /* renamed from: TS */
    public static String f10419TS = ".UTC_TS.";
    public static String V_D = ".VIDEO_DURATION.";
    public static String X_DOWN = ".AD_CLK_PT_DOWN_X.";
    public static String X_DOWN_DP = ".AD_CLK_PT_DOWN_X_DP.";
    public static String X_UP = ".AD_CLK_PT_UP_X.";
    public static String X_UP_DP = ".AD_CLK_PT_UP_X_DP.";
    public static String Y_DOWN = ".AD_CLK_PT_DOWN_Y.";
    public static String Y_DOWN_DP = ".AD_CLK_PT_DOWN_Y_DP.";
    public static String Y_UP = ".AD_CLK_PT_UP_Y.";
    public static String Y_UP_DP = ".AD_CLK_PT_UP_Y_DP.";

    /* renamed from: com.beizi.ad.internal.utilities.UrlUtil$DNSResolver */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class DNSResolver implements Runnable {
        private String domain;
        private InetAddress inetAddr;

        public DNSResolver(String str) {
            this.domain = str;
        }

        public synchronized InetAddress get() {
            return this.inetAddr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                set(InetAddress.getByName(this.domain));
            } catch (UnknownHostException unused) {
            }
        }

        public synchronized void set(InetAddress inetAddress) {
            this.inetAddr = inetAddress;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public static boolean isSendTouchEventUrl(String str) {
        ?? contains = str.contains(X_DOWN);
        int i = contains;
        if (str.contains(Y_DOWN)) {
            i = contains + 1;
        }
        int i2 = i;
        if (str.contains(X_UP)) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (str.contains(Y_UP)) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (str.contains(RAW_X_DOWN)) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (str.contains(RAW_Y_DOWN)) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (str.contains(RAW_X_UP)) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (str.contains(RAW_Y_UP)) {
            i7 = i6 + 1;
        }
        int i8 = i7;
        if (str.contains(f10419TS)) {
            i8 = i7 + 1;
        }
        return i8 == 9;
    }

    public static String px2dip(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && !str.equals("-999") && !str.equals("0")) {
                return String.valueOf((int) ((((float) Double.parseDouble(str)) / context.getResources().getDisplayMetrics().density) + 0.5f));
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static String replaceToTouchEventUrl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains(X_DOWN)) {
                str = str.replace(X_DOWN, str2);
            }
            if (str.contains(Y_DOWN)) {
                str = str.replace(Y_DOWN, str3);
            }
            if (str.contains(X_UP)) {
                str = str.replace(X_UP, str2);
            }
            if (str.contains(Y_UP)) {
                str = str.replace(Y_UP, str3);
            }
            if (str.contains(RAW_X_DOWN)) {
                str = str.replace(RAW_X_DOWN, str4);
            }
            if (str.contains(RAW_Y_DOWN)) {
                str = str.replace(RAW_Y_DOWN, str5);
            }
            if (str.contains(RAW_X_UP)) {
                str = str.replace(RAW_X_UP, str4);
            }
            if (str.contains(RAW_Y_UP)) {
                str = str.replace(RAW_Y_UP, str5);
            }
            if (str.contains(f10419TS)) {
                str = str.replace(f10419TS, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(E_TS_S)) {
                str = str.replace(E_TS_S, str6);
            }
            if (str.contains(E_TS_E)) {
                str = str.replace(E_TS_E, str7);
            }
            return str.contains(V_D) ? str.replace(V_D, str8) : str;
        }
        throw new IllegalArgumentException("url must no null");
    }

    public static void sendClickInfoToServerWithReplace(AdResponseOuterClass.C2803h c2803h, String str, String str2, String str3, String str4) {
        String m49929b = c2803h.m49929b();
        if (TextUtils.isEmpty(m49929b)) {
            return;
        }
        new ClickTracker(replaceToTouchEventUrl(m49929b, str, str2, str3, str4, "", "", "")).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
    }

    public static void sendOnCompletionInfoToServer(AdResponseOuterClass.C2803h c2803h) {
        String m49921f = c2803h.m49921f();
        if (TextUtils.isEmpty(m49921f)) {
            return;
        }
        new ClickTracker(replaceToTouchEventUrl(m49921f, "", "", "", "", "", "", "")).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
    }

    public static void sendOnPauseInfoToServer(AdResponseOuterClass.C2803h c2803h) {
        String m49923e = c2803h.m49923e();
        if (TextUtils.isEmpty(m49923e)) {
            return;
        }
        new ClickTracker(replaceToTouchEventUrl(m49923e, "", "", "", "", "", "", "")).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
    }

    public static void sendOnStartInfoToServer(AdResponseOuterClass.C2803h c2803h) {
        String m49925d = c2803h.m49925d();
        if (TextUtils.isEmpty(m49925d)) {
            return;
        }
        new ClickTracker(replaceToTouchEventUrl(m49925d, "", "", "", "", "", "", "")).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
    }

    public static void sendViewShowInfoToServer(AdResponseOuterClass.C2803h c2803h) {
        String m49931a = c2803h.m49931a();
        if (TextUtils.isEmpty(m49931a)) {
            return;
        }
        new ClickTracker(replaceToTouchEventUrl(m49931a, "", "", "", "", "", "", "")).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
    }

    public static boolean testDNS(String str) {
        try {
            DNSResolver dNSResolver = new DNSResolver("api.htp.ad-scope.com.cn");
            Thread thread = new Thread(dNSResolver);
            thread.start();
            thread.join(1500L);
            return dNSResolver.get() != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String replaceToTouchEventUrl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                if (str.contains(CLT_TYPE)) {
                    str2 = "0";
                    str3 = str2;
                    str4 = str3;
                    str5 = str4;
                }
                if (str.contains(CLT_TYPE_999)) {
                    str2 = "-999";
                    str3 = str2;
                    str4 = str3;
                    str5 = str4;
                }
            }
            if (str.contains(X_DOWN)) {
                str = str.replace(X_DOWN, str2);
            }
            if (str.contains(Y_DOWN)) {
                str = str.replace(Y_DOWN, str3);
            }
            if (str.contains(X_UP)) {
                str = str.replace(X_UP, str2);
            }
            if (str.contains(Y_UP)) {
                str = str.replace(Y_UP, str3);
            }
            if (str.contains(RAW_X_DOWN)) {
                str = str.replace(RAW_X_DOWN, str4);
            }
            if (str.contains(RAW_Y_DOWN)) {
                str = str.replace(RAW_Y_DOWN, str5);
            }
            if (str.contains(RAW_X_UP)) {
                str = str.replace(RAW_X_UP, str4);
            }
            if (str.contains(RAW_Y_UP)) {
                str = str.replace(RAW_Y_UP, str5);
            }
            if (str.contains(X_DOWN_DP)) {
                str = str.replace(X_DOWN_DP, px2dip(BeiZiImpl.m49492a().f10139i, str2));
            }
            if (str.contains(Y_DOWN_DP)) {
                str = str.replace(Y_DOWN_DP, px2dip(BeiZiImpl.m49492a().f10139i, str3));
            }
            if (str.contains(X_UP_DP)) {
                str = str.replace(X_UP_DP, px2dip(BeiZiImpl.m49492a().f10139i, str2));
            }
            if (str.contains(Y_UP_DP)) {
                str = str.replace(Y_UP_DP, px2dip(BeiZiImpl.m49492a().f10139i, str3));
            }
            if (str.contains(RAW_X_DOWN_DP)) {
                str = str.replace(RAW_X_DOWN_DP, px2dip(BeiZiImpl.m49492a().f10139i, str4));
            }
            if (str.contains(RAW_Y_DOWN_DP)) {
                str = str.replace(RAW_Y_DOWN_DP, px2dip(BeiZiImpl.m49492a().f10139i, str5));
            }
            if (str.contains(RAW_X_UP_DP)) {
                str = str.replace(RAW_X_UP_DP, px2dip(BeiZiImpl.m49492a().f10139i, str4));
            }
            if (str.contains(RAW_Y_UP_DP)) {
                str = str.replace(RAW_Y_UP_DP, px2dip(BeiZiImpl.m49492a().f10139i, str5));
            }
            if (str.contains(CLT_TYPE)) {
                str = str.replace(CLT_TYPE, String.valueOf(i));
            }
            if (str.contains(CLT_TYPE_999)) {
                str = str.replace(CLT_TYPE_999, String.valueOf(i));
            }
            if (str.contains(f10419TS)) {
                str = str.replace(f10419TS, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(E_TS_S)) {
                str = str.replace(E_TS_S, str6);
            }
            if (str.contains(E_TS_E)) {
                str = str.replace(E_TS_E, str7);
            }
            return str.contains(V_D) ? str.replace(V_D, str8) : str;
        }
        throw new IllegalArgumentException("url must no null");
    }

    public static String replaceToTouchEventUrl(String str, ClickPositionModel clickPositionModel, String str2, String str3, String str4) {
        if (str.contains(X_DOWN) && !TextUtils.isEmpty(clickPositionModel.m49863a())) {
            str = str.replace(X_DOWN, clickPositionModel.m49863a());
        }
        if (str.contains(Y_DOWN) && !TextUtils.isEmpty(clickPositionModel.m49861b())) {
            str = str.replace(Y_DOWN, clickPositionModel.m49861b());
        }
        if (str.contains(X_UP) && !TextUtils.isEmpty(clickPositionModel.m49855e())) {
            str = str.replace(X_UP, clickPositionModel.m49855e());
        }
        if (str.contains(Y_UP) && !TextUtils.isEmpty(clickPositionModel.m49853f())) {
            str = str.replace(Y_UP, clickPositionModel.m49853f());
        }
        if (str.contains(RAW_X_DOWN) && !TextUtils.isEmpty(clickPositionModel.m49859c())) {
            str = str.replace(RAW_X_DOWN, clickPositionModel.m49859c());
        }
        if (str.contains(RAW_Y_DOWN) && !TextUtils.isEmpty(clickPositionModel.m49857d())) {
            str = str.replace(RAW_Y_DOWN, clickPositionModel.m49857d());
        }
        if (str.contains(RAW_X_UP) && !TextUtils.isEmpty(clickPositionModel.m49851g())) {
            str = str.replace(RAW_X_UP, clickPositionModel.m49851g());
        }
        if (str.contains(RAW_Y_UP) && !TextUtils.isEmpty(clickPositionModel.m49849h())) {
            str = str.replace(RAW_Y_UP, clickPositionModel.m49849h());
        }
        if (str.contains(X_DOWN_DP) && !TextUtils.isEmpty(clickPositionModel.m49863a())) {
            str = str.replace(X_DOWN_DP, px2dip(BeiZiImpl.m49492a().f10139i, clickPositionModel.m49863a()));
        }
        if (str.contains(Y_DOWN_DP) && !TextUtils.isEmpty(clickPositionModel.m49861b())) {
            str = str.replace(Y_DOWN_DP, px2dip(BeiZiImpl.m49492a().f10139i, clickPositionModel.m49861b()));
        }
        if (str.contains(X_UP_DP) && !TextUtils.isEmpty(clickPositionModel.m49855e())) {
            str = str.replace(X_UP_DP, px2dip(BeiZiImpl.m49492a().f10139i, clickPositionModel.m49855e()));
        }
        if (str.contains(Y_UP_DP) && !TextUtils.isEmpty(clickPositionModel.m49853f())) {
            str = str.replace(Y_UP_DP, px2dip(BeiZiImpl.m49492a().f10139i, clickPositionModel.m49853f()));
        }
        if (str.contains(RAW_X_DOWN_DP) && !TextUtils.isEmpty(clickPositionModel.m49859c())) {
            str = str.replace(RAW_X_DOWN_DP, px2dip(BeiZiImpl.m49492a().f10139i, clickPositionModel.m49859c()));
        }
        if (str.contains(RAW_Y_DOWN_DP) && !TextUtils.isEmpty(clickPositionModel.m49857d())) {
            str = str.replace(RAW_Y_DOWN_DP, px2dip(BeiZiImpl.m49492a().f10139i, clickPositionModel.m49857d()));
        }
        if (str.contains(RAW_X_UP_DP) && !TextUtils.isEmpty(clickPositionModel.m49851g())) {
            str = str.replace(RAW_X_UP_DP, px2dip(BeiZiImpl.m49492a().f10139i, clickPositionModel.m49851g()));
        }
        return (!str.contains(RAW_Y_UP_DP) || TextUtils.isEmpty(clickPositionModel.m49849h())) ? str : str.replace(RAW_Y_UP_DP, px2dip(BeiZiImpl.m49492a().f10139i, clickPositionModel.m49849h()));
    }

    public static String replaceToTouchEventUrl(String str, ClickPositionModel clickPositionModel, String str2, String str3, String str4, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i != 2 && i != 5) {
                str = replaceToTouchEventUrl(str, clickPositionModel, str2, str3, str4);
            } else {
                ClickPositionModel clickPositionModel2 = new ClickPositionModel();
                if (str.contains(CLT_TYPE)) {
                    clickPositionModel2.m49862a("0");
                    clickPositionModel2.m49860b("0");
                    clickPositionModel2.m49858c("0");
                    clickPositionModel2.m49856d("0");
                    clickPositionModel2.m49854e("0");
                    clickPositionModel2.m49852f("0");
                    clickPositionModel2.m49850g("0");
                    clickPositionModel2.m49848h("0");
                    str = replaceToTouchEventUrl(str, clickPositionModel2, str2, str3, str4);
                }
                if (str.contains(CLT_TYPE_999)) {
                    clickPositionModel2.m49862a("-999");
                    clickPositionModel2.m49860b("-999");
                    clickPositionModel2.m49858c("-999");
                    clickPositionModel2.m49856d("-999");
                    clickPositionModel2.m49854e("-999");
                    clickPositionModel2.m49852f("-999");
                    clickPositionModel2.m49850g("-999");
                    clickPositionModel2.m49848h("-999");
                    str = replaceToTouchEventUrl(str, clickPositionModel2, str2, str3, str4);
                }
            }
            if (str.contains(CLT_TYPE)) {
                str = str.replace(CLT_TYPE, String.valueOf(i));
            }
            if (str.contains(CLT_TYPE_999)) {
                str = str.replace(CLT_TYPE_999, String.valueOf(i));
            }
            if (str.contains(f10419TS)) {
                str = str.replace(f10419TS, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(E_TS_S)) {
                str = str.replace(E_TS_S, str2);
            }
            if (str.contains(E_TS_E)) {
                str = str.replace(E_TS_E, str3);
            }
            return str.contains(V_D) ? str.replace(V_D, str4) : str;
        }
        throw new IllegalArgumentException("url must no null");
    }
}
