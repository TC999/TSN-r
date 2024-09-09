package com.bxkj.student.common.utils.video;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import com.orhanobut.logger.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: VideoUtils.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class h {
    public static Bitmap a(String videoFilePath) {
        if (videoFilePath == null) {
            return null;
        }
        return ThumbnailUtils.createVideoThumbnail(videoFilePath, 2);
    }

    public static long b(String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(path);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        if (extractMetadata == null) {
            extractMetadata = "0";
        }
        j.c("duration=" + extractMetadata);
        return Long.parseLong(extractMetadata);
    }
}
