package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.kwad.sdk.core.diskcache.p393a.C10281a;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.utils.C10400L;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.crash.utils.C10738b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    protected int bufferSize;
    protected C10281a cache;
    protected Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j) {
        this(file, null, fileNameGenerator, j, 0);
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    private void initCache(File file, File file2, long j, int i) {
        try {
            this.cache = C10281a.m26431a(file, 1, 1, j, i);
        } catch (IOException e) {
            C10400L.m26178e(e);
            if (file2 != null) {
                initCache(file2, null, j, i);
            }
            if (this.cache == null) {
                throw e;
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e) {
            C10400L.m26178e(e);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.m26440CW());
        } catch (IOException e2) {
            C10400L.m26178e(e2);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
        C10738b.closeQuietly(this.cache);
        this.cache = null;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        Throwable th;
        C10281a.C10288c c10288c;
        File file = null;
        try {
            c10288c = this.cache.m26425do(getKey(str));
            if (c10288c != null) {
                try {
                    try {
                        file = c10288c.m26398dc(0);
                    } catch (Throwable th2) {
                        th = th2;
                        C10738b.closeQuietly(c10288c);
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    C10400L.m26178e(e);
                    C10738b.closeQuietly(c10288c);
                    return null;
                }
            }
            C10738b.closeQuietly(c10288c);
            return file;
        } catch (IOException e2) {
            e = e2;
            c10288c = null;
        } catch (Throwable th3) {
            th = th3;
            c10288c = null;
            C10738b.closeQuietly(c10288c);
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
        } catch (IOException e) {
            C10400L.m26178e(e);
            return false;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        C10281a.C10285a m26424dp = this.cache.m26424dp(getKey(str));
        if (m26424dp == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(m26424dp.m26413cZ(0), this.bufferSize);
        try {
            boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            C10738b.closeQuietly(bufferedOutputStream);
            if (copyStream) {
                m26424dp.commit();
            } else {
                m26424dp.abort();
            }
            return copyStream;
        } catch (Throwable th) {
            C10738b.closeQuietly(bufferedOutputStream);
            m26424dp.abort();
            throw th;
        }
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i) {
        this.compressQuality = i;
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j, int i) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (fileNameGenerator != null) {
            long j2 = j == 0 ? Long.MAX_VALUE : j;
            int i2 = i == 0 ? Integer.MAX_VALUE : i;
            this.reserveCacheDir = file2;
            this.fileNameGenerator = fileNameGenerator;
            initCache(file, file2, j2, i2);
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        C10281a.C10285a m26424dp = this.cache.m26424dp(getKey(str));
        if (m26424dp == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(m26424dp.m26413cZ(0), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            if (compress) {
                m26424dp.commit();
            } else {
                m26424dp.abort();
            }
            return compress;
        } finally {
            C10738b.closeQuietly(bufferedOutputStream);
        }
    }
}
