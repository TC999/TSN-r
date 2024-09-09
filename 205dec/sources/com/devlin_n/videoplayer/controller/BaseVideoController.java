package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c1.f;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.widget.CenterView;
import java.util.Formatter;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class BaseVideoController extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected View f36863a;

    /* renamed from: b  reason: collision with root package name */
    protected d f36864b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f36865c;

    /* renamed from: d  reason: collision with root package name */
    protected CenterView f36866d;

    /* renamed from: e  reason: collision with root package name */
    protected AudioManager f36867e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f36868f;

    /* renamed from: g  reason: collision with root package name */
    protected int f36869g;

    /* renamed from: h  reason: collision with root package name */
    private StringBuilder f36870h;

    /* renamed from: i  reason: collision with root package name */
    private Formatter f36871i;

    /* renamed from: j  reason: collision with root package name */
    private GestureDetector f36872j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f36873k;

    /* renamed from: l  reason: collision with root package name */
    private float f36874l;

    /* renamed from: m  reason: collision with root package name */
    private float f36875m;

    /* renamed from: n  reason: collision with root package name */
    protected b1.a f36876n;

    /* renamed from: o  reason: collision with root package name */
    protected int f36877o;

    /* renamed from: p  reason: collision with root package name */
    protected Runnable f36878p;

    /* renamed from: q  reason: collision with root package name */
    protected final Runnable f36879q;

    /* renamed from: r  reason: collision with root package name */
    protected int f36880r;

    /* renamed from: s  reason: collision with root package name */
    protected float f36881s;

    /* renamed from: t  reason: collision with root package name */
    protected int f36882t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f36883u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return BaseVideoController.this.f36872j.onTouchEvent(motionEvent);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int f4 = BaseVideoController.this.f();
            if (BaseVideoController.this.f36864b.isPlaying()) {
                BaseVideoController baseVideoController = BaseVideoController.this;
                baseVideoController.postDelayed(baseVideoController.f36878p, 1000 - (f4 % 1000));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseVideoController.this.d();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface d {
        void a();

        boolean b();

        void c();

        void d();

        d e(int i4);

        void f();

        void g();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        String getTitle();

        void h();

        void i();

        boolean isMute();

        boolean isPlaying();

        void pause();

        void seekTo(int i4);

        void setLock(boolean z3);

        void start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f36887a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f36888b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f36889c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f36890d;

        private e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            BaseVideoController baseVideoController = BaseVideoController.this;
            if (baseVideoController.f36868f) {
                return true;
            }
            baseVideoController.b();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            BaseVideoController baseVideoController = BaseVideoController.this;
            if (baseVideoController.f36873k) {
                baseVideoController.f36880r = baseVideoController.f36867e.getStreamVolume(3);
                BaseVideoController baseVideoController2 = BaseVideoController.this;
                baseVideoController2.f36881s = f.l(baseVideoController2.getContext()).getWindow().getAttributes().screenBrightness;
                this.f36887a = true;
                this.f36888b = false;
                this.f36889c = false;
                this.f36890d = false;
                return true;
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
            if (BaseVideoController.this.f36873k) {
                float x3 = motionEvent.getX() - motionEvent2.getX();
                float y3 = motionEvent.getY() - motionEvent2.getY();
                if (this.f36887a) {
                    boolean z3 = Math.abs(f4) >= Math.abs(f5);
                    this.f36888b = z3;
                    if (!z3) {
                        if (motionEvent2.getX() > c1.a.b / 2) {
                            this.f36889c = true;
                        } else {
                            this.f36890d = true;
                        }
                    }
                    this.f36887a = false;
                }
                if (this.f36888b) {
                    BaseVideoController.this.i(x3);
                } else if (this.f36889c) {
                    BaseVideoController.this.h(y3);
                } else if (this.f36890d) {
                    BaseVideoController.this.j(y3);
                }
                return true;
            }
            return super.onScroll(motionEvent, motionEvent2, f4, f5);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            BaseVideoController baseVideoController = BaseVideoController.this;
            if (baseVideoController.f36865c) {
                baseVideoController.d();
                return true;
            }
            baseVideoController.g();
            return true;
        }

        /* synthetic */ e(BaseVideoController baseVideoController, a aVar) {
            this();
        }
    }

    public BaseVideoController(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.f36877o == 6) {
            return;
        }
        if (this.f36864b.isPlaying()) {
            this.f36864b.pause();
        } else {
            this.f36864b.start();
        }
    }

    public void c() {
        if (this.f36864b.b()) {
            f.l(getContext()).setRequestedOrientation(1);
            this.f36864b.f();
            return;
        }
        f.l(getContext()).setRequestedOrientation(0);
        this.f36864b.i();
    }

    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f36874l = motionEvent.getX();
            this.f36875m = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.f36874l);
            float abs2 = Math.abs(motionEvent.getY() - this.f36875m);
            if (abs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || abs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f36863a = LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        CenterView centerView = new CenterView(getContext());
        this.f36866d = centerView;
        centerView.setVisibility(8);
        addView(this.f36866d);
        this.f36867e = (AudioManager) getContext().getSystemService("audio");
        this.f36870h = new StringBuilder();
        this.f36871i = new Formatter(this.f36870h, Locale.getDefault());
        setClickable(true);
        setFocusable(true);
        this.f36872j = new GestureDetector(getContext(), new e(this, null));
        setOnTouchListener(new a());
    }

    protected int f() {
        return 0;
    }

    public void g() {
    }

    protected abstract int getLayoutId();

    protected void h(float f4) {
        this.f36866d.setVisibility(0);
        d();
        this.f36866d.setProVisibility(0);
        Window window = f.l(getContext()).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        this.f36866d.setIcon(R.drawable.ic_action_brightness);
        int measuredHeight = getMeasuredHeight();
        if (this.f36881s == -1.0f) {
            this.f36881s = 0.5f;
        }
        float f5 = (((f4 * 2.0f) / measuredHeight) * 1.0f) + this.f36881s;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        float f6 = f5 <= 1.0f ? f5 : 1.0f;
        int i4 = (int) (100.0f * f6);
        CenterView centerView = this.f36866d;
        centerView.setTextView(i4 + "%");
        this.f36866d.setProPercent(i4);
        attributes.screenBrightness = f6;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(float f4) {
        this.f36866d.setVisibility(0);
        d();
        this.f36866d.setProVisibility(8);
        int measuredWidth = getMeasuredWidth();
        int duration = this.f36864b.getDuration();
        int currentPosition = this.f36864b.getCurrentPosition();
        int i4 = (int) ((((-f4) / measuredWidth) * duration) + currentPosition);
        if (i4 > currentPosition) {
            this.f36866d.setIcon(R.drawable.ic_action_fast_forward);
        } else {
            this.f36866d.setIcon(R.drawable.ic_action_fast_rewind);
        }
        if (i4 > duration) {
            i4 = duration;
        }
        int i5 = i4 >= 0 ? i4 : 0;
        this.f36882t = i5;
        CenterView centerView = this.f36866d;
        centerView.setTextView(k(i5) + TTPathConst.sSeparator + k(duration));
        this.f36883u = true;
    }

    protected void j(float f4) {
        this.f36866d.setVisibility(0);
        d();
        this.f36866d.setProVisibility(0);
        float streamMaxVolume = this.f36867e.getStreamMaxVolume(3);
        float measuredHeight = this.f36880r + (((f4 * 2.0f) / getMeasuredHeight()) * streamMaxVolume);
        if (measuredHeight > streamMaxVolume) {
            measuredHeight = streamMaxVolume;
        }
        if (measuredHeight < 0.0f) {
            this.f36866d.setIcon(R.drawable.ic_action_volume_off);
            measuredHeight = 0.0f;
        } else {
            this.f36866d.setIcon(R.drawable.ic_action_volume_up);
        }
        int i4 = (int) ((measuredHeight / streamMaxVolume) * 100.0f);
        this.f36866d.setTextView(i4 + "%");
        this.f36866d.setProPercent(i4);
        this.f36867e.setStreamVolume(3, (int) measuredHeight, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k(int i4) {
        int i5 = i4 / 1000;
        int i6 = i5 % 60;
        int i7 = (i5 / 60) % 60;
        int i8 = i5 / 3600;
        this.f36870h.setLength(0);
        return i8 > 0 ? this.f36871i.format("%d:%02d:%02d", Integer.valueOf(i8), Integer.valueOf(i7), Integer.valueOf(i6)).toString() : this.f36871i.format("%02d:%02d", Integer.valueOf(i7), Integer.valueOf(i6)).toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(this.f36878p);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3 = motionEvent.getAction() == 1;
        if (!this.f36872j.onTouchEvent(motionEvent) && z3) {
            if (this.f36866d.getVisibility() == 0) {
                this.f36866d.setVisibility(8);
            }
            if (this.f36883u) {
                this.f36864b.seekTo(this.f36882t);
                this.f36883u = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        if (i4 == 0) {
            post(this.f36878p);
        }
    }

    public void setControllerListener(b1.a aVar) {
        this.f36876n = aVar;
    }

    public void setMediaPlayer(d dVar) {
        this.f36864b = dVar;
    }

    public void setPlayState(int i4) {
        this.f36877o = i4;
    }

    public void setPlayerState(int i4) {
    }

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4);
        this.f36869g = 3000;
        this.f36878p = new b();
        this.f36879q = new c();
        e();
    }
}
