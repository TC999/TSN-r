package com.bxkj.student.p094v2.p103vm.sports.appeal;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.http.RequestParameter;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.student.p094v2.repository.face.FaceDetectRepository;
import com.bxkj.student.p094v2.repository.sports.RecordRepository;
import com.bxkj.student.p094v2.repository.sports.SportsAppealRepository;
import com.bxkj.student.p094v2.repository.sports.SportsRepository;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.C14294d0;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: AppealVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102J.\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002JA\u0010\u0013\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rJ2\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010/¨\u00063"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/sports/appeal/AppealVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", DomainCampaignEx.LOOPBACK_KEY, "", "Ljava/io/File;", "files", "", "Lokhttp3/RequestBody;", "B", MediationConstant.KEY_REASON, "", "paths", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "msg", "Lkotlin/f1;", "callBack", "x", "exerciseRecordId", "Lkotlin/Function0;", "y", "h", "Ljava/lang/String;", UMCommonContent.f37777aG, "()Ljava/lang/String;", "F", "(Ljava/lang/String;)V", "i", "C", "G", "identify", "Lcom/bxkj/student/v2/repository/sports/b;", "j", "Lkotlin/o;", "D", "()Lcom/bxkj/student/v2/repository/sports/b;", "recordRepository", "Lcom/bxkj/student/v2/repository/sports/g;", "k", ExifInterface.LONGITUDE_EAST, "()Lcom/bxkj/student/v2/repository/sports/g;", "sportsRepository", "Lcom/bxkj/student/v2/repository/face/c;", C7304t.f25048d, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/bxkj/student/v2/repository/face/c;", "faceDetectRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.sports.appeal.AppealVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AppealVM extends BaseViewModel {
    @Nullable

    /* renamed from: h */
    private String f21175h;
    @Nullable

    /* renamed from: i */
    private String f21176i;
    @NotNull

    /* renamed from: j */
    private final InterfaceC14378o f21177j;
    @NotNull

    /* renamed from: k */
    private final InterfaceC14378o f21178k;
    @NotNull

    /* renamed from: l */
    private final InterfaceC14378o f21179l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppealVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.appeal.AppealVM$appealV3$1", m8638f = "AppealVM.kt", m8637i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 4}, m8636l = {54, 59, 63, 64, 71, 110, 120}, m8635m = "invokeSuspend", m8634n = {"identify", "identify", "it", "identify", "it", "faceFile", "identify", "it", "faceFile", "identify"}, m8633s = {"L$1", "L$1", "L$3", "L$1", "L$3", "L$5", "L$1", "L$3", "L$5", "L$1"})
    /* renamed from: com.bxkj.student.v2.vm.sports.appeal.AppealVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5898a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f21180a;

        /* renamed from: b */
        Object f21181b;

        /* renamed from: c */
        Object f21182c;

        /* renamed from: d */
        Object f21183d;

        /* renamed from: e */
        Object f21184e;

        /* renamed from: f */
        Object f21185f;

        /* renamed from: g */
        int f21186g;

        /* renamed from: i */
        final /* synthetic */ List<String> f21188i;

        /* renamed from: j */
        final /* synthetic */ String f21189j;

        /* renamed from: k */
        final /* synthetic */ InterfaceC15280l<String, Unit> f21190k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5898a(List<String> list, String str, InterfaceC15280l<? super String, Unit> interfaceC15280l, InterfaceC14268c<? super C5898a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21188i = list;
            this.f21189j = str;
            this.f21190k = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5898a(this.f21188i, this.f21189j, this.f21190k, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5898a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x03f3  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0140  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x01b7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0280  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0283  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x02df  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x02e2  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x02e6  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x02e9  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0343 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0344  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x034e  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0395 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x03a9 A[LOOP:0: B:94:0x03a3->B:96:0x03a9, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:99:0x03ed A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x015a -> B:65:0x01c2). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01b5 -> B:64:0x01b8). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r44) {
            /*
                Method dump skipped, instructions count: 1044
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.appeal.AppealVM.C5898a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: AppealVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.appeal.AppealVM$commit$2", m8638f = "AppealVM.kt", m8637i = {}, m8636l = {144}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.appeal.AppealVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5899b extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21191a;

        /* renamed from: b */
        final /* synthetic */ String f21192b;

        /* renamed from: c */
        final /* synthetic */ String f21193c;

        /* renamed from: d */
        final /* synthetic */ Map<String, RequestBody> f21194d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC15269a<Unit> f21195e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5899b(String str, String str2, Map<String, ? extends RequestBody> map, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5899b> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21192b = str;
            this.f21193c = str2;
            this.f21194d = map;
            this.f21195e = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5899b(this.f21192b, this.f21193c, this.f21194d, this.f21195e, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5899b) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21191a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsAppealRepository sportsAppealRepository = new SportsAppealRepository();
                RequestBody requestBody = RequestParameter.getRequestBody(this.f21192b);
                C14342f0.m8185o(requestBody, "getRequestBody(exerciseRecordId)");
                RequestBody requestBody2 = RequestParameter.getRequestBody(this.f21193c);
                C14342f0.m8185o(requestBody2, "getRequestBody(reason)");
                Map<String, RequestBody> map = this.f21194d;
                this.f21191a = 1;
                if (sportsAppealRepository.m38973a(requestBody, requestBody2, map, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            this.f21195e.invoke();
            return Unit.f41048a;
        }
    }

    /* compiled from: AppealVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/face/c;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.appeal.AppealVM$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5900c extends Lambda implements InterfaceC15269a<FaceDetectRepository> {

        /* renamed from: a */
        public static final C5900c f21196a = new C5900c();

        C5900c() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final FaceDetectRepository invoke() {
            return new FaceDetectRepository();
        }
    }

    /* compiled from: AppealVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/b;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.appeal.AppealVM$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5901d extends Lambda implements InterfaceC15269a<RecordRepository> {

        /* renamed from: a */
        public static final C5901d f21197a = new C5901d();

        C5901d() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final RecordRepository invoke() {
            return new RecordRepository();
        }
    }

    /* compiled from: AppealVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.appeal.AppealVM$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5902e extends Lambda implements InterfaceC15269a<SportsRepository> {

        /* renamed from: a */
        public static final C5902e f21198a = new C5902e();

        C5902e() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final SportsRepository invoke() {
            return new SportsRepository();
        }
    }

    public AppealVM() {
        InterfaceC14378o m7719c;
        InterfaceC14378o m7719c2;
        InterfaceC14378o m7719c3;
        m7719c = C14389r.m7719c(C5901d.f21197a);
        this.f21177j = m7719c;
        m7719c2 = C14389r.m7719c(C5902e.f21198a);
        this.f21178k = m7719c2;
        m7719c3 = C14389r.m7719c(C5900c.f21196a);
        this.f21179l = m7719c3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public final FaceDetectRepository m38011A() {
        return (FaceDetectRepository) this.f21179l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public final Map<String, RequestBody> m38010B(String str, List<? extends File> list) {
        File file;
        ArrayMap arrayMap = new ArrayMap();
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                arrayMap.put(str + "\"; filename=\"" + ((Object) file.getName()), RequestBody.Companion.create(MediaType.Companion.parse("image/png"), list.get(i)));
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public final RecordRepository m38008D() {
        return (RecordRepository) this.f21177j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public final SportsRepository m38007E() {
        return (SportsRepository) this.f21178k.getValue();
    }

    @Nullable
    /* renamed from: C */
    public final String m38009C() {
        return this.f21176i;
    }

    /* renamed from: F */
    public final void m38006F(@Nullable String str) {
        this.f21175h = str;
    }

    /* renamed from: G */
    public final void m38005G(@Nullable String str) {
        this.f21176i = str;
    }

    /* renamed from: x */
    public final void m38000x(@NotNull String reason, @NotNull List<String> paths, @NotNull InterfaceC15280l<? super String, Unit> callBack) {
        C14342f0.m8184p(reason, "reason");
        C14342f0.m8184p(paths, "paths");
        C14342f0.m8184p(callBack, "callBack");
        if (TextUtils.isEmpty(reason)) {
            m43953f().postValue("请输入申诉理由");
        } else {
            BaseViewModel.m43949j(this, new C5898a(paths, reason, callBack, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
        }
    }

    /* renamed from: y */
    public final void m37999y(@NotNull String exerciseRecordId, @NotNull String reason, @NotNull List<String> paths, @NotNull InterfaceC15269a<Unit> callBack) {
        C14342f0.m8184p(exerciseRecordId, "exerciseRecordId");
        C14342f0.m8184p(reason, "reason");
        C14342f0.m8184p(paths, "paths");
        C14342f0.m8184p(callBack, "callBack");
        if (TextUtils.isEmpty(reason)) {
            m43953f().postValue("请输入申诉理由");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : paths) {
            arrayList.add(new File(str));
        }
        BaseViewModel.m43949j(this, new C5899b(exerciseRecordId, reason, m38010B("files", arrayList), callBack, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @Nullable
    /* renamed from: z */
    public final String m37998z() {
        return this.f21175h;
    }
}
