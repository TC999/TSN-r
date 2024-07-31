package com.tencent.connect;

import android.content.Context;
import com.tencent.connect.auth.C12949c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UserInfo extends BaseApi {
    public static final String GRAPH_OPEN_ID = "oauth2.0/m_me";

    public UserInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void getOpenId(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.f37136c, C13061g.m15027a(), GRAPH_OPEN_ID, m15318a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void getUserInfo(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.f37136c, C13061g.m15027a(), "user/get_simple_userinfo", m15318a(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public UserInfo(Context context, C12949c c12949c, QQToken qQToken) {
        super(c12949c, qQToken);
    }
}
