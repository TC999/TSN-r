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
import com.orhanobut.logger.C11792j;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ThreeTwoOneActivity extends Activity {

    /* renamed from: a */
    private TextView f19285a;

    /* renamed from: b */
    private int f19286b = 4;

    /* renamed from: com.bxkj.student.run.app.ready.ThreeTwoOneActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5310a extends AnimatorListenerAdapter {
        C5310a() {
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
            ThreeTwoOneActivity.m39886b(ThreeTwoOneActivity.this);
            C11792j.m20470c("count=" + ThreeTwoOneActivity.this.f19286b);
            if (ThreeTwoOneActivity.this.f19286b == 0) {
                ThreeTwoOneActivity.this.f19285a.setText("GO");
            } else {
                ThreeTwoOneActivity.this.f19285a.setText(String.valueOf(ThreeTwoOneActivity.this.f19286b));
            }
        }
    }

    static {
        StubApp.interface11(12030);
    }

    /* renamed from: b */
    static /* synthetic */ int m39886b(ThreeTwoOneActivity threeTwoOneActivity) {
        int i = threeTwoOneActivity.f19286b;
        threeTwoOneActivity.f19286b = i - 1;
        return i;
    }

    /* renamed from: d */
    private void m39884d() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f19285a, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.setRepeatCount(4);
        ofPropertyValuesHolder.start();
        ofPropertyValuesHolder.addListener(new C5310a());
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
