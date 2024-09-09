package com.bytedance.android.live.base.api.outer;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.outer.ILivePreviewLayout;
import com.bytedance.android.live.base.api.outer.data.RoomInfo;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ILiveProvider {
    String getCirculationData();

    ILivePreviewLayout getILivePreviewLayout(ILivePreviewLayout.Builder builder);

    String getIdentity();

    ILiveView getLiveView(Context context, int i4, String str, boolean z3, Bundle bundle);

    @Deprecated
    List<RoomInfo> getRoomInfoList(int i4, int i5, int i6);

    List<RoomInfo> getRoomInfoList(int i4, int i5, int i6, Bundle bundle);

    IStandalonePreviewView makeStandalonePreviewView(Context context, int i4, Bundle bundle);

    void reportShow(int i4, String str, Bundle bundle);

    void startLive(Context context, int i4, String str, Bundle bundle);
}
