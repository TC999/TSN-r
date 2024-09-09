package com.bxkj.student.v2.repository.sports;

import com.bxkj.student.v2.common.db.AppDatabase;
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
/* compiled from: RecordRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJG\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0014J%\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u000fJ%\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u000fJ\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/b;", "", "", "status", "date", "", "datePageIndex", "isFeedback", "", "g", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "userNumber", "", "Lc0/c;", "e", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "startTime", "endTime", "d", "(Ljava/lang/String;JJLkotlin/coroutines/c;)Ljava/lang/Object;", "Lb0/b;", "f", "identify", "c", "Lc0/a;", "b", "Lkotlin/f1;", "a", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: RecordRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.RecordRepository", f = "RecordRepository.kt", i = {}, l = {28}, m = "getLocalFace", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23644a;

        /* renamed from: c  reason: collision with root package name */
        int f23646c;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23644a = obj;
            this.f23646c |= Integer.MIN_VALUE;
            return b.this.b(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: RecordRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.RecordRepository", f = "RecordRepository.kt", i = {}, l = {17}, m = "v3GetSportsResult", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0305b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23647a;

        /* renamed from: c  reason: collision with root package name */
        int f23649c;

        C0305b(kotlin.coroutines.c<? super C0305b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23647a = obj;
            this.f23649c |= Integer.MIN_VALUE;
            return b.this.g(null, null, 0, null, this);
        }
    }

    public static /* synthetic */ Object h(b bVar, String str, String str2, int i4, String str3, kotlin.coroutines.c cVar, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            str3 = null;
        }
        return bVar.g(str, str2, i4, str3, cVar);
    }

    @Nullable
    public final Object a(@NotNull String str, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        com.bxkj.student.v2.common.db.dao.a l4 = AppDatabase.f23168a.a().l();
        if (l4 == null) {
            return null;
        }
        Object deleteByIdentify = l4.deleteByIdentify(str, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return deleteByIdentify == h4 ? deleteByIdentify : f1.f55527a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.List<c0.a>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.sports.b.a
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.b$a r0 = (com.bxkj.student.v2.repository.sports.b.a) r0
            int r1 = r0.f23646c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23646c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.b$a r0 = new com.bxkj.student.v2.repository.sports.b$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f23644a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23646c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r6)
            goto L4b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.d0.n(r6)
            com.bxkj.student.v2.common.db.AppDatabase$b r6 = com.bxkj.student.v2.common.db.AppDatabase.f23168a
            com.bxkj.student.v2.common.db.AppDatabase r6 = r6.a()
            com.bxkj.student.v2.common.db.dao.a r6 = r6.l()
            if (r6 != 0) goto L42
            r5 = 0
            goto L4e
        L42:
            r0.f23646c = r3
            java.lang.Object r6 = r6.b(r5, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r5 = r6
            java.util.List r5 = (java.util.List) r5
        L4e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.b.b(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar) {
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        return n4.getLocalRecordById(str, cVar);
    }

    @Nullable
    public final Object d(@NotNull String str, long j4, long j5, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar) {
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        return n4.e(str, j4, j5, cVar);
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar) {
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        return n4.h(str, cVar);
    }

    @Nullable
    public final Object f(@NotNull String str, long j4, long j5, @NotNull kotlin.coroutines.c<? super List<b0.b>> cVar) {
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        return n4.i(str, j4, j5, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, int r10, @org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.bxkj.student.v2.repository.sports.b.C0305b
            if (r0 == 0) goto L13
            r0 = r12
            com.bxkj.student.v2.repository.sports.b$b r0 = (com.bxkj.student.v2.repository.sports.b.C0305b) r0
            int r1 = r0.f23649c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23649c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.b$b r0 = new com.bxkj.student.v2.repository.sports.b$b
            r0.<init>(r12)
        L18:
            r6 = r0
            java.lang.Object r12 = r6.f23647a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
            int r1 = r6.f23649c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.d0.n(r12)
            goto L48
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            kotlin.d0.n(r12)
            com.bxkj.student.v2.retrofit.c r12 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r1 = r12.b()
            r6.f23649c = r2
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r12 = r1.Q(r2, r3, r4, r5, r6)
            if (r12 != r0) goto L48
            return r0
        L48:
            com.bxkj.base.v2.http.result.ApiResult r12 = (com.bxkj.base.v2.http.result.ApiResult) r12
            if (r12 != 0) goto L4e
            r8 = 0
            goto L54
        L4e:
            java.lang.Object r8 = r12.apiData()
            java.util.Map r8 = (java.util.Map) r8
        L54:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.b.g(java.lang.String, java.lang.String, int, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
