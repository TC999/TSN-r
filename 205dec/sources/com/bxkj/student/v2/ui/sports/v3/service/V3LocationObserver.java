package com.bxkj.student.v2.ui.sports.v3.service;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
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
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.c;
import com.bxkj.student.v2.ui.sports.v3.service.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.q0;
import l1.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: V3LocationObserver.kt */
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0007J\b\u0010\r\u001a\u00020\u0002H\u0007R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010)R\u0016\u0010,\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00063"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3LocationObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f1;", "h", "Lcom/amap/api/location/AMapLocationClientOption;", "f", "Lcom/amap/api/location/AMapLocation;", "location", "l", "m", "(Lcom/amap/api/location/AMapLocation;Lkotlin/coroutines/c;)Ljava/lang/Object;", "n", "onCreate", "onDestroy", "Landroidx/lifecycle/LifecycleService;", "a", "Landroidx/lifecycle/LifecycleService;", "g", "()Landroidx/lifecycle/LifecycleService;", "service", "Lcom/amap/api/location/AMapLocationClient;", "b", "Lcom/amap/api/location/AMapLocationClient;", "locationClient", "Lcom/amap/api/maps/model/LatLng;", "c", "Lcom/amap/api/maps/model/LatLng;", "currentLatLng", "Lcom/bxkj/student/v2/common/data/PointData;", "d", "Lcom/bxkj/student/v2/common/data/PointData;", "lastPoint", "", "e", "Z", "firstMostAccuracySuccess", "", "I", "defaultAccuracy", "lastLossPoint", "", "D", "lastLossDistance", "i", "resumeNormalPointCount", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "j", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "devDialog", "<init>", "(Landroidx/lifecycle/LifecycleService;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class V3LocationObserver implements LifecycleObserver {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleService f24194a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private AMapLocationClient f24195b;

    /* renamed from: c  reason: collision with root package name */
    private LatLng f24196c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private PointData f24197d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24198e;

    /* renamed from: f  reason: collision with root package name */
    private final int f24199f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private PointData f24200g;

    /* renamed from: h  reason: collision with root package name */
    private double f24201h;

    /* renamed from: i  reason: collision with root package name */
    private int f24202i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private iOSOneButtonDialog f24203j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3LocationObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationChangeListener$1", f = "V3LocationObserver.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24204a;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AMapLocation f24206c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AMapLocation aMapLocation, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f24206c = aMapLocation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f24206c, cVar);
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
            int i4 = this.f24204a;
            if (i4 == 0) {
                d0.n(obj);
                V3LocationObserver v3LocationObserver = V3LocationObserver.this;
                AMapLocation aMapLocation = this.f24206c;
                this.f24204a = 1;
                if (v3LocationObserver.m(aMapLocation, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3LocationObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$11$1", f = "V3LocationObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24207a;

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
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24207a == 0) {
                d0.n(obj);
                Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
                if (a4 == null) {
                    return null;
                }
                ContextExtKt.p(a4, "\u8d85\u8fc710\u79d2\u672a\u83b7\u53d6\u5230\u5b9a\u4f4d\u70b9");
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3LocationObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$13$1", f = "V3LocationObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class c extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24208a;

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
            if (this.f24208a == 0) {
                d0.n(obj);
                Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
                if (a4 == null) {
                    return null;
                }
                ContextExtKt.q(a4, "\u6254\u6389\u7b2c" + V3LocationObserver.this.f24202i + "\u4e2a\u70b9");
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3LocationObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$15$1", f = "V3LocationObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class d extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24210a;

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
            if (this.f24210a == 0) {
                d0.n(obj);
                Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
                if (a4 == null) {
                    return null;
                }
                ContextExtKt.q(a4, "\u6062\u590d10\u4e2a\u5b9a\u4f4d\u70b9\u540e\u8865\u507f\u8ddd\u79bb\u7b97\u6cd5");
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3LocationObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$17$1", f = "V3LocationObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24211a;

        e(kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new e(cVar);
        }

        @Override // l1.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((e) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f24211a == 0) {
                d0.n(obj);
                Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
                if (a4 == null) {
                    return null;
                }
                ContextExtKt.q(a4, "\u4e2d\u9014\u51fa\u73b0\u4e86\u6682\u505c\u7684\u70b9\uff0c\u5c06\u4e22\u5931\u7684\u70b9\u4f4d\u7f6e\u7a7a\uff0c\u91cd\u65b0\u6309\u89c4\u5219\u8ba1\u7b97");
                return f1.f55527a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3LocationObserver.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver", f = "V3LocationObserver.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 402, 416}, m = "onLocationSuccessListener", n = {"this", "curPoint", "distance", "appendDistance", "countTime", "gpsDistance", "this", "curPoint", "distance", "appendDistance", "countTime", "gpsDistance", "this", "curPoint", "distance", "appendDistance", "countTime", "gpsDistance", "this", "curPoint", "distance", "appendDistance", "countTime", "gpsDistance"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "D$0", "L$0", "L$1", "L$2", "L$3", "J$0", "D$0", "L$0", "L$1", "L$2", "L$3", "J$0", "D$0", "L$0", "L$1", "L$2", "L$3", "J$0", "D$0"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        Object f24212a;

        /* renamed from: b  reason: collision with root package name */
        Object f24213b;

        /* renamed from: c  reason: collision with root package name */
        Object f24214c;

        /* renamed from: d  reason: collision with root package name */
        Object f24215d;

        /* renamed from: e  reason: collision with root package name */
        long f24216e;

        /* renamed from: f  reason: collision with root package name */
        double f24217f;

        /* renamed from: g  reason: collision with root package name */
        /* synthetic */ Object f24218g;

        /* renamed from: i  reason: collision with root package name */
        int f24220i;

        f(kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f24218g = obj;
            this.f24220i |= Integer.MIN_VALUE;
            return V3LocationObserver.this.m(null, this);
        }
    }

    public V3LocationObserver(@NotNull LifecycleService service) {
        f0.p(service, "service");
        this.f24194a = service;
        this.f24199f = 100;
    }

    private final AMapLocationClientOption f() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport);
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setGpsFirst(true);
        aMapLocationClientOption.setHttpTimeOut(PolicyConfig.mServerBusyRetryBaseInternal);
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

    private final void h() {
        AMapLocationClient aMapLocationClient = new AMapLocationClient(StubApp.getOrigApplicationContext(this.f24194a.getApplicationContext()));
        aMapLocationClient.setLocationOption(f());
        aMapLocationClient.setLocationListener(new AMapLocationListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.d
            @Override // com.amap.api.location.AMapLocationListener
            public final void onLocationChanged(AMapLocation aMapLocation) {
                V3LocationObserver.i(V3LocationObserver.this, aMapLocation);
            }
        });
        f1 f1Var = f1.f55527a;
        this.f24195b = aMapLocationClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final V3LocationObserver this$0, AMapLocation aMapLocation) {
        iOSOneButtonDialog m4;
        f0.p(this$0, "this$0");
        if (aMapLocation == null) {
            return;
        }
        m mVar = m.a;
        c.g gVar = com.bxkj.student.v2.common.data.c.f23133a;
        if (mVar.l(gVar.v(), "isCheckDevelop", 1) == 1) {
            com.bxkj.student.v2.ui.sports.safe.b bVar = com.bxkj.student.v2.ui.sports.safe.b.f23945a;
            if (bVar.b()) {
                gVar.Y(true);
                iOSOneButtonDialog iosonebuttondialog = this$0.f24203j;
                iOSOneButtonDialog iosonebuttondialog2 = null;
                j.d(f0.C("devDialog?.isShowing=", iosonebuttondialog == null ? null : Boolean.valueOf(iosonebuttondialog.isShowing())), new Object[0]);
                iOSOneButtonDialog iosonebuttondialog3 = this$0.f24203j;
                if (iosonebuttondialog3 != null) {
                    if (!((iosonebuttondialog3 == null || iosonebuttondialog3.isShowing()) ? false : true)) {
                        return;
                    }
                }
                gVar.a0(gVar.A() + 1);
                String a4 = bVar.a();
                g.a aVar = g.f24275a;
                BaseApp b4 = BaseApp.b();
                f0.o(b4, "getApp()");
                g.a.f(aVar, b4, a4, false, 4, null);
                Activity a5 = com.bxkj.student.v2.common.utils.a.f23334a.a();
                if (a5 != null && (m4 = ContextExtKt.m(a5, a4)) != null) {
                    m4.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            V3LocationObserver.j(view);
                        }
                    });
                    m4.setClickAutoCancel(false);
                    m4.setCancelable(false);
                    m4.setCanceledOnTouchOutside(false);
                    m4.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.b
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            V3LocationObserver.k(V3LocationObserver.this, dialogInterface);
                        }
                    });
                    f1 f1Var = f1.f55527a;
                    iosonebuttondialog2 = m4;
                }
                this$0.f24203j = iosonebuttondialog2;
                return;
            }
        }
        iOSOneButtonDialog iosonebuttondialog4 = this$0.f24203j;
        if (iosonebuttondialog4 != null) {
            iosonebuttondialog4.dismiss();
        }
        gVar.Y(false);
        this$0.l(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(View view) {
        com.bxkj.student.v2.ui.sports.safe.b.f23945a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(V3LocationObserver this$0, DialogInterface dialogInterface) {
        f0.p(this$0, "this$0");
        this$0.f24203j = null;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$a, d2.p] */
    private final void l(AMapLocation aMapLocation) {
        String gpsStatus = i.j(aMapLocation.getLocationQualityReport().getGPSStatus(), aMapLocation.getGpsAccuracyStatus());
        int k4 = i.k(aMapLocation.getGpsAccuracyStatus());
        c.g gVar = com.bxkj.student.v2.common.data.c.f23133a;
        gVar.V(aMapLocation.getGpsAccuracyStatus());
        f0.o(gpsStatus, "gpsStatus");
        gVar.X(gpsStatus);
        gVar.W(k4);
        gVar.G(gpsStatus, k4);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("\u56de\u8c03\u65f6\u95f4:");
        sb.append(i.h(currentTimeMillis, "yyyy-MM-dd HH:mm:ss"));
        sb.append("\n");
        if (aMapLocation.getErrorCode() == 0) {
            sb.append("\u5b9a\u4f4d\u6210\u529f\n");
            sb.append("\u5b9a\u4f4d\u7c7b\u578b:" + aMapLocation.getLocationType() + " \n");
            sb.append("\u7ecf\u3000\u3000\u5ea6:" + aMapLocation.getLongitude() + " \n");
            sb.append("\u7eac\u3000\u3000\u5ea6:" + aMapLocation.getLatitude() + " \n");
            sb.append("\u7cbe\u3000\u3000\u5ea6:" + aMapLocation.getAccuracy() + " \n");
            sb.append("\u63d0\u4f9b\u8005\u3000:" + ((Object) aMapLocation.getProvider()) + " \n");
            sb.append("\u901f\u3000\u3000\u5ea6:" + aMapLocation.getSpeed() + " \n");
            sb.append("\u89d2\u3000\u3000\u5ea6:" + aMapLocation.getBearing() + " \n");
            sb.append("\u661f\u3000\u3000\u6570:" + aMapLocation.getSatellites() + " \n");
            sb.append("\u56fd\u3000\u3000\u5bb6:" + ((Object) aMapLocation.getCountry()) + " \n");
            sb.append("\u7701\u3000\u3000\u3000:" + ((Object) aMapLocation.getProvince()) + " \n");
            sb.append("\u5e02\u3000\u3000\u3000:" + ((Object) aMapLocation.getCity()) + " \n");
            sb.append("\u57ce\u5e02\u7f16\u7801:" + ((Object) aMapLocation.getCityCode()) + " \n");
            sb.append("\u533a\u3000\u3000\u3000:" + ((Object) aMapLocation.getDistrict()) + " \n");
            sb.append("\u533a\u57df\u7801\u3000:" + ((Object) aMapLocation.getAdCode()) + " \n");
            sb.append("\u5730\u3000\u3000\u5740:" + ((Object) aMapLocation.getAddress()) + " \n");
            sb.append("\u5174\u8da3\u70b9\u3000:" + ((Object) aMapLocation.getPoiName()) + " \n");
            sb.append("\u5b9a\u4f4d\u65f6\u95f4:" + ((Object) i.h(aMapLocation.getTime(), "yyyy-MM-dd HH:mm:ss")) + " \n");
            kotlinx.coroutines.j.f(LifecycleOwnerKt.getLifecycleScope(this.f24194a), kotlinx.coroutines.f1.a(), null, new a(aMapLocation, null), 2, null);
        } else {
            sb.append("\u5b9a\u4f4d\u5931\u8d25\n");
            sb.append("\u9519\u8bef\u7801\u3000:" + aMapLocation.getErrorCode() + '\n');
            sb.append("\u9519\u8bef\u4fe1\u606f:" + ((Object) aMapLocation.getErrorInfo()) + '\n');
            sb.append("\u9519\u8bef\u63cf\u8ff0:" + ((Object) aMapLocation.getLocationDetail()) + '\n');
            j.d(sb.toString(), new Object[0]);
        }
        sb.append("***\u5b9a\u4f4d\u8d28\u91cf\u62a5\u544a***\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("* WIFI\u5f00\u5173\uff1a");
        sb2.append(aMapLocation.getLocationQualityReport().isWifiAble() ? "\u5f00\u542f" : "\u5173\u95ed");
        sb2.append('\n');
        sb.append(sb2.toString());
        sb.append("* GPS\u72b6\u6001\uff1a" + ((Object) i.m(aMapLocation.getLocationQualityReport().getGPSStatus())) + '\n');
        sb.append("* GPS\u661f\u6570\uff1a" + aMapLocation.getLocationQualityReport().getGPSSatellites() + '\n');
        sb.append("****************\n");
        f0.o(sb.toString(), "sb.toString()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(com.amap.api.location.AMapLocation r32, kotlin.coroutines.c<? super kotlin.f1> r33) {
        /*
            Method dump skipped, instructions count: 1202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver.m(com.amap.api.location.AMapLocation, kotlin.coroutines.c):java.lang.Object");
    }

    private final void n() {
        j.d("\u5f00\u542f\u524d\u53f0\u670d\u52a1\u5e7f\u64ad", new Object[0]);
        AMapLocationClient aMapLocationClient = this.f24195b;
        if (aMapLocationClient == null) {
            return;
        }
        g.f24275a.c(g(), aMapLocationClient);
    }

    @NotNull
    public final LifecycleService g() {
        return this.f24194a;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        j.d("\u5f00\u542f\u5b9a\u4f4d\u76d1\u542cstartGetLocation", new Object[0]);
        h();
        AMapLocationClient aMapLocationClient = this.f24195b;
        if (aMapLocationClient == null) {
            return;
        }
        aMapLocationClient.stopLocation();
        aMapLocationClient.startLocation();
        n();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        j.d("\u505c\u6b62\u5b9a\u4f4d\u670d\u52a1", new Object[0]);
        AMapLocationClient aMapLocationClient = this.f24195b;
        if (aMapLocationClient != null) {
            aMapLocationClient.disableBackgroundLocation(true);
            aMapLocationClient.stopLocation();
            aMapLocationClient.onDestroy();
        }
        this.f24194a.stopForeground(true);
        g.f24275a.b(this.f24194a);
    }
}
