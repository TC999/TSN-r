package com.yalantis.ucrop.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* renamed from: com.yalantis.ucrop.util.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ImageHeaderParser {

    /* renamed from: b */
    private static final String f39882b = "ImageHeaderParser";

    /* renamed from: c */
    public static final int f39883c = -1;

    /* renamed from: d */
    private static final int f39884d = 65496;

    /* renamed from: e */
    private static final int f39885e = 19789;

    /* renamed from: f */
    private static final int f39886f = 18761;

    /* renamed from: i */
    private static final int f39889i = 218;

    /* renamed from: j */
    private static final int f39890j = 217;

    /* renamed from: k */
    private static final int f39891k = 255;

    /* renamed from: l */
    private static final int f39892l = 225;

    /* renamed from: m */
    private static final int f39893m = 274;

    /* renamed from: a */
    private final InterfaceC13528b f39895a;

    /* renamed from: g */
    private static final String f39887g = "Exif\u0000\u0000";

    /* renamed from: h */
    private static final byte[] f39888h = f39887g.getBytes(Charset.forName("UTF-8"));

    /* renamed from: n */
    private static final int[] f39894n = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageHeaderParser.java */
    /* renamed from: com.yalantis.ucrop.util.f$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13527a {

        /* renamed from: a */
        private final ByteBuffer f39896a;

        public C13527a(byte[] bArr, int i) {
            this.f39896a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        /* renamed from: a */
        public short m12988a(int i) {
            return this.f39896a.getShort(i);
        }

        /* renamed from: b */
        public int m12987b(int i) {
            return this.f39896a.getInt(i);
        }

        /* renamed from: c */
        public int m12986c() {
            return this.f39896a.remaining();
        }

        /* renamed from: d */
        public void m12985d(ByteOrder byteOrder) {
            this.f39896a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageHeaderParser.java */
    /* renamed from: com.yalantis.ucrop.util.f$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13528b {
        /* renamed from: a */
        int mo12984a() throws IOException;

        /* renamed from: b */
        short mo12983b() throws IOException;

        int read(byte[] bArr, int i) throws IOException;

        long skip(long j) throws IOException;
    }

    /* compiled from: ImageHeaderParser.java */
    /* renamed from: com.yalantis.ucrop.util.f$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13529c implements InterfaceC13528b {

        /* renamed from: a */
        private final InputStream f39897a;

        public C13529c(InputStream inputStream) {
            this.f39897a = inputStream;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.InterfaceC13528b
        /* renamed from: a */
        public int mo12984a() throws IOException {
            return ((this.f39897a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f39897a.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.InterfaceC13528b
        /* renamed from: b */
        public short mo12983b() throws IOException {
            return (short) (this.f39897a.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.InterfaceC13528b
        public int read(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f39897a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.InterfaceC13528b
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f39897a.skip(j2);
                if (skip <= 0) {
                    if (this.f39897a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.f39895a = new C13529c(inputStream);
    }

    /* renamed from: a */
    private static int m12996a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    /* renamed from: b */
    public static void m12995b(ExifInterface exifInterface, int i, int i2, String str) {
        String[] strArr = {ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            for (int i3 = 0; i3 < 22; i3++) {
                String str2 = strArr[i3];
                String attribute = exifInterface.getAttribute(str2);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
            }
            exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i));
            exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i2));
            exifInterface2.setAttribute(ExifInterface.TAG_ORIENTATION, "0");
            exifInterface2.saveAttributes();
        } catch (IOException e) {
            Log.d(f39882b, e.getMessage());
        }
    }

    /* renamed from: d */
    private static boolean m12993d(int i) {
        return (i & f39884d) == f39884d || i == f39885e || i == f39886f;
    }

    /* renamed from: e */
    private boolean m12992e(byte[] bArr, int i) {
        boolean z = bArr != null && i > f39888h.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = f39888h;
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

    /* renamed from: f */
    private int m12991f() throws IOException {
        short mo12983b;
        short mo12983b2;
        int mo12984a;
        long j;
        long skip;
        do {
            if (this.f39895a.mo12983b() != 255) {
                if (Log.isLoggable(f39882b, 3)) {
                    Log.d(f39882b, "Unknown segmentId=" + ((int) mo12983b));
                }
                return -1;
            }
            mo12983b2 = this.f39895a.mo12983b();
            if (mo12983b2 == f39889i) {
                return -1;
            }
            if (mo12983b2 == f39890j) {
                if (Log.isLoggable(f39882b, 3)) {
                    Log.d(f39882b, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            mo12984a = this.f39895a.mo12984a() - 2;
            if (mo12983b2 == f39892l) {
                return mo12984a;
            }
            j = mo12984a;
            skip = this.f39895a.skip(j);
        } while (skip == j);
        if (Log.isLoggable(f39882b, 3)) {
            Log.d(f39882b, "Unable to skip enough data, type: " + ((int) mo12983b2) + ", wanted to skip: " + mo12984a + ", but actually skipped: " + skip);
        }
        return -1;
    }

    /* renamed from: g */
    private static int m12990g(C13527a c13527a) {
        ByteOrder byteOrder;
        short m12988a = c13527a.m12988a(6);
        if (m12988a == f39885e) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (m12988a == f39886f) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(f39882b, 3)) {
                Log.d(f39882b, "Unknown endianness = " + ((int) m12988a));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        c13527a.m12985d(byteOrder);
        int m12987b = c13527a.m12987b(10) + 6;
        short m12988a2 = c13527a.m12988a(m12987b);
        for (int i = 0; i < m12988a2; i++) {
            int m12996a = m12996a(m12987b, i);
            short m12988a3 = c13527a.m12988a(m12996a);
            if (m12988a3 == f39893m) {
                short m12988a4 = c13527a.m12988a(m12996a + 2);
                if (m12988a4 >= 1 && m12988a4 <= 12) {
                    int m12987b2 = c13527a.m12987b(m12996a + 4);
                    if (m12987b2 < 0) {
                        if (Log.isLoggable(f39882b, 3)) {
                            Log.d(f39882b, "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable(f39882b, 3)) {
                            Log.d(f39882b, "Got tagIndex=" + i + " tagType=" + ((int) m12988a3) + " formatCode=" + ((int) m12988a4) + " componentCount=" + m12987b2);
                        }
                        int i2 = m12987b2 + f39894n[m12988a4];
                        if (i2 > 4) {
                            if (Log.isLoggable(f39882b, 3)) {
                                Log.d(f39882b, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) m12988a4));
                            }
                        } else {
                            int i3 = m12996a + 8;
                            if (i3 >= 0 && i3 <= c13527a.m12986c()) {
                                if (i2 >= 0 && i2 + i3 <= c13527a.m12986c()) {
                                    return c13527a.m12988a(i3);
                                }
                                if (Log.isLoggable(f39882b, 3)) {
                                    Log.d(f39882b, "Illegal number of bytes for TI tag data tagType=" + ((int) m12988a3));
                                }
                            } else if (Log.isLoggable(f39882b, 3)) {
                                Log.d(f39882b, "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) m12988a3));
                            }
                        }
                    }
                } else if (Log.isLoggable(f39882b, 3)) {
                    Log.d(f39882b, "Got invalid format code = " + ((int) m12988a4));
                }
            }
        }
        return -1;
    }

    /* renamed from: h */
    private int m12989h(byte[] bArr, int i) throws IOException {
        int read = this.f39895a.read(bArr, i);
        if (read != i) {
            if (Log.isLoggable(f39882b, 3)) {
                Log.d(f39882b, "Unable to read exif segment data, length: " + i + ", actually read: " + read);
            }
            return -1;
        } else if (m12992e(bArr, i)) {
            return m12990g(new C13527a(bArr, i));
        } else {
            if (Log.isLoggable(f39882b, 3)) {
                Log.d(f39882b, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    /* renamed from: c */
    public int m12994c() throws IOException {
        int mo12984a = this.f39895a.mo12984a();
        if (!m12993d(mo12984a)) {
            if (Log.isLoggable(f39882b, 3)) {
                Log.d(f39882b, "Parser doesn't handle magic number: " + mo12984a);
            }
            return -1;
        }
        int m12991f = m12991f();
        if (m12991f == -1) {
            if (Log.isLoggable(f39882b, 3)) {
                Log.d(f39882b, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        return m12989h(new byte[m12991f], m12991f);
    }
}
