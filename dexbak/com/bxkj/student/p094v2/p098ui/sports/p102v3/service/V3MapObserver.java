package com.bxkj.student.p094v2.p098ui.sports.p102v3.service;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.utils.Tools;
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
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.common.utils.VibrateManager;
import com.bxkj.student.App;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.data.PointData;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.utils.ActivityManager;
import com.bxkj.student.p094v2.common.utils.DrawMapLineManager;
import com.bxkj.student.p094v2.p098ui.face.FaceDetectV3Activity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3NotificationManager;
import com.bxkj.student.p094v2.p103vm.sports.SportsVM;
import com.bxkj.student.run.app.utils.VoiceSpeaker;
import com.github.mikephil.charting.utils.Utils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p618m.StartActivityForResult;

/* compiled from: V3MapObserver.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020\u001b\u0012\u0006\u0010(\u001a\u00020#¢\u0006\u0004\bX\u0010YJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007R\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010<R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Z"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/service/V3MapObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/amap/api/maps/model/LatLng;", "startPoint", "Lkotlin/f1;", "p", "", "distance", "latLng", CampaignEx.JSON_KEY_AD_Q, "", "msg", "", "faceDistanceOut", "C", IAdInterListener.AdReqParam.WIDTH, "it", "x", "onCreate", "onResume", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "s", "()Landroidx/fragment/app/FragmentActivity;", "mActivity", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "b", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "u", "()Lcom/bxkj/student/v2/vm/sports/SportsVM;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/bxkj/student/v2/vm/sports/SportsVM;)V", "mViewModel", "Lcom/amap/api/maps/AMap;", "c", "Lcom/amap/api/maps/AMap;", "r", "()Lcom/amap/api/maps/AMap;", "aMap", "Landroid/content/Context;", "d", "Landroid/content/Context;", UMCommonContent.f37782aL, "()Landroid/content/Context;", "mContext", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "e", "Lcom/amap/api/maps/model/LatLngBounds$Builder;", "latLngBoundsBuilder", "", "f", "J", "v", "()J", "B", "(J)V", "onMapTouchTime", "g", "Lcom/amap/api/maps/model/LatLng;", "currentLatLng", "h", "lastLatLng", "", "i", "Ljava/util/List;", "middleFaces", "Lcom/bxkj/student/v2/common/utils/g;", "j", "Lcom/bxkj/student/v2/common/utils/g;", "drawMapLineManager", "Landroid/content/BroadcastReceiver;", "k", "Landroid/content/BroadcastReceiver;", "locationServiceBroadCastReceiver", "Lcom/amap/api/maps/LocationSource;", C7304t.f25048d, "Lcom/amap/api/maps/LocationSource;", "locationSource", "Lcom/amap/api/maps/LocationSource$OnLocationChangedListener;", "m", "Lcom/amap/api/maps/LocationSource$OnLocationChangedListener;", "mLocationListener", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "n", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "faceDialog", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/bxkj/student/v2/vm/sports/SportsVM;Lcom/amap/api/maps/AMap;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class V3MapObserver implements LifecycleObserver {
    @NotNull

    /* renamed from: a */
    private final FragmentActivity f20804a;
    @NotNull

    /* renamed from: b */
    private SportsVM f20805b;
    @NotNull

    /* renamed from: c */
    private final AMap f20806c;
    @NotNull

    /* renamed from: d */
    private final Context f20807d;
    @Nullable

    /* renamed from: e */
    private LatLngBounds.Builder f20808e;

    /* renamed from: f */
    private long f20809f;
    @Nullable

    /* renamed from: g */
    private LatLng f20810g;
    @Nullable

    /* renamed from: h */
    private LatLng f20811h;
    @Nullable

    /* renamed from: i */
    private List<Double> f20812i;
    @Nullable

    /* renamed from: j */
    private DrawMapLineManager f20813j;
    @Nullable

    /* renamed from: k */
    private BroadcastReceiver f20814k;
    @Nullable

    /* renamed from: l */
    private LocationSource f20815l;
    @Nullable

    /* renamed from: m */
    private LocationSource.OnLocationChangedListener f20816m;
    @Nullable

    /* renamed from: n */
    private iOSOneButtonDialog f20817n;

    /* compiled from: V3MapObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/service/V3MapObserver$a", "Lcom/amap/api/maps/LocationSource;", "Lcom/amap/api/maps/LocationSource$OnLocationChangedListener;", "listener", "Lkotlin/f1;", "activate", "deactivate", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5810a implements LocationSource {
        C5810a() {
        }

        @Override // com.amap.api.maps.LocationSource
        public void activate(@NotNull LocationSource.OnLocationChangedListener listener) {
            C14342f0.m8184p(listener, "listener");
            V3MapObserver.this.f20816m = listener;
        }

        @Override // com.amap.api.maps.LocationSource
        public void deactivate() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3MapObserver.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5811b extends Lambda implements InterfaceC15280l<iOSOneButtonDialog, Unit> {

        /* renamed from: b */
        final /* synthetic */ int f20820b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: V3MapObserver.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5812a extends Lambda implements InterfaceC15269a<Unit> {

            /* renamed from: a */
            final /* synthetic */ V3MapObserver f20821a;

            /* renamed from: b */
            final /* synthetic */ int f20822b;

            /* compiled from: V3MapObserver.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/service/V3MapObserver$b$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$b$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            public static final class C5813a implements StartActivityForResult.InterfaceC15293a {

                /* renamed from: a */
                final /* synthetic */ V3MapObserver f20823a;

                /* renamed from: b */
                final /* synthetic */ int f20824b;

                C5813a(V3MapObserver v3MapObserver, int i) {
                    this.f20823a = v3MapObserver;
                    this.f20824b = i;
                }

                @Override // p618m.StartActivityForResult.InterfaceC15293a
                /* renamed from: a */
                public void mo3459a(int i, @Nullable Intent intent) {
                    List<Integer> m12467P;
                    if (i == -1) {
                        LatLng latLng = this.f20823a.f20810g;
                        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
                        if (AMapUtils.calculateLineDistance(latLng, c5481g.m39251u()) > this.f20824b) {
                            c5481g.m39264i().setValue(Boolean.FALSE);
                            Activity m39150a = ActivityManager.f20090a.m39150a();
                            if (m39150a != null) {
                                ContextExt.m43851m(m39150a, "人脸识别超出指定范围");
                            }
                        }
                        MutableLiveData<Integer> m39266h = c5481g.m39266h();
                        Integer value = c5481g.m39266h().getValue();
                        if (value == null) {
                            value = 0;
                        }
                        m39266h.setValue(Integer.valueOf(value.intValue() + 1));
                        VoiceSpeaker m39665e = VoiceSpeaker.m39665e();
                        Context m38293t = this.f20823a.m38293t();
                        m12467P = CollectionsKt__CollectionsKt.m12467P(Integer.valueOf((int) C4215R.raw.face_live_success_run_continue));
                        m39665e.m39656n(m38293t, m12467P);
                        new VibrateManager(this.f20823a.m38294s()).m43734c();
                        c5481g.m39290Q(Utils.DOUBLE_EPSILON);
                        c5481g.m39271e0(null);
                        c5481g.m39289R(false);
                        iOSOneButtonDialog iosonebuttondialog = this.f20823a.f20817n;
                        if (iosonebuttondialog == null) {
                            return;
                        }
                        iosonebuttondialog.dismiss();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5812a(V3MapObserver v3MapObserver, int i) {
                super(0);
                this.f20821a = v3MapObserver;
                this.f20822b = i;
            }

            @Override // p617l1.InterfaceC15269a
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ActivityManager activityManager = ActivityManager.f20090a;
                Activity m39150a = activityManager.m39150a();
                if (m39150a != null) {
                    StartActivityForResult startActivityForResult = new StartActivityForResult((FragmentActivity) m39150a);
                    Intent intent = new Intent(this.f20821a.m38293t(), FaceDetectV3Activity.class);
                    JsonGet jsonGet = JsonGet.f15134a;
                    Intent putExtra = intent.putExtra("identify", jsonGet.m43760t(this.f20821a.m38292u().m38035B(), "identify")).putExtra("type", "2").putExtra("runType", jsonGet.m43768l(this.f20821a.m38292u().m38035B(), "runType", 1));
                    C14342f0.m8185o(putExtra, "Intent(mContext, FaceDet…                        )");
                    startActivityForResult.startActivityForResult(putExtra).m3460c(new C5813a(this.f20821a, this.f20822b));
                    Activity m39150a2 = activityManager.m39150a();
                    if (m39150a2 == null) {
                        return;
                    }
                    m39150a2.overridePendingTransition(2130771987, 2130771986);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5811b(int i) {
            super(1);
            this.f20820b = i;
        }

        /* renamed from: a */
        public final void m38286a(@NotNull iOSOneButtonDialog it) {
            C14342f0.m8184p(it, "it");
            Activity m39150a = ActivityManager.f20090a.m39150a();
            if (m39150a == null) {
                m39150a = V3MapObserver.this.m38294s();
            }
            V3MapObserver v3MapObserver = V3MapObserver.this;
            int i = this.f20820b;
            new VibrateManager(v3MapObserver.m38294s()).m43734c();
            PermissionExt.m43841c((FragmentActivity) m39150a, "人脸识别", new C5812a(v3MapObserver, i));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSOneButtonDialog iosonebuttondialog) {
            m38286a(iosonebuttondialog);
            return Unit.f41048a;
        }
    }

    public V3MapObserver(@NotNull FragmentActivity mActivity, @NotNull SportsVM mViewModel, @NotNull AMap aMap) {
        C14342f0.m8184p(mActivity, "mActivity");
        C14342f0.m8184p(mViewModel, "mViewModel");
        C14342f0.m8184p(aMap, "aMap");
        this.f20804a = mActivity;
        this.f20805b = mViewModel;
        this.f20806c = aMap;
        this.f20807d = mActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public final void m38313C(String str, int i) {
        iOSOneButtonDialog m43850n;
        new VibrateManager(this.f20804a).m43735b();
        V3NotificationManager.C5826a.m38267f(V3NotificationManager.f20856a, this.f20807d, str, false, 4, null);
        iOSOneButtonDialog iosonebuttondialog = this.f20817n;
        if (iosonebuttondialog != null) {
            iosonebuttondialog.dismiss();
        }
        Activity m39150a = ActivityManager.f20090a.m39150a();
        iOSOneButtonDialog iosonebuttondialog2 = null;
        if (m39150a != null && (m43850n = ContextExt.m43850n(m39150a, str, new C5811b(i))) != null) {
            m43850n.setClickAutoCancel(false);
            m43850n.setCancelable(false);
            m43850n.setCanceledOnTouchOutside(false);
            Unit unit = Unit.f41048a;
            iosonebuttondialog2 = m43850n;
        }
        this.f20817n = iosonebuttondialog2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public final void m38297p(LatLng latLng) {
        int m12476G;
        m38289x(latLng);
        LatLngBounds.Builder builder = this.f20808e;
        if (builder != null) {
            builder.include(latLng);
        }
        ArrayList<PointData> arrayList = new ArrayList();
        arrayList.addAll(SportsDataAgent.f19899a.m39256p());
        if ((arrayList.isEmpty() ^ true ? arrayList : null) == null) {
            return;
        }
        m12476G = CollectionsKt__CollectionsKt.m12476G(arrayList);
        PointData pointData = (PointData) arrayList.get(m12476G);
        this.f20811h = new LatLng(pointData.getA(), pointData.getO());
        try {
            DrawMapLineManager drawMapLineManager = this.f20813j;
            if (drawMapLineManager != null) {
                drawMapLineManager.m39130a(arrayList);
            }
        } catch (Exception e) {
            C11792j.m20470c(e.getMessage());
        }
        for (PointData pointData2 : arrayList) {
            LatLngBounds.Builder builder2 = this.f20808e;
            if (builder2 != null) {
                builder2.include(new LatLng(pointData2.getA(), pointData2.getO()));
            }
        }
        AMap m38295r = m38295r();
        LatLngBounds.Builder builder3 = this.f20808e;
        m38295r.animateCamera(CameraUpdateFactory.newLatLngBounds(builder3 == null ? null : builder3.build(), Tools.m57620a(50.0f, m38293t())), 1000L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c7, code lost:
        if (((r14 == null || r14.isShowing()) ? false : true) != false) goto L42;
     */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m38296q(double r12, com.amap.api.maps.model.LatLng r14) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3MapObserver.m38296q(double, com.amap.api.maps.model.LatLng):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public final void m38290w() {
        List<Marker> mapScreenMarkers = this.f20806c.getMapScreenMarkers();
        C14342f0.m8185o(mapScreenMarkers, "aMap.mapScreenMarkers");
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

    /* renamed from: x */
    private final void m38289x(LatLng latLng) {
        this.f20806c.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.ic_marker_start)).zIndex(9.0f).draggable(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public static final void m38288y(V3MapObserver this$0, MotionEvent motionEvent) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38314B(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public static final void m38287z(V3MapObserver this$0, LatLng latLng) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38290w();
    }

    /* renamed from: A */
    public final void m38315A(@NotNull SportsVM sportsVM) {
        C14342f0.m8184p(sportsVM, "<set-?>");
        this.f20805b = sportsVM;
    }

    /* renamed from: B */
    public final void m38314B(long j) {
        this.f20809f = j;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        this.f20809f = System.currentTimeMillis();
        this.f20808e = LatLngBounds.builder();
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.v3_sports_location_mark3));
        myLocationStyle.strokeColor(ContextCompat.getColor(this.f20807d, C4215R.C4217color.v3_tab_color3));
        myLocationStyle.radiusFillColor(ContextCompat.getColor(this.f20807d, C4215R.C4217color.v3_location_color3));
        myLocationStyle.strokeWidth(1.0f);
        myLocationStyle.myLocationType(5);
        this.f20806c.setMyLocationStyle(myLocationStyle);
        C5810a c5810a = new C5810a();
        this.f20815l = c5810a;
        this.f20806c.setLocationSource(c5810a);
        this.f20806c.getUiSettings().setMyLocationButtonEnabled(true);
        this.f20806c.setMyLocationEnabled(true);
        this.f20806c.moveCamera(CameraUpdateFactory.zoomTo(18.0f));
        this.f20806c.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
        this.f20806c.setOnMapTouchListener(new AMap.OnMapTouchListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.f
            @Override // com.amap.api.maps.AMap.OnMapTouchListener
            public final void onTouch(MotionEvent motionEvent) {
                V3MapObserver.m38288y(V3MapObserver.this, motionEvent);
            }
        });
        this.f20806c.setOnMapClickListener(new AMap.OnMapClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.e
            @Override // com.amap.api.maps.AMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                V3MapObserver.m38287z(V3MapObserver.this, latLng);
            }
        });
        this.f20813j = new DrawMapLineManager(this.f20807d, this.f20806c);
        this.f20812i = JsonParse.getList(this.f20805b.m38035B(), "middleFaces", Double.TYPE);
        LatLng m39249w = SportsDataAgent.f19899a.m39249w();
        if (m39249w != null) {
            m38297p(m39249w);
        }
        this.f20814k = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$onCreate$5
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                List<Integer> m12467P;
                LatLng latLng;
                DrawMapLineManager drawMapLineManager;
                LatLngBounds.Builder builder;
                LatLngBounds.Builder builder2;
                LocationSource.OnLocationChangedListener onLocationChangedListener;
                if (intent == null) {
                    return;
                }
                V3MapObserver v3MapObserver = V3MapObserver.this;
                if (intent.hasExtra("aMapLocation")) {
                    AMapLocation aMapLocation = (AMapLocation) intent.getParcelableExtra("aMapLocation");
                    onLocationChangedListener = v3MapObserver.f20816m;
                    if (onLocationChangedListener != null) {
                        onLocationChangedListener.onLocationChanged(aMapLocation);
                    }
                }
                if (intent.hasExtra("firstMapLocation")) {
                    LatLng latLng2 = (LatLng) intent.getParcelableExtra("firstMapLocation");
                    v3MapObserver.f20810g = latLng2;
                    builder = v3MapObserver.f20808e;
                    if (builder != null) {
                        builder.include(latLng2);
                    }
                    AMap m38295r = v3MapObserver.m38295r();
                    builder2 = v3MapObserver.f20808e;
                    m38295r.animateCamera(CameraUpdateFactory.newLatLngBounds(builder2 == null ? null : builder2.build(), Tools.m57620a(50.0f, v3MapObserver.m38293t())), 1000L, null);
                }
                if (intent.hasExtra("startPoint")) {
                    v3MapObserver.f20810g = (LatLng) intent.getParcelableExtra("startPoint");
                    LatLng latLng3 = v3MapObserver.f20810g;
                    if (latLng3 != null) {
                        v3MapObserver.m38297p(latLng3);
                    }
                }
                if (intent.hasExtra("countTime") && System.currentTimeMillis() - v3MapObserver.m38291v() > 30000) {
                    v3MapObserver.m38295r().animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(v3MapObserver.f20810g, 18.0f)), 500L, null);
                }
                if (intent.hasExtra("newPoint")) {
                    PointData pointData = (PointData) intent.getParcelableExtra("newPoint");
                    latLng = v3MapObserver.f20811h;
                    if (latLng != null) {
                        if (pointData != null) {
                            v3MapObserver.f20810g = new LatLng(pointData.getA(), pointData.getO());
                            drawMapLineManager = v3MapObserver.f20813j;
                            if (drawMapLineManager != null) {
                                LatLng latLng4 = v3MapObserver.f20810g;
                                C14342f0.m8187m(latLng4);
                                drawMapLineManager.m39129b(latLng4, latLng, pointData.getS(), pointData.isI());
                            }
                        }
                        v3MapObserver.f20811h = v3MapObserver.f20810g;
                        double m39270f = SportsDataAgent.f19899a.m39270f();
                        LatLng latLng5 = v3MapObserver.f20810g;
                        C14342f0.m8187m(latLng5);
                        v3MapObserver.m38296q(m39270f, latLng5);
                        if (System.currentTimeMillis() - v3MapObserver.m38291v() > 30000) {
                            v3MapObserver.m38314B(System.currentTimeMillis());
                            v3MapObserver.m38295r().animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(v3MapObserver.f20810g, 18.0f)), 500L, null);
                            v3MapObserver.m38290w();
                        }
                    }
                }
                if (intent.hasExtra(CampaignEx.JSON_NATIVE_VIDEO_PAUSE) && intent.getBooleanExtra(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, false)) {
                    SportsDataAgent.f19899a.m39289R(true);
                    VoiceSpeaker m39665e = VoiceSpeaker.m39665e();
                    Context m38293t = v3MapObserver.m38293t();
                    m12467P = CollectionsKt__CollectionsKt.m12467P(Integer.valueOf((int) C4215R.raw.run_pause_face_live));
                    m39665e.m39656n(m38293t, m12467P);
                    double m43774f = JsonGet.f15134a.m43774f(v3MapObserver.m38292u().m38035B(), "faceDistanceOut");
                    double d = 1000;
                    Double.isNaN(d);
                    int i = (int) (m43774f * d);
                    String str = "跑步已暂停，请在" + i + "米范围内进行人脸识别！";
                    C11792j.m20469d(str, new Object[0]);
                    v3MapObserver.m38313C(str, i);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
        intentFilter.addAction(C14342f0.m8216C(App.m43006n().getPackageName(), ".faceOutPause"));
        BroadcastReceiver broadcastReceiver = this.f20814k;
        if (broadcastReceiver == null) {
            return;
        }
        m38294s().registerReceiver(broadcastReceiver, intentFilter);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f20814k;
        if (broadcastReceiver == null) {
            return;
        }
        m38294s().unregisterReceiver(broadcastReceiver);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        LatLng latLng = this.f20810g;
        if (latLng != null) {
            this.f20806c.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng, 18.0f)), 1000L, null);
        }
        m38290w();
    }

    @NotNull
    /* renamed from: r */
    public final AMap m38295r() {
        return this.f20806c;
    }

    @NotNull
    /* renamed from: s */
    public final FragmentActivity m38294s() {
        return this.f20804a;
    }

    @NotNull
    /* renamed from: t */
    public final Context m38293t() {
        return this.f20807d;
    }

    @NotNull
    /* renamed from: u */
    public final SportsVM m38292u() {
        return this.f20805b;
    }

    /* renamed from: v */
    public final long m38291v() {
        return this.f20809f;
    }
}
