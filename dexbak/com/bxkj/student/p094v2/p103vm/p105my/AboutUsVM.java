package com.bxkj.student.p094v2.p103vm.p105my;

import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.student.p094v2.repository.p097my.AboutUsRepository;
import com.umeng.socialize.net.dplus.CommonNetImpl;
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

/* compiled from: AboutUsVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\b\u001a\u00020\u00062 \u0010\u0007\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0004\u0012\u00020\u00060\u0002R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/my/AboutUsVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/Function1;", "", "", "", "Lkotlin/f1;", CommonNetImpl.RESULT, "v", "Lcom/bxkj/student/v2/repository/my/a;", "h", "Lkotlin/o;", "u", "()Lcom/bxkj/student/v2/repository/my/a;", "aboutUsRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.my.AboutUsVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AboutUsVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private final InterfaceC14378o f21037h;

    /* compiled from: AboutUsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/my/a;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.my.AboutUsVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5863a extends Lambda implements InterfaceC15269a<AboutUsRepository> {

        /* renamed from: a */
        public static final C5863a f21038a = new C5863a();

        C5863a() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final AboutUsRepository invoke() {
            return new AboutUsRepository();
        }
    }

    /* compiled from: AboutUsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.my.AboutUsVM$getPgyerAppVersion$1", m8638f = "AboutUsVM.kt", m8637i = {}, m8636l = {16}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.my.AboutUsVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5864b extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21039a;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l<Map<String, Object>, Unit> f21041c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5864b(InterfaceC15280l<? super Map<String, Object>, Unit> interfaceC15280l, InterfaceC14268c<? super C5864b> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21041c = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5864b(this.f21041c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5864b) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21039a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                AboutUsRepository m38102u = AboutUsVM.this.m38102u();
                this.f21039a = 1;
                obj = m38102u.m38988a(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                this.f21041c.invoke(map);
            }
            return Unit.f41048a;
        }
    }

    public AboutUsVM() {
        InterfaceC14378o m7719c;
        m7719c = C14389r.m7719c(C5863a.f21038a);
        this.f21037h = m7719c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public final AboutUsRepository m38102u() {
        return (AboutUsRepository) this.f21037h.getValue();
    }

    /* renamed from: v */
    public final void m38101v(@NotNull InterfaceC15280l<? super Map<String, Object>, Unit> result) {
        C14342f0.m8184p(result, "result");
        BaseViewModel.m43949j(this, new C5864b(result, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }
}
