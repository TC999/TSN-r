package com.bxkj.student.p094v2.repository.sports;

import com.bxkj.student.p094v2.common.p095db.AppDatabase;
import com.bxkj.student.p094v2.common.p095db.dao.SportsDao;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.SportsDb;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/a;", "", "", "exerciseRecordId", "", "c", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "identify", "", "Lc0/c;", "a", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.repository.sports.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RecordDetailRepository {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordDetailRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.RecordDetailRepository", m8638f = "RecordDetailRepository.kt", m8637i = {}, m8636l = {17}, m8635m = "getSportsAppeal", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5575a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20281a;

        /* renamed from: c */
        int f20283c;

        C5575a(InterfaceC14268c<? super C5575a> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20281a = obj;
            this.f20283c |= Integer.MIN_VALUE;
            return RecordDetailRepository.this.m38983b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordDetailRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.RecordDetailRepository", m8638f = "RecordDetailRepository.kt", m8637i = {}, m8636l = {15}, m8635m = "getSportsRecordDetail", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5576b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20284a;

        /* renamed from: c */
        int f20286c;

        C5576b(InterfaceC14268c<? super C5576b> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20284a = obj;
            this.f20286c |= Integer.MIN_VALUE;
            return RecordDetailRepository.this.m38982c(null, this);
        }
    }

    @Nullable
    /* renamed from: a */
    public final Object m38984a(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c) {
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        return mo39225l.getLocalRecordById(str, interfaceC14268c);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38983b(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.p094v2.repository.sports.RecordDetailRepository.C5575a
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.a$a r0 = (com.bxkj.student.p094v2.repository.sports.RecordDetailRepository.C5575a) r0
            int r1 = r0.f20283c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20283c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.a$a r0 = new com.bxkj.student.v2.repository.sports.a$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20281a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20283c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C14294d0.m8596n(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.C14294d0.m8596n(r5)
            com.bxkj.student.v2.retrofit.b r5 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r5 = r5.m38888b()
            r0.f20283c = r3
            java.lang.Object r5 = r5.m38936P(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.p085v2.http.result.ApiResult) r5
            if (r5 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r5.apiData()
            java.util.Map r5 = (java.util.Map) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.RecordDetailRepository.m38983b(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38982c(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.p094v2.repository.sports.RecordDetailRepository.C5576b
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.a$b r0 = (com.bxkj.student.p094v2.repository.sports.RecordDetailRepository.C5576b) r0
            int r1 = r0.f20286c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20286c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.a$b r0 = new com.bxkj.student.v2.repository.sports.a$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20284a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20286c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C14294d0.m8596n(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.C14294d0.m8596n(r6)
            com.bxkj.student.v2.retrofit.b r6 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r6 = r6.m38888b()
            r0.f20286c = r3
            java.lang.Object r6 = r6.m38937O(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.p085v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r6.apiData()
            java.util.Map r5 = (java.util.Map) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.RecordDetailRepository.m38982c(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
