package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TypesJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J'\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001aJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001e\u00a8\u0006\""}, d2 = {"Lkotlin/reflect/x;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/v;", "", "getName", "getGenericDeclaration", "", "Ljava/lang/reflect/Type;", "getBounds", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "other", "", "equals", "", "hashCode", "toString", "", "T", "Ljava/lang/Class;", "annotationClass", "b", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "c", "()[Ljava/lang/annotation/Annotation;", "d", "a", "Lkotlin/reflect/s;", "Lkotlin/reflect/s;", "typeParameter", "<init>", "(Lkotlin/reflect/s;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalStdlibApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x implements TypeVariable<GenericDeclaration>, v {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final s f58695a;

    public x(@NotNull s typeParameter) {
        f0.p(typeParameter, "typeParameter");
        this.f58695a = typeParameter;
    }

    @NotNull
    public final Annotation[] a() {
        return new Annotation[0];
    }

    @Nullable
    public final <T extends Annotation> T b(@NotNull Class<T> annotationClass) {
        f0.p(annotationClass, "annotationClass");
        return null;
    }

    @NotNull
    public final Annotation[] c() {
        return new Annotation[0];
    }

    @NotNull
    public final Annotation[] d() {
        return new Annotation[0];
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (f0.g(getName(), typeVariable.getName()) && f0.g(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public Type[] getBounds() {
        int Z;
        Type c4;
        List<r> upperBounds = this.f58695a.getUpperBounds();
        Z = kotlin.collections.y.Z(upperBounds, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (r rVar : upperBounds) {
            c4 = y.c(rVar, true);
            arrayList.add(c4);
        }
        Object[] array = arrayList.toArray(new Type[0]);
        if (array != null) {
            return (Type[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError(f0.C("An operation is not implemented: ", f0.C("getGenericDeclaration() is not yet supported for type variables created from KType: ", this.f58695a)));
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public String getName() {
        return this.f58695a.getName();
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.v
    @NotNull
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
