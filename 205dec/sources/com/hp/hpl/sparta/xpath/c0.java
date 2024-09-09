package com.hp.hpl.sparta.xpath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: XPath.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c0 {

    /* renamed from: d  reason: collision with root package name */
    private static final int f37445d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static Hashtable f37446e = new Hashtable();

    /* renamed from: a  reason: collision with root package name */
    private Stack f37447a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f37448b;

    /* renamed from: c  reason: collision with root package name */
    private String f37449c;

    private c0(boolean z3, t[] tVarArr) {
        this.f37447a = new Stack();
        for (t tVar : tVarArr) {
            this.f37447a.addElement(tVar);
        }
        this.f37448b = z3;
        this.f37449c = null;
    }

    private String a() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration elements = this.f37447a.elements();
        boolean z3 = true;
        while (elements.hasMoreElements()) {
            t tVar = (t) elements.nextElement();
            if (!z3 || this.f37448b) {
                stringBuffer.append('/');
                if (tVar.c()) {
                    stringBuffer.append('/');
                }
            }
            stringBuffer.append(tVar.toString());
            z3 = false;
        }
        return stringBuffer.toString();
    }

    public static c0 b(String str) throws XPathException {
        c0 c0Var;
        synchronized (f37446e) {
            c0Var = (c0) f37446e.get(str);
            if (c0Var == null) {
                c0Var = new c0(str);
                f37446e.put(str, c0Var);
            }
        }
        return c0Var;
    }

    public static c0 c(boolean z3, t[] tVarArr) {
        c0 c0Var = new c0(z3, tVarArr);
        String c0Var2 = c0Var.toString();
        synchronized (f37446e) {
            c0 c0Var3 = (c0) f37446e.get(c0Var2);
            if (c0Var3 == null) {
                f37446e.put(c0Var2, c0Var);
                return c0Var;
            }
            return c0Var3;
        }
    }

    public static boolean i(String str) throws XPathException, IOException {
        return b(str).h();
    }

    public Object clone() {
        int size = this.f37447a.size();
        t[] tVarArr = new t[size];
        Enumeration elements = this.f37447a.elements();
        for (int i4 = 0; i4 < size; i4++) {
            tVarArr[i4] = (t) elements.nextElement();
        }
        return new c0(this.f37448b, tVarArr);
    }

    public String d() throws XPathException {
        k b4 = ((t) this.f37447a.peek()).b();
        if (b4 instanceof d) {
            return ((d) b4).b();
        }
        throw new XPathException(this, "has no indexing attribute name (must end with predicate of the form [@attrName]");
    }

    public String e() throws XPathException {
        k b4 = ((t) this.f37447a.peek()).b();
        if (b4 instanceof c) {
            return ((c) b4).b();
        }
        return null;
    }

    public Enumeration f() {
        return this.f37447a.elements();
    }

    public boolean g() {
        return this.f37448b;
    }

    public boolean h() {
        return ((t) this.f37447a.peek()).d();
    }

    public String toString() {
        if (this.f37449c == null) {
            this.f37449c = a();
        }
        return this.f37449c;
    }

    private c0(String str) throws XPathException {
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
    private c0(java.lang.String r6, java.io.Reader r7) throws com.hp.hpl.sparta.xpath.XPathException {
        /*
            r5 = this;
            r5.<init>()
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r5.f37447a = r0
            r5.f37449c = r6     // Catch: java.io.IOException -> L70
            com.hp.hpl.sparta.xpath.s r6 = new com.hp.hpl.sparta.xpath.s     // Catch: java.io.IOException -> L70
            r6.<init>(r7)     // Catch: java.io.IOException -> L70
            r7 = 47
            r6.b(r7)     // Catch: java.io.IOException -> L70
            r0 = 46
            r6.b(r0)     // Catch: java.io.IOException -> L70
            r0 = 58
            r6.d(r0, r0)     // Catch: java.io.IOException -> L70
            r0 = 95
            r6.d(r0, r0)     // Catch: java.io.IOException -> L70
            int r0 = r6.a()     // Catch: java.io.IOException -> L70
            r1 = 1
            r2 = 0
            if (r0 != r7) goto L3a
            r5.f37448b = r1     // Catch: java.io.IOException -> L70
            int r0 = r6.a()     // Catch: java.io.IOException -> L70
            if (r0 != r7) goto L3c
            r6.a()     // Catch: java.io.IOException -> L70
            r0 = 1
            goto L3d
        L3a:
            r5.f37448b = r2     // Catch: java.io.IOException -> L70
        L3c:
            r0 = 0
        L3d:
            java.util.Stack r3 = r5.f37447a     // Catch: java.io.IOException -> L70
            com.hp.hpl.sparta.xpath.t r4 = new com.hp.hpl.sparta.xpath.t     // Catch: java.io.IOException -> L70
            r4.<init>(r5, r0, r6)     // Catch: java.io.IOException -> L70
            r3.push(r4)     // Catch: java.io.IOException -> L70
        L47:
            int r0 = r6.f37461a     // Catch: java.io.IOException -> L70
            if (r0 != r7) goto L62
            int r0 = r6.a()     // Catch: java.io.IOException -> L70
            if (r0 != r7) goto L56
            r6.a()     // Catch: java.io.IOException -> L70
            r0 = 1
            goto L57
        L56:
            r0 = 0
        L57:
            java.util.Stack r3 = r5.f37447a     // Catch: java.io.IOException -> L70
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
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.xpath.c0.<init>(java.lang.String, java.io.Reader):void");
    }
}
