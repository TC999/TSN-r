package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.data.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* renamed from: b */
    private static final int f13499b = 5242880;

    /* renamed from: a */
    private final RecyclableBufferedInputStream f13500a;

    /* compiled from: InputStreamRewinder.java */
    /* renamed from: com.bumptech.glide.load.data.k$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3568a implements DataRewinder.InterfaceC3563a<InputStream> {

        /* renamed from: a */
        private final ArrayPool f13501a;

        public C3568a(ArrayPool arrayPool) {
            this.f13501a = arrayPool;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.InterfaceC3563a
        @NonNull
        /* renamed from: a */
        public Class<InputStream> mo2887a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.InterfaceC3563a
        @NonNull
        /* renamed from: c */
        public DataRewinder<InputStream> mo2886b(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f13501a);
        }
    }

    InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f13500a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    /* renamed from: b */
    public void mo2889b() {
        this.f13500a.m44910c();
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    /* renamed from: c */
    public InputStream mo2890a() throws IOException {
        this.f13500a.reset();
        return this.f13500a;
    }
}
