package com.p521ss.android.p540ok;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.ss.android.ok.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12277ok implements InterfaceC12273a {

    /* renamed from: ok */
    private final RandomAccessFile f34620ok;

    public C12277ok(File file) throws FileNotFoundException {
        this.f34620ok = new RandomAccessFile(file, "r");
    }

    @Override // com.p521ss.android.p540ok.InterfaceC12273a
    /* renamed from: a */
    public void mo18496a() throws IOException {
        this.f34620ok.close();
    }

    @Override // com.p521ss.android.p540ok.InterfaceC12273a
    /* renamed from: ok */
    public long mo18495ok() throws IOException {
        return this.f34620ok.length();
    }

    @Override // com.p521ss.android.p540ok.InterfaceC12273a
    /* renamed from: ok */
    public int mo18493ok(byte[] bArr, int i, int i2) throws IOException {
        return this.f34620ok.read(bArr, i, i2);
    }

    @Override // com.p521ss.android.p540ok.InterfaceC12273a
    /* renamed from: ok */
    public void mo18494ok(long j, long j2) throws IOException {
        this.f34620ok.seek(j);
    }
}
