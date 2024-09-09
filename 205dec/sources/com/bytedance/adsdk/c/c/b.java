package com.bytedance.adsdk.c.c;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface b extends Animatable {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class a {
        public void a(Drawable drawable) {
        }

        public void b(Drawable drawable) {
        }
    }

    /* renamed from: com.bytedance.adsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class C0348b extends f {

        /* renamed from: b  reason: collision with root package name */
        private static ThreadLocal<byte[]> f25258b = new ThreadLocal<>();

        public C0348b(c cVar) {
            super(cVar);
        }

        protected static byte[] g() {
            byte[] bArr = f25258b.get();
            if (bArr == null) {
                byte[] bArr2 = new byte[4];
                f25258b.set(bArr2);
                return bArr2;
            }
            return bArr;
        }

        public short b() throws IOException {
            byte[] g4 = g();
            c(g4, 0, 2);
            return (short) (((g4[0] & 255) << 8) | (g4[1] & 255));
        }

        public int d() throws IOException {
            byte[] g4 = g();
            c(g4, 0, 4);
            return ((g4[3] & 255) << 24) | (g4[0] & 255) | ((g4[1] & 255) << 8) | ((g4[2] & 255) << 16);
        }

        public boolean e(String str) throws IOException {
            if (TextUtils.isEmpty(str) || str.length() != 4) {
                return false;
            }
            int d4 = d();
            for (int i4 = 0; i4 < 4; i4++) {
                if (((d4 >> (i4 * 8)) & 255) != str.charAt(i4)) {
                    return false;
                }
            }
            return true;
        }

        public int h() throws IOException {
            byte[] g4 = g();
            c(g4, 0, 4);
            return ((g4[0] & 255) << 24) | (g4[3] & 255) | ((g4[2] & 255) << 8) | ((g4[1] & 255) << 16);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void a() throws IOException;

        int c(byte[] bArr, int i4, int i5) throws IOException;

        long c(long j4) throws IOException;

        byte c_() throws IOException;

        InputStream f() throws IOException;

        int sr() throws IOException;

        void ux() throws IOException;

        int xv();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface d {
        void xv() throws IOException;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class e implements d {

        /* renamed from: a  reason: collision with root package name */
        protected ByteBuffer f25259a;

        public e() {
            f(10240);
        }

        public int a() {
            return this.f25259a.position();
        }

        public void b(byte b4) {
            this.f25259a.put(b4);
        }

        public void c(byte[] bArr) {
            this.f25259a.put(bArr);
        }

        public void d(int i4) {
            this.f25259a.position(i4 + a());
        }

        public byte[] e() {
            return this.f25259a.array();
        }

        public void f(int i4) {
            ByteBuffer byteBuffer = this.f25259a;
            if (byteBuffer == null || i4 > byteBuffer.capacity()) {
                ByteBuffer allocate = ByteBuffer.allocate(i4);
                this.f25259a = allocate;
                allocate.order(ByteOrder.LITTLE_ENDIAN);
            }
            this.f25259a.clear();
        }

        @Override // com.bytedance.adsdk.c.c.b.d
        public void xv() {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class f implements c {

        /* renamed from: a  reason: collision with root package name */
        protected c f25260a;

        public f(c cVar) {
            this.f25260a = cVar;
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public void a() throws IOException {
            this.f25260a.a();
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public long c(long j4) throws IOException {
            return this.f25260a.c(j4);
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public byte c_() throws IOException {
            return this.f25260a.c_();
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public InputStream f() throws IOException {
            a();
            return this.f25260a.f();
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public int sr() throws IOException {
            return this.f25260a.sr();
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public void ux() throws IOException {
            this.f25260a.ux();
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public int xv() {
            return this.f25260a.xv();
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public int c(byte[] bArr, int i4, int i5) throws IOException {
            return this.f25260a.c(bArr, i4, i5);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class g extends e {
        @Override // com.bytedance.adsdk.c.c.b.e
        public void f(int i4) {
            super.f(i4);
            this.f25259a.order(ByteOrder.BIG_ENDIAN);
        }

        public void g(int i4) {
            b((byte) (i4 & 255));
            b((byte) ((i4 >> 8) & 255));
            b((byte) ((i4 >> 16) & 255));
            b((byte) ((i4 >> 24) & 255));
        }

        public void h(int i4) {
            b((byte) ((i4 >> 24) & 255));
            b((byte) ((i4 >> 16) & 255));
            b((byte) ((i4 >> 8) & 255));
            b((byte) (i4 & 255));
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class h implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f25261a;

        public h(ByteBuffer byteBuffer) {
            this.f25261a = byteBuffer;
            byteBuffer.position(0);
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public void a() throws IOException {
            this.f25261a.position(0);
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public long c(long j4) throws IOException {
            ByteBuffer byteBuffer = this.f25261a;
            byteBuffer.position((int) (byteBuffer.position() + j4));
            return j4;
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public byte c_() throws IOException {
            return this.f25261a.get();
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public InputStream f() throws IOException {
            return new ByteArrayInputStream(this.f25261a.array());
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public int sr() throws IOException {
            return this.f25261a.limit() - this.f25261a.position();
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public void ux() throws IOException {
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public int xv() {
            return this.f25261a.position();
        }

        @Override // com.bytedance.adsdk.c.c.b.c
        public int c(byte[] bArr, int i4, int i5) throws IOException {
            this.f25261a.get(bArr, i4, i5);
            return i5;
        }
    }
}
