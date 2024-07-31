package com.bytedance.android.openliveplugin.process;

import android.content.Context;
import com.bytedance.android.live.base.api.ILiveHostContextParam;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface ILiveInit {
    void initLiveInMain(ILiveHostContextParam iLiveHostContextParam, String str, Boolean bool);

    void initLiveProcess(Context context);

    void registerSubProcessStub();
}
