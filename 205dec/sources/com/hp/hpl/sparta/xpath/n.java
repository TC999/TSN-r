package com.hp.hpl.sparta.xpath;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: ExprFactory.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(c0 c0Var, s sVar) throws XPathException, IOException {
        int parseInt;
        int parseInt2;
        int i4 = sVar.f37461a;
        if (i4 == -3) {
            if (sVar.f37463c.equals("text")) {
                if (sVar.a() == 40) {
                    if (sVar.a() == 41) {
                        int a4 = sVar.a();
                        if (a4 != 33) {
                            if (a4 != 61) {
                                return w.f37475a;
                            }
                            sVar.a();
                            int i5 = sVar.f37461a;
                            if (i5 != 34 && i5 != 39) {
                                throw new XPathException(c0Var, "right hand side of equals", sVar, "quoted string");
                            }
                            String str = sVar.f37463c;
                            sVar.a();
                            return new v(str);
                        }
                        sVar.a();
                        if (sVar.f37461a == 61) {
                            sVar.a();
                            int i6 = sVar.f37461a;
                            if (i6 != 34 && i6 != 39) {
                                throw new XPathException(c0Var, "right hand side of !=", sVar, "quoted string");
                            }
                            String str2 = sVar.f37463c;
                            sVar.a();
                            return new x(str2);
                        }
                        throw new XPathException(c0Var, "after !", sVar, "=");
                    }
                    throw new XPathException(c0Var, "after text(", sVar, ")");
                }
                throw new XPathException(c0Var, "after text", sVar, "(");
            }
            throw new XPathException(c0Var, "at beginning of expression", sVar, "text()");
        } else if (i4 == -2) {
            int i7 = sVar.f37462b;
            sVar.a();
            return new r(i7);
        } else if (i4 == 64) {
            if (sVar.a() == -3) {
                String str3 = sVar.f37463c;
                int a5 = sVar.a();
                if (a5 != 33) {
                    switch (a5) {
                        case 60:
                            sVar.a();
                            int i8 = sVar.f37461a;
                            if (i8 == 34 || i8 == 39) {
                                parseInt = Integer.parseInt(sVar.f37463c);
                            } else if (i8 == -2) {
                                parseInt = sVar.f37462b;
                            } else {
                                throw new XPathException(c0Var, "right hand side of less-than", sVar, "quoted string or number");
                            }
                            sVar.a();
                            return new g(str3, parseInt);
                        case 61:
                            sVar.a();
                            int i9 = sVar.f37461a;
                            if (i9 != 34 && i9 != 39) {
                                throw new XPathException(c0Var, "right hand side of equals", sVar, "quoted string");
                            }
                            String str4 = sVar.f37463c;
                            sVar.a();
                            return new c(str3, str4);
                        case 62:
                            sVar.a();
                            int i10 = sVar.f37461a;
                            if (i10 == 34 || i10 == 39) {
                                parseInt2 = Integer.parseInt(sVar.f37463c);
                            } else if (i10 == -2) {
                                parseInt2 = sVar.f37462b;
                            } else {
                                throw new XPathException(c0Var, "right hand side of greater-than", sVar, "quoted string or number");
                            }
                            sVar.a();
                            return new f(str3, parseInt2);
                        default:
                            return new d(str3);
                    }
                }
                sVar.a();
                if (sVar.f37461a == 61) {
                    sVar.a();
                    int i11 = sVar.f37461a;
                    if (i11 != 34 && i11 != 39) {
                        throw new XPathException(c0Var, "right hand side of !=", sVar, "quoted string");
                    }
                    String str5 = sVar.f37463c;
                    sVar.a();
                    return new h(str3, str5);
                }
                throw new XPathException(c0Var, "after !", sVar, "=");
            }
            throw new XPathException(c0Var, "after @", sVar, "name");
        } else {
            throw new XPathException(c0Var, "at beginning of expression", sVar, "@, number, or text()");
        }
    }
}
