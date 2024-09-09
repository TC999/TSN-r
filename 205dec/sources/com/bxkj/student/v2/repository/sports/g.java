package com.bxkj.student.v2.repository.sports;

import com.alibaba.fastjson.JSON;
import com.bxkj.student.v2.common.data.CommitResult;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.orhanobut.logger.j;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SportsRepository.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=J\u008d\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\u009f\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J%\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u0004\u0018\u00010'2\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u0004\u0018\u00010'2\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010+J%\u0010-\u001a\u0004\u0018\u00010'2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010)J5\u00100\u001a\u0004\u0018\u00010'2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u00101J%\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u0001022\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010+J-\u00108\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u000205H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00109J+\u0010:\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u000205H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010;\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006>"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "", "", "sportType", "", "startTime", "endTime", "sportTime", "", "sportRange", "speed", "avgSpeed", "brand", "model", "system", "version", "appVersion", "latLngList", "stepNumbers", "isSequencePoint", "pointList", "okPointList", "isFaceStatus", "uploadType", "identify", "geofence", "limitSpeed", "limitStride", "limitStepFrequency", "gpsDistance", "Lcom/bxkj/student/v2/common/data/CommitResult;", "a", "(IJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "gitudeLatitude", "", "isOpenDevelopInStart", "isRunningOpenDevelop", "b", "(IJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/f1;", "j", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "i", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "c", "h", "isException", "isValid", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "Lc0/c;", "d", "Lokhttp3/RequestBody;", "remark", "file", "e", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsRepository", f = "SportsRepository.kt", i = {}, l = {185}, m = "passPointCamera", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23683a;

        /* renamed from: c  reason: collision with root package name */
        int f23685c;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23683a = obj;
            this.f23685c |= Integer.MIN_VALUE;
            return g.this.e(null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SportsRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.repository.sports.SportsRepository", f = "SportsRepository.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE}, m = "passPointCameraV2", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f23686a;

        /* renamed from: c  reason: collision with root package name */
        int f23688c;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f23686a = obj;
            this.f23688c |= Integer.MIN_VALUE;
            return g.this.f(null, null, null, this);
        }
    }

    @Nullable
    public final Object a(int i4, long j4, long j5, long j6, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable Integer num, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, @NotNull kotlin.coroutines.c<? super CommitResult<Object>> cVar) {
        return com.bxkj.student.v2.retrofit.c.f23705a.b().X(i4, j4, j5, j6, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, num, str15, str16, str17, str18, str19, str20, cVar);
    }

    @Nullable
    public final Object b(int i4, long j4, long j5, long j6, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable Integer num, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, boolean z3, @Nullable String str21, @NotNull kotlin.coroutines.c<? super CommitResult<Object>> cVar) {
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        boolean z6;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(u.a.f64412a.a());
        linkedHashMap.put("sportType", kotlin.coroutines.jvm.internal.a.f(i4));
        linkedHashMap.put("startTime", kotlin.coroutines.jvm.internal.a.g(j4));
        linkedHashMap.put("endTime", kotlin.coroutines.jvm.internal.a.g(j5));
        linkedHashMap.put("sportTime", kotlin.coroutines.jvm.internal.a.g(j6));
        linkedHashMap.put("sportRange", str);
        linkedHashMap.put("speed", str2);
        linkedHashMap.put("avgSpeed", str3);
        linkedHashMap.put("brand", str4);
        linkedHashMap.put("model", str5);
        linkedHashMap.put("system", str6);
        linkedHashMap.put("version", str7);
        linkedHashMap.put("appVersion", str8);
        linkedHashMap.put("stepNumbers", str10);
        linkedHashMap.put("isSequencePoint", str11);
        linkedHashMap.put("gitudeLatitude", str12);
        linkedHashMap.put("pointList", str9);
        linkedHashMap.put("okPointList", str13);
        linkedHashMap.put("isFaceStatus", str14);
        linkedHashMap.put("uploadType", num);
        linkedHashMap.put("identify", str15);
        linkedHashMap.put("geofence", str16);
        linkedHashMap.put("limitSpeed", str17);
        linkedHashMap.put("limitStride", str18);
        linkedHashMap.put("limitStepFrequency", str19);
        linkedHashMap.put("gpsDistance", str20);
        List<PointData> latLngList = JSON.parseArray(str12, PointData.class);
        f0.o(latLngList, "latLngList");
        boolean z7 = latLngList instanceof Collection;
        if (z7 && latLngList.isEmpty()) {
            i5 = 0;
        } else {
            i5 = 0;
            for (PointData pointData : latLngList) {
                if (pointData.getF() != null) {
                    Boolean f4 = pointData.getF();
                    f0.o(f4, "it.f");
                    if (f4.booleanValue()) {
                        z4 = true;
                        if (z4 && (i5 = i5 + 1) < 0) {
                            CollectionsKt__CollectionsKt.W();
                        }
                    }
                }
                z4 = false;
                if (z4) {
                    CollectionsKt__CollectionsKt.W();
                }
            }
        }
        if (z7 && latLngList.isEmpty()) {
            i6 = 0;
        } else {
            i6 = 0;
            for (PointData pointData2 : latLngList) {
                if (pointData2.getM() != null) {
                    Boolean m4 = pointData2.getM();
                    f0.o(m4, "it.m");
                    if (m4.booleanValue()) {
                        z5 = true;
                        if (z5 && (i6 = i6 + 1) < 0) {
                            CollectionsKt__CollectionsKt.W();
                        }
                    }
                }
                z5 = false;
                if (z5) {
                    CollectionsKt__CollectionsKt.W();
                }
            }
        }
        if (z7 && latLngList.isEmpty()) {
            i7 = 0;
        } else {
            i7 = 0;
            for (PointData pointData3 : latLngList) {
                if (pointData3.getH() != null) {
                    Boolean h4 = pointData3.getH();
                    f0.o(h4, "it.h");
                    if (h4.booleanValue()) {
                        z6 = true;
                        if (z6 && (i7 = i7 + 1) < 0) {
                            CollectionsKt__CollectionsKt.W();
                        }
                    }
                }
                z6 = false;
                if (z6) {
                    CollectionsKt__CollectionsKt.W();
                }
            }
        }
        int i8 = (z3 ? this : null) == null ? 0 : 1;
        if (str21 != null) {
            String str22 = str21.length() > 0 ? str21 : null;
            if (str22 != null) {
                i8 += Integer.parseInt(str22);
            }
        }
        linkedHashMap.put("d", kotlin.coroutines.jvm.internal.a.f(i8));
        linkedHashMap.put("f", kotlin.coroutines.jvm.internal.a.f(i5));
        linkedHashMap.put("m", kotlin.coroutines.jvm.internal.a.f(i6));
        linkedHashMap.put("h", kotlin.coroutines.jvm.internal.a.f(i7));
        String[] b4 = u.b.b(JSON.toJSONString(linkedHashMap));
        String str23 = b4[1];
        String str24 = b4[2];
        j.h(JSON.toJSONString(linkedHashMap));
        com.bxkj.student.v2.retrofit.a b5 = com.bxkj.student.v2.retrofit.c.f23705a.b();
        String encode = URLEncoder.encode(str23, "UTF-8");
        f0.o(encode, "encode(key, \"UTF-8\")");
        String encode2 = URLEncoder.encode(str24, "UTF-8");
        f0.o(encode2, "encode(data, \"UTF-8\")");
        return b5.R(encode, encode2, cVar);
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        Object deleteByIdentify = n4.deleteByIdentify(str, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return deleteByIdentify == h4 ? deleteByIdentify : f1.f55527a;
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar) {
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        return n4.getLocalRecordById(str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(@org.jetbrains.annotations.NotNull okhttp3.RequestBody r10, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r11, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.lang.Boolean> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.bxkj.student.v2.repository.sports.g.a
            if (r0 == 0) goto L13
            r0 = r13
            com.bxkj.student.v2.repository.sports.g$a r0 = (com.bxkj.student.v2.repository.sports.g.a) r0
            int r1 = r0.f23685c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23685c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.g$a r0 = new com.bxkj.student.v2.repository.sports.g$a
            r0.<init>(r13)
        L18:
            r6 = r0
            java.lang.Object r13 = r6.f23683a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
            int r1 = r6.f23685c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.d0.n(r13)
            goto L4b
        L2a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L32:
            kotlin.d0.n(r13)
            com.bxkj.student.v2.retrofit.c r13 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r1 = r13.b()
            r5 = 0
            r7 = 8
            r8 = 0
            r6.f23685c = r2
            r2 = r10
            r3 = r11
            r4 = r12
            java.lang.Object r13 = com.bxkj.student.v2.retrofit.a.b.o(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r13 != r0) goto L4b
            return r0
        L4b:
            com.bxkj.base.v2.http.result.ApiResult r13 = (com.bxkj.base.v2.http.result.ApiResult) r13
            if (r13 != 0) goto L51
            r10 = 0
            goto L57
        L51:
            java.lang.Object r10 = r13.apiData()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
        L57:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.g.e(okhttp3.RequestBody, okhttp3.RequestBody, okhttp3.RequestBody, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.bxkj.student.v2.repository.sports.g.b
            if (r0 == 0) goto L13
            r0 = r11
            com.bxkj.student.v2.repository.sports.g$b r0 = (com.bxkj.student.v2.repository.sports.g.b) r0
            int r1 = r0.f23688c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f23688c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.g$b r0 = new com.bxkj.student.v2.repository.sports.g$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f23686a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f23688c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.d0.n(r11)
            goto L90
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            kotlin.d0.n(r11)
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>()
            u.a r2 = u.a.f64412a
            java.util.Map r2 = r2.a()
            r11.putAll(r2)
            java.lang.String r2 = "identify"
            r11.put(r2, r8)
            java.lang.String r8 = "type"
            java.lang.String r2 = "4"
            r11.put(r8, r2)
            java.lang.String r8 = "remark"
            r11.put(r8, r9)
            java.lang.String r8 = com.alibaba.fastjson.JSON.toJSONString(r11)
            java.lang.String[] r8 = u.b.b(r8)
            r9 = r8[r3]
            r11 = 2
            r8 = r8[r11]
            com.bxkj.student.v2.retrofit.c r11 = com.bxkj.student.v2.retrofit.c.f23705a
            com.bxkj.student.v2.retrofit.a r11 = r11.b()
            okhttp3.RequestBody$Companion r2 = okhttp3.RequestBody.Companion
            java.lang.String r4 = "key"
            kotlin.jvm.internal.f0.o(r9, r4)
            okhttp3.MediaType$Companion r4 = okhttp3.MediaType.Companion
            java.lang.String r5 = "multipart/form-data"
            okhttp3.MediaType r6 = r4.parse(r5)
            okhttp3.RequestBody r9 = r2.create(r9, r6)
            java.lang.String r6 = "data"
            kotlin.jvm.internal.f0.o(r8, r6)
            okhttp3.MediaType r4 = r4.parse(r5)
            okhttp3.RequestBody r8 = r2.create(r8, r4)
            r0.f23688c = r3
            java.lang.Object r11 = r11.M(r9, r8, r10, r0)
            if (r11 != r1) goto L90
            return r1
        L90:
            com.bxkj.base.v2.http.result.ApiResult r11 = (com.bxkj.base.v2.http.result.ApiResult) r11
            if (r11 != 0) goto L95
            goto L9b
        L95:
            java.lang.Object r8 = r11.apiData()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
        L9b:
            kotlin.f1 r8 = kotlin.f1.f55527a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.repository.sports.g.f(java.lang.String, java.lang.String, okhttp3.RequestBody, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        Object k4 = n4.k(str, str2, str3, str4, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return k4 == h4 ? k4 : f1.f55527a;
    }

    @Nullable
    public final Object h(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        Object j4 = n4.j(str, str2, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return j4 == h4 ? j4 : f1.f55527a;
    }

    @Nullable
    public final Object i(@NotNull String str, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        Object l4 = n4.l(str, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return l4 == h4 ? l4 : f1.f55527a;
    }

    @Nullable
    public final Object j(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        com.bxkj.student.v2.common.db.dao.e n4 = AppDatabase.f23168a.a().n();
        if (n4 == null) {
            return null;
        }
        Object f4 = n4.f(str, str2, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return f4 == h4 ? f4 : f1.f55527a;
    }
}
