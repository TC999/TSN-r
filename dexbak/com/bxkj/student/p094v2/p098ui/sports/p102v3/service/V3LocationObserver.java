package com.bxkj.student.p094v2.p098ui.sports.p102v3.service;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.p094v2.common.data.PointData;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.utils.ActivityManager;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3NotificationManager;
import com.bxkj.student.p094v2.p098ui.sports.safe.SettingSafe;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: V3LocationObserver.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0007J\b\u0010\r\u001a\u00020\u0002H\u0007R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0016\u0010,\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010%R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3LocationObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f1;", "h", "Lcom/amap/api/location/AMapLocationClientOption;", "f", "Lcom/amap/api/location/AMapLocation;", SocializeConstants.KEY_LOCATION, C7304t.f25048d, "m", "(Lcom/amap/api/location/AMapLocation;Lkotlin/coroutines/c;)Ljava/lang/Object;", "n", "onCreate", "onDestroy", "Landroidx/lifecycle/LifecycleService;", "a", "Landroidx/lifecycle/LifecycleService;", "g", "()Landroidx/lifecycle/LifecycleService;", NotificationCompat.CATEGORY_SERVICE, "Lcom/amap/api/location/AMapLocationClient;", "b", "Lcom/amap/api/location/AMapLocationClient;", "locationClient", "Lcom/amap/api/maps/model/LatLng;", "c", "Lcom/amap/api/maps/model/LatLng;", "currentLatLng", "Lcom/bxkj/student/v2/common/data/PointData;", "d", "Lcom/bxkj/student/v2/common/data/PointData;", "lastPoint", "", "e", "Z", "firstMostAccuracySuccess", "", "I", "defaultAccuracy", "lastLossPoint", "", "D", "lastLossDistance", "i", "resumeNormalPointCount", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "j", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "devDialog", "<init>", "(Landroidx/lifecycle/LifecycleService;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class V3LocationObserver implements LifecycleObserver {
    @NotNull

    /* renamed from: a */
    private final LifecycleService f20775a;
    @Nullable

    /* renamed from: b */
    private AMapLocationClient f20776b;

    /* renamed from: c */
    private LatLng f20777c;
    @Nullable

    /* renamed from: d */
    private PointData f20778d;

    /* renamed from: e */
    private boolean f20779e;

    /* renamed from: f */
    private final int f20780f;
    @Nullable

    /* renamed from: g */
    private PointData f20781g;

    /* renamed from: h */
    private double f20782h;

    /* renamed from: i */
    private int f20783i;
    @Nullable

    /* renamed from: j */
    private iOSOneButtonDialog f20784j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3LocationObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationChangeListener$1", m8638f = "V3LocationObserver.kt", m8637i = {}, m8636l = {219}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5804a extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20785a;

        /* renamed from: c */
        final /* synthetic */ AMapLocation f20787c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5804a(AMapLocation aMapLocation, InterfaceC14268c<? super C5804a> interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f20787c = aMapLocation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5804a(this.f20787c, interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5804a) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f20785a;
            if (i == 0) {
                C14294d0.m8596n(obj);
                V3LocationObserver v3LocationObserver = V3LocationObserver.this;
                AMapLocation aMapLocation = this.f20787c;
                this.f20785a = 1;
                if (v3LocationObserver.m38317m(aMapLocation, this) == m8642h) {
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

    /* compiled from: V3LocationObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$11$1", m8638f = "V3LocationObserver.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5805b extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20788a;

        C5805b(InterfaceC14268c<? super C5805b> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5805b(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5805b) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f20788a == 0) {
                C14294d0.m8596n(obj);
                Activity m39150a = ActivityManager.f20090a.m39150a();
                if (m39150a == null) {
                    return null;
                }
                ContextExt.m43848p(m39150a, "超过10秒未获取到定位点");
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: V3LocationObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$13$1", m8638f = "V3LocationObserver.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5806c extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20789a;

        C5806c(InterfaceC14268c<? super C5806c> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5806c(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5806c) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f20789a == 0) {
                C14294d0.m8596n(obj);
                Activity m39150a = ActivityManager.f20090a.m39150a();
                if (m39150a == null) {
                    return null;
                }
                ContextExt.m43847q(m39150a, "扔掉第" + V3LocationObserver.this.f20783i + "个点");
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: V3LocationObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$15$1", m8638f = "V3LocationObserver.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5807d extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20791a;

        C5807d(InterfaceC14268c<? super C5807d> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5807d(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5807d) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f20791a == 0) {
                C14294d0.m8596n(obj);
                Activity m39150a = ActivityManager.f20090a.m39150a();
                if (m39150a == null) {
                    return null;
                }
                ContextExt.m43847q(m39150a, "恢复10个定位点后补偿距离算法");
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: V3LocationObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, m12616d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$17$1", m8638f = "V3LocationObserver.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5808e extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        int f20792a;

        C5808e(InterfaceC14268c<? super C5808e> interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            return new C5808e(interfaceC14268c);
        }

        @Override // p617l1.InterfaceC15284p
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C5808e) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f20792a == 0) {
                C14294d0.m8596n(obj);
                Activity m39150a = ActivityManager.f20090a.m39150a();
                if (m39150a == null) {
                    return null;
                }
                ContextExt.m43847q(m39150a, "中途出现了暂停的点，将丢失的点位置空，重新按规则计算");
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3LocationObserver.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    @DebugMetadata(m8639c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver", m8638f = "V3LocationObserver.kt", m8637i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, m8636l = {369, 380, 402, TTAdConstant.LIVE_AD_CODE}, m8635m = "onLocationSuccessListener", m8634n = {"this", "curPoint", "distance", "appendDistance", "countTime", "gpsDistance", "this", "curPoint", "distance", "appendDistance", "countTime", "gpsDistance", "this", "curPoint", "distance", "appendDistance", "countTime", "gpsDistance", "this", "curPoint", "distance", "appendDistance", "countTime", "gpsDistance"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "J$0", "D$0", "L$0", "L$1", "L$2", "L$3", "J$0", "D$0", "L$0", "L$1", "L$2", "L$3", "J$0", "D$0", "L$0", "L$1", "L$2", "L$3", "J$0", "D$0"})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5809f extends ContinuationImpl {

        /* renamed from: a */
        Object f20793a;

        /* renamed from: b */
        Object f20794b;

        /* renamed from: c */
        Object f20795c;

        /* renamed from: d */
        Object f20796d;

        /* renamed from: e */
        long f20797e;

        /* renamed from: f */
        double f20798f;

        /* renamed from: g */
        /* synthetic */ Object f20799g;

        /* renamed from: i */
        int f20801i;

        C5809f(InterfaceC14268c<? super C5809f> interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20799g = obj;
            this.f20801i |= Integer.MIN_VALUE;
            return V3LocationObserver.this.m38317m(null, this);
        }
    }

    public V3LocationObserver(@NotNull LifecycleService service) {
        C14342f0.m8184p(service, "service");
        this.f20775a = service;
        this.f20780f = 100;
    }

    /* renamed from: f */
    private final AMapLocationClientOption m38324f() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport);
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setGpsFirst(true);
        aMapLocationClientOption.setHttpTimeOut(30000L);
        aMapLocationClientOption.setInterval(1000L);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setOnceLocation(false);
        aMapLocationClientOption.setOnceLocationLatest(false);
        aMapLocationClientOption.setSensorEnable(true);
        aMapLocationClientOption.setWifiScan(true);
        aMapLocationClientOption.setLocationCacheEnable(true);
        aMapLocationClientOption.setMockEnable(false);
        return aMapLocationClientOption;
    }

    /* renamed from: h */
    private final void m38322h() {
        AMapLocationClient aMapLocationClient = new AMapLocationClient(StubApp.getOrigApplicationContext(this.f20775a.getApplicationContext()));
        aMapLocationClient.setLocationOption(m38324f());
        aMapLocationClient.setLocationListener(new AMapLocationListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.d
            @Override // com.amap.api.location.AMapLocationListener
            public final void onLocationChanged(AMapLocation aMapLocation) {
                V3LocationObserver.m38321i(V3LocationObserver.this, aMapLocation);
            }
        });
        Unit unit = Unit.f41048a;
        this.f20776b = aMapLocationClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static final void m38321i(final V3LocationObserver this$0, AMapLocation aMapLocation) {
        iOSOneButtonDialog m43851m;
        C14342f0.m8184p(this$0, "this$0");
        if (aMapLocation == null) {
            return;
        }
        JsonGet jsonGet = JsonGet.f15134a;
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        if (jsonGet.m43768l(c5481g.m39250v(), "isCheckDevelop", 1) == 1) {
            SettingSafe settingSafe = SettingSafe.f20547a;
            if (settingSafe.m38618b()) {
                c5481g.m39282Y(true);
                iOSOneButtonDialog iosonebuttondialog = this$0.f20784j;
                iOSOneButtonDialog iosonebuttondialog2 = null;
                C11792j.m20469d(C14342f0.m8216C("devDialog?.isShowing=", iosonebuttondialog == null ? null : Boolean.valueOf(iosonebuttondialog.isShowing())), new Object[0]);
                iOSOneButtonDialog iosonebuttondialog3 = this$0.f20784j;
                if (iosonebuttondialog3 != null) {
                    if (!((iosonebuttondialog3 == null || iosonebuttondialog3.isShowing()) ? false : true)) {
                        return;
                    }
                }
                c5481g.m39279a0(c5481g.m39306A() + 1);
                String m38619a = settingSafe.m38619a();
                V3NotificationManager.C5826a c5826a = V3NotificationManager.f20856a;
                BaseApp m44341b = BaseApp.m44341b();
                C14342f0.m8185o(m44341b, "getApp()");
                V3NotificationManager.C5826a.m38267f(c5826a, m44341b, m38619a, false, 4, null);
                Activity m39150a = ActivityManager.f20090a.m39150a();
                if (m39150a != null && (m43851m = ContextExt.m43851m(m39150a, m38619a)) != null) {
                    m43851m.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            V3LocationObserver.m38320j(view);
                        }
                    });
                    m43851m.setClickAutoCancel(false);
                    m43851m.setCancelable(false);
                    m43851m.setCanceledOnTouchOutside(false);
                    m43851m.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.b
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            V3LocationObserver.m38319k(V3LocationObserver.this, dialogInterface);
                        }
                    });
                    Unit unit = Unit.f41048a;
                    iosonebuttondialog2 = m43851m;
                }
                this$0.f20784j = iosonebuttondialog2;
                return;
            }
        }
        iOSOneButtonDialog iosonebuttondialog4 = this$0.f20784j;
        if (iosonebuttondialog4 != null) {
            iosonebuttondialog4.dismiss();
        }
        c5481g.m39282Y(false);
        this$0.m38318l(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final void m38320j(View view) {
        SettingSafe.f20547a.m38617c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static final void m38319k(V3LocationObserver this$0, DialogInterface dialogInterface) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.f20784j = null;
    }

    /* renamed from: l */
    private final void m38318l(AMapLocation aMapLocation) {
        String gpsStatus = FormatUtils.m39627j(aMapLocation.getLocationQualityReport().getGPSStatus(), aMapLocation.getGpsAccuracyStatus());
        int m39626k = FormatUtils.m39626k(aMapLocation.getGpsAccuracyStatus());
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        c5481g.m39285V(aMapLocation.getGpsAccuracyStatus());
        C14342f0.m8185o(gpsStatus, "gpsStatus");
        c5481g.m39283X(gpsStatus);
        c5481g.m39284W(m39626k);
        c5481g.m39300G(gpsStatus, m39626k);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("回调时间:");
        sb.append(FormatUtils.m39629h(currentTimeMillis, "yyyy-MM-dd HH:mm:ss"));
        sb.append(ShellAdbUtils.f33810d);
        if (aMapLocation.getErrorCode() == 0) {
            sb.append("定位成功\n");
            sb.append("定位类型:" + aMapLocation.getLocationType() + " \n");
            sb.append("经\u3000\u3000度:" + aMapLocation.getLongitude() + " \n");
            sb.append("纬\u3000\u3000度:" + aMapLocation.getLatitude() + " \n");
            sb.append("精\u3000\u3000度:" + aMapLocation.getAccuracy() + " \n");
            sb.append("提供者\u3000:" + ((Object) aMapLocation.getProvider()) + " \n");
            sb.append("速\u3000\u3000度:" + aMapLocation.getSpeed() + " \n");
            sb.append("角\u3000\u3000度:" + aMapLocation.getBearing() + " \n");
            sb.append("星\u3000\u3000数:" + aMapLocation.getSatellites() + " \n");
            sb.append("国\u3000\u3000家:" + ((Object) aMapLocation.getCountry()) + " \n");
            sb.append("省\u3000\u3000\u3000:" + ((Object) aMapLocation.getProvince()) + " \n");
            sb.append("市\u3000\u3000\u3000:" + ((Object) aMapLocation.getCity()) + " \n");
            sb.append("城市编码:" + ((Object) aMapLocation.getCityCode()) + " \n");
            sb.append("区\u3000\u3000\u3000:" + ((Object) aMapLocation.getDistrict()) + " \n");
            sb.append("区域码\u3000:" + ((Object) aMapLocation.getAdCode()) + " \n");
            sb.append("地\u3000\u3000址:" + ((Object) aMapLocation.getAddress()) + " \n");
            sb.append("兴趣点\u3000:" + ((Object) aMapLocation.getPoiName()) + " \n");
            sb.append("定位时间:" + ((Object) FormatUtils.m39629h(aMapLocation.getTime(), "yyyy-MM-dd HH:mm:ss")) + " \n");
            C15111j.m4126f(LifecycleOwnerKt.getLifecycleScope(this.f20775a), Dispatchers.m5038a(), null, new C5804a(aMapLocation, null), 2, null);
        } else {
            sb.append("定位失败\n");
            sb.append("错误码\u3000:" + aMapLocation.getErrorCode() + '\n');
            sb.append("错误信息:" + ((Object) aMapLocation.getErrorInfo()) + '\n');
            sb.append("错误描述:" + ((Object) aMapLocation.getLocationDetail()) + '\n');
            C11792j.m20469d(sb.toString(), new Object[0]);
        }
        sb.append("***定位质量报告***\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("* WIFI开关：");
        sb2.append(aMapLocation.getLocationQualityReport().isWifiAble() ? "开启" : "关闭");
        sb2.append('\n');
        sb.append(sb2.toString());
        sb.append("* GPS状态：" + ((Object) FormatUtils.m39624m(aMapLocation.getLocationQualityReport().getGPSStatus())) + '\n');
        sb.append("* GPS星数：" + aMapLocation.getLocationQualityReport().getGPSSatellites() + '\n');
        sb.append("****************\n");
        C14342f0.m8185o(sb.toString(), "sb.toString()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m38317m(com.amap.api.location.AMapLocation r32, kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r33) {
        /*
            Method dump skipped, instructions count: 1240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3LocationObserver.m38317m(com.amap.api.location.AMapLocation, kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: n */
    private final void m38316n() {
        C11792j.m20469d("开启前台服务广播", new Object[0]);
        AMapLocationClient aMapLocationClient = this.f20776b;
        if (aMapLocationClient == null) {
            return;
        }
        V3NotificationManager.f20856a.m38270c(m38323g(), aMapLocationClient);
    }

    @NotNull
    /* renamed from: g */
    public final LifecycleService m38323g() {
        return this.f20775a;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        C11792j.m20469d("开启定位监听startGetLocation", new Object[0]);
        m38322h();
        AMapLocationClient aMapLocationClient = this.f20776b;
        if (aMapLocationClient == null) {
            return;
        }
        aMapLocationClient.stopLocation();
        aMapLocationClient.startLocation();
        m38316n();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        C11792j.m20469d("停止定位服务", new Object[0]);
        AMapLocationClient aMapLocationClient = this.f20776b;
        if (aMapLocationClient != null) {
            aMapLocationClient.disableBackgroundLocation(true);
            aMapLocationClient.stopLocation();
            aMapLocationClient.onDestroy();
        }
        this.f20775a.stopForeground(true);
        V3NotificationManager.f20856a.m38271b(this.f20775a);
    }
}
