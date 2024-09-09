package com.hw.videoprocessor;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaMetadataRetriever;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoEffects.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f {
    public static void a(Context context, String str, String str2, @Nullable Integer num, float f4, int i4) throws Exception {
        Integer num2;
        List<File> l4;
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
        int d4 = i.d(str);
        try {
            com.hw.videoprocessor.util.c.t("\u5207\u5272\u89c6\u9891+", new Object[0]);
            l4 = i.l(context, str, file.getAbsolutePath(), i4, 500, Integer.valueOf(d4), f4, 0);
        } catch (MediaCodec.CodecException e4) {
            com.hw.videoprocessor.util.c.g(e4);
            l4 = i.l(context, str, file.getAbsolutePath(), i4, 500, Integer.valueOf(d4), f4, -1);
        }
        com.hw.videoprocessor.util.c.t("\u5207\u5272\u89c6\u9891-", new Object[0]);
        com.hw.videoprocessor.util.c.t("\u5408\u5e76\u89c6\u9891+", new Object[0]);
        i.b(l4, str2, num2, 1);
        com.hw.videoprocessor.util.c.t("\u5408\u5e76\u89c6\u9891-", new Object[0]);
        long currentTimeMillis2 = System.currentTimeMillis();
        com.hw.videoprocessor.util.c.f("\u9b3c\u755c\u5df2\u5b8c\u6210,\u8017\u65f6:" + (((float) (currentTimeMillis2 - currentTimeMillis)) / 1000.0f) + "s", new Object[0]);
    }
}
