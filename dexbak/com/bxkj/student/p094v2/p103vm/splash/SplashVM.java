package com.bxkj.student.p094v2.p103vm.splash;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.p094v2.repository.splash.SplashRepository;
import java.util.Map;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: SplashVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J)\u0010\u000b\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00030\u0006R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/splash/SplashVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/Function0;", "Lkotlin/f1;", ConstantHelper.LOG_FINISH, "v", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "dept_id", "u", "Lcom/bxkj/student/v2/repository/splash/b;", "h", "Lcom/bxkj/student/v2/repository/splash/b;", "splashRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.splash.SplashVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SplashVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private final SplashRepository f21048h = new SplashRepository();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.splash.SplashVM$autoLogin$1", m8638f = "SplashVM.kt", m8637i = {}, m8636l = {27}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.splash.SplashVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5867a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21049a;

        /* renamed from: c */
        final /* synthetic */ Ref.IntRef f21051c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5867a(Ref.IntRef intRef, InterfaceC14268c<? super C5867a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21051c = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5867a(this.f21051c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5867a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21049a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SplashRepository splashRepository = SplashVM.this.f21048h;
                String m43647o = LoggedInUser.f15182b.m43634a().m43647o();
                this.f21049a = 1;
                obj = splashRepository.m38986a(m43647o, this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            Map<String, ? extends Object> map = (Map) obj;
            LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
            LoggedInUser m43634a = c3984b.m43634a();
            Object obj2 = map.get("access_token");
            if (obj2 == null) {
                obj2 = "";
            }
            m43634a.m43688C(String.valueOf(obj2));
            LoggedInUser m43634a2 = c3984b.m43634a();
            Object obj3 = map.get("refresh_token");
            m43634a2.m43671T(String.valueOf(obj3 != null ? obj3 : ""));
            this.f21051c.element = (int) Double.parseDouble(JsonGet.f15134a.m43760t(map, "dept_id"));
            c3984b.m43634a().m43684G(String.valueOf(this.f21051c.element));
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.splash.SplashVM$autoLogin$2", m8638f = "SplashVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.splash.SplashVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5868b extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21052a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<Integer, Unit> f21053b;

        /* renamed from: c */
        final /* synthetic */ Ref.IntRef f21054c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5868b(InterfaceC15280l<? super Integer, Unit> interfaceC15280l, Ref.IntRef intRef, InterfaceC14268c<? super C5868b> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21053b = interfaceC15280l;
            this.f21054c = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5868b(this.f21053b, this.f21054c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5868b) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f21052a == 0) {
                C14294d0.m8596n(obj);
                this.f21053b.invoke(boxing.m8626f(this.f21054c.element));
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.splash.SplashVM$getAppId$1", m8638f = "SplashVM.kt", m8637i = {}, m8636l = {18}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.splash.SplashVM$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5869c extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21055a;

        C5869c(InterfaceC14268c<? super C5869c> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5869c(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5869c) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21055a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SplashRepository splashRepository = SplashVM.this.f21048h;
                this.f21055a = 1;
                obj = splashRepository.m38985b(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            String str = (String) obj;
            if (str != null) {
                LoggedInUser.f15182b.m43634a().m43686E(str);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplashVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.splash.SplashVM$getAppId$2", m8638f = "SplashVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.splash.SplashVM$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5870d extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21057a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15269a<Unit> f21058b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5870d(InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5870d> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21058b = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5870d(this.f21058b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5870d) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f21057a == 0) {
                C14294d0.m8596n(obj);
                this.f21058b.invoke();
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: u */
    public final void m38092u(@NotNull InterfaceC15280l<? super Integer, Unit> finish) {
        C14342f0.m8184p(finish, "finish");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        BaseViewModel.m43947l(this, new C5867a(intRef, null), null, null, null, new C5868b(finish, intRef, null), null, 46, null);
    }

    /* renamed from: v */
    public final void m38091v(@NotNull InterfaceC15269a<Unit> finish) {
        C14342f0.m8184p(finish, "finish");
        BaseViewModel.m43947l(this, new C5869c(null), null, null, null, new C5870d(finish, null), null, 46, null);
    }
}
