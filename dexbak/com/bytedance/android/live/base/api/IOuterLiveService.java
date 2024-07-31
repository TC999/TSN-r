package com.bytedance.android.live.base.api;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface IOuterLiveService extends IOuterLiveRoomService {
    boolean canHandleScheme(Uri uri);

    void enterLiveRoom(Context context, long j, Bundle bundle);

    boolean handleSchema(Context context, Uri uri);

    ILiveOuterPreviewCoverView makePreviewCoverView(Context context, Bundle bundle);
}
