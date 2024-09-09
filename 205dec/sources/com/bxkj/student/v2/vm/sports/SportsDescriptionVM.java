package com.bxkj.student.v2.vm.sports;

import androidx.lifecycle.MutableLiveData;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.db.dao.g;
import com.bxkj.student.v2.repository.sports.d;
import com.bytedance.msdk.api.NetworkPlatformConst;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.q;
import l1.l;
import l1.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SportsDescriptionVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/bxkj/student/v2/vm/sports/SportsDescriptionVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/f1;", "v", "Landroidx/lifecycle/MutableLiveData;", "", "h", "Landroidx/lifecycle/MutableLiveData;", "u", "()Landroidx/lifecycle/MutableLiveData;", "x", "(Landroidx/lifecycle/MutableLiveData;)V", "sportsDescription", "Lcom/bxkj/student/v2/repository/sports/d;", "i", "Lkotlin/o;", "w", "()Lcom/bxkj/student/v2/repository/sports/d;", "sportsDescriptionRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SportsDescriptionVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private MutableLiveData<String> f24479h = new MutableLiveData<>();
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final o f24480i = q.c(c.f24486a);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsDescriptionVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsDescriptionVM$getSportsDescription$1", f = "SportsDescriptionVM.kt", i = {}, l = {26, 29}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24481a;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(1, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new a(cVar);
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
            g m4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24481a;
            if (i4 == 0) {
                d0.n(obj);
                d w3 = SportsDescriptionVM.this.w();
                this.f24481a = 1;
                obj = w3.a(this);
                if (obj == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d0.n(obj);
                return f1.f55527a;
            } else {
                d0.n(obj);
            }
            String str = (String) obj;
            SportsDescriptionVM.this.u().postValue(str);
            if (str != null && (m4 = AppDatabase.f23168a.a().m()) != null) {
                c0.d dVar = new c0.d(com.bxkj.base.v2.data.a.b.a().t(), NetworkPlatformConst.AD_NETWORK_NO_DATA, str);
                this.f24481a = 2;
                if (m4.insert(dVar, this) == h4) {
                    return h4;
                }
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsDescriptionVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.SportsDescriptionVM$getSportsDescription$2", f = "SportsDescriptionVM.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends SuspendLambda implements p<Exception, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24483a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24484b;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            b bVar = new b(cVar);
            bVar.f24484b = obj;
            return bVar;
        }

        @Override // l1.p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable kotlin.coroutines.c<? super Boolean> cVar) {
            return ((b) create(exc, cVar)).invokeSuspend(f1.f55527a);
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
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r5.f24483a
                r2 = 0
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L19
                if (r1 != r4) goto L11
                kotlin.d0.n(r6)
                goto L45
            L11:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L19:
                kotlin.d0.n(r6)
                java.lang.Object r6 = r5.f24484b
                java.lang.Exception r6 = (java.lang.Exception) r6
                boolean r6 = com.bxkj.base.v2.common.ext.e.a(r6)
                if (r6 == 0) goto L71
                java.lang.Object[] r6 = new java.lang.Object[r2]
                java.lang.String r1 = "\u79bb\u7ebf\u8dd1\u6b65\u83b7\u53d6\u8dd1\u6b65\u8bf4\u660e"
                com.orhanobut.logger.j.d(r1, r6)
                com.bxkj.student.v2.common.db.AppDatabase$b r6 = com.bxkj.student.v2.common.db.AppDatabase.f23168a
                com.bxkj.student.v2.common.db.AppDatabase r6 = r6.a()
                com.bxkj.student.v2.common.db.dao.g r6 = r6.m()
                if (r6 != 0) goto L3a
                goto L63
            L3a:
                r5.f24483a = r4
                java.lang.String r1 = "-2"
                java.lang.Object r6 = r6.b(r1, r5)
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
                com.bxkj.student.v2.vm.sports.SportsDescriptionVM r0 = com.bxkj.student.v2.vm.sports.SportsDescriptionVM.this
                androidx.lifecycle.MutableLiveData r0 = r0.u()
                r0.postValue(r6)
                kotlin.f1 r3 = kotlin.f1.f55527a
            L63:
                if (r3 != 0) goto L70
                com.bxkj.student.v2.vm.sports.SportsDescriptionVM r6 = com.bxkj.student.v2.vm.sports.SportsDescriptionVM.this
                androidx.lifecycle.MutableLiveData r6 = r6.f()
                java.lang.String r0 = "\u670d\u52a1\u5668\u7ef4\u62a4\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8fdb\u884c\u8dd1\u6b65"
                r6.postValue(r0)
            L70:
                r2 = 1
            L71:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.a.a(r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.SportsDescriptionVM.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsDescriptionVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/d;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class c extends Lambda implements l1.a<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f24486a = new c();

        c() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final d invoke() {
            return new d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d w() {
        return (d) this.f24480i.getValue();
    }

    @NotNull
    public final MutableLiveData<String> u() {
        return this.f24479h;
    }

    public final void v() {
        BaseViewModel.j(this, new a(null), null, new b(null), null, null, null, null, null, 250, null);
    }

    public final void x(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f24479h = mutableLiveData;
    }
}
