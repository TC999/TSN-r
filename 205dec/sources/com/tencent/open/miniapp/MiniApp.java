package com.tencent.open.miniapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MiniApp extends BaseApi {
    public static final int MINIAPP_CONTEXT_NULL = -6;
    public static final int MINIAPP_ID_EMPTY = -1;
    public static final int MINIAPP_ID_NOT_DIGIT = -4;
    public static final int MINIAPP_SHOULD_DOWNLOAD = -2;
    public static final String MINIAPP_SRC_ID = "21";
    public static final int MINIAPP_SRC_ID_NOT_DIGIT = -3;
    public static final int MINIAPP_SUCCESS = 0;
    public static final String MINIAPP_TYPE_NORMAL = "mini_program_or_game";
    public static final int MINIAPP_UNKNOWN_TYPE = -5;
    public static final String MINIAPP_VERSION_DEVELOP = "develop";
    public static final String MINIAPP_VERSION_RELEASE = "release";
    public static final String MINIAPP_VERSION_TRIAL = "trial";
    public static final int MINIAPP_VERSION_WRONG = -7;
    public static final List<String> OPEN_CONNECT_DEMO_MINI_APP_VERSIONS = Arrays.asList("develop", "trial", "release");

    public MiniApp(Context context, c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3, String str4, String str5) {
        if (a.a("openSDK_LOG.MiniApp", null)) {
            return -5;
        }
        if (activity == null) {
            SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_CONTEXT_NULL : -6");
            return -6;
        } else if (!"mini_program_or_game".equals(str)) {
            SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_UNKNOWN_TYPE : -5");
            return -5;
        } else if (TextUtils.isEmpty(str2)) {
            SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_EMPTY : -1");
            return -1;
        } else {
            for (int i4 = 0; i4 < str2.length(); i4++) {
                if (!Character.isDigit(str2.charAt(i4))) {
                    SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_NOT_DIGIT : -4");
                    return -4;
                }
            }
            String str6 = str4 == null ? "" : str4;
            if (!OPEN_CONNECT_DEMO_MINI_APP_VERSIONS.contains(str5)) {
                SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_VERSION_WRONG : -7");
                return -7;
            } else if (m.e(activity)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage("com.tencent.mobileqq");
                intent.setData(Uri.parse(String.format("mqqapi://connect_miniapp/launch?app_type=%1$s&mini_app_id=%2$s&version=1&src_type=app&app_name=%3$s&app_id=%4$s&src_id=%5$s&mini_app_path=%6$s&mini_app_type=%7$s&open_id=%8$s", str, str2, m.k(k.a((Context) activity)), m.k(this.f51502c.getAppId()), str3, m.k(str6), m.k(str5), m.k(this.f51502c.getOpenId()))));
                intent.putExtra("pkg_name", activity.getPackageName());
                try {
                    try {
                        activity.startActivity(intent);
                        SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SUCCESS : 0");
                        return 0;
                    } catch (RuntimeException e4) {
                        SLog.e("openSDK_LOG.MiniApp", "Show download dialog exception:" + e4.getMessage());
                        SLog.i("openSDK_LOG.MiniApp", "QQ is not installed, Result is MINIAPP_SHOULD_DOWNLOAD : -2");
                        return -2;
                    }
                } catch (ActivityNotFoundException unused) {
                    new TDialog(activity, "", a(""), null, this.f51502c).show();
                    SLog.i("openSDK_LOG.MiniApp", "QQ is not installed, Result is MINIAPP_SHOULD_DOWNLOAD : -2");
                    return -2;
                }
            } else {
                try {
                    new TDialog(activity, "", a(""), null, this.f51502c).show();
                } catch (RuntimeException e5) {
                    SLog.e("openSDK_LOG.MiniApp", "Show download dialog exception:" + e5.getMessage());
                }
                SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SHOULD_DOWNLOAD : -2");
                return -2;
            }
        }
    }

    public MiniApp(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public MiniApp(QQToken qQToken) {
        super(qQToken);
    }
}
