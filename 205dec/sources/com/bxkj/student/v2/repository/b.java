package com.bxkj.student.v2.repository;

import com.bxkj.student.v2.retrofit.a;
import com.bxkj.student.v2.vm.LoginViewModel;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: LoginRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0010J!\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ1\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/bxkj/student/v2/repository/b;", "", "", "", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "openId", "type", "d", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "c", "Lcom/bxkj/student/v2/vm/LoginViewModel;", "a", "Lcom/bxkj/student/v2/vm/LoginViewModel;", "()Lcom/bxkj/student/v2/vm/LoginViewModel;", "e", "(Lcom/bxkj/student/v2/vm/LoginViewModel;)V", "loginViewModel", "<init>", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private LoginViewModel f23556a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: LoginRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.LoginRepository", f = "LoginRepository.kt", i = {}, l = {24}, m = "loginThirdCheck", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23557a;

        /* renamed from: c  reason: collision with root package name */
        int f23559c;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23557a = obj;
            this.f23559c |= Integer.MIN_VALUE;
            return b.this.d(null, null, this);
        }
    }

    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {20}, m = "getBanner", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class C0298b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23560a;

        /* renamed from: c  reason: collision with root package name */
        int f23562c;

        C0298b(kotlin.coroutines.c<? super C0298b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23560a = obj;
            this.f23562c |= Integer.MIN_VALUE;
            return b.this.b(this);
        }
    }

    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {15}, m = "getClassifyMenu", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23563a;

        /* renamed from: c  reason: collision with root package name */
        int f23565c;

        c(kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23563a = obj;
            this.f23565c |= Integer.MIN_VALUE;
            return b.this.c(this);
        }
    }

    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {14}, m = "getHomeMenu", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23566a;

        /* renamed from: c  reason: collision with root package name */
        int f23568c;

        d(kotlin.coroutines.c<? super d> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23566a = obj;
            this.f23568c |= Integer.MIN_VALUE;
            return b.this.d(this);
        }
    }

    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {22}, m = "getLatestUnreadNotice", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23569a;

        /* renamed from: c  reason: collision with root package name */
        int f23571c;

        e(kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23569a = obj;
            this.f23571c |= Integer.MIN_VALUE;
            return b.this.e(this);
        }
    }

    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {17}, m = "getLoginUserInfo", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23572a;

        /* renamed from: c  reason: collision with root package name */
        int f23574c;

        f(kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23572a = obj;
            this.f23574c |= Integer.MIN_VALUE;
            return b.this.f(this);
        }
    }

    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {23}, m = "getMessageNoticeVoById", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23575a;

        /* renamed from: c  reason: collision with root package name */
        int f23577c;

        g(kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23575a = obj;
            this.f23577c |= Integer.MIN_VALUE;
            return b.this.g(null, this);
        }
    }

    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {16}, m = "getMyMenu", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class h extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23578a;

        /* renamed from: c  reason: collision with root package name */
        int f23580c;

        h(kotlin.coroutines.c<? super h> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23578a = obj;
            this.f23580c |= Integer.MIN_VALUE;
            return b.this.h(this);
        }
    }

    /* compiled from: MainRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.MainRepository", f = "MainRepository.kt", i = {}, l = {21}, m = "isDefaultPass", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class i extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23581a;

        /* renamed from: c  reason: collision with root package name */
        int f23583c;

        i(kotlin.coroutines.c<? super i> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23581a = obj;
            this.f23583c |= Integer.MIN_VALUE;
            return b.this.i(this);
        }
    }

    public b(@NotNull LoginViewModel loginViewModel) {
        f0.p(loginViewModel, "loginViewModel");
        this.f23556a = loginViewModel;
    }

    @NotNull
    public final LoginViewModel a() {
        return this.f23556a;
    }

    @Nullable
    public final Object b(@NotNull kotlin.coroutines.c<? super Map<String, ? extends Object>> cVar) {
        com.bxkj.student.v2.retrofit.a b4 = com.bxkj.student.v2.retrofit.c.f23705a.b();
        String str = a().z().get();
        String str2 = a().y().get();
        return a.b.m(b4, str, str2 == null ? null : URLEncoder.encode(com.bxkj.base.v2.common.utils.a.f18593a.c(str2), "UTF-8"), null, null, cVar, 12, null);
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.c<? super Map<String, ? extends Object>> cVar) {
        return a.b.n(com.bxkj.student.v2.retrofit.c.f23705a.b(), str, null, null, str2, cVar, 6, null);
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
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<java.lang.Object> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.bxkj.student.v2.repository.b.a
            if (r0 == 0) goto L13
            r0 = r7
            com.bxkj.student.v2.repository.b$a r0 = (com.bxkj.student.v2.repository.b.a) r0
            int r1 = r0.f23559c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23559c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.b$a r0 = new com.bxkj.student.v2.repository.b$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f23557a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23559c
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
            r0.f23559c = r3
            java.lang.Object r7 = r7.K(r5, r6, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r7 = (com.bxkj.base.v2.http.result.ApiResult) r7
            if (r7 != 0) goto L49
            r5 = 0
            goto L4d
        L49:
            java.lang.Object r5 = r7.apiData()
        L4d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.b.d(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public final void e(@NotNull LoginViewModel loginViewModel) {
        f0.p(loginViewModel, "<set-?>");
        this.f23556a = loginViewModel;
    }
}
