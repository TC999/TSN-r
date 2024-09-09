package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType;

        static {
            int[] iArr = new int[ViewScaleType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(max, max);
    }

    private ImageSizeUtils() {
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z3) {
        int max;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i4 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[viewScaleType.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                max = 1;
            } else if (z3) {
                int i5 = width / 2;
                int i6 = height / 2;
                max = 1;
                while (i5 / max > width2 && i6 / max > height2) {
                    max *= 2;
                }
            } else {
                max = Math.min(width / width2, height / height2);
            }
        } else if (z3) {
            int i7 = width / 2;
            int i8 = height / 2;
            max = 1;
            while (true) {
                if (i7 / max <= width2 && i8 / max <= height2) {
                    break;
                }
                max *= 2;
            }
        } else {
            max = Math.max(width / width2, height / height2);
        }
        return considerMaxTextureSize(width, height, max > 0 ? max : 1, z3);
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z3) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f4 = width;
        float f5 = f4 / width2;
        float f6 = height;
        float f7 = f6 / height2;
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f5 < f7) && (viewScaleType != ViewScaleType.CROP || f5 >= f7)) {
            width2 = (int) (f4 / f7);
        } else {
            height2 = (int) (f6 / f5);
        }
        if ((z3 || width2 >= width || height2 >= height) && (!z3 || width2 == width || height2 == height)) {
            return 1.0f;
        }
        return width2 / f4;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil(width / maxBitmapSize.getWidth()), (int) Math.ceil(height / maxBitmapSize.getHeight()));
    }

    private static int considerMaxTextureSize(int i4, int i5, int i6, boolean z3) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i4 / i6 <= width && i5 / i6 <= height) {
                return i6;
            }
            i6 = z3 ? i6 * 2 : i6 + 1;
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int width = imageAware.getWidth();
        if (width <= 0) {
            width = imageSize.getWidth();
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            height = imageSize.getHeight();
        }
        return new ImageSize(width, height);
    }
}
