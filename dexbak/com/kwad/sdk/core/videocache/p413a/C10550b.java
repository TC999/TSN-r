package com.kwad.sdk.core.videocache.p413a;

import com.kwad.sdk.core.videocache.InterfaceC10548a;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.kwad.sdk.core.videocache.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10550b implements InterfaceC10548a {
    private final InterfaceC10549a aBI;
    private RandomAccessFile aCz;
    public File file;

    public C10550b(File file, InterfaceC10549a interfaceC10549a) {
        File file2;
        try {
            if (interfaceC10549a != null) {
                this.aBI = interfaceC10549a;
                C10552d.m25485u(file.getParentFile());
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
        } catch (IOException e) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }

    /* renamed from: t */
    private static boolean m25486t(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10548a
    /* renamed from: Go */
    public final synchronized long mo25489Go() {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e);
        }
        return (int) this.aCz.length();
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10548a
    /* renamed from: a */
    public final synchronized int mo25488a(byte[] bArr, long j, int i) {
        try {
            this.aCz.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(mo25489Go()), Integer.valueOf(bArr.length)), e);
        }
        return this.aCz.read(bArr, 0, i);
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10548a
    public final synchronized void close() {
        try {
            this.aCz.close();
            this.aBI.mo25476s(this.file);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.file, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10548a
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
                this.aBI.mo25476s(this.file);
                return;
            } catch (IOException e) {
                throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e);
            }
        }
        throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10548a
    /* renamed from: d */
    public final synchronized void mo25487d(byte[] bArr, int i) {
        try {
            if (!isCompleted()) {
                this.aCz.seek(mo25489Go());
                this.aCz.write(bArr, 0, i);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.aCz, 1024), e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.InterfaceC10548a
    public final synchronized boolean isCompleted() {
        return !m25486t(this.file);
    }
}
