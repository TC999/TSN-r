package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.lesson.CertificateActivity;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CertificateActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private ImageView f21110k;

    /* renamed from: l  reason: collision with root package name */
    private Button f21111l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f21112m;

    /* renamed from: n  reason: collision with root package name */
    private String f21113n;

    /* renamed from: o  reason: collision with root package name */
    private float f21114o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LoadingDialog f21115a;

        a(final LoadingDialog val$loadingDialog) {
            this.f21115a = val$loadingDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(LoadingDialog loadingDialog) {
            loadingDialog.dismiss();
            CertificateActivity.this.f21111l.setVisibility(0);
            CertificateActivity.this.f21110k.setImageBitmap(CertificateActivity.this.f21112m);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Bitmap decodeResource = BitmapFactory.decodeResource(CertificateActivity.this.getResources(), 2131558455);
            CertificateActivity certificateActivity = CertificateActivity.this;
            certificateActivity.f21112m = certificateActivity.p0(decodeResource);
            CertificateActivity certificateActivity2 = CertificateActivity.this;
            final LoadingDialog loadingDialog = this.f21115a;
            certificateActivity2.runOnUiThread(new Runnable() { // from class: com.bxkj.student.home.teaching.lesson.b
                @Override // java.lang.Runnable
                public final void run() {
                    CertificateActivity.a.this.b(loadingDialog);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bitmap f21117a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21118b;

        b(final Bitmap val$bmp, final Context val$context) {
            this.f21117a = val$bmp;
            this.f21118b = val$context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Toast.makeText(((BaseActivity) CertificateActivity.this).f1656h, "\u5df2\u6210\u529f\u4fdd\u5b58\u5230\u76f8\u518c", 0).show();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v11, types: [com.bxkj.student.home.teaching.lesson.CertificateActivity, android.app.Activity] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v5, types: [com.bxkj.student.home.teaching.lesson.c, java.lang.Runnable] */
        /* JADX WARN: Type inference failed for: r1v7 */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = android.os.Environment.DIRECTORY_PICTURES
                java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)
                java.io.File r0 = r0.getAbsoluteFile()
                java.io.File r1 = new java.io.File
                java.lang.String r2 = "download"
                r1.<init>(r0, r2)
                boolean r0 = r1.exists()
                if (r0 != 0) goto L1a
                r1.mkdirs()
            L1a:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                long r2 = java.lang.System.currentTimeMillis()
                r0.append(r2)
                java.lang.String r2 = ".jpg"
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.io.File r2 = new java.io.File
                r2.<init>(r1, r0)
                r0 = 0
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L60
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L53 java.io.FileNotFoundException -> L60
                android.graphics.Bitmap r0 = r6.f21117a     // Catch: java.io.IOException -> L4a java.io.FileNotFoundException -> L4c java.lang.Throwable -> L95
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.io.IOException -> L4a java.io.FileNotFoundException -> L4c java.lang.Throwable -> L95
                r4 = 100
                r0.compress(r3, r4, r1)     // Catch: java.io.IOException -> L4a java.io.FileNotFoundException -> L4c java.lang.Throwable -> L95
                r1.flush()     // Catch: java.io.IOException -> L4a java.io.FileNotFoundException -> L4c java.lang.Throwable -> L95
                r1.close()     // Catch: java.io.IOException -> L6d
                goto L71
            L4a:
                r0 = move-exception
                goto L57
            L4c:
                r0 = move-exception
                goto L64
            L4e:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
                goto L96
            L53:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L57:
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L95
                if (r1 == 0) goto L71
                r1.close()     // Catch: java.io.IOException -> L6d
                goto L71
            L60:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L64:
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L95
                if (r1 == 0) goto L71
                r1.close()     // Catch: java.io.IOException -> L6d
                goto L71
            L6d:
                r0 = move-exception
                r0.printStackTrace()
            L71:
                android.content.Context r0 = r6.f21118b
                android.content.Intent r1 = new android.content.Intent
                java.io.File r3 = new java.io.File
                java.lang.String r2 = r2.getPath()
                r3.<init>(r2)
                android.net.Uri r2 = android.net.Uri.fromFile(r3)
                java.lang.String r3 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
                r1.<init>(r3, r2)
                r0.sendBroadcast(r1)
                com.bxkj.student.home.teaching.lesson.CertificateActivity r0 = com.bxkj.student.home.teaching.lesson.CertificateActivity.this
                com.bxkj.student.home.teaching.lesson.c r1 = new com.bxkj.student.home.teaching.lesson.c
                r1.<init>()
                r0.runOnUiThread(r1)
                return
            L95:
                r0 = move-exception
            L96:
                if (r1 == 0) goto La0
                r1.close()     // Catch: java.io.IOException -> L9c
                goto La0
            L9c:
                r1 = move-exception
                r1.printStackTrace()
            La0:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.home.teaching.lesson.CertificateActivity.b.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap p0(Bitmap src) {
        Bitmap decodeResource;
        Bitmap decodeResource2;
        Bitmap decodeResource3;
        if (src == null) {
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        float f4 = width;
        float f5 = f4 / 2480;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRGB(255, 255, 255);
        canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        float f6 = f4 / 2.0f;
        float f7 = 234.0f * f5;
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 2131558458), f6 - (decodeResource.getWidth() / 2.0f), f7, (Paint) null);
        float height2 = f7 + decodeResource.getHeight() + (73.0f * f5);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 2131558459), f6 - (decodeResource2.getWidth() / 2.0f), height2, (Paint) null);
        float height3 = height2 + decodeResource2.getHeight() + (266.0f * f5);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 2131558457), f6 - (decodeResource3.getWidth() / 2.0f), height3, (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize(u.a(36.0f, this.f1656h));
        paint.setUnderlineText(true);
        Rect rect = new Rect();
        String realName = LoginUser.getLoginUser().getRealName();
        paint.getTextBounds(realName, 0, realName.length(), rect);
        float f8 = 388.0f * f5;
        float height4 = height3 + decodeResource3.getHeight() + (302.0f * f5);
        canvas.drawText(realName, f8, height4, paint);
        Rect rect2 = new Rect();
        paint.setUnderlineText(false);
        paint.getTextBounds("\u540c\u5b66\uff1a", 0, 3, rect2);
        canvas.drawText("\u540c\u5b66\uff1a", rect.width() + f8, height4, paint);
        Bitmap decodeResource4 = BitmapFactory.decodeResource(getResources(), 2131558456);
        Rect rect3 = new Rect();
        paint.setUnderlineText(false);
        paint.setTextSize(u.a(30.0f, this.f1656h));
        String schoolName = LoginUser.getLoginUser().getSchoolName();
        paint.getTextBounds(schoolName, 0, schoolName.length(), rect3);
        float f9 = 1103.0f * f5;
        float f10 = height - (440.0f * f5);
        canvas.drawText(schoolName, ((decodeResource4.getWidth() / 2.0f) + f9) - (rect3.width() / 2.0f), f10 - (decodeResource4.getHeight() / 2.0f), paint);
        Rect rect4 = new Rect();
        paint.setUnderlineText(false);
        paint.setTextSize(u.a(30.0f, this.f1656h));
        paint.getTextBounds("\u4f53\u80b2\u90e8", 0, 3, rect4);
        canvas.drawText("\u4f53\u80b2\u90e8", ((decodeResource4.getWidth() / 2.0f) + f9) - (rect4.width() / 2.0f), (f10 - (decodeResource4.getHeight() / 2.0f)) + rect3.height(), paint);
        canvas.drawBitmap(decodeResource4, f9, f10 - decodeResource4.getHeight(), (Paint) null);
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(-16777216);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setTextSize(u.a(36.0f, this.f1656h));
        StaticLayout staticLayout = new StaticLayout("\u3000\u3000\u53c2\u52a0" + this.f21113n + "\u73ed\u5b66\u4e60\uff0c\u7ecf\u8003\u6838" + q0(this.f21114o) + "\uff0c\u7279\u53d1\u6b64\u8bc1\uff01", textPaint, (int) ((f4 - f8) - (450.0f * f5)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        canvas.translate(f8, height4 + rect2.height() + (f5 * 120.0f));
        staticLayout.draw(canvas);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private String q0(float score) {
        return score >= 90.0f ? "\u4f18\u79c0" : score >= 80.0f ? "\u826f\u597d" : score >= 60.0f ? "\u5408\u683c" : "\u65e0\u8bc1\u4e66";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(View view) {
        t0(this.f1656h, this.f21112m);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21111l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateActivity.this.r0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427377;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("lessonName")) {
            this.f21113n = getIntent().getStringExtra("lessonName");
        }
        if (getIntent().hasExtra("score")) {
            this.f21114o = getIntent().getFloatExtra("score", 0.0f);
        }
        LoadingDialog loadingDialog = new LoadingDialog(this.f1656h);
        loadingDialog.setMessage("\u8bc1\u4e66\u751f\u6210\u4e2d...");
        loadingDialog.show();
        try {
            new a(loadingDialog).start();
        } catch (Exception e4) {
            e4.printStackTrace();
            new iOSOneButtonDialog(this.f1656h).setMessage("\u751f\u6210\u8bc1\u4e66\u5931\u8d25,\u8bf7\u7a0d\u540e\u518d\u8bd5").show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u67e5\u770b\u8bc1\u4e66");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21110k = (ImageView) findViewById(2131231382);
        this.f21111l = (Button) findViewById(2131231008);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f21112m;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f21112m.recycle();
            this.f21112m = null;
        }
        System.gc();
    }

    public Bitmap s0(Context mContext, int resourcesId, int width, int height) {
        InputStream openRawResource = mContext.getResources().openRawResource(resourcesId);
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i4 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(openRawResource, null, options);
        float f4 = options.outWidth;
        float f5 = options.outHeight;
        float f6 = height;
        if (f5 > f6 || f4 > width) {
            if (f4 > f5) {
                i4 = Math.round(f5 / f6);
            } else {
                i4 = Math.round(f4 / width);
            }
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i4;
        return BitmapFactory.decodeStream(openRawResource, null, options);
    }

    public void t0(Context context, Bitmap bmp) {
        new b(bmp, context).start();
    }
}
