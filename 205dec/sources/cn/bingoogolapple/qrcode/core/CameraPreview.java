package cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.util.Collections;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Camera f1532a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1533b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1534c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1535d;

    /* renamed from: e  reason: collision with root package name */
    private float f1536e;

    /* renamed from: f  reason: collision with root package name */
    private c f1537f;

    /* renamed from: g  reason: collision with root package name */
    private b f1538g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Camera.AutoFocusCallback {
        a() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z3, Camera camera) {
            if (z3) {
                cn.bingoogolapple.qrcode.core.a.e("\u5bf9\u7126\u6d4b\u5149\u6210\u529f");
            } else {
                cn.bingoogolapple.qrcode.core.a.h("\u5bf9\u7126\u6d4b\u5149\u5931\u8d25");
            }
            CameraPreview.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface b {
        void a();
    }

    public CameraPreview(Context context) {
        super(context);
        this.f1533b = false;
        this.f1534c = false;
        this.f1535d = false;
        this.f1536e = 1.0f;
        getHolder().addCallback(this);
    }

    private boolean c() {
        return f() && getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    private void d(float f4, float f5, int i4, int i5) {
        boolean z3;
        try {
            Camera.Parameters parameters = this.f1532a.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            boolean z4 = true;
            if (parameters.getMaxNumFocusAreas() > 0) {
                cn.bingoogolapple.qrcode.core.a.e("\u652f\u6301\u8bbe\u7f6e\u5bf9\u7126\u533a\u57df");
                Rect c4 = cn.bingoogolapple.qrcode.core.a.c(1.0f, f4, f5, i4, i5, previewSize.width, previewSize.height);
                cn.bingoogolapple.qrcode.core.a.o("\u5bf9\u7126\u533a\u57df", c4);
                parameters.setFocusAreas(Collections.singletonList(new Camera.Area(c4, 1000)));
                parameters.setFocusMode("macro");
                z3 = true;
            } else {
                cn.bingoogolapple.qrcode.core.a.e("\u4e0d\u652f\u6301\u8bbe\u7f6e\u5bf9\u7126\u533a\u57df");
                z3 = false;
            }
            if (parameters.getMaxNumMeteringAreas() > 0) {
                cn.bingoogolapple.qrcode.core.a.e("\u652f\u6301\u8bbe\u7f6e\u6d4b\u5149\u533a\u57df");
                Rect c5 = cn.bingoogolapple.qrcode.core.a.c(1.5f, f4, f5, i4, i5, previewSize.width, previewSize.height);
                cn.bingoogolapple.qrcode.core.a.o("\u6d4b\u5149\u533a\u57df", c5);
                parameters.setMeteringAreas(Collections.singletonList(new Camera.Area(c5, 1000)));
            } else {
                cn.bingoogolapple.qrcode.core.a.e("\u4e0d\u652f\u6301\u8bbe\u7f6e\u6d4b\u5149\u533a\u57df");
                z4 = z3;
            }
            if (z4) {
                this.f1532a.cancelAutoFocus();
                this.f1532a.setParameters(parameters);
                this.f1532a.autoFocus(new a());
                return;
            }
            this.f1535d = false;
        } catch (Exception e4) {
            e4.printStackTrace();
            cn.bingoogolapple.qrcode.core.a.h("\u5bf9\u7126\u6d4b\u5149\u5931\u8d25\uff1a" + e4.getMessage());
            k();
        }
    }

    private static void e(boolean z3, Camera camera) {
        try {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                int zoom = parameters.getZoom();
                if (z3 && zoom < parameters.getMaxZoom()) {
                    cn.bingoogolapple.qrcode.core.a.e("\u653e\u5927");
                    zoom++;
                } else if (!z3 && zoom > 0) {
                    cn.bingoogolapple.qrcode.core.a.e("\u7f29\u5c0f");
                    zoom--;
                } else {
                    cn.bingoogolapple.qrcode.core.a.e("\u65e2\u4e0d\u653e\u5927\u4e5f\u4e0d\u7f29\u5c0f");
                }
                parameters.setZoom(zoom);
                camera.setParameters(parameters);
                return;
            }
            cn.bingoogolapple.qrcode.core.a.e("\u4e0d\u652f\u6301\u7f29\u653e");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void j() {
        if (this.f1532a != null) {
            try {
                this.f1533b = true;
                SurfaceHolder holder = getHolder();
                holder.setKeepScreenOn(true);
                this.f1532a.setPreviewDisplay(holder);
                this.f1537f.l(this.f1532a);
                this.f1532a.startPreview();
                b bVar = this.f1538g;
                if (bVar != null) {
                    bVar.a();
                }
                k();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f1535d = false;
        Camera camera = this.f1532a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode("continuous-picture");
            this.f1532a.setParameters(parameters);
            this.f1532a.cancelAutoFocus();
        } catch (Exception unused) {
            cn.bingoogolapple.qrcode.core.a.h("\u8fde\u7eed\u5bf9\u7126\u5931\u8d25");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (c()) {
            this.f1537f.b(this.f1532a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f1532a != null && this.f1533b && this.f1534c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Rect rect) {
        if (this.f1532a == null || rect == null || rect.left <= 0 || rect.top <= 0) {
            return;
        }
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int width = rect.width() / 2;
        int height = rect.height() / 2;
        cn.bingoogolapple.qrcode.core.a.o("\u8f6c\u6362\u524d", rect);
        if (cn.bingoogolapple.qrcode.core.a.m(getContext())) {
            centerY = centerX;
            centerX = centerY;
            height = width;
            width = height;
        }
        Rect rect2 = new Rect(centerX - width, centerY - height, centerX + width, centerY + height);
        cn.bingoogolapple.qrcode.core.a.o("\u8f6c\u6362\u540e", rect2);
        cn.bingoogolapple.qrcode.core.a.e("\u626b\u7801\u6846\u53d1\u751f\u53d8\u5316\u89e6\u53d1\u5bf9\u7126\u6d4b\u5149");
        d(rect2.centerX(), rect2.centerY(), rect2.width(), rect2.height());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (c()) {
            this.f1537f.j(this.f1532a);
        }
    }

    public void i() {
        if (getHolder() == null || getHolder().getSurface() == null) {
            return;
        }
        l();
        j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        Camera camera = this.f1532a;
        if (camera != null) {
            try {
                this.f1533b = false;
                camera.cancelAutoFocus();
                this.f1532a.setOneShotPreviewCallback(null);
                this.f1532a.stopPreview();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i4, int i5) {
        int defaultSize = SurfaceView.getDefaultSize(getSuggestedMinimumWidth(), i4);
        int defaultSize2 = SurfaceView.getDefaultSize(getSuggestedMinimumHeight(), i5);
        c cVar = this.f1537f;
        if (cVar != null && cVar.f() != null) {
            Point f4 = this.f1537f.f();
            float f5 = defaultSize;
            float f6 = defaultSize2;
            float f7 = f4.x;
            float f8 = f4.y;
            float f9 = (f7 * 1.0f) / f8;
            if ((f5 * 1.0f) / f6 < f9) {
                defaultSize = (int) ((f6 / ((f8 * 1.0f) / f7)) + 0.5f);
            } else {
                defaultSize2 = (int) ((f5 / f9) + 0.5f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!f()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 1 && (motionEvent.getAction() & 255) == 1) {
            if (this.f1535d) {
                return true;
            }
            this.f1535d = true;
            cn.bingoogolapple.qrcode.core.a.e("\u624b\u6307\u89e6\u6478\u89e6\u53d1\u5bf9\u7126\u6d4b\u5149");
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (cn.bingoogolapple.qrcode.core.a.m(getContext())) {
                y3 = x3;
                x3 = y3;
            }
            int g4 = cn.bingoogolapple.qrcode.core.a.g(getContext(), 120.0f);
            d(x3, y3, g4, g4);
        }
        if (motionEvent.getPointerCount() == 2) {
            int action = motionEvent.getAction() & 255;
            if (action == 2) {
                float b4 = cn.bingoogolapple.qrcode.core.a.b(motionEvent);
                float f4 = this.f1536e;
                if (b4 > f4) {
                    e(true, this.f1532a);
                } else if (b4 < f4) {
                    e(false, this.f1532a);
                }
            } else if (action == 5) {
                this.f1536e = cn.bingoogolapple.qrcode.core.a.b(motionEvent);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCamera(Camera camera) {
        this.f1532a = camera;
        if (camera != null) {
            c cVar = new c(getContext());
            this.f1537f = cVar;
            cVar.i(this.f1532a);
            if (this.f1533b) {
                requestLayout();
            } else {
                j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDelegate(b bVar) {
        this.f1538g = bVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        l();
        j();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f1534c = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f1534c = false;
        l();
    }
}
