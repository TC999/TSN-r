package com.bxkj.student.p094v2.p103vm.sports.set;

import androidx.lifecycle.MutableLiveData;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.student.p094v2.repository.sports.SportsRankRepository;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.Map;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: SportsRankVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R6\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/sports/set/SportsRankVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "u", "Landroidx/lifecycle/MutableLiveData;", "", "", "", "h", "Landroidx/lifecycle/MutableLiveData;", UMCommonContent.f37782aL, "()Landroidx/lifecycle/MutableLiveData;", "v", "(Landroidx/lifecycle/MutableLiveData;)V", "dataMap", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.sports.set.SportsRankVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsRankVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private MutableLiveData<Map<String, Object>> f21272h = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsRankVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.set.SportsRankVM$getRankData$1", m8638f = "SportsRankVM.kt", m8637i = {}, m8636l = {17}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.set.SportsRankVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5928a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21273a;

        C5928a(InterfaceC14268c<? super C5928a> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5928a(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5928a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21273a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsRankRepository sportsRankRepository = new SportsRankRepository();
                this.f21273a = 1;
                obj = sportsRankRepository.m38961a(this);
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
                SportsRankVM.this.m37935t().postValue(map);
            }
            return Unit.f41048a;
        }
    }

    @NotNull
    /* renamed from: t */
    public final MutableLiveData<Map<String, Object>> m37935t() {
        return this.f21272h;
    }

    /* renamed from: u */
    public final void m37934u() {
        BaseViewModel.m43949j(this, new C5928a(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: v */
    public final void m37933v(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21272h = mutableLiveData;
    }
}
