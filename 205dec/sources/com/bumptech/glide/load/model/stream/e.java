package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.n;
import com.bumptech.glide.load.model.o;
import com.bumptech.glide.load.model.r;
import com.bumptech.glide.load.resource.bitmap.c0;
import com.stub.StubApp;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MediaStoreVideoThumbLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17357a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MediaStoreVideoThumbLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17358a;

        public a(Context context) {
            this.f17358a = context;
        }

        @Override // com.bumptech.glide.load.model.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new e(this.f17358a);
        }
    }

    public e(Context context) {
        this.f17357a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private boolean e(com.bumptech.glide.load.f fVar) {
        Long l4 = (Long) fVar.c(c0.f17392g);
        return l4 != null && l4.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.model.n
    @Nullable
    /* renamed from: c */
    public n.a<InputStream> b(@NonNull Uri uri, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        if (com.bumptech.glide.load.data.mediastore.b.d(i4, i5) && e(fVar)) {
            return new n.a<>(new com.bumptech.glide.signature.d(uri), com.bumptech.glide.load.data.mediastore.c.f(this.f17357a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.n
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return com.bumptech.glide.load.data.mediastore.b.c(uri);
    }
}
