package com.bytedance.sdk.component.widget.recycler;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class bk {

    /* renamed from: c  reason: collision with root package name */
    final w f30565c;

    /* renamed from: w  reason: collision with root package name */
    c f30566w = new c();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    interface w {
        int c();

        int c(View view);

        View c(int i4);

        int w();

        int w(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(w wVar) {
        this.f30565c = wVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View c(int i4, int i5, int i6, int i7) {
        int c4 = this.f30565c.c();
        int w3 = this.f30565c.w();
        int i8 = i5 > i4 ? 1 : -1;
        View view = null;
        while (i4 != i5) {
            View c5 = this.f30565c.c(i4);
            this.f30566w.c(c4, w3, this.f30565c.c(c5), this.f30565c.w(c5));
            if (i6 != 0) {
                this.f30566w.c();
                this.f30566w.c(i6);
                if (this.f30566w.w()) {
                    return c5;
                }
            }
            if (i7 != 0) {
                this.f30566w.c();
                this.f30566w.c(i7);
                if (this.f30566w.w()) {
                    view = c5;
                }
            }
            i4 += i8;
        }
        return view;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class c {

        /* renamed from: c  reason: collision with root package name */
        int f30567c = 0;
        int sr;
        int ux;

        /* renamed from: w  reason: collision with root package name */
        int f30568w;
        int xv;

        c() {
        }

        int c(int i4, int i5) {
            if (i4 > i5) {
                return 1;
            }
            return i4 == i5 ? 2 : 4;
        }

        void c(int i4, int i5, int i6, int i7) {
            this.f30568w = i4;
            this.xv = i5;
            this.sr = i6;
            this.ux = i7;
        }

        boolean w() {
            int i4 = this.f30567c;
            if ((i4 & 7) == 0 || (i4 & (c(this.sr, this.f30568w) << 0)) != 0) {
                int i5 = this.f30567c;
                if ((i5 & 112) == 0 || (i5 & (c(this.sr, this.xv) << 4)) != 0) {
                    int i6 = this.f30567c;
                    if ((i6 & 1792) == 0 || (i6 & (c(this.ux, this.f30568w) << 8)) != 0) {
                        int i7 = this.f30567c;
                        return (i7 & 28672) == 0 || (i7 & (c(this.ux, this.xv) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        void c(int i4) {
            this.f30567c = i4 | this.f30567c;
        }

        void c() {
            this.f30567c = 0;
        }
    }
}
