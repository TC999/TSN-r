package com.bxkj.student.home.teaching.learning;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LearningApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface m {
    @POST("app/appLearnQuestion/saveRadioLearnQuestion")
    @Multipart
    rx.e<Response<ResponseBody>> a(@Part("learnQuestionId") RequestBody learnQuestionId, @Part("answer") RequestBody answer, @Part MultipartBody.Part files);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/saveRadioLearnQuestion")
    rx.e<Response<ResponseBody>> b(@Field("learnQuestionId") String learnQuestionId, @Field("answer") String answer);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/getLearnQuestiondetail")
    rx.e<Response<ResponseBody>> c(@Field("questionId") String questionId, @Field("isQualified") int isQualified);

    @POST("app/appLearnQuestion/saveRadioLearnQuestion")
    @Multipart
    rx.e<Response<ResponseBody>> d(@Part("learnQuestionId") RequestBody learnQuestionId, @PartMap Map<String, RequestBody> files);

    @FormUrlEncoded
    @POST("app/appLearnResource/myLearnResourceDetail")
    rx.e<Response<ResponseBody>> e(@Field("userId") String userId, @Field("resultType") String resultType, @Field("pageSize") Integer pageSize, @Field("pageIndex") Integer pageIndex);

    @FormUrlEncoded
    @POST("app/appLearnResource/nextRresourceTypes")
    rx.e<Response<ResponseBody>> f(@Field("pId") String pid);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/loadLearnQuestionList")
    rx.e<Response<ResponseBody>> g(@Field("type") int type, @Field("resourceId") String resourceId);

    @FormUrlEncoded
    @POST("app/appLearnResource/childTypesAndRresources")
    rx.e<Response<ResponseBody>> h(@Field("pId") String pId);

    @POST("app/appLearnResource/startLearnData")
    rx.e<Response<ResponseBody>> i();

    @POST("app/appLearnResource/firstRresourceTypes")
    rx.e<Response<ResponseBody>> j();

    @FormUrlEncoded
    @POST("app/appLearnResource/saveLearnQuestionPaper")
    rx.e<Response<ResponseBody>> k(@Field("userId") String userId, @Field("radio") String radio, @Field("check") String check);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/deleteLearnWork")
    rx.e<Response<ResponseBody>> l(@Field("questionId") String questionId);

    @POST("app/appLearnResource/listResourceType")
    rx.e<Response<ResponseBody>> m();

    @POST("app/appLearnResource/showResourceTypePage")
    rx.e<Response<ResponseBody>> n();

    @FormUrlEncoded
    @POST("app/appLearnResource/isCompetedLearnByTypeId")
    rx.e<Response<ResponseBody>> o(@Field("typeId") String typeId);

    @POST("app/appLearnInstructions/loadLearnInstructions")
    rx.e<Response<ResponseBody>> p();

    @POST("app/appLearnResource/getReviewNotOkCount")
    rx.e<Response<ResponseBody>> q();

    @FormUrlEncoded
    @POST("app/appLearnResource/myLearnUserRecord")
    rx.e<Response<ResponseBody>> r(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appLearnResource/selectdTypeRresoure")
    rx.e<Response<ResponseBody>> s(@Field("typeId") String typeId);

    @FormUrlEncoded
    @POST("app/appLearnResource/learnResourceDetailOperation")
    rx.e<Response<ResponseBody>> t(@Field("detailId") String detailId, @Field("operateType") String operateType, @Field("status") int status);

    @FormUrlEncoded
    @POST("app/appLearnResource/learnResourceList")
    rx.e<Response<ResponseBody>> u(@Field("userId") String userId, @Field("oneTypeId") String oneTypeId, @Field("twoTypeId") String twoTypeId, @Field("pageSize") Integer pageSize, @Field("pageIndex") Integer pageIndex);

    @FormUrlEncoded
    @POST("app/appLearnResource/clickAnswerButton")
    rx.e<Response<ResponseBody>> v(@Field("userId") String userId, @Field("detailId") String detailId);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/getStuUnqualifiedLearnQuestionList")
    rx.e<Response<ResponseBody>> w(@Field("pageSize") Integer pageSize, @Field("pageIndex") Integer pageIndex);

    @FormUrlEncoded
    @POST("app/appLearnResource/loadLearnQuestionPaper")
    rx.e<Response<ResponseBody>> x(@Field("userId") String userId, @Field("learnResourceId") String learnResourceId);

    @FormUrlEncoded
    @POST("app/appLearnResource/getTheLearnResource")
    rx.e<Response<ResponseBody>> y(@Field("userId") String userId, @Field("id") String id);
}
