package com.ss.android.socialbase.appdownloader.f.c;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
class c implements gd {

    /* renamed from: a  reason: collision with root package name */
    private int[] f49071a;
    private int bk;
    private int ev;
    private int gd;

    /* renamed from: k  reason: collision with root package name */
    private int f49073k;

    /* renamed from: p  reason: collision with root package name */
    private int f49074p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f49075r;
    private f sr;

    /* renamed from: t  reason: collision with root package name */
    private int f49076t;
    private int[] ux;

    /* renamed from: w  reason: collision with root package name */
    private sr f49077w;
    private int ys;
    private boolean xv = false;

    /* renamed from: f  reason: collision with root package name */
    private C0966c f49072f = new C0966c();

    public c() {
        r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x018c, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void ev() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.c.c.ev():void");
    }

    private final void r() {
        this.ev = -1;
        this.gd = -1;
        this.f49074p = -1;
        this.f49073k = -1;
        this.f49071a = null;
        this.bk = -1;
        this.f49076t = -1;
        this.ys = -1;
    }

    public void c(InputStream inputStream) {
        c();
        if (inputStream != null) {
            this.f49077w = new sr(inputStream, false);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.f.c.r
    public int f() {
        return -1;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.c.r
    public String sr() {
        return "XML line #" + xv();
    }

    public int ux() {
        if (this.ev != 2) {
            return -1;
        }
        return this.f49071a.length / 5;
    }

    public int w() throws ev, IOException {
        if (this.f49077w != null) {
            try {
                ev();
                return this.ev;
            } catch (IOException e4) {
                c();
                throw e4;
            }
        }
        throw new ev("Parser is not opened.", this, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.f.c.r
    public int xv() {
        return this.gd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.appdownloader.f.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class C0966c {

        /* renamed from: c  reason: collision with root package name */
        private int[] f49078c = new int[32];

        /* renamed from: w  reason: collision with root package name */
        private int f49079w;
        private int xv;

        public final void c() {
            this.f49079w = 0;
            this.xv = 0;
        }

        public final void f() {
            int i4 = this.f49079w;
            if (i4 != 0) {
                int i5 = i4 - 1;
                int i6 = this.f49078c[i5] * 2;
                if ((i5 - 1) - i6 != 0) {
                    this.f49079w = i4 - (i6 + 2);
                    this.xv--;
                }
            }
        }

        public final int sr() {
            return this.xv;
        }

        public final void ux() {
            c(2);
            int i4 = this.f49079w;
            int[] iArr = this.f49078c;
            iArr[i4] = 0;
            iArr[i4 + 1] = 0;
            this.f49079w = i4 + 2;
            this.xv++;
        }

        public final int w() {
            int i4 = this.f49079w;
            if (i4 == 0) {
                return 0;
            }
            return this.f49078c[i4 - 1];
        }

        public final boolean xv() {
            int i4;
            int[] iArr;
            int i5;
            int i6 = this.f49079w;
            if (i6 == 0 || (i5 = (iArr = this.f49078c)[i6 - 1]) == 0) {
                return false;
            }
            int i7 = i5 - 1;
            int i8 = i4 - 2;
            iArr[i8] = i7;
            iArr[i8 - ((i7 * 2) + 1)] = i7;
            this.f49079w = i6 - 2;
            return true;
        }

        public final void c(int i4, int i5) {
            if (this.xv == 0) {
                ux();
            }
            c(2);
            int i6 = this.f49079w;
            int i7 = i6 - 1;
            int[] iArr = this.f49078c;
            int i8 = iArr[i7];
            int i9 = i8 + 1;
            iArr[(i7 - 1) - (i8 * 2)] = i9;
            iArr[i7] = i4;
            iArr[i7 + 1] = i5;
            iArr[i7 + 2] = i9;
            this.f49079w = i6 + 2;
        }

        private void c(int i4) {
            int[] iArr = this.f49078c;
            int length = iArr.length;
            int i5 = this.f49079w;
            int i6 = length - i5;
            if (i6 <= i4) {
                int[] iArr2 = new int[(iArr.length + i6) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i5);
                this.f49078c = iArr2;
            }
        }
    }

    private final int ux(int i4) {
        if (this.ev == 2) {
            int i5 = i4 * 5;
            if (i5 < this.f49071a.length) {
                return i5;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i4 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public String sr(int i4) {
        int ux = ux(i4);
        int[] iArr = this.f49071a;
        if (iArr[ux + 3] == 3) {
            return this.sr.c(iArr[ux + 2]);
        }
        int i5 = iArr[ux + 4];
        return "";
    }

    public int xv(int i4) {
        return this.f49071a[ux(i4) + 4];
    }

    public void c() {
        if (this.xv) {
            this.xv = false;
            this.f49077w.c();
            this.f49077w = null;
            this.sr = null;
            this.ux = null;
            this.f49072f.c();
            r();
        }
    }

    public int w(int i4) {
        return this.f49071a[ux(i4) + 3];
    }

    public String c(int i4) {
        int i5 = this.f49071a[ux(i4) + 1];
        return i5 == -1 ? "" : this.sr.c(i5);
    }
}
