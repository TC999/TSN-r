package com.bxkj.competition.electronicentry;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bumptech.glide.d;
import com.bumptech.glide.i;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ElectronicEntryActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f18927k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f18928l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f18929m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f18930n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f18931o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f18932p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f18933q;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f18934r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f18935s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f18936t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f18937u;

    /* renamed from: v  reason: collision with root package name */
    private String f18938v;

    /* renamed from: w  reason: collision with root package name */
    private String f18939w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ElectronicEntryActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ElectronicEntryActivity.this.R().setVisibility(0);
            ElectronicEntryActivity.this.q0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            ElectronicEntryActivity electronicEntryActivity = ElectronicEntryActivity.this;
            electronicEntryActivity.p0(electronicEntryActivity.f18939w);
        }
    }

    private void n0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).w(this.f18938v, LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(String imageUrl) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", new String[]{imageUrl});
        intent.putExtra("image_index", 1);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_ente, R.anim.zoom_exit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(Map<String, Object> data) {
        TextView textView = this.f18927k;
        textView.setText("\u59d3\u540d\uff1a" + JsonParse.getString(data, "userName"));
        TextView textView2 = this.f18928l;
        textView2.setText("\u5b66\u53f7\uff1a" + JsonParse.getString(data, "userNum"));
        TextView textView3 = this.f18929m;
        textView3.setText("\u6027\u522b\uff1a" + JsonParse.getString(data, "sex"));
        TextView textView4 = this.f18930n;
        textView4.setText("\u5e74\u7ea7\uff1a" + JsonParse.getString(data, "nj"));
        TextView textView5 = this.f18931o;
        textView5.setText("\u9662\u7cfb\uff1a" + JsonParse.getString(data, "yx"));
        TextView textView6 = this.f18932p;
        textView6.setText("\u4e13\u4e1a\uff1a" + JsonParse.getString(data, "zy"));
        TextView textView7 = this.f18933q;
        textView7.setText("\u73ed\u7ea7\uff1a" + JsonParse.getString(data, "bj"));
        TextView textView8 = this.f18937u;
        textView8.setText("\u53f7\u7801\uff1a" + JsonParse.getString(data, "cardNum"));
        this.f18939w = JsonParse.getString(data, "userImg");
        i<Drawable> a4 = d.C(this.f1656h).a(this.f18939w);
        int i4 = R.mipmap.student_img_default;
        a4.w0(i4).x(i4).i1(this.f18935s);
        o0(JsonParse.getString(data, "cardNum"));
        this.f18936t.setText(JsonParse.getString(data, "itemName"));
        this.f18935s.setOnClickListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_electronic_entry;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        this.f18938v = getIntent().getStringExtra("competitionId");
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7535\u5b50\u53c2\u8d5b\u8bc1");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f18927k = (TextView) findViewById(R.id.tv_name);
        this.f18928l = (TextView) findViewById(R.id.tv_number);
        this.f18929m = (TextView) findViewById(R.id.tv_sex);
        this.f18930n = (TextView) findViewById(R.id.tv_grade);
        this.f18931o = (TextView) findViewById(R.id.tv_yard);
        this.f18932p = (TextView) findViewById(R.id.tv_major);
        this.f18933q = (TextView) findViewById(R.id.tv_class);
        this.f18934r = (ImageView) findViewById(R.id.iv_qr_code);
        this.f18936t = (TextView) findViewById(R.id.tv_project);
        this.f18935s = (ImageView) findViewById(R.id.iv_student_image);
        this.f18937u = (TextView) findViewById(R.id.tv_NO);
    }

    public Bitmap m0(String text, int size, Bitmap mBitmap) {
        try {
            int i4 = size / 10;
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hashtable.put(EncodeHintType.MARGIN, 0);
            BitMatrix encode = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hashtable);
            int width = encode.getWidth();
            int i5 = width / 2;
            int height = encode.getHeight() / 2;
            Matrix matrix = new Matrix();
            float f4 = i4 * 2.0f;
            matrix.setScale(f4 / mBitmap.getWidth(), f4 / mBitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), matrix, false);
            int[] iArr = new int[size * size];
            for (int i6 = 0; i6 < size; i6++) {
                for (int i7 = 0; i7 < size; i7++) {
                    if (i7 > i5 - i4 && i7 < i5 + i4 && i6 > height - i4 && i6 < height + i4) {
                        iArr[(i6 * width) + i7] = createBitmap.getPixel((i7 - i5) + i4, (i6 - height) + i4);
                    } else if (encode.get(i7, i6)) {
                        iArr[(i6 * size) + i7] = -16777216;
                    } else {
                        iArr[(i6 * size) + i7] = -1;
                    }
                }
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            createBitmap2.setPixels(iArr, 0, size, 0, 0, size, size);
            return createBitmap2;
        } catch (WriterException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void o0(String cardNum) {
        this.f18934r.setImageBitmap(m0(cardNum, u.a(200.0f, this.f1656h), BitmapFactory.decodeResource(getResources(), R.mipmap.icon)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
