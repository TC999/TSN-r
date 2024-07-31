package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.util.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: c */
    private static final String f14540c = "ContentLengthStream";

    /* renamed from: d */
    private static final int f14541d = -1;

    /* renamed from: a */
    private final long f14542a;

    /* renamed from: b */
    private int f14543b;

    private ContentLengthInputStream(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f14542a = j;
    }

    /* renamed from: a */
    private int m44424a(int i) throws IOException {
        if (i >= 0) {
            this.f14543b += i;
        } else if (this.f14542a - this.f14543b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f14542a + ", but read: " + this.f14543b);
        }
        return i;
    }

    @NonNull
    /* renamed from: b */
    public static InputStream m44423b(@NonNull InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    @NonNull
    /* renamed from: c */
    public static InputStream m44422c(@NonNull InputStream inputStream, @Nullable String str) {
        return m44423b(inputStream, m44421e(str));
    }

    /* renamed from: e */
    private static int m44421e(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (Log.isLoggable(f14540c, 3)) {
                    Log.d(f14540c, "failed to parse content length header: " + str, e);
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f14542a - this.f14543b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        m44424a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return m44424a(super.read(bArr, i, i2));
    }
}
