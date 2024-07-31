package com.bxkj.equipment;

import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: com.bxkj.equipment.i */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface EquipmentApiService {
    @FormUrlEncoded
    @POST("app/appEquipment/teaEquDistributeRecords")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m43100a(@Field("teacherCurriculumId") String teacherCurriculumId, @Field("teacherCurriculumWeek") int teacherCurriculumWeek, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/syscampus/getCampusList")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m43099b();

    @FormUrlEncoded
    @POST("app/appEquipment/getEquipmentList")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m43098c(@Field("campusId") String campusId);

    @FormUrlEncoded
    @POST("app/appEquipment/addTeacherEquRoomDealRecord")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m43097d(@Field("teacherCurriculumId") String teacherCurriculumId, @Field("week") int week, @Field("eDetailId") String eDetailId, @Field("applyReason") String applyReason, @Field("amount") Integer amount, @Field("forReceiveTime") String forReceiveTime, @Field("forBackTime") String forBackTime, @Field("status") String status, @Field("recordId") String recordId);

    @FormUrlEncoded
    @POST("app/appEquipment/myEquDistributeRecords")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m43096e(@Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appEquipment/updateEdrRoomPerson")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m43095f(@Field("userId") String userId, @Field("campusId") String campusId, @Field("eDetailId") String eDetailId, @Field("applyReason") String applyReason, @Field("amount") Integer amount, @Field("forReceiveTime") String forReceiveTime, @Field("forBackTime") String forBackTime, @Field("status") String status, @Field("recordId") String recordId);
}
