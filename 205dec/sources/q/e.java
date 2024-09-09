package q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: LostApiService.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f61942a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/deleteLostFoundNotice")
    rx.e<Response<ResponseBody>> a(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/closeLostFoundNotice")
    rx.e<Response<ResponseBody>> b(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/reviewQAValidate")
    rx.e<Response<ResponseBody>> c(@Field("regionUserId") String str, @Field("validateAnswerId") String str2, @Field("status") String str3);

    @POST("https://h.boxkj.com/app/goodsType/topLevelGoodsTypeList")
    rx.e<Response<ResponseBody>> d();

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/addLostFoundNotice")
    rx.e<Response<ResponseBody>> e(@NonNull @Field("regionUserId") String str, @NonNull @Field("goodsTypeId") String str2, @NonNull @Field("lostOrFound") int i4, @NonNull @Field("description") String str3, @Nullable @Field("img") String str4, @Nullable @Field("phone") String str5, @Nullable @Field("qq") String str6, @Nullable @Field("wechat") String str7, @Nullable @Field("price") String str8, @Nullable @Field("isValidate") String str9, @Nullable @Field("validateCount") int i5, @Nullable @Field("question") String str10);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/addLostNoticeQAValidate")
    rx.e<Response<ResponseBody>> f(@Field("noticeId") String str, @Field("regionUserId") String str2, @Field("question") String str3, @Field("answer") String str4);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/user/grantUser")
    rx.e<Response<ResponseBody>> g(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/getNoticeDetail")
    rx.e<Response<ResponseBody>> h(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/user/userHasGranted")
    rx.e<Response<ResponseBody>> i(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/myLostFoundNoticeList")
    rx.e<Response<ResponseBody>> j(@Field("regionUserId") String str, @Field("pageIndex") int i4, @Field("pageSize") int i5);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/lostAndFoundNotice/allUsefulLostFoundNoticeList")
    rx.e<Response<ResponseBody>> k(@Field("pageIndex") int i4, @Field("pageSize") int i5);
}
