package com.acse.ottn;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class n {
    public static n M0 = null;
    public static String N0 = "AppPageNameUtil";

    /* renamed from: a  reason: collision with root package name */
    public boolean f5987a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f5989b = "com.taobao.android.detail.wrapper.activity.DetailActivity";

    /* renamed from: c  reason: collision with root package name */
    public String f5991c = "com.taobao.tao.detail.activity.DetailActivity";

    /* renamed from: d  reason: collision with root package name */
    public String f5993d = "com.taobao.android.tbabilitykit.pop.StdPopActivityGroup";

    /* renamed from: e  reason: collision with root package name */
    public String f5995e = "com.taobao.live.liveshop.detail.DTLiveShopDetailActivity";

    /* renamed from: f  reason: collision with root package name */
    public String f5997f = "com.taobao.android.detail.alittdetail.TTDetailActivity";

    /* renamed from: g  reason: collision with root package name */
    public String f5999g = "com.jd.lib.productdetail.ProductDetailActivity";

    /* renamed from: h  reason: collision with root package name */
    public String f6001h = "com.jd.lib.productdetail.ProductDetailPopActivity";

    /* renamed from: i  reason: collision with root package name */
    public String f6003i = "com.tmall.wireless.maintab.module.TMMainTabActivity";

    /* renamed from: j  reason: collision with root package name */
    public String f6005j = "com.tmall.wireless.xdetail.activity.TMXDetailActivity";

    /* renamed from: k  reason: collision with root package name */
    public String f6007k = "com.tmall.wireless.newdetail.activity.NewDetailActivity";

    /* renamed from: l  reason: collision with root package name */
    public String f6009l = "com.alibaba.triver.container.TriverMainActivity";

    /* renamed from: m  reason: collision with root package name */
    public String f6011m = "com.xunmeng.pinduoduo.activity.NewPageActivity";

    /* renamed from: n  reason: collision with root package name */
    public String f6013n = "com.xunmeng.pinduoduo.ui.activity.HomeActivity";

    /* renamed from: o  reason: collision with root package name */
    public String f6015o = "com.sankuai.waimai.business.restaurant.poicontainer.WMRestaurantActivity";

    /* renamed from: p  reason: collision with root package name */
    public String f6017p = "com.meituan.android.food.deal.FoodDealDetailActivity";

    /* renamed from: q  reason: collision with root package name */
    public String f6019q = "com.sankuai.waimai.business.page.homepage.MainActivity";

    /* renamed from: r  reason: collision with root package name */
    public String f6021r = "com.sankuai.waimai.business.page.homepage.TakeoutActivity";

    /* renamed from: s  reason: collision with root package name */
    public String f6023s = "com.meituan.android.takeout.library.business.main.homepage.TakeoutActivity";

    /* renamed from: t  reason: collision with root package name */
    public String f6025t = "me.ele.application.ui.Launcher.LauncherActivity";

    /* renamed from: u  reason: collision with root package name */
    public String f6027u = "com.alibaba.triver.container.TriverMainActivity";

    /* renamed from: v  reason: collision with root package name */
    public String f6029v = "me.ele.shopdetailv2.ShopDetailV2Activity";

    /* renamed from: w  reason: collision with root package name */
    public String f6031w = "me.ele.newretail.shop.RetailShopDetailActivity";

    /* renamed from: x  reason: collision with root package name */
    public String f6033x = "me.ele.search.XSearchActivity";

    /* renamed from: y  reason: collision with root package name */
    public String f6035y = "me.ele.newretail.muise.MuiseEShopActivity";

    /* renamed from: z  reason: collision with root package name */
    public String f6037z = "com.mc10086.cmcc.view.tabs.AppTabFragment";
    public String A = "com.sinovatech.unicom.basic.ui.activity.MainActivity";
    public String B = "com.ct.client.activity.MainActivity";
    public String C = "com.ct.client.widget.MyProgressDialogE";
    public String D = "com.tencent.qqlive.vc.VCPageActivity";
    public String E = "com.youku.android.paysdk.cashier.VipPaymentActivity";
    public String F = "com.starbucks.cn.home.revamp.RevampMainActivity";
    public String G = "com.achievo.vipshop.homepage.activity.MainActivity";
    public String H = "com.suning.mobile.ebuy.host.MainActivity";
    public String I = "com.sankuai.meituan.takeoutnew";
    public String J = "com.iqiyi.vipcashier.activity.PhonePayActivity";
    public String K = "org.qiyi.android.video.activitys.SecondPageActivity";

    /* renamed from: L  reason: collision with root package name */
    public String f5986L = "com.mgtv.ui.browser.WebActivity";
    public String M = "com.bilibili.app.vip.vip.buy.buypanel.VipBuyActivity";
    public String N = "com.bilibili.module.vip.web.VipWebActivity";
    public String O = "com.ximalaya.ting.android.host.activity.MainActivity";
    public String P = "com.jingdong.app.mall.MainFrameActivity";
    public String Q = "com.taobao.tao.TBMainActivity";
    public String R = "map.android.baidu.rentcaraar";
    public String S = "com.meituan.mmp.lib.HeraActivity";
    public String T = "com.sankuai.waimai.business.restaurant.goodsdetail.GoodDetailActivity";
    public String U = "com.sankuai.waimai.business.restaurant.poicontainer.WMRestaurantActivity";
    public String V = "com.sankuai.waimai.store.goods.list.SCSuperMarketActivity";
    public String W = "com.didi.sdk.app.MainActivity";
    public String X = "com.ximalaya.ting.android.host.activity.MainActivity";
    public String Y = "com.ss.android.ugc.aweme.main.MainActivity";
    public String Z = "com.ss.android.ugc.aweme.detail.ui.DetailActivity";

    /* renamed from: a0  reason: collision with root package name */
    public String f5988a0 = "com.huaxiaozhu.sdk.app.MainActivity";

    /* renamed from: b0  reason: collision with root package name */
    public String f5990b0 = "com.baidu.netdisk.ui.cloudp2p.RichMediaActivity";

    /* renamed from: c0  reason: collision with root package name */
    public String f5992c0 = "com.baidu.netdisk.advertise.ui.AdvertiseContentActivity";

    /* renamed from: d0  reason: collision with root package name */
    public String f5994d0 = "com.baidu.netdisk.ui.vipchannel.VipChannelActivity";

    /* renamed from: e0  reason: collision with root package name */
    public String f5996e0 = "com.yxcorp.gifshow.HomeActivity";

    /* renamed from: f0  reason: collision with root package name */
    public String f5998f0 = "com.zhihu.android.app.ui.activity.MainActivity";

    /* renamed from: g0  reason: collision with root package name */
    public String f6000g0 = "com.zhihu.android.mix.activity.ContentMixProfileActivity";

    /* renamed from: h0  reason: collision with root package name */
    public String f6002h0 = "com.xingin.xhs.index.v2.IndexActivityV2";

    /* renamed from: i0  reason: collision with root package name */
    public String f6004i0 = "com.zhihu.android";

    /* renamed from: j0  reason: collision with root package name */
    public String f6006j0 = "com.ximalaya";

    /* renamed from: k0  reason: collision with root package name */
    public String f6008k0 = "com.xingin.xhs";

    /* renamed from: l0  reason: collision with root package name */
    public String f6010l0 = "com.kuaishou.nebulam";

    /* renamed from: m0  reason: collision with root package name */
    public String f6012m0 = "com.smile.gifmakerm";

    /* renamed from: n0  reason: collision with root package name */
    public String f6014n0 = "com.baidu.netdiskm";

    /* renamed from: o0  reason: collision with root package name */
    public String f6016o0 = "com.ss.android.ugc.awemem";

    /* renamed from: p0  reason: collision with root package name */
    public String f6018p0 = "com.huaxiaozhu";

    /* renamed from: q0  reason: collision with root package name */
    public String f6020q0 = "com.taobao.taobao";

    /* renamed from: r0  reason: collision with root package name */
    public String f6022r0 = "com.tmall.wireless";

    /* renamed from: s0  reason: collision with root package name */
    public String f6024s0 = "com.jingdong.app.mall";

    /* renamed from: t0  reason: collision with root package name */
    public String f6026t0 = "com.xunmeng.pinduoduo.detail";

    /* renamed from: u0  reason: collision with root package name */
    public String f6028u0 = "com.xunmeng.pinduoduo.home";

    /* renamed from: v0  reason: collision with root package name */
    public String f6030v0 = "com.sankuai.meituan";

    /* renamed from: w0  reason: collision with root package name */
    public String f6032w0 = "me.didi";

    /* renamed from: x0  reason: collision with root package name */
    public String f6034x0 = "com.tencent.qqlive";

    /* renamed from: y0  reason: collision with root package name */
    public String f6036y0 = "com.youku.phone";

    /* renamed from: z0  reason: collision with root package name */
    public String f6038z0 = "com.sankuai.waimai.details";
    public String A0 = "me.ele";
    public String B0 = "com.starbucks.cn";
    public String C0 = "me.ele.detail";
    public String D0 = "com.qiyi.video";
    public String E0 = "com.taobao.tao.main";
    public String F0 = "com.tmall.wireless.main";
    public String G0 = "com.jingdong.app.mall.main";
    public String H0 = "com.suning.mobile.main";
    public String I0 = "com.ct.client.main";
    public String J0 = "com.sinovatech.unicom.main";
    public String K0 = "com.mc10086.cmcc.main";
    public String L0 = "com.achievo.vipshop.main";

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6039a;

        public a(Activity activity) {
            this.f6039a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            ClipData primaryClip = ((ClipboardManager) this.f6039a.getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemCount() <= 0) {
                return;
            }
            String charSequence = primaryClip.getItemAt(0).getText().toString();
            Log.d("ShopHelpManager", "getFromClipboard text=" + charSequence);
        }
    }

    public static n a() {
        if (M0 == null) {
            synchronized (n.class) {
                if (M0 == null) {
                    M0 = new n();
                }
            }
        }
        return M0;
    }

    public final Object b() throws ObjectStreamException {
        return M0;
    }

    public void a(Context context, String str) {
        z1.a("setClipboard", str);
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }

    public final void a(Activity activity) {
        try {
            activity.runOnUiThread(new a(activity));
        } catch (Exception e4) {
            z1.a("ShopHelpManager", "getFromClipboard error");
            e4.printStackTrace();
        }
    }
}
