package com.bxkj.student.p094v2.p098ui.sports.p102v3;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.alibaba.fastjson.JSON;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.mobads.sdk.internal.C2573a;
import com.bxkj.base.BaseApp;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.base.LoadingDialog;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.p085v2.common.utils.DataFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.util.C3912s;
import com.bxkj.base.util.NotificationsUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.databinding.AcV3SportsHomeBinding;
import com.bxkj.student.p094v2.common.data.PointData;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.utils.SQZSManager;
import com.bxkj.student.p094v2.common.utils.SportsType;
import com.bxkj.student.p094v2.p098ui.face.FaceDetectV3Activity;
import com.bxkj.student.p094v2.p098ui.face.FaceLiveV3Activity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsHomeActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.V3RecordListActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3LocationService;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.step.V3StepService;
import com.bxkj.student.p094v2.p098ui.sports.set.PermissionSetActivity;
import com.bxkj.student.p094v2.p098ui.sports.set.SportsDescriptionActivity;
import com.bxkj.student.p094v2.p098ui.sports.set.SportsSetActivity;
import com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.tabs.TabLayout;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.SportsDb;
import p615l.RequestPermission;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p618m.StartActivityForResult;

/* compiled from: V3SportsHomeActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\bN\u0010OJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0002J\u001e\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0014\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0016\u001a\u00020\u00042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0017\u001a\u00020\u00042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0019\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u001a\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u001b\u001a\u00020\u00042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u001c\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010 \u001a\u00020\u0004H\u0016J\u0006\u0010!\u001a\u00020\u0004J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\b\u0010(\u001a\u00020\u0004H\u0014J\b\u0010)\u001a\u00020\u0004H\u0014J\b\u0010*\u001a\u00020\u0004H\u0014J\b\u0010+\u001a\u00020\u0004H\u0014J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001dH\u0014R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010?R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010ER\u0014\u0010K\u001a\u00020H8\u0002X\u0082D¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010J¨\u0006P"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3SportsHomeBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsHomeVM;", "Lkotlin/f1;", "u0", "x0", "w0", "", C2573a.f8443b, "Lcom/google/android/material/tabs/TabLayout$Tab;", "j0", "cityName", "k0", "", "", "setMap", "h0", "B0", "f0", "i0", "sportsSetMap", "z0", "v0", "it", "g0", "l0", "y0", "A0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", ExifInterface.LONGITUDE_EAST, "t0", "p", "C0", "G0", "D0", "E0", "F0", "onResume", "onPause", "onStop", "onDestroy", "outState", "onSaveInstanceState", "Lcom/amap/api/maps/AMap;", "i", "Lcom/amap/api/maps/AMap;", "aMap", "Lcom/amap/api/maps/LocationSource;", "j", "Lcom/amap/api/maps/LocationSource;", "locationSource", "Lcom/amap/api/location/AMapLocationClient;", "k", "Lcom/amap/api/location/AMapLocationClient;", "mlocationClient", C7304t.f25048d, "Ljava/lang/String;", "weather", "", "m", "I", "sportType", "n", "gpsStatus", "Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "o", "Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "exceptionDialog", "uploadFileDialog", "", CampaignEx.JSON_KEY_AD_Q, "J", "timeInterval", "r", "mLastClickTime", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3SportsHomeActivity extends BaseActivity<AcV3SportsHomeBinding, SportsHomeVM> {

    /* renamed from: i */
    private AMap f20576i;
    @Nullable

    /* renamed from: j */
    private LocationSource f20577j;
    @Nullable

    /* renamed from: k */
    private AMapLocationClient f20578k;
    @Nullable

    /* renamed from: o */
    private iOSTwoButtonDialog f20582o;
    @Nullable

    /* renamed from: p */
    private iOSTwoButtonDialog f20583p;

    /* renamed from: r */
    private long f20585r;
    @NotNull

    /* renamed from: l */
    private String f20579l = "";

    /* renamed from: m */
    private int f20580m = 1;

    /* renamed from: n */
    private int f20581n = -1;

    /* renamed from: q */
    private final long f20584q = 1000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5718a extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f20587b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5718a(Map<String, Object> map) {
            super(0);
            this.f20587b = map;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            V3SportsHomeActivity.this.m38513i0(this.f20587b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "dialog", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5719b extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f20589b;

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5720a implements StartActivityForResult.InterfaceC15293a {

            /* renamed from: a */
            final /* synthetic */ V3SportsHomeActivity f20590a;

            /* renamed from: b */
            final /* synthetic */ Map<String, Object> f20591b;

            C5720a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f20590a = v3SportsHomeActivity;
                this.f20591b = map;
            }

            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public void mo3459a(int i, @Nullable Intent intent) {
                this.f20590a.m38517g0(this.f20591b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5719b(Map<String, Object> map) {
            super(1);
            this.f20589b = map;
        }

        /* renamed from: a */
        public final void m38491a(@NotNull iOSTwoButtonDialog dialog) {
            C14342f0.m8184p(dialog, "dialog");
            dialog.dismiss();
            new StartActivityForResult(V3SportsHomeActivity.this).startActivityForResult(new Intent("android.settings.BATTERY_SAVER_SETTINGS")).m3460c(new C5720a(V3SportsHomeActivity.this, this.f20589b));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38491a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5721c extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        public static final C5721c f20592a = new C5721c();

        C5721c() {
            super(1);
        }

        /* renamed from: a */
        public final void m38490a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            it.dismiss();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38490a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5722d extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        final /* synthetic */ LoadingDialog f20593a;

        /* renamed from: b */
        final /* synthetic */ V3SportsHomeActivity f20594b;

        /* renamed from: c */
        final /* synthetic */ Map<String, Object> f20595c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5722d(LoadingDialog loadingDialog, V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
            super(0);
            this.f20593a = loadingDialog;
            this.f20594b = v3SportsHomeActivity;
            this.f20595c = map;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f20593a.m43874b();
            this.f20594b.m38547B0(this.f20595c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5723e extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        final /* synthetic */ LoadingDialog f20596a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5723e(LoadingDialog loadingDialog) {
            super(0);
            this.f20596a = loadingDialog;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f20596a.m43874b();
        }
    }

    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$f", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5724f implements RequestPermission.InterfaceC15268a {

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f20598b;

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$f$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        static final class C5725a extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

            /* renamed from: a */
            final /* synthetic */ V3SportsHomeActivity f20599a;

            /* renamed from: b */
            final /* synthetic */ Map<String, Object> f20600b;

            /* compiled from: V3SportsHomeActivity.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$f$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$f$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            public static final class C5726a implements StartActivityForResult.InterfaceC15293a {

                /* renamed from: a */
                final /* synthetic */ V3SportsHomeActivity f20601a;

                /* renamed from: b */
                final /* synthetic */ Map<String, Object> f20602b;

                C5726a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                    this.f20601a = v3SportsHomeActivity;
                    this.f20602b = map;
                }

                @Override // p618m.StartActivityForResult.InterfaceC15293a
                /* renamed from: a */
                public void mo3459a(int i, @Nullable Intent intent) {
                    this.f20601a.m38513i0(this.f20602b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5725a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                super(1);
                this.f20599a = v3SportsHomeActivity;
                this.f20600b = map;
            }

            /* renamed from: a */
            public final void m38489a(@NotNull iOSTwoButtonDialog it) {
                C14342f0.m8184p(it, "it");
                C3912s.m44033p(this.f20599a.mo43912w(), new C5726a(this.f20599a, this.f20600b));
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
                m38489a(iostwobuttondialog);
                return Unit.f41048a;
            }
        }

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$f$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        static final class C5727b extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

            /* renamed from: a */
            final /* synthetic */ V3SportsHomeActivity f20603a;

            /* renamed from: b */
            final /* synthetic */ Map<String, Object> f20604b;

            /* compiled from: V3SportsHomeActivity.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$f$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$f$b$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            public static final class C5728a implements StartActivityForResult.InterfaceC15293a {

                /* renamed from: a */
                final /* synthetic */ V3SportsHomeActivity f20605a;

                /* renamed from: b */
                final /* synthetic */ Map<String, Object> f20606b;

                C5728a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                    this.f20605a = v3SportsHomeActivity;
                    this.f20606b = map;
                }

                @Override // p618m.StartActivityForResult.InterfaceC15293a
                /* renamed from: a */
                public void mo3459a(int i, @Nullable Intent intent) {
                    this.f20605a.m38513i0(this.f20606b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5727b(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                super(1);
                this.f20603a = v3SportsHomeActivity;
                this.f20604b = map;
            }

            /* renamed from: a */
            public final void m38488a(@NotNull iOSTwoButtonDialog it) {
                C14342f0.m8184p(it, "it");
                C3912s.m44033p(this.f20603a.mo43912w(), new C5728a(this.f20603a, this.f20604b));
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
                m38488a(iostwobuttondialog);
                return Unit.f41048a;
            }
        }

        C5724f(Map<String, Object> map) {
            this.f20598b = map;
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: a */
        public void mo3478a(@NotNull String[] permission) {
            C14342f0.m8184p(permission, "permission");
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            String string = v3SportsHomeActivity.mo43926C().getString(C4215R.C4224string.not_set_step_permission);
            C14342f0.m8185o(string, "mContext.getString(R.str….not_set_step_permission)");
            ContextExt.m43856h(v3SportsHomeActivity, "权限提示", string, new C5727b(V3SportsHomeActivity.this, this.f20598b), null, null, "去设置", 24, null);
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: b */
        public void mo3477b() {
            V3SportsHomeActivity.this.m38492z0(this.f20598b);
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: c */
        public void mo3476c(@NotNull String[] permission) {
            C14342f0.m8184p(permission, "permission");
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            String string = v3SportsHomeActivity.mo43926C().getString(C4215R.C4224string.not_set_step_permission);
            C14342f0.m8185o(string, "mContext.getString(R.str….not_set_step_permission)");
            ContextExt.m43856h(v3SportsHomeActivity, "权限提示", string, new C5725a(V3SportsHomeActivity.this, this.f20598b), null, null, "去设置", 24, null);
        }
    }

    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\f"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$g", "Lcom/amap/api/services/weather/WeatherSearch$OnWeatherSearchListener;", "Lcom/amap/api/services/weather/LocalWeatherLiveResult;", "weatherLiveResult", "", "rCode", "Lkotlin/f1;", "onWeatherLiveSearched", "Lcom/amap/api/services/weather/LocalWeatherForecastResult;", C7202bq.f24604g, "p1", "onWeatherForecastSearched", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5729g implements WeatherSearch.OnWeatherSearchListener {
        C5729g() {
        }

        @Override // com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener
        public void onWeatherForecastSearched(@Nullable LocalWeatherForecastResult localWeatherForecastResult, int i) {
        }

        @Override // com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener
        public void onWeatherLiveSearched(@Nullable LocalWeatherLiveResult localWeatherLiveResult, int i) {
            if (i != 1000 || localWeatherLiveResult == null || localWeatherLiveResult.getLiveResult() == null) {
                return;
            }
            LocalWeatherLive liveResult = localWeatherLiveResult.getLiveResult();
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            String weather = liveResult.getWeather();
            C14342f0.m8185o(weather, "weatherlive.weather");
            v3SportsHomeActivity.f20579l = weather;
            TextView textView = V3SportsHomeActivity.this.mo43920M().tvWeather;
            textView.setText(((Object) liveResult.getReportTime()) + "发布天气:" + V3SportsHomeActivity.this.f20579l);
        }
    }

    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$h", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5730h implements StartActivityForResult.InterfaceC15293a {

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f20609b;

        C5730h(Map<String, Object> map) {
            this.f20609b = map;
        }

        @Override // p618m.StartActivityForResult.InterfaceC15293a
        /* renamed from: a */
        public void mo3459a(int i, @Nullable Intent intent) {
            V3SportsHomeActivity.this.m38507l0(this.f20609b);
        }
    }

    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$i", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Lkotlin/f1;", "onTabSelected", "onTabUnselected", "onTabReselected", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5731i implements TabLayout.OnTabSelectedListener {
        C5731i() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            if (tab == null) {
                return;
            }
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            SportsType.C5549a c5549a = SportsType.f20137a;
            v3SportsHomeActivity.f20580m = c5549a.m39061c(tab.getText());
            int m39063a = c5549a.m39063a(tab.getText());
            View findViewById = v3SportsHomeActivity.getWindow().findViewById(v3SportsHomeActivity.getResources().getIdentifier("statusBarBackground", "id", FaceEnvironment.f8430OS));
            if (findViewById != null) {
                findViewById.setBackgroundResource(m39063a);
            }
            v3SportsHomeActivity.mo43920M().llTitle.setBackgroundResource(m39063a);
            v3SportsHomeActivity.mo43920M().clData.setBackgroundResource(m39063a);
            int m39056h = c5549a.m39056h(tab.getText());
            MyLocationStyle myLocationStyle = new MyLocationStyle();
            myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(m39056h));
            myLocationStyle.strokeColor(ContextCompat.getColor(v3SportsHomeActivity.mo43926C(), m39063a));
            myLocationStyle.radiusFillColor(ContextCompat.getColor(v3SportsHomeActivity.mo43926C(), c5549a.m39055i(tab.getText())));
            myLocationStyle.strokeWidth(1.0f);
            AMap aMap = v3SportsHomeActivity.f20576i;
            if (aMap == null) {
                C14342f0.m8200S("aMap");
                aMap = null;
            }
            aMap.setMyLocationStyle(myLocationStyle);
            v3SportsHomeActivity.m38495w0();
            v3SportsHomeActivity.mo43920M().ivDescription.setImageResource(c5549a.m39059e(tab.getText()));
            v3SportsHomeActivity.mo43920M().ivStart.setImageResource(c5549a.m39057g(tab.getText()));
            v3SportsHomeActivity.mo43920M().ivPermission.setImageResource(c5549a.m39058f(tab.getText()));
            v3SportsHomeActivity.mo43920M().tvDescriptionV3.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.mo43926C(), m39063a));
            v3SportsHomeActivity.mo43920M().tvPermissionV3.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.mo43926C(), m39063a));
            v3SportsHomeActivity.mo43920M().tvWeather.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.mo43926C(), m39063a));
            v3SportsHomeActivity.mo43920M().tvGps.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.mo43926C(), m39063a));
            v3SportsHomeActivity.mo43920M().ivGps.setImageResource(FormatUtils.m39616u(v3SportsHomeActivity.f20581n, v3SportsHomeActivity.f20580m));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5732j extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {
        C5732j() {
            super(1);
        }

        /* renamed from: a */
        public final void m38487a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            it.dismiss();
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            v3SportsHomeActivity.startActivity(v3SportsHomeActivity.getIntent().setClass(V3SportsHomeActivity.this.mo43926C(), V3RecordListActivity.class).putExtra("toLocal", true));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38487a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5733k extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        public static final C5733k f20612a = new C5733k();

        C5733k() {
            super(1);
        }

        /* renamed from: a */
        public final void m38486a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            it.dismiss();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38486a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "dialog", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5734l extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: b */
        final /* synthetic */ SportsDb f20614b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$l$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5735a extends Lambda implements InterfaceC15269a<Unit> {

            /* renamed from: a */
            public static final C5735a f20615a = new C5735a();

            C5735a() {
                super(0);
            }

            @Override // p617l1.InterfaceC15269a
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5734l(SportsDb sportsDb) {
            super(1);
            this.f20614b = sportsDb;
        }

        /* renamed from: a */
        public final void m38485a(@NotNull iOSTwoButtonDialog dialog) {
            C14342f0.m8184p(dialog, "dialog");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - V3SportsHomeActivity.this.f20585r > V3SportsHomeActivity.this.f20584q) {
                V3SportsHomeActivity.this.mo43911x().m38067L(this.f20614b, C5735a.f20615a);
                V3SportsHomeActivity.this.f20585r = currentTimeMillis;
            }
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38485a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "dialog", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5736m extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ SportsDb f20616a;

        /* renamed from: b */
        final /* synthetic */ V3SportsHomeActivity f20617b;

        /* renamed from: c */
        final /* synthetic */ SportsDb f20618c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$m$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5737a extends Lambda implements InterfaceC15269a<Unit> {

            /* renamed from: a */
            final /* synthetic */ V3SportsHomeActivity f20619a;

            /* renamed from: b */
            final /* synthetic */ SportsDb f20620b;

            /* renamed from: c */
            final /* synthetic */ V3SportsFinishDialog f20621c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: V3SportsHomeActivity.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$m$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            public static final class C5738a extends Lambda implements InterfaceC15269a<Unit> {

                /* renamed from: a */
                final /* synthetic */ V3SportsFinishDialog f20622a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C5738a(V3SportsFinishDialog v3SportsFinishDialog) {
                    super(0);
                    this.f20622a = v3SportsFinishDialog;
                }

                @Override // p617l1.InterfaceC15269a
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f41048a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.f20622a.dismiss();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5737a(V3SportsHomeActivity v3SportsHomeActivity, SportsDb sportsDb, V3SportsFinishDialog v3SportsFinishDialog) {
                super(0);
                this.f20619a = v3SportsHomeActivity;
                this.f20620b = sportsDb;
                this.f20621c = v3SportsFinishDialog;
            }

            @Override // p617l1.InterfaceC15269a
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f20619a.f20585r > this.f20619a.f20584q) {
                    this.f20619a.mo43911x().m38067L(this.f20620b, new C5738a(this.f20621c));
                    this.f20619a.f20585r = currentTimeMillis;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$m$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5739b extends Lambda implements InterfaceC15269a<Unit> {

            /* renamed from: a */
            final /* synthetic */ iOSTwoButtonDialog f20623a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5739b(iOSTwoButtonDialog iostwobuttondialog) {
                super(0);
                this.f20623a = iostwobuttondialog;
            }

            @Override // p617l1.InterfaceC15269a
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.f20623a.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5736m(SportsDb sportsDb, V3SportsHomeActivity v3SportsHomeActivity, SportsDb sportsDb2) {
            super(1);
            this.f20616a = sportsDb;
            this.f20617b = v3SportsHomeActivity;
            this.f20618c = sportsDb2;
        }

        /* renamed from: a */
        public final void m38484a(@NotNull iOSTwoButtonDialog dialog) {
            List m12218L5;
            boolean m6604K1;
            int m12076p5;
            C14342f0.m8184p(dialog, "dialog");
            SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
            c5481g.m39250v().clear();
            Map<String, Object> m39250v = c5481g.m39250v();
            JsonGet jsonGet = JsonGet.f15134a;
            m39250v.putAll(jsonGet.m43782A(this.f20616a.m58121L()));
            c5481g.m39253s().clear();
            List<Map<String, Object>> m39253s = c5481g.m39253s();
            m12218L5 = _Collections.m12218L5(jsonGet.m43754z(this.f20616a.m58123J()));
            m39253s.addAll(m12218L5);
            c5481g.m39265h0(Long.parseLong(this.f20616a.m58118O()));
            c5481g.m39293N(Long.parseLong(this.f20616a.m58062z()));
            c5481g.m39291P(Double.parseDouble(this.f20616a.m58132A()));
            c5481g.m39279a0(Integer.parseInt(this.f20616a.m58112U()));
            c5481g.m39290Q(Double.parseDouble(this.f20616a.m58129D()));
            String m58122K = this.f20616a.m58122K();
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
            c5481g.m39286U(this.f20616a.m58127F().length() == 0 ? Utils.DOUBLE_EPSILON : Double.parseDouble(this.f20616a.m58127F()));
            String m39636a = FormatUtils.m39636a(Double.parseDouble(this.f20616a.m58132A()), Long.parseLong(this.f20616a.m58062z()));
            C14342f0.m8185o(m39636a, "calAvgSpeed(\n           …                        )");
            c5481g.m39294M(m39636a);
            String m39635b = FormatUtils.m39635b(Double.parseDouble(this.f20616a.m58132A()), Long.parseLong(this.f20616a.m58062z()));
            C14342f0.m8185o(m39635b, "calPace(\n               …                        )");
            c5481g.m39275c0(m39635b);
            c5481g.m39266h().setValue(Integer.valueOf(Integer.parseInt(this.f20616a.m58128E())));
            c5481g.m39264i().setValue(Boolean.valueOf(Boolean.parseBoolean(this.f20616a.m58113T())));
            c5481g.m39295L();
            List latLngList = JSON.parseArray(this.f20616a.m58125H(), PointData.class);
            c5481g.m39256p().clear();
            List<PointData> m39256p = c5481g.m39256p();
            C14342f0.m8185o(latLngList, "latLngList");
            m39256p.addAll(latLngList);
            List list = latLngList.size() > 0 ? latLngList : null;
            if (list != null) {
                PointData pointData = (PointData) list.get(list.size() - 1);
                if (pointData != null) {
                    pointData.setI(true);
                }
                LatLng latLng = new LatLng(((PointData) latLngList.get(0)).getA(), ((PointData) latLngList.get(0)).getO());
                c5481g.m39267g0(latLng);
                c5481g.m39297J(latLng);
            }
            List stepCountList = JSON.parseArray(this.f20616a.m58117P(), Integer.TYPE);
            if (stepCountList != null) {
                m12076p5 = _Collections.m12076p5(stepCountList);
                c5481g.m39263i0(m12076p5);
            }
            c5481g.m39246z().clear();
            List<Integer> m39246z = c5481g.m39246z();
            C14342f0.m8185o(stepCountList, "stepCountList");
            m39246z.addAll(stepCountList);
            V3SportsFinishDialog v3SportsFinishDialog = new V3SportsFinishDialog();
            V3SportsHomeActivity v3SportsHomeActivity = this.f20617b;
            SportsDb sportsDb = this.f20618c;
            FragmentManager supportFragmentManager = v3SportsHomeActivity.getSupportFragmentManager();
            C14342f0.m8185o(supportFragmentManager, "supportFragmentManager");
            v3SportsFinishDialog.show(supportFragmentManager, "finishDialog");
            v3SportsFinishDialog.m38562a0(new C5737a(v3SportsHomeActivity, sportsDb, v3SportsFinishDialog));
            v3SportsFinishDialog.m38561b0(new C5739b(dialog));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38484a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$n */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5740n extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        public static final C5740n f20624a = new C5740n();

        C5740n() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$o */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5741o extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f20626b;

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$o$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$o$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5742a implements StartActivityForResult.InterfaceC15293a {

            /* renamed from: a */
            final /* synthetic */ V3SportsHomeActivity f20627a;

            /* renamed from: b */
            final /* synthetic */ Map<String, Object> f20628b;

            C5742a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f20627a = v3SportsHomeActivity;
                this.f20628b = map;
            }

            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public void mo3459a(int i, @Nullable Intent intent) {
                this.f20627a.m38496v0(this.f20628b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5741o(Map<String, Object> map) {
            super(1);
            this.f20626b = map;
        }

        /* renamed from: a */
        public final void m38483a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            it.dismiss();
            NotificationsUtils.m44049c(V3SportsHomeActivity.this.mo43912w(), new C5742a(V3SportsHomeActivity.this, this.f20626b));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38483a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$p */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5743p extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        public static final C5743p f20629a = new C5743p();

        C5743p() {
            super(1);
        }

        /* renamed from: a */
        public final void m38482a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            it.dismiss();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38482a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$q", "Lcom/amap/api/maps/LocationSource;", "Lcom/amap/api/maps/LocationSource$OnLocationChangedListener;", "listener", "Lkotlin/f1;", "activate", "deactivate", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$q */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5744q implements LocationSource {
        C5744q() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static final void m38480b(LocationSource.OnLocationChangedListener listener, V3SportsHomeActivity this$0, AMapLocation aMapLocation) {
            C14342f0.m8184p(listener, "$listener");
            C14342f0.m8184p(this$0, "this$0");
            if (Build.VERSION.SDK_INT >= 18) {
                C11792j.m20469d("isFromMockProvider=" + aMapLocation.isFromMockProvider() + "\nisMock=" + aMapLocation.isMock() + "\nisInstalledHighDangerMockApp=" + aMapLocation.getLocationQualityReport().isInstalledHighDangerMockApp(), new Object[0]);
            }
            listener.onLocationChanged(aMapLocation);
            this$0.f20581n = aMapLocation.getGpsAccuracyStatus();
            this$0.mo43920M().ivGps.setImageResource(FormatUtils.m39616u(this$0.f20581n, this$0.f20580m));
            AMap aMap = null;
            if ((aMapLocation.getErrorCode() == 0 ? aMapLocation : null) == null) {
                return;
            }
            AMap aMap2 = this$0.f20576i;
            if (aMap2 == null) {
                C14342f0.m8200S("aMap");
            } else {
                aMap = aMap2;
            }
            aMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
            String city = aMapLocation.getCity();
            C14342f0.m8185o(city, "aMapLocation.city");
            this$0.m38509k0(city);
        }

        @Override // com.amap.api.maps.LocationSource
        public void activate(@NotNull final LocationSource.OnLocationChangedListener listener) {
            C14342f0.m8184p(listener, "listener");
            if (V3SportsHomeActivity.this.f20578k == null) {
                V3SportsHomeActivity.this.f20578k = new AMapLocationClient(BaseApp.m44341b());
                AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                aMapLocationClientOption.setMockEnable(false);
                AMapLocationClient aMapLocationClient = V3SportsHomeActivity.this.f20578k;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(aMapLocationClientOption);
                }
                AMapLocationClient aMapLocationClient2 = V3SportsHomeActivity.this.f20578k;
                if (aMapLocationClient2 != null) {
                    final V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
                    aMapLocationClient2.setLocationListener(new AMapLocationListener() { // from class: com.bxkj.student.v2.ui.sports.v3.n
                        @Override // com.amap.api.location.AMapLocationListener
                        public final void onLocationChanged(AMapLocation aMapLocation) {
                            V3SportsHomeActivity.C5744q.m38480b(LocationSource.OnLocationChangedListener.this, v3SportsHomeActivity, aMapLocation);
                        }
                    });
                }
                AMapLocationClient aMapLocationClient3 = V3SportsHomeActivity.this.f20578k;
                if (aMapLocationClient3 == null) {
                    return;
                }
                aMapLocationClient3.startLocation();
            }
        }

        @Override // com.amap.api.maps.LocationSource
        public void deactivate() {
            AMapLocationClient aMapLocationClient = V3SportsHomeActivity.this.f20578k;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            AMapLocationClient aMapLocationClient2 = V3SportsHomeActivity.this.f20578k;
            if (aMapLocationClient2 != null) {
                aMapLocationClient2.onDestroy();
            }
            V3SportsHomeActivity.this.f20578k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$r */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5745r extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f20632b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$r$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5746a extends Lambda implements InterfaceC15269a<Unit> {

            /* renamed from: a */
            final /* synthetic */ Map<String, Object> f20633a;

            /* renamed from: b */
            final /* synthetic */ V3SportsHomeActivity f20634b;

            /* renamed from: c */
            final /* synthetic */ iOSTwoButtonDialog f20635c;

            /* compiled from: V3SportsHomeActivity.kt */
            @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$r$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$r$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            public static final class C5747a implements StartActivityForResult.InterfaceC15293a {

                /* renamed from: a */
                final /* synthetic */ iOSTwoButtonDialog f20636a;

                /* renamed from: b */
                final /* synthetic */ V3SportsHomeActivity f20637b;

                /* renamed from: c */
                final /* synthetic */ Map<String, Object> f20638c;

                C5747a(iOSTwoButtonDialog iostwobuttondialog, V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                    this.f20636a = iostwobuttondialog;
                    this.f20637b = v3SportsHomeActivity;
                    this.f20638c = map;
                }

                @Override // p618m.StartActivityForResult.InterfaceC15293a
                /* renamed from: a */
                public void mo3459a(int i, @Nullable Intent intent) {
                    if (i == -1) {
                        this.f20636a.dismiss();
                        this.f20637b.m38548A0(this.f20638c);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C5746a(Map<String, Object> map, V3SportsHomeActivity v3SportsHomeActivity, iOSTwoButtonDialog iostwobuttondialog) {
                super(0);
                this.f20633a = map;
                this.f20634b = v3SportsHomeActivity;
                this.f20635c = iostwobuttondialog;
            }

            @Override // p617l1.InterfaceC15269a
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f41048a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                JsonGet jsonGet = JsonGet.f15134a;
                Class cls = jsonGet.m43769k(this.f20633a, "livingFace") == 1 ? FaceLiveV3Activity.class : FaceDetectV3Activity.class;
                StartActivityForResult startActivityForResult = new StartActivityForResult(this.f20634b.mo43912w());
                Intent putExtra = this.f20634b.getIntent().setClass(this.f20634b.mo43926C(), cls).putExtra("identify", jsonGet.m43760t(this.f20633a, "identify")).putExtra("runType", jsonGet.m43768l(this.f20633a, "runType", 1)).putExtra("type", "1");
                C14342f0.m8185o(putExtra, "intent.setClass(mContext…a(\"type\", FaceType.Start)");
                startActivityForResult.startActivityForResult(putExtra).m3460c(new C5747a(this.f20635c, this.f20634b, this.f20633a));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5745r(Map<String, Object> map) {
            super(1);
            this.f20632b = map;
        }

        /* renamed from: a */
        public final void m38479a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            PermissionExt.m43841c(v3SportsHomeActivity, "人脸识别", new C5746a(this.f20632b, v3SportsHomeActivity, it));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38479a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$s */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5748s extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        public static final C5748s f20639a = new C5748s();

        C5748s() {
            super(1);
        }

        /* renamed from: a */
        public final void m38478a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            it.dismiss();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38478a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$t */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5749t extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f20641b;

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$t$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$t$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5750a implements StartActivityForResult.InterfaceC15293a {

            /* renamed from: a */
            final /* synthetic */ V3SportsHomeActivity f20642a;

            /* renamed from: b */
            final /* synthetic */ Map<String, Object> f20643b;

            C5750a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f20642a = v3SportsHomeActivity;
                this.f20643b = map;
            }

            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public void mo3459a(int i, @Nullable Intent intent) {
                this.f20642a.m38492z0(this.f20643b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5749t(Map<String, Object> map) {
            super(1);
            this.f20641b = map;
        }

        /* renamed from: a */
        public final void m38477a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            it.dismiss();
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            new StartActivityForResult(V3SportsHomeActivity.this.mo43912w()).startActivityForResult(intent).m3460c(new C5750a(V3SportsHomeActivity.this, this.f20641b));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38477a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$u */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5751u extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        public static final C5751u f20644a = new C5751u();

        C5751u() {
            super(1);
        }

        /* renamed from: a */
        public final void m38476a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            it.dismiss();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m38476a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$v */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5752v extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f20646b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5752v(Map<String, Object> map) {
            super(0);
            this.f20646b = map;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (Build.VERSION.SDK_INT >= 29) {
                V3SportsHomeActivity.this.m38519f0(this.f20646b);
            } else {
                V3SportsHomeActivity.this.m38492z0(this.f20646b);
            }
        }
    }

    static {
        StubApp.interface11(12643);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public final void m38548A0(Map<String, Object> map) {
        AppManager.m57776n().m57781i(V3SportsMapActivity.class);
        AppManager.m57776n().m57781i(V3SportsActivity.class);
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        c5481g.m39250v().clear();
        c5481g.m39250v().putAll(map);
        String m43760t = JsonGet.f15134a.m43760t(map, "lastExerciseExplanationDate");
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        if (c3984b.m43634a().m43649m() && C14342f0.m8193g(m43760t, c3984b.m43634a().m43653i())) {
            startActivity(new Intent(mo43926C(), V3SportsMapActivity.class));
            overridePendingTransition(C4215R.anim.qr_code_zoom_in, C4215R.anim.qr_code_zoom_out);
            return;
        }
        c3984b.m43634a().m43676O(false);
        c3984b.m43634a().m43681J(m43760t);
        startActivity(getIntent().setClass(mo43926C(), SportsDescriptionActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public final void m38547B0(Map<String, Object> map) {
        PermissionExt.m43835i(this, new C5752v(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public final void m38519f0(Map<String, Object> map) {
        PermissionExt.m43842b(this, new C5718a(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public final void m38517g0(Map<String, Object> map) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object systemService = getSystemService("power");
            if (systemService != null) {
                if (((PowerManager) systemService).isPowerSaveMode()) {
                    ContextExt.m43856h(this, "请勿开启省电模式", "开始锻炼前请关闭省电模式，否则轨迹记录可能不准确！", new C5719b(map), C5721c.f20592a, null, null, 48, null);
                    return;
                } else {
                    m38507l0(map);
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        }
        m38507l0(map);
    }

    /* renamed from: h0 */
    private final void m38515h0(Map<String, Object> map) {
        LoadingDialog loadingDialog = new LoadingDialog(mo43912w());
        loadingDialog.m43868h();
        SQZSManager.f20133a.m39066c(mo43912w(), new C5722d(loadingDialog, this, map), new C5723e(loadingDialog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public final void m38513i0(Map<String, Object> map) {
        new RequestPermission(mo43912w()).m3480c("android.permission.ACTIVITY_RECOGNITION").m3479d(new C5724f(map));
    }

    /* renamed from: j0 */
    private final TabLayout.Tab m38511j0(String str) {
        int tabCount = mo43920M().tab.getTabCount();
        if (tabCount <= 0) {
            return null;
        }
        int i = 0;
        TabLayout.Tab tab = null;
        while (true) {
            int i2 = i + 1;
            TabLayout.Tab tabAt = mo43920M().tab.getTabAt(i);
            if (C14342f0.m8193g(str, tabAt == null ? null : tabAt.getText())) {
                tab = mo43920M().tab.getTabAt(i);
            }
            if (i2 >= tabCount) {
                return tab;
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public final void m38509k0(String str) {
        WeatherSearchQuery weatherSearchQuery = new WeatherSearchQuery(str, 1);
        WeatherSearch weatherSearch = new WeatherSearch(this);
        weatherSearch.setOnWeatherSearchListener(new C5729g());
        weatherSearch.setQuery(weatherSearchQuery);
        weatherSearch.searchWeatherAsyn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public final void m38507l0(Map<String, Object> map) {
        if (Build.VERSION.SDK_INT >= 23) {
            Object systemService = getSystemService("power");
            if (systemService != null) {
                if (!((PowerManager) systemService).isIgnoringBatteryOptimizations(getPackageName())) {
                    Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent.setData(Uri.parse(C14342f0.m8216C("package:", getPackageName())));
                    try {
                        new StartActivityForResult(mo43912w()).startActivityForResult(intent).m3460c(new C5730h(map));
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                m38493y0(map);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        }
        m38493y0(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public static final void m38505m0(V3SportsHomeActivity this$0, Map map) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38495w0();
        if (!(JsonGet.f15134a.m43769k(map, "isShow") == 1)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        if ((this$0.m38511j0("自由跑") == null ? map : null) == null) {
            return;
        }
        this$0.mo43920M().tab.addTab(this$0.mo43920M().tab.newTab().setText("自由跑"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public static final void m38504n0(V3SportsHomeActivity this$0, Map map) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38495w0();
        if (!(JsonGet.f15134a.m43769k(map, "isShow") == 1)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        if ((this$0.m38511j0("场地锻炼") == null ? map : null) == null) {
            return;
        }
        this$0.mo43920M().tab.addTab(this$0.mo43920M().tab.newTab().setText("场地锻炼"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public static final void m38503o0(V3SportsHomeActivity this$0, List list) {
        C14342f0.m8184p(this$0, "this$0");
        iOSTwoButtonDialog iostwobuttondialog = this$0.f20583p;
        if (iostwobuttondialog != null) {
            if (!iostwobuttondialog.isShowing()) {
                iostwobuttondialog = null;
            }
            if (iostwobuttondialog != null) {
                iostwobuttondialog.dismiss();
            }
        }
        if (list == null) {
            return;
        }
        if (!(!list.isEmpty())) {
            list = null;
        }
        if (list == null) {
            return;
        }
        iOSTwoButtonDialog m43856h = ContextExt.m43856h(this$0, null, "系统检测到您还有" + list.size() + "条锻炼记录在本地暂存,是否上传？", new C5732j(), C5733k.f20612a, null, null, 49, null);
        m43856h.setCancelable(false);
        m43856h.setClickAutoCancel(false);
        m43856h.setCanceledOnTouchOutside(false);
        m43856h.setLeftButtonText("暂存本地");
        m43856h.setRightButtonText("现在上传");
        Unit unit = Unit.f41048a;
        this$0.f20583p = m43856h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public static final void m38502p0(V3SportsHomeActivity this$0, List list) {
        SportsDb sportsDb;
        String str;
        C14342f0.m8184p(this$0, "this$0");
        if (list != null) {
            List list2 = list.isEmpty() ? list : null;
            if (list2 != null) {
                C11792j.m20469d(C14342f0.m8216C("没有有异常结束数据=", list2), new Object[0]);
                iOSTwoButtonDialog iostwobuttondialog = this$0.f20582o;
                if (iostwobuttondialog != null) {
                    if (!iostwobuttondialog.isShowing()) {
                        iostwobuttondialog = null;
                    }
                    if (iostwobuttondialog != null) {
                        iostwobuttondialog.dismiss();
                    }
                }
            }
        }
        if (list == null) {
            return;
        }
        if (!(!list.isEmpty())) {
            list = null;
        }
        if (list == null || (sportsDb = (SportsDb) list.get(0)) == null) {
            return;
        }
        iOSTwoButtonDialog iostwobuttondialog2 = this$0.f20582o;
        if (iostwobuttondialog2 != null) {
            C14342f0.m8187m(iostwobuttondialog2);
            if (iostwobuttondialog2.isShowing()) {
                return;
            }
        }
        C11792j.m20469d(C14342f0.m8216C("有异常结束数据=", sportsDb), new Object[0]);
        FragmentActivity mo43912w = this$0.mo43912w();
        StringBuilder sb = new StringBuilder();
        sb.append("系统检测到您在");
        sb.append(DataFormatUtils.m43808a(sportsDb.m58118O()));
        sb.append("开始的的");
        if (Integer.parseInt(sportsDb.m58120M()) == 5) {
            str = "";
        } else {
            str = "已运动" + ((Object) FormatUtils.m39634c(Double.parseDouble(sportsDb.m58132A()))) + "KM";
        }
        sb.append(str);
        sb.append("用时");
        sb.append((Object) FormatUtils.m39630g(Long.parseLong(sportsDb.m58062z())));
        sb.append((char) 30340);
        sb.append(SportsType.f20137a.m39060d(Integer.parseInt(sportsDb.m58120M())));
        sb.append("记录异常结束,强烈建议您检查运动权限设置是否正确后尽快恢复继续锻炼");
        iOSTwoButtonDialog m43856h = ContextExt.m43856h(mo43912w, null, sb.toString(), new C5734l(sportsDb), new C5736m(sportsDb, this$0, sportsDb), null, null, 49, null);
        m43856h.setCancelable(false);
        m43856h.setClickAutoCancel(false);
        m43856h.setCanceledOnTouchOutside(false);
        m43856h.setLeftButtonText("结束并上传");
        m43856h.setRightButtonText("恢复继续锻炼");
        Unit unit = Unit.f41048a;
        this$0.f20582o = m43856h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public static final void m38501q0(V3SportsHomeActivity this$0, Map map) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38495w0();
        if (!(JsonGet.f15134a.m43769k(map, "isShow") == 1)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        if ((this$0.m38511j0("早操跑") == null ? map : null) == null) {
            return;
        }
        this$0.mo43920M().tab.addTab(this$0.mo43920M().tab.newTab().setText("早操跑"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        if (r0 != false) goto L16;
     */
    /* renamed from: r0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m38500r0(com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsHomeActivity r5, java.util.Map r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.C14342f0.m8184p(r5, r0)
            if (r6 != 0) goto L9
            goto L78
        L9:
            com.bxkj.base.v2.common.utils.l r0 = com.bxkj.base.p085v2.common.utils.JsonGet.f15134a
            java.lang.String r1 = "identify"
            java.lang.String r1 = r0.m43760t(r6, r1)
            java.lang.String r2 = "isFromLocalToContinue"
            boolean r2 = r0.m43776d(r6, r2)
            r2 = r2 ^ 1
            r3 = 0
            if (r2 == 0) goto L1e
            r2 = r6
            goto L1f
        L1e:
            r2 = r3
        L1f:
            if (r2 != 0) goto L22
            goto L2b
        L22:
            com.bxkj.base.v2.base.BaseViewModel r2 = r5.mo43911x()
            com.bxkj.student.v2.vm.sports.SportsHomeVM r2 = (com.bxkj.student.p094v2.p103vm.sports.SportsHomeVM) r2
            r2.m38073F(r1)
        L2b:
            java.lang.String r1 = "limitWeather"
            java.lang.String r0 = r0.m43760t(r6, r1)
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.C14342f0.m8193g(r0, r1)
            if (r0 == 0) goto L75
            java.lang.String r0 = r5.f20579l
            java.lang.String r1 = "雨"
            r2 = 0
            r4 = 2
            boolean r0 = kotlin.text.C14573n.m6767V2(r0, r1, r2, r4, r3)
            if (r0 != 0) goto L59
            java.lang.String r0 = r5.f20579l
            java.lang.String r1 = "雪"
            boolean r0 = kotlin.text.C14573n.m6767V2(r0, r1, r2, r4, r3)
            if (r0 != 0) goto L59
            java.lang.String r0 = r5.f20579l
            java.lang.String r1 = "霾"
            boolean r0 = kotlin.text.C14573n.m6767V2(r0, r1, r2, r4, r3)
            if (r0 == 0) goto L75
        L59:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "当前天气："
            r6.append(r0)
            java.lang.String r0 = r5.f20579l
            r6.append(r0)
            java.lang.String r0 = ",不能进行锻炼"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.bxkj.base.p085v2.common.ext.ContextExt.m43851m(r5, r6)
            goto L78
        L75:
            r5.m38515h0(r6)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsHomeActivity.m38500r0(com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity, java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public static final void m38499s0(V3SportsHomeActivity this$0, Map map) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38495w0();
        if (!(JsonGet.f15134a.m43769k(map, "isShow") == 1)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        if ((this$0.m38511j0("阳光跑") == null ? map : null) == null) {
            return;
        }
        TabLayout.Tab text = this$0.mo43920M().tab.newTab().setText("阳光跑");
        C14342f0.m8185o(text, "mDataBinding.tab.newTab().setText(\"阳光跑\")");
        this$0.mo43920M().tab.addTab(text);
        text.select();
    }

    /* renamed from: u0 */
    private final void m38497u0() {
        PermissionExt.m43835i(this, C5740n.f20624a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public final void m38496v0(Map<String, Object> map) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (!NotificationsUtils.m44051a(mo43926C())) {
                ContextExt.m43856h(this, "允许体适能推送通知未开启", "为了能够让你在锻炼过程中不错过重要的通知消息,必须开启允许推送通知功能", new C5741o(map), C5743p.f20629a, null, null, 48, null);
                return;
            } else {
                m38517g0(map);
                return;
            }
        }
        m38517g0(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public final void m38495w0() {
        mo43920M().setRecordMap(mo43911x().m38072G(this.f20580m));
    }

    /* renamed from: x0 */
    private final void m38494x0() {
        AMap map = mo43920M().map.getMap();
        C14342f0.m8185o(map, "mDataBinding.map.map");
        this.f20576i = map;
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(C4215R.mipmap.location_marker));
        myLocationStyle.strokeColor(ViewCompat.MEASURED_STATE_MASK);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        myLocationStyle.myLocationType(5);
        AMap aMap = this.f20576i;
        AMap aMap2 = null;
        if (aMap == null) {
            C14342f0.m8200S("aMap");
            aMap = null;
        }
        aMap.setMyLocationStyle(myLocationStyle);
        this.f20577j = new C5744q();
        AMap aMap3 = this.f20576i;
        if (aMap3 == null) {
            C14342f0.m8200S("aMap");
            aMap3 = null;
        }
        aMap3.setLocationSource(this.f20577j);
        AMap aMap4 = this.f20576i;
        if (aMap4 == null) {
            C14342f0.m8200S("aMap");
            aMap4 = null;
        }
        aMap4.getUiSettings().setMyLocationButtonEnabled(true);
        AMap aMap5 = this.f20576i;
        if (aMap5 == null) {
            C14342f0.m8200S("aMap");
            aMap5 = null;
        }
        aMap5.setMyLocationEnabled(true);
        CameraUpdate zoomTo = CameraUpdateFactory.zoomTo(19.0f);
        AMap aMap6 = this.f20576i;
        if (aMap6 == null) {
            C14342f0.m8200S("aMap");
        } else {
            aMap2 = aMap6;
        }
        aMap2.moveCamera(zoomTo);
    }

    /* renamed from: y0 */
    private final void m38493y0(Map<String, Object> map) {
        JsonGet jsonGet = JsonGet.f15134a;
        if (jsonGet.m43769k(map, "isStartFace") == 1 && !jsonGet.m43776d(map, "isFromLocalToContinue")) {
            iOSTwoButtonDialog m43856h = ContextExt.m43856h(this, null, C14342f0.m8216C(SportsType.f20137a.m39060d(jsonGet.m43769k(map, "runType")), "开始前，请先进行人脸识别"), new C5745r(map), C5748s.f20639a, null, null, 49, null);
            m43856h.setClickAutoCancel(false);
            m43856h.setCancelable(false);
            m43856h.setCanceledOnTouchOutside(false);
            return;
        }
        m38548A0(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public final void m38492z0(Map<String, Object> map) {
        Object systemService = getSystemService(SocializeConstants.KEY_LOCATION);
        if (systemService != null) {
            if (!((LocationManager) systemService).isProviderEnabled(GeocodeSearch.GPS)) {
                String string = getString(C4215R.C4224string.run_request_location);
                C14342f0.m8185o(string, "getString(R.string.run_request_location)");
                ContextExt.m43856h(this, "GPS未开启", string, new C5749t(map), C5751u.f20644a, null, null, 48, null);
                return;
            }
            m38496v0(map);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }

    /* renamed from: C0 */
    public final void m38546C0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f20585r > this.f20584q) {
            SportsHomeVM mo43911x = mo43911x();
            SportsType.C5549a c5549a = SportsType.f20137a;
            TabLayout.Tab tabAt = mo43920M().tab.getTabAt(mo43920M().tab.getSelectedTabPosition());
            mo43911x.m38076C(c5549a.m39061c(tabAt == null ? null : tabAt.getText()));
            this.f20585r = currentTimeMillis;
        }
    }

    /* renamed from: D0 */
    public final void m38545D0() {
        startActivity(new Intent(mo43926C(), SportsDescriptionActivity.class).putExtra("showBottom", false));
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setBackEvent(this);
        mo43911x().m38074E();
        mo43911x().m38068K();
        mo43911x().m38069J();
        m38497u0();
        if (getIntent().hasExtra("title")) {
            mo43920M().setTitle(getIntent().getStringExtra("title"));
        } else {
            mo43920M().setTitle("APP跑步");
        }
        m38494x0();
    }

    /* renamed from: E0 */
    public final void m38544E0() {
        startActivity(new Intent(mo43926C(), PermissionSetActivity.class));
    }

    /* renamed from: F0 */
    public final void m38543F0() {
        startActivity(new Intent(mo43926C(), V3RecordListActivity.class));
    }

    /* renamed from: G0 */
    public final void m38542G0() {
        startActivity(new Intent(mo43926C(), SportsSetActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocationSource locationSource = this.f20577j;
        if (locationSource != null) {
            locationSource.deactivate();
        }
        AMapLocationClient aMapLocationClient = this.f20578k;
        if (aMapLocationClient != null) {
            aMapLocationClient.onDestroy();
        }
        mo43920M().map.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        mo43920M().map.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Window window;
        super.onResume();
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            Context mo43926C = mo43926C();
            SportsType.C5549a c5549a = SportsType.f20137a;
            TabLayout.Tab tabAt = mo43920M().tab.getTabAt(mo43920M().tab.getSelectedTabPosition());
            window.setStatusBarColor(ContextCompat.getColor(mo43926C, c5549a.m39063a(tabAt == null ? null : tabAt.getText())));
        }
        mo43920M().map.onResume();
        AMapLocationClient aMapLocationClient = this.f20578k;
        if (aMapLocationClient != null) {
            aMapLocationClient.startLocation();
        }
        stopService(new Intent(this, V3LocationService.class));
        stopService(new Intent(this, V3StepService.class));
        Object systemService = getSystemService("notification");
        if (systemService != null) {
            ((NotificationManager) systemService).cancel(100);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        C14342f0.m8184p(outState, "outState");
        super.onSaveInstanceState(outState);
        mo43920M().map.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AMapLocationClient aMapLocationClient = this.f20578k;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
        super.onStop();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43920M().tab.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C5731i());
        mo43911x().m38078A().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.m38501q0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
        mo43911x().m38071H().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.m38499s0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
        mo43911x().m38051y().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.m38505m0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
        mo43911x().m38052x().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.m38504n0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
        mo43911x().m38070I().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.m38503o0(V3SportsHomeActivity.this, (List) obj);
            }
        });
        mo43911x().m38053w().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.m38502p0(V3SportsHomeActivity.this, (List) obj);
            }
        });
        mo43911x().m38077B().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.m38500r0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
    }

    /* renamed from: t0 */
    public final void m38498t0() {
        mo43911x().m38074E();
        mo43911x().m38068K();
    }
}
