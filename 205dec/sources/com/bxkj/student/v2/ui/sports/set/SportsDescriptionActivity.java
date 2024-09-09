package com.bxkj.student.v2.ui.sports.set;

import android.os.CountDownTimer;
import android.webkit.WebSettings;
import android.widget.Button;
import androidx.lifecycle.Observer;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.student.databinding.AcV2SportsDescriptionBinding;
import com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity;
import com.bxkj.student.v2.vm.sports.SportsDescriptionVM;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SportsDescriptionActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/set/SportsDescriptionActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2SportsDescriptionBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsDescriptionVM;", "Lkotlin/f1;", "E", "p", "N", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SportsDescriptionActivity extends BaseActivity<AcV2SportsDescriptionBinding, SportsDescriptionVM> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SportsDescriptionActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/bxkj/student/v2/ui/sports/set/SportsDescriptionActivity$a", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "Lkotlin/f1;", "onTick", "onFinish", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends CountDownTimer {
        a() {
            super(4000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SportsDescriptionActivity.this.M().setStartButtonEnable(Boolean.TRUE);
            SportsDescriptionActivity.this.M().btStart.setText("\u5f00\u59cb\u8dd1\u6b65");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j4) {
            Button button = SportsDescriptionActivity.this.M().btStart;
            button.setText("\u5f00\u59cb\u8dd1\u6b65(" + (j4 / 1000) + "\u79d2)");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SportsDescriptionActivity this$0, String str) {
        f0.p(this$0, "this$0");
        if (str == null) {
            return;
        }
        if (this$0.getIntent().hasExtra("showBottom")) {
            this$0.M().setShowBottom(Boolean.valueOf(this$0.getIntent().getBooleanExtra("showBottom", true)));
        } else {
            this$0.M().setShowBottom(Boolean.TRUE);
        }
        this$0.M().swv.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
        this$0.M().swv.h(str);
        new a().start();
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        x().v();
        M().setStartButtonEnable(Boolean.FALSE);
        M().setMActivity(this);
    }

    public final void N() {
        com.bxkj.base.v2.data.a.b.a().O(M().cbIgnore.isChecked());
        startActivity(getIntent().setClass(C(), V3SportsMapActivity.class));
        finish();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        x().u().observe(this, new Observer() { // from class: com.bxkj.student.v2.ui.sports.set.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SportsDescriptionActivity.d(SportsDescriptionActivity.this, (String) obj);
            }
        });
    }
}
