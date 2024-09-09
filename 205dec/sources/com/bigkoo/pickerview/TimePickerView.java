package com.bigkoo.pickerview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.lib.WheelView;
import com.bigkoo.pickerview.view.c;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class TimePickerView extends com.bigkoo.pickerview.view.a implements View.OnClickListener {
    private static final String I0 = "submit";
    private static final String J0 = "cancel";
    private Button A;
    private boolean A0;
    private TextView B;
    private String B0;
    private b C;
    private String C0;
    private int D;
    private String D0;
    private Type E;
    private String E0;
    private String F;
    private String F0;
    private String G;
    private String G0;
    private String H;
    private WheelView.DividerType H0;
    private int I;
    private int J;
    private int K;

    /* renamed from: L  reason: collision with root package name */
    private int f16203L;
    private int M;
    private int N;
    private int O;
    private int P;
    private Calendar Q;
    private Calendar R;
    private Calendar S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: p0  reason: collision with root package name */
    private float f16204p0;

    /* renamed from: w  reason: collision with root package name */
    private int f16205w;

    /* renamed from: x  reason: collision with root package name */
    private i.a f16206x;

    /* renamed from: y  reason: collision with root package name */
    c f16207y;

    /* renamed from: z  reason: collision with root package name */
    private Button f16208z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public enum Type {
        ALL,
        YEAR_MONTH_DAY,
        HOURS_MINS,
        MONTH_DAY_HOUR_MIN,
        YEAR_MONTH,
        YEAR_MONTH_DAY_HOUR_MIN
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a {
        private int A;
        private WheelView.DividerType B;
        private boolean D;
        private String E;
        private String F;
        private String G;
        private String H;
        private String I;
        private String J;

        /* renamed from: b  reason: collision with root package name */
        private i.a f16210b;

        /* renamed from: c  reason: collision with root package name */
        private Context f16211c;

        /* renamed from: d  reason: collision with root package name */
        private b f16212d;

        /* renamed from: g  reason: collision with root package name */
        private String f16215g;

        /* renamed from: h  reason: collision with root package name */
        private String f16216h;

        /* renamed from: i  reason: collision with root package name */
        private String f16217i;

        /* renamed from: j  reason: collision with root package name */
        private int f16218j;

        /* renamed from: k  reason: collision with root package name */
        private int f16219k;

        /* renamed from: l  reason: collision with root package name */
        private int f16220l;

        /* renamed from: m  reason: collision with root package name */
        private int f16221m;

        /* renamed from: n  reason: collision with root package name */
        private int f16222n;

        /* renamed from: r  reason: collision with root package name */
        private Calendar f16226r;

        /* renamed from: s  reason: collision with root package name */
        private Calendar f16227s;

        /* renamed from: t  reason: collision with root package name */
        private Calendar f16228t;

        /* renamed from: u  reason: collision with root package name */
        private int f16229u;

        /* renamed from: v  reason: collision with root package name */
        private int f16230v;

        /* renamed from: y  reason: collision with root package name */
        private int f16233y;

        /* renamed from: z  reason: collision with root package name */
        private int f16234z;

        /* renamed from: a  reason: collision with root package name */
        private int f16209a = R.layout.pickerview_time;

        /* renamed from: e  reason: collision with root package name */
        private Type f16213e = Type.ALL;

        /* renamed from: f  reason: collision with root package name */
        private int f16214f = 17;

        /* renamed from: o  reason: collision with root package name */
        private int f16223o = 17;

        /* renamed from: p  reason: collision with root package name */
        private int f16224p = 18;

        /* renamed from: q  reason: collision with root package name */
        private int f16225q = 18;

        /* renamed from: w  reason: collision with root package name */
        private boolean f16231w = false;

        /* renamed from: x  reason: collision with root package name */
        private boolean f16232x = true;
        private float C = 1.6f;

        public a(Context context, b bVar) {
            this.f16211c = context;
            this.f16212d = bVar;
        }

        public TimePickerView K() {
            return new TimePickerView(this);
        }

        public a L(int i4) {
            this.f16214f = i4;
            return this;
        }

        public a M(boolean z3) {
            this.f16231w = z3;
            return this;
        }

        public a N(boolean z3) {
            this.D = z3;
            return this;
        }

        public a O(int i4) {
            this.f16221m = i4;
            return this;
        }

        public a P(int i4) {
            this.f16219k = i4;
            return this;
        }

        public a Q(String str) {
            this.f16216h = str;
            return this;
        }

        public a R(int i4) {
            this.f16225q = i4;
            return this;
        }

        public a S(Calendar calendar) {
            this.f16226r = calendar;
            return this;
        }

        public a T(int i4) {
            this.A = i4;
            return this;
        }

        public a U(WheelView.DividerType dividerType) {
            this.B = dividerType;
            return this;
        }

        public a V(String str, String str2, String str3, String str4, String str5, String str6) {
            this.E = str;
            this.F = str2;
            this.G = str3;
            this.H = str4;
            this.I = str5;
            this.J = str6;
            return this;
        }

        public a W(int i4, i.a aVar) {
            this.f16209a = i4;
            this.f16210b = aVar;
            return this;
        }

        public a X(float f4) {
            this.C = f4;
            return this;
        }

        public a Y(boolean z3) {
            this.f16232x = z3;
            return this;
        }

        public a Z(Calendar calendar, Calendar calendar2) {
            this.f16227s = calendar;
            this.f16228t = calendar2;
            return this;
        }

        public a a0(int i4, int i5) {
            this.f16229u = i4;
            this.f16230v = i5;
            return this;
        }

        public a b0(int i4) {
            this.f16223o = i4;
            return this;
        }

        public a c0(int i4) {
            this.f16218j = i4;
            return this;
        }

        public a d0(String str) {
            this.f16215g = str;
            return this;
        }

        public a e0(int i4) {
            this.f16234z = i4;
            return this;
        }

        public a f0(int i4) {
            this.f16233y = i4;
            return this;
        }

        public a g0(int i4) {
            this.f16222n = i4;
            return this;
        }

        public a h0(int i4) {
            this.f16220l = i4;
            return this;
        }

        public a i0(int i4) {
            this.f16224p = i4;
            return this;
        }

        public a j0(String str) {
            this.f16217i = str;
            return this;
        }

        public a k0(Type type) {
            this.f16213e = type;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {
        void a(Date date, View view);
    }

    public TimePickerView(a aVar) {
        super(aVar.f16211c);
        this.D = 17;
        this.f16204p0 = 1.6f;
        this.C = aVar.f16212d;
        this.D = aVar.f16214f;
        this.E = aVar.f16213e;
        this.F = aVar.f16215g;
        this.G = aVar.f16216h;
        this.H = aVar.f16217i;
        this.I = aVar.f16218j;
        this.J = aVar.f16219k;
        this.K = aVar.f16220l;
        this.f16203L = aVar.f16221m;
        this.M = aVar.f16222n;
        this.N = aVar.f16223o;
        this.O = aVar.f16224p;
        this.P = aVar.f16225q;
        this.T = aVar.f16229u;
        this.U = aVar.f16230v;
        this.R = aVar.f16227s;
        this.S = aVar.f16228t;
        this.Q = aVar.f16226r;
        this.V = aVar.f16231w;
        this.W = aVar.f16232x;
        this.B0 = aVar.E;
        this.C0 = aVar.F;
        this.D0 = aVar.G;
        this.E0 = aVar.H;
        this.F0 = aVar.I;
        this.G0 = aVar.J;
        this.Y = aVar.f16234z;
        this.X = aVar.f16233y;
        this.Z = aVar.A;
        this.f16206x = aVar.f16210b;
        this.f16205w = aVar.f16209a;
        this.f16204p0 = aVar.C;
        this.A0 = aVar.D;
        this.H0 = aVar.B;
        w(aVar.f16211c);
    }

    private void A() {
        this.f16207y.C(this.T);
        this.f16207y.u(this.U);
    }

    private void B() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.Q;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i4 = calendar.get(1);
            i5 = calendar.get(2);
            i6 = calendar.get(5);
            i7 = calendar.get(11);
            i8 = calendar.get(12);
            i9 = calendar.get(13);
        } else {
            i4 = calendar2.get(1);
            i5 = this.Q.get(2);
            i6 = this.Q.get(5);
            i7 = this.Q.get(11);
            i8 = this.Q.get(12);
            i9 = this.Q.get(13);
        }
        int i10 = i7;
        int i11 = i6;
        int i12 = i5;
        c cVar = this.f16207y;
        cVar.z(i4, i12, i11, i10, i8, i9);
    }

    private void w(Context context) {
        int i4;
        p(this.W);
        l();
        j();
        k();
        i.a aVar = this.f16206x;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f16315c);
            this.B = (TextView) g(R.id.tvTitle);
            this.f16208z = (Button) g(R.id.btnSubmit);
            this.A = (Button) g(R.id.btnCancel);
            this.f16208z.setTag("submit");
            this.A.setTag("cancel");
            this.f16208z.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.f16208z.setText(TextUtils.isEmpty(this.F) ? context.getResources().getString(R.string.pickerview_submit) : this.F);
            this.A.setText(TextUtils.isEmpty(this.G) ? context.getResources().getString(R.string.pickerview_cancel) : this.G);
            this.B.setText(TextUtils.isEmpty(this.H) ? "" : this.H);
            Button button = this.f16208z;
            int i5 = this.I;
            if (i5 == 0) {
                i5 = this.f16319g;
            }
            button.setTextColor(i5);
            Button button2 = this.A;
            int i6 = this.J;
            if (i6 == 0) {
                i6 = this.f16319g;
            }
            button2.setTextColor(i6);
            TextView textView = this.B;
            int i7 = this.K;
            if (i7 == 0) {
                i7 = this.f16322j;
            }
            textView.setTextColor(i7);
            this.f16208z.setTextSize(this.N);
            this.A.setTextSize(this.N);
            this.B.setTextSize(this.O);
            RelativeLayout relativeLayout = (RelativeLayout) g(R.id.rv_topbar);
            int i8 = this.M;
            if (i8 == 0) {
                i8 = this.f16321i;
            }
            relativeLayout.setBackgroundColor(i8);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f16205w, this.f16315c));
        }
        LinearLayout linearLayout = (LinearLayout) g(R.id.timepicker);
        int i9 = this.f16203L;
        if (i9 == 0) {
            i9 = this.f16323k;
        }
        linearLayout.setBackgroundColor(i9);
        this.f16207y = new c(linearLayout, this.E, this.D, this.P);
        int i10 = this.T;
        if (i10 != 0 && (i4 = this.U) != 0 && i10 <= i4) {
            A();
        }
        Calendar calendar = this.R;
        if (calendar != null && this.S != null) {
            if (calendar.getTimeInMillis() <= this.S.getTimeInMillis()) {
                z();
            }
        } else if (calendar != null && this.S == null) {
            z();
        } else if (calendar == null && this.S != null) {
            z();
        }
        B();
        this.f16207y.v(this.B0, this.C0, this.D0, this.E0, this.F0, this.G0);
        s(this.W);
        this.f16207y.p(this.V);
        this.f16207y.r(this.Z);
        this.f16207y.t(this.H0);
        this.f16207y.x(this.f16204p0);
        this.f16207y.G(this.X);
        this.f16207y.E(this.Y);
    }

    private void z() {
        this.f16207y.A(this.R, this.S);
        Calendar calendar = this.R;
        if (calendar != null && this.S != null) {
            Calendar calendar2 = this.Q;
            if (calendar2 == null || calendar2.getTimeInMillis() < this.R.getTimeInMillis() || this.Q.getTimeInMillis() > this.S.getTimeInMillis()) {
                this.Q = this.R;
            }
        } else if (calendar != null) {
            this.Q = calendar;
        } else {
            Calendar calendar3 = this.S;
            if (calendar3 != null) {
                this.Q = calendar3;
            }
        }
    }

    @Override // com.bigkoo.pickerview.view.a
    public boolean m() {
        return this.A0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("cancel")) {
            d();
        } else {
            x();
        }
    }

    public void x() {
        if (this.C != null) {
            try {
                this.C.a(c.f16360w.parse(this.f16207y.m()), this.f16332t);
            } catch (ParseException e4) {
                e4.printStackTrace();
            }
        }
        d();
    }

    public void y(Calendar calendar) {
        this.Q = calendar;
        B();
    }
}
