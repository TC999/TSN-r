package com.bxkj.student.v2.ui.sports.v3;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.bxkj.base.util.y;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.App;
import com.bxkj.student.databinding.AcV3SportsMapBinding;
import com.bxkj.student.v2.common.data.b;
import com.bxkj.student.v2.common.utils.o;
import com.bxkj.student.v2.ui.sports.set.SportsSetActivity;
import com.bxkj.student.v2.ui.sports.v3.service.V3GeoFenceObserver;
import com.bxkj.student.v2.ui.sports.v3.service.V3KillNotificationsService;
import com.bxkj.student.v2.ui.sports.v3.service.V3LocationService;
import com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver;
import com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer;
import com.bxkj.student.v2.ui.sports.v3.service.step.V3StepService;
import com.bxkj.student.v2.vm.sports.SportsVM;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3SportsMapActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\fH\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00106\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109\u00a8\u0006?"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3SportsMapActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3SportsMapBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lkotlin/f1;", "N", "S", "E", "U", "p", "T", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onResume", "onPause", "onDestroy", "outState", "onSaveInstanceState", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "countDownHandler", "Ljava/lang/Runnable;", "j", "Ljava/lang/Runnable;", "countDownRunnable", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3MapObserver;", "k", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3MapObserver;", "v3MapObserver", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3GeoFenceObserver;", "l", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3GeoFenceObserver;", "v3GeoFenceObserver", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer;", "m", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer;", "v3PassPoint2Observer", "Landroid/content/ServiceConnection;", "n", "Landroid/content/ServiceConnection;", "mConnection", "", "o", "Z", "P", "()Z", "R", "(Z)V", "isResume", "O", "Q", "isFirstPointSuccess", "Landroid/content/BroadcastReceiver;", CampaignEx.JSON_KEY_AD_Q, "Landroid/content/BroadcastReceiver;", "locationServiceBroadCastReceiver", "r", "screenOffBroadCastReceiver", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3SportsMapActivity extends BaseActivity<AcV3SportsMapBinding, SportsVM> {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Handler f24062i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Runnable f24063j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private V3MapObserver f24064k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private V3GeoFenceObserver f24065l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private V3PassPoint2Observer f24066m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final ServiceConnection f24067n = new b();

    /* renamed from: o  reason: collision with root package name */
    private boolean f24068o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24069p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private BroadcastReceiver f24070q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private BroadcastReceiver f24071r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsMapActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Lc0/c;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class a extends Lambda implements l1.l<c0.c, f1> {
        a() {
            super(1);
        }

        public final void a(@Nullable c0.c cVar) {
            V3SportsMapActivity.this.S();
            V3SportsMapActivity v3SportsMapActivity = V3SportsMapActivity.this;
            AMap map = V3SportsMapActivity.this.M().mMapView.getMap();
            f0.o(map, "mDataBinding.mMapView.map");
            v3SportsMapActivity.f24064k = new V3MapObserver(v3SportsMapActivity, v3SportsMapActivity.x(), map);
            V3MapObserver v3MapObserver = V3SportsMapActivity.this.f24064k;
            if (v3MapObserver == null) {
                return;
            }
            V3SportsMapActivity.this.getLifecycle().addObserver(v3MapObserver);
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(c0.c cVar) {
            a(cVar);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsMapActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsMapActivity$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "className", "Landroid/os/IBinder;", "binder", "Lkotlin/f1;", "onServiceConnected", "onServiceDisconnected", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@NotNull ComponentName className, @NotNull IBinder binder) {
            f0.p(className, "className");
            f0.p(binder, "binder");
            ((V3KillNotificationsService.a) binder).a().startService(new Intent(V3SportsMapActivity.this.C(), V3KillNotificationsService.class));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@NotNull ComponentName className) {
            f0.p(className, "className");
        }
    }

    static {
        StubApp.interface11(12648);
    }

    private final void N() {
        this.f24070q = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity$addBroadCastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                if (intent == null) {
                    return;
                }
                V3SportsMapActivity v3SportsMapActivity = V3SportsMapActivity.this;
                if (intent.hasExtra("firstMapLocation")) {
                    v3SportsMapActivity.Q(true);
                    if (v3SportsMapActivity.P()) {
                        v3SportsMapActivity.T();
                    }
                }
                if (intent.hasExtra("gpsStatusImage")) {
                    v3SportsMapActivity.M().ivGps.setImageResource(com.bxkj.student.run.app.utils.i.u(com.bxkj.student.v2.common.data.b.a.m(), 0));
                }
                if (intent.hasExtra("countTime")) {
                    v3SportsMapActivity.M().tvTime.setText(com.bxkj.base.v2.common.utils.d.b(intent.getLongExtra("countTime", 0L)));
                }
                if (intent.hasExtra("distance")) {
                    v3SportsMapActivity.M().tvDistance.setText(com.bxkj.student.run.app.utils.i.c(intent.getDoubleExtra("distance", 0.0d)));
                }
                if (intent.hasExtra("pace")) {
                    v3SportsMapActivity.M().tvPeisu.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("stepCount")) {
                    v3SportsMapActivity.M().tvStep.setText(String.valueOf(intent.getIntExtra("stepCount", com.bxkj.student.v2.common.data.b.a.y())));
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(f0.C(App.n().getPackageName(), ".run"));
        BroadcastReceiver broadcastReceiver = this.f24070q;
        if (broadcastReceiver != null) {
            registerReceiver(broadcastReceiver, intentFilter, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST", null);
        }
        BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity$addBroadCastReceiver$3
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                f0.p(context, "context");
                f0.p(intent, "intent");
                if (f0.g("android.intent.action.SCREEN_OFF", intent.getAction())) {
                    V3SportsMapActivity.this.startActivity(new Intent(V3SportsMapActivity.this.C(), V3SportsActivity.class).putExtra("isLock", true));
                    V3SportsMapActivity.this.overridePendingTransition(2130772068, 2130772069);
                }
            }
        };
        this.f24071r = broadcastReceiver2;
        registerReceiver(broadcastReceiver2, new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        if (y.a(C(), V3LocationService.class.getName())) {
            return;
        }
        Intent intent = new Intent(this, V3LocationService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        try {
            b.g gVar = com.bxkj.student.v2.common.data.b.a;
            gVar.b();
            N();
            startActivity(new Intent(C(), V3SportsActivity.class).putExtra("isStart", true));
            overridePendingTransition(2130772068, 2130772069);
            M().setBackEvent(this);
            bindService(new Intent(C(), V3KillNotificationsService.class), this.f24067n, 1);
            if (!gVar.v().isEmpty()) {
                x().G(gVar.v());
                Object obj = x().B().get("runType");
                if (obj == null) {
                    obj = -1;
                }
                if (obj == null) {
                    obj = -1;
                }
                int parseInt = Integer.parseInt(obj.toString());
                M().setSportType(parseInt);
                M().setTitle(f0.C(o.a.d(parseInt), "\u4e2d"));
            } else {
                ContextExtKt.p(this, "\u6570\u636e\u5f02\u5e38\uff0c\u6ca1\u6709\u8fd0\u52a8\u7c7b\u578b");
                com.orhanobut.logger.j.e("\u6570\u636e\u5f02\u5e38\uff0c\u6ca1\u6709\u8fd0\u52a8\u7c7b\u578b", new Object[0]);
                finish();
            }
            Object obj2 = x().B().get("identify");
            if (obj2 == null) {
                obj2 = "";
            }
            String valueOf = String.valueOf(obj2);
            if (TextUtils.isEmpty(valueOf)) {
                ContextExtKt.p(this, "\u6570\u636e\u5f02\u5e38\uff0c\u6ca1\u6709\u8eab\u4efd");
                com.orhanobut.logger.j.e("\u6570\u636e\u5f02\u5e38\uff0c\u6ca1\u6709\u8eab\u4efd", new Object[0]);
                finish();
            }
            x().E(valueOf, new a());
            Object obj3 = x().B().get("context");
            String valueOf2 = String.valueOf(obj3 != null ? obj3 : "");
            Object obj4 = x().B().get("isClock");
            if (obj4 == null) {
                obj4 = "0";
            }
            String valueOf3 = String.valueOf(obj4);
            M().setNotice(valueOf2);
            M().setIsClock(valueOf3);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        int k4 = com.bxkj.base.v2.common.utils.l.f18624a.k(com.bxkj.student.v2.common.data.b.a.v(), "runType");
        TabLayout.Tab tabAt = M().tab.getTabAt(0);
        if (tabAt != null) {
            tabAt.setText(o.a.d(k4));
        }
        int color = ContextCompat.getColor(C(), 2131034571);
        M().titleLayout.setBackgroundResource(2131034571);
        com.bxkj.student.common.utils.l.g(this, color);
        M().tvGps.setTextColor(color);
    }

    public final boolean O() {
        return this.f24069p;
    }

    public final boolean P() {
        return this.f24068o;
    }

    public final void Q(boolean z3) {
        this.f24069p = z3;
    }

    public final void R(boolean z3) {
        this.f24068o = z3;
    }

    public final void T() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        b.g gVar = com.bxkj.student.v2.common.data.b.a;
        if (gVar.x() == 0) {
            gVar.h0(System.currentTimeMillis());
        }
        d0.a.f54621a.b(C(), 2131755099);
        AMap map = M().mMapView.getMap();
        f0.o(map, "mDataBinding.mMapView.map");
        V3GeoFenceObserver v3GeoFenceObserver = new V3GeoFenceObserver(this, x(), map);
        this.f24065l = v3GeoFenceObserver;
        getLifecycle().addObserver(v3GeoFenceObserver);
        MapView mapView = M().mMapView;
        f0.o(mapView, "mDataBinding.mMapView");
        V3PassPoint2Observer v3PassPoint2Observer = new V3PassPoint2Observer(this, x(), mapView);
        this.f24066m = v3PassPoint2Observer;
        getLifecycle().addObserver(v3PassPoint2Observer);
        Intent intent = new Intent(this, V3LocationService.class);
        intent.putExtra(CampaignEx.JSON_NATIVE_VIDEO_START, true);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
        if (y.a(C(), V3StepService.class.getName())) {
            return;
        }
        Intent intent2 = new Intent(this, V3StepService.class);
        if (i4 >= 26) {
            startForegroundService(intent2);
        } else {
            startService(intent2);
        }
    }

    public final void U() {
        startActivity(new Intent(C(), SportsSetActivity.class));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        startActivity(new Intent(C(), V3SportsActivity.class));
        overridePendingTransition(2130772068, 2130772069);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Handler handler;
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.f24070q;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.f24071r;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
        }
        V3MapObserver v3MapObserver = this.f24064k;
        if (v3MapObserver != null) {
            getLifecycle().removeObserver(v3MapObserver);
        }
        V3GeoFenceObserver v3GeoFenceObserver = this.f24065l;
        if (v3GeoFenceObserver != null) {
            getLifecycle().removeObserver(v3GeoFenceObserver);
        }
        V3PassPoint2Observer v3PassPoint2Observer = this.f24066m;
        if (v3PassPoint2Observer != null) {
            getLifecycle().removeObserver(v3PassPoint2Observer);
        }
        stopService(new Intent(this, V3LocationService.class));
        stopService(new Intent(this, V3StepService.class));
        com.bxkj.student.v2.common.data.b.a.b();
        this.f24069p = false;
        this.f24068o = false;
        M().mMapView.onDestroy();
        unbindService(this.f24067n);
        Runnable runnable = this.f24063j;
        if (runnable == null || (handler = this.f24062i) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        M().mMapView.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        M().mMapView.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        f0.p(outState, "outState");
        M().mMapView.onSaveInstanceState(outState);
        outState.putString("sportsSetMap", JSON.toJSONString(com.bxkj.student.v2.common.data.b.a.v()));
        super.onSaveInstanceState(outState);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
