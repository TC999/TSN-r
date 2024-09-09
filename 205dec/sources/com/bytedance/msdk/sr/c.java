package com.bytedance.msdk.sr;

import android.text.TextUtils;
import com.bytedance.msdk.api.sr.gd;
import com.bytedance.msdk.api.sr.ys;
import com.kwad.components.offline.api.BuildConfig;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final ys f28379c = new ys() { // from class: com.bytedance.msdk.sr.c.1
        @Override // com.bytedance.msdk.api.sr.ys
        public void c() {
            try {
                c.sr();
            } finally {
                try {
                } finally {
                }
            }
        }
    };

    public static void c() {
        try {
            if (com.bytedance.msdk.adapter.sr.xv.w() && gd.c()) {
                sr();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void sr() {
        synchronized (c.class) {
            if (com.bytedance.msdk.core.c.getContext() == null) {
                return;
            }
            com.bytedance.msdk.ux.c.c.p().c();
        }
    }

    public static boolean w(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals("pangle")) {
            return true;
        }
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1128782217:
                if (str.equals("klevin")) {
                    c4 = 0;
                    break;
                }
                break;
            case -902468465:
                if (str.equals("sigmob")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3432:
                if (str.equals("ks")) {
                    c4 = 2;
                    break;
                }
                break;
            case 102199:
                if (str.equals("gdt")) {
                    c4 = 3;
                    break;
                }
                break;
            case 92668925:
                if (str.equals("admob")) {
                    c4 = 4;
                    break;
                }
                break;
            case 93498907:
                if (str.equals("baidu")) {
                    c4 = 5;
                    break;
                }
                break;
            case 111433589:
                if (str.equals("unity")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1126045977:
                if (str.equals("mintegral")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                if (sr("2.11.0.3", str2)) {
                    c("klevinAdapter", "2.11.0.3", str2);
                    break;
                } else {
                    w("klevinAdapter", "2.11.0.3", str2);
                    return false;
                }
            case 1:
                if (sr("4.16.0", str2)) {
                    c("sigmobAdapter", "4.16.0", str2);
                    break;
                } else {
                    w("sigmobAdapter", "4.16.0", str2);
                    return false;
                }
            case 2:
                if (sr(BuildConfig.VERSION_NAME, str2)) {
                    c("ksAdapter", BuildConfig.VERSION_NAME, str2);
                    break;
                } else {
                    w("ksAdapter", BuildConfig.VERSION_NAME, str2);
                    return false;
                }
            case 3:
                if (sr("4.570.1440", str2)) {
                    c("gdtAdapter", "4.570.1440", str2);
                    break;
                } else {
                    w("gdtAdapter", "4.570.1440", str2);
                    return false;
                }
            case 4:
                if (sr(com.bytedance.msdk.adapter.gdt.BuildConfig.ADMOB_VERSION_ADAPTER, str2)) {
                    c("admobAdapter", com.bytedance.msdk.adapter.gdt.BuildConfig.ADMOB_VERSION_ADAPTER, str2);
                    break;
                } else {
                    w("admobAdapter", com.bytedance.msdk.adapter.gdt.BuildConfig.ADMOB_VERSION_ADAPTER, str2);
                    return false;
                }
            case 5:
                if (sr("9.35", str2)) {
                    c("baiduAdapter", "9.35", str2);
                    break;
                } else {
                    w("baiduAdapter", "9.35", str2);
                    return false;
                }
            case 6:
                if (sr("4.3.0", str2)) {
                    c("unityAdapter", "4.3.0", str2);
                    break;
                } else {
                    w("unityAdapter", "4.3.0", str2);
                    return false;
                }
            case 7:
                if (sr("16.6.57", str2)) {
                    c("mtgAdapter", "16.6.57", str2);
                    break;
                } else {
                    w("mtgAdapter", "16.6.57", str2);
                    return false;
                }
            default:
                return false;
        }
        return true;
    }

    private static int xv(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str.startsWith("v") || str.startsWith("V")) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith("V")) {
            str2 = str2.substring(1);
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i4 = 0; i4 < min; i4++) {
            if (split[i4].length() != split2[i4].length()) {
                return split[i4].length() > split2[i4].length() ? 1 : -1;
            }
            int compareTo = split[i4].compareTo(split2[i4]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (split.length == split2.length) {
            return 0;
        }
        return split.length > split2.length ? 1 : -1;
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals("baidu") || str.equals("admob") || str.equals("pangle")) {
            return true;
        }
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1128782217:
                if (str.equals("klevin")) {
                    c4 = 0;
                    break;
                }
                break;
            case -902468465:
                if (str.equals("sigmob")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3432:
                if (str.equals("ks")) {
                    c4 = 2;
                    break;
                }
                break;
            case 102199:
                if (str.equals("gdt")) {
                    c4 = 3;
                    break;
                }
                break;
            case 111433589:
                if (str.equals("unity")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1126045977:
                if (str.equals("mintegral")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                if (xv(str2, "2.11.0.3") != 0) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_InitChecker", "klevin\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e2.11.0.3\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_InitChecker", "klevin\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e2.11.0.3\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 1:
                if (xv(str2, "4.16.0") != 0) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_InitChecker", "sigmob\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e4.16.0\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_InitChecker", "sigmob\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e4.16.0\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 2:
                if (xv(str2, BuildConfig.VERSION_NAME) != 0) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_InitChecker", "\u5feb\u624b\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e" + BuildConfig.VERSION_NAME + "\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_InitChecker", "\u5feb\u624b\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e" + BuildConfig.VERSION_NAME + "\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 3:
                if (xv(str2, "4.570.1440") != 0) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_InitChecker", "gdt\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e4.570.1440\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_InitChecker", "gdt\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e4.570.1440\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 4:
                if (xv(str2, "4.3.0") != 0) {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_InitChecker", "unity\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e4.3.0\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_InitChecker", "unity\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e4.3.0\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 5:
                if (!TextUtils.isEmpty(str2) && str2.contains("16.6.57")) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_InitChecker", "Mintegral\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e16.6.57\uff0c\u5f53\u524d\u662f" + str2);
                    break;
                } else {
                    com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_InitChecker", "Mintegral\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e16.6.57\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    private static boolean sr(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0 || str.length() > str2.length()) {
            return false;
        }
        if (str.startsWith("v") || str.startsWith("V")) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith("V")) {
            str2 = str2.substring(1);
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i4 = 0; i4 < split.length; i4++) {
            if (split[i4].length() == split[i4].length() && split[i4].compareTo(split2[i4]) != 0) {
                return false;
            }
        }
        return true;
    }

    private static void c(String str, String str2, String str3) {
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_InitChecker", str + "\u63a5\u5165\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u4e3a\uff1a" + str2 + "\uff0c\u5f53\u524d\u7248\u672c\u4e3a\uff1a" + str3);
    }

    private static void w(String str, String str2, String str3) {
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_InitChecker", str + "\u63a5\u5165\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u4e3a\uff1a" + str2 + ".x\uff0c\u5f53\u524d\u7248\u672c\u4e3a\uff1a" + str3);
    }
}
