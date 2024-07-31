package com.beizi.p051ad.internal.p058b.p059a;

import com.beizi.p051ad.internal.p058b.InterfaceC2862a;
import com.beizi.p051ad.internal.p058b.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.beizi.ad.internal.b.a.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FileCache implements InterfaceC2862a {

    /* renamed from: a */
    public File f10000a;

    /* renamed from: b */
    private final DiskUsage f10001b;

    /* renamed from: c */
    private RandomAccessFile f10002c;

    public FileCache(File file, DiskUsage diskUsage) throws ProxyCacheException {
        File file2;
        try {
            if (diskUsage != null) {
                this.f10001b = diskUsage;
                Files.m49643a(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + ".download");
                }
                this.f10000a = file2;
                this.f10002c = new RandomAccessFile(this.f10000a, exists ? "r" : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2862a
    /* renamed from: a */
    public synchronized int mo49650a() throws ProxyCacheException {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.f10000a, e);
        }
        return (int) this.f10002c.length();
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2862a
    /* renamed from: b */
    public synchronized void mo49646b() throws ProxyCacheException {
        try {
            this.f10002c.close();
            this.f10001b.mo49629a(this.f10000a);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.f10000a, e);
        }
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2862a
    /* renamed from: c */
    public synchronized void mo49645c() throws ProxyCacheException {
        if (mo49644d()) {
            return;
        }
        mo49646b();
        File file = new File(this.f10000a.getParentFile(), this.f10000a.getName().substring(0, this.f10000a.getName().length() - 9));
        if (this.f10000a.renameTo(file)) {
            this.f10000a = file;
            try {
                this.f10002c = new RandomAccessFile(this.f10000a, "r");
                return;
            } catch (IOException e) {
                throw new ProxyCacheException("Error opening " + this.f10000a + " as disc cache", e);
            }
        }
        throw new ProxyCacheException("Error renaming file " + this.f10000a + " to " + file + " for completion!");
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2862a
    /* renamed from: d */
    public synchronized boolean mo49644d() {
        return !m49649a(this.f10000a);
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2862a
    /* renamed from: a */
    public synchronized int mo49647a(byte[] bArr, long j, int i) throws ProxyCacheException {
        try {
            this.f10002c.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d failFrom file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(mo49650a()), Integer.valueOf(bArr.length)), e);
        }
        return this.f10002c.read(bArr, 0, i);
    }

    @Override // com.beizi.p051ad.internal.p058b.InterfaceC2862a
    /* renamed from: a */
    public synchronized void mo49648a(byte[] bArr, int i) throws ProxyCacheException {
        try {
            if (!mo49644d()) {
                this.f10002c.seek(mo49650a());
                this.f10002c.write(bArr, 0, i);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.f10000a + " is completed!");
            }
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s failFrom buffer with size %d", Integer.valueOf(i), this.f10002c, Integer.valueOf(bArr.length)), e);
        }
    }

    /* renamed from: a */
    private boolean m49649a(File file) {
        return file.getName().endsWith(".download");
    }
}
