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
import com.bigkoo.pickerview.view.BasePickerView;
import com.bigkoo.pickerview.view.WheelTime;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import p600i.CustomListener;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TimePickerView extends BasePickerView implements View.OnClickListener {

    /* renamed from: I0 */
    private static final String f12902I0 = "submit";

    /* renamed from: J0 */
    private static final String f12903J0 = "cancel";

    /* renamed from: A */
    private Button f12904A;

    /* renamed from: A0 */
    private boolean f12905A0;

    /* renamed from: B */
    private TextView f12906B;

    /* renamed from: B0 */
    private String f12907B0;

    /* renamed from: C */
    private InterfaceC3509b f12908C;

    /* renamed from: C0 */
    private String f12909C0;

    /* renamed from: D */
    private int f12910D;

    /* renamed from: D0 */
    private String f12911D0;

    /* renamed from: E */
    private Type f12912E;

    /* renamed from: E0 */
    private String f12913E0;

    /* renamed from: F */
    private String f12914F;

    /* renamed from: F0 */
    private String f12915F0;

    /* renamed from: G */
    private String f12916G;

    /* renamed from: G0 */
    private String f12917G0;

    /* renamed from: H */
    private String f12918H;

    /* renamed from: H0 */
    private WheelView.DividerType f12919H0;

    /* renamed from: I */
    private int f12920I;

    /* renamed from: J */
    private int f12921J;

    /* renamed from: K */
    private int f12922K;

    /* renamed from: L */
    private int f12923L;

    /* renamed from: M */
    private int f12924M;

    /* renamed from: N */
    private int f12925N;

    /* renamed from: O */
    private int f12926O;

    /* renamed from: P */
    private int f12927P;

    /* renamed from: Q */
    private Calendar f12928Q;

    /* renamed from: R */
    private Calendar f12929R;

    /* renamed from: S */
    private Calendar f12930S;

    /* renamed from: T */
    private int f12931T;

    /* renamed from: U */
    private int f12932U;

    /* renamed from: V */
    private boolean f12933V;

    /* renamed from: W */
    private boolean f12934W;

    /* renamed from: X */
    private int f12935X;

    /* renamed from: Y */
    private int f12936Y;

    /* renamed from: Z */
    private int f12937Z;

    /* renamed from: p0 */
    private float f12938p0;

    /* renamed from: w */
    private int f12939w;

    /* renamed from: x */
    private CustomListener f12940x;

    /* renamed from: y */
    WheelTime f12941y;

    /* renamed from: z */
    private Button f12942z;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum Type {
        ALL,
        YEAR_MONTH_DAY,
        HOURS_MINS,
        MONTH_DAY_HOUR_MIN,
        YEAR_MONTH,
        YEAR_MONTH_DAY_HOUR_MIN
    }

    /* renamed from: com.bigkoo.pickerview.TimePickerView$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3508a {

        /* renamed from: A */
        private int f12943A;

        /* renamed from: B */
        private WheelView.DividerType f12944B;

        /* renamed from: D */
        private boolean f12946D;

        /* renamed from: E */
        private String f12947E;

        /* renamed from: F */
        private String f12948F;

        /* renamed from: G */
        private String f12949G;

        /* renamed from: H */
        private String f12950H;

        /* renamed from: I */
        private String f12951I;

        /* renamed from: J */
        private String f12952J;

        /* renamed from: b */
        private CustomListener f12954b;

        /* renamed from: c */
        private Context f12955c;

        /* renamed from: d */
        private InterfaceC3509b f12956d;

        /* renamed from: g */
        private String f12959g;

        /* renamed from: h */
        private String f12960h;

        /* renamed from: i */
        private String f12961i;

        /* renamed from: j */
        private int f12962j;

        /* renamed from: k */
        private int f12963k;

        /* renamed from: l */
        private int f12964l;

        /* renamed from: m */
        private int f12965m;

        /* renamed from: n */
        private int f12966n;

        /* renamed from: r */
        private Calendar f12970r;

        /* renamed from: s */
        private Calendar f12971s;

        /* renamed from: t */
        private Calendar f12972t;

        /* renamed from: u */
        private int f12973u;

        /* renamed from: v */
        private int f12974v;

        /* renamed from: y */
        private int f12977y;

        /* renamed from: z */
        private int f12978z;

        /* renamed from: a */
        private int f12953a = C3501R.C3505layout.pickerview_time;

        /* renamed from: e */
        private Type f12957e = Type.ALL;

        /* renamed from: f */
        private int f12958f = 17;

        /* renamed from: o */
        private int f12967o = 17;

        /* renamed from: p */
        private int f12968p = 18;

        /* renamed from: q */
        private int f12969q = 18;

        /* renamed from: w */
        private boolean f12975w = false;

        /* renamed from: x */
        private boolean f12976x = true;

        /* renamed from: C */
        private float f12945C = 1.6f;

        public C3508a(Context context, InterfaceC3509b interfaceC3509b) {
            this.f12955c = context;
            this.f12956d = interfaceC3509b;
        }

        /* renamed from: K */
        public TimePickerView m46016K() {
            return new TimePickerView(this);
        }

        /* renamed from: L */
        public C3508a m46015L(int i) {
            this.f12958f = i;
            return this;
        }

        /* renamed from: M */
        public C3508a m46014M(boolean z) {
            this.f12975w = z;
            return this;
        }

        /* renamed from: N */
        public C3508a m46013N(boolean z) {
            this.f12946D = z;
            return this;
        }

        /* renamed from: O */
        public C3508a m46012O(int i) {
            this.f12965m = i;
            return this;
        }

        /* renamed from: P */
        public C3508a m46011P(int i) {
            this.f12963k = i;
            return this;
        }

        /* renamed from: Q */
        public C3508a m46010Q(String str) {
            this.f12960h = str;
            return this;
        }

        /* renamed from: R */
        public C3508a m46009R(int i) {
            this.f12969q = i;
            return this;
        }

        /* renamed from: S */
        public C3508a m46008S(Calendar calendar) {
            this.f12970r = calendar;
            return this;
        }

        /* renamed from: T */
        public C3508a m46007T(int i) {
            this.f12943A = i;
            return this;
        }

        /* renamed from: U */
        public C3508a m46006U(WheelView.DividerType dividerType) {
            this.f12944B = dividerType;
            return this;
        }

        /* renamed from: V */
        public C3508a m46005V(String str, String str2, String str3, String str4, String str5, String str6) {
            this.f12947E = str;
            this.f12948F = str2;
            this.f12949G = str3;
            this.f12950H = str4;
            this.f12951I = str5;
            this.f12952J = str6;
            return this;
        }

        /* renamed from: W */
        public C3508a m46004W(int i, CustomListener customListener) {
            this.f12953a = i;
            this.f12954b = customListener;
            return this;
        }

        /* renamed from: X */
        public C3508a m46003X(float f) {
            this.f12945C = f;
            return this;
        }

        /* renamed from: Y */
        public C3508a m46002Y(boolean z) {
            this.f12976x = z;
            return this;
        }

        /* renamed from: Z */
        public C3508a m46001Z(Calendar calendar, Calendar calendar2) {
            this.f12971s = calendar;
            this.f12972t = calendar2;
            return this;
        }

        /* renamed from: a0 */
        public C3508a m45999a0(int i, int i2) {
            this.f12973u = i;
            this.f12974v = i2;
            return this;
        }

        /* renamed from: b0 */
        public C3508a m45997b0(int i) {
            this.f12967o = i;
            return this;
        }

        /* renamed from: c0 */
        public C3508a m45995c0(int i) {
            this.f12962j = i;
            return this;
        }

        /* renamed from: d0 */
        public C3508a m45993d0(String str) {
            this.f12959g = str;
            return this;
        }

        /* renamed from: e0 */
        public C3508a m45991e0(int i) {
            this.f12978z = i;
            return this;
        }

        /* renamed from: f0 */
        public C3508a m45989f0(int i) {
            this.f12977y = i;
            return this;
        }

        /* renamed from: g0 */
        public C3508a m45987g0(int i) {
            this.f12966n = i;
            return this;
        }

        /* renamed from: h0 */
        public C3508a m45985h0(int i) {
            this.f12964l = i;
            return this;
        }

        /* renamed from: i0 */
        public C3508a m45983i0(int i) {
            this.f12968p = i;
            return this;
        }

        /* renamed from: j0 */
        public C3508a m45981j0(String str) {
            this.f12961i = str;
            return this;
        }

        /* renamed from: k0 */
        public C3508a m45979k0(Type type) {
            this.f12957e = type;
            return this;
        }
    }

    /* renamed from: com.bigkoo.pickerview.TimePickerView$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3509b {
        /* renamed from: a */
        void m45963a(Date date, View view);
    }

    public TimePickerView(C3508a c3508a) {
        super(c3508a.f12955c);
        this.f12910D = 17;
        this.f12938p0 = 1.6f;
        this.f12908C = c3508a.f12956d;
        this.f12910D = c3508a.f12958f;
        this.f12912E = c3508a.f12957e;
        this.f12914F = c3508a.f12959g;
        this.f12916G = c3508a.f12960h;
        this.f12918H = c3508a.f12961i;
        this.f12920I = c3508a.f12962j;
        this.f12921J = c3508a.f12963k;
        this.f12922K = c3508a.f12964l;
        this.f12923L = c3508a.f12965m;
        this.f12924M = c3508a.f12966n;
        this.f12925N = c3508a.f12967o;
        this.f12926O = c3508a.f12968p;
        this.f12927P = c3508a.f12969q;
        this.f12931T = c3508a.f12973u;
        this.f12932U = c3508a.f12974v;
        this.f12929R = c3508a.f12971s;
        this.f12930S = c3508a.f12972t;
        this.f12928Q = c3508a.f12970r;
        this.f12933V = c3508a.f12975w;
        this.f12934W = c3508a.f12976x;
        this.f12907B0 = c3508a.f12947E;
        this.f12909C0 = c3508a.f12948F;
        this.f12911D0 = c3508a.f12949G;
        this.f12913E0 = c3508a.f12950H;
        this.f12915F0 = c3508a.f12951I;
        this.f12917G0 = c3508a.f12952J;
        this.f12936Y = c3508a.f12978z;
        this.f12935X = c3508a.f12977y;
        this.f12937Z = c3508a.f12943A;
        this.f12940x = c3508a.f12954b;
        this.f12939w = c3508a.f12953a;
        this.f12938p0 = c3508a.f12945C;
        this.f12905A0 = c3508a.f12946D;
        this.f12919H0 = c3508a.f12944B;
        m46030w(c3508a.f12955c);
    }

    /* renamed from: A */
    private void m46032A() {
        this.f12941y.m45825C(this.f12931T);
        this.f12941y.m45799u(this.f12932U);
    }

    /* renamed from: B */
    private void m46031B() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f12928Q;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = calendar2.get(1);
            i2 = this.f12928Q.get(2);
            i3 = this.f12928Q.get(5);
            i4 = this.f12928Q.get(11);
            i5 = this.f12928Q.get(12);
            i6 = this.f12928Q.get(13);
        }
        int i7 = i4;
        int i8 = i3;
        int i9 = i2;
        WheelTime wheelTime = this.f12941y;
        wheelTime.m45794z(i, i9, i8, i7, i5, i6);
    }

    /* renamed from: w */
    private void m46030w(Context context) {
        int i;
        m45862p(this.f12934W);
        m45866l();
        m45868j();
        m45867k();
        CustomListener customListener = this.f12940x;
        if (customListener == null) {
            LayoutInflater.from(context).inflate(C3501R.C3505layout.pickerview_time, this.f13117c);
            this.f12906B = (TextView) m45871g(C3501R.C3504id.tvTitle);
            this.f12942z = (Button) m45871g(C3501R.C3504id.btnSubmit);
            this.f12904A = (Button) m45871g(C3501R.C3504id.btnCancel);
            this.f12942z.setTag(f12902I0);
            this.f12904A.setTag("cancel");
            this.f12942z.setOnClickListener(this);
            this.f12904A.setOnClickListener(this);
            this.f12942z.setText(TextUtils.isEmpty(this.f12914F) ? context.getResources().getString(C3501R.C3506string.pickerview_submit) : this.f12914F);
            this.f12904A.setText(TextUtils.isEmpty(this.f12916G) ? context.getResources().getString(C3501R.C3506string.pickerview_cancel) : this.f12916G);
            this.f12906B.setText(TextUtils.isEmpty(this.f12918H) ? "" : this.f12918H);
            Button button = this.f12942z;
            int i2 = this.f12920I;
            if (i2 == 0) {
                i2 = this.f13121g;
            }
            button.setTextColor(i2);
            Button button2 = this.f12904A;
            int i3 = this.f12921J;
            if (i3 == 0) {
                i3 = this.f13121g;
            }
            button2.setTextColor(i3);
            TextView textView = this.f12906B;
            int i4 = this.f12922K;
            if (i4 == 0) {
                i4 = this.f13124j;
            }
            textView.setTextColor(i4);
            this.f12942z.setTextSize(this.f12925N);
            this.f12904A.setTextSize(this.f12925N);
            this.f12906B.setTextSize(this.f12926O);
            RelativeLayout relativeLayout = (RelativeLayout) m45871g(C3501R.C3504id.rv_topbar);
            int i5 = this.f12924M;
            if (i5 == 0) {
                i5 = this.f13123i;
            }
            relativeLayout.setBackgroundColor(i5);
        } else {
            customListener.m12721a(LayoutInflater.from(context).inflate(this.f12939w, this.f13117c));
        }
        LinearLayout linearLayout = (LinearLayout) m45871g(C3501R.C3504id.timepicker);
        int i6 = this.f12923L;
        if (i6 == 0) {
            i6 = this.f13125k;
        }
        linearLayout.setBackgroundColor(i6);
        this.f12941y = new WheelTime(linearLayout, this.f12912E, this.f12910D, this.f12927P);
        int i7 = this.f12931T;
        if (i7 != 0 && (i = this.f12932U) != 0 && i7 <= i) {
            m46032A();
        }
        Calendar calendar = this.f12929R;
        if (calendar != null && this.f12930S != null) {
            if (calendar.getTimeInMillis() <= this.f12930S.getTimeInMillis()) {
                m46027z();
            }
        } else if (calendar != null && this.f12930S == null) {
            m46027z();
        } else if (calendar == null && this.f12930S != null) {
            m46027z();
        }
        m46031B();
        this.f12941y.m45798v(this.f12907B0, this.f12909C0, this.f12911D0, this.f12913E0, this.f12915F0, this.f12917G0);
        m45859s(this.f12934W);
        this.f12941y.m45804p(this.f12933V);
        this.f12941y.m45802r(this.f12937Z);
        this.f12941y.m45800t(this.f12919H0);
        this.f12941y.m45796x(this.f12938p0);
        this.f12941y.m45821G(this.f12935X);
        this.f12941y.m45823E(this.f12936Y);
    }

    /* renamed from: z */
    private void m46027z() {
        this.f12941y.m45827A(this.f12929R, this.f12930S);
        Calendar calendar = this.f12929R;
        if (calendar != null && this.f12930S != null) {
            Calendar calendar2 = this.f12928Q;
            if (calendar2 == null || calendar2.getTimeInMillis() < this.f12929R.getTimeInMillis() || this.f12928Q.getTimeInMillis() > this.f12930S.getTimeInMillis()) {
                this.f12928Q = this.f12929R;
            }
        } else if (calendar != null) {
            this.f12928Q = calendar;
        } else {
            Calendar calendar3 = this.f12930S;
            if (calendar3 != null) {
                this.f12928Q = calendar3;
            }
        }
    }

    @Override // com.bigkoo.pickerview.view.BasePickerView
    /* renamed from: m */
    public boolean mo45865m() {
        return this.f12905A0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("cancel")) {
            m45874d();
        } else {
            m46029x();
        }
    }

    /* renamed from: x */
    public void m46029x() {
        if (this.f12908C != null) {
            try {
                this.f12908C.m45963a(WheelTime.f13165w.parse(this.f12941y.m45807m()), this.f13134t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        m45874d();
    }

    /* renamed from: y */
    public void m46028y(Calendar calendar) {
        this.f12928Q = calendar;
        m46031B();
    }
}
