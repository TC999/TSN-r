package com.bxkj.student.v2.retrofit;

import com.bxkj.base.v2.data.a;
import com.bxkj.base.v2.http.result.ApiResult;
import com.bxkj.base.v2.http.result.OldApiResult;
import com.bxkj.base.v2.http.result.PgyerApiResult;
import com.bxkj.student.v2.common.data.CommitResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.text.d;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: ApiService.kt */
@Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000 ]2\u00020\u0001:\u0001]J\u001d\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u0007\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\u0005J)\u0010\b\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0005J3\u0010\u000b\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ1\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0005J\u00bf\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010,2\b\b\u0001\u0010\u0012\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u00132\b\b\u0001\u0010\u0016\u001a\u00020\u00132\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.J/\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010,2\b\b\u0001\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0010JG\u00102\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u00100\u001a\u00020\t2\b\b\u0001\u00101\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103JS\u00108\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u00104\u001a\u00020\u00032\b\b\u0001\u00105\u001a\u00020\u00032\b\b\u0001\u00106\u001a\u00020\t2\n\b\u0003\u00107\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00109J3\u0010;\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u0010:\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010<J)\u0010=\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010\u0005J)\u0010>\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010\u0005J`\u0010D\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\n\b\u0001\u0010:\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010@\u001a\u0004\u0018\u00010?2\u001d\b\u0001\u0010C\u001a\u0017\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u00010A\u00a2\u0006\u0002\bBH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bD\u0010EJ'\u0010H\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010IJ?\u0010J\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010KJ?\u0010M\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010L\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010KJ'\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010&\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010<J'\u0010O\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010IJ3\u0010P\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u0010&\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bP\u0010<J9\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\b\u0001\u0010Q\u001a\u00020\u00032\b\b\u0001\u0010R\u001a\u00020\u00032\b\b\u0001\u0010L\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010TJQ\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A2\n\b\u0001\u0010U\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010V\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010W\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010L\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bX\u0010YJ3\u0010[\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0\u00022\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b[\u0010<J=\u0010]\u001a \u0012\u001a\u0012\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A\u0018\u00010\\\u0018\u00010\u00022\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b]\u0010<J9\u0010^\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0\\0\u00022\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b^\u0010<J'\u0010_\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b_\u0010\u0005JQ\u0010a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A2\n\b\u0001\u0010`\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010V\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010W\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010L\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\ba\u0010YJ\u0013\u0010c\u001a\u00020bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bc\u0010\u0005JQ\u0010f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0\\0\u00022\n\b\u0003\u0010L\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010d\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010e\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bf\u0010TJ+\u0010g\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010A\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bg\u0010\u0005J#\u0010k\u001a\b\u0012\u0004\u0012\u00020j0i2\b\b\u0001\u0010h\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bk\u0010<JK\u0010m\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010l\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?2\n\b\u0003\u0010L\u001a\u0004\u0018\u00010?H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bm\u0010nJ?\u0010o\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bo\u0010KJ)\u0010p\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bp\u0010\u0005J\u0019\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bq\u0010\u0005J/\u0010r\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A\u0018\u00010\\0\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\br\u0010\u0005JS\u0010t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00060\u00022\n\b\u0003\u0010s\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u00104\u001a\u00020\u00032\b\b\u0003\u00101\u001a\u00020\t2\b\b\u0003\u00100\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bt\u0010uJE\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\b\u0001\u0010v\u001a\u00020\u00032\b\b\u0001\u0010w\u001a\u00020\u00032\b\b\u0001\u0010@\u001a\u00020\u00032\n\b\u0001\u0010s\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bx\u0010YJ%\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\b\u0001\u0010y\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\bz\u0010<J+\u0010{\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b{\u0010\u0005J'\u0010}\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\b\b\u0001\u0010|\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b}\u0010<J/\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010~\u001a\u00020\u00032\b\b\u0001\u0010L\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u007f\u0010\u0010JS\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A2\n\b\u0001\u0010~\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010V\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010W\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010L\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0080\u0001\u0010YJ5\u0010\u0083\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u00032\u000b\b\u0003\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0083\u0001\u0010\u0010J=\u0010\u0086\u0001\u001a\u001f\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\\\u0018\u00010\u0085\u00012\t\b\u0001\u0010\u0084\u0001\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0086\u0001\u0010<J3\u0010\u0087\u0001\u001a \u0012\u001a\u0012\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A\u0018\u00010\\\u0018\u00010\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0087\u0001\u0010\u0005J9\u0010\u0088\u0001\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0018\u00010\u00022\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0088\u0001\u0010<JD\u0010\u008c\u0001\u001a\u001b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0018\u00010\u008b\u00012\t\b\u0003\u0010\u0089\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u008a\u0001\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u008c\u0001\u0010\u0010J8\u0010\u008e\u0001\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010A0\u00022\u000b\b\u0001\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u008e\u0001\u0010<J7\u0010\u008f\u0001\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u008f\u0001\u0010<JA\u0010\u0092\u0001\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\t\b\u0003\u0010\u0090\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u0091\u0001\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0092\u0001\u0010\u0010JE\u0010\u0095\u0001\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\u000b\b\u0003\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00032\u000b\b\u0003\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0095\u0001\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/bxkj/student/v2/retrofit/a;", "", "Lcom/bxkj/base/v2/http/result/ApiResult;", "", "r", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "j", "J", "", "sportsType", "z", "(ILkotlin/coroutines/c;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "param", "O", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "s", "sportType", "", "startTime", "endTime", "sportTime", "sportRange", "speed", "avgSpeed", "brand", "model", "system", "version", "appVersion", "gitudeLatitude", "stepNumbers", "isSequencePoint", "pointList", "okPointList", "isFaceStatus", "uploadType", "identify", "geofence", "limitSpeed", "limitStride", "limitStepFrequency", "gpsDistance", "Lcom/bxkj/student/v2/common/data/CommitResult;", "X", "(IJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "R", "pageIndex", "pageSize", "V", "(IIILkotlin/coroutines/c;)Ljava/lang/Object;", "status", "date", "datePageIndex", "isFeedback", "Q", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "exerciseRecordId", "S", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "D", "G", "Lokhttp3/RequestBody;", "content", "", "Lkotlin/jvm/JvmSuppressWildcards;", "files", "C", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Ljava/util/Map;Lkotlin/coroutines/c;)Ljava/lang/Object;", "file", "", "g", "(Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "M", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "type", "c", "A", "d", "E", "operatorID", "stuCardNum", "w", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "username", "password", "grant_type", "o", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "location", "U", "", "a", "f", "k", "refresh_token", "y", "Lkotlin/f1;", "W", "size", "current", CampaignEx.JSON_KEY_AD_Q, "m", "url", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "I", "remark", "b", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "F", "T", "v", "u", "basCampusId", "Z", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/c;)Ljava/lang/Object;", "latitude", "longitude", "p", "pointId", "N", "n", "id", "H", "openid", "K", "e", "messageArticleId", "basUserId", "t", "name", "Lcom/bxkj/base/v2/http/result/OldApiResult;", "L", "P", "l", "_api_key", "appKey", "Lcom/bxkj/base/v2/http/result/PgyerApiResult;", "B", "identifys", "Y", "x", "auth", "alias_value", "h", "schoolCode", "userName", "i", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final C0307a f23692a = C0307a.f23695a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final String f23693b = "https://m.boxkj.com/";
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final String f23694c = "http://a.sxstczx.com/";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: ApiService.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\tR\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/bxkj/student/v2/retrofit/a$a;", "", "", "b", "Ljava/lang/String;", "MOVE_BASE_URL", "c", "MAIN_BASE_URL", "d", "()Ljava/lang/String;", "HELP_CENTER_URL", "e", "a", "FORGET_PASSWORD_URL", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.retrofit.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0307a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ C0307a f23695a = new C0307a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final String f23696b = "https://m.boxkj.com/";
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public static final String f23697c = "http://a.sxstczx.com/";
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private static final String f23698d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private static final String f23699e;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append("https://h.tsnkj.com/?school=");
            a.b bVar = com.bxkj.base.v2.data.a.f18673h;
            sb.append(bVar.a().w());
            sb.append("#/pages/user/help/help");
            f23698d = sb.toString();
            f23699e = f0.C(bVar.a().k(), "#/pages/pwd/pwdType/pwdType");
        }

        private C0307a() {
        }

        @NotNull
        public final String a() {
            return f23699e;
        }

        @NotNull
        public final String b() {
            return f23698d;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: ApiService.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b {
        public static /* synthetic */ Object a(a aVar, int i4, long j4, long j5, long j6, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Integer num, String str15, String str16, String str17, String str18, String str19, String str20, kotlin.coroutines.c cVar, int i5, Object obj) {
            if (obj == null) {
                return aVar.X(i4, j4, j5, j6, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, (i5 & 16384) != 0 ? "0" : str11, str12, str13, str14, num, str15, str16, str17, str18, str19, str20, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRunRecorderV3");
        }

        public static /* synthetic */ Object b(a aVar, String str, String str2, String str3, String str4, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    str2 = "server";
                }
                String str5 = str2;
                if ((i4 & 4) != 0) {
                    str3 = "refresh_token";
                }
                String str6 = str3;
                if ((i4 & 8) != 0) {
                    str4 = "app";
                }
                return aVar.y(str, str5, str6, str4, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoLogin");
        }

        public static /* synthetic */ Object c(a aVar, String str, String str2, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    a.b bVar = com.bxkj.base.v2.data.a.f18673h;
                    str2 = bVar.a().G() ? bVar.a().B() : "";
                }
                return aVar.t(str, str2, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickArticle");
        }

        public static /* synthetic */ Object d(a aVar, String str, String str2, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    byte[] bytes = "371eb09af9255d557b1e697e".getBytes(d.f58930b);
                    f0.o(bytes, "this as java.lang.String).getBytes(charset)");
                    str = f0.C("Basic ", cn.bluemobi.dylan.base.utils.b.b(bytes));
                }
                if ((i4 & 2) != 0) {
                    str2 = com.bxkj.base.v2.data.a.f18673h.a().B();
                }
                return aVar.h(str, str2, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteServerAlis");
        }

        public static /* synthetic */ Object e(a aVar, String str, String str2, String str3, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str = "4";
                }
                if ((i4 & 2) != 0) {
                    str2 = null;
                }
                if ((i4 & 4) != 0) {
                    str3 = null;
                }
                return aVar.q(str, str2, str3, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBanner");
        }

        public static /* synthetic */ Object f(a aVar, String str, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str = "2";
                }
                return aVar.a(str, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClassifyMenu");
        }

        public static /* synthetic */ Object g(a aVar, String str, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str = "helpKey";
                }
                return aVar.l(str, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloatActionHelpUrl");
        }

        public static /* synthetic */ Object h(a aVar, String str, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str = "1";
                }
                return aVar.U(str, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHomeMenu");
        }

        public static /* synthetic */ Object i(a aVar, String str, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str = "5";
                }
                return aVar.f(str, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyMenu");
        }

        public static /* synthetic */ Object j(a aVar, String str, String str2, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str = "ca38c0581692da070fa829cc06556a8a";
                }
                if ((i4 & 2) != 0) {
                    str2 = "53d0109dcd490c9f0ab7ddefa3a95568";
                }
                return aVar.B(str, str2, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPgyerAppVersion");
        }

        public static /* synthetic */ Object k(a aVar, String str, String str2, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str = com.bxkj.base.v2.data.a.f18673h.a().w();
                }
                if ((i4 & 2) != 0) {
                    str2 = com.bxkj.base.v2.data.a.f18673h.a().C();
                }
                return aVar.i(str, str2, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShareCircleUrl");
        }

        public static /* synthetic */ Object l(a aVar, String str, String str2, int i4, int i5, kotlin.coroutines.c cVar, int i6, Object obj) {
            if (obj == null) {
                if ((i6 & 1) != 0) {
                    str = null;
                }
                String str3 = str;
                if ((i6 & 2) != 0) {
                    str2 = "1";
                }
                return aVar.Z(str3, str2, (i6 & 4) != 0 ? Integer.MAX_VALUE : i4, (i6 & 8) != 0 ? 0 : i5, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSportsPointList");
        }

        public static /* synthetic */ Object m(a aVar, String str, String str2, String str3, String str4, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 4) != 0) {
                    str3 = "password";
                }
                String str5 = str3;
                if ((i4 & 8) != 0) {
                    str4 = "app";
                }
                return aVar.o(str, str2, str5, str4, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }

        public static /* synthetic */ Object n(a aVar, String str, String str2, String str3, String str4, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    str2 = "123456";
                }
                String str5 = str2;
                if ((i4 & 4) != 0) {
                    str3 = "password";
                }
                String str6 = str3;
                if ((i4 & 8) != 0) {
                    str4 = "app";
                }
                return aVar.e(str, str5, str6, str4, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginThird");
        }

        public static /* synthetic */ Object o(a aVar, RequestBody requestBody, RequestBody requestBody2, RequestBody requestBody3, RequestBody requestBody4, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 8) != 0) {
                    requestBody4 = RequestBody.Companion.create(MediaType.Companion.parse("multipart/form-data"), "4");
                }
                return aVar.b(requestBody, requestBody2, requestBody3, requestBody4, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: passPointCamera");
        }

        public static /* synthetic */ Object p(a aVar, String str, kotlin.coroutines.c cVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    str = "appRunRank";
                }
                return aVar.x(str, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rankingExerciseRecordV2");
        }

        public static /* synthetic */ Object q(a aVar, String str, String str2, int i4, String str3, kotlin.coroutines.c cVar, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 8) != 0) {
                    str3 = null;
                }
                return aVar.Q(str, str2, i4, str3, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v3GetSportsRecord");
        }
    }

    @GET("exercise/exerciseSetting/checkTimeOut")
    @Nullable
    Object A(@NotNull @Query("identify") String str, @NotNull kotlin.coroutines.c<? super ApiResult<String>> cVar);

    @FormUrlEncoded
    @POST("https://www.pgyer.com/apiv2/app/check")
    @Nullable
    Object B(@Field("_api_key") @NotNull String str, @Field("appKey") @NotNull String str2, @NotNull kotlin.coroutines.c<? super PgyerApiResult<Map<String, Object>>> cVar);

    @POST("exercise/exerciseFeedback/addExerciseFeedback")
    @Nullable
    @Multipart
    Object C(@Nullable @Part("exerciseRecordId") RequestBody requestBody, @Nullable @Part("content") RequestBody requestBody2, @Nullable @PartMap Map<String, RequestBody> map, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("exercise/exerciseRecord/rankingExerciseRecord")
    @Nullable
    Object D(@NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("exercise/exerciseSetting/getExerciseStartTime")
    @Nullable
    Object E(@NotNull @Query("identify") String str, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @POST("exercise/exerciseRunningFace/v2/face")
    @Nullable
    @Multipart
    Object F(@Nullable @Part("key") RequestBody requestBody, @Nullable @Part("param") RequestBody requestBody2, @Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody3, @NotNull kotlin.coroutines.c<? super ApiResult<Boolean>> cVar);

    @GET("exercise/exerciseRecord/statisticsExerciseRecord")
    @Nullable
    Object G(@NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("upms/messageNotice/getMessageNoticeVoById")
    @Nullable
    Object H(@NotNull @Query("id") String str, @NotNull kotlin.coroutines.c<? super ApiResult<Object>> cVar);

    @Streaming
    @GET
    @Nullable
    Object I(@Url @NotNull String str, @NotNull kotlin.coroutines.c<? super Response<ResponseBody>> cVar);

    @GET("exercise/exerciseRecord/sumExerciseRecord")
    @Nullable
    Object J(@NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("upms/basUser/getLoginUserInfoThird")
    @Nullable
    Object K(@NotNull @Query("openid") String str, @NotNull @Query("type") String str2, @NotNull kotlin.coroutines.c<? super ApiResult<Object>> cVar);

    @GET("https://m.boxkj.com/app/sch/listSchoolDatas")
    @Nullable
    Object L(@NotNull @Query("name") String str, @NotNull kotlin.coroutines.c<? super OldApiResult<List<Map<String, Object>>>> cVar);

    @POST("exercise/exerciseRunningFace/v2/face")
    @Nullable
    @Multipart
    Object M(@Nullable @Part("key") RequestBody requestBody, @Nullable @Part("param") RequestBody requestBody2, @Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody3, @NotNull kotlin.coroutines.c<? super ApiResult<Boolean>> cVar);

    @POST("exercise/exerciseGaugePoint/{id}")
    @Nullable
    Object N(@Path("id") @NotNull String str, @NotNull kotlin.coroutines.c<? super ApiResult<String>> cVar);

    @GET("exercise/exerciseSetting/v2/getSetting")
    @Nullable
    Object O(@NotNull @Query("key") String str, @NotNull @Query("param") String str2, @NotNull kotlin.coroutines.c<? super ApiResult<String>> cVar);

    @GET("upms/sysSimulator/sysSimulatorList")
    @Nullable
    Object P(@NotNull kotlin.coroutines.c<? super ApiResult<List<Map<String, Object>>>> cVar);

    @GET("exercise/exerciseRecord/listExerciseRecord")
    @Nullable
    Object Q(@NotNull @Query("status") String str, @NotNull @Query("date") String str2, @Query("datePageIndex") int i4, @Nullable @Query("isFeedback") String str3, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @FormUrlEncoded
    @POST("exercise/exerciseRecord/v2/addExerciseRecord")
    @Nullable
    Object R(@Field("key") @NotNull String str, @Field("param") @NotNull String str2, @NotNull kotlin.coroutines.c<? super CommitResult<Object>> cVar);

    @GET("exercise/exerciseRecord/getExerciseRecord")
    @Nullable
    Object S(@NotNull @Query("exerciseRecordId") String str, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("exercise/exerciseFeedback/getFeedbackBalance")
    @Nullable
    Object T(@NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("upms/app/listMenu")
    @Nullable
    Object U(@Nullable @Query("location") String str, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("exercise/exerciseRecord/listExerciseRecord")
    @Nullable
    Object V(@Query("sportType") int i4, @Query("pageIndex") int i5, @Query("pageSize") int i6, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @POST("auth/token/logout")
    @Nullable
    Object W(@NotNull kotlin.coroutines.c<? super f1> cVar);

    @FormUrlEncoded
    @POST("exercise/exerciseRecord/addExerciseRecord")
    @Nullable
    Object X(@Field("sportType") int i4, @Field("startTime") long j4, @Field("endTime") long j5, @Field("sportTime") long j6, @Field("sportRange") @Nullable String str, @Field("speed") @Nullable String str2, @Field("avgSpeed") @Nullable String str3, @Field("brand") @Nullable String str4, @Field("model") @Nullable String str5, @Field("system") @Nullable String str6, @Field("version") @Nullable String str7, @Field("appVersion") @Nullable String str8, @Field("gitudeLatitude") @Nullable String str9, @Field("stepNumbers") @Nullable String str10, @Field("isSequencePoint") @Nullable String str11, @Field("pointList") @Nullable String str12, @Field("okPointList") @Nullable String str13, @Field("isFaceStatus") @Nullable String str14, @Field("uploadType") @Nullable Integer num, @Field("identify") @Nullable String str15, @Field("geofence") @Nullable String str16, @Field("limitSpeed") @Nullable String str17, @Field("limitStride") @Nullable String str18, @Field("limitStepFrequency") @Nullable String str19, @Field("gpsDistance") @Nullable String str20, @NotNull kotlin.coroutines.c<? super CommitResult<Object>> cVar);

    @FormUrlEncoded
    @POST("exercise/exerciseRecord/checkExerciseRecord")
    @Nullable
    Object Y(@Field("identifys") @Nullable String str, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("exercise/exerciseGaugePoint/page")
    @Nullable
    Object Z(@Nullable @Query("basCampusId") String str, @NotNull @Query("status") String str2, @Query("pageSize") int i4, @Query("pageIndex") int i5, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("upms/app/listMenu")
    @Nullable
    Object a(@Nullable @Query("location") String str, @NotNull kotlin.coroutines.c<? super ApiResult<List<Map<String, Object>>>> cVar);

    @POST("exercise/exerciseRunningFace/face")
    @Nullable
    @Multipart
    Object b(@Nullable @Part("identify") RequestBody requestBody, @Nullable @Part("remark") RequestBody requestBody2, @Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody3, @Nullable @Part("type") RequestBody requestBody4, @NotNull kotlin.coroutines.c<? super ApiResult<Boolean>> cVar);

    @POST("exercise/exerciseRunningFace/face")
    @Nullable
    @Multipart
    Object c(@Nullable @Part("identify") RequestBody requestBody, @Nullable @Part("type") RequestBody requestBody2, @Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody3, @NotNull kotlin.coroutines.c<? super ApiResult<Boolean>> cVar);

    @POST("exercise/exerciseRunningFace/faceVer")
    @Nullable
    @Multipart
    Object d(@Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody, @NotNull kotlin.coroutines.c<? super ApiResult<Boolean>> cVar);

    @POST("auth/oauth/token")
    @Nullable
    Object e(@Nullable @Query("username") String str, @Nullable @Query("password") String str2, @Nullable @Query("grant_type") String str3, @Nullable @Query("type") String str4, @NotNull kotlin.coroutines.c<? super Map<String, ? extends Object>> cVar);

    @GET("upms/app/listMenu")
    @Nullable
    Object f(@Nullable @Query("location") String str, @NotNull kotlin.coroutines.c<? super ApiResult<List<Map<String, Object>>>> cVar);

    @POST("upms/basUserImage/addUserFace")
    @Nullable
    @Multipart
    Object g(@Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody, @NotNull kotlin.coroutines.c<? super ApiResult<Boolean>> cVar);

    @GET("https://api.jpush.cn/v3/aliases/{alias_value}")
    @Nullable
    Object h(@Header("Authorization") @NotNull String str, @Path("alias_value") @NotNull String str2, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("http://circle.h5.tsnkj.com/circle/circleRecord/appGetCircleH5Url")
    @Nullable
    Object i(@Nullable @Query("schoolCode") String str, @Nullable @Query("userName") String str2, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("exercise/exerciseSetting/setting")
    @Nullable
    Object j(@NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("upms/basUser/getLoginUserInfo")
    @Nullable
    Object k(@NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("upms/app/getH5Url")
    @Nullable
    Object l(@Nullable @Query("key") String str, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("upms/basUser/isDefalutPass")
    @Nullable
    Object m(@NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @GET("upms/messageNotice/getLatestUnreadNotice")
    @Nullable
    Object n(@NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @POST("auth/oauth/token")
    @Nullable
    Object o(@Nullable @Query("username") String str, @Nullable @Query("password") String str2, @Nullable @Query("grant_type") String str3, @Nullable @Query("type") String str4, @NotNull kotlin.coroutines.c<? super Map<String, ? extends Object>> cVar);

    @FormUrlEncoded
    @POST("exercise/exerciseGaugePoint")
    @Nullable
    Object p(@Field("latitude") @NotNull String str, @Field("longitude") @NotNull String str2, @Field("content") @NotNull String str3, @Field("basCampusId") @Nullable String str4, @NotNull kotlin.coroutines.c<? super ApiResult<String>> cVar);

    @GET("upms/messageArticle/listByType")
    @Nullable
    Object q(@Nullable @Query("type") String str, @Nullable @Query("size") String str2, @Nullable @Query("current") String str3, @NotNull kotlin.coroutines.c<? super ApiResult<List<Map<String, Object>>>> cVar);

    @GET("upms/sysSchool/getAppid")
    @Nullable
    Object r(@NotNull kotlin.coroutines.c<? super ApiResult<String>> cVar);

    @GET("exercise/exerciseExplanation/getExerciseExplanation")
    @Nullable
    Object s(@NotNull kotlin.coroutines.c<? super ApiResult<String>> cVar);

    @GET("upms/messageArticleClickRecord/appClickArticle")
    @Nullable
    Object t(@NotNull @Query("messageArticleId") String str, @Nullable @Query("basUserId") String str2, @NotNull kotlin.coroutines.c<? super ApiResult<Object>> cVar);

    @GET("upms/basCampus/listCampus")
    @Nullable
    Object u(@NotNull kotlin.coroutines.c<? super ApiResult<List<Map<String, Object>>>> cVar);

    @GET("upms/app/getTeacherUrl")
    @Nullable
    Object v(@NotNull kotlin.coroutines.c<? super ApiResult<String>> cVar);

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/addStuGymClockRecord")
    @Nullable
    Object w(@Field("operatorID") @NotNull String str, @Field("stuCardNum") @NotNull String str2, @Field("type") @NotNull String str3, @NotNull kotlin.coroutines.c<? super ApiResult<String>> cVar);

    @GET("upms/app/getH5Url")
    @Nullable
    Object x(@Nullable @Query("key") String str, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);

    @POST("auth/oauth/token")
    @Nullable
    Object y(@Nullable @Query("refresh_token") String str, @Nullable @Query("scope") String str2, @Nullable @Query("grant_type") String str3, @Nullable @Query("type") String str4, @NotNull kotlin.coroutines.c<? super Map<String, ? extends Object>> cVar);

    @GET("exercise/exerciseSetting/getSetting")
    @Nullable
    Object z(@Query("runType") int i4, @NotNull kotlin.coroutines.c<? super ApiResult<Map<String, Object>>> cVar);
}
