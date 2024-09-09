package com.qq.e.dl.l;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.qq.e.dl.k.j;
import com.qq.e.dl.k.l;
import com.qq.e.dl.k.n;
import com.qq.e.dl.l.k.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class h<T extends com.qq.e.dl.l.k.a> implements Object {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, com.qq.e.dl.k.c> f47065c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, j> f47066d;

    /* renamed from: g  reason: collision with root package name */
    private Map<com.qq.e.dl.i.a, com.qq.e.dl.k.d> f47069g;

    /* renamed from: h  reason: collision with root package name */
    protected T f47070h;

    /* renamed from: k  reason: collision with root package name */
    protected final com.qq.e.dl.a f47073k;

    /* renamed from: l  reason: collision with root package name */
    protected com.qq.e.dl.l.l.d f47074l;

    /* renamed from: m  reason: collision with root package name */
    protected com.qq.e.dl.l.k.d f47075m;

    /* renamed from: p  reason: collision with root package name */
    private com.qq.e.dl.l.j.f f47078p;

    /* renamed from: r  reason: collision with root package name */
    private d f47080r;

    /* renamed from: s  reason: collision with root package name */
    protected int f47081s;

    /* renamed from: t  reason: collision with root package name */
    private List<g> f47082t;

    /* renamed from: v  reason: collision with root package name */
    private com.qq.e.dl.h.d f47084v;

    /* renamed from: i  reason: collision with root package name */
    private int f47071i = -1;

    /* renamed from: j  reason: collision with root package name */
    protected int f47072j = 0;

    /* renamed from: n  reason: collision with root package name */
    protected final com.qq.e.dl.l.b f47076n = new com.qq.e.dl.l.b();

    /* renamed from: o  reason: collision with root package name */
    protected final com.qq.e.dl.l.c f47077o = new com.qq.e.dl.l.c();

    /* renamed from: u  reason: collision with root package name */
    private List<com.qq.e.dl.h.a> f47083u = Collections.emptyList();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, j> f47067e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final List<com.qq.e.dl.l.j.c> f47068f = new ArrayList(2);

    /* renamed from: q  reason: collision with root package name */
    protected final com.qq.e.dl.l.i.b f47079q = new com.qq.e.dl.l.i.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements n.d {
        a() {
        }

        @Override // com.qq.e.dl.k.n.d
        public void a(Object[] objArr) {
            if (h.this.f47079q.a(objArr)) {
                h.this.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements n.c {
        b() {
        }

        @Override // com.qq.e.dl.k.n.c
        public void a(int i4) {
            if (h.this.f47079q.a(i4)) {
                h.this.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements n.c {
        c() {
        }

        @Override // com.qq.e.dl.k.n.c
        public void a(int i4) {
            if (h.this.f47079q.b(i4)) {
                h.this.e();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface d extends com.qq.e.dl.l.d {
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface e {
        h a(com.qq.e.dl.a aVar);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface f {
        void a(h hVar, com.qq.e.dl.h.a aVar);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface g {
        void a(h hVar, int i4, int i5);
    }

    public h(com.qq.e.dl.a aVar) {
        this.f47073k = aVar;
    }

    private final void d(int i4) {
        View m4 = m();
        if (m4 == null) {
            return;
        }
        m4.setPivotY(i4);
    }

    private void s() {
        View m4 = m();
        if (m4 == null) {
            return;
        }
        m4.invalidate();
    }

    public void a(String str, JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Canvas canvas) {
    }

    public void b(int[] iArr) {
        if (this.f47079q.b(iArr)) {
            e();
        }
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        for (com.qq.e.dl.l.j.c cVar : this.f47068f) {
            cVar.a(jSONObject);
        }
        for (com.qq.e.dl.h.a aVar : this.f47083u) {
            aVar.a(jSONObject);
        }
        b(jSONObject);
        Map<String, com.qq.e.dl.k.c> map = this.f47065c;
        if (map == null || map.size() <= 0) {
            return;
        }
        boolean z3 = this.f47067e.size() == 0;
        boolean z4 = false;
        for (Map.Entry<String, com.qq.e.dl.k.c> entry : this.f47065c.entrySet()) {
            Object c4 = (z3 ? entry.getValue().a() : entry.getValue()).c(jSONObject);
            if (c4 != null) {
                j c5 = l.c(c4);
                String key = entry.getKey();
                if (z3 || !c5.equals(this.f47067e.get(key))) {
                    this.f47067e.put(key, c5);
                    b(key, c5);
                    z4 = true;
                }
            }
        }
        if (z4) {
            u();
        }
    }

    public void e(int i4) {
        if (this.f47079q.a(i4)) {
            s();
        }
    }

    public void f(int i4) {
        if (this.f47079q.b(i4)) {
            s();
        }
    }

    public com.qq.e.dl.l.i.d g() {
        return this.f47079q;
    }

    public List<com.qq.e.dl.l.j.c> h() {
        return this.f47068f;
    }

    public T i() {
        return this.f47070h;
    }

    public com.qq.e.dl.l.b j() {
        return this.f47076n;
    }

    public int k() {
        return this.f47070h.a();
    }

    public int l() {
        return this.f47070h.c();
    }

    public View m() {
        return null;
    }

    public com.qq.e.dl.l.c n() {
        return this.f47077o;
    }

    public final com.qq.e.dl.l.k.d o() {
        return this.f47075m;
    }

    public com.qq.e.dl.l.l.d p() {
        return this.f47074l;
    }

    public final int q() {
        return this.f47072j;
    }

    public Rect r() {
        View m4 = m();
        if (m4 == null || !m4.isShown()) {
            return null;
        }
        Rect rect = new Rect();
        if (m4.getGlobalVisibleRect(rect)) {
            int[] iArr = new int[2];
            m4.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            m4.getLocationInWindow(iArr2);
            int i4 = iArr[0] - iArr2[0];
            if (i4 != 0) {
                rect.right += i4;
                rect.left += i4;
            }
            int i5 = iArr[1] - iArr2[1];
            if (i5 != 0) {
                rect.bottom += i5;
                rect.top += i5;
            }
            return rect;
        }
        return null;
    }

    public final boolean t() {
        return this.f47072j == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        this.f47070h.b();
    }

    public void a(com.qq.e.dl.l.i.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f47079q.a(dVar);
    }

    public void g(int i4) {
        if (this.f47079q.c(i4)) {
            s();
        }
    }

    public void h(int i4) {
        this.f47072j = i4;
        View m4 = m();
        if (m4 != null) {
            int i5 = this.f47072j;
            if (i5 == 1) {
                m4.setVisibility(4);
            } else if (i5 != 2) {
                m4.setVisibility(0);
            } else {
                m4.setVisibility(8);
            }
        }
    }

    private void a(com.qq.e.dl.k.g gVar) {
        n.a(gVar, a().c(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        View m4 = m();
        if (m4 != null && m4.willNotDraw()) {
            m4.setWillNotDraw(false);
        }
        s();
    }

    protected void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n.a(l.c((Object) str), this.f47073k.c(), new b());
    }

    public int f() {
        return this.f47081s;
    }

    public void a(Object[] objArr) {
        if (this.f47079q.a(objArr)) {
            e();
        }
    }

    public void a(int[] iArr) {
        if (this.f47079q.a(iArr)) {
            s();
        }
    }

    public final void d(float f4) {
        View m4 = m();
        if (m4 == null) {
            return;
        }
        m4.setRotationY(f4);
    }

    public final com.qq.e.dl.a a() {
        return this.f47073k;
    }

    public void a(com.qq.e.dl.l.l.d dVar) {
        this.f47074l = dVar;
    }

    public void b(com.qq.e.dl.k.g gVar) {
        n.a(gVar, a().c(), new c());
    }

    private void b(com.qq.e.dl.i.g gVar) {
        Map<String, j> map;
        if (gVar == null || (map = gVar.f46975c) == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, j> entry : gVar.f46975c.entrySet()) {
            b(entry.getKey(), entry.getValue());
        }
    }

    public final void a(com.qq.e.dl.l.k.d dVar) {
        this.f47075m = dVar;
    }

    public void a(com.qq.e.dl.i.g gVar, com.qq.e.dl.l.g gVar2, JSONObject jSONObject) {
        this.f47070h.b(gVar.f46981i);
        this.f47070h.a(gVar.f46982j);
        this.f47074l.c().a(gVar.f46980h, this);
        b(gVar);
        this.f47065c = gVar.f46977e;
        this.f47066d = gVar.f46976d;
        a(gVar);
        a(gVar.f46979g);
        c(jSONObject);
        if (this.f47067e.size() == 0) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        if (this.f47080r == null || this.f47078p != null || this.f47068f.size() <= 0) {
            return;
        }
        com.qq.e.dl.l.j.f fVar = new com.qq.e.dl.l.j.f(this, this.f47080r);
        this.f47078p = fVar;
        fVar.a(this.f47068f);
    }

    private void b(JSONObject jSONObject) {
        Object c4;
        Map<com.qq.e.dl.i.a, com.qq.e.dl.k.d> map = this.f47069g;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<com.qq.e.dl.i.a, com.qq.e.dl.k.d> entry : this.f47069g.entrySet()) {
            com.qq.e.dl.k.d value = entry.getValue();
            if (value != null && (c4 = value.a().c(jSONObject)) != null) {
                try {
                    value.a(new JSONArray(c4.toString()));
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void a(com.qq.e.dl.i.g gVar) {
        com.qq.e.dl.i.c[] cVarArr = gVar.f46978f;
        if (cVarArr == null) {
            return;
        }
        if (this.f47068f.size() > 0) {
            this.f47068f.clear();
        }
        for (com.qq.e.dl.i.c cVar : cVarArr) {
            this.f47068f.add(new com.qq.e.dl.l.j.c(cVar));
        }
    }

    public final void b(float f4) {
        View m4 = m();
        if (m4 == null) {
            return;
        }
        m4.setRotation(f4);
    }

    private void a(com.qq.e.dl.i.e[] eVarArr) {
        if (eVarArr == null) {
            return;
        }
        this.f47083u = new ArrayList(eVarArr.length);
        for (com.qq.e.dl.i.e eVar : eVarArr) {
            this.f47083u.add(new com.qq.e.dl.h.a(eVar));
        }
    }

    private final void c(int i4) {
        View m4 = m();
        if (m4 == null) {
            return;
        }
        m4.setPivotX(i4);
    }

    public final void a(float f4) {
        View m4 = m();
        if (m4 == null) {
            return;
        }
        m4.setAlpha(f4);
    }

    public final void b(Float f4, Float f5) {
        View m4 = m();
        if (m4 == null) {
            return;
        }
        if (f4 != null) {
            m4.setTranslationX(f4.floatValue());
        }
        if (f5 != null) {
            m4.setTranslationY(f5.floatValue());
        }
    }

    private final void a(int i4) {
        com.qq.e.dl.d d4;
        View m4 = m();
        if (m4 == null || (d4 = this.f47073k.d()) == null) {
            return;
        }
        d4.a(m4, i4);
    }

    public final void c(float f4) {
        View m4 = m();
        if (m4 == null) {
            return;
        }
        m4.setRotationX(f4);
    }

    protected void b(boolean z3, int i4, int i5, int i6, int i7) {
        if (z3) {
            this.f47070h.a(i4, i5, i6, i7);
        }
    }

    public void c() {
        Map<String, j> map = this.f47066d;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, j> entry : this.f47066d.entrySet()) {
            b(entry.getKey(), entry.getValue());
        }
    }

    protected void b(int i4, int i5) {
        this.f47070h.a(i4, i5);
    }

    private boolean b(String str, com.qq.e.dl.k.g gVar) {
        return a(str, gVar) || this.f47076n.a(str, gVar) || this.f47077o.a(str, gVar);
    }

    public final void a(Float f4, Float f5) {
        View m4 = m();
        if (m4 == null) {
            return;
        }
        if (f4 != null) {
            m4.setScaleX(f4.floatValue());
        }
        if (f5 != null) {
            m4.setScaleY(f5.floatValue());
        }
    }

    private int b(int i4) {
        int i5;
        if (i4 == 8 || (i5 = this.f47072j) == 2) {
            return 2;
        }
        if (i4 == 4) {
            i5 = 1;
        }
        h<T> hVar = this;
        do {
            hVar = hVar.o();
            if (hVar == null) {
                break;
            }
            int q3 = hVar.q();
            if (q3 > i5) {
                i5 = q3;
                continue;
            }
        } while (i5 != 2);
        return i5;
    }

    public final void a(int i4, int i5) {
        b(i4, i5);
    }

    public JSONArray b(com.qq.e.dl.i.a aVar) {
        JSONArray b4;
        if (aVar == null) {
            return null;
        }
        com.qq.e.dl.k.d dVar = this.f47069g.get(aVar);
        return (dVar == null || (b4 = dVar.b()) == null) ? aVar.f46910c : b4;
    }

    public final void a(boolean z3, int i4, int i5, int i6, int i7) {
        b(z3, i4, i5, i6, i7);
    }

    public final void a(Canvas canvas) {
        b(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        return a(str, gVar, this.f47076n.n(), this.f47076n.m());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean a(String str, com.qq.e.dl.k.g gVar, int i4, int i5) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode == 1598) {
            if (str.equals("20")) {
                c4 = 2;
            }
            c4 = '\uffff';
        } else if (hashCode == 1604) {
            if (str.equals("26")) {
                c4 = '\t';
            }
            c4 = '\uffff';
        } else if (hashCode == 1636) {
            if (str.equals("37")) {
                c4 = 5;
            }
            c4 = '\uffff';
        } else if (hashCode == 1665) {
            if (str.equals("45")) {
                c4 = '\r';
            }
            c4 = '\uffff';
        } else if (hashCode != 454217397) {
            switch (hashCode) {
                case 1572:
                    if (str.equals("15")) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1573:
                    if (str.equals("16")) {
                        c4 = 4;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1574:
                    if (str.equals("17")) {
                        c4 = 6;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1575:
                    if (str.equals("18")) {
                        c4 = 0;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1576:
                    if (str.equals("19")) {
                        c4 = 1;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                default:
                    switch (hashCode) {
                        case 1660:
                            if (str.equals("40")) {
                                c4 = 7;
                                break;
                            }
                            c4 = '\uffff';
                            break;
                        case 1661:
                            if (str.equals("41")) {
                                c4 = '\b';
                                break;
                            }
                            c4 = '\uffff';
                            break;
                        case 1662:
                            if (str.equals("42")) {
                                c4 = '\n';
                                break;
                            }
                            c4 = '\uffff';
                            break;
                        default:
                            switch (hashCode) {
                                case 1667:
                                    if (str.equals("47")) {
                                        c4 = 14;
                                        break;
                                    }
                                    c4 = '\uffff';
                                    break;
                                case 1668:
                                    if (str.equals("48")) {
                                        c4 = 15;
                                        break;
                                    }
                                    c4 = '\uffff';
                                    break;
                                case 1669:
                                    if (str.equals("49")) {
                                        c4 = 16;
                                        break;
                                    }
                                    c4 = '\uffff';
                                    break;
                                default:
                                    switch (hashCode) {
                                        case 1727:
                                            if (str.equals("65")) {
                                                c4 = 11;
                                                break;
                                            }
                                            c4 = '\uffff';
                                            break;
                                        case 1728:
                                            if (str.equals("66")) {
                                                c4 = '\f';
                                                break;
                                            }
                                            c4 = '\uffff';
                                            break;
                                        case 1729:
                                            if (str.equals("67")) {
                                                c4 = 18;
                                                break;
                                            }
                                            c4 = '\uffff';
                                            break;
                                        default:
                                            c4 = '\uffff';
                                            break;
                                    }
                            }
                    }
            }
        } else {
            if (str.equals("viewTag")) {
                c4 = 17;
            }
            c4 = '\uffff';
        }
        switch (c4) {
            case 0:
                g(gVar.f(new JSONObject[0]).a(i4, i5));
                return true;
            case 1:
                b(gVar);
                return true;
            case 2:
                a(n.a(gVar, i4, i5));
                return true;
            case 3:
                h(gVar.b(new JSONObject[0]));
                return true;
            case 4:
                e(n.a(gVar));
                return true;
            case 5:
                a(gVar);
                return true;
            case 6:
                a(gVar.d(new JSONObject[0]));
                return true;
            case 7:
                c(gVar.f(new JSONObject[0]).a(i4, i5));
                return true;
            case '\b':
                d(gVar.f(new JSONObject[0]).a(i4, i5));
                return true;
            case '\t':
                a(gVar.b(new JSONObject[0]));
                return true;
            case '\n':
                b(gVar.d(new JSONObject[0]));
                return true;
            case 11:
                c(gVar.d(new JSONObject[0]));
                return true;
            case '\f':
                d(gVar.d(new JSONObject[0]));
                return true;
            case '\r':
                this.f47081s = gVar.b(new JSONObject[0]);
                return true;
            case 14:
                b(gVar.toString());
                return true;
            case 15:
                Pair<Float, Float> d4 = n.d(gVar);
                if (d4 != null) {
                    b((Float) d4.first, (Float) d4.second);
                    return true;
                }
                return true;
            case 16:
                Pair<Float, Float> c5 = n.c(gVar);
                if (c5 != null) {
                    a((Float) c5.first, (Float) c5.second);
                    return true;
                }
                return true;
            case 17:
                View m4 = m();
                if (m4 != null) {
                    m4.setTag(gVar.toString());
                    return true;
                }
                return true;
            case 18:
                b(n.b(gVar, i4, i5));
                return true;
            default:
                return false;
        }
    }

    public final void a(View view, int i4) {
        int b4;
        List<g> list = this.f47082t;
        if (list == null || list.size() <= 0 || (b4 = b(i4)) == this.f47071i) {
            return;
        }
        for (g gVar : this.f47082t) {
            gVar.a(this, this.f47071i, b4);
        }
        this.f47071i = b4;
    }

    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        if (this.f47082t == null) {
            this.f47082t = new ArrayList();
        }
        this.f47082t.add(gVar);
    }

    public void a(d dVar) {
        this.f47080r = dVar;
        d();
    }

    public void a(f fVar) {
        List<com.qq.e.dl.h.a> list;
        if (fVar == null || this.f47084v != null || (list = this.f47083u) == null || list.size() <= 0) {
            return;
        }
        com.qq.e.dl.h.d dVar = new com.qq.e.dl.h.d(this, fVar);
        this.f47084v = dVar;
        dVar.a(this.f47083u);
    }

    public void a(com.qq.e.dl.i.a aVar) {
        if (this.f47069g == null) {
            this.f47069g = new ConcurrentHashMap();
        }
        com.qq.e.dl.k.c b4 = l.b((Object) aVar.a());
        if (b4 != null) {
            this.f47069g.put(aVar, new com.qq.e.dl.k.d(b4));
        }
    }
}
