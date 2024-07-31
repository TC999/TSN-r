package com.bxkj.student.p094v2.repository.face;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/face/c;", "", "Lokhttp3/RequestBody;", "identify", "type", IDataSource.f43973c, "", "a", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "runType", TTDownloadField.TT_FILE_PATH, "", "exception", "Lkotlin/f1;", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.repository.face.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class FaceDetectRepository {

    /* compiled from: FaceDetectRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.face.FaceDetectRepository", m8638f = "FaceDetectRepository.kt", m8637i = {}, m8636l = {20}, m8635m = "faceDetect", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.face.c$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5569a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20263a;

        /* renamed from: c */
        int f20265c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5569a(InterfaceC14268c<? super C5569a> interfaceC14268c) {
            super(interfaceC14268c);
            FaceDetectRepository.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20263a = obj;
            this.f20265c |= Integer.MIN_VALUE;
            return FaceDetectRepository.this.m38992a(null, null, null, this);
        }
    }

    /* compiled from: FaceDetectRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.face.FaceDetectRepository", m8638f = "FaceDetectRepository.kt", m8637i = {}, m8636l = {34}, m8635m = "faceDetectV2", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.face.c$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5570b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20266a;

        /* renamed from: c */
        int f20268c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5570b(InterfaceC14268c<? super C5570b> interfaceC14268c) {
            super(interfaceC14268c);
            FaceDetectRepository.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20266a = obj;
            this.f20268c |= Integer.MIN_VALUE;
            return FaceDetectRepository.this.m38991b(null, null, null, null, 0, this);
        }
    }

    /* renamed from: c */
    public static /* synthetic */ Object m38990c(FaceDetectRepository faceDetectRepository, String str, String str2, String str3, String str4, int i, InterfaceC14268c interfaceC14268c, int i2, Object obj) {
        return faceDetectRepository.m38991b(str, str2, str3, str4, (i2 & 16) != 0 ? 0 : i, interfaceC14268c);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0049  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38992a(@org.jetbrains.annotations.NotNull okhttp3.RequestBody r5, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r6, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.lang.Boolean> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.bxkj.student.p094v2.repository.face.FaceDetectRepository.C5569a
            if (r0 == 0) goto L13
            r0 = r8
            com.bxkj.student.v2.repository.face.c$a r0 = (com.bxkj.student.p094v2.repository.face.FaceDetectRepository.C5569a) r0
            int r1 = r0.f20265c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20265c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.face.c$a r0 = new com.bxkj.student.v2.repository.face.c$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f20263a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20265c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C14294d0.m8596n(r8)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.C14294d0.m8596n(r8)
            com.bxkj.student.v2.retrofit.b r8 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r8 = r8.m38888b()
            r0.f20265c = r3
            java.lang.Object r8 = r8.m38928c(r5, r6, r7, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            com.bxkj.base.v2.http.result.ApiResult r8 = (com.bxkj.base.p085v2.http.result.ApiResult) r8
            if (r8 != 0) goto L49
            r5 = 0
            goto L4f
        L49:
            java.lang.Object r5 = r8.apiData()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.face.FaceDetectRepository.m38992a(okhttp3.RequestBody, okhttp3.RequestBody, okhttp3.RequestBody, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38991b(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, int r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r12) {
        /*
            r6 = this;
            boolean r0 = r12 instanceof com.bxkj.student.p094v2.repository.face.FaceDetectRepository.C5570b
            if (r0 == 0) goto L13
            r0 = r12
            com.bxkj.student.v2.repository.face.c$b r0 = (com.bxkj.student.p094v2.repository.face.FaceDetectRepository.C5570b) r0
            int r1 = r0.f20268c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20268c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.face.c$b r0 = new com.bxkj.student.v2.repository.face.c$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f20266a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20268c
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.C14294d0.m8596n(r12)
            goto La9
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.C14294d0.m8596n(r12)
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
            u.a r2 = p647u.AppSecretInfo.f47135a
            java.util.Map r2 = r2.m247a()
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
            com.orhanobut.logger.C11792j.m20465h(r7)
            java.lang.String[] r7 = p647u.ClientEncrypt.m245b(r7)
            r8 = r7[r3]
            r9 = 2
            r7 = r7[r9]
            com.bxkj.student.v2.retrofit.b r9 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r9 = r9.m38888b()
            okhttp3.RequestBody$Companion r11 = okhttp3.RequestBody.Companion
            okhttp3.MediaType$Companion r12 = okhttp3.MediaType.Companion
            java.lang.String r2 = "multipart/form-data"
            okhttp3.MediaType r4 = r12.parse(r2)
            java.lang.String r5 = "key"
            kotlin.jvm.internal.C14342f0.m8185o(r8, r5)
            okhttp3.RequestBody r8 = r11.create(r4, r8)
            okhttp3.MediaType r2 = r12.parse(r2)
            java.lang.String r4 = "data"
            kotlin.jvm.internal.C14342f0.m8185o(r7, r4)
            okhttp3.RequestBody r7 = r11.create(r2, r7)
            java.lang.String r2 = "image/png"
            okhttp3.MediaType r12 = r12.parse(r2)
            java.io.File r2 = new java.io.File
            r2.<init>(r10)
            okhttp3.RequestBody r10 = r11.create(r12, r2)
            r0.f20268c = r3
            java.lang.Object r12 = r9.m38943I(r8, r7, r10, r0)
            if (r12 != r1) goto La9
            return r1
        La9:
            com.bxkj.base.v2.http.result.ApiResult r12 = (com.bxkj.base.p085v2.http.result.ApiResult) r12
            if (r12 != 0) goto Lae
            goto Lb4
        Lae:
            java.lang.Object r7 = r12.apiData()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
        Lb4:
            kotlin.f1 r7 = kotlin.Unit.f41048a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.face.FaceDetectRepository.m38991b(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.coroutines.c):java.lang.Object");
    }
}
