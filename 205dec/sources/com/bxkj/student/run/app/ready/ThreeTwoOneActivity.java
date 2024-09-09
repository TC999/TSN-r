package com.bxkj.student.run.app.ready;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.bxkj.student.run.app.RunningActivity;
import com.orhanobut.logger.j;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ThreeTwoOneActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f22521a;

    /* renamed from: b  reason: collision with root package name */
    private int f22522b = 4;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            Intent intent = ThreeTwoOneActivity.this.getIntent();
            intent.setClass(ThreeTwoOneActivity.this, RunningActivity.class);
            ThreeTwoOneActivity.this.startActivity(intent);
            ThreeTwoOneActivity.this.overridePendingTransition(2130771987, 2130771986);
            ThreeTwoOneActivity.this.finish();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            super.onAnimationRepeat(animation);
            ThreeTwoOneActivity.b(ThreeTwoOneActivity.this);
            j.c("count=" + ThreeTwoOneActivity.this.f22522b);
            if (ThreeTwoOneActivity.this.f22522b == 0) {
                ThreeTwoOneActivity.this.f22521a.setText("GO");
            } else {
                ThreeTwoOneActivity.this.f22521a.setText(String.valueOf(ThreeTwoOneActivity.this.f22522b));
            }
        }
    }

    static {
        StubApp.interface11(12030);
    }

    static /* synthetic */ int b(ThreeTwoOneActivity threeTwoOneActivity) {
        int i4 = threeTwoOneActivity.f22522b;
        threeTwoOneActivity.f22522b = i4 - 1;
        return i4;
    }

    private void d() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f22521a, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.setRepeatCount(4);
        ofPropertyValuesHolder.start();
        ofPropertyValuesHolder.addListener(new a());
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
