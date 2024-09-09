package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.XPathException;
import com.hp.hpl.sparta.xpath.a0;
import com.hp.hpl.sparta.xpath.c0;
import com.hp.hpl.sparta.xpath.t;
import com.hp.hpl.sparta.xpath.v;
import com.hp.hpl.sparta.xpath.w;
import com.hp.hpl.sparta.xpath.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: Node.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private e f37374a = null;

    /* renamed from: b  reason: collision with root package name */
    private g f37375b = null;

    /* renamed from: c  reason: collision with root package name */
    private i f37376c = null;

    /* renamed from: d  reason: collision with root package name */
    private i f37377d = null;

    /* renamed from: e  reason: collision with root package name */
    private Object f37378e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f37379f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* compiled from: Node.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class a implements com.hp.hpl.sparta.xpath.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f37380a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f37381b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f37382c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f37383d;

        a(g gVar, g gVar2, String str, String str2) {
            this.f37380a = gVar;
            this.f37381b = gVar2;
            this.f37382c = str;
            this.f37383d = str2;
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void a(a0 a0Var) {
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void d(x xVar) throws XPathException {
            g gVar = this.f37380a;
            gVar.x(new r("not " + xVar.b()));
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void e(com.hp.hpl.sparta.xpath.r rVar) throws XPathException {
            int b4 = rVar.b();
            if (this.f37381b == null && b4 != 1) {
                throw new XPathException(c0.b(this.f37382c), "Position of root node must be 1");
            }
            for (int i4 = 1; i4 < b4; i4++) {
                this.f37381b.x(new g(this.f37383d));
            }
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void f(com.hp.hpl.sparta.xpath.h hVar) throws XPathException {
            g gVar = this.f37380a;
            String b4 = hVar.b();
            gVar.O(b4, "not " + hVar.c());
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void g(w wVar) throws XPathException {
            this.f37380a.x(new r("something"));
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void i(com.hp.hpl.sparta.xpath.f fVar) throws XPathException {
            this.f37380a.O(fVar.b(), Long.toString(Long.MAX_VALUE));
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void j(com.hp.hpl.sparta.xpath.c cVar) throws XPathException {
            this.f37380a.O(cVar.b(), cVar.c());
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void m(com.hp.hpl.sparta.xpath.g gVar) throws XPathException {
            this.f37380a.O(gVar.b(), Long.toString(Long.MIN_VALUE));
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void o(com.hp.hpl.sparta.xpath.d dVar) throws XPathException {
            this.f37380a.O(dVar.b(), "something");
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void p(v vVar) throws XPathException {
            this.f37380a.x(new r(vVar.b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void g(Writer writer, String str) throws IOException {
        int length = str.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            String str2 = charAt >= '\u0080' ? "&#" + ((int) charAt) + ";" : charAt != '\"' ? charAt != '<' ? charAt != '>' ? charAt != '&' ? charAt != '\'' ? null : "&#39;" : "&amp;" : "&gt;" : "&lt;" : "&quot;";
            if (str2 != null) {
                writer.write(str, i4, i5 - i4);
                writer.write(str2);
                i4 = i5 + 1;
            }
        }
        if (i4 < length) {
            writer.write(str, i4, length - i4);
        }
    }

    protected abstract int a();

    public Object b() {
        return this.f37378e;
    }

    public i c() {
        return this.f37377d;
    }

    public abstract Object clone();

    public e d() {
        return this.f37374a;
    }

    public g e() {
        return this.f37375b;
    }

    public i f() {
        return this.f37376c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(i iVar) {
        this.f37376c = iVar;
        if (iVar != null) {
            iVar.f37377d = this;
        }
    }

    public int hashCode() {
        if (this.f37379f == 0) {
            this.f37379f = a();
        }
        return this.f37379f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g i(g gVar, t tVar, String str) throws ParseException, XPathException {
        com.hp.hpl.sparta.xpath.o a4 = tVar.a();
        if (a4 instanceof com.hp.hpl.sparta.xpath.m) {
            String c4 = ((com.hp.hpl.sparta.xpath.m) a4).c();
            g gVar2 = new g(c4);
            tVar.b().a(new a(gVar2, gVar, str, c4));
            return gVar2;
        }
        throw new ParseException("\"" + a4 + "\" in \"" + str + "\" is not an element test");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f37379f = 0;
        e eVar = this.f37374a;
        if (eVar != null) {
            eVar.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        i iVar = this.f37376c;
        if (iVar != null) {
            iVar.f37377d = this.f37377d;
        }
        i iVar2 = this.f37377d;
        if (iVar2 != null) {
            iVar2.f37376c = iVar;
        }
        this.f37377d = null;
        this.f37376c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(i iVar) {
        i iVar2 = this.f37376c;
        if (iVar2 != null) {
            iVar2.f37377d = iVar;
        }
        i iVar3 = this.f37377d;
        if (iVar3 != null) {
            iVar3.f37376c = iVar;
        }
        iVar.f37377d = iVar3;
        iVar.f37376c = this.f37376c;
        this.f37377d = null;
        this.f37376c = null;
    }

    public void m(Object obj) {
        this.f37378e = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(e eVar) {
        this.f37374a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(g gVar) {
        this.f37375b = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void p(Writer writer) throws IOException;

    public String q() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        r(outputStreamWriter);
        outputStreamWriter.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void r(Writer writer) throws IOException;

    public abstract g s(String str) throws ParseException;

    public abstract Enumeration t(String str) throws ParseException;

    public String toString() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
            p(outputStreamWriter);
            outputStreamWriter.flush();
            return new String(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return super.toString();
        }
    }

    public abstract String u(String str) throws ParseException;

    public abstract Enumeration v(String str) throws ParseException;

    public boolean w(String str, String str2) throws ParseException {
        try {
            int lastIndexOf = str.lastIndexOf(47);
            int i4 = lastIndexOf + 1;
            if (!str.substring(i4).equals("text()") && str.charAt(i4) != '@') {
                throw new ParseException("Last step of Xpath expression \"" + str + "\" is not \"text()\" and does not start with a '@'. It starts with a '" + str.charAt(i4) + "'");
            }
            boolean z3 = false;
            String substring = str.substring(0, lastIndexOf);
            if (str.charAt(i4) == '@') {
                String substring2 = str.substring(lastIndexOf + 2);
                if (substring2.length() != 0) {
                    Enumeration t3 = t(substring);
                    while (t3.hasMoreElements()) {
                        g gVar = (g) t3.nextElement();
                        if (!str2.equals(gVar.D(substring2))) {
                            gVar.O(substring2, str2);
                            z3 = true;
                        }
                    }
                    return z3;
                }
                throw new ParseException("Xpath expression \"" + str + "\" specifies zero-length attribute name\"");
            }
            Enumeration t4 = t(substring);
            boolean hasMoreElements = t4.hasMoreElements();
            while (t4.hasMoreElements()) {
                g gVar2 = (g) t4.nextElement();
                Vector vector = new Vector();
                for (i F = gVar2.F(); F != null; F = F.c()) {
                    if (F instanceof r) {
                        vector.addElement((r) F);
                    }
                }
                if (vector.size() == 0) {
                    r rVar = new r(str2);
                    if (rVar.A().length() > 0) {
                        gVar2.x(rVar);
                        hasMoreElements = true;
                    }
                } else {
                    r rVar2 = (r) vector.elementAt(0);
                    if (!rVar2.A().equals(str2)) {
                        vector.removeElementAt(0);
                        rVar2.B(str2);
                        hasMoreElements = true;
                    }
                    int i5 = 0;
                    while (i5 < vector.size()) {
                        gVar2.J((r) vector.elementAt(i5));
                        i5++;
                        hasMoreElements = true;
                    }
                }
            }
            return hasMoreElements;
        } catch (DOMException e4) {
            throw new Error("Assertion failed " + e4);
        } catch (IndexOutOfBoundsException unused) {
            throw new ParseException("Xpath expression \"" + str + "\" is not in the form \"xpathExpression/@attributeName\"");
        }
    }
}
