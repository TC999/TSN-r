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
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bumptech.glide.Glide;
import com.bxkj.student.C4215R;
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
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AdmissionTicketActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f16346k;

    /* renamed from: l */
    private TextView f16347l;

    /* renamed from: m */
    private TextView f16348m;

    /* renamed from: n */
    private TextView f16349n;

    /* renamed from: o */
    private TextView f16350o;

    /* renamed from: p */
    private TextView f16351p;

    /* renamed from: q */
    private TextView f16352q;

    /* renamed from: r */
    private TextView f16353r;

    /* renamed from: s */
    private ImageView f16354s;

    /* renamed from: t */
    private ImageView f16355t;

    /* renamed from: u */
    private RecyclerView f16356u;

    /* renamed from: v */
    private SmartWebView f16357v;

    /* renamed from: w */
    private List<Map<String, Object>> f16358w;

    /* renamed from: x */
    private String f16359x;

    /* renamed from: y */
    private CommonAdapter<Map<String, Object>> f16360y;

    /* renamed from: com.bxkj.student.home.physicaltest.AdmissionTicketActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4321a extends CommonAdapter<Map<String, Object>> {
        C4321a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "scheduleName"));
            holder.m57874J(2131233166, "开始时间：" + JsonParse.getString(stringObjectMap, "beginTime"));
            holder.m57874J(C4215R.C4219id.tv_end_time, "结束时间：" + JsonParse.getString(stringObjectMap, "endTime"));
            holder.m57874J(C4215R.C4219id.tv_appointment_time, "预约时间：" + JsonParse.getString(stringObjectMap, "appTime"));
        }
    }

    /* renamed from: com.bxkj.student.home.physicaltest.AdmissionTicketActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4322b extends UniversalItemDecoration {
        C4322b() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        /* renamed from: a */
        public UniversalItemDecoration.AbstractC4246b mo40391a(int position) {
            if (position != AdmissionTicketActivity.this.f16360y.getItemCount()) {
                UniversalItemDecoration.C4245a c4245a = new UniversalItemDecoration.C4245a();
                c4245a.f16215d = Tools.m57620a(1.0f, ((BaseActivity) AdmissionTicketActivity.this).f1669h);
                c4245a.f16211f = ContextCompat.getColor(((BaseActivity) AdmissionTicketActivity.this).f1669h, C4215R.C4217color.defaultBackgroundColor);
                return c4245a;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.AdmissionTicketActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4323c extends HttpCallBack {
        C4323c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AdmissionTicketActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AdmissionTicketActivity.this.m57932R().setVisibility(0);
            AdmissionTicketActivity.this.m42683t0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.AdmissionTicketActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4324d implements View.OnClickListener {
        View$OnClickListenerC4324d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            AdmissionTicketActivity admissionTicketActivity = AdmissionTicketActivity.this;
            admissionTicketActivity.m42684s0(admissionTicketActivity.f16359x);
        }
    }

    /* renamed from: q0 */
    private void m42686q0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m55y1()).setDataListener(new C4323c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m42684s0(String imageUrl) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, new String[]{imageUrl});
        intent.putExtra(ImagePagerActivity.f1868g, 1);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m42683t0(Map<String, Object> data) {
        TextView textView = this.f16346k;
        textView.setText("姓名：" + JsonParse.getString(data, "name"));
        TextView textView2 = this.f16347l;
        textView2.setText("学号：" + JsonParse.getString(data, "userNum"));
        TextView textView3 = this.f16348m;
        textView3.setText("性别：" + JsonParse.getString(data, "sex"));
        TextView textView4 = this.f16349n;
        textView4.setText("年级：" + JsonParse.getString(data, "grade"));
        TextView textView5 = this.f16350o;
        textView5.setText("院系：" + JsonParse.getString(data, "dept"));
        TextView textView6 = this.f16351p;
        textView6.setText("专业：" + JsonParse.getString(data, "major"));
        TextView textView7 = this.f16352q;
        textView7.setText("班级：" + JsonParse.getString(data, "class"));
        String string = JsonParse.getString(data, "IDCard");
        if (!TextUtils.isEmpty(string)) {
            this.f16353r.setVisibility(0);
            this.f16353r.setText(string);
        }
        this.f16359x = JsonParse.getString(data, "collectPhoto");
        Glide.m45751C(this.f1669h).mo45507a(this.f16359x).m44601w0(2131558996).m44600x(2131558996).m45551i1(this.f16355t);
        m42685r0(JsonParse.getString(data, "erWeiMaCode"));
        this.f16355t.setOnClickListener(new View$OnClickListenerC4324d());
        List<Map<String, Object>> list = JsonParse.getList(data, "meaInfo");
        this.f16358w = list;
        this.f16360y.m57836g(list);
        this.f16357v.m57495h(JsonParse.getString(data, "specification"));
        this.f16357v.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
    }

    /* renamed from: u0 */
    private void m42682u0(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = brightness;
        window.setAttributes(attributes);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_physical_exam_admission_ticket;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m42682u0(this, 1.0f);
        m57932R().setVisibility(8);
        this.f16360y = new C4321a(this.f1669h, C4215R.C4221layout.item_for_physical_exam_admission_ticket, this.f16358w);
        this.f16356u.setLayoutManager(new LinearLayoutManager(this.f1669h));
        this.f16356u.setAdapter(this.f16360y);
        this.f16356u.addItemDecoration(new C4322b());
        m42686q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测准考证");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16346k = (TextView) findViewById(2131233040);
        this.f16347l = (TextView) findViewById(2131233051);
        this.f16348m = (TextView) findViewById(2131233152);
        this.f16349n = (TextView) findViewById(2131232981);
        this.f16350o = (TextView) findViewById(2131233240);
        this.f16351p = (TextView) findViewById(2131233027);
        this.f16352q = (TextView) findViewById(2131232902);
        this.f16353r = (TextView) findViewById(C4215R.C4219id.tv_idcard);
        this.f16354s = (ImageView) findViewById(2131231475);
        this.f16355t = (ImageView) findViewById(2131231495);
        this.f16356u = (RecyclerView) findViewById(C4215R.C4219id.rv_list);
        this.f16357v = (SmartWebView) findViewById(2131232694);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m42682u0(this, -1.0f);
        super.onDestroy();
    }

    /* renamed from: p0 */
    public Bitmap m42687p0(String text, int size, Bitmap mBitmap) {
        try {
            int i = size / 10;
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "UTF-8");
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

    /* renamed from: r0 */
    public void m42685r0(String cardNum) {
        this.f16354s.setImageBitmap(m42687p0(cardNum, Tools.m57620a(200.0f, this.f1669h), BitmapFactory.decodeResource(getResources(), 2131558617)));
    }
}
