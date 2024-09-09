package com.acse.ottn.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class H {

    /* renamed from: a  reason: collision with root package name */
    private static H f6726a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6727b = "AppPageNameUtil";

    /* renamed from: c  reason: collision with root package name */
    private boolean f6729c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f6730d = "com.taobao.android.detail.wrapper.activity.DetailActivity";

    /* renamed from: e  reason: collision with root package name */
    public String f6731e = "com.taobao.tao.detail.activity.DetailActivity";

    /* renamed from: f  reason: collision with root package name */
    public String f6732f = "com.taobao.android.tbabilitykit.pop.StdPopActivityGroup";

    /* renamed from: g  reason: collision with root package name */
    public String f6733g = "com.taobao.live.liveshop.detail.DTLiveShopDetailActivity";

    /* renamed from: h  reason: collision with root package name */
    public String f6734h = "com.jd.lib.productdetail.ProductDetailActivity";

    /* renamed from: i  reason: collision with root package name */
    public String f6735i = "com.jd.lib.productdetail.ProductDetailPopActivity";

    /* renamed from: j  reason: collision with root package name */
    public String f6736j = "com.tmall.wireless.maintab.module.TMMainTabActivity";

    /* renamed from: k  reason: collision with root package name */
    public String f6737k = "com.tmall.wireless.xdetail.activity.TMXDetailActivity";

    /* renamed from: l  reason: collision with root package name */
    public String f6738l = "com.tmall.wireless.newdetail.activity.NewDetailActivity";

    /* renamed from: m  reason: collision with root package name */
    public String f6739m = "com.alibaba.triver.container.TriverMainActivity";

    /* renamed from: n  reason: collision with root package name */
    public String f6740n = "com.xunmeng.pinduoduo.activity.NewPageActivity";

    /* renamed from: o  reason: collision with root package name */
    public String f6741o = "com.xunmeng.pinduoduo.ui.activity.HomeActivity";

    /* renamed from: p  reason: collision with root package name */
    public String f6742p = "com.sankuai.waimai.business.restaurant.poicontainer.WMRestaurantActivity";

    /* renamed from: q  reason: collision with root package name */
    public String f6743q = "com.meituan.android.food.deal.FoodDealDetailActivity";

    /* renamed from: r  reason: collision with root package name */
    public String f6745r = "com.sankuai.waimai.business.page.homepage.MainActivity";

    /* renamed from: s  reason: collision with root package name */
    public String f6746s = "com.sankuai.waimai.business.page.homepage.TakeoutActivity";

    /* renamed from: t  reason: collision with root package name */
    public String f6747t = "com.meituan.android.takeout.library.business.main.homepage.TakeoutActivity";

    /* renamed from: u  reason: collision with root package name */
    public String f6748u = "me.ele.application.ui.Launcher.LauncherActivity";

    /* renamed from: v  reason: collision with root package name */
    public String f6749v = "com.alibaba.triver.container.TriverMainActivity";

    /* renamed from: w  reason: collision with root package name */
    public String f6750w = "me.ele.shopdetailv2.ShopDetailV2Activity";

    /* renamed from: x  reason: collision with root package name */
    public String f6751x = "me.ele.newretail.shop.RetailShopDetailActivity";

    /* renamed from: y  reason: collision with root package name */
    public String f6752y = "me.ele.search.XSearchActivity";

    /* renamed from: z  reason: collision with root package name */
    public String f6753z = "me.ele.newretail.muise.MuiseEShopActivity";
    public String A = "com.mc10086.cmcc.view.tabs.AppTabFragment";
    public String B = "com.sinovatech.unicom.basic.ui.activity.MainActivity";
    public String C = "com.ct.client.activity.MainActivity";
    public String D = "com.ct.client.widget.MyProgressDialogE";
    public String E = "com.tencent.qqlive.vc.VCPageActivity";
    public String F = "com.youku.android.paysdk.cashier.VipPaymentActivity";
    public String G = "com.starbucks.cn.home.revamp.RevampMainActivity";
    public String H = "com.achievo.vipshop.homepage.activity.MainActivity";
    public String I = "com.suning.mobile.ebuy.host.MainActivity";
    public String J = "com.sankuai.meituan.takeoutnew";
    public String K = "com.iqiyi.vipcashier.activity.PhonePayActivity";

    /* renamed from: L  reason: collision with root package name */
    public String f6728L = "org.qiyi.android.video.activitys.SecondPageActivity";
    public String M = "com.mgtv.ui.browser.WebActivity";
    public String N = "com.bilibili.app.vip.vip.buy.buypanel.VipBuyActivity";
    public String O = "com.bilibili.module.vip.web.VipWebActivity";
    public String P = "com.ximalaya.ting.android.host.activity.MainActivity";
    public String Q = "com.jingdong.app.mall.MainFrameActivity";
    public String R = "com.taobao.tao.TBMainActivity";
    public String S = "map.android.baidu.rentcaraar";
    public String T = "com.meituan.mmp.lib.HeraActivity";
    public String U = "com.sankuai.waimai.business.restaurant.goodsdetail.GoodDetailActivity";
    public String V = "com.sankuai.waimai.business.restaurant.poicontainer.WMRestaurantActivity";
    public String W = "com.sankuai.waimai.store.goods.list.SCSuperMarketActivity";
    public String X = "com.didi.sdk.app.MainActivity";
    public String Y = "com.ximalaya.ting.android.host.activity.MainActivity";
    public String Z = "com.ss.android.ugc.aweme.main.MainActivity";
    public String aa = "com.ss.android.ugc.aweme.detail.ui.DetailActivity";
    public String ba = "com.huaxiaozhu.sdk.app.MainActivity";
    public String ca = "com.baidu.netdisk.ui.cloudp2p.RichMediaActivity";
    public String da = "com.baidu.netdisk.advertise.ui.AdvertiseContentActivity";
    public String ea = "com.baidu.netdisk.ui.vipchannel.VipChannelActivity";
    public String fa = "com.yxcorp.gifshow.HomeActivity";
    public String ga = "com.zhihu.android.app.ui.activity.MainActivity";
    public String ha = "com.zhihu.android.mix.activity.ContentMixProfileActivity";
    public String ia = "com.xingin.xhs.index.v2.IndexActivityV2";
    public String ja = "com.zhihu.android";
    public String ka = "com.ximalaya";
    public String la = "com.xingin.xhs";
    public String ma = "com.kuaishou.nebulam";
    public String na = "com.smile.gifmakerm";
    public String oa = "com.baidu.netdiskm";
    public String pa = "com.ss.android.ugc.awemem";

    /* renamed from: qa  reason: collision with root package name */
    public String f6744qa = "com.huaxiaozhu";
    public String ra = "com.taobao.taobao";
    public String sa = "com.tmall.wireless";
    public String ta = "com.jingdong.app.mall";
    public String ua = "com.xunmeng.pinduoduo.detail";
    public String va = "com.xunmeng.pinduoduo.home";
    public String wa = "com.sankuai.meituan";
    public String xa = "me.didi";
    public String ya = "com.tencent.qqlive";
    public String za = "com.youku.phone";
    public String Aa = "com.sankuai.waimai.details";
    public String Ba = "me.ele";
    public String Ca = "com.starbucks.cn";
    public String Da = "me.ele.detail";
    public String Ea = "com.qiyi.video";
    public String Fa = "com.taobao.tao.main";
    public String Ga = "com.tmall.wireless.main";
    public String Ha = "com.jingdong.app.mall.main";
    public String Ia = "com.suning.mobile.main";
    public String Ja = "com.ct.client.main";
    public String Ka = "com.sinovatech.unicom.main";
    public String La = "com.mc10086.cmcc.main";
    public String Ma = "com.achievo.vipshop.main";

    private H() {
    }

    public static H a() {
        if (f6726a == null) {
            synchronized (H.class) {
                if (f6726a == null) {
                    f6726a = new H();
                }
            }
        }
        return f6726a;
    }

    private void a(Activity activity) {
        try {
            activity.runOnUiThread(new G(this, activity));
        } catch (Exception e4) {
            ra.a("ShopHelpManager", "getFromClipboard error");
            e4.printStackTrace();
        }
    }

    private Object b() throws ObjectStreamException {
        return f6726a;
    }

    public void a(Context context, String str) {
        ra.a("setClipboard", str);
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }
}
