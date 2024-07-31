package com.bytedance.pangle.util.p127b;

import com.bytedance.pangle.util.C6251g;
import com.bytedance.pangle.util.p127b.p128a.C6240b;
import com.bytedance.pangle.util.p127b.p129b.C6246d;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* renamed from: com.bytedance.pangle.util.b.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6238a {

    /* renamed from: a */
    final C6246d f22212a;

    /* renamed from: b */
    final C6240b f22213b = new C6240b();

    public C6238a(C6246d c6246d) {
        this.f22212a = c6246d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m36927a(File file) {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m36926a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) {
        C6251g.m36897a(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }
}
