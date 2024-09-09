package com.bxkj.student.home.physicaltest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AdmissionTicketActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f19736k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f19737l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19738m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f19739n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f19740o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f19741p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f19742q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f19743r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f19744s;

    /* renamed from: t  reason: collision with root package name */
    private ImageView f19745t;

    /* renamed from: u  reason: collision with root package name */
    private RecyclerView f19746u;

    /* renamed from: v  reason: collision with root package name */
    private SmartWebView f19747v;

    /* renamed from: w  reason: collision with root package name */
    private List<Map<String, Object>> f19748w;

    /* renamed from: x  reason: collision with root package name */
    private String f19749x;

    /* renamed from: y  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19750y;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "scheduleName"));
            holder.J(2131233166, "\u5f00\u59cb\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "beginTime"));
            holder.J(2131232954, "\u7ed3\u675f\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "endTime"));
            holder.J(2131232852, "\u9884\u7ea6\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "appTime"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends UniversalItemDecoration {
        b() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            if (position != AdmissionTicketActivity.this.f19750y.getItemCount()) {
                UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
                aVar.f19614d = u.a(1.0f, ((BaseActivity) AdmissionTicketActivity.this).f1656h);
                aVar.f19610f = ContextCompat.getColor(((BaseActivity) AdmissionTicketActivity.this).f1656h, 2131034204);
                return aVar;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AdmissionTicketActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AdmissionTicketActivity.this.R().setVisibility(0);
            AdmissionTicketActivity.this.t0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            AdmissionTicketActivity admissionTicketActivity = AdmissionTicketActivity.this;
            admissionTicketActivity.s0(admissionTicketActivity.f19749x);
        }
    }

    private void q0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).y1()).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(String imageUrl) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", new String[]{imageUrl});
        intent.putExtra("image_index", 1);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Map<String, Object> data) {
        TextView textView = this.f19736k;
        textView.setText("\u59d3\u540d\uff1a" + JsonParse.getString(data, "name"));
        TextView textView2 = this.f19737l;
        textView2.setText("\u5b66\u53f7\uff1a" + JsonParse.getString(data, "userNum"));
        TextView textView3 = this.f19738m;
        textView3.setText("\u6027\u522b\uff1a" + JsonParse.getString(data, "sex"));
        TextView textView4 = this.f19739n;
        textView4.setText("\u5e74\u7ea7\uff1a" + JsonParse.getString(data, "grade"));
        TextView textView5 = this.f19740o;
        textView5.setText("\u9662\u7cfb\uff1a" + JsonParse.getString(data, "dept"));
        TextView textView6 = this.f19741p;
        textView6.setText("\u4e13\u4e1a\uff1a" + JsonParse.getString(data, "major"));
        TextView textView7 = this.f19742q;
        textView7.setText("\u73ed\u7ea7\uff1a" + JsonParse.getString(data, "class"));
        String string = JsonParse.getString(data, "IDCard");
        if (!TextUtils.isEmpty(string)) {
            this.f19743r.setVisibility(0);
            this.f19743r.setText(string);
        }
        this.f19749x = JsonParse.getString(data, "collectPhoto");
        com.bumptech.glide.d.C(this.f1656h).a(this.f19749x).w0(2131558996).x(2131558996).i1(this.f19745t);
        r0(JsonParse.getString(data, "erWeiMaCode"));
        this.f19745t.setOnClickListener(new d());
        List<Map<String, Object>> list = JsonParse.getList(data, "meaInfo");
        this.f19748w = list;
        this.f19750y.g(list);
        this.f19747v.h(JsonParse.getString(data, "specification"));
        this.f19747v.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
    }

    private void u0(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = brightness;
        window.setAttributes(attributes);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427450;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        u0(this, 1.0f);
        R().setVisibility(8);
        this.f19750y = new a(this.f1656h, 2131427736, this.f19748w);
        this.f19746u.setLayoutManager(new LinearLayoutManager(this.f1656h));
        this.f19746u.setAdapter(this.f19750y);
        this.f19746u.addItemDecoration(new b());
        q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f53\u6d4b\u51c6\u8003\u8bc1");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19736k = (TextView) findViewById(2131233040);
        this.f19737l = (TextView) findViewById(2131233051);
        this.f19738m = (TextView) findViewById(2131233152);
        this.f19739n = (TextView) findViewById(2131232981);
        this.f19740o = (TextView) findViewById(2131233240);
        this.f19741p = (TextView) findViewById(2131233027);
        this.f19742q = (TextView) findViewById(2131232902);
        this.f19743r = (TextView) findViewById(2131233001);
        this.f19744s = (ImageView) findViewById(2131231475);
        this.f19745t = (ImageView) findViewById(2131231495);
        this.f19746u = (RecyclerView) findViewById(2131232549);
        this.f19747v = (SmartWebView) findViewById(2131232694);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        u0(this, -1.0f);
        super.onDestroy();
    }

    public Bitmap p0(String text, int size, Bitmap mBitmap) {
        try {
            int i4 = size / 10;
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "UTF-8");
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

    public void r0(String cardNum) {
        this.f19744s.setImageBitmap(p0(cardNum, u.a(200.0f, this.f1656h), BitmapFactory.decodeResource(getResources(), 2131558617)));
    }
}
