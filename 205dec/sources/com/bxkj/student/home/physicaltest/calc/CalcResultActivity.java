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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.JsonParse;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CalcResultActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f19827k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f19828l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f19829m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f19830n;

    /* renamed from: o  reason: collision with root package name */
    private LinearLayout f19831o;

    /* renamed from: p  reason: collision with root package name */
    private List<Map<String, Object>> f19832p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19833q;

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
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.J(2131233221, JsonParse.getString(stringObjectMap, "result"));
            holder.J(2131233145, JsonParse.getString(stringObjectMap, "standard"));
            holder.J(2131233164, JsonParse.getString(stringObjectMap, "score"));
            holder.J(2131233015, JsonParse.getString(stringObjectMap, "level"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements UMShareListener {
        b() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CalcResultActivity.this).f1656h, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t3) {
            t3.printStackTrace();
            Toast.makeText(((BaseActivity) CalcResultActivity.this).f1656h, " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CalcResultActivity.this).f1656h, " \u5206\u4eab\u6210\u529f\u5566", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    private Bitmap m0(Bitmap src, Bitmap watermark) {
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
        int i4 = width - width2;
        canvas.drawBitmap(watermark, i4, height, (Paint) null);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), 2131558826);
        canvas.drawBitmap(decodeResource, ((width / 5) * 2) - (decodeResource.getWidth() / 2), height - decodeResource.getHeight(), (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(-65536);
        paint.setTextSize(u.a(20.0f, this.f1656h));
        Rect rect = new Rect();
        paint.getTextBounds("\u626b\u63cf\u53f3\u4fa7\u4e8c\u7ef4\u7801", 0, 7, rect);
        int i5 = (i4 / 2) + 10;
        int i6 = height + MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED;
        canvas.drawText("\u626b\u63cf\u53f3\u4fa7\u4e8c\u7ef4\u7801", i5 - (rect.width() / 2), (i6 - (rect.height() / 2)) - rect.height(), paint);
        Rect rect2 = new Rect();
        paint.getTextBounds("\u4e0b\u8f7d\u4f53\u6d4b\u6210\u7ee9\u8ba1\u7b97\u5668", 0, 9, rect2);
        canvas.drawText("\u4e0b\u8f7d\u4f53\u6d4b\u6210\u7ee9\u8ba1\u7b97\u5668", i5 - (rect2.width() / 2), (i6 - (rect2.height() / 2)) + rect.height() + 10, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private void n0(SHARE_MEDIA platform) {
        new ShareAction(this).setPlatform(platform).setCallback(new b()).withMedia(new UMImage(this.f1656h, m0(l0(this.f19827k), BitmapFactory.decodeResource(getResources(), 2131559051)))).share();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19828l.setOnClickListener(this);
        this.f19829m.setOnClickListener(this);
        this.f19830n.setOnClickListener(this);
        this.f19831o.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427375;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("sm")) {
            this.f19832p = JsonParse.getList(((SeralizableMap) getIntent().getSerializableExtra("sm")).getMap(), "data");
        }
        HashMap hashMap = new HashMap(5);
        hashMap.put("name", "\u9879\u76ee");
        hashMap.put("result", "\u6210\u7ee9");
        hashMap.put("standard", "\u5206\u6570");
        hashMap.put("score", "\u6bd4\u4f8b\u5206");
        hashMap.put("level", "\u7b49\u7ea7");
        this.f19832p.add(0, hashMap);
        this.f19827k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427674, this.f19832p);
        this.f19833q = aVar;
        this.f19827k.setAdapter(aVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f53\u6d4b\u6210\u7ee9");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19827k = (RecyclerView) findViewById(2131232540);
        this.f19828l = (LinearLayout) findViewById(2131232234);
        this.f19829m = (LinearLayout) findViewById(2131232204);
        this.f19830n = (LinearLayout) findViewById(2131232213);
        this.f19831o = (LinearLayout) findViewById(2131232215);
    }

    public Bitmap l0(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        switch (v3.getId()) {
            case 2131232204:
                n0(SHARE_MEDIA.WEIXIN_CIRCLE);
                return;
            case 2131232213:
                n0(SHARE_MEDIA.QQ);
                return;
            case 2131232215:
                n0(SHARE_MEDIA.QZONE);
                return;
            case 2131232234:
                n0(SHARE_MEDIA.WEIXIN);
                return;
            default:
                return;
        }
    }
}
