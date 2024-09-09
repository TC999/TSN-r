package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.b.e;
import com.tencent.open.b.h;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ImageActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f51435a;

    /* renamed from: b  reason: collision with root package name */
    private QQToken f51436b;

    /* renamed from: c  reason: collision with root package name */
    private String f51437c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f51438d;

    /* renamed from: e  reason: collision with root package name */
    private c f51439e;

    /* renamed from: f  reason: collision with root package name */
    private Button f51440f;

    /* renamed from: g  reason: collision with root package name */
    private Button f51441g;

    /* renamed from: h  reason: collision with root package name */
    private b f51442h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f51443i;

    /* renamed from: j  reason: collision with root package name */
    private ProgressBar f51444j;

    /* renamed from: r  reason: collision with root package name */
    private String f51452r;

    /* renamed from: s  reason: collision with root package name */
    private Bitmap f51453s;

    /* renamed from: k  reason: collision with root package name */
    private int f51445k = 0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f51446l = false;

    /* renamed from: m  reason: collision with root package name */
    private long f51447m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f51448n = 0;

    /* renamed from: o  reason: collision with root package name */
    private final int f51449o = 640;

    /* renamed from: p  reason: collision with root package name */
    private final int f51450p = 640;

    /* renamed from: q  reason: collision with root package name */
    private Rect f51451q = new Rect();

    /* renamed from: t  reason: collision with root package name */
    private final View.OnClickListener f51454t = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f51444j.setVisibility(0);
            ImageActivity.this.f51441g.setEnabled(false);
            ImageActivity.this.f51441g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f51440f.setEnabled(false);
            ImageActivity.this.f51440f.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageActivity.this.c();
                }
            }).start();
            if (ImageActivity.this.f51446l) {
                ImageActivity.this.a("10657", 0L);
                return;
            }
            ImageActivity.this.a("10655", System.currentTimeMillis() - ImageActivity.this.f51447m);
            if (ImageActivity.this.f51439e.f51475b) {
                ImageActivity.this.a("10654", 0L);
            }
        }
    };

    /* renamed from: u  reason: collision with root package name */
    private final View.OnClickListener f51455u = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.a("10656", System.currentTimeMillis() - ImageActivity.this.f51447m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.d();
        }
    };

    /* renamed from: v  reason: collision with root package name */
    private final IUiListener f51456v = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.f51441g.setEnabled(true);
            int i4 = -1;
            ImageActivity.this.f51441g.setTextColor(-1);
            ImageActivity.this.f51440f.setEnabled(true);
            ImageActivity.this.f51440f.setTextColor(-1);
            ImageActivity.this.f51444j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i4 = jSONObject.getInt("ret");
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (i4 == 0) {
                ImageActivity.this.a("\u8bbe\u7f6e\u6210\u529f", 0);
                ImageActivity.this.a("10658", 0L);
                e.a().a(ImageActivity.this.f51436b.getOpenId(), ImageActivity.this.f51436b.getAppId(), "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "3", "0");
                ImageActivity imageActivity = ImageActivity.this;
                if (imageActivity.f51437c != null && !"".equals(ImageActivity.this.f51437c)) {
                    Intent intent = new Intent();
                    intent.setClassName(imageActivity, ImageActivity.this.f51437c);
                    if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                        imageActivity.startActivity(intent);
                    }
                }
                ImageActivity.this.a(0, jSONObject.toString(), null, null);
                ImageActivity.this.d();
                return;
            }
            ImageActivity.this.a("\u8bbe\u7f6e\u51fa\u9519\u4e86\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u518d\u5c1d\u8bd5\u4e0b\u5462\uff1a\uff09", 1);
            e.a().a(ImageActivity.this.f51436b.getOpenId(), ImageActivity.this.f51436b.getAppId(), "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "19", "1");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f51441g.setEnabled(true);
            ImageActivity.this.f51441g.setTextColor(-1);
            ImageActivity.this.f51440f.setEnabled(true);
            ImageActivity.this.f51440f.setTextColor(-1);
            ImageActivity.this.f51440f.setText("\u91cd\u8bd5");
            ImageActivity.this.f51444j.setVisibility(8);
            ImageActivity.this.f51446l = true;
            ImageActivity.this.a(uiError.errorMessage, 1);
            ImageActivity.this.a("10660", 0L);
        }
    };

    /* renamed from: w  reason: collision with root package name */
    private final IUiListener f51457w = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        private void a(int i4) {
            if (ImageActivity.this.f51445k < 2) {
                ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i4 = -1;
            try {
                i4 = jSONObject.getInt("ret");
                if (i4 == 0) {
                    final String string = jSONObject.getString("nickname");
                    ImageActivity.this.f51438d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageActivity.this.c(string);
                        }
                    });
                    ImageActivity.this.a("10659", 0L);
                } else {
                    ImageActivity.this.a("10661", 0L);
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (i4 != 0) {
                a(i4);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            a(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle a4 = a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            a4.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.f51502c, g.a(), "user/set_user_face", a4, "POST", tempRequestListener);
            e.a().a(this.f51502c.getOpenId(), this.f51502c.getAppId(), "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "19", "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a extends View {
        public a(Context context) {
            super(context);
        }

        public void a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b4 = ImageActivity.this.b("com.tencent.plus.blue_normal.png");
            Drawable b5 = ImageActivity.this.b("com.tencent.plus.blue_down.png");
            Drawable b6 = ImageActivity.this.b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b5);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b4);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b4);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b4);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b6);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b4 = ImageActivity.this.b("com.tencent.plus.gray_normal.png");
            Drawable b5 = ImageActivity.this.b("com.tencent.plus.gray_down.png");
            Drawable b6 = ImageActivity.this.b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b5);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b4);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b4);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b4);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b6);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.f51438d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra("key_params");
        this.f51452r = bundleExtra.getString("picture");
        this.f51437c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j4 = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f51448n = bundleExtra.getInt("exitAnim");
        QQToken qQToken = new QQToken(string);
        this.f51436b = qQToken;
        qQToken.setAccessToken(string2, ((j4 - System.currentTimeMillis()) / 1000) + "");
        this.f51436b.setOpenId(string3);
        b();
        e();
        this.f51447m = System.currentTimeMillis();
        a("10653", 0L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f51439e.setImageBitmap(null);
        Bitmap bitmap = this.f51453s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f51453s.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Matrix imageMatrix = this.f51439e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f4 = fArr[2];
        float f5 = fArr[5];
        float f6 = fArr[0];
        float width = 640.0f / this.f51451q.width();
        Rect rect = this.f51451q;
        int i4 = (int) ((rect.left - f4) / f6);
        int i5 = i4 < 0 ? 0 : i4;
        int i6 = (int) ((rect.top - f5) / f6);
        int i7 = i6 < 0 ? 0 : i6;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(width, width);
        int i8 = (int) (650.0f / f6);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f51453s, i5, i7, Math.min(this.f51453s.getWidth() - i5, i8), Math.min(this.f51453s.getHeight() - i7, i8), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 640, 640);
            createBitmap.recycle();
            a(createBitmap2);
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            a("\u56fe\u7247\u8bfb\u53d6\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u8be5\u56fe\u7247\u662f\u5426\u6709\u6548", 1);
            a(-5, null, "\u56fe\u7247\u8bfb\u53d6\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u8be5\u56fe\u7247\u662f\u5426\u6709\u6548", e4.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        finish();
        int i4 = this.f51448n;
        if (i4 != 0) {
            overridePendingTransition(0, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f51445k++;
        new UserInfo(this, this.f51436b).getUserInfo(this.f51457w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable b(String str) {
        return m.a(str, this);
    }

    private void b() {
        Bitmap a4;
        try {
            a4 = a(this.f51452r);
            this.f51453s = a4;
        } catch (IOException e4) {
            e4.printStackTrace();
            a("\u56fe\u7247\u8bfb\u53d6\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u8be5\u56fe\u7247\u662f\u5426\u6709\u6548", 1);
            a(-5, null, "\u56fe\u7247\u8bfb\u53d6\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u8be5\u56fe\u7247\u662f\u5426\u6709\u6548", e4.getMessage());
            d();
        }
        if (a4 != null) {
            this.f51439e.setImageBitmap(a4);
            this.f51440f.setOnClickListener(this.f51454t);
            this.f51441g.setOnClickListener(this.f51455u);
            this.f51435a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ImageActivity.this.f51435a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ImageActivity imageActivity = ImageActivity.this;
                    imageActivity.f51451q = imageActivity.f51442h.a();
                    ImageActivity.this.f51439e.a(ImageActivity.this.f51451q);
                }
            });
            return;
        }
        throw new IOException("cannot read picture: '" + this.f51452r + "'!");
    }

    private String d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    private Bitmap a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i4 = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
        }
        openInputStream.close();
        int i5 = options.outWidth;
        int i6 = options.outHeight;
        while (i5 * i6 > 4194304) {
            i5 /= 2;
            i6 /= 2;
            i4 *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i4;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e5) {
            e5.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i4) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
        if (i4 == 0) {
            imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String d4 = d(str);
        if ("".equals(d4)) {
            return;
        }
        this.f51443i.setText(d4);
        this.f51443i.setVisibility(0);
    }

    private View a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f51435a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f51435a.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.f51435a.addView(relativeLayout2);
        c cVar = new c(this);
        this.f51439e = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.f51439e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.f51439e);
        this.f51442h = new b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f51442h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.f51442h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f51435a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f51443i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f51443i.setLayoutParams(layoutParams6);
        this.f51443i.setEllipsize(TextUtils.TruncateAt.END);
        this.f51443i.setSingleLine();
        this.f51443i.setTextColor(-1);
        this.f51443i.setTextSize(24.0f);
        this.f51443i.setVisibility(8);
        linearLayout.addView(this.f51443i);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int a4 = com.tencent.connect.avatar.a.a(this, 10.0f);
        relativeLayout3.setPadding(a4, a4, a4, 0);
        this.f51435a.addView(relativeLayout3);
        a aVar = new a(this);
        int a5 = com.tencent.connect.avatar.a.a(this, 14.0f);
        int a6 = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f51441g = new Button(this);
        this.f51441g.setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
        this.f51441g.setText("\u53d6\u6d88");
        this.f51441g.setTextColor(-1);
        this.f51441g.setTextSize(18.0f);
        this.f51441g.setPadding(a5, a6, a5, a6);
        aVar.b(this.f51441g);
        relativeLayout3.addView(this.f51441g);
        this.f51440f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f51440f.setLayoutParams(layoutParams8);
        this.f51440f.setTextColor(-1);
        this.f51440f.setTextSize(18.0f);
        this.f51440f.setPadding(a5, a6, a5, a6);
        this.f51440f.setText("\u9009\u53d6");
        aVar.a(this.f51440f);
        relativeLayout3.addView(this.f51440f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("\u79fb\u52a8\u548c\u7f29\u653e");
        textView.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.f51444j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f51444j.setLayoutParams(layoutParams10);
        this.f51444j.setVisibility(8);
        this.f51435a.addView(this.f51444j);
        return this.f51435a;
    }

    private void a(Bitmap bitmap) {
        new QQAvatarImp(this.f51436b).setAvator(bitmap, this.f51456v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i4) {
        this.f51438d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.b(str, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra("key_error_code", i4);
        intent.putExtra("key_error_msg", str2);
        intent.putExtra("key_error_detail", str3);
        intent.putExtra("key_response", str);
        setResult(-1, intent);
    }

    public void a(String str, long j4) {
        a(str, j4, this.f51436b.getAppId());
    }

    public static void a(String str, long j4, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("strValue", str2);
        hashMap.put("nValue", str);
        hashMap.put("qver", "3.5.13.lite");
        if (j4 != 0) {
            hashMap.put("elt", String.valueOf(j4));
        }
        h.a().a("https://cgi.qplus.com/report/report", hashMap);
    }
}
