package com.bytedance.pangle.res.p124a;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* renamed from: com.bytedance.pangle.res.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6200a {

    /* renamed from: f */
    private static final Logger f22136f = Logger.getLogger(C6200a.class.getName());

    /* renamed from: a */
    private final byte[] f22137a;

    /* renamed from: b */
    private final InterfaceC6210h f22138b;

    /* renamed from: c */
    private final C6209g f22139c;

    /* renamed from: d */
    private final C6207e f22140d;

    /* renamed from: e */
    private C6201a f22141e;

    /* renamed from: com.bytedance.pangle.res.a.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6201a {

        /* renamed from: a */
        public final short f22142a;

        /* renamed from: b */
        public final int f22143b;

        /* renamed from: c */
        public final int f22144c;

        /* renamed from: d */
        public final int f22145d;

        /* renamed from: e */
        public final int f22146e;

        private C6201a(short s, int i, int i2, int i3) {
            this.f22142a = s;
            this.f22143b = i;
            this.f22144c = i2;
            this.f22145d = i3;
            this.f22146e = i3 + i2;
        }

        /* renamed from: a */
        public static C6201a m36996a(C6209g c6209g, C6207e c6207e) {
            int m36983a = c6207e.m36983a();
            try {
                return new C6201a(c6209g.readShort(), c6209g.readShort(), c6209g.readInt(), m36983a);
            } catch (EOFException unused) {
                return new C6201a((short) -1, 0, 0, c6207e.m36983a());
            }
        }
    }

    public C6200a(byte[] bArr, InterfaceC6210h interfaceC6210h) {
        C6207e c6207e = new C6207e(new ByteArrayInputStream(bArr));
        this.f22140d = c6207e;
        this.f22139c = new C6209g(new C6211i(c6207e));
        this.f22137a = bArr;
        this.f22138b = interfaceC6210h;
    }

    /* renamed from: a */
    private String m37007a(int i) {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || this.f22139c.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i = i2;
        }
        this.f22139c.skipBytes(i2);
        return sb.toString();
    }

    /* renamed from: b */
    private void m37006b() {
        m37005b(515);
        int readInt = this.f22139c.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f22139c.readInt();
            this.f22139c.skipBytes(256);
        }
        while (m36997j().f22142a == 513) {
            m37004c();
        }
    }

    /* renamed from: c */
    private void m37004c() {
        m37003d();
        short s = m36997j().f22142a;
        while (s == 514) {
            m37003d();
            s = m36997j().f22142a;
        }
        while (s == 513) {
            m37002e();
            if (this.f22140d.m36983a() < this.f22141e.f22146e) {
                Logger logger = f22136f;
                logger.warning("Unknown data detected. Skipping: " + (this.f22141e.f22146e - this.f22140d.m36983a()) + " byte(s)");
                C6207e c6207e = this.f22140d;
                c6207e.skip((long) (this.f22141e.f22146e - c6207e.m36983a()));
            }
            s = m36997j().f22142a;
        }
    }

    /* renamed from: d */
    private void m37003d() {
        m37005b(514);
        this.f22139c.readUnsignedByte();
        this.f22139c.skipBytes(3);
        this.f22139c.skipBytes(this.f22139c.readInt() * 4);
    }

    /* renamed from: e */
    private void m37002e() {
        m37005b(InputDeviceCompat.SOURCE_DPAD);
        this.f22139c.readUnsignedByte();
        this.f22139c.readByte();
        this.f22139c.skipBytes(2);
        int readInt = this.f22139c.readInt();
        int readInt2 = this.f22139c.readInt();
        m36998i();
        int i = (this.f22141e.f22145d + readInt2) - (readInt * 4);
        if (i != this.f22140d.m36983a()) {
            f22136f.warning("Invalid data detected. Skipping: " + (i - this.f22140d.m36983a()) + " byte(s)");
            this.f22139c.skipBytes(i - this.f22140d.m36983a());
        }
        int[] m36980a = this.f22139c.m36980a(readInt);
        HashSet hashSet = new HashSet();
        for (int i2 : m36980a) {
            if (i2 != -1 && !hashSet.contains(Integer.valueOf(i2))) {
                m37001f();
                hashSet.add(Integer.valueOf(i2));
            }
        }
    }

    /* renamed from: f */
    private void m37001f() {
        if (this.f22139c.readShort() >= 0) {
            short readShort = this.f22139c.readShort();
            this.f22139c.readInt();
            if ((readShort & 1) == 0) {
                m36999h();
                return;
            } else {
                m37000g();
                return;
            }
        }
        throw new RuntimeException("Entry size is under 0 bytes.");
    }

    /* renamed from: g */
    private void m37000g() {
        int m36969a = C6213k.m36969a(this.f22139c);
        C6213k.m36968a(this.f22137a, this.f22139c.readInt(), m36969a, this.f22138b);
        int readInt = this.f22139c.readInt();
        for (int i = 0; i < readInt; i++) {
            int m36969a2 = C6213k.m36969a(this.f22139c);
            C6213k.m36968a(this.f22137a, this.f22139c.readInt(), m36969a2, this.f22138b);
            m36999h();
        }
    }

    /* renamed from: h */
    private void m36999h() {
        this.f22139c.m36981a();
        this.f22139c.m36979b();
        byte readByte = this.f22139c.readByte();
        int m36969a = C6213k.m36969a(this.f22139c);
        int readInt = this.f22139c.readInt();
        if (readByte == 1) {
            C6213k.m36968a(this.f22137a, readInt, m36969a, this.f22138b);
        }
        if (readByte == 2) {
            C6213k.m36968a(this.f22137a, readInt, m36969a, this.f22138b);
        }
    }

    /* renamed from: i */
    private void m36998i() {
        int readInt = this.f22139c.readInt();
        int i = 28;
        if (readInt >= 28) {
            this.f22139c.readShort();
            this.f22139c.readShort();
            this.f22139c.readByte();
            this.f22139c.readByte();
            this.f22139c.readByte();
            this.f22139c.readByte();
            this.f22139c.readByte();
            this.f22139c.readByte();
            this.f22139c.readUnsignedShort();
            this.f22139c.readByte();
            this.f22139c.readByte();
            this.f22139c.readByte();
            this.f22139c.skipBytes(1);
            this.f22139c.readShort();
            this.f22139c.readShort();
            this.f22139c.readShort();
            this.f22139c.skipBytes(2);
            if (readInt >= 32) {
                this.f22139c.readByte();
                this.f22139c.readByte();
                this.f22139c.readShort();
                i = 32;
            }
            if (readInt >= 36) {
                this.f22139c.readShort();
                this.f22139c.readShort();
                i = 36;
            }
            if (readInt >= 48) {
                m37007a(4).toCharArray();
                m37007a(8).toCharArray();
                i = 48;
            }
            if (readInt >= 52) {
                this.f22139c.readByte();
                this.f22139c.readByte();
                this.f22139c.skipBytes(2);
                i = 52;
            }
            if (readInt >= 56) {
                this.f22139c.skipBytes(4);
                i = 56;
            }
            int i2 = readInt - 56;
            if (i2 > 0) {
                byte[] bArr = new byte[i2];
                i += i2;
                this.f22139c.readFully(bArr);
                BigInteger bigInteger = new BigInteger(1, bArr);
                if (bigInteger.equals(BigInteger.ZERO)) {
                    f22136f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
                } else {
                    f22136f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
                }
            }
            int i3 = readInt - i;
            if (i3 > 0) {
                this.f22139c.skipBytes(i3);
                return;
            }
            return;
        }
        throw new RuntimeException("Config size < 28");
    }

    /* renamed from: j */
    private C6201a m36997j() {
        C6201a m36996a = C6201a.m36996a(this.f22139c, this.f22140d);
        this.f22141e = m36996a;
        return m36996a;
    }

    /* renamed from: a */
    public final void m37008a() {
        m36997j();
        m37005b(2);
        int readInt = this.f22139c.readInt();
        C6214l.m36966a(this.f22139c);
        m36997j();
        for (int i = 0; i < readInt; i++) {
            m37005b(512);
            this.f22139c.readInt();
            this.f22139c.skipBytes(256);
            this.f22139c.skipBytes(4);
            this.f22139c.skipBytes(4);
            this.f22139c.skipBytes(4);
            this.f22139c.skipBytes(4);
            if (this.f22141e.f22143b == 288 && this.f22139c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            C6214l.m36966a(this.f22139c);
            C6214l.m36966a(this.f22139c);
            m36997j();
            boolean z = true;
            while (z) {
                short s = this.f22141e.f22142a;
                if (s == 514) {
                    m37004c();
                } else if (s != 515) {
                    z = false;
                } else {
                    m37006b();
                }
            }
        }
    }

    /* renamed from: b */
    private void m37005b(int i) {
        if (this.f22141e.f22142a != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.f22141e.f22142a)));
        }
    }
}
