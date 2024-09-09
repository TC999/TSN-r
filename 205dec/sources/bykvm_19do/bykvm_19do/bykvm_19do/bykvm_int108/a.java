package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.gdt.BuildConfig;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.TTMediationAdSdk;
import com.bytedance.msdk.api.TTSettingConfigCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: InitChecker.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final TTSettingConfigCallback f619a = new C0025a();

    /* compiled from: InitChecker.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class C0025a implements TTSettingConfigCallback {
        C0025a() {
        }

        @Override // com.bytedance.msdk.api.TTSettingConfigCallback
        public void configLoad() {
            try {
                a.e();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static void c() {
        try {
            if (Logger.isDebug() && TTMediationAdSdk.configLoadSuccess()) {
                e();
            }
        } catch (Throwable unused) {
        }
    }

    private static Map<String, String> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("pangle", "");
        hashMap.put("gdt", "");
        hashMap.put("admob", "");
        hashMap.put("unity", "");
        hashMap.put("baidu", "");
        hashMap.put("sigmob", "");
        hashMap.put("klevin", "");
        hashMap.put("mintegral", "");
        hashMap.put("ks", "");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        Map<String, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.a> c4;
        List<String> a4;
        Context d4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d();
        if (d4 == null || (c4 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.f().c()) == null) {
            return;
        }
        int i4 = d4.getApplicationInfo().targetSdkVersion;
        if ((Build.VERSION.SDK_INT >= 24 || i4 >= 24) && (a4 = a(d4)) != null) {
            for (String str : c4.keySet()) {
                if (!"unity".equals(str)) {
                    if (a4.contains(str)) {
                        Logger.d("TTMediationSDK_InitChecker", "\u5df2\u6309\u8981\u6c42\u63a5\u5165\u4e09\u65b9\u5e7f\u544asdk\u3010" + str + "\u3011");
                    } else {
                        Logger.e("TTMediationSDK_InitChecker", "\u672a\u6309\u8981\u6c42\u63a5\u5165\u4e09\u65b9\u5e7f\u544asdk\u3010" + str + "\u3011\uff0c\u8bf7\u68c0\u67e5\u63a5\u5165\u914d\u7f6e");
                    }
                }
            }
        }
        Logger.d("TTMediationSDK_InitChecker", "\u5f53\u524d\u63a5\u5165\u7684MSDK\u7248\u672c\u662f\uff1a2.9.2.1");
        Map<String, ITTAdapterConfiguration> c5 = b.c();
        Map<String, String> d5 = d();
        if (c5 == null || d5 == null) {
            return;
        }
        for (String str2 : d5.keySet()) {
            try {
                ITTAdapterConfiguration iTTAdapterConfiguration = c5.get(DefaultAdapterClasses.getClassNameByAdnName(str2));
                String str3 = d5.get(str2);
                if (iTTAdapterConfiguration != null && str3 != null) {
                    String networkSdkVersion = iTTAdapterConfiguration.getNetworkSdkVersion();
                    char c6 = '\uffff';
                    switch (str2.hashCode()) {
                        case -1128782217:
                            if (str2.equals("klevin")) {
                                c6 = 6;
                                break;
                            }
                            break;
                        case -995541405:
                            if (str2.equals("pangle")) {
                                c6 = 0;
                                break;
                            }
                            break;
                        case -902468465:
                            if (str2.equals("sigmob")) {
                                c6 = 5;
                                break;
                            }
                            break;
                        case 3432:
                            if (str2.equals("ks")) {
                                c6 = 7;
                                break;
                            }
                            break;
                        case 102199:
                            if (str2.equals("gdt")) {
                                c6 = 4;
                                break;
                            }
                            break;
                        case 92668925:
                            if (str2.equals("admob")) {
                                c6 = 1;
                                break;
                            }
                            break;
                        case 93498907:
                            if (str2.equals("baidu")) {
                                c6 = 2;
                                break;
                            }
                            break;
                        case 111433589:
                            if (str2.equals("unity")) {
                                c6 = 3;
                                break;
                            }
                            break;
                        case 1126045977:
                            if (str2.equals("mintegral")) {
                                c6 = '\b';
                                break;
                            }
                            break;
                    }
                    switch (c6) {
                        case 0:
                            if (a(networkSdkVersion, "4.0.0.0") != 0) {
                                Logger.e("TTMediationSDK_InitChecker", "\u7a7f\u5c71\u7532\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e4.0.0.0\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                break;
                            } else {
                                Logger.d("TTMediationSDK_InitChecker", "\u7a7f\u5c71\u7532\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e4.0.0.0\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                continue;
                            }
                        case 1:
                            if (a(networkSdkVersion, BuildConfig.ADMOB_VERSION_ADAPTER) > 0) {
                                Logger.e("TTMediationSDK_InitChecker", "admod\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42<=" + BuildConfig.ADMOB_VERSION_ADAPTER + "\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                break;
                            } else {
                                Logger.d("TTMediationSDK_InitChecker", "admod\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42<=" + BuildConfig.ADMOB_VERSION_ADAPTER + "\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                continue;
                            }
                        case 2:
                            if (a("9.14", "9.14") != 0) {
                                Logger.e("TTMediationSDK_InitChecker", "\u767e\u5ea6\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e9.14\uff0c\u5f53\u524d\u662f9.14");
                                break;
                            } else {
                                Logger.d("TTMediationSDK_InitChecker", "\u767e\u5ea6\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e9.14\uff0c\u5f53\u524d\u662f9.14");
                                continue;
                            }
                        case 3:
                            if (a(networkSdkVersion, "3.7.5") != 0) {
                                Logger.e("TTMediationSDK_InitChecker", "unity\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42>=3.7.5 && <=\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                break;
                            } else {
                                Logger.d("TTMediationSDK_InitChecker", "unity\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42>=3.7.5 && <=\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                continue;
                            }
                        case 4:
                            if (a(networkSdkVersion, "4.391.1261") != 0) {
                                Logger.e("TTMediationSDK_InitChecker", "gdt\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e4.391.1261\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                break;
                            } else {
                                Logger.d("TTMediationSDK_InitChecker", "gdt\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e4.391.1261\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                continue;
                            }
                        case 5:
                            if (a(networkSdkVersion, "3.3.1") != 0) {
                                Logger.e("TTMediationSDK_InitChecker", "sigmob\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.1\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                break;
                            } else {
                                Logger.d("TTMediationSDK_InitChecker", "sigmob\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.1\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                continue;
                            }
                        case 6:
                            if (a(networkSdkVersion, "2.0.0.23") != 0) {
                                Logger.e("TTMediationSDK_InitChecker", "klevin\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e2.0.0.23\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                break;
                            } else {
                                Logger.d("TTMediationSDK_InitChecker", "klevin\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e2.0.0.23\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                continue;
                            }
                        case 7:
                            if (a(networkSdkVersion, "3.3.13") != 0) {
                                Logger.e("TTMediationSDK_InitChecker", "\u5feb\u624b\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.13\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                break;
                            } else {
                                Logger.d("TTMediationSDK_InitChecker", "\u5feb\u624b\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.13\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                continue;
                            }
                        case '\b':
                            if (!TextUtils.isEmpty(networkSdkVersion) && networkSdkVersion.contains("15.6.17")) {
                                Logger.d("TTMediationSDK_InitChecker", "Mintegral\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e15.6.17\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                break;
                            } else {
                                Logger.e("TTMediationSDK_InitChecker", "Mintegral\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e15.6.17\uff0c\u5f53\u524d\u662f" + networkSdkVersion);
                                continue;
                            }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static int a(String str, String str2) {
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

    public static boolean b(String str, String str2) {
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
                if (a(str2, "2.0.0.23.1") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "klevinAdapter\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e2.0.0.23.1\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "klevinAdapter\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e2.0.0.23.1\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 1:
                if (a(str2, "3.3.1.1") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "sigmobAdapter\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.1.1\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "sigmobAdapter\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.1.1\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 2:
                if (a(str2, "3.3.13.1") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "\u5feb\u624bAdapter\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.13.1\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "\u5feb\u624bAdapter\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.13.1\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 3:
                if (a(str2, "4.391.1261.1") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "gdtAdapter\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e4.391.1261.1\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "gdtAdapter\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e4.391.1261.1\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 4:
                if (a(str2, "17.2.0.8") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "admobAdapter\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42<=17.2.0.8\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "admobAdapter\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42<=17.2.0.8\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 5:
                if (a(str2, "9.14.2") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "\u767e\u5ea6Adapter\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e9.14.2\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "\u767e\u5ea6Adapter\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e9.14.2\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 6:
                if (a(str2, "3.7.5.1") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "unityAdapter\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e3.7.5.1\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "unityAdapter\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e3.7.5.1\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 7:
                if (a(str2, "15.6.17.1") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "MintegralAdapter\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e15.6.17.1\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "MintegralAdapter\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e15.6.17.1\uff0c\u5f53\u524d\u662f" + str2);
                break;
            default:
                return false;
        }
        return true;
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals("baidu") || str.equals("admob")) {
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
            case -995541405:
                if (str.equals("pangle")) {
                    c4 = 1;
                    break;
                }
                break;
            case -902468465:
                if (str.equals("sigmob")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3432:
                if (str.equals("ks")) {
                    c4 = 3;
                    break;
                }
                break;
            case 102199:
                if (str.equals("gdt")) {
                    c4 = 4;
                    break;
                }
                break;
            case 111433589:
                if (str.equals("unity")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1126045977:
                if (str.equals("mintegral")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                if (a(str2, "2.0.0.23") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "klevin\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e2.0.0.23\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "klevin\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e2.0.0.23\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 1:
                if (a(str2, "4.0.0.0") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "\u7a7f\u5c71\u7532\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e4.0.0.0\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "\u7a7f\u5c71\u7532\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e4.0.0.0\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 2:
                if (a(str2, "3.3.1") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "sigmob\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.1\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "sigmob\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.1\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 3:
                if (a(str2, "3.3.13") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "\u5feb\u624b\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.13\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "\u5feb\u624b\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e3.3.13\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 4:
                if (a(str2, "4.391.1261") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "gdt\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e4.391.1261\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "gdt\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e4.391.1261\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 5:
                if (a(str2, "3.7.5") != 0) {
                    Logger.e("TTMediationSDK_InitChecker", "unity\u7248\u672c\u4e0d\u7b26\u5408\uff0c\u8981\u6c42\u7b49\u4e8e3.7.5\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                Logger.d("TTMediationSDK_InitChecker", "unity\u7248\u672c\u6b63\u5e38\uff0c\u8981\u6c42\u7b49\u4e8e3.7.5\uff0c\u5f53\u524d\u662f" + str2);
                break;
            case 6:
                if (!TextUtils.isEmpty(str2) && str2.contains("15.6.17")) {
                    Logger.d("TTMediationSDK_InitChecker", "Mintegral\u7248\u672c\u6b63\u5e38, \u8981\u6c42\u7248\u672c\u7b49\u4e8e15.6.17\uff0c\u5f53\u524d\u662f" + str2);
                    break;
                } else {
                    Logger.e("TTMediationSDK_InitChecker", "Mintegral\u7248\u672c\u4e0d\u7b26\u5408, \u8981\u6c42\u7248\u672c\u7b49\u4e8e15.6.17\uff0c\u5f53\u524d\u662f" + str2);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    private static List<String> a(Context context) {
        List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (queryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        for (ProviderInfo providerInfo : queryContentProviders) {
            String str = providerInfo.name;
            str.hashCode();
            char c4 = '\uffff';
            switch (str.hashCode()) {
                case -2132028139:
                    if (str.equals("com.baidu.mobads.sdk.api.BdFileProvider")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1630533804:
                    if (str.equals("com.mbridge.msdk.foundation.tools.MBFileProvider")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1097984862:
                    if (str.equals("com.sigmob.sdk.SigmobFileProvider")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 8917003:
                    if (str.equals("com.tencent.klevin.utils.FileProvider")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 405711305:
                    if (str.equals("com.google.android.gms.ads.MobileAdsInitProvider")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 980611709:
                    if (str.equals("com.kwad.sdk.api.proxy.app.AdSdkFileProvider")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 1010345138:
                    if (str.equals("com.bytedance.sdk.openadsdk.TTFileProvider")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 1011081416:
                    if (str.equals("com.unity")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 1719438508:
                    if (str.equals("com.qq.e.comm.GDTFileProvider")) {
                        c4 = '\b';
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    arrayList.add("baidu");
                    break;
                case 1:
                    arrayList.add("mintegral");
                    break;
                case 2:
                    arrayList.add("sigmob");
                    break;
                case 3:
                    arrayList.add("klevin");
                    break;
                case 4:
                    arrayList.add("admob");
                    break;
                case 5:
                    arrayList.add("ks");
                    break;
                case 6:
                    arrayList.add("pangle");
                    break;
                case 7:
                    arrayList.add("unity");
                    break;
                case '\b':
                    arrayList.add("gdt");
                    break;
            }
        }
        return arrayList;
    }
}
