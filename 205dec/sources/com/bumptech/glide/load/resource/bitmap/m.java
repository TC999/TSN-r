package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DefaultImageHeaderParser.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class m implements ImageHeaderParser {

    /* renamed from: b  reason: collision with root package name */
    private static final String f17415b = "DfltImageHeaderParser";

    /* renamed from: c  reason: collision with root package name */
    private static final int f17416c = 4671814;

    /* renamed from: d  reason: collision with root package name */
    private static final int f17417d = -1991225785;

    /* renamed from: e  reason: collision with root package name */
    static final int f17418e = 65496;

    /* renamed from: f  reason: collision with root package name */
    private static final int f17419f = 19789;

    /* renamed from: g  reason: collision with root package name */
    private static final int f17420g = 18761;

    /* renamed from: h  reason: collision with root package name */
    private static final String f17421h = "Exif\u0000\u0000";

    /* renamed from: j  reason: collision with root package name */
    private static final int f17423j = 218;

    /* renamed from: k  reason: collision with root package name */
    private static final int f17424k = 217;

    /* renamed from: l  reason: collision with root package name */
    static final int f17425l = 255;

    /* renamed from: m  reason: collision with root package name */
    static final int f17426m = 225;

    /* renamed from: n  reason: collision with root package name */
    private static final int f17427n = 274;

    /* renamed from: p  reason: collision with root package name */
    private static final int f17429p = 1380533830;

    /* renamed from: q  reason: collision with root package name */
    private static final int f17430q = 1464156752;

    /* renamed from: r  reason: collision with root package name */
    private static final int f17431r = 1448097792;

    /* renamed from: s  reason: collision with root package name */
    private static final int f17432s = -256;

    /* renamed from: t  reason: collision with root package name */
    private static final int f17433t = 255;

    /* renamed from: u  reason: collision with root package name */
    private static final int f17434u = 88;

    /* renamed from: v  reason: collision with root package name */
    private static final int f17435v = 76;

    /* renamed from: w  reason: collision with root package name */
    private static final int f17436w = 16;

    /* renamed from: x  reason: collision with root package name */
    private static final int f17437x = 8;

    /* renamed from: i  reason: collision with root package name */
    static final byte[] f17422i = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f17428o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17438a;

        a(ByteBuffer byteBuffer) {
            this.f17438a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public int a() {
            return ((c() << 8) & 65280) | (c() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public short b() {
            return (short) (c() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public int c() {
            if (this.f17438a.remaining() < 1) {
                return -1;
            }
            return this.f17438a.get();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public int read(byte[] bArr, int i4) {
            int min = Math.min(i4, this.f17438a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f17438a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public long skip(long j4) {
            int min = (int) Math.min(this.f17438a.remaining(), j4);
            ByteBuffer byteBuffer = this.f17438a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17439a;

        b(byte[] bArr, int i4) {
            this.f17439a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i4);
        }

        private boolean c(int i4, int i5) {
            return this.f17439a.remaining() - i4 >= i5;
        }

        short a(int i4) {
            if (c(i4, 2)) {
                return this.f17439a.getShort(i4);
            }
            return (short) -1;
        }

        int b(int i4) {
            if (c(i4, 4)) {
                return this.f17439a.getInt(i4);
            }
            return -1;
        }

        int d() {
            return this.f17439a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f17439a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface c {
        int a() throws IOException;

        short b() throws IOException;

        int c() throws IOException;

        int read(byte[] bArr, int i4) throws IOException;

        long skip(long j4) throws IOException;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f17440a;

        d(InputStream inputStream) {
            this.f17440a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public int a() throws IOException {
            return ((this.f17440a.read() << 8) & 65280) | (this.f17440a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public short b() throws IOException {
            return (short) (this.f17440a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public int c() throws IOException {
            return this.f17440a.read();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public int read(byte[] bArr, int i4) throws IOException {
            int i5 = i4;
            while (i5 > 0) {
                int read = this.f17440a.read(bArr, i4 - i5, i5);
                if (read == -1) {
                    break;
                }
                i5 -= read;
            }
            return i4 - i5;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.c
        public long skip(long j4) throws IOException {
            if (j4 < 0) {
                return 0L;
            }
            long j5 = j4;
            while (j5 > 0) {
                long skip = this.f17440a.skip(j5);
                if (skip <= 0) {
                    if (this.f17440a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j5 -= skip;
            }
            return j4 - j5;
        }
    }

    private static int c(int i4, int i5) {
        return i4 + 2 + (i5 * 12);
    }

    private int d(c cVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        int a4 = cVar.a();
        if (!e(a4)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a4);
            }
            return -1;
        }
        int g4 = g(cVar);
        if (g4 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.c(g4, byte[].class);
        try {
            return i(cVar, bArr, g4);
        } finally {
            bVar.put(bArr);
        }
    }

    private static boolean e(int i4) {
        return (i4 & 65496) == 65496 || i4 == 19789 || i4 == 18761;
    }

    private boolean f(byte[] bArr, int i4) {
        boolean z3 = bArr != null && i4 > f17422i.length;
        if (z3) {
            int i5 = 0;
            while (true) {
                byte[] bArr2 = f17422i;
                if (i5 >= bArr2.length) {
                    break;
                } else if (bArr[i5] != bArr2[i5]) {
                    return false;
                } else {
                    i5++;
                }
            }
        }
        return z3;
    }

    private int g(c cVar) throws IOException {
        short b4;
        short b5;
        int a4;
        long j4;
        long skip;
        do {
            if (cVar.b() != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) b4));
                }
                return -1;
            }
            b5 = cVar.b();
            if (b5 == 218) {
                return -1;
            }
            if (b5 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a4 = cVar.a() - 2;
            if (b5 == 225) {
                return a4;
            }
            j4 = a4;
            skip = cVar.skip(j4);
        } while (skip == j4);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) b5) + ", wanted to skip: " + a4 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int h(b bVar) {
        ByteOrder byteOrder;
        short a4 = bVar.a(6);
        if (a4 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a4 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) a4));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.e(byteOrder);
        int b4 = bVar.b(10) + 6;
        short a5 = bVar.a(b4);
        for (int i4 = 0; i4 < a5; i4++) {
            int c4 = c(b4, i4);
            short a6 = bVar.a(c4);
            if (a6 == 274) {
                short a7 = bVar.a(c4 + 2);
                if (a7 >= 1 && a7 <= 12) {
                    int b5 = bVar.b(c4 + 4);
                    if (b5 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i4 + " tagType=" + ((int) a6) + " formatCode=" + ((int) a7) + " componentCount=" + b5);
                        }
                        int i5 = b5 + f17428o[a7];
                        if (i5 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a7));
                            }
                        } else {
                            int i6 = c4 + 8;
                            if (i6 >= 0 && i6 <= bVar.d()) {
                                if (i5 >= 0 && i5 + i6 <= bVar.d()) {
                                    return bVar.a(i6);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a6));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i6 + " tagType=" + ((int) a6));
                            }
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) a7));
                }
            }
        }
        return -1;
    }

    private int i(c cVar, byte[] bArr, int i4) throws IOException {
        int read = cVar.read(bArr, i4);
        if (read != i4) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i4 + ", actually read: " + read);
            }
            return -1;
        } else if (f(bArr, i4)) {
            return h(new b(bArr, i4));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return d(new a((ByteBuffer) com.bumptech.glide.util.j.d(byteBuffer)), (com.bumptech.glide.load.engine.bitmap_recycle.b) com.bumptech.glide.util.j.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return d(new d((InputStream) com.bumptech.glide.util.j.d(inputStream)), (com.bumptech.glide.load.engine.bitmap_recycle.b) com.bumptech.glide.util.j.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        return getType(new d((InputStream) com.bumptech.glide.util.j.d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        return getType(new a((ByteBuffer) com.bumptech.glide.util.j.d(byteBuffer)));
    }

    @NonNull
    private ImageHeaderParser.ImageType getType(c cVar) throws IOException {
        int a4 = cVar.a();
        if (a4 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int a5 = ((a4 << 16) & (-65536)) | (cVar.a() & 65535);
        if (a5 == -1991225785) {
            cVar.skip(21L);
            return cVar.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((a5 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (a5 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4L);
            if ((((cVar.a() << 16) & (-65536)) | (cVar.a() & 65535)) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int a6 = ((cVar.a() << 16) & (-65536)) | (cVar.a() & 65535);
            if ((a6 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i4 = a6 & 255;
            if (i4 == 88) {
                cVar.skip(4L);
                return (cVar.c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i4 == 76) {
                cVar.skip(4L);
                return (cVar.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else {
                return ImageHeaderParser.ImageType.WEBP;
            }
        }
    }
}
