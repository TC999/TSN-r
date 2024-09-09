package com.kwad.sdk.core.imageloader.cache.disc;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.File;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface DiskCache {
    void clear();

    void close();

    File get(String str);

    File getDirectory();

    boolean remove(String str);

    boolean save(String str, Bitmap bitmap);

    boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener);
}
