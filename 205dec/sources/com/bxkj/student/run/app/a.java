package com.bxkj.student.run.app;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RunApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface a {
    @FormUrlEncoded
    @POST("app/sportRecordSetting/setting")
    rx.e<Response<ResponseBody>> a(@Field("uid") String userId);

    @FormUrlEncoded
    @POST("app/runingFeedback/add")
    rx.e<Response<ResponseBody>> b(@Field("sportRecordId") String sportRecordId, @Field("content") String content, @Field("base64Images") String base64Images);

    @FormUrlEncoded
    @POST("app/appRunningLeaderboard/findAppRunningLeaderboardByUserId")
    rx.e<Response<ResponseBody>> c(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appSportRecord/getSportRecordId")
    rx.e<Response<ResponseBody>> d(@Field("sportRecordId") String sportRecordId);

    @FormUrlEncoded
    @POST("app/sportRecordSetting/checkTimeOut")
    rx.e<Response<ResponseBody>> e(@Field("identify") String identify);

    @FormUrlEncoded
    @POST("app/appSportRecord/getSportSpecification")
    rx.e<Response<ResponseBody>> f(@Field("runType") int runType);

    @FormUrlEncoded
    @POST("app/sportRecordSetting/getRunningStartTime")
    rx.e<Response<ResponseBody>> g(@Field("identify") String identify);

    @POST("app/runingFace/appRuningFace")
    @Multipart
    rx.e<Response<ResponseBody>> h(@Part("userId") RequestBody userId, @Part("identify") RequestBody identify, @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("app/appAvoidRunningUser/applyAvoidRunningUserApply")
    rx.e<Response<ResponseBody>> i(@Field("userId") String userId, @Field("applyReason") String applyReason, @Field("fileNames") String fileNames, @Field("imgs") String imgs);

    @FormUrlEncoded
    @POST("app/appSportRecord/appSportRecordList")
    rx.e<Response<ResponseBody>> j(@Field("userId") String userId, @Field("sportType") int sportType, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appAvoidRunningUser/findAppAvoidRunningUserById")
    rx.e<Response<ResponseBody>> k(@Field("avoidRunningUserId") String avoidRunningUserId);

    @FormUrlEncoded
    @POST("app/appAvoidRunningUser/findAvoidRunningUserListByUserId")
    rx.e<Response<ResponseBody>> l(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appSportRecord/sumSportRecord")
    rx.e<Response<ResponseBody>> m(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appRuningStatistics/appPersonalStatistics")
    rx.e<Response<ResponseBody>> n(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/sportRecordSetting/getSetting")
    rx.e<Response<ResponseBody>> o(@Field("runType") int runType, @Field("uid") String uid);

    @GET("https://keep.boxkj.com/keep/records")
    rx.e<Response<ResponseBody>> p(@Query("token") String token, @Query("date") String date);

    @FormUrlEncoded
    @POST("app/appSportRecord/appAddSportRecord")
    rx.e<Response<ResponseBody>> q(@Field("userId") String userId, @Field("runType") int runType, @Field("startTime") long startTime, @Field("endTime") long endTime, @Field("gitudeLatitude") String latLngList, @Field("identify") String identify, @Field("formatSportTime") String formatSportTime, @Field("formatSportRange") String formatSportRange, @Field("avgspeed") String avgSpeed, @Field("speed") String speed, @Field("okPointList") String okPointList, @Field("brand") String brand, @Field("model") String model, @Field("system") String system, @Field("version") String version, @Field("appVersion") String appVersion, @Field("stepNumbers") String stepNumbers, @Field("isFaceStatus") String isFaceStatus, @Field("points") String points, @Field("uploadType") Integer uploadType, @Field("keepId") String keepId);
}
