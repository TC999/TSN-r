package q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: SecondHandApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61948a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/deleteUsedGoodsNotice")
    rx.e<Response<ResponseBody>> a(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/closeUsedGoodsNotice")
    rx.e<Response<ResponseBody>> b(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/myUsedGoodsNoticeList")
    rx.e<Response<ResponseBody>> c(@Field("regionUserId") String str, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/usefulUsedGoodsNoticeList")
    rx.e<Response<ResponseBody>> d(@Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/addUsedGoodsNotice")
    rx.e<Response<ResponseBody>> e(@NonNull @Field("regionUserId") String str, @NonNull @Field("goodsTypeId") String str2, @NonNull @Field("buyOrSell") int i4, @NonNull @Field("description") String str3, @Nullable @Field("img") String str4, @Nullable @Field("phone") String str5, @Nullable @Field("qq") String str6, @Nullable @Field("wechat") String str7, @Nullable @Field("price") String str8);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userUg/userHasGranted")
    rx.e<Response<ResponseBody>> f(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/getUsedGoodsNoticeDetail")
    rx.e<Response<ResponseBody>> g(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userUg/grantUser")
    rx.e<Response<ResponseBody>> h(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);
}
