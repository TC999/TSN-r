package com.bxkj.student.v2.vm;

import androidx.lifecycle.MutableLiveData;
import com.bxkj.base.v2.base.BaseViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import l1.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: NoticeVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R6\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/bxkj/student/v2/vm/NoticeVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "u", "Landroidx/lifecycle/MutableLiveData;", "", "", "", "h", "Landroidx/lifecycle/MutableLiveData;", "t", "()Landroidx/lifecycle/MutableLiveData;", "v", "(Landroidx/lifecycle/MutableLiveData;)V", "latestUnreadNotice", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class NoticeVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private MutableLiveData<Map<String, Object>> f24420h = new MutableLiveData<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: NoticeVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.NoticeVM$getLatestUnreadNotice$1", f = "NoticeVM.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends SuspendLambda implements l<c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24421a;

        a(c<? super a> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final c<f1> create(@NotNull c<?> cVar) {
            return new a(cVar);
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
            h4 = b.h();
            int i4 = this.f24421a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.b bVar = new com.bxkj.student.v2.repository.b();
                String t3 = com.bxkj.base.v2.common.utils.l.f18624a.t(NoticeVM.this.t().getValue(), "id");
                this.f24421a = 1;
                if (bVar.g(t3, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    @NotNull
    public final MutableLiveData<Map<String, Object>> t() {
        return this.f24420h;
    }

    public final void u() {
        BaseViewModel.j(this, new a(null), null, null, null, null, null, null, null, 254, null);
    }

    public final void v(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24420h = mutableLiveData;
    }
}
