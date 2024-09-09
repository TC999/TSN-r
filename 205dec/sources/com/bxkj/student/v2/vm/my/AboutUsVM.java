package com.bxkj.student.v2.vm.my;

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
/* compiled from: AboutUsVM.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\b\u001a\u00020\u00062 \u0010\u0007\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0004\u0012\u00020\u00060\u0002R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/bxkj/student/v2/vm/my/AboutUsVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/Function1;", "", "", "", "Lkotlin/f1;", "result", "v", "Lcom/bxkj/student/v2/repository/my/a;", "h", "Lkotlin/o;", "u", "()Lcom/bxkj/student/v2/repository/my/a;", "aboutUsRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class AboutUsVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final o f24457h = q.c(a.f24458a);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AboutUsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/my/a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends Lambda implements l1.a<com.bxkj.student.v2.repository.my.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f24458a = new a();

        a() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.my.a invoke() {
            return new com.bxkj.student.v2.repository.my.a();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AboutUsVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.my.AboutUsVM$getPgyerAppVersion$1", f = "AboutUsVM.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends SuspendLambda implements l<c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24459a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<Map<String, Object>, f1> f24461c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(l<? super Map<String, Object>, f1> lVar, c<? super b> cVar) {
            super(1, cVar);
            this.f24461c = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final c<f1> create(@NotNull c<?> cVar) {
            return new b(this.f24461c, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable c<? super f1> cVar) {
            return ((b) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24459a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.my.a u3 = AboutUsVM.this.u();
                this.f24459a = 1;
                obj = u3.a(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            Map<String, Object> map = (Map) obj;
            if (map != null) {
                this.f24461c.invoke(map);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.my.a u() {
        return (com.bxkj.student.v2.repository.my.a) this.f24457h.getValue();
    }

    public final void v(@NotNull l<? super Map<String, Object>, f1> result) {
        f0.p(result, "result");
        BaseViewModel.j(this, new b(result, null), null, null, null, null, null, null, null, 254, null);
    }
}
