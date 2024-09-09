package com.bxkj.student.v2.vm.splash;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.data.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import l1.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SplashVM.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J)\u0010\u000b\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00030\u0006R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/bxkj/student/v2/vm/splash/SplashVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/Function0;", "Lkotlin/f1;", "finish", "v", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "dept_id", "u", "Lcom/bxkj/student/v2/repository/splash/b;", "h", "Lcom/bxkj/student/v2/repository/splash/b;", "splashRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SplashVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final com.bxkj.student.v2.repository.splash.b f24468h = new com.bxkj.student.v2.repository.splash.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SplashVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$autoLogin$1", f = "SplashVM.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24469a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f24471c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref.IntRef intRef, kotlin.coroutines.c<? super a> cVar) {
            super(1, cVar);
            this.f24471c = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f24471c, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24469a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.splash.b bVar = SplashVM.this.f24468h;
                String o4 = com.bxkj.base.v2.data.a.b.a().o();
                this.f24469a = 1;
                obj = bVar.a(o4, this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            Map<String, ? extends Object> map = (Map) obj;
            a.b bVar2 = com.bxkj.base.v2.data.a.b;
            com.bxkj.base.v2.data.a a4 = bVar2.a();
            Object obj2 = map.get("access_token");
            if (obj2 == null) {
                obj2 = "";
            }
            a4.C(String.valueOf(obj2));
            com.bxkj.base.v2.data.a a5 = bVar2.a();
            Object obj3 = map.get("refresh_token");
            a5.T(String.valueOf(obj3 != null ? obj3 : ""));
            this.f24471c.element = (int) Double.parseDouble(com.bxkj.base.v2.common.utils.l.f18624a.t(map, "dept_id"));
            bVar2.a().G(String.valueOf(this.f24471c.element));
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SplashVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$autoLogin$2", f = "SplashVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24472a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l<Integer, f1> f24473b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f24474c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(l<? super Integer, f1> lVar, Ref.IntRef intRef, kotlin.coroutines.c<? super b> cVar) {
            super(1, cVar);
            this.f24473b = lVar;
            this.f24474c = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new b(this.f24473b, this.f24474c, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24472a == 0) {
                d0.n(obj);
                this.f24473b.invoke(kotlin.coroutines.jvm.internal.a.f(this.f24474c.element));
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SplashVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$getAppId$1", f = "SplashVM.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24475a;

        c(kotlin.coroutines.c<? super c> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new c(cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24475a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.splash.b bVar = SplashVM.this.f24468h;
                this.f24475a = 1;
                obj = bVar.b(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            String str = (String) obj;
            if (str != null) {
                com.bxkj.base.v2.data.a.b.a().E(str);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SplashVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SplashVM$getAppId$2", f = "SplashVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24477a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24478b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(l1.a<f1> aVar, kotlin.coroutines.c<? super d> cVar) {
            super(1, cVar);
            this.f24478b = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new d(this.f24478b, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((d) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24477a == 0) {
                d0.n(obj);
                this.f24478b.invoke();
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void u(@NotNull l<? super Integer, f1> finish) {
        f0.p(finish, "finish");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        BaseViewModel.l(this, new a(intRef, null), null, null, null, new b(finish, intRef, null), null, 46, null);
    }

    public final void v(@NotNull l1.a<f1> finish) {
        f0.p(finish, "finish");
        BaseViewModel.l(this, new c(null), null, null, null, new d(finish, null), null, 46, null);
    }
}
