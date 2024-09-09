package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements com.kwad.sdk.core.videocache.a {
    private final a aBI;
    private RandomAccessFile aCz;
    public File file;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar != null) {
                this.aBI = aVar;
                d.u(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + ".download");
                }
                this.file = file2;
                this.aCz = new RandomAccessFile(this.file, exists ? "r" : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e4) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e4);
        }
    }

    private static boolean t(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized long Go() {
        try {
        } catch (IOException e4) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e4);
        }
        return (int) this.aCz.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized int a(byte[] bArr, long j4, int i4) {
        try {
            this.aCz.seek(j4);
        } catch (IOException e4) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i4), Long.valueOf(j4), Long.valueOf(Go()), Integer.valueOf(bArr.length)), e4);
        }
        return this.aCz.read(bArr, 0, i4);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void close() {
        try {
            this.aCz.close();
            this.aBI.s(this.file);
        } catch (IOException e4) {
            throw new ProxyCacheException("Error closing file " + this.file, e4);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void complete() {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (this.file.renameTo(file)) {
            this.file = file;
            try {
                this.aCz = new RandomAccessFile(this.file, "r");
                this.aBI.s(this.file);
                return;
            } catch (IOException e4) {
                throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e4);
            }
        }
        throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void d(byte[] bArr, int i4) {
        try {
            if (!isCompleted()) {
                this.aCz.seek(Go());
                this.aCz.write(bArr, 0, i4);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
        } catch (IOException e4) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i4), this.aCz, 1024), e4);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized boolean isCompleted() {
        return !t(this.file);
    }
}
