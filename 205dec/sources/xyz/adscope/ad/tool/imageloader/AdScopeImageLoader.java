package xyz.adscope.ad.tool.imageloader;

import android.content.Context;
import android.widget.ImageView;
import xyz.adscope.common.imageloader.ImageLoader;
import xyz.adscope.common.imageloader.inter.IImageLoaderCallback;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeImageLoader {
    public static void load(ImageView imageView, String str) {
        new ImageLoader().loadImage(imageView, str);
    }

    public static void loadImage(Context context, String str, IImageLoaderCallback iImageLoaderCallback) {
        new ImageLoader().loadImage(context, str, true, iImageLoaderCallback);
    }

    public static void loadImage(Context context, String str, boolean z3, IImageLoaderCallback iImageLoaderCallback) {
        new ImageLoader().loadImage(context, str, z3, iImageLoaderCallback);
    }
}
