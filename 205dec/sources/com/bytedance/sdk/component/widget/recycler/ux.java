package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends RecyclerView.gd implements RecyclerView.fz.w {

    /* renamed from: c  reason: collision with root package name */
    int f30608c;

    /* renamed from: f  reason: collision with root package name */
    sr f30609f;
    private boolean fz;
    private int gb;

    /* renamed from: i  reason: collision with root package name */
    private boolean f30610i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f30611j;
    private final w ls;

    /* renamed from: q  reason: collision with root package name */
    private boolean f30612q;

    /* renamed from: r  reason: collision with root package name */
    final c f30613r;

    /* renamed from: s  reason: collision with root package name */
    private xv f30614s;
    int sr;

    /* renamed from: u  reason: collision with root package name */
    private boolean f30615u;
    int ux;

    /* renamed from: w  reason: collision with root package name */
    ev f30616w;
    boolean xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        ev f30617c;
        boolean sr;
        boolean ux;

        /* renamed from: w  reason: collision with root package name */
        int f30618w;
        int xv;

        c() {
            c();
        }

        void c() {
            this.f30618w = -1;
            this.xv = Integer.MIN_VALUE;
            this.sr = false;
            this.ux = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f30618w + ", mCoordinate=" + this.xv + ", mLayoutFromEnd=" + this.sr + ", mValid=" + this.ux + '}';
        }

        void w() {
            this.xv = this.sr ? this.f30617c.sr() : this.f30617c.xv();
        }

        public void w(View view, int i4) {
            if (this.sr) {
                this.xv = this.f30617c.w(view) + this.f30617c.w();
            } else {
                this.xv = this.f30617c.c(view);
            }
            this.f30618w = i4;
        }

        boolean c(View view, RecyclerView.u uVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.w() && pVar.sr() >= 0 && pVar.sr() < uVar.sr();
        }

        public void c(View view, int i4) {
            int w3 = this.f30617c.w();
            if (w3 >= 0) {
                w(view, i4);
                return;
            }
            this.f30618w = i4;
            if (this.sr) {
                int sr = (this.f30617c.sr() - w3) - this.f30617c.w(view);
                this.xv = this.f30617c.sr() - sr;
                if (sr > 0) {
                    int ux = this.xv - this.f30617c.ux(view);
                    int xv = this.f30617c.xv();
                    int min = ux - (xv + Math.min(this.f30617c.c(view) - xv, 0));
                    if (min < 0) {
                        this.xv += Math.min(sr, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int c4 = this.f30617c.c(view);
            int xv2 = c4 - this.f30617c.xv();
            this.xv = c4;
            if (xv2 > 0) {
                int sr2 = (this.f30617c.sr() - Math.min(0, (this.f30617c.sr() - w3) - this.f30617c.w(view))) - (c4 + this.f30617c.ux(view));
                if (sr2 < 0) {
                    this.xv -= Math.min(xv2, -sr2);
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class sr implements Parcelable {
        public static final Parcelable.Creator<sr> CREATOR = new Parcelable.Creator<sr>() { // from class: com.bytedance.sdk.component.widget.recycler.ux.sr.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public sr createFromParcel(Parcel parcel) {
                return new sr(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public sr[] newArray(int i4) {
                return new sr[i4];
            }
        };

        /* renamed from: c  reason: collision with root package name */
        int f30619c;

        /* renamed from: w  reason: collision with root package name */
        int f30620w;
        boolean xv;

        public sr() {
        }

        boolean c() {
            return this.f30619c >= 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void w() {
            this.f30619c = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f30619c);
            parcel.writeInt(this.f30620w);
            parcel.writeInt(this.xv ? 1 : 0);
        }

        sr(Parcel parcel) {
            this.f30619c = parcel.readInt();
            this.f30620w = parcel.readInt();
            this.xv = parcel.readInt() == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {

        /* renamed from: c  reason: collision with root package name */
        public int f30621c;
        public boolean sr;

        /* renamed from: w  reason: collision with root package name */
        public boolean f30622w;
        public boolean xv;

        protected w() {
        }

        void c() {
            this.f30621c = 0;
            this.f30622w = false;
            this.xv = false;
            this.sr = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class xv {

        /* renamed from: a  reason: collision with root package name */
        boolean f30623a;

        /* renamed from: f  reason: collision with root package name */
        int f30625f;

        /* renamed from: p  reason: collision with root package name */
        int f30627p;

        /* renamed from: r  reason: collision with root package name */
        int f30628r;
        int sr;
        int ux;

        /* renamed from: w  reason: collision with root package name */
        int f30629w;
        int xv;

        /* renamed from: c  reason: collision with root package name */
        boolean f30624c = true;
        int ev = 0;
        boolean gd = false;

        /* renamed from: k  reason: collision with root package name */
        List<RecyclerView.j> f30626k = null;

        xv() {
        }

        private View w() {
            int size = this.f30626k.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.f30626k.get(i4).sr;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.w() && this.sr == pVar.sr()) {
                    c(view);
                    return view;
                }
            }
            return null;
        }

        boolean c(RecyclerView.u uVar) {
            int i4 = this.sr;
            return i4 >= 0 && i4 < uVar.sr();
        }

        View c(RecyclerView.fp fpVar) {
            if (this.f30626k != null) {
                return w();
            }
            View w3 = fpVar.w(this.sr);
            this.sr += this.ux;
            return w3;
        }

        public void c() {
            c((View) null);
        }

        public View w(View view) {
            int sr;
            int size = this.f30626k.size();
            View view2 = null;
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < size; i5++) {
                View view3 = this.f30626k.get(i5).sr;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.w() && (sr = (pVar.sr() - this.sr) * this.ux) >= 0 && sr < i4) {
                    view2 = view3;
                    if (sr == 0) {
                        break;
                    }
                    i4 = sr;
                }
            }
            return view2;
        }

        public void c(View view) {
            View w3 = w(view);
            if (w3 == null) {
                this.sr = -1;
            } else {
                this.sr = ((RecyclerView.p) w3.getLayoutParams()).sr();
            }
        }
    }

    public ux(Context context) {
        this(context, 1, false);
    }

    private View bw() {
        return ev(this.xv ? 0 : i() - 1);
    }

    private void f(int i4, int i5) {
        this.f30614s.xv = this.f30616w.sr() - i5;
        xv xvVar = this.f30614s;
        xvVar.ux = this.xv ? -1 : 1;
        xvVar.sr = i4;
        xvVar.f30625f = 1;
        xvVar.f30629w = i5;
        xvVar.f30628r = Integer.MIN_VALUE;
    }

    private int gd(RecyclerView.u uVar) {
        if (i() == 0) {
            return 0;
        }
        f();
        return p.c(uVar, this.f30616w, c(!this.f30612q, true), w(!this.f30612q, true), this, this.f30612q, this.xv);
    }

    private int k(RecyclerView.u uVar) {
        if (i() == 0) {
            return 0;
        }
        f();
        return p.w(uVar, this.f30616w, c(!this.f30612q, true), w(!this.f30612q, true), this, this.f30612q);
    }

    private int p(RecyclerView.u uVar) {
        if (i() == 0) {
            return 0;
        }
        f();
        return p.c(uVar, this.f30616w, c(!this.f30612q, true), w(!this.f30612q, true), this, this.f30612q);
    }

    private View pr() {
        return ev(this.xv ? i() - 1 : 0);
    }

    private void r(int i4, int i5) {
        this.f30614s.xv = i5 - this.f30616w.xv();
        xv xvVar = this.f30614s;
        xvVar.sr = i4;
        xvVar.ux = this.xv ? 1 : -1;
        xvVar.f30625f = -1;
        xvVar.f30629w = i5;
        xvVar.f30628r = Integer.MIN_VALUE;
    }

    private void wx() {
        if (this.f30608c != 1 && ux()) {
            this.xv = !this.f30615u;
        } else {
            this.xv = this.f30615u;
        }
    }

    public int a() {
        View c4 = c(i() - 1, -1, false, true);
        if (c4 == null) {
            return -1;
        }
        return sr(c4);
    }

    public int bk() {
        View c4 = c(i() - 1, -1, true, false);
        if (c4 == null) {
            return -1;
        }
        return sr(c4);
    }

    void c(RecyclerView.fp fpVar, RecyclerView.u uVar, c cVar, int i4) {
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void c(RecyclerView recyclerView, RecyclerView.fp fpVar) {
        super.c(recyclerView, fpVar);
        if (this.f30611j) {
            xv(fpVar);
            fpVar.c();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public boolean c() {
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int ev(RecyclerView.u uVar) {
        return k(uVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public boolean sr() {
        return this.f30608c == 1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public boolean t() {
        return this.f30609f == null && this.fz == this.f30610i;
    }

    protected boolean ux() {
        return fz() == 1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public RecyclerView.p w() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public boolean xv() {
        return this.f30608c == 0;
    }

    public ux(Context context, int i4, boolean z3) {
        this.f30608c = 1;
        this.f30615u = false;
        this.xv = false;
        this.f30610i = false;
        this.f30612q = true;
        this.sr = -1;
        this.ux = Integer.MIN_VALUE;
        this.f30609f = null;
        this.f30613r = new c();
        this.ls = new w();
        this.gb = 2;
        c(i4);
        c(z3);
    }

    boolean ev() {
        return this.f30616w.ev() == 0 && this.f30616w.ux() == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void sr(int i4) {
        this.sr = i4;
        this.ux = Integer.MIN_VALUE;
        sr srVar = this.f30609f;
        if (srVar != null) {
            srVar.w();
        }
        ys();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int ux(RecyclerView.u uVar) {
        return p(uVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public View w(int i4) {
        int i5 = i();
        if (i5 == 0) {
            return null;
        }
        int sr2 = i4 - sr(ev(0));
        if (sr2 >= 0 && sr2 < i5) {
            View ev = ev(sr2);
            if (sr(ev) == i4) {
                return ev;
            }
        }
        return super.w(i4);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fz.w
    public PointF xv(int i4) {
        if (i() == 0) {
            return null;
        }
        int i5 = (i4 < sr(ev(0))) != this.xv ? -1 : 1;
        return this.f30608c == 0 ? new PointF(i5, 0.0f) : new PointF(0.0f, i5);
    }

    private View ev(RecyclerView.fp fpVar, RecyclerView.u uVar) {
        return c(0, i());
    }

    int ux(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 17 ? i4 != 33 ? i4 != 66 ? (i4 == 130 && this.f30608c == 1) ? 1 : Integer.MIN_VALUE : this.f30608c == 0 ? 1 : Integer.MIN_VALUE : this.f30608c == 1 ? -1 : Integer.MIN_VALUE : this.f30608c == 0 ? -1 : Integer.MIN_VALUE : (this.f30608c != 1 && ux()) ? -1 : 1 : (this.f30608c != 1 && ux()) ? 1 : -1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    boolean gd() {
        return (j() == 1073741824 || q() == 1073741824 || !yu()) ? false : true;
    }

    public int k() {
        View c4 = c(0, i(), true, false);
        if (c4 == null) {
            return -1;
        }
        return sr(c4);
    }

    public int p() {
        View c4 = c(0, i(), false, true);
        if (c4 == null) {
            return -1;
        }
        return sr(c4);
    }

    private View gd(RecyclerView.fp fpVar, RecyclerView.u uVar) {
        return c(i() - 1, -1);
    }

    public void c(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i4);
        }
        c((String) null);
        if (i4 != this.f30608c || this.f30616w == null) {
            ev c4 = ev.c(this, i4);
            this.f30616w = c4;
            this.f30613r.f30617c = c4;
            this.f30608c = i4;
            ys();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int xv(RecyclerView.u uVar) {
        return gd(uVar);
    }

    void f() {
        if (this.f30614s == null) {
            this.f30614s = r();
        }
    }

    xv r() {
        return new xv();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int sr(RecyclerView.u uVar) {
        return gd(uVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void w(RecyclerView.u uVar) {
        super.w(uVar);
        this.f30609f = null;
        this.sr = -1;
        this.ux = Integer.MIN_VALUE;
        this.f30613r.c();
    }

    int xv(int i4, RecyclerView.fp fpVar, RecyclerView.u uVar) {
        if (i() == 0 || i4 == 0) {
            return 0;
        }
        this.f30614s.f30624c = true;
        f();
        int i5 = i4 > 0 ? 1 : -1;
        int abs = Math.abs(i4);
        c(i5, abs, true, uVar);
        xv xvVar = this.f30614s;
        int c4 = xvVar.f30628r + c(fpVar, xvVar, uVar, false);
        if (c4 < 0) {
            return 0;
        }
        if (abs > c4) {
            i4 = i5 * c4;
        }
        this.f30616w.c(-i4);
        this.f30614s.f30627p = i4;
        return i4;
    }

    private View sr(RecyclerView.fp fpVar, RecyclerView.u uVar) {
        return c(fpVar, uVar, 0, i(), uVar.sr());
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int r(RecyclerView.u uVar) {
        return k(uVar);
    }

    private View r(RecyclerView.fp fpVar, RecyclerView.u uVar) {
        return this.xv ? gd(fpVar, uVar) : ev(fpVar, uVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int f(RecyclerView.u uVar) {
        return p(uVar);
    }

    private View f(RecyclerView.fp fpVar, RecyclerView.u uVar) {
        return this.xv ? ev(fpVar, uVar) : gd(fpVar, uVar);
    }

    private View ux(RecyclerView.fp fpVar, RecyclerView.u uVar) {
        return c(fpVar, uVar, i() - 1, -1, uVar.sr());
    }

    private void w(RecyclerView.fp fpVar, RecyclerView.u uVar, int i4, int i5) {
        if (!uVar.w() || i() == 0 || uVar.c() || !t()) {
            return;
        }
        List<RecyclerView.j> xv2 = fpVar.xv();
        int size = xv2.size();
        int sr2 = sr(ev(0));
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            RecyclerView.j jVar = xv2.get(i8);
            if (!jVar.i()) {
                if (((jVar.ev() < sr2) != this.xv ? '\uffff' : (char) 1) == '\uffff') {
                    i6 += this.f30616w.ux(jVar.sr);
                } else {
                    i7 += this.f30616w.ux(jVar.sr);
                }
            }
        }
        this.f30614s.f30626k = xv2;
        if (i6 > 0) {
            r(sr(pr()), i4);
            xv xvVar = this.f30614s;
            xvVar.ev = i6;
            xvVar.xv = 0;
            xvVar.c();
            c(fpVar, this.f30614s, uVar, false);
        }
        if (i7 > 0) {
            f(sr(bw()), i5);
            xv xvVar2 = this.f30614s;
            xvVar2.ev = i7;
            xvVar2.xv = 0;
            xvVar2.c();
            c(fpVar, this.f30614s, uVar, false);
        }
        this.f30614s.f30626k = null;
    }

    public void c(boolean z3) {
        c((String) null);
        if (z3 != this.f30615u) {
            this.f30615u = z3;
            ys();
        }
    }

    private View xv(RecyclerView.fp fpVar, RecyclerView.u uVar) {
        return this.xv ? ux(fpVar, uVar) : sr(fpVar, uVar);
    }

    protected int c(RecyclerView.u uVar) {
        if (uVar.xv()) {
            return this.f30616w.f();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void c(RecyclerView recyclerView, RecyclerView.u uVar, int i4) {
        f fVar = new f(recyclerView.getContext());
        fVar.xv(i4);
        c(fVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void c(RecyclerView.fp fpVar, RecyclerView.u uVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int c4;
        int i9;
        View w3;
        int c5;
        int i10;
        int i11 = -1;
        if ((this.f30609f != null || this.sr != -1) && uVar.sr() == 0) {
            xv(fpVar);
            return;
        }
        sr srVar = this.f30609f;
        if (srVar != null && srVar.c()) {
            this.sr = this.f30609f.f30619c;
        }
        f();
        this.f30614s.f30624c = false;
        wx();
        View y3 = y();
        c cVar = this.f30613r;
        if (cVar.ux && this.sr == -1 && this.f30609f == null) {
            if (y3 != null && (this.f30616w.c(y3) >= this.f30616w.sr() || this.f30616w.w(y3) <= this.f30616w.xv())) {
                this.f30613r.c(y3, sr(y3));
            }
        } else {
            cVar.c();
            c cVar2 = this.f30613r;
            cVar2.sr = this.xv ^ this.f30610i;
            c(fpVar, uVar, cVar2);
            this.f30613r.ux = true;
        }
        int c6 = c(uVar);
        if (this.f30614s.f30627p >= 0) {
            i4 = c6;
            c6 = 0;
        } else {
            i4 = 0;
        }
        int xv2 = c6 + this.f30616w.xv();
        int r3 = i4 + this.f30616w.r();
        if (uVar.c() && (i9 = this.sr) != -1 && this.ux != Integer.MIN_VALUE && (w3 = w(i9)) != null) {
            if (this.xv) {
                i10 = this.f30616w.sr() - this.f30616w.w(w3);
                c5 = this.ux;
            } else {
                c5 = this.f30616w.c(w3) - this.f30616w.xv();
                i10 = this.ux;
            }
            int i12 = i10 - c5;
            if (i12 > 0) {
                xv2 += i12;
            } else {
                r3 -= i12;
            }
        }
        c cVar3 = this.f30613r;
        if (!cVar3.sr ? !this.xv : this.xv) {
            i11 = 1;
        }
        c(fpVar, uVar, cVar3, i11);
        c(fpVar);
        this.f30614s.f30623a = ev();
        this.f30614s.gd = uVar.c();
        c cVar4 = this.f30613r;
        if (cVar4.sr) {
            w(cVar4);
            xv xvVar = this.f30614s;
            xvVar.ev = xv2;
            c(fpVar, xvVar, uVar, false);
            xv xvVar2 = this.f30614s;
            i6 = xvVar2.f30629w;
            int i13 = xvVar2.sr;
            int i14 = xvVar2.xv;
            if (i14 > 0) {
                r3 += i14;
            }
            c(this.f30613r);
            xv xvVar3 = this.f30614s;
            xvVar3.ev = r3;
            xvVar3.sr += xvVar3.ux;
            c(fpVar, xvVar3, uVar, false);
            xv xvVar4 = this.f30614s;
            i5 = xvVar4.f30629w;
            int i15 = xvVar4.xv;
            if (i15 > 0) {
                r(i13, i6);
                xv xvVar5 = this.f30614s;
                xvVar5.ev = i15;
                c(fpVar, xvVar5, uVar, false);
                i6 = this.f30614s.f30629w;
            }
        } else {
            c(cVar4);
            xv xvVar6 = this.f30614s;
            xvVar6.ev = r3;
            c(fpVar, xvVar6, uVar, false);
            xv xvVar7 = this.f30614s;
            i5 = xvVar7.f30629w;
            int i16 = xvVar7.sr;
            int i17 = xvVar7.xv;
            if (i17 > 0) {
                xv2 += i17;
            }
            w(this.f30613r);
            xv xvVar8 = this.f30614s;
            xvVar8.ev = xv2;
            xvVar8.sr += xvVar8.ux;
            c(fpVar, xvVar8, uVar, false);
            xv xvVar9 = this.f30614s;
            i6 = xvVar9.f30629w;
            int i18 = xvVar9.xv;
            if (i18 > 0) {
                f(i16, i5);
                xv xvVar10 = this.f30614s;
                xvVar10.ev = i18;
                c(fpVar, xvVar10, uVar, false);
                i5 = this.f30614s.f30629w;
            }
        }
        if (i() > 0) {
            if (this.xv ^ this.f30610i) {
                int c7 = c(i5, fpVar, uVar, true);
                i7 = i6 + c7;
                i8 = i5 + c7;
                c4 = w(i7, fpVar, uVar, false);
            } else {
                int w4 = w(i6, fpVar, uVar, true);
                i7 = i6 + w4;
                i8 = i5 + w4;
                c4 = c(i8, fpVar, uVar, false);
            }
            i6 = i7 + c4;
            i5 = i8 + c4;
        }
        w(fpVar, uVar, i6, i5);
        if (!uVar.c()) {
            this.f30616w.c();
        } else {
            this.f30613r.c();
        }
        this.fz = this.f30610i;
    }

    private boolean w(RecyclerView.fp fpVar, RecyclerView.u uVar, c cVar) {
        boolean z3 = false;
        if (i() == 0) {
            return false;
        }
        View y3 = y();
        if (y3 != null && cVar.c(y3, uVar)) {
            cVar.c(y3, sr(y3));
            return true;
        } else if (this.fz != this.f30610i) {
            return false;
        } else {
            View w3 = cVar.sr ? w(fpVar, uVar) : xv(fpVar, uVar);
            if (w3 == null) {
                return false;
            }
            cVar.w(w3, sr(w3));
            if (!uVar.c() && t()) {
                if ((this.f30616w.c(w3) >= this.f30616w.sr() || this.f30616w.w(w3) < this.f30616w.xv()) ? true : true) {
                    cVar.xv = cVar.sr ? this.f30616w.sr() : this.f30616w.xv();
                }
            }
            return true;
        }
    }

    private int w(int i4, RecyclerView.fp fpVar, RecyclerView.u uVar, boolean z3) {
        int xv2;
        int xv3 = i4 - this.f30616w.xv();
        if (xv3 > 0) {
            int i5 = -xv(xv3, fpVar, uVar);
            int i6 = i4 + i5;
            if (!z3 || (xv2 = i6 - this.f30616w.xv()) <= 0) {
                return i5;
            }
            this.f30616w.c(-xv2);
            return i5 - xv2;
        }
        return 0;
    }

    private void w(c cVar) {
        r(cVar.f30618w, cVar.xv);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int w(int i4, RecyclerView.fp fpVar, RecyclerView.u uVar) {
        if (this.f30608c == 0) {
            return 0;
        }
        return xv(i4, fpVar, uVar);
    }

    private void w(RecyclerView.fp fpVar, int i4) {
        int i5 = i();
        if (i4 >= 0) {
            int ux = this.f30616w.ux() - i4;
            if (this.xv) {
                for (int i6 = 0; i6 < i5; i6++) {
                    View ev = ev(i6);
                    if (this.f30616w.c(ev) < ux || this.f30616w.sr(ev) < ux) {
                        c(fpVar, 0, i6);
                        return;
                    }
                }
                return;
            }
            int i7 = i5 - 1;
            for (int i8 = i7; i8 >= 0; i8--) {
                View ev2 = ev(i8);
                if (this.f30616w.c(ev2) < ux || this.f30616w.sr(ev2) < ux) {
                    c(fpVar, i7, i8);
                    return;
                }
            }
        }
    }

    private View w(boolean z3, boolean z4) {
        int i4;
        int i5;
        if (this.xv) {
            i4 = 0;
            i5 = i();
        } else {
            i4 = i() - 1;
            i5 = -1;
        }
        return c(i4, i5, z3, z4);
    }

    private View w(RecyclerView.fp fpVar, RecyclerView.u uVar) {
        return this.xv ? sr(fpVar, uVar) : ux(fpVar, uVar);
    }

    private void c(RecyclerView.fp fpVar, RecyclerView.u uVar, c cVar) {
        if (c(uVar, cVar) || w(fpVar, uVar, cVar)) {
            return;
        }
        cVar.w();
        cVar.f30618w = this.f30610i ? uVar.sr() - 1 : 0;
    }

    private boolean c(RecyclerView.u uVar, c cVar) {
        int i4;
        if (!uVar.c() && (i4 = this.sr) != -1) {
            if (i4 >= 0 && i4 < uVar.sr()) {
                cVar.f30618w = this.sr;
                sr srVar = this.f30609f;
                if (srVar != null && srVar.c()) {
                    boolean z3 = this.f30609f.xv;
                    cVar.sr = z3;
                    if (z3) {
                        cVar.xv = this.f30616w.sr() - this.f30609f.f30620w;
                    } else {
                        cVar.xv = this.f30616w.xv() + this.f30609f.f30620w;
                    }
                    return true;
                } else if (this.ux == Integer.MIN_VALUE) {
                    View w3 = w(this.sr);
                    if (w3 != null) {
                        if (this.f30616w.ux(w3) > this.f30616w.f()) {
                            cVar.w();
                            return true;
                        } else if (this.f30616w.c(w3) - this.f30616w.xv() < 0) {
                            cVar.xv = this.f30616w.xv();
                            cVar.sr = false;
                            return true;
                        } else if (this.f30616w.sr() - this.f30616w.w(w3) < 0) {
                            cVar.xv = this.f30616w.sr();
                            cVar.sr = true;
                            return true;
                        } else {
                            cVar.xv = cVar.sr ? this.f30616w.w(w3) + this.f30616w.w() : this.f30616w.c(w3);
                        }
                    } else {
                        if (i() > 0) {
                            cVar.sr = (this.sr < sr(ev(0))) == this.xv;
                        }
                        cVar.w();
                    }
                    return true;
                } else {
                    boolean z4 = this.xv;
                    cVar.sr = z4;
                    if (z4) {
                        cVar.xv = this.f30616w.sr() - this.ux;
                    } else {
                        cVar.xv = this.f30616w.xv() + this.ux;
                    }
                    return true;
                }
            }
            this.sr = -1;
            this.ux = Integer.MIN_VALUE;
        }
        return false;
    }

    private int c(int i4, RecyclerView.fp fpVar, RecyclerView.u uVar, boolean z3) {
        int sr2;
        int sr3 = this.f30616w.sr() - i4;
        if (sr3 > 0) {
            int i5 = -xv(-sr3, fpVar, uVar);
            int i6 = i4 + i5;
            if (!z3 || (sr2 = this.f30616w.sr() - i6) <= 0) {
                return i5;
            }
            this.f30616w.c(sr2);
            return sr2 + i5;
        }
        return 0;
    }

    private void c(c cVar) {
        f(cVar.f30618w, cVar.xv);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public int c(int i4, RecyclerView.fp fpVar, RecyclerView.u uVar) {
        if (this.f30608c == 1) {
            return 0;
        }
        return xv(i4, fpVar, uVar);
    }

    private void c(int i4, int i5, boolean z3, RecyclerView.u uVar) {
        int xv2;
        this.f30614s.f30623a = ev();
        this.f30614s.ev = c(uVar);
        xv xvVar = this.f30614s;
        xvVar.f30625f = i4;
        if (i4 == 1) {
            xvVar.ev += this.f30616w.r();
            View bw = bw();
            xv xvVar2 = this.f30614s;
            xvVar2.ux = this.xv ? -1 : 1;
            int sr2 = sr(bw);
            xv xvVar3 = this.f30614s;
            xvVar2.sr = sr2 + xvVar3.ux;
            xvVar3.f30629w = this.f30616w.w(bw);
            xv2 = this.f30616w.w(bw) - this.f30616w.sr();
        } else {
            View pr = pr();
            this.f30614s.ev += this.f30616w.xv();
            xv xvVar4 = this.f30614s;
            xvVar4.ux = this.xv ? 1 : -1;
            int sr3 = sr(pr);
            xv xvVar5 = this.f30614s;
            xvVar4.sr = sr3 + xvVar5.ux;
            xvVar5.f30629w = this.f30616w.c(pr);
            xv2 = (-this.f30616w.c(pr)) + this.f30616w.xv();
        }
        xv xvVar6 = this.f30614s;
        xvVar6.xv = i5;
        if (z3) {
            xvVar6.xv = i5 - xv2;
        }
        xvVar6.f30628r = xv2;
    }

    void c(RecyclerView.u uVar, xv xvVar, RecyclerView.gd.c cVar) {
        int i4 = xvVar.sr;
        if (i4 < 0 || i4 >= uVar.sr()) {
            return;
        }
        cVar.w(i4, Math.max(0, xvVar.f30628r));
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void c(int i4, RecyclerView.gd.c cVar) {
        boolean z3;
        int i5;
        sr srVar = this.f30609f;
        if (srVar != null && srVar.c()) {
            sr srVar2 = this.f30609f;
            z3 = srVar2.xv;
            i5 = srVar2.f30619c;
        } else {
            wx();
            z3 = this.xv;
            i5 = this.sr;
            if (i5 == -1) {
                i5 = z3 ? i4 - 1 : 0;
            }
        }
        int i6 = z3 ? -1 : 1;
        for (int i7 = 0; i7 < this.gb && i5 >= 0 && i5 < i4; i7++) {
            cVar.w(i5, 0);
            i5 += i6;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void c(int i4, int i5, RecyclerView.u uVar, RecyclerView.gd.c cVar) {
        if (this.f30608c != 0) {
            i4 = i5;
        }
        if (i() == 0 || i4 == 0) {
            return;
        }
        f();
        c(i4 > 0 ? 1 : -1, Math.abs(i4), true, uVar);
        c(uVar, this.f30614s, cVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public void c(String str) {
        if (this.f30609f == null) {
            super.c(str);
        }
    }

    private void c(RecyclerView.fp fpVar, int i4, int i5) {
        if (i4 != i5) {
            if (i5 <= i4) {
                while (i4 > i5) {
                    c(i4, fpVar);
                    i4--;
                }
                return;
            }
            for (int i6 = i5 - 1; i6 >= i4; i6--) {
                c(i6, fpVar);
            }
        }
    }

    private void c(RecyclerView.fp fpVar, int i4) {
        if (i4 >= 0) {
            int i5 = i();
            if (!this.xv) {
                for (int i6 = 0; i6 < i5; i6++) {
                    View ev = ev(i6);
                    if (this.f30616w.w(ev) > i4 || this.f30616w.xv(ev) > i4) {
                        c(fpVar, 0, i6);
                        return;
                    }
                }
                return;
            }
            int i7 = i5 - 1;
            for (int i8 = i7; i8 >= 0; i8--) {
                View ev2 = ev(i8);
                if (this.f30616w.w(ev2) > i4 || this.f30616w.xv(ev2) > i4) {
                    c(fpVar, i7, i8);
                    return;
                }
            }
        }
    }

    private void c(RecyclerView.fp fpVar, xv xvVar) {
        if (!xvVar.f30624c || xvVar.f30623a) {
            return;
        }
        if (xvVar.f30625f == -1) {
            w(fpVar, xvVar.f30628r);
        } else {
            c(fpVar, xvVar.f30628r);
        }
    }

    int c(RecyclerView.fp fpVar, xv xvVar, RecyclerView.u uVar, boolean z3) {
        int i4 = xvVar.xv;
        int i5 = xvVar.f30628r;
        if (i5 != Integer.MIN_VALUE) {
            if (i4 < 0) {
                xvVar.f30628r = i5 + i4;
            }
            c(fpVar, xvVar);
        }
        int i6 = xvVar.xv + xvVar.ev;
        w wVar = this.ls;
        while (true) {
            if ((!xvVar.f30623a && i6 <= 0) || !xvVar.c(uVar)) {
                break;
            }
            wVar.c();
            c(fpVar, uVar, xvVar, wVar);
            if (!wVar.f30622w) {
                xvVar.f30629w += wVar.f30621c * xvVar.f30625f;
                if (!wVar.xv || this.f30614s.f30626k != null || !uVar.c()) {
                    int i7 = xvVar.xv;
                    int i8 = wVar.f30621c;
                    xvVar.xv = i7 - i8;
                    i6 -= i8;
                }
                int i9 = xvVar.f30628r;
                if (i9 != Integer.MIN_VALUE) {
                    int i10 = i9 + wVar.f30621c;
                    xvVar.f30628r = i10;
                    int i11 = xvVar.xv;
                    if (i11 < 0) {
                        xvVar.f30628r = i10 + i11;
                    }
                    c(fpVar, xvVar);
                }
                if (z3 && wVar.sr) {
                    break;
                }
            } else {
                break;
            }
        }
        return i4 - xvVar.xv;
    }

    void c(RecyclerView.fp fpVar, RecyclerView.u uVar, xv xvVar, w wVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        int f4;
        View c4 = xvVar.c(fpVar);
        if (c4 == null) {
            wVar.f30622w = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) c4.getLayoutParams();
        if (xvVar.f30626k == null) {
            if (this.xv == (xvVar.f30625f == -1)) {
                w(c4);
            } else {
                w(c4, 0);
            }
        } else {
            if (this.xv == (xvVar.f30625f == -1)) {
                c(c4);
            } else {
                c(c4, 0);
            }
        }
        c(c4, 0, 0);
        wVar.f30621c = this.f30616w.ux(c4);
        if (this.f30608c == 1) {
            if (ux()) {
                f4 = ls() - z();
                i7 = f4 - this.f30616w.f(c4);
            } else {
                i7 = n();
                f4 = this.f30616w.f(c4) + i7;
            }
            if (xvVar.f30625f == -1) {
                int i8 = xvVar.f30629w;
                i6 = i8;
                i5 = f4;
                i4 = i8 - wVar.f30621c;
            } else {
                int i9 = xvVar.f30629w;
                i4 = i9;
                i5 = f4;
                i6 = wVar.f30621c + i9;
            }
        } else {
            int ck = ck();
            int f5 = this.f30616w.f(c4) + ck;
            if (xvVar.f30625f == -1) {
                int i10 = xvVar.f30629w;
                i5 = i10;
                i4 = ck;
                i6 = f5;
                i7 = i10 - wVar.f30621c;
            } else {
                int i11 = xvVar.f30629w;
                i4 = ck;
                i5 = wVar.f30621c + i11;
                i6 = f5;
                i7 = i11;
            }
        }
        c(c4, i7, i4, i5, i6);
        if (pVar.w() || pVar.xv()) {
            wVar.xv = true;
        }
        wVar.sr = c4.hasFocusable();
    }

    private View c(boolean z3, boolean z4) {
        int i4;
        int i5;
        if (this.xv) {
            i4 = i() - 1;
            i5 = -1;
        } else {
            i4 = 0;
            i5 = i();
        }
        return c(i4, i5, z3, z4);
    }

    View c(RecyclerView.fp fpVar, RecyclerView.u uVar, int i4, int i5, int i6) {
        f();
        int xv2 = this.f30616w.xv();
        int sr2 = this.f30616w.sr();
        int i7 = i5 > i4 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i4 != i5) {
            View ev = ev(i4);
            int sr3 = sr(ev);
            if (sr3 >= 0 && sr3 < i6) {
                if (((RecyclerView.p) ev.getLayoutParams()).w()) {
                    if (view2 == null) {
                        view2 = ev;
                    }
                } else if (this.f30616w.c(ev) < sr2 && this.f30616w.w(ev) >= xv2) {
                    return ev;
                } else {
                    if (view == null) {
                        view = ev;
                    }
                }
            }
            i4 += i7;
        }
        return view != null ? view : view2;
    }

    View c(int i4, int i5, boolean z3, boolean z4) {
        f();
        return (this.f30608c == 0 ? this.f30524p : this.f30523k).c(i4, i5, z3 ? 24579 : 320, z4 ? 320 : 0);
    }

    View c(int i4, int i5) {
        int i6;
        int i7;
        f();
        if ((i5 > i4 ? (char) 1 : i5 < i4 ? '\uffff' : (char) 0) == 0) {
            return ev(i4);
        }
        if (this.f30616w.c(ev(i4)) < this.f30616w.xv()) {
            i6 = 16644;
            i7 = 16388;
        } else {
            i6 = 4161;
            i7 = 4097;
        }
        return (this.f30608c == 0 ? this.f30524p : this.f30523k).c(i4, i5, i6, i7);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gd
    public View c(View view, int i4, RecyclerView.fp fpVar, RecyclerView.u uVar) {
        int ux;
        View f4;
        View bw;
        wx();
        if (i() == 0 || (ux = ux(i4)) == Integer.MIN_VALUE) {
            return null;
        }
        f();
        f();
        c(ux, (int) (this.f30616w.f() * 0.33333334f), false, uVar);
        xv xvVar = this.f30614s;
        xvVar.f30628r = Integer.MIN_VALUE;
        xvVar.f30624c = false;
        c(fpVar, xvVar, uVar, true);
        if (ux == -1) {
            f4 = r(fpVar, uVar);
        } else {
            f4 = f(fpVar, uVar);
        }
        if (ux == -1) {
            bw = pr();
        } else {
            bw = bw();
        }
        if (bw.hasFocusable()) {
            if (f4 == null) {
                return null;
            }
            return bw;
        }
        return f4;
    }
}
