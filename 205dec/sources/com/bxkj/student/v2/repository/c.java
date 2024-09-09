package com.bxkj.student.v2.repository;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MainRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u0007\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0018\u00010\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\u0005J)\u0010\b\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0018\u00010\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0005J#\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\u0005J)\u0010\f\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0018\u00010\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u0005J#\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u0005J#\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0005J\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/bxkj/student/v2/repository/c;", "", "", "", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "c", "h", "f", "Lkotlin/f1;", "j", "b", "i", "", "e", "id", "g", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {24}, m = "clickArticle", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23584a;

        /* renamed from: c  reason: collision with root package name */
        int f23586c;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23584a = obj;
            this.f23586c |= Integer.MIN_VALUE;
            return c.this.a(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {20}, m = "getBanner", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23587a;

        /* renamed from: c  reason: collision with root package name */
        int f23589c;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23587a = obj;
            this.f23589c |= Integer.MIN_VALUE;
            return c.this.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {15}, m = "getClassifyMenu", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0299c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23590a;

        /* renamed from: c  reason: collision with root package name */
        int f23592c;

        C0299c(kotlin.coroutines.c<? super C0299c> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23590a = obj;
            this.f23592c |= Integer.MIN_VALUE;
            return c.this.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {14}, m = "getHomeMenu", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23593a;

        /* renamed from: c  reason: collision with root package name */
        int f23595c;

        d(kotlin.coroutines.c<? super d> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23593a = obj;
            this.f23595c |= Integer.MIN_VALUE;
            return c.this.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {22}, m = "getLatestUnreadNotice", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23596a;

        /* renamed from: c  reason: collision with root package name */
        int f23598c;

        e(kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23596a = obj;
            this.f23598c |= Integer.MIN_VALUE;
            return c.this.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {17}, m = "getLoginUserInfo", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23599a;

        /* renamed from: c  reason: collision with root package name */
        int f23601c;

        f(kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23599a = obj;
            this.f23601c |= Integer.MIN_VALUE;
            return c.this.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {23}, m = "getMessageNoticeVoById", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23602a;

        /* renamed from: c  reason: collision with root package name */
        int f23604c;

        g(kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23602a = obj;
            this.f23604c |= Integer.MIN_VALUE;
            return c.this.g(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {16}, m = "getMyMenu", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class h extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23605a;

        /* renamed from: c  reason: collision with root package name */
        int f23607c;

        h(kotlin.coroutines.c<? super h> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23605a = obj;
            this.f23607c |= Integer.MIN_VALUE;
            return c.this.h(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {21}, m = "isDefaultPass", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class i extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23608a;

        /* renamed from: c  reason: collision with root package name */
        int f23610c;

        i(kotlin.coroutines.c<? super i> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23608a = obj;
            this.f23610c |= Integer.MIN_VALUE;
            return c.this.i(this);
        }
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
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.bxkj.student.v2.repository.c.a
            if (r0 == 0) goto L13
            r0 = r9
            com.bxkj.student.v2.repository.c$a r0 = (com.bxkj.student.v2.repository.c.a) r0
            int r1 = r0.f23586c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23586c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.c$a r0 = new com.bxkj.student.v2.repository.c$a
            r0.<init>(r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.f23584a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
            int r1 = r4.f23586c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.d0.n(r9)
            goto L48
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            kotlin.d0.n(r9)
            com.bxkj.student.v2.retrofit.c r9 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r1 = r9.b()
            r3 = 0
            r5 = 2
            r6 = 0
            r4.f23586c = r2
            r2 = r8
            java.lang.Object r9 = com.bxkj.student.v2.retrofit.a.b.c(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L48
            return r0
        L48:
            com.bxkj.base.v2.http.result.ApiResult r9 = (com.bxkj.base.v2.http.result.ApiResult) r9
            if (r9 != 0) goto L4e
            r8 = 0
            goto L52
        L4e:
            java.lang.Object r8 = r9.apiData()
        L52:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.c.a(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.bxkj.student.v2.repository.c.b
            if (r0 == 0) goto L13
            r0 = r9
            com.bxkj.student.v2.repository.c$b r0 = (com.bxkj.student.v2.repository.c.b) r0
            int r1 = r0.f23589c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23589c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.c$b r0 = new com.bxkj.student.v2.repository.c$b
            r0.<init>(r9)
        L18:
            r5 = r0
            java.lang.Object r9 = r5.f23587a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
            int r1 = r5.f23589c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.d0.n(r9)
            goto L4a
        L2a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L32:
            kotlin.d0.n(r9)
            com.bxkj.student.v2.retrofit.c r9 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r1 = r9.b()
            r9 = 0
            r3 = 0
            r4 = 0
            r6 = 7
            r7 = 0
            r5.f23589c = r2
            r2 = r9
            java.lang.Object r9 = com.bxkj.student.v2.retrofit.a.b.e(r1, r2, r3, r4, r5, r6, r7)
            if (r9 != r0) goto L4a
            return r0
        L4a:
            com.bxkj.base.v2.http.result.ApiResult r9 = (com.bxkj.base.v2.http.result.ApiResult) r9
            java.lang.Object r9 = r9.apiData()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.c.b(kotlin.coroutines.c):java.lang.Object");
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
    public final java.lang.Object c(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.c.C0299c
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.c$c r0 = (com.bxkj.student.v2.repository.c.C0299c) r0
            int r1 = r0.f23592c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23592c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.c$c r0 = new com.bxkj.student.v2.repository.c$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f23590a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23592c
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
            r0.f23592c = r4
            java.lang.Object r6 = com.bxkj.student.v2.retrofit.a.b.f(r6, r3, r0, r4, r3)
            if (r6 != r1) goto L44
            return r1
        L44:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            goto L50
        L49:
            java.lang.Object r6 = r6.apiData()
            r3 = r6
            java.util.List r3 = (java.util.List) r3
        L50:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.c.c(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.c.d
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.c$d r0 = (com.bxkj.student.v2.repository.c.d) r0
            int r1 = r0.f23595c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23595c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.c$d r0 = new com.bxkj.student.v2.repository.c$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23593a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23595c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r5)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.d0.n(r5)
            com.bxkj.student.v2.retrofit.c r5 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r5 = r5.b()
            r0.f23595c = r3
            r2 = 0
            java.lang.Object r5 = com.bxkj.student.v2.retrofit.a.b.h(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L44
            return r1
        L44:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.v2.http.result.ApiResult) r5
            java.lang.Object r5 = r5.apiData()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.c.d(kotlin.coroutines.c):java.lang.Object");
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
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.c.e
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.c$e r0 = (com.bxkj.student.v2.repository.c.e) r0
            int r1 = r0.f23598c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23598c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.c$e r0 = new com.bxkj.student.v2.repository.c$e
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23596a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23598c
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
            r0.f23598c = r3
            java.lang.Object r5 = r5.n(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.c.e(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.c.f
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.c$f r0 = (com.bxkj.student.v2.repository.c.f) r0
            int r1 = r0.f23601c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23601c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.c$f r0 = new com.bxkj.student.v2.repository.c$f
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23599a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23601c
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
            r0.f23601c = r3
            java.lang.Object r5 = r5.k(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.v2.http.result.ApiResult) r5
            java.lang.Object r5 = r5.apiData()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.c.f(kotlin.coroutines.c):java.lang.Object");
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
    public final java.lang.Object g(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<java.lang.Object> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.v2.repository.c.g
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.c$g r0 = (com.bxkj.student.v2.repository.c.g) r0
            int r1 = r0.f23604c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23604c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.c$g r0 = new com.bxkj.student.v2.repository.c$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f23602a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23604c
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
            r0.f23604c = r3
            java.lang.Object r6 = r6.H(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r6 = (com.bxkj.base.v2.http.result.ApiResult) r6
            if (r6 != 0) goto L49
            r5 = 0
            goto L4d
        L49:
            java.lang.Object r5 = r6.apiData()
        L4d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.c.g(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.c.h
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.c$h r0 = (com.bxkj.student.v2.repository.c.h) r0
            int r1 = r0.f23607c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23607c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.c$h r0 = new com.bxkj.student.v2.repository.c$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23605a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23607c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r5)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.d0.n(r5)
            com.bxkj.student.v2.retrofit.c r5 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r5 = r5.b()
            r0.f23607c = r3
            r2 = 0
            java.lang.Object r5 = com.bxkj.student.v2.retrofit.a.b.i(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L44
            return r1
        L44:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.v2.http.result.ApiResult) r5
            java.lang.Object r5 = r5.apiData()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.c.h(kotlin.coroutines.c):java.lang.Object");
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
    public final java.lang.Object i(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.c.i
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.c$i r0 = (com.bxkj.student.v2.repository.c.i) r0
            int r1 = r0.f23610c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23610c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.c$i r0 = new com.bxkj.student.v2.repository.c$i
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23608a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23610c
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
            r0.f23610c = r3
            java.lang.Object r5 = r5.m(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.c.i(kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    public final Object j(@NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object W = com.bxkj.student.v2.retrofit.c.f23705a.b().W(cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return W == h4 ? W : f1.f55527a;
    }
}
