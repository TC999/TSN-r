package com.bxkj.student.v2.repository.sports;

import com.bxkj.student.v2.common.db.AppDatabase;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SportsHomeRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J#\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\tJ%\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\tJ%\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\tJ\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0005J)\u0010\u001c\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001b\u0018\u00010\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0005J%\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\tJ\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\tJ+\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/e;", "", "", "", "e", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "g", "identity", "a", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "sportsType", "f", "(ILkotlin/coroutines/c;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "param", "h", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "i", "userNumber", "", "Lc0/c;", "d", "k", "Lkotlin/f1;", "c", "", "", "l", "j", "m", "identifys", "b", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", f = "SportsHomeRepository.kt", i = {}, l = {17}, m = "checkExceptionTimeOut", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23653a;

        /* renamed from: c  reason: collision with root package name */
        int f23655c;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23653a = obj;
            this.f23655c |= Integer.MIN_VALUE;
            return e.this.a(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", f = "SportsHomeRepository.kt", i = {}, l = {39}, m = "checkExerciseRecord", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23656a;

        /* renamed from: c  reason: collision with root package name */
        int f23658c;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23656a = obj;
            this.f23658c |= Integer.MIN_VALUE;
            return e.this.b(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", f = "SportsHomeRepository.kt", i = {}, l = {15}, m = "getSportsHomeMenu", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23659a;

        /* renamed from: c  reason: collision with root package name */
        int f23661c;

        c(kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23659a = obj;
            this.f23661c |= Integer.MIN_VALUE;
            return e.this.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", f = "SportsHomeRepository.kt", i = {}, l = {16}, m = "getSportsResult", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23662a;

        /* renamed from: c  reason: collision with root package name */
        int f23664c;

        d(kotlin.coroutines.c<? super d> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23662a = obj;
            this.f23664c |= Integer.MIN_VALUE;
            return e.this.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", f = "SportsHomeRepository.kt", i = {}, l = {19}, m = "getSportsResult", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0306e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23665a;

        /* renamed from: c  reason: collision with root package name */
        int f23667c;

        C0306e(kotlin.coroutines.c<? super C0306e> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23665a = obj;
            this.f23667c |= Integer.MIN_VALUE;
            return e.this.f(0, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", f = "SportsHomeRepository.kt", i = {}, l = {21}, m = "getSportsResultV2", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23668a;

        /* renamed from: c  reason: collision with root package name */
        int f23670c;

        f(kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23668a = obj;
            this.f23670c |= Integer.MIN_VALUE;
            return e.this.h(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", f = "SportsHomeRepository.kt", i = {}, l = {23}, m = "getSportsStartTime", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23671a;

        /* renamed from: c  reason: collision with root package name */
        int f23673c;

        g(kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23671a = obj;
            this.f23673c |= Integer.MIN_VALUE;
            return e.this.i(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", f = "SportsHomeRepository.kt", i = {}, l = {35}, m = "getVirtualList", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class h extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23674a;

        /* renamed from: c  reason: collision with root package name */
        int f23676c;

        h(kotlin.coroutines.c<? super h> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23674a = obj;
            this.f23676c |= Integer.MIN_VALUE;
            return e.this.l(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.sports.e.a
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.e$a r0 = (com.bxkj.student.v2.repository.sports.e.a) r0
            int r1 = r0.f23655c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23655c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$a r0 = new com.bxkj.student.v2.repository.sports.e$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f23653a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23655c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.d0.n(r6)
            com.bxkj.student.v2.retrofit.c r6 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r6 = r6.b()
            r0.f23655c = r3
            java.lang.Object r6 = r6.A(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r6.apiData()
            java.lang.String r5 = (java.lang.String) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.e.a(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.sports.e.b
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.e$b r0 = (com.bxkj.student.v2.repository.sports.e.b) r0
            int r1 = r0.f23658c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23658c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$b r0 = new com.bxkj.student.v2.repository.sports.e$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f23656a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23658c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.d0.n(r6)
            com.bxkj.student.v2.retrofit.c r6 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r6 = r6.b()
            r0.f23658c = r3
            java.lang.Object r6 = r6.Y(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r6.apiData()
            java.util.Map r5 = (java.util.Map) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.e.b(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    public final Object c(@NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        com.bxkj.student.v2.common.db.dao.a l4 = AppDatabase.f23168a.a().l();
        if (l4 == null) {
            return null;
        }
        Object a4 = l4.a(cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return a4 == h4 ? a4 : f1.f55527a;
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar) {
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        return n4.getExceptionSports(str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.sports.e.c
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.e$c r0 = (com.bxkj.student.v2.repository.sports.e.c) r0
            int r1 = r0.f23661c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23661c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$c r0 = new com.bxkj.student.v2.repository.sports.e$c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23659a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23661c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.d0.n(r5)
            com.bxkj.student.v2.retrofit.c r5 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r5 = r5.b()
            r0.f23661c = r3
            java.lang.Object r5 = r5.j(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.v2.http.result.ApiResult) r5
            if (r5 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r5.apiData()
            java.util.Map r5 = (java.util.Map) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.e.e(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.sports.e.C0306e
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.e$e r0 = (com.bxkj.student.v2.repository.sports.e.C0306e) r0
            int r1 = r0.f23667c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23667c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$e r0 = new com.bxkj.student.v2.repository.sports.e$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f23665a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23667c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.d0.n(r6)
            com.bxkj.student.v2.retrofit.c r6 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r6 = r6.b()
            r0.f23667c = r3
            java.lang.Object r6 = r6.z(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r6.apiData()
            java.util.Map r5 = (java.util.Map) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.e.f(int, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.sports.e.d
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.e$d r0 = (com.bxkj.student.v2.repository.sports.e.d) r0
            int r1 = r0.f23664c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23664c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$d r0 = new com.bxkj.student.v2.repository.sports.e$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23662a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23664c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.d0.n(r5)
            com.bxkj.student.v2.retrofit.c r5 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r5 = r5.b()
            r0.f23664c = r3
            java.lang.Object r5 = r5.J(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.v2.http.result.ApiResult) r5
            if (r5 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r5.apiData()
            java.util.Map r5 = (java.util.Map) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.e.g(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.lang.String> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.bxkj.student.v2.repository.sports.e.f
            if (r0 == 0) goto L13
            r0 = r7
            com.bxkj.student.v2.repository.sports.e$f r0 = (com.bxkj.student.v2.repository.sports.e.f) r0
            int r1 = r0.f23670c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23670c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$f r0 = new com.bxkj.student.v2.repository.sports.e$f
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f23668a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23670c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r7)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.d0.n(r7)
            com.bxkj.student.v2.retrofit.c r7 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r7 = r7.b()
            r0.f23670c = r3
            java.lang.Object r7 = r7.O(r5, r6, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r7 = (com.bxkj.base.v2.http.result.ApiResult) r7
            if (r7 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r7.apiData()
            java.lang.String r5 = (java.lang.String) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.e.h(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.sports.e.g
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.e$g r0 = (com.bxkj.student.v2.repository.sports.e.g) r0
            int r1 = r0.f23673c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23673c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$g r0 = new com.bxkj.student.v2.repository.sports.e$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f23671a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23673c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.d0.n(r6)
            com.bxkj.student.v2.retrofit.c r6 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r6 = r6.b()
            r0.f23673c = r3
            java.lang.Object r6 = r6.E(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r6.apiData()
            java.util.Map r5 = (java.util.Map) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.e.i(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    public final Object j(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar) {
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        return n4.g(str, cVar);
    }

    @Nullable
    public final Object k(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar) {
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        return n4.h(str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.sports.e.h
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.e$h r0 = (com.bxkj.student.v2.repository.sports.e.h) r0
            int r1 = r0.f23676c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23676c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$h r0 = new com.bxkj.student.v2.repository.sports.e$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23674a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23676c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.d0.n(r5)
            com.bxkj.student.v2.retrofit.c r5 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r5 = r5.b()
            r0.f23676c = r3
            java.lang.Object r5 = r5.P(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.v2.http.result.ApiResult) r5
            if (r5 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r5.apiData()
            java.util.List r5 = (java.util.List) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.e.l(kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    public final Object m(@NotNull String str, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        Object c4 = n4.c(str, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return c4 == h4 ? c4 : f1.f55527a;
    }
}
