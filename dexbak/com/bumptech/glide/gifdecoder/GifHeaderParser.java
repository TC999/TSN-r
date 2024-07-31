package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.UByte;

/* renamed from: com.bumptech.glide.gifdecoder.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GifHeaderParser {

    /* renamed from: e */
    private static final String f13380e = "GifHeaderParser";

    /* renamed from: f */
    private static final int f13381f = 255;

    /* renamed from: g */
    private static final int f13382g = 44;

    /* renamed from: h */
    private static final int f13383h = 33;

    /* renamed from: i */
    private static final int f13384i = 59;

    /* renamed from: j */
    private static final int f13385j = 249;

    /* renamed from: k */
    private static final int f13386k = 255;

    /* renamed from: l */
    private static final int f13387l = 254;

    /* renamed from: m */
    private static final int f13388m = 1;

    /* renamed from: n */
    private static final int f13389n = 28;

    /* renamed from: o */
    private static final int f13390o = 2;

    /* renamed from: p */
    private static final int f13391p = 1;

    /* renamed from: q */
    private static final int f13392q = 128;

    /* renamed from: r */
    private static final int f13393r = 64;

    /* renamed from: s */
    private static final int f13394s = 7;

    /* renamed from: t */
    private static final int f13395t = 128;

    /* renamed from: u */
    private static final int f13396u = 7;

    /* renamed from: v */
    static final int f13397v = 2;

    /* renamed from: w */
    static final int f13398w = 10;

    /* renamed from: x */
    private static final int f13399x = 256;

    /* renamed from: b */
    private ByteBuffer f13401b;

    /* renamed from: c */
    private GifHeader f13402c;

    /* renamed from: a */
    private final byte[] f13400a = new byte[256];

    /* renamed from: d */
    private int f13403d = 0;

    /* renamed from: b */
    private boolean m45615b() {
        return this.f13402c.f13368b != 0;
    }

    /* renamed from: e */
    private int m45612e() {
        try {
            return this.f13401b.get() & UByte.f41242c;
        } catch (Exception unused) {
            this.f13402c.f13368b = 1;
            return 0;
        }
    }

    /* renamed from: f */
    private void m45611f() {
        this.f13402c.f13370d.f13354a = m45602o();
        this.f13402c.f13370d.f13355b = m45602o();
        this.f13402c.f13370d.f13356c = m45602o();
        this.f13402c.f13370d.f13357d = m45602o();
        int m45612e = m45612e();
        boolean z = (m45612e & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m45612e & 7) + 1);
        GifFrame gifFrame = this.f13402c.f13370d;
        gifFrame.f13358e = (m45612e & 64) != 0;
        if (z) {
            gifFrame.f13364k = m45609h(pow);
        } else {
            gifFrame.f13364k = null;
        }
        this.f13402c.f13370d.f13363j = this.f13401b.position();
        m45597t();
        if (m45615b()) {
            return;
        }
        GifHeader gifHeader = this.f13402c;
        gifHeader.f13369c++;
        gifHeader.f13371e.add(gifHeader.f13370d);
    }

    /* renamed from: g */
    private void m45610g() {
        int m45612e = m45612e();
        this.f13403d = m45612e;
        if (m45612e <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                i2 = this.f13403d;
                if (i >= i2) {
                    return;
                }
                i2 -= i;
                this.f13401b.get(this.f13400a, i, i2);
                i += i2;
            } catch (Exception e) {
                if (Log.isLoggable(f13380e, 3)) {
                    Log.d(f13380e, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f13403d, e);
                }
                this.f13402c.f13368b = 1;
                return;
            }
        }
    }

    @Nullable
    /* renamed from: h */
    private int[] m45609h(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f13401b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = bArr[i3] & UByte.f41242c;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & UByte.f41242c;
                int i8 = i6 + 1;
                int i9 = i2 + 1;
                iArr[i2] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & UByte.f41242c);
                i3 = i8;
                i2 = i9;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable(f13380e, 3)) {
                Log.d(f13380e, "Format Error Reading Color Table", e);
            }
            this.f13402c.f13368b = 1;
        }
        return iArr;
    }

    /* renamed from: i */
    private void m45608i() {
        m45607j(Integer.MAX_VALUE);
    }

    /* renamed from: j */
    private void m45607j(int i) {
        boolean z = false;
        while (!z && !m45615b() && this.f13402c.f13369c <= i) {
            int m45612e = m45612e();
            if (m45612e == 33) {
                int m45612e2 = m45612e();
                if (m45612e2 == 1) {
                    m45598s();
                } else if (m45612e2 == f13385j) {
                    this.f13402c.f13370d = new GifFrame();
                    m45606k();
                } else if (m45612e2 == 254) {
                    m45598s();
                } else if (m45612e2 != 255) {
                    m45598s();
                } else {
                    m45610g();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.f13400a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m45603n();
                    } else {
                        m45598s();
                    }
                }
            } else if (m45612e == 44) {
                GifHeader gifHeader = this.f13402c;
                if (gifHeader.f13370d == null) {
                    gifHeader.f13370d = new GifFrame();
                }
                m45611f();
            } else if (m45612e != 59) {
                this.f13402c.f13368b = 1;
            } else {
                z = true;
            }
        }
    }

    /* renamed from: k */
    private void m45606k() {
        m45612e();
        int m45612e = m45612e();
        GifFrame gifFrame = this.f13402c.f13370d;
        int i = (m45612e & 28) >> 2;
        gifFrame.f13360g = i;
        if (i == 0) {
            gifFrame.f13360g = 1;
        }
        gifFrame.f13359f = (m45612e & 1) != 0;
        int m45602o = m45602o();
        if (m45602o < 2) {
            m45602o = 10;
        }
        GifFrame gifFrame2 = this.f13402c.f13370d;
        gifFrame2.f13362i = m45602o * 10;
        gifFrame2.f13361h = m45612e();
        m45612e();
    }

    /* renamed from: l */
    private void m45605l() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) m45612e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f13402c.f13368b = 1;
            return;
        }
        m45604m();
        if (!this.f13402c.f13374h || m45615b()) {
            return;
        }
        GifHeader gifHeader = this.f13402c;
        gifHeader.f13367a = m45609h(gifHeader.f13375i);
        GifHeader gifHeader2 = this.f13402c;
        gifHeader2.f13378l = gifHeader2.f13367a[gifHeader2.f13376j];
    }

    /* renamed from: m */
    private void m45604m() {
        this.f13402c.f13372f = m45602o();
        this.f13402c.f13373g = m45602o();
        int m45612e = m45612e();
        GifHeader gifHeader = this.f13402c;
        gifHeader.f13374h = (m45612e & 128) != 0;
        gifHeader.f13375i = (int) Math.pow(2.0d, (m45612e & 7) + 1);
        this.f13402c.f13376j = m45612e();
        this.f13402c.f13377k = m45612e();
    }

    /* renamed from: n */
    private void m45603n() {
        do {
            m45610g();
            byte[] bArr = this.f13400a;
            if (bArr[0] == 1) {
                this.f13402c.f13379m = ((bArr[2] & UByte.f41242c) << 8) | (bArr[1] & UByte.f41242c);
            }
            if (this.f13403d <= 0) {
                return;
            }
        } while (!m45615b());
    }

    /* renamed from: o */
    private int m45602o() {
        return this.f13401b.getShort();
    }

    /* renamed from: p */
    private void m45601p() {
        this.f13401b = null;
        Arrays.fill(this.f13400a, (byte) 0);
        this.f13402c = new GifHeader();
        this.f13403d = 0;
    }

    /* renamed from: s */
    private void m45598s() {
        int m45612e;
        do {
            m45612e = m45612e();
            this.f13401b.position(Math.min(this.f13401b.position() + m45612e, this.f13401b.limit()));
        } while (m45612e > 0);
    }

    /* renamed from: t */
    private void m45597t() {
        m45612e();
        m45598s();
    }

    /* renamed from: a */
    public void m45616a() {
        this.f13401b = null;
        this.f13402c = null;
    }

    /* renamed from: c */
    public boolean m45614c() {
        m45605l();
        if (!m45615b()) {
            m45607j(2);
        }
        return this.f13402c.f13369c > 1;
    }

    @NonNull
    /* renamed from: d */
    public GifHeader m45613d() {
        if (this.f13401b != null) {
            if (m45615b()) {
                return this.f13402c;
            }
            m45605l();
            if (!m45615b()) {
                m45608i();
                GifHeader gifHeader = this.f13402c;
                if (gifHeader.f13369c < 0) {
                    gifHeader.f13368b = 1;
                }
            }
            return this.f13402c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    /* renamed from: q */
    public GifHeaderParser m45600q(@NonNull ByteBuffer byteBuffer) {
        m45601p();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f13401b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f13401b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    /* renamed from: r */
    public GifHeaderParser m45599r(@Nullable byte[] bArr) {
        if (bArr != null) {
            m45600q(ByteBuffer.wrap(bArr));
        } else {
            this.f13401b = null;
            this.f13402c.f13368b = 2;
        }
        return this;
    }
}
