package com.amap.api.col.p0463l;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.bytedance.msdk.api.AdError;
import com.clj.fastble.BleManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* renamed from: com.amap.api.col.3l.z3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CoreUtil {

    /* renamed from: a */
    private static String[] f5817a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    /* renamed from: a */
    public static int m53335a(List<LatLng> list) {
        int i = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i2 = 0;
        while (i < list.size() - 1) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i);
            if (latLng == null || latLng2 == null) {
                break;
            }
            i2 = (int) (i2 + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return i2;
    }

    /* renamed from: b */
    private static void m53334b(int i, String str) throws AMapException {
        if (i != 0) {
            switch (i) {
                case BleManager.f22896l /* 10000 */:
                    return;
                case 10001:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_KEY);
                case 10002:
                    throw new AMapException(AMapException.AMAP_SERVICE_NOT_AVAILBALE);
                case 10003:
                    throw new AMapException(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT);
                case IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START /* 10004 */:
                    throw new AMapException(AMapException.AMAP_ACCESS_TOO_FREQUENT);
                case IMediaPlayer.MEDIA_INFO_OPEN_INPUT /* 10005 */:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_IP);
                case IMediaPlayer.MEDIA_INFO_FIND_STREAM_INFO /* 10006 */:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_DOMAIN);
                case 10007:
                    throw new AMapException("用户签名未通过");
                case IMediaPlayer.MEDIA_INFO_VIDEO_SEEK_RENDERING_START /* 10008 */:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_SCODE);
                case IMediaPlayer.MEDIA_INFO_AUDIO_SEEK_RENDERING_START /* 10009 */:
                    throw new AMapException(AMapException.AMAP_USERKEY_PLAT_NOMATCH);
                case 10010:
                    throw new AMapException(AMapException.AMAP_IP_QUERY_OVER_LIMIT);
                case 10011:
                    throw new AMapException(AMapException.AMAP_NOT_SUPPORT_HTTPS);
                case 10012:
                    throw new AMapException(AMapException.AMAP_INSUFFICIENT_PRIVILEGES);
                case 10013:
                    throw new AMapException(AMapException.AMAP_USER_KEY_RECYCLED);
                default:
                    switch (i) {
                        case 20000:
                            throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS);
                        case 20001:
                            throw new AMapException(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS);
                        case 20002:
                            throw new AMapException(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST);
                        case 20003:
                            throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR);
                        default:
                            switch (i) {
                                case 30000:
                                    throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_ERROR);
                                case AdError.ERROR_CODE_THIRD_SDK_NOT_INIT /* 30001 */:
                                    throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
                                case AdError.ERROR_CODE_THIRD_SDK_PARARM_ERROR /* 30002 */:
                                    throw new AMapException(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT);
                                case AdError.ERROR_CODE_THIRD_SDK_FILE_IO_ERROR /* 30003 */:
                                    throw new AMapException(AMapException.AMAP_ENGINE_RETURN_TIMEOUT);
                                default:
                                    throw new AMapException(str);
                            }
                    }
            }
        }
    }

    /* renamed from: c */
    public static void m53333c(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                m53334b(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has("status") && jSONObject.has("infocode")) {
                String string = jSONObject.getString("status");
                int i = jSONObject.getInt("infocode");
                if ("1".equals(string)) {
                    return;
                }
                String string2 = jSONObject.getString("info");
                if ("0".equals(string)) {
                    m53334b(i, string2);
                }
            }
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }
}
