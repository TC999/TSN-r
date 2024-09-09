package com.kwad.framework.filedownloader.e;

import com.kwad.framework.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements com.kwad.framework.filedownloader.e.a {
    private final BufferedOutputStream aig;
    private final RandomAccessFile aih;
    private final FileDescriptor fd;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements c.e {
        @Override // com.kwad.framework.filedownloader.f.c.e
        public final com.kwad.framework.filedownloader.e.a c(File file) {
            return new b(file);
        }
    }

    b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.aih = randomAccessFile;
        this.fd = randomAccessFile.getFD();
        this.aig = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // com.kwad.framework.filedownloader.e.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.aig.close();
        this.aih.close();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void seek(long j4) {
        this.aih.seek(j4);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void setLength(long j4) {
        this.aih.setLength(j4);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void wI() {
        this.aig.flush();
        this.fd.sync();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void write(byte[] bArr, int i4, int i5) {
        this.aig.write(bArr, 0, i5);
    }
}
