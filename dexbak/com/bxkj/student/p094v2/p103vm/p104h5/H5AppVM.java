package com.bxkj.student.p094v2.p103vm.p104h5;

import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.p094v2.repository.MainRepository;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.Map;
import kotlin.C14294d0;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: H5AppVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/h5/H5AppVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "updateStatus", "Lkotlin/f1;", "isNeedUpdate", "v", "Lcom/bxkj/student/v2/repository/b;", "h", "Lkotlin/o;", "u", "()Lcom/bxkj/student/v2/repository/b;", "mainRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.h5.H5AppVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class H5AppVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private final InterfaceC14378o f21032h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: H5AppVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.h5.H5AppVM$isDefaultPass$1", m8638f = "H5AppVM.kt", m8637i = {}, m8636l = {18}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.h5.H5AppVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5861a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21033a;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l<String, Unit> f21035c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5861a(InterfaceC15280l<? super String, Unit> interfaceC15280l, InterfaceC14268c<? super C5861a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21035c = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5861a(this.f21035c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5861a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21033a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                MainRepository m38107u = H5AppVM.this.m38107u();
                this.f21033a = 1;
                obj = m38107u.m38996i(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (map != null) {
                this.f21035c.invoke(JsonGet.f15134a.m43760t(map, "updateStatus"));
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: H5AppVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/b;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.h5.H5AppVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5862b extends Lambda implements InterfaceC15269a<MainRepository> {

        /* renamed from: a */
        public static final C5862b f21036a = new C5862b();

        C5862b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final MainRepository invoke() {
            return new MainRepository();
        }
    }

    public H5AppVM() {
        InterfaceC14378o m7719c;
        m7719c = C14389r.m7719c(C5862b.f21036a);
        this.f21032h = m7719c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public final MainRepository m38107u() {
        return (MainRepository) this.f21032h.getValue();
    }

    /* renamed from: v */
    public final void m38106v(@NotNull InterfaceC15280l<? super String, Unit> isNeedUpdate) {
        C14342f0.m8184p(isNeedUpdate, "isNeedUpdate");
        BaseViewModel.m43949j(this, new C5861a(isNeedUpdate, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }
}
