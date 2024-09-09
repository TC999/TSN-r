package p;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: JobApiService.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public interface d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61777a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitVitae/loadRecruitVitae")
    rx.e<Response<ResponseBody>> a(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitmentCompany/appRecruitmentCompanyDetail")
    rx.e<Response<ResponseBody>> b(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitUserPublish/recruitUserPublishList")
    rx.e<Response<ResponseBody>> c(@Field("schoolId") String str, @Field("pageIndex") int i4, @Field("pageSize") int i5, @Field("type") int i6);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appApplyRecuitment/addApplyRecuit")
    rx.e<Response<ResponseBody>> d(@Field("recruitId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitment/appRecruitmentList")
    rx.e<Response<ResponseBody>> e(@Field("schoolId") String str, @Field("pageIndex") int i4, @Field("pageSize") int i5, @Field("type") int i6);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userZp/grantUser")
    rx.e<Response<ResponseBody>> f(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitUserPublish/addRecruitUserpubInfo")
    rx.e<Response<ResponseBody>> g(@Field("schoolId") String str, @Field("userId") String str2, @Field("workType") String str3, @Field("function") String str4, @Field("expectMoney") String str5, @Field("place") String str6, @Field("otherDemand") String str7, @Field("funcIntroduce") String str8);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userZp/userHasGranted")
    rx.e<Response<ResponseBody>> h(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitVitae/addRecruitVitae")
    rx.e<Response<ResponseBody>> i(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("age") String str5, @Field("nativePlace") String str6, @Field("education") String str7, @Field("probatePeriodMoney") String str8, @Field("becomeMemberMoney") String str9, @Field("welfare") String str10, @Field("telphone") String str11, @Field("marriage") String str12, @Field("political") String str13, @Field("workYear") String str14, @Field("workPlace") String str15, @Field("eduUndergo") String str16, @Field("trainUndergo") String str17, @Field("workUndergo") String str18, @Field("introduceSelf") String str19, @Field("weixin") String str20, @Field("qq") String str21, @Field("workTime") String str22);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitUserPublish/loadRecruitUserpubInfo")
    rx.e<Response<ResponseBody>> j(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitment/appRecruitmentDetail")
    rx.e<Response<ResponseBody>> k(@Field("schoolId") String str, @Field("userId") String str2, @Field("id") String str3);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitVitae/updateRecruitVitae")
    rx.e<Response<ResponseBody>> l(@Field("id") String str, @Field("schoolId") String str2, @Field("userId") String str3, @Field("userName") String str4, @Field("sex") String str5, @Field("age") String str6, @Field("nativePlace") String str7, @Field("education") String str8, @Field("probatePeriodMoney") String str9, @Field("becomeMemberMoney") String str10, @Field("welfare") String str11, @Field("telphone") String str12, @Field("marriage") String str13, @Field("political") String str14, @Field("workYear") String str15, @Field("workPlace") String str16, @Field("eduUndergo") String str17, @Field("trainUndergo") String str18, @Field("workUndergo") String str19, @Field("introduceSelf") String str20, @Field("weixin") String str21, @Field("qq") String str22, @Field("workTime") String str23);
}
