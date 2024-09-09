package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StreamGifDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i implements com.bumptech.glide.load.g<InputStream, GifDrawable> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f17563d = "StreamGifDecoder";

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f17564a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.g<ByteBuffer, GifDrawable> f17565b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f17566c;

    public i(List<ImageHeaderParser> list, com.bumptech.glide.load.g<ByteBuffer, GifDrawable> gVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f17564a = list;
        this.f17565b = gVar;
        this.f17566c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e4) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e4);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c */
    public u<GifDrawable> b(@NonNull InputStream inputStream, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        byte[] e4 = e(inputStream);
        if (e4 == null) {
            return null;
        }
        return this.f17565b.b(ByteBuffer.wrap(e4), i4, i5, fVar);
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return !((Boolean) fVar.c(h.f17562b)).booleanValue() && com.bumptech.glide.load.b.getType(this.f17564a, inputStream, this.f17566c) == ImageHeaderParser.ImageType.GIF;
    }
}
