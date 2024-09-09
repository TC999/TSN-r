package com.bytedance.android.live.base.api;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IOuterLiveService extends IOuterLiveRoomService {
    boolean canHandleScheme(Uri uri);

    void enterLiveRoom(Context context, long j4, Bundle bundle);

    boolean handleSchema(Context context, Uri uri);

    ILiveOuterPreviewCoverView makePreviewCoverView(Context context, Bundle bundle);
}
