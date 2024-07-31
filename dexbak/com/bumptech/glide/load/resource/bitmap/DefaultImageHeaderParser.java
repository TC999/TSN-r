package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.C3770j;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* renamed from: com.bumptech.glide.load.resource.bitmap.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: b */
    private static final String f14098b = "DfltImageHeaderParser";

    /* renamed from: c */
    private static final int f14099c = 4671814;

    /* renamed from: d */
    private static final int f14100d = -1991225785;

    /* renamed from: e */
    static final int f14101e = 65496;

    /* renamed from: f */
    private static final int f14102f = 19789;

    /* renamed from: g */
    private static final int f14103g = 18761;

    /* renamed from: j */
    private static final int f14106j = 218;

    /* renamed from: k */
    private static final int f14107k = 217;

    /* renamed from: l */
    static final int f14108l = 255;

    /* renamed from: m */
    static final int f14109m = 225;

    /* renamed from: n */
    private static final int f14110n = 274;

    /* renamed from: p */
    private static final int f14112p = 1380533830;

    /* renamed from: q */
    private static final int f14113q = 1464156752;

    /* renamed from: r */
    private static final int f14114r = 1448097792;

    /* renamed from: s */
    private static final int f14115s = -256;

    /* renamed from: t */
    private static final int f14116t = 255;

    /* renamed from: u */
    private static final int f14117u = 88;

    /* renamed from: v */
    private static final int f14118v = 76;

    /* renamed from: w */
    private static final int f14119w = 16;

    /* renamed from: x */
    private static final int f14120x = 8;

    /* renamed from: h */
    private static final String f14104h = "Exif\u0000\u0000";

    /* renamed from: i */
    static final byte[] f14105i = f14104h.getBytes(Charset.forName("UTF-8"));

    /* renamed from: o */
    private static final int[] f14111o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.m$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3717a implements InterfaceC3719c {

        /* renamed from: a */
        private final ByteBuffer f14121a;

        C3717a(ByteBuffer byteBuffer) {
            this.f14121a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        /* renamed from: a */
        public int mo44951a() {
            return ((mo44949c() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (mo44949c() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        /* renamed from: b */
        public short mo44950b() {
            return (short) (mo44949c() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        /* renamed from: c */
        public int mo44949c() {
            if (this.f14121a.remaining() < 1) {
                return -1;
            }
            return this.f14121a.get();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        public int read(byte[] bArr, int i) {
            int min = Math.min(i, this.f14121a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f14121a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        public long skip(long j) {
            int min = (int) Math.min(this.f14121a.remaining(), j);
            ByteBuffer byteBuffer = this.f14121a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.m$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3718b {

        /* renamed from: a */
        private final ByteBuffer f14122a;

        C3718b(byte[] bArr, int i) {
            this.f14122a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        /* renamed from: c */
        private boolean m44954c(int i, int i2) {
            return this.f14122a.remaining() - i >= i2;
        }

        /* renamed from: a */
        short m44956a(int i) {
            if (m44954c(i, 2)) {
                return this.f14122a.getShort(i);
            }
            return (short) -1;
        }

        /* renamed from: b */
        int m44955b(int i) {
            if (m44954c(i, 4)) {
                return this.f14122a.getInt(i);
            }
            return -1;
        }

        /* renamed from: d */
        int m44953d() {
            return this.f14122a.remaining();
        }

        /* renamed from: e */
        void m44952e(ByteOrder byteOrder) {
            this.f14122a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.m$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3719c {
        /* renamed from: a */
        int mo44951a() throws IOException;

        /* renamed from: b */
        short mo44950b() throws IOException;

        /* renamed from: c */
        int mo44949c() throws IOException;

        int read(byte[] bArr, int i) throws IOException;

        long skip(long j) throws IOException;
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.m$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3720d implements InterfaceC3719c {

        /* renamed from: a */
        private final InputStream f14123a;

        C3720d(InputStream inputStream) {
            this.f14123a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        /* renamed from: a */
        public int mo44951a() throws IOException {
            return ((this.f14123a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f14123a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        /* renamed from: b */
        public short mo44950b() throws IOException {
            return (short) (this.f14123a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        /* renamed from: c */
        public int mo44949c() throws IOException {
            return this.f14123a.read();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        public int read(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f14123a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC3719c
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f14123a.skip(j2);
                if (skip <= 0) {
                    if (this.f14123a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    /* renamed from: c */
    private static int m44963c(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    /* renamed from: d */
    private int m44962d(InterfaceC3719c interfaceC3719c, ArrayPool arrayPool) throws IOException {
        int mo44951a = interfaceC3719c.mo44951a();
        if (!m44961e(mo44951a)) {
            if (Log.isLoggable(f14098b, 3)) {
                Log.d(f14098b, "Parser doesn't handle magic number: " + mo44951a);
            }
            return -1;
        }
        int m44959g = m44959g(interfaceC3719c);
        if (m44959g == -1) {
            if (Log.isLoggable(f14098b, 3)) {
                Log.d(f14098b, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) arrayPool.mo45394c(m44959g, byte[].class);
        try {
            return m44957i(interfaceC3719c, bArr, m44959g);
        } finally {
            arrayPool.put(bArr);
        }
    }

    /* renamed from: e */
    private static boolean m44961e(int i) {
        return (i & f14101e) == f14101e || i == f14102f || i == f14103g;
    }

    /* renamed from: f */
    private boolean m44960f(byte[] bArr, int i) {
        boolean z = bArr != null && i > f14105i.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = f14105i;
                if (i2 >= bArr2.length) {
                    break;
                } else if (bArr[i2] != bArr2[i2]) {
                    return false;
                } else {
                    i2++;
                }
            }
        }
        return z;
    }

    /* renamed from: g */
    private int m44959g(InterfaceC3719c interfaceC3719c) throws IOException {
        short mo44950b;
        short mo44950b2;
        int mo44951a;
        long j;
        long skip;
        do {
            if (interfaceC3719c.mo44950b() != 255) {
                if (Log.isLoggable(f14098b, 3)) {
                    Log.d(f14098b, "Unknown segmentId=" + ((int) mo44950b));
                }
                return -1;
            }
            mo44950b2 = interfaceC3719c.mo44950b();
            if (mo44950b2 == f14106j) {
                return -1;
            }
            if (mo44950b2 == f14107k) {
                if (Log.isLoggable(f14098b, 3)) {
                    Log.d(f14098b, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            mo44951a = interfaceC3719c.mo44951a() - 2;
            if (mo44950b2 == f14109m) {
                return mo44951a;
            }
            j = mo44951a;
            skip = interfaceC3719c.skip(j);
        } while (skip == j);
        if (Log.isLoggable(f14098b, 3)) {
            Log.d(f14098b, "Unable to skip enough data, type: " + ((int) mo44950b2) + ", wanted to skip: " + mo44951a + ", but actually skipped: " + skip);
        }
        return -1;
    }

    /* renamed from: h */
    private static int m44958h(C3718b c3718b) {
        ByteOrder byteOrder;
        short m44956a = c3718b.m44956a(6);
        if (m44956a == f14103g) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (m44956a != f14102f) {
            if (Log.isLoggable(f14098b, 3)) {
                Log.d(f14098b, "Unknown endianness = " + ((int) m44956a));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        c3718b.m44952e(byteOrder);
        int m44955b = c3718b.m44955b(10) + 6;
        short m44956a2 = c3718b.m44956a(m44955b);
        for (int i = 0; i < m44956a2; i++) {
            int m44963c = m44963c(m44955b, i);
            short m44956a3 = c3718b.m44956a(m44963c);
            if (m44956a3 == f14110n) {
                short m44956a4 = c3718b.m44956a(m44963c + 2);
                if (m44956a4 >= 1 && m44956a4 <= 12) {
                    int m44955b2 = c3718b.m44955b(m44963c + 4);
                    if (m44955b2 < 0) {
                        if (Log.isLoggable(f14098b, 3)) {
                            Log.d(f14098b, "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable(f14098b, 3)) {
                            Log.d(f14098b, "Got tagIndex=" + i + " tagType=" + ((int) m44956a3) + " formatCode=" + ((int) m44956a4) + " componentCount=" + m44955b2);
                        }
                        int i2 = m44955b2 + f14111o[m44956a4];
                        if (i2 > 4) {
                            if (Log.isLoggable(f14098b, 3)) {
                                Log.d(f14098b, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) m44956a4));
                            }
                        } else {
                            int i3 = m44963c + 8;
                            if (i3 >= 0 && i3 <= c3718b.m44953d()) {
                                if (i2 >= 0 && i2 + i3 <= c3718b.m44953d()) {
                                    return c3718b.m44956a(i3);
                                }
                                if (Log.isLoggable(f14098b, 3)) {
                                    Log.d(f14098b, "Illegal number of bytes for TI tag data tagType=" + ((int) m44956a3));
                                }
                            } else if (Log.isLoggable(f14098b, 3)) {
                                Log.d(f14098b, "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) m44956a3));
                            }
                        }
                    }
                } else if (Log.isLoggable(f14098b, 3)) {
                    Log.d(f14098b, "Got invalid format code = " + ((int) m44956a4));
                }
            }
        }
        return -1;
    }

    /* renamed from: i */
    private int m44957i(InterfaceC3719c interfaceC3719c, byte[] bArr, int i) throws IOException {
        int read = interfaceC3719c.read(bArr, i);
        if (read != i) {
            if (Log.isLoggable(f14098b, 3)) {
                Log.d(f14098b, "Unable to read exif segment data, length: " + i + ", actually read: " + read);
            }
            return -1;
        } else if (m44960f(bArr, i)) {
            return m44958h(new C3718b(bArr, i));
        } else {
            if (Log.isLoggable(f14098b, 3)) {
                Log.d(f14098b, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: a */
    public int mo44921a(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException {
        return m44962d(new C3717a((ByteBuffer) C3770j.m44392d(byteBuffer)), (ArrayPool) C3770j.m44392d(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: b */
    public int mo44920b(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        return m44962d(new C3720d((InputStream) C3770j.m44392d(inputStream)), (ArrayPool) C3770j.m44392d(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        return getType(new C3720d((InputStream) C3770j.m44392d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        return getType(new C3717a((ByteBuffer) C3770j.m44392d(byteBuffer)));
    }

    @NonNull
    private ImageHeaderParser.ImageType getType(InterfaceC3719c interfaceC3719c) throws IOException {
        int mo44951a = interfaceC3719c.mo44951a();
        if (mo44951a == f14101e) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int mo44951a2 = ((mo44951a << 16) & SupportMenu.CATEGORY_MASK) | (interfaceC3719c.mo44951a() & 65535);
        if (mo44951a2 == f14100d) {
            interfaceC3719c.skip(21L);
            return interfaceC3719c.mo44949c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((mo44951a2 >> 8) == f14099c) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (mo44951a2 != f14112p) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            interfaceC3719c.skip(4L);
            if ((((interfaceC3719c.mo44951a() << 16) & SupportMenu.CATEGORY_MASK) | (interfaceC3719c.mo44951a() & 65535)) != f14113q) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int mo44951a3 = ((interfaceC3719c.mo44951a() << 16) & SupportMenu.CATEGORY_MASK) | (interfaceC3719c.mo44951a() & 65535);
            if ((mo44951a3 & (-256)) != f14114r) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = mo44951a3 & 255;
            if (i == 88) {
                interfaceC3719c.skip(4L);
                return (interfaceC3719c.mo44949c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i == 76) {
                interfaceC3719c.skip(4L);
                return (interfaceC3719c.mo44949c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else {
                return ImageHeaderParser.ImageType.WEBP;
            }
        }
    }
}
