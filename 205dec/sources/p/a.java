package p;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: ChatApiService.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public interface a {
    @POST("app/chat/getChatInfo")
    rx.e<Response<ResponseBody>> a();

    @FormUrlEncoded
    @POST("app/chat/updateReadStatus")
    rx.e<Response<ResponseBody>> b(@Field("type") int i4, @Field("userId") String str, @Field("groupId") String str2);

    @FormUrlEncoded
    @POST("app/chat/getChat")
    rx.e<Response<ResponseBody>> c(@Field("type") int i4, @Field("userId") String str, @Field("groupId") String str2, @Field("pageSize") Integer num, @Field("pageIndex") Integer num2, @Field("lastDateTime") String str3);

    @FormUrlEncoded
    @POST("app/chat/getUserInfo")
    rx.e<Response<ResponseBody>> d(@Field("userId") String str);

    @FormUrlEncoded
    @POST("app/chat/listFriends")
    rx.e<Response<ResponseBody>> e(@Field("groupId") String str);

    @POST("app/chat/listChats")
    rx.e<Response<ResponseBody>> f();
}
