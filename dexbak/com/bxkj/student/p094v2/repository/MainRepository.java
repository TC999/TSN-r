package com.bxkj.student.p094v2.repository;

import com.bxkj.student.p094v2.retrofit.RetrofitClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u0007\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005J)\u0010\b\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0005J#\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005J)\u0010\f\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0005J#\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0005J#\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0005J\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/b;", "", "", "", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "c", "h", "f", "Lkotlin/f1;", "j", "b", "i", "", "e", "id", "g", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.repository.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class MainRepository {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.MainRepository", m8638f = "MainRepository.kt", m8637i = {}, m8636l = {24}, m8635m = "clickArticle", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5558a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20230a;

        /* renamed from: c */
        int f20232c;

        C5558a(InterfaceC14268c<? super C5558a> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20230a = obj;
            this.f20232c |= Integer.MIN_VALUE;
            return MainRepository.this.m39004a(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.MainRepository", m8638f = "MainRepository.kt", m8637i = {}, m8636l = {20}, m8635m = "getBanner", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5559b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20233a;

        /* renamed from: c */
        int f20235c;

        C5559b(InterfaceC14268c<? super C5559b> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20233a = obj;
            this.f20235c |= Integer.MIN_VALUE;
            return MainRepository.this.m39003b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.MainRepository", m8638f = "MainRepository.kt", m8637i = {}, m8636l = {15}, m8635m = "getClassifyMenu", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5560c extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20236a;

        /* renamed from: c */
        int f20238c;

        C5560c(InterfaceC14268c<? super C5560c> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20236a = obj;
            this.f20238c |= Integer.MIN_VALUE;
            return MainRepository.this.m39002c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.MainRepository", m8638f = "MainRepository.kt", m8637i = {}, m8636l = {14}, m8635m = "getHomeMenu", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5561d extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20239a;

        /* renamed from: c */
        int f20241c;

        C5561d(InterfaceC14268c<? super C5561d> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20239a = obj;
            this.f20241c |= Integer.MIN_VALUE;
            return MainRepository.this.m39001d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.MainRepository", m8638f = "MainRepository.kt", m8637i = {}, m8636l = {22}, m8635m = "getLatestUnreadNotice", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5562e extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20242a;

        /* renamed from: c */
        int f20244c;

        C5562e(InterfaceC14268c<? super C5562e> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20242a = obj;
            this.f20244c |= Integer.MIN_VALUE;
            return MainRepository.this.m39000e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.MainRepository", m8638f = "MainRepository.kt", m8637i = {}, m8636l = {17}, m8635m = "getLoginUserInfo", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5563f extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20245a;

        /* renamed from: c */
        int f20247c;

        C5563f(InterfaceC14268c<? super C5563f> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20245a = obj;
            this.f20247c |= Integer.MIN_VALUE;
            return MainRepository.this.m38999f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.MainRepository", m8638f = "MainRepository.kt", m8637i = {}, m8636l = {23}, m8635m = "getMessageNoticeVoById", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5564g extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20248a;

        /* renamed from: c */
        int f20250c;

        C5564g(InterfaceC14268c<? super C5564g> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20248a = obj;
            this.f20250c |= Integer.MIN_VALUE;
            return MainRepository.this.m38998g(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.MainRepository", m8638f = "MainRepository.kt", m8637i = {}, m8636l = {16}, m8635m = "getMyMenu", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5565h extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20251a;

        /* renamed from: c */
        int f20253c;

        C5565h(InterfaceC14268c<? super C5565h> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20251a = obj;
            this.f20253c |= Integer.MIN_VALUE;
            return MainRepository.this.m38997h(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.MainRepository", m8638f = "MainRepository.kt", m8637i = {}, m8636l = {21}, m8635m = "isDefaultPass", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5566i extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20254a;

        /* renamed from: c */
        int f20256c;

        C5566i(InterfaceC14268c<? super C5566i> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20254a = obj;
            this.f20256c |= Integer.MIN_VALUE;
            return MainRepository.this.m38996i(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m39004a(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.bxkj.student.p094v2.repository.MainRepository.C5558a
            if (r0 == 0) goto L13
            r0 = r9
            com.bxkj.student.v2.repository.b$a r0 = (com.bxkj.student.p094v2.repository.MainRepository.C5558a) r0
            int r1 = r0.f20232c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20232c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$a r0 = new com.bxkj.student.v2.repository.b$a
            r0.<init>(r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.f20230a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r1 = r4.f20232c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.C14294d0.m8596n(r9)
            goto L48
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            kotlin.C14294d0.m8596n(r9)
            com.bxkj.student.v2.retrofit.b r9 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r1 = r9.m38888b()
            r3 = 0
            r5 = 2
            r6 = 0
            r4.f20232c = r2
            r2 = r8
            java.lang.Object r9 = com.bxkj.student.p094v2.retrofit.ApiService.C5592b.m38900c(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L48
            return r0
        L48:
            com.bxkj.base.v2.http.result.ApiResult r9 = (com.bxkj.base.p085v2.http.result.ApiResult) r9
            if (r9 != 0) goto L4e
            r8 = 0
            goto L52
        L4e:
            java.lang.Object r8 = r9.apiData()
        L52:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.MainRepository.m39004a(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m39003b(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.bxkj.student.p094v2.repository.MainRepository.C5559b
            if (r0 == 0) goto L13
            r0 = r9
            com.bxkj.student.v2.repository.b$b r0 = (com.bxkj.student.p094v2.repository.MainRepository.C5559b) r0
            int r1 = r0.f20235c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20235c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$b r0 = new com.bxkj.student.v2.repository.b$b
            r0.<init>(r9)
        L18:
            r5 = r0
            java.lang.Object r9 = r5.f20233a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r1 = r5.f20235c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.C14294d0.m8596n(r9)
            goto L4a
        L2a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L32:
            kotlin.C14294d0.m8596n(r9)
            com.bxkj.student.v2.retrofit.b r9 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r1 = r9.m38888b()
            r9 = 0
            r3 = 0
            r4 = 0
            r6 = 7
            r7 = 0
            r5.f20235c = r2
            r2 = r9
            java.lang.Object r9 = com.bxkj.student.p094v2.retrofit.ApiService.C5592b.m38899d(r1, r2, r3, r4, r5, r6, r7)
            if (r9 != r0) goto L4a
            return r0
        L4a:
            com.bxkj.base.v2.http.result.ApiResult r9 = (com.bxkj.base.p085v2.http.result.ApiResult) r9
            java.lang.Object r9 = r9.apiData()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.MainRepository.m39003b(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m39002c(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.bxkj.student.p094v2.repository.MainRepository.C5560c
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.b$c r0 = (com.bxkj.student.p094v2.repository.MainRepository.C5560c) r0
            int r1 = r0.f20238c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20238c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$c r0 = new com.bxkj.student.v2.repository.b$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20236a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20238c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.C14294d0.m8596n(r6)
            goto L44
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            kotlin.C14294d0.m8596n(r6)
            com.bxkj.student.v2.retrofit.b r6 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r6 = r6.m38888b()
            r0.f20238c = r4
            java.lang.Object r6 = com.bxkj.student.p094v2.retrofit.ApiService.C5592b.m38898e(r6, r3, r0, r4, r3)
            if (r6 != r1) goto L44
            return r1
        L44:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.p085v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            goto L50
        L49:
            java.lang.Object r6 = r6.apiData()
            r3 = r6
            java.util.List r3 = (java.util.List) r3
        L50:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.MainRepository.m39002c(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m39001d(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.p094v2.repository.MainRepository.C5561d
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.b$d r0 = (com.bxkj.student.p094v2.repository.MainRepository.C5561d) r0
            int r1 = r0.f20241c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20241c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$d r0 = new com.bxkj.student.v2.repository.b$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20239a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20241c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C14294d0.m8596n(r5)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.C14294d0.m8596n(r5)
            com.bxkj.student.v2.retrofit.b r5 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r5 = r5.m38888b()
            r0.f20241c = r3
            r2 = 0
            java.lang.Object r5 = com.bxkj.student.p094v2.retrofit.ApiService.C5592b.m38897f(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L44
            return r1
        L44:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.p085v2.http.result.ApiResult) r5
            java.lang.Object r5 = r5.apiData()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.MainRepository.m39001d(kotlin.coroutines.c):java.lang.Object");
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
    public final java.lang.Object m39000e(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.p094v2.repository.MainRepository.C5562e
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.b$e r0 = (com.bxkj.student.p094v2.repository.MainRepository.C5562e) r0
            int r1 = r0.f20244c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20244c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$e r0 = new com.bxkj.student.v2.repository.b$e
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20242a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20244c
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
            r0.f20244c = r3
            java.lang.Object r5 = r5.m38920k(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.MainRepository.m39000e(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38999f(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.p094v2.repository.MainRepository.C5563f
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.b$f r0 = (com.bxkj.student.p094v2.repository.MainRepository.C5563f) r0
            int r1 = r0.f20247c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20247c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$f r0 = new com.bxkj.student.v2.repository.b$f
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20245a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20247c
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
            r0.f20247c = r3
            java.lang.Object r5 = r5.m38922i(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.p085v2.http.result.ApiResult) r5
            java.lang.Object r5 = r5.apiData()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.MainRepository.m38999f(kotlin.coroutines.c):java.lang.Object");
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
    public final java.lang.Object m38998g(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<java.lang.Object> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.p094v2.repository.MainRepository.C5564g
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.b$g r0 = (com.bxkj.student.p094v2.repository.MainRepository.C5564g) r0
            int r1 = r0.f20250c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20250c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$g r0 = new com.bxkj.student.v2.repository.b$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20248a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20250c
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
            r0.f20250c = r3
            java.lang.Object r6 = r6.m38948D(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.p085v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            r5 = 0
            goto L4d
        L49:
            java.lang.Object r5 = r6.apiData()
        L4d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.MainRepository.m38998g(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38997h(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.p094v2.repository.MainRepository.C5565h
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.b$h r0 = (com.bxkj.student.p094v2.repository.MainRepository.C5565h) r0
            int r1 = r0.f20253c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20253c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$h r0 = new com.bxkj.student.v2.repository.b$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20251a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20253c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C14294d0.m8596n(r5)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.C14294d0.m8596n(r5)
            com.bxkj.student.v2.retrofit.b r5 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r5 = r5.m38888b()
            r0.f20253c = r3
            r2 = 0
            java.lang.Object r5 = com.bxkj.student.p094v2.retrofit.ApiService.C5592b.m38896g(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L44
            return r1
        L44:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.p085v2.http.result.ApiResult) r5
            java.lang.Object r5 = r5.apiData()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.MainRepository.m38997h(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38996i(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.p094v2.repository.MainRepository.C5566i
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.b$i r0 = (com.bxkj.student.p094v2.repository.MainRepository.C5566i) r0
            int r1 = r0.f20256c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20256c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$i r0 = new com.bxkj.student.v2.repository.b$i
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20254a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20256c
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
            r0.f20256c = r3
            java.lang.Object r5 = r5.m38921j(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.MainRepository.m38996i(kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: j */
    public final Object m38995j(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m38933S = RetrofitClient.f20337a.m38888b().m38933S(interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m38933S == m8642h ? m38933S : Unit.f41048a;
    }
}
