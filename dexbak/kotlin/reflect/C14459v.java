package kotlin.reflect;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.collections._Arrays;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0015\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, m12616d2 = {"Lkotlin/reflect/v;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/w;", "Ljava/lang/reflect/Type;", "getRawType", "getOwnerType", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "", "getTypeName", "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "toString", "a", "[Ljava/lang/reflect/Type;", "typeArguments", "Ljava/lang/Class;", "b", "Ljava/lang/Class;", "rawType", "c", "Ljava/lang/reflect/Type;", "ownerType", "", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalStdlibApi
/* renamed from: kotlin.reflect.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14459v implements ParameterizedType, InterfaceC14461w {

    /* renamed from: a */
    private final Type[] f41344a;

    /* renamed from: b */
    private final Class<?> f41345b;

    /* renamed from: c */
    private final Type f41346c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypesJVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Ljava/lang/reflect/Type;", "p1", "", "e", "(Ljava/lang/reflect/Type;)Ljava/lang/String;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.v$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final /* synthetic */ class C14460a extends FunctionReferenceImpl implements InterfaceC15280l<Type, String> {

        /* renamed from: a */
        public static final C14460a f41347a = new C14460a();

        C14460a() {
            super(1, C14432a0.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // p617l1.InterfaceC15280l
        @NotNull
        /* renamed from: e */
        public final String invoke(@NotNull Type p1) {
            String m7369j;
            C14342f0.m8184p(p1, "p1");
            m7369j = C14432a0.m7369j(p1);
            return m7369j;
        }
    }

    public C14459v(@NotNull Class<?> rawType, @Nullable Type type, @NotNull List<? extends Type> typeArguments) {
        C14342f0.m8184p(rawType, "rawType");
        C14342f0.m8184p(typeArguments, "typeArguments");
        this.f41345b = rawType;
        this.f41346c = type;
        Object[] array = typeArguments.toArray(new Type[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.f41344a = (Type[]) array;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (C14342f0.m8193g(this.f41345b, parameterizedType.getRawType()) && C14342f0.m8193g(this.f41346c, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type[] getActualTypeArguments() {
        return this.f41344a;
    }

    @Override // java.lang.reflect.ParameterizedType
    @Nullable
    public Type getOwnerType() {
        return this.f41346c;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type getRawType() {
        return this.f41345b;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.InterfaceC14461w
    @NotNull
    public String getTypeName() {
        String m7369j;
        String m7369j2;
        StringBuilder sb = new StringBuilder();
        Type type = this.f41346c;
        if (type != null) {
            m7369j2 = C14432a0.m7369j(type);
            sb.append(m7369j2);
            sb.append("$");
            sb.append(this.f41345b.getSimpleName());
        } else {
            m7369j = C14432a0.m7369j(this.f41345b);
            sb.append(m7369j);
        }
        Type[] typeArr = this.f41344a;
        if (!(typeArr.length == 0)) {
            _Arrays.m10127qg(typeArr, sb, null, "<", ">", 0, null, C14460a.f41347a, 50, null);
        }
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        int hashCode = this.f41345b.hashCode();
        Type type = this.f41346c;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
