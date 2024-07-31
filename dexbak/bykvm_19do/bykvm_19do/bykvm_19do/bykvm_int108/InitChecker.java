package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.AdNetworkConfValue;
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

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class InitChecker {

    /* renamed from: a */
    private static final TTSettingConfigCallback f626a = new C0978a();

    /* compiled from: InitChecker.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C0978a implements TTSettingConfigCallback {
        C0978a() {
        }

        @Override // com.bytedance.msdk.api.TTSettingConfigCallback
        public void configLoad() {
            try {
                InitChecker.m59283e();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: c */
    public static void m59286c() {
        try {
            if (Logger.isDebug() && TTMediationAdSdk.configLoadSuccess()) {
                m59283e();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    private static Map<String, String> m59284d() {
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
    /* renamed from: e */
    public static void m59283e() {
        Map<String, AdNetworkConfValue> m59751c;
        List<String> m59290a;
        Context m59945d = InternalContainer.m59945d();
        if (m59945d == null || (m59751c = InternalContainer.m59943f().m59751c()) == null) {
            return;
        }
        int i = m59945d.getApplicationInfo().targetSdkVersion;
        if ((Build.VERSION.SDK_INT >= 24 || i >= 24) && (m59290a = m59290a(m59945d)) != null) {
            for (String str : m59751c.keySet()) {
                if (!"unity".equals(str)) {
                    if (m59290a.contains(str)) {
                        Logger.m37562d("TTMediationSDK_InitChecker", "已按要求接入三方广告sdk【" + str + "】");
                    } else {
                        Logger.m37557e("TTMediationSDK_InitChecker", "未按要求接入三方广告sdk【" + str + "】，请检查接入配置");
                    }
                }
            }
        }
        Logger.m37562d("TTMediationSDK_InitChecker", "当前接入的MSDK版本是：2.9.2.1");
        Map<String, ITTAdapterConfiguration> m59273c = InitHelper.m59273c();
        Map<String, String> m59284d = m59284d();
        if (m59273c == null || m59284d == null) {
            return;
        }
        for (String str2 : m59284d.keySet()) {
            try {
                ITTAdapterConfiguration iTTAdapterConfiguration = m59273c.get(DefaultAdapterClasses.getClassNameByAdnName(str2));
                String str3 = m59284d.get(str2);
                if (iTTAdapterConfiguration != null && str3 != null) {
                    String networkSdkVersion = iTTAdapterConfiguration.getNetworkSdkVersion();
                    char c = 65535;
                    switch (str2.hashCode()) {
                        case -1128782217:
                            if (str2.equals("klevin")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -995541405:
                            if (str2.equals("pangle")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -902468465:
                            if (str2.equals("sigmob")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 3432:
                            if (str2.equals("ks")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 102199:
                            if (str2.equals("gdt")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 92668925:
                            if (str2.equals("admob")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 93498907:
                            if (str2.equals("baidu")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 111433589:
                            if (str2.equals("unity")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 1126045977:
                            if (str2.equals("mintegral")) {
                                c = '\b';
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            if (m59289a(networkSdkVersion, "4.0.0.0") != 0) {
                                Logger.m37557e("TTMediationSDK_InitChecker", "穿山甲版本不符合，要求等于4.0.0.0，当前是" + networkSdkVersion);
                                break;
                            } else {
                                Logger.m37562d("TTMediationSDK_InitChecker", "穿山甲版本正常，要求等于4.0.0.0，当前是" + networkSdkVersion);
                                continue;
                            }
                        case 1:
                            if (m59289a(networkSdkVersion, BuildConfig.ADMOB_VERSION_ADAPTER) > 0) {
                                Logger.m37557e("TTMediationSDK_InitChecker", "admod版本不符合，要求<=" + BuildConfig.ADMOB_VERSION_ADAPTER + "，当前是" + networkSdkVersion);
                                break;
                            } else {
                                Logger.m37562d("TTMediationSDK_InitChecker", "admod版本正常，要求<=" + BuildConfig.ADMOB_VERSION_ADAPTER + "，当前是" + networkSdkVersion);
                                continue;
                            }
                        case 2:
                            if (m59289a("9.14", "9.14") != 0) {
                                Logger.m37557e("TTMediationSDK_InitChecker", "百度版本不符合，要求等于9.14，当前是9.14");
                                break;
                            } else {
                                Logger.m37562d("TTMediationSDK_InitChecker", "百度版本正常，要求等于9.14，当前是9.14");
                                continue;
                            }
                        case 3:
                            if (m59289a(networkSdkVersion, "3.7.5") != 0) {
                                Logger.m37557e("TTMediationSDK_InitChecker", "unity版本不符合，要求>=3.7.5 && <=，当前是" + networkSdkVersion);
                                break;
                            } else {
                                Logger.m37562d("TTMediationSDK_InitChecker", "unity版本正常，要求>=3.7.5 && <=，当前是" + networkSdkVersion);
                                continue;
                            }
                        case 4:
                            if (m59289a(networkSdkVersion, "4.391.1261") != 0) {
                                Logger.m37557e("TTMediationSDK_InitChecker", "gdt版本不符合，要求等于4.391.1261，当前是" + networkSdkVersion);
                                break;
                            } else {
                                Logger.m37562d("TTMediationSDK_InitChecker", "gdt版本正常，要求等于4.391.1261，当前是" + networkSdkVersion);
                                continue;
                            }
                        case 5:
                            if (m59289a(networkSdkVersion, "3.3.1") != 0) {
                                Logger.m37557e("TTMediationSDK_InitChecker", "sigmob版本不符合, 要求版本等于3.3.1，当前是" + networkSdkVersion);
                                break;
                            } else {
                                Logger.m37562d("TTMediationSDK_InitChecker", "sigmob版本正常, 要求版本等于3.3.1，当前是" + networkSdkVersion);
                                continue;
                            }
                        case 6:
                            if (m59289a(networkSdkVersion, "2.0.0.23") != 0) {
                                Logger.m37557e("TTMediationSDK_InitChecker", "klevin版本不符合, 要求版本等于2.0.0.23，当前是" + networkSdkVersion);
                                break;
                            } else {
                                Logger.m37562d("TTMediationSDK_InitChecker", "klevin版本正常, 要求版本等于2.0.0.23，当前是" + networkSdkVersion);
                                continue;
                            }
                        case 7:
                            if (m59289a(networkSdkVersion, "3.3.13") != 0) {
                                Logger.m37557e("TTMediationSDK_InitChecker", "快手版本不符合, 要求版本等于3.3.13，当前是" + networkSdkVersion);
                                break;
                            } else {
                                Logger.m37562d("TTMediationSDK_InitChecker", "快手版本正常, 要求版本等于3.3.13，当前是" + networkSdkVersion);
                                continue;
                            }
                        case '\b':
                            if (!TextUtils.isEmpty(networkSdkVersion) && networkSdkVersion.contains("15.6.17")) {
                                Logger.m37562d("TTMediationSDK_InitChecker", "Mintegral版本正常, 要求版本等于15.6.17，当前是" + networkSdkVersion);
                                break;
                            } else {
                                Logger.m37557e("TTMediationSDK_InitChecker", "Mintegral版本不符合, 要求版本等于15.6.17，当前是" + networkSdkVersion);
                                continue;
                            }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static int m59289a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str2 = str2.substring(1);
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i = 0; i < min; i++) {
            if (split[i].length() != split2[i].length()) {
                return split[i].length() > split2[i].length() ? 1 : -1;
            }
            int compareTo = split[i].compareTo(split2[i]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (split.length == split2.length) {
            return 0;
        }
        return split.length > split2.length ? 1 : -1;
    }

    /* renamed from: b */
    public static boolean m59287b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals("pangle")) {
            return true;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1128782217:
                if (str.equals("klevin")) {
                    c = 0;
                    break;
                }
                break;
            case -902468465:
                if (str.equals("sigmob")) {
                    c = 1;
                    break;
                }
                break;
            case 3432:
                if (str.equals("ks")) {
                    c = 2;
                    break;
                }
                break;
            case 102199:
                if (str.equals("gdt")) {
                    c = 3;
                    break;
                }
                break;
            case 92668925:
                if (str.equals("admob")) {
                    c = 4;
                    break;
                }
                break;
            case 93498907:
                if (str.equals("baidu")) {
                    c = 5;
                    break;
                }
                break;
            case 111433589:
                if (str.equals("unity")) {
                    c = 6;
                    break;
                }
                break;
            case 1126045977:
                if (str.equals("mintegral")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (m59289a(str2, "2.0.0.23.1") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "klevinAdapter版本不符合, 要求版本等于2.0.0.23.1，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "klevinAdapter版本正常, 要求版本等于2.0.0.23.1，当前是" + str2);
                break;
            case 1:
                if (m59289a(str2, "3.3.1.1") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "sigmobAdapter版本不符合, 要求版本等于3.3.1.1，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "sigmobAdapter版本正常, 要求版本等于3.3.1.1，当前是" + str2);
                break;
            case 2:
                if (m59289a(str2, "3.3.13.1") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "快手Adapter版本不符合, 要求版本等于3.3.13.1，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "快手Adapter版本正常, 要求版本等于3.3.13.1，当前是" + str2);
                break;
            case 3:
                if (m59289a(str2, "4.391.1261.1") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "gdtAdapter版本不符合，要求等于4.391.1261.1，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "gdtAdapter版本正常，要求等于4.391.1261.1，当前是" + str2);
                break;
            case 4:
                if (m59289a(str2, "17.2.0.8") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "admobAdapter版本不符合，要求<=17.2.0.8，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "admobAdapter版本正常，要求<=17.2.0.8，当前是" + str2);
                break;
            case 5:
                if (m59289a(str2, "9.14.2") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "百度Adapter版本不符合，要求等于9.14.2，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "百度Adapter版本正常，要求等于9.14.2，当前是" + str2);
                break;
            case 6:
                if (m59289a(str2, "3.7.5.1") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "unityAdapter版本不符合，要求等于3.7.5.1，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "unityAdapter版本正常，要求等于3.7.5.1，当前是" + str2);
                break;
            case 7:
                if (m59289a(str2, "15.6.17.1") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "MintegralAdapter版本不符合, 要求版本等于15.6.17.1，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "MintegralAdapter版本正常, 要求版本等于15.6.17.1，当前是" + str2);
                break;
            default:
                return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m59285c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals("baidu") || str.equals("admob")) {
            return true;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1128782217:
                if (str.equals("klevin")) {
                    c = 0;
                    break;
                }
                break;
            case -995541405:
                if (str.equals("pangle")) {
                    c = 1;
                    break;
                }
                break;
            case -902468465:
                if (str.equals("sigmob")) {
                    c = 2;
                    break;
                }
                break;
            case 3432:
                if (str.equals("ks")) {
                    c = 3;
                    break;
                }
                break;
            case 102199:
                if (str.equals("gdt")) {
                    c = 4;
                    break;
                }
                break;
            case 111433589:
                if (str.equals("unity")) {
                    c = 5;
                    break;
                }
                break;
            case 1126045977:
                if (str.equals("mintegral")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (m59289a(str2, "2.0.0.23") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "klevin版本不符合, 要求版本等于2.0.0.23，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "klevin版本正常, 要求版本等于2.0.0.23，当前是" + str2);
                break;
            case 1:
                if (m59289a(str2, "4.0.0.0") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "穿山甲版本不符合，要求等于4.0.0.0，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "穿山甲版本正常，要求等于4.0.0.0，当前是" + str2);
                break;
            case 2:
                if (m59289a(str2, "3.3.1") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "sigmob版本不符合, 要求版本等于3.3.1，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "sigmob版本正常, 要求版本等于3.3.1，当前是" + str2);
                break;
            case 3:
                if (m59289a(str2, "3.3.13") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "快手版本不符合, 要求版本等于3.3.13，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "快手版本正常, 要求版本等于3.3.13，当前是" + str2);
                break;
            case 4:
                if (m59289a(str2, "4.391.1261") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "gdt版本不符合，要求等于4.391.1261，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "gdt版本正常，要求等于4.391.1261，当前是" + str2);
                break;
            case 5:
                if (m59289a(str2, "3.7.5") != 0) {
                    Logger.m37557e("TTMediationSDK_InitChecker", "unity版本不符合，要求等于3.7.5，当前是" + str2);
                    return false;
                }
                Logger.m37562d("TTMediationSDK_InitChecker", "unity版本正常，要求等于3.7.5，当前是" + str2);
                break;
            case 6:
                if (!TextUtils.isEmpty(str2) && str2.contains("15.6.17")) {
                    Logger.m37562d("TTMediationSDK_InitChecker", "Mintegral版本正常, 要求版本等于15.6.17，当前是" + str2);
                    break;
                } else {
                    Logger.m37557e("TTMediationSDK_InitChecker", "Mintegral版本不符合, 要求版本等于15.6.17，当前是" + str2);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    /* renamed from: a */
    private static List<String> m59290a(Context context) {
        List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (queryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        for (ProviderInfo providerInfo : queryContentProviders) {
            String str = providerInfo.name;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -2132028139:
                    if (str.equals("com.baidu.mobads.sdk.api.BdFileProvider")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1630533804:
                    if (str.equals("com.mbridge.msdk.foundation.tools.MBFileProvider")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1097984862:
                    if (str.equals("com.sigmob.sdk.SigmobFileProvider")) {
                        c = 2;
                        break;
                    }
                    break;
                case 8917003:
                    if (str.equals("com.tencent.klevin.utils.FileProvider")) {
                        c = 3;
                        break;
                    }
                    break;
                case 405711305:
                    if (str.equals("com.google.android.gms.ads.MobileAdsInitProvider")) {
                        c = 4;
                        break;
                    }
                    break;
                case 980611709:
                    if (str.equals("com.kwad.sdk.api.proxy.app.AdSdkFileProvider")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1010345138:
                    if (str.equals("com.bytedance.sdk.openadsdk.TTFileProvider")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1011081416:
                    if (str.equals("com.unity")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1719438508:
                    if (str.equals("com.qq.e.comm.GDTFileProvider")) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
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
