package cn.bingoogolapple.qrcode.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cn.bingoogolapple.qrcode.core.CameraPreview;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback {

    /* renamed from: p  reason: collision with root package name */
    private static final int f1540p = -1;

    /* renamed from: q  reason: collision with root package name */
    private static final long[] f1541q = {255, 255, 255, 255};

    /* renamed from: r  reason: collision with root package name */
    private static final int f1542r = 150;

    /* renamed from: s  reason: collision with root package name */
    private static final int f1543s = 60;

    /* renamed from: a  reason: collision with root package name */
    protected Camera f1544a;

    /* renamed from: b  reason: collision with root package name */
    protected CameraPreview f1545b;

    /* renamed from: c  reason: collision with root package name */
    protected ScanBoxView f1546c;

    /* renamed from: d  reason: collision with root package name */
    protected f f1547d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f1548e;

    /* renamed from: f  reason: collision with root package name */
    protected cn.bingoogolapple.qrcode.core.d f1549f;

    /* renamed from: g  reason: collision with root package name */
    protected int f1550g;

    /* renamed from: h  reason: collision with root package name */
    private PointF[] f1551h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f1552i;

    /* renamed from: j  reason: collision with root package name */
    protected BarcodeType f1553j;

    /* renamed from: k  reason: collision with root package name */
    private long f1554k;

    /* renamed from: l  reason: collision with root package name */
    private ValueAnimator f1555l;

    /* renamed from: m  reason: collision with root package name */
    private long f1556m;

    /* renamed from: n  reason: collision with root package name */
    private long f1557n;

    /* renamed from: o  reason: collision with root package name */
    private int f1558o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements CameraPreview.b {
        a() {
        }

        @Override // cn.bingoogolapple.qrcode.core.CameraPreview.b
        public void a() {
            QRCodeView.this.v();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeView.this.f1545b.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1561a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1562b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1563c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f1564d;

        c(int i4, int i5, int i6, String str) {
            this.f1561a = i4;
            this.f1562b = i5;
            this.f1563c = i6;
            this.f1564d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeView qRCodeView = QRCodeView.this;
            int i4 = this.f1561a;
            qRCodeView.y(i4, Math.min(this.f1562b + i4, this.f1563c), this.f1564d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CameraPreview cameraPreview = QRCodeView.this.f1545b;
            if (cameraPreview == null || !cameraPreview.f()) {
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            Camera.Parameters parameters = QRCodeView.this.f1544a.getParameters();
            parameters.setZoom(intValue);
            QRCodeView.this.f1544a.setParameters(parameters);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1567a;

        e(String str) {
            this.f1567a = str;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QRCodeView.this.q(new cn.bingoogolapple.qrcode.core.e(this.f1567a));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface f {
        void D();

        void H(String str);

        void b(boolean z3);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B(int i4) {
        try {
            this.f1550g = i4;
            Camera open = Camera.open(i4);
            this.f1544a = open;
            this.f1545b.setCamera(open);
        } catch (Exception e4) {
            e4.printStackTrace();
            f fVar = this.f1547d;
            if (fVar != null) {
                fVar.D();
            }
        }
    }

    private PointF H(float f4, float f5, float f6, float f7, boolean z3, int i4, Rect rect) {
        PointF pointF;
        int width = getWidth();
        int height = getHeight();
        if (cn.bingoogolapple.qrcode.core.a.m(getContext())) {
            float f8 = width;
            float f9 = height;
            pointF = new PointF((f7 - f4) * (f8 / f7), (f6 - f5) * (f9 / f6));
            float f10 = f9 - pointF.y;
            pointF.y = f10;
            pointF.x = f8 - pointF.x;
            if (rect == null) {
                pointF.y = f10 + i4;
            }
        } else {
            float f11 = width;
            pointF = new PointF(f4 * (f11 / f6), f5 * (height / f7));
            if (z3) {
                pointF.x = f11 - pointF.x;
            }
        }
        if (rect != null) {
            pointF.y += rect.top;
            pointF.x += rect.left;
        }
        return pointF;
    }

    private int h(int i4) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i5 = 0; i5 < Camera.getNumberOfCameras(); i5++) {
            try {
                Camera.getCameraInfo(i5, cameraInfo);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (cameraInfo.facing == i4) {
                return i5;
            }
        }
        return -1;
    }

    private void i(byte[] bArr, Camera camera) {
        CameraPreview cameraPreview = this.f1545b;
        if (cameraPreview == null || !cameraPreview.f()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1557n < 150) {
            return;
        }
        this.f1557n = currentTimeMillis;
        long j4 = 0;
        long j5 = camera.getParameters().getPreviewSize().width * camera.getParameters().getPreviewSize().height;
        if (Math.abs(bArr.length - (((float) j5) * 1.5f)) < 1.0E-5f) {
            boolean z3 = false;
            for (int i4 = 0; i4 < j5; i4 += 10) {
                j4 += bArr[i4] & 255;
            }
            long j6 = j4 / (j5 / 10);
            long[] jArr = f1541q;
            int length = this.f1558o % jArr.length;
            this.f1558o = length;
            jArr[length] = j6;
            this.f1558o = length + 1;
            int length2 = jArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length2) {
                    z3 = true;
                    break;
                } else if (jArr[i5] > 60) {
                    break;
                } else {
                    i5++;
                }
            }
            cn.bingoogolapple.qrcode.core.a.e("\u6444\u50cf\u5934\u73af\u5883\u4eae\u5ea6\u4e3a\uff1a" + j6);
            f fVar = this.f1547d;
            if (fVar != null) {
                fVar.b(z3);
            }
        }
    }

    private boolean j(PointF[] pointFArr, String str) {
        if (this.f1544a == null || this.f1546c == null || pointFArr == null || pointFArr.length < 1) {
            return false;
        }
        ValueAnimator valueAnimator = this.f1555l;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && System.currentTimeMillis() - this.f1556m >= 1200) {
            Camera.Parameters parameters = this.f1544a.getParameters();
            if (parameters.isZoomSupported()) {
                float f4 = pointFArr[0].x;
                float f5 = pointFArr[0].y;
                float f6 = pointFArr[1].x;
                float f7 = pointFArr[1].y;
                float abs = Math.abs(f4 - f6);
                float abs2 = Math.abs(f5 - f7);
                if (((int) Math.sqrt((abs * abs) + (abs2 * abs2))) > this.f1546c.getRectWidth() / 4) {
                    return false;
                }
                int maxZoom = parameters.getMaxZoom();
                post(new c(parameters.getZoom(), maxZoom / 4, maxZoom, str));
                return true;
            }
            return false;
        }
        return true;
    }

    private void l(Context context, AttributeSet attributeSet) {
        CameraPreview cameraPreview = new CameraPreview(context);
        this.f1545b = cameraPreview;
        cameraPreview.setDelegate(new a());
        ScanBoxView scanBoxView = new ScanBoxView(context);
        this.f1546c = scanBoxView;
        scanBoxView.i(this, attributeSet);
        this.f1545b.setId(R.id.bgaqrcode_camera_preview);
        addView(this.f1545b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.f1545b.getId());
        layoutParams.addRule(8, this.f1545b.getId());
        addView(this.f1546c, layoutParams);
        Paint paint = new Paint();
        this.f1552i = paint;
        paint.setColor(getScanBoxView().getCornerColor());
        this.f1552i.setStyle(Paint.Style.FILL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.f1548e && this.f1545b.f()) {
            try {
                this.f1544a.setOneShotPreviewCallback(this);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i4, int i5, String str) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i4, i5);
        this.f1555l = ofInt;
        ofInt.addUpdateListener(new d());
        this.f1555l.addListener(new e(str));
        this.f1555l.setDuration(600L);
        this.f1555l.setRepeatCount(0);
        this.f1555l.start();
        this.f1556m = System.currentTimeMillis();
    }

    public void A(int i4) {
        if (this.f1544a != null || Camera.getNumberOfCameras() == 0) {
            return;
        }
        int h4 = h(i4);
        if (h4 != -1) {
            B(h4);
            return;
        }
        if (i4 == 0) {
            h4 = h(1);
        } else if (i4 == 1) {
            h4 = h(0);
        }
        if (h4 != -1) {
            B(h4);
        }
    }

    public void C() {
        this.f1548e = true;
        z();
        v();
    }

    public void D() {
        C();
        x();
    }

    public void E() {
        try {
            G();
            if (this.f1544a != null) {
                this.f1545b.l();
                this.f1545b.setCamera(null);
                this.f1544a.release();
                this.f1544a = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void F() {
        this.f1548e = false;
        cn.bingoogolapple.qrcode.core.d dVar = this.f1549f;
        if (dVar != null) {
            dVar.a();
            this.f1549f = null;
        }
        Camera camera = this.f1544a;
        if (camera != null) {
            try {
                camera.setOneShotPreviewCallback(null);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void G() {
        F();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I(PointF[] pointFArr, Rect rect, boolean z3, String str) {
        if (pointFArr != null && pointFArr.length != 0) {
            try {
                Camera.Size previewSize = this.f1544a.getParameters().getPreviewSize();
                boolean z4 = this.f1550g == 1;
                int k4 = cn.bingoogolapple.qrcode.core.a.k(getContext());
                PointF[] pointFArr2 = new PointF[pointFArr.length];
                int i4 = 0;
                for (PointF pointF : pointFArr) {
                    pointFArr2[i4] = H(pointF.x, pointF.y, previewSize.width, previewSize.height, z4, k4, rect);
                    i4++;
                }
                this.f1551h = pointFArr2;
                postInvalidate();
                if (z3) {
                    return j(pointFArr2, str);
                }
                return false;
            } catch (Exception e4) {
                this.f1551h = null;
                e4.printStackTrace();
            }
        }
        return false;
    }

    public void c() {
        if (this.f1546c.getIsBarcode()) {
            return;
        }
        this.f1546c.setIsBarcode(true);
    }

    public void d() {
        if (this.f1546c.getIsBarcode()) {
            this.f1546c.setIsBarcode(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        PointF[] pointFArr;
        super.dispatchDraw(canvas);
        if (!n() || (pointFArr = this.f1551h) == null) {
            return;
        }
        for (PointF pointF : pointFArr) {
            canvas.drawCircle(pointF.x, pointF.y, 10.0f, this.f1552i);
        }
        this.f1551h = null;
        postInvalidateDelayed(2000L);
    }

    public void e() {
        this.f1545b.b();
    }

    public void f(Bitmap bitmap) {
        this.f1549f = new cn.bingoogolapple.qrcode.core.d(bitmap, this).d();
    }

    public void g(String str) {
        this.f1549f = new cn.bingoogolapple.qrcode.core.d(str, this).d();
    }

    public CameraPreview getCameraPreview() {
        return this.f1545b;
    }

    public boolean getIsScanBarcodeStyle() {
        return this.f1546c.getIsBarcode();
    }

    public ScanBoxView getScanBoxView() {
        return this.f1546c;
    }

    public void k() {
        ScanBoxView scanBoxView = this.f1546c;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        ScanBoxView scanBoxView = this.f1546c;
        return scanBoxView != null && scanBoxView.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n() {
        ScanBoxView scanBoxView = this.f1546c;
        return scanBoxView != null && scanBoxView.p();
    }

    public void o() {
        E();
        this.f1547d = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f1555l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (cn.bingoogolapple.qrcode.core.a.l()) {
            cn.bingoogolapple.qrcode.core.a.e("\u4e24\u6b21 onPreviewFrame \u65f6\u95f4\u95f4\u9694\uff1a" + (System.currentTimeMillis() - this.f1554k));
            this.f1554k = System.currentTimeMillis();
        }
        CameraPreview cameraPreview = this.f1545b;
        if (cameraPreview != null && cameraPreview.f()) {
            try {
                i(bArr, camera);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (this.f1548e) {
            cn.bingoogolapple.qrcode.core.d dVar = this.f1549f;
            if (dVar == null || !(dVar.getStatus() == AsyncTask.Status.PENDING || this.f1549f.getStatus() == AsyncTask.Status.RUNNING)) {
                this.f1549f = new cn.bingoogolapple.qrcode.core.d(camera, bArr, this, cn.bingoogolapple.qrcode.core.a.m(getContext())).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(cn.bingoogolapple.qrcode.core.e eVar) {
        f fVar = this.f1547d;
        if (fVar != null) {
            fVar.H(eVar == null ? null : eVar.f1615a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(cn.bingoogolapple.qrcode.core.e eVar) {
        if (this.f1548e) {
            String str = eVar == null ? null : eVar.f1615a;
            if (TextUtils.isEmpty(str)) {
                try {
                    Camera camera = this.f1544a;
                    if (camera != null) {
                        camera.setOneShotPreviewCallback(this);
                        return;
                    }
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            this.f1548e = false;
            try {
                f fVar = this.f1547d;
                if (fVar != null) {
                    fVar.H(str);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Rect rect) {
        this.f1545b.g(rect);
    }

    public void s() {
        postDelayed(new b(), this.f1545b.f() ? 0L : 500L);
    }

    public void setDelegate(f fVar) {
        this.f1547d = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract cn.bingoogolapple.qrcode.core.e t(Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract cn.bingoogolapple.qrcode.core.e u(byte[] bArr, int i4, int i5, boolean z3);

    protected abstract void w();

    public void x() {
        ScanBoxView scanBoxView = this.f1546c;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(0);
        }
    }

    public void z() {
        A(this.f1550g);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1548e = false;
        this.f1550g = 0;
        this.f1553j = BarcodeType.HIGH_FREQUENCY;
        this.f1554k = 0L;
        this.f1556m = 0L;
        this.f1557n = System.currentTimeMillis();
        this.f1558o = 0;
        l(context, attributeSet);
        w();
    }
}
