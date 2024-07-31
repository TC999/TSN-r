package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Distinct.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001aT\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\t\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u001a6\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u001aw\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\"0\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f8\u0002X\u0083\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\"6\u0010\u0018\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\b0\u00038\u0002X\u0083\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "a", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "areEquivalent", "b", "K", "Lkotlin/Function1;", "keySelector", "c", "", "d", "(Lkotlinx/coroutines/flow/h;Ll1/l;Ll1/p;)Lkotlinx/coroutines/flow/h;", "defaultKeySelector", "Ll1/l;", "g", "()Ll1/l;", "getDefaultKeySelector$FlowKt__DistinctKt$annotations", "()V", "defaultAreEquivalent", "Ll1/p;", "e", "()Ll1/p;", "getDefaultAreEquivalent$FlowKt__DistinctKt$annotations", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C15034p {

    /* renamed from: a */
    private static final InterfaceC15280l<Object, Object> f42965a = C15036b.f42968a;

    /* renamed from: b */
    private static final InterfaceC15284p<Object, Object, Boolean> f42966b = C15035a.f42967a;

    /* compiled from: Distinct.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"", "old", "new", "", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Z"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.p$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15035a extends Lambda implements InterfaceC15284p<Object, Object, Boolean> {

        /* renamed from: a */
        public static final C15035a f42967a = new C15035a();

        C15035a() {
            super(2);
        }

        /* renamed from: a */
        public final boolean m4522a(@Nullable Object obj, @Nullable Object obj2) {
            return C14342f0.m8193g(obj, obj2);
        }

        @Override // p617l1.InterfaceC15284p
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(m4522a(obj, obj2));
        }
    }

    /* compiled from: Distinct.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, m12616d2 = {"<anonymous>", "", "it", "invoke"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.p$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15036b extends Lambda implements InterfaceC15280l<Object, Object> {

        /* renamed from: a */
        public static final C15036b f42968a = new C15036b();

        C15036b() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        public final Object invoke(@Nullable Object obj) {
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14958h<T> m4530a(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return interfaceC14958h instanceof StateFlow ? interfaceC14958h : m4527d(interfaceC14958h, f42965a, f42966b);
    }

    @NotNull
    /* renamed from: b */
    public static final <T> InterfaceC14958h<T> m4529b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super T, Boolean> interfaceC15284p) {
        InterfaceC15280l<Object, Object> interfaceC15280l = f42965a;
        if (interfaceC15284p != null) {
            return m4527d(interfaceC14958h, interfaceC15280l, (InterfaceC15284p) TypeIntrinsics.m8010q(interfaceC15284p, 2));
        }
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Any?, kotlin.Any?) -> kotlin.Boolean");
    }

    @NotNull
    /* renamed from: c */
    public static final <T, K> InterfaceC14958h<T> m4528c(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15280l<? super T, ? extends K> interfaceC15280l) {
        return m4527d(interfaceC14958h, interfaceC15280l, f42966b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private static final <T> InterfaceC14958h<T> m4527d(InterfaceC14958h<? extends T> interfaceC14958h, InterfaceC15280l<? super T, ? extends Object> interfaceC15280l, InterfaceC15284p<Object, Object, Boolean> interfaceC15284p) {
        if (interfaceC14958h instanceof Distinct) {
            Distinct distinct = (Distinct) interfaceC14958h;
            if (distinct.f42290b == interfaceC15280l && distinct.f42291c == interfaceC15284p) {
                return interfaceC14958h;
            }
        }
        return new Distinct(interfaceC14958h, interfaceC15280l, interfaceC15284p);
    }

    /* renamed from: e */
    private static final InterfaceC15284p<Object, Object, Boolean> m4526e() {
        return f42966b;
    }

    /* renamed from: f */
    private static /* synthetic */ void m4525f() {
    }

    /* renamed from: g */
    private static final InterfaceC15280l<Object, Object> m4524g() {
        return f42965a;
    }

    /* renamed from: h */
    private static /* synthetic */ void m4523h() {
    }
}
