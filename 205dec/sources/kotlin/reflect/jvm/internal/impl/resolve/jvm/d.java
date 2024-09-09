package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import org.jetbrains.annotations.NotNull;

/* compiled from: JvmClassName.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f57878a;

    /* renamed from: b  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.name.c f57879b;

    private d(@NotNull String str) {
        if (str == null) {
            a(5);
        }
        this.f57878a = str;
    }

    private static /* synthetic */ void a(int i4) {
        String str = (i4 == 3 || i4 == 6 || i4 == 7 || i4 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 3 || i4 == 6 || i4 == 7 || i4 == 8) ? 2 : 3];
        switch (i4) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i4 == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i4 == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i4 == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i4 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i4) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 3 && i4 != 6 && i4 != 7 && i4 != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static d b(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar) {
        if (bVar == null) {
            a(1);
        }
        kotlin.reflect.jvm.internal.impl.name.c h4 = bVar.h();
        String replace = bVar.i().b().replace('.', '$');
        if (h4.d()) {
            return new d(replace);
        }
        return new d(h4.b().replace('.', '/') + TTPathConst.sSeparator + replace);
    }

    @NotNull
    public static d c(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        if (cVar == null) {
            a(2);
        }
        d dVar = new d(cVar.b().replace('.', '/'));
        dVar.f57879b = cVar;
        return dVar;
    }

    @NotNull
    public static d d(@NotNull String str) {
        if (str == null) {
            a(0);
        }
        return new d(str);
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c e() {
        return new kotlin.reflect.jvm.internal.impl.name.c(this.f57878a.replace('/', '.'));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f57878a.equals(((d) obj).f57878a);
    }

    @NotNull
    public String f() {
        String str = this.f57878a;
        if (str == null) {
            a(8);
        }
        return str;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c g() {
        int lastIndexOf = this.f57878a.lastIndexOf(TTPathConst.sSeparator);
        if (lastIndexOf == -1) {
            kotlin.reflect.jvm.internal.impl.name.c cVar = kotlin.reflect.jvm.internal.impl.name.c.f57562c;
            if (cVar == null) {
                a(7);
            }
            return cVar;
        }
        return new kotlin.reflect.jvm.internal.impl.name.c(this.f57878a.substring(0, lastIndexOf).replace('/', '.'));
    }

    public int hashCode() {
        return this.f57878a.hashCode();
    }

    public String toString() {
        return this.f57878a;
    }
}
