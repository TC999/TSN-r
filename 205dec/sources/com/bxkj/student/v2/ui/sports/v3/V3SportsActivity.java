package com.bxkj.student.v2.ui.sports.v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.student.App;
import com.bxkj.student.common.view.LongPressButton;
import com.bxkj.student.databinding.AcV3SportsBinding;
import com.bxkj.student.v2.common.data.b;
import com.bxkj.student.v2.common.utils.o;
import com.bxkj.student.v2.common.view.StepArcView;
import com.bxkj.student.v2.ui.sports.set.SportsSetActivity;
import com.bxkj.student.v2.ui.sports.v3.service.V3LocationService;
import com.bxkj.student.v2.vm.sports.SportsVM;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3SportsActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\b\u0010\u0011\u001a\u00020\u0004H\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3SportsActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3SportsBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lkotlin/f1;", "S", "N", "V", "", "f", "O", "E", "p", "onBackPressed", "U", "P", "T", "onDestroy", "Landroid/content/BroadcastReceiver;", "i", "Landroid/content/BroadcastReceiver;", "locationServiceBroadCastReceiver", "j", "screenOffBroadCastReceiver", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3SportsActivity extends BaseActivity<AcV3SportsBinding, SportsVM> {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private BroadcastReceiver f23959i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private BroadcastReceiver f23960j;

    private final void N() {
        this.f23959i = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V3SportsActivity$addBroadCastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                if (intent == null) {
                    return;
                }
                V3SportsActivity v3SportsActivity = V3SportsActivity.this;
                if (intent.hasExtra("gpsStatusImage")) {
                    v3SportsActivity.M().ivGps.setImageResource(com.bxkj.student.run.app.utils.i.u(com.bxkj.student.v2.common.data.b.a.m(), 2));
                }
                if (intent.hasExtra("countTime")) {
                    long longExtra = intent.getLongExtra("countTime", 0L);
                    v3SportsActivity.M().saTime.l(((float) longExtra) / 60.0f);
                    v3SportsActivity.M().saTime.n(com.bxkj.base.v2.common.utils.d.b(longExtra));
                }
                if (intent.hasExtra("distance")) {
                    double doubleExtra = intent.getDoubleExtra("distance", 0.0d);
                    v3SportsActivity.M().saDistance.l((float) com.bxkj.student.run.app.utils.i.e(doubleExtra));
                    v3SportsActivity.M().saDistance.n(com.bxkj.student.run.app.utils.i.c(doubleExtra));
                    Integer valueOf = Integer.valueOf(com.bxkj.student.v2.common.data.b.a.a());
                    if (!(valueOf.intValue() != -1)) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        int intValue = valueOf.intValue();
                        v3SportsActivity.M().saTime.o(intValue);
                        StepArcView stepArcView = v3SportsActivity.M().saTime;
                        stepArcView.p("\u6709\u6548\u65f6\u95f4\uff1a(" + com.bxkj.base.v2.common.utils.l.f18624a.t(v3SportsActivity.x().B(), "startQualifiedTime") + '-' + intValue + ")\u5206");
                    }
                }
                if (intent.hasExtra("avgSpeed")) {
                    v3SportsActivity.M().tvAvgSpeed.setText(intent.getStringExtra("avgSpeed"));
                }
                if (intent.hasExtra("pace")) {
                    v3SportsActivity.M().tvPaceSpeed.setText(intent.getStringExtra("pace"));
                }
                if (intent.hasExtra("stepCount")) {
                    int intExtra = intent.getIntExtra("stepCount", com.bxkj.student.v2.common.data.b.a.y());
                    v3SportsActivity.M().saStep.l(intExtra);
                    v3SportsActivity.M().saStep.n(String.valueOf(intExtra));
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(f0.C(App.n().getPackageName(), ".run"));
        BroadcastReceiver broadcastReceiver = this.f23959i;
        if (broadcastReceiver != null) {
            registerReceiver(broadcastReceiver, intentFilter, "com.bxkj.student.sports.permissions.V3_Sports_BROADCAST", null);
        }
        BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V3SportsActivity$addBroadCastReceiver$3
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                f0.p(context, "context");
                f0.p(intent, "intent");
                if (f0.g("android.intent.action.SCREEN_OFF", intent.getAction())) {
                    V3SportsActivity.this.P();
                }
            }
        };
        this.f23960j = broadcastReceiver2;
        registerReceiver(broadcastReceiver2, new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    private final void O(float f4) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f4;
        getWindow().addFlags(2);
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(V3SportsActivity this$0) {
        f0.p(this$0, "this$0");
        this$0.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(V3SportsActivity this$0) {
        f0.p(this$0, "this$0");
        com.bxkj.student.v2.common.data.b.a.R(true);
        V3SportsFinishDialog v3SportsFinishDialog = new V3SportsFinishDialog();
        FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
        f0.o(supportFragmentManager, "supportFragmentManager");
        v3SportsFinishDialog.show(supportFragmentManager, "finishDialog");
    }

    private final void S() {
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
        startActivity(new Intent(C(), V3ThreeTwoOneActivity.class));
    }

    private final void V() {
        O(1.0f);
        M().ivLock.setVisibility(0);
        M().ivToMap.setVisibility(0);
        M().ivStop.setVisibility(0);
        M().ivUnlock.setVisibility(4);
        if (com.bxkj.base.v2.common.utils.l.f18624a.k(com.bxkj.student.v2.common.data.b.a.v(), "runType") == 5) {
            return;
        }
        M().tvAvgSpeed.setVisibility(0);
        M().tvAvgSpeedHint.setVisibility(0);
        M().tvPaceSpeed.setVisibility(0);
        M().tvPaceSpeedHint.setVisibility(0);
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setBackEvent(this);
        S();
        N();
    }

    public final void P() {
        M().ivLock.setVisibility(4);
        M().ivToMap.setVisibility(4);
        M().ivStop.setVisibility(4);
        M().ivUnlock.setVisibility(0);
        O(0.5f);
        if (com.bxkj.base.v2.common.utils.l.f18624a.k(com.bxkj.student.v2.common.data.b.a.v(), "runType") == 5) {
            return;
        }
        M().tvAvgSpeed.setVisibility(4);
        M().tvAvgSpeedHint.setVisibility(4);
        M().tvPaceSpeed.setVisibility(4);
        M().tvPaceSpeedHint.setVisibility(4);
    }

    public final void T() {
        finish();
        overridePendingTransition(0, 2130772088);
    }

    public final void U() {
        startActivity(new Intent(C(), SportsSetActivity.class));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f23959i;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.f23960j;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
        }
        super.onDestroy();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        com.bxkj.student.common.utils.l.g(this, ContextCompat.getColor(C(), 2131034559));
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
                    P();
                }
            }
        }
        b.g gVar = com.bxkj.student.v2.common.data.b.a;
        if ((gVar.v().isEmpty() ? this : null) != null) {
            com.orhanobut.logger.j.d("\u5f02\u5e38\u5212\u6389\u540e\u901a\u8fc7\u70b9\u51fb\u901a\u77e5\u680f\u8fdb\u6765\uff0c\u4e0d\u505a\u4efb\u4f55\u64cd\u4f5c\uff0c\u53ea\u6e05\u9664\u901a\u77e5\u680f", new Object[0]);
            startService(new Intent(this, V3LocationService.class));
            stopService(new Intent(this, V3LocationService.class));
            finish();
        }
        x().G(gVar.v());
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        int k4 = lVar.k(gVar.v(), "runType");
        M().setSportType(k4);
        TabLayout.Tab tabAt = M().tab.getTabAt(0);
        if (tabAt != null) {
            tabAt.setText(o.a.d(k4));
        }
        M().ivUnlock.setOnFinishListener(new LongPressButton.OnFinishListener() { // from class: com.bxkj.student.v2.ui.sports.v3.b
            @Override // com.bxkj.student.common.view.LongPressButton.OnFinishListener
            public final void onFinish() {
                V3SportsActivity.Q(V3SportsActivity.this);
            }
        });
        M().saDistance.k(lVar.i(x().B(), "totalRange"));
        M().saDistance.p("\u76ee\u6807\u91cc\u7a0b\uff1a" + lVar.t(x().B(), "totalRange") + "KM");
        M().saDistance.l((float) com.bxkj.student.run.app.utils.i.e(gVar.f()));
        M().saDistance.n(com.bxkj.student.run.app.utils.i.c(gVar.f()));
        M().saTime.k(lVar.i(x().B(), "startQualifiedTime"));
        M().saTime.p("\u6709\u6548\u65f6\u95f4\uff1a(" + lVar.t(x().B(), "startQualifiedTime") + '-' + lVar.t(x().B(), "endQualifiedTime") + ")\u5206");
        M().saTime.l(((float) gVar.d()) / 60.0f);
        M().saTime.n(com.bxkj.base.v2.common.utils.d.b(gVar.d()));
        Integer valueOf = Integer.valueOf(gVar.a());
        Integer num = valueOf.intValue() != -1 ? valueOf : null;
        if (num != null) {
            int intValue = num.intValue();
            M().saTime.o(intValue);
            M().saTime.p("\u6709\u6548\u65f6\u95f4\uff1a(" + lVar.t(x().B(), "startQualifiedTime") + '-' + intValue + ")\u5206");
        }
        M().saStep.k(lVar.i(x().B(), "step"));
        M().saStep.p(f0.C("\u8fbe\u6807\u6b65\u6570\uff1a", lVar.t(x().B(), "step")));
        M().saStep.l(gVar.y());
        M().saStep.n(String.valueOf(gVar.y()));
        M().tvAvgSpeed.setText(gVar.c());
        M().tvPaceSpeed.setText(gVar.t());
        M().ivGps.setImageResource(com.bxkj.student.run.app.utils.i.u(gVar.m(), 2));
        M().ivStop.setOnFinishListener(new LongPressButton.OnFinishListener() { // from class: com.bxkj.student.v2.ui.sports.v3.a
            @Override // com.bxkj.student.common.view.LongPressButton.OnFinishListener
            public final void onFinish() {
                V3SportsActivity.R(V3SportsActivity.this);
            }
        });
    }
}
