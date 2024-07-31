package com.bxkj.student.p094v2.repository.p097my;

import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/my/a;", "", "", "", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.repository.my.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AboutUsRepository {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AboutUsRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.my.AboutUsRepository", m8638f = "AboutUsRepository.kt", m8637i = {}, m8636l = {12}, m8635m = "getPgyerAppVersion", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.my.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5572a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20272a;

        /* renamed from: c */
        int f20274c;

        C5572a(InterfaceC14268c<? super C5572a> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20272a = obj;
            this.f20274c |= Integer.MIN_VALUE;
            return AboutUsRepository.this.m38988a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38988a(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.util.Map<java.lang.String, java.lang.Object>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.bxkj.student.p094v2.repository.p097my.AboutUsRepository.C5572a
            if (r0 == 0) goto L13
            r0 = r8
            com.bxkj.student.v2.repository.my.a$a r0 = (com.bxkj.student.p094v2.repository.p097my.AboutUsRepository.C5572a) r0
            int r1 = r0.f20274c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20274c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.my.a$a r0 = new com.bxkj.student.v2.repository.my.a$a
            r0.<init>(r8)
        L18:
            r4 = r0
            java.lang.Object r8 = r4.f20272a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r1 = r4.f20274c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.C14294d0.m8596n(r8)
            goto L49
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L32:
            kotlin.C14294d0.m8596n(r8)
            com.bxkj.student.v2.retrofit.b r8 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r1 = r8.m38888b()
            r8 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r4.f20274c = r2
            r2 = r8
            java.lang.Object r8 = com.bxkj.student.p094v2.retrofit.ApiService.C5592b.m38895h(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L49
            return r0
        L49:
            t.a r8 = (p644t.PgyerApiResult) r8
            if (r8 != 0) goto L4f
            r8 = 0
            goto L55
        L4f:
            java.lang.Object r8 = r8.m316a()
            java.util.Map r8 = (java.util.Map) r8
        L55:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.p097my.AboutUsRepository.m38988a(kotlin.coroutines.c):java.lang.Object");
    }
}
