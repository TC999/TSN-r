package kotlin.reflect.jvm.internal.impl.name;

import org.jetbrains.annotations.NotNull;

/* compiled from: Name.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f implements Comparable<f> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f57573a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f57574b;

    private f(@NotNull String str, boolean z3) {
        if (str == null) {
            a(0);
        }
        this.f57573a = str;
        this.f57574b = z3;
    }

    private static /* synthetic */ void a(int i4) {
        String str = (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4) ? 2 : 3];
        if (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i4 == 1) {
            objArr[1] = "asString";
        } else if (i4 == 2) {
            objArr[1] = "getIdentifier";
        } else if (i4 == 3 || i4 == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i4) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 1 && i4 != 2 && i4 != 3 && i4 != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static f e(@NotNull String str) {
        if (str == null) {
            a(8);
        }
        if (str.startsWith("<")) {
            return i(str);
        }
        return f(str);
    }

    @NotNull
    public static f f(@NotNull String str) {
        if (str == null) {
            a(5);
        }
        return new f(str, false);
    }

    public static boolean h(@NotNull String str) {
        if (str == null) {
            a(6);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static f i(@NotNull String str) {
        if (str == null) {
            a(7);
        }
        if (str.startsWith("<")) {
            return new f(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    @NotNull
    public String b() {
        String str = this.f57573a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(f fVar) {
        return this.f57573a.compareTo(fVar.f57573a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f57574b == fVar.f57574b && this.f57573a.equals(fVar.f57573a);
        }
        return false;
    }

    public boolean g() {
        return this.f57574b;
    }

    @NotNull
    public String getIdentifier() {
        if (!this.f57574b) {
            String b4 = b();
            if (b4 == null) {
                a(2);
            }
            return b4;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public int hashCode() {
        return (this.f57573a.hashCode() * 31) + (this.f57574b ? 1 : 0);
    }

    public String toString() {
        return this.f57573a;
    }
}
