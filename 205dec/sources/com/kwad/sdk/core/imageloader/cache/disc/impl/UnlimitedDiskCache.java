package com.kwad.sdk.core.imageloader.cache.disc.impl;

import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class UnlimitedDiskCache extends BaseDiskCache {
    public UnlimitedDiskCache(File file) {
        super(file);
    }

    public UnlimitedDiskCache(File file, File file2) {
        super(file, file2);
    }

    public UnlimitedDiskCache(File file, File file2, FileNameGenerator fileNameGenerator) {
        super(file, file2, fileNameGenerator);
    }
}
