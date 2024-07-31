package com.tencent.open.p568im;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.connect.C12925a;
import com.tencent.connect.auth.C12949c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.utils.C13071m;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.im.IM */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13035IM extends BaseApi {
    public static final String CHAT_TYPE_AIO = "thirdparty2c";
    public static final String CHAT_TYPE_AUDIO_CHAT = "audio_chat";
    public static final String CHAT_TYPE_VIDEO_CHAT = "video_chat";
    public static final int IM_LENGTH_SHORT = -3;
    public static final int IM_SHOULD_DOWNLOAD = -2;
    public static final int IM_SUCCESS = 0;
    public static final int IM_UIN_EMPTY = -1;
    public static final int IM_UIN_NOT_DIGIT = -4;
    public static final int IM_UNKNOWN_TYPE = -5;

    public C13035IM(Context context, C12949c c12949c, QQToken qQToken) {
        super(c12949c, qQToken);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        if (C12925a.m15471a("ImApi", null) || str == null || (!str.equals(CHAT_TYPE_AIO) && !str.equals(CHAT_TYPE_AUDIO_CHAT) && !str.equals(CHAT_TYPE_VIDEO_CHAT))) {
            return -5;
        }
        if (!str.equals(CHAT_TYPE_AUDIO_CHAT)) {
            str.equals(CHAT_TYPE_VIDEO_CHAT);
        }
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        if (str2.length() < 5) {
            return -3;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!Character.isDigit(str2.charAt(i))) {
                return -4;
            }
        }
        if (C13071m.m14935d(activity)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format("mqqapi://im/chat?chat_type=%1$s&uin=%2$s&version=1&src_type=app&open_id=%3$s&app_id=%4$s&app_pkg_name=%5$s", str, str2, C13071m.m14918k(this.f37136c.getOpenId()), C13071m.m14918k(this.f37136c.getAppId()), C13071m.m14918k(str3))));
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtra(Constants.PARAM_PKG_NAME, str3);
            activity.startActivity(intent);
            return 0;
        }
        try {
            new TDialog(activity, "", m15311a(""), null, this.f37136c).show();
            return -2;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public C13035IM(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public C13035IM(QQToken qQToken) {
        super(qQToken);
    }
}
