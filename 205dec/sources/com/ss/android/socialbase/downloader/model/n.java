package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.q.kf;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private FileDescriptor f49967a;
    private RandomAccessFile bl;
    private BufferedOutputStream ok;

    public n(File file, int i4) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.bl = randomAccessFile;
            this.f49967a = randomAccessFile.getFD();
            if (i4 > 0) {
                if (i4 < 8192) {
                    i4 = 8192;
                } else if (i4 > 131072) {
                    i4 = 131072;
                }
                this.ok = new BufferedOutputStream(new FileOutputStream(this.bl.getFD()), i4);
                return;
            }
            this.ok = new BufferedOutputStream(new FileOutputStream(this.bl.getFD()));
        } catch (IOException e4) {
            throw new BaseException(1039, e4);
        }
    }

    public void a() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.ok;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void bl() throws IOException {
        FileDescriptor fileDescriptor = this.f49967a;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        kf.ok(this.bl, this.ok);
    }

    public void ok(byte[] bArr, int i4, int i5) throws IOException {
        this.ok.write(bArr, i4, i5);
    }

    public void ok() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.ok;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f49967a;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void a(long j4) throws IOException {
        this.bl.setLength(j4);
    }

    public void ok(long j4) throws IOException {
        this.bl.seek(j4);
    }
}
