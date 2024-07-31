package p635q;

import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: q.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface MallApiService {

    /* renamed from: a */
    public static final String f44529a = "https://mall.boxkj.com/";

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/weixinpayController/appPay")
    /* renamed from: A */
    Observable<Response<ResponseBody>> m2252A(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getUserShoppingCarNum")
    /* renamed from: B */
    Observable<Response<ResponseBody>> m2251B(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/findUserfavorites")
    /* renamed from: C */
    Observable<Response<ResponseBody>> m2250C(@Field("keyword") String str, @Field("userId") String str2, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getSettlementCenter1")
    /* renamed from: D */
    Observable<Response<ResponseBody>> m2249D(@Field("regionUserId") String str, @Field("ids") String str2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getUserShoppingCarList")
    /* renamed from: E */
    Observable<Response<ResponseBody>> m2248E(@Field("regionUserId") String str);

    @POST("https://mall.boxkj.com/app/show/loadFirstGoodsType")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m2247a();

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/confirmReceipt")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m2246b(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadSecondGoodsRelative")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m2245c(@Field("firstTypeId") String str, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getReceiveAddressList")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m2244d(@Field("regionUserId") String str, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadCityStandard")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m2243e(@Field("parentId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/deleteReceiveAddress")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m2242f(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/batchUpdateUserShoppingCar")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m2241g(@Field("data") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/alipayController/appPay")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m2240h(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/deleteShoppingCar")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m2239i(@Field("ids") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/addCommodityToShoppingCar")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m2238j(@Field("regionUserId") String str, @Field("commId") String str2, @Field("modelId") String str3, @Field("commNum") int i);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadCommodityDetail")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m2237k(@Field("commId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/deleteOrder")
    /* renamed from: l */
    Observable<Response<ResponseBody>> m2236l(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/cancelOrder")
    /* renamed from: m */
    Observable<Response<ResponseBody>> m2235m(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadOrderDetail")
    /* renamed from: n */
    Observable<Response<ResponseBody>> m2234n(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/addReceiveAddress")
    /* renamed from: o */
    Observable<Response<ResponseBody>> m2233o(@Field("id") String str, @Field("regionUserId") String str2, @Field("cityId") String str3, @Field("detailAddress") String str4, @Field("receiverName") String str5, @Field("receiverPhone") String str6);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getSettlementCenter2")
    /* renamed from: p */
    Observable<Response<ResponseBody>> m2232p(@Field("regionUserId") String str, @Field("commId") String str2, @Field("modelId") String str3, @Field("commNum") int i);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/askForRefund")
    /* renamed from: q */
    Observable<Response<ResponseBody>> m2231q(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/favoriteComm")
    /* renamed from: r */
    Observable<Response<ResponseBody>> m2230r(@Field("commId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadCommodityList")
    /* renamed from: s */
    Observable<Response<ResponseBody>> m2229s(@Field("typeId") String str, @Field("keyword") String str2, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/user/userHasGranted")
    /* renamed from: t */
    Observable<Response<ResponseBody>> m2228t(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/generatingOrder")
    /* renamed from: u */
    Observable<Response<ResponseBody>> m2227u(@Field("ids") String str, @Field("addressId") String str2, @Field("memo") String str3, @Field("comm") String str4);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getUserOrders")
    /* renamed from: v */
    Observable<Response<ResponseBody>> m2226v(@Field("orderMode") String str, @Field("regionUserId") String str2, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/setDefaultAddress")
    /* renamed from: w */
    Observable<Response<ResponseBody>> m2225w(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/clearUserfavorites")
    /* renamed from: x */
    Observable<Response<ResponseBody>> m2224x(@Field("userId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadLoggicInfo")
    /* renamed from: y */
    Observable<Response<ResponseBody>> m2223y(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/user/grantUser")
    /* renamed from: z */
    Observable<Response<ResponseBody>> m2222z(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);
}
