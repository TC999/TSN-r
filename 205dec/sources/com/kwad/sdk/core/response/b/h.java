package com.kwad.sdk.core.response.b;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.PhotoInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {
    public static String a(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.videoUrl;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.manifest;
    }

    public static String c(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.sdkExtraData;
    }

    public static boolean a(@Nullable Matrix matrix, int i4, int i5, PhotoInfo.VideoInfo videoInfo) {
        if (matrix != null) {
            matrix.reset();
        }
        if (videoInfo == null) {
            return false;
        }
        float f4 = videoInfo.width;
        float f5 = videoInfo.height;
        if (f4 >= f5) {
            return false;
        }
        float f6 = (float) videoInfo.leftRatio;
        float f7 = (float) videoInfo.topRatio;
        float f8 = (float) videoInfo.widthRatio;
        float f9 = (float) videoInfo.heightRatio;
        float f10 = i4;
        float f11 = f10 / f4;
        float f12 = i5;
        float f13 = f12 / f5;
        float f14 = f11 / f13;
        if (Math.abs(f14 - 1.0f) < 0.01d) {
            return false;
        }
        if (f11 > f13) {
            float f15 = f13 / f11;
            float f16 = (f15 + 1.0f) / 2.0f;
            if (f7 < (1.0f - f15) / 2.0f || f7 + f9 > f16) {
                return false;
            }
        } else {
            float f17 = (f14 + 1.0f) / 2.0f;
            if (f6 < (1.0f - f14) / 2.0f || f6 + f8 > f17) {
                return false;
            }
            f11 = f13;
        }
        if (matrix == null) {
            return true;
        }
        matrix.preTranslate((f10 - f4) / 2.0f, (f12 - f5) / 2.0f);
        matrix.preScale(f4 / f10, f5 / f12);
        matrix.postScale(f11, f11, f10 / 2.0f, f12 / 2.0f);
        return true;
    }
}
