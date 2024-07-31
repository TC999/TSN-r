package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Standard;
import kotlin.collections.C14236x;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J'\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0014*\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007¢\u0006\u0004\b\u001b\u0010\u001aJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007¢\u0006\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001e¨\u0006\""}, m12616d2 = {"Lkotlin/reflect/y;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/w;", "", "getName", "getGenericDeclaration", "", "Ljava/lang/reflect/Type;", "getBounds", "()[Ljava/lang/reflect/Type;", "getTypeName", "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "toString", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "annotationClass", "b", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "c", "()[Ljava/lang/annotation/Annotation;", "d", "a", "Lkotlin/reflect/s;", "Lkotlin/reflect/s;", "typeParameter", "<init>", "(Lkotlin/reflect/s;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalStdlibApi
/* renamed from: kotlin.reflect.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14462y implements TypeVariable<GenericDeclaration>, InterfaceC14461w {

    /* renamed from: a */
    private final KTypeParameter f41348a;

    public C14462y(@NotNull KTypeParameter typeParameter) {
        C14342f0.m8184p(typeParameter, "typeParameter");
        this.f41348a = typeParameter;
    }

    @NotNull
    /* renamed from: a */
    public final Annotation[] m7299a() {
        return new Annotation[0];
    }

    @Nullable
    /* renamed from: b */
    public final <T extends Annotation> T m7298b(@NotNull Class<T> annotationClass) {
        C14342f0.m8184p(annotationClass, "annotationClass");
        return null;
    }

    @NotNull
    /* renamed from: c */
    public final Annotation[] m7297c() {
        return new Annotation[0];
    }

    @NotNull
    /* renamed from: d */
    public final Annotation[] m7296d() {
        return new Annotation[0];
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (C14342f0.m8193g(getName(), typeVariable.getName()) && C14342f0.m8193g(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public Type[] getBounds() {
        int m8957Y;
        Type m7376c;
        List<KType> upperBounds = this.f41348a.getUpperBounds();
        m8957Y = C14236x.m8957Y(upperBounds, 10);
        ArrayList arrayList = new ArrayList(m8957Y);
        for (KType kType : upperBounds) {
            m7376c = C14432a0.m7376c(kType, true);
            arrayList.add(m7376c);
        }
        Object[] array = arrayList.toArray(new Type[0]);
        if (array != null) {
            return (Type[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public GenericDeclaration getGenericDeclaration() {
        throw new Standard("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f41348a));
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public String getName() {
        return this.f41348a.getName();
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.InterfaceC14461w
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
