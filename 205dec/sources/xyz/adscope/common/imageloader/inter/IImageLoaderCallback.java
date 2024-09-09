package xyz.adscope.common.imageloader.inter;

import android.graphics.Bitmap;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IImageLoaderCallback {
    void failCallback(String str);

    void successCallback(Bitmap bitmap);
}
