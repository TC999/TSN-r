package com.bxkj.student.p094v2.p103vm.sports;

import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.p094v2.common.p095db.AppDatabase;
import com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao;
import com.bxkj.student.p094v2.repository.sports.SportsDescriptionRepository;
import com.bytedance.msdk.api.NetworkPlatformConst;
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
import p027c0.SportsSetDb;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: SportsDescriptionVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/sports/SportsDescriptionVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "v", "Landroidx/lifecycle/MutableLiveData;", "", "h", "Landroidx/lifecycle/MutableLiveData;", "u", "()Landroidx/lifecycle/MutableLiveData;", "x", "(Landroidx/lifecycle/MutableLiveData;)V", "sportsDescription", "Lcom/bxkj/student/v2/repository/sports/d;", "i", "Lkotlin/o;", IAdInterListener.AdReqParam.WIDTH, "()Lcom/bxkj/student/v2/repository/sports/d;", "sportsDescriptionRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.sports.SportsDescriptionVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsDescriptionVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private MutableLiveData<String> f21059h = new MutableLiveData<>();
    @NotNull

    /* renamed from: i */
    private final InterfaceC14378o f21060i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsDescriptionVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsDescriptionVM$getSportsDescription$1", m8638f = "SportsDescriptionVM.kt", m8637i = {}, m8636l = {26, 29}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsDescriptionVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5871a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21061a;

        C5871a(InterfaceC14268c<? super C5871a> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5871a(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5871a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            SportsSetDao mo39224m;
            m8642h = C14287b.m8642h();
            int i = this.f21061a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsDescriptionRepository m38083w = SportsDescriptionVM.this.m38083w();
                this.f21061a = 1;
                obj = m38083w.m38972a(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C14294d0.m8596n(obj);
                return Unit.f41048a;
            } else {
                C14294d0.m8596n(obj);
            }
            String str = (String) obj;
            SportsDescriptionVM.this.m38085u().postValue(str);
            if (str != null && (mo39224m = AppDatabase.f19934a.m39228a().mo39224m()) != null) {
                SportsSetDb sportsSetDb = new SportsSetDb(LoggedInUser.f15182b.m43634a().m43642t(), NetworkPlatformConst.AD_NETWORK_NO_DATA, str);
                this.f21061a = 2;
                if (mo39224m.insert(sportsSetDb, this) == m8642h) {
                    return m8642h;
                }
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsDescriptionVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsDescriptionVM$getSportsDescription$2", m8638f = "SportsDescriptionVM.kt", m8637i = {}, m8636l = {37}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsDescriptionVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5872b extends SuspendLambda implements InterfaceC15284p<Exception, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21063a;

        /* renamed from: b */
        /* synthetic */ Object f21064b;

        C5872b(InterfaceC14268c<? super C5872b> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5872b c5872b = new C5872b(interfaceC14268c);
            c5872b.f21064b = obj;
            return c5872b;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5872b) create(exc, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r5.f21063a
                r2 = 0
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L19
                if (r1 != r4) goto L11
                kotlin.C14294d0.m8596n(r6)
                goto L45
            L11:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L19:
                kotlin.C14294d0.m8596n(r6)
                java.lang.Object r6 = r5.f21064b
                java.lang.Exception r6 = (java.lang.Exception) r6
                boolean r6 = com.bxkj.base.p085v2.common.ext.ExceptionExt.m43845a(r6)
                if (r6 == 0) goto L71
                java.lang.Object[] r6 = new java.lang.Object[r2]
                java.lang.String r1 = "离线跑步获取跑步说明"
                com.orhanobut.logger.C11792j.m20469d(r1, r6)
                com.bxkj.student.v2.common.db.AppDatabase$b r6 = com.bxkj.student.p094v2.common.p095db.AppDatabase.f19934a
                com.bxkj.student.v2.common.db.AppDatabase r6 = r6.m39228a()
                com.bxkj.student.v2.common.db.dao.g r6 = r6.mo39224m()
                if (r6 != 0) goto L3a
                goto L63
            L3a:
                r5.f21063a = r4
                java.lang.String r1 = "-2"
                java.lang.Object r6 = r6.mo39159b(r1, r5)
                if (r6 != r0) goto L45
                return r0
            L45:
                java.lang.String r6 = (java.lang.String) r6
                if (r6 != 0) goto L4a
                goto L63
            L4a:
                int r0 = r6.length()
                if (r0 <= 0) goto L51
                r2 = 1
            L51:
                if (r2 == 0) goto L54
                goto L55
            L54:
                r6 = r3
            L55:
                if (r6 != 0) goto L58
                goto L63
            L58:
                com.bxkj.student.v2.vm.sports.SportsDescriptionVM r0 = com.bxkj.student.p094v2.p103vm.sports.SportsDescriptionVM.this
                androidx.lifecycle.MutableLiveData r0 = r0.m38085u()
                r0.postValue(r6)
                kotlin.f1 r3 = kotlin.Unit.f41048a
            L63:
                if (r3 != 0) goto L70
                com.bxkj.student.v2.vm.sports.SportsDescriptionVM r6 = com.bxkj.student.p094v2.p103vm.sports.SportsDescriptionVM.this
                androidx.lifecycle.MutableLiveData r6 = r6.m43953f()
                java.lang.String r0 = "服务器维护中，请稍后再进行跑步"
                r6.postValue(r0)
            L70:
                r2 = 1
            L71:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.boxing.m8631a(r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.SportsDescriptionVM.C5872b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: SportsDescriptionVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/d;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsDescriptionVM$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5873c extends Lambda implements InterfaceC15269a<SportsDescriptionRepository> {

        /* renamed from: a */
        public static final C5873c f21066a = new C5873c();

        C5873c() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final SportsDescriptionRepository invoke() {
            return new SportsDescriptionRepository();
        }
    }

    public SportsDescriptionVM() {
        InterfaceC14378o m7719c;
        m7719c = C14389r.m7719c(C5873c.f21066a);
        this.f21060i = m7719c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public final SportsDescriptionRepository m38083w() {
        return (SportsDescriptionRepository) this.f21060i.getValue();
    }

    @NotNull
    /* renamed from: u */
    public final MutableLiveData<String> m38085u() {
        return this.f21059h;
    }

    /* renamed from: v */
    public final void m38084v() {
        BaseViewModel.m43949j(this, new C5871a(null), null, new C5872b(null), null, null, null, null, null, 250, null);
    }

    /* renamed from: x */
    public final void m38082x(@NotNull MutableLiveData<String> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21059h = mutableLiveData;
    }
}
