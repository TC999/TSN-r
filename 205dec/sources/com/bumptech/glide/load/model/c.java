package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ByteBufferEncoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c implements com.bumptech.glide.load.a<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f17268a = "ByteBufferEncoder";

    @Override // com.bumptech.glide.load.a
    /* renamed from: c */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) {
        try {
            com.bumptech.glide.util.a.e(byteBuffer, file);
            return true;
        } catch (IOException e4) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e4);
            }
            return false;
        }
    }
}
