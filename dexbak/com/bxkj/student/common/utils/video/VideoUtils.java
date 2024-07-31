package com.bxkj.student.common.utils.video;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import com.orhanobut.logger.C11792j;

/* renamed from: com.bxkj.student.common.utils.video.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VideoUtils {
    /* renamed from: a */
    public static Bitmap m42768a(String videoFilePath) {
        if (videoFilePath == null) {
            return null;
        }
        return ThumbnailUtils.createVideoThumbnail(videoFilePath, 2);
    }

    /* renamed from: b */
    public static long m42767b(String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(path);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        if (extractMetadata == null) {
            extractMetadata = "0";
        }
        C11792j.m20470c("duration=" + extractMetadata);
        return Long.parseLong(extractMetadata);
    }
}
