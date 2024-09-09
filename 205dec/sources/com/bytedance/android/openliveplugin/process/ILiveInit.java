package com.bytedance.android.openliveplugin.process;

import android.content.Context;
import com.bytedance.android.live.base.api.ILiveHostContextParam;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ILiveInit {
    void initLiveInMain(ILiveHostContextParam iLiveHostContextParam, String str, Boolean bool);

    void initLiveProcess(Context context);

    void registerSubProcessStub();
}
