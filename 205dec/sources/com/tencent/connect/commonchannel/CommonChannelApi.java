package com.tencent.connect.commonchannel;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CommonChannelApi extends BaseApi {
    public static final String SCHEME_HEADER = "mqqapi://open_connect/common_channel";

    public CommonChannelApi(c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    private boolean a(Bundle bundle) {
        return bundle != null && bundle.containsKey("src_id") && bundle.containsKey("opensdk_ext_data");
    }

    public int launchQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        if (iUiListener == null) {
            return -5;
        }
        if (a.a("UniversalApi", iUiListener)) {
            return -6;
        }
        if (!a(bundle)) {
            iUiListener.onError(new UiError(-5, "\u4f20\u5165\u53c2\u6570\u6709\u8bef!", "\u4f20\u5165\u53c2\u6570\u6709\u8bef!"));
            return -5;
        }
        StringBuilder sb = new StringBuilder("mqqapi://open_connect/common_channel");
        a(sb, activity);
        String string = bundle.getString("opensdk_ext_data");
        a(sb, "exsvr_userinfo", m.k(string));
        a(sb, "opensdk_ext_data", m.k(string));
        a(sb, "src_id", String.valueOf(bundle.getInt("src_id", 0)));
        Intent intent = new Intent();
        intent.setData(Uri.parse(sb.toString()));
        intent.setPackage("com.tencent.mobileqq");
        intent.putExtra("for_result", true);
        intent.putExtra("pkg_name", activity.getPackageName());
        intent.setFlags(335544320);
        UIListenerManager.getInstance().setListenerWithRequestcode(10114, iUiListener);
        a(activity, 10114, intent, false);
        return 0;
    }

    public CommonChannelApi(QQToken qQToken) {
        super(qQToken);
    }
}
