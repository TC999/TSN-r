package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UnionInfo extends BaseApi {
    public static final String URL_GET_UNION_ID = "https://openmobile.qq.com/oauth2.0/me";

    public UnionInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void getUnionId(IUiListener iUiListener) {
        Bundle m15318a = m15318a();
        m15318a.putString("unionid", "1");
        HttpUtils.requestAsync(this.f37136c, C13061g.m15027a(), URL_GET_UNION_ID, m15318a, "GET", new BaseApi.TempRequestListener(iUiListener));
    }
}
