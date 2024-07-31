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
import com.bigkoo.pickerview.view.BasePickerView;
import com.bigkoo.pickerview.view.WheelOptions;
import java.util.List;
import p600i.CustomListener;

/* renamed from: com.bigkoo.pickerview.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OptionsPickerView<T> extends BasePickerView implements View.OnClickListener {

    /* renamed from: F0 */
    private static final String f12985F0 = "submit";

    /* renamed from: G0 */
    private static final String f12986G0 = "cancel";

    /* renamed from: A */
    private Button f12987A;

    /* renamed from: A0 */
    private Typeface f12988A0;

    /* renamed from: B */
    private TextView f12989B;

    /* renamed from: B0 */
    private int f12990B0;

    /* renamed from: C */
    private InterfaceC3512b f12991C;

    /* renamed from: C0 */
    private int f12992C0;

    /* renamed from: D */
    private String f12993D;

    /* renamed from: D0 */
    private int f12994D0;

    /* renamed from: E */
    private String f12995E;

    /* renamed from: E0 */
    private WheelView.DividerType f12996E0;

    /* renamed from: F */
    private String f12997F;

    /* renamed from: G */
    private int f12998G;

    /* renamed from: H */
    private int f12999H;

    /* renamed from: I */
    private int f13000I;

    /* renamed from: J */
    private int f13001J;

    /* renamed from: K */
    private int f13002K;

    /* renamed from: L */
    private int f13003L;

    /* renamed from: M */
    private int f13004M;

    /* renamed from: N */
    private int f13005N;

    /* renamed from: O */
    private int f13006O;

    /* renamed from: P */
    private int f13007P;

    /* renamed from: Q */
    private int f13008Q;

    /* renamed from: R */
    private float f13009R;

    /* renamed from: S */
    private boolean f13010S;

    /* renamed from: T */
    private boolean f13011T;

    /* renamed from: U */
    private boolean f13012U;

    /* renamed from: V */
    private String f13013V;

    /* renamed from: W */
    private String f13014W;

    /* renamed from: X */
    private String f13015X;

    /* renamed from: Y */
    private boolean f13016Y;

    /* renamed from: Z */
    private boolean f13017Z;

    /* renamed from: p0 */
    private boolean f13018p0;

    /* renamed from: w */
    WheelOptions<T> f13019w;

    /* renamed from: x */
    private int f13020x;

    /* renamed from: y */
    private CustomListener f13021y;

    /* renamed from: z */
    private Button f13022z;

    /* compiled from: OptionsPickerView.java */
    /* renamed from: com.bigkoo.pickerview.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3511a {

        /* renamed from: C */
        private Typeface f13025C;

        /* renamed from: D */
        private int f13026D;

        /* renamed from: E */
        private int f13027E;

        /* renamed from: F */
        private int f13028F;

        /* renamed from: G */
        private WheelView.DividerType f13029G;

        /* renamed from: b */
        private CustomListener f13031b;

        /* renamed from: c */
        private Context f13032c;

        /* renamed from: d */
        private InterfaceC3512b f13033d;

        /* renamed from: e */
        private String f13034e;

        /* renamed from: f */
        private String f13035f;

        /* renamed from: g */
        private String f13036g;

        /* renamed from: h */
        private int f13037h;

        /* renamed from: i */
        private int f13038i;

        /* renamed from: j */
        private int f13039j;

        /* renamed from: k */
        private int f13040k;

        /* renamed from: l */
        private int f13041l;

        /* renamed from: r */
        private int f13047r;

        /* renamed from: s */
        private int f13048s;

        /* renamed from: t */
        private int f13049t;

        /* renamed from: v */
        private boolean f13051v;

        /* renamed from: w */
        private String f13052w;

        /* renamed from: x */
        private String f13053x;

        /* renamed from: y */
        private String f13054y;

        /* renamed from: a */
        private int f13030a = C3501R.C3505layout.pickerview_options;

        /* renamed from: m */
        private int f13042m = 17;

        /* renamed from: n */
        private int f13043n = 18;

        /* renamed from: o */
        private int f13044o = 18;

        /* renamed from: p */
        private boolean f13045p = true;

        /* renamed from: q */
        private boolean f13046q = true;

        /* renamed from: u */
        private float f13050u = 1.6f;

        /* renamed from: z */
        private boolean f13055z = false;

        /* renamed from: A */
        private boolean f13023A = false;

        /* renamed from: B */
        private boolean f13024B = false;

        public C3511a(Context context, InterfaceC3512b interfaceC3512b) {
            this.f13032c = context;
            this.f13033d = interfaceC3512b;
        }

        /* renamed from: H */
        public OptionsPickerView m45945H() {
            return new OptionsPickerView(this);
        }

        /* renamed from: I */
        public C3511a m45944I(boolean z) {
            this.f13051v = z;
            return this;
        }

        /* renamed from: J */
        public C3511a m45943J(int i) {
            this.f13040k = i;
            return this;
        }

        /* renamed from: K */
        public C3511a m45942K(int i) {
            this.f13038i = i;
            return this;
        }

        /* renamed from: L */
        public C3511a m45941L(String str) {
            this.f13035f = str;
            return this;
        }

        /* renamed from: M */
        public C3511a m45940M(int i) {
            this.f13044o = i;
            return this;
        }

        /* renamed from: N */
        public C3511a m45939N(boolean z, boolean z2, boolean z3) {
            this.f13055z = z;
            this.f13023A = z2;
            this.f13024B = z3;
            return this;
        }

        /* renamed from: O */
        public C3511a m45938O(int i) {
            this.f13049t = i;
            return this;
        }

        /* renamed from: P */
        public C3511a m45937P(WheelView.DividerType dividerType) {
            this.f13029G = dividerType;
            return this;
        }

        /* renamed from: Q */
        public C3511a m45936Q(String str, String str2, String str3) {
            this.f13052w = str;
            this.f13053x = str2;
            this.f13054y = str3;
            return this;
        }

        /* renamed from: R */
        public C3511a m45935R(int i, CustomListener customListener) {
            this.f13030a = i;
            this.f13031b = customListener;
            return this;
        }

        /* renamed from: S */
        public C3511a m45934S(float f) {
            this.f13050u = f;
            return this;
        }

        @Deprecated
        /* renamed from: T */
        public C3511a m45933T(boolean z) {
            this.f13046q = z;
            return this;
        }

        /* renamed from: U */
        public C3511a m45932U(boolean z) {
            this.f13045p = z;
            return this;
        }

        /* renamed from: V */
        public C3511a m45931V(int i) {
            this.f13026D = i;
            return this;
        }

        /* renamed from: W */
        public C3511a m45930W(int i, int i2) {
            this.f13026D = i;
            this.f13027E = i2;
            return this;
        }

        /* renamed from: X */
        public C3511a m45929X(int i, int i2, int i3) {
            this.f13026D = i;
            this.f13027E = i2;
            this.f13028F = i3;
            return this;
        }

        /* renamed from: Y */
        public C3511a m45928Y(int i) {
            this.f13042m = i;
            return this;
        }

        /* renamed from: Z */
        public C3511a m45927Z(int i) {
            this.f13037h = i;
            return this;
        }

        /* renamed from: a0 */
        public C3511a m45925a0(String str) {
            this.f13034e = str;
            return this;
        }

        /* renamed from: b0 */
        public C3511a m45923b0(int i) {
            this.f13048s = i;
            return this;
        }

        /* renamed from: c0 */
        public C3511a m45921c0(int i) {
            this.f13047r = i;
            return this;
        }

        /* renamed from: d0 */
        public C3511a m45919d0(int i) {
            this.f13041l = i;
            return this;
        }

        /* renamed from: e0 */
        public C3511a m45917e0(int i) {
            this.f13039j = i;
            return this;
        }

        /* renamed from: f0 */
        public C3511a m45915f0(int i) {
            this.f13043n = i;
            return this;
        }

        /* renamed from: g0 */
        public C3511a m45913g0(String str) {
            this.f13036g = str;
            return this;
        }

        /* renamed from: h0 */
        public C3511a m45911h0(Typeface typeface) {
            this.f13025C = typeface;
            return this;
        }
    }

    /* compiled from: OptionsPickerView.java */
    /* renamed from: com.bigkoo.pickerview.b$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3512b {
        /* renamed from: a */
        void mo40505a(int i, int i2, int i3, View view);
    }

    public OptionsPickerView(C3511a c3511a) {
        super(c3511a.f13032c);
        this.f13009R = 1.6f;
        this.f12991C = c3511a.f13033d;
        this.f12993D = c3511a.f13034e;
        this.f12995E = c3511a.f13035f;
        this.f12997F = c3511a.f13036g;
        this.f12998G = c3511a.f13037h;
        this.f12999H = c3511a.f13038i;
        this.f13000I = c3511a.f13039j;
        this.f13001J = c3511a.f13040k;
        this.f13002K = c3511a.f13041l;
        this.f13003L = c3511a.f13042m;
        this.f13004M = c3511a.f13043n;
        this.f13005N = c3511a.f13044o;
        this.f13016Y = c3511a.f13055z;
        this.f13017Z = c3511a.f13023A;
        this.f13018p0 = c3511a.f13024B;
        this.f13011T = c3511a.f13045p;
        this.f13012U = c3511a.f13046q;
        this.f13013V = c3511a.f13052w;
        this.f13014W = c3511a.f13053x;
        this.f13015X = c3511a.f13054y;
        this.f12988A0 = c3511a.f13025C;
        this.f12990B0 = c3511a.f13026D;
        this.f12992C0 = c3511a.f13027E;
        this.f12994D0 = c3511a.f13028F;
        this.f13007P = c3511a.f13048s;
        this.f13006O = c3511a.f13047r;
        this.f13008Q = c3511a.f13049t;
        this.f13009R = c3511a.f13050u;
        this.f13021y = c3511a.f13031b;
        this.f13020x = c3511a.f13030a;
        this.f13010S = c3511a.f13051v;
        this.f12996E0 = c3511a.f13029G;
        m45955x(c3511a.f13032c);
    }

    /* renamed from: w */
    private void m45956w() {
        WheelOptions<T> wheelOptions = this.f13019w;
        if (wheelOptions != null) {
            wheelOptions.m45844j(this.f12990B0, this.f12992C0, this.f12994D0);
        }
    }

    /* renamed from: x */
    private void m45955x(Context context) {
        m45862p(this.f13011T);
        m45866l();
        m45868j();
        m45867k();
        CustomListener customListener = this.f13021y;
        if (customListener == null) {
            LayoutInflater.from(context).inflate(this.f13020x, this.f13117c);
            this.f12989B = (TextView) m45871g(C3501R.C3504id.tvTitle);
            this.f13022z = (Button) m45871g(C3501R.C3504id.btnSubmit);
            this.f12987A = (Button) m45871g(C3501R.C3504id.btnCancel);
            this.f13022z.setTag(f12985F0);
            this.f12987A.setTag("cancel");
            this.f13022z.setOnClickListener(this);
            this.f12987A.setOnClickListener(this);
            this.f13022z.setText(TextUtils.isEmpty(this.f12993D) ? context.getResources().getString(C3501R.C3506string.pickerview_submit) : this.f12993D);
            this.f12987A.setText(TextUtils.isEmpty(this.f12995E) ? context.getResources().getString(C3501R.C3506string.pickerview_cancel) : this.f12995E);
            this.f12989B.setText(TextUtils.isEmpty(this.f12997F) ? "" : this.f12997F);
            Button button = this.f13022z;
            int i = this.f12998G;
            if (i == 0) {
                i = this.f13121g;
            }
            button.setTextColor(i);
            Button button2 = this.f12987A;
            int i2 = this.f12999H;
            if (i2 == 0) {
                i2 = this.f13121g;
            }
            button2.setTextColor(i2);
            TextView textView = this.f12989B;
            int i3 = this.f13000I;
            if (i3 == 0) {
                i3 = this.f13124j;
            }
            textView.setTextColor(i3);
            RelativeLayout relativeLayout = (RelativeLayout) m45871g(C3501R.C3504id.rv_topbar);
            int i4 = this.f13002K;
            if (i4 == 0) {
                i4 = this.f13123i;
            }
            relativeLayout.setBackgroundColor(i4);
            this.f13022z.setTextSize(this.f13003L);
            this.f12987A.setTextSize(this.f13003L);
            this.f12989B.setTextSize(this.f13004M);
            this.f12989B.setText(this.f12997F);
        } else {
            customListener.m12721a(LayoutInflater.from(context).inflate(this.f13020x, this.f13117c));
        }
        LinearLayout linearLayout = (LinearLayout) m45871g(C3501R.C3504id.optionspicker);
        int i5 = this.f13001J;
        if (i5 == 0) {
            i5 = this.f13125k;
        }
        linearLayout.setBackgroundColor(i5);
        WheelOptions<T> wheelOptions = new WheelOptions<>(linearLayout, Boolean.valueOf(this.f13012U));
        this.f13019w = wheelOptions;
        wheelOptions.m45828z(this.f13005N);
        this.f13019w.m45837q(this.f13013V, this.f13014W, this.f13015X);
        this.f13019w.m45842l(this.f13016Y, this.f13017Z, this.f13018p0);
        this.f13019w.m45855A(this.f12988A0);
        m45859s(this.f13011T);
        TextView textView2 = this.f12989B;
        if (textView2 != null) {
            textView2.setText(this.f12997F);
        }
        this.f13019w.m45840n(this.f13008Q);
        this.f13019w.m45838p(this.f12996E0);
        this.f13019w.m45835s(this.f13009R);
        this.f13019w.m45829y(this.f13006O);
        this.f13019w.m45831w(this.f13007P);
    }

    /* renamed from: A */
    public void m45962A(List<T> list) {
        this.f13019w.m45833u(list, null, null);
        m45956w();
    }

    /* renamed from: B */
    public void m45961B(List<T> list, List<List<T>> list2) {
        this.f13019w.m45833u(list, list2, null);
        m45956w();
    }

    /* renamed from: C */
    public void m45960C(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f13019w.m45833u(list, list2, list3);
        m45956w();
    }

    /* renamed from: D */
    public void m45959D(int i) {
        this.f12990B0 = i;
        m45956w();
    }

    /* renamed from: E */
    public void m45958E(int i, int i2) {
        this.f12990B0 = i;
        this.f12992C0 = i2;
        m45956w();
    }

    /* renamed from: F */
    public void m45957F(int i, int i2, int i3) {
        this.f12990B0 = i;
        this.f12992C0 = i2;
        this.f12994D0 = i3;
        m45956w();
    }

    @Override // com.bigkoo.pickerview.view.BasePickerView
    /* renamed from: m */
    public boolean mo45865m() {
        return this.f13010S;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("cancel")) {
            m45874d();
        } else {
            m45954y();
        }
    }

    /* renamed from: y */
    public void m45954y() {
        if (this.f12991C != null) {
            int[] m45847g = this.f13019w.m45847g();
            this.f12991C.mo40505a(m45847g[0], m45847g[1], m45847g[2], this.f13134t);
        }
        m45874d();
    }

    /* renamed from: z */
    public void m45953z(List<T> list, List<T> list2, List<T> list3) {
        this.f13019w.m45834t(list, list2, list3);
        m45956w();
    }
}
