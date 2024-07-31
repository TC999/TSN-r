package kotlin.properties;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.reflect.InterfaceC14446n;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15285q;

@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0001J\u0082\u0001\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0005\u001a\u00028\u00002Q\b\u0004\u0010\u000e\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0082\u0001\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0005\u001a\u00028\u00002Q\b\u0004\u0010\u000e\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00110\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, m12616d2 = {"Lkotlin/properties/a;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/properties/f;", "a", "initialValue", "Lkotlin/Function3;", "Lkotlin/reflect/n;", "Lkotlin/ParameterName;", "name", "property", "oldValue", "newValue", "Lkotlin/f1;", "onChange", "b", "(Ljava/lang/Object;Ll1/q;)Lkotlin/properties/f;", "", "c", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.properties.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Delegates {
    @NotNull

    /* renamed from: a */
    public static final Delegates f41251a = new Delegates();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Delegates.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m12616d2 = {"kotlin/properties/a$a", "Lkotlin/properties/c;", "Lkotlin/reflect/n;", "property", "oldValue", "newValue", "Lkotlin/f1;", "c", "(Lkotlin/reflect/n;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.properties.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14382a<T> extends ObservableProperty<T> {

        /* renamed from: b */
        final /* synthetic */ InterfaceC15285q f41252b;

        /* renamed from: c */
        final /* synthetic */ Object f41253c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14382a(InterfaceC15285q interfaceC15285q, Object obj, Object obj2) {
            super(obj2);
            this.f41252b = interfaceC15285q;
            this.f41253c = obj;
        }

        @Override // kotlin.properties.ObservableProperty
        /* renamed from: c */
        protected void mo7732c(@NotNull InterfaceC14446n<?> property, T t, T t2) {
            C14342f0.m8184p(property, "property");
            this.f41252b.invoke(property, t, t2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Delegates.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m12616d2 = {"kotlin/properties/a$b", "Lkotlin/properties/c;", "Lkotlin/reflect/n;", "property", "oldValue", "newValue", "", "d", "(Lkotlin/reflect/n;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.properties.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14383b<T> extends ObservableProperty<T> {

        /* renamed from: b */
        final /* synthetic */ InterfaceC15285q f41254b;

        /* renamed from: c */
        final /* synthetic */ Object f41255c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14383b(InterfaceC15285q interfaceC15285q, Object obj, Object obj2) {
            super(obj2);
            this.f41254b = interfaceC15285q;
            this.f41255c = obj;
        }

        @Override // kotlin.properties.ObservableProperty
        /* renamed from: d */
        protected boolean mo7731d(@NotNull InterfaceC14446n<?> property, T t, T t2) {
            C14342f0.m8184p(property, "property");
            return ((Boolean) this.f41254b.invoke(property, t, t2)).booleanValue();
        }
    }

    private Delegates() {
    }

    @NotNull
    /* renamed from: a */
    public final <T> InterfaceC14386f<Object, T> m7735a() {
        return new C14384b();
    }

    @NotNull
    /* renamed from: b */
    public final <T> InterfaceC14386f<Object, T> m7734b(T t, @NotNull InterfaceC15285q<? super InterfaceC14446n<?>, ? super T, ? super T, Unit> onChange) {
        C14342f0.m8184p(onChange, "onChange");
        return new C14382a(onChange, t, t);
    }

    @NotNull
    /* renamed from: c */
    public final <T> InterfaceC14386f<Object, T> m7733c(T t, @NotNull InterfaceC15285q<? super InterfaceC14446n<?>, ? super T, ? super T, Boolean> onChange) {
        C14342f0.m8184p(onChange, "onChange");
        return new C14383b(onChange, t, t);
    }
}
