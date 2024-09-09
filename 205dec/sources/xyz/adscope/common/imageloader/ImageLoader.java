package xyz.adscope.common.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import xyz.adscope.common.R;
import xyz.adscope.common.imageloader.ImageUtils;
import xyz.adscope.common.imageloader.inter.IImageLoader;
import xyz.adscope.common.imageloader.inter.IImageLoaderCallback;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ImageLoader implements IImageLoader {
    @Override // xyz.adscope.common.imageloader.inter.IImageLoader
    public void loadCacheImage(final Context context, String str, boolean z3, final IImageLoaderCallback iImageLoaderCallback) {
        ImageUtils.with().getCacheBitmap(context, str, z3, new ImageUtils.BitmapLoadedListener() { // from class: xyz.adscope.common.imageloader.ImageLoader.3
            @Override // xyz.adscope.common.imageloader.ImageUtils.BitmapLoadedListener
            public void onBitmapLoadFailed() {
                iImageLoaderCallback.failCallback(context.getString(R.string.adscope_image_load_failed));
            }

            @Override // xyz.adscope.common.imageloader.ImageUtils.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                iImageLoaderCallback.successCallback(bitmap);
            }
        });
    }

    @Override // xyz.adscope.common.imageloader.inter.IImageLoader
    public void loadImage(final Context context, String str, final IImageLoaderCallback iImageLoaderCallback) {
        ImageUtils.with().getBitmap(context, str, new ImageUtils.BitmapLoadedListener() { // from class: xyz.adscope.common.imageloader.ImageLoader.1
            @Override // xyz.adscope.common.imageloader.ImageUtils.BitmapLoadedListener
            public void onBitmapLoadFailed() {
                iImageLoaderCallback.failCallback(context.getString(R.string.adscope_image_load_failed));
            }

            @Override // xyz.adscope.common.imageloader.ImageUtils.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                iImageLoaderCallback.successCallback(bitmap);
            }
        });
    }

    @Override // xyz.adscope.common.imageloader.inter.IImageLoader
    public void loadImage(final Context context, String str, boolean z3, final IImageLoaderCallback iImageLoaderCallback) {
        ImageUtils.with().getBitmap(context, str, z3, new ImageUtils.BitmapLoadedListener() { // from class: xyz.adscope.common.imageloader.ImageLoader.2
            @Override // xyz.adscope.common.imageloader.ImageUtils.BitmapLoadedListener
            public void onBitmapLoadFailed() {
                iImageLoaderCallback.failCallback(context.getString(R.string.adscope_image_load_failed));
            }

            @Override // xyz.adscope.common.imageloader.ImageUtils.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                iImageLoaderCallback.successCallback(bitmap);
            }
        });
    }

    @Override // xyz.adscope.common.imageloader.inter.IImageLoader
    public void loadImage(ImageView imageView, String str) {
        ImageUtils.with().load(str).into(imageView);
    }
}
