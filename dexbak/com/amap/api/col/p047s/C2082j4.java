package com.amap.api.col.p047s;

import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.bytedance.msdk.api.AdError;
import com.clj.fastble.BleManager;
import com.github.mikephil.charting.utils.Utils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: CoreUtil.java */
/* renamed from: com.amap.api.col.s.j4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2082j4 {
    /* renamed from: a */
    public static double m52833a(double d) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    /* renamed from: b */
    public static float m52832b(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        if (latLonPoint == null || latLonPoint2 == null) {
            return 0.0f;
        }
        try {
            double longitude = latLonPoint.getLongitude();
            double d = longitude * 0.01745329251994329d;
            double latitude = latLonPoint.getLatitude() * 0.01745329251994329d;
            double longitude2 = latLonPoint2.getLongitude() * 0.01745329251994329d;
            double latitude2 = latLonPoint2.getLatitude() * 0.01745329251994329d;
            double sin = Math.sin(d);
            double sin2 = Math.sin(latitude);
            double cos = Math.cos(d);
            double cos2 = Math.cos(latitude);
            double sin3 = Math.sin(longitude2);
            double sin4 = Math.sin(latitude2);
            double cos3 = Math.cos(longitude2);
            double cos4 = Math.cos(latitude2);
            double[] dArr = {cos * cos2, cos2 * sin, sin2};
            double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
            return (float) (Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: c */
    public static String m52831c(int i) {
        StringBuilder sb = new StringBuilder();
        if ((i & 1) != 0) {
            sb.append("cost,");
        }
        if ((i & 2) != 0) {
            sb.append("tmcs,");
        }
        if ((i & 4) != 0) {
            sb.append("navi,");
        }
        if ((i & 8) != 0) {
            sb.append("cities,");
        }
        if ((i & 16) != 0) {
            sb.append("polyline,");
        }
        if ((i & 32) != 0) {
            sb.append("elec_consume_info,");
        }
        if ((i & 64) != 0) {
            sb.append("charge_station_info,");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        return sb.toString();
    }

    /* renamed from: d */
    public static String m52830d(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        double m52833a = m52833a(latLonPoint.getLongitude());
        double m52833a2 = m52833a(latLonPoint.getLatitude());
        return m52833a + "," + m52833a2;
    }

    /* renamed from: e */
    public static String m52829e(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    /* renamed from: f */
    public static String m52828f(List<LatLonPoint> list) {
        return m52827g(list, ";");
    }

    /* renamed from: g */
    public static String m52827g(List<LatLonPoint> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            LatLonPoint latLonPoint = list.get(i);
            if (latLonPoint != null) {
                double m52833a = m52833a(latLonPoint.getLongitude());
                double m52833a2 = m52833a(latLonPoint.getLatitude());
                stringBuffer.append(m52833a);
                stringBuffer.append(",");
                stringBuffer.append(m52833a2);
                stringBuffer.append(str);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    /* renamed from: h */
    private static void m52826h(int i, String str) throws AMapException, JSONException {
        if (i != 0) {
            if (i == 22000) {
                throw new AMapException(AMapException.AMAP_SERVICE_TABLEID_NOT_EXIST, 2, str);
            }
            if (i == 32200) {
                throw new AMapException(AMapException.AMAP_NEARBY_INVALID_USERID, 2, str);
            }
            if (i != 32201) {
                switch (i) {
                    case BleManager.f22896l /* 10000 */:
                        return;
                    case 10001:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_KEY, 2, str);
                    case 10002:
                        throw new AMapException(AMapException.AMAP_SERVICE_NOT_AVAILBALE, 2, str);
                    case 10003:
                        throw new AMapException(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT, 2, str);
                    case IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START /* 10004 */:
                        throw new AMapException(AMapException.AMAP_ACCESS_TOO_FREQUENT, 2, str);
                    case IMediaPlayer.MEDIA_INFO_OPEN_INPUT /* 10005 */:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_IP, 2, str);
                    case IMediaPlayer.MEDIA_INFO_FIND_STREAM_INFO /* 10006 */:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_DOMAIN, 2, str);
                    case 10007:
                        throw new AMapException("用户签名未通过", 2, str);
                    case IMediaPlayer.MEDIA_INFO_VIDEO_SEEK_RENDERING_START /* 10008 */:
                        throw new AMapException(AMapException.AMAP_INVALID_USER_SCODE, 2, str);
                    case IMediaPlayer.MEDIA_INFO_AUDIO_SEEK_RENDERING_START /* 10009 */:
                        throw new AMapException(AMapException.AMAP_USERKEY_PLAT_NOMATCH, 2, str);
                    case 10010:
                        throw new AMapException(AMapException.AMAP_IP_QUERY_OVER_LIMIT, 2, str);
                    case 10011:
                        throw new AMapException(AMapException.AMAP_NOT_SUPPORT_HTTPS, 2, str);
                    case 10012:
                        throw new AMapException(AMapException.AMAP_INSUFFICIENT_PRIVILEGES, 2, str);
                    case 10013:
                        throw new AMapException(AMapException.AMAP_USER_KEY_RECYCLED, 2, str);
                    default:
                        switch (i) {
                            case 20000:
                                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 2, str);
                            case 20001:
                                throw new AMapException(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS, 2, str);
                            case 20002:
                                throw new AMapException(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST, 2, str);
                            case 20003:
                                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 2, str);
                            default:
                                switch (i) {
                                    case 20800:
                                        throw new AMapException(AMapException.AMAP_ROUTE_OUT_OF_SERVICE, 2, str);
                                    case 20801:
                                        throw new AMapException(AMapException.AMAP_ROUTE_NO_ROADS_NEARBY, 2, str);
                                    case 20802:
                                        throw new AMapException(AMapException.AMAP_ROUTE_FAIL, 2, str);
                                    case 20803:
                                        throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE, 2, str);
                                    default:
                                        switch (i) {
                                            case 30000:
                                                throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_ERROR, 2, str);
                                            case AdError.ERROR_CODE_THIRD_SDK_NOT_INIT /* 30001 */:
                                                throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR, 2, str);
                                            case AdError.ERROR_CODE_THIRD_SDK_PARARM_ERROR /* 30002 */:
                                                throw new AMapException(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT, 2, str);
                                            case AdError.ERROR_CODE_THIRD_SDK_FILE_IO_ERROR /* 30003 */:
                                                throw new AMapException(AMapException.AMAP_ENGINE_RETURN_TIMEOUT, 2, str);
                                            default:
                                                switch (i) {
                                                    case 32000:
                                                        throw new AMapException(AMapException.AMAP_ENGINE_TABLEID_NOT_EXIST, 2, str);
                                                    case 32001:
                                                        throw new AMapException(AMapException.AMAP_ID_NOT_EXIST, 2, str);
                                                    case 32002:
                                                        throw new AMapException(AMapException.AMAP_SERVICE_MAINTENANCE, 2, str);
                                                    default:
                                                        if (!TextUtils.isEmpty(str) && i > 0) {
                                                            throw new AMapException(str, 2, str, i);
                                                        }
                                                        throw new AMapException(str, 2, str);
                                                }
                                        }
                                }
                        }
                }
            }
            throw new AMapException(AMapException.AMAP_NEARBY_KEY_NOT_BIND, 2, str);
        }
    }

    /* renamed from: i */
    public static void m52825i(Throwable th, String str, String str2) {
        try {
            C2060g2 m52973n = C2060g2.m52973n();
            if (m52973n != null) {
                m52973n.m52974m(th, str, str2);
            }
            th.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: j */
    public static boolean m52824j(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: k */
    public static double m52823k(List<LatLonPoint> list) {
        double d = Utils.DOUBLE_EPSILON;
        if (list == null || list.size() < 3) {
            return Utils.DOUBLE_EPSILON;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            LatLonPoint latLonPoint = list.get(i);
            i++;
            LatLonPoint latLonPoint2 = list.get(i % size);
            d += (((latLonPoint.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint.getLatitude() * 0.017453292519943295d)) * (latLonPoint2.getLatitude() * 111319.49079327357d)) - (((latLonPoint2.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint2.getLatitude() * 0.017453292519943295d)) * (latLonPoint.getLatitude() * 111319.49079327357d));
        }
        return Math.abs(d / 2.0d);
    }

    /* renamed from: l */
    public static void m52822l(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                m52826h(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (jSONObject.has("status")) {
                String string = jSONObject.getString("status");
                if (string.equals("1")) {
                    return;
                }
                if (string.equals("0") && !jSONObject.has("infocode")) {
                    throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                }
                int i = jSONObject.getInt("infocode");
                if (string.equals("0")) {
                    m52826h(i, jSONObject.getString("info"));
                }
            }
        } catch (JSONException e) {
            m52825i(e, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: m */
    public static void m52821m(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                m52826h(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (jSONObject.has("status")) {
                if (jSONObject.optInt("status") == 0) {
                    if (jSONObject.has("infocode")) {
                        m52826h(jSONObject.getInt("infocode"), jSONObject.getString("info"));
                    } else {
                        throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                    }
                }
                int optInt = jSONObject.optInt("code");
                if (optInt == 0) {
                    return;
                }
                String optString = jSONObject.optString("message");
                throw new AMapException(optString, 2, optString, Integer.parseInt("1".concat(String.valueOf(optInt))));
            }
        } catch (JSONException e) {
            m52825i(e, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* renamed from: n */
    public static Date m52820n(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HHmm").parse(str);
        } catch (ParseException e) {
            m52825i(e, "CoreUtil", "parseString2Time");
            return null;
        }
    }

    /* renamed from: o */
    public static Date m52819o(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HH:mm").parse(str);
        } catch (ParseException e) {
            m52825i(e, "CoreUtil", "parseTime");
            return null;
        }
    }
}
