package kotlinx.coroutines.selects;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.selects.Select;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: SelectUnbiased.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0001J5\u0010\f\u001a\u00020\u0005*\u00020\b2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJG\u0010\u0011\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00010\u000f2\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0010H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J[\u0010\u0016\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\u000e*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0010H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J8\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R3\u0010'\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050#`$8\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b\u001d\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, m12616d2 = {"Lkotlinx/coroutines/selects/j;", "R", "Lkotlinx/coroutines/selects/a;", "", "e", "Lkotlin/f1;", "", "f", "Lkotlinx/coroutines/selects/c;", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "block", "c", "(Lkotlinx/coroutines/selects/c;Ll1/l;)V", "Q", "Lkotlinx/coroutines/selects/d;", "Lkotlin/Function2;", IAdInterListener.AdReqParam.WIDTH, "(Lkotlinx/coroutines/selects/d;Ll1/p;)V", "P", "Lkotlinx/coroutines/selects/e;", "param", "b", "(Lkotlinx/coroutines/selects/e;Ljava/lang/Object;Ll1/p;)V", "", "timeMillis", "m", "(JLl1/l;)V", "Lkotlinx/coroutines/selects/b;", "a", "Lkotlinx/coroutines/selects/b;", "d", "()Lkotlinx/coroutines/selects/b;", "instance", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "clauses", "uCont", "<init>", "(Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
@PublishedApi
/* renamed from: kotlinx.coroutines.selects.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15200j<R> implements Select<R> {
    @NotNull

    /* renamed from: a */
    private final C15188b<R> f43331a;
    @NotNull

    /* renamed from: b */
    private final ArrayList<InterfaceC15269a<Unit>> f43332b = new ArrayList<>();

    /* compiled from: SelectUnbiased.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"R", "Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.j$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15201a extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: b */
        final /* synthetic */ InterfaceC15194c f43334b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l f43335c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15201a(InterfaceC15194c interfaceC15194c, InterfaceC15280l interfaceC15280l) {
            super(0);
            this.f43334b = interfaceC15194c;
            this.f43335c = interfaceC15280l;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f43334b.mo3707u(C15200j.this.m3680d(), this.f43335c);
        }
    }

    /* compiled from: SelectUnbiased.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Q", "R", "Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.j$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15202b extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: b */
        final /* synthetic */ InterfaceC15195d f43337b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15284p f43338c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15202b(InterfaceC15195d interfaceC15195d, InterfaceC15284p interfaceC15284p) {
            super(0);
            this.f43337b = interfaceC15195d;
            this.f43338c = interfaceC15284p;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f43337b.mo3491k(C15200j.this.m3680d(), this.f43338c);
        }
    }

    /* compiled from: SelectUnbiased.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0006\b\u0002\u0010\u0002 \u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"P", "Q", "R", "Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.j$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15203c extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: b */
        final /* synthetic */ InterfaceC15196e f43340b;

        /* renamed from: c */
        final /* synthetic */ Object f43341c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC15284p f43342d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15203c(InterfaceC15196e interfaceC15196e, Object obj, InterfaceC15284p interfaceC15284p) {
            super(0);
            this.f43340b = interfaceC15196e;
            this.f43341c = obj;
            this.f43342d = interfaceC15284p;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f43340b.mo3631d(C15200j.this.m3680d(), this.f43341c, this.f43342d);
        }
    }

    /* compiled from: SelectUnbiased.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"R", "Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.j$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15204d extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: b */
        final /* synthetic */ long f43344b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l f43345c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15204d(long j, InterfaceC15280l interfaceC15280l) {
            super(0);
            this.f43344b = j;
            this.f43345c = interfaceC15280l;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            C15200j.this.m3680d().mo3677m(this.f43344b, this.f43345c);
        }
    }

    public C15200j(@NotNull InterfaceC14268c<? super R> interfaceC14268c) {
        this.f43331a = new C15188b<>(interfaceC14268c);
    }

    @NotNull
    /* renamed from: a */
    public final ArrayList<InterfaceC15269a<Unit>> m3683a() {
        return this.f43332b;
    }

    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: b */
    public <P, Q> void mo3682b(@NotNull InterfaceC15196e<? super P, ? extends Q> interfaceC15196e, P p, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        this.f43332b.add(new C15203c(interfaceC15196e, p, interfaceC15284p));
    }

    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: c */
    public void mo3681c(@NotNull InterfaceC15194c interfaceC15194c, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15280l) {
        this.f43332b.add(new C15201a(interfaceC15194c, interfaceC15280l));
    }

    @NotNull
    /* renamed from: d */
    public final C15188b<R> m3680d() {
        return this.f43331a;
    }

    @PublishedApi
    /* renamed from: e */
    public final void m3679e(@NotNull Throwable th) {
        this.f43331a.m3713n0(th);
    }

    @PublishedApi
    @Nullable
    /* renamed from: f */
    public final Object m3678f() {
        if (!this.f43331a.mo3706i()) {
            try {
                Collections.shuffle(this.f43332b);
                Iterator<T> it = this.f43332b.iterator();
                while (it.hasNext()) {
                    ((InterfaceC15269a) it.next()).invoke();
                }
            } catch (Throwable th) {
                this.f43331a.m3713n0(th);
            }
        }
        return this.f43331a.m3714m0();
    }

    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: m */
    public void mo3677m(long j, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15280l) {
        this.f43332b.add(new C15204d(j, interfaceC15280l));
    }

    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: n */
    public <P, Q> void mo3676n(@NotNull InterfaceC15196e<? super P, ? extends Q> interfaceC15196e, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        Select.C15187a.m3720a(this, interfaceC15196e, interfaceC15284p);
    }

    @Override // kotlinx.coroutines.selects.Select
    /* renamed from: w */
    public <Q> void mo3675w(@NotNull InterfaceC15195d<? extends Q> interfaceC15195d, @NotNull InterfaceC15284p<? super Q, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        this.f43332b.add(new C15202b(interfaceC15195d, interfaceC15284p));
    }
}
