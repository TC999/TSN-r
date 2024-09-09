package v;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PlaceApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface b {
    @FormUrlEncoded
    @POST("app/fieldPlan/fieldPlanAppointedList")
    e<Response<ResponseBody>> a(@Field("userId") String userId, @Field("type") int type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/syscampus/getCampusList")
    e<Response<ResponseBody>> b();

    @FormUrlEncoded
    @POST("app/fieldPlan/stuAppointField")
    e<Response<ResponseBody>> f(@Field("userId") String userId, @Field("fieldPlanDateId") String fieldPlanDateId, @Field("detailId") String detailId, @Field("status") String status);

    @FormUrlEncoded
    @POST("app/userInfoUserByUserNum2App")
    e<Response<ResponseBody>> g(@Field("userId") String userId, @Field("userNum") String userNum);

    @FormUrlEncoded
    @POST("app/fieldPlan/getFieldAppHelp")
    e<Response<ResponseBody>> h(@Field("type") int type);

    @FormUrlEncoded
    @POST("app/fieldPlan/stuAppointField")
    e<Response<ResponseBody>> i(@Field("userId") String userId, @Field("fieldPlanDateId") String fieldPlanDateId, @Field("companions") String companions, @Field("note") String note, @Field("appointType") int appointType, @Field("status") String status);

    @FormUrlEncoded
    @POST("app/field/getFieldByCampus")
    e<Response<ResponseBody>> j(@Field("campusId") String campusId);

    @FormUrlEncoded
    @POST("app/fieldPlan/getFieldplanList")
    e<Response<ResponseBody>> k(@Field("userId") String userId, @Field("type") int type, @Field("pid") String pid, @Field("applyDate") String applyDate);
}
