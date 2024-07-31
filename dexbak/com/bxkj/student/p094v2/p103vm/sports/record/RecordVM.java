package com.bxkj.student.p094v2.p103vm.sports.record;

import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.ext.ExceptionExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.p094v2.repository.face.FaceDetectRepository;
import com.bxkj.student.p094v2.repository.sports.RecordRepository;
import com.bxkj.student.p094v2.repository.sports.SportsRepository;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.dns.DnsRecord;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C14294d0;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.comparisons.Comparisons;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.C14579x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: RecordVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@JR\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000225\u0010\r\u001a1\u0012'\u0012%\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J[\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u000225\u0010\r\u001a1\u0012'\u0012%\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015J3\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072#\u0010\u001a\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f0\u0004R0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R.\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u0010=\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/sports/record/RecordVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "datePageIndex", "Lkotlin/Function1;", "", "", "", "", "Lkotlin/ParameterName;", "name", "recordList", "Lkotlin/f1;", "resultList", "C", "(ILl1/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "date", "Lkotlin/Pair;", "", "y", "status", "Lkotlin/Function0;", "requestFinish", "D", "identify", "msg", "success", "K", "h", "Ljava/util/Map;", ExifInterface.LONGITUDE_EAST, "()Ljava/util/Map;", "J", "(Ljava/util/Map;)V", "recordMap", "i", "Ljava/lang/String;", UMCommonContent.f37777aG, "()Ljava/lang/String;", "H", "(Ljava/lang/String;)V", "defaultDate", "", "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "expandMap", "Lcom/bxkj/student/v2/repository/sports/b;", "k", "Lkotlin/o;", "F", "()Lcom/bxkj/student/v2/repository/sports/b;", "recordRepository", "Lcom/bxkj/student/v2/repository/sports/g;", C7304t.f25048d, "G", "()Lcom/bxkj/student/v2/repository/sports/g;", "sportsRepository", "Lcom/bxkj/student/v2/repository/face/c;", "m", "B", "()Lcom/bxkj/student/v2/repository/face/c;", "faceDetectRepository", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RecordVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private Map<String, Object> f21225h = new LinkedHashMap();
    @NotNull

    /* renamed from: i */
    private String f21226i = "";
    @NotNull

    /* renamed from: j */
    private Map<String, Boolean> f21227j = new LinkedHashMap();
    @NotNull

    /* renamed from: k */
    private final InterfaceC14378o f21228k;
    @NotNull

    /* renamed from: l */
    private final InterfaceC14378o f21229l;
    @NotNull

    /* renamed from: m */
    private final InterfaceC14378o f21230m;

    /* compiled from: RecordVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/face/c;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5919a extends Lambda implements InterfaceC15269a<FaceDetectRepository> {

        /* renamed from: a */
        public static final C5919a f21231a = new C5919a();

        C5919a() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final FaceDetectRepository invoke() {
            return new FaceDetectRepository();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordVM.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.record.RecordVM", m8638f = "RecordVM.kt", m8637i = {0, 0, 0}, m8636l = {175}, m8635m = "getLocalRecord", m8634n = {"this", "resultList", "current"}, m8633s = {"L$0", "L$1", "L$2"})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5920b extends ContinuationImpl {

        /* renamed from: a */
        Object f21232a;

        /* renamed from: b */
        Object f21233b;

        /* renamed from: c */
        Object f21234c;

        /* renamed from: d */
        /* synthetic */ Object f21235d;

        /* renamed from: f */
        int f21237f;

        C5920b(InterfaceC14268c<? super C5920b> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21235d = obj;
            this.f21237f |= Integer.MIN_VALUE;
            return RecordVM.this.m37958C(0, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getRecordListV3$1", m8638f = "RecordVM.kt", m8637i = {1, 1, 2, 2, 2}, m8636l = {44, 75, 105}, m8635m = "invokeSuspend", m8634n = {"recordList", "list", "recordList", "list", "it"}, m8633s = {"L$3", "L$4", "L$3", "L$4", "L$6"})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5921c extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f21238a;

        /* renamed from: b */
        Object f21239b;

        /* renamed from: c */
        Object f21240c;

        /* renamed from: d */
        Object f21241d;

        /* renamed from: e */
        Object f21242e;

        /* renamed from: f */
        Object f21243f;

        /* renamed from: g */
        Object f21244g;

        /* renamed from: h */
        int f21245h;

        /* renamed from: j */
        final /* synthetic */ String f21247j;

        /* renamed from: k */
        final /* synthetic */ int f21248k;

        /* renamed from: l */
        final /* synthetic */ InterfaceC15280l<List<Map<String, Object>>, Unit> f21249l;

        /* renamed from: m */
        final /* synthetic */ InterfaceC15269a<Unit> f21250m;

        /* compiled from: Comparisons.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$d", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5922a<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int m8803g;
                JsonGet jsonGet = JsonGet.f15134a;
                m8803g = Comparisons.m8803g(Long.valueOf(jsonGet.m43765o((Map) t2, AnalyticsConfig.RTD_START_TIME)), Long.valueOf(jsonGet.m43765o((Map) t, AnalyticsConfig.RTD_START_TIME)));
                return m8803g;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5921c(String str, int i, InterfaceC15280l<? super List<Map<String, Object>>, Unit> interfaceC15280l, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5921c> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21247j = str;
            this.f21248k = i;
            this.f21249l = interfaceC15280l;
            this.f21250m = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5921c(this.f21247j, this.f21248k, this.f21249l, this.f21250m, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5921c) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:123:0x02b1  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x02c9  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x0322  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x032f  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x03c1  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x03d4  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x03d8  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x03dd  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01b9  */
        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List, T] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:130:0x0316 -> B:131:0x031e). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r33) {
            /*
                Method dump skipped, instructions count: 1025
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.record.RecordVM.C5921c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getRecordListV3$2", m8638f = "RecordVM.kt", m8637i = {}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5923d extends SuspendLambda implements InterfaceC15284p<Exception, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21251a;

        /* renamed from: b */
        /* synthetic */ Object f21252b;

        /* renamed from: c */
        final /* synthetic */ String f21253c;

        /* renamed from: d */
        final /* synthetic */ RecordVM f21254d;

        /* renamed from: e */
        final /* synthetic */ int f21255e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15280l<List<Map<String, Object>>, Unit> f21256f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5923d(String str, RecordVM recordVM, int i, InterfaceC15280l<? super List<Map<String, Object>>, Unit> interfaceC15280l, InterfaceC14268c<? super C5923d> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f21253c = str;
            this.f21254d = recordVM;
            this.f21255e = i;
            this.f21256f = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5923d c5923d = new C5923d(this.f21253c, this.f21254d, this.f21255e, this.f21256f, interfaceC14268c);
            c5923d.f21252b = obj;
            return c5923d;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5923d) create(exc, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21251a;
            boolean z = false;
            if (i == 0) {
                C14294d0.m8596n(obj);
                if (ExceptionExt.m43845a((Exception) this.f21252b)) {
                    C11792j.m20469d("服务器挂了，获取本地跑步记录", new Object[0]);
                    if (!C14342f0.m8193g(this.f21253c, "0") && !C14342f0.m8193g(this.f21253c, "-1")) {
                        this.f21256f.invoke(new ArrayList());
                    } else {
                        RecordVM recordVM = this.f21254d;
                        int i2 = this.f21255e;
                        InterfaceC15280l<List<Map<String, Object>>, Unit> interfaceC15280l = this.f21256f;
                        this.f21251a = 1;
                        if (recordVM.m37958C(i2, interfaceC15280l, this) == m8642h) {
                            return m8642h;
                        }
                    }
                }
                return boxing.m8631a(z);
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            z = true;
            return boxing.m8631a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.record.RecordVM$getRecordListV3$3", m8638f = "RecordVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5924e extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21257a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15269a<Unit> f21258b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5924e(InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5924e> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21258b = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5924e(this.f21258b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5924e) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f21257a == 0) {
                C14294d0.m8596n(obj);
                this.f21258b.invoke();
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: RecordVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/b;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5925f extends Lambda implements InterfaceC15269a<RecordRepository> {

        /* renamed from: a */
        public static final C5925f f21259a = new C5925f();

        C5925f() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final RecordRepository invoke() {
            return new RecordRepository();
        }
    }

    /* compiled from: RecordVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5926g extends Lambda implements InterfaceC15269a<SportsRepository> {

        /* renamed from: a */
        public static final C5926g f21260a = new C5926g();

        C5926g() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final SportsRepository invoke() {
            return new SportsRepository();
        }
    }

    /* compiled from: RecordVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.record.RecordVM$uploadV3$1", m8638f = "RecordVM.kt", m8637i = {1, 2, 2, 3, 3, 5}, m8636l = {251, 257, 261, 268, 275, 306}, m8635m = "invokeSuspend", m8634n = {"it", "it", "faceFile", "it", "faceFile", "commitV3"}, m8633s = {"L$4", "L$4", "L$6", "L$4", "L$6", "L$2"})
    /* renamed from: com.bxkj.student.v2.vm.sports.record.RecordVM$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5927h extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f21261a;

        /* renamed from: b */
        Object f21262b;

        /* renamed from: c */
        Object f21263c;

        /* renamed from: d */
        Object f21264d;

        /* renamed from: e */
        Object f21265e;

        /* renamed from: f */
        Object f21266f;

        /* renamed from: g */
        Object f21267g;

        /* renamed from: h */
        int f21268h;

        /* renamed from: j */
        final /* synthetic */ String f21270j;

        /* renamed from: k */
        final /* synthetic */ InterfaceC15280l<String, Unit> f21271k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5927h(String str, InterfaceC15280l<? super String, Unit> interfaceC15280l, InterfaceC14268c<? super C5927h> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21270j = str;
            this.f21271k = interfaceC15280l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5927h(this.f21270j, this.f21271k, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5927h) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0192 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0260  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0263  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x02bf  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x02c2  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x02c6  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x02c9  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0333 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0334  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0355 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0356  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0359  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x012b -> B:53:0x019e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0190 -> B:52:0x0193). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r47) {
            /*
                Method dump skipped, instructions count: 888
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.record.RecordVM.C5927h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public RecordVM() {
        InterfaceC14378o m7719c;
        InterfaceC14378o m7719c2;
        InterfaceC14378o m7719c3;
        m7719c = C14389r.m7719c(C5925f.f21259a);
        this.f21228k = m7719c;
        m7719c2 = C14389r.m7719c(C5926g.f21260a);
        this.f21229l = m7719c2;
        m7719c3 = C14389r.m7719c(C5919a.f21231a);
        this.f21230m = m7719c3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public final FaceDetectRepository m37959B() {
        return (FaceDetectRepository) this.f21230m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m37958C(int r12, p617l1.InterfaceC15280l<? super java.util.List<java.util.Map<java.lang.String, java.lang.Object>>, kotlin.Unit> r13, kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.record.RecordVM.m37958C(int, l1.l, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public final RecordRepository m37955F() {
        return (RecordRepository) this.f21228k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public final SportsRepository m37954G() {
        return (SportsRepository) this.f21229l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public final Tuples<Long, Long> m37944y(String str) {
        List m6471T4;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        m6471T4 = C14579x.m6471T4(str, new String[]{"-"}, false, 0, 6, null);
        calendar.set(1, Integer.parseInt((String) m6471T4.get(0)));
        calendar.set(2, Integer.parseInt((String) m6471T4.get(1)) - 1);
        calendar.set(5, 1);
        String format = simpleDateFormat.format(calendar.getTime());
        C14342f0.m8185o(format, "dateFormat.format(cal.time)");
        String substring = format.substring(0, 10);
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String m8216C = C14342f0.m8216C(substring, " 00:00:00");
        calendar.set(5, calendar.getActualMaximum(5));
        String format2 = simpleDateFormat.format(calendar.getTime());
        C14342f0.m8185o(format2, "dateFormat.format(cal.time)");
        String substring2 = format2.substring(0, 10);
        C14342f0.m8185o(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return new Tuples<>(Long.valueOf(simpleDateFormat.parse(m8216C).getTime()), Long.valueOf(simpleDateFormat.parse(C14342f0.m8216C(substring2, " 23:59:59")).getTime()));
    }

    @NotNull
    /* renamed from: A */
    public final Map<String, Boolean> m37960A() {
        return this.f21227j;
    }

    /* renamed from: D */
    public final void m37957D(@NotNull String status, int i, @NotNull InterfaceC15280l<? super List<Map<String, Object>>, Unit> resultList, @NotNull InterfaceC15269a<Unit> requestFinish) {
        C14342f0.m8184p(status, "status");
        C14342f0.m8184p(resultList, "resultList");
        C14342f0.m8184p(requestFinish, "requestFinish");
        BaseViewModel.m43949j(this, new C5921c(status, i, resultList, requestFinish, null), null, new C5923d(status, this, i, resultList, null), null, new C5924e(requestFinish, null), null, null, null, 234, null);
    }

    @NotNull
    /* renamed from: E */
    public final Map<String, Object> m37956E() {
        return this.f21225h;
    }

    /* renamed from: H */
    public final void m37953H(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f21226i = str;
    }

    /* renamed from: I */
    public final void m37952I(@NotNull Map<String, Boolean> map) {
        C14342f0.m8184p(map, "<set-?>");
        this.f21227j = map;
    }

    /* renamed from: J */
    public final void m37951J(@NotNull Map<String, Object> map) {
        C14342f0.m8184p(map, "<set-?>");
        this.f21225h = map;
    }

    /* renamed from: K */
    public final void m37950K(@NotNull String identify, @NotNull InterfaceC15280l<? super String, Unit> success) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(success, "success");
        BaseViewModel.m43949j(this, new C5927h(identify, success, null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    @NotNull
    /* renamed from: z */
    public final String m37943z() {
        return this.f21226i;
    }
}
