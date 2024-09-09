package com.bxkj.student.v2.vm.sports.set;

import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.repository.sports.f;
import d2.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SportsSetVM.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bxkj/student/v2/vm/sports/set/SportsSetVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SportsSetVM extends BaseViewModel {

    /* compiled from: SportsSetVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.set.SportsSetVM$rankingExerciseRecordV2$1", f = "SportsSetVM.kt", i = {}, l = {15}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class a extends SuspendLambda implements l<c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24724a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<Map<String, Object>, f1> f24726c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(l<? super Map<String, Object>, f1> lVar, c<? super a> cVar) {
            super(1, cVar);
            this.f24726c = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final c<f1> create(@NotNull c<?> cVar) {
            return new a(this.f24726c, cVar);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: e */
        public final Object invoke(@Nullable c<? super f1> cVar) {
            return ((a) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24724a;
            if (i4 == 0) {
                d0.n(obj);
                f t3 = SportsSetVM.t(SportsSetVM.this);
                this.f24724a = 1;
                obj = t3.b(this);
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
                this.f24726c.invoke(map);
            }
            return f1.f55527a;
        }
    }

    /* compiled from: SportsSetVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/f;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class b extends Lambda implements d2.a<f> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f24727a = new b();

        b() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final f invoke() {
            return new f();
        }
    }
}
