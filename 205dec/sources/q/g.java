package q;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: MallApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61946a = "https://mall.boxkj.com/";

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/weixinpayController/appPay")
    rx.e<Response<ResponseBody>> A(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getUserShoppingCarNum")
    rx.e<Response<ResponseBody>> B(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/findUserfavorites")
    rx.e<Response<ResponseBody>> C(@Field("keyword") String str, @Field("userId") String str2, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getSettlementCenter1")
    rx.e<Response<ResponseBody>> D(@Field("regionUserId") String str, @Field("ids") String str2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getUserShoppingCarList")
    rx.e<Response<ResponseBody>> E(@Field("regionUserId") String str);

    @POST("https://mall.boxkj.com/app/show/loadFirstGoodsType")
    rx.e<Response<ResponseBody>> a();

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/confirmReceipt")
    rx.e<Response<ResponseBody>> b(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadSecondGoodsRelative")
    rx.e<Response<ResponseBody>> c(@Field("firstTypeId") String str, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getReceiveAddressList")
    rx.e<Response<ResponseBody>> d(@Field("regionUserId") String str, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadCityStandard")
    rx.e<Response<ResponseBody>> e(@Field("parentId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/deleteReceiveAddress")
    rx.e<Response<ResponseBody>> f(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/batchUpdateUserShoppingCar")
    rx.e<Response<ResponseBody>> g(@Field("data") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/alipayController/appPay")
    rx.e<Response<ResponseBody>> h(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/deleteShoppingCar")
    rx.e<Response<ResponseBody>> i(@Field("ids") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/addCommodityToShoppingCar")
    rx.e<Response<ResponseBody>> j(@Field("regionUserId") String str, @Field("commId") String str2, @Field("modelId") String str3, @Field("commNum") int i4);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadCommodityDetail")
    rx.e<Response<ResponseBody>> k(@Field("commId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/deleteOrder")
    rx.e<Response<ResponseBody>> l(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/cancelOrder")
    rx.e<Response<ResponseBody>> m(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadOrderDetail")
    rx.e<Response<ResponseBody>> n(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/addReceiveAddress")
    rx.e<Response<ResponseBody>> o(@Field("id") String str, @Field("regionUserId") String str2, @Field("cityId") String str3, @Field("detailAddress") String str4, @Field("receiverName") String str5, @Field("receiverPhone") String str6);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getSettlementCenter2")
    rx.e<Response<ResponseBody>> p(@Field("regionUserId") String str, @Field("commId") String str2, @Field("modelId") String str3, @Field("commNum") int i4);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/askForRefund")
    rx.e<Response<ResponseBody>> q(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/favoriteComm")
    rx.e<Response<ResponseBody>> r(@Field("commId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadCommodityList")
    rx.e<Response<ResponseBody>> s(@Field("typeId") String str, @Field("keyword") String str2, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/user/userHasGranted")
    rx.e<Response<ResponseBody>> t(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/generatingOrder")
    rx.e<Response<ResponseBody>> u(@Field("ids") String str, @Field("addressId") String str2, @Field("memo") String str3, @Field("comm") String str4);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/getUserOrders")
    rx.e<Response<ResponseBody>> v(@Field("orderMode") String str, @Field("regionUserId") String str2, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/setDefaultAddress")
    rx.e<Response<ResponseBody>> w(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/clearUserfavorites")
    rx.e<Response<ResponseBody>> x(@Field("userId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/show/loadLoggicInfo")
    rx.e<Response<ResponseBody>> y(@Field("orderId") String str);

    @FormUrlEncoded
    @POST("https://mall.boxkj.com/app/user/grantUser")
    rx.e<Response<ResponseBody>> z(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);
}
