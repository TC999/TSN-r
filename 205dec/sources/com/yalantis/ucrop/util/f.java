package com.yalantis.ucrop.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ImageHeaderParser.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final String f54418b = "ImageHeaderParser";

    /* renamed from: c  reason: collision with root package name */
    public static final int f54419c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f54420d = 65496;

    /* renamed from: e  reason: collision with root package name */
    private static final int f54421e = 19789;

    /* renamed from: f  reason: collision with root package name */
    private static final int f54422f = 18761;

    /* renamed from: g  reason: collision with root package name */
    private static final String f54423g = "Exif\u0000\u0000";

    /* renamed from: i  reason: collision with root package name */
    private static final int f54425i = 218;

    /* renamed from: j  reason: collision with root package name */
    private static final int f54426j = 217;

    /* renamed from: k  reason: collision with root package name */
    private static final int f54427k = 255;

    /* renamed from: l  reason: collision with root package name */
    private static final int f54428l = 225;

    /* renamed from: m  reason: collision with root package name */
    private static final int f54429m = 274;

    /* renamed from: a  reason: collision with root package name */
    private final b f54431a;

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f54424h = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f54430n = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ImageHeaderParser.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f54432a;

        public a(byte[] bArr, int i4) {
            this.f54432a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i4);
        }

        public short a(int i4) {
            return this.f54432a.getShort(i4);
        }

        public int b(int i4) {
            return this.f54432a.getInt(i4);
        }

        public int c() {
            return this.f54432a.remaining();
        }

        public void d(ByteOrder byteOrder) {
            this.f54432a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ImageHeaderParser.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface b {
        int a() throws IOException;

        short b() throws IOException;

        int read(byte[] bArr, int i4) throws IOException;

        long skip(long j4) throws IOException;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ImageHeaderParser.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f54433a;

        public c(InputStream inputStream) {
            this.f54433a = inputStream;
        }

        @Override // com.yalantis.ucrop.util.f.b
        public int a() throws IOException {
            return ((this.f54433a.read() << 8) & 65280) | (this.f54433a.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.f.b
        public short b() throws IOException {
            return (short) (this.f54433a.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.f.b
        public int read(byte[] bArr, int i4) throws IOException {
            int i5 = i4;
            while (i5 > 0) {
                int read = this.f54433a.read(bArr, i4 - i5, i5);
                if (read == -1) {
                    break;
                }
                i5 -= read;
            }
            return i4 - i5;
        }

        @Override // com.yalantis.ucrop.util.f.b
        public long skip(long j4) throws IOException {
            if (j4 < 0) {
                return 0L;
            }
            long j5 = j4;
            while (j5 > 0) {
                long skip = this.f54433a.skip(j5);
                if (skip <= 0) {
                    if (this.f54433a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j5 -= skip;
            }
            return j4 - j5;
        }
    }

    public f(InputStream inputStream) {
        this.f54431a = new c(inputStream);
    }

    private static int a(int i4, int i5) {
        return i4 + 2 + (i5 * 12);
    }

    public static void b(ExifInterface exifInterface, int i4, int i5, String str) {
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            for (int i6 = 0; i6 < 22; i6++) {
                String str2 = strArr[i6];
                String attribute = exifInterface.getAttribute(str2);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
            }
            exifInterface2.setAttribute("ImageWidth", String.valueOf(i4));
            exifInterface2.setAttribute("ImageLength", String.valueOf(i5));
            exifInterface2.setAttribute("Orientation", "0");
            exifInterface2.saveAttributes();
        } catch (IOException e4) {
            Log.d("ImageHeaderParser", e4.getMessage());
        }
    }

    private static boolean d(int i4) {
        return (i4 & 65496) == 65496 || i4 == 19789 || i4 == 18761;
    }

    private boolean e(byte[] bArr, int i4) {
        boolean z3 = bArr != null && i4 > f54424h.length;
        if (z3) {
            int i5 = 0;
            while (true) {
                byte[] bArr2 = f54424h;
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

    private int f() throws IOException {
        short b4;
        short b5;
        int a4;
        long j4;
        long skip;
        do {
            if (this.f54431a.b() != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) b4));
                }
                return -1;
            }
            b5 = this.f54431a.b();
            if (b5 == 218) {
                return -1;
            }
            if (b5 == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a4 = this.f54431a.a() - 2;
            if (b5 == 225) {
                return a4;
            }
            j4 = a4;
            skip = this.f54431a.skip(j4);
        } while (skip == j4);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) b5) + ", wanted to skip: " + a4 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int g(a aVar) {
        ByteOrder byteOrder;
        short a4 = aVar.a(6);
        if (a4 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a4 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + ((int) a4));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.d(byteOrder);
        int b4 = aVar.b(10) + 6;
        short a5 = aVar.a(b4);
        for (int i4 = 0; i4 < a5; i4++) {
            int a6 = a(b4, i4);
            short a7 = aVar.a(a6);
            if (a7 == 274) {
                short a8 = aVar.a(a6 + 2);
                if (a8 >= 1 && a8 <= 12) {
                    int b5 = aVar.b(a6 + 4);
                    if (b5 < 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i4 + " tagType=" + ((int) a7) + " formatCode=" + ((int) a8) + " componentCount=" + b5);
                        }
                        int i5 = b5 + f54430n[a8];
                        if (i5 > 4) {
                            if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a8));
                            }
                        } else {
                            int i6 = a6 + 8;
                            if (i6 >= 0 && i6 <= aVar.c()) {
                                if (i5 >= 0 && i5 + i6 <= aVar.c()) {
                                    return aVar.a(i6);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a7));
                                }
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i6 + " tagType=" + ((int) a7));
                            }
                        }
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code = " + ((int) a8));
                }
            }
        }
        return -1;
    }

    private int h(byte[] bArr, int i4) throws IOException {
        int read = this.f54431a.read(bArr, i4);
        if (read != i4) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unable to read exif segment data, length: " + i4 + ", actually read: " + read);
            }
            return -1;
        } else if (e(bArr, i4)) {
            return g(new a(bArr, i4));
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public int c() throws IOException {
        int a4 = this.f54431a.a();
        if (!d(a4)) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Parser doesn't handle magic number: " + a4);
            }
            return -1;
        }
        int f4 = f();
        if (f4 == -1) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        return h(new byte[f4], f4);
    }
}
