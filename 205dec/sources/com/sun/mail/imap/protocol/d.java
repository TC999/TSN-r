package com.sun.mail.imap.protocol;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.sun.mail.iap.ParsingException;
import java.io.PrintStream;
import java.util.Vector;
import javax.mail.internet.ParameterList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BODYSTRUCTURE.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d implements l {

    /* renamed from: r  reason: collision with root package name */
    static final char[] f50491r = {'B', 'O', 'D', 'Y', 'S', 'T', 'R', 'U', 'C', 'T', 'U', 'R', 'E'};

    /* renamed from: s  reason: collision with root package name */
    private static int f50492s = 1;

    /* renamed from: t  reason: collision with root package name */
    private static int f50493t = 2;

    /* renamed from: u  reason: collision with root package name */
    private static int f50494u = 3;

    /* renamed from: v  reason: collision with root package name */
    private static boolean f50495v;

    /* renamed from: a  reason: collision with root package name */
    public int f50496a;

    /* renamed from: b  reason: collision with root package name */
    public String f50497b;

    /* renamed from: c  reason: collision with root package name */
    public String f50498c;

    /* renamed from: d  reason: collision with root package name */
    public String f50499d;

    /* renamed from: e  reason: collision with root package name */
    public int f50500e;

    /* renamed from: f  reason: collision with root package name */
    public int f50501f;

    /* renamed from: g  reason: collision with root package name */
    public String f50502g;

    /* renamed from: h  reason: collision with root package name */
    public String f50503h;

    /* renamed from: i  reason: collision with root package name */
    public String f50504i;

    /* renamed from: j  reason: collision with root package name */
    public String f50505j;

    /* renamed from: k  reason: collision with root package name */
    public String f50506k;

    /* renamed from: l  reason: collision with root package name */
    public ParameterList f50507l;

    /* renamed from: m  reason: collision with root package name */
    public ParameterList f50508m;

    /* renamed from: n  reason: collision with root package name */
    public String[] f50509n;

    /* renamed from: o  reason: collision with root package name */
    public d[] f50510o;

    /* renamed from: p  reason: collision with root package name */
    public e f50511p;

    /* renamed from: q  reason: collision with root package name */
    private int f50512q;

    static {
        boolean z3 = true;
        f50495v = false;
        try {
            String property = System.getProperty("mail.imap.parse.debug");
            if (property == null || !property.equalsIgnoreCase("true")) {
                z3 = false;
            }
            f50495v = z3;
        } catch (SecurityException unused) {
        }
    }

    public d(f fVar) throws ParsingException {
        this.f50500e = -1;
        this.f50501f = -1;
        if (f50495v) {
            System.out.println("DEBUG IMAP: parsing BODYSTRUCTURE");
        }
        this.f50496a = fVar.E();
        if (f50495v) {
            PrintStream printStream = System.out;
            printStream.println("DEBUG IMAP: msgno " + this.f50496a);
        }
        fVar.B();
        if (fVar.r() == 40) {
            if (fVar.n() == 40) {
                if (f50495v) {
                    System.out.println("DEBUG IMAP: parsing multipart");
                }
                this.f50497b = "multipart";
                this.f50512q = f50493t;
                Vector vector = new Vector(1);
                do {
                    vector.addElement(new d(fVar));
                    fVar.B();
                } while (fVar.n() == 40);
                d[] dVarArr = new d[vector.size()];
                this.f50510o = dVarArr;
                vector.copyInto(dVarArr);
                this.f50498c = fVar.w();
                if (f50495v) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("DEBUG IMAP: subtype " + this.f50498c);
                }
                if (fVar.r() == 41) {
                    if (f50495v) {
                        System.out.println("DEBUG IMAP: parse DONE");
                        return;
                    }
                    return;
                }
                if (f50495v) {
                    System.out.println("DEBUG IMAP: parsing extension data");
                }
                this.f50507l = e(fVar);
                if (fVar.r() == 41) {
                    if (f50495v) {
                        System.out.println("DEBUG IMAP: body parameters DONE");
                        return;
                    }
                    return;
                }
                byte r3 = fVar.r();
                if (r3 == 40) {
                    if (f50495v) {
                        System.out.println("DEBUG IMAP: parse disposition");
                    }
                    this.f50502g = fVar.w();
                    if (f50495v) {
                        PrintStream printStream3 = System.out;
                        printStream3.println("DEBUG IMAP: disposition " + this.f50502g);
                    }
                    this.f50508m = e(fVar);
                    if (fVar.r() == 41) {
                        if (f50495v) {
                            System.out.println("DEBUG IMAP: disposition DONE");
                        }
                    } else {
                        throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition in multipart");
                    }
                } else if (r3 != 78 && r3 != 110) {
                    throw new ParsingException("BODYSTRUCTURE parse error: " + this.f50497b + TTPathConst.sSeparator + this.f50498c + ": bad multipart disposition, b " + ((int) r3));
                } else {
                    if (f50495v) {
                        System.out.println("DEBUG IMAP: disposition NIL");
                    }
                    fVar.A(2);
                }
                byte r4 = fVar.r();
                if (r4 == 41) {
                    if (f50495v) {
                        System.out.println("DEBUG IMAP: no body-fld-lang");
                        return;
                    }
                    return;
                } else if (r4 == 32) {
                    if (fVar.n() == 40) {
                        this.f50509n = fVar.y();
                        if (f50495v) {
                            PrintStream printStream4 = System.out;
                            printStream4.println("DEBUG IMAP: language len " + this.f50509n.length);
                        }
                    } else {
                        String w3 = fVar.w();
                        if (w3 != null) {
                            this.f50509n = new String[]{w3};
                            if (f50495v) {
                                PrintStream printStream5 = System.out;
                                printStream5.println("DEBUG IMAP: language " + w3);
                            }
                        }
                    }
                    while (fVar.r() == 32) {
                        d(fVar);
                    }
                    return;
                } else {
                    throw new ParsingException("BODYSTRUCTURE parse error: missing space after disposition");
                }
            }
            if (f50495v) {
                System.out.println("DEBUG IMAP: single part");
            }
            this.f50497b = fVar.w();
            if (f50495v) {
                PrintStream printStream6 = System.out;
                printStream6.println("DEBUG IMAP: type " + this.f50497b);
            }
            this.f50512q = f50492s;
            this.f50498c = fVar.w();
            if (f50495v) {
                PrintStream printStream7 = System.out;
                printStream7.println("DEBUG IMAP: subtype " + this.f50498c);
            }
            if (this.f50497b == null) {
                this.f50497b = "application";
                this.f50498c = "octet-stream";
            }
            this.f50507l = e(fVar);
            if (f50495v) {
                PrintStream printStream8 = System.out;
                printStream8.println("DEBUG IMAP: cParams " + this.f50507l);
            }
            this.f50503h = fVar.w();
            if (f50495v) {
                PrintStream printStream9 = System.out;
                printStream9.println("DEBUG IMAP: id " + this.f50503h);
            }
            this.f50504i = fVar.w();
            if (f50495v) {
                PrintStream printStream10 = System.out;
                printStream10.println("DEBUG IMAP: description " + this.f50504i);
            }
            this.f50499d = fVar.w();
            if (f50495v) {
                PrintStream printStream11 = System.out;
                printStream11.println("DEBUG IMAP: encoding " + this.f50499d);
            }
            this.f50501f = fVar.v();
            if (f50495v) {
                PrintStream printStream12 = System.out;
                printStream12.println("DEBUG IMAP: size " + this.f50501f);
            }
            if (this.f50501f >= 0) {
                if (this.f50497b.equalsIgnoreCase("text")) {
                    this.f50500e = fVar.v();
                    if (f50495v) {
                        PrintStream printStream13 = System.out;
                        printStream13.println("DEBUG IMAP: lines " + this.f50500e);
                    }
                    if (this.f50500e < 0) {
                        throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                    }
                } else if (this.f50497b.equalsIgnoreCase("message") && this.f50498c.equalsIgnoreCase("rfc822")) {
                    this.f50512q = f50494u;
                    this.f50511p = new e(fVar);
                    this.f50510o = new d[]{new d(fVar)};
                    this.f50500e = fVar.v();
                    if (f50495v) {
                        PrintStream printStream14 = System.out;
                        printStream14.println("DEBUG IMAP: lines " + this.f50500e);
                    }
                    if (this.f50500e < 0) {
                        throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                    }
                } else {
                    fVar.B();
                    if (Character.isDigit((char) fVar.n())) {
                        throw new ParsingException("BODYSTRUCTURE parse error: server erroneously included ``lines'' element with type " + this.f50497b + TTPathConst.sSeparator + this.f50498c);
                    }
                }
                if (fVar.n() == 41) {
                    fVar.r();
                    if (f50495v) {
                        System.out.println("DEBUG IMAP: parse DONE");
                        return;
                    }
                    return;
                }
                this.f50505j = fVar.w();
                if (fVar.r() == 41) {
                    if (f50495v) {
                        System.out.println("DEBUG IMAP: no MD5 DONE");
                        return;
                    }
                    return;
                }
                byte r5 = fVar.r();
                if (r5 == 40) {
                    this.f50502g = fVar.w();
                    if (f50495v) {
                        PrintStream printStream15 = System.out;
                        printStream15.println("DEBUG IMAP: disposition " + this.f50502g);
                    }
                    this.f50508m = e(fVar);
                    if (f50495v) {
                        PrintStream printStream16 = System.out;
                        printStream16.println("DEBUG IMAP: dParams " + this.f50508m);
                    }
                    if (fVar.r() != 41) {
                        throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition");
                    }
                } else if (r5 != 78 && r5 != 110) {
                    throw new ParsingException("BODYSTRUCTURE parse error: " + this.f50497b + TTPathConst.sSeparator + this.f50498c + ": bad single part disposition, b " + ((int) r5));
                } else {
                    if (f50495v) {
                        System.out.println("DEBUG IMAP: disposition NIL");
                    }
                    fVar.A(2);
                }
                if (fVar.r() == 41) {
                    if (f50495v) {
                        System.out.println("DEBUG IMAP: disposition DONE");
                        return;
                    }
                    return;
                }
                if (fVar.n() == 40) {
                    this.f50509n = fVar.y();
                    if (f50495v) {
                        PrintStream printStream17 = System.out;
                        printStream17.println("DEBUG IMAP: language len " + this.f50509n.length);
                    }
                } else {
                    String w4 = fVar.w();
                    if (w4 != null) {
                        this.f50509n = new String[]{w4};
                        if (f50495v) {
                            PrintStream printStream18 = System.out;
                            printStream18.println("DEBUG IMAP: language " + w4);
                        }
                    }
                }
                while (fVar.r() == 32) {
                    d(fVar);
                }
                if (f50495v) {
                    System.out.println("DEBUG IMAP: all DONE");
                    return;
                }
                return;
            }
            throw new ParsingException("BODYSTRUCTURE parse error: bad ``size'' element");
        }
        throw new ParsingException("BODYSTRUCTURE parse error: missing ``('' at start");
    }

    private void d(com.sun.mail.iap.g gVar) throws ParsingException {
        gVar.B();
        byte n4 = gVar.n();
        if (n4 == 40) {
            gVar.A(1);
            do {
                d(gVar);
            } while (gVar.r() != 41);
        } else if (Character.isDigit((char) n4)) {
            gVar.v();
        } else {
            gVar.w();
        }
    }

    private ParameterList e(com.sun.mail.iap.g gVar) throws ParsingException {
        gVar.B();
        byte r3 = gVar.r();
        if (r3 != 40) {
            if (r3 != 78 && r3 != 110) {
                throw new ParsingException("Parameter list parse error");
            }
            if (f50495v) {
                System.out.println("DEBUG IMAP: parameter list NIL");
            }
            gVar.A(2);
            return null;
        }
        ParameterList parameterList = new ParameterList();
        do {
            String w3 = gVar.w();
            if (f50495v) {
                PrintStream printStream = System.out;
                printStream.println("DEBUG IMAP: parameter name " + w3);
            }
            if (w3 != null) {
                String w4 = gVar.w();
                if (f50495v) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("DEBUG IMAP: parameter value " + w4);
                }
                parameterList.set(w3, w4);
            } else {
                throw new ParsingException("BODYSTRUCTURE parse error: " + this.f50497b + TTPathConst.sSeparator + this.f50498c + ": null name in parameter list");
            }
        } while (gVar.r() != 41);
        parameterList.set(null, "DONE");
        return parameterList;
    }

    public boolean a() {
        return this.f50512q == f50493t;
    }

    public boolean b() {
        return this.f50512q == f50494u;
    }

    public boolean c() {
        return this.f50512q == f50492s;
    }
}
