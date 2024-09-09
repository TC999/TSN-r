package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.XPathException;
import com.hp.hpl.sparta.xpath.a0;
import com.hp.hpl.sparta.xpath.b0;
import com.hp.hpl.sparta.xpath.c0;
import com.hp.hpl.sparta.xpath.t;
import com.hp.hpl.sparta.xpath.v;
import com.hp.hpl.sparta.xpath.w;
import com.hp.hpl.sparta.xpath.x;
import com.hp.hpl.sparta.xpath.y;
import com.hp.hpl.sparta.xpath.z;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: XPathVisitor.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class s implements b0 {

    /* renamed from: i  reason: collision with root package name */
    private static final Boolean f37429i = new Boolean(true);

    /* renamed from: j  reason: collision with root package name */
    private static final Boolean f37430j = new Boolean(false);

    /* renamed from: a  reason: collision with root package name */
    private final j f37431a;

    /* renamed from: b  reason: collision with root package name */
    private Vector f37432b;

    /* renamed from: c  reason: collision with root package name */
    private Enumeration f37433c;

    /* renamed from: d  reason: collision with root package name */
    private Object f37434d;

    /* renamed from: e  reason: collision with root package name */
    private final b f37435e;

    /* renamed from: f  reason: collision with root package name */
    private i f37436f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f37437g;

    /* renamed from: h  reason: collision with root package name */
    private c0 f37438h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: XPathVisitor.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private a f37439a;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
        /* compiled from: XPathVisitor.java */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            final Boolean f37440a;

            /* renamed from: b  reason: collision with root package name */
            final a f37441b;

            a(Boolean bool, a aVar) {
                this.f37440a = bool;
                this.f37441b = aVar;
            }
        }

        private b() {
            this.f37439a = null;
        }

        Boolean a() {
            a aVar = this.f37439a;
            Boolean bool = aVar.f37440a;
            this.f37439a = aVar.f37441b;
            return bool;
        }

        void b(Boolean bool) {
            this.f37439a = new a(bool, this.f37439a);
        }
    }

    private s(c0 c0Var, i iVar) throws XPathException {
        this.f37431a = new j();
        this.f37432b = new Vector();
        this.f37433c = null;
        this.f37434d = null;
        this.f37435e = new b();
        this.f37438h = c0Var;
        this.f37436f = iVar;
        Vector vector = new Vector(1);
        this.f37432b = vector;
        vector.addElement(this.f37436f);
        Enumeration f4 = c0Var.f();
        while (f4.hasMoreElements()) {
            t tVar = (t) f4.nextElement();
            this.f37437g = tVar.c();
            this.f37433c = null;
            tVar.a().a(this);
            this.f37433c = this.f37431a.d();
            this.f37432b.removeAllElements();
            com.hp.hpl.sparta.xpath.k b4 = tVar.b();
            while (this.f37433c.hasMoreElements()) {
                this.f37434d = this.f37433c.nextElement();
                b4.a(this);
                if (this.f37435e.a().booleanValue()) {
                    this.f37432b.addElement(this.f37434d);
                }
            }
        }
    }

    private void q(e eVar) {
        g z3 = eVar.z();
        this.f37431a.a(z3, 1);
        if (this.f37437g) {
            r(z3);
        }
    }

    private void r(g gVar) {
        int i4 = 0;
        for (i F = gVar.F(); F != null; F = F.c()) {
            if (F instanceof g) {
                i4++;
                this.f37431a.a(F, i4);
                if (this.f37437g) {
                    r((g) F);
                }
            }
        }
    }

    private void s(e eVar, String str) {
        g z3 = eVar.z();
        if (z3 == null) {
            return;
        }
        if (z3.H() == str) {
            this.f37431a.a(z3, 1);
        }
        if (this.f37437g) {
            t(z3, str);
        }
    }

    private void t(g gVar, String str) {
        int i4 = 0;
        for (i F = gVar.F(); F != null; F = F.c()) {
            if (F instanceof g) {
                g gVar2 = (g) F;
                if (gVar2.H() == str) {
                    i4++;
                    this.f37431a.a(gVar2, i4);
                }
                if (this.f37437g) {
                    t(gVar2, str);
                }
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void a(a0 a0Var) {
        this.f37435e.b(f37429i);
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void b(com.hp.hpl.sparta.xpath.j jVar) {
        String D;
        Vector vector = this.f37432b;
        this.f37431a.f();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            i iVar = (i) elements.nextElement();
            if ((iVar instanceof g) && (D = ((g) iVar).D(jVar.c())) != null) {
                this.f37431a.b(D);
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void c(z zVar) {
        this.f37431a.f();
        this.f37431a.a(this.f37436f, 1);
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void d(x xVar) throws XPathException {
        Object obj = this.f37434d;
        if (obj instanceof g) {
            for (i F = ((g) obj).F(); F != null; F = F.c()) {
                if ((F instanceof r) && !((r) F).A().equals(xVar.b())) {
                    this.f37435e.b(f37429i);
                    return;
                }
            }
            this.f37435e.b(f37430j);
            return;
        }
        throw new XPathException(this.f37438h, "Cannot test attribute of document");
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void e(com.hp.hpl.sparta.xpath.r rVar) throws XPathException {
        Object obj = this.f37434d;
        if (obj instanceof g) {
            this.f37435e.b(this.f37431a.e((g) obj) == rVar.b() ? f37429i : f37430j);
            return;
        }
        throw new XPathException(this.f37438h, "Cannot test position of document");
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void f(com.hp.hpl.sparta.xpath.h hVar) throws XPathException {
        Object obj = this.f37434d;
        if (obj instanceof g) {
            this.f37435e.b(hVar.c().equals(((g) obj).D(hVar.b())) ^ true ? f37429i : f37430j);
            return;
        }
        throw new XPathException(this.f37438h, "Cannot test attribute of document");
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void g(w wVar) throws XPathException {
        Object obj = this.f37434d;
        if (obj instanceof g) {
            for (i F = ((g) obj).F(); F != null; F = F.c()) {
                if (F instanceof r) {
                    this.f37435e.b(f37429i);
                    return;
                }
            }
            this.f37435e.b(f37430j);
            return;
        }
        throw new XPathException(this.f37438h, "Cannot test attribute of document");
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void h(com.hp.hpl.sparta.xpath.m mVar) {
        String c4 = mVar.c();
        Vector vector = this.f37432b;
        int size = vector.size();
        this.f37431a.f();
        for (int i4 = 0; i4 < size; i4++) {
            Object elementAt = vector.elementAt(i4);
            if (elementAt instanceof g) {
                t((g) elementAt, c4);
            } else if (elementAt instanceof e) {
                s((e) elementAt, c4);
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void i(com.hp.hpl.sparta.xpath.f fVar) throws XPathException {
        Object obj = this.f37434d;
        if (obj instanceof g) {
            this.f37435e.b((((double) Long.parseLong(((g) obj).D(fVar.b()))) > fVar.c() ? 1 : (((double) Long.parseLong(((g) obj).D(fVar.b()))) == fVar.c() ? 0 : -1)) > 0 ? f37429i : f37430j);
            return;
        }
        throw new XPathException(this.f37438h, "Cannot test attribute of document");
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void j(com.hp.hpl.sparta.xpath.c cVar) throws XPathException {
        Object obj = this.f37434d;
        if (obj instanceof g) {
            this.f37435e.b(cVar.c().equals(((g) obj).D(cVar.b())) ? f37429i : f37430j);
            return;
        }
        throw new XPathException(this.f37438h, "Cannot test attribute of document");
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void k(com.hp.hpl.sparta.xpath.a aVar) {
        Vector vector = this.f37432b;
        this.f37431a.f();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof g) {
                r((g) nextElement);
            } else if (nextElement instanceof e) {
                q((e) nextElement);
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void l(y yVar) {
        Vector vector = this.f37432b;
        this.f37431a.f();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof g) {
                for (i F = ((g) nextElement).F(); F != null; F = F.c()) {
                    if (F instanceof r) {
                        this.f37431a.b(((r) F).A());
                    }
                }
            }
        }
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void m(com.hp.hpl.sparta.xpath.g gVar) throws XPathException {
        Object obj = this.f37434d;
        if (obj instanceof g) {
            this.f37435e.b((((double) Long.parseLong(((g) obj).D(gVar.b()))) > gVar.c() ? 1 : (((double) Long.parseLong(((g) obj).D(gVar.b()))) == gVar.c() ? 0 : -1)) < 0 ? f37429i : f37430j);
            return;
        }
        throw new XPathException(this.f37438h, "Cannot test attribute of document");
    }

    @Override // com.hp.hpl.sparta.xpath.p
    public void n(com.hp.hpl.sparta.xpath.q qVar) throws XPathException {
        this.f37431a.f();
        g e4 = this.f37436f.e();
        if (e4 != null) {
            this.f37431a.a(e4, 1);
            return;
        }
        throw new XPathException(this.f37438h, "Illegal attempt to apply \"..\" to node with no parent.");
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void o(com.hp.hpl.sparta.xpath.d dVar) throws XPathException {
        Object obj = this.f37434d;
        if (obj instanceof g) {
            String D = ((g) obj).D(dVar.b());
            this.f37435e.b(D != null && D.length() > 0 ? f37429i : f37430j);
            return;
        }
        throw new XPathException(this.f37438h, "Cannot test attribute of document");
    }

    @Override // com.hp.hpl.sparta.xpath.l
    public void p(v vVar) throws XPathException {
        Object obj = this.f37434d;
        if (obj instanceof g) {
            for (i F = ((g) obj).F(); F != null; F = F.c()) {
                if ((F instanceof r) && ((r) F).A().equals(vVar.b())) {
                    this.f37435e.b(f37429i);
                    return;
                }
            }
            this.f37435e.b(f37430j);
            return;
        }
        throw new XPathException(this.f37438h, "Cannot test attribute of document");
    }

    public g u() {
        if (this.f37432b.size() == 0) {
            return null;
        }
        return (g) this.f37432b.elementAt(0);
    }

    public String v() {
        if (this.f37432b.size() == 0) {
            return null;
        }
        return this.f37432b.elementAt(0).toString();
    }

    public Enumeration w() {
        return this.f37432b.elements();
    }

    public s(g gVar, c0 c0Var) throws XPathException {
        this(c0Var, gVar);
        if (c0Var.g()) {
            throw new XPathException(c0Var, "Cannot use element as context node for absolute xpath");
        }
    }

    public s(e eVar, c0 c0Var) throws XPathException {
        this(c0Var, eVar);
    }
}
