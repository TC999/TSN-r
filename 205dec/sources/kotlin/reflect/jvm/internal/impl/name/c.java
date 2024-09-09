package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: FqName.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static final c f57562c = new c("");
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d f57563a;

    /* renamed from: b  reason: collision with root package name */
    private transient c f57564b;

    public c(@NotNull String str) {
        if (str == null) {
            a(1);
        }
        this.f57563a = new d(str, this);
    }

    private static /* synthetic */ void a(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i5 = 2;
                break;
            case 8:
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i4) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i4) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            case 8:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    public static c k(@NotNull f fVar) {
        if (fVar == null) {
            a(13);
        }
        return new c(d.m(fVar));
    }

    @NotNull
    public String b() {
        String b4 = this.f57563a.b();
        if (b4 == null) {
            a(4);
        }
        return b4;
    }

    @NotNull
    public c c(@NotNull f fVar) {
        if (fVar == null) {
            a(8);
        }
        return new c(this.f57563a.c(fVar), this);
    }

    public boolean d() {
        return this.f57563a.e();
    }

    @NotNull
    public c e() {
        c cVar = this.f57564b;
        if (cVar != null) {
            if (cVar == null) {
                a(6);
            }
            return cVar;
        } else if (!d()) {
            c cVar2 = new c(this.f57563a.g());
            this.f57564b = cVar2;
            return cVar2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f57563a.equals(((c) obj).f57563a);
    }

    @NotNull
    public List<f> f() {
        List<f> h4 = this.f57563a.h();
        if (h4 == null) {
            a(11);
        }
        return h4;
    }

    @NotNull
    public f g() {
        f i4 = this.f57563a.i();
        if (i4 == null) {
            a(9);
        }
        return i4;
    }

    @NotNull
    public f h() {
        f j4 = this.f57563a.j();
        if (j4 == null) {
            a(10);
        }
        return j4;
    }

    public int hashCode() {
        return this.f57563a.hashCode();
    }

    public boolean i(@NotNull f fVar) {
        if (fVar == null) {
            a(12);
        }
        return this.f57563a.k(fVar);
    }

    @NotNull
    public d j() {
        d dVar = this.f57563a;
        if (dVar == null) {
            a(5);
        }
        return dVar;
    }

    public String toString() {
        return this.f57563a.toString();
    }

    public c(@NotNull d dVar) {
        if (dVar == null) {
            a(2);
        }
        this.f57563a = dVar;
    }

    private c(@NotNull d dVar, c cVar) {
        if (dVar == null) {
            a(3);
        }
        this.f57563a = dVar;
        this.f57564b = cVar;
    }
}
