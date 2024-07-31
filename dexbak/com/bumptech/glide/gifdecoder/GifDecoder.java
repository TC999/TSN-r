package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface GifDecoder {

    /* renamed from: a */
    public static final int f13339a = 0;

    /* renamed from: b */
    public static final int f13340b = 1;

    /* renamed from: c */
    public static final int f13341c = 2;

    /* renamed from: d */
    public static final int f13342d = 3;

    /* renamed from: e */
    public static final int f13343e = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface GifDecodeStatus {
    }

    /* renamed from: com.bumptech.glide.gifdecoder.GifDecoder$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3554a {
        /* renamed from: a */
        void mo44833a(@NonNull Bitmap bitmap);

        @NonNull
        /* renamed from: b */
        byte[] mo44832b(int i);

        @NonNull
        /* renamed from: c */
        Bitmap mo44831c(int i, int i2, @NonNull Bitmap.Config config);

        @NonNull
        /* renamed from: d */
        int[] mo44830d(int i);

        /* renamed from: e */
        void mo44829e(@NonNull byte[] bArr);

        /* renamed from: f */
        void mo44828f(@NonNull int[] iArr);
    }

    @Nullable
    /* renamed from: a */
    Bitmap mo45596a();

    /* renamed from: b */
    void mo45595b();

    /* renamed from: c */
    int mo45594c();

    void clear();

    /* renamed from: d */
    void mo45593d(@NonNull Bitmap.Config config);

    /* renamed from: e */
    int mo45592e(int i);

    /* renamed from: f */
    int mo45591f();

    @Deprecated
    /* renamed from: g */
    int mo45590g();

    @NonNull
    ByteBuffer getData();

    int getHeight();

    int getStatus();

    int getWidth();

    /* renamed from: h */
    void mo45589h(@NonNull GifHeader gifHeader, @NonNull byte[] bArr);

    /* renamed from: i */
    int mo45588i();

    /* renamed from: j */
    void mo45587j();

    /* renamed from: k */
    void mo45586k(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer);

    /* renamed from: l */
    int mo45585l();

    /* renamed from: m */
    void mo45584m(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i);

    /* renamed from: n */
    int mo45583n();

    /* renamed from: o */
    int mo45582o(@Nullable InputStream inputStream, int i);

    /* renamed from: p */
    int mo45581p();

    int read(@Nullable byte[] bArr);
}
