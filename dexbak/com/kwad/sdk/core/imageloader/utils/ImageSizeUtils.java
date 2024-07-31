package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    /* renamed from: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static /* synthetic */ class C103991 {

        /* renamed from: $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType */
        static final /* synthetic */ int[] f29558xaa5c94ea;

        static {
            int[] iArr = new int[ViewScaleType.values().length];
            f29558xaa5c94ea = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29558xaa5c94ea[ViewScaleType.CROP.ordinal()] = 2;
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

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int max;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i = C103991.f29558xaa5c94ea[viewScaleType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                max = 1;
            } else if (z) {
                int i2 = width / 2;
                int i3 = height / 2;
                max = 1;
                while (i2 / max > width2 && i3 / max > height2) {
                    max *= 2;
                }
            } else {
                max = Math.min(width / width2, height / height2);
            }
        } else if (z) {
            int i4 = width / 2;
            int i5 = height / 2;
            max = 1;
            while (true) {
                if (i4 / max <= width2 && i5 / max <= height2) {
                    break;
                }
                max *= 2;
            }
        } else {
            max = Math.max(width / width2, height / height2);
        }
        return considerMaxTextureSize(width, height, max > 0 ? max : 1, z);
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f = width;
        float f2 = f / width2;
        float f3 = height;
        float f4 = f3 / height2;
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f2 < f4) && (viewScaleType != ViewScaleType.CROP || f2 >= f4)) {
            width2 = (int) (f / f4);
        } else {
            height2 = (int) (f3 / f2);
        }
        if ((z || width2 >= width || height2 >= height) && (!z || width2 == width || height2 == height)) {
            return 1.0f;
        }
        return width2 / f;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil(width / maxBitmapSize.getWidth()), (int) Math.ceil(height / maxBitmapSize.getHeight()));
    }

    private static int considerMaxTextureSize(int i, int i2, int i3, boolean z) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i / i3 <= width && i2 / i3 <= height) {
                return i3;
            }
            i3 = z ? i3 * 2 : i3 + 1;
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
