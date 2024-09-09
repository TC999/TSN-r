package com.bytedance.msdk.core.p;

import android.text.TextUtils;
import com.bytedance.c.w.b;
import com.bytedance.msdk.f.wv;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    protected final Map<String, String> f28088c = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    protected final wv f28089w;

    public c(String str) {
        this.f28089w = wv.c(str, com.bytedance.msdk.core.c.getContext());
        xv();
    }

    public static String c(int i4) {
        switch (i4) {
            case 1:
                return "banner";
            case 2:
                return "interstitial";
            case 3:
            case 4:
                return "splash";
            case 5:
                return AMPSConstants.AdType.AD_TYPE_NATIVE;
            case 6:
            default:
                return null;
            case 7:
                return "rewardVideo";
            case 8:
                return "fullscreenVideo";
            case 9:
                return "draw";
            case 10:
                return "interstitialFull";
        }
    }

    private void xv(int i4, String str, double d4) {
        if (TextUtils.isEmpty(str) || i4 != 3) {
            return;
        }
        this.f28089w.c(str, d4 + "_" + System.currentTimeMillis());
        c(str);
    }

    protected abstract Map<String, String> c();

    protected abstract JSONObject c(com.bytedance.msdk.core.k.sr srVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i4, String str, int i5, double d4) {
        if (i5 == 1) {
            c(i4, str, d4);
        } else if (i5 == 3) {
            w(i4, str, d4);
        } else if (i5 == 2) {
            xv(i4, str, d4);
        }
    }

    protected abstract void c(String str, int i4, String str2);

    protected abstract void c(String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        Map<String, ?> w3 = this.f28089w.w();
        if (w3 != null) {
            for (Map.Entry<String, ?> entry : w3.entrySet()) {
                if (entry != null) {
                    c(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
            }
        }
    }

    protected abstract boolean w(String str, JSONObject jSONObject, Map<String, Object> map);

    /* JADX INFO: Access modifiers changed from: protected */
    public double c(int i4, String str, int i5) {
        if (i5 == 1) {
            return BigDecimal.valueOf(Double.parseDouble(c(i4, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i5 == 3) {
            return BigDecimal.valueOf(Double.parseDouble(w(i4, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i5 == 2) {
            return BigDecimal.valueOf(Double.parseDouble(xv(i4, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return 0.0d;
    }

    private void w(int i4, String str, double d4) {
        if (TextUtils.isEmpty(str) || i4 != 3) {
            return;
        }
        this.f28089w.c(str, d4 + "_" + System.currentTimeMillis());
        c(str);
    }

    private String xv(int i4, String str) {
        if (!TextUtils.isEmpty(str) && i4 == 3) {
            String w3 = this.f28089w.w(str);
            if (!TextUtils.isEmpty(w3) && !"0".equals(w3)) {
                String[] split = w3.split("_");
                String str2 = split[0];
                String str3 = split[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (str3.matches("[0-9]+")) {
                        try {
                            long parseLong = Long.parseLong(str3);
                            if (com.bytedance.msdk.core.c.w().c(System.currentTimeMillis() - parseLong)) {
                                return str2;
                            }
                            this.f28089w.f(str);
                        } catch (NumberFormatException unused) {
                            this.f28089w.f(str);
                            b.f("\u81ea\u5b9a\u4e49\u4e0a\u62a5 saveTime format exception valueTimestamp " + w3);
                        }
                    } else {
                        this.f28089w.f(str);
                        b.f("\u81ea\u5b9a\u4e49\u4e0a\u62a5 saveTime is not number valueTimestamp " + w3);
                    }
                }
            }
        }
        return "0";
    }

    public void c(double d4, double d5, String str, String str2) {
        if (this.f28089w == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        c(str, "_last_post_cpm_", str2, d4);
        c(str, "_last_bidding_cpm_", str2, d5);
    }

    private String w(int i4, String str) {
        if (!TextUtils.isEmpty(str) && i4 == 3) {
            String w3 = this.f28089w.w(str);
            if (!TextUtils.isEmpty(w3) && !"0".equals(w3)) {
                String[] split = w3.split("_");
                String str2 = split[0];
                String str3 = split[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (com.bytedance.msdk.core.c.w().c(System.currentTimeMillis() - Long.parseLong(str3))) {
                        return str2;
                    }
                    this.f28089w.f(str);
                }
            }
        }
        return "0";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0142 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0147 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double[] c(int r18, double r19, double r21, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.p.c.c(int, double, double, java.lang.String, java.lang.String):double[]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c4 : charArray) {
            sb.append(this.f28088c.get(String.valueOf(c4)));
        }
        return sb.toString();
    }

    protected void xv() {
        this.f28088c.put("0", "a");
        this.f28088c.put("1", "b");
        this.f28088c.put("2", "c");
        this.f28088c.put("3", "d");
        this.f28088c.put("4", "e");
        this.f28088c.put("5", "f");
        this.f28088c.put("6", "g");
        this.f28088c.put("7", "h");
        this.f28088c.put("8", "i");
        this.f28088c.put("9", "j");
        this.f28088c.put(".", "k");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str, String str2, String str3, double d4) {
        String str4 = str + str2;
        this.f28089w.c(str4, str3 + "_" + d4);
    }

    private synchronized void c(int i4, String str, double d4) {
        String str2 = "label_size_" + str;
        int w3 = this.f28089w.w(str2, 0) + 1;
        String c4 = c(str, w3);
        String c5 = c(str, d4);
        c(c4, i4, c5);
        this.f28089w.c(c4, c5);
        this.f28089w.c(str2, w3);
    }

    private String c(int i4, String str) {
        if (TextUtils.isEmpty(str) || i4 != 3) {
            return "0";
        }
        double[] dArr = new double[2];
        Iterator<Map.Entry<String, String>> it = c().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next != null) {
                String value = next.getValue();
                if (!TextUtils.isEmpty(value) && value.contains(str)) {
                    String[] split = value.split("_");
                    String str2 = split[0];
                    String str3 = split[1];
                    String str4 = split[2];
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        if (com.bytedance.msdk.core.c.w().c(System.currentTimeMillis() - Long.parseLong(str4))) {
                            dArr[0] = dArr[0] + 1.0d;
                            dArr[1] = dArr[1] + Double.parseDouble(str3);
                        } else {
                            it.remove();
                            this.f28089w.f(next.getKey());
                            String str5 = "label_size_" + str;
                            wv wvVar = this.f28089w;
                            wvVar.c(str5, wvVar.xv(str5) - 1);
                        }
                    }
                }
            }
        }
        return c(dArr);
    }

    public void c(String str) {
        for (int xv = this.f28089w.xv("label_size_" + str); xv > 0; xv--) {
            try {
                String c4 = c(str, xv);
                this.f28089w.f(c4);
                c().remove(c4);
            } catch (Throwable th) {
                com.bytedance.msdk.adapter.sr.xv.sr("CalculateLabelValueImpl", "clearFromSpByRit,ignore:" + th.toString());
            }
        }
    }

    private String c(String str, int i4) {
        return "cpm_key_" + str + "_" + i4;
    }

    private String c(String str, double d4) {
        return str + "_" + d4 + "_" + System.currentTimeMillis();
    }

    public String c(double[] dArr) {
        if (dArr[0] != 0.0d) {
            return new BigDecimal(dArr[1] / dArr[0]).setScale(2, RoundingMode.HALF_UP).toString();
        }
        return String.valueOf(-1.0d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.bytedance.msdk.core.c.w().gw() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (w(str, jSONObject2, map == null ? new HashMap<>() : map)) {
            try {
                jSONObject.putOpt("label", jSONObject2);
                if (map == null || map.get("cost_time") == null) {
                    return;
                }
                jSONObject.put("uvalueExcTime", map.get("cost_time"));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }
}
