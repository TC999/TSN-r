package com.bykv.vk.openvk.component.video.c.w;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class ev {

    /* renamed from: c  reason: collision with root package name */
    private final RandomAccessFile f25072c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class c extends Exception {
        c(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(File file, String str) throws c {
        try {
            this.f25072c = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e4) {
            throw new c(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j4) throws c {
        try {
            this.f25072c.seek(j4);
        } catch (IOException e4) {
            throw new c(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(byte[] bArr, int i4, int i5) throws c {
        try {
            this.f25072c.write(bArr, i4, i5);
        } catch (IOException e4) {
            throw new c(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(byte[] bArr) throws c {
        try {
            return this.f25072c.read(bArr);
        } catch (IOException e4) {
            throw new c(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        com.bykv.vk.openvk.component.video.c.xv.c.c(this.f25072c);
    }
}
