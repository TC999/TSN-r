package com.kwad.sdk.core.response.p409b;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.PhotoInfo;

/* renamed from: com.kwad.sdk.core.response.b.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10490h {
    /* renamed from: a */
    public static String m25612a(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.videoUrl;
    }

    /* renamed from: b */
    public static String m25611b(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.manifest;
    }

    /* renamed from: c */
    public static String m25610c(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.sdkExtraData;
    }

    /* renamed from: a */
    public static boolean m25613a(@Nullable Matrix matrix, int i, int i2, PhotoInfo.VideoInfo videoInfo) {
        if (matrix != null) {
            matrix.reset();
        }
        if (videoInfo == null) {
            return false;
        }
        float f = videoInfo.width;
        float f2 = videoInfo.height;
        if (f >= f2) {
            return false;
        }
        float f3 = (float) videoInfo.leftRatio;
        float f4 = (float) videoInfo.topRatio;
        float f5 = (float) videoInfo.widthRatio;
        float f6 = (float) videoInfo.heightRatio;
        float f7 = i;
        float f8 = f7 / f;
        float f9 = i2;
        float f10 = f9 / f2;
        float f11 = f8 / f10;
        if (Math.abs(f11 - 1.0f) < 0.01d) {
            return false;
        }
        if (f8 > f10) {
            float f12 = f10 / f8;
            float f13 = (f12 + 1.0f) / 2.0f;
            if (f4 < (1.0f - f12) / 2.0f || f4 + f6 > f13) {
                return false;
            }
        } else {
            float f14 = (f11 + 1.0f) / 2.0f;
            if (f3 < (1.0f - f11) / 2.0f || f3 + f5 > f14) {
                return false;
            }
            f8 = f10;
        }
        if (matrix == null) {
            return true;
        }
        matrix.preTranslate((f7 - f) / 2.0f, (f9 - f2) / 2.0f);
        matrix.preScale(f / f7, f2 / f9);
        matrix.postScale(f8, f8, f7 / 2.0f, f9 / 2.0f);
        return true;
    }
}
