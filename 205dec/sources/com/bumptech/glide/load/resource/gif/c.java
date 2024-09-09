package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.u;
import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GifDrawableEncoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c implements com.bumptech.glide.load.h<GifDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f17535a = "GifEncoder";

    @Override // com.bumptech.glide.load.h
    @NonNull
    public EncodeStrategy b(@NonNull com.bumptech.glide.load.f fVar) {
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: c */
    public boolean a(@NonNull u<GifDrawable> uVar, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) {
        try {
            com.bumptech.glide.util.a.e(uVar.get().c(), file);
            return true;
        } catch (IOException e4) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e4);
            }
            return false;
        }
    }
}
