package p635q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: q.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface LostApiService {

    /* renamed from: a */
    public static final String f44525a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/deleteLostFoundNotice")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m2287a(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/closeLostFoundNotice")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m2286b(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/reviewQAValidate")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m2285c(@Field("regionUserId") String str, @Field("validateAnswerId") String str2, @Field("status") String str3);

    @POST("https://h.boxkj.com/app/goodsType/topLevelGoodsTypeList")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m2284d();

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/addLostFoundNotice")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m2283e(@NonNull @Field("regionUserId") String str, @NonNull @Field("goodsTypeId") String str2, @NonNull @Field("lostOrFound") int i, @NonNull @Field("description") String str3, @Nullable @Field("img") String str4, @Nullable @Field("phone") String str5, @Nullable @Field("qq") String str6, @Nullable @Field("wechat") String str7, @Nullable @Field("price") String str8, @Nullable @Field("isValidate") String str9, @Nullable @Field("validateCount") int i2, @Nullable @Field("question") String str10);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/addLostNoticeQAValidate")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m2282f(@Field("noticeId") String str, @Field("regionUserId") String str2, @Field("question") String str3, @Field("answer") String str4);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/user/grantUser")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m2281g(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/getNoticeDetail")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m2280h(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/user/userHasGranted")
    /* renamed from: i */
    Observable<Response<ResponseBody>> m2279i(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/myLostFoundNoticeList")
    /* renamed from: j */
    Observable<Response<ResponseBody>> m2278j(@Field("regionUserId") String str, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/allUsefulLostFoundNoticeList")
    /* renamed from: k */
    Observable<Response<ResponseBody>> m2277k(@Field("pageIndex") int i, @Field("pageSize") int i2);
}
