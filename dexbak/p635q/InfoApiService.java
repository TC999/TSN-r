package p635q;

import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: q.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InfoApiService {

    /* renamed from: a */
    public static final String f44523a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationIndex")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m2304a(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationTitle")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m2303b(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2, @Field("inforTypeId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationindex")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m2302c(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationPublish")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m2301d(@Field("inforId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/appInformation/appInformationTitleDesc")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m2300e(@Field("pageSize") Integer num, @Field("pageIndex") Integer num2);
}
