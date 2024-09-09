package com.bxkj.student.v2.repository.face;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FaceDetectRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ=\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/bxkj/student/v2/repository/face/c;", "", "Lokhttp3/RequestBody;", "identify", "type", "file", "", "a", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "runType", "filePath", "", "exception", "Lkotlin/f1;", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c {

    /* compiled from: FaceDetectRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.face.FaceDetectRepository", f = "FaceDetectRepository.kt", i = {}, l = {20}, m = "faceDetect", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f23617a;

        /* renamed from: c */
        int f23619c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
            c.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23617a = obj;
            this.f23619c |= Integer.MIN_VALUE;
            return c.this.a(null, null, null, this);
        }
    }

    /* compiled from: FaceDetectRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.face.FaceDetectRepository", f = "FaceDetectRepository.kt", i = {}, l = {34}, m = "faceDetectV2", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f23620a;

        /* renamed from: c */
        int f23622c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
            c.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23620a = obj;
            this.f23622c |= Integer.MIN_VALUE;
            return c.this.b(null, null, null, null, 0, this);
        }
    }

    public static /* synthetic */ Object c(c cVar, String str, String str2, String str3, String str4, int i4, kotlin.coroutines.c cVar2, int i5, Object obj) {
        return cVar.b(str, str2, str3, str4, (i5 & 16) != 0 ? 0 : i4, cVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0049  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull okhttp3.RequestBody r5, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r6, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.lang.Boolean> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.bxkj.student.v2.repository.face.c.a
            if (r0 == 0) goto L13
            r0 = r8
            com.bxkj.student.v2.repository.face.c$a r0 = (com.bxkj.student.v2.repository.face.c.a) r0
            int r1 = r0.f23619c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23619c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.face.c$a r0 = new com.bxkj.student.v2.repository.face.c$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f23617a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23619c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r8)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.d0.n(r8)
            com.bxkj.student.v2.retrofit.c r8 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r8 = r8.b()
            r0.f23619c = r3
            java.lang.Object r8 = r8.c(r5, r6, r7, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r8 = (com.bxkj.base.v2.http.result.ApiResult) r8
            if (r8 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r8.apiData()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.face.c.a(okhttp3.RequestBody, okhttp3.RequestBody, okhttp3.RequestBody, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, int r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r12) {
        /*
            r6 = this;
            boolean r0 = r12 instanceof com.bxkj.student.v2.repository.face.c.b
            if (r0 == 0) goto L13
            r0 = r12
            com.bxkj.student.v2.repository.face.c$b r0 = (com.bxkj.student.v2.repository.face.c.b) r0
            int r1 = r0.f23622c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23622c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.face.c$b r0 = new com.bxkj.student.v2.repository.face.c$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f23620a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23622c
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.d0.n(r12)
            goto Laa
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.d0.n(r12)
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
            u.a r2 = u.a.f64412a
            java.util.Map r2 = r2.a()
            r12.putAll(r2)
            java.lang.String r2 = "identify"
            r12.put(r2, r7)
            java.lang.String r7 = "type"
            r12.put(r7, r8)
            java.lang.String r7 = "runType"
            r12.put(r7, r9)
            java.lang.String r7 = java.lang.String.valueOf(r11)
            java.lang.String r8 = "exception"
            r12.put(r8, r7)
            java.lang.String r7 = com.alibaba.fastjson.JSON.toJSONString(r12)
            com.orhanobut.logger.j.h(r7)
            java.lang.String[] r7 = u.b.b(r7)
            r8 = r7[r3]
            r9 = 2
            r7 = r7[r9]
            com.bxkj.student.v2.retrofit.c r9 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r9 = r9.b()
            okhttp3.RequestBody$Companion r11 = okhttp3.RequestBody.Companion
            okhttp3.MediaType$Companion r12 = okhttp3.MediaType.Companion
            java.lang.String r2 = "multipart/form-data"
            okhttp3.MediaType r4 = r12.parse(r2)
            java.lang.String r5 = "key"
            kotlin.jvm.internal.f0.o(r8, r5)
            okhttp3.RequestBody r8 = r11.create(r4, r8)
            okhttp3.MediaType r2 = r12.parse(r2)
            java.lang.String r4 = "data"
            kotlin.jvm.internal.f0.o(r7, r4)
            okhttp3.RequestBody r7 = r11.create(r2, r7)
            java.lang.String r2 = "image/png"
            okhttp3.MediaType r12 = r12.parse(r2)
            java.io.File r2 = new java.io.File
            r2.<init>(r10)
            okhttp3.RequestBody r10 = r11.create(r12, r2)
            r0.f23622c = r3
            java.lang.Object r12 = r9.M(r8, r7, r10, r0)
            if (r12 != r1) goto Laa
            return r1
        Laa:
            com.bxkj.base.v2.http.result.ApiResult r12 = (com.bxkj.base.v2.http.result.ApiResult) r12
            if (r12 != 0) goto Laf
            goto Lb5
        Laf:
            java.lang.Object r7 = r12.apiData()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
        Lb5:
            kotlin.f1 r7 = kotlin.f1.f55527a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.face.c.b(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.coroutines.c):java.lang.Object");
    }
}
