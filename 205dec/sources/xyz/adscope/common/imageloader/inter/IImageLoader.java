package xyz.adscope.common.imageloader.inter;

import android.content.Context;
import android.widget.ImageView;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IImageLoader {
    void loadCacheImage(Context context, String str, boolean z3, IImageLoaderCallback iImageLoaderCallback);

    void loadImage(Context context, String str, IImageLoaderCallback iImageLoaderCallback);

    void loadImage(Context context, String str, boolean z3, IImageLoaderCallback iImageLoaderCallback);

    void loadImage(ImageView imageView, String str);
}
