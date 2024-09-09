package com.tencent.open;

import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class GuildApi extends BaseApi {
    public static final int CREATE_GUILD_ERROR_ALREADY_EXIST = -1;
    public static final int JOIN_GUILD_ERROR_NOT_EXIST = -1;

    public GuildApi(QQToken qQToken) {
        super(qQToken);
    }
}
