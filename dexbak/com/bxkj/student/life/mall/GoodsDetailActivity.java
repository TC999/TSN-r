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
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bumptech.glide.Glide;
import com.bxkj.base.auth.AuthorizationUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.view.NumberButton;
import com.bxkj.student.common.view.SlideDetailsLayout;
import com.bxkj.student.life.mall.order.ConfirmOrderActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p635q.MallApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GoodsDetailActivity extends BaseActivity {

    /* renamed from: A */
    private TextView f18190A;

    /* renamed from: B */
    private TextView f18191B;

    /* renamed from: C */
    private TextView f18192C;

    /* renamed from: D */
    private TextView f18193D;

    /* renamed from: E */
    private TextView f18194E;

    /* renamed from: F */
    private TextView f18195F;

    /* renamed from: G */
    private Button f18196G;

    /* renamed from: H */
    private Button f18197H;

    /* renamed from: I */
    private Button f18198I;

    /* renamed from: J */
    private String f18199J;

    /* renamed from: K */
    private Map<String, Object> f18200K;

    /* renamed from: L */
    private List<String> f18201L;

    /* renamed from: k */
    private FloatingActionButton f18202k;

    /* renamed from: l */
    private RelativeLayout f18203l;

    /* renamed from: m */
    private LinearLayout f18204m;

    /* renamed from: n */
    private LinearLayout f18205n;

    /* renamed from: o */
    private SlideDetailsLayout f18206o;

    /* renamed from: p */
    private ScrollView f18207p;

    /* renamed from: q */
    private ScrollView f18208q;

    /* renamed from: r */
    private LinearLayout f18209r;

    /* renamed from: s */
    private CycleViewPager f18210s;

    /* renamed from: t */
    private SmartWebView f18211t;

    /* renamed from: u */
    private TextView f18212u;

    /* renamed from: v */
    private TextView f18213v;

    /* renamed from: w */
    private TextView f18214w;

    /* renamed from: x */
    private TextView f18215x;

    /* renamed from: y */
    private TextView f18216y;

    /* renamed from: z */
    private TextView f18217z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4937a extends TagAdapter<Map<String, Object>> {

        /* renamed from: d */
        final /* synthetic */ TagFlowLayout f18218d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4937a(List datas, final TagFlowLayout val$rv_size) {
            super(datas);
            this.f18218d = val$rv_size;
        }

        @Override // com.zhy.view.flowlayout.TagAdapter
        /* renamed from: j */
        public View mo12853d(FlowLayout parent, int position, Map<String, Object> stringObjectMap) {
            TextView textView = (TextView) LayoutInflater.from(((BaseActivity) GoodsDetailActivity.this).f1669h).inflate(C4215R.C4221layout.item_tag, (ViewGroup) this.f18218d, false);
            textView.setText(JsonParse.getString(stringObjectMap, "modelName"));
            return textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4938b implements TagFlowLayout.InterfaceC13565a {

        /* renamed from: a */
        final /* synthetic */ TextView f18220a;

        /* renamed from: b */
        final /* synthetic */ String f18221b;

        /* renamed from: c */
        final /* synthetic */ TagAdapter f18222c;

        C4938b(final TextView val$tv_stock, final String val$stock, final TagAdapter val$modelNameAdapter) {
            this.f18220a = val$tv_stock;
            this.f18221b = val$stock;
            this.f18222c = val$modelNameAdapter;
        }

        @Override // com.zhy.view.flowlayout.TagFlowLayout.InterfaceC13565a
        /* renamed from: a */
        public void mo12858a(Set<Integer> selectPosSet) {
            if (selectPosSet != null && selectPosSet.size() != 0) {
                TextView textView = this.f18220a;
                textView.setText("库存：" + JsonParse.getString((Map) this.f18222c.m12855b(selectPosSet.iterator().next().intValue()), "branchStock"));
                return;
            }
            this.f18220a.setText(this.f18221b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4939c implements NumberButton.OnWarnListener {

        /* renamed from: a */
        final /* synthetic */ TextView f18224a;

        /* renamed from: b */
        final /* synthetic */ double f18225b;

        C4939c(final TextView val$tv_count, final double val$price) {
            this.f18224a = val$tv_count;
            this.f18225b = val$price;
        }

        @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
        public void onNumberChanged(int number) {
            TextView textView = this.f18224a;
            StringBuilder sb = new StringBuilder();
            sb.append("共");
            sb.append(number);
            sb.append("件￥");
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            double d = this.f18225b;
            double d2 = number;
            Double.isNaN(d2);
            sb.append(decimalFormat.format(d * d2));
            sb.append("元");
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
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4940d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ TagFlowLayout f18227a;

        /* renamed from: b */
        final /* synthetic */ NumberButton f18228b;

        /* renamed from: c */
        final /* synthetic */ TagAdapter f18229c;

        /* renamed from: d */
        final /* synthetic */ Dialog f18230d;

        /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4941a implements AuthorizationUtils.InterfaceC3827g {

            /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$d$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C4942a extends HttpCallBack {
                C4942a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    View$OnClickListenerC4940d.this.f18230d.dismiss();
                    HashMap hashMap = new HashMap(3);
                    HashMap hashMap2 = new HashMap(3);
                    hashMap2.putAll(JsonParse.getMap(data, "address"));
                    hashMap.put("address", hashMap2);
                    hashMap.put("goodsList", JsonParse.getList(data, "comms"));
                    hashMap.put("postFee", Double.valueOf(JsonParse.getDouble(data, "postFee")));
                    hashMap.put("goodsPrice", Double.valueOf(JsonParse.getDouble(data, "totalPrize")));
                    SeralizableMap seralizableMap = new SeralizableMap();
                    seralizableMap.setMap(hashMap);
                    GoodsDetailActivity.this.startActivity(new Intent(((BaseActivity) GoodsDetailActivity.this).f1669h, ConfirmOrderActivity.class).putExtra("map", seralizableMap));
                }
            }

            C4941a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
            /* renamed from: a */
            public void mo40697a() {
                View$OnClickListenerC4940d view$OnClickListenerC4940d = View$OnClickListenerC4940d.this;
                Http.with(((BaseActivity) GoodsDetailActivity.this).f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2232p(LoginUser.getLoginUser().getOpenId(), GoodsDetailActivity.this.f18199J, JsonParse.getString((Map) view$OnClickListenerC4940d.f18229c.m12855b(view$OnClickListenerC4940d.f18227a.getSelectedList().iterator().next().intValue()), "id"), View$OnClickListenerC4940d.this.f18228b.getNumber())).setDataListener(new C4942a());
            }
        }

        View$OnClickListenerC4940d(final TagFlowLayout val$rv_size, final NumberButton val$number_button, final TagAdapter val$modelNameAdapter, final Dialog val$dialog) {
            this.f18227a = val$rv_size;
            this.f18228b = val$number_button;
            this.f18229c = val$modelNameAdapter;
            this.f18230d = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (this.f18227a.getSelectedList() != null && this.f18227a.getSelectedList().size() > 0) {
                if (this.f18228b.getNumber() <= 0) {
                    GoodsDetailActivity.this.m57919h0("请选择商品数量");
                    return;
                } else {
                    new AuthorizationUtils(((BaseActivity) GoodsDetailActivity.this).f1669h).m44322i(new C4941a()).m44329b(GoodsDetailActivity.this.getSupportFragmentManager(), 0);
                    return;
                }
            }
            GoodsDetailActivity.this.m57919h0("请选择商品属性");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4943e implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ TagFlowLayout f18234a;

        /* renamed from: b */
        final /* synthetic */ NumberButton f18235b;

        /* renamed from: c */
        final /* synthetic */ TagAdapter f18236c;

        /* renamed from: d */
        final /* synthetic */ Dialog f18237d;

        /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$e$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4944a implements AuthorizationUtils.InterfaceC3827g {

            /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$e$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C4945a extends HttpCallBack {
                C4945a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    View$OnClickListenerC4943e.this.f18237d.dismiss();
                    GoodsDetailActivity.this.m57919h0("加入购物车成功");
                    GoodsListFragment goodsListFragment = (GoodsListFragment) AppManager.m57776n().m57775o(GoodsListFragment.class);
                    if (goodsListFragment != null) {
                        goodsListFragment.m40929g0();
                    }
                }
            }

            C4944a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
            /* renamed from: a */
            public void mo40697a() {
                View$OnClickListenerC4943e view$OnClickListenerC4943e = View$OnClickListenerC4943e.this;
                Http.with(((BaseActivity) GoodsDetailActivity.this).f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2238j(LoginUser.getLoginUser().getOpenId(), GoodsDetailActivity.this.f18199J, JsonParse.getString((Map) view$OnClickListenerC4943e.f18236c.m12855b(view$OnClickListenerC4943e.f18234a.getSelectedList().iterator().next().intValue()), "id"), View$OnClickListenerC4943e.this.f18235b.getNumber())).setDataListener(new C4945a());
            }
        }

        View$OnClickListenerC4943e(final TagFlowLayout val$rv_size, final NumberButton val$number_button, final TagAdapter val$modelNameAdapter, final Dialog val$dialog) {
            this.f18234a = val$rv_size;
            this.f18235b = val$number_button;
            this.f18236c = val$modelNameAdapter;
            this.f18237d = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (this.f18234a.getSelectedList() != null && this.f18234a.getSelectedList().size() > 0) {
                if (this.f18235b.getNumber() <= 0) {
                    GoodsDetailActivity.this.m57919h0("请选择商品数量");
                    return;
                } else {
                    new AuthorizationUtils(((BaseActivity) GoodsDetailActivity.this).f1669h).m44322i(new C4944a()).m44329b(GoodsDetailActivity.this.getSupportFragmentManager(), 0);
                    return;
                }
            }
            GoodsDetailActivity.this.m57919h0("请选择商品属性");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4946f extends CommonAdapter<Map<String, Object>> {
        C4946f(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_specification, JsonParse.getString(stringObjectMap, "name") + "：\u3000");
            holder.m57874J(2131233221, JsonParse.getString(stringObjectMap, DomainCampaignEx.LOOPBACK_VALUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4947g implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Dialog f18242a;

        View$OnClickListenerC4947g(final Dialog val$dialog) {
            this.f18242a = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Dialog dialog = this.f18242a;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f18242a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4948h implements AuthorizationUtils.InterfaceC3827g {

        /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$h$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4949a extends HttpCallBack {
            C4949a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
                goodsDetailActivity.m40977J0("收藏".equals(goodsDetailActivity.f18192C.getText().toString().trim()));
            }
        }

        C4948h() {
        }

        @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
        /* renamed from: a */
        public void mo40697a() {
            Http.with(((BaseActivity) GoodsDetailActivity.this).f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2230r(GoodsDetailActivity.this.f18199J, LoginUser.getLoginUser().getOpenId())).setDataListener(new C4949a());
        }
    }

    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4950i implements SlideDetailsLayout.OnSlideDetailsListener {
        C4950i() {
        }

        @Override // com.bxkj.student.common.view.SlideDetailsLayout.OnSlideDetailsListener
        public void onStatucChanged(SlideDetailsLayout.Status status) {
            if (status == SlideDetailsLayout.Status.OPEN) {
                GoodsDetailActivity.this.f18208q.setVisibility(0);
                GoodsDetailActivity.this.f18202k.setVisibility(0);
                return;
            }
            GoodsDetailActivity.this.f18208q.setVisibility(8);
            GoodsDetailActivity.this.f18202k.setVisibility(8);
        }
    }

    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4951j implements AuthorizationUtils.InterfaceC3827g {
        C4951j() {
        }

        @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
        /* renamed from: a */
        public void mo40697a() {
            GoodsDetailActivity.this.m40979H0();
        }
    }

    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4952k implements AuthorizationUtils.InterfaceC3827g {
        C4952k() {
        }

        @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
        /* renamed from: a */
        public void mo40697a() {
            GoodsDetailActivity.this.startActivity(new Intent(((BaseActivity) GoodsDetailActivity.this).f1669h, CartActivity.class));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4953l implements iOSTwoButtonDialog.RightButtonOnClick {
        C4953l() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(GoodsDetailActivity.this.getString(C4215R.C4224string.link_phone_number)));
            intent.setFlags(268435456);
            GoodsDetailActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4954m implements ShareBoardlistener {

        /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$m$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4955a implements UMShareListener {
            C4955a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) GoodsDetailActivity.this).f1669h, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t) {
                t.printStackTrace();
                Toast.makeText(((BaseActivity) GoodsDetailActivity.this).f1669h, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) GoodsDetailActivity.this).f1669h, " 分享成功啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        C4954m() {
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb("http://m.boxkj.com/admin/studentAppUpdate/downloadUrl");
            uMWeb.setTitle("校园生活如此简单");
            uMWeb.setThumb(new UMImage(((BaseActivity) GoodsDetailActivity.this).f1669h, "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
            uMWeb.setDescription(GoodsDetailActivity.this.getString(C4215R.C4224string.welcome_user_app));
            new ShareAction(GoodsDetailActivity.this).setPlatform(share_media).setCallback(new C4955a()).withMedia(uMWeb).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$n */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4956n extends HttpCallBack {
        C4956n() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) GoodsDetailActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            GoodsDetailActivity.this.f18203l.setVisibility(0);
            GoodsDetailActivity.this.f18200K = data;
            GoodsDetailActivity.this.m40976K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$o */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4957o implements CycleViewPager.ImageCycleViewListener {
        C4957o() {
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewListener
        public void onImageClick(String url, int position, View imageView) {
            GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
            goodsDetailActivity.m40972O0((String[]) goodsDetailActivity.f18201L.toArray(new String[GoodsDetailActivity.this.f18201L.size()]), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$p */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4958p implements CycleViewPager.ImageCycleViewSelectListener {
        C4958p() {
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewSelectListener
        public void onItemSelect(int position) {
            TextView textView = GoodsDetailActivity.this.f18191B;
            textView.setText((position + 1) + "/" + GoodsDetailActivity.this.f18201L.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$q */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class View$OnClickListenerC4959q implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Dialog f18255a;

        View$OnClickListenerC4959q(final Dialog val$dialog) {
            this.f18255a = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Dialog dialog = this.f18255a;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f18255a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public void m40979H0() {
        if (!LoginUser.getLoginUser().isLogin()) {
            startActivity(new Intent(this.f1669h, LoginActivity.class));
        } else {
            new AuthorizationUtils(this.f1669h).m44322i(new C4948h()).m44329b(getSupportFragmentManager(), 0);
        }
    }

    /* renamed from: I0 */
    private void m40978I0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2237k(this.f18199J, (LoginUser.getLoginUser().isLogin() && LoginUser.getLoginUser().isAuthorizationInMall()) ? LoginUser.getLoginUser().getOpenId() : null)).setDataListener(new C4956n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public void m40977J0(boolean hasFavorited) {
        if (hasFavorited) {
            m40975L0();
        } else {
            m40974M0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public void m40976K0() {
        if (this.f18200K.containsKey("imgArr")) {
            List<String> list = (List) this.f18200K.get("imgArr");
            this.f18201L = list;
            this.f18210s.setData(list, new C4957o());
            TextView textView = this.f18191B;
            textView.setText("1/" + this.f18201L.size());
            this.f18210s.setImageCycleViewSelectListener(new C4958p());
        } else {
            this.f18191B.setText("0");
        }
        this.f18217z.setText(JsonParse.getString(this.f18200K, "name"));
        TextView textView2 = this.f18190A;
        textView2.setText("￥" + JsonParse.getMoney(this.f18200K, "discountPrice"));
        TextView textView3 = this.f18212u;
        textView3.setText("原价：￥" + JsonParse.getMoney(this.f18200K, "regionPrice"));
        TextView textView4 = this.f18213v;
        textView4.setText("库存：" + JsonParse.getString(this.f18200K, "stock"));
        TextView textView5 = this.f18214w;
        textView5.setText("销量：" + JsonParse.getString(this.f18200K, "saledNum"));
        this.f18216y.setText(JsonParse.getString(this.f18200K, "postFeeTip"));
        m40977J0(JsonParse.getBoolean(this.f18200K, "hasFavorited", false));
        this.f18211t.m57495h(JsonParse.getString(this.f18200K, "memo"));
        if ("1".equals(JsonParse.getString(this.f18200K, "downState"))) {
            m40973N0();
        }
    }

    /* renamed from: L0 */
    private void m40975L0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.goods_collection_star_red);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1669h), Tools.m57620a(21.0f, this.f1669h));
        this.f18192C.setCompoundDrawables(null, drawable, null, null);
        this.f18192C.setText("已收藏");
    }

    /* renamed from: M0 */
    private void m40974M0() {
        Drawable drawable = getResources().getDrawable(C4215R.mipmap.goods_collection_star_grey);
        drawable.setBounds(0, 0, Tools.m57620a(21.0f, this.f1669h), Tools.m57620a(21.0f, this.f1669h));
        this.f18192C.setCompoundDrawables(null, drawable, null, null);
        this.f18192C.setText("收藏");
    }

    /* renamed from: N0 */
    private void m40973N0() {
        this.f18205n.setVisibility(8);
        this.f18198I.setVisibility(0);
        this.f18194E.setEnabled(false);
        this.f18204m.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public void m40972O0(String[] arr, int position) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, arr);
        intent.putExtra(ImagePagerActivity.f1868g, position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    /* renamed from: P0 */
    private void m40971P0() {
        Dialog dialog = new Dialog(this.f1669h, C4215R.C4225style.Dialog_FullScreen);
        dialog.setContentView(C4215R.C4221layout.dialog_select_size);
        dialog.getWindow().setGravity(80);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        dialog.getWindow().setAttributes(attributes);
        dialog.show();
        dialog.findViewById(2131231399).setOnClickListener(new View$OnClickListenerC4959q(dialog));
        ImageView imageView = (ImageView) dialog.findViewById(2131231451);
        List<String> list = this.f18201L;
        if (list != null && list.size() > 0) {
            Glide.m45751C(this.f1669h).mo45507a(this.f18201L.get(0)).m44601w0(C4215R.mipmap.icon_smal).m44600x(C4215R.mipmap.icon_smal).m45551i1(imageView);
        }
        ((TextView) dialog.findViewById(2131233040)).setText(JsonParse.getString(this.f18200K, "name"));
        ((TextView) dialog.findViewById(2131233101)).setText("￥" + JsonParse.getMoney(this.f18200K, "discountPrice"));
        TextView textView = (TextView) dialog.findViewById(C4215R.C4219id.tv_stock);
        String str = "库存：" + JsonParse.getString(this.f18200K, "stock");
        textView.setText(str);
        TagFlowLayout tagFlowLayout = (TagFlowLayout) dialog.findViewById(C4215R.C4219id.tfl);
        List<Map<String, Object>> list2 = JsonParse.getList(this.f18200K, "models");
        tagFlowLayout.setMaxSelectCount(1);
        C4937a c4937a = new C4937a(list2, tagFlowLayout);
        tagFlowLayout.setAdapter(c4937a);
        tagFlowLayout.setOnSelectListener(new C4938b(textView, str, c4937a));
        double d = JsonParse.getDouble(this.f18200K, "discountPrice");
        TextView textView2 = (TextView) dialog.findViewById(2131232914);
        textView2.setText("共1件￥" + d + "元");
        NumberButton numberButton = (NumberButton) dialog.findViewById(2131232411);
        numberButton.setBuyMax(JsonParse.getInt(this.f18200K, "stock"));
        numberButton.setCurrentNumber(JsonParse.getInt(this.f18200K, "stock") <= 0 ? 0 : 1);
        numberButton.setOnWarnListener(new C4939c(textView2, d));
        ((Button) dialog.findViewById(C4215R.C4219id.bt_buy)).setOnClickListener(new View$OnClickListenerC4940d(tagFlowLayout, numberButton, c4937a, dialog));
        ((Button) dialog.findViewById(2131230950)).setOnClickListener(new View$OnClickListenerC4943e(tagFlowLayout, numberButton, c4937a, dialog));
    }

    /* renamed from: Q0 */
    private void m40970Q0() {
        Dialog dialog = new Dialog(this.f1669h, C4215R.C4225style.Dialog_FullScreen);
        dialog.setContentView(C4215R.C4221layout.dialog_specifications);
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
        hashMap.put("specification", "商品名称：\u3000");
        hashMap.put(DomainCampaignEx.LOOPBACK_VALUE, "商品名称");
        arrayList.add(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("specification", "商品编号：\u3000");
        hashMap2.put(DomainCampaignEx.LOOPBACK_VALUE, "商品编号");
        arrayList.add(hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("specification", "品牌：\u3000\u3000\u3000");
        hashMap3.put(DomainCampaignEx.LOOPBACK_VALUE, "品牌");
        arrayList.add(hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("specification", "上架时间：\u3000");
        hashMap4.put(DomainCampaignEx.LOOPBACK_VALUE, "上架时间");
        arrayList.add(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put("specification", "商品毛重：\u3000");
        hashMap5.put(DomainCampaignEx.LOOPBACK_VALUE, "商品毛重");
        arrayList.add(hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put("specification", "库存：\u3000\u3000\u3000");
        hashMap6.put(DomainCampaignEx.LOOPBACK_VALUE, "库存");
        arrayList.add(hashMap6);
        HashMap hashMap7 = new HashMap();
        hashMap7.put("specification", "面料：\u3000\u3000\u3000");
        hashMap7.put(DomainCampaignEx.LOOPBACK_VALUE, "面料");
        arrayList.add(hashMap7);
        ((ListView) dialog.findViewById(2131232245)).setAdapter((ListAdapter) new C4946f(this.f1669h, C4215R.C4221layout.item_for_specifications, arrayList));
        ((ImageView) dialog.findViewById(2131231399)).setOnClickListener(new View$OnClickListenerC4947g(dialog));
    }

    /* renamed from: R0 */
    private void m40969R0() {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new C4954m()).open();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18206o.setOnSlideDetailsListener(new C4950i());
        this.f18215x.setOnClickListener(this);
        this.f18196G.setOnClickListener(this);
        this.f18197H.setOnClickListener(this);
        this.f18204m.setOnClickListener(this);
        this.f18192C.setOnClickListener(this);
        this.f18193D.setOnClickListener(this);
        this.f18194E.setOnClickListener(this);
        this.f18202k.setOnClickListener(this);
        this.f18195F.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_goods_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("goodsId")) {
            this.f18199J = getIntent().getStringExtra("goodsId");
        }
        m40978I0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("商品详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18202k = (FloatingActionButton) findViewById(C4215R.C4219id.fb_go_top);
        this.f18212u = (TextView) findViewById(C4215R.C4219id.tv_origin_price);
        this.f18206o = (SlideDetailsLayout) findViewById(C4215R.C4219id.f16009tb);
        this.f18207p = (ScrollView) findViewById(C4215R.C4219id.mHeader);
        this.f18208q = (ScrollView) findViewById(C4215R.C4219id.mFooter);
        this.f18209r = (LinearLayout) this.f18207p.getChildAt(0);
        this.f18210s = (CycleViewPager) findViewById(C4215R.C4219id.f15994cv);
        this.f18212u.getPaint().setFlags(16);
        SmartWebView smartWebView = (SmartWebView) findViewById(C4215R.C4219id.f16014wv);
        this.f18211t = smartWebView;
        smartWebView.m57493j("http://btblcn.com//mobi//commodity//details//de90164762b24a299f45a143e1dbe1ba");
        this.f18215x = (TextView) findViewById(C4215R.C4219id.tv_specifications);
        this.f18196G = (Button) findViewById(2131230950);
        this.f18197H = (Button) findViewById(C4215R.C4219id.bt_buy);
        this.f18217z = (TextView) findViewById(2131233040);
        this.f18190A = (TextView) findViewById(2131233101);
        this.f18213v = (TextView) findViewById(C4215R.C4219id.tv_stock);
        this.f18214w = (TextView) findViewById(C4215R.C4219id.tv_sale_num);
        this.f18203l = (RelativeLayout) findViewById(2131232527);
        this.f18191B = (TextView) findViewById(C4215R.C4219id.tv_indicator);
        this.f18204m = (LinearLayout) findViewById(C4215R.C4219id.ll_select);
        this.f18192C = (TextView) findViewById(C4215R.C4219id.tv_collect);
        this.f18195F = (TextView) findViewById(2131233089);
        this.f18193D = (TextView) findViewById(C4215R.C4219id.tv_cart);
        this.f18216y = (TextView) findViewById(C4215R.C4219id.tv_post_price_desc);
        this.f18194E = (TextView) findViewById(C4215R.C4219id.tv_share);
        this.f18205n = (LinearLayout) findViewById(C4215R.C4219id.ll_bottom_menu);
        this.f18198I = (Button) findViewById(C4215R.C4219id.bt_under_the_shelf);
        this.f18203l.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case 2131230950:
                m40971P0();
                return;
            case C4215R.C4219id.bt_buy /* 2131230957 */:
                m40971P0();
                return;
            case C4215R.C4219id.fb_go_top /* 2131231292 */:
                this.f18207p.smoothScrollTo(0, 0);
                this.f18206o.smoothClose(true);
                return;
            case C4215R.C4219id.ll_select /* 2131232223 */:
                m40971P0();
                return;
            case C4215R.C4219id.tv_cart /* 2131232894 */:
                new AuthorizationUtils(this.f1669h).m44322i(new C4952k()).m44329b(getSupportFragmentManager(), 0);
                return;
            case C4215R.C4219id.tv_collect /* 2131232908 */:
                new AuthorizationUtils(this.f1669h).m44322i(new C4951j()).m44329b(getSupportFragmentManager(), 0);
                return;
            case 2131233089:
                new iOSTwoButtonDialog(this.f1669h).setTitle("提示").setMessage(getString(2131821592)).setRightButtonOnClickListener(new C4953l()).show();
                return;
            case C4215R.C4219id.tv_share /* 2131233153 */:
                m40969R0();
                return;
            case C4215R.C4219id.tv_specifications /* 2131233161 */:
                m40970Q0();
                return;
            default:
                return;
        }
    }
}
