package com.bxkj.student.home.teaching.homework;

import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: HomeWorkApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface a {
    @POST("app/homeAppLearnQuestion/saveRadioHomeWorkLearnQuestion")
    @Multipart
    e<Response<ResponseBody>> a(@Part("learnQuestionId") RequestBody learnQuestionId, @Part("answer") RequestBody answer, @Part MultipartBody.Part files);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/saveRadioHomeWorkLearnQuestion")
    e<Response<ResponseBody>> b(@Field("learnQuestionId") String learnQuestionId, @Field("answer") String answer);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/getHomeWorkLearnQuestiondetail")
    e<Response<ResponseBody>> c(@Field("questionId") String questionId, @Field("isQualified") int isQualified);

    @POST("app/homeAppLearnQuestion/saveRadioHomeWorkLearnQuestion")
    @Multipart
    e<Response<ResponseBody>> d(@Part("learnQuestionId") RequestBody learnQuestionId, @PartMap Map<String, RequestBody> files);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/deleteLearnHomeWork")
    e<Response<ResponseBody>> e(@Field("questionId") String questionId);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/loadHomeWorkLearnQuestionList")
    e<Response<ResponseBody>> f(@Field("teacherCurriculumId") String teacherCurriculumId, @Field("week") Integer week);
}
