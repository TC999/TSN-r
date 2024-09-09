package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* compiled from: CodeBlock.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f17764c = Pattern.compile("\\$(?<argumentName>[\\w_]+):(?<typeChar>[\\w]).*");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f17765d = Pattern.compile("[a-z]+[\\w_]*");

    /* renamed from: a  reason: collision with root package name */
    final List<String> f17766a;

    /* renamed from: b  reason: collision with root package name */
    final List<Object> f17767b;

    /* compiled from: CodeBlock.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f17768a;

        /* renamed from: b  reason: collision with root package name */
        final List<Object> f17769b;

        private void c(String str, char c4, Object obj) {
            if (c4 == 'L') {
                this.f17769b.add(e(obj));
            } else if (c4 == 'N') {
                this.f17769b.add(f(obj));
            } else if (c4 == 'S') {
                this.f17769b.add(g(obj));
            } else if (c4 == 'T') {
                this.f17769b.add(h(obj));
            } else {
                throw new IllegalArgumentException(String.format("invalid format string: '%s'", str));
            }
        }

        private Object e(Object obj) {
            return obj;
        }

        private String f(Object obj) {
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof j) {
                return ((j) obj).f17839a;
            }
            if (obj instanceof f) {
                return ((f) obj).f17786b;
            }
            if (obj instanceof i) {
                return ((i) obj).f17817a;
            }
            if (obj instanceof TypeSpec) {
                return ((TypeSpec) obj).f17724b;
            }
            throw new IllegalArgumentException("expected name but was " + obj);
        }

        private String g(Object obj) {
            if (obj != null) {
                return String.valueOf(obj);
            }
            return null;
        }

        private l h(Object obj) {
            if (obj instanceof l) {
                return (l) obj;
            }
            if (obj instanceof TypeMirror) {
                return l.j((TypeMirror) obj);
            }
            if (obj instanceof Element) {
                return l.j(((Element) obj).asType());
            }
            if (obj instanceof Type) {
                return l.h((Type) obj);
            }
            throw new IllegalArgumentException("expected type but was " + obj);
        }

        private boolean m(char c4) {
            return c4 == '$' || c4 == '>' || c4 == '<' || c4 == '[' || c4 == ']' || c4 == 'W';
        }

        public b a(d dVar) {
            this.f17768a.addAll(dVar.f17766a);
            this.f17769b.addAll(dVar.f17767b);
            return this;
        }

        public b b(String str, Object... objArr) {
            int i4;
            boolean z3;
            int i5;
            char charAt;
            boolean z4;
            int i6;
            int[] iArr = new int[objArr.length];
            int i7 = 0;
            boolean z5 = false;
            int i8 = 0;
            boolean z6 = false;
            while (true) {
                if (i7 >= str.length()) {
                    break;
                } else if (str.charAt(i7) != '$') {
                    int indexOf = str.indexOf(36, i7 + 1);
                    if (indexOf == -1) {
                        indexOf = str.length();
                    }
                    this.f17768a.add(str.substring(i7, indexOf));
                    i7 = indexOf;
                } else {
                    int i9 = i7 + 1;
                    int i10 = i9;
                    while (true) {
                        n.b(i10 < str.length(), "dangling format characters in '%s'", str);
                        i5 = i10 + 1;
                        charAt = str.charAt(i10);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i10 = i5;
                    }
                    int i11 = i5 - 1;
                    if (m(charAt)) {
                        n.b(i9 == i11, "$$, $>, $<, $[, $], and $W may not have an index", new Object[0]);
                        this.f17768a.add("$" + charAt);
                        i7 = i5;
                    } else {
                        if (i9 < i11) {
                            int parseInt = Integer.parseInt(str.substring(i9, i11)) - 1;
                            if (objArr.length > 0) {
                                int length = parseInt % objArr.length;
                                iArr[length] = iArr[length] + 1;
                            }
                            z4 = true;
                            i6 = i8;
                            i8 = parseInt;
                        } else {
                            z4 = z6;
                            i6 = i8 + 1;
                            z5 = true;
                        }
                        n.b(i8 >= 0 && i8 < objArr.length, "index %d for '%s' not in range (received %s arguments)", Integer.valueOf(i8 + 1), str.substring(i9 - 1, i11 + 1), Integer.valueOf(objArr.length));
                        n.b((z4 && z5) ? false : true, "cannot mix indexed and positional parameters", new Object[0]);
                        c(str, charAt, objArr[i8]);
                        this.f17768a.add("$" + charAt);
                        i8 = i6;
                        i7 = i5;
                        z6 = z4;
                    }
                }
            }
            if (z5) {
                if (i8 >= objArr.length) {
                    i4 = 2;
                    z3 = true;
                } else {
                    i4 = 2;
                    z3 = false;
                }
                Object[] objArr2 = new Object[i4];
                objArr2[0] = Integer.valueOf(i8);
                objArr2[1] = Integer.valueOf(objArr.length);
                n.b(z3, "unused arguments: expected %s, received %s", objArr2);
            }
            if (z6) {
                ArrayList arrayList = new ArrayList();
                for (int i12 = 0; i12 < objArr.length; i12++) {
                    if (iArr[i12] == 0) {
                        arrayList.add("$" + (i12 + 1));
                    }
                }
                n.b(arrayList.isEmpty(), "unused argument%s: %s", arrayList.size() == 1 ? "" : "s", n.j(", ", arrayList));
            }
            return this;
        }

        public b d(String str, Object... objArr) {
            b("$[", new Object[0]);
            b(str, objArr);
            b(";\n$]", new Object[0]);
            return this;
        }

        public b i(String str, Object... objArr) {
            b(str + " {\n", objArr);
            l();
            return this;
        }

        public d j() {
            return new d(this);
        }

        public b k() {
            o();
            b("}\n", new Object[0]);
            return this;
        }

        public b l() {
            this.f17768a.add("$>");
            return this;
        }

        public b n(String str, Object... objArr) {
            o();
            b("} " + str + " {\n", objArr);
            l();
            return this;
        }

        public b o() {
            this.f17768a.add("$<");
            return this;
        }

        private b() {
            this.f17768a = new ArrayList();
            this.f17769b = new ArrayList();
        }
    }

    public static b a() {
        return new b();
    }

    public static d c(String str, Object... objArr) {
        return new b().b(str, objArr).j();
    }

    public boolean b() {
        return this.f17766a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new e(stringWriter).a(this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private d(b bVar) {
        this.f17766a = n.f(bVar.f17768a);
        this.f17767b = n.f(bVar.f17769b);
    }
}
