package com.p200hp.hpl.sparta;

import com.p200hp.hpl.sparta.Sparta;
import com.p200hp.hpl.sparta.xpath.Step;
import com.p200hp.hpl.sparta.xpath.XPath;
import com.p200hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Document extends Node {

    /* renamed from: l */
    private static final boolean f23854l = false;

    /* renamed from: m */
    private static final Integer f23855m = new Integer(1);

    /* renamed from: n */
    static final Enumeration f23856n = new C7046h();

    /* renamed from: g */
    private Element f23857g;

    /* renamed from: h */
    private String f23858h;

    /* renamed from: i */
    private Sparta.InterfaceC7052c f23859i;

    /* renamed from: j */
    private Vector f23860j;

    /* renamed from: k */
    private final Hashtable f23861k;

    /* compiled from: Document.java */
    /* renamed from: com.hp.hpl.sparta.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C7044a implements InterfaceC7045b {

        /* renamed from: a */
        private transient Sparta.InterfaceC7052c f23862a = null;

        /* renamed from: b */
        private final XPath f23863b;

        /* renamed from: c */
        private final String f23864c;

        C7044a(XPath xPath) throws XPathException {
            this.f23864c = xPath.m35092d();
            this.f23863b = xPath;
            Document.this.m35277x(this);
        }

        /* renamed from: b */
        private void m35273b() throws ParseException {
            try {
                this.f23862a = Sparta.m35123b();
                Enumeration m35100w = Document.this.m35282E(this.f23863b, false).m35100w();
                while (m35100w.hasMoreElements()) {
                    Element element = (Element) m35100w.nextElement();
                    String m35267D = element.m35267D(this.f23864c);
                    Vector vector = (Vector) this.f23862a.get(m35267D);
                    if (vector == null) {
                        vector = new Vector(1);
                        this.f23862a.put(m35267D, vector);
                    }
                    vector.addElement(element);
                }
            } catch (XPathException e) {
                throw new ParseException("XPath problem", e);
            }
        }

        /* renamed from: a */
        public synchronized Enumeration m35274a(String str) throws ParseException {
            Vector vector;
            if (this.f23862a == null) {
                m35273b();
            }
            vector = (Vector) this.f23862a.get(str);
            return vector == null ? Document.f23856n : vector.elements();
        }

        /* renamed from: c */
        public synchronized int m35272c() throws ParseException {
            if (this.f23862a == null) {
                m35273b();
            }
            return this.f23862a.size();
        }

        @Override // com.p200hp.hpl.sparta.Document.InterfaceC7045b
        public synchronized void update(Document document) {
            this.f23862a = null;
        }
    }

    /* compiled from: Document.java */
    /* renamed from: com.hp.hpl.sparta.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7045b {
        void update(Document document);
    }

    Document(String str) {
        this.f23857g = null;
        this.f23859i = Sparta.m35123b();
        this.f23860j = new Vector();
        this.f23861k = null;
        this.f23858h = str;
    }

    /* renamed from: F */
    private C7056s m35281F(String str, boolean z) throws XPathException {
        if (str.charAt(0) != '/') {
            str = "/" + str;
        }
        return m35282E(XPath.m35094b(str), z);
    }

    /* renamed from: A */
    public String m35286A() {
        return this.f23858h;
    }

    /* renamed from: B */
    void m35285B(XPath xPath) throws XPathException {
    }

    /* renamed from: C */
    public void m35284C(Element element) {
        this.f23857g = element;
        element.m35237n(this);
        mo35241j();
    }

    /* renamed from: D */
    public void m35283D(String str) {
        this.f23858h = str;
        mo35241j();
    }

    /* renamed from: E */
    C7056s m35282E(XPath xPath, boolean z) throws XPathException {
        if (xPath.m35088h() != z) {
            String str = z ? "evaluates to element not string" : "evaluates to string not element";
            throw new XPathException(xPath, "\"" + xPath + "\" evaluates to " + str);
        }
        return new C7056s(this, xPath);
    }

    /* renamed from: G */
    public boolean m35280G(String str) throws ParseException {
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
            Enumeration m35090f2 = m35094b.m35090f();
            Step step = (Step) m35090f2.nextElement();
            int i2 = i - 1;
            Step[] stepArr = new Step[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                stepArr[i3] = (Step) m35090f2.nextElement();
            }
            if (this.f23857g == null) {
                m35284C(m35242i(null, step, str));
            } else {
                if (mo35113s("/" + step) == null) {
                    throw new ParseException("Existing root element <" + this.f23857g.m35263H() + "...> does not match first step \"" + step + "\" of \"" + str);
                }
            }
            if (i2 == 0) {
                return true;
            }
            return this.f23857g.m35253R(XPath.m35093c(false, stepArr).toString());
        } catch (XPathException e) {
            throw new ParseException(str, e);
        }
    }

    /* renamed from: H */
    public C7044a m35279H(String str) throws ParseException {
        try {
            C7044a c7044a = (C7044a) this.f23859i.get(str);
            if (c7044a == null) {
                C7044a c7044a2 = new C7044a(XPath.m35094b(str));
                this.f23859i.put(str, c7044a2);
                return c7044a2;
            }
            return c7044a;
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    /* renamed from: I */
    public boolean m35278I(String str) {
        return this.f23859i.get(str) != null;
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: a */
    protected int mo35116a() {
        return this.f23857g.hashCode();
    }

    @Override // com.p200hp.hpl.sparta.Node
    public Object clone() {
        Document document = new Document(this.f23858h);
        document.f23857g = (Element) this.f23857g.clone();
        return document;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Document) {
            return this.f23857g.equals(((Document) obj).f23857g);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: j */
    public void mo35241j() {
        Enumeration elements = this.f23860j.elements();
        while (elements.hasMoreElements()) {
            ((InterfaceC7045b) elements.nextElement()).update(this);
        }
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: p */
    public void mo35115p(Writer writer) throws IOException {
        this.f23857g.mo35115p(writer);
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: r */
    public void mo35114r(Writer writer) throws IOException {
        writer.write("<?xml version=\"1.0\" ?>\n");
        this.f23857g.mo35114r(writer);
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: s */
    public Element mo35113s(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            XPath m35094b = XPath.m35094b(str);
            m35285B(m35094b);
            return m35282E(m35094b, false).m35102u();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: t */
    public Enumeration mo35112t(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            XPath m35094b = XPath.m35094b(str);
            m35285B(m35094b);
            return m35282E(m35094b, false).m35100w();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.p200hp.hpl.sparta.Node
    public String toString() {
        return this.f23858h;
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: u */
    public String mo35111u(String str) throws ParseException {
        try {
            return m35281F(str, true).m35101v();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: v */
    public Enumeration mo35110v(String str) throws ParseException {
        try {
            return m35281F(str, true).m35100w();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    /* renamed from: x */
    public void m35277x(InterfaceC7045b interfaceC7045b) {
        this.f23860j.addElement(interfaceC7045b);
    }

    /* renamed from: y */
    public void m35276y(InterfaceC7045b interfaceC7045b) {
        this.f23860j.removeElement(interfaceC7045b);
    }

    /* renamed from: z */
    public Element m35275z() {
        return this.f23857g;
    }

    public Document() {
        this.f23857g = null;
        this.f23859i = Sparta.m35123b();
        this.f23860j = new Vector();
        this.f23861k = null;
        this.f23858h = "MEMORY";
    }
}
