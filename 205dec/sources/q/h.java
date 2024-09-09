package q;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: RunnerApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61947a = "https://w.boxkj.com/";

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskOrder/appMyDeliverTaskOrderList")
    rx.e<Response<ResponseBody>> a(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderStatus") String str3, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverSettleAccount/getDeliverWithdrawMoney")
    rx.e<Response<ResponseBody>> b(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverSettleAccount/getIncomeDeliverMoney")
    rx.e<Response<ResponseBody>> c(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/updateDeliverTaskPublishStatus")
    rx.e<Response<ResponseBody>> d(@Field("schoolId") String str, @Field("userId") String str2, @Field("taskStatus") String str3, @Field("taskId") String str4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/weixinpayController/appPay")
    rx.e<Response<ResponseBody>> e(@Field("taskId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/userPt/userHasGranted")
    rx.e<Response<ResponseBody>> f(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskOrder/addDeliverTaskOrder")
    rx.e<Response<ResponseBody>> g(@Field("taskId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskAppraise/addDeliverTaskAppraise")
    rx.e<Response<ResponseBody>> h(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3, @Field("appraiseStar") String str4, @Field("appraiseContent") String str5, @Field("images") String str6, @Field("imgNames") String str7);

    @POST("https://w.boxkj.com/app/appDeliverItemType/getAllItemType")
    rx.e<Response<ResponseBody>> i();

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskOrder/updateDeliverTaskOrderStatus")
    rx.e<Response<ResponseBody>> j(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/alipayController/appPay")
    rx.e<Response<ResponseBody>> k(@Field("taskId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/userPt/grantUser")
    rx.e<Response<ResponseBody>> l(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskProcess/addDeliverTaskFinishProcess")
    rx.e<Response<ResponseBody>> m(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3, @Field("taskCode") String str4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverUserBasicInfo/getDeliverUserBasicInfo")
    rx.e<Response<ResponseBody>> n(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/addDeliverTaskPublish")
    rx.e<Response<ResponseBody>> o(@Field("taskName") String str, @Field("taskContent") String str2, @Field("goodsTypeId") String str3, @Field("schoolId") String str4, @Field("userId") String str5, @Field("publishUser") String str6, @Field("publishTelPhone") String str7, @Field("taskStartAddress") String str8, @Field("startLat") String str9, @Field("startLng") String str10, @Field("taskStartTime") String str11, @Field("receverUser") String str12, @Field("receverTelPhone") String str13, @Field("taskEndAddress") String str14, @Field("endLat") String str15, @Field("endLng") String str16, @Field("taskEndTime") String str17, @Field("taskPrice") String str18);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/getDeliverTaskPublish")
    rx.e<Response<ResponseBody>> p(@Field("taskId") String str, @Field("orderId") String str2, @Field("schoolId") String str3, @Field("userId") String str4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverSettleAccount/getExpendDeliverMoney")
    rx.e<Response<ResponseBody>> q(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskProcess/addDelivertaskTakeProcess")
    rx.e<Response<ResponseBody>> r(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3, @Field("images") String str4, @Field("imgNames") String str5);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/appMyDeliverTaskPublishList")
    rx.e<Response<ResponseBody>> s(@Field("schoolId") String str, @Field("userId") String str2, @Field("taskStatus") String str3, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/appDeliverTaskPublishList")
    rx.e<Response<ResponseBody>> t(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverWithdrawApply/addDeliverWithdrawApplyRecord")
    rx.e<Response<ResponseBody>> u(@Field("schoolId") String str, @Field("userId") String str2, @Field("withDrawMoney") double d4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverUserBasicInfo/addDeliverUserBasicInfo")
    rx.e<Response<ResponseBody>> v(@Field("schoolId") String str, @Field("userId") String str2, @Field("telPhone") String str3, @Field("birthday") String str4, @Field("identificate") String str5, @Field("userAddress") String str6, @Field("cardFrontImg") String str7, @Field("cardReverseImg") String str8, @Field("cardHandImg") String str9);
}
