package com.umeng.socialize;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UmengTool {
    public static void checkAlipay(Context context) {
        String packageName = context.getPackageName();
        if (!UMUtils.checkPath(packageName + ".apshare.ShareEntryActivity")) {
            SLog.E(UmengText.CHECK.ALIPAYERROR);
        } else {
            SLog.E(UmengText.CHECK.ALIPAYSUCCESS);
        }
    }

    @TargetApi(9)
    public static String checkFBByself(Context context) {
        if (!UMUtils.checkAndroidManifest(context, "com.umeng.facebook.FacebookActivity")) {
            return UmengText.FACEBOOK.NOFACEBOOKACTIVITY;
        }
        if (!UMUtils.checkMetaData(context, "com.facebook.sdk.ApplicationId")) {
            return UmengText.FACEBOOK.NOMETA;
        }
        if (!UMUtils.checkResource(context, "facebook_app_id", "string")) {
            return UmengText.FACEBOOK.ERRORMETA;
        }
        return UmengText.CHECK.checkSuccess(UMUtils.getAppHashKey(context), ContextUtil.getPackageName());
    }

    public static void checkFacebook(Context context) {
        showDialog(context, checkFBByself(context));
    }

    public static String checkKakao(Context context) {
        if (TextUtils.isEmpty(context.getPackageName())) {
            return "\u5305\u540d\u4e3a\u7a7a";
        }
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            return "kakao \u914d\u7f6e\u6b63\u786e\uff0c\u8bf7\u68c0\u67e5kakao\u540e\u53f0\u7b7e\u540d:" + UMUtils.getAppHashKey(context);
        } catch (PackageManager.NameNotFoundException unused) {
            return "\u7b7e\u540d\u83b7\u53d6\u5931\u8d25";
        }
    }

    public static String checkLinkin(Context context) {
        if (TextUtils.isEmpty(context.getPackageName())) {
            return "\u5305\u540d\u4e3a\u7a7a";
        }
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            return "\u9886\u82f1 \u914d\u7f6e\u6b63\u786e\uff0c\u8bf7\u68c0\u67e5\u9886\u82f1\u540e\u53f0\u7b7e\u540d:" + UMUtils.getAppHashKey(context);
        } catch (PackageManager.NameNotFoundException unused) {
            return "\u7b7e\u540d\u83b7\u53d6\u5931\u8d25";
        }
    }

    public static void checkQQ(Context context) {
        showDialog(context, checkQQByself(context));
    }

    public static String checkQQByself(Context context) {
        if (!UMUtils.checkAndroidManifest(context, "com.tencent.tauth.AuthActivity")) {
            return UmengText.QQ.getError("com.tencent.tauth.AuthActivity");
        }
        if (UMUtils.checkAndroidManifest(context, "com.tencent.connect.common.AssistActivity")) {
            return !UMUtils.checkIntentFilterData(context, ((PlatformConfig.APPIDPlatform) PlatformConfig.getPlatform(SHARE_MEDIA.QQ)).appId) ? UmengText.QQ.ERRORDATA : "qq\u914d\u7f6e\u6b63\u786e";
        }
        return UmengText.QQ.getError("com.tencent.connect.common.AssistActivity");
    }

    public static void checkSina(Context context) {
        showDialog(context, checkSinaBySelf(context));
    }

    public static String checkSinaBySelf(Context context) {
        return UmengText.CHECK.checkSuccess(UMUtils.getAppMD5Signature(context).toLowerCase(), context.getPackageName());
    }

    public static void checkVK(Context context) {
        showDialog(context, checkVKByself(context));
    }

    public static String checkVKByself(Context context) {
        String appSHA1Key = UMUtils.getAppSHA1Key(context);
        return "\u4f60\u4f7f\u7528\u7684\u7b7e\u540d\uff1a" + appSHA1Key.replace(":", "");
    }

    public static void checkWx(Context context) {
        showDialog(context, checkWxBySelf(context));
    }

    public static String checkWxBySelf(Context context) {
        String packageName = context.getPackageName();
        String str = packageName + ".wxapi.WXEntryActivity";
        if (!UMUtils.checkPath(str)) {
            return UmengText.WX.WX_ERRORACTIVITY;
        }
        String appMD5Signature = UMUtils.getAppMD5Signature(context);
        if (UMUtils.checkAndroidManifest(context, str)) {
            return UmengText.CHECK.checkSuccess(appMD5Signature.toLowerCase(), packageName);
        }
        return UmengText.WX.WX_ERRORMANIFEST;
    }

    public static void getSignature(Context context) {
        showDialog(context, "\u5305\u540d\uff1a" + ContextUtil.getPackageName() + "\n\u7b7e\u540d:" + UMUtils.getAppMD5Signature(context) + "\nfacebook keyhash:" + UMUtils.getAppHashKey(context));
    }

    public static String getStrRedicrectUrl() {
        return ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(SHARE_MEDIA.SINA)).redirectUrl;
    }

    public static void showDialog(Context context, String str) {
        new AlertDialog.Builder(context).setTitle("\u53cb\u76dfDebug\u6a21\u5f0f\u81ea\u68c0").setMessage(str).setPositiveButton("\u5173\u95ed", (DialogInterface.OnClickListener) null).show();
    }
}
