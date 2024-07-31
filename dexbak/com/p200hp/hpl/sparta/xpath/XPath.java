package com.p200hp.hpl.sparta.xpath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

/* renamed from: com.hp.hpl.sparta.xpath.c0 */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class XPath {

    /* renamed from: d */
    private static final int f23962d = 0;

    /* renamed from: e */
    private static Hashtable f23963e = new Hashtable();

    /* renamed from: a */
    private Stack f23964a;

    /* renamed from: b */
    private boolean f23965b;

    /* renamed from: c */
    private String f23966c;

    private XPath(boolean z, Step[] stepArr) {
        this.f23964a = new Stack();
        for (Step step : stepArr) {
            this.f23964a.addElement(step);
        }
        this.f23965b = z;
        this.f23966c = null;
    }

    /* renamed from: a */
    private String m35095a() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration elements = this.f23964a.elements();
        boolean z = true;
        while (elements.hasMoreElements()) {
            Step step = (Step) elements.nextElement();
            if (!z || this.f23965b) {
                stringBuffer.append('/');
                if (step.m35057c()) {
                    stringBuffer.append('/');
                }
            }
            stringBuffer.append(step.toString());
            z = false;
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static XPath m35094b(String str) throws XPathException {
        XPath xPath;
        synchronized (f23963e) {
            xPath = (XPath) f23963e.get(str);
            if (xPath == null) {
                xPath = new XPath(str);
                f23963e.put(str, xPath);
            }
        }
        return xPath;
    }

    /* renamed from: c */
    public static XPath m35093c(boolean z, Step[] stepArr) {
        XPath xPath = new XPath(z, stepArr);
        String xPath2 = xPath.toString();
        synchronized (f23963e) {
            XPath xPath3 = (XPath) f23963e.get(xPath2);
            if (xPath3 == null) {
                f23963e.put(xPath2, xPath);
                return xPath;
            }
            return xPath3;
        }
    }

    /* renamed from: i */
    public static boolean m35087i(String str) throws XPathException, IOException {
        return m35094b(str).m35088h();
    }

    public Object clone() {
        int size = this.f23964a.size();
        Step[] stepArr = new Step[size];
        Enumeration elements = this.f23964a.elements();
        for (int i = 0; i < size; i++) {
            stepArr[i] = (Step) elements.nextElement();
        }
        return new XPath(this.f23965b, stepArr);
    }

    /* renamed from: d */
    public String m35092d() throws XPathException {
        BooleanExpr m35058b = ((Step) this.f23964a.peek()).m35058b();
        if (m35058b instanceof AttrExistsExpr) {
            return ((AttrExistsExpr) m35058b).m35086b();
        }
        throw new XPathException(this, "has no indexing attribute name (must end with predicate of the form [@attrName]");
    }

    /* renamed from: e */
    public String m35091e() throws XPathException {
        BooleanExpr m35058b = ((Step) this.f23964a.peek()).m35058b();
        if (m35058b instanceof AttrEqualsExpr) {
            return ((AttrEqualsExpr) m35058b).m35086b();
        }
        return null;
    }

    /* renamed from: f */
    public Enumeration m35090f() {
        return this.f23964a.elements();
    }

    /* renamed from: g */
    public boolean m35089g() {
        return this.f23965b;
    }

    /* renamed from: h */
    public boolean m35088h() {
        return ((Step) this.f23964a.peek()).m35056d();
    }

    public String toString() {
        if (this.f23966c == null) {
            this.f23966c = m35095a();
        }
        return this.f23966c;
    }

    private XPath(String str) throws XPathException {
        this(str, new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b A[Catch: IOException -> 0x0070, TryCatch #0 {IOException -> 0x0070, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:10:0x003d, B:11:0x0047, B:13:0x004b, B:15:0x0051, B:17:0x0057, B:21:0x0066, B:22:0x006f, B:8:0x003a), top: B:27:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066 A[Catch: IOException -> 0x0070, TryCatch #0 {IOException -> 0x0070, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:10:0x003d, B:11:0x0047, B:13:0x004b, B:15:0x0051, B:17:0x0057, B:21:0x0066, B:22:0x006f, B:8:0x003a), top: B:27:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[EDGE_INSN: B:29:0x0062->B:18:0x0062 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private XPath(java.lang.String r6, java.io.Reader r7) throws com.p200hp.hpl.sparta.xpath.XPathException {
        /*
            r5 = this;
            r5.<init>()
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r5.f23964a = r0
            r5.f23966c = r6     // Catch: java.io.IOException -> L70
            com.hp.hpl.sparta.xpath.s r6 = new com.hp.hpl.sparta.xpath.s     // Catch: java.io.IOException -> L70
            r6.<init>(r7)     // Catch: java.io.IOException -> L70
            r7 = 47
            r6.m35062b(r7)     // Catch: java.io.IOException -> L70
            r0 = 46
            r6.m35062b(r0)     // Catch: java.io.IOException -> L70
            r0 = 58
            r6.m35060d(r0, r0)     // Catch: java.io.IOException -> L70
            r0 = 95
            r6.m35060d(r0, r0)     // Catch: java.io.IOException -> L70
            int r0 = r6.m35063a()     // Catch: java.io.IOException -> L70
            r1 = 1
            r2 = 0
            if (r0 != r7) goto L3a
            r5.f23965b = r1     // Catch: java.io.IOException -> L70
            int r0 = r6.m35063a()     // Catch: java.io.IOException -> L70
            if (r0 != r7) goto L3c
            r6.m35063a()     // Catch: java.io.IOException -> L70
            r0 = 1
            goto L3d
        L3a:
            r5.f23965b = r2     // Catch: java.io.IOException -> L70
        L3c:
            r0 = 0
        L3d:
            java.util.Stack r3 = r5.f23964a     // Catch: java.io.IOException -> L70
            com.hp.hpl.sparta.xpath.t r4 = new com.hp.hpl.sparta.xpath.t     // Catch: java.io.IOException -> L70
            r4.<init>(r5, r0, r6)     // Catch: java.io.IOException -> L70
            r3.push(r4)     // Catch: java.io.IOException -> L70
        L47:
            int r0 = r6.f23978a     // Catch: java.io.IOException -> L70
            if (r0 != r7) goto L62
            int r0 = r6.m35063a()     // Catch: java.io.IOException -> L70
            if (r0 != r7) goto L56
            r6.m35063a()     // Catch: java.io.IOException -> L70
            r0 = 1
            goto L57
        L56:
            r0 = 0
        L57:
            java.util.Stack r3 = r5.f23964a     // Catch: java.io.IOException -> L70
            com.hp.hpl.sparta.xpath.t r4 = new com.hp.hpl.sparta.xpath.t     // Catch: java.io.IOException -> L70
            r4.<init>(r5, r0, r6)     // Catch: java.io.IOException -> L70
            r3.push(r4)     // Catch: java.io.IOException -> L70
            goto L47
        L62:
            r7 = -1
            if (r0 != r7) goto L66
            return
        L66:
            com.hp.hpl.sparta.xpath.XPathException r7 = new com.hp.hpl.sparta.xpath.XPathException     // Catch: java.io.IOException -> L70
            java.lang.String r0 = "at end of XPATH expression"
            java.lang.String r1 = "end of expression"
            r7.<init>(r5, r0, r6, r1)     // Catch: java.io.IOException -> L70
            throw r7     // Catch: java.io.IOException -> L70
        L70:
            r6 = move-exception
            com.hp.hpl.sparta.xpath.XPathException r7 = new com.hp.hpl.sparta.xpath.XPathException
            r7.<init>(r5, r6)
            goto L78
        L77:
            throw r7
        L78:
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p200hp.hpl.sparta.xpath.XPath.<init>(java.lang.String, java.io.Reader):void");
    }
}