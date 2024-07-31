package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Okio;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import com.baidu.mobads.sdk.internal.C2657cj;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Hpack {

    /* renamed from: a */
    static final Header[] f1047a;

    /* renamed from: b */
    static final Map<ByteString, Integer> f1048b;

    /* compiled from: Hpack.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static final class C1033a {

        /* renamed from: a */
        private final List<Header> f1049a;

        /* renamed from: b */
        private final BufferedSource f1050b;

        /* renamed from: c */
        private final int f1051c;

        /* renamed from: d */
        private int f1052d;

        /* renamed from: e */
        Header[] f1053e;

        /* renamed from: f */
        int f1054f;

        /* renamed from: g */
        int f1055g;

        /* renamed from: h */
        int f1056h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1033a(int i, Source source) {
            this(i, i, source);
        }

        /* renamed from: b */
        private int m58669b(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f1053e.length;
                while (true) {
                    length--;
                    i2 = this.f1054f;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.f1053e;
                    i -= headerArr[length].f1046c;
                    this.f1056h -= headerArr[length].f1046c;
                    this.f1055g--;
                    i3++;
                }
                Header[] headerArr2 = this.f1053e;
                int i4 = i2 + 1;
                System.arraycopy(headerArr2, i4, headerArr2, i4 + i3, this.f1055g);
                this.f1054f += i3;
            }
            return i3;
        }

        /* renamed from: d */
        private void m58666d() {
            int i = this.f1052d;
            int i2 = this.f1056h;
            if (i < i2) {
                if (i == 0) {
                    m58664e();
                } else {
                    m58669b(i2 - i);
                }
            }
        }

        /* renamed from: e */
        private void m58664e() {
            Arrays.fill(this.f1053e, (Object) null);
            this.f1054f = this.f1053e.length - 1;
            this.f1055g = 0;
            this.f1056h = 0;
        }

        /* renamed from: f */
        private void m58661f(int i) throws IOException {
            m58671a(-1, new Header(m58667c(i), m58670b()));
        }

        /* renamed from: g */
        private void m58659g(int i) throws IOException {
            this.f1049a.add(new Header(m58667c(i), m58670b()));
        }

        /* renamed from: h */
        private void m58658h() throws IOException {
            this.f1049a.add(new Header(Hpack.m58675a(m58670b()), m58670b()));
        }

        /* renamed from: a */
        public List<Header> m58674a() {
            ArrayList arrayList = new ArrayList(this.f1049a);
            this.f1049a.clear();
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public void m58668c() throws IOException {
            while (!this.f1050b.mo58901x()) {
                int readByte = this.f1050b.readByte() & UByte.f41242c;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    m58663e(m58672a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    m58660g();
                } else if ((readByte & 64) == 64) {
                    m58661f(m58672a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m58672a = m58672a(readByte, 31);
                    this.f1052d = m58672a;
                    if (m58672a >= 0 && m58672a <= this.f1051c) {
                        m58666d();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f1052d);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    m58659g(m58672a(readByte, 15) - 1);
                } else {
                    m58658h();
                }
            }
        }

        C1033a(int i, int i2, Source source) {
            this.f1049a = new ArrayList();
            Header[] headerArr = new Header[8];
            this.f1053e = headerArr;
            this.f1054f = headerArr.length - 1;
            this.f1055g = 0;
            this.f1056h = 0;
            this.f1051c = i;
            this.f1052d = i2;
            this.f1050b = Okio.m58926a(source);
        }

        /* renamed from: a */
        private int m58673a(int i) {
            return this.f1054f + 1 + i;
        }

        /* renamed from: a */
        private void m58671a(int i, Header header) {
            this.f1049a.add(header);
            int i2 = header.f1046c;
            if (i != -1) {
                i2 -= this.f1053e[m58673a(i)].f1046c;
            }
            int i3 = this.f1052d;
            if (i2 > i3) {
                m58664e();
                return;
            }
            int m58669b = m58669b((this.f1056h + i2) - i3);
            if (i == -1) {
                int i4 = this.f1055g + 1;
                Header[] headerArr = this.f1053e;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f1054f = this.f1053e.length - 1;
                    this.f1053e = headerArr2;
                }
                int i5 = this.f1054f;
                this.f1054f = i5 - 1;
                this.f1053e[i5] = header;
                this.f1055g++;
            } else {
                this.f1053e[i + m58673a(i) + m58669b] = header;
            }
            this.f1056h += i2;
        }

        /* renamed from: d */
        private boolean m58665d(int i) {
            return i >= 0 && i <= Hpack.f1047a.length - 1;
        }

        /* renamed from: f */
        private int m58662f() throws IOException {
            return this.f1050b.readByte() & UByte.f41242c;
        }

        /* renamed from: g */
        private void m58660g() throws IOException {
            m58671a(-1, new Header(Hpack.m58675a(m58670b()), m58670b()));
        }

        /* renamed from: e */
        private void m58663e(int i) throws IOException {
            if (m58665d(i)) {
                this.f1049a.add(Hpack.f1047a[i]);
                return;
            }
            int m58673a = m58673a(i - Hpack.f1047a.length);
            if (m58673a >= 0) {
                Header[] headerArr = this.f1053e;
                if (m58673a <= headerArr.length - 1) {
                    this.f1049a.add(headerArr[m58673a]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: b */
        ByteString m58670b() throws IOException {
            int m58662f = m58662f();
            boolean z = (m58662f & 128) == 128;
            int m58672a = m58672a(m58662f, 127);
            if (z) {
                return ByteString.m58940a(Huffman.m58530b().m58531a(this.f1050b.mo58906f(m58672a)));
            }
            return this.f1050b.mo58908d(m58672a);
        }

        /* renamed from: c */
        private ByteString m58667c(int i) {
            if (m58665d(i)) {
                return Hpack.f1047a[i].f1044a;
            }
            return this.f1053e[m58673a(i - Hpack.f1047a.length)].f1044a;
        }

        /* renamed from: a */
        int m58672a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int m58662f = m58662f();
                if ((m58662f & 128) == 0) {
                    return i2 + (m58662f << i4);
                }
                i2 += (m58662f & 127) << i4;
                i4 += 7;
            }
        }
    }

    /* compiled from: Hpack.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static final class C1034b {

        /* renamed from: a */
        private final Buffer f1057a;

        /* renamed from: b */
        private final boolean f1058b;

        /* renamed from: c */
        private int f1059c;

        /* renamed from: d */
        private boolean f1060d;

        /* renamed from: e */
        int f1061e;

        /* renamed from: f */
        Header[] f1062f;

        /* renamed from: g */
        int f1063g;

        /* renamed from: h */
        int f1064h;

        /* renamed from: i */
        int f1065i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1034b(Buffer buffer) {
            this(4096, true, buffer);
        }

        /* renamed from: a */
        private void m58653a(Header header) {
            int i = header.f1046c;
            int i2 = this.f1061e;
            if (i > i2) {
                m58651b();
                return;
            }
            m58650b((this.f1065i + i) - i2);
            int i3 = this.f1064h + 1;
            Header[] headerArr = this.f1062f;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f1063g = this.f1062f.length - 1;
                this.f1062f = headerArr2;
            }
            int i4 = this.f1063g;
            this.f1063g = i4 - 1;
            this.f1062f[i4] = header;
            this.f1064h++;
            this.f1065i += i;
        }

        /* renamed from: b */
        private void m58651b() {
            Arrays.fill(this.f1062f, (Object) null);
            this.f1063g = this.f1062f.length - 1;
            this.f1064h = 0;
            this.f1065i = 0;
        }

        C1034b(int i, boolean z, Buffer buffer) {
            this.f1059c = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.f1062f = headerArr;
            this.f1063g = headerArr.length - 1;
            this.f1064h = 0;
            this.f1065i = 0;
            this.f1061e = i;
            this.f1058b = z;
            this.f1057a = buffer;
        }

        /* renamed from: b */
        private int m58650b(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f1062f.length;
                while (true) {
                    length--;
                    i2 = this.f1063g;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.f1062f;
                    i -= headerArr[length].f1046c;
                    this.f1065i -= headerArr[length].f1046c;
                    this.f1064h--;
                    i3++;
                }
                Header[] headerArr2 = this.f1062f;
                int i4 = i2 + 1;
                System.arraycopy(headerArr2, i4, headerArr2, i4 + i3, this.f1064h);
                Header[] headerArr3 = this.f1062f;
                int i5 = this.f1063g + 1;
                Arrays.fill(headerArr3, i5, i5 + i3, (Object) null);
                this.f1063g += i3;
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m58652a(List<Header> list) throws IOException {
            int i;
            int i2;
            if (this.f1060d) {
                int i3 = this.f1059c;
                if (i3 < this.f1061e) {
                    m58655a(i3, 31, 32);
                }
                this.f1060d = false;
                this.f1059c = Integer.MAX_VALUE;
                m58655a(this.f1061e, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                Header header = list.get(i4);
                ByteString mo58880f = header.f1044a.mo58880f();
                ByteString byteString = header.f1045b;
                Integer num = Hpack.f1048b.get(mo58880f);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        Header[] headerArr = Hpack.f1047a;
                        if (C1061c.m58473a(headerArr[i - 1].f1045b, byteString)) {
                            i2 = i;
                        } else if (C1061c.m58473a(headerArr[i].f1045b, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.f1063g + 1;
                    int length = this.f1062f.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (C1061c.m58473a(this.f1062f[i5].f1044a, mo58880f)) {
                            if (C1061c.m58473a(this.f1062f[i5].f1045b, byteString)) {
                                i = Hpack.f1047a.length + (i5 - this.f1063g);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.f1063g) + Hpack.f1047a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    m58655a(i, 127, 128);
                } else if (i2 == -1) {
                    this.f1057a.writeByte(64);
                    m58654a(mo58880f);
                    m58654a(byteString);
                    m58653a(header);
                } else if (mo58880f.m58939b(Header.f1038d) && !Header.f1043i.equals(mo58880f)) {
                    m58655a(i2, 15, 0);
                    m58654a(byteString);
                } else {
                    m58655a(i2, 63, 64);
                    m58654a(byteString);
                    m58653a(header);
                }
            }
        }

        /* renamed from: a */
        void m58655a(int i, int i2, int i3) {
            if (i < i2) {
                this.f1057a.writeByte(i | i3);
                return;
            }
            this.f1057a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f1057a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f1057a.writeByte(i4);
        }

        /* renamed from: a */
        void m58654a(ByteString byteString) throws IOException {
            if (this.f1058b && Huffman.m58530b().m58533a(byteString) < byteString.mo58881e()) {
                Buffer buffer = new Buffer();
                Huffman.m58530b().m58532a(byteString, buffer);
                ByteString m58949d = buffer.m58949d();
                m58655a(m58949d.mo58881e(), 127, 128);
                this.f1057a.m58959a(m58949d);
                return;
            }
            m58655a(byteString.mo58881e(), 127, 0);
            this.f1057a.m58959a(byteString);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m58656a(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.f1061e;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.f1059c = Math.min(this.f1059c, min);
            }
            this.f1060d = true;
            this.f1061e = min;
            m58657a();
        }

        /* renamed from: a */
        private void m58657a() {
            int i = this.f1061e;
            int i2 = this.f1065i;
            if (i < i2) {
                if (i == 0) {
                    m58651b();
                } else {
                    m58650b(i2 - i);
                }
            }
        }
    }

    static {
        ByteString byteString = Header.f1040f;
        ByteString byteString2 = Header.f1041g;
        ByteString byteString3 = Header.f1042h;
        ByteString byteString4 = Header.f1039e;
        f1047a = new Header[]{new Header(Header.f1043i, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, IDataSource.f43971a), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, C2657cj.f8821b), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(DownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header(Constants.FROM, ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(SocializeConstants.KEY_LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, ""), new Header("www-authenticate", "")};
        f1048b = m58676a();
    }

    /* renamed from: a */
    private static Map<ByteString, Integer> m58676a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f1047a.length);
        int i = 0;
        while (true) {
            Header[] headerArr = f1047a;
            if (i < headerArr.length) {
                if (!linkedHashMap.containsKey(headerArr[i].f1044a)) {
                    linkedHashMap.put(headerArr[i].f1044a, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    /* renamed from: a */
    static ByteString m58675a(ByteString byteString) throws IOException {
        int mo58881e = byteString.mo58881e();
        for (int i = 0; i < mo58881e; i++) {
            byte mo58890a = byteString.mo58890a(i);
            if (mo58890a >= 65 && mo58890a <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.mo58878h());
            }
        }
        return byteString;
    }
}
