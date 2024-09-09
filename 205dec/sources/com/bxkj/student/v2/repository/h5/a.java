package com.bxkj.student.v2.repository.h5;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: H5AppRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/bxkj/student/v2/repository/h5/a;", "", "", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: H5AppRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.h5.H5AppRepository", f = "H5AppRepository.kt", i = {}, l = {11}, m = "getAppId", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.h5.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0301a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23623a;

        /* renamed from: c  reason: collision with root package name */
        int f23625c;

        C0301a(c<? super C0301a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23623a = obj;
            this.f23625c |= Integer.MIN_VALUE;
            return a.this.a(this);
        }
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
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.lang.String> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bxkj.student.v2.repository.h5.a.C0301a
            if (r0 == 0) goto L13
            r0 = r5
            com.bxkj.student.v2.repository.h5.a$a r0 = (com.bxkj.student.v2.repository.h5.a.C0301a) r0
            int r1 = r0.f23625c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23625c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.h5.a$a r0 = new com.bxkj.student.v2.repository.h5.a$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f23623a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23625c
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
            r0.f23625c = r3
            java.lang.Object r5 = r5.r(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r5 = (com.bxkj.base.v2.http.result.ApiResult) r5
            if (r5 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r5.apiData()
            java.lang.String r5 = (java.lang.String) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.h5.a.a(kotlin.coroutines.c):java.lang.Object");
    }
}
