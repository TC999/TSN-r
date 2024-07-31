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
import com.devlin_n.videoplayer.C6596R;
import com.devlin_n.videoplayer.widget.CenterView;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Formatter;
import java.util.Locale;
import p597h0.ControllerListener;
import p601i0.C13583a;
import p601i0.C13584f;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class BaseVideoController extends FrameLayout {

    /* renamed from: a */
    protected View f23197a;

    /* renamed from: b */
    protected InterfaceC6607d f23198b;

    /* renamed from: c */
    protected boolean f23199c;

    /* renamed from: d */
    protected CenterView f23200d;

    /* renamed from: e */
    protected AudioManager f23201e;

    /* renamed from: f */
    protected boolean f23202f;

    /* renamed from: g */
    protected int f23203g;

    /* renamed from: h */
    private StringBuilder f23204h;

    /* renamed from: i */
    private Formatter f23205i;

    /* renamed from: j */
    private GestureDetector f23206j;

    /* renamed from: k */
    protected boolean f23207k;

    /* renamed from: l */
    private float f23208l;

    /* renamed from: m */
    private float f23209m;

    /* renamed from: n */
    protected ControllerListener f23210n;

    /* renamed from: o */
    protected int f23211o;

    /* renamed from: p */
    protected Runnable f23212p;

    /* renamed from: q */
    protected final Runnable f23213q;

    /* renamed from: r */
    protected int f23214r;

    /* renamed from: s */
    protected float f23215s;

    /* renamed from: t */
    protected int f23216t;

    /* renamed from: u */
    protected boolean f23217u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.devlin_n.videoplayer.controller.BaseVideoController$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnTouchListenerC6604a implements View.OnTouchListener {
        View$OnTouchListenerC6604a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return BaseVideoController.this.f23206j.onTouchEvent(motionEvent);
        }
    }

    /* renamed from: com.devlin_n.videoplayer.controller.BaseVideoController$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6605b implements Runnable {
        RunnableC6605b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int mo35759f = BaseVideoController.this.mo35759f();
            if (BaseVideoController.this.f23198b.isPlaying()) {
                BaseVideoController baseVideoController = BaseVideoController.this;
                baseVideoController.postDelayed(baseVideoController.f23212p, 1000 - (mo35759f % 1000));
            }
        }
    }

    /* renamed from: com.devlin_n.videoplayer.controller.BaseVideoController$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC6606c implements Runnable {
        RunnableC6606c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseVideoController.this.mo35761d();
        }
    }

    /* renamed from: com.devlin_n.videoplayer.controller.BaseVideoController$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC6607d {
        /* renamed from: a */
        void mo35722a();

        /* renamed from: b */
        boolean mo35720b();

        /* renamed from: c */
        void mo35718c();

        /* renamed from: d */
        void mo35716d();

        /* renamed from: e */
        InterfaceC6607d mo35714e(int i);

        /* renamed from: f */
        void mo35712f();

        /* renamed from: g */
        boolean mo35710g();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        String getTitle();

        /* renamed from: h */
        void mo35708h();

        /* renamed from: i */
        void mo35706i();

        boolean isPlaying();

        /* renamed from: j */
        void mo35704j();

        void pause();

        void seekTo(int i);

        void setLock(boolean z);

        void start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.devlin_n.videoplayer.controller.BaseVideoController$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6608e extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a */
        private boolean f23221a;

        /* renamed from: b */
        private boolean f23222b;

        /* renamed from: c */
        private boolean f23223c;

        /* renamed from: d */
        private boolean f23224d;

        private C6608e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            BaseVideoController baseVideoController = BaseVideoController.this;
            if (baseVideoController.f23202f) {
                return true;
            }
            baseVideoController.m35779b();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            BaseVideoController baseVideoController = BaseVideoController.this;
            if (baseVideoController.f23207k) {
                baseVideoController.f23214r = baseVideoController.f23201e.getStreamVolume(3);
                BaseVideoController baseVideoController2 = BaseVideoController.this;
                baseVideoController2.f23215s = C13584f.m12699l(baseVideoController2.getContext()).getWindow().getAttributes().screenBrightness;
                this.f23221a = true;
                this.f23222b = false;
                this.f23223c = false;
                this.f23224d = false;
                return true;
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (BaseVideoController.this.f23207k) {
                float x = motionEvent.getX() - motionEvent2.getX();
                float y = motionEvent.getY() - motionEvent2.getY();
                if (this.f23221a) {
                    boolean z = Math.abs(f) >= Math.abs(f2);
                    this.f23222b = z;
                    if (!z) {
                        if (motionEvent2.getX() > C13583a.f40163b / 2) {
                            this.f23223c = true;
                        } else {
                            this.f23224d = true;
                        }
                    }
                    this.f23221a = false;
                }
                if (this.f23222b) {
                    BaseVideoController.this.mo35757i(x);
                } else if (this.f23223c) {
                    BaseVideoController.this.m35777h(y);
                } else if (this.f23224d) {
                    BaseVideoController.this.m35776j(y);
                }
                return true;
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            BaseVideoController baseVideoController = BaseVideoController.this;
            if (baseVideoController.f23199c) {
                baseVideoController.mo35761d();
                return true;
            }
            baseVideoController.mo35758g();
            return true;
        }

        /* synthetic */ C6608e(BaseVideoController baseVideoController, View$OnTouchListenerC6604a view$OnTouchListenerC6604a) {
            this();
        }
    }

    public BaseVideoController(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m35779b() {
        if (this.f23211o == 6) {
            return;
        }
        if (this.f23198b.isPlaying()) {
            this.f23198b.pause();
        } else {
            this.f23198b.start();
        }
    }

    /* renamed from: c */
    public void m35778c() {
        if (this.f23198b.mo35720b()) {
            C13584f.m12699l(getContext()).setRequestedOrientation(1);
            this.f23198b.mo35712f();
            return;
        }
        C13584f.m12699l(getContext()).setRequestedOrientation(0);
        this.f23198b.mo35704j();
    }

    /* renamed from: d */
    public void mo35761d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f23208l = motionEvent.getX();
            this.f23209m = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.f23208l);
            float abs2 = Math.abs(motionEvent.getY() - this.f23209m);
            if (abs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || abs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public void mo35760e() {
        this.f23197a = LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        CenterView centerView = new CenterView(getContext());
        this.f23200d = centerView;
        centerView.setVisibility(8);
        addView(this.f23200d);
        this.f23201e = (AudioManager) getContext().getSystemService("audio");
        this.f23204h = new StringBuilder();
        this.f23205i = new Formatter(this.f23204h, Locale.getDefault());
        setClickable(true);
        setFocusable(true);
        this.f23206j = new GestureDetector(getContext(), new C6608e(this, null));
        setOnTouchListener(new View$OnTouchListenerC6604a());
    }

    /* renamed from: f */
    protected int mo35759f() {
        return 0;
    }

    /* renamed from: g */
    public void mo35758g() {
    }

    protected abstract int getLayoutId();

    /* renamed from: h */
    protected void m35777h(float f) {
        this.f23200d.setVisibility(0);
        mo35761d();
        this.f23200d.setProVisibility(0);
        Window window = C13584f.m12699l(getContext()).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        this.f23200d.setIcon(C6596R.C6598drawable.ic_action_brightness);
        int measuredHeight = getMeasuredHeight();
        if (this.f23215s == -1.0f) {
            this.f23215s = 0.5f;
        }
        float f2 = (((f * 2.0f) / measuredHeight) * 1.0f) + this.f23215s;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        int i = (int) (100.0f * f3);
        CenterView centerView = this.f23200d;
        centerView.setTextView(i + "%");
        this.f23200d.setProPercent(i);
        attributes.screenBrightness = f3;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public void mo35757i(float f) {
        this.f23200d.setVisibility(0);
        mo35761d();
        this.f23200d.setProVisibility(8);
        int measuredWidth = getMeasuredWidth();
        int duration = this.f23198b.getDuration();
        int currentPosition = this.f23198b.getCurrentPosition();
        int i = (int) ((((-f) / measuredWidth) * duration) + currentPosition);
        if (i > currentPosition) {
            this.f23200d.setIcon(C6596R.C6598drawable.ic_action_fast_forward);
        } else {
            this.f23200d.setIcon(C6596R.C6598drawable.ic_action_fast_rewind);
        }
        if (i > duration) {
            i = duration;
        }
        int i2 = i >= 0 ? i : 0;
        this.f23216t = i2;
        CenterView centerView = this.f23200d;
        centerView.setTextView(m35775k(i2) + "/" + m35775k(duration));
        this.f23217u = true;
    }

    /* renamed from: j */
    protected void m35776j(float f) {
        this.f23200d.setVisibility(0);
        mo35761d();
        this.f23200d.setProVisibility(0);
        float streamMaxVolume = this.f23201e.getStreamMaxVolume(3);
        float measuredHeight = this.f23214r + (((f * 2.0f) / getMeasuredHeight()) * streamMaxVolume);
        if (measuredHeight > streamMaxVolume) {
            measuredHeight = streamMaxVolume;
        }
        if (measuredHeight < 0.0f) {
            this.f23200d.setIcon(C6596R.C6598drawable.ic_action_volume_off);
            measuredHeight = 0.0f;
        } else {
            this.f23200d.setIcon(C6596R.C6598drawable.ic_action_volume_up);
        }
        int i = (int) ((measuredHeight / streamMaxVolume) * 100.0f);
        this.f23200d.setTextView(i + "%");
        this.f23200d.setProPercent(i);
        this.f23201e.setStreamVolume(3, (int) measuredHeight, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public String m35775k(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        this.f23204h.setLength(0);
        return i5 > 0 ? this.f23205i.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.f23205i.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(this.f23212p);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = motionEvent.getAction() == 1;
        if (!this.f23206j.onTouchEvent(motionEvent) && z) {
            if (this.f23200d.getVisibility() == 0) {
                this.f23200d.setVisibility(8);
            }
            if (this.f23217u) {
                this.f23198b.seekTo(this.f23216t);
                this.f23217u = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            post(this.f23212p);
        }
    }

    public void setControllerListener(ControllerListener controllerListener) {
        this.f23210n = controllerListener;
    }

    public void setMediaPlayer(InterfaceC6607d interfaceC6607d) {
        this.f23198b = interfaceC6607d;
    }

    public void setPlayState(int i) {
        this.f23211o = i;
    }

    public void setPlayerState(int i) {
    }

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.f23203g = 3000;
        this.f23212p = new RunnableC6605b();
        this.f23213q = new RunnableC6606c();
        mo35760e();
    }
}
