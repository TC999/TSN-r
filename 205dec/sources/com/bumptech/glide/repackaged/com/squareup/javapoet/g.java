package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;

/* compiled from: JavaFile.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class g {

    /* renamed from: g  reason: collision with root package name */
    private static final Appendable f17797g = new a();

    /* renamed from: a  reason: collision with root package name */
    public final d f17798a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17799b;

    /* renamed from: c  reason: collision with root package name */
    public final TypeSpec f17800c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17801d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<String> f17802e;

    /* renamed from: f  reason: collision with root package name */
    private final String f17803f;

    /* compiled from: JavaFile.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    final class a implements Appendable {
        a() {
        }

        @Override // java.lang.Appendable
        public Appendable append(char c4) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i4, int i5) {
            return this;
        }
    }

    /* compiled from: JavaFile.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f17804a;

        /* renamed from: b  reason: collision with root package name */
        private final TypeSpec f17805b;

        /* renamed from: c  reason: collision with root package name */
        private final d.b f17806c;

        /* renamed from: d  reason: collision with root package name */
        private final Set<String> f17807d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f17808e;

        /* renamed from: f  reason: collision with root package name */
        private String f17809f;

        /* synthetic */ b(String str, TypeSpec typeSpec, a aVar) {
            this(str, typeSpec);
        }

        public g g() {
            return new g(this, null);
        }

        private b(String str, TypeSpec typeSpec) {
            this.f17806c = d.a();
            this.f17807d = new TreeSet();
            this.f17809f = "  ";
            this.f17804a = str;
            this.f17805b = typeSpec;
        }
    }

    /* synthetic */ g(b bVar, a aVar) {
        this(bVar);
    }

    public static b a(String str, TypeSpec typeSpec) {
        n.c(str, "packageName == null", new Object[0]);
        n.c(typeSpec, "typeSpec == null", new Object[0]);
        return new b(str, typeSpec, null);
    }

    private void b(e eVar) throws IOException {
        eVar.w(this.f17799b);
        if (!this.f17798a.b()) {
            eVar.f(this.f17798a);
        }
        if (!this.f17799b.isEmpty()) {
            eVar.c("package $L;\n", this.f17799b);
            eVar.b("\n");
        }
        if (!this.f17802e.isEmpty()) {
            Iterator<String> it = this.f17802e.iterator();
            while (it.hasNext()) {
                eVar.c("import static $L;\n", (String) it.next());
            }
            eVar.b("\n");
        }
        Iterator it2 = new TreeSet(eVar.q().values()).iterator();
        int i4 = 0;
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            if (!this.f17801d || !cVar.C().equals("java.lang")) {
                eVar.c("import $L;\n", cVar);
                i4++;
            }
        }
        if (i4 > 0) {
            eVar.b("\n");
        }
        this.f17800c.b(eVar, null, Collections.emptySet());
        eVar.u();
    }

    public void c(Appendable appendable) throws IOException {
        e eVar = new e(f17797g, this.f17803f, this.f17802e);
        b(eVar);
        b(new e(appendable, this.f17803f, eVar.A(), this.f17802e));
    }

    public void d(Filer filer) throws IOException {
        String str;
        if (this.f17799b.isEmpty()) {
            str = this.f17800c.f17724b;
        } else {
            str = this.f17799b + "." + this.f17800c.f17724b;
        }
        List<Element> list = this.f17800c.f17738p;
        JavaFileObject createSourceFile = filer.createSourceFile(str, (Element[]) list.toArray(new Element[list.size()]));
        try {
            Writer openWriter = createSourceFile.openWriter();
            c(openWriter);
            if (openWriter != null) {
                openWriter.close();
            }
        } catch (Exception e4) {
            try {
                createSourceFile.delete();
            } catch (Exception unused) {
            }
            throw e4;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            c(sb);
            return sb.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private g(b bVar) {
        this.f17798a = bVar.f17806c.j();
        this.f17799b = bVar.f17804a;
        this.f17800c = bVar.f17805b;
        this.f17801d = bVar.f17808e;
        this.f17802e = n.i(bVar.f17807d);
        this.f17803f = bVar.f17809f;
    }
}
