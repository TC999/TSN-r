package com.bxkj.student.run.app.vm;

import android.text.TextUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RunVM.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u0007\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002J$\u0010\b\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002J,\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u001c\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J,\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u001c\u0010\u0006\u001a\u0018\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0002J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0004R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/bxkj/student/run/app/vm/RunVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "Lkotlin/Function1;", "", "Lcom/bxkj/student/run/app/offline/table/RunDb;", "Lkotlin/f1;", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "z", "A", "", "runType", "x", "runDb", "Lkotlin/Function0;", "C", "B", "", "identify", "u", "v", "y", "La0/a;", "h", "Lkotlin/o;", "w", "()La0/a;", "runStartRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class RunVM extends BaseViewModel {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.o f22962h = q.c(k.f22996a);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$deleteExceptionRecord$1", f = "RunVM.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f22963a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22964b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, kotlin.coroutines.c<? super a> cVar) {
            super(1, cVar);
            this.f22964b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f22964b, cVar);
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
            int i4 = this.f22963a;
            if (i4 == 0) {
                d0.n(obj);
                a0.a aVar = new a0.a();
                String str = this.f22964b;
                this.f22963a = 1;
                if (aVar.a(str, this) == h4) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$getLocalRecordById$1", f = "RunVM.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f22965a;

        /* renamed from: b  reason: collision with root package name */
        int f22966b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f22967c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f22968d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.ObjectRef<List<RunDb>> objectRef, String str, kotlin.coroutines.c<? super b> cVar) {
            super(1, cVar);
            this.f22967c = objectRef;
            this.f22968d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new b(this.f22967c, this.f22968d, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t3;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f22966b;
            if (i4 == 0) {
                d0.n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f22967c;
                a0.a aVar = new a0.a();
                String str = this.f22968d;
                this.f22965a = objectRef2;
                this.f22966b = 1;
                Object c4 = aVar.c(str, this);
                if (c4 == h4) {
                    return h4;
                }
                objectRef = objectRef2;
                t3 = c4;
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                objectRef = (Ref.ObjectRef) this.f22965a;
                d0.n(obj);
                t3 = obj;
            }
            objectRef.element = t3;
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$getLocalRecordById$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f22969a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.l<List<RunDb>, f1> f22970b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f22971c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(l1.l<? super List<RunDb>, f1> lVar, Ref.ObjectRef<List<RunDb>> objectRef, kotlin.coroutines.c<? super c> cVar) {
            super(1, cVar);
            this.f22970b = lVar;
            this.f22971c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new c(this.f22970b, this.f22971c, cVar);
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
            kotlin.coroutines.intrinsics.b.h();
            if (this.f22969a == 0) {
                d0.n(obj);
                this.f22970b.invoke(this.f22971c.element);
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$getUploadFailSportsByType$1", f = "RunVM.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class d extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f22972a;

        /* renamed from: b  reason: collision with root package name */
        int f22973b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f22974c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RunVM f22975d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f22976e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Ref.ObjectRef<List<RunDb>> objectRef, RunVM runVM, int i4, kotlin.coroutines.c<? super d> cVar) {
            super(1, cVar);
            this.f22974c = objectRef;
            this.f22975d = runVM;
            this.f22976e = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new d(this.f22974c, this.f22975d, this.f22976e, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((d) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t3;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f22973b;
            if (i4 == 0) {
                d0.n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f22974c;
                a0.a w3 = this.f22975d.w();
                String account = LoginUser.getLoginUser().getAccount();
                f0.o(account, "getLoginUser().account");
                int i5 = this.f22976e;
                this.f22972a = objectRef2;
                this.f22973b = 1;
                Object e4 = w3.e(account, i5, this);
                if (e4 == h4) {
                    return h4;
                }
                objectRef = objectRef2;
                t3 = e4;
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                objectRef = (Ref.ObjectRef) this.f22972a;
                d0.n(obj);
                t3 = obj;
            }
            objectRef.element = t3;
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$getUploadFailSportsByType$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class e extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f22977a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.l<List<RunDb>, f1> f22978b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f22979c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(l1.l<? super List<RunDb>, f1> lVar, Ref.ObjectRef<List<RunDb>> objectRef, kotlin.coroutines.c<? super e> cVar) {
            super(1, cVar);
            this.f22978b = lVar;
            this.f22979c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new e(this.f22978b, this.f22979c, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((e) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f22977a == 0) {
                d0.n(obj);
                this.f22978b.invoke(this.f22979c.element);
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$insertRun$1", f = "RunVM.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class f extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f22980a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RunDb f22981b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(RunDb runDb, kotlin.coroutines.c<? super f> cVar) {
            super(1, cVar);
            this.f22981b = runDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new f(this.f22981b, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((f) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f22980a;
            if (i4 == 0) {
                d0.n(obj);
                a0.a aVar = new a0.a();
                RunDb runDb = this.f22981b;
                this.f22980a = 1;
                if (aVar.f(runDb, this) == h4) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$queryExceptionSports$1", f = "RunVM.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class g extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f22982a;

        /* renamed from: b  reason: collision with root package name */
        int f22983b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f22984c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RunVM f22985d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Ref.ObjectRef<List<RunDb>> objectRef, RunVM runVM, kotlin.coroutines.c<? super g> cVar) {
            super(1, cVar);
            this.f22984c = objectRef;
            this.f22985d = runVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new g(this.f22984c, this.f22985d, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((g) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t3;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f22983b;
            if (i4 == 0) {
                d0.n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f22984c;
                a0.a w3 = this.f22985d.w();
                String account = LoginUser.getLoginUser().getAccount();
                f0.o(account, "getLoginUser().account");
                this.f22982a = objectRef2;
                this.f22983b = 1;
                Object b4 = w3.b(account, this);
                if (b4 == h4) {
                    return h4;
                }
                objectRef = objectRef2;
                t3 = b4;
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                objectRef = (Ref.ObjectRef) this.f22982a;
                d0.n(obj);
                t3 = obj;
            }
            objectRef.element = t3;
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$queryExceptionSports$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class h extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f22986a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.l<List<RunDb>, f1> f22987b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f22988c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        h(l1.l<? super List<RunDb>, f1> lVar, Ref.ObjectRef<List<RunDb>> objectRef, kotlin.coroutines.c<? super h> cVar) {
            super(1, cVar);
            this.f22987b = lVar;
            this.f22988c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new h(this.f22987b, this.f22988c, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((h) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f22986a == 0) {
                d0.n(obj);
                this.f22987b.invoke(this.f22988c.element);
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$queryFailRecord$1", f = "RunVM.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class i extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f22989a;

        /* renamed from: b  reason: collision with root package name */
        int f22990b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f22991c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RunVM f22992d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Ref.ObjectRef<List<RunDb>> objectRef, RunVM runVM, kotlin.coroutines.c<? super i> cVar) {
            super(1, cVar);
            this.f22991c = objectRef;
            this.f22992d = runVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new i(this.f22991c, this.f22992d, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((i) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            Ref.ObjectRef<List<RunDb>> objectRef;
            T t3;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f22990b;
            if (i4 == 0) {
                d0.n(obj);
                Ref.ObjectRef<List<RunDb>> objectRef2 = this.f22991c;
                a0.a w3 = this.f22992d.w();
                String account = LoginUser.getLoginUser().getAccount();
                f0.o(account, "getLoginUser().account");
                this.f22989a = objectRef2;
                this.f22990b = 1;
                Object d4 = w3.d(account, this);
                if (d4 == h4) {
                    return h4;
                }
                objectRef = objectRef2;
                t3 = d4;
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                objectRef = (Ref.ObjectRef) this.f22989a;
                d0.n(obj);
                t3 = obj;
            }
            objectRef.element = t3;
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$queryFailRecord$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class j extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f22993a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.l<List<RunDb>, f1> f22994b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<RunDb>> f22995c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        j(l1.l<? super List<RunDb>, f1> lVar, Ref.ObjectRef<List<RunDb>> objectRef, kotlin.coroutines.c<? super j> cVar) {
            super(1, cVar);
            this.f22994b = lVar;
            this.f22995c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new j(this.f22994b, this.f22995c, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((j) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f22993a == 0) {
                d0.n(obj);
                this.f22994b.invoke(this.f22995c.element);
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"La0/a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class k extends Lambda implements l1.a<a0.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f22996a = new k();

        k() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final a0.a invoke() {
            return new a0.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionStatus$1", f = "RunVM.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class l extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f22997a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RunDb f22998b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(RunDb runDb, kotlin.coroutines.c<? super l> cVar) {
            super(1, cVar);
            this.f22998b = runDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new l(this.f22998b, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((l) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f22997a;
            if (i4 == 0) {
                d0.n(obj);
                this.f22998b.setEndTime(String.valueOf(System.currentTimeMillis()));
                a0.a aVar = new a0.a();
                String endTime = this.f22998b.getEndTime();
                String uploadType = this.f22998b.getUploadType();
                String identify = this.f22998b.getIdentify();
                this.f22997a = 1;
                if (aVar.g(endTime, uploadType, identify, this) == h4) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionStatus$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class m extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f22999a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f23000b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(l1.a<f1> aVar, kotlin.coroutines.c<? super m> cVar) {
            super(1, cVar);
            this.f23000b = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new m(this.f23000b, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((m) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f22999a == 0) {
                d0.n(obj);
                this.f23000b.invoke();
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionToFail$1", f = "RunVM.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class n extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23001a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RunDb f23002b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(RunDb runDb, kotlin.coroutines.c<? super n> cVar) {
            super(1, cVar);
            this.f23002b = runDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new n(this.f23002b, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((n) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f23001a;
            if (i4 == 0) {
                d0.n(obj);
                this.f23002b.setEndTime(String.valueOf(System.currentTimeMillis()));
                this.f23002b.setUploadType("2");
                a0.a aVar = new a0.a();
                String endTime = this.f23002b.getEndTime();
                String uploadType = this.f23002b.getUploadType();
                String identify = this.f23002b.getIdentify();
                this.f23001a = 1;
                if (aVar.g(endTime, uploadType, identify, this) == h4) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.run.app.vm.RunVM$updateExceptionToFail$2", f = "RunVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class o extends SuspendLambda implements l1.l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23003a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f23004b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(l1.a<f1> aVar, kotlin.coroutines.c<? super o> cVar) {
            super(1, cVar);
            this.f23004b = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new o(this.f23004b, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((o) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f23003a == 0) {
                d0.n(obj);
                this.f23004b.invoke();
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a0.a w() {
        return (a0.a) this.f22962h.getValue();
    }

    public final void A(@NotNull l1.l<? super List<RunDb>, f1> complete) {
        f0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.j(this, new i(objectRef, this, null), null, null, null, new j(complete, objectRef, null), null, null, null, 238, null);
    }

    public final void B(@NotNull RunDb runDb, @NotNull l1.a<f1> complete) {
        f0.p(runDb, "runDb");
        f0.p(complete, "complete");
        if (TextUtils.isEmpty(runDb.getEndTime())) {
            BaseViewModel.j(this, new l(runDb, null), null, null, null, new m(complete, null), null, null, null, 238, null);
        }
    }

    public final void C(@NotNull RunDb runDb, @NotNull l1.a<f1> complete) {
        f0.p(runDb, "runDb");
        f0.p(complete, "complete");
        if (TextUtils.isEmpty(runDb.getEndTime())) {
            BaseViewModel.j(this, new n(runDb, null), null, null, null, new o(complete, null), null, null, null, 238, null);
        }
    }

    public final void u(@NotNull String identify) {
        f0.p(identify, "identify");
        BaseViewModel.j(this, new a(identify, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void v(@NotNull String identify, @NotNull l1.l<? super List<RunDb>, f1> complete) {
        f0.p(identify, "identify");
        f0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.j(this, new b(objectRef, identify, null), null, null, null, new c(complete, objectRef, null), null, null, null, 238, null);
    }

    public final void x(int i4, @NotNull l1.l<? super List<RunDb>, f1> complete) {
        f0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.j(this, new d(objectRef, this, i4, null), null, null, null, new e(complete, objectRef, null), null, null, null, 238, null);
    }

    public final void y(@NotNull RunDb runDb) {
        f0.p(runDb, "runDb");
        BaseViewModel.j(this, new f(runDb, null), null, null, null, null, null, null, null, 254, null);
    }

    public final void z(@NotNull l1.l<? super List<RunDb>, f1> complete) {
        f0.p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.j(this, new g(objectRef, this, null), null, null, null, new h(complete, objectRef, null), null, null, null, 238, null);
    }
}
