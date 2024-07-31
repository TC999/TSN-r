package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class CountdownButton extends AppCompatButton {
    private String afterText;
    private String beforeText;
    private Handler handler;
    private long length;
    private View.OnClickListener onClickListener;
    private Timer timer;
    private TimerTask timerTask;

    public CountdownButton(Context context) {
        super(context);
        this.length = 60000L;
        this.beforeText = "获取验证码";
        this.afterText = "秒";
        this.handler = new Handler() { // from class: cn.bluemobi.dylan.base.view.CountdownButton.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                CountdownButton countdownButton = CountdownButton.this;
                countdownButton.setText((CountdownButton.this.length / 1000) + CountdownButton.this.afterText);
                CountdownButton countdownButton2 = CountdownButton.this;
                countdownButton2.length = countdownButton2.length - 1000;
                if (CountdownButton.this.length < 0) {
                    CountdownButton.this.setEnabled(true);
                    CountdownButton countdownButton3 = CountdownButton.this;
                    countdownButton3.setText(countdownButton3.beforeText);
                    CountdownButton.this.clearTimer();
                }
            }
        };
        initView();
    }

    private void initTimer() {
        this.timer = new Timer();
        this.timerTask = new TimerTask() { // from class: cn.bluemobi.dylan.base.view.CountdownButton.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                CountdownButton.this.handler.sendEmptyMessage(1);
            }
        };
    }

    private void initView() {
        if (!TextUtils.isEmpty(getText())) {
            this.beforeText = getText().toString().trim();
        }
        setText(this.beforeText);
    }

    public void clearTimer() {
        this.length = 60000L;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.timerTask);
        }
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.timerTask = null;
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        clearTimer();
        super.onDetachedFromWindow();
    }

    public void setAfterText(String str) {
        this.afterText = this.afterText;
    }

    public void setBeforeText(String str) {
        this.beforeText = str;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void start() {
        initTimer();
        setText((this.length / 1000) + this.afterText);
        setEnabled(false);
        this.timer.schedule(this.timerTask, 0L, 1000L);
    }

    public CountdownButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.length = 60000L;
        this.beforeText = "获取验证码";
        this.afterText = "秒";
        this.handler = new Handler() { // from class: cn.bluemobi.dylan.base.view.CountdownButton.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                CountdownButton countdownButton = CountdownButton.this;
                countdownButton.setText((CountdownButton.this.length / 1000) + CountdownButton.this.afterText);
                CountdownButton countdownButton2 = CountdownButton.this;
                countdownButton2.length = countdownButton2.length - 1000;
                if (CountdownButton.this.length < 0) {
                    CountdownButton.this.setEnabled(true);
                    CountdownButton countdownButton3 = CountdownButton.this;
                    countdownButton3.setText(countdownButton3.beforeText);
                    CountdownButton.this.clearTimer();
                }
            }
        };
        initView();
    }

    public CountdownButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.length = 60000L;
        this.beforeText = "获取验证码";
        this.afterText = "秒";
        this.handler = new Handler() { // from class: cn.bluemobi.dylan.base.view.CountdownButton.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                CountdownButton countdownButton = CountdownButton.this;
                countdownButton.setText((CountdownButton.this.length / 1000) + CountdownButton.this.afterText);
                CountdownButton countdownButton2 = CountdownButton.this;
                countdownButton2.length = countdownButton2.length - 1000;
                if (CountdownButton.this.length < 0) {
                    CountdownButton.this.setEnabled(true);
                    CountdownButton countdownButton3 = CountdownButton.this;
                    countdownButton3.setText(countdownButton3.beforeText);
                    CountdownButton.this.clearTimer();
                }
            }
        };
        initView();
    }
}
