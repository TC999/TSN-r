package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.network.Headers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hpack.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final c[] f1040a;

    /* renamed from: b  reason: collision with root package name */
    static final Map<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f, Integer> f1041b;

    /* compiled from: Hpack.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<c> f1042a;

        /* renamed from: b  reason: collision with root package name */
        private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f1043b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1044c;

        /* renamed from: d  reason: collision with root package name */
        private int f1045d;

        /* renamed from: e  reason: collision with root package name */
        c[] f1046e;

        /* renamed from: f  reason: collision with root package name */
        int f1047f;

        /* renamed from: g  reason: collision with root package name */
        int f1048g;

        /* renamed from: h  reason: collision with root package name */
        int f1049h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i4, s sVar) {
            this(i4, i4, sVar);
        }

        private int b(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.f1046e.length;
                while (true) {
                    length--;
                    i5 = this.f1047f;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f1046e;
                    i4 -= cVarArr[length].f1039c;
                    this.f1049h -= cVarArr[length].f1039c;
                    this.f1048g--;
                    i6++;
                }
                c[] cVarArr2 = this.f1046e;
                int i7 = i5 + 1;
                System.arraycopy(cVarArr2, i7, cVarArr2, i7 + i6, this.f1048g);
                this.f1047f += i6;
            }
            return i6;
        }

        private void d() {
            int i4 = this.f1045d;
            int i5 = this.f1049h;
            if (i4 < i5) {
                if (i4 == 0) {
                    e();
                } else {
                    b(i5 - i4);
                }
            }
        }

        private void e() {
            Arrays.fill(this.f1046e, (Object) null);
            this.f1047f = this.f1046e.length - 1;
            this.f1048g = 0;
            this.f1049h = 0;
        }

        private void f(int i4) throws IOException {
            a(-1, new c(c(i4), b()));
        }

        private void g(int i4) throws IOException {
            this.f1042a.add(new c(c(i4), b()));
        }

        private void h() throws IOException {
            this.f1042a.add(new c(d.a(b()), b()));
        }

        public List<c> a() {
            ArrayList arrayList = new ArrayList(this.f1042a);
            this.f1042a.clear();
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() throws IOException {
            while (!this.f1043b.x()) {
                int readByte = this.f1043b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    e(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    f(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int a4 = a(readByte, 31);
                    this.f1045d = a4;
                    if (a4 >= 0 && a4 <= this.f1044c) {
                        d();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f1045d);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    g(a(readByte, 15) - 1);
                } else {
                    h();
                }
            }
        }

        a(int i4, int i5, s sVar) {
            this.f1042a = new ArrayList();
            c[] cVarArr = new c[8];
            this.f1046e = cVarArr;
            this.f1047f = cVarArr.length - 1;
            this.f1048g = 0;
            this.f1049h = 0;
            this.f1044c = i4;
            this.f1045d = i5;
            this.f1043b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l.a(sVar);
        }

        private int a(int i4) {
            return this.f1047f + 1 + i4;
        }

        private void a(int i4, c cVar) {
            this.f1042a.add(cVar);
            int i5 = cVar.f1039c;
            if (i4 != -1) {
                i5 -= this.f1046e[a(i4)].f1039c;
            }
            int i6 = this.f1045d;
            if (i5 > i6) {
                e();
                return;
            }
            int b4 = b((this.f1049h + i5) - i6);
            if (i4 == -1) {
                int i7 = this.f1048g + 1;
                c[] cVarArr = this.f1046e;
                if (i7 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f1047f = this.f1046e.length - 1;
                    this.f1046e = cVarArr2;
                }
                int i8 = this.f1047f;
                this.f1047f = i8 - 1;
                this.f1046e[i8] = cVar;
                this.f1048g++;
            } else {
                this.f1046e[i4 + a(i4) + b4] = cVar;
            }
            this.f1049h += i5;
        }

        private boolean d(int i4) {
            return i4 >= 0 && i4 <= d.f1040a.length - 1;
        }

        private int f() throws IOException {
            return this.f1043b.readByte() & 255;
        }

        private void g() throws IOException {
            a(-1, new c(d.a(b()), b()));
        }

        private void e(int i4) throws IOException {
            if (d(i4)) {
                this.f1042a.add(d.f1040a[i4]);
                return;
            }
            int a4 = a(i4 - d.f1040a.length);
            if (a4 >= 0) {
                c[] cVarArr = this.f1046e;
                if (a4 <= cVarArr.length - 1) {
                    this.f1042a.add(cVarArr[a4]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f b() throws IOException {
            int f4 = f();
            boolean z3 = (f4 & 128) == 128;
            int a4 = a(f4, 127);
            if (z3) {
                return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.a(k.b().a(this.f1043b.f(a4)));
            }
            return this.f1043b.d(a4);
        }

        private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c(int i4) {
            if (d(i4)) {
                return d.f1040a[i4].f1037a;
            }
            return this.f1046e[a(i4 - d.f1040a.length)].f1037a;
        }

        int a(int i4, int i5) throws IOException {
            int i6 = i4 & i5;
            if (i6 < i5) {
                return i6;
            }
            int i7 = 0;
            while (true) {
                int f4 = f();
                if ((f4 & 128) == 0) {
                    return i5 + (f4 << i7);
                }
                i5 += (f4 & 127) << i7;
                i7 += 7;
            }
        }
    }

    /* compiled from: Hpack.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f1050a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1051b;

        /* renamed from: c  reason: collision with root package name */
        private int f1052c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1053d;

        /* renamed from: e  reason: collision with root package name */
        int f1054e;

        /* renamed from: f  reason: collision with root package name */
        c[] f1055f;

        /* renamed from: g  reason: collision with root package name */
        int f1056g;

        /* renamed from: h  reason: collision with root package name */
        int f1057h;

        /* renamed from: i  reason: collision with root package name */
        int f1058i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar) {
            this(4096, true, cVar);
        }

        private void a(c cVar) {
            int i4 = cVar.f1039c;
            int i5 = this.f1054e;
            if (i4 > i5) {
                b();
                return;
            }
            b((this.f1058i + i4) - i5);
            int i6 = this.f1057h + 1;
            c[] cVarArr = this.f1055f;
            if (i6 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f1056g = this.f1055f.length - 1;
                this.f1055f = cVarArr2;
            }
            int i7 = this.f1056g;
            this.f1056g = i7 - 1;
            this.f1055f[i7] = cVar;
            this.f1057h++;
            this.f1058i += i4;
        }

        private void b() {
            Arrays.fill(this.f1055f, (Object) null);
            this.f1056g = this.f1055f.length - 1;
            this.f1057h = 0;
            this.f1058i = 0;
        }

        b(int i4, boolean z3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar) {
            this.f1052c = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.f1055f = cVarArr;
            this.f1056g = cVarArr.length - 1;
            this.f1057h = 0;
            this.f1058i = 0;
            this.f1054e = i4;
            this.f1051b = z3;
            this.f1050a = cVar;
        }

        private int b(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.f1055f.length;
                while (true) {
                    length--;
                    i5 = this.f1056g;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f1055f;
                    i4 -= cVarArr[length].f1039c;
                    this.f1058i -= cVarArr[length].f1039c;
                    this.f1057h--;
                    i6++;
                }
                c[] cVarArr2 = this.f1055f;
                int i7 = i5 + 1;
                System.arraycopy(cVarArr2, i7, cVarArr2, i7 + i6, this.f1057h);
                c[] cVarArr3 = this.f1055f;
                int i8 = this.f1056g + 1;
                Arrays.fill(cVarArr3, i8, i8 + i6, (Object) null);
                this.f1056g += i6;
            }
            return i6;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<c> list) throws IOException {
            int i4;
            int i5;
            if (this.f1053d) {
                int i6 = this.f1052c;
                if (i6 < this.f1054e) {
                    a(i6, 31, 32);
                }
                this.f1053d = false;
                this.f1052c = Integer.MAX_VALUE;
                a(this.f1054e, 31, 32);
            }
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                c cVar = list.get(i7);
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f4 = cVar.f1037a.f();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = cVar.f1038b;
                Integer num = d.f1041b.get(f4);
                if (num != null) {
                    i4 = num.intValue() + 1;
                    if (i4 > 1 && i4 < 8) {
                        c[] cVarArr = d.f1040a;
                        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(cVarArr[i4 - 1].f1038b, fVar)) {
                            i5 = i4;
                        } else if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(cVarArr[i4].f1038b, fVar)) {
                            i5 = i4;
                            i4++;
                        }
                    }
                    i5 = i4;
                    i4 = -1;
                } else {
                    i4 = -1;
                    i5 = -1;
                }
                if (i4 == -1) {
                    int i8 = this.f1056g + 1;
                    int length = this.f1055f.length;
                    while (true) {
                        if (i8 >= length) {
                            break;
                        }
                        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1055f[i8].f1037a, f4)) {
                            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1055f[i8].f1038b, fVar)) {
                                i4 = d.f1040a.length + (i8 - this.f1056g);
                                break;
                            } else if (i5 == -1) {
                                i5 = (i8 - this.f1056g) + d.f1040a.length;
                            }
                        }
                        i8++;
                    }
                }
                if (i4 != -1) {
                    a(i4, 127, 128);
                } else if (i5 == -1) {
                    this.f1050a.writeByte(64);
                    a(f4);
                    a(fVar);
                    a(cVar);
                } else if (f4.b(c.f1031d) && !c.f1036i.equals(f4)) {
                    a(i5, 15, 0);
                    a(fVar);
                } else {
                    a(i5, 63, 64);
                    a(fVar);
                    a(cVar);
                }
            }
        }

        void a(int i4, int i5, int i6) {
            if (i4 < i5) {
                this.f1050a.writeByte(i4 | i6);
                return;
            }
            this.f1050a.writeByte(i6 | i5);
            int i7 = i4 - i5;
            while (i7 >= 128) {
                this.f1050a.writeByte(128 | (i7 & 127));
                i7 >>>= 7;
            }
            this.f1050a.writeByte(i7);
        }

        void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) throws IOException {
            if (this.f1051b && k.b().a(fVar) < fVar.e()) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                k.b().a(fVar, cVar);
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f d4 = cVar.d();
                a(d4.e(), 127, 128);
                this.f1050a.a(d4);
                return;
            }
            a(fVar.e(), 127, 0);
            this.f1050a.a(fVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i4) {
            int min = Math.min(i4, 16384);
            int i5 = this.f1054e;
            if (i5 == min) {
                return;
            }
            if (min < i5) {
                this.f1052c = Math.min(this.f1052c, min);
            }
            this.f1053d = true;
            this.f1054e = min;
            a();
        }

        private void a() {
            int i4 = this.f1054e;
            int i5 = this.f1058i;
            if (i4 < i5) {
                if (i4 == 0) {
                    b();
                } else {
                    b(i5 - i4);
                }
            }
        }
    }

    static {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = c.f1033f;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar2 = c.f1034g;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar3 = c.f1035h;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar4 = c.f1032e;
        f1040a = new c[]{new c(c.f1036i, ""), new c(fVar, "GET"), new c(fVar, "POST"), new c(fVar2, TTPathConst.sSeparator), new c(fVar2, "/index.html"), new c(fVar3, "http"), new c(fVar3, "https"), new c(fVar4, "200"), new c(fVar4, "204"), new c(fVar4, "206"), new c(fVar4, "304"), new c(fVar4, "400"), new c(fVar4, "404"), new c(fVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", Headers.VALUE_ACCEPT_ENCODING), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c(DownloadModel.ETAG, ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f1041b = a();
    }

    private static Map<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f1040a.length);
        int i4 = 0;
        while (true) {
            c[] cVarArr = f1040a;
            if (i4 < cVarArr.length) {
                if (!linkedHashMap.containsKey(cVarArr[i4].f1037a)) {
                    linkedHashMap.put(cVarArr[i4].f1037a, Integer.valueOf(i4));
                }
                i4++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) throws IOException {
        int e4 = fVar.e();
        for (int i4 = 0; i4 < e4; i4++) {
            byte a4 = fVar.a(i4);
            if (a4 >= 65 && a4 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.h());
            }
        }
        return fVar;
    }
}
