package kotlin.properties;

import d2.q;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;

/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Delegates.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0001J\u0082\u0001\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0005\u001a\u00028\u00002Q\b\u0004\u0010\u000e\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0082\u0001\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0005\u001a\u00028\u00002Q\b\u0004\u0010\u000e\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00110\u0006H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0015"}, d2 = {"Lkotlin/properties/a;", "", "T", "Lkotlin/properties/f;", "a", "initialValue", "Lkotlin/Function3;", "Lkotlin/reflect/n;", "Lkotlin/ParameterName;", "name", "property", "oldValue", "newValue", "Lkotlin/f1;", "onChange", "b", "(Ljava/lang/Object;Ld2/q;)Lkotlin/properties/f;", "", "c", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f55750a = new a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Delegates.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"kotlin/properties/a$a", "Lkotlin/properties/c;", "Lkotlin/reflect/n;", "property", "oldValue", "newValue", "Lkotlin/f1;", "c", "(Lkotlin/reflect/n;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.properties.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1103a<T> extends c<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ T f55751b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ q<n<?>, T, T, f1> f55752c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C1103a(T t3, q<? super n<?>, ? super T, ? super T, f1> qVar) {
            super(t3);
            this.f55751b = t3;
            this.f55752c = qVar;
        }

        @Override // kotlin.properties.c
        protected void c(@NotNull n<?> property, T t3, T t4) {
            f0.p(property, "property");
            this.f55752c.invoke(property, t3, t4);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Delegates.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"kotlin/properties/a$b", "Lkotlin/properties/c;", "Lkotlin/reflect/n;", "property", "oldValue", "newValue", "", "d", "(Lkotlin/reflect/n;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends c<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ T f55753b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ q<n<?>, T, T, Boolean> f55754c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(T t3, q<? super n<?>, ? super T, ? super T, Boolean> qVar) {
            super(t3);
            this.f55753b = t3;
            this.f55754c = qVar;
        }

        @Override // kotlin.properties.c
        protected boolean d(@NotNull n<?> property, T t3, T t4) {
            f0.p(property, "property");
            return this.f55754c.invoke(property, t3, t4).booleanValue();
        }
    }

    static {
    }

    private a() {
    }

    @NotNull
    public final <T> f<Object, T> a() {
        return new kotlin.properties.b();
    }

    @NotNull
    public final <T> f<Object, T> b(T t3, @NotNull q<? super n<?>, ? super T, ? super T, f1> onChange) {
        f0.p(onChange, "onChange");
        return new C1103a(t3, onChange);
    }

    @NotNull
    public final <T> f<Object, T> c(T t3, @NotNull q<? super n<?>, ? super T, ? super T, Boolean> onChange) {
        f0.p(onChange, "onChange");
        return new b(t3, onChange);
    }
}
