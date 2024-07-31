package p635q;

import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: q.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface ChatApiService {
    @POST("app/chat/getChatInfo")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m2318a();

    @FormUrlEncoded
    @POST("app/chat/updateReadStatus")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m2317b(@Field("type") int i, @Field("userId") String str, @Field("groupId") String str2);

    @FormUrlEncoded
    @POST("app/chat/getChat")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m2316c(@Field("type") int i, @Field("userId") String str, @Field("groupId") String str2, @Field("pageSize") Integer num, @Field("pageIndex") Integer num2, @Field("lastDateTime") String str3);

    @FormUrlEncoded
    @POST("app/chat/getUserInfo")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m2315d(@Field("userId") String str);

    @FormUrlEncoded
    @POST("app/chat/listFriends")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m2314e(@Field("groupId") String str);

    @POST("app/chat/listChats")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m2313f();
}
