package com.p200hp.hpl.sparta.xpath;

import com.baidu.mobads.sdk.internal.C2573a;
import java.io.IOException;

/* renamed from: com.hp.hpl.sparta.xpath.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Step {

    /* renamed from: d */
    public static Step f23987d = new Step(ThisNodeTest.f23994a, TrueExpr.f23960a);

    /* renamed from: a */
    private final NodeTest f23988a;

    /* renamed from: b */
    private final BooleanExpr f23989b;

    /* renamed from: c */
    private final boolean f23990c;

    Step(NodeTest nodeTest, BooleanExpr booleanExpr) {
        this.f23988a = nodeTest;
        this.f23989b = booleanExpr;
        this.f23990c = false;
    }

    /* renamed from: a */
    public NodeTest m35059a() {
        return this.f23988a;
    }

    /* renamed from: b */
    public BooleanExpr m35058b() {
        return this.f23989b;
    }

    /* renamed from: c */
    public boolean m35057c() {
        return this.f23990c;
    }

    /* renamed from: d */
    public boolean m35056d() {
        return this.f23988a.mo35051b();
    }

    public String toString() {
        return this.f23988a.toString() + this.f23989b.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Step(XPath xPath, boolean z, SimpleStreamTokenizer simpleStreamTokenizer) throws XPathException, IOException {
        this.f23990c = z;
        int i = simpleStreamTokenizer.f23978a;
        if (i != -3) {
            if (i == 42) {
                this.f23988a = AllElementTest.f23959a;
            } else if (i != 46) {
                if (i == 64) {
                    if (simpleStreamTokenizer.m35063a() == -3) {
                        this.f23988a = new AttrTest(simpleStreamTokenizer.f23980c);
                    } else {
                        throw new XPathException(xPath, "after @ in node test", simpleStreamTokenizer, "name");
                    }
                } else {
                    throw new XPathException(xPath, "at begininning of step", simpleStreamTokenizer, "'.' or '*' or name");
                }
            } else if (simpleStreamTokenizer.m35063a() == 46) {
                this.f23988a = ParentNodeTest.f23971a;
            } else {
                simpleStreamTokenizer.m35061c();
                this.f23988a = ThisNodeTest.f23994a;
            }
        } else if (simpleStreamTokenizer.f23980c.equals(C2573a.f8443b)) {
            if (simpleStreamTokenizer.m35063a() == 40 && simpleStreamTokenizer.m35063a() == 41) {
                this.f23988a = TextTest.f23993a;
            } else {
                throw new XPathException(xPath, "after text", simpleStreamTokenizer, "()");
            }
        } else {
            this.f23988a = new ElementTest(simpleStreamTokenizer.f23980c);
        }
        if (simpleStreamTokenizer.m35063a() == 91) {
            simpleStreamTokenizer.m35063a();
            this.f23989b = ExprFactory.m35071a(xPath, simpleStreamTokenizer);
            if (simpleStreamTokenizer.f23978a == 93) {
                simpleStreamTokenizer.m35063a();
                return;
            }
            throw new XPathException(xPath, "after predicate expression", simpleStreamTokenizer, "]");
        }
        this.f23989b = TrueExpr.f23960a;
    }
}
