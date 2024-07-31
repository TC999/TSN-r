package com.p200hp.hpl.sparta;

import com.p200hp.hpl.sparta.xpath.Step;
import com.p200hp.hpl.sparta.xpath.XPath;
import com.p200hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Element extends Node {

    /* renamed from: l */
    private static final boolean f23866l = false;

    /* renamed from: g */
    private Node f23867g;

    /* renamed from: h */
    private Node f23868h;

    /* renamed from: i */
    private Hashtable f23869i;

    /* renamed from: j */
    private Vector f23870j;

    /* renamed from: k */
    private String f23871k;

    public Element(String str) {
        this.f23867g = null;
        this.f23868h = null;
        this.f23869i = null;
        this.f23870j = null;
        this.f23871k = null;
        this.f23871k = Sparta.m35124a(str);
    }

    /* renamed from: A */
    private void m35270A() {
    }

    /* renamed from: K */
    private boolean m35260K(Node node) {
        for (Node node2 = this.f23867g; node2 != null; node2 = node2.m35248c()) {
            if (node2.equals(node)) {
                if (this.f23867g == node2) {
                    this.f23867g = node2.m35248c();
                }
                if (this.f23868h == node2) {
                    this.f23868h = node2.m35245f();
                }
                node2.m35240k();
                node2.m35236o(null);
                node2.m35237n(null);
                return true;
            }
        }
        return false;
    }

    /* renamed from: N */
    private void m35257N(Node node, Node node2) throws DOMException {
        for (Node node3 = this.f23867g; node3 != null; node3 = node3.m35248c()) {
            if (node3 == node2) {
                if (this.f23867g == node2) {
                    this.f23867g = node;
                }
                if (this.f23868h == node2) {
                    this.f23868h = node;
                }
                node2.m35239l(node);
                node.m35236o(this);
                node2.m35236o(null);
                return;
            }
        }
        throw new DOMException((short) 8, "Cannot find " + node2 + " in " + this);
    }

    /* renamed from: Q */
    private C7056s m35254Q(String str, boolean z) throws XPathException {
        XPath m35094b = XPath.m35094b(str);
        if (m35094b.m35088h() != z) {
            String str2 = z ? "evaluates to element not string" : "evaluates to string not element";
            throw new XPathException(m35094b, "\"" + m35094b + "\" evaluates to " + str2);
        }
        return new C7056s(this, m35094b);
    }

    /* renamed from: B */
    public Element m35269B(boolean z) {
        Element element = new Element(this.f23871k);
        Vector vector = this.f23870j;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                element.m35256O(str, (String) this.f23869i.get(str));
            }
        }
        if (z) {
            for (Node node = this.f23867g; node != null; node = node.m35248c()) {
                element.m35252x((Node) node.clone());
            }
        }
        return element;
    }

    /* renamed from: C */
    public Element m35268C() {
        return m35269B(false);
    }

    /* renamed from: D */
    public String m35267D(String str) {
        Hashtable hashtable = this.f23869i;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str);
    }

    /* renamed from: E */
    public Enumeration m35266E() {
        Vector vector = this.f23870j;
        if (vector == null) {
            return Document.f23856n;
        }
        return vector.elements();
    }

    /* renamed from: F */
    public Node m35265F() {
        return this.f23867g;
    }

    /* renamed from: G */
    public Node m35264G() {
        return this.f23868h;
    }

    /* renamed from: H */
    public String m35263H() {
        return this.f23871k;
    }

    /* renamed from: I */
    public void m35262I(String str) {
        Hashtable hashtable = this.f23869i;
        if (hashtable == null) {
            return;
        }
        hashtable.remove(str);
        this.f23870j.removeElement(str);
        mo35241j();
    }

    /* renamed from: J */
    public void m35261J(Node node) throws DOMException {
        if (m35260K(node)) {
            mo35241j();
            return;
        }
        throw new DOMException((short) 8, "Cannot find " + node + " in " + this);
    }

    /* renamed from: L */
    public void m35259L(Element element, Node node) throws DOMException {
        m35257N(element, node);
        mo35241j();
    }

    /* renamed from: M */
    public void m35258M(Text text, Node node) throws DOMException {
        m35257N(text, node);
        mo35241j();
    }

    /* renamed from: O */
    public void m35256O(String str, String str2) {
        if (this.f23869i == null) {
            this.f23869i = new Hashtable();
            this.f23870j = new Vector();
        }
        if (this.f23869i.get(str) == null) {
            this.f23870j.addElement(str);
        }
        this.f23869i.put(str, str2);
        mo35241j();
    }

    /* renamed from: P */
    public void m35255P(String str) {
        this.f23871k = Sparta.m35124a(str);
        mo35241j();
    }

    /* renamed from: R */
    public boolean m35253R(String str) throws ParseException {
        Element mo35113s;
        try {
            if (mo35113s(str) != null) {
                return false;
            }
            XPath m35094b = XPath.m35094b(str);
            Enumeration m35090f = m35094b.m35090f();
            int i = 0;
            while (m35090f.hasMoreElements()) {
                m35090f.nextElement();
                i++;
            }
            int i2 = i - 1;
            Step[] stepArr = new Step[i2];
            Enumeration m35090f2 = m35094b.m35090f();
            for (int i3 = 0; i3 < i2; i3++) {
                stepArr[i3] = (Step) m35090f2.nextElement();
            }
            Step step = (Step) m35090f2.nextElement();
            if (i2 == 0) {
                mo35113s = this;
            } else {
                String xPath = XPath.m35093c(m35094b.m35089g(), stepArr).toString();
                m35253R(xPath.toString());
                mo35113s = mo35113s(xPath);
            }
            mo35113s.m35251y(m35242i(mo35113s, step, str));
            return true;
        } catch (XPathException e) {
            throw new ParseException(str, e);
        }
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: a */
    protected int mo35116a() {
        int hashCode = this.f23871k.hashCode();
        Hashtable hashtable = this.f23869i;
        if (hashtable != null) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                hashCode = (((hashCode * 31) + str.hashCode()) * 31) + ((String) this.f23869i.get(str)).hashCode();
            }
        }
        for (Node node = this.f23867g; node != null; node = node.m35248c()) {
            hashCode = (hashCode * 31) + node.hashCode();
        }
        return hashCode;
    }

    @Override // com.p200hp.hpl.sparta.Node
    public Object clone() {
        return m35269B(true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Element) {
            Element element = (Element) obj;
            if (this.f23871k.equals(element.f23871k)) {
                Hashtable hashtable = this.f23869i;
                int size = hashtable == null ? 0 : hashtable.size();
                Hashtable hashtable2 = element.f23869i;
                if (size != (hashtable2 == null ? 0 : hashtable2.size())) {
                    return false;
                }
                Hashtable hashtable3 = this.f23869i;
                if (hashtable3 != null) {
                    Enumeration keys = hashtable3.keys();
                    while (keys.hasMoreElements()) {
                        String str = (String) keys.nextElement();
                        if (!((String) this.f23869i.get(str)).equals((String) element.f23869i.get(str))) {
                            return false;
                        }
                    }
                }
                Node node = this.f23867g;
                Node node2 = element.f23867g;
                while (node != null) {
                    if (!node.equals(node2)) {
                        return false;
                    }
                    node = node.m35248c();
                    node2 = node2.m35248c();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: p */
    public void mo35115p(Writer writer) throws IOException {
        for (Node node = this.f23867g; node != null; node = node.m35248c()) {
            node.mo35115p(writer);
        }
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: r */
    public void mo35114r(Writer writer) throws IOException {
        writer.write("<" + this.f23871k);
        Vector vector = this.f23870j;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                writer.write(" " + str + "=\"");
                Node.m35244g(writer, (String) this.f23869i.get(str));
                writer.write("\"");
            }
        }
        if (this.f23867g == null) {
            writer.write("/>");
            return;
        }
        writer.write(">");
        for (Node node = this.f23867g; node != null; node = node.m35248c()) {
            node.mo35114r(writer);
        }
        writer.write("</" + this.f23871k + ">");
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: s */
    public Element mo35113s(String str) throws ParseException {
        try {
            return m35254Q(str, false).m35102u();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: t */
    public Enumeration mo35112t(String str) throws ParseException {
        try {
            return m35254Q(str, false).m35100w();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: u */
    public String mo35111u(String str) throws ParseException {
        try {
            return m35254Q(str, true).m35101v();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: v */
    public Enumeration mo35110v(String str) throws ParseException {
        try {
            return m35254Q(str, true).m35100w();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    /* renamed from: x */
    public void m35252x(Node node) {
        if (!m35250z(node)) {
            node = (Element) node.clone();
        }
        m35251y(node);
        mo35241j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public void m35251y(Node node) {
        Element m35246e = node.m35246e();
        if (m35246e != null) {
            m35246e.m35260K(node);
        }
        node.m35243h(this.f23868h);
        if (this.f23867g == null) {
            this.f23867g = node;
        }
        node.m35236o(this);
        this.f23868h = node;
        node.m35237n(m35247d());
    }

    /* renamed from: z */
    boolean m35250z(Node node) {
        if (node == this) {
            return false;
        }
        Element m35246e = m35246e();
        if (m35246e == null) {
            return true;
        }
        return m35246e.m35250z(node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element() {
        this.f23867g = null;
        this.f23868h = null;
        this.f23869i = null;
        this.f23870j = null;
        this.f23871k = null;
    }
}
