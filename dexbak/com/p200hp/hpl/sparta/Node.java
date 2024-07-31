package com.p200hp.hpl.sparta;

import com.p200hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.p200hp.hpl.sparta.xpath.AttrExistsExpr;
import com.p200hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.p200hp.hpl.sparta.xpath.AttrLessExpr;
import com.p200hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.p200hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.p200hp.hpl.sparta.xpath.ElementTest;
import com.p200hp.hpl.sparta.xpath.NodeTest;
import com.p200hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.p200hp.hpl.sparta.xpath.Step;
import com.p200hp.hpl.sparta.xpath.TextEqualsExpr;
import com.p200hp.hpl.sparta.xpath.TextExistsExpr;
import com.p200hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.p200hp.hpl.sparta.xpath.TrueExpr;
import com.p200hp.hpl.sparta.xpath.XPath;
import com.p200hp.hpl.sparta.xpath.XPathException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class Node {

    /* renamed from: a */
    private Document f23872a = null;

    /* renamed from: b */
    private Element f23873b = null;

    /* renamed from: c */
    private Node f23874c = null;

    /* renamed from: d */
    private Node f23875d = null;

    /* renamed from: e */
    private Object f23876e = null;

    /* renamed from: f */
    private int f23877f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Node.java */
    /* renamed from: com.hp.hpl.sparta.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C7047a implements BooleanExprVisitor {

        /* renamed from: a */
        final /* synthetic */ Element f23878a;

        /* renamed from: b */
        final /* synthetic */ Element f23879b;

        /* renamed from: c */
        final /* synthetic */ String f23880c;

        /* renamed from: d */
        final /* synthetic */ String f23881d;

        C7047a(Element element, Element element2, String str, String str2) {
            this.f23878a = element;
            this.f23879b = element2;
            this.f23880c = str;
            this.f23881d = str2;
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: a */
        public void mo35082a(TrueExpr trueExpr) {
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: d */
        public void mo35081d(TextNotEqualsExpr textNotEqualsExpr) throws XPathException {
            Element element = this.f23878a;
            element.m35252x(new Text("not " + textNotEqualsExpr.m35055b()));
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: e */
        public void mo35080e(PositionEqualsExpr positionEqualsExpr) throws XPathException {
            int m35064b = positionEqualsExpr.m35064b();
            if (this.f23879b == null && m35064b != 1) {
                throw new XPathException(XPath.m35094b(this.f23880c), "Position of root node must be 1");
            }
            for (int i = 1; i < m35064b; i++) {
                this.f23879b.m35252x(new Element(this.f23881d));
            }
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: f */
        public void mo35079f(AttrNotEqualsExpr attrNotEqualsExpr) throws XPathException {
            Element element = this.f23878a;
            String m35086b = attrNotEqualsExpr.m35086b();
            element.m35256O(m35086b, "not " + attrNotEqualsExpr.m35097c());
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: g */
        public void mo35078g(TextExistsExpr textExistsExpr) throws XPathException {
            this.f23878a.m35252x(new Text("something"));
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: i */
        public void mo35077i(AttrGreaterExpr attrGreaterExpr) throws XPathException {
            this.f23878a.m35256O(attrGreaterExpr.m35086b(), Long.toString(Long.MAX_VALUE));
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: j */
        public void mo35076j(AttrEqualsExpr attrEqualsExpr) throws XPathException {
            this.f23878a.m35256O(attrEqualsExpr.m35086b(), attrEqualsExpr.m35097c());
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: m */
        public void mo35075m(AttrLessExpr attrLessExpr) throws XPathException {
            this.f23878a.m35256O(attrLessExpr.m35086b(), Long.toString(Long.MIN_VALUE));
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: o */
        public void mo35074o(AttrExistsExpr attrExistsExpr) throws XPathException {
            this.f23878a.m35256O(attrExistsExpr.m35086b(), "something");
        }

        @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
        /* renamed from: p */
        public void mo35073p(TextEqualsExpr textEqualsExpr) throws XPathException {
            this.f23878a.m35252x(new Text(textEqualsExpr.m35055b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public static void m35244g(Writer writer, String str) throws IOException {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String str2 = charAt >= 128 ? "&#" + ((int) charAt) + ";" : charAt != '\"' ? charAt != '<' ? charAt != '>' ? charAt != '&' ? charAt != '\'' ? null : "&#39;" : "&amp;" : "&gt;" : "&lt;" : "&quot;";
            if (str2 != null) {
                writer.write(str, i, i2 - i);
                writer.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            writer.write(str, i, length - i);
        }
    }

    /* renamed from: a */
    protected abstract int mo35116a();

    /* renamed from: b */
    public Object m35249b() {
        return this.f23876e;
    }

    /* renamed from: c */
    public Node m35248c() {
        return this.f23875d;
    }

    public abstract Object clone();

    /* renamed from: d */
    public Document m35247d() {
        return this.f23872a;
    }

    /* renamed from: e */
    public Element m35246e() {
        return this.f23873b;
    }

    /* renamed from: f */
    public Node m35245f() {
        return this.f23874c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public void m35243h(Node node) {
        this.f23874c = node;
        if (node != null) {
            node.f23875d = this;
        }
    }

    public int hashCode() {
        if (this.f23877f == 0) {
            this.f23877f = mo35116a();
        }
        return this.f23877f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public Element m35242i(Element element, Step step, String str) throws ParseException, XPathException {
        NodeTest m35059a = step.m35059a();
        if (m35059a instanceof ElementTest) {
            String m35072c = ((ElementTest) m35059a).m35072c();
            Element element2 = new Element(m35072c);
            step.m35058b().mo35053a(new C7047a(element2, element, str, m35072c));
            return element2;
        }
        throw new ParseException("\"" + m35059a + "\" in \"" + str + "\" is not an element test");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo35241j() {
        this.f23877f = 0;
        Document document = this.f23872a;
        if (document != null) {
            document.mo35241j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m35240k() {
        Node node = this.f23874c;
        if (node != null) {
            node.f23875d = this.f23875d;
        }
        Node node2 = this.f23875d;
        if (node2 != null) {
            node2.f23874c = node;
        }
        this.f23875d = null;
        this.f23874c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void m35239l(Node node) {
        Node node2 = this.f23874c;
        if (node2 != null) {
            node2.f23875d = node;
        }
        Node node3 = this.f23875d;
        if (node3 != null) {
            node3.f23874c = node;
        }
        node.f23875d = node3;
        node.f23874c = this.f23874c;
        this.f23875d = null;
        this.f23874c = null;
    }

    /* renamed from: m */
    public void m35238m(Object obj) {
        this.f23876e = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public void m35237n(Document document) {
        this.f23872a = document;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public void m35236o(Element element) {
        this.f23873b = element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public abstract void mo35115p(Writer writer) throws IOException;

    /* renamed from: q */
    public String m35235q() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        mo35114r(outputStreamWriter);
        outputStreamWriter.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public abstract void mo35114r(Writer writer) throws IOException;

    /* renamed from: s */
    public abstract Element mo35113s(String str) throws ParseException;

    /* renamed from: t */
    public abstract Enumeration mo35112t(String str) throws ParseException;

    public String toString() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
            mo35115p(outputStreamWriter);
            outputStreamWriter.flush();
            return new String(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return super.toString();
        }
    }

    /* renamed from: u */
    public abstract String mo35111u(String str) throws ParseException;

    /* renamed from: v */
    public abstract Enumeration mo35110v(String str) throws ParseException;

    /* renamed from: w */
    public boolean m35234w(String str, String str2) throws ParseException {
        try {
            int lastIndexOf = str.lastIndexOf(47);
            int i = lastIndexOf + 1;
            if (!str.substring(i).equals("text()") && str.charAt(i) != '@') {
                throw new ParseException("Last step of Xpath expression \"" + str + "\" is not \"text()\" and does not start with a '@'. It starts with a '" + str.charAt(i) + "'");
            }
            boolean z = false;
            String substring = str.substring(0, lastIndexOf);
            if (str.charAt(i) == '@') {
                String substring2 = str.substring(lastIndexOf + 2);
                if (substring2.length() != 0) {
                    Enumeration mo35112t = mo35112t(substring);
                    while (mo35112t.hasMoreElements()) {
                        Element element = (Element) mo35112t.nextElement();
                        if (!str2.equals(element.m35267D(substring2))) {
                            element.m35256O(substring2, str2);
                            z = true;
                        }
                    }
                    return z;
                }
                throw new ParseException("Xpath expression \"" + str + "\" specifies zero-length attribute name\"");
            }
            Enumeration mo35112t2 = mo35112t(substring);
            boolean hasMoreElements = mo35112t2.hasMoreElements();
            while (mo35112t2.hasMoreElements()) {
                Element element2 = (Element) mo35112t2.nextElement();
                Vector vector = new Vector();
                for (Node m35265F = element2.m35265F(); m35265F != null; m35265F = m35265F.m35248c()) {
                    if (m35265F instanceof Text) {
                        vector.addElement((Text) m35265F);
                    }
                }
                if (vector.size() == 0) {
                    Text text = new Text(str2);
                    if (text.m35118A().length() > 0) {
                        element2.m35252x(text);
                        hasMoreElements = true;
                    }
                } else {
                    Text text2 = (Text) vector.elementAt(0);
                    if (!text2.m35118A().equals(str2)) {
                        vector.removeElementAt(0);
                        text2.m35117B(str2);
                        hasMoreElements = true;
                    }
                    int i2 = 0;
                    while (i2 < vector.size()) {
                        element2.m35261J((Text) vector.elementAt(i2));
                        i2++;
                        hasMoreElements = true;
                    }
                }
            }
            return hasMoreElements;
        } catch (DOMException e) {
            throw new Error("Assertion failed " + e);
        } catch (IndexOutOfBoundsException unused) {
            throw new ParseException("Xpath expression \"" + str + "\" is not in the form \"xpathExpression/@attributeName\"");
        }
    }
}
