package com.ss.android.c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c implements w {

    /* renamed from: c  reason: collision with root package name */
    private final RandomAccessFile f48151c;

    public c(File file) throws FileNotFoundException {
        this.f48151c = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.c.w
    public long c() throws IOException {
        return this.f48151c.length();
    }

    @Override // com.ss.android.c.w
    public void w() throws IOException {
        this.f48151c.close();
    }

    @Override // com.ss.android.c.w
    public int c(byte[] bArr, int i4, int i5) throws IOException {
        return this.f48151c.read(bArr, i4, i5);
    }

    @Override // com.ss.android.c.w
    public void c(long j4, long j5) throws IOException {
        this.f48151c.seek(j4);
    }
}
