package com.bxkj.student.v2.ui.sports.v3.service;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.s;
import com.bxkj.base.v2.common.utils.t;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.run.app.utils.d0;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.b;
import com.bxkj.student.v2.ui.face.FaceDetectV3Activity;
import com.bxkj.student.v2.ui.sports.v3.service.g;
import com.bxkj.student.v2.vm.sports.SportsVM;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.v;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import l1.l;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: V3MapObserver.kt */
@Metadata(bv = {}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020\u001b\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006Z"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3MapObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/amap/api/maps/model/LatLng;", "startPoint", "Lkotlin/f1;", "p", "", "distance", "latLng", CampaignEx.JSON_KEY_AD_Q, "", "msg", "", "faceDistanceOut", "C", "w", "it", "x", "onCreate", "onResume", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "s", "()Landroidx/fragment/app/FragmentActivity;", "mActivity", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "b", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "u", "()Lcom/bxkj/student/v2/vm/sports/SportsVM;", "A", "(Lcom/bxkj/student/v2/vm/sports/SportsVM;)V", "mViewModel", "Lcom/amap/api/maps/AMap;", "c", "Lcom/amap/api/maps/AMap;", "r", "()Lcom/amap/api/maps/AMap;", "aMap", "Landroid/content/Context;", "d", "Landroid/content/Context;", "t", "()Landroid/content/Context;", "mContext", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "e", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "latLngBoundsBuilder", "", "f", "J", "v", "()J", "B", "(J)V", "onMapTouchTime", "g", "Lcom/amap/api/maps/model/LatLng;", "currentLatLng", "h", "lastLatLng", "", "i", "Ljava/util/List;", "middleFaces", "Lcom/bxkj/student/v2/common/utils/g;", "j", "Lcom/bxkj/student/v2/common/utils/g;", "drawMapLineManager", "Landroid/content/BroadcastReceiver;", "k", "Landroid/content/BroadcastReceiver;", "locationServiceBroadCastReceiver", "Lcom/amap/api/maps/LocationSource;", "l", "Lcom/amap/api/maps/LocationSource;", "locationSource", "Lcom/amap/api/maps/LocationSource$OnLocationChangedListener;", "m", "Lcom/amap/api/maps/LocationSource$OnLocationChangedListener;", "mLocationListener", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "n", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "faceDialog", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/bxkj/student/v2/vm/sports/SportsVM;Lcom/amap/api/maps/AMap;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class V3MapObserver implements LifecycleObserver {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final FragmentActivity f24223a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private SportsVM f24224b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final AMap f24225c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Context f24226d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds.Builder f24227e;

    /* renamed from: f  reason: collision with root package name */
    private long f24228f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private LatLng f24229g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private LatLng f24230h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private List<Double> f24231i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private com.bxkj.student.v2.common.utils.g f24232j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private BroadcastReceiver f24233k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private LocationSource f24234l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private LocationSource.OnLocationChangedListener f24235m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private iOSOneButtonDialog f24236n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3MapObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/service/V3MapObserver$a", "Lcom/amap/api/maps/LocationSource;", "Lcom/amap/api/maps/LocationSource$OnLocationChangedListener;", "listener", "Lkotlin/f1;", "activate", "deactivate", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements LocationSource {
        a() {
        }

        @Override // com.amap.api.maps.LocationSource
        public void activate(@NotNull LocationSource.OnLocationChangedListener listener) {
            f0.p(listener, "listener");
            V3MapObserver.this.f24235m = listener;
        }

        @Override // com.amap.api.maps.LocationSource
        public void deactivate() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3MapObserver.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l<iOSOneButtonDialog, f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f24239b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3MapObserver.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a extends Lambda implements l1.a<f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3MapObserver f24240a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f24241b;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* compiled from: V3MapObserver.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/service/V3MapObserver$b$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$b$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            public static final class C0320a implements b.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ V3MapObserver f24242a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ int f24243b;

                C0320a(V3MapObserver v3MapObserver, int i4) {
                    this.f24242a = v3MapObserver;
                    this.f24243b = i4;
                }

                @Override // m.b.a
                public void a(int i4, @Nullable Intent intent) {
                    if (i4 == -1) {
                        LatLng latLng = this.f24242a.f24229g;
                        b.g gVar = com.bxkj.student.v2.common.data.b.a;
                        if (AMapUtils.calculateLineDistance(latLng, gVar.u()) > this.f24243b) {
                            gVar.i().setValue(Boolean.FALSE);
                            Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
                            if (a4 != null) {
                                ContextExtKt.m(a4, "\u4eba\u8138\u8bc6\u522b\u8d85\u51fa\u6307\u5b9a\u8303\u56f4");
                            }
                        }
                        MutableLiveData<Integer> h4 = gVar.h();
                        Integer value = gVar.h().getValue();
                        if (value == null) {
                            value = 0;
                        }
                        h4.setValue(Integer.valueOf(value.intValue() + 1));
                        d0.e().n(this.f24242a.t(), v.P(new Integer[]{2131755020}));
                        new s(this.f24242a.s()).c();
                        gVar.Q(0.0d);
                        gVar.e0(null);
                        gVar.R(false);
                        iOSOneButtonDialog iosonebuttondialog = this.f24242a.f24236n;
                        if (iosonebuttondialog == null) {
                            return;
                        }
                        iosonebuttondialog.dismiss();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(V3MapObserver v3MapObserver, int i4) {
                super(0);
                this.f24240a = v3MapObserver;
                this.f24241b = i4;
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m81invoke();
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m81invoke() {
                com.bxkj.student.v2.common.utils.a aVar = com.bxkj.student.v2.common.utils.a.f23334a;
                Activity a4 = aVar.a();
                if (a4 != null) {
                    m.b bVar = new m.b((FragmentActivity) a4);
                    Intent intent = new Intent(this.f24240a.t(), FaceDetectV3Activity.class);
                    com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
                    Intent putExtra = intent.putExtra("identify", lVar.t(this.f24240a.u().B(), "identify")).putExtra("type", "2").putExtra("runType", lVar.l(this.f24240a.u().B(), "runType", 1));
                    f0.o(putExtra, "Intent(mContext, FaceDet\u2026                        )");
                    bVar.startActivityForResult(putExtra).c(new C0320a(this.f24240a, this.f24241b));
                    Activity a5 = aVar.a();
                    if (a5 == null) {
                        return;
                    }
                    a5.overridePendingTransition(2130771987, 2130771986);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i4) {
            super(1);
            this.f24239b = i4;
        }

        public final void a(@NotNull iOSOneButtonDialog it) {
            f0.p(it, "it");
            Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
            if (a4 == null) {
                a4 = V3MapObserver.this.s();
            }
            V3MapObserver v3MapObserver = V3MapObserver.this;
            int i4 = this.f24239b;
            new s(v3MapObserver.s()).c();
            com.bxkj.base.v2.common.ext.g.c((FragmentActivity) a4, "\u4eba\u8138\u8bc6\u522b", new a(v3MapObserver, i4));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
            a(iosonebuttondialog);
            return f1.f55527a;
        }
    }

    public V3MapObserver(@NotNull FragmentActivity mActivity, @NotNull SportsVM mViewModel, @NotNull AMap aMap) {
        f0.p(mActivity, "mActivity");
        f0.p(mViewModel, "mViewModel");
        f0.p(aMap, "aMap");
        this.f24223a = mActivity;
        this.f24224b = mViewModel;
        this.f24225c = aMap;
        this.f24226d = mActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [d2.l, com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$b] */
    public final void C(String str, int i4) {
        iOSOneButtonDialog n4;
        new t(this.f24223a).b();
        g.a.f(g.f24275a, this.f24226d, str, false, 4, null);
        iOSOneButtonDialog iosonebuttondialog = this.f24236n;
        if (iosonebuttondialog != null) {
            iosonebuttondialog.dismiss();
        }
        Activity a4 = com.bxkj.student.v2.common.utils.a.f23334a.a();
        iOSOneButtonDialog iosonebuttondialog2 = null;
        if (a4 != null && (n4 = ContextExtKt.n(a4, str, (d2.l) new b(i4))) != null) {
            n4.setClickAutoCancel(false);
            n4.setCancelable(false);
            n4.setCanceledOnTouchOutside(false);
            f1 f1Var = f1.f55527a;
            iosonebuttondialog2 = n4;
        }
        this.f24236n = iosonebuttondialog2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(LatLng latLng) {
        int H;
        x(latLng);
        LatLngBounds.Builder builder = this.f24227e;
        if (builder != null) {
            builder.include(latLng);
        }
        ArrayList<PointData> arrayList = new ArrayList();
        arrayList.addAll(com.bxkj.student.v2.common.data.c.f23133a.p());
        if ((arrayList.isEmpty() ^ true ? arrayList : null) == null) {
            return;
        }
        H = CollectionsKt__CollectionsKt.H(arrayList);
        PointData pointData = (PointData) arrayList.get(H);
        this.f24230h = new LatLng(pointData.getA(), pointData.getO());
        try {
            com.bxkj.student.v2.common.utils.g gVar = this.f24232j;
            if (gVar != null) {
                gVar.a(arrayList);
            }
        } catch (Exception e4) {
            j.c(e4.getMessage());
        }
        for (PointData pointData2 : arrayList) {
            LatLngBounds.Builder builder2 = this.f24227e;
            if (builder2 != null) {
                builder2.include(new LatLng(pointData2.getA(), pointData2.getO()));
            }
        }
        AMap r3 = r();
        LatLngBounds.Builder builder3 = this.f24227e;
        r3.animateCamera(CameraUpdateFactory.newLatLngBounds(builder3 == null ? null : builder3.build(), u.a(50.0f, t())), 1000L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c9, code lost:
        if (((r14 == null || r14.isShowing()) ? false : true) != false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q(double r12, com.amap.api.maps.model.LatLng r14) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver.q(double, com.amap.api.maps.model.LatLng):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        List<Marker> mapScreenMarkers = this.f24225c.getMapScreenMarkers();
        f0.o(mapScreenMarkers, "aMap.mapScreenMarkers");
        for (Marker marker : mapScreenMarkers) {
            if (marker != null) {
                if (!marker.isInfoWindowShown()) {
                    marker = null;
                }
                if (marker != null) {
                    marker.hideInfoWindow();
                }
            }
        }
    }

    private final void x(LatLng latLng) {
        this.f24225c.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(2131558628)).zIndex(9.0f).draggable(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(V3MapObserver this$0, MotionEvent motionEvent) {
        f0.p(this$0, "this$0");
        this$0.B(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(V3MapObserver this$0, LatLng latLng) {
        f0.p(this$0, "this$0");
        this$0.w();
    }

    public final void A(@NotNull SportsVM sportsVM) {
        f0.p(sportsVM, "<set-?>");
        this.f24224b = sportsVM;
    }

    public final void B(long j4) {
        this.f24228f = j4;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        this.f24228f = System.currentTimeMillis();
        this.f24227e = LatLngBounds.builder();
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(2131559192));
        myLocationStyle.strokeColor(ContextCompat.getColor(this.f24226d, R.color.v3_tab_color3));
        myLocationStyle.radiusFillColor(ContextCompat.getColor(this.f24226d, R.color.v3_location_color3));
        myLocationStyle.strokeWidth(1.0f);
        myLocationStyle.myLocationType(5);
        this.f24225c.setMyLocationStyle(myLocationStyle);
        a aVar = new a();
        this.f24234l = aVar;
        this.f24225c.setLocationSource(aVar);
        this.f24225c.getUiSettings().setMyLocationButtonEnabled(true);
        this.f24225c.setMyLocationEnabled(true);
        this.f24225c.moveCamera(CameraUpdateFactory.zoomTo(18.0f));
        this.f24225c.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
        this.f24225c.setOnMapTouchListener(new AMap.OnMapTouchListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.f
            @Override // com.amap.api.maps.AMap.OnMapTouchListener
            public final void onTouch(MotionEvent motionEvent) {
                V3MapObserver.y(V3MapObserver.this, motionEvent);
            }
        });
        this.f24225c.setOnMapClickListener(new AMap.OnMapClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.e
            @Override // com.amap.api.maps.AMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                V3MapObserver.z(V3MapObserver.this, latLng);
            }
        });
        this.f24232j = new com.bxkj.student.v2.common.utils.g(this.f24226d, this.f24225c);
        this.f24231i = JsonParse.getList(this.f24224b.D(), "middleFaces", Double.TYPE);
        LatLng w3 = com.bxkj.student.v2.common.data.c.f23133a.w();
        if (w3 != null) {
            p(w3);
        }
        this.f24233k = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$onCreate$5
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                LatLng latLng;
                com.bxkj.student.v2.common.utils.g gVar;
                LatLngBounds.Builder builder;
                LatLngBounds.Builder builder2;
                LocationSource.OnLocationChangedListener onLocationChangedListener;
                if (intent == null) {
                    return;
                }
                V3MapObserver v3MapObserver = V3MapObserver.this;
                if (intent.hasExtra("aMapLocation")) {
                    AMapLocation aMapLocation = (AMapLocation) intent.getParcelableExtra("aMapLocation");
                    onLocationChangedListener = v3MapObserver.f24235m;
                    if (onLocationChangedListener != null) {
                        onLocationChangedListener.onLocationChanged(aMapLocation);
                    }
                }
                if (intent.hasExtra("firstMapLocation")) {
                    LatLng latLng2 = (LatLng) intent.getParcelableExtra("firstMapLocation");
                    v3MapObserver.f24229g = latLng2;
                    builder = v3MapObserver.f24227e;
                    if (builder != null) {
                        builder.include(latLng2);
                    }
                    AMap r3 = v3MapObserver.r();
                    builder2 = v3MapObserver.f24227e;
                    r3.animateCamera(CameraUpdateFactory.newLatLngBounds(builder2 == null ? null : builder2.build(), u.a(50.0f, v3MapObserver.t())), 1000L, null);
                }
                if (intent.hasExtra("startPoint")) {
                    v3MapObserver.f24229g = (LatLng) intent.getParcelableExtra("startPoint");
                    LatLng latLng3 = v3MapObserver.f24229g;
                    if (latLng3 != null) {
                        v3MapObserver.p(latLng3);
                    }
                }
                if (intent.hasExtra("countTime") && System.currentTimeMillis() - v3MapObserver.v() > PolicyConfig.mServerBusyRetryBaseInternal) {
                    v3MapObserver.r().animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(v3MapObserver.f24229g, 18.0f)), 500L, null);
                }
                if (intent.hasExtra("newPoint")) {
                    PointData pointData = (PointData) intent.getParcelableExtra("newPoint");
                    latLng = v3MapObserver.f24230h;
                    if (latLng != null) {
                        if (pointData != null) {
                            v3MapObserver.f24229g = new LatLng(pointData.getA(), pointData.getO());
                            gVar = v3MapObserver.f24232j;
                            if (gVar != null) {
                                LatLng latLng4 = v3MapObserver.f24229g;
                                f0.m(latLng4);
                                gVar.b(latLng4, latLng, pointData.getS(), pointData.isI());
                            }
                        }
                        v3MapObserver.f24230h = v3MapObserver.f24229g;
                        double f4 = com.bxkj.student.v2.common.data.b.a.f();
                        LatLng latLng5 = v3MapObserver.f24229g;
                        f0.m(latLng5);
                        v3MapObserver.q(f4, latLng5);
                        if (System.currentTimeMillis() - v3MapObserver.v() > PolicyConfig.mServerBusyRetryBaseInternal) {
                            v3MapObserver.B(System.currentTimeMillis());
                            v3MapObserver.r().animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(v3MapObserver.f24229g, 18.0f)), 500L, null);
                            v3MapObserver.w();
                        }
                    }
                }
                if (intent.hasExtra(CampaignEx.JSON_NATIVE_VIDEO_PAUSE) && intent.getBooleanExtra(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, false)) {
                    com.bxkj.student.v2.common.data.b.a.R(true);
                    d0.e().n(v3MapObserver.t(), v.P(new Integer[]{2131755098}));
                    double f5 = com.bxkj.base.v2.common.utils.l.f18624a.f(v3MapObserver.u().B(), "faceDistanceOut");
                    double d4 = 1000;
                    Double.isNaN(d4);
                    int i4 = (int) (f5 * d4);
                    String str = "\u8dd1\u6b65\u5df2\u6682\u505c\uff0c\u8bf7\u5728" + i4 + "\u7c73\u8303\u56f4\u5185\u8fdb\u884c\u4eba\u8138\u8bc6\u522b\uff01";
                    j.d(str, new Object[0]);
                    v3MapObserver.C(str, i4);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(f0.C(App.n().getPackageName(), ".run"));
        intentFilter.addAction(f0.C(App.n().getPackageName(), ".faceOutPause"));
        BroadcastReceiver broadcastReceiver = this.f24233k;
        if (broadcastReceiver == null) {
            return;
        }
        s().registerReceiver(broadcastReceiver, intentFilter);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f24233k;
        if (broadcastReceiver == null) {
            return;
        }
        s().unregisterReceiver(broadcastReceiver);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        LatLng latLng = this.f24229g;
        if (latLng != null) {
            this.f24225c.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng, 18.0f)), 1000L, null);
        }
        w();
    }

    @NotNull
    public final AMap r() {
        return this.f24225c;
    }

    @NotNull
    public final FragmentActivity s() {
        return this.f24223a;
    }

    @NotNull
    public final Context t() {
        return this.f24226d;
    }

    @NotNull
    public final SportsVM u() {
        return this.f24224b;
    }

    public final long v() {
        return this.f24228f;
    }
}
