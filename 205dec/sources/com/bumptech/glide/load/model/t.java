package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StreamEncoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class t implements com.bumptech.glide.load.a<InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f17360b = "StreamEncoder";

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f17361a;

    public t(com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f17361a = bVar;
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: c */
    public boolean a(@NonNull InputStream inputStream, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) {
        byte[] bArr = (byte[]) this.f17361a.c(65536, byte[].class);
        boolean z3 = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (IOException e4) {
                            e = e4;
                            fileOutputStream = fileOutputStream2;
                            if (Log.isLoggable("StreamEncoder", 3)) {
                                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.f17361a.put(bArr);
                            return z3;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.f17361a.put(bArr);
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    z3 = true;
                    fileOutputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (IOException unused2) {
        }
        this.f17361a.put(bArr);
        return z3;
    }
}
