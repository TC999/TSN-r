package com.bytedance.pangle.util.b;

import com.bytedance.pangle.util.b.b.d;
import com.bytedance.pangle.util.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final d f28982a;

    /* renamed from: b  reason: collision with root package name */
    final com.bytedance.pangle.util.b.a.b f28983b = new com.bytedance.pangle.util.b.a.b();

    public a(d dVar) {
        this.f28982a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j4, long j5, String str) {
        g.a(randomAccessFile, randomAccessFile2, j4, j4 + j5, str);
    }
}
