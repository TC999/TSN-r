package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.gd.f;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private BufferedOutputStream f49974c;

    /* renamed from: w  reason: collision with root package name */
    private FileDescriptor f49975w;
    private RandomAccessFile xv;

    public ux(File file, int i4) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.xv = randomAccessFile;
            this.f49975w = randomAccessFile.getFD();
            if (i4 > 0) {
                if (i4 < 8192) {
                    i4 = 8192;
                } else if (i4 > 131072) {
                    i4 = 131072;
                }
                this.f49974c = new BufferedOutputStream(new FileOutputStream(this.xv.getFD()), i4);
                return;
            }
            this.f49974c = new BufferedOutputStream(new FileOutputStream(this.xv.getFD()));
        } catch (IOException e4) {
            throw new BaseException(1039, e4);
        }
    }

    public void c(byte[] bArr, int i4, int i5) throws IOException {
        this.f49974c.write(bArr, i4, i5);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        f.c(this.xv, this.f49974c);
    }

    public void w() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f49974c;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void xv() throws IOException {
        FileDescriptor fileDescriptor = this.f49975w;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void c() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f49974c;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f49975w;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void w(long j4) throws IOException {
        this.xv.setLength(j4);
    }

    public void c(long j4) throws IOException {
        this.xv.seek(j4);
    }
}
