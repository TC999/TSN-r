package com.mbridge.msdk.foundation.download.resource.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FileDownloadRandomAccessDownloadFile implements DownloadFileOutputStream {
    private final BufferedOutputStream bufferedOutputStream;
    private final FileDescriptor fileDescriptor;
    private final RandomAccessFile randomAccess;

    public FileDownloadRandomAccessDownloadFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.randomAccess = randomAccessFile;
        this.fileDescriptor = randomAccessFile.getFD();
        this.bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    public static DownloadFileOutputStream create(File file) throws IOException {
        return new FileDownloadRandomAccessDownloadFile(file);
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void close() throws IOException {
        this.bufferedOutputStream.close();
        this.randomAccess.close();
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void flushAndSync() throws IOException {
        this.bufferedOutputStream.flush();
        this.fileDescriptor.sync();
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void seek(long j) throws IOException {
        this.randomAccess.seek(j);
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void setLength(long j) throws IOException {
        this.randomAccess.setLength(j);
    }

    @Override // com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.bufferedOutputStream.write(bArr, i, i2);
    }
}
