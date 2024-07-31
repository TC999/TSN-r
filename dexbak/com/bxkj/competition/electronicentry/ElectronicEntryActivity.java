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
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ElectronicEntryActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f15383k;

    /* renamed from: l */
    private TextView f15384l;

    /* renamed from: m */
    private TextView f15385m;

    /* renamed from: n */
    private TextView f15386n;

    /* renamed from: o */
    private TextView f15387o;

    /* renamed from: p */
    private TextView f15388p;

    /* renamed from: q */
    private TextView f15389q;

    /* renamed from: r */
    private ImageView f15390r;

    /* renamed from: s */
    private ImageView f15391s;

    /* renamed from: t */
    private TextView f15392t;

    /* renamed from: u */
    private TextView f15393u;

    /* renamed from: v */
    private String f15394v;

    /* renamed from: w */
    private String f15395w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.electronicentry.ElectronicEntryActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4034a extends HttpCallBack {
        C4034a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ElectronicEntryActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ElectronicEntryActivity.this.m57932R().setVisibility(0);
            ElectronicEntryActivity.this.m43408q0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.electronicentry.ElectronicEntryActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4035b implements View.OnClickListener {
        View$OnClickListenerC4035b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            ElectronicEntryActivity electronicEntryActivity = ElectronicEntryActivity.this;
            electronicEntryActivity.m43409p0(electronicEntryActivity.f15395w);
        }
    }

    /* renamed from: n0 */
    private void m43411n0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43434w(this.f15394v, LoginUser.getLoginUser().getUserId())).setDataListener(new C4034a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public void m43409p0(String imageUrl) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, new String[]{imageUrl});
        intent.putExtra(ImagePagerActivity.f1868g, 1);
        startActivity(intent);
        overridePendingTransition(C4017R.anim.zoom_ente, C4017R.anim.zoom_exit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void m43408q0(Map<String, Object> data) {
        TextView textView = this.f15383k;
        textView.setText("姓名：" + JsonParse.getString(data, "userName"));
        TextView textView2 = this.f15384l;
        textView2.setText("学号：" + JsonParse.getString(data, "userNum"));
        TextView textView3 = this.f15385m;
        textView3.setText("性别：" + JsonParse.getString(data, "sex"));
        TextView textView4 = this.f15386n;
        textView4.setText("年级：" + JsonParse.getString(data, "nj"));
        TextView textView5 = this.f15387o;
        textView5.setText("院系：" + JsonParse.getString(data, "yx"));
        TextView textView6 = this.f15388p;
        textView6.setText("专业：" + JsonParse.getString(data, "zy"));
        TextView textView7 = this.f15389q;
        textView7.setText("班级：" + JsonParse.getString(data, "bj"));
        TextView textView8 = this.f15393u;
        textView8.setText("号码：" + JsonParse.getString(data, "cardNum"));
        this.f15395w = JsonParse.getString(data, "userImg");
        RequestBuilder<Drawable> mo45507a = Glide.m45751C(this.f1669h).mo45507a(this.f15395w);
        int i = C4017R.mipmap.student_img_default;
        mo45507a.m44601w0(i).m44600x(i).m45551i1(this.f15391s);
        m43410o0(JsonParse.getString(data, "cardNum"));
        this.f15392t.setText(JsonParse.getString(data, "itemName"));
        this.f15391s.setOnClickListener(new View$OnClickListenerC4035b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_electronic_entry;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        this.f15394v = getIntent().getStringExtra("competitionId");
        m43411n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("电子参赛证");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15383k = (TextView) findViewById(C4017R.C4021id.tv_name);
        this.f15384l = (TextView) findViewById(C4017R.C4021id.tv_number);
        this.f15385m = (TextView) findViewById(C4017R.C4021id.tv_sex);
        this.f15386n = (TextView) findViewById(C4017R.C4021id.tv_grade);
        this.f15387o = (TextView) findViewById(C4017R.C4021id.tv_yard);
        this.f15388p = (TextView) findViewById(C4017R.C4021id.tv_major);
        this.f15389q = (TextView) findViewById(C4017R.C4021id.tv_class);
        this.f15390r = (ImageView) findViewById(C4017R.C4021id.iv_qr_code);
        this.f15392t = (TextView) findViewById(C4017R.C4021id.tv_project);
        this.f15391s = (ImageView) findViewById(C4017R.C4021id.iv_student_image);
        this.f15393u = (TextView) findViewById(C4017R.C4021id.tv_NO);
    }

    /* renamed from: m0 */
    public Bitmap m43412m0(String text, int size, Bitmap mBitmap) {
        try {
            int i = size / 10;
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hashtable.put(EncodeHintType.MARGIN, 0);
            BitMatrix encode = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hashtable);
            int width = encode.getWidth();
            int i2 = width / 2;
            int height = encode.getHeight() / 2;
            Matrix matrix = new Matrix();
            float f = i * 2.0f;
            matrix.setScale(f / mBitmap.getWidth(), f / mBitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), matrix, false);
            int[] iArr = new int[size * size];
            for (int i3 = 0; i3 < size; i3++) {
                for (int i4 = 0; i4 < size; i4++) {
                    if (i4 > i2 - i && i4 < i2 + i && i3 > height - i && i3 < height + i) {
                        iArr[(i3 * width) + i4] = createBitmap.getPixel((i4 - i2) + i, (i3 - height) + i);
                    } else if (encode.get(i4, i3)) {
                        iArr[(i3 * size) + i4] = -16777216;
                    } else {
                        iArr[(i3 * size) + i4] = -1;
                    }
                }
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            createBitmap2.setPixels(iArr, 0, size, 0, 0, size, size);
            return createBitmap2;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: o0 */
    public void m43410o0(String cardNum) {
        this.f15390r.setImageBitmap(m43412m0(cardNum, Tools.m57620a(200.0f, this.f1669h), BitmapFactory.decodeResource(getResources(), C4017R.mipmap.icon)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
