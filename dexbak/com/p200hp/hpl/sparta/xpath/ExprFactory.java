package com.p200hp.hpl.sparta.xpath;

import com.baidu.mobads.sdk.internal.C2573a;
import java.io.IOException;

/* renamed from: com.hp.hpl.sparta.xpath.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ExprFactory {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static BooleanExpr m35071a(XPath xPath, SimpleStreamTokenizer simpleStreamTokenizer) throws XPathException, IOException {
        int parseInt;
        int parseInt2;
        int i = simpleStreamTokenizer.f23978a;
        if (i == -3) {
            if (simpleStreamTokenizer.f23980c.equals(C2573a.f8443b)) {
                if (simpleStreamTokenizer.m35063a() == 40) {
                    if (simpleStreamTokenizer.m35063a() == 41) {
                        int m35063a = simpleStreamTokenizer.m35063a();
                        if (m35063a != 33) {
                            if (m35063a != 61) {
                                return TextExistsExpr.f23992a;
                            }
                            simpleStreamTokenizer.m35063a();
                            int i2 = simpleStreamTokenizer.f23978a;
                            if (i2 != 34 && i2 != 39) {
                                throw new XPathException(xPath, "right hand side of equals", simpleStreamTokenizer, "quoted string");
                            }
                            String str = simpleStreamTokenizer.f23980c;
                            simpleStreamTokenizer.m35063a();
                            return new TextEqualsExpr(str);
                        }
                        simpleStreamTokenizer.m35063a();
                        if (simpleStreamTokenizer.f23978a == 61) {
                            simpleStreamTokenizer.m35063a();
                            int i3 = simpleStreamTokenizer.f23978a;
                            if (i3 != 34 && i3 != 39) {
                                throw new XPathException(xPath, "right hand side of !=", simpleStreamTokenizer, "quoted string");
                            }
                            String str2 = simpleStreamTokenizer.f23980c;
                            simpleStreamTokenizer.m35063a();
                            return new TextNotEqualsExpr(str2);
                        }
                        throw new XPathException(xPath, "after !", simpleStreamTokenizer, "=");
                    }
                    throw new XPathException(xPath, "after text(", simpleStreamTokenizer, ")");
                }
                throw new XPathException(xPath, "after text", simpleStreamTokenizer, "(");
            }
            throw new XPathException(xPath, "at beginning of expression", simpleStreamTokenizer, "text()");
        } else if (i == -2) {
            int i4 = simpleStreamTokenizer.f23979b;
            simpleStreamTokenizer.m35063a();
            return new PositionEqualsExpr(i4);
        } else if (i == 64) {
            if (simpleStreamTokenizer.m35063a() == -3) {
                String str3 = simpleStreamTokenizer.f23980c;
                int m35063a2 = simpleStreamTokenizer.m35063a();
                if (m35063a2 != 33) {
                    switch (m35063a2) {
                        case 60:
                            simpleStreamTokenizer.m35063a();
                            int i5 = simpleStreamTokenizer.f23978a;
                            if (i5 == 34 || i5 == 39) {
                                parseInt = Integer.parseInt(simpleStreamTokenizer.f23980c);
                            } else if (i5 == -2) {
                                parseInt = simpleStreamTokenizer.f23979b;
                            } else {
                                throw new XPathException(xPath, "right hand side of less-than", simpleStreamTokenizer, "quoted string or number");
                            }
                            simpleStreamTokenizer.m35063a();
                            return new AttrLessExpr(str3, parseInt);
                        case 61:
                            simpleStreamTokenizer.m35063a();
                            int i6 = simpleStreamTokenizer.f23978a;
                            if (i6 != 34 && i6 != 39) {
                                throw new XPathException(xPath, "right hand side of equals", simpleStreamTokenizer, "quoted string");
                            }
                            String str4 = simpleStreamTokenizer.f23980c;
                            simpleStreamTokenizer.m35063a();
                            return new AttrEqualsExpr(str3, str4);
                        case 62:
                            simpleStreamTokenizer.m35063a();
                            int i7 = simpleStreamTokenizer.f23978a;
                            if (i7 == 34 || i7 == 39) {
                                parseInt2 = Integer.parseInt(simpleStreamTokenizer.f23980c);
                            } else if (i7 == -2) {
                                parseInt2 = simpleStreamTokenizer.f23979b;
                            } else {
                                throw new XPathException(xPath, "right hand side of greater-than", simpleStreamTokenizer, "quoted string or number");
                            }
                            simpleStreamTokenizer.m35063a();
                            return new AttrGreaterExpr(str3, parseInt2);
                        default:
                            return new AttrExistsExpr(str3);
                    }
                }
                simpleStreamTokenizer.m35063a();
                if (simpleStreamTokenizer.f23978a == 61) {
                    simpleStreamTokenizer.m35063a();
                    int i8 = simpleStreamTokenizer.f23978a;
                    if (i8 != 34 && i8 != 39) {
                        throw new XPathException(xPath, "right hand side of !=", simpleStreamTokenizer, "quoted string");
                    }
                    String str5 = simpleStreamTokenizer.f23980c;
                    simpleStreamTokenizer.m35063a();
                    return new AttrNotEqualsExpr(str3, str5);
                }
                throw new XPathException(xPath, "after !", simpleStreamTokenizer, "=");
            }
            throw new XPathException(xPath, "after @", simpleStreamTokenizer, "name");
        } else {
            throw new XPathException(xPath, "at beginning of expression", simpleStreamTokenizer, "@, number, or text()");
        }
    }
}
