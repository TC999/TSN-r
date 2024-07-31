package com.p201hw.videoprocessor;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaMetadataRetriever;
import androidx.annotation.Nullable;
import com.p201hw.videoprocessor.util.CL;
import java.io.File;
import java.util.List;

/* renamed from: com.hw.videoprocessor.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoEffects {
    /* renamed from: a */
    public static void m35042a(Context context, String str, String str2, @Nullable Integer num, float f, int i) throws Exception {
        Integer num2;
        List<File> m34985l;
        long currentTimeMillis = System.currentTimeMillis();
        File cacheDir = context.getCacheDir();
        File file = new File(cacheDir, "kichiku_" + System.currentTimeMillis());
        file.mkdir();
        if (num == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            Integer valueOf = Integer.valueOf(Integer.parseInt(mediaMetadataRetriever.extractMetadata(20)));
            mediaMetadataRetriever.release();
            num2 = valueOf;
        } else {
            num2 = num;
        }
        int m34993d = VideoUtil.m34993d(str);
        try {
            CL.m34882t("切割视频+", new Object[0]);
            m34985l = VideoUtil.m34985l(context, str, file.getAbsolutePath(), i, 500, Integer.valueOf(m34993d), f, 0);
        } catch (MediaCodec.CodecException e) {
            CL.m34895g(e);
            m34985l = VideoUtil.m34985l(context, str, file.getAbsolutePath(), i, 500, Integer.valueOf(m34993d), f, -1);
        }
        CL.m34882t("切割视频-", new Object[0]);
        CL.m34882t("合并视频+", new Object[0]);
        VideoUtil.m34995b(m34985l, str2, num2, 1);
        CL.m34882t("合并视频-", new Object[0]);
        long currentTimeMillis2 = System.currentTimeMillis();
        CL.m34896f("鬼畜已完成,耗时:" + (((float) (currentTimeMillis2 - currentTimeMillis)) / 1000.0f) + "s", new Object[0]);
    }
}
