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
import com.jmolsmobile.landscapevideocapture.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class VideoCaptureView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f37968a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f37969b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f37970c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f37971d;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceView f37972e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f37973f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f37974g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f37975h;

    /* renamed from: i  reason: collision with root package name */
    private long f37976i;

    /* renamed from: j  reason: collision with root package name */
    private com.jmolsmobile.landscapevideocapture.view.a f37977j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f37978k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f37979l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f37980m;

    /* renamed from: n  reason: collision with root package name */
    private Runnable f37981n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int uptimeMillis = (int) ((SystemClock.uptimeMillis() - VideoCaptureView.this.f37976i) / 1000);
            VideoCaptureView videoCaptureView = VideoCaptureView.this;
            videoCaptureView.g(uptimeMillis % 60, uptimeMillis / 60);
            VideoCaptureView.this.f37975h.postDelayed(this, 1000L);
        }
    }

    public VideoCaptureView(Context context) {
        super(context);
        this.f37975h = new Handler();
        this.f37976i = 0L;
        this.f37981n = new a();
        e(context);
    }

    private boolean d() {
        return com.jmolsmobile.landscapevideocapture.preview.a.b() && this.f37980m;
    }

    private void e(Context context) {
        View inflate = View.inflate(context, R.layout.view_videocapture, this);
        this.f37970c = (ImageView) inflate.findViewById(R.id.videocapture_recordbtn_iv);
        this.f37969b = (ImageView) inflate.findViewById(R.id.videocapture_acceptbtn_iv);
        this.f37968a = (ImageView) inflate.findViewById(R.id.videocapture_declinebtn_iv);
        this.f37971d = (ImageView) inflate.findViewById(R.id.change_camera_iv);
        this.f37970c.setOnClickListener(this);
        this.f37969b.setOnClickListener(this);
        this.f37968a.setOnClickListener(this);
        this.f37971d.setOnClickListener(this);
        this.f37973f = (ImageView) inflate.findViewById(R.id.videocapture_preview_iv);
        this.f37972e = (SurfaceView) inflate.findViewById(R.id.videocapture_preview_sv);
        this.f37974g = (TextView) inflate.findViewById(R.id.videocapture_timer_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i4, int i5) {
        TextView textView = this.f37974g;
        textView.setText(String.format("%02d", Integer.valueOf(i5)) + ":" + String.format("%02d", Integer.valueOf(i4)));
    }

    public void f(boolean z3) {
        this.f37978k = z3;
    }

    public SurfaceHolder getPreviewSurfaceHolder() {
        return this.f37972e.getHolder();
    }

    public void h() {
        this.f37970c.setSelected(false);
        this.f37971d.setVisibility(d() ? 0 : 4);
        this.f37970c.setVisibility(0);
        this.f37969b.setVisibility(8);
        this.f37968a.setVisibility(8);
        this.f37973f.setVisibility(8);
        this.f37972e.setVisibility(0);
    }

    public void i(Bitmap bitmap) {
        this.f37970c.setVisibility(4);
        this.f37969b.setVisibility(0);
        this.f37971d.setVisibility(4);
        this.f37968a.setVisibility(0);
        this.f37973f.setVisibility(0);
        this.f37972e.setVisibility(8);
        if (bitmap != null) {
            this.f37973f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f37973f.setImageBitmap(bitmap);
        }
        this.f37975h.removeCallbacks(this.f37981n);
    }

    public void j() {
        this.f37970c.setSelected(true);
        this.f37970c.setVisibility(0);
        this.f37971d.setVisibility(4);
        this.f37969b.setVisibility(8);
        this.f37968a.setVisibility(8);
        this.f37973f.setVisibility(8);
        this.f37972e.setVisibility(0);
        if (this.f37978k) {
            this.f37974g.setVisibility(0);
            this.f37976i = SystemClock.uptimeMillis();
            g(0, 0);
            this.f37975h.postDelayed(this.f37981n, 1000L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f37977j == null) {
            return;
        }
        if (view.getId() == this.f37970c.getId()) {
            this.f37977j.a();
        } else if (view.getId() == this.f37969b.getId()) {
            this.f37977j.e();
        } else if (view.getId() == this.f37968a.getId()) {
            this.f37977j.b();
        } else if (view.getId() == this.f37971d.getId()) {
            boolean z3 = !this.f37979l;
            this.f37979l = z3;
            this.f37971d.setImageResource(z3 ? R.drawable.ic_change_camera_front : R.drawable.ic_change_camera_back);
            this.f37977j.h(this.f37979l);
        }
    }

    public void setCameraFacing(boolean z3) {
        if (this.f37980m) {
            this.f37979l = z3;
            this.f37971d.setImageResource(z3 ? R.drawable.ic_change_camera_back : R.drawable.ic_change_camera_front);
        }
    }

    public void setCameraSwitchingEnabled(boolean z3) {
        this.f37980m = z3;
        this.f37971d.setVisibility(z3 ? 0 : 4);
    }

    public void setRecordingButtonInterface(com.jmolsmobile.landscapevideocapture.view.a aVar) {
        this.f37977j = aVar;
    }

    public VideoCaptureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37975h = new Handler();
        this.f37976i = 0L;
        this.f37981n = new a();
        e(context);
    }

    public VideoCaptureView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f37975h = new Handler();
        this.f37976i = 0L;
        this.f37981n = new a();
        e(context);
    }
}
