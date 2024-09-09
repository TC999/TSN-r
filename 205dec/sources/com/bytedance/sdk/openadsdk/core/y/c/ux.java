package com.bytedance.sdk.openadsdk.core.y.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f35655c = new ArrayList(Arrays.asList("1", "3"));

    private static String c(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 49679470:
                if (str.equals("46000")) {
                    c4 = 0;
                    break;
                }
                break;
            case 49679471:
                if (str.equals("46001")) {
                    c4 = 1;
                    break;
                }
                break;
            case 49679472:
                if (str.equals("46002")) {
                    c4 = 2;
                    break;
                }
                break;
            case 49679473:
                if (str.equals("46003")) {
                    c4 = 3;
                    break;
                }
                break;
            case 49679474:
                if (str.equals("46004")) {
                    c4 = 4;
                    break;
                }
                break;
            case 49679475:
                if (str.equals("46005")) {
                    c4 = 5;
                    break;
                }
                break;
            case 49679476:
                if (str.equals("46006")) {
                    c4 = 6;
                    break;
                }
                break;
            case 49679477:
                if (str.equals("46007")) {
                    c4 = 7;
                    break;
                }
                break;
            case 49679479:
                if (str.equals("46009")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 49679502:
                if (str.equals("46011")) {
                    c4 = '\t';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 2:
            case 4:
            case 7:
                return "1";
            case 1:
            case 6:
            case '\b':
                return "2";
            case 3:
            case 5:
            case '\t':
                return "3";
            default:
                return "0";
        }
    }

    public static String c() {
        String ys = i.ys();
        String ia = i.ia();
        String fp = i.fp();
        String s3 = i.s();
        if (i.t()) {
            if (!TextUtils.isEmpty(ys) && !TextUtils.isEmpty(ia)) {
                if (!TextUtils.isEmpty(fp) && !TextUtils.isEmpty(s3)) {
                    String c4 = c(ys + ia);
                    String c5 = c(fp + s3);
                    List<String> list = f35655c;
                    return (list.contains(c4) && list.contains(c5) && !c5.equals(c4)) ? "6" : list.contains(c4) ? c4 : list.contains(c5) ? c5 : "0";
                }
                return c(ys + ia);
            } else if (TextUtils.isEmpty(fp) || TextUtils.isEmpty(s3)) {
                return "4";
            } else {
                return c(fp + s3);
            }
        }
        return "5";
    }
}
