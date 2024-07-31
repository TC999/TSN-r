package com.acse.ottn.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import java.io.ObjectStreamException;

/* renamed from: com.acse.ottn.util.H */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1631H {

    /* renamed from: a */
    private static C1631H f3153a = null;

    /* renamed from: b */
    private static String f3154b = "AppPageNameUtil";

    /* renamed from: c */
    private boolean f3196c = false;

    /* renamed from: d */
    public String f3198d = "com.taobao.android.detail.wrapper.activity.DetailActivity";

    /* renamed from: e */
    public String f3200e = "com.taobao.tao.detail.activity.DetailActivity";

    /* renamed from: f */
    public String f3202f = "com.taobao.android.tbabilitykit.pop.StdPopActivityGroup";

    /* renamed from: g */
    public String f3204g = "com.taobao.live.liveshop.detail.DTLiveShopDetailActivity";

    /* renamed from: h */
    public String f3206h = "com.jd.lib.productdetail.ProductDetailActivity";

    /* renamed from: i */
    public String f3208i = "com.jd.lib.productdetail.ProductDetailPopActivity";

    /* renamed from: j */
    public String f3210j = "com.tmall.wireless.maintab.module.TMMainTabActivity";

    /* renamed from: k */
    public String f3212k = "com.tmall.wireless.xdetail.activity.TMXDetailActivity";

    /* renamed from: l */
    public String f3214l = "com.tmall.wireless.newdetail.activity.NewDetailActivity";

    /* renamed from: m */
    public String f3216m = "com.alibaba.triver.container.TriverMainActivity";

    /* renamed from: n */
    public String f3218n = "com.xunmeng.pinduoduo.activity.NewPageActivity";

    /* renamed from: o */
    public String f3220o = "com.xunmeng.pinduoduo.ui.activity.HomeActivity";

    /* renamed from: p */
    public String f3222p = "com.sankuai.waimai.business.restaurant.poicontainer.WMRestaurantActivity";

    /* renamed from: q */
    public String f3224q = "com.meituan.android.food.deal.FoodDealDetailActivity";

    /* renamed from: r */
    public String f3226r = "com.sankuai.waimai.business.page.homepage.MainActivity";

    /* renamed from: s */
    public String f3228s = "com.sankuai.waimai.business.page.homepage.TakeoutActivity";

    /* renamed from: t */
    public String f3230t = "com.meituan.android.takeout.library.business.main.homepage.TakeoutActivity";

    /* renamed from: u */
    public String f3232u = "me.ele.application.ui.Launcher.LauncherActivity";

    /* renamed from: v */
    public String f3234v = "com.alibaba.triver.container.TriverMainActivity";

    /* renamed from: w */
    public String f3236w = "me.ele.shopdetailv2.ShopDetailV2Activity";

    /* renamed from: x */
    public String f3238x = "me.ele.newretail.shop.RetailShopDetailActivity";

    /* renamed from: y */
    public String f3240y = "me.ele.search.XSearchActivity";

    /* renamed from: z */
    public String f3242z = "me.ele.newretail.muise.MuiseEShopActivity";

    /* renamed from: A */
    public String f3155A = "com.mc10086.cmcc.view.tabs.AppTabFragment";

    /* renamed from: B */
    public String f3157B = "com.sinovatech.unicom.basic.ui.activity.MainActivity";

    /* renamed from: C */
    public String f3159C = "com.ct.client.activity.MainActivity";

    /* renamed from: D */
    public String f3161D = "com.ct.client.widget.MyProgressDialogE";

    /* renamed from: E */
    public String f3163E = "com.tencent.qqlive.vc.VCPageActivity";

    /* renamed from: F */
    public String f3165F = "com.youku.android.paysdk.cashier.VipPaymentActivity";

    /* renamed from: G */
    public String f3167G = "com.starbucks.cn.home.revamp.RevampMainActivity";

    /* renamed from: H */
    public String f3169H = "com.achievo.vipshop.homepage.activity.MainActivity";

    /* renamed from: I */
    public String f3171I = "com.suning.mobile.ebuy.host.MainActivity";

    /* renamed from: J */
    public String f3173J = "com.sankuai.meituan.takeoutnew";

    /* renamed from: K */
    public String f3175K = "com.iqiyi.vipcashier.activity.PhonePayActivity";

    /* renamed from: L */
    public String f3177L = "org.qiyi.android.video.activitys.SecondPageActivity";

    /* renamed from: M */
    public String f3179M = "com.mgtv.ui.browser.WebActivity";

    /* renamed from: N */
    public String f3181N = "com.bilibili.app.vip.vip.buy.buypanel.VipBuyActivity";

    /* renamed from: O */
    public String f3182O = "com.bilibili.module.vip.web.VipWebActivity";

    /* renamed from: P */
    public String f3183P = "com.ximalaya.ting.android.host.activity.MainActivity";

    /* renamed from: Q */
    public String f3184Q = "com.jingdong.app.mall.MainFrameActivity";

    /* renamed from: R */
    public String f3185R = "com.taobao.tao.TBMainActivity";

    /* renamed from: S */
    public String f3186S = "map.android.baidu.rentcaraar";

    /* renamed from: T */
    public String f3187T = "com.meituan.mmp.lib.HeraActivity";

    /* renamed from: U */
    public String f3188U = "com.sankuai.waimai.business.restaurant.goodsdetail.GoodDetailActivity";

    /* renamed from: V */
    public String f3189V = "com.sankuai.waimai.business.restaurant.poicontainer.WMRestaurantActivity";

    /* renamed from: W */
    public String f3190W = "com.sankuai.waimai.store.goods.list.SCSuperMarketActivity";

    /* renamed from: X */
    public String f3191X = "com.didi.sdk.app.MainActivity";

    /* renamed from: Y */
    public String f3192Y = "com.ximalaya.ting.android.host.activity.MainActivity";

    /* renamed from: Z */
    public String f3193Z = "com.ss.android.ugc.aweme.main.MainActivity";

    /* renamed from: aa */
    public String f3194aa = "com.ss.android.ugc.aweme.detail.ui.DetailActivity";

    /* renamed from: ba */
    public String f3195ba = "com.huaxiaozhu.sdk.app.MainActivity";

    /* renamed from: ca */
    public String f3197ca = "com.baidu.netdisk.ui.cloudp2p.RichMediaActivity";

    /* renamed from: da */
    public String f3199da = "com.baidu.netdisk.advertise.ui.AdvertiseContentActivity";

    /* renamed from: ea */
    public String f3201ea = "com.baidu.netdisk.ui.vipchannel.VipChannelActivity";

    /* renamed from: fa */
    public String f3203fa = "com.yxcorp.gifshow.HomeActivity";

    /* renamed from: ga */
    public String f3205ga = "com.zhihu.android.app.ui.activity.MainActivity";

    /* renamed from: ha */
    public String f3207ha = "com.zhihu.android.mix.activity.ContentMixProfileActivity";

    /* renamed from: ia */
    public String f3209ia = "com.xingin.xhs.index.v2.IndexActivityV2";

    /* renamed from: ja */
    public String f3211ja = "com.zhihu.android";

    /* renamed from: ka */
    public String f3213ka = "com.ximalaya";

    /* renamed from: la */
    public String f3215la = "com.xingin.xhs";

    /* renamed from: ma */
    public String f3217ma = "com.kuaishou.nebulam";

    /* renamed from: na */
    public String f3219na = "com.smile.gifmakerm";

    /* renamed from: oa */
    public String f3221oa = "com.baidu.netdiskm";

    /* renamed from: pa */
    public String f3223pa = "com.ss.android.ugc.awemem";

    /* renamed from: qa */
    public String f3225qa = "com.huaxiaozhu";

    /* renamed from: ra */
    public String f3227ra = "com.taobao.taobao";

    /* renamed from: sa */
    public String f3229sa = "com.tmall.wireless";

    /* renamed from: ta */
    public String f3231ta = "com.jingdong.app.mall";

    /* renamed from: ua */
    public String f3233ua = "com.xunmeng.pinduoduo.detail";

    /* renamed from: va */
    public String f3235va = "com.xunmeng.pinduoduo.home";

    /* renamed from: wa */
    public String f3237wa = "com.sankuai.meituan";

    /* renamed from: xa */
    public String f3239xa = "me.didi";

    /* renamed from: ya */
    public String f3241ya = "com.tencent.qqlive";

    /* renamed from: za */
    public String f3243za = "com.youku.phone";

    /* renamed from: Aa */
    public String f3156Aa = "com.sankuai.waimai.details";

    /* renamed from: Ba */
    public String f3158Ba = "me.ele";

    /* renamed from: Ca */
    public String f3160Ca = "com.starbucks.cn";

    /* renamed from: Da */
    public String f3162Da = "me.ele.detail";

    /* renamed from: Ea */
    public String f3164Ea = "com.qiyi.video";

    /* renamed from: Fa */
    public String f3166Fa = "com.taobao.tao.main";

    /* renamed from: Ga */
    public String f3168Ga = "com.tmall.wireless.main";

    /* renamed from: Ha */
    public String f3170Ha = "com.jingdong.app.mall.main";

    /* renamed from: Ia */
    public String f3172Ia = "com.suning.mobile.main";

    /* renamed from: Ja */
    public String f3174Ja = "com.ct.client.main";

    /* renamed from: Ka */
    public String f3176Ka = "com.sinovatech.unicom.main";

    /* renamed from: La */
    public String f3178La = "com.mc10086.cmcc.main";

    /* renamed from: Ma */
    public String f3180Ma = "com.achievo.vipshop.main";

    private C1631H() {
    }

    /* renamed from: a */
    public static C1631H m56262a() {
        if (f3153a == null) {
            synchronized (C1631H.class) {
                if (f3153a == null) {
                    f3153a = new C1631H();
                }
            }
        }
        return f3153a;
    }

    /* renamed from: a */
    private void m56261a(Activity activity) {
        try {
            activity.runOnUiThread(new RunnableC1629G(this, activity));
        } catch (Exception e) {
            C1694ra.m55917a("ShopHelpManager", "getFromClipboard error");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private Object m56259b() throws ObjectStreamException {
        return f3153a;
    }

    /* renamed from: a */
    public void m56260a(Context context, String str) {
        C1694ra.m55917a("setClipboard", str);
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }
}
