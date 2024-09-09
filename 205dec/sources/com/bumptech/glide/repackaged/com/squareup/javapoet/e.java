package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodeWriter.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class e {

    /* renamed from: o  reason: collision with root package name */
    private static final String f17770o = new String();

    /* renamed from: a  reason: collision with root package name */
    private final String f17771a;

    /* renamed from: b  reason: collision with root package name */
    private final h f17772b;

    /* renamed from: c  reason: collision with root package name */
    private int f17773c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17774d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17775e;

    /* renamed from: f  reason: collision with root package name */
    private String f17776f;

    /* renamed from: g  reason: collision with root package name */
    private final List<TypeSpec> f17777g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<String> f17778h;

    /* renamed from: i  reason: collision with root package name */
    private final Set<String> f17779i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, c> f17780j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, c> f17781k;

    /* renamed from: l  reason: collision with root package name */
    private final Set<String> f17782l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17783m;

    /* renamed from: n  reason: collision with root package name */
    int f17784n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Appendable appendable) {
        this(appendable, "  ", Collections.emptySet());
    }

    private void g() throws IOException {
        for (int i4 = 0; i4 < this.f17773c; i4++) {
            this.f17772b.a(this.f17771a);
        }
    }

    private void i(Object obj) throws IOException {
        if (obj instanceof TypeSpec) {
            ((TypeSpec) obj).b(this, null, Collections.emptySet());
        } else if (obj instanceof a) {
            ((a) obj).c(this, true);
        } else if (obj instanceof d) {
            a((d) obj);
        } else {
            d(String.valueOf(obj));
        }
    }

    private boolean l(String str, String str2) throws IOException {
        String substring = str2.substring(1);
        if (!substring.isEmpty() && Character.isJavaIdentifierStart(substring.charAt(0))) {
            String str3 = str + "." + o(substring);
            String str4 = str + ".*";
            if (this.f17779i.contains(str3) || this.f17779i.contains(str4)) {
                d(substring);
                return true;
            }
            return false;
        }
        return false;
    }

    private static String o(String str) {
        n.b(Character.isJavaIdentifierStart(str.charAt(0)), "not an identifier: %s", str);
        for (int i4 = 1; i4 <= str.length(); i4++) {
            if (!SourceVersion.isIdentifier(str.substring(0, i4))) {
                return str.substring(0, i4 - 1);
            }
        }
        return str;
    }

    private void p(c cVar) {
        c G;
        String E;
        c put;
        if (cVar.C().isEmpty() || (put = this.f17781k.put((E = (G = cVar.G()).E()), G)) == null) {
            return;
        }
        this.f17781k.put(E, put);
    }

    private c y(String str) {
        for (int size = this.f17777g.size() - 1; size >= 0; size--) {
            for (TypeSpec typeSpec : this.f17777g.get(size).f17737o) {
                if (androidx.core.graphics.a.a(typeSpec.f17724b, str)) {
                    return z(size, str);
                }
            }
        }
        if (this.f17777g.size() > 0 && androidx.core.graphics.a.a(this.f17777g.get(0).f17724b, str)) {
            return c.w(this.f17776f, str, new String[0]);
        }
        c cVar = this.f17780j.get(str);
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    private c z(int i4, String str) {
        c w3 = c.w(this.f17776f, this.f17777g.get(0).f17724b, new String[0]);
        for (int i5 = 1; i5 <= i4; i5++) {
            w3 = w3.B(this.f17777g.get(i5).f17724b);
        }
        return w3.B(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, c> A() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f17781k);
        linkedHashMap.keySet().removeAll(this.f17782l);
        return linkedHashMap;
    }

    public e B() {
        return C(1);
    }

    public e C(int i4) {
        n.b(this.f17773c - i4 >= 0, "cannot unindent %s from %s", Integer.valueOf(i4), Integer.valueOf(this.f17773c));
        this.f17773c -= i4;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.bumptech.glide.repackaged.com.squareup.javapoet.l] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.bumptech.glide.repackaged.com.squareup.javapoet.l] */
    public e a(d dVar) throws IOException {
        char c4;
        int i4;
        ListIterator<String> listIterator = dVar.f17766a.listIterator();
        c cVar = null;
        int i5 = 0;
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            next.hashCode();
            switch (next.hashCode()) {
                case 1152:
                    if (next.equals("$$")) {
                        c4 = 0;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1176:
                    if (next.equals("$<")) {
                        c4 = 1;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1178:
                    if (next.equals("$>")) {
                        c4 = 2;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1192:
                    if (next.equals("$L")) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1194:
                    if (next.equals("$N")) {
                        c4 = 4;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1199:
                    if (next.equals("$S")) {
                        c4 = 5;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1200:
                    if (next.equals("$T")) {
                        c4 = 6;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1203:
                    if (next.equals("$W")) {
                        c4 = 7;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1207:
                    if (next.equals("$[")) {
                        c4 = '\b';
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1209:
                    if (next.equals("$]")) {
                        c4 = '\t';
                        break;
                    }
                    c4 = '\uffff';
                    break;
                default:
                    c4 = '\uffff';
                    break;
            }
            switch (c4) {
                case 0:
                    d("$");
                    continue;
                case 1:
                    B();
                    continue;
                case 2:
                    r();
                    continue;
                case 3:
                    i4 = i5 + 1;
                    i(dVar.f17767b.get(i5));
                    break;
                case 4:
                    i4 = i5 + 1;
                    d((String) dVar.f17767b.get(i5));
                    break;
                case 5:
                    i4 = i5 + 1;
                    String str = (String) dVar.f17767b.get(i5);
                    d(str != null ? n.l(str, this.f17771a) : "null");
                    break;
                case 6:
                    i4 = i5 + 1;
                    ?? r3 = (l) dVar.f17767b.get(i5);
                    boolean l4 = r3.l();
                    c cVar2 = r3;
                    if (l4) {
                        r3.g(this);
                        cVar2 = r3.p();
                    }
                    if ((cVar2 instanceof c) && listIterator.hasNext() && !dVar.f17766a.get(listIterator.nextIndex()).startsWith("$")) {
                        c cVar3 = cVar2;
                        if (this.f17778h.contains(cVar3.f17763x)) {
                            n.d(cVar == null, "pending type for static import?!", new Object[0]);
                            cVar = cVar3;
                            break;
                        }
                    }
                    cVar2.f(this);
                    break;
                case 7:
                    this.f17772b.c(this.f17773c + 2);
                    continue;
                case '\b':
                    n.d(this.f17784n == -1, "statement enter $[ followed by statement enter $[", new Object[0]);
                    this.f17784n = 0;
                    continue;
                case '\t':
                    n.d(this.f17784n != -1, "statement exit $] has no matching statement enter $[", new Object[0]);
                    if (this.f17784n > 0) {
                        C(2);
                    }
                    this.f17784n = -1;
                    continue;
                default:
                    if (cVar != null) {
                        if (next.startsWith(".") && l(cVar.f17763x, next)) {
                            cVar = null;
                        } else {
                            cVar.f(this);
                            cVar = null;
                        }
                    }
                    d(next);
                    continue;
                    break;
            }
            i5 = i4;
        }
        return this;
    }

    public e b(String str) throws IOException {
        return d(str);
    }

    public e c(String str, Object... objArr) throws IOException {
        return a(d.c(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e d(String str) throws IOException {
        String[] split = str.split("\n", -1);
        int length = split.length;
        int i4 = 0;
        boolean z3 = true;
        while (i4 < length) {
            String str2 = split[i4];
            if (!z3) {
                if ((this.f17774d || this.f17775e) && this.f17783m) {
                    g();
                    this.f17772b.a(this.f17774d ? " *" : "//");
                }
                this.f17772b.a("\n");
                this.f17783m = true;
                int i5 = this.f17784n;
                if (i5 != -1) {
                    if (i5 == 0) {
                        s(2);
                    }
                    this.f17784n++;
                }
            }
            if (!str2.isEmpty()) {
                if (this.f17783m) {
                    g();
                    if (this.f17774d) {
                        this.f17772b.a(" * ");
                    } else if (this.f17775e) {
                        this.f17772b.a("// ");
                    }
                }
                this.f17772b.a(str2);
                this.f17783m = false;
            }
            i4++;
            z3 = false;
        }
        return this;
    }

    public void e(List<a> list, boolean z3) throws IOException {
        for (a aVar : list) {
            aVar.c(this, z3);
            b(z3 ? " " : "\n");
        }
    }

    public void f(d dVar) throws IOException {
        this.f17783m = true;
        this.f17775e = true;
        try {
            a(dVar);
            b("\n");
        } finally {
            this.f17775e = false;
        }
    }

    public void h(d dVar) throws IOException {
        if (dVar.b()) {
            return;
        }
        b("/**\n");
        this.f17774d = true;
        try {
            a(dVar);
            this.f17774d = false;
            b(" */\n");
        } catch (Throwable th) {
            this.f17774d = false;
            throw th;
        }
    }

    public void j(Set<Modifier> set) throws IOException {
        k(set, Collections.emptySet());
    }

    public void k(Set<Modifier> set, Set<Modifier> set2) throws IOException {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = EnumSet.copyOf((Collection) set).iterator();
        while (it.hasNext()) {
            Modifier modifier = (Modifier) it.next();
            if (!set2.contains(modifier)) {
                d(modifier.name().toLowerCase(Locale.US));
                d(" ");
            }
        }
    }

    public void m(List<m> list) throws IOException {
        if (list.isEmpty()) {
            return;
        }
        b("<");
        boolean z3 = true;
        for (m mVar : list) {
            if (!z3) {
                b(", ");
            }
            c("$L", mVar.f17874w);
            boolean z4 = true;
            for (l lVar : mVar.f17875x) {
                c(z4 ? " extends $T" : " & $T", lVar);
                z4 = false;
            }
            z3 = false;
        }
        b(">");
    }

    public e n() throws IOException {
        this.f17772b.c(this.f17773c + 2);
        return this;
    }

    public Map<String, c> q() {
        return this.f17780j;
    }

    public e r() {
        return s(1);
    }

    public e s(int i4) {
        this.f17773c += i4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String t(c cVar) {
        c cVar2 = cVar;
        boolean z3 = false;
        while (cVar2 != null) {
            c y3 = y(cVar2.E());
            boolean z4 = y3 != null;
            if (androidx.core.graphics.a.a(y3, cVar2)) {
                return n.j(".", cVar.F().subList(cVar2.F().size() - 1, cVar.F().size()));
            }
            cVar2 = cVar2.t();
            z3 = z4;
        }
        if (z3) {
            return cVar.f17763x;
        }
        if (androidx.core.graphics.a.a(this.f17776f, cVar.C())) {
            this.f17782l.add(cVar.G().E());
            return n.j(".", cVar.F());
        }
        if (!this.f17774d) {
            p(cVar);
        }
        return cVar.f17763x;
    }

    public e u() {
        String str = this.f17776f;
        String str2 = f17770o;
        n.d(str != str2, "package already set: %s", str);
        this.f17776f = str2;
        return this;
    }

    public e v() {
        List<TypeSpec> list = this.f17777g;
        list.remove(list.size() - 1);
        return this;
    }

    public e w(String str) {
        String str2 = this.f17776f;
        n.d(str2 == f17770o, "package already set: %s", str2);
        this.f17776f = (String) n.c(str, "packageName == null", new Object[0]);
        return this;
    }

    public e x(TypeSpec typeSpec) {
        this.f17777g.add(typeSpec);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Appendable appendable, String str, Set<String> set) {
        this(appendable, str, Collections.emptyMap(), set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Appendable appendable, String str, Map<String, c> map, Set<String> set) {
        this.f17774d = false;
        this.f17775e = false;
        this.f17776f = f17770o;
        this.f17777g = new ArrayList();
        this.f17781k = new LinkedHashMap();
        this.f17782l = new LinkedHashSet();
        this.f17784n = -1;
        this.f17772b = new h(appendable, str, 100);
        this.f17771a = (String) n.c(str, "indent == null", new Object[0]);
        this.f17780j = (Map) n.c(map, "importedTypes == null", new Object[0]);
        this.f17779i = (Set) n.c(set, "staticImports == null", new Object[0]);
        this.f17778h = new LinkedHashSet();
        for (String str2 : set) {
            this.f17778h.add(str2.substring(0, str2.lastIndexOf(46)));
        }
    }
}
