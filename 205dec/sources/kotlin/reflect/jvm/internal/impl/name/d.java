package kotlin.reflect.jvm.internal.impl.name;

import d2.l;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* compiled from: FqNameUnsafe.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {

    /* renamed from: e  reason: collision with root package name */
    private static final f f57565e = f.i("<root>");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f57566f = Pattern.compile("\\.");

    /* renamed from: g  reason: collision with root package name */
    private static final l<String, f> f57567g = new a();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f57568a;

    /* renamed from: b  reason: collision with root package name */
    private transient c f57569b;

    /* renamed from: c  reason: collision with root package name */
    private transient d f57570c;

    /* renamed from: d  reason: collision with root package name */
    private transient f f57571d;

    /* compiled from: FqNameUnsafe.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements l<String, f> {
        a() {
        }

        @Override // d2.l
        /* renamed from: a */
        public f invoke(String str) {
            return f.e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(@NotNull String str, @NotNull c cVar) {
        if (str == null) {
            a(0);
        }
        if (cVar == null) {
            a(1);
        }
        this.f57568a = str;
        this.f57569b = cVar;
    }

    private static /* synthetic */ void a(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i5 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        if (i4 != 1) {
            switch (i4) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i4) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(format);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    private void d() {
        int lastIndexOf = this.f57568a.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.f57571d = f.e(this.f57568a.substring(lastIndexOf + 1));
            this.f57570c = new d(this.f57568a.substring(0, lastIndexOf));
            return;
        }
        this.f57571d = f.e(this.f57568a);
        this.f57570c = c.f57562c.j();
    }

    @NotNull
    public static d m(@NotNull f fVar) {
        if (fVar == null) {
            a(16);
        }
        return new d(fVar.b(), c.f57562c.j(), fVar);
    }

    @NotNull
    public String b() {
        String str = this.f57568a;
        if (str == null) {
            a(4);
        }
        return str;
    }

    @NotNull
    public d c(@NotNull f fVar) {
        String str;
        if (fVar == null) {
            a(9);
        }
        if (e()) {
            str = fVar.b();
        } else {
            str = this.f57568a + "." + fVar.b();
        }
        return new d(str, this, fVar);
    }

    public boolean e() {
        return this.f57568a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f57568a.equals(((d) obj).f57568a);
    }

    public boolean f() {
        return this.f57569b != null || b().indexOf(60) < 0;
    }

    @NotNull
    public d g() {
        d dVar = this.f57570c;
        if (dVar != null) {
            if (dVar == null) {
                a(7);
            }
            return dVar;
        } else if (!e()) {
            d();
            d dVar2 = this.f57570c;
            if (dVar2 == null) {
                a(8);
            }
            return dVar2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @NotNull
    public List<f> h() {
        List<f> emptyList = e() ? Collections.emptyList() : kotlin.collections.l.Kh(f57566f.split(this.f57568a), f57567g);
        if (emptyList == null) {
            a(14);
        }
        return emptyList;
    }

    public int hashCode() {
        return this.f57568a.hashCode();
    }

    @NotNull
    public f i() {
        f fVar = this.f57571d;
        if (fVar != null) {
            if (fVar == null) {
                a(10);
            }
            return fVar;
        } else if (!e()) {
            d();
            f fVar2 = this.f57571d;
            if (fVar2 == null) {
                a(11);
            }
            return fVar2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    @NotNull
    public f j() {
        if (e()) {
            f fVar = f57565e;
            if (fVar == null) {
                a(12);
            }
            return fVar;
        }
        f i4 = i();
        if (i4 == null) {
            a(13);
        }
        return i4;
    }

    public boolean k(@NotNull f fVar) {
        if (fVar == null) {
            a(15);
        }
        if (e()) {
            return false;
        }
        int indexOf = this.f57568a.indexOf(46);
        String str = this.f57568a;
        String b4 = fVar.b();
        if (indexOf == -1) {
            indexOf = this.f57568a.length();
        }
        return str.regionMatches(0, b4, 0, indexOf);
    }

    @NotNull
    public c l() {
        c cVar = this.f57569b;
        if (cVar != null) {
            if (cVar == null) {
                a(5);
            }
            return cVar;
        }
        c cVar2 = new c(this);
        this.f57569b = cVar2;
        return cVar2;
    }

    @NotNull
    public String toString() {
        String b4 = e() ? f57565e.b() : this.f57568a;
        if (b4 == null) {
            a(17);
        }
        return b4;
    }

    public d(@NotNull String str) {
        if (str == null) {
            a(2);
        }
        this.f57568a = str;
    }

    private d(@NotNull String str, d dVar, f fVar) {
        if (str == null) {
            a(3);
        }
        this.f57568a = str;
        this.f57570c = dVar;
        this.f57571d = fVar;
    }
}
