package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    protected int bufferSize;
    protected a cache;
    protected Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j4) {
        this(file, null, fileNameGenerator, j4, 0);
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    private void initCache(File file, File file2, long j4, int i4) {
        try {
            this.cache = a.a(file, 1, 1, j4, i4);
        } catch (IOException e4) {
            L.e(e4);
            if (file2 != null) {
                initCache(file2, null, j4, i4);
            }
            if (this.cache == null) {
                throw e4;
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e4) {
            L.e(e4);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.CW());
        } catch (IOException e5) {
            L.e(e5);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
        b.closeQuietly(this.cache);
        this.cache = null;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        Throwable th;
        a.c cVar;
        File file = null;
        try {
            cVar = this.cache.m91do(getKey(str));
            if (cVar != null) {
                try {
                    try {
                        file = cVar.dc(0);
                    } catch (Throwable th2) {
                        th = th2;
                        b.closeQuietly(cVar);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    L.e(e);
                    b.closeQuietly(cVar);
                    return null;
                }
            }
            b.closeQuietly(cVar);
            return file;
        } catch (IOException e5) {
            e = e5;
            cVar = null;
        } catch (Throwable th3) {
            th = th3;
            cVar = null;
            b.closeQuietly(cVar);
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File getDirectory() {
        return this.cache.getDirectory();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        try {
            return this.cache.remove(getKey(str));
        } catch (IOException e4) {
            L.e(e4);
            return false;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        a.C0691a dp = this.cache.dp(getKey(str));
        if (dp == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(dp.cZ(0), this.bufferSize);
        try {
            boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            b.closeQuietly(bufferedOutputStream);
            if (copyStream) {
                dp.commit();
            } else {
                dp.abort();
            }
            return copyStream;
        } catch (Throwable th) {
            b.closeQuietly(bufferedOutputStream);
            dp.abort();
            throw th;
        }
    }

    public void setBufferSize(int i4) {
        this.bufferSize = i4;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i4) {
        this.compressQuality = i4;
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j4, int i4) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j4 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (fileNameGenerator != null) {
            long j5 = j4 == 0 ? Long.MAX_VALUE : j4;
            int i5 = i4 == 0 ? Integer.MAX_VALUE : i4;
            this.reserveCacheDir = file2;
            this.fileNameGenerator = fileNameGenerator;
            initCache(file, file2, j5, i5);
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        a.C0691a dp = this.cache.dp(getKey(str));
        if (dp == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(dp.cZ(0), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            if (compress) {
                dp.commit();
            } else {
                dp.abort();
            }
            return compress;
        } finally {
            b.closeQuietly(bufferedOutputStream);
        }
    }
}
