package p635q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: q.i */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface SecondHandApiService {

    /* renamed from: a */
    public static final String f44531a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/deleteUsedGoodsNotice")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m2199a(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/closeUsedGoodsNotice")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m2198b(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/myUsedGoodsNoticeList")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m2197c(@Field("regionUserId") String str, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/usefulUsedGoodsNoticeList")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m2196d(@Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/addUsedGoodsNotice")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m2195e(@NonNull @Field("regionUserId") String str, @NonNull @Field("goodsTypeId") String str2, @NonNull @Field("buyOrSell") int i, @NonNull @Field("description") String str3, @Nullable @Field("img") String str4, @Nullable @Field("phone") String str5, @Nullable @Field("qq") String str6, @Nullable @Field("wechat") String str7, @Nullable @Field("price") String str8);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userUg/userHasGranted")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m2194f(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/usedGoodsNotice/getUsedGoodsNoticeDetail")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m2193g(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userUg/grantUser")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m2192h(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);
}
