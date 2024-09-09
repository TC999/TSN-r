package com.bxkj.student.common.jpush;

import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JPushInterface;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.v2.retrofit.a;
import com.orhanobut.logger.j;
import d2.p;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.j1;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JPushManger.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/bxkj/student/common/jpush/a;", "", "Lkotlin/f1;", "c", "b", "e", "d", "", "I", InAppSlotParams.SLOT_KEY.SEQ, "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f19570a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static int f19571b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JPushManger.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.common.jpush.JPushManger$setAlias$1", f = "JPushManger.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bxkj.student.common.jpush.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class C0215a extends SuspendLambda implements p<q0, c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f19572a;

        C0215a(c<? super C0215a> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final c<f1> create(@Nullable Object obj, @NotNull c<?> cVar) {
            return new C0215a(cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable c<? super f1> cVar) {
            return ((C0215a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = b.h();
            int i4 = this.f19572a;
            try {
                try {
                    if (i4 == 0) {
                        d0.n(obj);
                        com.bxkj.student.v2.retrofit.a b4 = com.bxkj.student.v2.retrofit.c.f23705a.b();
                        this.f19572a = 1;
                        if (a.b.d(b4, null, null, this, 3, null) == h4) {
                            return h4;
                        }
                    } else if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        d0.n(obj);
                    }
                } catch (Exception e4) {
                    j.c(e4.getMessage());
                }
                return f1.f55527a;
            } finally {
                JPushInterface.setAlias(BaseApp.b(), a.f19571b, com.bxkj.base.v2.data.a.f18673h.a().B());
            }
        }
    }

    private a() {
    }

    private final void b() {
        f19571b++;
        JPushInterface.deleteAlias(BaseApp.b(), f19571b);
    }

    private final void c() {
        f19571b++;
        kotlinx.coroutines.j.f(w1.f60756a, kotlinx.coroutines.f1.c(), null, new C0215a(null), 2, null);
    }

    public final void d() {
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        if (bVar.a().L() != 1) {
            JPushInterface.stopPush(BaseApp.b());
        } else if (bVar.a().G()) {
            c();
        } else {
            b();
        }
    }

    public final void e() {
        Set q3;
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        if (bVar.a().L() != 1) {
            JPushInterface.stopPush(BaseApp.b());
            return;
        }
        f19571b++;
        BaseApp b4 = BaseApp.b();
        int i4 = f19571b;
        q3 = j1.q(bVar.a().x());
        JPushInterface.setTags(b4, i4, q3);
    }
}
