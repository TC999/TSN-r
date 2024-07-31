package com.bxkj.student.home.physicaltest.calc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CalcResultActivity extends BaseActivity {

    /* renamed from: k */
    private RecyclerView f16437k;

    /* renamed from: l */
    private LinearLayout f16438l;

    /* renamed from: m */
    private LinearLayout f16439m;

    /* renamed from: n */
    private LinearLayout f16440n;

    /* renamed from: o */
    private LinearLayout f16441o;

    /* renamed from: p */
    private List<Map<String, Object>> f16442p = new ArrayList();

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f16443q;

    /* renamed from: com.bxkj.student.home.physicaltest.calc.CalcResultActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4343a extends CommonAdapter<Map<String, Object>> {
        C4343a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57874J(2131233221, JsonParse.getString(stringObjectMap, CommonNetImpl.RESULT));
            holder.m57874J(C4215R.C4219id.tv_scor, JsonParse.getString(stringObjectMap, "standard"));
            holder.m57874J(C4215R.C4219id.tv_ss, JsonParse.getString(stringObjectMap, "score"));
            holder.m57874J(C4215R.C4219id.tv_level, JsonParse.getString(stringObjectMap, "level"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.calc.CalcResultActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4344b implements UMShareListener {
        C4344b() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CalcResultActivity.this).f1669h, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t) {
            t.printStackTrace();
            Toast.makeText(((BaseActivity) CalcResultActivity.this).f1669h, " 分享失败啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CalcResultActivity.this).f1669h, " 分享成功啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* renamed from: m0 */
    private Bitmap m42627m0(Bitmap src, Bitmap watermark) {
        if (src == null) {
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        int width2 = watermark.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(width, height + width2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRGB(255, 255, 255);
        canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        int i = width - width2;
        canvas.drawBitmap(watermark, i, height, (Paint) null);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), 2131558826);
        canvas.drawBitmap(decodeResource, ((width / 5) * 2) - (decodeResource.getWidth() / 2), height - decodeResource.getHeight(), (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setTextSize(Tools.m57620a(20.0f, this.f1669h));
        Rect rect = new Rect();
        paint.getTextBounds("扫描右侧二维码", 0, 7, rect);
        int i2 = (i / 2) + 10;
        int i3 = height + 175;
        canvas.drawText("扫描右侧二维码", i2 - (rect.width() / 2), (i3 - (rect.height() / 2)) - rect.height(), paint);
        Rect rect2 = new Rect();
        paint.getTextBounds("下载体测成绩计算器", 0, 9, rect2);
        canvas.drawText("下载体测成绩计算器", i2 - (rect2.width() / 2), (i3 - (rect2.height() / 2)) + rect.height() + 10, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    /* renamed from: n0 */
    private void m42626n0(SHARE_MEDIA platform) {
        new ShareAction(this).setPlatform(platform).setCallback(new C4344b()).withMedia(new UMImage(this.f1669h, m42627m0(m42628l0(this.f16437k), BitmapFactory.decodeResource(getResources(), 2131559051)))).share();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16438l.setOnClickListener(this);
        this.f16439m.setOnClickListener(this);
        this.f16440n.setOnClickListener(this);
        this.f16441o.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_calc_result;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra(CommonNetImpl.f39534SM)) {
            this.f16442p = JsonParse.getList(((SeralizableMap) getIntent().getSerializableExtra(CommonNetImpl.f39534SM)).getMap(), "data");
        }
        HashMap hashMap = new HashMap(5);
        hashMap.put("name", "项目");
        hashMap.put(CommonNetImpl.RESULT, "成绩");
        hashMap.put("standard", "分数");
        hashMap.put("score", "比例分");
        hashMap.put("level", "等级");
        this.f16442p.add(0, hashMap);
        this.f16437k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4343a c4343a = new C4343a(this.f1669h, C4215R.C4221layout.item_for_calc_reslut, this.f16442p);
        this.f16443q = c4343a;
        this.f16437k.setAdapter(c4343a);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测成绩");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16437k = (RecyclerView) findViewById(2131232540);
        this.f16438l = (LinearLayout) findViewById(2131232234);
        this.f16439m = (LinearLayout) findViewById(2131232204);
        this.f16440n = (LinearLayout) findViewById(2131232213);
        this.f16441o = (LinearLayout) findViewById(2131232215);
    }

    /* renamed from: l0 */
    public Bitmap m42628l0(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case 2131232204:
                m42626n0(SHARE_MEDIA.WEIXIN_CIRCLE);
                return;
            case 2131232213:
                m42626n0(SHARE_MEDIA.QQ);
                return;
            case 2131232215:
                m42626n0(SHARE_MEDIA.QZONE);
                return;
            case 2131232234:
                m42626n0(SHARE_MEDIA.WEIXIN);
                return;
            default:
                return;
        }
    }
}
