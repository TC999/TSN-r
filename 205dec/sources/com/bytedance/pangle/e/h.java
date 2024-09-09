package com.bytedance.pangle.e;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class h implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final FileInputStream f28708a;

    /* renamed from: b  reason: collision with root package name */
    private a f28709b;

    /* renamed from: c  reason: collision with root package name */
    private b[] f28710c;

    /* renamed from: d  reason: collision with root package name */
    private c[] f28711d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, c> f28712e = new HashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f28713a;

        /* renamed from: b  reason: collision with root package name */
        public final short f28714b;

        /* renamed from: c  reason: collision with root package name */
        public final short f28715c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28716d;

        /* renamed from: e  reason: collision with root package name */
        public final long f28717e;

        /* renamed from: f  reason: collision with root package name */
        public final long f28718f;

        /* renamed from: g  reason: collision with root package name */
        public final long f28719g;

        /* renamed from: h  reason: collision with root package name */
        public final int f28720h;

        /* renamed from: i  reason: collision with root package name */
        public final short f28721i;

        /* renamed from: j  reason: collision with root package name */
        public final short f28722j;

        /* renamed from: k  reason: collision with root package name */
        public final short f28723k;

        /* renamed from: l  reason: collision with root package name */
        public final short f28724l;

        /* renamed from: m  reason: collision with root package name */
        public final short f28725m;

        /* renamed from: n  reason: collision with root package name */
        public final short f28726n;

        /* synthetic */ a(FileChannel fileChannel, byte b4) {
            this(fileChannel);
        }

        private a(FileChannel fileChannel) {
            byte[] bArr = new byte[16];
            this.f28713a = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                byte b4 = bArr[4];
                h.a(b4, 2, "bad elf class: " + ((int) bArr[4]));
                byte b5 = bArr[5];
                h.a(b5, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                h.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.f28714b = allocate.getShort();
                this.f28715c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f28716d = i4;
                h.a(i4, 1, "bad elf version: " + i4);
                byte b6 = bArr[4];
                if (b6 == 1) {
                    this.f28717e = allocate.getInt();
                    this.f28718f = allocate.getInt();
                    this.f28719g = allocate.getInt();
                } else if (b6 == 2) {
                    this.f28717e = allocate.getLong();
                    this.f28718f = allocate.getLong();
                    this.f28719g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.f28720h = allocate.getInt();
                this.f28721i = allocate.getShort();
                this.f28722j = allocate.getShort();
                this.f28723k = allocate.getShort();
                this.f28724l = allocate.getShort();
                this.f28725m = allocate.getShort();
                this.f28726n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f28727a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28728b;

        /* renamed from: c  reason: collision with root package name */
        public final long f28729c;

        /* renamed from: d  reason: collision with root package name */
        public final long f28730d;

        /* renamed from: e  reason: collision with root package name */
        public final long f28731e;

        /* renamed from: f  reason: collision with root package name */
        public final long f28732f;

        /* renamed from: g  reason: collision with root package name */
        public final long f28733g;

        /* renamed from: h  reason: collision with root package name */
        public final long f28734h;

        /* synthetic */ b(ByteBuffer byteBuffer, int i4, byte b4) {
            this(byteBuffer, i4);
        }

        private b(ByteBuffer byteBuffer, int i4) {
            if (i4 == 1) {
                this.f28727a = byteBuffer.getInt();
                this.f28729c = byteBuffer.getInt();
                this.f28730d = byteBuffer.getInt();
                this.f28731e = byteBuffer.getInt();
                this.f28732f = byteBuffer.getInt();
                this.f28733g = byteBuffer.getInt();
                this.f28728b = byteBuffer.getInt();
                this.f28734h = byteBuffer.getInt();
            } else if (i4 == 2) {
                this.f28727a = byteBuffer.getInt();
                this.f28728b = byteBuffer.getInt();
                this.f28729c = byteBuffer.getLong();
                this.f28730d = byteBuffer.getLong();
                this.f28731e = byteBuffer.getLong();
                this.f28732f = byteBuffer.getLong();
                this.f28733g = byteBuffer.getLong();
                this.f28734h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i4)));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f28735a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28736b;

        /* renamed from: c  reason: collision with root package name */
        public final long f28737c;

        /* renamed from: d  reason: collision with root package name */
        public final long f28738d;

        /* renamed from: e  reason: collision with root package name */
        public final long f28739e;

        /* renamed from: f  reason: collision with root package name */
        public final long f28740f;

        /* renamed from: g  reason: collision with root package name */
        public final int f28741g;

        /* renamed from: h  reason: collision with root package name */
        public final int f28742h;

        /* renamed from: i  reason: collision with root package name */
        public final long f28743i;

        /* renamed from: j  reason: collision with root package name */
        public final long f28744j;

        /* renamed from: k  reason: collision with root package name */
        public String f28745k;

        /* synthetic */ c(ByteBuffer byteBuffer, int i4, byte b4) {
            this(byteBuffer, i4);
        }

        private c(ByteBuffer byteBuffer, int i4) {
            if (i4 == 1) {
                this.f28735a = byteBuffer.getInt();
                this.f28736b = byteBuffer.getInt();
                this.f28737c = byteBuffer.getInt();
                this.f28738d = byteBuffer.getInt();
                this.f28739e = byteBuffer.getInt();
                this.f28740f = byteBuffer.getInt();
                this.f28741g = byteBuffer.getInt();
                this.f28742h = byteBuffer.getInt();
                this.f28743i = byteBuffer.getInt();
                this.f28744j = byteBuffer.getInt();
            } else if (i4 == 2) {
                this.f28735a = byteBuffer.getInt();
                this.f28736b = byteBuffer.getInt();
                this.f28737c = byteBuffer.getLong();
                this.f28738d = byteBuffer.getLong();
                this.f28739e = byteBuffer.getLong();
                this.f28740f = byteBuffer.getLong();
                this.f28741g = byteBuffer.getInt();
                this.f28742h = byteBuffer.getInt();
                this.f28743i = byteBuffer.getLong();
                this.f28744j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i4)));
            }
            this.f28745k = null;
        }
    }

    private h(File file) {
        c[] cVarArr;
        c[] cVarArr2;
        this.f28709b = null;
        this.f28710c = null;
        this.f28711d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f28708a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f28709b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f28709b.f28722j);
        allocate.order(this.f28709b.f28713a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f28709b.f28718f);
        this.f28710c = new b[this.f28709b.f28723k];
        for (int i4 = 0; i4 < this.f28710c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f28710c[i4] = new b(allocate, this.f28709b.f28713a[4], (byte) 0);
        }
        channel.position(this.f28709b.f28719g);
        allocate.limit(this.f28709b.f28724l);
        this.f28711d = new c[this.f28709b.f28725m];
        int i5 = 0;
        while (true) {
            cVarArr = this.f28711d;
            if (i5 >= cVarArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f28711d[i5] = new c(allocate, this.f28709b.f28713a[4], (byte) 0);
            i5++;
        }
        short s3 = this.f28709b.f28726n;
        if (s3 > 0) {
            c cVar = cVarArr[s3];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) cVar.f28740f);
            this.f28708a.getChannel().position(cVar.f28739e);
            b(this.f28708a.getChannel(), allocate2, "failed to read section: " + cVar.f28745k);
            for (c cVar2 : this.f28711d) {
                allocate2.position(cVar2.f28735a);
                String a4 = a(allocate2);
                cVar2.f28745k = a4;
                this.f28712e.put(a4, cVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
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
        this.f28708a.close();
        this.f28712e.clear();
        this.f28710c = null;
        this.f28711d = null;
    }

    public static boolean a(File file) {
        try {
            com.bytedance.pangle.util.g.a(new h(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            throw th;
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    static /* synthetic */ void a(int i4, int i5, String str) {
        if (i4 <= 0 || i4 > i5) {
            throw new IOException(str);
        }
    }
}
