package com.bxkj.student.life.mall;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.auth.a;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.common.view.NumberButton;
import com.bxkj.student.common.view.SlideDetailsLayout;
import com.bxkj.student.life.mall.order.ConfirmOrderActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GoodsDetailActivity extends BaseActivity {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private Button G;
    private Button H;
    private Button I;
    private String J;
    private Map<String, Object> K;

    /* renamed from: L  reason: collision with root package name */
    private List<String> f21516L;

    /* renamed from: k  reason: collision with root package name */
    private FloatingActionButton f21517k;

    /* renamed from: l  reason: collision with root package name */
    private RelativeLayout f21518l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f21519m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f21520n;

    /* renamed from: o  reason: collision with root package name */
    private SlideDetailsLayout f21521o;

    /* renamed from: p  reason: collision with root package name */
    private ScrollView f21522p;

    /* renamed from: q  reason: collision with root package name */
    private ScrollView f21523q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayout f21524r;

    /* renamed from: s  reason: collision with root package name */
    private CycleViewPager f21525s;

    /* renamed from: t  reason: collision with root package name */
    private SmartWebView f21526t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f21527u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f21528v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f21529w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f21530x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f21531y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f21532z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends com.zhy.view.flowlayout.b<Map<String, Object>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TagFlowLayout f21533d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List datas, final TagFlowLayout val$rv_size) {
            super(datas);
            this.f21533d = val$rv_size;
        }

        @Override // com.zhy.view.flowlayout.b
        /* renamed from: j */
        public View d(FlowLayout parent, int position, Map<String, Object> stringObjectMap) {
            TextView textView = (TextView) LayoutInflater.from(((BaseActivity) GoodsDetailActivity.this).f1656h).inflate(2131427781, (ViewGroup) this.f21533d, false);
            textView.setText(JsonParse.getString(stringObjectMap, "modelName"));
            return textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements TagFlowLayout.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f21535a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21536b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.zhy.view.flowlayout.b f21537c;

        b(final TextView val$tv_stock, final String val$stock, final com.zhy.view.flowlayout.b val$modelNameAdapter) {
            this.f21535a = val$tv_stock;
            this.f21536b = val$stock;
            this.f21537c = val$modelNameAdapter;
        }

        @Override // com.zhy.view.flowlayout.TagFlowLayout.a
        public void a(Set<Integer> selectPosSet) {
            if (selectPosSet != null && selectPosSet.size() != 0) {
                TextView textView = this.f21535a;
                textView.setText("\u5e93\u5b58\uff1a" + JsonParse.getString((Map) this.f21537c.b(selectPosSet.iterator().next().intValue()), "branchStock"));
                return;
            }
            this.f21535a.setText(this.f21536b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements NumberButton.OnWarnListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f21539a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double f21540b;

        c(final TextView val$tv_count, final double val$price) {
            this.f21539a = val$tv_count;
            this.f21540b = val$price;
        }

        @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
        public void onNumberChanged(int number) {
            TextView textView = this.f21539a;
            StringBuilder sb = new StringBuilder();
            sb.append("\u5171");
            sb.append(number);
            sb.append("\u4ef6\uffe5");
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            double d4 = this.f21540b;
            double d5 = number;
            Double.isNaN(d5);
            sb.append(decimalFormat.format(d4 * d5));
            sb.append("\u5143");
            textView.setText(sb.toString());
        }

        @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
        public void onWarningForBuyMax(int max) {
        }

        @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
        public void onWarningForInventory(int inventory) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TagFlowLayout f21542a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NumberButton f21543b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.zhy.view.flowlayout.b f21544c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Dialog f21545d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements a.g {

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$d$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0257a extends HttpCallBack {
                C0257a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    d.this.f21545d.dismiss();
                    HashMap hashMap = new HashMap(3);
                    HashMap hashMap2 = new HashMap(3);
                    hashMap2.putAll(JsonParse.getMap(data, "address"));
                    hashMap.put("address", hashMap2);
                    hashMap.put("goodsList", JsonParse.getList(data, "comms"));
                    hashMap.put("postFee", Double.valueOf(JsonParse.getDouble(data, "postFee")));
                    hashMap.put("goodsPrice", Double.valueOf(JsonParse.getDouble(data, "totalPrize")));
                    SeralizableMap seralizableMap = new SeralizableMap();
                    seralizableMap.setMap(hashMap);
                    GoodsDetailActivity.this.startActivity(new Intent(((BaseActivity) GoodsDetailActivity.this).f1656h, ConfirmOrderActivity.class).putExtra("map", seralizableMap));
                }
            }

            a() {
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                d dVar = d.this;
                Http.with(((BaseActivity) GoodsDetailActivity.this).f1656h).setObservable(((q.g) Http.getApiService(q.g.class)).p(LoginUser.getLoginUser().getOpenId(), GoodsDetailActivity.this.J, JsonParse.getString((Map) dVar.f21544c.b(dVar.f21542a.getSelectedList().iterator().next().intValue()), "id"), d.this.f21543b.getNumber())).setDataListener(new C0257a());
            }
        }

        d(final TagFlowLayout val$rv_size, final NumberButton val$number_button, final com.zhy.view.flowlayout.b val$modelNameAdapter, final Dialog val$dialog) {
            this.f21542a = val$rv_size;
            this.f21543b = val$number_button;
            this.f21544c = val$modelNameAdapter;
            this.f21545d = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            if (this.f21542a.getSelectedList() != null && this.f21542a.getSelectedList().size() > 0) {
                if (this.f21543b.getNumber() <= 0) {
                    GoodsDetailActivity.this.h0("\u8bf7\u9009\u62e9\u5546\u54c1\u6570\u91cf");
                    return;
                } else {
                    new com.bxkj.base.auth.a(((BaseActivity) GoodsDetailActivity.this).f1656h).i(new a()).b(GoodsDetailActivity.this.getSupportFragmentManager(), 0);
                    return;
                }
            }
            GoodsDetailActivity.this.h0("\u8bf7\u9009\u62e9\u5546\u54c1\u5c5e\u6027");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TagFlowLayout f21549a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NumberButton f21550b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.zhy.view.flowlayout.b f21551c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Dialog f21552d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements a.g {

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$e$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0258a extends HttpCallBack {
                C0258a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    e.this.f21552d.dismiss();
                    GoodsDetailActivity.this.h0("\u52a0\u5165\u8d2d\u7269\u8f66\u6210\u529f");
                    GoodsListFragment goodsListFragment = (GoodsListFragment) cn.bluemobi.dylan.base.utils.a.n().o(GoodsListFragment.class);
                    if (goodsListFragment != null) {
                        goodsListFragment.g0();
                    }
                }
            }

            a() {
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                e eVar = e.this;
                Http.with(((BaseActivity) GoodsDetailActivity.this).f1656h).setObservable(((q.g) Http.getApiService(q.g.class)).j(LoginUser.getLoginUser().getOpenId(), GoodsDetailActivity.this.J, JsonParse.getString((Map) eVar.f21551c.b(eVar.f21549a.getSelectedList().iterator().next().intValue()), "id"), e.this.f21550b.getNumber())).setDataListener(new C0258a());
            }
        }

        e(final TagFlowLayout val$rv_size, final NumberButton val$number_button, final com.zhy.view.flowlayout.b val$modelNameAdapter, final Dialog val$dialog) {
            this.f21549a = val$rv_size;
            this.f21550b = val$number_button;
            this.f21551c = val$modelNameAdapter;
            this.f21552d = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            if (this.f21549a.getSelectedList() != null && this.f21549a.getSelectedList().size() > 0) {
                if (this.f21550b.getNumber() <= 0) {
                    GoodsDetailActivity.this.h0("\u8bf7\u9009\u62e9\u5546\u54c1\u6570\u91cf");
                    return;
                } else {
                    new com.bxkj.base.auth.a(((BaseActivity) GoodsDetailActivity.this).f1656h).i(new a()).b(GoodsDetailActivity.this.getSupportFragmentManager(), 0);
                    return;
                }
            }
            GoodsDetailActivity.this.h0("\u8bf7\u9009\u62e9\u5546\u54c1\u5c5e\u6027");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        f(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233160, JsonParse.getString(stringObjectMap, "name") + "\uff1a\u3000");
            holder.J(2131233221, JsonParse.getString(stringObjectMap, "value"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Dialog f21557a;

        g(final Dialog val$dialog) {
            this.f21557a = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            Dialog dialog = this.f21557a;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f21557a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h implements a.g {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
                goodsDetailActivity.J0("\u6536\u85cf".equals(goodsDetailActivity.C.getText().toString().trim()));
            }
        }

        h() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            Http.with(((BaseActivity) GoodsDetailActivity.this).f1656h).setObservable(((q.g) Http.getApiService(q.g.class)).r(GoodsDetailActivity.this.J, LoginUser.getLoginUser().getOpenId())).setDataListener(new a());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class i implements SlideDetailsLayout.OnSlideDetailsListener {
        i() {
        }

        @Override // com.bxkj.student.common.view.SlideDetailsLayout.OnSlideDetailsListener
        public void onStatucChanged(SlideDetailsLayout.Status status) {
            if (status == SlideDetailsLayout.Status.OPEN) {
                GoodsDetailActivity.this.f21523q.setVisibility(0);
                GoodsDetailActivity.this.f21517k.setVisibility(0);
                return;
            }
            GoodsDetailActivity.this.f21523q.setVisibility(8);
            GoodsDetailActivity.this.f21517k.setVisibility(8);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class j implements a.g {
        j() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            GoodsDetailActivity.this.H0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class k implements a.g {
        k() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            GoodsDetailActivity.this.startActivity(new Intent(((BaseActivity) GoodsDetailActivity.this).f1656h, CartActivity.class));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class l implements iOSTwoButtonDialog.RightButtonOnClick {
        l() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(GoodsDetailActivity.this.getString(2131820968)));
            intent.setFlags(268435456);
            GoodsDetailActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class m implements ShareBoardlistener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements UMShareListener {
            a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) GoodsDetailActivity.this).f1656h, " \u5206\u4eab\u53d6\u6d88\u4e86", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t3) {
                t3.printStackTrace();
                Toast.makeText(((BaseActivity) GoodsDetailActivity.this).f1656h, " \u5206\u4eab\u5931\u8d25\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) GoodsDetailActivity.this).f1656h, " \u5206\u4eab\u6210\u529f\u5566", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        m() {
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb("http://m.boxkj.com/admin/studentAppUpdate/downloadUrl");
            uMWeb.setTitle("\u6821\u56ed\u751f\u6d3b\u5982\u6b64\u7b80\u5355");
            uMWeb.setThumb(new UMImage(((BaseActivity) GoodsDetailActivity.this).f1656h, "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
            uMWeb.setDescription(GoodsDetailActivity.this.getString(2131821569));
            new ShareAction(GoodsDetailActivity.this).setPlatform(share_media).setCallback(new a()).withMedia(uMWeb).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class n extends HttpCallBack {
        n() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) GoodsDetailActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            GoodsDetailActivity.this.f21518l.setVisibility(0);
            GoodsDetailActivity.this.K = data;
            GoodsDetailActivity.this.K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class o implements CycleViewPager.ImageCycleViewListener {
        o() {
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewListener
        public void onImageClick(String url, int position, View imageView) {
            GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
            goodsDetailActivity.O0((String[]) goodsDetailActivity.f21516L.toArray(new String[GoodsDetailActivity.this.f21516L.size()]), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class p implements CycleViewPager.ImageCycleViewSelectListener {
        p() {
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewSelectListener
        public void onItemSelect(int position) {
            TextView textView = GoodsDetailActivity.this.B;
            textView.setText((position + 1) + TTPathConst.sSeparator + GoodsDetailActivity.this.f21516L.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Dialog f21570a;

        q(final Dialog val$dialog) {
            this.f21570a = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            Dialog dialog = this.f21570a;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f21570a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        if (!LoginUser.getLoginUser().isLogin()) {
            startActivity(new Intent(this.f1656h, LoginActivity.class));
        } else {
            new com.bxkj.base.auth.a(this.f1656h).i(new h()).b(getSupportFragmentManager(), 0);
        }
    }

    private void I0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((q.g) Http.getApiService(q.g.class)).k(this.J, (LoginUser.getLoginUser().isLogin() && LoginUser.getLoginUser().isAuthorizationInMall()) ? LoginUser.getLoginUser().getOpenId() : null)).setDataListener(new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(boolean hasFavorited) {
        if (hasFavorited) {
            L0();
        } else {
            M0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        if (this.K.containsKey("imgArr")) {
            List<String> list = (List) this.K.get("imgArr");
            this.f21516L = list;
            this.f21525s.setData(list, new o());
            TextView textView = this.B;
            textView.setText("1/" + this.f21516L.size());
            this.f21525s.setImageCycleViewSelectListener(new p());
        } else {
            this.B.setText("0");
        }
        this.f21532z.setText(JsonParse.getString(this.K, "name"));
        TextView textView2 = this.A;
        textView2.setText("\uffe5" + JsonParse.getMoney(this.K, "discountPrice"));
        TextView textView3 = this.f21527u;
        textView3.setText("\u539f\u4ef7\uff1a\uffe5" + JsonParse.getMoney(this.K, "regionPrice"));
        TextView textView4 = this.f21528v;
        textView4.setText("\u5e93\u5b58\uff1a" + JsonParse.getString(this.K, "stock"));
        TextView textView5 = this.f21529w;
        textView5.setText("\u9500\u91cf\uff1a" + JsonParse.getString(this.K, "saledNum"));
        this.f21531y.setText(JsonParse.getString(this.K, "postFeeTip"));
        J0(JsonParse.getBoolean(this.K, "hasFavorited", false));
        this.f21526t.h(JsonParse.getString(this.K, "memo"));
        if ("1".equals(JsonParse.getString(this.K, "downState"))) {
            N0();
        }
    }

    private void L0() {
        Drawable drawable = getResources().getDrawable(2131558579);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1656h), u.a(21.0f, this.f1656h));
        this.C.setCompoundDrawables(null, drawable, null, null);
        this.C.setText("\u5df2\u6536\u85cf");
    }

    private void M0() {
        Drawable drawable = getResources().getDrawable(2131558578);
        drawable.setBounds(0, 0, u.a(21.0f, this.f1656h), u.a(21.0f, this.f1656h));
        this.C.setCompoundDrawables(null, drawable, null, null);
        this.C.setText("\u6536\u85cf");
    }

    private void N0() {
        this.f21520n.setVisibility(8);
        this.I.setVisibility(0);
        this.E.setEnabled(false);
        this.f21519m.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(String[] arr, int position) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", arr);
        intent.putExtra("image_index", position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    private void P0() {
        Dialog dialog = new Dialog(this.f1656h, 2131886336);
        dialog.setContentView(2131427603);
        dialog.getWindow().setGravity(80);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        dialog.getWindow().setAttributes(attributes);
        dialog.show();
        dialog.findViewById(2131231399).setOnClickListener(new q(dialog));
        ImageView imageView = (ImageView) dialog.findViewById(2131231451);
        List<String> list = this.f21516L;
        if (list != null && list.size() > 0) {
            com.bumptech.glide.d.C(this.f1656h).a(this.f21516L.get(0)).w0(2131558744).x(2131558744).i1(imageView);
        }
        ((TextView) dialog.findViewById(2131233040)).setText(JsonParse.getString(this.K, "name"));
        ((TextView) dialog.findViewById(2131233101)).setText("\uffe5" + JsonParse.getMoney(this.K, "discountPrice"));
        TextView textView = (TextView) dialog.findViewById(2131233185);
        String str = "\u5e93\u5b58\uff1a" + JsonParse.getString(this.K, "stock");
        textView.setText(str);
        TagFlowLayout tagFlowLayout = (TagFlowLayout) dialog.findViewById(2131232762);
        List<Map<String, Object>> list2 = JsonParse.getList(this.K, "models");
        tagFlowLayout.setMaxSelectCount(1);
        a aVar = new a(list2, tagFlowLayout);
        tagFlowLayout.setAdapter(aVar);
        tagFlowLayout.setOnSelectListener(new b(textView, str, aVar));
        double d4 = JsonParse.getDouble(this.K, "discountPrice");
        TextView textView2 = (TextView) dialog.findViewById(2131232914);
        textView2.setText("\u51711\u4ef6\uffe5" + d4 + "\u5143");
        NumberButton numberButton = (NumberButton) dialog.findViewById(2131232411);
        numberButton.setBuyMax(JsonParse.getInt(this.K, "stock"));
        numberButton.setCurrentNumber(JsonParse.getInt(this.K, "stock") <= 0 ? 0 : 1);
        numberButton.setOnWarnListener(new c(textView2, d4));
        ((Button) dialog.findViewById(2131230957)).setOnClickListener(new d(tagFlowLayout, numberButton, aVar, dialog));
        ((Button) dialog.findViewById(2131230950)).setOnClickListener(new e(tagFlowLayout, numberButton, aVar, dialog));
    }

    private void Q0() {
        Dialog dialog = new Dialog(this.f1656h, 2131886336);
        dialog.setContentView(2131427607);
        dialog.getWindow().setGravity(80);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        dialog.getWindow().setAttributes(attributes);
        dialog.show();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("specification", "\u5546\u54c1\u540d\u79f0\uff1a\u3000");
        hashMap.put("value", "\u5546\u54c1\u540d\u79f0");
        arrayList.add(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("specification", "\u5546\u54c1\u7f16\u53f7\uff1a\u3000");
        hashMap2.put("value", "\u5546\u54c1\u7f16\u53f7");
        arrayList.add(hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("specification", "\u54c1\u724c\uff1a\u3000\u3000\u3000");
        hashMap3.put("value", "\u54c1\u724c");
        arrayList.add(hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("specification", "\u4e0a\u67b6\u65f6\u95f4\uff1a\u3000");
        hashMap4.put("value", "\u4e0a\u67b6\u65f6\u95f4");
        arrayList.add(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put("specification", "\u5546\u54c1\u6bdb\u91cd\uff1a\u3000");
        hashMap5.put("value", "\u5546\u54c1\u6bdb\u91cd");
        arrayList.add(hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put("specification", "\u5e93\u5b58\uff1a\u3000\u3000\u3000");
        hashMap6.put("value", "\u5e93\u5b58");
        arrayList.add(hashMap6);
        HashMap hashMap7 = new HashMap();
        hashMap7.put("specification", "\u9762\u6599\uff1a\u3000\u3000\u3000");
        hashMap7.put("value", "\u9762\u6599");
        arrayList.add(hashMap7);
        ((ListView) dialog.findViewById(2131232245)).setAdapter((ListAdapter) new f(this.f1656h, 2131427765, arrayList));
        ((ImageView) dialog.findViewById(2131231399)).setOnClickListener(new g(dialog));
    }

    private void R0() {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new m()).open();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21521o.setOnSlideDetailsListener(new i());
        this.f21530x.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.f21519m.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.f21517k.setOnClickListener(this);
        this.F.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427405;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("goodsId")) {
            this.J = getIntent().getStringExtra("goodsId");
        }
        I0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5546\u54c1\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21517k = (FloatingActionButton) findViewById(2131231292);
        this.f21527u = (TextView) findViewById(2131233059);
        this.f21521o = (SlideDetailsLayout) findViewById(2131232711);
        this.f21522p = (ScrollView) findViewById(2131232255);
        this.f21523q = (ScrollView) findViewById(2131232253);
        this.f21524r = (LinearLayout) this.f21522p.getChildAt(0);
        this.f21525s = (CycleViewPager) findViewById(2131231166);
        this.f21527u.getPaint().setFlags(16);
        SmartWebView smartWebView = (SmartWebView) findViewById(2131233327);
        this.f21526t = smartWebView;
        smartWebView.j("http://btblcn.com//mobi//commodity//details//de90164762b24a299f45a143e1dbe1ba");
        this.f21530x = (TextView) findViewById(2131233161);
        this.G = (Button) findViewById(2131230950);
        this.H = (Button) findViewById(2131230957);
        this.f21532z = (TextView) findViewById(2131233040);
        this.A = (TextView) findViewById(2131233101);
        this.f21528v = (TextView) findViewById(2131233185);
        this.f21529w = (TextView) findViewById(2131233142);
        this.f21518l = (RelativeLayout) findViewById(2131232527);
        this.B = (TextView) findViewById(2131233003);
        this.f21519m = (LinearLayout) findViewById(2131232223);
        this.C = (TextView) findViewById(2131232908);
        this.F = (TextView) findViewById(2131233089);
        this.D = (TextView) findViewById(2131232894);
        this.f21531y = (TextView) findViewById(2131233100);
        this.E = (TextView) findViewById(2131233153);
        this.f21520n = (LinearLayout) findViewById(2131232168);
        this.I = (Button) findViewById(2131231016);
        this.f21518l.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        switch (v3.getId()) {
            case 2131230950:
                P0();
                return;
            case 2131230957:
                P0();
                return;
            case 2131231292:
                this.f21522p.smoothScrollTo(0, 0);
                this.f21521o.smoothClose(true);
                return;
            case 2131232223:
                P0();
                return;
            case 2131232894:
                new com.bxkj.base.auth.a(this.f1656h).i(new k()).b(getSupportFragmentManager(), 0);
                return;
            case 2131232908:
                new com.bxkj.base.auth.a(this.f1656h).i(new j()).b(getSupportFragmentManager(), 0);
                return;
            case 2131233089:
                new iOSTwoButtonDialog(this.f1656h).setTitle("\u63d0\u793a").setMessage(getString(2131821592)).setRightButtonOnClickListener(new l()).show();
                return;
            case 2131233153:
                R0();
                return;
            case 2131233161:
                Q0();
                return;
            default:
                return;
        }
    }
}
