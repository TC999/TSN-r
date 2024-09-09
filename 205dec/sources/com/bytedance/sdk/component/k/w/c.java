package com.bytedance.sdk.component.k.w;

import android.content.Context;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f29909c;

    public static void c(Context context, String str, int i4, String[] strArr, long[] jArr, VideoEventEngineUploader videoEventEngineUploader) {
        if (f29909c) {
            return;
        }
        try {
            TTVideoEngine.setCacheInfoLists(strArr, jArr);
            TTVideoEngine.setStringValue(0, str);
            TTVideoEngine.setIntValue(1, i4);
            TTVideoEngine.setIntValue(11, 5);
            TTVideoEngine.setIntValue(2, 10);
            TTVideoEngine.setIntValue(3, 10);
            TTVideoEngine.setIntValue(4, 3);
            TTVideoEngine.startDataLoader(context);
            TTVideoEngine.setVideoEventUploader(videoEventEngineUploader);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        f29909c = true;
    }

    public static void c(boolean z3) {
        if (z3) {
            TTVideoEngineLog.turnOn(1, 1);
            AVMDLLog.turnOn(1, 1);
            return;
        }
        TTVideoEngineLog.turnOn(1, 0);
    }

    public static TTVideoEngine c(Context context) {
        TTVideoEngine tTVideoEngine = new TTVideoEngine(context, 0);
        tTVideoEngine.setIntOption(160, 1);
        tTVideoEngine.setIntOption(11, 10);
        tTVideoEngine.setIntOption(12, 10);
        tTVideoEngine.setMaxRetryCount(2);
        tTVideoEngine.setScreenOnWhilePlaying(true);
        return tTVideoEngine;
    }
}
