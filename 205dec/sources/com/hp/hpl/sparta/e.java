package com.hp.hpl.sparta;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.hp.hpl.sparta.q;
import com.hp.hpl.sparta.xpath.XPathException;
import com.hp.hpl.sparta.xpath.c0;
import com.hp.hpl.sparta.xpath.t;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: Document.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e extends i {

    /* renamed from: l  reason: collision with root package name */
    private static final boolean f37356l = false;

    /* renamed from: m  reason: collision with root package name */
    private static final Integer f37357m = new Integer(1);

    /* renamed from: n  reason: collision with root package name */
    static final Enumeration f37358n = new h();

    /* renamed from: g  reason: collision with root package name */
    private g f37359g;

    /* renamed from: h  reason: collision with root package name */
    private String f37360h;

    /* renamed from: i  reason: collision with root package name */
    private q.c f37361i;

    /* renamed from: j  reason: collision with root package name */
    private Vector f37362j;

    /* renamed from: k  reason: collision with root package name */
    private final Hashtable f37363k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: Document.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private transient q.c f37364a = null;

        /* renamed from: b  reason: collision with root package name */
        private final c0 f37365b;

        /* renamed from: c  reason: collision with root package name */
        private final String f37366c;

        a(c0 c0Var) throws XPathException {
            this.f37366c = c0Var.d();
            this.f37365b = c0Var;
            e.this.x(this);
        }

        private void b() throws ParseException {
            try {
                this.f37364a = q.b();
                Enumeration w3 = e.this.E(this.f37365b, false).w();
                while (w3.hasMoreElements()) {
                    g gVar = (g) w3.nextElement();
                    String D = gVar.D(this.f37366c);
                    Vector vector = (Vector) this.f37364a.get(D);
                    if (vector == null) {
                        vector = new Vector(1);
                        this.f37364a.put(D, vector);
                    }
                    vector.addElement(gVar);
                }
            } catch (XPathException e4) {
                throw new ParseException("XPath problem", e4);
            }
        }

        public synchronized Enumeration a(String str) throws ParseException {
            Vector vector;
            if (this.f37364a == null) {
                b();
            }
            vector = (Vector) this.f37364a.get(str);
            return vector == null ? e.f37358n : vector.elements();
        }

        public synchronized int c() throws ParseException {
            if (this.f37364a == null) {
                b();
            }
            return this.f37364a.size();
        }

        @Override // com.hp.hpl.sparta.e.b
        public synchronized void update(e eVar) {
            this.f37364a = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: Document.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void update(e eVar);
    }

    e(String str) {
        this.f37359g = null;
        this.f37361i = q.b();
        this.f37362j = new Vector();
        this.f37363k = null;
        this.f37360h = str;
    }

    private s F(String str, boolean z3) throws XPathException {
        if (str.charAt(0) != '/') {
            str = TTPathConst.sSeparator + str;
        }
        return E(c0.b(str), z3);
    }

    public String A() {
        return this.f37360h;
    }

    void B(c0 c0Var) throws XPathException {
    }

    public void C(g gVar) {
        this.f37359g = gVar;
        gVar.n(this);
        j();
    }

    public void D(String str) {
        this.f37360h = str;
        j();
    }

    s E(c0 c0Var, boolean z3) throws XPathException {
        if (c0Var.h() != z3) {
            String str = z3 ? "evaluates to element not string" : "evaluates to string not element";
            throw new XPathException(c0Var, "\"" + c0Var + "\" evaluates to " + str);
        }
        return new s(this, c0Var);
    }

    public boolean G(String str) throws ParseException {
        try {
            if (s(str) != null) {
                return false;
            }
            c0 b4 = c0.b(str);
            Enumeration f4 = b4.f();
            int i4 = 0;
            while (f4.hasMoreElements()) {
                f4.nextElement();
                i4++;
            }
            Enumeration f5 = b4.f();
            t tVar = (t) f5.nextElement();
            int i5 = i4 - 1;
            t[] tVarArr = new t[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                tVarArr[i6] = (t) f5.nextElement();
            }
            if (this.f37359g == null) {
                C(i(null, tVar, str));
            } else {
                if (s(TTPathConst.sSeparator + tVar) == null) {
                    throw new ParseException("Existing root element <" + this.f37359g.H() + "...> does not match first step \"" + tVar + "\" of \"" + str);
                }
            }
            if (i5 == 0) {
                return true;
            }
            return this.f37359g.R(c0.c(false, tVarArr).toString());
        } catch (XPathException e4) {
            throw new ParseException(str, e4);
        }
    }

    public a H(String str) throws ParseException {
        try {
            a aVar = (a) this.f37361i.get(str);
            if (aVar == null) {
                a aVar2 = new a(c0.b(str));
                this.f37361i.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        } catch (XPathException e4) {
            throw new ParseException("XPath problem", e4);
        }
    }

    public boolean I(String str) {
        return this.f37361i.get(str) != null;
    }

    @Override // com.hp.hpl.sparta.i
    protected int a() {
        return this.f37359g.hashCode();
    }

    @Override // com.hp.hpl.sparta.i
    public Object clone() {
        e eVar = new e(this.f37360h);
        eVar.f37359g = (g) this.f37359g.clone();
        return eVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f37359g.equals(((e) obj).f37359g);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hp.hpl.sparta.i
    public void j() {
        Enumeration elements = this.f37362j.elements();
        while (elements.hasMoreElements()) {
            ((b) elements.nextElement()).update(this);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public void p(Writer writer) throws IOException {
        this.f37359g.p(writer);
    }

    @Override // com.hp.hpl.sparta.i
    public void r(Writer writer) throws IOException {
        writer.write("<?xml version=\"1.0\" ?>\n");
        this.f37359g.r(writer);
    }

    @Override // com.hp.hpl.sparta.i
    public g s(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = TTPathConst.sSeparator + str;
            }
            c0 b4 = c0.b(str);
            B(b4);
            return E(b4, false).u();
        } catch (XPathException e4) {
            throw new ParseException("XPath problem", e4);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration t(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = TTPathConst.sSeparator + str;
            }
            c0 b4 = c0.b(str);
            B(b4);
            return E(b4, false).w();
        } catch (XPathException e4) {
            throw new ParseException("XPath problem", e4);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public String toString() {
        return this.f37360h;
    }

    @Override // com.hp.hpl.sparta.i
    public String u(String str) throws ParseException {
        try {
            return F(str, true).v();
        } catch (XPathException e4) {
            throw new ParseException("XPath problem", e4);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration v(String str) throws ParseException {
        try {
            return F(str, true).w();
        } catch (XPathException e4) {
            throw new ParseException("XPath problem", e4);
        }
    }

    public void x(b bVar) {
        this.f37362j.addElement(bVar);
    }

    public void y(b bVar) {
        this.f37362j.removeElement(bVar);
    }

    public g z() {
        return this.f37359g;
    }

    public e() {
        this.f37359g = null;
        this.f37361i = q.b();
        this.f37362j = new Vector();
        this.f37363k = null;
        this.f37360h = "MEMORY";
    }
}
