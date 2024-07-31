package com.bxkj.student.p094v2.repository;

import com.bxkj.base.p085v2.common.utils.C3958a;
import com.bxkj.student.p094v2.p103vm.LoginViewModel;
import com.bxkj.student.p094v2.retrofit.ApiService;
import com.bxkj.student.p094v2.retrofit.RetrofitClient;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0010J!\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ1\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/a;", "", "", "", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "openId", "type", "d", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "c", "Lcom/bxkj/student/v2/vm/LoginViewModel;", "a", "Lcom/bxkj/student/v2/vm/LoginViewModel;", "()Lcom/bxkj/student/v2/vm/LoginViewModel;", "e", "(Lcom/bxkj/student/v2/vm/LoginViewModel;)V", "loginViewModel", "<init>", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.repository.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class LoginRepository {
    @NotNull

    /* renamed from: a */
    private LoginViewModel f20226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.LoginRepository", m8638f = "LoginRepository.kt", m8637i = {}, m8636l = {24}, m8635m = "loginThirdCheck", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5557a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20227a;

        /* renamed from: c */
        int f20229c;

        C5557a(InterfaceC14268c<? super C5557a> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20227a = obj;
            this.f20229c |= Integer.MIN_VALUE;
            return LoginRepository.this.m39006d(null, null, this);
        }
    }

    public LoginRepository(@NotNull LoginViewModel loginViewModel) {
        C14342f0.m8184p(loginViewModel, "loginViewModel");
        this.f20226a = loginViewModel;
    }

    @NotNull
    /* renamed from: a */
    public final LoginViewModel m39009a() {
        return this.f20226a;
    }

    @Nullable
    /* renamed from: b */
    public final Object m39008b(@NotNull InterfaceC14268c<? super Map<String, ? extends Object>> interfaceC14268c) {
        ApiService m38888b = RetrofitClient.f20337a.m38888b();
        String str = m39009a().m38191z().get();
        String str2 = m39009a().m38192y().get();
        return ApiService.C5592b.m38893j(m38888b, str, str2 == null ? null : URLEncoder.encode(C3958a.f15105a.m43813c(str2), "UTF-8"), null, null, interfaceC14268c, 12, null);
    }

    @Nullable
    /* renamed from: c */
    public final Object m39007c(@NotNull String str, @NotNull String str2, @NotNull InterfaceC14268c<? super Map<String, ? extends Object>> interfaceC14268c) {
        return ApiService.C5592b.m38892k(RetrofitClient.f20337a.m38888b(), str, null, null, str2, interfaceC14268c, 6, null);
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
    public final java.lang.Object m39006d(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<java.lang.Object> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.bxkj.student.p094v2.repository.LoginRepository.C5557a
            if (r0 == 0) goto L13
            r0 = r7
            com.bxkj.student.v2.repository.a$a r0 = (com.bxkj.student.p094v2.repository.LoginRepository.C5557a) r0
            int r1 = r0.f20229c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20229c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.a$a r0 = new com.bxkj.student.v2.repository.a$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20227a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20229c
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
            r0.f20229c = r3
            java.lang.Object r7 = r7.m38945G(r5, r6, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r7 = (com.bxkj.base.p085v2.http.result.ApiResult) r7
            if (r7 != 0) goto L49
            r5 = 0
            goto L4d
        L49:
            java.lang.Object r5 = r7.apiData()
        L4d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.LoginRepository.m39006d(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: e */
    public final void m39005e(@NotNull LoginViewModel loginViewModel) {
        C14342f0.m8184p(loginViewModel, "<set-?>");
        this.f20226a = loginViewModel;
    }
}
