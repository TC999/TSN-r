package com.beizi.ad.internal.b.a;

import com.beizi.ad.internal.b.m;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FileCache.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b implements com.beizi.ad.internal.b.a {

    /* renamed from: a  reason: collision with root package name */
    public File f13677a;

    /* renamed from: b  reason: collision with root package name */
    private final a f13678b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f13679c;

    public b(File file, a aVar) throws m {
        File file2;
        try {
            if (aVar != null) {
                this.f13678b = aVar;
                d.a(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + ".download");
                }
                this.f13677a = file2;
                this.f13679c = new RandomAccessFile(this.f13677a, exists ? "r" : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e4) {
            throw new m("Error using file " + file + " as disc cache", e4);
        }
    }

    @Override // com.beizi.ad.internal.b.a
    public synchronized int a() throws m {
        try {
        } catch (IOException e4) {
            throw new m("Error reading length of file " + this.f13677a, e4);
        }
        return (int) this.f13679c.length();
    }

    @Override // com.beizi.ad.internal.b.a
    public synchronized void b() throws m {
        try {
            this.f13679c.close();
            this.f13678b.a(this.f13677a);
        } catch (IOException e4) {
            throw new m("Error closing file " + this.f13677a, e4);
        }
    }

    @Override // com.beizi.ad.internal.b.a
    public synchronized void c() throws m {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f13677a.getParentFile(), this.f13677a.getName().substring(0, this.f13677a.getName().length() - 9));
        if (this.f13677a.renameTo(file)) {
            this.f13677a = file;
            try {
                this.f13679c = new RandomAccessFile(this.f13677a, "r");
                return;
            } catch (IOException e4) {
                throw new m("Error opening " + this.f13677a + " as disc cache", e4);
            }
        }
        throw new m("Error renaming file " + this.f13677a + " to " + file + " for completion!");
    }

    @Override // com.beizi.ad.internal.b.a
    public synchronized boolean d() {
        return !a(this.f13677a);
    }

    @Override // com.beizi.ad.internal.b.a
    public synchronized int a(byte[] bArr, long j4, int i4) throws m {
        try {
            this.f13679c.seek(j4);
        } catch (IOException e4) {
            throw new m(String.format("Error reading %d bytes with offset %d failFrom file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i4), Long.valueOf(j4), Integer.valueOf(a()), Integer.valueOf(bArr.length)), e4);
        }
        return this.f13679c.read(bArr, 0, i4);
    }

    @Override // com.beizi.ad.internal.b.a
    public synchronized void a(byte[] bArr, int i4) throws m {
        try {
            if (!d()) {
                this.f13679c.seek(a());
                this.f13679c.write(bArr, 0, i4);
            } else {
                throw new m("Error append cache: cache file " + this.f13677a + " is completed!");
            }
        } catch (IOException e4) {
            throw new m(String.format("Error writing %d bytes to %s failFrom buffer with size %d", Integer.valueOf(i4), this.f13679c, Integer.valueOf(bArr.length)), e4);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }
}
