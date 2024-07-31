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
import androidx.core.view.ViewCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.lesson.CertificateActivity;
import java.io.InputStream;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CertificateActivity extends BaseActivity {

    /* renamed from: k */
    private ImageView f17772k;

    /* renamed from: l */
    private Button f17773l;

    /* renamed from: m */
    private Bitmap f17774m;

    /* renamed from: n */
    private String f17775n;

    /* renamed from: o */
    private float f17776o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.CertificateActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4782a extends Thread {

        /* renamed from: a */
        final /* synthetic */ LoadingDialog f17777a;

        C4782a(final LoadingDialog val$loadingDialog) {
            this.f17777a = val$loadingDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m41349b(LoadingDialog loadingDialog) {
            loadingDialog.dismiss();
            CertificateActivity.this.f17773l.setVisibility(0);
            CertificateActivity.this.f17772k.setImageBitmap(CertificateActivity.this.f17774m);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Bitmap decodeResource = BitmapFactory.decodeResource(CertificateActivity.this.getResources(), C4215R.mipmap.certificate_bg);
            CertificateActivity certificateActivity = CertificateActivity.this;
            certificateActivity.f17774m = certificateActivity.m41355p0(decodeResource);
            CertificateActivity certificateActivity2 = CertificateActivity.this;
            final LoadingDialog loadingDialog = this.f17777a;
            certificateActivity2.runOnUiThread(new Runnable() { // from class: com.bxkj.student.home.teaching.lesson.b
                @Override // java.lang.Runnable
                public final void run() {
                    CertificateActivity.C4782a.this.m41349b(loadingDialog);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.CertificateActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4783b extends Thread {

        /* renamed from: a */
        final /* synthetic */ Bitmap f17779a;

        /* renamed from: b */
        final /* synthetic */ Context f17780b;

        C4783b(final Bitmap val$bmp, final Context val$context) {
            this.f17779a = val$bmp;
            this.f17780b = val$context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m41347b() {
            Toast.makeText(((BaseActivity) CertificateActivity.this).f1669h, "已成功保存到相册", 0).show();
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
                android.graphics.Bitmap r0 = r6.f17779a     // Catch: java.io.IOException -> L4a java.io.FileNotFoundException -> L4c java.lang.Throwable -> L95
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
                android.content.Context r0 = r6.f17780b
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
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.home.teaching.lesson.CertificateActivity.C4783b.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public Bitmap m41355p0(Bitmap src) {
        Bitmap decodeResource;
        Bitmap decodeResource2;
        Bitmap decodeResource3;
        if (src == null) {
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        float f = width;
        float f2 = f / 2480;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRGB(255, 255, 255);
        canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        float f3 = f / 2.0f;
        float f4 = 234.0f * f2;
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), C4215R.mipmap.certificate_top_logo), f3 - (decodeResource.getWidth() / 2.0f), f4, (Paint) null);
        float height2 = f4 + decodeResource.getHeight() + (73.0f * f2);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), C4215R.mipmap.certificate_top_school), f3 - (decodeResource2.getWidth() / 2.0f), height2, (Paint) null);
        float height3 = height2 + decodeResource2.getHeight() + (266.0f * f2);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), C4215R.mipmap.certificate_top_level), f3 - (decodeResource3.getWidth() / 2.0f), height3, (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize(Tools.m57620a(36.0f, this.f1669h));
        paint.setUnderlineText(true);
        Rect rect = new Rect();
        String realName = LoginUser.getLoginUser().getRealName();
        paint.getTextBounds(realName, 0, realName.length(), rect);
        float f5 = 388.0f * f2;
        float height4 = height3 + decodeResource3.getHeight() + (302.0f * f2);
        canvas.drawText(realName, f5, height4, paint);
        Rect rect2 = new Rect();
        paint.setUnderlineText(false);
        paint.getTextBounds("同学：", 0, 3, rect2);
        canvas.drawText("同学：", rect.width() + f5, height4, paint);
        Bitmap decodeResource4 = BitmapFactory.decodeResource(getResources(), C4215R.mipmap.certificate_bottom_deal);
        Rect rect3 = new Rect();
        paint.setUnderlineText(false);
        paint.setTextSize(Tools.m57620a(30.0f, this.f1669h));
        String schoolName = LoginUser.getLoginUser().getSchoolName();
        paint.getTextBounds(schoolName, 0, schoolName.length(), rect3);
        float f6 = 1103.0f * f2;
        float f7 = height - (440.0f * f2);
        canvas.drawText(schoolName, ((decodeResource4.getWidth() / 2.0f) + f6) - (rect3.width() / 2.0f), f7 - (decodeResource4.getHeight() / 2.0f), paint);
        Rect rect4 = new Rect();
        paint.setUnderlineText(false);
        paint.setTextSize(Tools.m57620a(30.0f, this.f1669h));
        paint.getTextBounds("体育部", 0, 3, rect4);
        canvas.drawText("体育部", ((decodeResource4.getWidth() / 2.0f) + f6) - (rect4.width() / 2.0f), (f7 - (decodeResource4.getHeight() / 2.0f)) + rect3.height(), paint);
        canvas.drawBitmap(decodeResource4, f6, f7 - decodeResource4.getHeight(), (Paint) null);
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setTextSize(Tools.m57620a(36.0f, this.f1669h));
        StaticLayout staticLayout = new StaticLayout("\u3000\u3000参加" + this.f17775n + "班学习，经考核" + m41354q0(this.f17776o) + "，特发此证！", textPaint, (int) ((f - f5) - (450.0f * f2)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        canvas.translate(f5, height4 + rect2.height() + (f2 * 120.0f));
        staticLayout.draw(canvas);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    /* renamed from: q0 */
    private String m41354q0(float score) {
        return score >= 90.0f ? "优秀" : score >= 80.0f ? "良好" : score >= 60.0f ? "合格" : "无证书";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void m41353r0(View view) {
        m41351t0(this.f1669h, this.f17774m);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17773l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateActivity.this.m41353r0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_certificate;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("lessonName")) {
            this.f17775n = getIntent().getStringExtra("lessonName");
        }
        if (getIntent().hasExtra("score")) {
            this.f17776o = getIntent().getFloatExtra("score", 0.0f);
        }
        LoadingDialog loadingDialog = new LoadingDialog(this.f1669h);
        loadingDialog.setMessage("证书生成中...");
        loadingDialog.show();
        try {
            new C4782a(loadingDialog).start();
        } catch (Exception e) {
            e.printStackTrace();
            new iOSOneButtonDialog(this.f1669h).setMessage("生成证书失败,请稍后再试").show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("查看证书");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17772k = (ImageView) findViewById(C4215R.C4219id.f15999iv);
        this.f17773l = (Button) findViewById(C4215R.C4219id.bt_save);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f17774m;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f17774m.recycle();
            this.f17774m = null;
        }
        System.gc();
    }

    /* renamed from: s0 */
    public Bitmap m41352s0(Context mContext, int resourcesId, int width, int height) {
        InputStream openRawResource = mContext.getResources().openRawResource(resourcesId);
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(openRawResource, null, options);
        float f = options.outWidth;
        float f2 = options.outHeight;
        float f3 = height;
        if (f2 > f3 || f > width) {
            if (f > f2) {
                i = Math.round(f2 / f3);
            } else {
                i = Math.round(f / width);
            }
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        return BitmapFactory.decodeStream(openRawResource, null, options);
    }

    /* renamed from: t0 */
    public void m41351t0(Context context, Bitmap bmp) {
        new C4783b(bmp, context).start();
    }
}
