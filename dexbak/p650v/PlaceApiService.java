package p650v;

import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: v.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface PlaceApiService {
    @FormUrlEncoded
    @POST("app/fieldPlan/fieldPlanAppointedList")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m217a(@Field("userId") String userId, @Field("type") int type, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @POST("app/syscampus/getCampusList")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m216b();

    @FormUrlEncoded
    @POST("app/fieldPlan/stuAppointField")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m215f(@Field("userId") String userId, @Field("fieldPlanDateId") String fieldPlanDateId, @Field("detailId") String detailId, @Field("status") String status);

    @FormUrlEncoded
    @POST("app/userInfoUserByUserNum2App")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m214g(@Field("userId") String userId, @Field("userNum") String userNum);

    @FormUrlEncoded
    @POST("app/fieldPlan/getFieldAppHelp")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m213h(@Field("type") int type);

    @FormUrlEncoded
    @POST("app/fieldPlan/stuAppointField")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m212i(@Field("userId") String userId, @Field("fieldPlanDateId") String fieldPlanDateId, @Field("companions") String companions, @Field("note") String note, @Field("appointType") int appointType, @Field("status") String status);

    @FormUrlEncoded
    @POST("app/field/getFieldByCampus")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m211j(@Field("campusId") String campusId);

    @FormUrlEncoded
    @POST("app/fieldPlan/getFieldplanList")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m210k(@Field("userId") String userId, @Field("type") int type, @Field("pid") String pid, @Field("applyDate") String applyDate);
}
