package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ContentLengthInputStream.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b extends FilterInputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final String f18058c = "ContentLengthStream";

    /* renamed from: d  reason: collision with root package name */
    private static final int f18059d = -1;

    /* renamed from: a  reason: collision with root package name */
    private final long f18060a;

    /* renamed from: b  reason: collision with root package name */
    private int f18061b;

    private b(@NonNull InputStream inputStream, long j4) {
        super(inputStream);
        this.f18060a = j4;
    }

    private int a(int i4) throws IOException {
        if (i4 >= 0) {
            this.f18061b += i4;
        } else if (this.f18060a - this.f18061b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f18060a + ", but read: " + this.f18061b);
        }
        return i4;
    }

    @NonNull
    public static InputStream b(@NonNull InputStream inputStream, long j4) {
        return new b(inputStream, j4);
    }

    @NonNull
    public static InputStream c(@NonNull InputStream inputStream, @Nullable String str) {
        return b(inputStream, e(str));
    }

    private static int e(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e4) {
                if (Log.isLoggable("ContentLengthStream", 3)) {
                    Log.d("ContentLengthStream", "failed to parse content length header: " + str, e4);
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f18060a - this.f18061b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i4, int i5) throws IOException {
        return a(super.read(bArr, i4, i5));
    }
}
