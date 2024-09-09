package p;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: InfoApiService.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61776a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationIndex")
    rx.e<Response<ResponseBody>> a(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationTitle")
    rx.e<Response<ResponseBody>> b(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2, @Field("inforTypeId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationindex")
    rx.e<Response<ResponseBody>> c(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationPublish")
    rx.e<Response<ResponseBody>> d(@Field("inforId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationTitleDesc")
    rx.e<Response<ResponseBody>> e(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2);
}
