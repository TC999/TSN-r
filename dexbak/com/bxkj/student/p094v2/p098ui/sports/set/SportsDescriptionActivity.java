package com.bxkj.student.p094v2.p098ui.sports.set;

import android.os.CountDownTimer;
import android.webkit.WebSettings;
import android.widget.Button;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.databinding.AcV2SportsDescriptionBinding;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsMapActivity;
import com.bxkj.student.p094v2.p103vm.sports.SportsDescriptionVM;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;

/* compiled from: SportsDescriptionActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/set/SportsDescriptionActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2SportsDescriptionBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsDescriptionVM;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "N", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.set.SportsDescriptionActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SportsDescriptionActivity extends BaseActivity<AcV2SportsDescriptionBinding, SportsDescriptionVM> {

    /* compiled from: SportsDescriptionActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/set/SportsDescriptionActivity$a", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "Lkotlin/f1;", "onTick", "onFinish", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.set.SportsDescriptionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class CountDownTimerC5705a extends CountDownTimer {
        CountDownTimerC5705a() {
            super(DanmakuFactory.f43786r, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SportsDescriptionActivity.this.mo43920M().setStartButtonEnable(Boolean.TRUE);
            SportsDescriptionActivity.this.mo43920M().btStart.setText("开始跑步");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Button button = SportsDescriptionActivity.this.mo43920M().btStart;
            button.setText("开始跑步(" + (j / 1000) + "秒)");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static final void m38607d(SportsDescriptionActivity this$0, String str) {
        C14342f0.m8184p(this$0, "this$0");
        if (str == null) {
            return;
        }
        if (this$0.getIntent().hasExtra("showBottom")) {
            this$0.mo43920M().setShowBottom(Boolean.valueOf(this$0.getIntent().getBooleanExtra("showBottom", true)));
        } else {
            this$0.mo43920M().setShowBottom(Boolean.TRUE);
        }
        this$0.mo43920M().swv.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
        this$0.mo43920M().swv.m57495h(str);
        new CountDownTimerC5705a().start();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43911x().m38084v();
        mo43920M().setStartButtonEnable(Boolean.FALSE);
        mo43920M().setMActivity(this);
    }

    /* renamed from: N */
    public final void m38609N() {
        LoggedInUser.f15182b.m43634a().m43676O(mo43920M().cbIgnore.isChecked());
        startActivity(getIntent().setClass(mo43926C(), V3SportsMapActivity.class));
        finish();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43911x().m38085u().observe(this, new Observer() { // from class: com.bxkj.student.v2.ui.sports.set.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SportsDescriptionActivity.m38607d(SportsDescriptionActivity.this, (String) obj);
            }
        });
    }
}
