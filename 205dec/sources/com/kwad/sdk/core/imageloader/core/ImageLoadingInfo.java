package com.kwad.sdk.core.imageloader.core;

import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingProgressListener;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ImageLoadingInfo {
    final ImageAware imageAware;
    final ImageLoadingListener listener;
    final ReentrantLock loadFromUriLock;
    final String memoryCacheKey;
    final DisplayImageOptions options;
    final ImageLoadingProgressListener progressListener;
    final ImageSize targetSize;
    final String uri;

    public ImageLoadingInfo(String str, ImageAware imageAware, ImageSize imageSize, String str2, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener, ReentrantLock reentrantLock) {
        this.uri = str;
        this.imageAware = imageAware;
        this.targetSize = imageSize;
        this.options = displayImageOptions;
        this.listener = imageLoadingListener;
        this.progressListener = imageLoadingProgressListener;
        this.loadFromUriLock = reentrantLock;
        this.memoryCacheKey = str2;
    }
}
