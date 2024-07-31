package com.sun.mail.imap.protocol;

import com.baidu.mobads.sdk.internal.C2573a;
import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.ParsingException;
import java.io.PrintStream;
import java.util.Vector;
import javax.mail.internet.ParameterList;

/* renamed from: com.sun.mail.imap.protocol.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BODYSTRUCTURE implements Item {

    /* renamed from: r */
    static final char[] f36079r = {'B', 'O', 'D', 'Y', 'S', 'T', 'R', 'U', 'C', 'T', 'U', 'R', 'E'};

    /* renamed from: s */
    private static int f36080s = 1;

    /* renamed from: t */
    private static int f36081t = 2;

    /* renamed from: u */
    private static int f36082u = 3;

    /* renamed from: v */
    private static boolean f36083v;

    /* renamed from: a */
    public int f36084a;

    /* renamed from: b */
    public String f36085b;

    /* renamed from: c */
    public String f36086c;

    /* renamed from: d */
    public String f36087d;

    /* renamed from: e */
    public int f36088e;

    /* renamed from: f */
    public int f36089f;

    /* renamed from: g */
    public String f36090g;

    /* renamed from: h */
    public String f36091h;

    /* renamed from: i */
    public String f36092i;

    /* renamed from: j */
    public String f36093j;

    /* renamed from: k */
    public String f36094k;

    /* renamed from: l */
    public ParameterList f36095l;

    /* renamed from: m */
    public ParameterList f36096m;

    /* renamed from: n */
    public String[] f36097n;

    /* renamed from: o */
    public BODYSTRUCTURE[] f36098o;

    /* renamed from: p */
    public ENVELOPE f36099p;

    /* renamed from: q */
    private int f36100q;

    static {
        boolean z = true;
        f36083v = false;
        try {
            String property = System.getProperty("mail.imap.parse.debug");
            if (property == null || !property.equalsIgnoreCase("true")) {
                z = false;
            }
            f36083v = z;
        } catch (SecurityException unused) {
        }
    }

    public BODYSTRUCTURE(FetchResponse fetchResponse) throws ParsingException {
        this.f36088e = -1;
        this.f36089f = -1;
        if (f36083v) {
            System.out.println("DEBUG IMAP: parsing BODYSTRUCTURE");
        }
        this.f36084a = fetchResponse.m16121E();
        if (f36083v) {
            PrintStream printStream = System.out;
            printStream.println("DEBUG IMAP: msgno " + this.f36084a);
        }
        fetchResponse.m16408B();
        if (fetchResponse.m16389r() == 40) {
            if (fetchResponse.m16393n() == 40) {
                if (f36083v) {
                    System.out.println("DEBUG IMAP: parsing multipart");
                }
                this.f36085b = "multipart";
                this.f36100q = f36081t;
                Vector vector = new Vector(1);
                do {
                    vector.addElement(new BODYSTRUCTURE(fetchResponse));
                    fetchResponse.m16408B();
                } while (fetchResponse.m16393n() == 40);
                BODYSTRUCTURE[] bodystructureArr = new BODYSTRUCTURE[vector.size()];
                this.f36098o = bodystructureArr;
                vector.copyInto(bodystructureArr);
                this.f36086c = fetchResponse.m16384w();
                if (f36083v) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("DEBUG IMAP: subtype " + this.f36086c);
                }
                if (fetchResponse.m16389r() == 41) {
                    if (f36083v) {
                        System.out.println("DEBUG IMAP: parse DONE");
                        return;
                    }
                    return;
                }
                if (f36083v) {
                    System.out.println("DEBUG IMAP: parsing extension data");
                }
                this.f36095l = m16215e(fetchResponse);
                if (fetchResponse.m16389r() == 41) {
                    if (f36083v) {
                        System.out.println("DEBUG IMAP: body parameters DONE");
                        return;
                    }
                    return;
                }
                byte m16389r = fetchResponse.m16389r();
                if (m16389r == 40) {
                    if (f36083v) {
                        System.out.println("DEBUG IMAP: parse disposition");
                    }
                    this.f36090g = fetchResponse.m16384w();
                    if (f36083v) {
                        PrintStream printStream3 = System.out;
                        printStream3.println("DEBUG IMAP: disposition " + this.f36090g);
                    }
                    this.f36096m = m16215e(fetchResponse);
                    if (fetchResponse.m16389r() == 41) {
                        if (f36083v) {
                            System.out.println("DEBUG IMAP: disposition DONE");
                        }
                    } else {
                        throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition in multipart");
                    }
                } else if (m16389r != 78 && m16389r != 110) {
                    throw new ParsingException("BODYSTRUCTURE parse error: " + this.f36085b + "/" + this.f36086c + ": bad multipart disposition, b " + ((int) m16389r));
                } else {
                    if (f36083v) {
                        System.out.println("DEBUG IMAP: disposition NIL");
                    }
                    fetchResponse.m16409A(2);
                }
                byte m16389r2 = fetchResponse.m16389r();
                if (m16389r2 == 41) {
                    if (f36083v) {
                        System.out.println("DEBUG IMAP: no body-fld-lang");
                        return;
                    }
                    return;
                } else if (m16389r2 == 32) {
                    if (fetchResponse.m16393n() == 40) {
                        this.f36097n = fetchResponse.m16382y();
                        if (f36083v) {
                            PrintStream printStream4 = System.out;
                            printStream4.println("DEBUG IMAP: language len " + this.f36097n.length);
                        }
                    } else {
                        String m16384w = fetchResponse.m16384w();
                        if (m16384w != null) {
                            this.f36097n = new String[]{m16384w};
                            if (f36083v) {
                                PrintStream printStream5 = System.out;
                                printStream5.println("DEBUG IMAP: language " + m16384w);
                            }
                        }
                    }
                    while (fetchResponse.m16389r() == 32) {
                        m16216d(fetchResponse);
                    }
                    return;
                } else {
                    throw new ParsingException("BODYSTRUCTURE parse error: missing space after disposition");
                }
            }
            if (f36083v) {
                System.out.println("DEBUG IMAP: single part");
            }
            this.f36085b = fetchResponse.m16384w();
            if (f36083v) {
                PrintStream printStream6 = System.out;
                printStream6.println("DEBUG IMAP: type " + this.f36085b);
            }
            this.f36100q = f36080s;
            this.f36086c = fetchResponse.m16384w();
            if (f36083v) {
                PrintStream printStream7 = System.out;
                printStream7.println("DEBUG IMAP: subtype " + this.f36086c);
            }
            if (this.f36085b == null) {
                this.f36085b = "application";
                this.f36086c = "octet-stream";
            }
            this.f36095l = m16215e(fetchResponse);
            if (f36083v) {
                PrintStream printStream8 = System.out;
                printStream8.println("DEBUG IMAP: cParams " + this.f36095l);
            }
            this.f36091h = fetchResponse.m16384w();
            if (f36083v) {
                PrintStream printStream9 = System.out;
                printStream9.println("DEBUG IMAP: id " + this.f36091h);
            }
            this.f36092i = fetchResponse.m16384w();
            if (f36083v) {
                PrintStream printStream10 = System.out;
                printStream10.println("DEBUG IMAP: description " + this.f36092i);
            }
            this.f36087d = fetchResponse.m16384w();
            if (f36083v) {
                PrintStream printStream11 = System.out;
                printStream11.println("DEBUG IMAP: encoding " + this.f36087d);
            }
            this.f36089f = fetchResponse.m16385v();
            if (f36083v) {
                PrintStream printStream12 = System.out;
                printStream12.println("DEBUG IMAP: size " + this.f36089f);
            }
            if (this.f36089f >= 0) {
                if (this.f36085b.equalsIgnoreCase(C2573a.f8443b)) {
                    this.f36088e = fetchResponse.m16385v();
                    if (f36083v) {
                        PrintStream printStream13 = System.out;
                        printStream13.println("DEBUG IMAP: lines " + this.f36088e);
                    }
                    if (this.f36088e < 0) {
                        throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                    }
                } else if (this.f36085b.equalsIgnoreCase("message") && this.f36086c.equalsIgnoreCase("rfc822")) {
                    this.f36100q = f36082u;
                    this.f36099p = new ENVELOPE(fetchResponse);
                    this.f36098o = new BODYSTRUCTURE[]{new BODYSTRUCTURE(fetchResponse)};
                    this.f36088e = fetchResponse.m16385v();
                    if (f36083v) {
                        PrintStream printStream14 = System.out;
                        printStream14.println("DEBUG IMAP: lines " + this.f36088e);
                    }
                    if (this.f36088e < 0) {
                        throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                    }
                } else {
                    fetchResponse.m16408B();
                    if (Character.isDigit((char) fetchResponse.m16393n())) {
                        throw new ParsingException("BODYSTRUCTURE parse error: server erroneously included ``lines'' element with type " + this.f36085b + "/" + this.f36086c);
                    }
                }
                if (fetchResponse.m16393n() == 41) {
                    fetchResponse.m16389r();
                    if (f36083v) {
                        System.out.println("DEBUG IMAP: parse DONE");
                        return;
                    }
                    return;
                }
                this.f36093j = fetchResponse.m16384w();
                if (fetchResponse.m16389r() == 41) {
                    if (f36083v) {
                        System.out.println("DEBUG IMAP: no MD5 DONE");
                        return;
                    }
                    return;
                }
                byte m16389r3 = fetchResponse.m16389r();
                if (m16389r3 == 40) {
                    this.f36090g = fetchResponse.m16384w();
                    if (f36083v) {
                        PrintStream printStream15 = System.out;
                        printStream15.println("DEBUG IMAP: disposition " + this.f36090g);
                    }
                    this.f36096m = m16215e(fetchResponse);
                    if (f36083v) {
                        PrintStream printStream16 = System.out;
                        printStream16.println("DEBUG IMAP: dParams " + this.f36096m);
                    }
                    if (fetchResponse.m16389r() != 41) {
                        throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition");
                    }
                } else if (m16389r3 != 78 && m16389r3 != 110) {
                    throw new ParsingException("BODYSTRUCTURE parse error: " + this.f36085b + "/" + this.f36086c + ": bad single part disposition, b " + ((int) m16389r3));
                } else {
                    if (f36083v) {
                        System.out.println("DEBUG IMAP: disposition NIL");
                    }
                    fetchResponse.m16409A(2);
                }
                if (fetchResponse.m16389r() == 41) {
                    if (f36083v) {
                        System.out.println("DEBUG IMAP: disposition DONE");
                        return;
                    }
                    return;
                }
                if (fetchResponse.m16393n() == 40) {
                    this.f36097n = fetchResponse.m16382y();
                    if (f36083v) {
                        PrintStream printStream17 = System.out;
                        printStream17.println("DEBUG IMAP: language len " + this.f36097n.length);
                    }
                } else {
                    String m16384w2 = fetchResponse.m16384w();
                    if (m16384w2 != null) {
                        this.f36097n = new String[]{m16384w2};
                        if (f36083v) {
                            PrintStream printStream18 = System.out;
                            printStream18.println("DEBUG IMAP: language " + m16384w2);
                        }
                    }
                }
                while (fetchResponse.m16389r() == 32) {
                    m16216d(fetchResponse);
                }
                if (f36083v) {
                    System.out.println("DEBUG IMAP: all DONE");
                    return;
                }
                return;
            }
            throw new ParsingException("BODYSTRUCTURE parse error: bad ``size'' element");
        }
        throw new ParsingException("BODYSTRUCTURE parse error: missing ``('' at start");
    }

    /* renamed from: d */
    private void m16216d(C12728g c12728g) throws ParsingException {
        c12728g.m16408B();
        byte m16393n = c12728g.m16393n();
        if (m16393n == 40) {
            c12728g.m16409A(1);
            do {
                m16216d(c12728g);
            } while (c12728g.m16389r() != 41);
        } else if (Character.isDigit((char) m16393n)) {
            c12728g.m16385v();
        } else {
            c12728g.m16384w();
        }
    }

    /* renamed from: e */
    private ParameterList m16215e(C12728g c12728g) throws ParsingException {
        c12728g.m16408B();
        byte m16389r = c12728g.m16389r();
        if (m16389r != 40) {
            if (m16389r != 78 && m16389r != 110) {
                throw new ParsingException("Parameter list parse error");
            }
            if (f36083v) {
                System.out.println("DEBUG IMAP: parameter list NIL");
            }
            c12728g.m16409A(2);
            return null;
        }
        ParameterList parameterList = new ParameterList();
        do {
            String m16384w = c12728g.m16384w();
            if (f36083v) {
                PrintStream printStream = System.out;
                printStream.println("DEBUG IMAP: parameter name " + m16384w);
            }
            if (m16384w != null) {
                String m16384w2 = c12728g.m16384w();
                if (f36083v) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("DEBUG IMAP: parameter value " + m16384w2);
                }
                parameterList.set(m16384w, m16384w2);
            } else {
                throw new ParsingException("BODYSTRUCTURE parse error: " + this.f36085b + "/" + this.f36086c + ": null name in parameter list");
            }
        } while (c12728g.m16389r() != 41);
        parameterList.set(null, "DONE");
        return parameterList;
    }

    /* renamed from: a */
    public boolean m16219a() {
        return this.f36100q == f36081t;
    }

    /* renamed from: b */
    public boolean m16218b() {
        return this.f36100q == f36082u;
    }

    /* renamed from: c */
    public boolean m16217c() {
        return this.f36100q == f36080s;
    }
}
