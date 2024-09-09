package com.bxkj.equipment;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EquipmentApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface i {
    @FormUrlEncoded
    @POST("app/appEquipment/teaEquDistributeRecords")
    rx.e<Response<ResponseBody>> a(@Field("teacherCurriculumId") String teacherCurriculumId, @Field("teacherCurriculumWeek") int teacherCurriculumWeek, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/syscampus/getCampusList")
    rx.e<Response<ResponseBody>> b();

    @FormUrlEncoded
    @POST("app/appEquipment/getEquipmentList")
    rx.e<Response<ResponseBody>> c(@Field("campusId") String campusId);

    @FormUrlEncoded
    @POST("app/appEquipment/addTeacherEquRoomDealRecord")
    rx.e<Response<ResponseBody>> d(@Field("teacherCurriculumId") String teacherCurriculumId, @Field("week") int week, @Field("eDetailId") String eDetailId, @Field("applyReason") String applyReason, @Field("amount") Integer amount, @Field("forReceiveTime") String forReceiveTime, @Field("forBackTime") String forBackTime, @Field("status") String status, @Field("recordId") String recordId);

    @FormUrlEncoded
    @POST("app/appEquipment/myEquDistributeRecords")
    rx.e<Response<ResponseBody>> e(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appEquipment/updateEdrRoomPerson")
    rx.e<Response<ResponseBody>> f(@Field("userId") String userId, @Field("campusId") String campusId, @Field("eDetailId") String eDetailId, @Field("applyReason") String applyReason, @Field("amount") Integer amount, @Field("forReceiveTime") String forReceiveTime, @Field("forBackTime") String forBackTime, @Field("status") String status, @Field("recordId") String recordId);
}
