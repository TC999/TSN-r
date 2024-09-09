package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.u;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ImageHeaderParserUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f16791a = 5242880;

    private b() {
    }

    public static int a(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new u(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            try {
                int b4 = list.get(i4).b(inputStream, bVar);
                if (b4 != -1) {
                    return b4;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new u(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            try {
                ImageHeaderParser.ImageType type = list.get(i4).getType(inputStream);
                if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                    return type;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            ImageHeaderParser.ImageType type = list.get(i4).getType(byteBuffer);
            if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
