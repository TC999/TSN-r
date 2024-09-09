package com.bytedance.pangle.res.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f28897f = Logger.getLogger(a.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f28898a;

    /* renamed from: b  reason: collision with root package name */
    private final h f28899b;

    /* renamed from: c  reason: collision with root package name */
    private final g f28900c;

    /* renamed from: d  reason: collision with root package name */
    private final e f28901d;

    /* renamed from: e  reason: collision with root package name */
    private C0432a f28902e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* renamed from: com.bytedance.pangle.res.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0432a {

        /* renamed from: a  reason: collision with root package name */
        public final short f28903a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28904b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28905c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28906d;

        /* renamed from: e  reason: collision with root package name */
        public final int f28907e;

        private C0432a(short s3, int i4, int i5, int i6) {
            this.f28903a = s3;
            this.f28904b = i4;
            this.f28905c = i5;
            this.f28906d = i6;
            this.f28907e = i6 + i5;
        }

        public static C0432a a(g gVar, e eVar) {
            int a4 = eVar.a();
            try {
                return new C0432a(gVar.readShort(), gVar.readShort(), gVar.readInt(), a4);
            } catch (EOFException unused) {
                return new C0432a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, h hVar) {
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.f28901d = eVar;
        this.f28900c = new g(new i(eVar));
        this.f28898a = bArr;
        this.f28899b = hVar;
    }

    private String a(int i4) {
        int i5;
        short s3;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i5 = i4 - 1;
            if (i4 == 0 || this.f28900c.readByte() == 0) {
                break;
            }
            sb.append((char) s3);
            i4 = i5;
        }
        this.f28900c.skipBytes(i5);
        return sb.toString();
    }

    private void b() {
        b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT);
        int readInt = this.f28900c.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            this.f28900c.readInt();
            this.f28900c.skipBytes(256);
        }
        while (j().f28903a == 513) {
            c();
        }
    }

    private void c() {
        d();
        short s3 = j().f28903a;
        while (s3 == 514) {
            d();
            s3 = j().f28903a;
        }
        while (s3 == 513) {
            e();
            if (this.f28901d.a() < this.f28902e.f28907e) {
                Logger logger = f28897f;
                logger.warning("Unknown data detected. Skipping: " + (this.f28902e.f28907e - this.f28901d.a()) + " byte(s)");
                e eVar = this.f28901d;
                eVar.skip((long) (this.f28902e.f28907e - eVar.a()));
            }
            s3 = j().f28903a;
        }
    }

    private void d() {
        b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE);
        this.f28900c.readUnsignedByte();
        this.f28900c.skipBytes(3);
        this.f28900c.skipBytes(this.f28900c.readInt() * 4);
    }

    private void e() {
        b(513);
        this.f28900c.readUnsignedByte();
        this.f28900c.readByte();
        this.f28900c.skipBytes(2);
        int readInt = this.f28900c.readInt();
        int readInt2 = this.f28900c.readInt();
        i();
        int i4 = (this.f28902e.f28906d + readInt2) - (readInt * 4);
        if (i4 != this.f28901d.a()) {
            f28897f.warning("Invalid data detected. Skipping: " + (i4 - this.f28901d.a()) + " byte(s)");
            this.f28900c.skipBytes(i4 - this.f28901d.a());
        }
        int[] a4 = this.f28900c.a(readInt);
        HashSet hashSet = new HashSet();
        for (int i5 : a4) {
            if (i5 != -1 && !hashSet.contains(Integer.valueOf(i5))) {
                f();
                hashSet.add(Integer.valueOf(i5));
            }
        }
    }

    private void f() {
        if (this.f28900c.readShort() >= 0) {
            short readShort = this.f28900c.readShort();
            this.f28900c.readInt();
            if ((readShort & 1) == 0) {
                h();
                return;
            } else {
                g();
                return;
            }
        }
        throw new RuntimeException("Entry size is under 0 bytes.");
    }

    private void g() {
        int a4 = k.a(this.f28900c);
        k.a(this.f28898a, this.f28900c.readInt(), a4, this.f28899b);
        int readInt = this.f28900c.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            int a5 = k.a(this.f28900c);
            k.a(this.f28898a, this.f28900c.readInt(), a5, this.f28899b);
            h();
        }
    }

    private void h() {
        this.f28900c.a();
        this.f28900c.b();
        byte readByte = this.f28900c.readByte();
        int a4 = k.a(this.f28900c);
        int readInt = this.f28900c.readInt();
        if (readByte == 1) {
            k.a(this.f28898a, readInt, a4, this.f28899b);
        }
        if (readByte == 2) {
            k.a(this.f28898a, readInt, a4, this.f28899b);
        }
    }

    private void i() {
        int readInt = this.f28900c.readInt();
        int i4 = 28;
        if (readInt >= 28) {
            this.f28900c.readShort();
            this.f28900c.readShort();
            this.f28900c.readByte();
            this.f28900c.readByte();
            this.f28900c.readByte();
            this.f28900c.readByte();
            this.f28900c.readByte();
            this.f28900c.readByte();
            this.f28900c.readUnsignedShort();
            this.f28900c.readByte();
            this.f28900c.readByte();
            this.f28900c.readByte();
            this.f28900c.skipBytes(1);
            this.f28900c.readShort();
            this.f28900c.readShort();
            this.f28900c.readShort();
            this.f28900c.skipBytes(2);
            if (readInt >= 32) {
                this.f28900c.readByte();
                this.f28900c.readByte();
                this.f28900c.readShort();
                i4 = 32;
            }
            if (readInt >= 36) {
                this.f28900c.readShort();
                this.f28900c.readShort();
                i4 = 36;
            }
            if (readInt >= 48) {
                a(4).toCharArray();
                a(8).toCharArray();
                i4 = 48;
            }
            if (readInt >= 52) {
                this.f28900c.readByte();
                this.f28900c.readByte();
                this.f28900c.skipBytes(2);
                i4 = 52;
            }
            if (readInt >= 56) {
                this.f28900c.skipBytes(4);
                i4 = 56;
            }
            int i5 = readInt - 56;
            if (i5 > 0) {
                byte[] bArr = new byte[i5];
                i4 += i5;
                this.f28900c.readFully(bArr);
                BigInteger bigInteger = new BigInteger(1, bArr);
                if (bigInteger.equals(BigInteger.ZERO)) {
                    f28897f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
                } else {
                    f28897f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
                }
            }
            int i6 = readInt - i4;
            if (i6 > 0) {
                this.f28900c.skipBytes(i6);
                return;
            }
            return;
        }
        throw new RuntimeException("Config size < 28");
    }

    private C0432a j() {
        C0432a a4 = C0432a.a(this.f28900c, this.f28901d);
        this.f28902e = a4;
        return a4;
    }

    public final void a() {
        j();
        b(2);
        int readInt = this.f28900c.readInt();
        l.a(this.f28900c);
        j();
        for (int i4 = 0; i4 < readInt; i4++) {
            b(512);
            this.f28900c.readInt();
            this.f28900c.skipBytes(256);
            this.f28900c.skipBytes(4);
            this.f28900c.skipBytes(4);
            this.f28900c.skipBytes(4);
            this.f28900c.skipBytes(4);
            if (this.f28902e.f28904b == 288 && this.f28900c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            l.a(this.f28900c);
            l.a(this.f28900c);
            j();
            boolean z3 = true;
            while (z3) {
                short s3 = this.f28902e.f28903a;
                if (s3 == 514) {
                    c();
                } else if (s3 != 515) {
                    z3 = false;
                } else {
                    b();
                }
            }
        }
    }

    private void b(int i4) {
        if (this.f28902e.f28903a != i4) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i4), Short.valueOf(this.f28902e.f28903a)));
        }
    }
}
