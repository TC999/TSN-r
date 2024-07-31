package p635q;

import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: q.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface MainApiService {

    /* renamed from: a */
    public static final String f44526a = "https://m.boxkj.com/";

    /* renamed from: b */
    public static final String f44527b = "e8167ef026cbc5e456ab837d9d6d9254";

    /* renamed from: c */
    public static final String f44528c = "bxkj2018";

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/bindDevice/unBindDevice")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m2276a(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/admin/studentAppUpdate/stuAppVersion2")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m2275b(@Field("schoolId") String str, @Field("appSign") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/getReplyFeedBackByUserId")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m2274c(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/api/permission/getPermission")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m2273d(@Field("schoolId") String str, @Field("userNum") String str2, @Field("pid") int i);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/uploadVideo/loadSchoolUploadVideo")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m2272e(@Field("schoolId") String str, @Field("keyword") String str2, @Field("typeId") String str3, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sys/addintegral")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m2271f(@Field("schoolId") String str, @Field("userNum") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/admin/appUpdate/teaAppVersion2")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m2270g(@Field("schoolId") String str, @Field("type") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/getReplyFeedBackCountUser")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m2269h(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/uploadVideo/loadUploadVideoDetail")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m2268i(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/uploadVideo/loadVideoType")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m2267j(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sch/getSchoolById")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m2266k(@Field("schoolId") String str);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/addReplyFeedBack")
    /* renamed from: l */
    Observable<Response<ResponseBody>> m2265l(@Field("feedBackId") String str, @Field("userId") String str2, @Field("replyContent") String str3);

    @POST("https://m.boxkj.com/app/province/findAllProvince")
    /* renamed from: m */
    Observable<Response<ResponseBody>> m2264m();

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sys/sumIntegralAndIsSign")
    /* renamed from: n */
    Observable<Response<ResponseBody>> m2263n(@Field("schoolId") String str, @Field("userNum") String str2, @Field("name") String str3);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/getReplyFeedBackBySuId")
    /* renamed from: o */
    Observable<Response<ResponseBody>> m2262o(@Field("feedBackId") String str, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/appadverties/addappadverties")
    /* renamed from: p */
    Observable<Response<ResponseBody>> m2261p(@Field("advertiesId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/admin/analysis/addUploadRecord")
    /* renamed from: q */
    Observable<Response<ResponseBody>> m2260q(@Field("schoolId") Integer num, @Field("platform") Integer num2, @Field("deviceId") String str, @Field("brandName") String str2, @Field("deviceNum") String str3, @Field("sysUserId") String str4, @Field("versionName") String str5);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/bindDevice/validateDeviceBind")
    /* renamed from: r */
    Observable<Response<ResponseBody>> m2259r(@Field("schoolId") String str, @Field("userNum") String str2, @Field("code") String str3, @Field("manufacturer") String str4, @Field("model") String str5, @Field("platform") String str6);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/addReplyFeedBack2")
    /* renamed from: s */
    Observable<Response<ResponseBody>> m2258s(@Field("appVersion") String str, @Field("platform") String str2, @Field("schoolId") String str3, @Field("feedbackContent") String str4, @Field("userId") String str5, @Field("phone") String str6, @Field("fileName") String str7, @Field("images") String str8, @Field("type") String str9);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/addReplyFeedBack2")
    /* renamed from: t */
    Observable<Response<ResponseBody>> m2257t(@Field("schoolId") String str, @Field("userId") String str2, @Field("appVersion") String str3, @Field("platform") String str4, @Field("replyContent") String str5, @Field("fileName") String str6, @Field("userName") String str7, @Field("userNum") String str8, @Field("userPhone") String str9);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sysFeedback/getFeedBackByUid")
    /* renamed from: u */
    Observable<Response<ResponseBody>> m2256u(@Field("userId") String str, @Field("schoolId") String str2, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/bindDevice/getBindDevicePagerData")
    /* renamed from: v */
    Observable<Response<ResponseBody>> m2255v(@Field("schoolId") String str, @Field("keys") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sys/integralInfo")
    /* renamed from: w */
    Observable<Response<ResponseBody>> m2254w(@Field("schoolId") String str, @Field("userNum") String str2, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sch/listSchoolByProvinceId")
    /* renamed from: x */
    Observable<Response<ResponseBody>> m2253x(@Field("provinceId") String str);
}
