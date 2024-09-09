package com.bxkj.student.v2.ui.sports.v3;

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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
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
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.databinding.AcV3SportsHomeBinding;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.b;
import com.bxkj.student.v2.common.utils.o;
import com.bxkj.student.v2.ui.face.FaceDetectV3Activity;
import com.bxkj.student.v2.ui.face.FaceLiveV3Activity;
import com.bxkj.student.v2.ui.sports.set.PermissionSetActivity;
import com.bxkj.student.v2.ui.sports.set.SportsDescriptionActivity;
import com.bxkj.student.v2.ui.sports.set.SportsSetActivity;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity;
import com.bxkj.student.v2.ui.sports.v3.service.V3LocationService;
import com.bxkj.student.v2.ui.sports.v3.service.step.V3StepService;
import com.bxkj.student.v2.vm.sports.SportsHomeVM;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import l.b;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3SportsHomeActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0002J\u001e\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0014\u001a\u00020\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0016\u001a\u00020\u00042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0017\u001a\u00020\u00042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u0019\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u001a\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u001b\u001a\u00020\u00042\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u001e\u0010\u001c\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010 \u001a\u00020\u0004H\u0016J\u0006\u0010!\u001a\u00020\u0004J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\b\u0010(\u001a\u00020\u0004H\u0014J\b\u0010)\u001a\u00020\u0004H\u0014J\b\u0010*\u001a\u00020\u0004H\u0014J\b\u0010+\u001a\u00020\u0004H\u0014J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001dH\u0014R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010ER\u0014\u0010K\u001a\u00020H8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010J\u00a8\u0006P"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3SportsHomeBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsHomeVM;", "Lkotlin/f1;", "u0", "x0", "w0", "", "text", "Lcom/google/android/material/tabs/TabLayout$Tab;", "j0", "cityName", "k0", "", "", "setMap", "h0", "B0", "f0", "i0", "sportsSetMap", "z0", "v0", "it", "g0", "l0", "y0", "A0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "E", "t0", "p", "C0", "G0", "D0", "E0", "F0", "onResume", "onPause", "onStop", "onDestroy", "outState", "onSaveInstanceState", "Lcom/amap/api/maps/AMap;", "i", "Lcom/amap/api/maps/AMap;", "aMap", "Lcom/amap/api/maps/LocationSource;", "j", "Lcom/amap/api/maps/LocationSource;", "locationSource", "Lcom/amap/api/location/AMapLocationClient;", "k", "Lcom/amap/api/location/AMapLocationClient;", "mlocationClient", "l", "Ljava/lang/String;", "weather", "", "m", "I", "sportType", "n", "gpsStatus", "Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "o", "Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "exceptionDialog", "uploadFileDialog", "", CampaignEx.JSON_KEY_AD_Q, "J", "timeInterval", "r", "mLastClickTime", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3SportsHomeActivity extends BaseActivity<AcV3SportsHomeBinding, SportsHomeVM> {

    /* renamed from: i  reason: collision with root package name */
    private AMap f23979i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private LocationSource f23980j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private AMapLocationClient f23981k;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private iOSTwoButtonDialog f23985o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private iOSTwoButtonDialog f23986p;

    /* renamed from: r  reason: collision with root package name */
    private long f23988r;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private String f23982l = "";

    /* renamed from: m  reason: collision with root package name */
    private int f23983m = 1;

    /* renamed from: n  reason: collision with root package name */
    private int f23984n = -1;

    /* renamed from: q  reason: collision with root package name */
    private final long f23987q = 1000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends Lambda implements l1.a<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f23990b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Map<String, Object> map) {
            super(0);
            this.f23990b = map;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m69invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m69invoke() {
            V3SportsHomeActivity.this.i0(this.f23990b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "dialog", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f23992b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f23993a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f23994b;

            a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f23993a = v3SportsHomeActivity;
                this.f23994b = map;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                this.f23993a.g0(this.f23994b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Map<String, Object> map) {
            super(1);
            this.f23992b = map;
        }

        public final void a(@NotNull iOSTwoButtonDialog dialog) {
            f0.p(dialog, "dialog");
            dialog.dismiss();
            new m.b(V3SportsHomeActivity.this).startActivityForResult(new Intent("android.settings.BATTERY_SAVER_SETTINGS")).c(new a(V3SportsHomeActivity.this, this.f23992b));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f23995a = new c();

        c() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            it.dismiss();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends Lambda implements l1.a<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.base.v2.base.m f23996a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V3SportsHomeActivity f23997b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f23998c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(com.bxkj.base.v2.base.m mVar, V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
            super(0);
            this.f23996a = mVar;
            this.f23997b = v3SportsHomeActivity;
            this.f23998c = map;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m70invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m70invoke() {
            this.f23996a.b();
            this.f23997b.B0(this.f23998c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e extends Lambda implements l1.a<f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.base.v2.base.m f23999a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(com.bxkj.base.v2.base.m mVar) {
            super(0);
            this.f23999a = mVar;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m71invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m71invoke() {
            this.f23999a.b();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$f", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class f implements b.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f24001b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        static final class a extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f24002a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24003b;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* compiled from: V3SportsHomeActivity.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$f$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$f$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            public static final class C0316a implements b.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ V3SportsHomeActivity f24004a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Map<String, Object> f24005b;

                C0316a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                    this.f24004a = v3SportsHomeActivity;
                    this.f24005b = map;
                }

                @Override // m.b.a
                public void a(int i4, @Nullable Intent intent) {
                    this.f24004a.i0(this.f24005b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                super(1);
                this.f24002a = v3SportsHomeActivity;
                this.f24003b = map;
            }

            public final void a(@NotNull iOSTwoButtonDialog it) {
                f0.p(it, "it");
                com.bxkj.base.util.s.p(this.f24002a.w(), new C0316a(this.f24002a, this.f24003b));
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
                a(iostwobuttondialog);
                return f1.f55527a;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        static final class b extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f24006a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24007b;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* compiled from: V3SportsHomeActivity.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$f$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            public static final class a implements b.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ V3SportsHomeActivity f24008a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Map<String, Object> f24009b;

                a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                    this.f24008a = v3SportsHomeActivity;
                    this.f24009b = map;
                }

                @Override // m.b.a
                public void a(int i4, @Nullable Intent intent) {
                    this.f24008a.i0(this.f24009b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                super(1);
                this.f24006a = v3SportsHomeActivity;
                this.f24007b = map;
            }

            public final void a(@NotNull iOSTwoButtonDialog it) {
                f0.p(it, "it");
                com.bxkj.base.util.s.p(this.f24006a.w(), new a(this.f24006a, this.f24007b));
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
                a(iostwobuttondialog);
                return f1.f55527a;
            }
        }

        f(Map<String, Object> map) {
            this.f24001b = map;
        }

        @Override // l.b.a
        public void a(@NotNull String[] permission) {
            f0.p(permission, "permission");
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            String string = v3SportsHomeActivity.C().getString(2131821122);
            f0.o(string, "mContext.getString(R.str\u2026.not_set_step_permission)");
            ContextExtKt.h(v3SportsHomeActivity, "\u6743\u9650\u63d0\u793a", string, new b(V3SportsHomeActivity.this, this.f24001b), null, null, "\u53bb\u8bbe\u7f6e", 24, null);
        }

        @Override // l.b.a
        public void b() {
            V3SportsHomeActivity.this.z0(this.f24001b);
        }

        @Override // l.b.a
        public void c(@NotNull String[] permission) {
            f0.p(permission, "permission");
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            String string = v3SportsHomeActivity.C().getString(2131821122);
            f0.o(string, "mContext.getString(R.str\u2026.not_set_step_permission)");
            ContextExtKt.h(v3SportsHomeActivity, "\u6743\u9650\u63d0\u793a", string, new a(V3SportsHomeActivity.this, this.f24001b), null, null, "\u53bb\u8bbe\u7f6e", 24, null);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$g", "Lcom/amap/api/services/weather/WeatherSearch$OnWeatherSearchListener;", "Lcom/amap/api/services/weather/LocalWeatherLiveResult;", "weatherLiveResult", "", "rCode", "Lkotlin/f1;", "onWeatherLiveSearched", "Lcom/amap/api/services/weather/LocalWeatherForecastResult;", "p0", "p1", "onWeatherForecastSearched", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class g implements WeatherSearch.OnWeatherSearchListener {
        g() {
        }

        @Override // com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener
        public void onWeatherForecastSearched(@Nullable LocalWeatherForecastResult localWeatherForecastResult, int i4) {
        }

        @Override // com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener
        public void onWeatherLiveSearched(@Nullable LocalWeatherLiveResult localWeatherLiveResult, int i4) {
            if (i4 != 1000 || localWeatherLiveResult == null || localWeatherLiveResult.getLiveResult() == null) {
                return;
            }
            LocalWeatherLive liveResult = localWeatherLiveResult.getLiveResult();
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            String weather = liveResult.getWeather();
            f0.o(weather, "weatherlive.weather");
            v3SportsHomeActivity.f23982l = weather;
            TextView textView = V3SportsHomeActivity.this.M().tvWeather;
            textView.setText(((Object) liveResult.getReportTime()) + "\u53d1\u5e03\u5929\u6c14:" + V3SportsHomeActivity.this.f23982l);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$h", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class h implements b.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f24012b;

        h(Map<String, Object> map) {
            this.f24012b = map;
        }

        @Override // m.b.a
        public void a(int i4, @Nullable Intent intent) {
            V3SportsHomeActivity.this.l0(this.f24012b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$i", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "Lkotlin/f1;", "onTabSelected", "onTabUnselected", "onTabReselected", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class i implements TabLayout.OnTabSelectedListener {
        i() {
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
            o.a aVar = com.bxkj.student.v2.common.utils.o.a;
            v3SportsHomeActivity.f23983m = aVar.c(tab.getText());
            int a4 = aVar.a(tab.getText());
            View findViewById = v3SportsHomeActivity.getWindow().findViewById(v3SportsHomeActivity.getResources().getIdentifier("statusBarBackground", "id", "android"));
            if (findViewById != null) {
                findViewById.setBackgroundResource(a4);
            }
            v3SportsHomeActivity.M().llTitle.setBackgroundResource(a4);
            v3SportsHomeActivity.M().clData.setBackgroundResource(a4);
            int h4 = aVar.h(tab.getText());
            MyLocationStyle myLocationStyle = new MyLocationStyle();
            myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(h4));
            myLocationStyle.strokeColor(ContextCompat.getColor(v3SportsHomeActivity.C(), a4));
            myLocationStyle.radiusFillColor(ContextCompat.getColor(v3SportsHomeActivity.C(), aVar.i(tab.getText())));
            myLocationStyle.strokeWidth(1.0f);
            AMap aMap = v3SportsHomeActivity.f23979i;
            if (aMap == null) {
                f0.S("aMap");
                aMap = null;
            }
            aMap.setMyLocationStyle(myLocationStyle);
            v3SportsHomeActivity.w0();
            v3SportsHomeActivity.M().ivDescription.setImageResource(aVar.e(tab.getText()));
            v3SportsHomeActivity.M().ivStart.setImageResource(aVar.g(tab.getText()));
            v3SportsHomeActivity.M().ivPermission.setImageResource(aVar.f(tab.getText()));
            v3SportsHomeActivity.M().tvDescriptionV3.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.C(), a4));
            v3SportsHomeActivity.M().tvPermissionV3.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.C(), a4));
            v3SportsHomeActivity.M().tvWeather.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.C(), a4));
            v3SportsHomeActivity.M().tvGps.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.C(), a4));
            v3SportsHomeActivity.M().ivGps.setImageResource(com.bxkj.student.run.app.utils.i.u(v3SportsHomeActivity.f23984n, v3SportsHomeActivity.f23983m));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class j extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {
        j() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            it.dismiss();
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            v3SportsHomeActivity.startActivity(v3SportsHomeActivity.getIntent().setClass(V3SportsHomeActivity.this.C(), V3RecordListActivity.class).putExtra("toLocal", true));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class k extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f24015a = new k();

        k() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            it.dismiss();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "dialog", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class l extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0.c f24017b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a extends Lambda implements l1.a<f1> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f24018a = new a();

            a() {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m72invoke();
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m72invoke() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(c0.c cVar) {
            super(1);
            this.f24017b = cVar;
        }

        public final void a(@NotNull iOSTwoButtonDialog dialog) {
            f0.p(dialog, "dialog");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - V3SportsHomeActivity.this.f23988r > V3SportsHomeActivity.this.f23987q) {
                V3SportsHomeActivity.this.x().L(this.f24017b, a.f24018a);
                V3SportsHomeActivity.this.f23988r = currentTimeMillis;
            }
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "dialog", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class m extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0.c f24019a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V3SportsHomeActivity f24020b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c0.c f24021c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a extends Lambda implements l1.a<f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f24022a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c0.c f24023b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ V3SportsFinishDialog f24024c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* compiled from: V3SportsHomeActivity.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$m$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            public static final class C0317a extends Lambda implements l1.a<f1> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ V3SportsFinishDialog f24025a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0317a(V3SportsFinishDialog v3SportsFinishDialog) {
                    super(0);
                    this.f24025a = v3SportsFinishDialog;
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m74invoke();
                    return f1.f55527a;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m74invoke() {
                    this.f24025a.dismiss();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(V3SportsHomeActivity v3SportsHomeActivity, c0.c cVar, V3SportsFinishDialog v3SportsFinishDialog) {
                super(0);
                this.f24022a = v3SportsHomeActivity;
                this.f24023b = cVar;
                this.f24024c = v3SportsFinishDialog;
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m73invoke();
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m73invoke() {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f24022a.f23988r > this.f24022a.f23987q) {
                    this.f24022a.x().L(this.f24023b, new C0317a(this.f24024c));
                    this.f24022a.f23988r = currentTimeMillis;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class b extends Lambda implements l1.a<f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ iOSTwoButtonDialog f24026a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(iOSTwoButtonDialog iostwobuttondialog) {
                super(0);
                this.f24026a = iostwobuttondialog;
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m75invoke();
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m75invoke() {
                this.f24026a.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(c0.c cVar, V3SportsHomeActivity v3SportsHomeActivity, c0.c cVar2) {
            super(1);
            this.f24019a = cVar;
            this.f24020b = v3SportsHomeActivity;
            this.f24021c = cVar2;
        }

        public final void a(@NotNull iOSTwoButtonDialog dialog) {
            boolean K1;
            f0.p(dialog, "dialog");
            b.g gVar = com.bxkj.student.v2.common.data.b.a;
            gVar.v().clear();
            Map<String, Object> v3 = gVar.v();
            com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
            v3.putAll(lVar.A(this.f24019a.L()));
            gVar.s().clear();
            gVar.s().addAll(kotlin.collections.v.L5(lVar.z(this.f24019a.J())));
            gVar.h0(Long.parseLong(this.f24019a.O()));
            gVar.N(Long.parseLong(this.f24019a.z()));
            gVar.P(Double.parseDouble(this.f24019a.A()));
            gVar.a0(Integer.parseInt(this.f24019a.U()));
            gVar.Q(Double.parseDouble(this.f24019a.D()));
            String K = this.f24019a.K();
            K1 = kotlin.text.w.K1(K, "null", true);
            if (!(!K1)) {
                K = null;
            }
            if (K != null) {
                if (!(K.length() > 0)) {
                    K = null;
                }
                if (K != null) {
                    Map<String, Object> A = lVar.A(K);
                    gVar.e0(new LatLng(lVar.f(A, "latitude"), lVar.f(A, "longitude")));
                }
            }
            gVar.U(this.f24019a.F().length() == 0 ? 0.0d : Double.parseDouble(this.f24019a.F()));
            String a4 = com.bxkj.student.run.app.utils.i.a(Double.parseDouble(this.f24019a.A()), Long.parseLong(this.f24019a.z()));
            f0.o(a4, "calAvgSpeed(\n           \u2026                        )");
            gVar.M(a4);
            String b4 = com.bxkj.student.run.app.utils.i.b(Double.parseDouble(this.f24019a.A()), Long.parseLong(this.f24019a.z()));
            f0.o(b4, "calPace(\n               \u2026                        )");
            gVar.c0(b4);
            gVar.h().setValue(Integer.valueOf(Integer.parseInt(this.f24019a.E())));
            gVar.i().setValue(Boolean.valueOf(Boolean.parseBoolean(this.f24019a.T())));
            gVar.L();
            List latLngList = JSON.parseArray(this.f24019a.H(), PointData.class);
            gVar.p().clear();
            List<PointData> p3 = gVar.p();
            f0.o(latLngList, "latLngList");
            p3.addAll(latLngList);
            List list = latLngList.size() > 0 ? latLngList : null;
            if (list != null) {
                PointData pointData = (PointData) list.get(list.size() - 1);
                if (pointData != null) {
                    pointData.setI(true);
                }
                LatLng latLng = new LatLng(((PointData) latLngList.get(0)).getA(), ((PointData) latLngList.get(0)).getO());
                gVar.g0(latLng);
                gVar.J(latLng);
            }
            List stepCountList = JSON.parseArray(this.f24019a.P(), Integer.TYPE);
            if (stepCountList != null) {
                gVar.i0(kotlin.collections.v.p5(stepCountList));
            }
            gVar.z().clear();
            List<Integer> z3 = gVar.z();
            f0.o(stepCountList, "stepCountList");
            z3.addAll(stepCountList);
            V3SportsFinishDialog v3SportsFinishDialog = new V3SportsFinishDialog();
            V3SportsHomeActivity v3SportsHomeActivity = this.f24020b;
            c0.c cVar = this.f24021c;
            FragmentManager supportFragmentManager = v3SportsHomeActivity.getSupportFragmentManager();
            f0.o(supportFragmentManager, "supportFragmentManager");
            v3SportsFinishDialog.show(supportFragmentManager, "finishDialog");
            v3SportsFinishDialog.a0(new a(v3SportsHomeActivity, cVar, v3SportsFinishDialog));
            v3SportsFinishDialog.b0(new b(dialog));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class n extends Lambda implements l1.a<f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final n f24027a = new n();

        n() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m76invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m76invoke() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class o extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f24029b;

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$o$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f24030a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24031b;

            a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f24030a = v3SportsHomeActivity;
                this.f24031b = map;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                this.f24030a.v0(this.f24031b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(Map<String, Object> map) {
            super(1);
            this.f24029b = map;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            it.dismiss();
            com.bxkj.base.util.r.c(V3SportsHomeActivity.this.w(), new a(V3SportsHomeActivity.this, this.f24029b));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class p extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final p f24032a = new p();

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$p$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f24033a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24034b;

            a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f24033a = v3SportsHomeActivity;
                this.f24034b = map;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                this.f24033a.v0(this.f24034b);
            }
        }

        p() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            it.dismiss();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$q", "Lcom/amap/api/maps/LocationSource;", "Lcom/amap/api/maps/LocationSource$OnLocationChangedListener;", "listener", "Lkotlin/f1;", "activate", "deactivate", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class q implements LocationSource {
        q() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(LocationSource.OnLocationChangedListener listener, V3SportsHomeActivity this$0, AMapLocation aMapLocation) {
            f0.p(listener, "$listener");
            f0.p(this$0, "this$0");
            if (Build.VERSION.SDK_INT >= 18) {
                com.orhanobut.logger.j.d("isFromMockProvider=" + aMapLocation.isFromMockProvider() + "\nisMock=" + aMapLocation.isMock() + "\nisInstalledHighDangerMockApp=" + aMapLocation.getLocationQualityReport().isInstalledHighDangerMockApp(), new Object[0]);
            }
            listener.onLocationChanged(aMapLocation);
            this$0.f23984n = aMapLocation.getGpsAccuracyStatus();
            this$0.M().ivGps.setImageResource(com.bxkj.student.run.app.utils.i.u(this$0.f23984n, this$0.f23983m));
            AMap aMap = null;
            if ((aMapLocation.getErrorCode() == 0 ? aMapLocation : null) == null) {
                return;
            }
            AMap aMap2 = this$0.f23979i;
            if (aMap2 == null) {
                f0.S("aMap");
            } else {
                aMap = aMap2;
            }
            aMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
            String city = aMapLocation.getCity();
            f0.o(city, "aMapLocation.city");
            this$0.k0(city);
        }

        @Override // com.amap.api.maps.LocationSource
        public void activate(@NotNull final LocationSource.OnLocationChangedListener listener) {
            f0.p(listener, "listener");
            if (V3SportsHomeActivity.this.f23981k == null) {
                V3SportsHomeActivity.this.f23981k = new AMapLocationClient(BaseApp.b());
                AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                aMapLocationClientOption.setMockEnable(false);
                AMapLocationClient aMapLocationClient = V3SportsHomeActivity.this.f23981k;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(aMapLocationClientOption);
                }
                AMapLocationClient aMapLocationClient2 = V3SportsHomeActivity.this.f23981k;
                if (aMapLocationClient2 != null) {
                    final V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
                    aMapLocationClient2.setLocationListener(new AMapLocationListener() { // from class: com.bxkj.student.v2.ui.sports.v3.n
                        @Override // com.amap.api.location.AMapLocationListener
                        public final void onLocationChanged(AMapLocation aMapLocation) {
                            V3SportsHomeActivity.q.b(LocationSource.OnLocationChangedListener.this, v3SportsHomeActivity, aMapLocation);
                        }
                    });
                }
                AMapLocationClient aMapLocationClient3 = V3SportsHomeActivity.this.f23981k;
                if (aMapLocationClient3 == null) {
                    return;
                }
                aMapLocationClient3.startLocation();
            }
        }

        @Override // com.amap.api.maps.LocationSource
        public void deactivate() {
            AMapLocationClient aMapLocationClient = V3SportsHomeActivity.this.f23981k;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            AMapLocationClient aMapLocationClient2 = V3SportsHomeActivity.this.f23981k;
            if (aMapLocationClient2 != null) {
                aMapLocationClient2.onDestroy();
            }
            V3SportsHomeActivity.this.f23981k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class r extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f24037b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a extends Lambda implements l1.a<f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24038a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f24039b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ iOSTwoButtonDialog f24040c;

            /* compiled from: V3SportsHomeActivity.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$r$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$r$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            public static final class C0318a implements b.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ iOSTwoButtonDialog f24041a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ V3SportsHomeActivity f24042b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Map<String, Object> f24043c;

                C0318a(iOSTwoButtonDialog iostwobuttondialog, V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                    this.f24041a = iostwobuttondialog;
                    this.f24042b = v3SportsHomeActivity;
                    this.f24043c = map;
                }

                @Override // m.b.a
                public void a(int i4, @Nullable Intent intent) {
                    if (i4 == -1) {
                        this.f24041a.dismiss();
                        this.f24042b.A0(this.f24043c);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Map<String, Object> map, V3SportsHomeActivity v3SportsHomeActivity, iOSTwoButtonDialog iostwobuttondialog) {
                super(0);
                this.f24038a = map;
                this.f24039b = v3SportsHomeActivity;
                this.f24040c = iostwobuttondialog;
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m77invoke();
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m77invoke() {
                com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
                Class cls = lVar.k(this.f24038a, "livingFace") == 1 ? FaceLiveV3Activity.class : FaceDetectV3Activity.class;
                m.b bVar = new m.b(this.f24039b.w());
                Intent putExtra = this.f24039b.getIntent().setClass(this.f24039b.C(), cls).putExtra("identify", lVar.t(this.f24038a, "identify")).putExtra("runType", lVar.l(this.f24038a, "runType", 1)).putExtra("type", "1");
                f0.o(putExtra, "intent.setClass(mContext\u2026a(\"type\", FaceType.Start)");
                bVar.startActivityForResult(putExtra).c(new C0318a(this.f24040c, this.f24039b, this.f24038a));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(Map<String, Object> map) {
            super(1);
            this.f24037b = map;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            com.bxkj.base.v2.common.ext.g.c(v3SportsHomeActivity, "\u4eba\u8138\u8bc6\u522b", new a(this.f24037b, v3SportsHomeActivity, it));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class s extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final s f24044a = new s();

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        static final class a extends Lambda implements d2.a<f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24045a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f24046b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ iOSTwoButtonDialog f24047c;

            /* compiled from: V3SportsHomeActivity.kt */
            @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$s$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$s$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\4499832.dex */
            public static final class C0319a implements b.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ iOSTwoButtonDialog f24048a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ V3SportsHomeActivity f24049b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Map<String, Object> f24050c;

                C0319a(iOSTwoButtonDialog iostwobuttondialog, V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                    this.f24048a = iostwobuttondialog;
                    this.f24049b = v3SportsHomeActivity;
                    this.f24050c = map;
                }

                @Override // m.b.a
                public void a(int i4, @Nullable Intent intent) {
                    if (i4 == -1) {
                        this.f24048a.dismiss();
                        this.f24049b.B0(this.f24050c);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Map<String, Object> map, V3SportsHomeActivity v3SportsHomeActivity, iOSTwoButtonDialog iostwobuttondialog) {
                super(0);
                this.f24045a = map;
                this.f24046b = v3SportsHomeActivity;
                this.f24047c = iostwobuttondialog;
            }

            @Override // d2.a
            public /* bridge */ /* synthetic */ f1 invoke() {
                invoke2();
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.bxkj.base.v2.common.utils.m mVar = com.bxkj.base.v2.common.utils.m.a;
                Class cls = mVar.k(this.f24045a, "livingFace") == 1 ? FaceLiveV3Activity.class : FaceDetectV3Activity.class;
                m.b bVar = new m.b(this.f24046b.w());
                Intent putExtra = this.f24046b.getIntent().setClass(this.f24046b.C(), cls).putExtra("identify", mVar.t(this.f24045a, "identify")).putExtra("runType", mVar.l(this.f24045a, "runType", 1)).putExtra("type", "1");
                f0.o(putExtra, "intent.setClass(mContext\u2026a(\"type\", FaceType.Start)");
                bVar.startActivityForResult(putExtra).c(new C0319a(this.f24047c, this.f24046b, this.f24045a));
            }
        }

        s() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            it.dismiss();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class t extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f24052b;

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$t$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f24053a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24054b;

            a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f24053a = v3SportsHomeActivity;
                this.f24054b = map;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                this.f24053a.z0(this.f24054b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(Map<String, Object> map) {
            super(1);
            this.f24052b = map;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            it.dismiss();
            Intent intent = new Intent();
            intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
            new m.b(V3SportsHomeActivity.this.w()).startActivityForResult(intent).c(new a(V3SportsHomeActivity.this, this.f24052b));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class u extends Lambda implements l1.l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final u f24055a = new u();

        /* compiled from: V3SportsHomeActivity.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$u$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f24056a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f24057b;

            a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f24056a = v3SportsHomeActivity;
                this.f24057b = map;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                this.f24056a.A0(this.f24057b);
            }
        }

        u() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            it.dismiss();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class v extends Lambda implements l1.a<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f24059b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(Map<String, Object> map) {
            super(0);
            this.f24059b = map;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m78invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m78invoke() {
            if (Build.VERSION.SDK_INT >= 29) {
                V3SportsHomeActivity.this.f0(this.f24059b);
            } else {
                V3SportsHomeActivity.this.z0(this.f24059b);
            }
        }
    }

    /* compiled from: V3SportsHomeActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class w extends Lambda implements d2.a<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f24061b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(Map<String, Object> map) {
            super(0);
            this.f24061b = map;
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (Build.VERSION.SDK_INT >= 29) {
                V3SportsHomeActivity.this.f0(this.f24061b);
            } else {
                V3SportsHomeActivity.this.A0(this.f24061b);
            }
        }
    }

    static {
        StubApp.interface11(12643);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(Map<String, Object> map) {
        cn.bluemobi.dylan.base.utils.a.n().i(V3SportsMapActivity.class);
        cn.bluemobi.dylan.base.utils.a.n().i(V3SportsActivity.class);
        b.g gVar = com.bxkj.student.v2.common.data.b.a;
        gVar.v().clear();
        gVar.v().putAll(map);
        String t3 = com.bxkj.base.v2.common.utils.l.f18624a.t(map, "lastExerciseExplanationDate");
        a.b bVar = com.bxkj.base.v2.data.a.b;
        if (bVar.a().m() && f0.g(t3, bVar.a().i())) {
            startActivity(new Intent(C(), V3SportsMapActivity.class));
            overridePendingTransition(2130772068, 2130772069);
            return;
        }
        bVar.a().O(false);
        bVar.a().J(t3);
        startActivity(getIntent().setClass(C(), SportsDescriptionActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(Map<String, Object> map) {
        com.bxkj.base.v2.common.ext.g.i(this, new v(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(Map<String, Object> map) {
        com.bxkj.base.v2.common.ext.g.b(this, new a(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(Map<String, Object> map) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object systemService = getSystemService("power");
            if (systemService != null) {
                if (((PowerManager) systemService).isPowerSaveMode()) {
                    ContextExtKt.h(this, "\u8bf7\u52ff\u5f00\u542f\u7701\u7535\u6a21\u5f0f", "\u5f00\u59cb\u953b\u70bc\u524d\u8bf7\u5173\u95ed\u7701\u7535\u6a21\u5f0f\uff0c\u5426\u5219\u8f68\u8ff9\u8bb0\u5f55\u53ef\u80fd\u4e0d\u51c6\u786e\uff01", new b(map), c.f23995a, null, null, 48, null);
                    return;
                } else {
                    l0(map);
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        }
        l0(map);
    }

    private final void h0(Map<String, Object> map) {
        com.bxkj.base.v2.base.m mVar = new com.bxkj.base.v2.base.m(w());
        mVar.h();
        com.bxkj.student.v2.common.utils.n.f23377a.c(w(), new d(mVar, this, map), new e(mVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(Map<String, Object> map) {
        new l.b(w()).c("android.permission.ACTIVITY_RECOGNITION").d(new f(map));
    }

    private final TabLayout.Tab j0(String str) {
        int tabCount = M().tab.getTabCount();
        if (tabCount <= 0) {
            return null;
        }
        int i4 = 0;
        TabLayout.Tab tab = null;
        while (true) {
            int i5 = i4 + 1;
            TabLayout.Tab tabAt = M().tab.getTabAt(i4);
            if (f0.g(str, tabAt == null ? null : tabAt.getText())) {
                tab = M().tab.getTabAt(i4);
            }
            if (i5 >= tabCount) {
                return tab;
            }
            i4 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(String str) {
        WeatherSearchQuery weatherSearchQuery = new WeatherSearchQuery(str, 1);
        WeatherSearch weatherSearch = new WeatherSearch(this);
        weatherSearch.setOnWeatherSearchListener(new g());
        weatherSearch.setQuery(weatherSearchQuery);
        weatherSearch.searchWeatherAsyn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(Map<String, Object> map) {
        if (Build.VERSION.SDK_INT >= 23) {
            Object systemService = getSystemService("power");
            if (systemService != null) {
                if (!((PowerManager) systemService).isIgnoringBatteryOptimizations(getPackageName())) {
                    Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent.setData(Uri.parse(f0.C("package:", getPackageName())));
                    try {
                        new m.b(w()).startActivityForResult(intent).c(new h(map));
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
                y0(map);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        }
        y0(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(V3SportsHomeActivity this$0, Map map) {
        f0.p(this$0, "this$0");
        this$0.w0();
        if (!(com.bxkj.base.v2.common.utils.l.f18624a.k(map, "isShow") == 1)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        if ((this$0.j0("\u81ea\u7531\u8dd1") == null ? map : null) == null) {
            return;
        }
        this$0.M().tab.addTab(this$0.M().tab.newTab().setText("\u81ea\u7531\u8dd1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(V3SportsHomeActivity this$0, Map map) {
        f0.p(this$0, "this$0");
        this$0.w0();
        if (!(com.bxkj.base.v2.common.utils.l.f18624a.k(map, "isShow") == 1)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        if ((this$0.j0("\u573a\u5730\u953b\u70bc") == null ? map : null) == null) {
            return;
        }
        this$0.M().tab.addTab(this$0.M().tab.newTab().setText("\u573a\u5730\u953b\u70bc"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(V3SportsHomeActivity this$0, List list) {
        f0.p(this$0, "this$0");
        iOSTwoButtonDialog iostwobuttondialog = this$0.f23986p;
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
        iOSTwoButtonDialog h4 = ContextExtKt.h(this$0, null, "\u7cfb\u7edf\u68c0\u6d4b\u5230\u60a8\u8fd8\u6709" + list.size() + "\u6761\u953b\u70bc\u8bb0\u5f55\u5728\u672c\u5730\u6682\u5b58,\u662f\u5426\u4e0a\u4f20\uff1f", new j(), k.f24015a, null, null, 49, null);
        h4.setCancelable(false);
        h4.setClickAutoCancel(false);
        h4.setCanceledOnTouchOutside(false);
        h4.setLeftButtonText("\u6682\u5b58\u672c\u5730");
        h4.setRightButtonText("\u73b0\u5728\u4e0a\u4f20");
        f1 f1Var = f1.f55527a;
        this$0.f23986p = h4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(V3SportsHomeActivity this$0, List list) {
        c0.c cVar;
        String str;
        f0.p(this$0, "this$0");
        if (list != null) {
            List list2 = list.isEmpty() ? list : null;
            if (list2 != null) {
                com.orhanobut.logger.j.d(f0.C("\u6ca1\u6709\u6709\u5f02\u5e38\u7ed3\u675f\u6570\u636e=", list2), new Object[0]);
                iOSTwoButtonDialog iostwobuttondialog = this$0.f23985o;
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
        if (list == null || (cVar = (c0.c) list.get(0)) == null) {
            return;
        }
        iOSTwoButtonDialog iostwobuttondialog2 = this$0.f23985o;
        if (iostwobuttondialog2 != null) {
            f0.m(iostwobuttondialog2);
            if (iostwobuttondialog2.isShowing()) {
                return;
            }
        }
        com.orhanobut.logger.j.d(f0.C("\u6709\u5f02\u5e38\u7ed3\u675f\u6570\u636e=", cVar), new Object[0]);
        FragmentActivity w3 = this$0.w();
        StringBuilder sb = new StringBuilder();
        sb.append("\u7cfb\u7edf\u68c0\u6d4b\u5230\u60a8\u5728");
        sb.append(com.bxkj.base.v2.common.utils.d.a(cVar.O()));
        sb.append("\u5f00\u59cb\u7684\u7684");
        if (Integer.parseInt(cVar.M()) == 5) {
            str = "";
        } else {
            str = "\u5df2\u8fd0\u52a8" + ((Object) com.bxkj.student.run.app.utils.i.c(Double.parseDouble(cVar.A()))) + "KM";
        }
        sb.append(str);
        sb.append("\u7528\u65f6");
        sb.append((Object) com.bxkj.student.run.app.utils.i.g(Long.parseLong(cVar.z())));
        sb.append('\u7684');
        sb.append(com.bxkj.student.v2.common.utils.o.a.d(Integer.parseInt(cVar.M())));
        sb.append("\u8bb0\u5f55\u5f02\u5e38\u7ed3\u675f,\u5f3a\u70c8\u5efa\u8bae\u60a8\u68c0\u67e5\u8fd0\u52a8\u6743\u9650\u8bbe\u7f6e\u662f\u5426\u6b63\u786e\u540e\u5c3d\u5feb\u6062\u590d\u7ee7\u7eed\u953b\u70bc");
        iOSTwoButtonDialog h4 = ContextExtKt.h(w3, null, sb.toString(), new l(cVar), new m(cVar, this$0, cVar), null, null, 49, null);
        h4.setCancelable(false);
        h4.setClickAutoCancel(false);
        h4.setCanceledOnTouchOutside(false);
        h4.setLeftButtonText("\u7ed3\u675f\u5e76\u4e0a\u4f20");
        h4.setRightButtonText("\u6062\u590d\u7ee7\u7eed\u953b\u70bc");
        f1 f1Var = f1.f55527a;
        this$0.f23985o = h4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(V3SportsHomeActivity this$0, Map map) {
        f0.p(this$0, "this$0");
        this$0.w0();
        if (!(com.bxkj.base.v2.common.utils.l.f18624a.k(map, "isShow") == 1)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        if ((this$0.j0("\u65e9\u64cd\u8dd1") == null ? map : null) == null) {
            return;
        }
        this$0.M().tab.addTab(this$0.M().tab.newTab().setText("\u65e9\u64cd\u8dd1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        if (r0 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r0(com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity r5, java.util.Map r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.f0.p(r5, r0)
            if (r6 != 0) goto L9
            goto L78
        L9:
            com.bxkj.base.v2.common.utils.l r0 = com.bxkj.base.v2.common.utils.l.f18624a
            java.lang.String r1 = "identify"
            java.lang.String r1 = r0.t(r6, r1)
            java.lang.String r2 = "isFromLocalToContinue"
            boolean r2 = r0.d(r6, r2)
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
            com.bxkj.base.v2.base.BaseViewModel r2 = r5.x()
            com.bxkj.student.v2.vm.sports.SportsHomeVM r2 = (com.bxkj.student.v2.vm.sports.SportsHomeVM) r2
            r2.F(r1)
        L2b:
            java.lang.String r1 = "limitWeather"
            java.lang.String r0 = r0.t(r6, r1)
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.f0.g(r0, r1)
            if (r0 == 0) goto L75
            java.lang.String r0 = r5.f23982l
            java.lang.String r1 = "\u96e8"
            r2 = 0
            r4 = 2
            boolean r0 = kotlin.text.n.V2(r0, r1, r2, r4, r3)
            if (r0 != 0) goto L59
            java.lang.String r0 = r5.f23982l
            java.lang.String r1 = "\u96ea"
            boolean r0 = kotlin.text.n.V2(r0, r1, r2, r4, r3)
            if (r0 != 0) goto L59
            java.lang.String r0 = r5.f23982l
            java.lang.String r1 = "\u973e"
            boolean r0 = kotlin.text.n.V2(r0, r1, r2, r4, r3)
            if (r0 == 0) goto L75
        L59:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "\u5f53\u524d\u5929\u6c14\uff1a"
            r6.append(r0)
            java.lang.String r0 = r5.f23982l
            r6.append(r0)
            java.lang.String r0 = ",\u4e0d\u80fd\u8fdb\u884c\u953b\u70bc"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.bxkj.base.v2.common.ext.ContextExtKt.m(r5, r6)
            goto L78
        L75:
            r5.h0(r6)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity.r0(com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity, java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(V3SportsHomeActivity this$0, Map map) {
        f0.p(this$0, "this$0");
        this$0.w0();
        if (!(com.bxkj.base.v2.common.utils.l.f18624a.k(map, "isShow") == 1)) {
            map = null;
        }
        if (map == null) {
            return;
        }
        if ((this$0.j0("\u9633\u5149\u8dd1") == null ? map : null) == null) {
            return;
        }
        TabLayout.Tab text = this$0.M().tab.newTab().setText("\u9633\u5149\u8dd1");
        f0.o(text, "mDataBinding.tab.newTab().setText(\"\u9633\u5149\u8dd1\")");
        this$0.M().tab.addTab(text);
        text.select();
    }

    private final void u0() {
        com.bxkj.base.v2.common.ext.g.i(this, n.f24027a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(Map<String, Object> map) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (!com.bxkj.base.util.r.a(C())) {
                ContextExtKt.h(this, "\u5141\u8bb8\u4f53\u9002\u80fd\u63a8\u9001\u901a\u77e5\u672a\u5f00\u542f", "\u4e3a\u4e86\u80fd\u591f\u8ba9\u4f60\u5728\u953b\u70bc\u8fc7\u7a0b\u4e2d\u4e0d\u9519\u8fc7\u91cd\u8981\u7684\u901a\u77e5\u6d88\u606f,\u5fc5\u987b\u5f00\u542f\u5141\u8bb8\u63a8\u9001\u901a\u77e5\u529f\u80fd", new o(map), p.f24032a, null, null, 48, null);
                return;
            } else {
                g0(map);
                return;
            }
        }
        g0(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0() {
        M().setRecordMap(x().G(this.f23983m));
    }

    private final void x0() {
        AMap map = M().map.getMap();
        f0.o(map, "mDataBinding.map.map");
        this.f23979i = map;
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(2131558820));
        myLocationStyle.strokeColor(-16777216);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        myLocationStyle.myLocationType(5);
        AMap aMap = this.f23979i;
        AMap aMap2 = null;
        if (aMap == null) {
            f0.S("aMap");
            aMap = null;
        }
        aMap.setMyLocationStyle(myLocationStyle);
        this.f23980j = new q();
        AMap aMap3 = this.f23979i;
        if (aMap3 == null) {
            f0.S("aMap");
            aMap3 = null;
        }
        aMap3.setLocationSource(this.f23980j);
        AMap aMap4 = this.f23979i;
        if (aMap4 == null) {
            f0.S("aMap");
            aMap4 = null;
        }
        aMap4.getUiSettings().setMyLocationButtonEnabled(true);
        AMap aMap5 = this.f23979i;
        if (aMap5 == null) {
            f0.S("aMap");
            aMap5 = null;
        }
        aMap5.setMyLocationEnabled(true);
        CameraUpdate zoomTo = CameraUpdateFactory.zoomTo(19.0f);
        AMap aMap6 = this.f23979i;
        if (aMap6 == null) {
            f0.S("aMap");
        } else {
            aMap2 = aMap6;
        }
        aMap2.moveCamera(zoomTo);
    }

    private final void y0(Map<String, Object> map) {
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        if (lVar.k(map, "isStartFace") == 1 && !lVar.d(map, "isFromLocalToContinue")) {
            iOSTwoButtonDialog h4 = ContextExtKt.h(this, null, f0.C(com.bxkj.student.v2.common.utils.o.a.d(lVar.k(map, "runType")), "\u5f00\u59cb\u524d\uff0c\u8bf7\u5148\u8fdb\u884c\u4eba\u8138\u8bc6\u522b"), new r(map), s.f24044a, null, null, 49, null);
            h4.setClickAutoCancel(false);
            h4.setCancelable(false);
            h4.setCanceledOnTouchOutside(false);
            return;
        }
        A0(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(Map<String, Object> map) {
        Object systemService = getSystemService("location");
        if (systemService != null) {
            if (!((LocationManager) systemService).isProviderEnabled("gps")) {
                String string = getString(2131821266);
                f0.o(string, "getString(R.string.run_request_location)");
                ContextExtKt.h(this, "GPS\u672a\u5f00\u542f", string, new t(map), u.f24055a, null, null, 48, null);
                return;
            }
            v0(map);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }

    public final void C0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f23988r > this.f23987q) {
            SportsHomeVM x3 = x();
            o.a aVar = com.bxkj.student.v2.common.utils.o.a;
            TabLayout.Tab tabAt = M().tab.getTabAt(M().tab.getSelectedTabPosition());
            x3.C(aVar.c(tabAt == null ? null : tabAt.getText()));
            this.f23988r = currentTimeMillis;
        }
    }

    public final void D0() {
        startActivity(new Intent(C(), SportsDescriptionActivity.class).putExtra("showBottom", false));
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setBackEvent(this);
        x().E();
        x().K();
        x().J();
        u0();
        if (getIntent().hasExtra("title")) {
            M().setTitle(getIntent().getStringExtra("title"));
        } else {
            M().setTitle("APP\u8dd1\u6b65");
        }
        x0();
    }

    public final void E0() {
        startActivity(new Intent(C(), PermissionSetActivity.class));
    }

    public final void F0() {
        startActivity(new Intent(C(), V3RecordListActivity.class));
    }

    public final void G0() {
        startActivity(new Intent(C(), SportsSetActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LocationSource locationSource = this.f23980j;
        if (locationSource != null) {
            locationSource.deactivate();
        }
        AMapLocationClient aMapLocationClient = this.f23981k;
        if (aMapLocationClient != null) {
            aMapLocationClient.onDestroy();
        }
        M().map.onDestroy();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        M().map.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Window window;
        super.onResume();
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            Context C = C();
            o.a aVar = com.bxkj.student.v2.common.utils.o.a;
            TabLayout.Tab tabAt = M().tab.getTabAt(M().tab.getSelectedTabPosition());
            window.setStatusBarColor(ContextCompat.getColor(C, aVar.a(tabAt == null ? null : tabAt.getText())));
        }
        M().map.onResume();
        AMapLocationClient aMapLocationClient = this.f23981k;
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
        f0.p(outState, "outState");
        super.onSaveInstanceState(outState);
        M().map.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AMapLocationClient aMapLocationClient = this.f23981k;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
        super.onStop();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        M().tab.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new i());
        x().A().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.q0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
        x().H().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.s0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
        x().y().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.m0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
        x().x().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.n0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
        x().I().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.o0(V3SportsHomeActivity.this, (List) obj);
            }
        });
        x().w().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.p0(V3SportsHomeActivity.this, (List) obj);
            }
        });
        x().B().observe(w(), new Observer() { // from class: com.bxkj.student.v2.ui.sports.v3.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                V3SportsHomeActivity.r0(V3SportsHomeActivity.this, (Map) obj);
            }
        });
    }

    public final void t0() {
        x().E();
        x().K();
    }
}
