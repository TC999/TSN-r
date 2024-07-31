package com.bxkj.student.p094v2.p098ui.sports.p102v3;

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
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.DataFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.util.C3919y;
import com.bxkj.student.App;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.C4254l;
import com.bxkj.student.databinding.AcV3SportsMapBinding;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.data.SportsPermission;
import com.bxkj.student.p094v2.common.utils.SportsType;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3GeoFenceObserver;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3KillNotificationsService;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3LocationService;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3MapObserver;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3PassPoint2Observer;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.step.V3StepService;
import com.bxkj.student.p094v2.p098ui.sports.set.SportsSetActivity;
import com.bxkj.student.p094v2.p103vm.sports.SportsVM;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.tabs.TabLayout;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.SportsDb;
import p581d0.VoiceUtils;
import p617l1.InterfaceC15280l;

/* compiled from: V3SportsMapActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b=\u0010>J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\fH\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00106\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109¨\u0006?"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3SportsMapActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3SportsMapBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lkotlin/f1;", "N", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "U", "p", ExifInterface.GPS_DIRECTION_TRUE, "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onResume", "onPause", "onDestroy", "outState", "onSaveInstanceState", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "countDownHandler", "Ljava/lang/Runnable;", "j", "Ljava/lang/Runnable;", "countDownRunnable", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3MapObserver;", "k", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3MapObserver;", "v3MapObserver", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3GeoFenceObserver;", C7304t.f25048d, "Lcom/bxkj/student/v2/ui/sports/v3/service/V3GeoFenceObserver;", "v3GeoFenceObserver", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer;", "m", "Lcom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer;", "v3PassPoint2Observer", "Landroid/content/ServiceConnection;", "n", "Landroid/content/ServiceConnection;", "mConnection", "", "o", "Z", "P", "()Z", "R", "(Z)V", "isResume", "O", "Q", "isFirstPointSuccess", "Landroid/content/BroadcastReceiver;", CampaignEx.JSON_KEY_AD_Q, "Landroid/content/BroadcastReceiver;", "locationServiceBroadCastReceiver", "r", "screenOffBroadCastReceiver", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3SportsMapActivity extends BaseActivity<AcV3SportsMapBinding, SportsVM> {
    @Nullable

    /* renamed from: i */
    private Handler f20647i;
    @Nullable

    /* renamed from: j */
    private Runnable f20648j;
    @Nullable

    /* renamed from: k */
    private V3MapObserver f20649k;
    @Nullable

    /* renamed from: l */
    private V3GeoFenceObserver f20650l;
    @Nullable

    /* renamed from: m */
    private V3PassPoint2Observer f20651m;
    @NotNull

    /* renamed from: n */
    private final ServiceConnection f20652n = new ServiceConnectionC5754b();

    /* renamed from: o */
    private boolean f20653o;

    /* renamed from: p */
    private boolean f20654p;
    @Nullable

    /* renamed from: q */
    private BroadcastReceiver f20655q;
    @Nullable

    /* renamed from: r */
    private BroadcastReceiver f20656r;

    /* compiled from: V3SportsMapActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, m12616d2 = {"Lc0/c;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5753a extends Lambda implements InterfaceC15280l<SportsDb, Unit> {
        C5753a() {
            super(1);
        }

        /* renamed from: a */
        public final void m38464a(@Nullable SportsDb sportsDb) {
            V3SportsMapActivity.this.m38470S();
            V3SportsMapActivity v3SportsMapActivity = V3SportsMapActivity.this;
            AMap map = V3SportsMapActivity.this.mo43920M().mMapView.getMap();
            C14342f0.m8185o(map, "mDataBinding.mMapView.map");
            v3SportsMapActivity.f20649k = new V3MapObserver(v3SportsMapActivity, v3SportsMapActivity.mo43911x(), map);
            V3MapObserver v3MapObserver = V3SportsMapActivity.this.f20649k;
            if (v3MapObserver == null) {
                return;
            }
            V3SportsMapActivity.this.getLifecycle().addObserver(v3MapObserver);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(SportsDb sportsDb) {
            m38464a(sportsDb);
            return Unit.f41048a;
        }
    }

    /* compiled from: V3SportsMapActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsMapActivity$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "className", "Landroid/os/IBinder;", "binder", "Lkotlin/f1;", "onServiceConnected", "onServiceDisconnected", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class ServiceConnectionC5754b implements ServiceConnection {
        ServiceConnectionC5754b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@NotNull ComponentName className, @NotNull IBinder binder) {
            C14342f0.m8184p(className, "className");
            C14342f0.m8184p(binder, "binder");
            ((V3KillNotificationsService.BinderC5803a) binder).m38330a().startService(new Intent(V3SportsMapActivity.this.mo43926C(), V3KillNotificationsService.class));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@NotNull ComponentName className) {
            C14342f0.m8184p(className, "className");
        }
    }

    static {
        StubApp.interface11(12648);
    }

    /* renamed from: N */
    private final void m38475N() {
        this.f20655q = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity$addBroadCastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                if (intent == null) {
                    return;
                }
                V3SportsMapActivity v3SportsMapActivity = V3SportsMapActivity.this;
                if (intent.hasExtra("firstMapLocation")) {
                    v3SportsMapActivity.m38472Q(true);
                    if (v3SportsMapActivity.m38473P()) {
                        v3SportsMapActivity.m38469T();
                    }
                }
                if (intent.hasExtra("gpsStatusImage")) {
                    v3SportsMapActivity.mo43920M().ivGps.setImageResource(FormatUtils.m39616u(SportsDataAgent.f19899a.m39259m(), 0));
                }
                if (intent.hasExtra("countTime")) {
                    v3SportsMapActivity.mo43920M().tvTime.setText(DataFormatUtils.m43807b(intent.getLongExtra("countTime", 0L)));
                }
                if (intent.hasExtra("distance")) {
                    v3SportsMapActivity.mo43920M().tvDistance.setText(FormatUtils.m39634c(intent.getDoubleExtra("distance", Utils.DOUBLE_EPSILON)));
                }
                if (intent.hasExtra("pace")) {
                    v3SportsMapActivity.mo43920M().tvPeisu.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("stepCount")) {
                    v3SportsMapActivity.mo43920M().tvStep.setText(String.valueOf(intent.getIntExtra("stepCount", SportsDataAgent.f19899a.m39247y())));
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
        BroadcastReceiver broadcastReceiver = this.f20655q;
        if (broadcastReceiver != null) {
            registerReceiver(broadcastReceiver, intentFilter, SportsPermission.f19933b, null);
        }
        BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity$addBroadCastReceiver$3
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                C14342f0.m8184p(context, "context");
                C14342f0.m8184p(intent, "intent");
                if (C14342f0.m8193g("android.intent.action.SCREEN_OFF", intent.getAction())) {
                    V3SportsMapActivity.this.startActivity(new Intent(V3SportsMapActivity.this.mo43926C(), V3SportsActivity.class).putExtra("isLock", true));
                    V3SportsMapActivity.this.overridePendingTransition(C4215R.anim.qr_code_zoom_in, C4215R.anim.qr_code_zoom_out);
                }
            }
        };
        this.f20656r = broadcastReceiver2;
        registerReceiver(broadcastReceiver2, new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public final void m38470S() {
        if (C3919y.m44006a(mo43926C(), V3LocationService.class.getName())) {
            return;
        }
        Intent intent = new Intent(this, V3LocationService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        try {
            SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
            c5481g.m39278b();
            m38475N();
            startActivity(new Intent(mo43926C(), V3SportsActivity.class).putExtra("isStart", true));
            overridePendingTransition(C4215R.anim.qr_code_zoom_in, C4215R.anim.qr_code_zoom_out);
            mo43920M().setBackEvent(this);
            bindService(new Intent(mo43926C(), V3KillNotificationsService.class), this.f20652n, 1);
            if (!c5481g.m39250v().isEmpty()) {
                mo43911x().m38030G(c5481g.m39250v());
                Object obj = mo43911x().m38035B().get("runType");
                if (obj == null) {
                    obj = -1;
                }
                if (obj == null) {
                    obj = -1;
                }
                int parseInt = Integer.parseInt(obj.toString());
                mo43920M().setSportType(parseInt);
                mo43920M().setTitle(C14342f0.m8216C(SportsType.f20137a.m39060d(parseInt), "中"));
            } else {
                ContextExt.m43848p(this, "数据异常，没有运动类型");
                C11792j.m20468e("数据异常，没有运动类型", new Object[0]);
                finish();
            }
            Object obj2 = mo43911x().m38035B().get("identify");
            if (obj2 == null) {
                obj2 = "";
            }
            String valueOf = String.valueOf(obj2);
            if (TextUtils.isEmpty(valueOf)) {
                ContextExt.m43848p(this, "数据异常，没有身份");
                C11792j.m20468e("数据异常，没有身份", new Object[0]);
                finish();
            }
            mo43911x().m38032E(valueOf, new C5753a());
            Object obj3 = mo43911x().m38035B().get("context");
            String valueOf2 = String.valueOf(obj3 != null ? obj3 : "");
            Object obj4 = mo43911x().m38035B().get("isClock");
            if (obj4 == null) {
                obj4 = "0";
            }
            String valueOf3 = String.valueOf(obj4);
            mo43920M().setNotice(valueOf2);
            mo43920M().setIsClock(valueOf3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int m43769k = JsonGet.f15134a.m43769k(SportsDataAgent.f19899a.m39250v(), "runType");
        TabLayout.Tab tabAt = mo43920M().tab.getTabAt(0);
        if (tabAt != null) {
            tabAt.setText(SportsType.f20137a.m39060d(m43769k));
        }
        int color = ContextCompat.getColor(mo43926C(), C4215R.C4217color.v3_tab_color3);
        mo43920M().titleLayout.setBackgroundResource(C4215R.C4217color.v3_tab_color3);
        C4254l.m42811g(this, color);
        mo43920M().tvGps.setTextColor(color);
    }

    /* renamed from: O */
    public final boolean m38474O() {
        return this.f20654p;
    }

    /* renamed from: P */
    public final boolean m38473P() {
        return this.f20653o;
    }

    /* renamed from: Q */
    public final void m38472Q(boolean z) {
        this.f20654p = z;
    }

    /* renamed from: R */
    public final void m38471R(boolean z) {
        this.f20653o = z;
    }

    /* renamed from: T */
    public final void m38469T() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        if (c5481g.m39248x() == 0) {
            c5481g.m39265h0(System.currentTimeMillis());
        }
        VoiceUtils.f40105a.m12842b(mo43926C(), C4215R.raw.run_start);
        AMap map = mo43920M().mMapView.getMap();
        C14342f0.m8185o(map, "mDataBinding.mMapView.map");
        V3GeoFenceObserver v3GeoFenceObserver = new V3GeoFenceObserver(this, mo43911x(), map);
        this.f20650l = v3GeoFenceObserver;
        getLifecycle().addObserver(v3GeoFenceObserver);
        MapView mapView = mo43920M().mMapView;
        C14342f0.m8185o(mapView, "mDataBinding.mMapView");
        V3PassPoint2Observer v3PassPoint2Observer = new V3PassPoint2Observer(this, mo43911x(), mapView);
        this.f20651m = v3PassPoint2Observer;
        getLifecycle().addObserver(v3PassPoint2Observer);
        Intent intent = new Intent(this, V3LocationService.class);
        intent.putExtra(CampaignEx.JSON_NATIVE_VIDEO_START, true);
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
        if (C3919y.m44006a(mo43926C(), V3StepService.class.getName())) {
            return;
        }
        Intent intent2 = new Intent(this, V3StepService.class);
        if (i >= 26) {
            startForegroundService(intent2);
        } else {
            startService(intent2);
        }
    }

    /* renamed from: U */
    public final void m38468U() {
        startActivity(new Intent(mo43926C(), SportsSetActivity.class));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        startActivity(new Intent(mo43926C(), V3SportsActivity.class));
        overridePendingTransition(C4215R.anim.qr_code_zoom_in, C4215R.anim.qr_code_zoom_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Handler handler;
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.f20655q;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.f20656r;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
        }
        V3MapObserver v3MapObserver = this.f20649k;
        if (v3MapObserver != null) {
            getLifecycle().removeObserver(v3MapObserver);
        }
        V3GeoFenceObserver v3GeoFenceObserver = this.f20650l;
        if (v3GeoFenceObserver != null) {
            getLifecycle().removeObserver(v3GeoFenceObserver);
        }
        V3PassPoint2Observer v3PassPoint2Observer = this.f20651m;
        if (v3PassPoint2Observer != null) {
            getLifecycle().removeObserver(v3PassPoint2Observer);
        }
        stopService(new Intent(this, V3LocationService.class));
        stopService(new Intent(this, V3StepService.class));
        SportsDataAgent.f19899a.m39278b();
        this.f20654p = false;
        this.f20653o = false;
        mo43920M().mMapView.onDestroy();
        unbindService(this.f20652n);
        Runnable runnable = this.f20648j;
        if (runnable == null || (handler = this.f20647i) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        mo43920M().mMapView.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        mo43920M().mMapView.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        C14342f0.m8184p(outState, "outState");
        mo43920M().mMapView.onSaveInstanceState(outState);
        outState.putString("sportsSetMap", JSON.toJSONString(SportsDataAgent.f19899a.m39250v()));
        super.onSaveInstanceState(outState);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
