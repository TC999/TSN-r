package com.kwad.framework.filedownloader.p352e;

import com.kwad.framework.filedownloader.p353f.C9492c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/* renamed from: com.kwad.framework.filedownloader.e.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9481b implements InterfaceC9480a {
    private final BufferedOutputStream aig;
    private final RandomAccessFile aih;

    /* renamed from: fd */
    private final FileDescriptor f29485fd;

    /* renamed from: com.kwad.framework.filedownloader.e.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9482a implements C9492c.InterfaceC9497e {
        @Override // com.kwad.framework.filedownloader.p353f.C9492c.InterfaceC9497e
        /* renamed from: c */
        public final InterfaceC9480a mo28541c(File file) {
            return new C9481b(file);
        }
    }

    C9481b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.aih = randomAccessFile;
        this.f29485fd = randomAccessFile.getFD();
        this.aig = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // com.kwad.framework.filedownloader.p352e.InterfaceC9480a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.aig.close();
        this.aih.close();
    }

    @Override // com.kwad.framework.filedownloader.p352e.InterfaceC9480a
    public final void seek(long j) {
        this.aih.seek(j);
    }

    @Override // com.kwad.framework.filedownloader.p352e.InterfaceC9480a
    public final void setLength(long j) {
        this.aih.setLength(j);
    }

    @Override // com.kwad.framework.filedownloader.p352e.InterfaceC9480a
    /* renamed from: wI */
    public final void mo28567wI() {
        this.aig.flush();
        this.f29485fd.sync();
    }

    @Override // com.kwad.framework.filedownloader.p352e.InterfaceC9480a
    public final void write(byte[] bArr, int i, int i2) {
        this.aig.write(bArr, 0, i2);
    }
}
