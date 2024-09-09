package com.kwad.sdk.core.imageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DefaultConfigurationFactory;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class LimitedAgeDiskCache extends BaseDiskCache {
    private final Map<File, Long> loadingDates;
    private final long maxFileAge;

    public LimitedAgeDiskCache(File file, long j4) {
        this(file, null, DefaultConfigurationFactory.createFileNameGenerator(), j4);
    }

    private void rememberUsage(String str) {
        File file = getFile(str);
        long currentTimeMillis = System.currentTimeMillis();
        file.setLastModified(currentTimeMillis);
        this.loadingDates.put(file, Long.valueOf(currentTimeMillis));
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        super.clear();
        this.loadingDates.clear();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        boolean z3;
        File file = super.get(str);
        if (file != null && file.exists()) {
            Long l4 = this.loadingDates.get(file);
            if (l4 == null) {
                l4 = Long.valueOf(file.lastModified());
                z3 = false;
            } else {
                z3 = true;
            }
            if (System.currentTimeMillis() - l4.longValue() > this.maxFileAge) {
                file.delete();
                this.loadingDates.remove(file);
            } else if (!z3) {
                this.loadingDates.put(file, l4);
            }
        }
        return file;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        this.loadingDates.remove(getFile(str));
        return super.remove(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        boolean save = super.save(str, inputStream, copyListener);
        rememberUsage(str);
        return save;
    }

    public LimitedAgeDiskCache(File file, File file2, long j4) {
        this(file, file2, DefaultConfigurationFactory.createFileNameGenerator(), j4);
    }

    public LimitedAgeDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j4) {
        super(file, file2, fileNameGenerator);
        this.loadingDates = Collections.synchronizedMap(new HashMap());
        this.maxFileAge = j4 * 1000;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        boolean save = super.save(str, bitmap);
        rememberUsage(str);
        return save;
    }
}
