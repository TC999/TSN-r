package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11137y;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.InputStream;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KSImageLoader {
    public static DisplayImageOptionsCompat IMGOPTION_NORMAL = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build();
    private static OnRenderResultListener<AdTemplate> mDefaultListener;

    /* renamed from: com.kwad.sdk.core.imageloader.KSImageLoader$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static /* synthetic */ class C103891 {

        /* renamed from: $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType */
        static final /* synthetic */ int[] f29555x5c614925;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            f29555x5c614925 = iArr;
            try {
                iArr[FailReason.FailType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29555x5c614925[FailReason.FailType.IO_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29555x5c614925[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29555x5c614925[FailReason.FailType.NETWORK_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29555x5c614925[FailReason.FailType.DECODING_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class InnerImageLoadingListener implements ImageLoadingListener {
        public static final int MAX_DURATION = 30000;
        @Nullable
        AdTemplate adTemplate;
        @Nullable
        ImageLoadingListener loadingListener;
        private long startTime;

        public InnerImageLoadingListener(@Nullable AdTemplate adTemplate, @Nullable ImageLoadingListener imageLoadingListener) {
            this.adTemplate = adTemplate;
            this.loadingListener = imageLoadingListener;
        }

        private long getDuration(long j) {
            if (j == 0) {
                return -1L;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - j;
            if (elapsedRealtime >= 30000) {
                return -1L;
            }
            return elapsedRealtime;
        }

        private void recordDuration(long j) {
            try {
                long duration = getDuration(j);
                if (duration >= 0) {
                    C11137y.m23608aG(duration);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                return imageLoadingListener.onDecode(str, inputStream, decodedResult);
            }
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingCancelled(str, view);
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingComplete(str, view, decodedResult);
            }
            recordDuration(this.startTime);
            C11137y.m23629LP();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            String str2;
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(str, view, failReason);
            }
            if (this.adTemplate != null) {
                StringBuilder sb = new StringBuilder("ImageLoader:");
                if (failReason != null) {
                    Throwable cause = failReason.getCause();
                    if (cause == null || cause.getStackTrace().length <= 0) {
                        str2 = "";
                    } else {
                        str2 = cause.getMessage() + " @ " + cause.getStackTrace()[0].getFileName() + cause.getStackTrace()[0].getClassName() + cause.getStackTrace()[0].getLineNumber();
                    }
                    int i = C103891.f29555x5c614925[failReason.getType().ordinal()];
                    if (i == 1) {
                        sb.append(Constants.APP_VERSION_UNKNOWN);
                    } else if (i == 2) {
                        sb.append("IO_ERROR");
                        sb.append(str2);
                    } else if (i == 3) {
                        sb.append("OUT_OF_MEMORY");
                    } else if (i == 4) {
                        sb.append("NETWORK_DENIED");
                    } else if (i == 5) {
                        sb.append("DECODING_ERROR");
                    }
                }
                if (KSImageLoader.access$000() != null) {
                    KSImageLoader.access$000().onRenderResult(false, this.adTemplate, str, sb.toString());
                }
            }
            C11137y.m23628LQ();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingStarted(str, view);
            }
            this.startTime = SystemClock.elapsedRealtime();
            C11137y.m23630LO();
        }
    }

    static /* synthetic */ OnRenderResultListener access$000() {
        return getGlobalImageListener();
    }

    @RequiresApi(api = 17)
    public static Bitmap blur(Context context, Bitmap bitmap, @IntRange(from = 1, m60035to = 25) int i) {
        try {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            Bitmap copy = config == config2 ? bitmap : bitmap.copy(config2, true);
            if (copy == null) {
                copy = bitmap.copy(bitmap.getConfig(), true);
            }
            Bitmap createBitmap = Bitmap.createBitmap(copy.getWidth(), copy.getHeight(), copy.getConfig());
            RenderScript create = RenderScript.create(context);
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createBitmap);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
            create2.setInput(createFromBitmap);
            create2.setRadius(i);
            create2.forEach(createFromBitmap);
            createFromBitmap.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public static void clearMemory() {
        ImageLoaderProxy.INSTANCE.clearMemory(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext());
    }

    private static OnRenderResultListener<AdTemplate> getGlobalImageListener() {
        if (mDefaultListener == null) {
            mDefaultListener = new GlobalImageListener();
        }
        return mDefaultListener;
    }

    private static Context getSDKContext() {
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        if (interfaceC10968f != null) {
            return interfaceC10968f.getContext();
        }
        return null;
    }

    public static boolean isImageExist(String str) {
        File isImageExistOnDisk;
        return !TextUtils.isEmpty(str) && (isImageExistOnDisk = ImageLoaderProxy.INSTANCE.isImageExistOnDisk(str)) != null && isImageExistOnDisk.exists() && isImageExistOnDisk.length() > 0;
    }

    public static void loadAppIcon(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        DisplayImageOptionsCompat.Builder builder = new DisplayImageOptionsCompat.Builder();
        Resources resources = imageView.getContext().getResources();
        int i2 = C9659R.C9661drawable.ksad_default_app_icon;
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, builder.showImageOnLoading(resources.getDrawable(i2)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(i2)).showImageOnFail(imageView.getContext().getResources().getDrawable(i2)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable, @ColorInt int i) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(i).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithBorder(ImageView imageView, String str, Drawable drawable, Integer num, float f) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(num.intValue()).setStrokeWidth(f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithoutStroke(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setCircle(true).build(), (ImageLoadingListener) null);
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadFeeImage(imageView, str, adTemplate, null);
    }

    public static void loadImage(String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static Bitmap loadImageSync(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ImageLoaderProxy.INSTANCE.loadImageSync(str);
    }

    public static void loadWithRadius(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        DisplayImageOptionsCompat.Builder builder = new DisplayImageOptionsCompat.Builder();
        Resources resources = imageView.getContext().getResources();
        int i2 = C9659R.C9661drawable.ksad_default_app_icon;
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, builder.showImageOnLoading(resources.getDrawable(i2)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(i2)).showImageOnFail(imageView.getContext().getResources().getDrawable(i2)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void pause() {
        ImageLoaderProxy.INSTANCE.pause();
    }

    public static void preloadImage(String str, AdTemplate adTemplate) {
        loadImage(str, adTemplate, IMGOPTION_NORMAL, (ImageLoadingListener) null);
    }

    public static void resume() {
        ImageLoaderProxy.INSTANCE.resume();
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisk(true).setCornerRound(1).build(), new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, ImageLoadingListener imageLoadingListener) {
        if (imageView == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext(), str, imageView, IMGOPTION_NORMAL, imageLoadingListener);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (imageView == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext(), str, imageView, displayImageOptionsCompat, (ImageLoadingListener) null);
    }

    public static void loadImage(ImageView imageView, @Nullable String str) {
        loadImage(imageView, str, (AdTemplate) null, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadImage(imageView, str, adTemplate, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(Color.argb(255, 255, 255, 255)).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, IMGOPTION_NORMAL, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }
}
