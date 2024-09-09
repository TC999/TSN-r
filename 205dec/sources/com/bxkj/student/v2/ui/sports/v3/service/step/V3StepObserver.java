package com.bxkj.student.v2.ui.sports.v3.service.step;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.data.b;
import com.bxkj.student.v2.common.data.c;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.utils.h;
import com.bxkj.student.v2.ui.sports.v3.service.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.j;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.q0;
import l1.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: V3StepObserver.kt */
@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001b\u00a2\u0006\u0004\b=\u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0007J\b\u0010\u0012\u001a\u00020\u0003H\u0007J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00100R\u0016\u00104\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00103R\u0016\u00106\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00103R\u0016\u00107\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00103R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00103R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010:R\u0016\u0010<\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00103\u00a8\u0006>"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/hardware/SensorEventListener;", "Lkotlin/f1;", "k", "r", "h", "o", "p", "i", "l", "", "countTime", "m", CampaignEx.JSON_KEY_AD_Q, "g", "e", "onCreate", "onDestroy", "Landroid/hardware/SensorEvent;", "event", "onSensorChanged", "Landroid/hardware/Sensor;", "sensor", "", "accuracy", "onAccuracyChanged", "Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService;", "a", "Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService;", "j", "()Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService;", "n", "(Lcom/bxkj/student/v2/ui/sports/v3/service/step/V3StepService;)V", "service", "Ljava/util/Timer;", "b", "Ljava/util/Timer;", "timer", "Ljava/util/TimerTask;", "c", "Ljava/util/TimerTask;", "timerTask", "Landroid/hardware/SensorManager;", "d", "Landroid/hardware/SensorManager;", "sensorManager", "", "Z", "hasRecord", "f", "I", "hasStepCount", "CURRENT_STEP", "preStepCount", "stepSensorType", "previousStepCount", "Lcom/bxkj/student/run/app/step/accelerometer/a;", "Lcom/bxkj/student/run/app/step/accelerometer/a;", "mStepCount", "exceptionTraceCount", "<init>", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class V3StepObserver implements LifecycleObserver, SensorEventListener {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private V3StepService f24278a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Timer f24279b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private TimerTask f24280c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private SensorManager f24281d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24282e;

    /* renamed from: f  reason: collision with root package name */
    private int f24283f;

    /* renamed from: g  reason: collision with root package name */
    private int f24284g;

    /* renamed from: h  reason: collision with root package name */
    private int f24285h;

    /* renamed from: i  reason: collision with root package name */
    private int f24286i;

    /* renamed from: j  reason: collision with root package name */
    private int f24287j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private com.bxkj.student.run.app.step.accelerometer.a f24288k;

    /* renamed from: l  reason: collision with root package name */
    private int f24289l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3StepObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$createRecorder$1", f = "V3StepObserver.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24290a;

        a(kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new a(cVar);
        }

        @Override // l1.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24290a;
            if (i4 == 0) {
                d0.n(obj);
                b.g gVar = com.bxkj.student.v2.common.data.b.a;
                Object obj2 = gVar.v().get("runType");
                if (obj2 == null) {
                    obj2 = kotlin.coroutines.jvm.internal.a.f(1);
                }
                if (obj2 == null) {
                    obj2 = kotlin.coroutines.jvm.internal.a.f(1);
                }
                int parseInt = Integer.parseInt(obj2.toString());
                Object obj3 = gVar.v().get("identify");
                if (obj3 == null) {
                    obj3 = "";
                }
                String valueOf = String.valueOf(obj3);
                if (TextUtils.isEmpty(valueOf)) {
                    V3StepObserver.this.j().stopSelf();
                    return f1.f55527a;
                }
                String u3 = com.bxkj.base.v2.data.a.b.a().u();
                String valueOf2 = String.valueOf(parseInt);
                String jSONString = JSON.toJSONString(gVar.v());
                f0.o(jSONString, "toJSONString(SportsDataAgent.sportsSetMap)");
                String valueOf3 = String.valueOf(gVar.x());
                String valueOf4 = String.valueOf(gVar.d());
                String valueOf5 = String.valueOf(gVar.f());
                String valueOf6 = String.valueOf(gVar.l());
                String jSONString2 = JSON.toJSONString(gVar.p());
                f0.o(jSONString2, "toJSONString(SportsDataAgent.latLngList)");
                String jSONString3 = JSON.toJSONString(gVar.j());
                f0.o(jSONString3, "toJSONString(SportsDataA\u2026.getFinalStepCountList())");
                String jSONString4 = JSON.toJSONString(gVar.s());
                f0.o(jSONString4, "toJSONString(SportsDataAgent.okPointList)");
                String valueOf7 = String.valueOf(gVar.i().getValue());
                String valueOf8 = String.valueOf(gVar.h().getValue());
                String jSONString5 = JSON.toJSONString(gVar.u());
                f0.o(jSONString5, "toJSONString(SportsDataAgent.pauseLatLng)");
                c0.c cVar = new c0.c(valueOf, u3, valueOf2, jSONString, valueOf3, "", valueOf4, valueOf5, valueOf6, jSONString2, jSONString3, jSONString4, valueOf7, valueOf8, "0", "", "", "", "", "0", "0.0", jSONString5, String.valueOf(gVar.A()));
                com.bxkj.student.v2.common.db.dao.e l4 = AppDatabase.f23168a.a().l();
                if (l4 != null) {
                    c0.c[] cVarArr = {cVar};
                    this.f24290a = 1;
                    if (l4.b(cVarArr, this) == h4) {
                        return h4;
                    }
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3StepObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$recorderLocation$1", f = "V3StepObserver.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24292a;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new b(cVar);
        }

        @Override // l1.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24292a;
            if (i4 == 0) {
                d0.n(obj);
                b.g gVar = com.bxkj.student.v2.common.data.b.a;
                Object obj2 = gVar.v().get("identify");
                if (obj2 == null) {
                    obj2 = "";
                }
                if (TextUtils.isEmpty(String.valueOf(obj2))) {
                    V3StepObserver.this.j().stopSelf();
                    return f1.f55527a;
                }
                com.bxkj.student.v2.common.db.dao.e l4 = AppDatabase.f23168a.a().l();
                if (l4 != null) {
                    String valueOf = String.valueOf(gVar.d());
                    String valueOf2 = String.valueOf(gVar.f());
                    String valueOf3 = String.valueOf(gVar.l());
                    String jSONString = JSON.toJSONString(gVar.p());
                    f0.o(jSONString, "toJSONString(SportsDataAgent.latLngList)");
                    String jSONString2 = JSON.toJSONString(gVar.j());
                    f0.o(jSONString2, "toJSONString(SportsDataA\u2026.getFinalStepCountList())");
                    String jSONString3 = JSON.toJSONString(gVar.s());
                    f0.o(jSONString3, "toJSONString(SportsDataAgent.okPointList)");
                    String valueOf4 = String.valueOf(gVar.i().getValue());
                    String valueOf5 = String.valueOf(gVar.h().getValue());
                    String t3 = l.f18624a.t(gVar.v(), "identify");
                    String valueOf6 = String.valueOf(gVar.g());
                    String jSONString4 = JSON.toJSONString(gVar.u());
                    f0.o(jSONString4, "toJSONString(SportsDataAgent.pauseLatLng)");
                    String valueOf7 = String.valueOf(gVar.A());
                    this.f24292a = 1;
                    if (l4.e(valueOf, valueOf2, valueOf3, jSONString, jSONString2, jSONString3, valueOf4, valueOf5, t3, valueOf6, jSONString4, valueOf7, this) == h4) {
                        return h4;
                    }
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3StepObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$showExceptionTraceDialog$1", f = "V3StepObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24294a;

        c(kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new c(cVar);
        }

        @Override // l1.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24294a == 0) {
                d0.n(obj);
                Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
                if (a4 != null) {
                    String string = BaseApp.b().getString(2131820787);
                    f0.o(string, "getApp().getString(R.str\u2026xception_trace_alert_msg)");
                    ContextExtKt.m(a4, string);
                }
                Object systemService = V3StepObserver.this.j().getSystemService("vibrator");
                if (systemService != null) {
                    ((Vibrator) systemService).vibrate(2000L);
                    return f1.f55527a;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3StepObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$showExceptionTraceDialogConfirm$1", f = "V3StepObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24296a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3StepObserver.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a extends Lambda implements l1.l<iOSOneButtonDialog, f1> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f24298a = new a();

            a() {
                super(1);
            }

            public final void a(@NotNull iOSOneButtonDialog it) {
                f0.p(it, "it");
                com.bxkj.student.v2.common.data.b.a.R(false);
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
                a(iosonebuttondialog);
                return f1.f55527a;
            }
        }

        d(kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new d(cVar);
        }

        @Override // l1.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((d) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24296a == 0) {
                d0.n(obj);
                com.bxkj.student.v2.common.data.b.a.R(true);
                Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
                if (a4 != null) {
                    String string = BaseApp.b().getString(2131820787);
                    f0.o(string, "getApp().getString(R.str\u2026xception_trace_alert_msg)");
                    iOSOneButtonDialog n4 = ContextExtKt.n(a4, string, a.f24298a);
                    if (n4 != null) {
                        n4.setOneButtonText("\u7ee7\u7eed\u8dd1\u6b65");
                    }
                }
                Object systemService = V3StepObserver.this.j().getSystemService("vibrator");
                if (systemService != null) {
                    ((Vibrator) systemService).vibrate(2000L);
                    return f1.f55527a;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3StepObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/service/step/V3StepObserver$e", "Ljava/util/TimerTask;", "Lkotlin/f1;", "run", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e extends TimerTask {
        e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b.g gVar = com.bxkj.student.v2.common.data.b.a;
            if (!gVar.C()) {
                long d4 = gVar.d() + 1;
                gVar.N(d4);
                gVar.L();
                String avgSpeed = i.a(gVar.f(), d4);
                String pace = i.b(gVar.f(), d4);
                f0.o(avgSpeed, "avgSpeed");
                gVar.M(avgSpeed);
                f0.o(pace, "pace");
                gVar.c0(pace);
                V3StepObserver.this.m(d4);
                d0.a.f54621a.a(V3StepObserver.this.j(), d4, gVar.f(), gVar.y());
                if (d4 % 60 == 0) {
                    g.f24275a.a(V3StepObserver.this.j());
                }
                g.f24275a.d(V3StepObserver.this.j());
                V3StepObserver.this.h();
            }
            V3StepObserver.this.l();
        }
    }

    public V3StepObserver(@NotNull V3StepService service) {
        f0.p(service, "service");
        this.f24278a = service;
        this.f24286i = -1;
    }

    private final void e() {
        com.bxkj.student.run.app.step.accelerometer.a aVar = new com.bxkj.student.run.app.step.accelerometer.a();
        this.f24288k = aVar;
        aVar.f(this.f24284g);
        SensorManager sensorManager = this.f24281d;
        Sensor defaultSensor = sensorManager == null ? null : sensorManager.getDefaultSensor(1);
        SensorManager sensorManager2 = this.f24281d;
        f0.m(sensorManager2);
        com.bxkj.student.run.app.step.accelerometer.a aVar2 = this.f24288k;
        boolean registerListener = sensorManager2.registerListener(aVar2 != null ? aVar2.b() : null, defaultSensor, 1);
        com.bxkj.student.run.app.step.accelerometer.a aVar3 = this.f24288k;
        if (aVar3 != null) {
            aVar3.c(new com.bxkj.student.run.app.step.accelerometer.d() { // from class: com.bxkj.student.v2.ui.sports.v3.service.step.b
                @Override // com.bxkj.student.run.app.step.accelerometer.d
                public final void a(int i4) {
                    V3StepObserver.f(V3StepObserver.this, i4);
                }
            });
        }
        if (registerListener) {
            j.d("\u52a0\u901f\u5ea6\u4f20\u611f\u5668\u53ef\u4ee5\u4f7f\u7528", new Object[0]);
        } else {
            j.d("\u52a0\u901f\u5ea6\u4f20\u611f\u5668\u65e0\u6cd5\u4f7f\u7528", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(V3StepObserver this$0, int i4) {
        f0.p(this$0, "this$0");
        this$0.f24284g = i4;
        c.g gVar = com.bxkj.student.v2.common.data.c.f23133a;
        gVar.i0(i4);
        gVar.K(this$0.f24284g);
    }

    private final void g() {
        SensorManager sensorManager = this.f24281d;
        Sensor defaultSensor = sensorManager == null ? null : sensorManager.getDefaultSensor(19);
        SensorManager sensorManager2 = this.f24281d;
        Sensor defaultSensor2 = sensorManager2 != null ? sensorManager2.getDefaultSensor(18) : null;
        if (defaultSensor != null) {
            this.f24286i = 19;
            SensorManager sensorManager3 = this.f24281d;
            if (sensorManager3 == null) {
                return;
            }
            sensorManager3.registerListener(this, defaultSensor, 0);
        } else if (defaultSensor2 != null) {
            this.f24286i = 18;
            SensorManager sensorManager4 = this.f24281d;
            if (sensorManager4 == null) {
                return;
            }
            sensorManager4.registerListener(this, defaultSensor2, 0);
        } else {
            j.d("Count sensor not available!", new Object[0]);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        m mVar = m.a;
        c.g gVar = com.bxkj.student.v2.common.data.c.f23133a;
        if (mVar.l(gVar.v(), "isCheckExceptionTrace", 1) == 0) {
            return;
        }
        double g4 = mVar.g(gVar.v(), "exceptionRatio", 0.4d);
        if (gVar.d() == 30) {
            boolean d4 = h.f23357a.d(gVar.p(), g4);
            j.d(f0.C("\u7b2c\u4e00\u6b21\u68c0\u6d4bisExceptionPoint=", Boolean.valueOf(d4)), new Object[0]);
            if (d4) {
                this.f24289l = 1;
                o();
            }
        } else if (gVar.d() == 60) {
            boolean d5 = h.f23357a.d(gVar.p(), g4);
            j.d(f0.C("\u7b2c\u4e8c\u6b21\u68c0\u6d4bisExceptionPoint=", Boolean.valueOf(d5)), new Object[0]);
            if (d5) {
                if (this.f24289l == 1) {
                    p();
                } else {
                    o();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$a, d2.p] */
    private final void i() {
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(this.f24278a), kotlinx.coroutines.f1.c(), null, new a(null), 2, null);
    }

    private final void k() {
        int y3 = com.bxkj.student.v2.common.data.c.f23133a.y();
        this.f24284g = y3;
        this.f24285h = y3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$b, d2.p] */
    public final void l() {
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(this.f24278a), kotlinx.coroutines.f1.c(), null, new b(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(long j4) {
        long j5 = 60;
        if (j4 % j5 == 0) {
            long j6 = j4 / j5;
            int i4 = this.f24284g - this.f24285h;
            c.g gVar = com.bxkj.student.v2.common.data.c.f23133a;
            if (gVar.z().size() < j6) {
                gVar.z().add(Integer.valueOf(i4));
            } else {
                gVar.z().set(gVar.z().size() - 1, Integer.valueOf(gVar.z().get(gVar.z().size() - 1).intValue() + i4));
            }
            this.f24285h = this.f24284g;
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$c, d2.p] */
    private final void o() {
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(this.f24278a), kotlinx.coroutines.f1.e(), null, new c(null), 2, null);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$d, d2.p] */
    private final void p() {
        kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(this.f24278a), kotlinx.coroutines.f1.e(), null, new d(null), 2, null);
    }

    private final void q() {
        if (this.f24281d != null) {
            this.f24281d = null;
        }
        Object systemService = this.f24278a.getSystemService("sensor");
        if (systemService != null) {
            this.f24281d = (SensorManager) systemService;
            if (Build.VERSION.SDK_INT >= 19) {
                g();
                return;
            } else {
                e();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    private final void r() {
        i();
        this.f24280c = new e();
        Timer timer = new Timer();
        timer.schedule(this.f24280c, 0L, 1000L);
        f1 f1Var = f1.f55527a;
        this.f24279b = timer;
    }

    @NotNull
    public final V3StepService j() {
        return this.f24278a;
    }

    public final void n(@NotNull V3StepService v3StepService) {
        f0.p(v3StepService, "<set-?>");
        this.f24278a = v3StepService;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@Nullable Sensor sensor, int i4) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        g.f24275a.c(this.f24278a, null);
        k();
        r();
        q();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        TimerTask timerTask = this.f24280c;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.f24279b;
        if (timer != null) {
            timer.cancel();
        }
        SensorManager sensorManager = this.f24281d;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.f24278a.stopForeground(true);
        g.f24275a.b(this.f24278a);
        j.d("\u505c\u6b62\u8ba1\u6b65\u670d\u52a1", new Object[0]);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent event) {
        f0.p(event, "event");
        int i4 = this.f24286i;
        if (i4 != 19) {
            if (i4 == 18) {
                if ((event.values[0] == 1.0f) && !com.bxkj.student.v2.common.data.c.f23133a.C()) {
                    this.f24284g++;
                }
                c.g gVar = com.bxkj.student.v2.common.data.c.f23133a;
                gVar.i0(this.f24284g);
                gVar.K(this.f24284g);
                return;
            }
            return;
        }
        int i5 = (int) event.values[0];
        if (!this.f24282e) {
            this.f24282e = true;
            this.f24283f = i5;
        } else {
            int i6 = i5 - this.f24283f;
            int i7 = i6 - this.f24287j;
            if (!com.bxkj.student.v2.common.data.c.f23133a.C()) {
                this.f24284g += i7;
            }
            this.f24287j = i6;
        }
        c.g gVar2 = com.bxkj.student.v2.common.data.c.f23133a;
        gVar2.i0(this.f24284g);
        gVar2.K(this.f24284g);
    }
}
