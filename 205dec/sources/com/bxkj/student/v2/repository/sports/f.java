package com.bxkj.student.v2.repository.sports;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SportsRankRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/f;", "", "", "", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "b", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsRankRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsRankRepository", f = "SportsRankRepository.kt", i = {}, l = {12}, m = "getRank", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23677a;

        /* renamed from: c  reason: collision with root package name */
        int f23679c;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23677a = obj;
            this.f23679c |= Integer.MIN_VALUE;
            return f.this.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsRankRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsRankRepository", f = "SportsRankRepository.kt", i = {}, l = {13}, m = "rankingExerciseRecordV2", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23680a;

        /* renamed from: c  reason: collision with root package name */
        int f23682c;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23680a = obj;
            this.f23682c |= Integer.MIN_VALUE;
            return f.this.b(this);
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
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.sports.f.a
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.f$a r0 = (com.bxkj.student.v2.repository.sports.f.a) r0
            int r1 = r0.f23679c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23679c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.f$a r0 = new com.bxkj.student.v2.repository.sports.f$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23677a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23679c
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
            r0.f23679c = r3
            java.lang.Object r5 = r5.D(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.f.a(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.sports.f.b
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.f$b r0 = (com.bxkj.student.v2.repository.sports.f.b) r0
            int r1 = r0.f23682c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23682c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.f$b r0 = new com.bxkj.student.v2.repository.sports.f$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f23680a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23682c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.d0.n(r6)
            goto L44
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            kotlin.d0.n(r6)
            com.bxkj.student.v2.retrofit.c r6 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r6 = r6.b()
            r0.f23682c = r4
            java.lang.Object r6 = com.bxkj.student.v2.retrofit.a.b.p(r6, r3, r0, r4, r3)
            if (r6 != r1) goto L44
            return r1
        L44:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            goto L50
        L49:
            java.lang.Object r6 = r6.apiData()
            r3 = r6
            java.util.Map r3 = (java.util.Map) r3
        L50:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.f.b(kotlin.coroutines.c):java.lang.Object");
    }
}