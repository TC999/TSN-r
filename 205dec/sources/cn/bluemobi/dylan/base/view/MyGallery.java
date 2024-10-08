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
import cn.bluemobi.dylan.base.R;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
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
        int i4 = this.count;
        if (i4 == 0) {
            destroy();
            return;
        }
        if (i4 == 1) {
            destroy();
        }
        for (int i5 = 0; i5 < this.count; i5++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setId(i5);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(10, 10, 10, 10);
            imageView.setLayoutParams(layoutParams);
            imageView.setPadding(0, 0, 0, 0);
            imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.pub_dot_normal));
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

    public void init(int i4, LinearLayout linearLayout) {
        this.count = i4;
        this.ll_focus_indicator_container = linearLayout;
        InitFocusIndicatorContainer();
        setOnItemSelectedListener(this);
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        onKeyDown(isScrollingLeft(motionEvent, motionEvent2) ? 21 : 22, null);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
        int i5 = this.count;
        if (i5 == 0) {
            return;
        }
        int i6 = i4 % i5;
        ImageView imageView = (ImageView) this.ll_focus_indicator_container.findViewById(this.preSelImgIndex);
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.pub_dot_normal));
        ((ImageView) this.ll_focus_indicator_container.findViewById(i6)).setImageDrawable(getContext().getResources().getDrawable(R.drawable.pub_dot_focus));
        this.preSelImgIndex = i6;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAutoPlay(boolean z3) {
        this.autoPlay = z3;
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

    public MyGallery(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
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
