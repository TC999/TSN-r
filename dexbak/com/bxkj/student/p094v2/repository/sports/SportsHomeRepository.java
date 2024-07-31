package com.bxkj.student.p094v2.repository.sports;

import com.bxkj.student.p094v2.common.p095db.AppDatabase;
import com.bxkj.student.p094v2.common.p095db.dao.FaceDao;
import com.bxkj.student.p094v2.common.p095db.dao.SportsDao;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.SportsDb;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\tJ%\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\tJ%\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\tJ\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0005J)\u0010\u001c\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001b\u0018\u00010\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/e;", "", "", "", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "identity", "a", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "sportsType", "e", "(ILkotlin/coroutines/c;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "param", "g", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "h", "userNumber", "", "Lc0/c;", "c", "i", "Lkotlin/f1;", "b", "", "", "j", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.repository.sports.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsHomeRepository {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", m8638f = "SportsHomeRepository.kt", m8637i = {}, m8636l = {16}, m8635m = "checkExceptionTimeOut", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.e$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5580a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20296a;

        /* renamed from: c */
        int f20298c;

        C5580a(InterfaceC14268c<? super C5580a> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20296a = obj;
            this.f20298c |= Integer.MIN_VALUE;
            return SportsHomeRepository.this.m38971a(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", m8638f = "SportsHomeRepository.kt", m8637i = {}, m8636l = {14}, m8635m = "getSportsHomeMenu", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.e$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5581b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20299a;

        /* renamed from: c */
        int f20301c;

        C5581b(InterfaceC14268c<? super C5581b> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20299a = obj;
            this.f20301c |= Integer.MIN_VALUE;
            return SportsHomeRepository.this.m38968d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", m8638f = "SportsHomeRepository.kt", m8637i = {}, m8636l = {15}, m8635m = "getSportsResult", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.e$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5582c extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20302a;

        /* renamed from: c */
        int f20304c;

        C5582c(InterfaceC14268c<? super C5582c> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20302a = obj;
            this.f20304c |= Integer.MIN_VALUE;
            return SportsHomeRepository.this.m38966f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", m8638f = "SportsHomeRepository.kt", m8637i = {}, m8636l = {18}, m8635m = "getSportsResult", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.e$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5583d extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20305a;

        /* renamed from: c */
        int f20307c;

        C5583d(InterfaceC14268c<? super C5583d> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20305a = obj;
            this.f20307c |= Integer.MIN_VALUE;
            return SportsHomeRepository.this.m38967e(0, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", m8638f = "SportsHomeRepository.kt", m8637i = {}, m8636l = {20}, m8635m = "getSportsResultV2", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.e$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5584e extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20308a;

        /* renamed from: c */
        int f20310c;

        C5584e(InterfaceC14268c<? super C5584e> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20308a = obj;
            this.f20310c |= Integer.MIN_VALUE;
            return SportsHomeRepository.this.m38965g(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", m8638f = "SportsHomeRepository.kt", m8637i = {}, m8636l = {22}, m8635m = "getSportsStartTime", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.e$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5585f extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20311a;

        /* renamed from: c */
        int f20313c;

        C5585f(InterfaceC14268c<? super C5585f> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20311a = obj;
            this.f20313c |= Integer.MIN_VALUE;
            return SportsHomeRepository.this.m38964h(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.SportsHomeRepository", m8638f = "SportsHomeRepository.kt", m8637i = {}, m8636l = {34}, m8635m = "getVirtualList", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.e$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5586g extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20314a;

        /* renamed from: c */
        int f20316c;

        C5586g(InterfaceC14268c<? super C5586g> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20314a = obj;
            this.f20316c |= Integer.MIN_VALUE;
            return SportsHomeRepository.this.m38962j(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38971a(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5580a
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.e$a r0 = (com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5580a) r0
            int r1 = r0.f20298c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20298c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$a r0 = new com.bxkj.student.v2.repository.sports.e$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20296a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20298c
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
            r0.f20298c = r3
            java.lang.Object r6 = r6.m38908w(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.p085v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r6.apiData()
            java.lang.String r5 = (java.lang.String) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.m38971a(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: b */
    public final Object m38970b(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        FaceDao mo39227j = AppDatabase.f19934a.m39228a().mo39227j();
        if (mo39227j == null) {
            return null;
        }
        Object mo39212a = mo39227j.mo39212a(interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo39212a == m8642h ? mo39212a : Unit.f41048a;
    }

    @Nullable
    /* renamed from: c */
    public final Object m38969c(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c) {
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        return mo39225l.getExceptionSports(str, interfaceC14268c);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38968d(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5581b
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.e$b r0 = (com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5581b) r0
            int r1 = r0.f20301c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20301c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$b r0 = new com.bxkj.student.v2.repository.sports.e$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20299a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20301c
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
            r0.f20301c = r3
            java.lang.Object r5 = r5.m38923h(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.m38968d(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38967e(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5583d
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.e$d r0 = (com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5583d) r0
            int r1 = r0.f20307c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20307c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$d r0 = new com.bxkj.student.v2.repository.sports.e$d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20305a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20307c
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
            r0.f20307c = r3
            java.lang.Object r6 = r6.m38909v(r5, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.m38967e(int, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38966f(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5582c
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.e$c r0 = (com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5582c) r0
            int r1 = r0.f20304c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20304c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$c r0 = new com.bxkj.student.v2.repository.sports.e$c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20302a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20304c
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
            r0.f20304c = r3
            java.lang.Object r5 = r5.m38946F(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.m38966f(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38965g(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.lang.String> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5584e
            if (r0 == 0) goto L13
            r0 = r7
            com.bxkj.student.v2.repository.sports.e$e r0 = (com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5584e) r0
            int r1 = r0.f20310c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20310c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$e r0 = new com.bxkj.student.v2.repository.sports.e$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20308a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20310c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C14294d0.m8596n(r7)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.C14294d0.m8596n(r7)
            com.bxkj.student.v2.retrofit.b r7 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r7 = r7.m38888b()
            r0.f20310c = r3
            java.lang.Object r7 = r7.m38941K(r5, r6, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r7 = (com.bxkj.base.p085v2.http.result.ApiResult) r7
            if (r7 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r7.apiData()
            java.lang.String r5 = (java.lang.String) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.m38965g(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38964h(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5585f
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.sports.e$f r0 = (com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5585f) r0
            int r1 = r0.f20313c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20313c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$f r0 = new com.bxkj.student.v2.repository.sports.e$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20311a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20313c
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
            r0.f20313c = r3
            java.lang.Object r6 = r6.m38951A(r5, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.m38964h(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: i */
    public final Object m38963i(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c) {
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        return mo39225l.mo39182a(str, interfaceC14268c);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38962j(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5586g
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.sports.e$g r0 = (com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.C5586g) r0
            int r1 = r0.f20316c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20316c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.e$g r0 = new com.bxkj.student.v2.repository.sports.e$g
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20314a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20316c
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
            r0.f20316c = r3
            java.lang.Object r5 = r5.m38940L(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.p085v2.http.result.ApiResult) r5
            if (r5 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r5.apiData()
            java.util.List r5 = (java.util.List) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.SportsHomeRepository.m38962j(kotlin.coroutines.c):java.lang.Object");
    }
}
