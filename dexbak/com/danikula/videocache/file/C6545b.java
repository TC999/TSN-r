package com.danikula.videocache.file;

import com.danikula.videocache.InterfaceC6541d;
import com.danikula.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: FileCache.java */
/* renamed from: com.danikula.videocache.file.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6545b implements InterfaceC6541d {

    /* renamed from: d */
    private static final String f23069d = ".download";

    /* renamed from: a */
    private final InterfaceC6544a f23070a;

    /* renamed from: b */
    public File f23071b;

    /* renamed from: c */
    private RandomAccessFile f23072c;

    public C6545b(File file) throws ProxyCacheException {
        this(file, new UnlimitedDiskUsage());
    }

    /* renamed from: d */
    private boolean m35939d(File file) {
        return file.getName().endsWith(f23069d);
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    /* renamed from: a */
    public synchronized void mo35942a(byte[] bArr, int i) throws ProxyCacheException {
        try {
            if (!isCompleted()) {
                this.f23072c.seek(available());
                this.f23072c.write(bArr, 0, i);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.f23071b + " is completed!");
            }
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.f23072c, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.f23071b, e);
        }
        return (int) this.f23072c.length();
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    /* renamed from: b */
    public synchronized int mo35941b(byte[] bArr, long j, int i) throws ProxyCacheException {
        try {
            this.f23072c.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)), e);
        }
        return this.f23072c.read(bArr, 0, i);
    }

    /* renamed from: c */
    public File m35940c() {
        return this.f23071b;
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    public synchronized void close() throws ProxyCacheException {
        try {
            this.f23072c.close();
            this.f23070a.mo35925a(this.f23071b);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.f23071b, e);
        }
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    public synchronized void complete() throws ProxyCacheException {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.f23071b.getParentFile(), this.f23071b.getName().substring(0, this.f23071b.getName().length() - 9));
        if (this.f23071b.renameTo(file)) {
            this.f23071b = file;
            try {
                this.f23072c = new RandomAccessFile(this.f23071b, "r");
                this.f23070a.mo35925a(this.f23071b);
                return;
            } catch (IOException e) {
                throw new ProxyCacheException("Error opening " + this.f23071b + " as disc cache", e);
            }
        }
        throw new ProxyCacheException("Error renaming file " + this.f23071b + " to " + file + " for completion!");
    }

    @Override // com.danikula.videocache.InterfaceC6541d
    public synchronized boolean isCompleted() {
        return !m35939d(this.f23071b);
    }

    public C6545b(File file, InterfaceC6544a interfaceC6544a) throws ProxyCacheException {
        File file2;
        try {
            if (interfaceC6544a != null) {
                this.f23070a = interfaceC6544a;
                C6547d.m35937b(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + f23069d);
                }
                this.f23071b = file2;
                this.f23072c = new RandomAccessFile(this.f23071b, exists ? "r" : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }
}
