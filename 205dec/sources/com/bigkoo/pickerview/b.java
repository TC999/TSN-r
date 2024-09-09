package com.bigkoo.pickerview;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.lib.WheelView;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: OptionsPickerView.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b<T> extends com.bigkoo.pickerview.view.a implements View.OnClickListener {
    private static final String F0 = "submit";
    private static final String G0 = "cancel";
    private Button A;
    private Typeface A0;
    private TextView B;
    private int B0;
    private InterfaceC0157b C;
    private int C0;
    private String D;
    private int D0;
    private String E;
    private WheelView.DividerType E0;
    private String F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;

    /* renamed from: L  reason: collision with root package name */
    private int f16241L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private float R;
    private boolean S;
    private boolean T;
    private boolean U;
    private String V;
    private String W;
    private String X;
    private boolean Y;
    private boolean Z;

    /* renamed from: p0  reason: collision with root package name */
    private boolean f16242p0;

    /* renamed from: w  reason: collision with root package name */
    com.bigkoo.pickerview.view.b<T> f16243w;

    /* renamed from: x  reason: collision with root package name */
    private int f16244x;

    /* renamed from: y  reason: collision with root package name */
    private i.a f16245y;

    /* renamed from: z  reason: collision with root package name */
    private Button f16246z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OptionsPickerView.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a {
        private Typeface C;
        private int D;
        private int E;
        private int F;
        private WheelView.DividerType G;

        /* renamed from: b  reason: collision with root package name */
        private i.a f16248b;

        /* renamed from: c  reason: collision with root package name */
        private Context f16249c;

        /* renamed from: d  reason: collision with root package name */
        private InterfaceC0157b f16250d;

        /* renamed from: e  reason: collision with root package name */
        private String f16251e;

        /* renamed from: f  reason: collision with root package name */
        private String f16252f;

        /* renamed from: g  reason: collision with root package name */
        private String f16253g;

        /* renamed from: h  reason: collision with root package name */
        private int f16254h;

        /* renamed from: i  reason: collision with root package name */
        private int f16255i;

        /* renamed from: j  reason: collision with root package name */
        private int f16256j;

        /* renamed from: k  reason: collision with root package name */
        private int f16257k;

        /* renamed from: l  reason: collision with root package name */
        private int f16258l;

        /* renamed from: r  reason: collision with root package name */
        private int f16264r;

        /* renamed from: s  reason: collision with root package name */
        private int f16265s;

        /* renamed from: t  reason: collision with root package name */
        private int f16266t;

        /* renamed from: v  reason: collision with root package name */
        private boolean f16268v;

        /* renamed from: w  reason: collision with root package name */
        private String f16269w;

        /* renamed from: x  reason: collision with root package name */
        private String f16270x;

        /* renamed from: y  reason: collision with root package name */
        private String f16271y;

        /* renamed from: a  reason: collision with root package name */
        private int f16247a = R.layout.pickerview_options;

        /* renamed from: m  reason: collision with root package name */
        private int f16259m = 17;

        /* renamed from: n  reason: collision with root package name */
        private int f16260n = 18;

        /* renamed from: o  reason: collision with root package name */
        private int f16261o = 18;

        /* renamed from: p  reason: collision with root package name */
        private boolean f16262p = true;

        /* renamed from: q  reason: collision with root package name */
        private boolean f16263q = true;

        /* renamed from: u  reason: collision with root package name */
        private float f16267u = 1.6f;

        /* renamed from: z  reason: collision with root package name */
        private boolean f16272z = false;
        private boolean A = false;
        private boolean B = false;

        public a(Context context, InterfaceC0157b interfaceC0157b) {
            this.f16249c = context;
            this.f16250d = interfaceC0157b;
        }

        public b H() {
            return new b(this);
        }

        public a I(boolean z3) {
            this.f16268v = z3;
            return this;
        }

        public a J(int i4) {
            this.f16257k = i4;
            return this;
        }

        public a K(int i4) {
            this.f16255i = i4;
            return this;
        }

        public a L(String str) {
            this.f16252f = str;
            return this;
        }

        public a M(int i4) {
            this.f16261o = i4;
            return this;
        }

        public a N(boolean z3, boolean z4, boolean z5) {
            this.f16272z = z3;
            this.A = z4;
            this.B = z5;
            return this;
        }

        public a O(int i4) {
            this.f16266t = i4;
            return this;
        }

        public a P(WheelView.DividerType dividerType) {
            this.G = dividerType;
            return this;
        }

        public a Q(String str, String str2, String str3) {
            this.f16269w = str;
            this.f16270x = str2;
            this.f16271y = str3;
            return this;
        }

        public a R(int i4, i.a aVar) {
            this.f16247a = i4;
            this.f16248b = aVar;
            return this;
        }

        public a S(float f4) {
            this.f16267u = f4;
            return this;
        }

        @Deprecated
        public a T(boolean z3) {
            this.f16263q = z3;
            return this;
        }

        public a U(boolean z3) {
            this.f16262p = z3;
            return this;
        }

        public a V(int i4) {
            this.D = i4;
            return this;
        }

        public a W(int i4, int i5) {
            this.D = i4;
            this.E = i5;
            return this;
        }

        public a X(int i4, int i5, int i6) {
            this.D = i4;
            this.E = i5;
            this.F = i6;
            return this;
        }

        public a Y(int i4) {
            this.f16259m = i4;
            return this;
        }

        public a Z(int i4) {
            this.f16254h = i4;
            return this;
        }

        public a a0(String str) {
            this.f16251e = str;
            return this;
        }

        public a b0(int i4) {
            this.f16265s = i4;
            return this;
        }

        public a c0(int i4) {
            this.f16264r = i4;
            return this;
        }

        public a d0(int i4) {
            this.f16258l = i4;
            return this;
        }

        public a e0(int i4) {
            this.f16256j = i4;
            return this;
        }

        public a f0(int i4) {
            this.f16260n = i4;
            return this;
        }

        public a g0(String str) {
            this.f16253g = str;
            return this;
        }

        public a h0(Typeface typeface) {
            this.C = typeface;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: OptionsPickerView.java */
    /* renamed from: com.bigkoo.pickerview.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface InterfaceC0157b {
        void a(int i4, int i5, int i6, View view);
    }

    public b(a aVar) {
        super(aVar.f16249c);
        this.R = 1.6f;
        this.C = aVar.f16250d;
        this.D = aVar.f16251e;
        this.E = aVar.f16252f;
        this.F = aVar.f16253g;
        this.G = aVar.f16254h;
        this.H = aVar.f16255i;
        this.I = aVar.f16256j;
        this.J = aVar.f16257k;
        this.K = aVar.f16258l;
        this.f16241L = aVar.f16259m;
        this.M = aVar.f16260n;
        this.N = aVar.f16261o;
        this.Y = aVar.f16272z;
        this.Z = aVar.A;
        this.f16242p0 = aVar.B;
        this.T = aVar.f16262p;
        this.U = aVar.f16263q;
        this.V = aVar.f16269w;
        this.W = aVar.f16270x;
        this.X = aVar.f16271y;
        this.A0 = aVar.C;
        this.B0 = aVar.D;
        this.C0 = aVar.E;
        this.D0 = aVar.F;
        this.P = aVar.f16265s;
        this.O = aVar.f16264r;
        this.Q = aVar.f16266t;
        this.R = aVar.f16267u;
        this.f16245y = aVar.f16248b;
        this.f16244x = aVar.f16247a;
        this.S = aVar.f16268v;
        this.E0 = aVar.G;
        x(aVar.f16249c);
    }

    private void w() {
        com.bigkoo.pickerview.view.b<T> bVar = this.f16243w;
        if (bVar != null) {
            bVar.j(this.B0, this.C0, this.D0);
        }
    }

    private void x(Context context) {
        p(this.T);
        l();
        j();
        k();
        i.a aVar = this.f16245y;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(this.f16244x, this.f16315c);
            this.B = (TextView) g(R.id.tvTitle);
            this.f16246z = (Button) g(R.id.btnSubmit);
            this.A = (Button) g(R.id.btnCancel);
            this.f16246z.setTag("submit");
            this.A.setTag("cancel");
            this.f16246z.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.f16246z.setText(TextUtils.isEmpty(this.D) ? context.getResources().getString(R.string.pickerview_submit) : this.D);
            this.A.setText(TextUtils.isEmpty(this.E) ? context.getResources().getString(R.string.pickerview_cancel) : this.E);
            this.B.setText(TextUtils.isEmpty(this.F) ? "" : this.F);
            Button button = this.f16246z;
            int i4 = this.G;
            if (i4 == 0) {
                i4 = this.f16319g;
            }
            button.setTextColor(i4);
            Button button2 = this.A;
            int i5 = this.H;
            if (i5 == 0) {
                i5 = this.f16319g;
            }
            button2.setTextColor(i5);
            TextView textView = this.B;
            int i6 = this.I;
            if (i6 == 0) {
                i6 = this.f16322j;
            }
            textView.setTextColor(i6);
            RelativeLayout relativeLayout = (RelativeLayout) g(R.id.rv_topbar);
            int i7 = this.K;
            if (i7 == 0) {
                i7 = this.f16321i;
            }
            relativeLayout.setBackgroundColor(i7);
            this.f16246z.setTextSize(this.f16241L);
            this.A.setTextSize(this.f16241L);
            this.B.setTextSize(this.M);
            this.B.setText(this.F);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f16244x, this.f16315c));
        }
        LinearLayout linearLayout = (LinearLayout) g(R.id.optionspicker);
        int i8 = this.J;
        if (i8 == 0) {
            i8 = this.f16323k;
        }
        linearLayout.setBackgroundColor(i8);
        com.bigkoo.pickerview.view.b<T> bVar = new com.bigkoo.pickerview.view.b<>(linearLayout, Boolean.valueOf(this.U));
        this.f16243w = bVar;
        bVar.z(this.N);
        this.f16243w.q(this.V, this.W, this.X);
        this.f16243w.l(this.Y, this.Z, this.f16242p0);
        this.f16243w.A(this.A0);
        s(this.T);
        TextView textView2 = this.B;
        if (textView2 != null) {
            textView2.setText(this.F);
        }
        this.f16243w.n(this.Q);
        this.f16243w.p(this.E0);
        this.f16243w.s(this.R);
        this.f16243w.y(this.O);
        this.f16243w.w(this.P);
    }

    public void A(List<T> list) {
        this.f16243w.u(list, null, null);
        w();
    }

    public void B(List<T> list, List<List<T>> list2) {
        this.f16243w.u(list, list2, null);
        w();
    }

    public void C(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f16243w.u(list, list2, list3);
        w();
    }

    public void D(int i4) {
        this.B0 = i4;
        w();
    }

    public void E(int i4, int i5) {
        this.B0 = i4;
        this.C0 = i5;
        w();
    }

    public void F(int i4, int i5, int i6) {
        this.B0 = i4;
        this.C0 = i5;
        this.D0 = i6;
        w();
    }

    @Override // com.bigkoo.pickerview.view.a
    public boolean m() {
        return this.S;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("cancel")) {
            d();
        } else {
            y();
        }
    }

    public void y() {
        if (this.C != null) {
            int[] g4 = this.f16243w.g();
            this.C.a(g4[0], g4[1], g4[2], this.f16332t);
        }
        d();
    }

    public void z(List<T> list, List<T> list2, List<T> list3) {
        this.f16243w.t(list, list2, list3);
        w();
    }
}
