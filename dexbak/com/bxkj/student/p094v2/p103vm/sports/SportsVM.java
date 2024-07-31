package com.bxkj.student.p094v2.p103vm.sports;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.ext.ExceptionExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.p094v2.common.data.PointData;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.repository.face.FaceDetectRepository;
import com.bxkj.student.p094v2.repository.sports.RecordRepository;
import com.bxkj.student.p094v2.repository.sports.SportsRepository;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.C14294d0;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections._Collections;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsJVM;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.SportsDb;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: SportsVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106J`\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022:\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fJ$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fJ$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\n0\u0011J,\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\fJ,\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u0014\u0010\u001b\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fR0\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u00103¨\u00067"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "isValid", "isException", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msg", "id", "Lkotlin/f1;", "success", "Lkotlin/Function0;", CommonNetImpl.FAIL, IAdInterListener.AdReqParam.WIDTH, "F", "identify", "Lkotlin/Function1;", "Lc0/c;", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, ExifInterface.LONGITUDE_EAST, "remark", "Ljava/io/File;", "cameraFile", CommonNetImpl.RESULT, "C", "D", "x", "", "", "h", "Ljava/util/Map;", "B", "()Ljava/util/Map;", "G", "(Ljava/util/Map;)V", "sportsSetMap", "Lcom/bxkj/student/v2/repository/sports/b;", "i", "Lkotlin/o;", UMCommonContent.f37777aG, "()Lcom/bxkj/student/v2/repository/sports/b;", "recordRepository", "Lcom/bxkj/student/v2/repository/sports/g;", "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/bxkj/student/v2/repository/sports/g;", "sportsRepository", "Lcom/bxkj/student/v2/repository/face/c;", "k", "y", "()Lcom/bxkj/student/v2/repository/face/c;", "faceDetectRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.sports.SportsVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private Map<String, Object> f21118h = new LinkedHashMap();
    @NotNull

    /* renamed from: i */
    private final InterfaceC14378o f21119i;
    @NotNull

    /* renamed from: j */
    private final InterfaceC14378o f21120j;
    @NotNull

    /* renamed from: k */
    private final InterfaceC14378o f21121k;

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsVM$commitV3$1", m8638f = "SportsVM.kt", m8637i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 5}, m8636l = {60, 64, 68, 75, 80, 120}, m8635m = "invokeSuspend", m8634n = {"uploadType", "sportsType", "uploadType", "sportsType", "uploadType", "faceFile", "sportsType", "uploadType", "faceFile", "sportsType", "commitV3"}, m8633s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$4", "I$0", "L$0", "L$4", "I$0", "L$0"})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5887a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21122a;

        /* renamed from: b */
        Object f21123b;

        /* renamed from: c */
        Object f21124c;

        /* renamed from: d */
        Object f21125d;

        /* renamed from: e */
        Object f21126e;

        /* renamed from: f */
        Object f21127f;

        /* renamed from: g */
        int f21128g;

        /* renamed from: i */
        final /* synthetic */ String f21130i;

        /* renamed from: j */
        final /* synthetic */ long f21131j;

        /* renamed from: k */
        final /* synthetic */ long f21132k;

        /* renamed from: l */
        final /* synthetic */ long f21133l;

        /* renamed from: m */
        final /* synthetic */ List<Map<String, Object>> f21134m;

        /* renamed from: n */
        final /* synthetic */ InterfaceC15284p<String, String, Unit> f21135n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5887a(String str, long j, long j2, long j3, List<? extends Map<String, ? extends Object>> list, InterfaceC15284p<? super String, ? super String, Unit> interfaceC15284p, InterfaceC14268c<? super C5887a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21130i = str;
            this.f21131j = j;
            this.f21132k = j2;
            this.f21133l = j3;
            this.f21134m = list;
            this.f21135n = interfaceC15284p;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5887a(this.f21130i, this.f21131j, this.f21132k, this.f21133l, this.f21134m, this.f21135n, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5887a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00dc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0169 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01fa  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x02b7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x02cd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x02ce  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x02d1  */
        /* JADX WARN: Type inference failed for: r7v12, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0167 -> B:53:0x016a). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r42) {
            /*
                Method dump skipped, instructions count: 756
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.SportsVM.C5887a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsVM$commitV3$2", m8638f = "SportsVM.kt", m8637i = {0}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_WIFI}, m8635m = "invokeSuspend", m8634n = {"e"}, m8633s = {"L$0"})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5888b extends SuspendLambda implements InterfaceC15284p<Exception, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21136a;

        /* renamed from: b */
        /* synthetic */ Object f21137b;

        /* renamed from: d */
        final /* synthetic */ String f21139d;

        /* renamed from: e */
        final /* synthetic */ String f21140e;

        /* renamed from: f */
        final /* synthetic */ long f21141f;

        /* renamed from: g */
        final /* synthetic */ String f21142g;

        /* renamed from: h */
        final /* synthetic */ InterfaceC15269a<Unit> f21143h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5888b(String str, String str2, long j, String str3, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5888b> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f21139d = str;
            this.f21140e = str2;
            this.f21141f = j;
            this.f21142g = str3;
            this.f21143h = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5888b c5888b = new C5888b(this.f21139d, this.f21140e, this.f21141f, this.f21142g, this.f21143h, interfaceC14268c);
            c5888b.f21137b = obj;
            return c5888b;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5888b) create(exc, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            Exception exc;
            m8642h = C14287b.m8642h();
            int i = this.f21136a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                Exception exc2 = (Exception) this.f21137b;
                SportsRepository m38036A = SportsVM.this.m38036A();
                String str = this.f21139d;
                String str2 = this.f21140e;
                String valueOf = String.valueOf(this.f21141f);
                String str3 = this.f21142g;
                this.f21137b = exc2;
                this.f21136a = 1;
                if (m38036A.m38954g(str, str2, valueOf, str3, this) == m8642h) {
                    return m8642h;
                }
                exc = exc2;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                exc = (Exception) this.f21137b;
                C14294d0.m8596n(obj);
            }
            this.f21143h.invoke();
            C11792j.m20469d("离线跑步，保存跑步记录！", new Object[0]);
            return boxing.m8631a(ExceptionExt.m43845a(exc));
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsVM$deleteThisRecorder$1", m8638f = "SportsVM.kt", m8637i = {0, 1}, m8636l = {251, 252, 255}, m8635m = "invokeSuspend", m8634n = {"identify", "identify"}, m8633s = {"L$0", "L$0"})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5889c extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f21144a;

        /* renamed from: b */
        int f21145b;

        /* renamed from: d */
        final /* synthetic */ InterfaceC15269a<Unit> f21147d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5889c(InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5889c> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21147d = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5889c(this.f21147d, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5889c) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a7 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r6.f21145b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2e
                if (r1 == r4) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.C14294d0.m8596n(r7)
                goto La8
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.f21144a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.C14294d0.m8596n(r7)
                goto L62
            L26:
                java.lang.Object r1 = r6.f21144a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.C14294d0.m8596n(r7)
                goto L51
            L2e:
                kotlin.C14294d0.m8596n(r7)
                com.bxkj.base.v2.common.utils.l r7 = com.bxkj.base.p085v2.common.utils.JsonGet.f15134a
                com.bxkj.student.v2.common.data.b$g r1 = com.bxkj.student.p094v2.common.data.SportsDataAgent.f19899a
                java.util.Map r1 = r1.m39250v()
                java.lang.String r5 = "identify"
                java.lang.String r7 = r7.m43760t(r1, r5)
                com.bxkj.student.v2.vm.sports.SportsVM r1 = com.bxkj.student.p094v2.p103vm.sports.SportsVM.this
                com.bxkj.student.v2.repository.sports.g r1 = com.bxkj.student.p094v2.p103vm.sports.SportsVM.m38027v(r1)
                r6.f21144a = r7
                r6.f21145b = r4
                java.lang.Object r1 = r1.m38958c(r7, r6)
                if (r1 != r0) goto L50
                return r0
            L50:
                r1 = r7
            L51:
                com.bxkj.student.v2.vm.sports.SportsVM r7 = com.bxkj.student.p094v2.p103vm.sports.SportsVM.this
                com.bxkj.student.v2.repository.sports.b r7 = com.bxkj.student.p094v2.p103vm.sports.SportsVM.m38028u(r7)
                r6.f21144a = r1
                r6.f21145b = r3
                java.lang.Object r7 = r7.m38980b(r1, r6)
                if (r7 != r0) goto L62
                return r0
            L62:
                java.util.List r7 = (java.util.List) r7
                r3 = 0
                if (r7 != 0) goto L68
                goto L97
            L68:
                java.util.Iterator r7 = r7.iterator()
            L6c:
                boolean r4 = r7.hasNext()
                if (r4 == 0) goto L97
                java.lang.Object r4 = r7.next()
                c0.a r4 = (p027c0.FaceDb) r4
                if (r4 != 0) goto L7b
                goto L6c
            L7b:
                java.io.File r5 = new java.io.File
                java.lang.String r4 = r4.m58179g()
                r5.<init>(r4)
                boolean r4 = r5.exists()
                if (r4 == 0) goto L8b
                goto L8c
            L8b:
                r5 = r3
            L8c:
                if (r5 != 0) goto L8f
                goto L6c
            L8f:
                boolean r4 = r5.delete()
                kotlin.coroutines.jvm.internal.boxing.m8631a(r4)
                goto L6c
            L97:
                com.bxkj.student.v2.vm.sports.SportsVM r7 = com.bxkj.student.p094v2.p103vm.sports.SportsVM.this
                com.bxkj.student.v2.repository.sports.b r7 = com.bxkj.student.p094v2.p103vm.sports.SportsVM.m38028u(r7)
                r6.f21144a = r3
                r6.f21145b = r2
                java.lang.Object r7 = r7.m38981a(r1, r6)
                if (r7 != r0) goto La8
                return r0
            La8:
                l1.a<kotlin.f1> r7 = r6.f21147d
                r7.invoke()
                kotlin.f1 r7 = kotlin.Unit.f41048a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.SportsVM.C5889c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/face/c;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5890d extends Lambda implements InterfaceC15269a<FaceDetectRepository> {

        /* renamed from: a */
        public static final C5890d f21148a = new C5890d();

        C5890d() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final FaceDetectRepository invoke() {
            return new FaceDetectRepository();
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsVM$passPointCamera$1", m8638f = "SportsVM.kt", m8637i = {}, m8636l = {224}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5891e extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21149a;

        /* renamed from: c */
        final /* synthetic */ String f21151c;

        /* renamed from: d */
        final /* synthetic */ String f21152d;

        /* renamed from: e */
        final /* synthetic */ File f21153e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15269a<Unit> f21154f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5891e(String str, String str2, File file, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5891e> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21151c = str;
            this.f21152d = str2;
            this.f21153e = file;
            this.f21154f = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5891e(this.f21151c, this.f21152d, this.f21153e, this.f21154f, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5891e) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21149a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsRepository m38036A = SportsVM.this.m38036A();
                RequestBody.Companion companion = RequestBody.Companion;
                MediaType.Companion companion2 = MediaType.Companion;
                RequestBody create = companion.create(companion2.parse(HttpHeaders.Values.MULTIPART_FORM_DATA), this.f21151c);
                RequestBody create2 = companion.create(companion2.parse(HttpHeaders.Values.MULTIPART_FORM_DATA), this.f21152d);
                RequestBody create3 = companion.create(companion2.parse("image/png"), this.f21153e);
                this.f21149a = 1;
                if (m38036A.m38956e(create, create2, create3, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f21154f.invoke();
            return Unit.f41048a;
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsVM$passPointCameraV2$1", m8638f = "SportsVM.kt", m8637i = {}, m8636l = {GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5892f extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21155a;

        /* renamed from: c */
        final /* synthetic */ String f21157c;

        /* renamed from: d */
        final /* synthetic */ String f21158d;

        /* renamed from: e */
        final /* synthetic */ File f21159e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15269a<Unit> f21160f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5892f(String str, String str2, File file, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5892f> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21157c = str;
            this.f21158d = str2;
            this.f21159e = file;
            this.f21160f = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5892f(this.f21157c, this.f21158d, this.f21159e, this.f21160f, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5892f) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21155a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsRepository m38036A = SportsVM.this.m38036A();
                String str = this.f21157c;
                String str2 = this.f21158d;
                RequestBody create = RequestBody.Companion.create(MediaType.Companion.parse("image/png"), this.f21159e);
                this.f21155a = 1;
                if (m38036A.m38955f(str, str2, create, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f21160f.invoke();
            return Unit.f41048a;
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/b;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5893g extends Lambda implements InterfaceC15269a<RecordRepository> {

        /* renamed from: a */
        public static final C5893g f21161a = new C5893g();

        C5893g() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final RecordRepository invoke() {
            return new RecordRepository();
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeLocalData$1", m8638f = "SportsVM.kt", m8637i = {}, m8636l = {155}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5894h extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21162a;

        /* renamed from: c */
        final /* synthetic */ String f21164c;

        /* renamed from: d */
        final /* synthetic */ Ref.ObjectRef<SportsDb> f21165d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5894h(String str, Ref.ObjectRef<SportsDb> objectRef, InterfaceC14268c<? super C5894h> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21164c = str;
            this.f21165d = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5894h(this.f21164c, this.f21165d, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5894h) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Type inference failed for: r11v9, types: [T, java.lang.Object, c0.c] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            List m12218L5;
            boolean m6604K1;
            m8642h = C14287b.m8642h();
            int i = this.f21162a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsRepository m38036A = SportsVM.this.m38036A();
                String str = this.f21164c;
                this.f21162a = 1;
                obj = m38036A.m38957d(str, this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            List list = (List) obj;
            if (list != null) {
                if (!(!list.isEmpty())) {
                    list = null;
                }
                if (list != null) {
                    Ref.ObjectRef<SportsDb> objectRef = this.f21165d;
                    int i2 = 0;
                    ?? r11 = (SportsDb) list.get(0);
                    if (r11 != 0) {
                        objectRef.element = r11;
                        C11792j.m20469d(C14342f0.m8216C("从数据库恢复的数据", r11), new Object[0]);
                        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
                        c5481g.m39253s().clear();
                        List<Map<String, Object>> m39253s = c5481g.m39253s();
                        JsonGet jsonGet = JsonGet.f15134a;
                        m12218L5 = _Collections.m12218L5(jsonGet.m43754z(r11.m58123J()));
                        m39253s.addAll(m12218L5);
                        c5481g.m39265h0(Long.parseLong(r11.m58118O()));
                        c5481g.m39293N(Long.parseLong(r11.m58062z()));
                        c5481g.m39291P(Double.parseDouble(r11.m58132A()));
                        c5481g.m39279a0(Integer.parseInt(r11.m58112U()));
                        c5481g.m39286U(r11.m58127F().length() == 0 ? Utils.DOUBLE_EPSILON : Double.parseDouble(r11.m58127F()));
                        String m39636a = FormatUtils.m39636a(Double.parseDouble(r11.m58132A()), Long.parseLong(r11.m58062z()));
                        C14342f0.m8185o(m39636a, "calAvgSpeed(\n           …                        )");
                        c5481g.m39294M(m39636a);
                        c5481g.m39290Q(Double.parseDouble(r11.m58129D()));
                        String m58122K = r11.m58122K();
                        m6604K1 = StringsJVM.m6604K1(m58122K, "null", true);
                        if (!(!m6604K1)) {
                            m58122K = null;
                        }
                        if (m58122K != null) {
                            if (!(m58122K.length() > 0)) {
                                m58122K = null;
                            }
                            if (m58122K != null) {
                                Map<String, Object> m43782A = jsonGet.m43782A(m58122K);
                                c5481g.m39271e0(new LatLng(jsonGet.m43774f(m43782A, "latitude"), jsonGet.m43774f(m43782A, "longitude")));
                            }
                        }
                        String m39635b = FormatUtils.m39635b(Double.parseDouble(r11.m58132A()), Long.parseLong(r11.m58062z()));
                        C14342f0.m8185o(m39635b, "calPace(it.distance.toDo…), it.countTime.toLong())");
                        c5481g.m39275c0(m39635b);
                        c5481g.m39266h().setValue(boxing.m8626f(Integer.parseInt(r11.m58128E())));
                        c5481g.m39264i().setValue(boxing.m8631a(Boolean.parseBoolean(r11.m58113T())));
                        c5481g.m39295L();
                        List latLngList = JSON.parseArray(r11.m58125H(), PointData.class);
                        c5481g.m39256p().clear();
                        List<PointData> m39256p = c5481g.m39256p();
                        C14342f0.m8185o(latLngList, "latLngList");
                        m39256p.addAll(latLngList);
                        List list2 = latLngList.size() > 0 ? latLngList : null;
                        if (list2 != null) {
                            PointData pointData = (PointData) list2.get(list2.size() - 1);
                            if (pointData != null) {
                                pointData.setI(true);
                            }
                            LatLng latLng = new LatLng(((PointData) latLngList.get(0)).getA(), ((PointData) latLngList.get(0)).getO());
                            c5481g.m39267g0(latLng);
                            c5481g.m39297J(latLng);
                        }
                        List stepCountList = JSON.parseArray(r11.m58117P(), Integer.TYPE);
                        c5481g.m39246z().clear();
                        List<Integer> m39246z = c5481g.m39246z();
                        C14342f0.m8185o(stepCountList, "stepCountList");
                        m39246z.addAll(stepCountList);
                        List<Integer> list3 = stepCountList.size() > 0 ? stepCountList : null;
                        if (list3 != null) {
                            for (Integer step : list3) {
                                C14342f0.m8185o(step, "step");
                                i2 += step.intValue();
                            }
                            SportsDataAgent.C5481g c5481g2 = SportsDataAgent.f19899a;
                            c5481g2.m39263i0(i2);
                            c5481g2.m39296K(i2);
                        }
                    }
                }
            }
            return Unit.f41048a;
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsVM$resumeLocalData$2", m8638f = "SportsVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5895i extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21166a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<SportsDb, Unit> f21167b;

        /* renamed from: c */
        final /* synthetic */ Ref.ObjectRef<SportsDb> f21168c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5895i(InterfaceC15280l<? super SportsDb, Unit> interfaceC15280l, Ref.ObjectRef<SportsDb> objectRef, InterfaceC14268c<? super C5895i> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21167b = interfaceC15280l;
            this.f21168c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5895i(this.f21167b, this.f21168c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5895i) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f21166a == 0) {
                C14294d0.m8596n(obj);
                this.f21167b.invoke(this.f21168c.element);
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsVM$saveToLocal$1", m8638f = "SportsVM.kt", m8637i = {}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5896j extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21169a;

        /* renamed from: c */
        final /* synthetic */ String f21171c;

        /* renamed from: d */
        final /* synthetic */ String f21172d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC15269a<Unit> f21173e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5896j(String str, String str2, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5896j> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21171c = str;
            this.f21172d = str2;
            this.f21173e = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5896j(this.f21171c, this.f21172d, this.f21173e, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5896j) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21169a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                String m43760t = JsonGet.f15134a.m43760t(SportsVM.this.m38035B(), "identify");
                long currentTimeMillis = System.currentTimeMillis();
                SportsRepository m38036A = SportsVM.this.m38036A();
                String str = this.f21171c;
                String str2 = this.f21172d;
                String valueOf = String.valueOf(currentTimeMillis);
                this.f21169a = 1;
                if (m38036A.m38954g(str, str2, valueOf, m43760t, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f21173e.invoke();
            return Unit.f41048a;
        }
    }

    /* compiled from: SportsVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsVM$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5897k extends Lambda implements InterfaceC15269a<SportsRepository> {

        /* renamed from: a */
        public static final C5897k f21174a = new C5897k();

        C5897k() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final SportsRepository invoke() {
            return new SportsRepository();
        }
    }

    public SportsVM() {
        InterfaceC14378o m7719c;
        InterfaceC14378o m7719c2;
        InterfaceC14378o m7719c3;
        m7719c = C14389r.m7719c(C5893g.f21161a);
        this.f21119i = m7719c;
        m7719c2 = C14389r.m7719c(C5897k.f21174a);
        this.f21120j = m7719c2;
        m7719c3 = C14389r.m7719c(C5890d.f21148a);
        this.f21121k = m7719c3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public final SportsRepository m38036A() {
        return (SportsRepository) this.f21120j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public final FaceDetectRepository m38024y() {
        return (FaceDetectRepository) this.f21121k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public final RecordRepository m38023z() {
        return (RecordRepository) this.f21119i.getValue();
    }

    @NotNull
    /* renamed from: B */
    public final Map<String, Object> m38035B() {
        return this.f21118h;
    }

    /* renamed from: C */
    public final void m38034C(@NotNull String identify, @NotNull String remark, @NotNull File cameraFile, @NotNull InterfaceC15269a<Unit> result) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(remark, "remark");
        C14342f0.m8184p(cameraFile, "cameraFile");
        C14342f0.m8184p(result, "result");
        BaseViewModel.m43949j(this, new C5891e(identify, remark, cameraFile, result, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: D */
    public final void m38033D(@NotNull String identify, @NotNull String remark, @NotNull File cameraFile, @NotNull InterfaceC15269a<Unit> result) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(remark, "remark");
        C14342f0.m8184p(cameraFile, "cameraFile");
        C14342f0.m8184p(result, "result");
        BaseViewModel.m43949j(this, new C5892f(identify, remark, cameraFile, result, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: E */
    public final void m38032E(@NotNull String identify, @NotNull InterfaceC15280l<? super SportsDb, Unit> complete) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(complete, "complete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BaseViewModel.m43947l(this, new C5894h(identify, objectRef, null), null, null, null, new C5895i(complete, objectRef, null), null, 46, null);
    }

    /* renamed from: F */
    public final void m38031F(@NotNull String isValid, @NotNull String isException, @NotNull InterfaceC15269a<Unit> success) {
        C14342f0.m8184p(isValid, "isValid");
        C14342f0.m8184p(isException, "isException");
        C14342f0.m8184p(success, "success");
        BaseViewModel.m43947l(this, new C5896j(isException, isValid, success, null), null, null, null, null, null, 62, null);
    }

    /* renamed from: G */
    public final void m38030G(@NotNull Map<String, Object> map) {
        C14342f0.m8184p(map, "<set-?>");
        this.f21118h = map;
    }

    /* renamed from: w */
    public final void m38026w(@NotNull String isValid, @NotNull String isException, @NotNull InterfaceC15284p<? super String, ? super String, Unit> success, @NotNull InterfaceC15269a<Unit> fail) {
        C14342f0.m8184p(isValid, "isValid");
        C14342f0.m8184p(isException, "isException");
        C14342f0.m8184p(success, "success");
        C14342f0.m8184p(fail, "fail");
        JsonGet jsonGet = JsonGet.f15134a;
        Map<String, ? extends Object> map = this.f21118h;
        String uuid = UUID.randomUUID().toString();
        C14342f0.m8185o(uuid, "randomUUID().toString()");
        String m43759u = jsonGet.m43759u(map, "identify", uuid);
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        long m39248x = c5481g.m39248x();
        long currentTimeMillis = System.currentTimeMillis();
        long m39274d = c5481g.m39274d();
        List<Map<String, Object>> m43766n = jsonGet.m43766n(this.f21118h, "list");
        C11792j.m20469d(C14342f0.m8216C("sportsSetMap=", this.f21118h), new Object[0]);
        C11792j.m20469d("复核距离=" + ((Object) FormatUtils.m39634c(c5481g.m39270f())) + "\n轨迹距离=" + ((Object) FormatUtils.m39634c(c5481g.m39260l())), new Object[0]);
        BaseViewModel.m43949j(this, new C5887a(m43759u, m39248x, currentTimeMillis, m39274d, m43766n, success, null), null, new C5888b(isException, isValid, currentTimeMillis, m43759u, fail, null), null, null, null, null, null, 250, null);
    }

    /* renamed from: x */
    public final void m38025x(@NotNull InterfaceC15269a<Unit> success) {
        C14342f0.m8184p(success, "success");
        BaseViewModel.m43949j(this, new C5889c(success, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }
}
