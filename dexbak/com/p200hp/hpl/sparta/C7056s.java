package com.p200hp.hpl.sparta;

import com.p200hp.hpl.sparta.xpath.AllElementTest;
import com.p200hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.p200hp.hpl.sparta.xpath.AttrExistsExpr;
import com.p200hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.p200hp.hpl.sparta.xpath.AttrLessExpr;
import com.p200hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.p200hp.hpl.sparta.xpath.AttrTest;
import com.p200hp.hpl.sparta.xpath.BooleanExpr;
import com.p200hp.hpl.sparta.xpath.ElementTest;
import com.p200hp.hpl.sparta.xpath.ParentNodeTest;
import com.p200hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.p200hp.hpl.sparta.xpath.Step;
import com.p200hp.hpl.sparta.xpath.TextEqualsExpr;
import com.p200hp.hpl.sparta.xpath.TextExistsExpr;
import com.p200hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.p200hp.hpl.sparta.xpath.TextTest;
import com.p200hp.hpl.sparta.xpath.ThisNodeTest;
import com.p200hp.hpl.sparta.xpath.TrueExpr;
import com.p200hp.hpl.sparta.xpath.Visitor;
import com.p200hp.hpl.sparta.xpath.XPath;
import com.p200hp.hpl.sparta.xpath.XPathException;
import java.util.Enumeration;
import java.util.Vector;

/* compiled from: XPathVisitor.java */
/* renamed from: com.hp.hpl.sparta.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
class C7056s implements Visitor {

    /* renamed from: i */
    private static final Boolean f23946i = new Boolean(true);

    /* renamed from: j */
    private static final Boolean f23947j = new Boolean(false);

    /* renamed from: a */
    private final XPathVisitor f23948a;

    /* renamed from: b */
    private Vector f23949b;

    /* renamed from: c */
    private Enumeration f23950c;

    /* renamed from: d */
    private Object f23951d;

    /* renamed from: e */
    private final C7058b f23952e;

    /* renamed from: f */
    private Node f23953f;

    /* renamed from: g */
    private boolean f23954g;

    /* renamed from: h */
    private XPath f23955h;

    /* compiled from: XPathVisitor.java */
    /* renamed from: com.hp.hpl.sparta.s$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class C7058b {

        /* renamed from: a */
        private C7059a f23956a;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: XPathVisitor.java */
        /* renamed from: com.hp.hpl.sparta.s$b$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C7059a {

            /* renamed from: a */
            final Boolean f23957a;

            /* renamed from: b */
            final C7059a f23958b;

            C7059a(Boolean bool, C7059a c7059a) {
                this.f23957a = bool;
                this.f23958b = c7059a;
            }
        }

        private C7058b() {
            this.f23956a = null;
        }

        /* renamed from: a */
        Boolean m35099a() {
            C7059a c7059a = this.f23956a;
            Boolean bool = c7059a.f23957a;
            this.f23956a = c7059a.f23958b;
            return bool;
        }

        /* renamed from: b */
        void m35098b(Boolean bool) {
            this.f23956a = new C7059a(bool, this.f23956a);
        }
    }

    private C7056s(XPath xPath, Node node) throws XPathException {
        this.f23948a = new XPathVisitor();
        this.f23949b = new Vector();
        this.f23950c = null;
        this.f23951d = null;
        this.f23952e = new C7058b();
        this.f23955h = xPath;
        this.f23953f = node;
        Vector vector = new Vector(1);
        this.f23949b = vector;
        vector.addElement(this.f23953f);
        Enumeration m35090f = xPath.m35090f();
        while (m35090f.hasMoreElements()) {
            Step step = (Step) m35090f.nextElement();
            this.f23954g = step.m35057c();
            this.f23950c = null;
            step.m35059a().mo35052a(this);
            this.f23950c = this.f23948a.m35230d();
            this.f23949b.removeAllElements();
            BooleanExpr m35058b = step.m35058b();
            while (this.f23950c.hasMoreElements()) {
                this.f23951d = this.f23950c.nextElement();
                m35058b.mo35053a(this);
                if (this.f23952e.m35099a().booleanValue()) {
                    this.f23949b.addElement(this.f23951d);
                }
            }
        }
    }

    /* renamed from: q */
    private void m35106q(Document document) {
        Element m35275z = document.m35275z();
        this.f23948a.m35233a(m35275z, 1);
        if (this.f23954g) {
            m35105r(m35275z);
        }
    }

    /* renamed from: r */
    private void m35105r(Element element) {
        int i = 0;
        for (Node m35265F = element.m35265F(); m35265F != null; m35265F = m35265F.m35248c()) {
            if (m35265F instanceof Element) {
                i++;
                this.f23948a.m35233a(m35265F, i);
                if (this.f23954g) {
                    m35105r((Element) m35265F);
                }
            }
        }
    }

    /* renamed from: s */
    private void m35104s(Document document, String str) {
        Element m35275z = document.m35275z();
        if (m35275z == null) {
            return;
        }
        if (m35275z.m35263H() == str) {
            this.f23948a.m35233a(m35275z, 1);
        }
        if (this.f23954g) {
            m35103t(m35275z, str);
        }
    }

    /* renamed from: t */
    private void m35103t(Element element, String str) {
        int i = 0;
        for (Node m35265F = element.m35265F(); m35265F != null; m35265F = m35265F.m35248c()) {
            if (m35265F instanceof Element) {
                Element element2 = (Element) m35265F;
                if (element2.m35263H() == str) {
                    i++;
                    this.f23948a.m35233a(element2, i);
                }
                if (this.f23954g) {
                    m35103t(element2, str);
                }
            }
        }
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: a */
    public void mo35082a(TrueExpr trueExpr) {
        this.f23952e.m35098b(f23946i);
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTestVisitor
    /* renamed from: b */
    public void mo35070b(AttrTest attrTest) {
        String m35267D;
        Vector vector = this.f23949b;
        this.f23948a.m35228f();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Node node = (Node) elements.nextElement();
            if ((node instanceof Element) && (m35267D = ((Element) node).m35267D(attrTest.m35083c())) != null) {
                this.f23948a.m35232b(m35267D);
            }
        }
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTestVisitor
    /* renamed from: c */
    public void mo35069c(ThisNodeTest thisNodeTest) {
        this.f23948a.m35228f();
        this.f23948a.m35233a(this.f23953f, 1);
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: d */
    public void mo35081d(TextNotEqualsExpr textNotEqualsExpr) throws XPathException {
        Object obj = this.f23951d;
        if (obj instanceof Element) {
            for (Node m35265F = ((Element) obj).m35265F(); m35265F != null; m35265F = m35265F.m35248c()) {
                if ((m35265F instanceof Text) && !((Text) m35265F).m35118A().equals(textNotEqualsExpr.m35055b())) {
                    this.f23952e.m35098b(f23946i);
                    return;
                }
            }
            this.f23952e.m35098b(f23947j);
            return;
        }
        throw new XPathException(this.f23955h, "Cannot test attribute of document");
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: e */
    public void mo35080e(PositionEqualsExpr positionEqualsExpr) throws XPathException {
        Object obj = this.f23951d;
        if (obj instanceof Element) {
            this.f23952e.m35098b(this.f23948a.m35229e((Element) obj) == positionEqualsExpr.m35064b() ? f23946i : f23947j);
            return;
        }
        throw new XPathException(this.f23955h, "Cannot test position of document");
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: f */
    public void mo35079f(AttrNotEqualsExpr attrNotEqualsExpr) throws XPathException {
        Object obj = this.f23951d;
        if (obj instanceof Element) {
            this.f23952e.m35098b(attrNotEqualsExpr.m35097c().equals(((Element) obj).m35267D(attrNotEqualsExpr.m35086b())) ^ true ? f23946i : f23947j);
            return;
        }
        throw new XPathException(this.f23955h, "Cannot test attribute of document");
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: g */
    public void mo35078g(TextExistsExpr textExistsExpr) throws XPathException {
        Object obj = this.f23951d;
        if (obj instanceof Element) {
            for (Node m35265F = ((Element) obj).m35265F(); m35265F != null; m35265F = m35265F.m35248c()) {
                if (m35265F instanceof Text) {
                    this.f23952e.m35098b(f23946i);
                    return;
                }
            }
            this.f23952e.m35098b(f23947j);
            return;
        }
        throw new XPathException(this.f23955h, "Cannot test attribute of document");
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTestVisitor
    /* renamed from: h */
    public void mo35068h(ElementTest elementTest) {
        String m35072c = elementTest.m35072c();
        Vector vector = this.f23949b;
        int size = vector.size();
        this.f23948a.m35228f();
        for (int i = 0; i < size; i++) {
            Object elementAt = vector.elementAt(i);
            if (elementAt instanceof Element) {
                m35103t((Element) elementAt, m35072c);
            } else if (elementAt instanceof Document) {
                m35104s((Document) elementAt, m35072c);
            }
        }
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: i */
    public void mo35077i(AttrGreaterExpr attrGreaterExpr) throws XPathException {
        Object obj = this.f23951d;
        if (obj instanceof Element) {
            this.f23952e.m35098b((((double) Long.parseLong(((Element) obj).m35267D(attrGreaterExpr.m35086b()))) > attrGreaterExpr.m35085c() ? 1 : (((double) Long.parseLong(((Element) obj).m35267D(attrGreaterExpr.m35086b()))) == attrGreaterExpr.m35085c() ? 0 : -1)) > 0 ? f23946i : f23947j);
            return;
        }
        throw new XPathException(this.f23955h, "Cannot test attribute of document");
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: j */
    public void mo35076j(AttrEqualsExpr attrEqualsExpr) throws XPathException {
        Object obj = this.f23951d;
        if (obj instanceof Element) {
            this.f23952e.m35098b(attrEqualsExpr.m35097c().equals(((Element) obj).m35267D(attrEqualsExpr.m35086b())) ? f23946i : f23947j);
            return;
        }
        throw new XPathException(this.f23955h, "Cannot test attribute of document");
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTestVisitor
    /* renamed from: k */
    public void mo35067k(AllElementTest allElementTest) {
        Vector vector = this.f23949b;
        this.f23948a.m35228f();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Element) {
                m35105r((Element) nextElement);
            } else if (nextElement instanceof Document) {
                m35106q((Document) nextElement);
            }
        }
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTestVisitor
    /* renamed from: l */
    public void mo35066l(TextTest textTest) {
        Vector vector = this.f23949b;
        this.f23948a.m35228f();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Element) {
                for (Node m35265F = ((Element) nextElement).m35265F(); m35265F != null; m35265F = m35265F.m35248c()) {
                    if (m35265F instanceof Text) {
                        this.f23948a.m35232b(((Text) m35265F).m35118A());
                    }
                }
            }
        }
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: m */
    public void mo35075m(AttrLessExpr attrLessExpr) throws XPathException {
        Object obj = this.f23951d;
        if (obj instanceof Element) {
            this.f23952e.m35098b((((double) Long.parseLong(((Element) obj).m35267D(attrLessExpr.m35086b()))) > attrLessExpr.m35085c() ? 1 : (((double) Long.parseLong(((Element) obj).m35267D(attrLessExpr.m35086b()))) == attrLessExpr.m35085c() ? 0 : -1)) < 0 ? f23946i : f23947j);
            return;
        }
        throw new XPathException(this.f23955h, "Cannot test attribute of document");
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTestVisitor
    /* renamed from: n */
    public void mo35065n(ParentNodeTest parentNodeTest) throws XPathException {
        this.f23948a.m35228f();
        Element m35246e = this.f23953f.m35246e();
        if (m35246e != null) {
            this.f23948a.m35233a(m35246e, 1);
            return;
        }
        throw new XPathException(this.f23955h, "Illegal attempt to apply \"..\" to node with no parent.");
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: o */
    public void mo35074o(AttrExistsExpr attrExistsExpr) throws XPathException {
        Object obj = this.f23951d;
        if (obj instanceof Element) {
            String m35267D = ((Element) obj).m35267D(attrExistsExpr.m35086b());
            this.f23952e.m35098b(m35267D != null && m35267D.length() > 0 ? f23946i : f23947j);
            return;
        }
        throw new XPathException(this.f23955h, "Cannot test attribute of document");
    }

    @Override // com.p200hp.hpl.sparta.xpath.BooleanExprVisitor
    /* renamed from: p */
    public void mo35073p(TextEqualsExpr textEqualsExpr) throws XPathException {
        Object obj = this.f23951d;
        if (obj instanceof Element) {
            for (Node m35265F = ((Element) obj).m35265F(); m35265F != null; m35265F = m35265F.m35248c()) {
                if ((m35265F instanceof Text) && ((Text) m35265F).m35118A().equals(textEqualsExpr.m35055b())) {
                    this.f23952e.m35098b(f23946i);
                    return;
                }
            }
            this.f23952e.m35098b(f23947j);
            return;
        }
        throw new XPathException(this.f23955h, "Cannot test attribute of document");
    }

    /* renamed from: u */
    public Element m35102u() {
        if (this.f23949b.size() == 0) {
            return null;
        }
        return (Element) this.f23949b.elementAt(0);
    }

    /* renamed from: v */
    public String m35101v() {
        if (this.f23949b.size() == 0) {
            return null;
        }
        return this.f23949b.elementAt(0).toString();
    }

    /* renamed from: w */
    public Enumeration m35100w() {
        return this.f23949b.elements();
    }

    public C7056s(Element element, XPath xPath) throws XPathException {
        this(xPath, element);
        if (xPath.m35089g()) {
            throw new XPathException(xPath, "Cannot use element as context node for absolute xpath");
        }
    }

    public C7056s(Document document, XPath xPath) throws XPathException {
        this(xPath, document);
    }
}
