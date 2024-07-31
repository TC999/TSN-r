package com.bxkj.student.p094v2.p103vm.sports;

import android.app.Activity;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.ext.ExceptionExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.p085v2.http.exception.ApiException;
import com.bxkj.student.App;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.data.SportsDataAnalysis;
import com.bxkj.student.p094v2.common.p095db.AppDatabase;
import com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao;
import com.bxkj.student.p094v2.common.utils.ActivityManager;
import com.bxkj.student.p094v2.common.utils.C5543h;
import com.bxkj.student.p094v2.common.utils.RootCheckUtils;
import com.bxkj.student.p094v2.p098ui.sports.safe.SettingSafe;
import com.bxkj.student.p094v2.repository.sports.SportsHomeRepository;
import com.bxkj.student.p094v2.repository.sports.SportsRepository;
import com.bxkj.student.run.app.utils.MockLocationUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import com.snail.antifake.jni.EmulatorDetectUtil;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C14294d0;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.C14239y0;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.SportsDb;
import p027c0.SportsSetDb;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p647u.AppSecretInfo;
import p647u.ClientEncrypt;

/* compiled from: SportsHomeVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bC\u0010DJ\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002J&\u0010\u000b\u001a\u00020\u00062\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0006J\u001c\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u0006\u0010\u0017\u001a\u00020\u0006R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR6\u0010%\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R6\u0010)\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R6\u0010-\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R6\u00101\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R6\u00105\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010 \u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R6\u00109\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010 \u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R0\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120:0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010 \u001a\u0004\b<\u0010\"\"\u0004\b=\u0010$R0\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120:0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010 \u001a\u0004\b@\u0010\"\"\u0004\bA\u0010$¨\u0006E"}, m12616d2 = {"Lcom/bxkj/student/v2/vm/sports/SportsHomeVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", "", "", "sportsResult", "Lkotlin/f1;", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "sportType", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "G", "C", "identity", "F", "K", "Lc0/c;", "sportsDb", "Lkotlin/Function0;", "canContinue", "L", "J", "Lcom/bxkj/student/v2/repository/sports/e;", "h", "Lkotlin/o;", "D", "()Lcom/bxkj/student/v2/repository/sports/e;", "sportsHomeRepository", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", UMCommonContent.f37777aG, "()Landroidx/lifecycle/MutableLiveData;", "P", "(Landroidx/lifecycle/MutableLiveData;)V", "menuList", "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Q", "morningRecordMap", "k", "H", "U", "sunshineRecordMap", C7304t.f25048d, "y", "O", "freedomRecordMap", "m", "x", "N", "exercise_sit_RecordMap", "n", "B", "R", "sportSetMap", "", "o", "I", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "uploadFailList", "p", IAdInterListener.AdReqParam.WIDTH, "M", "exceptionList", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsHomeVM extends BaseViewModel {
    @NotNull

    /* renamed from: h */
    private final InterfaceC14378o f21067h;
    @NotNull

    /* renamed from: i */
    private MutableLiveData<Map<String, Object>> f21068i;
    @NotNull

    /* renamed from: j */
    private MutableLiveData<Map<String, Object>> f21069j;
    @NotNull

    /* renamed from: k */
    private MutableLiveData<Map<String, Object>> f21070k;
    @NotNull

    /* renamed from: l */
    private MutableLiveData<Map<String, Object>> f21071l;
    @NotNull

    /* renamed from: m */
    private MutableLiveData<Map<String, Object>> f21072m;
    @NotNull

    /* renamed from: n */
    private MutableLiveData<Map<String, Object>> f21073n;
    @NotNull

    /* renamed from: o */
    private MutableLiveData<List<SportsDb>> f21074o;
    @NotNull

    /* renamed from: p */
    private MutableLiveData<List<SportsDb>> f21075p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportSetV2$1", m8638f = "SportsHomeVM.kt", m8637i = {0, 1}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME}, m8635m = "invokeSuspend", m8634n = {"originAesKey", "resultJson"}, m8633s = {"L$0", "L$1"})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5874a extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f21076a;

        /* renamed from: b */
        Object f21077b;

        /* renamed from: c */
        int f21078c;

        /* renamed from: d */
        int f21079d;

        /* renamed from: e */
        final /* synthetic */ int f21080e;

        /* renamed from: f */
        final /* synthetic */ SportsHomeVM f21081f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5874a(int i, SportsHomeVM sportsHomeVM, InterfaceC14268c<? super C5874a> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21080e = i;
            this.f21081f = sportsHomeVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5874a(this.f21080e, this.f21081f, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5874a) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            String str;
            int i;
            SportsHomeVM sportsHomeVM;
            String resultJson;
            int i2;
            SportsHomeVM sportsHomeVM2;
            Map m8915J0;
            m8642h = C14287b.m8642h();
            int i3 = this.f21079d;
            if (i3 == 0) {
                C14294d0.m8596n(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.putAll(AppSecretInfo.f47135a.m247a());
                linkedHashMap.put("runType", boxing.m8626f(this.f21080e));
                String[] m245b = ClientEncrypt.m245b(JSON.toJSONString(linkedHashMap));
                str = m245b[0];
                String key = m245b[1];
                String data = m245b[2];
                SportsHomeRepository m38075D = this.f21081f.m38075D();
                C14342f0.m8185o(key, "key");
                C14342f0.m8185o(data, "data");
                this.f21076a = str;
                this.f21079d = 1;
                obj = m38075D.m38965g(key, data, this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.f21078c;
                resultJson = (String) this.f21077b;
                sportsHomeVM2 = (SportsHomeVM) this.f21076a;
                C14294d0.m8596n(obj);
                i = i2;
                sportsHomeVM = sportsHomeVM2;
                m8915J0 = C14239y0.m8915J0(JsonGet.f15134a.m43782A(resultJson));
                sportsHomeVM.m38060S(m8915J0, i);
                return Unit.f41048a;
            } else {
                str = (String) this.f21076a;
                C14294d0.m8596n(obj);
            }
            String str2 = (String) obj;
            if (str2 != null) {
                i = this.f21080e;
                sportsHomeVM = this.f21081f;
                resultJson = ClientEncrypt.m246a(str, str2);
                C11792j.m20465h(resultJson);
                SportsSetDao mo39224m = AppDatabase.f19934a.m39228a().mo39224m();
                if (mo39224m != null) {
                    String m43642t = LoggedInUser.f15182b.m43634a().m43642t();
                    String valueOf = String.valueOf(i);
                    C14342f0.m8185o(resultJson, "resultJson");
                    SportsSetDb sportsSetDb = new SportsSetDb(m43642t, valueOf, resultJson);
                    this.f21076a = sportsHomeVM;
                    this.f21077b = resultJson;
                    this.f21078c = i;
                    this.f21079d = 2;
                    if (mo39224m.insert(sportsSetDb, this) == m8642h) {
                        return m8642h;
                    }
                    i2 = i;
                    sportsHomeVM2 = sportsHomeVM;
                    i = i2;
                    sportsHomeVM = sportsHomeVM2;
                }
                m8915J0 = C14239y0.m8915J0(JsonGet.f15134a.m43782A(resultJson));
                sportsHomeVM.m38060S(m8915J0, i);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportSetV2$2", m8638f = "SportsHomeVM.kt", m8637i = {}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5875b extends SuspendLambda implements InterfaceC15284p<Exception, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21082a;

        /* renamed from: b */
        /* synthetic */ Object f21083b;

        /* renamed from: d */
        final /* synthetic */ int f21085d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5875b(int i, InterfaceC14268c<? super C5875b> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f21085d = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5875b c5875b = new C5875b(this.f21085d, interfaceC14268c);
            c5875b.f21083b = obj;
            return c5875b;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5875b) create(exc, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r5.f21082a
                r2 = 0
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L19
                if (r1 != r4) goto L11
                kotlin.C14294d0.m8596n(r6)
                goto L49
            L11:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L19:
                kotlin.C14294d0.m8596n(r6)
                java.lang.Object r6 = r5.f21083b
                java.lang.Exception r6 = (java.lang.Exception) r6
                boolean r6 = com.bxkj.base.p085v2.common.ext.ExceptionExt.m43845a(r6)
                if (r6 == 0) goto L93
                java.lang.Object[] r6 = new java.lang.Object[r2]
                java.lang.String r1 = "离线跑步"
                com.orhanobut.logger.C11792j.m20469d(r1, r6)
                com.bxkj.student.v2.common.db.AppDatabase$b r6 = com.bxkj.student.p094v2.common.p095db.AppDatabase.f19934a
                com.bxkj.student.v2.common.db.AppDatabase r6 = r6.m39228a()
                com.bxkj.student.v2.common.db.dao.g r6 = r6.mo39224m()
                if (r6 != 0) goto L3a
                goto L85
            L3a:
                int r1 = r5.f21085d
                java.lang.String r1 = java.lang.String.valueOf(r1)
                r5.f21082a = r4
                java.lang.Object r6 = r6.mo39159b(r1, r5)
                if (r6 != r0) goto L49
                return r0
            L49:
                java.lang.String r6 = (java.lang.String) r6
                if (r6 != 0) goto L4e
                goto L85
            L4e:
                int r0 = r6.length()
                if (r0 <= 0) goto L55
                r2 = 1
            L55:
                if (r2 == 0) goto L58
                goto L59
            L58:
                r6 = r3
            L59:
                if (r6 != 0) goto L5c
                goto L85
            L5c:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r0 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.this
                int r1 = r5.f21085d
                com.bxkj.base.v2.common.utils.l r2 = com.bxkj.base.p085v2.common.utils.JsonGet.f15134a
                java.util.Map r6 = r2.m43782A(r6)
                java.util.Map r6 = kotlin.collections.C14234v0.m8979J0(r6)
                java.util.UUID r2 = java.util.UUID.randomUUID()
                java.lang.String r2 = r2.toString()
                java.lang.String r3 = "identify"
                r6.put(r3, r2)
                java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.boxing.m8631a(r4)
                java.lang.String r3 = "serverUnavailable"
                r6.put(r3, r2)
                com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.m38055u(r0, r6, r1)
                kotlin.f1 r3 = kotlin.Unit.f41048a
            L85:
                if (r3 != 0) goto L92
                com.bxkj.student.v2.vm.sports.SportsHomeVM r6 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.this
                androidx.lifecycle.MutableLiveData r6 = r6.m43953f()
                java.lang.String r0 = "服务器维护中，请稍后再进行跑步"
                r6.postValue(r0)
            L92:
                r2 = 1
            L93:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.boxing.m8631a(r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.C5875b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsMenu$1", m8638f = "SportsHomeVM.kt", m8637i = {1}, m8636l = {54, 56}, m8635m = "invokeSuspend", m8634n = {"sportsResult"}, m8633s = {"L$0"})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5876c extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f21086a;

        /* renamed from: b */
        Object f21087b;

        /* renamed from: c */
        int f21088c;

        C5876c(InterfaceC14268c<? super C5876c> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5876c(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5876c) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            Map map;
            SportsHomeVM sportsHomeVM;
            SportsHomeVM sportsHomeVM2;
            m8642h = C14287b.m8642h();
            int i = this.f21088c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsHomeRepository m38075D = SportsHomeVM.this.m38075D();
                this.f21088c = 1;
                obj = m38075D.m38966f(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sportsHomeVM2 = (SportsHomeVM) this.f21087b;
                map = (Map) this.f21086a;
                C14294d0.m8596n(obj);
                sportsHomeVM = sportsHomeVM2;
                sportsHomeVM.m38059T(map);
                return Unit.f41048a;
            } else {
                C14294d0.m8596n(obj);
            }
            map = (Map) obj;
            if (map != null) {
                sportsHomeVM = SportsHomeVM.this;
                SportsSetDao mo39224m = AppDatabase.f19934a.m39228a().mo39224m();
                if (mo39224m != null) {
                    String m43642t = LoggedInUser.f15182b.m43634a().m43642t();
                    String jSONString = JSON.toJSONString(map);
                    C14342f0.m8185o(jSONString, "toJSONString(it)");
                    SportsSetDb sportsSetDb = new SportsSetDb(m43642t, "-1", jSONString);
                    this.f21086a = map;
                    this.f21087b = sportsHomeVM;
                    this.f21088c = 2;
                    if (mo39224m.insert(sportsSetDb, this) == m8642h) {
                        return m8642h;
                    }
                    sportsHomeVM2 = sportsHomeVM;
                    sportsHomeVM = sportsHomeVM2;
                }
                sportsHomeVM.m38059T(map);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsMenu$2", m8638f = "SportsHomeVM.kt", m8637i = {}, m8636l = {69}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5877d extends SuspendLambda implements InterfaceC15284p<Exception, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21090a;

        /* renamed from: b */
        /* synthetic */ Object f21091b;

        C5877d(InterfaceC14268c<? super C5877d> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5877d c5877d = new C5877d(interfaceC14268c);
            c5877d.f21091b = obj;
            return c5877d;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5877d) create(exc, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r5.f21090a
                r2 = 0
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L19
                if (r1 != r4) goto L11
                kotlin.C14294d0.m8596n(r6)
                goto L45
            L11:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L19:
                kotlin.C14294d0.m8596n(r6)
                java.lang.Object r6 = r5.f21091b
                java.lang.Exception r6 = (java.lang.Exception) r6
                boolean r6 = com.bxkj.base.p085v2.common.ext.ExceptionExt.m43845a(r6)
                if (r6 == 0) goto L77
                java.lang.Object[] r6 = new java.lang.Object[r2]
                java.lang.String r1 = "离线跑步获取跑步总记录数"
                com.orhanobut.logger.C11792j.m20469d(r1, r6)
                com.bxkj.student.v2.common.db.AppDatabase$b r6 = com.bxkj.student.p094v2.common.p095db.AppDatabase.f19934a
                com.bxkj.student.v2.common.db.AppDatabase r6 = r6.m39228a()
                com.bxkj.student.v2.common.db.dao.g r6 = r6.mo39224m()
                if (r6 != 0) goto L3a
                goto L69
            L3a:
                r5.f21090a = r4
                java.lang.String r1 = "-1"
                java.lang.Object r6 = r6.mo39159b(r1, r5)
                if (r6 != r0) goto L45
                return r0
            L45:
                java.lang.String r6 = (java.lang.String) r6
                if (r6 != 0) goto L4a
                goto L69
            L4a:
                int r0 = r6.length()
                if (r0 <= 0) goto L51
                r2 = 1
            L51:
                if (r2 == 0) goto L54
                goto L55
            L54:
                r6 = r3
            L55:
                if (r6 != 0) goto L58
                goto L69
            L58:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r0 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.this
                com.bxkj.base.v2.common.utils.l r1 = com.bxkj.base.p085v2.common.utils.JsonGet.f15134a
                java.util.Map r6 = r1.m43782A(r6)
                java.util.Map r6 = kotlin.collections.C14234v0.m8979J0(r6)
                com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.m38054v(r0, r6)
                kotlin.f1 r3 = kotlin.Unit.f41048a
            L69:
                if (r3 != 0) goto L76
                com.bxkj.student.v2.vm.sports.SportsHomeVM r6 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.this
                androidx.lifecycle.MutableLiveData r6 = r6.m43953f()
                java.lang.String r0 = "服务器维护中，请稍后再进行跑步"
                r6.postValue(r0)
            L76:
                r2 = 1
            L77:
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.boxing.m8631a(r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.C5877d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsStartTime$1", m8638f = "SportsHomeVM.kt", m8637i = {}, m8636l = {215}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5878e extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21093a;

        /* renamed from: c */
        final /* synthetic */ String f21095c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5878e(String str, InterfaceC14268c<? super C5878e> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21095c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5878e(this.f21095c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5878e) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21093a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsHomeRepository m38075D = SportsHomeVM.this.m38075D();
                String str = this.f21095c;
                this.f21093a = 1;
                if (m38075D.m38964h(str, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getSportsStartTime$2", m8638f = "SportsHomeVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5879f extends SuspendLambda implements InterfaceC15284p<Exception, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21096a;

        /* renamed from: b */
        /* synthetic */ Object f21097b;

        C5879f(InterfaceC14268c<? super C5879f> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5879f c5879f = new C5879f(interfaceC14268c);
            c5879f.f21097b = obj;
            return c5879f;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5879f) create(exc, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f21096a == 0) {
                C14294d0.m8596n(obj);
                return boxing.m8631a(ExceptionExt.m43845a((Exception) this.f21097b));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$getVirtualList$1", m8638f = "SportsHomeVM.kt", m8637i = {}, m8636l = {278}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5880g extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21098a;

        C5880g(InterfaceC14268c<? super C5880g> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5880g(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5880g) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21098a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsHomeRepository m38075D = SportsHomeVM.this.m38075D();
                this.f21098a = 1;
                obj = m38075D.m38962j(this);
                if (obj == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            List<Map<String, ? extends Object>> list = (List) obj;
            if (list != null) {
                for (Map<String, ? extends Object> map : list) {
                    String m43760t = JsonGet.f15134a.m43760t(map, TTDownloadField.TT_PACKAGE_NAME);
                    MockLocationUtils.f19653a.m39595a().put(m43760t, m43760t);
                }
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$queryLocalSports$1", m8638f = "SportsHomeVM.kt", m8637i = {}, m8636l = {222, 226, 232}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5881h extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        Object f21100a;

        /* renamed from: b */
        int f21101b;

        C5881h(InterfaceC14268c<? super C5881h> interfaceC14268c) {
            super(1, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5881h(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5881h) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r8.f21101b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L29
                if (r1 == r4) goto L25
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                java.lang.Object r1 = r8.f21100a
                java.util.Iterator r1 = (java.util.Iterator) r1
                kotlin.C14294d0.m8596n(r9)
                goto L7f
            L19:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L21:
                kotlin.C14294d0.m8596n(r9)
                goto L6c
            L25:
                kotlin.C14294d0.m8596n(r9)
                goto L45
            L29:
                kotlin.C14294d0.m8596n(r9)
                com.bxkj.student.v2.vm.sports.SportsHomeVM r9 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.this
                com.bxkj.student.v2.repository.sports.e r9 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.m38056t(r9)
                com.bxkj.base.v2.data.a$b r1 = com.bxkj.base.p085v2.data.LoggedInUser.f15182b
                com.bxkj.base.v2.data.a r1 = r1.m43634a()
                java.lang.String r1 = r1.m43641u()
                r8.f21101b = r4
                java.lang.Object r9 = r9.m38963i(r1, r8)
                if (r9 != r0) goto L45
                return r0
            L45:
                java.util.List r9 = (java.util.List) r9
                if (r9 != 0) goto L4a
                goto L53
            L4a:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r1 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.this
                androidx.lifecycle.MutableLiveData r1 = r1.m38070I()
                r1.postValue(r9)
            L53:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r9 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.this
                com.bxkj.student.v2.repository.sports.e r9 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.m38056t(r9)
                com.bxkj.base.v2.data.a$b r1 = com.bxkj.base.p085v2.data.LoggedInUser.f15182b
                com.bxkj.base.v2.data.a r1 = r1.m43634a()
                java.lang.String r1 = r1.m43641u()
                r8.f21101b = r3
                java.lang.Object r9 = r9.m38969c(r1, r8)
                if (r9 != r0) goto L6c
                return r0
            L6c:
                java.util.List r9 = (java.util.List) r9
                if (r9 != 0) goto L71
                goto Lca
            L71:
                com.bxkj.student.v2.vm.sports.SportsHomeVM r1 = com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.this
                androidx.lifecycle.MutableLiveData r1 = r1.m38053w()
                r1.postValue(r9)
                java.util.Iterator r9 = r9.iterator()
                r1 = r9
            L7f:
                r9 = r8
            L80:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto Lca
                java.lang.Object r3 = r1.next()
                c0.c r3 = (p027c0.SportsDb) r3
                if (r3 != 0) goto L8f
                goto L80
            L8f:
                java.lang.String r5 = r3.m58126G()
                int r5 = r5.length()
                if (r5 <= 0) goto L9b
                r5 = 1
                goto L9c
            L9b:
                r5 = 0
            L9c:
                r6 = 0
                if (r5 == 0) goto La0
                goto La1
            La0:
                r3 = r6
            La1:
                if (r3 != 0) goto La4
                goto L80
            La4:
                java.lang.String r5 = r3.m58116Q()
                java.lang.String r7 = "0"
                boolean r5 = kotlin.jvm.internal.C14342f0.m8193g(r5, r7)
                if (r5 == 0) goto Lb1
                r6 = r3
            Lb1:
                if (r6 != 0) goto Lb4
                goto L80
            Lb4:
                com.bxkj.student.v2.repository.sports.g r3 = new com.bxkj.student.v2.repository.sports.g
                r3.<init>()
                java.lang.String r5 = r6.m58126G()
                r9.f21100a = r1
                r9.f21101b = r2
                java.lang.String r6 = "2"
                java.lang.Object r3 = r3.m38953h(r6, r5, r9)
                if (r3 != r0) goto L80
                return r0
            Lca:
                kotlin.f1 r9 = kotlin.Unit.f41048a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM.C5881h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$1", m8638f = "SportsHomeVM.kt", m8637i = {}, m8636l = {256, 258}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5882i extends SuspendLambda implements InterfaceC15280l<InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f21103a;

        /* renamed from: c */
        final /* synthetic */ SportsDb f21105c;

        /* renamed from: d */
        final /* synthetic */ ArrayMap<String, Object> f21106d;

        /* renamed from: e */
        final /* synthetic */ InterfaceC15269a<Unit> f21107e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5882i(SportsDb sportsDb, ArrayMap<String, Object> arrayMap, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5882i> interfaceC14268c) {
            super(1, interfaceC14268c);
            this.f21105c = sportsDb;
            this.f21106d = arrayMap;
            this.f21107e = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5882i(this.f21105c, this.f21106d, this.f21107e, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5882i) create(interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21103a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsHomeRepository m38075D = SportsHomeVM.this.m38075D();
                String m58126G = this.f21105c.m58126G();
                this.f21103a = 1;
                if (m38075D.m38971a(m58126G, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C14294d0.m8596n(obj);
                this.f21107e.invoke();
                return Unit.f41048a;
            } else {
                C14294d0.m8596n(obj);
            }
            SportsHomeVM sportsHomeVM = SportsHomeVM.this;
            ArrayMap<String, Object> sportsSetMap = this.f21106d;
            C14342f0.m8185o(sportsSetMap, "sportsSetMap");
            sportsHomeVM.m38060S(sportsSetMap, Integer.parseInt(this.f21105c.m58120M()));
            SportsRepository sportsRepository = new SportsRepository();
            String m58126G2 = this.f21105c.m58126G();
            this.f21103a = 2;
            if (sportsRepository.m38953h("0", m58126G2, this) == m8642h) {
                return m8642h;
            }
            this.f21107e.invoke();
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m12616d2 = {"Lcom/bxkj/base/v2/http/exception/ApiException;", "it", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$2", m8638f = "SportsHomeVM.kt", m8637i = {}, m8636l = {261}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5883j extends SuspendLambda implements InterfaceC15284p<ApiException, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21108a;

        /* renamed from: b */
        final /* synthetic */ SportsDb f21109b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5883j(SportsDb sportsDb, InterfaceC14268c<? super C5883j> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f21109b = sportsDb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5883j(this.f21109b, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull ApiException apiException, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5883j) create(apiException, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f21108a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsRepository sportsRepository = new SportsRepository();
                String m58126G = this.f21109b.m58126G();
                this.f21108a = 1;
                if (sportsRepository.m38953h("3", m58126G, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return boxing.m8631a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u00052\u0019\u0010\u0004\u001a\u00150\u0000j\u0011`\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004H\u008a@"}, m12616d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.vm.sports.SportsHomeVM$resumeContinue$3", m8638f = "SportsHomeVM.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5884k extends SuspendLambda implements InterfaceC15284p<Exception, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        int f21110a;

        /* renamed from: b */
        /* synthetic */ Object f21111b;

        /* renamed from: d */
        final /* synthetic */ ArrayMap<String, Object> f21113d;

        /* renamed from: e */
        final /* synthetic */ SportsDb f21114e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC15269a<Unit> f21115f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5884k(ArrayMap<String, Object> arrayMap, SportsDb sportsDb, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC14268c<? super C5884k> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f21113d = arrayMap;
            this.f21114e = sportsDb;
            this.f21115f = interfaceC15269a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C5884k c5884k = new C5884k(this.f21113d, this.f21114e, this.f21115f, interfaceC14268c);
            c5884k.f21111b = obj;
            return c5884k;
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        /* renamed from: d */
        public final Object invoke(@NotNull Exception exc, @Nullable InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C5884k) create(exc, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f21110a == 0) {
                C14294d0.m8596n(obj);
                boolean z = false;
                if (ExceptionExt.m43845a((Exception) this.f21111b)) {
                    C11792j.m20469d("离线跑步直接没办法验证超时时间", new Object[0]);
                    SportsHomeVM sportsHomeVM = SportsHomeVM.this;
                    ArrayMap<String, Object> sportsSetMap = this.f21113d;
                    C14342f0.m8185o(sportsSetMap, "sportsSetMap");
                    sportsHomeVM.m38060S(sportsSetMap, Integer.parseInt(this.f21114e.m58120M()));
                    this.f21115f.invoke();
                    z = true;
                }
                return boxing.m8631a(z);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5885l extends Lambda implements InterfaceC15280l<iOSOneButtonDialog, Unit> {

        /* renamed from: a */
        public static final C5885l f21116a = new C5885l();

        C5885l() {
            super(1);
        }

        /* renamed from: a */
        public final void m38038a(@NotNull iOSOneButtonDialog it) {
            C14342f0.m8184p(it, "it");
            SettingSafe.f20547a.m38617c();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSOneButtonDialog iosonebuttondialog) {
            m38038a(iosonebuttondialog);
            return Unit.f41048a;
        }
    }

    /* compiled from: SportsHomeVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/repository/sports/e;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.vm.sports.SportsHomeVM$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5886m extends Lambda implements InterfaceC15269a<SportsHomeRepository> {

        /* renamed from: a */
        public static final C5886m f21117a = new C5886m();

        C5886m() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final SportsHomeRepository invoke() {
            return new SportsHomeRepository();
        }
    }

    public SportsHomeVM() {
        InterfaceC14378o m7719c;
        m7719c = C14389r.m7719c(C5886m.f21117a);
        this.f21067h = m7719c;
        this.f21068i = new MutableLiveData<>();
        this.f21069j = new MutableLiveData<>();
        this.f21070k = new MutableLiveData<>();
        this.f21071l = new MutableLiveData<>();
        this.f21072m = new MutableLiveData<>();
        this.f21073n = new MutableLiveData<>();
        this.f21074o = new MutableLiveData<>();
        this.f21075p = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public final SportsHomeRepository m38075D() {
        return (SportsHomeRepository) this.f21067h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public final void m38060S(Map<String, Object> map, int i) {
        C5543h.C5544a c5544a = C5543h.f20113a;
        SportsDataAnalysis.C5482a c5482a = SportsDataAnalysis.f19931a;
        JsonGet jsonGet = JsonGet.f15134a;
        c5544a.m39081v(c5482a.m39238h(jsonGet.m43773g(map, "limitSpeed", c5544a.m39092k())));
        c5544a.m39077z(jsonGet.m43773g(map, "startStride", c5544a.m39088o()));
        c5544a.m39085r(jsonGet.m43773g(map, "avgStride", c5544a.m39097f()));
        c5544a.m39079x(jsonGet.m43773g(map, "endStride", c5544a.m39090m()));
        c5544a.m39082u(jsonGet.m43768l(map, "startLimitStepFrequency", c5544a.m39093j()));
        c5544a.m39078y(jsonGet.m43768l(map, "startStepFrequency", c5544a.m39089n()));
        c5544a.m39080w(jsonGet.m43768l(map, "endStepFrequency", c5544a.m39091l()));
        c5544a.m39083t(jsonGet.m43768l(map, "endLimitStepFrequency", c5544a.m39094i()));
        c5544a.m39106A(jsonGet.m43768l(map, "stepCheckDistance", c5544a.m39086q()));
        C11792j.m20469d(" DriftUtils.maxSpeed=" + c5544a.m39092k() + "\n DriftUtils.minStride=" + c5544a.m39088o() + "\n DriftUtils.avgStride=" + c5544a.m39097f() + "\n DriftUtils.maxStride=" + c5544a.m39090m() + "\n DriftUtils.limitMinStep=" + c5544a.m39093j() + "\n DriftUtils.minStep=" + c5544a.m39089n() + "\n DriftUtils.maxStep=" + c5544a.m39091l() + "\n DriftUtils.limitMaxStep=" + c5544a.m39094i() + "", new Object[0]);
        map.put("runType", Integer.valueOf(i));
        SettingSafe settingSafe = SettingSafe.f20547a;
        settingSafe.m38616d(jsonGet.m43759u(map, "developTips", settingSafe.m38619a()));
        if (jsonGet.m43768l(map, "isCheckDevelop", 1) == 1 && settingSafe.m38618b()) {
            SportsDataAgent.f19899a.m39277b0(true);
            Activity m39150a = ActivityManager.f20090a.m39150a();
            if (m39150a == null) {
                return;
            }
            ContextExt.m43850n(m39150a, settingSafe.m38619a(), C5885l.f21116a);
            return;
        }
        Map<String, Object> map2 = jsonGet.m43776d(map, "userOpenDevelop") ^ true ? map : null;
        if (map2 != null) {
            map2.put("userOpenDevelop", Boolean.valueOf(SportsDataAgent.f19899a.m39305B()));
        }
        this.f21073n.postValue(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public final void m38059T(Map<String, Object> map) {
        Map<String, ? extends Object> m8915J0;
        Map<String, Object> m8915J02;
        Map<String, ? extends Object> m8915J03;
        Map<String, Object> m8915J04;
        Map<String, ? extends Object> m8915J05;
        Map<String, Object> m8915J06;
        Map<String, ? extends Object> m8915J07;
        Map<String, Object> m8915J08;
        JsonGet jsonGet = JsonGet.f15134a;
        m8915J0 = C14239y0.m8915J0(map);
        m8915J02 = C14239y0.m8915J0(jsonGet.m43763q(m8915J0, "morningRun"));
        this.f21069j.postValue(m8915J02);
        m8915J03 = C14239y0.m8915J0(map);
        m8915J04 = C14239y0.m8915J0(jsonGet.m43763q(m8915J03, "sunRun"));
        this.f21070k.postValue(m8915J04);
        m8915J05 = C14239y0.m8915J0(map);
        m8915J06 = C14239y0.m8915J0(jsonGet.m43763q(m8915J05, "freedomRun"));
        this.f21071l.postValue(m8915J06);
        m8915J07 = C14239y0.m8915J0(map);
        m8915J08 = C14239y0.m8915J0(jsonGet.m43763q(m8915J07, "exerciseSite"));
        this.f21072m.postValue(m8915J08);
        if (C14342f0.m8193g("0", m8915J02.get("isShow")) && C14342f0.m8193g("0", m8915J04.get("isShow")) && C14342f0.m8193g("0", m8915J06.get("isShow"))) {
            m43953f().postValue("系统未开放跑步，请联系管理员");
        }
    }

    @NotNull
    /* renamed from: A */
    public final MutableLiveData<Map<String, Object>> m38078A() {
        return this.f21069j;
    }

    @NotNull
    /* renamed from: B */
    public final MutableLiveData<Map<String, Object>> m38077B() {
        return this.f21073n;
    }

    /* renamed from: C */
    public final void m38076C(int i) {
        TsnSecret tsnSecret = TsnSecret.f13210a;
        BaseApp m44341b = BaseApp.m44341b();
        C14342f0.m8185o(m44341b, "getApp()");
        if (!tsnSecret.checkSignature(m44341b)) {
            m43953f().postValue("系统内部错误，错误码【1001】");
        } else if (RootCheckUtils.f20129a.m39069d()) {
            m43953f().postValue("系统内部错误，错误码【1002】");
        } else if (EmulatorDetectUtil.m19668b(App.m43006n())) {
            m43953f().postValue("系统检查到当前运行环境为模拟器，请使用真机进行跑步");
        } else {
            BaseViewModel.m43949j(this, new C5874a(i, this, null), null, new C5875b(i, null), null, null, null, null, null, 250, null);
        }
    }

    /* renamed from: E */
    public final void m38074E() {
        BaseViewModel.m43949j(this, new C5876c(null), null, new C5877d(null), null, null, null, null, null, 250, null);
    }

    /* renamed from: F */
    public final void m38073F(@NotNull String identity) {
        C14342f0.m8184p(identity, "identity");
        BaseViewModel.m43949j(this, new C5878e(identity, null), null, new C5879f(null), null, null, null, null, null, 250, null);
    }

    @Nullable
    /* renamed from: G */
    public final Map<String, Object> m38072G(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        return this.f21068i.getValue();
                    }
                    return this.f21072m.getValue();
                }
                return this.f21069j.getValue();
            }
            return this.f21070k.getValue();
        }
        return this.f21071l.getValue();
    }

    @NotNull
    /* renamed from: H */
    public final MutableLiveData<Map<String, Object>> m38071H() {
        return this.f21070k;
    }

    @NotNull
    /* renamed from: I */
    public final MutableLiveData<List<SportsDb>> m38070I() {
        return this.f21074o;
    }

    /* renamed from: J */
    public final void m38069J() {
        BaseViewModel.m43947l(this, new C5880g(null), null, null, null, null, null, 62, null);
    }

    /* renamed from: K */
    public final void m38068K() {
        BaseViewModel.m43949j(this, new C5881h(null), null, null, null, null, null, null, null, DnsRecord.CLASS_NONE, null);
    }

    /* renamed from: L */
    public final void m38067L(@NotNull SportsDb sportsDb, @NotNull InterfaceC15269a<Unit> canContinue) {
        C14342f0.m8184p(sportsDb, "sportsDb");
        C14342f0.m8184p(canContinue, "canContinue");
        ArrayMap<String, Object> sportsSetMap = JsonParse.jsonToMap(sportsDb.m58121L());
        C14342f0.m8185o(sportsSetMap, "sportsSetMap");
        sportsSetMap.put("isFromLocalToContinue", Boolean.TRUE);
        if (JsonGet.f15134a.m43776d(sportsSetMap, "serverUnavailable")) {
            C11792j.m20469d("如果开始跑步的时候服务器不可用，恢复跑步的时候直接恢复跑步", new Object[0]);
            m38060S(sportsSetMap, Integer.parseInt(sportsDb.m58120M()));
            canContinue.invoke();
            return;
        }
        BaseViewModel.m43949j(this, new C5882i(sportsDb, sportsSetMap, canContinue, null), new C5883j(sportsDb, null), new C5884k(sportsSetMap, sportsDb, canContinue, null), null, null, null, null, null, 248, null);
    }

    /* renamed from: M */
    public final void m38066M(@NotNull MutableLiveData<List<SportsDb>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21075p = mutableLiveData;
    }

    /* renamed from: N */
    public final void m38065N(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21072m = mutableLiveData;
    }

    /* renamed from: O */
    public final void m38064O(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21071l = mutableLiveData;
    }

    /* renamed from: P */
    public final void m38063P(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21068i = mutableLiveData;
    }

    /* renamed from: Q */
    public final void m38062Q(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21069j = mutableLiveData;
    }

    /* renamed from: R */
    public final void m38061R(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21073n = mutableLiveData;
    }

    /* renamed from: U */
    public final void m38058U(@NotNull MutableLiveData<Map<String, Object>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21070k = mutableLiveData;
    }

    /* renamed from: V */
    public final void m38057V(@NotNull MutableLiveData<List<SportsDb>> mutableLiveData) {
        C14342f0.m8184p(mutableLiveData, "<set-?>");
        this.f21074o = mutableLiveData;
    }

    @NotNull
    /* renamed from: w */
    public final MutableLiveData<List<SportsDb>> m38053w() {
        return this.f21075p;
    }

    @NotNull
    /* renamed from: x */
    public final MutableLiveData<Map<String, Object>> m38052x() {
        return this.f21072m;
    }

    @NotNull
    /* renamed from: y */
    public final MutableLiveData<Map<String, Object>> m38051y() {
        return this.f21071l;
    }

    @NotNull
    /* renamed from: z */
    public final MutableLiveData<Map<String, Object>> m38050z() {
        return this.f21068i;
    }
}
