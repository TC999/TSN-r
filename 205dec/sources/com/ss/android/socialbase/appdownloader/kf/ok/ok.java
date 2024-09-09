package com.ss.android.socialbase.appdownloader.kf.ok;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
class ok implements q {

    /* renamed from: a  reason: collision with root package name */
    private s f49130a;

    /* renamed from: h  reason: collision with root package name */
    private boolean f49131h;

    /* renamed from: j  reason: collision with root package name */
    private int[] f49132j;

    /* renamed from: k  reason: collision with root package name */
    private int f49133k;

    /* renamed from: n  reason: collision with root package name */
    private int[] f49134n;

    /* renamed from: p  reason: collision with root package name */
    private int f49135p;

    /* renamed from: q  reason: collision with root package name */
    private int f49136q;

    /* renamed from: r  reason: collision with root package name */
    private int f49137r;
    private int rh;

    /* renamed from: s  reason: collision with root package name */
    private kf f49138s;

    /* renamed from: t  reason: collision with root package name */
    private int f49139t;

    /* renamed from: z  reason: collision with root package name */
    private int f49140z;
    private boolean bl = false;
    private C0967ok kf = new C0967ok();

    public ok() {
        h();
    }

    private final void h() {
        this.f49135p = -1;
        this.f49136q = -1;
        this.f49133k = -1;
        this.f49137r = -1;
        this.f49132j = null;
        this.f49140z = -1;
        this.rh = -1;
        this.f49139t = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x018c, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void p() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.kf.ok.ok.p():void");
    }

    public int a() throws p, IOException {
        if (this.f49130a != null) {
            try {
                p();
                return this.f49135p;
            } catch (IOException e4) {
                ok();
                throw e4;
            }
        }
        throw new p("Parser is not opened.", this, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.kf.ok.h
    public int bl() {
        return this.f49136q;
    }

    @Override // com.ss.android.socialbase.appdownloader.kf.ok.h
    public int kf() {
        return -1;
    }

    public int n() {
        if (this.f49135p != 2) {
            return -1;
        }
        return this.f49132j.length / 5;
    }

    public void ok(InputStream inputStream) {
        ok();
        if (inputStream != null) {
            this.f49130a = new s(inputStream, false);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.kf.ok.h
    public String s() {
        return "XML line #" + bl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.appdownloader.kf.ok.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class C0967ok {

        /* renamed from: a  reason: collision with root package name */
        private int f49141a;
        private int bl;
        private int[] ok = new int[32];

        public final int a() {
            int i4 = this.f49141a;
            if (i4 == 0) {
                return 0;
            }
            return this.ok[i4 - 1];
        }

        public final boolean bl() {
            int i4;
            int[] iArr;
            int i5;
            int i6 = this.f49141a;
            if (i6 == 0 || (i5 = (iArr = this.ok)[i6 - 1]) == 0) {
                return false;
            }
            int i7 = i5 - 1;
            int i8 = i4 - 2;
            iArr[i8] = i7;
            iArr[i8 - ((i7 * 2) + 1)] = i7;
            this.f49141a = i6 - 2;
            return true;
        }

        public final void kf() {
            int i4 = this.f49141a;
            if (i4 != 0) {
                int i5 = i4 - 1;
                int i6 = this.ok[i5] * 2;
                if ((i5 - 1) - i6 != 0) {
                    this.f49141a = i4 - (i6 + 2);
                    this.bl--;
                }
            }
        }

        public final void n() {
            ok(2);
            int i4 = this.f49141a;
            int[] iArr = this.ok;
            iArr[i4] = 0;
            iArr[i4 + 1] = 0;
            this.f49141a = i4 + 2;
            this.bl++;
        }

        public final void ok() {
            this.f49141a = 0;
            this.bl = 0;
        }

        public final int s() {
            return this.bl;
        }

        public final void ok(int i4, int i5) {
            if (this.bl == 0) {
                n();
            }
            ok(2);
            int i6 = this.f49141a;
            int i7 = i6 - 1;
            int[] iArr = this.ok;
            int i8 = iArr[i7];
            int i9 = i8 + 1;
            iArr[(i7 - 1) - (i8 * 2)] = i9;
            iArr[i7] = i4;
            iArr[i7 + 1] = i5;
            iArr[i7 + 2] = i9;
            this.f49141a = i6 + 2;
        }

        private void ok(int i4) {
            int[] iArr = this.ok;
            int length = iArr.length;
            int i5 = this.f49141a;
            int i6 = length - i5;
            if (i6 <= i4) {
                int[] iArr2 = new int[(iArr.length + i6) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i5);
                this.ok = iArr2;
            }
        }
    }

    private final int n(int i4) {
        if (this.f49135p == 2) {
            int i5 = i4 * 5;
            if (i5 < this.f49132j.length) {
                return i5;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i4 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public int bl(int i4) {
        return this.f49132j[n(i4) + 4];
    }

    public String s(int i4) {
        int n4 = n(i4);
        int[] iArr = this.f49132j;
        if (iArr[n4 + 3] == 3) {
            return this.f49138s.ok(iArr[n4 + 2]);
        }
        int i5 = iArr[n4 + 4];
        return "";
    }

    public void ok() {
        if (this.bl) {
            this.bl = false;
            this.f49130a.ok();
            this.f49130a = null;
            this.f49138s = null;
            this.f49134n = null;
            this.kf.ok();
            h();
        }
    }

    public int a(int i4) {
        return this.f49132j[n(i4) + 3];
    }

    public String ok(int i4) {
        int i5 = this.f49132j[n(i4) + 1];
        return i5 == -1 ? "" : this.f49138s.ok(i5);
    }
}
