package com.ss.android.ok;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok implements a {
    private final RandomAccessFile ok;

    public ok(File file) throws FileNotFoundException {
        this.ok = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.ok.a
    public void a() throws IOException {
        this.ok.close();
    }

    @Override // com.ss.android.ok.a
    public long ok() throws IOException {
        return this.ok.length();
    }

    @Override // com.ss.android.ok.a
    public int ok(byte[] bArr, int i4, int i5) throws IOException {
        return this.ok.read(bArr, i4, i5);
    }

    @Override // com.ss.android.ok.a
    public void ok(long j4, long j5) throws IOException {
        this.ok.seek(j4);
    }
}
