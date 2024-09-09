package com.bxkj.student.v2.vm.h5;

import com.bxkj.base.v2.base.BaseViewModel;
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
/* compiled from: H5AppVM.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/bxkj/student/v2/vm/h5/H5AppVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "updateStatus", "Lkotlin/f1;", "isNeedUpdate", "v", "Lcom/bxkj/student/v2/repository/b;", "h", "Lkotlin/o;", "u", "()Lcom/bxkj/student/v2/repository/b;", "mainRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class H5AppVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final o f24452h = q.c(b.f24456a);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: H5AppVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.h5.H5AppVM$isDefaultPass$1", f = "H5AppVM.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends SuspendLambda implements l<c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24453a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<String, f1> f24455c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(l<? super String, f1> lVar, c<? super a> cVar) {
            super(1, cVar);
            this.f24455c = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final c<f1> create(@NotNull c<?> cVar) {
            return new a(this.f24455c, cVar);
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
            int i4 = this.f24453a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.b u3 = H5AppVM.this.u();
                this.f24453a = 1;
                obj = u3.i(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (map != null) {
                this.f24455c.invoke(com.bxkj.base.v2.common.utils.l.f18624a.t(map, "updateStatus"));
            }
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: H5AppVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends Lambda implements l1.a<com.bxkj.student.v2.repository.b> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f24456a = new b();

        b() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.b invoke() {
            return new com.bxkj.student.v2.repository.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.b u() {
        return (com.bxkj.student.v2.repository.b) this.f24452h.getValue();
    }

    public final void v(@NotNull l<? super String, f1> isNeedUpdate) {
        f0.p(isNeedUpdate, "isNeedUpdate");
        BaseViewModel.j(this, new a(isNeedUpdate, null), null, null, null, null, null, null, null, 254, null);
    }
}
