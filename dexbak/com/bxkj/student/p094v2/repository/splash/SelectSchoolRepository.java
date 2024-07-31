package com.bxkj.student.p094v2.repository.splash;

import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0006\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/splash/a;", "", "", "name", "", "", "a", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.repository.splash.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SelectSchoolRepository {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectSchoolRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.splash.SelectSchoolRepository", m8638f = "SelectSchoolRepository.kt", m8637i = {}, m8636l = {14}, m8635m = "searchSchool", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.splash.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5573a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20275a;

        /* renamed from: c */
        int f20277c;

        C5573a(InterfaceC14268c<? super C5573a> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20275a = obj;
            this.f20277c |= Integer.MIN_VALUE;
            return SelectSchoolRepository.this.m38987a(null, this);
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
    public final java.lang.Object m38987a(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.bxkj.student.p094v2.repository.splash.SelectSchoolRepository.C5573a
            if (r0 == 0) goto L13
            r0 = r6
            com.bxkj.student.v2.repository.splash.a$a r0 = (com.bxkj.student.p094v2.repository.splash.SelectSchoolRepository.C5573a) r0
            int r1 = r0.f20277c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20277c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.splash.a$a r0 = new com.bxkj.student.v2.repository.splash.a$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20275a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20277c
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
            r0.f20277c = r3
            java.lang.Object r6 = r6.m38944H(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.OldApiResult r6 = (com.bxkj.base.p085v2.http.result.OldApiResult) r6
            if (r6 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r6.apiData()
            java.util.List r5 = (java.util.List) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.splash.SelectSchoolRepository.m38987a(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
