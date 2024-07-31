package com.bxkj.student.common.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import com.bxkj.student.C4215R;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LoadingView extends LinearLayout {
    Handler handler;

    /* renamed from: rg */
    private RadioGroup f16274rg;
    private Timer timer;
    private TimerTask timerTask;

    public LoadingView(Context context) {
        super(context);
        this.handler = new Handler() { // from class: com.bxkj.student.common.view.LoadingView.2
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                LoadingView.this.f16274rg.check(LoadingView.this.f16274rg.getChildAt((LoadingView.this.f16274rg.indexOfChild(LoadingView.this.f16274rg.findViewById(LoadingView.this.f16274rg.getCheckedRadioButtonId())) + 1) % 3).getId());
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(C4215R.C4221layout.dialog_loading, this);
        this.f16274rg = (RadioGroup) findViewById(2131232489);
        this.timer = new Timer();
        this.timerTask = new TimerTask() { // from class: com.bxkj.student.common.view.LoadingView.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LoadingView.this.handler.sendEmptyMessage(0);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.timer.schedule(this.timerTask, 0L, 300L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.handler.removeCallbacks(this.timerTask);
        this.timer.cancel();
        super.onDetachedFromWindow();
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.handler = new Handler() { // from class: com.bxkj.student.common.view.LoadingView.2
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                LoadingView.this.f16274rg.check(LoadingView.this.f16274rg.getChildAt((LoadingView.this.f16274rg.indexOfChild(LoadingView.this.f16274rg.findViewById(LoadingView.this.f16274rg.getCheckedRadioButtonId())) + 1) % 3).getId());
            }
        };
        init(context);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.handler = new Handler() { // from class: com.bxkj.student.common.view.LoadingView.2
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                LoadingView.this.f16274rg.check(LoadingView.this.f16274rg.getChildAt((LoadingView.this.f16274rg.indexOfChild(LoadingView.this.f16274rg.findViewById(LoadingView.this.f16274rg.getCheckedRadioButtonId())) + 1) % 3).getId());
            }
        };
        init(context);
    }
}
