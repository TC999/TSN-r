package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface GifDecoder {

    /* renamed from: a  reason: collision with root package name */
    public static final int f16683a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f16684b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f16685c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f16686d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f16687e = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface GifDecodeStatus {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a(@NonNull Bitmap bitmap);

        @NonNull
        byte[] b(int i4);

        @NonNull
        Bitmap c(int i4, int i5, @NonNull Bitmap.Config config);

        @NonNull
        int[] d(int i4);

        void e(@NonNull byte[] bArr);

        void f(@NonNull int[] iArr);
    }

    @Nullable
    Bitmap a();

    void b();

    int c();

    void clear();

    void d(@NonNull Bitmap.Config config);

    int e(int i4);

    int f();

    @Deprecated
    int g();

    @NonNull
    ByteBuffer getData();

    int getHeight();

    int getStatus();

    int getWidth();

    void h(@NonNull c cVar, @NonNull byte[] bArr);

    int i();

    void j();

    void k(@NonNull c cVar, @NonNull ByteBuffer byteBuffer);

    int l();

    void m(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i4);

    int n();

    int o(@Nullable InputStream inputStream, int i4);

    int p();

    int read(@Nullable byte[] bArr);
}
