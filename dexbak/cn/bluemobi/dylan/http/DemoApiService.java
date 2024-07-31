package cn.bluemobi.dylan.http;

import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface DemoApiService {
    @POST(" ")
    @Multipart
    Observable<ResponseBody> editHeadImage(@Part("app") RequestBody requestBody, @Part("class") RequestBody requestBody2, @Part("sign") RequestBody requestBody3, @Part("userid") RequestBody requestBody4, @Part MultipartBody.Part part);

    @FormUrlEncoded
    @POST(" ")
    Observable<ResponseBody> login(@Field("app") String str, @Field("class") String str2, @Field("phone") String str3, @Field("password") String str4);

    @POST(" ")
    @Multipart
    Observable<ResponseBody> publishTask(@Part("app") RequestBody requestBody, @Part("class") RequestBody requestBody2, @Part("sign") RequestBody requestBody3, @Part("userid") RequestBody requestBody4, @Part("task_category_id") RequestBody requestBody5, @Part("task_poundage") RequestBody requestBody6, @Part("task_title") RequestBody requestBody7, @Part("task_status_time") RequestBody requestBody8, @Part("task_end_time") RequestBody requestBody9, @Part("task_content") RequestBody requestBody10, @Part("task_special") RequestBody requestBody11, @Part("task_reward") RequestBody requestBody12, @Part("task_lon") RequestBody requestBody13, @Part("task_lat") RequestBody requestBody14, @Part("task_address") RequestBody requestBody15, @Part("task_img_count") RequestBody requestBody16, @PartMap Map<String, RequestBody> map);
}
