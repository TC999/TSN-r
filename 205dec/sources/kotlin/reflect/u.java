package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TypesJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0018\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lkotlin/reflect/u;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/v;", "Ljava/lang/reflect/Type;", "getRawType", "getOwnerType", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "", "getTypeName", "", "other", "", "equals", "", "hashCode", "toString", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "rawType", "b", "Ljava/lang/reflect/Type;", "ownerType", "c", "[Ljava/lang/reflect/Type;", "typeArguments", "", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalStdlibApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u implements ParameterizedType, v {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f58690a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Type f58691b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Type[] f58692c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypesJVM.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a extends FunctionReferenceImpl implements d2.l<Type, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f58693a = new a();

        a() {
            super(1, y.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final String invoke(@NotNull Type p02) {
            String j4;
            f0.p(p02, "p0");
            j4 = y.j(p02);
            return j4;
        }
    }

    public u(@NotNull Class<?> rawType, @Nullable Type type, @NotNull List<? extends Type> typeArguments) {
        f0.p(rawType, "rawType");
        f0.p(typeArguments, "typeArguments");
        this.f58690a = rawType;
        this.f58691b = type;
        Object[] array = typeArguments.toArray(new Type[0]);
        if (array != null) {
            this.f58692c = (Type[]) array;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (f0.g(this.f58690a, parameterizedType.getRawType()) && f0.g(this.f58691b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type[] getActualTypeArguments() {
        return this.f58692c;
    }

    @Override // java.lang.reflect.ParameterizedType
    @Nullable
    public Type getOwnerType() {
        return this.f58691b;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NotNull
    public Type getRawType() {
        return this.f58690a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.v
    @NotNull
    public String getTypeName() {
        String j4;
        String j5;
        StringBuilder sb = new StringBuilder();
        Type type = this.f58691b;
        if (type != null) {
            j5 = y.j(type);
            sb.append(j5);
            sb.append("$");
            sb.append(this.f58690a.getSimpleName());
        } else {
            j4 = y.j(this.f58690a);
            sb.append(j4);
        }
        Type[] typeArr = this.f58692c;
        if (!(typeArr.length == 0)) {
            kotlin.collections.p.qg(typeArr, sb, null, "<", ">", 0, null, a.f58693a, 50, null);
        }
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        int hashCode = this.f58690a.hashCode();
        Type type = this.f58691b;
        return (hashCode ^ (type == null ? 0 : type.hashCode())) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
