package com.bxkj.student.home.teaching.homework;

import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/* renamed from: com.bxkj.student.home.teaching.homework.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface HomeWorkApiService {
    @POST("app/homeAppLearnQuestion/saveRadioHomeWorkLearnQuestion")
    @Multipart
    /* renamed from: a */
    Observable<Response<ResponseBody>> m42112a(@Part("learnQuestionId") RequestBody learnQuestionId, @Part("answer") RequestBody answer, @Part MultipartBody.Part files);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/saveRadioHomeWorkLearnQuestion")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m42111b(@Field("learnQuestionId") String learnQuestionId, @Field("answer") String answer);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/getHomeWorkLearnQuestiondetail")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m42110c(@Field("questionId") String questionId, @Field("isQualified") int isQualified);

    @POST("app/homeAppLearnQuestion/saveRadioHomeWorkLearnQuestion")
    @Multipart
    /* renamed from: d */
    Observable<Response<ResponseBody>> m42109d(@Part("learnQuestionId") RequestBody learnQuestionId, @PartMap Map<String, RequestBody> files);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/deleteLearnHomeWork")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m42108e(@Field("questionId") String questionId);

    @FormUrlEncoded
    @POST("app/homeAppLearnQuestion/loadHomeWorkLearnQuestionList")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m42107f(@Field("teacherCurriculumId") String teacherCurriculumId, @Field("week") Integer week);
}
