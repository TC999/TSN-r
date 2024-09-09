package com.bytedance.android.live.base.api;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.callback.Callback;
import com.bytedance.android.live.base.api.outer.ILiveProvider;
import com.bytedance.android.live.base.api.outer.data.OpenUserInfo;
import com.bytedance.android.live.base.api.push.ILivePush;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IOuterLiveRoomService {
    void addEventListener(IEventListener iEventListener);

    Object callExpandMethod(String str, Object... objArr);

    @Deprecated
    void enterRoomWithDraw();

    void enterRoomWithDraw(Bundle bundle);

    ILiveProvider getLiveProvider();

    ILivePush getPushService();

    OpenUserInfo getUserInfo();

    IBaseHorizontalLiveListView makeFollowListView(Context context, Bundle bundle, ILiveBorderAnimController iLiveBorderAnimController);

    void removeEventListener(IEventListener iEventListener);

    @Deprecated
    void setEventListener(IEventListener iEventListener);

    void setNeedPersonalRecommend(boolean z3);

    void setUseBlackNavigationBar(boolean z3);

    void updateConsumer(int i4, Callback<Object> callback, boolean z3);
}
