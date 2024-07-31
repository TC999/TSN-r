package com.bxkj.student.p094v2.retrofit;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.p085v2.http.result.ApiResult;
import com.bxkj.base.p085v2.http.result.OldApiResult;
import com.bxkj.student.p094v2.common.data.CommitResult;
import com.bxkj.student.p094v2.common.utils.PgyerUtils;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.common.SocializeConstants;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.C14342f0;
import master.flame.danmaku.danmaku.parser.IDataSource;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p644t.PgyerApiResult;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 ]2\u00020\u0001:\u0001]J\u001d\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u0007\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005J)\u0010\b\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0005J3\u0010\u000b\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0005J¿\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010,2\b\b\u0001\u0010\u0012\u001a\u00020\t2\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u00132\b\b\u0001\u0010\u0016\u001a\u00020\u00132\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\b-\u0010.J/\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010,2\b\b\u0001\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0010JG\u00102\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u00100\u001a\u00020\t2\b\b\u0001\u00101\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0004\b2\u00103JS\u00108\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u00104\u001a\u00020\u00032\b\b\u0001\u00105\u001a\u00020\u00032\b\b\u0001\u00106\u001a\u00020\t2\n\b\u0003\u00107\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\b8\u00109J3\u0010;\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u0010:\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b;\u0010<J)\u0010=\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b=\u0010\u0005J)\u0010>\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b>\u0010\u0005J`\u0010D\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\n\b\u0001\u0010:\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010@\u001a\u0004\u0018\u00010?2\u001d\b\u0001\u0010C\u001a\u0017\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u00010A¢\u0006\u0002\bBH§@ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ'\u0010H\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H§@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ?\u0010J\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H§@ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ?\u0010M\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010L\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H§@ø\u0001\u0000¢\u0006\u0004\bM\u0010KJ'\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010&\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\bN\u0010<J'\u0010O\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H§@ø\u0001\u0000¢\u0006\u0004\bO\u0010IJ3\u0010P\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u00022\b\b\u0001\u0010&\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\bP\u0010<J9\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\b\u0001\u0010Q\u001a\u00020\u00032\b\b\u0001\u0010R\u001a\u00020\u00032\b\b\u0001\u0010L\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\bS\u0010TJQ\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A2\n\b\u0001\u0010U\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010V\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010W\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010L\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ3\u0010[\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0\u00022\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\b[\u0010<J=\u0010]\u001a \u0012\u001a\u0012\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A\u0018\u00010\\\u0018\u00010\u00022\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\b]\u0010<J9\u0010^\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0\\0\u00022\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\b^\u0010<J'\u0010_\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b_\u0010\u0005JQ\u0010a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A2\n\b\u0001\u0010`\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010V\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010W\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010L\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\ba\u0010YJ\u0013\u0010c\u001a\u00020bH§@ø\u0001\u0000¢\u0006\u0004\bc\u0010\u0005JQ\u0010f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A0\\0\u00022\n\b\u0003\u0010L\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010d\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010e\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\bf\u0010TJ+\u0010g\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010A\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\bg\u0010\u0005J#\u0010k\u001a\b\u0012\u0004\u0012\u00020j0i2\b\b\u0001\u0010h\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\bk\u0010<JK\u0010m\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010l\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?2\n\b\u0003\u0010L\u001a\u0004\u0018\u00010?H§@ø\u0001\u0000¢\u0006\u0004\bm\u0010nJ?\u0010o\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010?2\n\b\u0001\u0010F\u001a\u0004\u0018\u00010?H§@ø\u0001\u0000¢\u0006\u0004\bo\u0010KJ)\u0010p\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\bp\u0010\u0005J\u0019\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\bq\u0010\u0005J/\u0010r\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A\u0018\u00010\\0\u0002H§@ø\u0001\u0000¢\u0006\u0004\br\u0010\u0005JS\u0010t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00060\u00022\n\b\u0003\u0010s\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u00104\u001a\u00020\u00032\b\b\u0003\u00101\u001a\u00020\t2\b\b\u0003\u00100\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0004\bt\u0010uJE\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\b\u0001\u0010v\u001a\u00020\u00032\b\b\u0001\u0010w\u001a\u00020\u00032\b\b\u0001\u0010@\u001a\u00020\u00032\n\b\u0001\u0010s\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\bx\u0010YJ%\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\b\b\u0001\u0010y\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\bz\u0010<J+\u0010{\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b{\u0010\u0005J'\u0010}\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\b\b\u0001\u0010|\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b}\u0010<J/\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010~\u001a\u00020\u00032\b\b\u0001\u0010L\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b\u007f\u0010\u0010JS\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A2\n\b\u0001\u0010~\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010V\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010W\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010L\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0005\b\u0080\u0001\u0010YJ5\u0010\u0083\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u00032\u000b\b\u0003\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0005\b\u0083\u0001\u0010\u0010J=\u0010\u0086\u0001\u001a\u001f\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\\\u0018\u00010\u0085\u00012\t\b\u0001\u0010\u0084\u0001\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0005\b\u0086\u0001\u0010<J3\u0010\u0087\u0001\u001a \u0012\u001a\u0012\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010A\u0018\u00010\\\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u0087\u0001\u0010\u0005JD\u0010\u008b\u0001\u001a\u001b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0018\u00010\u008a\u00012\t\b\u0003\u0010\u0088\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u0089\u0001\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0005\b\u008b\u0001\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008c\u0001"}, m12616d2 = {"Lcom/bxkj/student/v2/retrofit/a;", "", "Lcom/bxkj/base/v2/http/result/ApiResult;", "", "o", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "h", "F", "", "sportsType", "v", "(ILkotlin/coroutines/c;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_KEY, "param", "K", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "p", "sportType", "", AnalyticsConfig.RTD_START_TIME, "endTime", "sportTime", "sportRange", "speed", "avgSpeed", C2624bk.f8686j, C2624bk.f8685i, ConstantHelper.LOG_OS, ConstantHelper.LOG_VS, "appVersion", "gitudeLatitude", "stepNumbers", "isSequencePoint", "pointList", "okPointList", "isFaceStatus", "uploadType", "identify", "geofence", "limitSpeed", "limitStride", "limitStepFrequency", "gpsDistance", "Lcom/bxkj/student/v2/common/data/CommitResult;", ExifInterface.GPS_DIRECTION_TRUE, "(IJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "N", "pageIndex", "pageSize", "R", "(IIILkotlin/coroutines/c;)Ljava/lang/Object;", "status", "date", "datePageIndex", "isFeedback", "M", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "exerciseRecordId", "O", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", UMCommonContent.f37777aG, "C", "Lokhttp3/RequestBody;", "content", "", "Lkotlin/jvm/JvmSuppressWildcards;", "files", "y", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Ljava/util/Map;Lkotlin/coroutines/c;)Ljava/lang/Object;", IDataSource.f43973c, "", "g", "(Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "I", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "type", "c", IAdInterListener.AdReqParam.WIDTH, "d", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "operatorID", "stuCardNum", UMCommonContent.f37782aL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "username", "password", "grant_type", C7304t.f25048d, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", SocializeConstants.KEY_LOCATION, "Q", "", "a", "f", "i", "refresh_token", "u", "Lkotlin/f1;", ExifInterface.LATITUDE_SOUTH, "size", "current", "n", "j", "url", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", ExifInterface.LONGITUDE_EAST, "remark", "b", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/c;)Ljava/lang/Object;", "B", "P", "s", "r", "basCampusId", "U", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/c;)Ljava/lang/Object;", "latitude", "longitude", "m", "pointId", "J", "k", "id", "D", "openid", "G", "e", "messageArticleId", "basUserId", CampaignEx.JSON_KEY_AD_Q, "name", "Lcom/bxkj/base/v2/http/result/OldApiResult;", "H", "L", "_api_key", "appKey", "Lt/a;", "x", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.retrofit.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface ApiService {
    @NotNull

    /* renamed from: a */
    public static final C5591a f20329a = C5591a.f20332a;
    @NotNull

    /* renamed from: b */
    public static final String f20330b = "https://m.boxkj.com/";
    @NotNull

    /* renamed from: c */
    public static final String f20331c = "http://a.sxstczx.com/";

    /* compiled from: ApiService.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\tR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\t¨\u0006\u0010"}, m12616d2 = {"Lcom/bxkj/student/v2/retrofit/a$a;", "", "", "b", "Ljava/lang/String;", "MOVE_BASE_URL", "c", "MAIN_BASE_URL", "d", "()Ljava/lang/String;", "HELP_CENTER_URL", "e", "a", "FORGET_PASSWORD_URL", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.retrofit.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5591a {

        /* renamed from: a */
        static final /* synthetic */ C5591a f20332a = new C5591a();
        @NotNull

        /* renamed from: b */
        public static final String f20333b = "https://m.boxkj.com/";
        @NotNull

        /* renamed from: c */
        public static final String f20334c = "http://a.sxstczx.com/";
        @NotNull

        /* renamed from: d */
        private static final String f20335d;
        @NotNull

        /* renamed from: e */
        private static final String f20336e;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append("https://h.tsnkj.com/?school=");
            LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
            sb.append(c3984b.m43634a().m43646p());
            sb.append("#/pages/user/help/help");
            f20335d = sb.toString();
            f20336e = C14342f0.m8216C(c3984b.m43634a().m43654h(), "#/pages/pwd/pwdType/pwdType");
        }

        private C5591a() {
        }

        @NotNull
        /* renamed from: a */
        public final String m38904a() {
            return f20336e;
        }

        @NotNull
        /* renamed from: b */
        public final String m38903b() {
            return f20335d;
        }
    }

    /* compiled from: ApiService.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    /* renamed from: com.bxkj.student.v2.retrofit.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5592b {
        /* renamed from: a */
        public static /* synthetic */ Object m38902a(ApiService apiService, int i, long j, long j2, long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Integer num, String str15, String str16, String str17, String str18, String str19, String str20, InterfaceC14268c interfaceC14268c, int i2, Object obj) {
            if (obj == null) {
                return apiService.m38932T(i, j, j2, j3, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, (i2 & 16384) != 0 ? "0" : str11, str12, str13, str14, num, str15, str16, str17, str18, str19, str20, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRunRecorderV3");
        }

        /* renamed from: b */
        public static /* synthetic */ Object m38901b(ApiService apiService, String str, String str2, String str3, String str4, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "server";
                }
                String str5 = str2;
                if ((i & 4) != 0) {
                    str3 = "refresh_token";
                }
                String str6 = str3;
                if ((i & 8) != 0) {
                    str4 = Constants.JumpUrlConstants.SRC_TYPE_APP;
                }
                return apiService.m38910u(str, str5, str6, str4, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoLogin");
        }

        /* renamed from: c */
        public static /* synthetic */ Object m38900c(ApiService apiService, String str, String str2, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
                    str2 = c3984b.m43634a().m43637y() ? c3984b.m43634a().m43642t() : "";
                }
                return apiService.m38914q(str, str2, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickArticle");
        }

        /* renamed from: d */
        public static /* synthetic */ Object m38899d(ApiService apiService, String str, String str2, String str3, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "4";
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return apiService.m38917n(str, str2, str3, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBanner");
        }

        /* renamed from: e */
        public static /* synthetic */ Object m38898e(ApiService apiService, String str, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "2";
                }
                return apiService.m38930a(str, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClassifyMenu");
        }

        /* renamed from: f */
        public static /* synthetic */ Object m38897f(ApiService apiService, String str, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "1";
                }
                return apiService.m38935Q(str, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHomeMenu");
        }

        /* renamed from: g */
        public static /* synthetic */ Object m38896g(ApiService apiService, String str, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "5";
                }
                return apiService.m38925f(str, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyMenu");
        }

        /* renamed from: h */
        public static /* synthetic */ Object m38895h(ApiService apiService, String str, String str2, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = PgyerUtils.f20127b;
                }
                if ((i & 2) != 0) {
                    str2 = PgyerUtils.f20128c;
                }
                return apiService.m38907x(str, str2, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPgyerAppVersion");
        }

        /* renamed from: i */
        public static /* synthetic */ Object m38894i(ApiService apiService, String str, String str2, int i, int i2, InterfaceC14268c interfaceC14268c, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = null;
                }
                String str3 = str;
                if ((i3 & 2) != 0) {
                    str2 = "1";
                }
                return apiService.m38931U(str3, str2, (i3 & 4) != 0 ? Integer.MAX_VALUE : i, (i3 & 8) != 0 ? 0 : i2, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSportsPointList");
        }

        /* renamed from: j */
        public static /* synthetic */ Object m38893j(ApiService apiService, String str, String str2, String str3, String str4, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = "password";
                }
                String str5 = str3;
                if ((i & 8) != 0) {
                    str4 = Constants.JumpUrlConstants.SRC_TYPE_APP;
                }
                return apiService.m38919l(str, str2, str5, str4, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }

        /* renamed from: k */
        public static /* synthetic */ Object m38892k(ApiService apiService, String str, String str2, String str3, String str4, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "123456";
                }
                String str5 = str2;
                if ((i & 4) != 0) {
                    str3 = "password";
                }
                String str6 = str3;
                if ((i & 8) != 0) {
                    str4 = Constants.JumpUrlConstants.SRC_TYPE_APP;
                }
                return apiService.m38926e(str, str5, str6, str4, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginThird");
        }

        /* renamed from: l */
        public static /* synthetic */ Object m38891l(ApiService apiService, RequestBody requestBody, RequestBody requestBody2, RequestBody requestBody3, RequestBody requestBody4, InterfaceC14268c interfaceC14268c, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    requestBody4 = RequestBody.Companion.create(MediaType.Companion.parse(HttpHeaders.Values.MULTIPART_FORM_DATA), "4");
                }
                return apiService.m38929b(requestBody, requestBody2, requestBody3, requestBody4, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: passPointCamera");
        }

        /* renamed from: m */
        public static /* synthetic */ Object m38890m(ApiService apiService, String str, String str2, int i, String str3, InterfaceC14268c interfaceC14268c, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    str3 = null;
                }
                return apiService.m38939M(str, str2, i, str3, interfaceC14268c);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v3GetSportsRecord");
        }
    }

    @GET("exercise/exerciseSetting/getExerciseStartTime")
    @Nullable
    /* renamed from: A */
    Object m38951A(@NotNull @Query("identify") String str, @NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @POST("exercise/exerciseRunningFace/v2/face")
    @Nullable
    @Multipart
    /* renamed from: B */
    Object m38950B(@Nullable @Part("key") RequestBody requestBody, @Nullable @Part("param") RequestBody requestBody2, @Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody3, @NotNull InterfaceC14268c<? super ApiResult<Boolean>> interfaceC14268c);

    @GET("exercise/exerciseRecord/statisticsExerciseRecord")
    @Nullable
    /* renamed from: C */
    Object m38949C(@NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("upms/messageNotice/getMessageNoticeVoById")
    @Nullable
    /* renamed from: D */
    Object m38948D(@NotNull @Query("id") String str, @NotNull InterfaceC14268c<? super ApiResult<Object>> interfaceC14268c);

    @Streaming
    @GET
    @Nullable
    /* renamed from: E */
    Object m38947E(@Url @NotNull String str, @NotNull InterfaceC14268c<? super Response<ResponseBody>> interfaceC14268c);

    @GET("exercise/exerciseRecord/sumExerciseRecord")
    @Nullable
    /* renamed from: F */
    Object m38946F(@NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("upms/basUser/getLoginUserInfoThird")
    @Nullable
    /* renamed from: G */
    Object m38945G(@NotNull @Query("openid") String str, @NotNull @Query("type") String str2, @NotNull InterfaceC14268c<? super ApiResult<Object>> interfaceC14268c);

    @GET("https://m.boxkj.com/app/sch/listSchoolDatas")
    @Nullable
    /* renamed from: H */
    Object m38944H(@NotNull @Query("name") String str, @NotNull InterfaceC14268c<? super OldApiResult<List<Map<String, Object>>>> interfaceC14268c);

    @POST("exercise/exerciseRunningFace/v2/face")
    @Nullable
    @Multipart
    /* renamed from: I */
    Object m38943I(@Nullable @Part("key") RequestBody requestBody, @Nullable @Part("param") RequestBody requestBody2, @Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody3, @NotNull InterfaceC14268c<? super ApiResult<Boolean>> interfaceC14268c);

    @DELETE("exercise/exerciseGaugePoint/{id}")
    @Nullable
    /* renamed from: J */
    Object m38942J(@Path("id") @NotNull String str, @NotNull InterfaceC14268c<? super ApiResult<String>> interfaceC14268c);

    @GET("exercise/exerciseSetting/v2/getSetting")
    @Nullable
    /* renamed from: K */
    Object m38941K(@NotNull @Query("key") String str, @NotNull @Query("param") String str2, @NotNull InterfaceC14268c<? super ApiResult<String>> interfaceC14268c);

    @GET("upms/sysSimulator/sysSimulatorList")
    @Nullable
    /* renamed from: L */
    Object m38940L(@NotNull InterfaceC14268c<? super ApiResult<List<Map<String, Object>>>> interfaceC14268c);

    @GET("exercise/exerciseRecord/listExerciseRecord")
    @Nullable
    /* renamed from: M */
    Object m38939M(@NotNull @Query("status") String str, @NotNull @Query("date") String str2, @Query("datePageIndex") int i, @Nullable @Query("isFeedback") String str3, @NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @FormUrlEncoded
    @POST("exercise/exerciseRecord/v2/addExerciseRecord")
    @Nullable
    /* renamed from: N */
    Object m38938N(@Field("key") @NotNull String str, @Field("param") @NotNull String str2, @NotNull InterfaceC14268c<? super CommitResult<Object>> interfaceC14268c);

    @GET("exercise/exerciseRecord/getExerciseRecord")
    @Nullable
    /* renamed from: O */
    Object m38937O(@NotNull @Query("exerciseRecordId") String str, @NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("exercise/exerciseFeedback/getFeedbackBalance")
    @Nullable
    /* renamed from: P */
    Object m38936P(@NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("upms/app/listMenu")
    @Nullable
    /* renamed from: Q */
    Object m38935Q(@Nullable @Query("location") String str, @NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("exercise/exerciseRecord/listExerciseRecord")
    @Nullable
    /* renamed from: R */
    Object m38934R(@Query("sportType") int i, @Query("pageIndex") int i2, @Query("pageSize") int i3, @NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @DELETE("auth/token/logout")
    @Nullable
    /* renamed from: S */
    Object m38933S(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @FormUrlEncoded
    @POST("exercise/exerciseRecord/addExerciseRecord")
    @Nullable
    /* renamed from: T */
    Object m38932T(@Field("sportType") int i, @Field("startTime") long j, @Field("endTime") long j2, @Field("sportTime") long j3, @Field("sportRange") @Nullable String str, @Field("speed") @Nullable String str2, @Field("avgSpeed") @Nullable String str3, @Field("brand") @Nullable String str4, @Field("model") @Nullable String str5, @Field("system") @Nullable String str6, @Field("version") @Nullable String str7, @Field("appVersion") @Nullable String str8, @Field("gitudeLatitude") @Nullable String str9, @Field("stepNumbers") @Nullable String str10, @Field("isSequencePoint") @Nullable String str11, @Field("pointList") @Nullable String str12, @Field("okPointList") @Nullable String str13, @Field("isFaceStatus") @Nullable String str14, @Field("uploadType") @Nullable Integer num, @Field("identify") @Nullable String str15, @Field("geofence") @Nullable String str16, @Field("limitSpeed") @Nullable String str17, @Field("limitStride") @Nullable String str18, @Field("limitStepFrequency") @Nullable String str19, @Field("gpsDistance") @Nullable String str20, @NotNull InterfaceC14268c<? super CommitResult<Object>> interfaceC14268c);

    @GET("exercise/exerciseGaugePoint/page")
    @Nullable
    /* renamed from: U */
    Object m38931U(@Nullable @Query("basCampusId") String str, @NotNull @Query("status") String str2, @Query("pageSize") int i, @Query("pageIndex") int i2, @NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("upms/app/listMenu")
    @Nullable
    /* renamed from: a */
    Object m38930a(@Nullable @Query("location") String str, @NotNull InterfaceC14268c<? super ApiResult<List<Map<String, Object>>>> interfaceC14268c);

    @POST("exercise/exerciseRunningFace/face")
    @Nullable
    @Multipart
    /* renamed from: b */
    Object m38929b(@Nullable @Part("identify") RequestBody requestBody, @Nullable @Part("remark") RequestBody requestBody2, @Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody3, @Nullable @Part("type") RequestBody requestBody4, @NotNull InterfaceC14268c<? super ApiResult<Boolean>> interfaceC14268c);

    @POST("exercise/exerciseRunningFace/face")
    @Nullable
    @Multipart
    /* renamed from: c */
    Object m38928c(@Nullable @Part("identify") RequestBody requestBody, @Nullable @Part("type") RequestBody requestBody2, @Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody3, @NotNull InterfaceC14268c<? super ApiResult<Boolean>> interfaceC14268c);

    @POST("exercise/exerciseRunningFace/faceVer")
    @Nullable
    @Multipart
    /* renamed from: d */
    Object m38927d(@Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody, @NotNull InterfaceC14268c<? super ApiResult<Boolean>> interfaceC14268c);

    @POST("auth/oauth/token")
    @Nullable
    /* renamed from: e */
    Object m38926e(@Nullable @Query("username") String str, @Nullable @Query("password") String str2, @Nullable @Query("grant_type") String str3, @Nullable @Query("type") String str4, @NotNull InterfaceC14268c<? super Map<String, ? extends Object>> interfaceC14268c);

    @GET("upms/app/listMenu")
    @Nullable
    /* renamed from: f */
    Object m38925f(@Nullable @Query("location") String str, @NotNull InterfaceC14268c<? super ApiResult<List<Map<String, Object>>>> interfaceC14268c);

    @POST("upms/basUserImage/addUserFace")
    @Nullable
    @Multipart
    /* renamed from: g */
    Object m38924g(@Nullable @Part("file\"; filename=\"file.jpg") RequestBody requestBody, @NotNull InterfaceC14268c<? super ApiResult<Boolean>> interfaceC14268c);

    @GET("exercise/exerciseSetting/setting")
    @Nullable
    /* renamed from: h */
    Object m38923h(@NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("upms/basUser/getLoginUserInfo")
    @Nullable
    /* renamed from: i */
    Object m38922i(@NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("upms/basUser/isDefalutPass")
    @Nullable
    /* renamed from: j */
    Object m38921j(@NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("upms/messageNotice/getLatestUnreadNotice")
    @Nullable
    /* renamed from: k */
    Object m38920k(@NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @POST("auth/oauth/token")
    @Nullable
    /* renamed from: l */
    Object m38919l(@Nullable @Query("username") String str, @Nullable @Query("password") String str2, @Nullable @Query("grant_type") String str3, @Nullable @Query("type") String str4, @NotNull InterfaceC14268c<? super Map<String, ? extends Object>> interfaceC14268c);

    @FormUrlEncoded
    @POST("exercise/exerciseGaugePoint")
    @Nullable
    /* renamed from: m */
    Object m38918m(@Field("latitude") @NotNull String str, @Field("longitude") @NotNull String str2, @Field("content") @NotNull String str3, @Field("basCampusId") @Nullable String str4, @NotNull InterfaceC14268c<? super ApiResult<String>> interfaceC14268c);

    @GET("upms/messageArticle/listByType")
    @Nullable
    /* renamed from: n */
    Object m38917n(@Nullable @Query("type") String str, @Nullable @Query("size") String str2, @Nullable @Query("current") String str3, @NotNull InterfaceC14268c<? super ApiResult<List<Map<String, Object>>>> interfaceC14268c);

    @GET("upms/sysSchool/getAppid")
    @Nullable
    /* renamed from: o */
    Object m38916o(@NotNull InterfaceC14268c<? super ApiResult<String>> interfaceC14268c);

    @GET("exercise/exerciseExplanation/getExerciseExplanation")
    @Nullable
    /* renamed from: p */
    Object m38915p(@NotNull InterfaceC14268c<? super ApiResult<String>> interfaceC14268c);

    @GET("upms/messageArticleClickRecord/appClickArticle")
    @Nullable
    /* renamed from: q */
    Object m38914q(@NotNull @Query("messageArticleId") String str, @Nullable @Query("basUserId") String str2, @NotNull InterfaceC14268c<? super ApiResult<Object>> interfaceC14268c);

    @GET("upms/basCampus/listCampus")
    @Nullable
    /* renamed from: r */
    Object m38913r(@NotNull InterfaceC14268c<? super ApiResult<List<Map<String, Object>>>> interfaceC14268c);

    @GET("upms/app/getTeacherUrl")
    @Nullable
    /* renamed from: s */
    Object m38912s(@NotNull InterfaceC14268c<? super ApiResult<String>> interfaceC14268c);

    @FormUrlEncoded
    @POST("app/stuGymClockRecord/addStuGymClockRecord")
    @Nullable
    /* renamed from: t */
    Object m38911t(@Field("operatorID") @NotNull String str, @Field("stuCardNum") @NotNull String str2, @Field("type") @NotNull String str3, @NotNull InterfaceC14268c<? super ApiResult<String>> interfaceC14268c);

    @POST("auth/oauth/token")
    @Nullable
    /* renamed from: u */
    Object m38910u(@Nullable @Query("refresh_token") String str, @Nullable @Query("scope") String str2, @Nullable @Query("grant_type") String str3, @Nullable @Query("type") String str4, @NotNull InterfaceC14268c<? super Map<String, ? extends Object>> interfaceC14268c);

    @GET("exercise/exerciseSetting/getSetting")
    @Nullable
    /* renamed from: v */
    Object m38909v(@Query("runType") int i, @NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("exercise/exerciseSetting/checkTimeOut")
    @Nullable
    /* renamed from: w */
    Object m38908w(@NotNull @Query("identify") String str, @NotNull InterfaceC14268c<? super ApiResult<String>> interfaceC14268c);

    @FormUrlEncoded
    @POST("https://www.pgyer.com/apiv2/app/check")
    @Nullable
    /* renamed from: x */
    Object m38907x(@Field("_api_key") @NotNull String str, @Field("appKey") @NotNull String str2, @NotNull InterfaceC14268c<? super PgyerApiResult<Map<String, Object>>> interfaceC14268c);

    @POST("exercise/exerciseFeedback/addExerciseFeedback")
    @Nullable
    @Multipart
    /* renamed from: y */
    Object m38906y(@Nullable @Part("exerciseRecordId") RequestBody requestBody, @Nullable @Part("content") RequestBody requestBody2, @Nullable @PartMap Map<String, RequestBody> map, @NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);

    @GET("exercise/exerciseRecord/rankingExerciseRecord")
    @Nullable
    /* renamed from: z */
    Object m38905z(@NotNull InterfaceC14268c<? super ApiResult<Map<String, Object>>> interfaceC14268c);
}
