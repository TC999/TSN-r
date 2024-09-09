package xyz.adscope.ad.control.action.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import xyz.adscope.ad.constants.ConstantConfig;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.Base64Util;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class MarketTools {
    private static final String ANZHI_PACKAGE_NAME = "com.goapk.market";
    private static final String BAIDU_PACKAGE_NAME = "com.baidu.appsearch";
    private static final String GOOGLE_BRAND = "GOOGLE";
    private static final String GOOGLE_PACKAGE_NAME = "com.android.vending";
    private static final String HONOR_BRAND = "HONOR";
    private static final String HTC_BRAND = "HTC";
    private static final String HUAWEI_BRAND = "HUAWEI";
    private static final String HUAWEI_PACKAGE_NAME = "com.huawei.appmarket";
    private static final String LENOVO_BRAND = "LENOVO";
    private static final String LIANXIANG_PACKAGE_NAME = "com.lenovo.leos.appstore";
    private static final String MEITU_BRAND = "MEITU";
    private static final String MEITU_PACKAGE_NAME = "com.android.mobile.appstore";
    private static final String MEIZU_BRAND = "MEIZU";
    private static final String MEIZU_PACKAGE_NAME = "com.meizu.mstore";
    private static final String NIUBIA_BRAND = "NUBIA";
    private static final String NIUBIA_PACKAGE_NAME = "com.nubia.neostore";
    private static final String ONE_PLUS_BRAND = "ONEPLUS";
    private static final String OPPO_BRAND = "OPPO";
    private static final String OPPO_PACKAGE_NAME = "com.oppo.market";
    private static final String PPZHUSHOU_PACKAGE_NAME = "com.pp.assistant";
    private static final String QH360_BRAND = "360";
    private static final String QH360_PACKAGE_NAME = "com.qihoo.appstore";
    private static final String REDMI_BRAND = "REDMI";
    private static final String SCHEMA_URL_DINGDING = "com.alibaba.android.rimet";
    private static final String SONY_BRAND = "SONY";
    private static final String SUONI_PACKAGE_NAME = "com.android.vending";
    private static final String TENCENT_PACKAGE_NAME = "com.tencent.android.qqdownloader";
    private static final String VIVO_BRAND = "VIVO";
    private static final String VIVO_PACKAGE_NAME = "com.bbk.appstore";
    private static final String WANDOUJIA_PACKAGE_NAME = "com.wandoujia.phonenix2";
    private static final String XIAOLAJIAO_BRAND = "XIAOLAJIAO";
    private static final String XIAOMI_BRAND = "XIAOMI";
    private static final String XIAOMI_PACKAGE_NAME = "com.xiaomi.market";
    private static final String ZHUOYI_PACKAGE_NAME = "com.zhuoyi.market";
    private static final String ZTE_BRAND = "ZTE";
    private static final String ZTE_PACKAGE_NAME = "zte.com.market";
    private static final String ZUK_BRAND = "ZUK";
    private static final String schemaUrl = "market://details?id=";

    public static String getBrandName(String str) {
        return str.equals(HUAWEI_BRAND) ? HUAWEI_PACKAGE_NAME : str.equals("OPPO") ? OPPO_PACKAGE_NAME : str.equals(VIVO_BRAND) ? VIVO_PACKAGE_NAME : (str.equals(XIAOMI_BRAND) || str.equals(REDMI_BRAND)) ? XIAOMI_PACKAGE_NAME : str.equals(LENOVO_BRAND) ? LIANXIANG_PACKAGE_NAME : str.equals(QH360_BRAND) ? QH360_PACKAGE_NAME : str.equals(MEIZU_BRAND) ? MEIZU_PACKAGE_NAME : str.equals(HONOR_BRAND) ? HUAWEI_PACKAGE_NAME : str.equals(XIAOLAJIAO_BRAND) ? ZHUOYI_PACKAGE_NAME : str.equals(ZTE_BRAND) ? ZTE_PACKAGE_NAME : str.equals(NIUBIA_BRAND) ? NIUBIA_PACKAGE_NAME : str.equals(ONE_PLUS_BRAND) ? OPPO_PACKAGE_NAME : str.equals(MEITU_BRAND) ? MEITU_PACKAGE_NAME : (str.equals(SONY_BRAND) || str.equals(GOOGLE_BRAND)) ? "com.android.vending" : "";
    }

    private static String getDeviceBrand() {
        String str = Build.BRAND;
        return str == null ? "" : str;
    }

    public static boolean isCheckMarket(String str, Context context) {
        return isInstalled(str, context);
    }

    public static boolean isInstalled(String str, Context context) {
        if (str.isEmpty()) {
            return false;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            LogUtil.i("", "");
        }
        return packageInfo != null;
    }

    public static void openMarket(Context context, String str, String str2) {
        try {
            LogUtil.e("MarketTools", "schemaUrl market://details?id=");
            LogUtil.e("MarketTools", "marketPackageName " + str2);
            LogUtil.e("MarketTools", "mPackageName " + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            intent.setPackage(str2);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            LogUtil.e("MarketTools", "openMarket \u8981\u8df3\u8f6c\u7684\u5e94\u7528\u5e02\u573a\u4e0d\u5b58\u5728!");
        } catch (Exception e4) {
            LogUtil.e("MarketTools", "openMarket \u5176\u4ed6\u9519\u8bef\uff1a" + e4);
        }
    }

    public static boolean startGooglePlay(Context context, String str) {
        if (Boolean.valueOf(isCheckMarket("com.android.vending", context)).booleanValue()) {
            startMarket(context, str, "com.android.vending");
            return true;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        String decode = Base64Util.decode(ConstantConfig.GOOGLE_PLAY_MARKET_ADDRESS);
        if (TextUtils.isEmpty(decode)) {
            return false;
        }
        intent.setData(Uri.parse(decode + str));
        context.startActivity(intent);
        return false;
    }

    public static void startMarket(Context context) {
        startMarket(context, context.getPackageName());
    }

    public static boolean startMarket(Context context, String str) {
        try {
            String upperCase = getDeviceBrand().toUpperCase();
            LogUtil.e("MarketTools", "\u8bfb\u53d6\u5230\u624b\u673a\u5382\u5546~~ brandName : " + upperCase);
            if (TextUtils.isEmpty(upperCase)) {
                LogUtil.e("MarketTools", "\u6ca1\u6709\u8bfb\u53d6\u5230\u624b\u673a\u5382\u5546~~");
                return false;
            }
            String brandName = getBrandName(upperCase);
            LogUtil.e("MarketTools", "\u8bfb\u53d6\u5230\u624b\u673a\u5382\u5546~~ marketPackageName : " + brandName);
            if (brandName.isEmpty()) {
                if (isCheckMarket(BAIDU_PACKAGE_NAME, context)) {
                    startMarket(context, str, BAIDU_PACKAGE_NAME);
                    return true;
                } else if (isCheckMarket(TENCENT_PACKAGE_NAME, context)) {
                    startMarket(context, str, TENCENT_PACKAGE_NAME);
                    return true;
                }
            }
            startMarket(context, str, brandName);
            return true;
        } catch (ActivityNotFoundException unused) {
            LogUtil.e("MarketTools", "startMarket \u8981\u8df3\u8f6c\u7684\u5e94\u7528\u5e02\u573a\u4e0d\u5b58\u5728!");
            return false;
        } catch (Exception e4) {
            LogUtil.e("MarketTools", "startMarket \u5176\u4ed6\u9519\u8bef\uff1a" + e4);
            return false;
        }
    }

    public static void startMarket(Context context, String str, String str2) {
        try {
            openMarket(context, str, str2);
        } catch (ActivityNotFoundException unused) {
            LogUtil.e("MarketTools", "\u8981\u8df3\u8f6c\u7684\u5e94\u7528\u5e02\u573a\u4e0d\u5b58\u5728!");
        } catch (Exception e4) {
            LogUtil.e("MarketTools", "\u5176\u4ed6\u9519\u8bef\uff1a" + e4);
        }
    }
}
