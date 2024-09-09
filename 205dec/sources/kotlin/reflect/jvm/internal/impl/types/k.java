package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassTypeConstructorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class k extends b implements y0 {

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f58389d;

    /* renamed from: e  reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.descriptors.a1> f58390e;

    /* renamed from: f  reason: collision with root package name */
    private final Collection<e0> f58391f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull List<? extends kotlin.reflect.jvm.internal.impl.descriptors.a1> list, @NotNull Collection<e0> collection, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        super(nVar);
        if (dVar == null) {
            t(0);
        }
        if (list == null) {
            t(1);
        }
        if (collection == null) {
            t(2);
        }
        if (nVar == null) {
            t(3);
        }
        this.f58389d = dVar;
        this.f58390e = Collections.unmodifiableList(new ArrayList(list));
        this.f58391f = Collections.unmodifiableCollection(collection);
    }

    private static /* synthetic */ void t(int i4) {
        String str = (i4 == 4 || i4 == 5 || i4 == 6 || i4 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 4 || i4 == 5 || i4 == 6 || i4 == 7) ? 2 : 3];
        switch (i4) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i4 == 4) {
            objArr[1] = "getParameters";
        } else if (i4 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i4 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i4 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i4 != 4 && i4 != 5 && i4 != 6 && i4 != 7) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i4 != 4 && i4 != 5 && i4 != 6 && i4 != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    public boolean c() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.a1> getParameters() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.a1> list = this.f58390e;
        if (list == null) {
            t(4);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g
    @NotNull
    protected Collection<e0> i() {
        Collection<e0> collection = this.f58391f;
        if (collection == null) {
            t(6);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.descriptors.y0 o() {
        y0.a aVar = y0.a.f56639a;
        if (aVar == null) {
            t(7);
        }
        return aVar;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.resolve.d.m(this.f58389d).b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b, kotlin.reflect.jvm.internal.impl.types.l, kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    /* renamed from: u */
    public kotlin.reflect.jvm.internal.impl.descriptors.d b() {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = this.f58389d;
        if (dVar == null) {
            t(5);
        }
        return dVar;
    }
}
