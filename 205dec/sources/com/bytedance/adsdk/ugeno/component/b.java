package com.bytedance.adsdk.ugeno.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.component.a;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.adsdk.ugeno.w.c;
import com.bytedance.adsdk.ugeno.w.e;
import com.bytedance.adsdk.ugeno.w.f;
import com.bytedance.adsdk.ugeno.w.g;
import com.bytedance.adsdk.ugeno.w.h;
import com.bytedance.adsdk.ugeno.w.j;
import com.bytedance.adsdk.ugeno.w.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l0.a;
import l0.i;
import m0.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class b<T extends View> implements b.a, b.InterfaceC0363b, j0.d {

    /* renamed from: a  reason: collision with root package name */
    protected float f26023a;
    private a.C1228a au;

    /* renamed from: b  reason: collision with root package name */
    private m0.d f26024b;
    protected String ba;
    private boolean be;
    private com.bytedance.adsdk.ugeno.w.c bj;
    protected float bk;
    private m0.c bm;
    private float bs;
    protected float bw;

    /* renamed from: c  reason: collision with root package name */
    private GradientDrawable f26025c;
    protected boolean ck;
    protected float eq;
    private JSONObject eu;
    protected e.a ev;

    /* renamed from: f  reason: collision with root package name */
    protected com.bytedance.adsdk.ugeno.component.a<ViewGroup> f26026f;
    private boolean fm;
    protected float fp;
    protected float fz;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26027g;
    protected boolean gb;
    protected g gd;
    private boolean ge;
    protected com.bytedance.adsdk.ugeno.w.b gw;

    /* renamed from: h  reason: collision with root package name */
    private f f26028h;

    /* renamed from: i  reason: collision with root package name */
    protected float f26029i;
    protected float ia;

    /* renamed from: j  reason: collision with root package name */
    protected float f26030j;

    /* renamed from: k  reason: collision with root package name */
    protected String f26031k;
    protected boolean ls;

    /* renamed from: m  reason: collision with root package name */
    protected j f26032m;
    protected float me;
    private String mt;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f26033n;
    private boolean ng;
    private boolean oh;
    private boolean ok;
    private boolean oo;
    private com.bytedance.adsdk.ugeno.w.d ox;

    /* renamed from: p  reason: collision with root package name */
    protected String f26034p;
    protected int pr;

    /* renamed from: q  reason: collision with root package name */
    protected float f26035q;

    /* renamed from: r  reason: collision with root package name */
    protected com.bytedance.adsdk.ugeno.component.a<ViewGroup> f26036r;

    /* renamed from: s  reason: collision with root package name */
    protected float f26037s;
    protected JSONObject sr;

    /* renamed from: t  reason: collision with root package name */
    protected float f26038t;
    private boolean ta;
    private boolean te;

    /* renamed from: u  reason: collision with root package name */
    protected float f26039u;
    protected Map<Integer, h> up;
    protected T ux;
    protected l vc;

    /* renamed from: w  reason: collision with root package name */
    protected Context f26040w;
    private m0.a wo;
    protected float wv;
    protected int wx;

    /* renamed from: x  reason: collision with root package name */
    protected boolean f26041x;
    protected float xk;
    private String xu;
    protected JSONObject xv;

    /* renamed from: y  reason: collision with root package name */
    protected float f26042y;
    protected float ys;
    protected float yu;

    /* renamed from: z  reason: collision with root package name */
    protected int f26043z;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (bVar.f26032m == null || !bVar.ta) {
                return;
            }
            b bVar2 = b.this;
            bVar2.f26032m.c(bVar2);
        }
    }

    /* renamed from: com.bytedance.adsdk.ugeno.component.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class View$OnClickListenerC0359b implements View.OnClickListener {
        View$OnClickListenerC0359b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (bVar.gw == null || !bVar.ta) {
                return;
            }
            b bVar2 = b.this;
            b bVar3 = b.this;
            bVar2.gw.c(bVar2.up.get(1), bVar3, bVar3);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class c implements a.InterfaceC1229a {
        c() {
        }

        @Override // m0.a.InterfaceC1229a
        public void c(int i4) {
            if (i4 == 1 && b.this.ux.isShown()) {
                b bVar = b.this;
                com.bytedance.adsdk.ugeno.w.b bVar2 = bVar.gw;
                if (bVar2 != null) {
                    b bVar3 = b.this;
                    bVar2.c(bVar.up.get(3), bVar3, bVar3);
                }
                b.this.wo.h();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class d implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m0.e f26047a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m0.b f26048b;

        d(m0.e eVar, m0.b bVar) {
            this.f26047a = eVar;
            this.f26048b = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            m0.b bVar;
            b bVar2;
            com.bytedance.adsdk.ugeno.w.b bVar3;
            m0.e eVar;
            b bVar4 = b.this;
            l lVar = bVar4.vc;
            if (lVar != null) {
                lVar.c(bVar4, motionEvent);
            }
            if (b.this.c(17) && motionEvent.getAction() == 0) {
                b bVar5 = b.this;
                b bVar6 = b.this;
                bVar5.gw.c(bVar5.up.get(17), bVar6, bVar6);
            }
            if (b.this.c(1) && b.this.ng && (bVar3 = (bVar2 = b.this).gw) != null && (eVar = this.f26047a) != null) {
                return eVar.a(bVar3, bVar2, motionEvent);
            }
            b bVar7 = b.this;
            com.bytedance.adsdk.ugeno.w.b bVar8 = bVar7.gw;
            if (bVar8 == null || (bVar = this.f26048b) == null) {
                return false;
            }
            return bVar.b(bVar8, bVar7, motionEvent);
        }
    }

    public b(Context context) {
        this(context, null);
    }

    private void ev() {
        if (TextUtils.isEmpty(this.ba)) {
            this.f26025c.setShape(0);
            if (this.oo) {
                a.C1228a c1228a = this.au;
                if (c1228a != null) {
                    this.f26025c.setOrientation(c1228a.f60794a);
                    if (Build.VERSION.SDK_INT >= 29) {
                        GradientDrawable gradientDrawable = this.f26025c;
                        a.C1228a c1228a2 = this.au;
                        gradientDrawable.setColors(c1228a2.f60795b, c1228a2.f60796c);
                    } else {
                        this.f26025c.setColors(this.au.f60795b);
                    }
                }
            } else {
                this.f26025c.setColor(this.f26043z);
            }
            this.f26025c.setCornerRadius(this.f26042y);
            this.f26025c.setStroke((int) this.yu, this.wx);
            this.ux.setBackground(this.f26025c);
        } else if (this.ba.startsWith("local://")) {
            String replace = this.ba.replace("local://", "");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                this.ux.setBackground(new BitmapDrawable(this.f26040w.getResources(), BitmapFactory.decodeStream(this.f26040w.getResources().openRawResource(l0.f.d(this.f26040w, replace)), null, options)));
            } catch (Throwable unused) {
            }
        }
    }

    public e.a a() {
        return this.ev;
    }

    public com.bytedance.adsdk.ugeno.component.a bk() {
        return this.f26026f;
    }

    public void c(JSONObject jSONObject) {
        JSONObject jSONObject2;
        this.sr = jSONObject;
        JSONObject jSONObject3 = this.xv;
        if (jSONObject3 == null) {
            return;
        }
        Iterator<String> keys = jSONObject3.keys();
        com.bytedance.adsdk.ugeno.component.a<ViewGroup> aVar = this.f26026f;
        a.C0358a c4 = aVar instanceof com.bytedance.adsdk.ugeno.component.a ? aVar.c() : null;
        while (keys.hasNext()) {
            String next = keys.next();
            String a4 = n0.d.a(this.xv.optString(next), jSONObject);
            c(next, a4);
            if (c4 != null) {
                c4.b(this.f26040w, next, a4);
            }
        }
        if (c4 != null) {
            c(c4.a());
        }
        JSONObject jSONObject4 = this.eu;
        if (jSONObject4 == null || (jSONObject2 = this.sr) == null) {
            return;
        }
        try {
            jSONObject2.put("i18n", jSONObject4);
            Log.d("nxb", "id: " + this.f26034p + "; " + this.eu);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // j0.d
    public void c(boolean z3) {
    }

    @Override // j0.d
    public void f() {
        com.bytedance.adsdk.ugeno.w.c cVar = this.bj;
        if (cVar != null) {
            com.bytedance.adsdk.ugeno.w.d dVar = new com.bytedance.adsdk.ugeno.w.d(this.ux, cVar);
            this.ox = dVar;
            dVar.b();
        }
        f fVar = this.f26028h;
        if (fVar != null) {
            fVar.gd();
        }
        if (this.f26024b != null && c(10)) {
            this.f26024b.a();
        }
        if (this.bm == null || !c(9)) {
            return;
        }
        this.bm.a();
    }

    public int fp() {
        return (int) this.f26023a;
    }

    public T gd() {
        return this.ux;
    }

    public int ia() {
        return (int) this.bk;
    }

    public JSONObject k() {
        return this.xv;
    }

    public JSONObject p() {
        return this.sr;
    }

    @Override // j0.d
    public void r() {
        com.bytedance.adsdk.ugeno.w.d dVar = this.ox;
        if (dVar != null) {
            dVar.c();
        }
        f fVar = this.f26028h;
        if (fVar != null) {
            fVar.p();
        }
    }

    public boolean s() {
        return this.f26041x;
    }

    public String t() {
        return this.f26034p;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void w() {
        m0.b bVar;
        ev();
        this.ux.setPadding((int) (this.ls ? this.f26039u : this.fz), (int) (this.f26033n ? this.f26035q : this.fz), (int) (this.gb ? this.f26029i : this.fz), (int) (this.ck ? this.f26030j : this.fz));
        this.ux.setVisibility(this.pr);
        e.a aVar = this.ev;
        if (aVar != null && TextUtils.isEmpty(aVar.h())) {
            this.ux.setOnClickListener(new a());
        } else if (c(1) && !this.ng) {
            this.ux.setOnClickListener(new View$OnClickListenerC0359b());
        }
        m0.e eVar = null;
        if (this.gw == null || !c(4)) {
            bVar = null;
        } else if (c(1)) {
            this.ok = true;
            bVar = new m0.b(this.f26040w, this.up.get(4), this.up.get(1), this.ok);
        } else {
            bVar = new m0.b(this.f26040w, this.up.get(4), this.ok);
        }
        if (this.gw != null && c(1) && this.ng) {
            eVar = new m0.e(this.f26040w, this.up.get(1));
        }
        if (this.gw != null && c(3)) {
            m0.a aVar2 = new m0.a(this.f26040w);
            this.wo = aVar2;
            aVar2.c(this.bs);
            this.wo.b();
            this.wo.d(new c());
        }
        if (this.gw != null && c(9)) {
            m0.c cVar = new m0.c(this.f26040w, this.up.get(9), this);
            this.bm = cVar;
            cVar.b(this.gw);
        }
        if (c(10)) {
            m0.d dVar = new m0.d(this.f26040w, this.up.get(10), this);
            this.f26024b = dVar;
            dVar.b(this.gw);
        }
        this.ux.setOnTouchListener(new d(eVar, bVar));
        c();
    }

    public T xv() {
        return null;
    }

    public String ys() {
        return this.f26031k;
    }

    public b(Context context, com.bytedance.adsdk.ugeno.component.a<ViewGroup> aVar) {
        this.f26023a = -2.0f;
        this.bk = -2.0f;
        this.pr = 0;
        this.f26041x = true;
        this.ta = true;
        this.be = false;
        this.f26027g = false;
        this.bs = 12.0f;
        this.f26040w = context;
        this.f26026f = aVar;
        this.up = new HashMap();
        this.f26025c = new GradientDrawable();
        this.ux = xv();
    }

    public void sr(String str) {
        this.f26031k = str;
    }

    @Override // j0.d
    public void ux() {
        f fVar = this.f26028h;
        if (fVar == null || this.te) {
            return;
        }
        this.te = true;
        fVar.f();
    }

    public void xv(String str) {
        this.f26034p = str;
    }

    @Override // j0.d
    public void sr() {
        f fVar = this.f26028h;
        if (fVar == null || this.oh) {
            return;
        }
        this.oh = true;
        fVar.ux();
    }

    private void c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f26034p);
        sb.append(":");
        sb.append(this.f26031k);
        sb.append(":");
        if (c(1)) {
            sb.append("1");
            sb.append(":");
            h hVar = this.up.get(1);
            if (hVar != null && hVar.i() != null) {
                sb.append(hVar.i().optString("type"));
            }
        } else {
            sb.append("0");
        }
        this.ux.setContentDescription(sb);
    }

    public void c(f fVar) {
        this.f26028h = fVar;
    }

    public boolean c(int i4) {
        Map<Integer, h> map = this.up;
        return map != null && map.containsKey(Integer.valueOf(i4));
    }

    public void c(l lVar) {
        this.vc = lVar;
    }

    public void c(com.bytedance.adsdk.ugeno.w.b bVar) {
        this.gw = bVar;
    }

    public void c(ViewGroup.LayoutParams layoutParams) {
        T t3 = this.ux;
        if (t3 != null) {
            t3.setLayoutParams(layoutParams);
        }
    }

    public void c(e.a aVar) {
        this.ev = aVar;
    }

    public void w(boolean z3) {
        this.ng = z3;
    }

    protected b<T> c(String str) {
        if (TextUtils.isEmpty(this.f26034p) || !TextUtils.equals(this.f26034p, str)) {
            return null;
        }
        return this;
    }

    public void w(int i4) {
        this.ux.setVisibility(i4);
    }

    public void c(com.bytedance.adsdk.ugeno.component.a aVar) {
        this.f26026f = aVar;
    }

    public void w(JSONObject jSONObject) {
        this.xv = jSONObject;
    }

    public void c(g gVar) {
        this.gd = gVar;
    }

    public b<T> w(String str) {
        return c(str);
    }

    public void c(j jVar) {
        this.f26032m = jVar;
    }

    protected void w(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && this.up != null) {
            try {
                int type = com.bytedance.adsdk.ugeno.w.a.c(str).getType();
                h hVar = new h();
                hVar.b(type);
                hVar.c(this);
                JSONObject jSONObject = new JSONObject(str2);
                if (type == 3) {
                    try {
                        this.bs = Float.parseFloat(n0.d.a(jSONObject.optString("shakeAmplitude"), this.sr));
                    } catch (NumberFormatException unused) {
                        this.bs = 12.0f;
                    }
                }
                com.bytedance.adsdk.ugeno.w.b bVar = this.gw;
                if (!(bVar instanceof c.b)) {
                    c(type, jSONObject, hVar);
                } else if (!((c.b) bVar).i()) {
                    c(type, jSONObject, hVar);
                } else {
                    hVar.e(jSONObject);
                    this.up.put(Integer.valueOf(type), hVar);
                }
            } catch (JSONException unused2) {
            }
        }
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    c4 = 3;
                    break;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    c4 = 4;
                    break;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    c4 = 5;
                    break;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    c4 = 6;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c4 = 7;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    c4 = '\b';
                    break;
                }
                break;
            case -1055029545:
                if (str.equals("borderRightTopRadius")) {
                    c4 = '\t';
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    c4 = '\n';
                    break;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    c4 = 11;
                    break;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    c4 = '\f';
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    c4 = '\r';
                    break;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    c4 = 14;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    c4 = 15;
                    break;
                }
                break;
            case -179345264:
                if (str.equals("borderLeftBottomRadius")) {
                    c4 = 16;
                    break;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    c4 = 17;
                    break;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    c4 = 18;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c4 = 19;
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c4 = 20;
                    break;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    c4 = 21;
                    break;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    c4 = 22;
                    break;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    c4 = 23;
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c4 = 24;
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c4 = 25;
                    break;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    c4 = 26;
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c4 = 27;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c4 = 28;
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    c4 = 29;
                    break;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    c4 = 30;
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    c4 = 31;
                    break;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    c4 = ' ';
                    break;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    c4 = '!';
                    break;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    c4 = '\"';
                    break;
                }
                break;
            case 1259700532:
                if (str.equals("borderLeftTopRadius")) {
                    c4 = '#';
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c4 = '$';
                    break;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    c4 = '%';
                    break;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    c4 = '&';
                    break;
                }
                break;
            case 1691835405:
                if (str.equals("borderRightBottomRadius")) {
                    c4 = '\'';
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c4 = '(';
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    c4 = ')';
                    break;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    c4 = '*';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.ta = i.d(str2, true);
                return;
            case 1:
                this.f26039u = l0.b.b(this.f26040w, str2);
                this.ls = true;
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 11:
            case 22:
            case 26:
            case 30:
            case ' ':
            case '\"':
            case '%':
            case '&':
                w(str, str2);
                return;
            case 6:
                if (l0.a.e(str2)) {
                    this.oo = true;
                    this.au = l0.a.d(str2);
                    return;
                }
                this.f26043z = l0.a.a(str2);
                this.oo = false;
                return;
            case 7:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.bk = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.bk = -2.0f;
                } else {
                    this.bk = l0.b.b(this.f26040w, str2);
                }
                this.f26027g = true;
                return;
            case '\b':
                this.f26038t = l0.b.b(this.f26040w, str2);
                return;
            case '\t':
                this.wv = l0.b.b(this.f26040w, str2);
                return;
            case '\n':
                this.ia = l0.b.b(this.f26040w, str2);
                return;
            case '\f':
                this.ba = str2;
                return;
            case '\r':
                this.fz = l0.b.b(this.f26040w, str2);
                return;
            case 14:
                this.xu = str2;
                return;
            case 15:
                this.f26037s = l0.b.b(this.f26040w, str2);
                return;
            case 16:
                this.me = l0.b.b(this.f26040w, str2);
                return;
            case 17:
                this.f26034p = str2;
                return;
            case 18:
                this.eu = l0.h.b(str2, null);
                return;
            case 19:
                this.f26031k = str2;
                return;
            case 20:
                this.f26035q = l0.b.b(this.f26040w, str2);
                this.f26033n = true;
                return;
            case 21:
                this.mt = str2;
                return;
            case 23:
                this.bw = i.a(str2, 0.0f);
                return;
            case 24:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.f26023a = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.f26023a = -2.0f;
                } else {
                    this.f26023a = l0.b.b(this.f26040w, str2);
                }
                this.be = true;
                return;
            case 25:
                this.f26030j = l0.b.b(this.f26040w, str2);
                this.ck = true;
                return;
            case 27:
                this.f26029i = l0.b.b(this.f26040w, str2);
                this.gb = true;
                return;
            case 28:
                this.wx = l0.a.a(str2);
                return;
            case 29:
                this.yu = l0.b.b(this.f26040w, str2);
                return;
            case 31:
                this.fp = l0.b.b(this.f26040w, str2);
                return;
            case '!':
                this.bj = com.bytedance.adsdk.ugeno.w.c.a(str2, this);
                return;
            case '#':
                this.eq = l0.b.b(this.f26040w, str2);
                return;
            case '$':
                this.f26042y = l0.b.b(this.f26040w, str2);
                return;
            case '\'':
                this.xk = l0.b.b(this.f26040w, str2);
                return;
            case '(':
                if (TextUtils.equals("visible", str2)) {
                    this.pr = 0;
                    return;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.pr = 4;
                    return;
                } else if (TextUtils.equals("gone", str2)) {
                    this.pr = 8;
                    return;
                } else {
                    return;
                }
            case ')':
                this.ys = l0.b.b(this.f26040w, str2);
                return;
            case '*':
                this.f26041x = !TextUtils.equals(str2, "unavailable");
                return;
            default:
                return;
        }
    }

    public b w(b bVar) {
        return (bVar.bk() == null && (bVar instanceof com.bytedance.adsdk.ugeno.component.a)) ? bVar : w(bVar.bk());
    }

    @Deprecated
    protected void c(int i4, JSONObject jSONObject, h hVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("success");
        if (optJSONObject != null) {
            h hVar2 = new h();
            hVar2.e(optJSONObject);
            hVar2.c(this);
            hVar.d(hVar2);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("fail");
        if (optJSONObject2 != null) {
            h hVar3 = new h();
            hVar3.e(optJSONObject2);
            hVar3.c(this);
            hVar.h(hVar3);
        }
        hVar.e(jSONObject);
        this.up.put(Integer.valueOf(i4), hVar);
    }

    @Override // j0.d
    public int[] c(int i4, int i5) {
        if (this.bw > 0.0f) {
            if (this.be) {
                int size = View.MeasureSpec.getSize(i4);
                float f4 = this.bw;
                if (f4 != 0.0f) {
                    i5 = View.MeasureSpec.makeMeasureSpec((int) (size / f4), 1073741824);
                }
            } else if (this.f26027g) {
                int size2 = View.MeasureSpec.getSize(i5);
                float f5 = this.bw;
                if (f5 != 0.0f) {
                    i4 = View.MeasureSpec.makeMeasureSpec((int) (size2 * f5), 1073741824);
                }
            }
        }
        f fVar = this.f26028h;
        if (fVar != null && !this.fm) {
            this.fm = true;
            fVar.sr();
        }
        return new int[]{i4, i5};
    }

    @Override // j0.d
    public void c(int i4, int i5, int i6, int i7) {
        f fVar = this.f26028h;
        if (fVar == null || this.ge) {
            return;
        }
        this.ge = true;
        fVar.r();
    }

    @Override // j0.d
    public void c(Canvas canvas) {
        f fVar = this.f26028h;
        if (fVar != null) {
            fVar.ev();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.b.InterfaceC0363b
    public void c(h hVar) {
        com.bytedance.adsdk.ugeno.component.a<ViewGroup> aVar;
        b<T> w3;
        if (hVar == null || hVar.i() == null) {
            return;
        }
        m0.a aVar2 = this.wo;
        if (aVar2 != null) {
            aVar2.h();
        }
        if (TextUtils.equals(hVar.i().optString("type"), "onDismiss")) {
            String optString = hVar.i().optString("nodeId");
            w(8);
            this.f26036r = (com.bytedance.adsdk.ugeno.component.a) w(this);
            if (TextUtils.isEmpty(optString) || (aVar = this.f26036r) == null || (w3 = aVar.w(optString)) == null) {
                return;
            }
            w3.w(8);
        }
    }
}
