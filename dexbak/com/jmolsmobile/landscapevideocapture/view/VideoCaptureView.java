package com.jmolsmobile.landscapevideocapture.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.jmolsmobile.landscapevideocapture.C7131R;
import com.jmolsmobile.landscapevideocapture.preview.CapturePreview;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoCaptureView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private ImageView f24428a;

    /* renamed from: b */
    private ImageView f24429b;

    /* renamed from: c */
    private ImageView f24430c;

    /* renamed from: d */
    private ImageView f24431d;

    /* renamed from: e */
    private SurfaceView f24432e;

    /* renamed from: f */
    private ImageView f24433f;

    /* renamed from: g */
    private TextView f24434g;

    /* renamed from: h */
    private Handler f24435h;

    /* renamed from: i */
    private long f24436i;

    /* renamed from: j */
    private RecordingButtonInterface f24437j;

    /* renamed from: k */
    private boolean f24438k;

    /* renamed from: l */
    private boolean f24439l;

    /* renamed from: m */
    private boolean f24440m;

    /* renamed from: n */
    private Runnable f24441n;

    /* renamed from: com.jmolsmobile.landscapevideocapture.view.VideoCaptureView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class RunnableC7142a implements Runnable {
        RunnableC7142a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int uptimeMillis = (int) ((SystemClock.uptimeMillis() - VideoCaptureView.this.f24436i) / 1000);
            VideoCaptureView videoCaptureView = VideoCaptureView.this;
            videoCaptureView.m34456g(uptimeMillis % 60, uptimeMillis / 60);
            VideoCaptureView.this.f24435h.postDelayed(this, 1000L);
        }
    }

    public VideoCaptureView(Context context) {
        super(context);
        this.f24435h = new Handler();
        this.f24436i = 0L;
        this.f24441n = new RunnableC7142a();
        m34458e(context);
    }

    /* renamed from: d */
    private boolean m34459d() {
        return CapturePreview.m34483b() && this.f24440m;
    }

    /* renamed from: e */
    private void m34458e(Context context) {
        View inflate = View.inflate(context, C7131R.C7134layout.view_videocapture, this);
        this.f24430c = (ImageView) inflate.findViewById(C7131R.C7133id.videocapture_recordbtn_iv);
        this.f24429b = (ImageView) inflate.findViewById(C7131R.C7133id.videocapture_acceptbtn_iv);
        this.f24428a = (ImageView) inflate.findViewById(C7131R.C7133id.videocapture_declinebtn_iv);
        this.f24431d = (ImageView) inflate.findViewById(C7131R.C7133id.change_camera_iv);
        this.f24430c.setOnClickListener(this);
        this.f24429b.setOnClickListener(this);
        this.f24428a.setOnClickListener(this);
        this.f24431d.setOnClickListener(this);
        this.f24433f = (ImageView) inflate.findViewById(C7131R.C7133id.videocapture_preview_iv);
        this.f24432e = (SurfaceView) inflate.findViewById(C7131R.C7133id.videocapture_preview_sv);
        this.f24434g = (TextView) inflate.findViewById(C7131R.C7133id.videocapture_timer_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m34456g(int i, int i2) {
        TextView textView = this.f24434g;
        textView.setText(String.format("%02d", Integer.valueOf(i2)) + ":" + String.format("%02d", Integer.valueOf(i)));
    }

    /* renamed from: f */
    public void m34457f(boolean z) {
        this.f24438k = z;
    }

    public SurfaceHolder getPreviewSurfaceHolder() {
        return this.f24432e.getHolder();
    }

    /* renamed from: h */
    public void m34455h() {
        this.f24430c.setSelected(false);
        this.f24431d.setVisibility(m34459d() ? 0 : 4);
        this.f24430c.setVisibility(0);
        this.f24429b.setVisibility(8);
        this.f24428a.setVisibility(8);
        this.f24433f.setVisibility(8);
        this.f24432e.setVisibility(0);
    }

    /* renamed from: i */
    public void m34454i(Bitmap bitmap) {
        this.f24430c.setVisibility(4);
        this.f24429b.setVisibility(0);
        this.f24431d.setVisibility(4);
        this.f24428a.setVisibility(0);
        this.f24433f.setVisibility(0);
        this.f24432e.setVisibility(8);
        if (bitmap != null) {
            this.f24433f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f24433f.setImageBitmap(bitmap);
        }
        this.f24435h.removeCallbacks(this.f24441n);
    }

    /* renamed from: j */
    public void m34453j() {
        this.f24430c.setSelected(true);
        this.f24430c.setVisibility(0);
        this.f24431d.setVisibility(4);
        this.f24429b.setVisibility(8);
        this.f24428a.setVisibility(8);
        this.f24433f.setVisibility(8);
        this.f24432e.setVisibility(0);
        if (this.f24438k) {
            this.f24434g.setVisibility(0);
            this.f24436i = SystemClock.uptimeMillis();
            m34456g(0, 0);
            this.f24435h.postDelayed(this.f24441n, 1000L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f24437j == null) {
            return;
        }
        if (view.getId() == this.f24430c.getId()) {
            this.f24437j.mo34452a();
        } else if (view.getId() == this.f24429b.getId()) {
            this.f24437j.mo34450e();
        } else if (view.getId() == this.f24428a.getId()) {
            this.f24437j.mo34451b();
        } else if (view.getId() == this.f24431d.getId()) {
            boolean z = !this.f24439l;
            this.f24439l = z;
            this.f24431d.setImageResource(z ? C7131R.C7132drawable.ic_change_camera_front : C7131R.C7132drawable.ic_change_camera_back);
            this.f24437j.mo34449h(this.f24439l);
        }
    }

    public void setCameraFacing(boolean z) {
        if (this.f24440m) {
            this.f24439l = z;
            this.f24431d.setImageResource(z ? C7131R.C7132drawable.ic_change_camera_back : C7131R.C7132drawable.ic_change_camera_front);
        }
    }

    public void setCameraSwitchingEnabled(boolean z) {
        this.f24440m = z;
        this.f24431d.setVisibility(z ? 0 : 4);
    }

    public void setRecordingButtonInterface(RecordingButtonInterface recordingButtonInterface) {
        this.f24437j = recordingButtonInterface;
    }

    public VideoCaptureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24435h = new Handler();
        this.f24436i = 0L;
        this.f24441n = new RunnableC7142a();
        m34458e(context);
    }

    public VideoCaptureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24435h = new Handler();
        this.f24436i = 0L;
        this.f24441n = new RunnableC7142a();
        m34458e(context);
    }
}
