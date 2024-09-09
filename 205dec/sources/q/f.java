package q;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: MainApiService.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61943a = "https://m.boxkj.com/";

    /* renamed from: b  reason: collision with root package name */
    public static final String f61944b = "e8167ef026cbc5e456ab837d9d6d9254";

    /* renamed from: c  reason: collision with root package name */
    public static final String f61945c = "bxkj2018";

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/bindDevice/unBindDevice")
    rx.e<Response<ResponseBody>> a(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/admin/studentAppUpdate/stuAppVersion2")
    rx.e<Response<ResponseBody>> b(@Field("schoolId") String str, @Field("appSign") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/getReplyFeedBackByUserId")
    rx.e<Response<ResponseBody>> c(@Field("schoolId") String str, @Field("userId") String str2, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/api/permission/getPermission")
    rx.e<Response<ResponseBody>> d(@Field("schoolId") String str, @Field("userNum") String str2, @Field("pid") int i4);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/uploadVideo/loadSchoolUploadVideo")
    rx.e<Response<ResponseBody>> e(@Field("schoolId") String str, @Field("keyword") String str2, @Field("typeId") String str3, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sys/addintegral")
    rx.e<Response<ResponseBody>> f(@Field("schoolId") String str, @Field("userNum") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/admin/appUpdate/teaAppVersion2")
    rx.e<Response<ResponseBody>> g(@Field("schoolId") String str, @Field("type") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/getReplyFeedBackCountUser")
    rx.e<Response<ResponseBody>> h(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/uploadVideo/loadUploadVideoDetail")
    rx.e<Response<ResponseBody>> i(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/uploadVideo/loadVideoType")
    rx.e<Response<ResponseBody>> j(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sch/getSchoolById")
    rx.e<Response<ResponseBody>> k(@Field("schoolId") String str);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/addReplyFeedBack")
    rx.e<Response<ResponseBody>> l(@Field("feedBackId") String str, @Field("userId") String str2, @Field("replyContent") String str3);

    @POST("https://m.boxkj.com/app/province/findAllProvince")
    rx.e<Response<ResponseBody>> m();

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sys/sumIntegralAndIsSign")
    rx.e<Response<ResponseBody>> n(@Field("schoolId") String str, @Field("userNum") String str2, @Field("name") String str3);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/getReplyFeedBackBySuId")
    rx.e<Response<ResponseBody>> o(@Field("feedBackId") String str, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/appadverties/addappadverties")
    rx.e<Response<ResponseBody>> p(@Field("advertiesId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/admin/analysis/addUploadRecord")
    rx.e<Response<ResponseBody>> q(@Field("schoolId") Integer num, @Field("platform") Integer num2, @Field("deviceId") String str, @Field("brandName") String str2, @Field("deviceNum") String str3, @Field("sysUserId") String str4, @Field("versionName") String str5);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/bindDevice/validateDeviceBind")
    rx.e<Response<ResponseBody>> r(@Field("schoolId") String str, @Field("userNum") String str2, @Field("code") String str3, @Field("manufacturer") String str4, @Field("model") String str5, @Field("platform") String str6);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/addReplyFeedBack2")
    rx.e<Response<ResponseBody>> s(@Field("appVersion") String str, @Field("platform") String str2, @Field("schoolId") String str3, @Field("feedbackContent") String str4, @Field("userId") String str5, @Field("phone") String str6, @Field("fileName") String str7, @Field("images") String str8, @Field("type") String str9);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/replyFeedBack/addReplyFeedBack2")
    rx.e<Response<ResponseBody>> t(@Field("schoolId") String str, @Field("userId") String str2, @Field("appVersion") String str3, @Field("platform") String str4, @Field("replyContent") String str5, @Field("fileName") String str6, @Field("userName") String str7, @Field("userNum") String str8, @Field("userPhone") String str9);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sysFeedback/getFeedBackByUid")
    rx.e<Response<ResponseBody>> u(@Field("userId") String str, @Field("schoolId") String str2, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/bindDevice/getBindDevicePagerData")
    rx.e<Response<ResponseBody>> v(@Field("schoolId") String str, @Field("keys") String str2);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sys/integralInfo")
    rx.e<Response<ResponseBody>> w(@Field("schoolId") String str, @Field("userNum") String str2, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://m.boxkj.com/app/sch/listSchoolByProvinceId")
    rx.e<Response<ResponseBody>> x(@Field("provinceId") String str);
}
