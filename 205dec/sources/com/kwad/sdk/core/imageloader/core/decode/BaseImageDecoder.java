package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.utils.ImageSizeUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BaseImageDecoder implements ImageDecoder {
    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d\u00b0 [%2$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected final boolean loggingEnabled;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class ImageFileInfo {
        public final ExifInfo exif;
        public final ImageSize imageSize;

        protected ImageFileInfo(ImageSize imageSize, ExifInfo exifInfo) {
            this.imageSize = imageSize;
            this.exif = exifInfo;
        }
    }

    public BaseImageDecoder(boolean z3) {
        this.loggingEnabled = z3;
    }

    private boolean canDefineExifParams(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    protected Bitmap considerExactScaleAndOrientatiton(Bitmap bitmap, ImageDecodingInfo imageDecodingInfo, int i4, boolean z3) {
        Matrix matrix = new Matrix();
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.EXACTLY || imageScaleType == ImageScaleType.EXACTLY_STRETCHED) {
            ImageSize imageSize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i4);
            float computeImageScale = ImageSizeUtils.computeImageScale(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(computeImageScale, 1.0f) != 0) {
                matrix.setScale(computeImageScale, computeImageScale);
                if (this.loggingEnabled) {
                    L.d("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", imageSize, imageSize.scale(computeImageScale), Float.valueOf(computeImageScale), imageDecodingInfo.getImageKey());
                }
            }
        }
        if (z3) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                L.d("Flip image horizontally [%s]", imageDecodingInfo.getImageKey());
            }
        }
        if (i4 != 0) {
            matrix.postRotate(i4);
            if (this.loggingEnabled) {
                L.d("Rotate image on %1$d\u00b0 [%2$s]", Integer.valueOf(i4), imageDecodingInfo.getImageKey());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    @Override // com.kwad.sdk.core.imageloader.core.decode.ImageDecoder
    public DecodedResult decode(ImageDecodingInfo imageDecodingInfo) {
        DecodedResult decodedResult = new DecodedResult();
        InputStream imageStream = getImageStream(imageDecodingInfo);
        if (imageStream == null) {
            L.e("No stream for image [%s]", imageDecodingInfo.getImageKey());
            return null;
        }
        try {
            if (imageDecodingInfo.getLoadListener() == null || !imageDecodingInfo.getLoadListener().onDecode(imageDecodingInfo.getImageUri(), imageStream, decodedResult)) {
                ImageFileInfo defineImageSizeAndRotation = defineImageSizeAndRotation(imageStream, imageDecodingInfo);
                imageStream = resetStream(imageStream, imageDecodingInfo);
                decodedResult.mBitmap = BitmapFactory.decodeStream(imageStream, null, prepareDecodingOptions(defineImageSizeAndRotation.imageSize, imageDecodingInfo));
                b.closeQuietly(imageStream);
                Bitmap bitmap = decodedResult.mBitmap;
                if (bitmap == null && decodedResult.mFrameSequence == null) {
                    L.e("Image can't be decoded [%s]", imageDecodingInfo.getImageKey());
                } else {
                    ExifInfo exifInfo = defineImageSizeAndRotation.exif;
                    decodedResult.mBitmap = considerExactScaleAndOrientatiton(bitmap, imageDecodingInfo, exifInfo.rotation, exifInfo.flipHorizontal);
                }
                return decodedResult;
            }
            return decodedResult;
        } finally {
            b.closeQuietly(imageStream);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    protected ExifInfo defineExifOrientation(String str) {
        boolean z3;
        int i4 = 0;
        boolean z4 = true;
        try {
        } catch (IOException unused) {
            L.w("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt("Orientation", 1)) {
            case 1:
                z4 = false;
                z3 = z4;
                break;
            case 2:
                z3 = z4;
                break;
            case 3:
                z3 = i4;
                i4 = 180;
                break;
            case 4:
                i4 = 1;
                z3 = i4;
                i4 = 180;
                break;
            case 5:
                i4 = 1;
                z3 = i4;
                i4 = 270;
                break;
            case 6:
                z3 = i4;
                i4 = 90;
                break;
            case 7:
                i4 = 1;
                z3 = i4;
                i4 = 90;
                break;
            case 8:
                z3 = i4;
                i4 = 270;
                break;
            default:
                z3 = false;
                break;
        }
        return new ExifInfo(i4, z3);
    }

    protected ImageFileInfo defineImageSizeAndRotation(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        ExifInfo exifInfo;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String imageUri = imageDecodingInfo.getImageUri();
        if (imageDecodingInfo.shouldConsiderExifParams() && canDefineExifParams(imageUri, options.outMimeType)) {
            exifInfo = defineExifOrientation(imageUri);
        } else {
            exifInfo = new ExifInfo();
        }
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, exifInfo.rotation), exifInfo);
    }

    public InputStream getImageStream(ImageDecodingInfo imageDecodingInfo) {
        return imageDecodingInfo.getDownloader().getStream(imageDecodingInfo.getImageUri(), imageDecodingInfo.getExtraForDownloader());
    }

    protected BitmapFactory.Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo imageDecodingInfo) {
        int computeImageSampleSize;
        ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
        if (imageScaleType == ImageScaleType.NONE) {
            computeImageSampleSize = 1;
        } else if (imageScaleType == ImageScaleType.NONE_SAFE) {
            computeImageSampleSize = ImageSizeUtils.computeMinImageSampleSize(imageSize);
        } else {
            computeImageSampleSize = ImageSizeUtils.computeImageSampleSize(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (computeImageSampleSize > 1 && this.loggingEnabled) {
            L.d("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", imageSize, imageSize.scaleDown(computeImageSampleSize), Integer.valueOf(computeImageSampleSize), imageDecodingInfo.getImageKey());
        }
        BitmapFactory.Options decodingOptions = imageDecodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = computeImageSampleSize;
        return decodingOptions;
    }

    protected InputStream resetStream(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        if (inputStream.markSupported()) {
            try {
                inputStream.reset();
                return inputStream;
            } catch (IOException unused) {
            }
        }
        b.closeQuietly(inputStream);
        return getImageStream(imageDecodingInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        protected ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        protected ExifInfo(int i4, boolean z3) {
            this.rotation = i4;
            this.flipHorizontal = z3;
        }
    }
}
