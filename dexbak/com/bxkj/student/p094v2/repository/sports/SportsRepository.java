package com.bxkj.student.p094v2.repository.sports;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.bxkj.base.BaseApp;
import com.bxkj.student.common.utils.C4249g;
import com.bxkj.student.p094v2.common.data.CommitResult;
import com.bxkj.student.p094v2.common.data.PointData;
import com.bxkj.student.p094v2.common.p095db.AppDatabase;
import com.bxkj.student.p094v2.common.p095db.dao.SportsDao;
import com.bxkj.student.p094v2.retrofit.ApiService;
import com.bxkj.student.p094v2.retrofit.RetrofitClient;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.AnalyticsConfig;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.C14342f0;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.SportsDb;
import p647u.AppSecretInfo;
import p647u.ClientEncrypt;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;J\u008d\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u009f\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0018\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J%\u0010*\u001a\u0004\u0018\u00010'2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J5\u0010.\u001a\u0004\u0018\u00010'2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J%\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u0001002\u0006\u0010\u0018\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b2\u0010)J-\u00106\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0004\b6\u00107J+\u00108\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u000203H\u0086@ø\u0001\u0000¢\u0006\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "", "", "sportType", "", AnalyticsConfig.RTD_START_TIME, "endTime", "sportTime", "", "sportRange", "speed", "avgSpeed", C2624bk.f8686j, C2624bk.f8685i, ConstantHelper.LOG_OS, ConstantHelper.LOG_VS, "appVersion", "latLngList", "stepNumbers", "isSequencePoint", "pointList", "okPointList", "isFaceStatus", "uploadType", "identify", "geofence", "limitSpeed", "limitStride", "limitStepFrequency", "gpsDistance", "Lcom/bxkj/student/v2/common/data/CommitResult;", "a", "(IJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "gitudeLatitude", "", "isOpenDevelopInStart", "isRunningOpenDevelop", "b", "(IJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/f1;", "c", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "h", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "isException", "isValid", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "Lc0/c;", "d", "Lokhttp3/RequestBody;", "remark", IDataSource.f43973c, "e", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.repository.sports.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsRepository {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.SportsRepository", m8638f = "SportsRepository.kt", m8637i = {}, m8636l = {Opcodes.INVOKESTATIC}, m8635m = "passPointCamera", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5588a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20320a;

        /* renamed from: c */
        int f20322c;

        C5588a(InterfaceC14268c<? super C5588a> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20320a = obj;
            this.f20322c |= Integer.MIN_VALUE;
            return SportsRepository.this.m38956e(null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsRepository.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.repository.sports.SportsRepository", m8638f = "SportsRepository.kt", m8637i = {}, m8636l = {195}, m8635m = "passPointCameraV2", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.repository.sports.g$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5589b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f20323a;

        /* renamed from: c */
        int f20325c;

        C5589b(InterfaceC14268c<? super C5589b> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20323a = obj;
            this.f20325c |= Integer.MIN_VALUE;
            return SportsRepository.this.m38955f(null, null, null, this);
        }
    }

    @Nullable
    /* renamed from: a */
    public final Object m38960a(int i, long j, long j2, long j3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable Integer num, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, @NotNull InterfaceC14268c<? super CommitResult<Object>> interfaceC14268c) {
        return RetrofitClient.f20337a.m38888b().m38932T(i, j, j2, j3, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, num, str15, str16, str17, str18, str19, str20, interfaceC14268c);
    }

    @Nullable
    /* renamed from: b */
    public final Object m38959b(int i, long j, long j2, long j3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable Integer num, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, boolean z, @Nullable String str21, @NotNull InterfaceC14268c<? super CommitResult<Object>> interfaceC14268c) {
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(AppSecretInfo.f47135a.m247a());
        linkedHashMap.put("sportType", boxing.m8626f(i));
        linkedHashMap.put(AnalyticsConfig.RTD_START_TIME, boxing.m8625g(j));
        linkedHashMap.put("endTime", boxing.m8625g(j2));
        linkedHashMap.put("sportTime", boxing.m8625g(j3));
        linkedHashMap.put("sportRange", str);
        linkedHashMap.put("speed", str2);
        linkedHashMap.put("avgSpeed", str3);
        linkedHashMap.put(C2624bk.f8686j, str4);
        linkedHashMap.put(C2624bk.f8685i, str5);
        linkedHashMap.put(ConstantHelper.LOG_OS, str6);
        linkedHashMap.put(ConstantHelper.LOG_VS, str7);
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
        linkedHashMap.put("uniqueCode", C4249g.m42833a(BaseApp.m44341b()));
        List<PointData> latLngList = JSON.parseArray(str12, PointData.class);
        C14342f0.m8185o(latLngList, "latLngList");
        boolean z5 = latLngList instanceof Collection;
        if (z5 && latLngList.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 0;
            for (PointData pointData : latLngList) {
                if (pointData.getF() != null) {
                    Boolean f = pointData.getF();
                    C14342f0.m8185o(f, "it.f");
                    if (f.booleanValue()) {
                        z2 = true;
                        if (z2 && (i2 = i2 + 1) < 0) {
                            CollectionsKt__CollectionsKt.m12461V();
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    CollectionsKt__CollectionsKt.m12461V();
                }
            }
        }
        if (z5 && latLngList.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 0;
            for (PointData pointData2 : latLngList) {
                if (pointData2.getM() != null) {
                    Boolean m = pointData2.getM();
                    C14342f0.m8185o(m, "it.m");
                    if (m.booleanValue()) {
                        z3 = true;
                        if (z3 && (i3 = i3 + 1) < 0) {
                            CollectionsKt__CollectionsKt.m12461V();
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    CollectionsKt__CollectionsKt.m12461V();
                }
            }
        }
        if (z5 && latLngList.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 0;
            for (PointData pointData3 : latLngList) {
                if (pointData3.getH() != null) {
                    Boolean h = pointData3.getH();
                    C14342f0.m8185o(h, "it.h");
                    if (h.booleanValue()) {
                        z4 = true;
                        if (z4 && (i4 = i4 + 1) < 0) {
                            CollectionsKt__CollectionsKt.m12461V();
                        }
                    }
                }
                z4 = false;
                if (z4) {
                    CollectionsKt__CollectionsKt.m12461V();
                }
            }
        }
        if ((z ? this : null) == null) {
            i5 = 0;
        } else {
            Unit unit = Unit.f41048a;
            i5 = 1;
        }
        if (str21 != null) {
            String str22 = str21.length() > 0 ? str21 : null;
            if (str22 != null) {
                i5 += Integer.parseInt(str22);
                Unit unit2 = Unit.f41048a;
            }
        }
        linkedHashMap.put("d", boxing.m8626f(i5));
        linkedHashMap.put("f", boxing.m8626f(i2));
        linkedHashMap.put("m", boxing.m8626f(i3));
        linkedHashMap.put("h", boxing.m8626f(i4));
        String[] m245b = ClientEncrypt.m245b(JSON.toJSONString(linkedHashMap));
        String str23 = m245b[1];
        String str24 = m245b[2];
        C11792j.m20465h(JSON.toJSONString(linkedHashMap));
        ApiService m38888b = RetrofitClient.f20337a.m38888b();
        String encode = URLEncoder.encode(str23, "UTF-8");
        C14342f0.m8185o(encode, "encode(key, \"UTF-8\")");
        String encode2 = URLEncoder.encode(str24, "UTF-8");
        C14342f0.m8185o(encode2, "encode(data, \"UTF-8\")");
        return m38888b.m38938N(encode, encode2, interfaceC14268c);
    }

    @Nullable
    /* renamed from: c */
    public final Object m38958c(@NotNull String str, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        Object deleteByIdentify = mo39225l.deleteByIdentify(str, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return deleteByIdentify == m8642h ? deleteByIdentify : Unit.f41048a;
    }

    @Nullable
    /* renamed from: d */
    public final Object m38957d(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c) {
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        return mo39225l.getLocalRecordById(str, interfaceC14268c);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38956e(@org.jetbrains.annotations.NotNull okhttp3.RequestBody r10, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r11, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.lang.Boolean> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.bxkj.student.p094v2.repository.sports.SportsRepository.C5588a
            if (r0 == 0) goto L13
            r0 = r13
            com.bxkj.student.v2.repository.sports.g$a r0 = (com.bxkj.student.p094v2.repository.sports.SportsRepository.C5588a) r0
            int r1 = r0.f20322c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20322c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.g$a r0 = new com.bxkj.student.v2.repository.sports.g$a
            r0.<init>(r13)
        L18:
            r6 = r0
            java.lang.Object r13 = r6.f20320a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r1 = r6.f20322c
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.C14294d0.m8596n(r13)
            goto L4b
        L2a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L32:
            kotlin.C14294d0.m8596n(r13)
            com.bxkj.student.v2.retrofit.b r13 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r1 = r13.m38888b()
            r5 = 0
            r7 = 8
            r8 = 0
            r6.f20322c = r2
            r2 = r10
            r3 = r11
            r4 = r12
            java.lang.Object r13 = com.bxkj.student.p094v2.retrofit.ApiService.C5592b.m38891l(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r13 != r0) goto L4b
            return r0
        L4b:
            com.bxkj.base.v2.http.result.ApiResult r13 = (com.bxkj.base.p085v2.http.result.ApiResult) r13
            if (r13 != 0) goto L51
            r10 = 0
            goto L57
        L51:
            java.lang.Object r10 = r13.apiData()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
        L57:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.SportsRepository.m38956e(okhttp3.RequestBody, okhttp3.RequestBody, okhttp3.RequestBody, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38955f(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull okhttp3.RequestBody r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.bxkj.student.p094v2.repository.sports.SportsRepository.C5589b
            if (r0 == 0) goto L13
            r0 = r11
            com.bxkj.student.v2.repository.sports.g$b r0 = (com.bxkj.student.p094v2.repository.sports.SportsRepository.C5589b) r0
            int r1 = r0.f20325c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20325c = r1
            goto L18
        L13:
            com.bxkj.student.v2.repository.sports.g$b r0 = new com.bxkj.student.v2.repository.sports.g$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f20323a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f20325c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C14294d0.m8596n(r11)
            goto L8f
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            kotlin.C14294d0.m8596n(r11)
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>()
            u.a r2 = p647u.AppSecretInfo.f47135a
            java.util.Map r2 = r2.m247a()
            r11.putAll(r2)
            java.lang.String r2 = "identify"
            r11.put(r2, r8)
            java.lang.String r8 = "type"
            java.lang.String r2 = "4"
            r11.put(r8, r2)
            java.lang.String r8 = "remark"
            r11.put(r8, r9)
            java.lang.String r8 = com.alibaba.fastjson.JSON.toJSONString(r11)
            java.lang.String[] r8 = p647u.ClientEncrypt.m245b(r8)
            r9 = r8[r3]
            r11 = 2
            r8 = r8[r11]
            com.bxkj.student.v2.retrofit.b r11 = com.bxkj.student.p094v2.retrofit.RetrofitClient.f20337a
            com.bxkj.student.v2.retrofit.a r11 = r11.m38888b()
            okhttp3.RequestBody$Companion r2 = okhttp3.RequestBody.Companion
            java.lang.String r4 = "key"
            kotlin.jvm.internal.C14342f0.m8185o(r9, r4)
            okhttp3.MediaType$Companion r4 = okhttp3.MediaType.Companion
            java.lang.String r5 = "multipart/form-data"
            okhttp3.MediaType r6 = r4.parse(r5)
            okhttp3.RequestBody r9 = r2.create(r9, r6)
            java.lang.String r6 = "data"
            kotlin.jvm.internal.C14342f0.m8185o(r8, r6)
            okhttp3.MediaType r4 = r4.parse(r5)
            okhttp3.RequestBody r8 = r2.create(r8, r4)
            r0.f20325c = r3
            java.lang.Object r11 = r11.m38943I(r9, r8, r10, r0)
            if (r11 != r1) goto L8f
            return r1
        L8f:
            com.bxkj.base.v2.http.result.ApiResult r11 = (com.bxkj.base.p085v2.http.result.ApiResult) r11
            if (r11 != 0) goto L94
            goto L9a
        L94:
            java.lang.Object r8 = r11.apiData()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
        L9a:
            kotlin.f1 r8 = kotlin.Unit.f41048a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.repository.sports.SportsRepository.m38955f(java.lang.String, java.lang.String, okhttp3.RequestBody, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: g */
    public final Object m38954g(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        Object mo39173j = mo39225l.mo39173j(str, str2, str3, str4, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo39173j == m8642h ? mo39173j : Unit.f41048a;
    }

    @Nullable
    /* renamed from: h */
    public final Object m38953h(@NotNull String str, @NotNull String str2, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
        if (mo39225l == null) {
            return null;
        }
        Object mo39174i = mo39225l.mo39174i(str, str2, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo39174i == m8642h ? mo39174i : Unit.f41048a;
    }
}
