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

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback {

    /* renamed from: p */
    private static final int f1526p = -1;

    /* renamed from: q */
    private static final long[] f1527q = {255, 255, 255, 255};

    /* renamed from: r */
    private static final int f1528r = 150;

    /* renamed from: s */
    private static final int f1529s = 60;

    /* renamed from: a */
    protected Camera f1530a;

    /* renamed from: b */
    protected CameraPreview f1531b;

    /* renamed from: c */
    protected ScanBoxView f1532c;

    /* renamed from: d */
    protected InterfaceC1099f f1533d;

    /* renamed from: e */
    protected boolean f1534e;

    /* renamed from: f */
    protected ProcessDataTask f1535f;

    /* renamed from: g */
    protected int f1536g;

    /* renamed from: h */
    private PointF[] f1537h;

    /* renamed from: i */
    private Paint f1538i;

    /* renamed from: j */
    protected BarcodeType f1539j;

    /* renamed from: k */
    private long f1540k;

    /* renamed from: l */
    private ValueAnimator f1541l;

    /* renamed from: m */
    private long f1542m;

    /* renamed from: n */
    private long f1543n;

    /* renamed from: o */
    private int f1544o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bingoogolapple.qrcode.core.QRCodeView$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1094a implements CameraPreview.InterfaceC1093b {
        C1094a() {
        }

        @Override // cn.bingoogolapple.qrcode.core.CameraPreview.InterfaceC1093b
        /* renamed from: a */
        public void mo57998a() {
            QRCodeView.this.m58002v();
        }
    }

    /* renamed from: cn.bingoogolapple.qrcode.core.QRCodeView$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class RunnableC1095b implements Runnable {
        RunnableC1095b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeView.this.f1531b.m58035h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bingoogolapple.qrcode.core.QRCodeView$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC1096c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f1547a;

        /* renamed from: b */
        final /* synthetic */ int f1548b;

        /* renamed from: c */
        final /* synthetic */ int f1549c;

        /* renamed from: d */
        final /* synthetic */ String f1550d;

        RunnableC1096c(int i, int i2, int i3, String str) {
            this.f1547a = i;
            this.f1548b = i2;
            this.f1549c = i3;
            this.f1550d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeView qRCodeView = QRCodeView.this;
            int i = this.f1547a;
            qRCodeView.m58000y(i, Math.min(this.f1548b + i, this.f1549c), this.f1550d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bingoogolapple.qrcode.core.QRCodeView$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1097d implements ValueAnimator.AnimatorUpdateListener {
        C1097d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CameraPreview cameraPreview = QRCodeView.this.f1531b;
            if (cameraPreview == null || !cameraPreview.m58037f()) {
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            Camera.Parameters parameters = QRCodeView.this.f1530a.getParameters();
            parameters.setZoom(intValue);
            QRCodeView.this.f1530a.setParameters(parameters);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.bingoogolapple.qrcode.core.QRCodeView$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1098e extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ String f1553a;

        C1098e(String str) {
            this.f1553a = str;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QRCodeView.this.m58005q(new ScanResult(this.f1553a));
        }
    }

    /* renamed from: cn.bingoogolapple.qrcode.core.QRCodeView$f */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1099f {
        /* renamed from: D */
        void mo38629D();

        /* renamed from: H */
        void mo38628H(String str);

        /* renamed from: b */
        void mo38627b(boolean z);
    }

    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: B */
    private void m58029B(int i) {
        try {
            this.f1536g = i;
            Camera open = Camera.open(i);
            this.f1530a = open;
            this.f1531b.setCamera(open);
        } catch (Exception e) {
            e.printStackTrace();
            InterfaceC1099f interfaceC1099f = this.f1533d;
            if (interfaceC1099f != null) {
                interfaceC1099f.mo38629D();
            }
        }
    }

    /* renamed from: H */
    private PointF m58023H(float f, float f2, float f3, float f4, boolean z, int i, Rect rect) {
        PointF pointF;
        int width = getWidth();
        int height = getHeight();
        if (BGAQRCodeUtil.m57964m(getContext())) {
            float f5 = width;
            float f6 = height;
            pointF = new PointF((f4 - f) * (f5 / f4), (f3 - f2) * (f6 / f3));
            float f7 = f6 - pointF.y;
            pointF.y = f7;
            pointF.x = f5 - pointF.x;
            if (rect == null) {
                pointF.y = f7 + i;
            }
        } else {
            float f8 = width;
            pointF = new PointF(f * (f8 / f3), f2 * (height / f4));
            if (z) {
                pointF.x = f8 - pointF.x;
            }
        }
        if (rect != null) {
            pointF.y += rect.top;
            pointF.x += rect.left;
        }
        return pointF;
    }

    /* renamed from: h */
    private int m58014h(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            try {
                Camera.getCameraInfo(i2, cameraInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: i */
    private void m58013i(byte[] bArr, Camera camera) {
        CameraPreview cameraPreview = this.f1531b;
        if (cameraPreview == null || !cameraPreview.m58037f()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1543n < 150) {
            return;
        }
        this.f1543n = currentTimeMillis;
        long j = 0;
        long j2 = camera.getParameters().getPreviewSize().width * camera.getParameters().getPreviewSize().height;
        if (Math.abs(bArr.length - (((float) j2) * 1.5f)) < 1.0E-5f) {
            boolean z = false;
            for (int i = 0; i < j2; i += 10) {
                j += bArr[i] & 255;
            }
            long j3 = j / (j2 / 10);
            long[] jArr = f1527q;
            int length = this.f1544o % jArr.length;
            this.f1544o = length;
            jArr[length] = j3;
            this.f1544o = length + 1;
            int length2 = jArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = true;
                    break;
                } else if (jArr[i2] > 60) {
                    break;
                } else {
                    i2++;
                }
            }
            BGAQRCodeUtil.m57972e("摄像头环境亮度为：" + j3);
            InterfaceC1099f interfaceC1099f = this.f1533d;
            if (interfaceC1099f != null) {
                interfaceC1099f.mo38627b(z);
            }
        }
    }

    /* renamed from: j */
    private boolean m58012j(PointF[] pointFArr, String str) {
        if (this.f1530a == null || this.f1532c == null || pointFArr == null || pointFArr.length < 1) {
            return false;
        }
        ValueAnimator valueAnimator = this.f1541l;
        if ((valueAnimator == null || !valueAnimator.isRunning()) && System.currentTimeMillis() - this.f1542m >= 1200) {
            Camera.Parameters parameters = this.f1530a.getParameters();
            if (parameters.isZoomSupported()) {
                float f = pointFArr[0].x;
                float f2 = pointFArr[0].y;
                float f3 = pointFArr[1].x;
                float f4 = pointFArr[1].y;
                float abs = Math.abs(f - f3);
                float abs2 = Math.abs(f2 - f4);
                if (((int) Math.sqrt((abs * abs) + (abs2 * abs2))) > this.f1532c.getRectWidth() / 4) {
                    return false;
                }
                int maxZoom = parameters.getMaxZoom();
                post(new RunnableC1096c(parameters.getZoom(), maxZoom / 4, maxZoom, str));
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: l */
    private void m58010l(Context context, AttributeSet attributeSet) {
        CameraPreview cameraPreview = new CameraPreview(context);
        this.f1531b = cameraPreview;
        cameraPreview.setDelegate(new C1094a());
        ScanBoxView scanBoxView = new ScanBoxView(context);
        this.f1532c = scanBoxView;
        scanBoxView.m57989i(this, attributeSet);
        this.f1531b.setId(C1100R.C1101id.bgaqrcode_camera_preview);
        addView(this.f1531b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
        layoutParams.addRule(6, this.f1531b.getId());
        layoutParams.addRule(8, this.f1531b.getId());
        addView(this.f1532c, layoutParams);
        Paint paint = new Paint();
        this.f1538i = paint;
        paint.setColor(getScanBoxView().getCornerColor());
        this.f1538i.setStyle(Paint.Style.FILL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m58002v() {
        if (this.f1534e && this.f1531b.m58037f()) {
            try {
                this.f1530a.setOneShotPreviewCallback(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m58000y(int i, int i2, String str) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        this.f1541l = ofInt;
        ofInt.addUpdateListener(new C1097d());
        this.f1541l.addListener(new C1098e(str));
        this.f1541l.setDuration(600L);
        this.f1541l.setRepeatCount(0);
        this.f1541l.start();
        this.f1542m = System.currentTimeMillis();
    }

    /* renamed from: A */
    public void m58030A(int i) {
        if (this.f1530a != null || Camera.getNumberOfCameras() == 0) {
            return;
        }
        int m58014h = m58014h(i);
        if (m58014h != -1) {
            m58029B(m58014h);
            return;
        }
        if (i == 0) {
            m58014h = m58014h(1);
        } else if (i == 1) {
            m58014h = m58014h(0);
        }
        if (m58014h != -1) {
            m58029B(m58014h);
        }
    }

    /* renamed from: C */
    public void m58028C() {
        this.f1534e = true;
        m57999z();
        m58002v();
    }

    /* renamed from: D */
    public void m58027D() {
        m58028C();
        m58001x();
    }

    /* renamed from: E */
    public void m58026E() {
        try {
            m58024G();
            if (this.f1530a != null) {
                this.f1531b.m58031l();
                this.f1531b.setCamera(null);
                this.f1530a.release();
                this.f1530a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: F */
    public void m58025F() {
        this.f1534e = false;
        ProcessDataTask processDataTask = this.f1535f;
        if (processDataTask != null) {
            processDataTask.m57947a();
            this.f1535f = null;
        }
        Camera camera = this.f1530a;
        if (camera != null) {
            try {
                camera.setOneShotPreviewCallback(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: G */
    public void m58024G() {
        m58025F();
        m58011k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I */
    public boolean m58022I(PointF[] pointFArr, Rect rect, boolean z, String str) {
        if (pointFArr != null && pointFArr.length != 0) {
            try {
                Camera.Size previewSize = this.f1530a.getParameters().getPreviewSize();
                boolean z2 = this.f1536g == 1;
                int m57966k = BGAQRCodeUtil.m57966k(getContext());
                PointF[] pointFArr2 = new PointF[pointFArr.length];
                int i = 0;
                for (PointF pointF : pointFArr) {
                    pointFArr2[i] = m58023H(pointF.x, pointF.y, previewSize.width, previewSize.height, z2, m57966k, rect);
                    i++;
                }
                this.f1537h = pointFArr2;
                postInvalidate();
                if (z) {
                    return m58012j(pointFArr2, str);
                }
                return false;
            } catch (Exception e) {
                this.f1537h = null;
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m58019c() {
        if (this.f1532c.getIsBarcode()) {
            return;
        }
        this.f1532c.setIsBarcode(true);
    }

    /* renamed from: d */
    public void m58018d() {
        if (this.f1532c.getIsBarcode()) {
            this.f1532c.setIsBarcode(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        PointF[] pointFArr;
        super.dispatchDraw(canvas);
        if (!m58008n() || (pointFArr = this.f1537h) == null) {
            return;
        }
        for (PointF pointF : pointFArr) {
            canvas.drawCircle(pointF.x, pointF.y, 10.0f, this.f1538i);
        }
        this.f1537h = null;
        postInvalidateDelayed(2000L);
    }

    /* renamed from: e */
    public void m58017e() {
        this.f1531b.m58041b();
    }

    /* renamed from: f */
    public void m58016f(Bitmap bitmap) {
        this.f1535f = new ProcessDataTask(bitmap, this).m57944d();
    }

    /* renamed from: g */
    public void m58015g(String str) {
        this.f1535f = new ProcessDataTask(str, this).m57944d();
    }

    public CameraPreview getCameraPreview() {
        return this.f1531b;
    }

    public boolean getIsScanBarcodeStyle() {
        return this.f1532c.getIsBarcode();
    }

    public ScanBoxView getScanBoxView() {
        return this.f1532c;
    }

    /* renamed from: k */
    public void m58011k() {
        ScanBoxView scanBoxView = this.f1532c;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public boolean m58009m() {
        ScanBoxView scanBoxView = this.f1532c;
        return scanBoxView != null && scanBoxView.m57987k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public boolean m58008n() {
        ScanBoxView scanBoxView = this.f1532c;
        return scanBoxView != null && scanBoxView.m57982p();
    }

    /* renamed from: o */
    public void m58007o() {
        m58026E();
        this.f1533d = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f1541l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (BGAQRCodeUtil.m57965l()) {
            BGAQRCodeUtil.m57972e("两次 onPreviewFrame 时间间隔：" + (System.currentTimeMillis() - this.f1540k));
            this.f1540k = System.currentTimeMillis();
        }
        CameraPreview cameraPreview = this.f1531b;
        if (cameraPreview != null && cameraPreview.m58037f()) {
            try {
                m58013i(bArr, camera);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f1534e) {
            ProcessDataTask processDataTask = this.f1535f;
            if (processDataTask == null || !(processDataTask.getStatus() == AsyncTask.Status.PENDING || this.f1535f.getStatus() == AsyncTask.Status.RUNNING)) {
                this.f1535f = new ProcessDataTask(camera, bArr, this, BGAQRCodeUtil.m57964m(getContext())).m57944d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void m58006p(ScanResult scanResult) {
        InterfaceC1099f interfaceC1099f = this.f1533d;
        if (interfaceC1099f != null) {
            interfaceC1099f.mo38628H(scanResult == null ? null : scanResult.f1628a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public void m58005q(ScanResult scanResult) {
        if (this.f1534e) {
            String str = scanResult == null ? null : scanResult.f1628a;
            if (TextUtils.isEmpty(str)) {
                try {
                    Camera camera = this.f1530a;
                    if (camera != null) {
                        camera.setOneShotPreviewCallback(this);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.f1534e = false;
            try {
                InterfaceC1099f interfaceC1099f = this.f1533d;
                if (interfaceC1099f != null) {
                    interfaceC1099f.mo38628H(str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public void m58004r(Rect rect) {
        this.f1531b.m58036g(rect);
    }

    /* renamed from: s */
    public void m58003s() {
        postDelayed(new RunnableC1095b(), this.f1531b.m58037f() ? 0L : 500L);
    }

    public void setDelegate(InterfaceC1099f interfaceC1099f) {
        this.f1533d = interfaceC1099f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public abstract ScanResult mo57939t(Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u */
    public abstract ScanResult mo57938u(byte[] bArr, int i, int i2, boolean z);

    /* renamed from: w */
    protected abstract void mo57937w();

    /* renamed from: x */
    public void m58001x() {
        ScanBoxView scanBoxView = this.f1532c;
        if (scanBoxView != null) {
            scanBoxView.setVisibility(0);
        }
    }

    /* renamed from: z */
    public void m57999z() {
        m58030A(this.f1536g);
    }

    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1534e = false;
        this.f1536g = 0;
        this.f1539j = BarcodeType.HIGH_FREQUENCY;
        this.f1540k = 0L;
        this.f1542m = 0L;
        this.f1543n = System.currentTimeMillis();
        this.f1544o = 0;
        m58010l(context, attributeSet);
        mo57937w();
    }
}
