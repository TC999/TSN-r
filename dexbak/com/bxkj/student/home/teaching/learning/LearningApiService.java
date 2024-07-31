package com.bxkj.student.home.teaching.learning;

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

/* renamed from: com.bxkj.student.home.teaching.learning.m */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface LearningApiService {
    @POST("app/appLearnQuestion/saveRadioLearnQuestion")
    @Multipart
    /* renamed from: a */
    Observable<Response<ResponseBody>> m41641a(@Part("learnQuestionId") RequestBody learnQuestionId, @Part("answer") RequestBody answer, @Part MultipartBody.Part files);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/saveRadioLearnQuestion")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m41640b(@Field("learnQuestionId") String learnQuestionId, @Field("answer") String answer);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/getLearnQuestiondetail")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m41639c(@Field("questionId") String questionId, @Field("isQualified") int isQualified);

    @POST("app/appLearnQuestion/saveRadioLearnQuestion")
    @Multipart
    /* renamed from: d */
    Observable<Response<ResponseBody>> m41638d(@Part("learnQuestionId") RequestBody learnQuestionId, @PartMap Map<String, RequestBody> files);

    @FormUrlEncoded
    @POST("app/appLearnResource/myLearnResourceDetail")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m41637e(@Field("userId") String userId, @Field("resultType") String resultType, @Field("pageSize") Integer pageSize, @Field("pageIndex") Integer pageIndex);

    @FormUrlEncoded
    @POST("app/appLearnResource/nextRresourceTypes")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m41636f(@Field("pId") String pid);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/loadLearnQuestionList")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m41635g(@Field("type") int type, @Field("resourceId") String resourceId);

    @FormUrlEncoded
    @POST("app/appLearnResource/childTypesAndRresources")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m41634h(@Field("pId") String pId);

    @POST("app/appLearnResource/startLearnData")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m41633i();

    @POST("app/appLearnResource/firstRresourceTypes")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m41632j();

    @FormUrlEncoded
    @POST("app/appLearnResource/saveLearnQuestionPaper")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m41631k(@Field("userId") String userId, @Field("radio") String radio, @Field("check") String check);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/deleteLearnWork")
    /* renamed from: l */
    Observable<Response<ResponseBody>> m41630l(@Field("questionId") String questionId);

    @POST("app/appLearnResource/listResourceType")
    /* renamed from: m */
    Observable<Response<ResponseBody>> m41629m();

    @POST("app/appLearnResource/showResourceTypePage")
    /* renamed from: n */
    Observable<Response<ResponseBody>> m41628n();

    @FormUrlEncoded
    @POST("app/appLearnResource/isCompetedLearnByTypeId")
    /* renamed from: o */
    Observable<Response<ResponseBody>> m41627o(@Field("typeId") String typeId);

    @POST("app/appLearnInstructions/loadLearnInstructions")
    /* renamed from: p */
    Observable<Response<ResponseBody>> m41626p();

    @POST("app/appLearnResource/getReviewNotOkCount")
    /* renamed from: q */
    Observable<Response<ResponseBody>> m41625q();

    @FormUrlEncoded
    @POST("app/appLearnResource/myLearnUserRecord")
    /* renamed from: r */
    Observable<Response<ResponseBody>> m41624r(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appLearnResource/selectdTypeRresoure")
    /* renamed from: s */
    Observable<Response<ResponseBody>> m41623s(@Field("typeId") String typeId);

    @FormUrlEncoded
    @POST("app/appLearnResource/learnResourceDetailOperation")
    /* renamed from: t */
    Observable<Response<ResponseBody>> m41622t(@Field("detailId") String detailId, @Field("operateType") String operateType, @Field("status") int status);

    @FormUrlEncoded
    @POST("app/appLearnResource/learnResourceList")
    /* renamed from: u */
    Observable<Response<ResponseBody>> m41621u(@Field("userId") String userId, @Field("oneTypeId") String oneTypeId, @Field("twoTypeId") String twoTypeId, @Field("pageSize") Integer pageSize, @Field("pageIndex") Integer pageIndex);

    @FormUrlEncoded
    @POST("app/appLearnResource/clickAnswerButton")
    /* renamed from: v */
    Observable<Response<ResponseBody>> m41620v(@Field("userId") String userId, @Field("detailId") String detailId);

    @FormUrlEncoded
    @POST("app/appLearnQuestion/getStuUnqualifiedLearnQuestionList")
    /* renamed from: w */
    Observable<Response<ResponseBody>> m41619w(@Field("pageSize") Integer pageSize, @Field("pageIndex") Integer pageIndex);

    @FormUrlEncoded
    @POST("app/appLearnResource/loadLearnQuestionPaper")
    /* renamed from: x */
    Observable<Response<ResponseBody>> m41618x(@Field("userId") String userId, @Field("learnResourceId") String learnResourceId);

    @FormUrlEncoded
    @POST("app/appLearnResource/getTheLearnResource")
    /* renamed from: y */
    Observable<Response<ResponseBody>> m41617y(@Field("userId") String userId, @Field("id") String id);
}
