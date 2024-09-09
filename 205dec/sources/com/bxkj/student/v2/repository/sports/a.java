package com.bxkj.student.v2.repository.sports;

import com.bxkj.student.v2.common.db.AppDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: RecordDetailRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u0006J#\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/a;", "", "", "exerciseRecordId", "", "d", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "c", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "identify", "", "Lc0/c;", "a", "b", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: RecordDetailRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.RecordDetailRepository", f = "RecordDetailRepository.kt", i = {}, l = {22}, m = "getShareCircleUrl", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0304a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23635a;

        /* renamed from: c  reason: collision with root package name */
        int f23637c;

        C0304a(kotlin.coroutines.c<? super C0304a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23635a = obj;
            this.f23637c |= Integer.MIN_VALUE;
            return a.this.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: RecordDetailRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.RecordDetailRepository", f = "RecordDetailRepository.kt", i = {}, l = {17}, m = "getSportsAppeal", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23638a;

        /* renamed from: c  reason: collision with root package name */
        int f23640c;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23638a = obj;
            this.f23640c |= Integer.MIN_VALUE;
            return a.this.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordDetailRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.RecordDetailRepository", f = "RecordDetailRepository.kt", i = {}, l = {15}, m = "getSportsRecordDetail", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23641a;

        /* renamed from: c  reason: collision with root package name */
        int f23643c;

        c(kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23641a = obj;
            this.f23643c |= Integer.MIN_VALUE;
            return a.this.d(null, this);
        }
    }

    @Nullable
    public final Object a(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar) {
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        return n4.getLocalRecordById(str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.bxkj.student.v2.repository.sports.a.C0304a
            if (r0 == 0) goto L13
            r0 = r8
            com.bxkj.student.v2.repository.sports.a$a r0 = (com.bxkj.student.v2.repository.sports.a.C0304a) r0
            int r1 = r0.f23637c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23637c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.a$a r0 = new com.bxkj.student.v2.repository.sports.a$a
            r0.<init>(r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.f23635a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
            int r1 = r4.f23637c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.d0.n(r8)
            goto L49
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L32:
            kotlin.d0.n(r8)
            com.bxkj.student.v2.retrofit.c r8 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r1 = r8.b()
            r8 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r4.f23637c = r2
            r2 = r8
            java.lang.Object r8 = com.bxkj.student.v2.retrofit.a.b.k(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L49
            return r0
        L49:
            com.bxkj.base.v2.http.result.ApiResult r8 = (com.bxkj.base.v2.http.result.ApiResult) r8
            if (r8 != 0) goto L4f
            r8 = 0
            goto L55
        L4f:
            java.lang.Object r8 = r8.apiData()
            java.util.Map r8 = (java.util.Map) r8
        L55:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.a.b(kotlin.coroutines.c):java.lang.Object");
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
    public final java.lang.Object c(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.sports.a.b
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.a$b r0 = (com.bxkj.student.v2.repository.sports.a.b) r0
            int r1 = r0.f23640c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23640c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.a$b r0 = new com.bxkj.student.v2.repository.sports.a$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23638a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23640c
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
            r0.f23640c = r3
            java.lang.Object r5 = r5.T(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.a.c(kotlin.coroutines.c):java.lang.Object");
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
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.sports.a.c
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.a$c r0 = (com.bxkj.student.v2.repository.sports.a.c) r0
            int r1 = r0.f23643c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23643c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.a$c r0 = new com.bxkj.student.v2.repository.sports.a$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f23641a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23643c
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
            r0.f23643c = r3
            java.lang.Object r6 = r6.S(r5, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.a.d(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
