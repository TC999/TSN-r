package com.bytedance.pangle.p120e;

import com.bytedance.pangle.util.C6251g;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.pangle.e.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6108h implements Closeable {

    /* renamed from: a */
    private final FileInputStream f21947a;

    /* renamed from: b */
    private C6109a f21948b;

    /* renamed from: c */
    private C6110b[] f21949c;

    /* renamed from: d */
    private C6111c[] f21950d;

    /* renamed from: e */
    private final Map<String, C6111c> f21951e = new HashMap();

    /* renamed from: com.bytedance.pangle.e.h$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6109a {

        /* renamed from: a */
        public final byte[] f21952a;

        /* renamed from: b */
        public final short f21953b;

        /* renamed from: c */
        public final short f21954c;

        /* renamed from: d */
        public final int f21955d;

        /* renamed from: e */
        public final long f21956e;

        /* renamed from: f */
        public final long f21957f;

        /* renamed from: g */
        public final long f21958g;

        /* renamed from: h */
        public final int f21959h;

        /* renamed from: i */
        public final short f21960i;

        /* renamed from: j */
        public final short f21961j;

        /* renamed from: k */
        public final short f21962k;

        /* renamed from: l */
        public final short f21963l;

        /* renamed from: m */
        public final short f21964m;

        /* renamed from: n */
        public final short f21965n;

        /* synthetic */ C6109a(FileChannel fileChannel, byte b) {
            this(fileChannel);
        }

        private C6109a(FileChannel fileChannel) {
            byte[] bArr = new byte[16];
            this.f21952a = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                byte b = bArr[4];
                C6108h.m37176a(b, 2, "bad elf class: " + ((int) bArr[4]));
                byte b2 = bArr[5];
                C6108h.m37176a(b2, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                C6108h.m37172b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.f21953b = allocate.getShort();
                this.f21954c = allocate.getShort();
                int i = allocate.getInt();
                this.f21955d = i;
                C6108h.m37176a(i, 1, "bad elf version: " + i);
                byte b3 = bArr[4];
                if (b3 == 1) {
                    this.f21956e = allocate.getInt();
                    this.f21957f = allocate.getInt();
                    this.f21958g = allocate.getInt();
                } else if (b3 == 2) {
                    this.f21956e = allocate.getLong();
                    this.f21957f = allocate.getLong();
                    this.f21958g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.f21959h = allocate.getInt();
                this.f21960i = allocate.getShort();
                this.f21961j = allocate.getShort();
                this.f21962k = allocate.getShort();
                this.f21963l = allocate.getShort();
                this.f21964m = allocate.getShort();
                this.f21965n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    /* renamed from: com.bytedance.pangle.e.h$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6110b {

        /* renamed from: a */
        public final int f21966a;

        /* renamed from: b */
        public final int f21967b;

        /* renamed from: c */
        public final long f21968c;

        /* renamed from: d */
        public final long f21969d;

        /* renamed from: e */
        public final long f21970e;

        /* renamed from: f */
        public final long f21971f;

        /* renamed from: g */
        public final long f21972g;

        /* renamed from: h */
        public final long f21973h;

        /* synthetic */ C6110b(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private C6110b(ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.f21966a = byteBuffer.getInt();
                this.f21968c = byteBuffer.getInt();
                this.f21969d = byteBuffer.getInt();
                this.f21970e = byteBuffer.getInt();
                this.f21971f = byteBuffer.getInt();
                this.f21972g = byteBuffer.getInt();
                this.f21967b = byteBuffer.getInt();
                this.f21973h = byteBuffer.getInt();
            } else if (i == 2) {
                this.f21966a = byteBuffer.getInt();
                this.f21967b = byteBuffer.getInt();
                this.f21968c = byteBuffer.getLong();
                this.f21969d = byteBuffer.getLong();
                this.f21970e = byteBuffer.getLong();
                this.f21971f = byteBuffer.getLong();
                this.f21972g = byteBuffer.getLong();
                this.f21973h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.e.h$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static class C6111c {

        /* renamed from: a */
        public final int f21974a;

        /* renamed from: b */
        public final int f21975b;

        /* renamed from: c */
        public final long f21976c;

        /* renamed from: d */
        public final long f21977d;

        /* renamed from: e */
        public final long f21978e;

        /* renamed from: f */
        public final long f21979f;

        /* renamed from: g */
        public final int f21980g;

        /* renamed from: h */
        public final int f21981h;

        /* renamed from: i */
        public final long f21982i;

        /* renamed from: j */
        public final long f21983j;

        /* renamed from: k */
        public String f21984k;

        /* synthetic */ C6111c(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        private C6111c(ByteBuffer byteBuffer, int i) {
            if (i == 1) {
                this.f21974a = byteBuffer.getInt();
                this.f21975b = byteBuffer.getInt();
                this.f21976c = byteBuffer.getInt();
                this.f21977d = byteBuffer.getInt();
                this.f21978e = byteBuffer.getInt();
                this.f21979f = byteBuffer.getInt();
                this.f21980g = byteBuffer.getInt();
                this.f21981h = byteBuffer.getInt();
                this.f21982i = byteBuffer.getInt();
                this.f21983j = byteBuffer.getInt();
            } else if (i == 2) {
                this.f21974a = byteBuffer.getInt();
                this.f21975b = byteBuffer.getInt();
                this.f21976c = byteBuffer.getLong();
                this.f21977d = byteBuffer.getLong();
                this.f21978e = byteBuffer.getLong();
                this.f21979f = byteBuffer.getLong();
                this.f21980g = byteBuffer.getInt();
                this.f21981h = byteBuffer.getInt();
                this.f21982i = byteBuffer.getLong();
                this.f21983j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.f21984k = null;
        }
    }

    private C6108h(File file) {
        C6111c[] c6111cArr;
        C6111c[] c6111cArr2;
        this.f21948b = null;
        this.f21949c = null;
        this.f21950d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f21947a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f21948b = new C6109a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f21948b.f21961j);
        allocate.order(this.f21948b.f21952a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f21948b.f21957f);
        this.f21949c = new C6110b[this.f21948b.f21962k];
        for (int i = 0; i < this.f21949c.length; i++) {
            m37172b(channel, allocate, "failed to read phdr.");
            this.f21949c[i] = new C6110b(allocate, this.f21948b.f21952a[4], (byte) 0);
        }
        channel.position(this.f21948b.f21958g);
        allocate.limit(this.f21948b.f21963l);
        this.f21950d = new C6111c[this.f21948b.f21964m];
        int i2 = 0;
        while (true) {
            c6111cArr = this.f21950d;
            if (i2 >= c6111cArr.length) {
                break;
            }
            m37172b(channel, allocate, "failed to read shdr.");
            this.f21950d[i2] = new C6111c(allocate, this.f21948b.f21952a[4], (byte) 0);
            i2++;
        }
        short s = this.f21948b.f21965n;
        if (s > 0) {
            C6111c c6111c = c6111cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c6111c.f21979f);
            this.f21947a.getChannel().position(c6111c.f21978e);
            m37172b(this.f21947a.getChannel(), allocate2, "failed to read section: " + c6111c.f21984k);
            for (C6111c c6111c2 : this.f21950d) {
                allocate2.position(c6111c2.f21974a);
                String m37174a = m37174a(allocate2);
                c6111c2.f21984k = m37174a;
                this.f21951e.put(m37174a, c6111c2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m37172b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f21947a.close();
        this.f21951e.clear();
        this.f21949c = null;
        this.f21950d = null;
    }

    /* renamed from: a */
    public static boolean m37175a(File file) {
        try {
            C6251g.m36900a(new C6108h(file));
            return true;
        } catch (IOException unused) {
            C6251g.m36900a((Closeable) null);
            return false;
        } catch (Throwable th) {
            C6251g.m36900a((Closeable) null);
            throw th;
        }
    }

    /* renamed from: a */
    private static String m37174a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    /* renamed from: a */
    static /* synthetic */ void m37176a(int i, int i2, String str) {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }
}
