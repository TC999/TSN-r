package com.bytedance.pangle.res.p124a;

import java.io.IOException;
import java.util.HashMap;

/* renamed from: com.bytedance.pangle.res.a.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6202b {

    /* renamed from: c */
    C6209g f22149c;

    /* renamed from: i */
    private final InterfaceC6210h f22155i;

    /* renamed from: j */
    private final byte[] f22156j;

    /* renamed from: l */
    private int[] f22158l;

    /* renamed from: n */
    private boolean f22160n;

    /* renamed from: o */
    private int f22161o;

    /* renamed from: p */
    private int[] f22162p;

    /* renamed from: q */
    private int f22163q;

    /* renamed from: a */
    HashMap<Integer, Integer> f22147a = new HashMap<>();

    /* renamed from: b */
    boolean f22148b = false;

    /* renamed from: k */
    private boolean f22157k = false;

    /* renamed from: m */
    private final C6203a f22159m = new C6203a();

    /* renamed from: d */
    int f22150d = 0;

    /* renamed from: e */
    int f22151e = 1;

    /* renamed from: f */
    int f22152f = 2;

    /* renamed from: g */
    int f22153g = 3;

    /* renamed from: h */
    int f22154h = 4;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.res.a.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6203a {

        /* renamed from: a */
        int[] f22164a = new int[32];

        /* renamed from: b */
        int f22165b;

        /* renamed from: c */
        int f22166c;

        /* renamed from: a */
        public final void m36991a() {
            m36990b();
            int i = this.f22165b;
            int[] iArr = this.f22164a;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.f22165b = i + 2;
            this.f22166c++;
        }

        /* renamed from: b */
        final void m36990b() {
            int[] iArr = this.f22164a;
            int length = iArr.length;
            int i = this.f22165b;
            int i2 = length - i;
            if (i2 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.f22164a = iArr2;
        }
    }

    public C6202b(byte[] bArr, InterfaceC6210h interfaceC6210h) {
        this.f22155i = interfaceC6210h;
        this.f22156j = bArr;
        m36993c();
    }

    /* renamed from: c */
    private void m36993c() {
        this.f22161o = -1;
        this.f22162p = null;
        this.f22163q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0295, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012b, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r6 + ").");
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m36992d() {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.p124a.C6202b.m36992d():void");
    }

    /* renamed from: a */
    public final void m36995a() {
        if (this.f22157k) {
            this.f22157k = false;
            this.f22149c = null;
            this.f22158l = null;
            C6203a c6203a = this.f22159m;
            c6203a.f22165b = 0;
            c6203a.f22166c = 0;
            m36993c();
        }
    }

    /* renamed from: b */
    public final int m36994b() {
        if (this.f22149c != null) {
            try {
                m36992d();
                return this.f22161o;
            } catch (IOException e) {
                m36995a();
                throw e;
            }
        }
        throw new RuntimeException("Parser is not opened.");
    }
}
