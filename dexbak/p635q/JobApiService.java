package p635q;

import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: q.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface JobApiService {

    /* renamed from: a */
    public static final String f44524a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitVitae/loadRecruitVitae")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m2299a(@Field("schoolId") String str, @Field("userId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitmentCompany/appRecruitmentCompanyDetail")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m2298b(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitUserPublish/recruitUserPublishList")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m2297c(@Field("schoolId") String str, @Field("pageIndex") int i, @Field("pageSize") int i2, @Field("type") int i3);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appApplyRecuitment/addApplyRecuit")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m2296d(@Field("recruitId") String str, @Field("schoolId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitment/appRecruitmentList")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m2295e(@Field("schoolId") String str, @Field("pageIndex") int i, @Field("pageSize") int i2, @Field("type") int i3);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userZp/grantUser")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m2294f(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitUserPublish/addRecruitUserpubInfo")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m2293g(@Field("schoolId") String str, @Field("userId") String str2, @Field("workType") String str3, @Field("function") String str4, @Field("expectMoney") String str5, @Field("place") String str6, @Field("otherDemand") String str7, @Field("funcIntroduce") String str8);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userZp/userHasGranted")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m2292h(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitVitae/addRecruitVitae")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m2291i(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("age") String str5, @Field("nativePlace") String str6, @Field("education") String str7, @Field("probatePeriodMoney") String str8, @Field("becomeMemberMoney") String str9, @Field("welfare") String str10, @Field("telphone") String str11, @Field("marriage") String str12, @Field("political") String str13, @Field("workYear") String str14, @Field("workPlace") String str15, @Field("eduUndergo") String str16, @Field("trainUndergo") String str17, @Field("workUndergo") String str18, @Field("introduceSelf") String str19, @Field("weixin") String str20, @Field("qq") String str21, @Field("workTime") String str22);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitUserPublish/loadRecruitUserpubInfo")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m2290j(@Field("id") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitment/appRecruitmentDetail")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m2289k(@Field("schoolId") String str, @Field("userId") String str2, @Field("id") String str3);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appRecruitVitae/updateRecruitVitae")
    /* renamed from: l */
    Observable<Response<ResponseBody>> m2288l(@Field("id") String str, @Field("schoolId") String str2, @Field("userId") String str3, @Field("userName") String str4, @Field("sex") String str5, @Field("age") String str6, @Field("nativePlace") String str7, @Field("education") String str8, @Field("probatePeriodMoney") String str9, @Field("becomeMemberMoney") String str10, @Field("welfare") String str11, @Field("telphone") String str12, @Field("marriage") String str13, @Field("political") String str14, @Field("workYear") String str15, @Field("workPlace") String str16, @Field("eduUndergo") String str17, @Field("trainUndergo") String str18, @Field("workUndergo") String str19, @Field("introduceSelf") String str20, @Field("weixin") String str21, @Field("qq") String str22, @Field("workTime") String str23);
}
