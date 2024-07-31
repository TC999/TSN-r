package p635q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.ResponseBody;
import p640rx.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* renamed from: q.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface DonationApiService {

    /* renamed from: a */
    public static final String f44522a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/deleteDonationNotice")
    /* renamed from: a */
    Observable<Response<ResponseBody>> m2312a(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/closeDonationNotice")
    /* renamed from: b */
    Observable<Response<ResponseBody>> m2311b(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/myDonationNoticeList")
    /* renamed from: c */
    Observable<Response<ResponseBody>> m2310c(@Field("regionUserId") String str, @Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/usefulDonationNoticeList")
    /* renamed from: d */
    Observable<Response<ResponseBody>> m2309d(@Field("pageIndex") int i, @Field("pageSize") int i2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/addDonationNotice")
    /* renamed from: e */
    Observable<Response<ResponseBody>> m2308e(@NonNull @Field("regionUserId") String str, @NonNull @Field("goodsTypeId") String str2, @NonNull @Field("buyOrSell") int i, @NonNull @Field("description") String str3, @Nullable @Field("img") String str4, @Nullable @Field("phone") String str5, @Nullable @Field("qq") String str6, @Nullable @Field("wechat") String str7, @Nullable @Field("price") String str8);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userJM/userHasGranted")
    /* renamed from: f */
    Observable<Response<ResponseBody>> m2307f(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userJM/grantUser")
    /* renamed from: g */
    Observable<Response<ResponseBody>> m2306g(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/getDonationNoticeDetail")
    /* renamed from: h */
    Observable<Response<ResponseBody>> m2305h(@Field("noticeId") String str, @Field("regionUserId") String str2);
}
