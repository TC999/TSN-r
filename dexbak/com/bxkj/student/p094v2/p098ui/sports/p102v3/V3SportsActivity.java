package com.bxkj.student.p094v2.p098ui.sports.p102v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.common.utils.DataFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.App;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.C4254l;
import com.bxkj.student.common.view.LongPressButton;
import com.bxkj.student.databinding.AcV3SportsBinding;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.data.SportsPermission;
import com.bxkj.student.p094v2.common.utils.SportsType;
import com.bxkj.student.p094v2.common.view.StepArcView;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3LocationService;
import com.bxkj.student.p094v2.p098ui.sports.set.SportsSetActivity;
import com.bxkj.student.p094v2.p103vm.sports.SportsVM;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.tabs.TabLayout;
import com.orhanobut.logger.C11792j;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3SportsActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\b\u0010\u0011\u001a\u00020\u0004H\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3SportsActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3SportsBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lkotlin/f1;", ExifInterface.LATITUDE_SOUTH, "N", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "f", "O", ExifInterface.LONGITUDE_EAST, "p", "onBackPressed", "U", "P", ExifInterface.GPS_DIRECTION_TRUE, "onDestroy", "Landroid/content/BroadcastReceiver;", "i", "Landroid/content/BroadcastReceiver;", "locationServiceBroadCastReceiver", "j", "screenOffBroadCastReceiver", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3SportsActivity extends BaseActivity<AcV3SportsBinding, SportsVM> {
    @Nullable

    /* renamed from: i */
    private BroadcastReceiver f20560i;
    @Nullable

    /* renamed from: j */
    private BroadcastReceiver f20561j;

    /* renamed from: N */
    private final void m38588N() {
        this.f20560i = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V3SportsActivity$addBroadCastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                if (intent == null) {
                    return;
                }
                V3SportsActivity v3SportsActivity = V3SportsActivity.this;
                if (intent.hasExtra("gpsStatusImage")) {
                    v3SportsActivity.mo43920M().ivGps.setImageResource(FormatUtils.m39616u(SportsDataAgent.f19899a.m39259m(), 2));
                }
                if (intent.hasExtra("countTime")) {
                    long longExtra = intent.getLongExtra("countTime", 0L);
                    v3SportsActivity.mo43920M().saTime.m39020l(((float) longExtra) / 60.0f);
                    v3SportsActivity.mo43920M().saTime.m39018n(DataFormatUtils.m43807b(longExtra));
                }
                if (intent.hasExtra("distance")) {
                    double doubleExtra = intent.getDoubleExtra("distance", Utils.DOUBLE_EPSILON);
                    v3SportsActivity.mo43920M().saDistance.m39020l((float) FormatUtils.m39632e(doubleExtra));
                    v3SportsActivity.mo43920M().saDistance.m39018n(FormatUtils.m39634c(doubleExtra));
                    Integer valueOf = Integer.valueOf(SportsDataAgent.f19899a.m39280a());
                    if (!(valueOf.intValue() != -1)) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        int intValue = valueOf.intValue();
                        v3SportsActivity.mo43920M().saTime.m39017o(intValue);
                        StepArcView stepArcView = v3SportsActivity.mo43920M().saTime;
                        stepArcView.m39016p("有效时间：(" + JsonGet.f15134a.m43760t(v3SportsActivity.mo43911x().m38035B(), "startQualifiedTime") + '-' + intValue + ")分");
                    }
                }
                if (intent.hasExtra("avgSpeed")) {
                    v3SportsActivity.mo43920M().tvAvgSpeed.setText(intent.getStringExtra("avgSpeed"));
                }
                if (intent.hasExtra("pace")) {
                    v3SportsActivity.mo43920M().tvPaceSpeed.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("stepCount")) {
                    int intExtra = intent.getIntExtra("stepCount", SportsDataAgent.f19899a.m39247y());
                    v3SportsActivity.mo43920M().saStep.m39020l(intExtra);
                    v3SportsActivity.mo43920M().saStep.m39018n(String.valueOf(intExtra));
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(C14342f0.m8216C(App.m43006n().getPackageName(), ".run"));
        BroadcastReceiver broadcastReceiver = this.f20560i;
        if (broadcastReceiver != null) {
            registerReceiver(broadcastReceiver, intentFilter, SportsPermission.f19933b, null);
        }
        BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V3SportsActivity$addBroadCastReceiver$3
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                C14342f0.m8184p(context, "context");
                C14342f0.m8184p(intent, "intent");
                if (C14342f0.m8193g("android.intent.action.SCREEN_OFF", intent.getAction())) {
                    V3SportsActivity.this.m38586P();
                }
            }
        };
        this.f20561j = broadcastReceiver2;
        registerReceiver(broadcastReceiver2, new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    /* renamed from: O */
    private final void m38587O(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().addFlags(2);
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public static final void m38585Q(V3SportsActivity this$0) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38580V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public static final void m38584R(V3SportsActivity this$0) {
        C14342f0.m8184p(this$0, "this$0");
        SportsDataAgent.f19899a.m39289R(true);
        V3SportsFinishDialog v3SportsFinishDialog = new V3SportsFinishDialog();
        FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
        C14342f0.m8185o(supportFragmentManager, "supportFragmentManager");
        v3SportsFinishDialog.show(supportFragmentManager, "finishDialog");
    }

    /* renamed from: S */
    private final void m38583S() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (!getIntent().hasExtra("isStart")) {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        if ((getIntent().getBooleanExtra("isStart", false) ? intent : null) == null) {
            return;
        }
        startActivity(new Intent(mo43926C(), V3ThreeTwoOneActivity.class));
    }

    /* renamed from: V */
    private final void m38580V() {
        m38587O(1.0f);
        mo43920M().ivLock.setVisibility(0);
        mo43920M().ivToMap.setVisibility(0);
        mo43920M().ivStop.setVisibility(0);
        mo43920M().ivUnlock.setVisibility(4);
        if (JsonGet.f15134a.m43769k(SportsDataAgent.f19899a.m39250v(), "runType") == 5) {
            return;
        }
        mo43920M().tvAvgSpeed.setVisibility(0);
        mo43920M().tvAvgSpeedHint.setVisibility(0);
        mo43920M().tvPaceSpeed.setVisibility(0);
        mo43920M().tvPaceSpeedHint.setVisibility(0);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setBackEvent(this);
        m38583S();
        m38588N();
    }

    /* renamed from: P */
    public final void m38586P() {
        mo43920M().ivLock.setVisibility(4);
        mo43920M().ivToMap.setVisibility(4);
        mo43920M().ivStop.setVisibility(4);
        mo43920M().ivUnlock.setVisibility(0);
        m38587O(0.5f);
        if (JsonGet.f15134a.m43769k(SportsDataAgent.f19899a.m39250v(), "runType") == 5) {
            return;
        }
        mo43920M().tvAvgSpeed.setVisibility(4);
        mo43920M().tvAvgSpeedHint.setVisibility(4);
        mo43920M().tvPaceSpeed.setVisibility(4);
        mo43920M().tvPaceSpeedHint.setVisibility(4);
    }

    /* renamed from: T */
    public final void m38582T() {
        finish();
        overridePendingTransition(0, 2130772088);
    }

    /* renamed from: U */
    public final void m38581U() {
        startActivity(new Intent(mo43926C(), SportsSetActivity.class));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.bxkj.base.p085v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f20560i;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.f20561j;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
        }
        super.onDestroy();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        C4254l.m42811g(this, ContextCompat.getColor(mo43926C(), C4215R.C4217color.v3_sporting_color));
        Intent intent = getIntent();
        if (intent != null) {
            if (!getIntent().hasExtra("isLock")) {
                intent = null;
            }
            if (intent != null) {
                if (!getIntent().getBooleanExtra("isLock", false)) {
                    intent = null;
                }
                if (intent != null) {
                    m38586P();
                }
            }
        }
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        if ((c5481g.m39250v().isEmpty() ? this : null) != null) {
            C11792j.m20469d("异常划掉后通过点击通知栏进来，不做任何操作，只清除通知栏", new Object[0]);
            startService(new Intent(this, V3LocationService.class));
            stopService(new Intent(this, V3LocationService.class));
            finish();
        }
        mo43911x().m38030G(c5481g.m39250v());
        JsonGet jsonGet = JsonGet.f15134a;
        int m43769k = jsonGet.m43769k(c5481g.m39250v(), "runType");
        mo43920M().setSportType(m43769k);
        TabLayout.Tab tabAt = mo43920M().tab.getTabAt(0);
        if (tabAt != null) {
            tabAt.setText(SportsType.f20137a.m39060d(m43769k));
        }
        mo43920M().ivUnlock.setOnFinishListener(new LongPressButton.OnFinishListener() { // from class: com.bxkj.student.v2.ui.sports.v3.b
            @Override // com.bxkj.student.common.view.LongPressButton.OnFinishListener
            public final void onFinish() {
                V3SportsActivity.m38585Q(V3SportsActivity.this);
            }
        });
        mo43920M().saDistance.m39021k(jsonGet.m43771i(mo43911x().m38035B(), "totalRange"));
        mo43920M().saDistance.m39016p("目标里程：" + jsonGet.m43760t(mo43911x().m38035B(), "totalRange") + "KM");
        mo43920M().saDistance.m39020l((float) FormatUtils.m39632e(c5481g.m39270f()));
        mo43920M().saDistance.m39018n(FormatUtils.m39634c(c5481g.m39270f()));
        mo43920M().saTime.m39021k(jsonGet.m43771i(mo43911x().m38035B(), "startQualifiedTime"));
        mo43920M().saTime.m39016p("有效时间：(" + jsonGet.m43760t(mo43911x().m38035B(), "startQualifiedTime") + '-' + jsonGet.m43760t(mo43911x().m38035B(), "endQualifiedTime") + ")分");
        mo43920M().saTime.m39020l(((float) c5481g.m39274d()) / 60.0f);
        mo43920M().saTime.m39018n(DataFormatUtils.m43807b(c5481g.m39274d()));
        Integer valueOf = Integer.valueOf(c5481g.m39280a());
        Integer num = valueOf.intValue() != -1 ? valueOf : null;
        if (num != null) {
            int intValue = num.intValue();
            mo43920M().saTime.m39017o(intValue);
            mo43920M().saTime.m39016p("有效时间：(" + jsonGet.m43760t(mo43911x().m38035B(), "startQualifiedTime") + '-' + intValue + ")分");
        }
        mo43920M().saStep.m39021k(jsonGet.m43771i(mo43911x().m38035B(), "step"));
        mo43920M().saStep.m39016p(C14342f0.m8216C("达标步数：", jsonGet.m43760t(mo43911x().m38035B(), "step")));
        mo43920M().saStep.m39020l(c5481g.m39247y());
        mo43920M().saStep.m39018n(String.valueOf(c5481g.m39247y()));
        mo43920M().tvAvgSpeed.setText(c5481g.m39276c());
        mo43920M().tvPaceSpeed.setText(c5481g.m39252t());
        mo43920M().ivGps.setImageResource(FormatUtils.m39616u(c5481g.m39259m(), 2));
        mo43920M().ivStop.setOnFinishListener(new LongPressButton.OnFinishListener() { // from class: com.bxkj.student.v2.ui.sports.v3.a
            @Override // com.bxkj.student.common.view.LongPressButton.OnFinishListener
            public final void onFinish() {
                V3SportsActivity.m38584R(V3SportsActivity.this);
            }
        });
    }
}
