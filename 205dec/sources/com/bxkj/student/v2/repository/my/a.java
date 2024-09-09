package com.bxkj.student.v2.repository.my;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AboutUsRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/bxkj/student/v2/repository/my/a;", "", "", "", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: AboutUsRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.my.AboutUsRepository", f = "AboutUsRepository.kt", i = {}, l = {12}, m = "getPgyerAppVersion", n = {}, s = {})
    /* renamed from: com.bxkj.student.v2.repository.my.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0302a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23626a;

        /* renamed from: c  reason: collision with root package name */
        int f23628c;

        C0302a(c<? super C0302a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23626a = obj;
            this.f23628c |= Integer.MIN_VALUE;
            return a.this.a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.util.Map<java.lang.String, java.lang.Object>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.bxkj.student.v2.repository.my.a.C0302a
            if (r0 == 0) goto L13
            r0 = r8
            com.bxkj.student.v2.repository.my.a$a r0 = (com.bxkj.student.v2.repository.my.a.C0302a) r0
            int r1 = r0.f23628c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23628c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.my.a$a r0 = new com.bxkj.student.v2.repository.my.a$a
            r0.<init>(r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.f23626a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
            int r1 = r4.f23628c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.d0.n(r8)
            goto L49
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L32:
            kotlin.d0.n(r8)
            com.bxkj.student.v2.retrofit.c r8 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r1 = r8.b()
            r8 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r4.f23628c = r2
            r2 = r8
            java.lang.Object r8 = com.bxkj.student.v2.retrofit.a.b.j(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L49
            return r0
        L49:
            com.bxkj.base.v2.http.result.PgyerApiResult r8 = (com.bxkj.base.v2.http.result.PgyerApiResult) r8
            if (r8 != 0) goto L4f
            r8 = 0
            goto L55
        L4f:
            java.lang.Object r8 = r8.apiData()
            java.util.Map r8 = (java.util.Map) r8
        L55:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.my.a.a(kotlin.coroutines.c):java.lang.Object");
    }
}
