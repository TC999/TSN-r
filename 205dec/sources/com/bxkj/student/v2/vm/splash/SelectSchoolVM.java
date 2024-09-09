package com.bxkj.student.v2.vm.splash;

import com.bxkj.base.v2.base.BaseViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.q;
import l1.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SelectSchoolVM.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J6\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\t\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005\u0012\u0004\u0012\u00020\b0\u0004R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/bxkj/student/v2/vm/splash/SelectSchoolVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "name", "Lkotlin/Function1;", "", "", "", "Lkotlin/f1;", "finish", "v", "Lcom/bxkj/student/v2/repository/splash/a;", "h", "Lkotlin/o;", "u", "()Lcom/bxkj/student/v2/repository/splash/a;", "selectSchoolRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SelectSchoolVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final o f24462h = q.c(b.f24467a);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SelectSchoolVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.splash.SelectSchoolVM$searchSchool$1", f = "SelectSchoolVM.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements l<c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24463a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24465c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ l<List<Map<String, Object>>, f1> f24466d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(String str, l<? super List<Map<String, Object>>, f1> lVar, c<? super a> cVar) {
            super(1, cVar);
            this.f24465c = str;
            this.f24466d = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final c<f1> create(@NotNull c<?> cVar) {
            return new a(this.f24465c, this.f24466d, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable c<? super f1> cVar) {
            return ((a) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24463a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.splash.a u3 = SelectSchoolVM.this.u();
                String str = this.f24465c;
                this.f24463a = 1;
                obj = u3.a(str, this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            List<Map<String, Object>> list = (List) obj;
            if (list != null) {
                this.f24466d.invoke(list);
            }
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SelectSchoolVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/splash/a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends Lambda implements l1.a<com.bxkj.student.v2.repository.splash.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f24467a = new b();

        b() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.splash.a invoke() {
            return new com.bxkj.student.v2.repository.splash.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.splash.a u() {
        return (com.bxkj.student.v2.repository.splash.a) this.f24462h.getValue();
    }

    public final void v(@NotNull String name, @NotNull l<? super List<Map<String, Object>>, f1> finish) {
        f0.p(name, "name");
        f0.p(finish, "finish");
        BaseViewModel.l(this, new a(name, finish, null), null, null, null, null, null, 62, null);
    }
}
