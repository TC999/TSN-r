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
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.p566b.C13014e;
import com.tencent.open.p566b.C13017h;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13071m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ImageActivity extends Activity {

    /* renamed from: a */
    RelativeLayout f37069a;

    /* renamed from: b */
    private QQToken f37070b;

    /* renamed from: c */
    private String f37071c;

    /* renamed from: d */
    private Handler f37072d;

    /* renamed from: e */
    private C12961c f37073e;

    /* renamed from: f */
    private Button f37074f;

    /* renamed from: g */
    private Button f37075g;

    /* renamed from: h */
    private C12960b f37076h;

    /* renamed from: i */
    private TextView f37077i;

    /* renamed from: j */
    private ProgressBar f37078j;

    /* renamed from: r */
    private String f37086r;

    /* renamed from: s */
    private Bitmap f37087s;

    /* renamed from: k */
    private int f37079k = 0;

    /* renamed from: l */
    private boolean f37080l = false;

    /* renamed from: m */
    private long f37081m = 0;

    /* renamed from: n */
    private int f37082n = 0;

    /* renamed from: o */
    private final int f37083o = 640;

    /* renamed from: p */
    private final int f37084p = 640;

    /* renamed from: q */
    private Rect f37085q = new Rect();

    /* renamed from: t */
    private final View.OnClickListener f37088t = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f37078j.setVisibility(0);
            ImageActivity.this.f37075g.setEnabled(false);
            ImageActivity.this.f37075g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f37074f.setEnabled(false);
            ImageActivity.this.f37074f.setTextColor(Color.rgb(36, 94, (int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE));
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageActivity.this.m15355c();
                }
            }).start();
            if (ImageActivity.this.f37080l) {
                ImageActivity.this.m15363a("10657", 0L);
                return;
            }
            ImageActivity.this.m15363a("10655", System.currentTimeMillis() - ImageActivity.this.f37081m);
            if (ImageActivity.this.f37073e.f37109b) {
                ImageActivity.this.m15363a("10654", 0L);
            }
        }
    };

    /* renamed from: u */
    private final View.OnClickListener f37089u = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.m15363a("10656", System.currentTimeMillis() - ImageActivity.this.f37081m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.m15352d();
        }
    };

    /* renamed from: v */
    private final IUiListener f37090v = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.f37075g.setEnabled(true);
            int i = -1;
            ImageActivity.this.f37075g.setTextColor(-1);
            ImageActivity.this.f37074f.setEnabled(true);
            ImageActivity.this.f37074f.setTextColor(-1);
            ImageActivity.this.f37078j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i = jSONObject.getInt("ret");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                ImageActivity.this.m15364a("设置成功", 0);
                ImageActivity.this.m15363a("10658", 0L);
                C13014e.m15176a().m15174a(ImageActivity.this.f37070b.getOpenId(), ImageActivity.this.f37070b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, "3", "0");
                ImageActivity imageActivity = ImageActivity.this;
                if (imageActivity.f37071c != null && !"".equals(ImageActivity.this.f37071c)) {
                    Intent intent = new Intent();
                    intent.setClassName(imageActivity, ImageActivity.this.f37071c);
                    if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                        imageActivity.startActivity(intent);
                    }
                }
                ImageActivity.this.m15373a(0, jSONObject.toString(), null, null);
                ImageActivity.this.m15352d();
                return;
            }
            ImageActivity.this.m15364a("设置出错了，请重新登录再尝试下呢：）", 1);
            C13014e.m15176a().m15174a(ImageActivity.this.f37070b.getOpenId(), ImageActivity.this.f37070b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "1");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f37075g.setEnabled(true);
            ImageActivity.this.f37075g.setTextColor(-1);
            ImageActivity.this.f37074f.setEnabled(true);
            ImageActivity.this.f37074f.setTextColor(-1);
            ImageActivity.this.f37074f.setText("重试");
            ImageActivity.this.f37078j.setVisibility(8);
            ImageActivity.this.f37080l = true;
            ImageActivity.this.m15364a(uiError.errorMessage, 1);
            ImageActivity.this.m15363a("10660", 0L);
        }
    };

    /* renamed from: w */
    private final IUiListener f37091w = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        /* renamed from: a */
        private void m15337a(int i) {
            if (ImageActivity.this.f37079k < 2) {
                ImageActivity.this.m15349e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i = -1;
            try {
                i = jSONObject.getInt("ret");
                if (i == 0) {
                    final String string = jSONObject.getString("nickname");
                    ImageActivity.this.f37072d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageActivity.this.m15353c(string);
                        }
                    });
                    ImageActivity.this.m15363a("10659", 0L);
                } else {
                    ImageActivity.this.m15363a("10661", 0L);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i != 0) {
                m15337a(i);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            m15337a(0);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle m15318a = m15318a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            m15318a.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.f37136c, C13061g.m15027a(), "user/set_user_face", m15318a, "POST", tempRequestListener);
            C13014e.m15176a().m15174a(this.f37136c.getOpenId(), this.f37136c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.avatar.ImageActivity$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12958a extends View {
        public C12958a(Context context) {
            super(context);
        }

        /* renamed from: a */
        public void m15336a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable m15357b = ImageActivity.this.m15357b("com.tencent.plus.blue_normal.png");
            Drawable m15357b2 = ImageActivity.this.m15357b("com.tencent.plus.blue_down.png");
            Drawable m15357b3 = ImageActivity.this.m15357b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, m15357b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, m15357b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, m15357b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, m15357b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, m15357b3);
            button.setBackgroundDrawable(stateListDrawable);
        }

        /* renamed from: b */
        public void m15335b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable m15357b = ImageActivity.this.m15357b("com.tencent.plus.gray_normal.png");
            Drawable m15357b2 = ImageActivity.this.m15357b("com.tencent.plus.gray_down.png");
            Drawable m15357b3 = ImageActivity.this.m15357b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, m15357b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, m15357b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, m15357b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, m15357b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, m15357b3);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        m15352d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(m15374a());
        this.f37072d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.f37086r = bundleExtra.getString("picture");
        this.f37071c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f37082n = bundleExtra.getInt("exitAnim");
        QQToken qQToken = new QQToken(string);
        this.f37070b = qQToken;
        qQToken.setAccessToken(string2, ((j - System.currentTimeMillis()) / 1000) + "");
        this.f37070b.setOpenId(string3);
        m15361b();
        m15349e();
        this.f37081m = System.currentTimeMillis();
        m15363a("10653", 0L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f37073e.setImageBitmap(null);
        Bitmap bitmap = this.f37087s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f37087s.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15355c() {
        Matrix imageMatrix = this.f37073e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = 640.0f / this.f37085q.width();
        Rect rect = this.f37085q;
        int i = (int) ((rect.left - f) / f3);
        int i2 = i < 0 ? 0 : i;
        int i3 = (int) ((rect.top - f2) / f3);
        int i4 = i3 < 0 ? 0 : i3;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(width, width);
        int i5 = (int) (650.0f / f3);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f37087s, i2, i4, Math.min(this.f37087s.getWidth() - i2, i5), Math.min(this.f37087s.getHeight() - i4, i5), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 640, 640);
            createBitmap.recycle();
            m15372a(createBitmap2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            m15364a(Constants.MSG_IMAGE_ERROR, 1);
            m15373a(-5, null, Constants.MSG_IMAGE_ERROR, e.getMessage());
            m15352d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m15352d() {
        finish();
        int i = this.f37082n;
        if (i != 0) {
            overridePendingTransition(0, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m15349e() {
        this.f37079k++;
        new UserInfo(this, this.f37070b).getUserInfo(this.f37091w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Drawable m15357b(String str) {
        return C13071m.m14956a(str, this);
    }

    /* renamed from: b */
    private void m15361b() {
        Bitmap m15365a;
        try {
            m15365a = m15365a(this.f37086r);
            this.f37087s = m15365a;
        } catch (IOException e) {
            e.printStackTrace();
            m15364a(Constants.MSG_IMAGE_ERROR, 1);
            m15373a(-5, null, Constants.MSG_IMAGE_ERROR, e.getMessage());
            m15352d();
        }
        if (m15365a != null) {
            this.f37073e.setImageBitmap(m15365a);
            this.f37074f.setOnClickListener(this.f37088t);
            this.f37075g.setOnClickListener(this.f37089u);
            this.f37069a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ImageActivity.this.f37069a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ImageActivity imageActivity = ImageActivity.this;
                    imageActivity.f37085q = imageActivity.f37076h.m15330a();
                    ImageActivity.this.f37073e.m15326a(ImageActivity.this.f37085q);
                }
            });
            return;
        }
        throw new IOException("cannot read picture: '" + this.f37086r + "'!");
    }

    /* renamed from: d */
    private String m15350d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    /* renamed from: a */
    private Bitmap m15365a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        openInputStream.close();
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        while (i2 * i3 > 4194304) {
            i2 /= 2;
            i3 /= 2;
            i *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15356b(String str, int i) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(C12959a.m15331a(this, 16.0f), C12959a.m15331a(this, 16.0f)));
        if (i == 0) {
            imageView.setImageDrawable(m15357b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(m15357b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15353c(String str) {
        String m15350d = m15350d(str);
        if ("".equals(m15350d)) {
            return;
        }
        this.f37077i.setText(m15350d);
        this.f37077i.setVisibility(0);
    }

    /* renamed from: a */
    private View m15374a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f37069a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f37069a.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.f37069a.addView(relativeLayout2);
        C12961c c12961c = new C12961c(this);
        this.f37073e = c12961c;
        c12961c.setLayoutParams(layoutParams2);
        this.f37073e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.f37073e);
        this.f37076h = new C12960b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f37076h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.f37076h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, C12959a.m15331a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f37069a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(C12959a.m15331a(this, 24.0f), C12959a.m15331a(this, 24.0f)));
        imageView.setImageDrawable(m15357b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f37077i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = C12959a.m15331a(this, 7.0f);
        this.f37077i.setLayoutParams(layoutParams6);
        this.f37077i.setEllipsize(TextUtils.TruncateAt.END);
        this.f37077i.setSingleLine();
        this.f37077i.setTextColor(-1);
        this.f37077i.setTextSize(24.0f);
        this.f37077i.setVisibility(8);
        linearLayout.addView(this.f37077i);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, C12959a.m15331a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(m15357b("com.tencent.plus.bar.png"));
        int m15331a = C12959a.m15331a(this, 10.0f);
        relativeLayout3.setPadding(m15331a, m15331a, m15331a, 0);
        this.f37069a.addView(relativeLayout3);
        C12958a c12958a = new C12958a(this);
        int m15331a2 = C12959a.m15331a(this, 14.0f);
        int m15331a3 = C12959a.m15331a(this, 7.0f);
        this.f37075g = new Button(this);
        this.f37075g.setLayoutParams(new RelativeLayout.LayoutParams(C12959a.m15331a(this, 78.0f), C12959a.m15331a(this, 45.0f)));
        this.f37075g.setText("取消");
        this.f37075g.setTextColor(-1);
        this.f37075g.setTextSize(18.0f);
        this.f37075g.setPadding(m15331a2, m15331a3, m15331a2, m15331a3);
        c12958a.m15335b(this.f37075g);
        relativeLayout3.addView(this.f37075g);
        this.f37074f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(C12959a.m15331a(this, 78.0f), C12959a.m15331a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f37074f.setLayoutParams(layoutParams8);
        this.f37074f.setTextColor(-1);
        this.f37074f.setTextSize(18.0f);
        this.f37074f.setPadding(m15331a2, m15331a3, m15331a2, m15331a3);
        this.f37074f.setText("选取");
        c12958a.m15336a(this.f37074f);
        relativeLayout3.addView(this.f37074f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, C12959a.m15331a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.f37078j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f37078j.setLayoutParams(layoutParams10);
        this.f37078j.setVisibility(8);
        this.f37069a.addView(this.f37078j);
        return this.f37069a;
    }

    /* renamed from: a */
    private void m15372a(Bitmap bitmap) {
        new QQAvatarImp(this.f37070b).setAvator(bitmap, this.f37090v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15364a(final String str, final int i) {
        this.f37072d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.m15356b(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15373a(int i, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    /* renamed from: a */
    public void m15363a(String str, long j) {
        m15362a(str, j, this.f37070b.getAppId());
    }

    /* renamed from: a */
    public static void m15362a(String str, long j, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("strValue", str2);
        hashMap.put("nValue", str);
        hashMap.put("qver", Constants.SDK_VERSION);
        if (j != 0) {
            hashMap.put("elt", String.valueOf(j));
        }
        C13017h.m15165a().m15158a("https://cgi.qplus.com/report/report", hashMap);
    }
}
