package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.C1108R;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MyGallery extends Gallery implements AdapterView.OnItemSelectedListener {
    private static final int timerAnimation = 1;
    private boolean autoPlay;
    private int count;
    private LinearLayout ll_focus_indicator_container;
    private final Handler mHandler;
    private int preSelImgIndex;
    private final TimerTask task;
    private final Timer timer;

    public MyGallery(Context context) {
        super(context);
        this.preSelImgIndex = 0;
        this.mHandler = new Handler() { // from class: cn.bluemobi.dylan.base.view.MyGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                if (MyGallery.this.getSelectedItemPosition() >= MyGallery.this.getCount() - 1) {
                    MyGallery.this.onKeyDown(21, null);
                } else {
                    MyGallery.this.onKeyDown(22, null);
                }
            }
        };
        Timer timer = new Timer();
        this.timer = timer;
        TimerTask timerTask = new TimerTask() { // from class: cn.bluemobi.dylan.base.view.MyGallery.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MyGallery.this.autoPlay) {
                    MyGallery.this.mHandler.sendEmptyMessage(1);
                } else {
                    MyGallery.this.timer.cancel();
                }
            }
        };
        this.task = timerTask;
        this.autoPlay = true;
        this.count = 0;
        timer.schedule(timerTask, 3000L, 3000L);
    }

    private void InitFocusIndicatorContainer() {
        this.ll_focus_indicator_container.removeAllViews();
        int i = this.count;
        if (i == 0) {
            destroy();
            return;
        }
        if (i == 1) {
            destroy();
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setId(i2);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(10, 10, 10, 10);
            imageView.setLayoutParams(layoutParams);
            imageView.setPadding(0, 0, 0, 0);
            imageView.setImageDrawable(getContext().getResources().getDrawable(C1108R.C1111drawable.pub_dot_normal));
            this.ll_focus_indicator_container.addView(imageView);
        }
    }

    private void init() {
    }

    private boolean isScrollingLeft(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent2.getX() > motionEvent.getX();
    }

    public void destroy() {
        this.timer.cancel();
        this.mHandler.removeCallbacks(this.task);
    }

    public void init(int i, LinearLayout linearLayout) {
        this.count = i;
        this.ll_focus_indicator_container = linearLayout;
        InitFocusIndicatorContainer();
        setOnItemSelectedListener(this);
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        onKeyDown(isScrollingLeft(motionEvent, motionEvent2) ? 21 : 22, null);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = this.count;
        if (i2 == 0) {
            return;
        }
        int i3 = i % i2;
        ImageView imageView = (ImageView) this.ll_focus_indicator_container.findViewById(this.preSelImgIndex);
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(getContext().getResources().getDrawable(C1108R.C1111drawable.pub_dot_normal));
        ((ImageView) this.ll_focus_indicator_container.findViewById(i3)).setImageDrawable(getContext().getResources().getDrawable(C1108R.C1111drawable.pub_dot_focus));
        this.preSelImgIndex = i3;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public MyGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.preSelImgIndex = 0;
        this.mHandler = new Handler() { // from class: cn.bluemobi.dylan.base.view.MyGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                if (MyGallery.this.getSelectedItemPosition() >= MyGallery.this.getCount() - 1) {
                    MyGallery.this.onKeyDown(21, null);
                } else {
                    MyGallery.this.onKeyDown(22, null);
                }
            }
        };
        Timer timer = new Timer();
        this.timer = timer;
        TimerTask timerTask = new TimerTask() { // from class: cn.bluemobi.dylan.base.view.MyGallery.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MyGallery.this.autoPlay) {
                    MyGallery.this.mHandler.sendEmptyMessage(1);
                } else {
                    MyGallery.this.timer.cancel();
                }
            }
        };
        this.task = timerTask;
        this.autoPlay = true;
        this.count = 0;
        timer.schedule(timerTask, 3000L, 3000L);
    }

    public MyGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.preSelImgIndex = 0;
        this.mHandler = new Handler() { // from class: cn.bluemobi.dylan.base.view.MyGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                if (MyGallery.this.getSelectedItemPosition() >= MyGallery.this.getCount() - 1) {
                    MyGallery.this.onKeyDown(21, null);
                } else {
                    MyGallery.this.onKeyDown(22, null);
                }
            }
        };
        Timer timer = new Timer();
        this.timer = timer;
        TimerTask timerTask = new TimerTask() { // from class: cn.bluemobi.dylan.base.view.MyGallery.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MyGallery.this.autoPlay) {
                    MyGallery.this.mHandler.sendEmptyMessage(1);
                } else {
                    MyGallery.this.timer.cancel();
                }
            }
        };
        this.task = timerTask;
        this.autoPlay = true;
        this.count = 0;
        timer.schedule(timerTask, 3000L, 3000L);
        init();
    }
}
