package com.bxkj.student.common.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LoadingView extends LinearLayout {
    Handler handler;
    private RadioGroup rg;
    private Timer timer;
    private TimerTask timerTask;

    public LoadingView(Context context) {
        super(context);
        this.handler = new Handler() { // from class: com.bxkj.student.common.view.LoadingView.2
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                LoadingView.this.rg.check(LoadingView.this.rg.getChildAt((LoadingView.this.rg.indexOfChild(LoadingView.this.rg.findViewById(LoadingView.this.rg.getCheckedRadioButtonId())) + 1) % 3).getId());
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(2131427597, this);
        this.rg = (RadioGroup) findViewById(2131232489);
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
                LoadingView.this.rg.check(LoadingView.this.rg.getChildAt((LoadingView.this.rg.indexOfChild(LoadingView.this.rg.findViewById(LoadingView.this.rg.getCheckedRadioButtonId())) + 1) % 3).getId());
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
                LoadingView.this.rg.check(LoadingView.this.rg.getChildAt((LoadingView.this.rg.indexOfChild(LoadingView.this.rg.findViewById(LoadingView.this.rg.getCheckedRadioButtonId())) + 1) % 3).getId());
            }
        };
        init(context);
    }
}
