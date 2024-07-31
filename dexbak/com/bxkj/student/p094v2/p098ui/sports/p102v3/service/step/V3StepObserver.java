package com.bxkj.student.p094v2.p098ui.sports.p102v3.service.step;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.alibaba.fastjson.JSON;
import com.baidu.mobads.sdk.internal.C2658ck;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.p095db.AppDatabase;
import com.bxkj.student.p094v2.common.p095db.dao.SportsDao;
import com.bxkj.student.p094v2.common.utils.ActivityManager;
import com.bxkj.student.p094v2.common.utils.C5543h;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3NotificationManager;
import com.bxkj.student.run.app.step.accelerometer.StepCount;
import com.bxkj.student.run.app.step.accelerometer.StepValuePassListener;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.SportsDb;
import p581d0.VoiceUtils;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: V3StepObserver.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001b¢\u0006\u0004\b=\u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0007J\b\u0010\u0012\u001a\u00020\u0003H\u0007J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u00100R\u0016\u00104\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00103R\u0016\u00106\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00103R\u0016\u00107\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00103R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u00103R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010:R\u0016\u0010<\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00103¨\u0006>"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/hardware/SensorEventListener;", "Lkotlin/f1;", "k", "r", "h", "o", "p", "i", C7304t.f25048d, "", "countTime", "m", CampaignEx.JSON_KEY_AD_Q, "g", "e", "onCreate", "onDestroy", "Landroid/hardware/SensorEvent;", "event", "onSensorChanged", "Landroid/hardware/Sensor;", UMCommonContent.f37799ac, "", "accuracy", "onAccuracyChanged", "Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService;", "a", "Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService;", "j", "()Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService;", "n", "(Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService;)V", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/Timer;", "b", "Ljava/util/Timer;", "timer", "Ljava/util/TimerTask;", "c", "Ljava/util/TimerTask;", "timerTask", "Landroid/hardware/SensorManager;", "d", "Landroid/hardware/SensorManager;", "sensorManager", "", "Z", "hasRecord", "f", "I", "hasStepCount", "CURRENT_STEP", "preStepCount", "stepSensorType", "previousStepCount", "Lcom/bxkj/student/run/app/step/accelerometer/a;", "Lcom/bxkj/student/run/app/step/accelerometer/a;", "mStepCount", "exceptionTraceCount", "<init>", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class V3StepObserver implements LifecycleObserver, SensorEventListener {
    @NotNull

    /* renamed from: a */
    private V3StepService f20859a;
    @Nullable

    /* renamed from: b */
    private Timer f20860b;
    @Nullable

    /* renamed from: c */
    private TimerTask f20861c;
    @Nullable

    /* renamed from: d */
    private SensorManager f20862d;

    /* renamed from: e */
    private boolean f20863e;

    /* renamed from: f */
    private int f20864f;

    /* renamed from: g */
    private int f20865g;

    /* renamed from: h */
    private int f20866h;

    /* renamed from: i */
    private int f20867i;

    /* renamed from: j */
    private int f20868j;
    @Nullable

    /* renamed from: k */
    private StepCount f20869k;

    /* renamed from: l */
    private int f20870l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3StepObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$createRecorder$1", m8638f = "V3StepObserver.kt", m8637i = {}, m8636l = {250}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5827a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20871a;

        C5827a(InterfaceC14268c<? super C5827a> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5827a(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5827a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20871a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
                Object obj2 = c5481g.m39250v().get("runType");
                if (obj2 == null) {
                    obj2 = boxing.m8626f(1);
                }
                if (obj2 == null) {
                    obj2 = boxing.m8626f(1);
                }
                int parseInt = Integer.parseInt(obj2.toString());
                Object obj3 = c5481g.m39250v().get("identify");
                if (obj3 == null) {
                    obj3 = "";
                }
                String valueOf = String.valueOf(obj3);
                if (TextUtils.isEmpty(valueOf)) {
                    V3StepObserver.this.m38256j().stopSelf();
                    return Unit.f41048a;
                }
                String m43641u = LoggedInUser.f15182b.m43634a().m43641u();
                String valueOf2 = String.valueOf(parseInt);
                String jSONString = JSON.toJSONString(c5481g.m39250v());
                C14342f0.m8185o(jSONString, "toJSONString(SportsDataAgent.sportsSetMap)");
                String valueOf3 = String.valueOf(c5481g.m39248x());
                String valueOf4 = String.valueOf(c5481g.m39274d());
                String valueOf5 = String.valueOf(c5481g.m39270f());
                String valueOf6 = String.valueOf(c5481g.m39260l());
                String jSONString2 = JSON.toJSONString(c5481g.m39256p());
                C14342f0.m8185o(jSONString2, "toJSONString(SportsDataAgent.latLngList)");
                String jSONString3 = JSON.toJSONString(c5481g.m39262j());
                C14342f0.m8185o(jSONString3, "toJSONString(SportsDataA….getFinalStepCountList())");
                String jSONString4 = JSON.toJSONString(c5481g.m39253s());
                C14342f0.m8185o(jSONString4, "toJSONString(SportsDataAgent.okPointList)");
                String valueOf7 = String.valueOf(c5481g.m39264i().getValue());
                String valueOf8 = String.valueOf(c5481g.m39266h().getValue());
                String jSONString5 = JSON.toJSONString(c5481g.m39251u());
                C14342f0.m8185o(jSONString5, "toJSONString(SportsDataAgent.pauseLatLng)");
                SportsDb sportsDb = new SportsDb(valueOf, m43641u, valueOf2, jSONString, valueOf3, "", valueOf4, valueOf5, valueOf6, jSONString2, jSONString3, jSONString4, valueOf7, valueOf8, "0", "", "", "", "", "0", C2658ck.f8834d, jSONString5, String.valueOf(c5481g.m39306A()));
                SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
                if (mo39225l != null) {
                    SportsDb[] sportsDbArr = {sportsDb};
                    this.f20871a = 1;
                    if (mo39225l.mo39181b(sportsDbArr, this) == m8642h) {
                        return m8642h;
                    }
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
    /* compiled from: V3StepObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$recorderLocation$1", m8638f = "V3StepObserver.kt", m8637i = {}, m8636l = {264}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5828b extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20873a;

        C5828b(InterfaceC14268c<? super C5828b> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5828b(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5828b) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20873a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
                Object obj2 = c5481g.m39250v().get("identify");
                if (obj2 == null) {
                    obj2 = "";
                }
                if (TextUtils.isEmpty(String.valueOf(obj2))) {
                    V3StepObserver.this.m38256j().stopSelf();
                    return Unit.f41048a;
                }
                SportsDao mo39225l = AppDatabase.f19934a.m39228a().mo39225l();
                if (mo39225l != null) {
                    String valueOf = String.valueOf(c5481g.m39274d());
                    String valueOf2 = String.valueOf(c5481g.m39270f());
                    String valueOf3 = String.valueOf(c5481g.m39260l());
                    String jSONString = JSON.toJSONString(c5481g.m39256p());
                    C14342f0.m8185o(jSONString, "toJSONString(SportsDataAgent.latLngList)");
                    String jSONString2 = JSON.toJSONString(c5481g.m39262j());
                    C14342f0.m8185o(jSONString2, "toJSONString(SportsDataA….getFinalStepCountList())");
                    String jSONString3 = JSON.toJSONString(c5481g.m39253s());
                    C14342f0.m8185o(jSONString3, "toJSONString(SportsDataAgent.okPointList)");
                    String valueOf4 = String.valueOf(c5481g.m39264i().getValue());
                    String valueOf5 = String.valueOf(c5481g.m39266h().getValue());
                    String m43760t = JsonGet.f15134a.m43760t(c5481g.m39250v(), "identify");
                    String valueOf6 = String.valueOf(c5481g.m39268g());
                    String jSONString4 = JSON.toJSONString(c5481g.m39251u());
                    C14342f0.m8185o(jSONString4, "toJSONString(SportsDataAgent.pauseLatLng)");
                    String valueOf7 = String.valueOf(c5481g.m39306A());
                    this.f20873a = 1;
                    if (mo39225l.mo39178e(valueOf, valueOf2, valueOf3, jSONString, jSONString2, jSONString3, valueOf4, valueOf5, m43760t, valueOf6, jSONString4, valueOf7, this) == m8642h) {
                        return m8642h;
                    }
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
    /* compiled from: V3StepObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$showExceptionTraceDialog$1", m8638f = "V3StepObserver.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5829c extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20875a;

        C5829c(InterfaceC14268c<? super C5829c> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5829c(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5829c) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f20875a == 0) {
                C14294d0.m8596n(obj);
                Activity m39150a = ActivityManager.f20090a.m39150a();
                if (m39150a != null) {
                    String string = BaseApp.m44341b().getString(C4215R.C4224string.exception_trace_alert_msg);
                    C14342f0.m8185o(string, "getApp().getString(R.str…xception_trace_alert_msg)");
                    ContextExt.m43851m(m39150a, string);
                }
                Object systemService = V3StepObserver.this.m38256j().getSystemService("vibrator");
                if (systemService != null) {
                    ((Vibrator) systemService).vibrate(2000L);
                    return Unit.f41048a;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3StepObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$showExceptionTraceDialogConfirm$1", m8638f = "V3StepObserver.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5830d extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20877a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: V3StepObserver.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5831a extends Lambda implements InterfaceC15280l<iOSOneButtonDialog, Unit> {

            /* renamed from: a */
            public static final C5831a f20879a = new C5831a();

            C5831a() {
                super(1);
            }

            /* renamed from: a */
            public final void m38247a(@NotNull iOSOneButtonDialog it) {
                C14342f0.m8184p(it, "it");
                SportsDataAgent.f19899a.m39289R(false);
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(iOSOneButtonDialog iosonebuttondialog) {
                m38247a(iosonebuttondialog);
                return Unit.f41048a;
            }
        }

        C5830d(InterfaceC14268c<? super C5830d> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5830d(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5830d) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f20877a == 0) {
                C14294d0.m8596n(obj);
                SportsDataAgent.f19899a.m39289R(true);
                Activity m39150a = ActivityManager.f20090a.m39150a();
                if (m39150a != null) {
                    String string = BaseApp.m44341b().getString(C4215R.C4224string.exception_trace_alert_msg);
                    C14342f0.m8185o(string, "getApp().getString(R.str…xception_trace_alert_msg)");
                    iOSOneButtonDialog m43850n = ContextExt.m43850n(m39150a, string, C5831a.f20879a);
                    if (m43850n != null) {
                        m43850n.setOneButtonText("继续跑步");
                    }
                }
                Object systemService = V3StepObserver.this.m38256j().getSystemService("vibrator");
                if (systemService != null) {
                    ((Vibrator) systemService).vibrate(2000L);
                    return Unit.f41048a;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: V3StepObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/service/step/V3StepObserver$e", "Ljava/util/TimerTask;", "Lkotlin/f1;", "run", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5832e extends TimerTask {
        C5832e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
            if (!c5481g.m39304C()) {
                long m39274d = c5481g.m39274d() + 1;
                c5481g.m39293N(m39274d);
                c5481g.m39295L();
                String avgSpeed = FormatUtils.m39636a(c5481g.m39270f(), m39274d);
                String pace = FormatUtils.m39635b(c5481g.m39270f(), m39274d);
                C14342f0.m8185o(avgSpeed, "avgSpeed");
                c5481g.m39294M(avgSpeed);
                C14342f0.m8185o(pace, "pace");
                c5481g.m39275c0(pace);
                V3StepObserver.this.m38253m(m39274d);
                VoiceUtils.f40105a.m12843a(V3StepObserver.this.m38256j(), m39274d, c5481g.m39270f(), c5481g.m39247y());
                if (m39274d % 60 == 0) {
                    V3NotificationManager.f20856a.m38272a(V3StepObserver.this.m38256j());
                }
                V3NotificationManager.f20856a.m38269d(V3StepObserver.this.m38256j());
                V3StepObserver.this.m38258h();
            }
            V3StepObserver.this.m38254l();
        }
    }

    public V3StepObserver(@NotNull V3StepService service) {
        C14342f0.m8184p(service, "service");
        this.f20859a = service;
        this.f20867i = -1;
    }

    /* renamed from: e */
    private final void m38261e() {
        StepCount stepCount = new StepCount();
        this.f20869k = stepCount;
        stepCount.m39746f(this.f20865g);
        SensorManager sensorManager = this.f20862d;
        Sensor defaultSensor = sensorManager == null ? null : sensorManager.getDefaultSensor(1);
        SensorManager sensorManager2 = this.f20862d;
        C14342f0.m8187m(sensorManager2);
        StepCount stepCount2 = this.f20869k;
        boolean registerListener = sensorManager2.registerListener(stepCount2 != null ? stepCount2.m39750b() : null, defaultSensor, 1);
        StepCount stepCount3 = this.f20869k;
        if (stepCount3 != null) {
            stepCount3.m39749c(new StepValuePassListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.step.b
                @Override // com.bxkj.student.run.app.step.accelerometer.StepValuePassListener
                /* renamed from: a */
                public final void mo38207a(int i) {
                    V3StepObserver.m38260f(V3StepObserver.this, i);
                }
            });
        }
        if (registerListener) {
            C11792j.m20469d("加速度传感器可以使用", new Object[0]);
        } else {
            C11792j.m20469d("加速度传感器无法使用", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static final void m38260f(V3StepObserver this$0, int i) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.f20865g = i;
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        c5481g.m39263i0(i);
        c5481g.m39296K(this$0.f20865g);
    }

    /* renamed from: g */
    private final void m38259g() {
        SensorManager sensorManager = this.f20862d;
        Sensor defaultSensor = sensorManager == null ? null : sensorManager.getDefaultSensor(19);
        SensorManager sensorManager2 = this.f20862d;
        Sensor defaultSensor2 = sensorManager2 != null ? sensorManager2.getDefaultSensor(18) : null;
        if (defaultSensor != null) {
            this.f20867i = 19;
            SensorManager sensorManager3 = this.f20862d;
            if (sensorManager3 == null) {
                return;
            }
            sensorManager3.registerListener(this, defaultSensor, 0);
        } else if (defaultSensor2 != null) {
            this.f20867i = 18;
            SensorManager sensorManager4 = this.f20862d;
            if (sensorManager4 == null) {
                return;
            }
            sensorManager4.registerListener(this, defaultSensor2, 0);
        } else {
            C11792j.m20469d("Count sensor not available!", new Object[0]);
            m38261e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public final void m38258h() {
        JsonGet jsonGet = JsonGet.f15134a;
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        if (jsonGet.m43768l(c5481g.m39250v(), "isCheckExceptionTrace", 1) == 0) {
            return;
        }
        double m43773g = jsonGet.m43773g(c5481g.m39250v(), "exceptionRatio", 0.4d);
        if (c5481g.m39274d() == 30) {
            boolean m39099d = C5543h.f20113a.m39099d(c5481g.m39256p(), m43773g);
            C11792j.m20469d(C14342f0.m8216C("第一次检测isExceptionPoint=", Boolean.valueOf(m39099d)), new Object[0]);
            if (m39099d) {
                this.f20870l = 1;
                m38251o();
            }
        } else if (c5481g.m39274d() == 60) {
            boolean m39099d2 = C5543h.f20113a.m39099d(c5481g.m39256p(), m43773g);
            C11792j.m20469d(C14342f0.m8216C("第二次检测isExceptionPoint=", Boolean.valueOf(m39099d2)), new Object[0]);
            if (m39099d2) {
                if (this.f20870l == 1) {
                    m38250p();
                } else {
                    m38251o();
                }
            }
        }
    }

    /* renamed from: i */
    private final void m38257i() {
        C15111j.m4126f(LifecycleOwnerKt.getLifecycleScope(this.f20859a), Dispatchers.m5036c(), null, new C5827a(null), 2, null);
    }

    /* renamed from: k */
    private final void m38255k() {
        int m39247y = SportsDataAgent.f19899a.m39247y();
        this.f20865g = m39247y;
        this.f20866h = m39247y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public final void m38254l() {
        C15111j.m4126f(LifecycleOwnerKt.getLifecycleScope(this.f20859a), Dispatchers.m5036c(), null, new C5828b(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public final void m38253m(long j) {
        long j2 = 60;
        if (j % j2 == 0) {
            long j3 = j / j2;
            int i = this.f20865g - this.f20866h;
            SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
            if (c5481g.m39246z().size() < j3) {
                c5481g.m39246z().add(Integer.valueOf(i));
            } else {
                c5481g.m39246z().set(c5481g.m39246z().size() - 1, Integer.valueOf(c5481g.m39246z().get(c5481g.m39246z().size() - 1).intValue() + i));
            }
            this.f20866h = this.f20865g;
        }
    }

    /* renamed from: o */
    private final void m38251o() {
        C15111j.m4126f(LifecycleOwnerKt.getLifecycleScope(this.f20859a), Dispatchers.m5034e(), null, new C5829c(null), 2, null);
    }

    /* renamed from: p */
    private final void m38250p() {
        C15111j.m4126f(LifecycleOwnerKt.getLifecycleScope(this.f20859a), Dispatchers.m5034e(), null, new C5830d(null), 2, null);
    }

    /* renamed from: q */
    private final void m38249q() {
        if (this.f20862d != null) {
            this.f20862d = null;
        }
        Object systemService = this.f20859a.getSystemService(UMCommonContent.f37799ac);
        if (systemService != null) {
            this.f20862d = (SensorManager) systemService;
            if (Build.VERSION.SDK_INT >= 19) {
                m38259g();
                return;
            } else {
                m38261e();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    /* renamed from: r */
    private final void m38248r() {
        m38257i();
        this.f20861c = new C5832e();
        Timer timer = new Timer();
        timer.schedule(this.f20861c, 0L, 1000L);
        Unit unit = Unit.f41048a;
        this.f20860b = timer;
    }

    @NotNull
    /* renamed from: j */
    public final V3StepService m38256j() {
        return this.f20859a;
    }

    /* renamed from: n */
    public final void m38252n(@NotNull V3StepService v3StepService) {
        C14342f0.m8184p(v3StepService, "<set-?>");
        this.f20859a = v3StepService;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@Nullable Sensor sensor, int i) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        V3NotificationManager.f20856a.m38270c(this.f20859a, null);
        m38255k();
        m38248r();
        m38249q();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        TimerTask timerTask = this.f20861c;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.f20860b;
        if (timer != null) {
            timer.cancel();
        }
        SensorManager sensorManager = this.f20862d;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.f20859a.stopForeground(true);
        V3NotificationManager.f20856a.m38271b(this.f20859a);
        C11792j.m20469d("停止计步服务", new Object[0]);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent event) {
        C14342f0.m8184p(event, "event");
        int i = this.f20867i;
        if (i != 19) {
            if (i == 18) {
                if ((event.values[0] == 1.0f) && !SportsDataAgent.f19899a.m39304C()) {
                    this.f20865g++;
                }
                SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
                c5481g.m39263i0(this.f20865g);
                c5481g.m39296K(this.f20865g);
                return;
            }
            return;
        }
        int i2 = (int) event.values[0];
        if (!this.f20863e) {
            this.f20863e = true;
            this.f20864f = i2;
        } else {
            int i3 = i2 - this.f20864f;
            int i4 = i3 - this.f20868j;
            if (!SportsDataAgent.f19899a.m39304C()) {
                this.f20865g += i4;
            }
            this.f20868j = i3;
        }
        SportsDataAgent.C5481g c5481g2 = SportsDataAgent.f19899a;
        c5481g2.m39263i0(this.f20865g);
        c5481g2.m39296K(this.f20865g);
    }
}
