package cn.bingoogolapple.qrcode.core;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ProcessDataTask.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d extends AsyncTask<Void, Void, e> {

    /* renamed from: g  reason: collision with root package name */
    private static long f1608g;

    /* renamed from: a  reason: collision with root package name */
    private Camera f1609a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f1610b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1611c;

    /* renamed from: d  reason: collision with root package name */
    private String f1612d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f1613e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<QRCodeView> f1614f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Camera camera, byte[] bArr, QRCodeView qRCodeView, boolean z3) {
        this.f1609a = camera;
        this.f1610b = bArr;
        this.f1614f = new WeakReference<>(qRCodeView);
        this.f1611c = z3;
    }

    private e e(QRCodeView qRCodeView) {
        Exception e4;
        int i4;
        int i5;
        byte[] bArr = this.f1610b;
        if (bArr == null) {
            return null;
        }
        try {
            Camera.Size previewSize = this.f1609a.getParameters().getPreviewSize();
            i5 = previewSize.width;
            try {
                i4 = previewSize.height;
                try {
                    if (this.f1611c) {
                        bArr = new byte[this.f1610b.length];
                        for (int i6 = 0; i6 < i4; i6++) {
                            for (int i7 = 0; i7 < i5; i7++) {
                                bArr[(((i7 * i4) + i4) - i6) - 1] = this.f1610b[(i6 * i5) + i7];
                            }
                        }
                        i5 = i4;
                        i4 = i5;
                    }
                    return qRCodeView.u(bArr, i5, i4, false);
                } catch (Exception e5) {
                    e4 = e5;
                    e4.printStackTrace();
                    if (i5 != 0 && i4 != 0) {
                        try {
                            a.e("\u8bc6\u522b\u5931\u8d25\u91cd\u8bd5");
                            return qRCodeView.u(bArr, i5, i4, true);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            } catch (Exception e7) {
                e4 = e7;
                i4 = 0;
            }
        } catch (Exception e8) {
            e4 = e8;
            i4 = 0;
            i5 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (getStatus() != AsyncTask.Status.FINISHED) {
            cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public e doInBackground(Void... voidArr) {
        QRCodeView qRCodeView = this.f1614f.get();
        if (qRCodeView == null) {
            return null;
        }
        String str = this.f1612d;
        if (str != null) {
            return qRCodeView.t(a.i(str));
        }
        Bitmap bitmap = this.f1613e;
        if (bitmap != null) {
            e t3 = qRCodeView.t(bitmap);
            this.f1613e = null;
            return t3;
        }
        if (a.l()) {
            a.e("\u4e24\u6b21\u4efb\u52a1\u6267\u884c\u7684\u65f6\u95f4\u95f4\u9694\uff1a" + (System.currentTimeMillis() - f1608g));
            f1608g = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        e e4 = e(qRCodeView);
        if (a.l()) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (e4 != null && !TextUtils.isEmpty(e4.f1615a)) {
                a.e("\u8bc6\u522b\u6210\u529f\u65f6\u95f4\u4e3a\uff1a" + currentTimeMillis2);
            } else {
                a.h("\u8bc6\u522b\u5931\u8d25\u65f6\u95f4\u4e3a\uff1a" + currentTimeMillis2);
            }
        }
        return e4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(e eVar) {
        QRCodeView qRCodeView = this.f1614f.get();
        if (qRCodeView == null) {
            return;
        }
        if (this.f1612d == null && this.f1613e == null) {
            qRCodeView.q(eVar);
            return;
        }
        this.f1613e = null;
        qRCodeView.p(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d d() {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.f1614f.clear();
        this.f1613e = null;
        this.f1610b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, QRCodeView qRCodeView) {
        this.f1612d = str;
        this.f1614f = new WeakReference<>(qRCodeView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Bitmap bitmap, QRCodeView qRCodeView) {
        this.f1613e = bitmap;
        this.f1614f = new WeakReference<>(qRCodeView);
    }
}
