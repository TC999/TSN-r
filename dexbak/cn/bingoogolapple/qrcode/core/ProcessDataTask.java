package cn.bingoogolapple.qrcode.core;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: cn.bingoogolapple.qrcode.core.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ProcessDataTask extends AsyncTask<Void, Void, ScanResult> {

    /* renamed from: g */
    private static long f1621g;

    /* renamed from: a */
    private Camera f1622a;

    /* renamed from: b */
    private byte[] f1623b;

    /* renamed from: c */
    private boolean f1624c;

    /* renamed from: d */
    private String f1625d;

    /* renamed from: e */
    private Bitmap f1626e;

    /* renamed from: f */
    private WeakReference<QRCodeView> f1627f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessDataTask(Camera camera, byte[] bArr, QRCodeView qRCodeView, boolean z) {
        this.f1622a = camera;
        this.f1623b = bArr;
        this.f1627f = new WeakReference<>(qRCodeView);
        this.f1624c = z;
    }

    /* renamed from: e */
    private ScanResult m57943e(QRCodeView qRCodeView) {
        Exception e;
        int i;
        int i2;
        byte[] bArr = this.f1623b;
        if (bArr == null) {
            return null;
        }
        try {
            Camera.Size previewSize = this.f1622a.getParameters().getPreviewSize();
            i2 = previewSize.width;
            try {
                i = previewSize.height;
                try {
                    if (this.f1624c) {
                        bArr = new byte[this.f1623b.length];
                        for (int i3 = 0; i3 < i; i3++) {
                            for (int i4 = 0; i4 < i2; i4++) {
                                bArr[(((i4 * i) + i) - i3) - 1] = this.f1623b[(i3 * i2) + i4];
                            }
                        }
                        i2 = i;
                        i = i2;
                    }
                    return qRCodeView.mo57938u(bArr, i2, i, false);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (i2 != 0 && i != 0) {
                        try {
                            BGAQRCodeUtil.m57972e("识别失败重试");
                            return qRCodeView.mo57938u(bArr, i2, i, true);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                i = 0;
            }
        } catch (Exception e5) {
            e = e5;
            i = 0;
            i2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m57947a() {
        if (getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public ScanResult doInBackground(Void... voidArr) {
        QRCodeView qRCodeView = this.f1627f.get();
        if (qRCodeView == null) {
            return null;
        }
        String str = this.f1625d;
        if (str != null) {
            return qRCodeView.mo57939t(BGAQRCodeUtil.m57968i(str));
        }
        Bitmap bitmap = this.f1626e;
        if (bitmap != null) {
            ScanResult mo57939t = qRCodeView.mo57939t(bitmap);
            this.f1626e = null;
            return mo57939t;
        }
        if (BGAQRCodeUtil.m57965l()) {
            BGAQRCodeUtil.m57972e("两次任务执行的时间间隔：" + (System.currentTimeMillis() - f1621g));
            f1621g = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ScanResult m57943e = m57943e(qRCodeView);
        if (BGAQRCodeUtil.m57965l()) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (m57943e != null && !TextUtils.isEmpty(m57943e.f1628a)) {
                BGAQRCodeUtil.m57972e("识别成功时间为：" + currentTimeMillis2);
            } else {
                BGAQRCodeUtil.m57969h("识别失败时间为：" + currentTimeMillis2);
            }
        }
        return m57943e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(ScanResult scanResult) {
        QRCodeView qRCodeView = this.f1627f.get();
        if (qRCodeView == null) {
            return;
        }
        if (this.f1625d == null && this.f1626e == null) {
            qRCodeView.m58005q(scanResult);
            return;
        }
        this.f1626e = null;
        qRCodeView.m58006p(scanResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public ProcessDataTask m57944d() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.f1627f.clear();
        this.f1626e = null;
        this.f1623b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessDataTask(String str, QRCodeView qRCodeView) {
        this.f1625d = str;
        this.f1627f = new WeakReference<>(qRCodeView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessDataTask(Bitmap bitmap, QRCodeView qRCodeView) {
        this.f1626e = bitmap;
        this.f1627f = new WeakReference<>(qRCodeView);
    }
}
