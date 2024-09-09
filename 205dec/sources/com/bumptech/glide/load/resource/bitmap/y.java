package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.n;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StreamBitmapDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class y implements com.bumptech.glide.load.g<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final n f17487a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f17488b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: StreamBitmapDecoder.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a implements n.b {

        /* renamed from: a  reason: collision with root package name */
        private final u f17489a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.util.c f17490b;

        a(u uVar, com.bumptech.glide.util.c cVar) {
            this.f17489a = uVar;
            this.f17490b = cVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.n.b
        public void a(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) throws IOException {
            IOException b4 = this.f17490b.b();
            if (b4 != null) {
                if (bitmap != null) {
                    eVar.d(bitmap);
                }
                throw b4;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.n.b
        public void b() {
            this.f17489a.b();
        }
    }

    public y(n nVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f17487a = nVar;
        this.f17488b = bVar;
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull InputStream inputStream, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        u uVar;
        boolean z3;
        if (inputStream instanceof u) {
            uVar = (u) inputStream;
            z3 = false;
        } else {
            uVar = new u(inputStream, this.f17488b);
            z3 = true;
        }
        com.bumptech.glide.util.c c4 = com.bumptech.glide.util.c.c(uVar);
        try {
            return this.f17487a.e(new com.bumptech.glide.util.h(c4), i4, i5, fVar, new a(uVar, c4));
        } finally {
            c4.d();
            if (z3) {
                uVar.c();
            }
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f17487a.m(inputStream);
    }
}
