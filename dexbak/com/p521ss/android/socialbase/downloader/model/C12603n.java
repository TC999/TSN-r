package com.p521ss.android.socialbase.downloader.model;

import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.ss.android.socialbase.downloader.model.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12603n implements Closeable {

    /* renamed from: a */
    private FileDescriptor f35518a;

    /* renamed from: bl */
    private RandomAccessFile f35519bl;

    /* renamed from: ok */
    private BufferedOutputStream f35520ok;

    public C12603n(File file, int i) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f35519bl = randomAccessFile;
            this.f35518a = randomAccessFile.getFD();
            if (i > 0) {
                if (i < 8192) {
                    i = 8192;
                } else if (i > 131072) {
                    i = 131072;
                }
                this.f35520ok = new BufferedOutputStream(new FileOutputStream(this.f35519bl.getFD()), i);
                return;
            }
            this.f35520ok = new BufferedOutputStream(new FileOutputStream(this.f35519bl.getFD()));
        } catch (IOException e) {
            throw new BaseException(1039, e);
        }
    }

    /* renamed from: a */
    public void m16996a() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f35520ok;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    /* renamed from: bl */
    public void m16994bl() throws IOException {
        FileDescriptor fileDescriptor = this.f35518a;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C12713kf.m16531ok(this.f35519bl, this.f35520ok);
    }

    /* renamed from: ok */
    public void m16991ok(byte[] bArr, int i, int i2) throws IOException {
        this.f35520ok.write(bArr, i, i2);
    }

    /* renamed from: ok */
    public void m16993ok() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f35520ok;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f35518a;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    /* renamed from: a */
    public void m16995a(long j) throws IOException {
        this.f35519bl.setLength(j);
    }

    /* renamed from: ok */
    public void m16992ok(long j) throws IOException {
        this.f35519bl.seek(j);
    }
}
