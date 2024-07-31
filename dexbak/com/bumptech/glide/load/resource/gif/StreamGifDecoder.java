package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.bumptech.glide.load.resource.gif.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    /* renamed from: d */
    private static final String f14246d = "StreamGifDecoder";

    /* renamed from: a */
    private final List<ImageHeaderParser> f14247a;

    /* renamed from: b */
    private final ResourceDecoder<ByteBuffer, GifDrawable> f14248b;

    /* renamed from: c */
    private final ArrayPool f14249c;

    public StreamGifDecoder(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.f14247a = list;
        this.f14248b = resourceDecoder;
        this.f14249c = arrayPool;
    }

    /* renamed from: e */
    private static byte[] m44790e(InputStream inputStream) {
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
        } catch (IOException e) {
            if (Log.isLoggable(f14246d, 5)) {
                Log.w(f14246d, "Error reading data from stream", e);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<GifDrawable> mo2813b(@NonNull InputStream inputStream, int i, int i2, @NonNull Options options) throws IOException {
        byte[] m44790e = m44790e(inputStream);
        if (m44790e == null) {
            return null;
        }
        return this.f14248b.mo2813b(ByteBuffer.wrap(m44790e), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean mo2814a(@NonNull InputStream inputStream, @NonNull Options options) throws IOException {
        return !((Boolean) options.m45124c(GifOptions.f14245b)).booleanValue() && ImageHeaderParserUtils.getType(this.f14247a, inputStream, this.f14249c) == ImageHeaderParser.ImageType.GIF;
    }
}
