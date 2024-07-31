package com.bxkj.student.run.app;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/* renamed from: com.bxkj.student.run.app.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface RunApiService {
    @FormUrlEncoded
    @POST("app/sportRecordSetting/setting")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m40120a(@Field("uid") String userId);

    @FormUrlEncoded
    @POST("app/runingFeedback/add")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m40119b(@Field("sportRecordId") String sportRecordId, @Field("content") String content, @Field("base64Images") String base64Images);

    @FormUrlEncoded
    @POST("app/appRunningLeaderboard/findAppRunningLeaderboardByUserId")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m40118c(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appSportRecord/getSportRecordId")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m40117d(@Field("sportRecordId") String sportRecordId);

    @FormUrlEncoded
    @POST("app/sportRecordSetting/checkTimeOut")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m40116e(@Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/appSportRecord/getSportSpecification")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m40115f(@Field("runType") int runType);

    @FormUrlEncoded
    @POST("app/sportRecordSetting/getRunningStartTime")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m40114g(@Field("identify") String identify);

    @POST("app/runingFace/appRuningFace")
    @Multipart
    /* renamed from: h */
    Observable<Response<ResponseBody>> m40113h(@Part("userId") RequestBody userId, @Part("identify") RequestBody identify, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("app/appAvoidRunningUser/applyAvoidRunningUserApply")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m40112i(@Field("userId") String userId, @Field("applyReason") String applyReason, @Field("fileNames") String fileNames, @Field("imgs") String imgs);

    @FormUrlEncoded
    @POST("app/appSportRecord/appSportRecordList")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m40111j(@Field("userId") String userId, @Field("sportType") int sportType, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appAvoidRunningUser/findAppAvoidRunningUserById")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m40110k(@Field("avoidRunningUserId") String avoidRunningUserId);

    @FormUrlEncoded
    @POST("app/appAvoidRunningUser/findAvoidRunningUserListByUserId")
    /* renamed from: l */
    Observable<Response<ResponseBody>> m40109l(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appSportRecord/sumSportRecord")
    /* renamed from: m */
    Observable<Response<ResponseBody>> m40108m(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appRuningStatistics/appPersonalStatistics")
    /* renamed from: n */
    Observable<Response<ResponseBody>> m40107n(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/sportRecordSetting/getSetting")
    /* renamed from: o */
    Observable<Response<ResponseBody>> m40106o(@Field("runType") int runType, @Field("uid") String uid);

    @GET("https://keep.boxkj.com/keep/records")
    /* renamed from: p */
    Observable<Response<ResponseBody>> m40105p(@Query("token") String token, @Query("date") String date);

    @FormUrlEncoded
    @POST("app/appSportRecord/appAddSportRecord")
    /* renamed from: q */
    Observable<Response<ResponseBody>> m40104q(@Field("userId") String userId, @Field("runType") int runType, @Field("startTime") long startTime, @Field("endTime") long endTime, @Field("gitudeLatitude") String latLngList, @Field("identify") String identify, @Field("formatSportTime") String formatSportTime, @Field("formatSportRange") String formatSportRange, @Field("avgspeed") String avgSpeed, @Field("speed") String speed, @Field("okPointList") String okPointList, @Field("brand") String brand, @Field("model") String model, @Field("system") String system, @Field("version") String version, @Field("appVersion") String appVersion, @Field("stepNumbers") String stepNumbers, @Field("isFaceStatus") String isFaceStatus, @Field("points") String points, @Field("uploadType") Integer uploadType, @Field("keepId") String keepId);
}
