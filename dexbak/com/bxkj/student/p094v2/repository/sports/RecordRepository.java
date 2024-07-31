package com.bxkj.student.p094v2.repository.sports;

import com.bxkj.student.p094v2.common.p095db.AppDatabase;
import com.bxkj.student.p094v2.common.p095db.dao.FaceDao;
import com.bxkj.student.p094v2.common.p095db.dao.SportsDao;
import com.umeng.analytics.AnalyticsConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p023b0.CountDistanceTime;
import p027c0.SportsDb;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJG\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0014J%\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u000fJ%\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/b;", "", "", "status", "date", "", "datePageIndex", "isFeedback", "", "g", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "userNumber", "", "Lc0/c;", "e", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", AnalyticsConfig.RTD_START_TIME, "endTime", "d", "(Ljava/lang/String;JJLkotlin/coroutines/c;)Ljava/lang/Object;", "Lb0/b;", "f", "identify", "c", "Lc0/a;", "b", "Lkotlin/f1;", "a", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.repository.sports.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RecordRepository {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.RecordRepository", m8638f = "RecordRepository.kt", m8637i = {}, m8636l = {28}, m8635m = "getLocalFace", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5577a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20287a;

        /* renamed from: c */
        int f20289c;

        C5577a(InterfaceC14268c<? super C5577a> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20287a = obj;
            this.f20289c |= Integer.MIN_VALUE;
            return RecordRepository.this.m38980b(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.RecordRepository", m8638f = "RecordRepository.kt", m8637i = {}, m8636l = {17}, m8635m = "v3GetSportsResult", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.b$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5578b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20290a;

        /* renamed from: c */
        int f20292c;

        C5578b(InterfaceC14268c<? super C5578b> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20290a = obj;
            this.f20292c |= Integer.MIN_VALUE;
            return RecordRepository.this.m38975g(null, null, 0, null, this);
        }
    }

    /* renamed from: h */
    public static /* synthetic */ Object m38974h(RecordRepository recordRepository, String str, String str2, int i, String str3, InterfaceC14268c interfaceC14268c, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return recordRepository.m38975g(str, str2, i, str3, interfaceC14268c);
    }

    @Nullable
    /* renamed from: a */
    public final Object m38981a(@NotNull String str, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        FaceDao mo39227j = AppDatabase.f19934a.m39228a().mo39227j();
        if (mo39227j == null) {
            return null;
        }
        Object deleteByIdentify = mo39227j.deleteByIdentify(str, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return deleteByIdentify == m8642h ? deleteByIdentify : Unit.f41048a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38980b(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.List<p027c0.FaceDb>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.p094v2.repository.sports.RecordRepository.C5577a
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.b$a r0 = (com.bxkj.student.p094v2.repository.sports.RecordRepository.C5577a) r0
            int r1 = r0.f20289c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20289c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.b$a r0 = new com.bxkj.student.v2.repository.sports.b$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20287a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20289c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C14294d0.m8596n(r6)
            goto L4b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.C14294d0.m8596n(r6)
            com.bxkj.student.v2.common.db.AppDatabase$b r6 = com.bxkj.student.p094v2.common.p095db.AppDatabase.f19934a
            com.bxkj.student.v2.common.db.AppDatabase r6 = r6.m39228a()
            com.bxkj.student.v2.common.db.dao.a r6 = r6.mo39227j()
            if (r6 != 0) goto L42
            r5 = 0
            goto L4e
        L42:
            r0.f20289c = r3
            java.lang.Object r6 = r6.mo39211b(r5, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r5 = r6
            java.util.List r5 = (java.util.List) r5
        L4e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.RecordRepository.m38980b(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: c */
    public final Object m38979c(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c) {
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        return mo39225l.getLocalRecordById(str, interfaceC14268c);
    }

    @Nullable
    /* renamed from: d */
    public final Object m38978d(@NotNull String str, long j, long j2, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c) {
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        return mo39225l.mo39177f(str, j, j2, interfaceC14268c);
    }

    @Nullable
    /* renamed from: e */
    public final Object m38977e(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c) {
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        return mo39225l.mo39176g(str, interfaceC14268c);
    }

    @Nullable
    /* renamed from: f */
    public final Object m38976f(@NotNull String str, long j, long j2, @NotNull InterfaceC14268c<? super List<CountDistanceTime>> interfaceC14268c) {
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        return mo39225l.mo39175h(str, j, j2, interfaceC14268c);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38975g(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, int r10, @org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, java.lang.Object>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.bxkj.student.p094v2.repository.sports.RecordRepository.C5578b
            if (r0 == 0) goto L13
            r0 = r12
            com.bxkj.student.v2.repository.sports.b$b r0 = (com.bxkj.student.p094v2.repository.sports.RecordRepository.C5578b) r0
            int r1 = r0.f20292c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20292c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.b$b r0 = new com.bxkj.student.v2.repository.sports.b$b
            r0.<init>(r12)
        L18:
            r6 = r0
            java.lang.Object r12 = r6.f20290a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r1 = r6.f20292c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.C14294d0.m8596n(r12)
            goto L48
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            kotlin.C14294d0.m8596n(r12)
            com.bxkj.student.v2.retrofit.b r12 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r1 = r12.m38888b()
            r6.f20292c = r2
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r12 = r1.m38939M(r2, r3, r4, r5, r6)
            if (r12 != r0) goto L48
            return r0
        L48:
            com.bxkj.base.v2.http.result.ApiResult r12 = (com.bxkj.base.p085v2.http.result.ApiResult) r12
            if (r12 != 0) goto L4e
            r8 = 0
            goto L54
        L4e:
            java.lang.Object r8 = r12.apiData()
            java.util.Map r8 = (java.util.Map) r8
        L54:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.RecordRepository.m38975g(java.lang.String, java.lang.String, int, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
