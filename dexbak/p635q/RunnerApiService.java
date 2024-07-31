package p635q;

import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: q.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface RunnerApiService {

    /* renamed from: a */
    public static final String f44530a = "https://w.boxkj.com/";

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskOrder/appMyDeliverTaskOrderList")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m2221a(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderStatus") String str3, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverSettleAccount/getDeliverWithdrawMoney")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m2220b(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverSettleAccount/getIncomeDeliverMoney")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m2219c(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/updateDeliverTaskPublishStatus")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m2218d(@Field("schoolId") String str, @Field("userId") String str2, @Field("taskStatus") String str3, @Field("taskId") String str4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/weixinpayController/appPay")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m2217e(@Field("taskId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/userPt/userHasGranted")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m2216f(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskOrder/addDeliverTaskOrder")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m2215g(@Field("taskId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskAppraise/addDeliverTaskAppraise")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m2214h(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3, @Field("appraiseStar") String str4, @Field("appraiseContent") String str5, @Field("images") String str6, @Field("imgNames") String str7);

    @POST("https://w.boxkj.com/app/appDeliverItemType/getAllItemType")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m2213i();

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskOrder/updateDeliverTaskOrderStatus")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m2212j(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/alipayController/appPay")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m2211k(@Field("taskId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/userPt/grantUser")
    /* renamed from: l */
    Observable<Response<ResponseBody>> m2210l(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskProcess/addDeliverTaskFinishProcess")
    /* renamed from: m */
    Observable<Response<ResponseBody>> m2209m(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3, @Field("taskCode") String str4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverUserBasicInfo/getDeliverUserBasicInfo")
    /* renamed from: n */
    Observable<Response<ResponseBody>> m2208n(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/addDeliverTaskPublish")
    /* renamed from: o */
    Observable<Response<ResponseBody>> m2207o(@Field("taskName") String str, @Field("taskContent") String str2, @Field("goodsTypeId") String str3, @Field("schoolId") String str4, @Field("userId") String str5, @Field("publishUser") String str6, @Field("publishTelPhone") String str7, @Field("taskStartAddress") String str8, @Field("startLat") String str9, @Field("startLng") String str10, @Field("taskStartTime") String str11, @Field("receverUser") String str12, @Field("receverTelPhone") String str13, @Field("taskEndAddress") String str14, @Field("endLat") String str15, @Field("endLng") String str16, @Field("taskEndTime") String str17, @Field("taskPrice") String str18);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/getDeliverTaskPublish")
    /* renamed from: p */
    Observable<Response<ResponseBody>> m2206p(@Field("taskId") String str, @Field("orderId") String str2, @Field("schoolId") String str3, @Field("userId") String str4);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverSettleAccount/getExpendDeliverMoney")
    /* renamed from: q */
    Observable<Response<ResponseBody>> m2205q(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskProcess/addDelivertaskTakeProcess")
    /* renamed from: r */
    Observable<Response<ResponseBody>> m2204r(@Field("schoolId") String str, @Field("userId") String str2, @Field("orderId") String str3, @Field("images") String str4, @Field("imgNames") String str5);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/appMyDeliverTaskPublishList")
    /* renamed from: s */
    Observable<Response<ResponseBody>> m2203s(@Field("schoolId") String str, @Field("userId") String str2, @Field("taskStatus") String str3, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverTaskPublish/appDeliverTaskPublishList")
    /* renamed from: t */
    Observable<Response<ResponseBody>> m2202t(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/AppDeliverWithdrawApply/addDeliverWithdrawApplyRecord")
    /* renamed from: u */
    Observable<Response<ResponseBody>> m2201u(@Field("schoolId") String str, @Field("userId") String str2, @Field("withDrawMoney") double d);

    @FormUrlEncoded
    @POST("https://w.boxkj.com/app/appDeliverUserBasicInfo/addDeliverUserBasicInfo")
    /* renamed from: v */
    Observable<Response<ResponseBody>> m2200v(@Field("schoolId") String str, @Field("userId") String str2, @Field("telPhone") String str3, @Field("birthday") String str4, @Field("identificate") String str5, @Field("userAddress") String str6, @Field("cardFrontImg") String str7, @Field("cardReverseImg") String str8, @Field("cardHandImg") String str9);
}
