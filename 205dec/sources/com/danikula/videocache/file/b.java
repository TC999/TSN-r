package com.danikula.videocache.file;

import com.danikula.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: FileCache.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class b implements com.danikula.videocache.d {

    /* renamed from: d  reason: collision with root package name */
    private static final String f36736d = ".download";

    /* renamed from: a  reason: collision with root package name */
    private final a f36737a;

    /* renamed from: b  reason: collision with root package name */
    public File f36738b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f36739c;

    public b(File file) throws ProxyCacheException {
        this(file, new i());
    }

    private boolean d(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.danikula.videocache.d
    public synchronized void a(byte[] bArr, int i4) throws ProxyCacheException {
        try {
            if (!isCompleted()) {
                this.f36739c.seek(available());
                this.f36739c.write(bArr, 0, i4);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.f36738b + " is completed!");
            }
        } catch (IOException e4) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i4), this.f36739c, Integer.valueOf(bArr.length)), e4);
        }
    }

    @Override // com.danikula.videocache.d
    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e4) {
            throw new ProxyCacheException("Error reading length of file " + this.f36738b, e4);
        }
        return (int) this.f36739c.length();
    }

    @Override // com.danikula.videocache.d
    public synchronized int b(byte[] bArr, long j4, int i4) throws ProxyCacheException {
        try {
            this.f36739c.seek(j4);
        } catch (IOException e4) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i4), Long.valueOf(j4), Long.valueOf(available()), Integer.valueOf(bArr.length)), e4);
        }
        return this.f36739c.read(bArr, 0, i4);
    }

    public File c() {
        return this.f36738b;
    }

    @Override // com.danikula.videocache.d
    public synchronized void close() throws ProxyCacheException {
        try {
            this.f36739c.close();
            this.f36737a.a(this.f36738b);
        } catch (IOException e4) {
            throw new ProxyCacheException("Error closing file " + this.f36738b, e4);
        }
    }

    @Override // com.danikula.videocache.d
    public synchronized void complete() throws ProxyCacheException {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.f36738b.getParentFile(), this.f36738b.getName().substring(0, this.f36738b.getName().length() - 9));
        if (this.f36738b.renameTo(file)) {
            this.f36738b = file;
            try {
                this.f36739c = new RandomAccessFile(this.f36738b, "r");
                this.f36737a.a(this.f36738b);
                return;
            } catch (IOException e4) {
                throw new ProxyCacheException("Error opening " + this.f36738b + " as disc cache", e4);
            }
        }
        throw new ProxyCacheException("Error renaming file " + this.f36738b + " to " + file + " for completion!");
    }

    @Override // com.danikula.videocache.d
    public synchronized boolean isCompleted() {
        return !d(this.f36738b);
    }

    public b(File file, a aVar) throws ProxyCacheException {
        File file2;
        try {
            if (aVar != null) {
                this.f36737a = aVar;
                d.b(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + ".download");
                }
                this.f36738b = file2;
                this.f36739c = new RandomAccessFile(this.f36738b, exists ? "r" : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e4) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e4);
        }
    }
}
