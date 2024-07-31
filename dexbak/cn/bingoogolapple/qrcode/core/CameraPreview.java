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

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a */
    private Camera f1518a;

    /* renamed from: b */
    private boolean f1519b;

    /* renamed from: c */
    private boolean f1520c;

    /* renamed from: d */
    private boolean f1521d;

    /* renamed from: e */
    private float f1522e;

    /* renamed from: f */
    private CameraConfigurationManager f1523f;

    /* renamed from: g */
    private InterfaceC1093b f1524g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bingoogolapple.qrcode.core.CameraPreview$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1092a implements Camera.AutoFocusCallback {
        C1092a() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            if (z) {
                BGAQRCodeUtil.m57972e("对焦测光成功");
            } else {
                BGAQRCodeUtil.m57969h("对焦测光失败");
            }
            CameraPreview.this.m58032k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bingoogolapple.qrcode.core.CameraPreview$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1093b {
        /* renamed from: a */
        void mo57998a();
    }

    public CameraPreview(Context context) {
        super(context);
        this.f1519b = false;
        this.f1520c = false;
        this.f1521d = false;
        this.f1522e = 1.0f;
        getHolder().addCallback(this);
    }

    /* renamed from: c */
    private boolean m58040c() {
        return m58037f() && getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    /* renamed from: d */
    private void m58039d(float f, float f2, int i, int i2) {
        boolean z;
        try {
            Camera.Parameters parameters = this.f1518a.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            boolean z2 = true;
            if (parameters.getMaxNumFocusAreas() > 0) {
                BGAQRCodeUtil.m57972e("支持设置对焦区域");
                Rect m57974c = BGAQRCodeUtil.m57974c(1.0f, f, f2, i, i2, previewSize.width, previewSize.height);
                BGAQRCodeUtil.m57962o("对焦区域", m57974c);
                parameters.setFocusAreas(Collections.singletonList(new Camera.Area(m57974c, 1000)));
                parameters.setFocusMode("macro");
                z = true;
            } else {
                BGAQRCodeUtil.m57972e("不支持设置对焦区域");
                z = false;
            }
            if (parameters.getMaxNumMeteringAreas() > 0) {
                BGAQRCodeUtil.m57972e("支持设置测光区域");
                Rect m57974c2 = BGAQRCodeUtil.m57974c(1.5f, f, f2, i, i2, previewSize.width, previewSize.height);
                BGAQRCodeUtil.m57962o("测光区域", m57974c2);
                parameters.setMeteringAreas(Collections.singletonList(new Camera.Area(m57974c2, 1000)));
            } else {
                BGAQRCodeUtil.m57972e("不支持设置测光区域");
                z2 = z;
            }
            if (z2) {
                this.f1518a.cancelAutoFocus();
                this.f1518a.setParameters(parameters);
                this.f1518a.autoFocus(new C1092a());
                return;
            }
            this.f1521d = false;
        } catch (Exception e) {
            e.printStackTrace();
            BGAQRCodeUtil.m57969h("对焦测光失败：" + e.getMessage());
            m58032k();
        }
    }

    /* renamed from: e */
    private static void m58038e(boolean z, Camera camera) {
        try {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                int zoom = parameters.getZoom();
                if (z && zoom < parameters.getMaxZoom()) {
                    BGAQRCodeUtil.m57972e("放大");
                    zoom++;
                } else if (!z && zoom > 0) {
                    BGAQRCodeUtil.m57972e("缩小");
                    zoom--;
                } else {
                    BGAQRCodeUtil.m57972e("既不放大也不缩小");
                }
                parameters.setZoom(zoom);
                camera.setParameters(parameters);
                return;
            }
            BGAQRCodeUtil.m57972e("不支持缩放");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    private void m58033j() {
        if (this.f1518a != null) {
            try {
                this.f1519b = true;
                SurfaceHolder holder = getHolder();
                holder.setKeepScreenOn(true);
                this.f1518a.setPreviewDisplay(holder);
                this.f1523f.m57948l(this.f1518a);
                this.f1518a.startPreview();
                InterfaceC1093b interfaceC1093b = this.f1524g;
                if (interfaceC1093b != null) {
                    interfaceC1093b.mo57998a();
                }
                m58032k();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m58032k() {
        this.f1521d = false;
        Camera camera = this.f1518a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode("continuous-picture");
            this.f1518a.setParameters(parameters);
            this.f1518a.cancelAutoFocus();
        } catch (Exception unused) {
            BGAQRCodeUtil.m57969h("连续对焦失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m58041b() {
        if (m58040c()) {
            this.f1523f.m57958b(this.f1518a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean m58037f() {
        return this.f1518a != null && this.f1519b && this.f1520c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m58036g(Rect rect) {
        if (this.f1518a == null || rect == null || rect.left <= 0 || rect.top <= 0) {
            return;
        }
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int width = rect.width() / 2;
        int height = rect.height() / 2;
        BGAQRCodeUtil.m57962o("转换前", rect);
        if (BGAQRCodeUtil.m57964m(getContext())) {
            centerY = centerX;
            centerX = centerY;
            height = width;
            width = height;
        }
        Rect rect2 = new Rect(centerX - width, centerY - height, centerX + width, centerY + height);
        BGAQRCodeUtil.m57962o("转换后", rect2);
        BGAQRCodeUtil.m57972e("扫码框发生变化触发对焦测光");
        m58039d(rect2.centerX(), rect2.centerY(), rect2.width(), rect2.height());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public void m58035h() {
        if (m58040c()) {
            this.f1523f.m57950j(this.f1518a);
        }
    }

    /* renamed from: i */
    public void m58034i() {
        if (getHolder() == null || getHolder().getSurface() == null) {
            return;
        }
        m58031l();
        m58033j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void m58031l() {
        Camera camera = this.f1518a;
        if (camera != null) {
            try {
                this.f1519b = false;
                camera.cancelAutoFocus();
                this.f1518a.setOneShotPreviewCallback(null);
                this.f1518a.stopPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = SurfaceView.getDefaultSize(getSuggestedMinimumWidth(), i);
        int defaultSize2 = SurfaceView.getDefaultSize(getSuggestedMinimumHeight(), i2);
        CameraConfigurationManager cameraConfigurationManager = this.f1523f;
        if (cameraConfigurationManager != null && cameraConfigurationManager.m57954f() != null) {
            Point m57954f = this.f1523f.m57954f();
            float f = defaultSize;
            float f2 = defaultSize2;
            float f3 = m57954f.x;
            float f4 = m57954f.y;
            float f5 = (f3 * 1.0f) / f4;
            if ((f * 1.0f) / f2 < f5) {
                defaultSize = (int) ((f2 / ((f4 * 1.0f) / f3)) + 0.5f);
            } else {
                defaultSize2 = (int) ((f / f5) + 0.5f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m58037f()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 1 && (motionEvent.getAction() & 255) == 1) {
            if (this.f1521d) {
                return true;
            }
            this.f1521d = true;
            BGAQRCodeUtil.m57972e("手指触摸触发对焦测光");
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (BGAQRCodeUtil.m57964m(getContext())) {
                y = x;
                x = y;
            }
            int m57970g = BGAQRCodeUtil.m57970g(getContext(), 120.0f);
            m58039d(x, y, m57970g, m57970g);
        }
        if (motionEvent.getPointerCount() == 2) {
            int action = motionEvent.getAction() & 255;
            if (action == 2) {
                float m57975b = BGAQRCodeUtil.m57975b(motionEvent);
                float f = this.f1522e;
                if (m57975b > f) {
                    m58038e(true, this.f1518a);
                } else if (m57975b < f) {
                    m58038e(false, this.f1518a);
                }
            } else if (action == 5) {
                this.f1522e = BGAQRCodeUtil.m57975b(motionEvent);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCamera(Camera camera) {
        this.f1518a = camera;
        if (camera != null) {
            CameraConfigurationManager cameraConfigurationManager = new CameraConfigurationManager(getContext());
            this.f1523f = cameraConfigurationManager;
            cameraConfigurationManager.m57951i(this.f1518a);
            if (this.f1519b) {
                requestLayout();
            } else {
                m58033j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDelegate(InterfaceC1093b interfaceC1093b) {
        this.f1524g = interfaceC1093b;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        m58031l();
        m58033j();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f1520c = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f1520c = false;
        m58031l();
    }
}
