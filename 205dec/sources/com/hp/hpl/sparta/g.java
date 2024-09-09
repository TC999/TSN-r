package com.hp.hpl.sparta;

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
/* compiled from: Element.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g extends i {

    /* renamed from: l  reason: collision with root package name */
    private static final boolean f37368l = false;

    /* renamed from: g  reason: collision with root package name */
    private i f37369g;

    /* renamed from: h  reason: collision with root package name */
    private i f37370h;

    /* renamed from: i  reason: collision with root package name */
    private Hashtable f37371i;

    /* renamed from: j  reason: collision with root package name */
    private Vector f37372j;

    /* renamed from: k  reason: collision with root package name */
    private String f37373k;

    public g(String str) {
        this.f37369g = null;
        this.f37370h = null;
        this.f37371i = null;
        this.f37372j = null;
        this.f37373k = null;
        this.f37373k = q.a(str);
    }

    private void A() {
    }

    private boolean K(i iVar) {
        for (i iVar2 = this.f37369g; iVar2 != null; iVar2 = iVar2.c()) {
            if (iVar2.equals(iVar)) {
                if (this.f37369g == iVar2) {
                    this.f37369g = iVar2.c();
                }
                if (this.f37370h == iVar2) {
                    this.f37370h = iVar2.f();
                }
                iVar2.k();
                iVar2.o(null);
                iVar2.n(null);
                return true;
            }
        }
        return false;
    }

    private void N(i iVar, i iVar2) throws DOMException {
        for (i iVar3 = this.f37369g; iVar3 != null; iVar3 = iVar3.c()) {
            if (iVar3 == iVar2) {
                if (this.f37369g == iVar2) {
                    this.f37369g = iVar;
                }
                if (this.f37370h == iVar2) {
                    this.f37370h = iVar;
                }
                iVar2.l(iVar);
                iVar.o(this);
                iVar2.o(null);
                return;
            }
        }
        throw new DOMException((short) 8, "Cannot find " + iVar2 + " in " + this);
    }

    private s Q(String str, boolean z3) throws XPathException {
        c0 b4 = c0.b(str);
        if (b4.h() != z3) {
            String str2 = z3 ? "evaluates to element not string" : "evaluates to string not element";
            throw new XPathException(b4, "\"" + b4 + "\" evaluates to " + str2);
        }
        return new s(this, b4);
    }

    public g B(boolean z3) {
        g gVar = new g(this.f37373k);
        Vector vector = this.f37372j;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                gVar.O(str, (String) this.f37371i.get(str));
            }
        }
        if (z3) {
            for (i iVar = this.f37369g; iVar != null; iVar = iVar.c()) {
                gVar.x((i) iVar.clone());
            }
        }
        return gVar;
    }

    public g C() {
        return B(false);
    }

    public String D(String str) {
        Hashtable hashtable = this.f37371i;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str);
    }

    public Enumeration E() {
        Vector vector = this.f37372j;
        if (vector == null) {
            return e.f37358n;
        }
        return vector.elements();
    }

    public i F() {
        return this.f37369g;
    }

    public i G() {
        return this.f37370h;
    }

    public String H() {
        return this.f37373k;
    }

    public void I(String str) {
        Hashtable hashtable = this.f37371i;
        if (hashtable == null) {
            return;
        }
        hashtable.remove(str);
        this.f37372j.removeElement(str);
        j();
    }

    public void J(i iVar) throws DOMException {
        if (K(iVar)) {
            j();
            return;
        }
        throw new DOMException((short) 8, "Cannot find " + iVar + " in " + this);
    }

    public void L(g gVar, i iVar) throws DOMException {
        N(gVar, iVar);
        j();
    }

    public void M(r rVar, i iVar) throws DOMException {
        N(rVar, iVar);
        j();
    }

    public void O(String str, String str2) {
        if (this.f37371i == null) {
            this.f37371i = new Hashtable();
            this.f37372j = new Vector();
        }
        if (this.f37371i.get(str) == null) {
            this.f37372j.addElement(str);
        }
        this.f37371i.put(str, str2);
        j();
    }

    public void P(String str) {
        this.f37373k = q.a(str);
        j();
    }

    public boolean R(String str) throws ParseException {
        g s3;
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
            int i5 = i4 - 1;
            t[] tVarArr = new t[i5];
            Enumeration f5 = b4.f();
            for (int i6 = 0; i6 < i5; i6++) {
                tVarArr[i6] = (t) f5.nextElement();
            }
            t tVar = (t) f5.nextElement();
            if (i5 == 0) {
                s3 = this;
            } else {
                String c0Var = c0.c(b4.g(), tVarArr).toString();
                R(c0Var.toString());
                s3 = s(c0Var);
            }
            s3.y(i(s3, tVar, str));
            return true;
        } catch (XPathException e4) {
            throw new ParseException(str, e4);
        }
    }

    @Override // com.hp.hpl.sparta.i
    protected int a() {
        int hashCode = this.f37373k.hashCode();
        Hashtable hashtable = this.f37371i;
        if (hashtable != null) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                hashCode = (((hashCode * 31) + str.hashCode()) * 31) + ((String) this.f37371i.get(str)).hashCode();
            }
        }
        for (i iVar = this.f37369g; iVar != null; iVar = iVar.c()) {
            hashCode = (hashCode * 31) + iVar.hashCode();
        }
        return hashCode;
    }

    @Override // com.hp.hpl.sparta.i
    public Object clone() {
        return B(true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f37373k.equals(gVar.f37373k)) {
                Hashtable hashtable = this.f37371i;
                int size = hashtable == null ? 0 : hashtable.size();
                Hashtable hashtable2 = gVar.f37371i;
                if (size != (hashtable2 == null ? 0 : hashtable2.size())) {
                    return false;
                }
                Hashtable hashtable3 = this.f37371i;
                if (hashtable3 != null) {
                    Enumeration keys = hashtable3.keys();
                    while (keys.hasMoreElements()) {
                        String str = (String) keys.nextElement();
                        if (!((String) this.f37371i.get(str)).equals((String) gVar.f37371i.get(str))) {
                            return false;
                        }
                    }
                }
                i iVar = this.f37369g;
                i iVar2 = gVar.f37369g;
                while (iVar != null) {
                    if (!iVar.equals(iVar2)) {
                        return false;
                    }
                    iVar = iVar.c();
                    iVar2 = iVar2.c();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hp.hpl.sparta.i
    public void p(Writer writer) throws IOException {
        for (i iVar = this.f37369g; iVar != null; iVar = iVar.c()) {
            iVar.p(writer);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public void r(Writer writer) throws IOException {
        writer.write("<" + this.f37373k);
        Vector vector = this.f37372j;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                writer.write(" " + str + "=\"");
                i.g(writer, (String) this.f37371i.get(str));
                writer.write("\"");
            }
        }
        if (this.f37369g == null) {
            writer.write("/>");
            return;
        }
        writer.write(">");
        for (i iVar = this.f37369g; iVar != null; iVar = iVar.c()) {
            iVar.r(writer);
        }
        writer.write("</" + this.f37373k + ">");
    }

    @Override // com.hp.hpl.sparta.i
    public g s(String str) throws ParseException {
        try {
            return Q(str, false).u();
        } catch (XPathException e4) {
            throw new ParseException("XPath problem", e4);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration t(String str) throws ParseException {
        try {
            return Q(str, false).w();
        } catch (XPathException e4) {
            throw new ParseException("XPath problem", e4);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public String u(String str) throws ParseException {
        try {
            return Q(str, true).v();
        } catch (XPathException e4) {
            throw new ParseException("XPath problem", e4);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration v(String str) throws ParseException {
        try {
            return Q(str, true).w();
        } catch (XPathException e4) {
            throw new ParseException("XPath problem", e4);
        }
    }

    public void x(i iVar) {
        if (!z(iVar)) {
            iVar = (g) iVar.clone();
        }
        y(iVar);
        j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(i iVar) {
        g e4 = iVar.e();
        if (e4 != null) {
            e4.K(iVar);
        }
        iVar.h(this.f37370h);
        if (this.f37369g == null) {
            this.f37369g = iVar;
        }
        iVar.o(this);
        this.f37370h = iVar;
        iVar.n(d());
    }

    boolean z(i iVar) {
        if (iVar == this) {
            return false;
        }
        g e4 = e();
        if (e4 == null) {
            return true;
        }
        return e4.z(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        this.f37369g = null;
        this.f37370h = null;
        this.f37371i = null;
        this.f37372j = null;
        this.f37373k = null;
    }
}
