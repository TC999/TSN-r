package com.bytedance.sdk.openadsdk.n;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class gd {
    public static Bitmap c(String str, Map<String, String> map) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap bitmap = null;
        try {
            mediaMetadataRetriever.setDataSource(str, map);
            long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000;
            if (parseLong > 0) {
                bitmap = mediaMetadataRetriever.getFrameAtTime(parseLong, 3);
            }
        } catch (IllegalArgumentException | RuntimeException unused) {
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused2) {
            }
            throw th;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (RuntimeException unused3) {
            return bitmap;
        }
    }

    public static Bitmap c(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap bitmap = null;
        try {
            mediaMetadataRetriever.setDataSource(str);
            long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000;
            if (parseLong > 0) {
                bitmap = mediaMetadataRetriever.getFrameAtTime(parseLong, 3);
            }
        } catch (IllegalArgumentException | RuntimeException unused) {
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused2) {
            }
            throw th;
        }
        try {
            mediaMetadataRetriever.release();
        } catch (RuntimeException unused3) {
            return bitmap;
        }
    }

    public static boolean c(me meVar) {
        if (ng.p(meVar)) {
            if (fp.c(meVar)) {
                return fp.w(meVar);
            }
            return !me.w(meVar);
        }
        return false;
    }
}
