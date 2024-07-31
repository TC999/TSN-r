package com.p521ss.android.socialbase.appdownloader.p543kf.p544ok;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.ok.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12324ok implements InterfaceC12327q {

    /* renamed from: a */
    private C12328s f34749a;

    /* renamed from: h */
    private boolean f34751h;

    /* renamed from: j */
    private int[] f34752j;

    /* renamed from: k */
    private int f34753k;

    /* renamed from: n */
    private int[] f34755n;

    /* renamed from: p */
    private int f34756p;

    /* renamed from: q */
    private int f34757q;

    /* renamed from: r */
    private int f34758r;

    /* renamed from: rh */
    private int f34759rh;

    /* renamed from: s */
    private C12322kf f34760s;

    /* renamed from: t */
    private int f34761t;

    /* renamed from: z */
    private int f34762z;

    /* renamed from: bl */
    private boolean f34750bl = false;

    /* renamed from: kf */
    private C12325ok f34754kf = new C12325ok();

    public C12324ok() {
        m18198h();
    }

    /* renamed from: h */
    private final void m18198h() {
        this.f34756p = -1;
        this.f34757q = -1;
        this.f34753k = -1;
        this.f34758r = -1;
        this.f34752j = null;
        this.f34762z = -1;
        this.f34759rh = -1;
        this.f34761t = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x018c, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m18191p() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.appdownloader.p543kf.p544ok.C12324ok.m18191p():void");
    }

    /* renamed from: a */
    public int m18202a() throws C12326p, IOException {
        if (this.f34749a != null) {
            try {
                m18191p();
                return this.f34756p;
            } catch (IOException e) {
                m18194ok();
                throw e;
            }
        }
        throw new C12326p("Parser is not opened.", this, null);
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p543kf.p544ok.InterfaceC12321h
    /* renamed from: bl */
    public int mo18200bl() {
        return this.f34757q;
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p543kf.p544ok.InterfaceC12321h
    /* renamed from: kf */
    public int mo18197kf() {
        return -1;
    }

    /* renamed from: n */
    public int m18196n() {
        if (this.f34756p != 2) {
            return -1;
        }
        return this.f34752j.length / 5;
    }

    /* renamed from: ok */
    public void m18192ok(InputStream inputStream) {
        m18194ok();
        if (inputStream != null) {
            this.f34749a = new C12328s(inputStream, false);
        }
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p543kf.p544ok.InterfaceC12321h
    /* renamed from: s */
    public String mo18190s() {
        return "XML line #" + mo18200bl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.appdownloader.kf.ok.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C12325ok {

        /* renamed from: a */
        private int f34763a;

        /* renamed from: bl */
        private int f34764bl;

        /* renamed from: ok */
        private int[] f34765ok = new int[32];

        /* renamed from: a */
        public final int m18188a() {
            int i = this.f34763a;
            if (i == 0) {
                return 0;
            }
            return this.f34765ok[i - 1];
        }

        /* renamed from: bl */
        public final boolean m18187bl() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.f34763a;
            if (i3 == 0 || (i2 = (iArr = this.f34765ok)[i3 - 1]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.f34763a = i3 - 2;
            return true;
        }

        /* renamed from: kf */
        public final void m18186kf() {
            int i = this.f34763a;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.f34765ok[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.f34763a = i - (i3 + 2);
                    this.f34764bl--;
                }
            }
        }

        /* renamed from: n */
        public final void m18185n() {
            m18183ok(2);
            int i = this.f34763a;
            int[] iArr = this.f34765ok;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.f34763a = i + 2;
            this.f34764bl++;
        }

        /* renamed from: ok */
        public final void m18184ok() {
            this.f34763a = 0;
            this.f34764bl = 0;
        }

        /* renamed from: s */
        public final int m18181s() {
            return this.f34764bl;
        }

        /* renamed from: ok */
        public final void m18182ok(int i, int i2) {
            if (this.f34764bl == 0) {
                m18185n();
            }
            m18183ok(2);
            int i3 = this.f34763a;
            int i4 = i3 - 1;
            int[] iArr = this.f34765ok;
            int i5 = iArr[i4];
            int i6 = i5 + 1;
            iArr[(i4 - 1) - (i5 * 2)] = i6;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i6;
            this.f34763a = i3 + 2;
        }

        /* renamed from: ok */
        private void m18183ok(int i) {
            int[] iArr = this.f34765ok;
            int length = iArr.length;
            int i2 = this.f34763a;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.f34765ok = iArr2;
            }
        }
    }

    /* renamed from: n */
    private final int m18195n(int i) {
        if (this.f34756p == 2) {
            int i2 = i * 5;
            if (i2 < this.f34752j.length) {
                return i2;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    /* renamed from: bl */
    public int m18199bl(int i) {
        return this.f34752j[m18195n(i) + 4];
    }

    /* renamed from: s */
    public String m18189s(int i) {
        int m18195n = m18195n(i);
        int[] iArr = this.f34752j;
        if (iArr[m18195n + 3] == 3) {
            return this.f34760s.m18212ok(iArr[m18195n + 2]);
        }
        int i2 = iArr[m18195n + 4];
        return "";
    }

    /* renamed from: ok */
    public void m18194ok() {
        if (this.f34750bl) {
            this.f34750bl = false;
            this.f34749a.m18176ok();
            this.f34749a = null;
            this.f34760s = null;
            this.f34755n = null;
            this.f34754kf.m18184ok();
            m18198h();
        }
    }

    /* renamed from: a */
    public int m18201a(int i) {
        return this.f34752j[m18195n(i) + 3];
    }

    /* renamed from: ok */
    public String m18193ok(int i) {
        int i2 = this.f34752j[m18195n(i) + 1];
        return i2 == -1 ? "" : this.f34760s.m18212ok(i2);
    }
}
