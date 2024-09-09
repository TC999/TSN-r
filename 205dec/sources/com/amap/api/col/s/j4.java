package com.amap.api.col.s;

import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.bytedance.msdk.api.AdError;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CoreUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j4 {
    public static double a(double d4) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d4));
    }

    public static float b(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        if (latLonPoint == null || latLonPoint2 == null) {
            return 0.0f;
        }
        try {
            double longitude = latLonPoint.getLongitude();
            double d4 = longitude * 0.01745329251994329d;
            double latitude = latLonPoint.getLatitude() * 0.01745329251994329d;
            double longitude2 = latLonPoint2.getLongitude() * 0.01745329251994329d;
            double latitude2 = latLonPoint2.getLatitude() * 0.01745329251994329d;
            double sin = Math.sin(d4);
            double sin2 = Math.sin(latitude);
            double cos = Math.cos(d4);
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

    public static String c(int i4) {
        StringBuilder sb = new StringBuilder();
        if ((i4 & 1) != 0) {
            sb.append("cost,");
        }
        if ((i4 & 2) != 0) {
            sb.append("tmcs,");
        }
        if ((i4 & 4) != 0) {
            sb.append("navi,");
        }
        if ((i4 & 8) != 0) {
            sb.append("cities,");
        }
        if ((i4 & 16) != 0) {
            sb.append("polyline,");
        }
        if ((i4 & 32) != 0) {
            sb.append("elec_consume_info,");
        }
        if ((i4 & 64) != 0) {
            sb.append("charge_station_info,");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        return sb.toString();
    }

    public static String d(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        double a4 = a(latLonPoint.getLongitude());
        double a5 = a(latLonPoint.getLatitude());
        return a4 + "," + a5;
    }

    public static String e(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    public static String f(List<LatLonPoint> list) {
        return g(list, ";");
    }

    public static String g(List<LatLonPoint> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < list.size(); i4++) {
            LatLonPoint latLonPoint = list.get(i4);
            if (latLonPoint != null) {
                double a4 = a(latLonPoint.getLongitude());
                double a5 = a(latLonPoint.getLatitude());
                stringBuffer.append(a4);
                stringBuffer.append(",");
                stringBuffer.append(a5);
                stringBuffer.append(str);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    private static void h(int i4, String str) throws AMapException, JSONException {
        if (i4 != 0) {
            if (i4 == 22000) {
                throw new AMapException("tableID\u683c\u5f0f\u4e0d\u6b63\u786e\u4e0d\u5b58\u5728", 2, str);
            }
            if (i4 == 32200) {
                throw new AMapException("\u627e\u4e0d\u5230\u5bf9\u5e94\u7684userid\u4fe1\u606f,\u8bf7\u68c0\u67e5\u60a8\u63d0\u4f9b\u7684userid\u662f\u5426\u5b58\u5728", 2, str);
            }
            if (i4 != 32201) {
                switch (i4) {
                    case 10000:
                        return;
                    case 10001:
                        throw new AMapException("\u7528\u6237key\u4e0d\u6b63\u786e\u6216\u8fc7\u671f", 2, str);
                    case 10002:
                        throw new AMapException("\u8bf7\u6c42\u670d\u52a1\u4e0d\u5b58\u5728", 2, str);
                    case 10003:
                        throw new AMapException("\u8bbf\u95ee\u5df2\u8d85\u51fa\u65e5\u8bbf\u95ee\u91cf", 2, str);
                    case 10004:
                        throw new AMapException("\u7528\u6237\u8bbf\u95ee\u8fc7\u4e8e\u9891\u7e41", 2, str);
                    case 10005:
                        throw new AMapException("\u7528\u6237IP\u65e0\u6548", 2, str);
                    case 10006:
                        throw new AMapException("\u7528\u6237\u57df\u540d\u65e0\u6548", 2, str);
                    case 10007:
                        throw new AMapException("\u7528\u6237\u7b7e\u540d\u672a\u901a\u8fc7", 2, str);
                    case 10008:
                        throw new AMapException("\u7528\u6237MD5\u5b89\u5168\u7801\u672a\u901a\u8fc7", 2, str);
                    case 10009:
                        throw new AMapException("\u8bf7\u6c42key\u4e0e\u7ed1\u5b9a\u5e73\u53f0\u4e0d\u7b26", 2, str);
                    case 10010:
                        throw new AMapException("IP\u8bbf\u95ee\u8d85\u9650", 2, str);
                    case 10011:
                        throw new AMapException("\u670d\u52a1\u4e0d\u652f\u6301https\u8bf7\u6c42", 2, str);
                    case 10012:
                        throw new AMapException("\u6743\u9650\u4e0d\u8db3\uff0c\u670d\u52a1\u8bf7\u6c42\u88ab\u62d2\u7edd", 2, str);
                    case 10013:
                        throw new AMapException("\u5f00\u53d1\u8005\u5220\u9664\u4e86key\uff0ckey\u88ab\u5220\u9664\u540e\u65e0\u6cd5\u6b63\u5e38\u4f7f\u7528", 2, str);
                    default:
                        switch (i4) {
                            case 20000:
                                throw new AMapException("\u8bf7\u6c42\u53c2\u6570\u975e\u6cd5", 2, str);
                            case 20001:
                                throw new AMapException("\u7f3a\u5c11\u5fc5\u586b\u53c2\u6570", 2, str);
                            case 20002:
                                throw new AMapException("\u8bf7\u6c42\u534f\u8bae\u975e\u6cd5", 2, str);
                            case 20003:
                                throw new AMapException("\u5176\u4ed6\u672a\u77e5\u9519\u8bef", 2, str);
                            default:
                                switch (i4) {
                                    case 20800:
                                        throw new AMapException("\u89c4\u5212\u70b9\uff08\u5305\u62ec\u8d77\u70b9\u3001\u7ec8\u70b9\u3001\u9014\u7ecf\u70b9\uff09\u4e0d\u5728\u4e2d\u56fd\u9646\u5730\u8303\u56f4\u5185", 2, str);
                                    case 20801:
                                        throw new AMapException("\u89c4\u5212\u70b9\uff08\u8d77\u70b9\u3001\u7ec8\u70b9\u3001\u9014\u7ecf\u70b9\uff09\u9644\u8fd1\u641c\u4e0d\u5230\u8def", 2, str);
                                    case 20802:
                                        throw new AMapException("\u8def\u7ebf\u8ba1\u7b97\u5931\u8d25\uff0c\u901a\u5e38\u662f\u7531\u4e8e\u9053\u8def\u8fde\u901a\u5173\u7cfb\u5bfc\u81f4", 2, str);
                                    case 20803:
                                        throw new AMapException("\u8d77\u70b9\u7ec8\u70b9\u8ddd\u79bb\u8fc7\u957f", 2, str);
                                    default:
                                        switch (i4) {
                                            case 30000:
                                                throw new AMapException("\u8bf7\u6c42\u670d\u52a1\u54cd\u5e94\u9519\u8bef", 2, str);
                                            case AdError.ERROR_CODE_THIRD_SDK_NOT_INIT /* 30001 */:
                                                throw new AMapException("\u5f15\u64ce\u8fd4\u56de\u6570\u636e\u5f02\u5e38", 2, str);
                                            case AdError.ERROR_CODE_THIRD_SDK_PARARM_ERROR /* 30002 */:
                                                throw new AMapException("\u670d\u52a1\u7aef\u8bf7\u6c42\u94fe\u63a5\u8d85\u65f6", 2, str);
                                            case AdError.ERROR_CODE_THIRD_SDK_FILE_IO_ERROR /* 30003 */:
                                                throw new AMapException("\u8bfb\u53d6\u670d\u52a1\u7ed3\u679c\u8d85\u65f6", 2, str);
                                            default:
                                                switch (i4) {
                                                    case 32000:
                                                        throw new AMapException("key\u5bf9\u5e94\u7684tableID\u4e0d\u5b58\u5728", 2, str);
                                                    case 32001:
                                                        throw new AMapException("ID\u4e0d\u5b58\u5728", 2, str);
                                                    case 32002:
                                                        throw new AMapException("\u670d\u52a1\u5668\u7ef4\u62a4\u4e2d", 2, str);
                                                    default:
                                                        if (!TextUtils.isEmpty(str) && i4 > 0) {
                                                            throw new AMapException(str, 2, str, i4);
                                                        }
                                                        throw new AMapException(str, 2, str);
                                                }
                                        }
                                }
                        }
                }
            }
            throw new AMapException("App key\u672a\u5f00\u901a\u201c\u9644\u8fd1\u201d\u529f\u80fd,\u8bf7\u6ce8\u518c\u9644\u8fd1KEY", 2, str);
        }
    }

    public static void i(Throwable th, String str, String str2) {
        try {
            g2 n4 = g2.n();
            if (n4 != null) {
                n4.m(th, str, str2);
            }
            th.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean j(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static double k(List<LatLonPoint> list) {
        double d4 = 0.0d;
        if (list == null || list.size() < 3) {
            return 0.0d;
        }
        int size = list.size();
        int i4 = 0;
        while (i4 < size) {
            LatLonPoint latLonPoint = list.get(i4);
            i4++;
            LatLonPoint latLonPoint2 = list.get(i4 % size);
            d4 += (((latLonPoint.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint.getLatitude() * 0.017453292519943295d)) * (latLonPoint2.getLatitude() * 111319.49079327357d)) - (((latLonPoint2.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint2.getLatitude() * 0.017453292519943295d)) * (latLonPoint.getLatitude() * 111319.49079327357d));
        }
        return Math.abs(d4 / 2.0d);
    }

    public static void l(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                h(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (jSONObject.has("status")) {
                String string = jSONObject.getString("status");
                if (string.equals("1")) {
                    return;
                }
                if (string.equals("0") && !jSONObject.has("infocode")) {
                    throw new AMapException("\u672a\u77e5\u9519\u8bef");
                }
                int i4 = jSONObject.getInt("infocode");
                if (string.equals("0")) {
                    h(i4, jSONObject.getString("info"));
                }
            }
        } catch (JSONException e4) {
            i(e4, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static void m(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                h(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (jSONObject.has("status")) {
                if (jSONObject.optInt("status") == 0) {
                    if (jSONObject.has("infocode")) {
                        h(jSONObject.getInt("infocode"), jSONObject.getString("info"));
                    } else {
                        throw new AMapException("\u672a\u77e5\u9519\u8bef");
                    }
                }
                int optInt = jSONObject.optInt("code");
                if (optInt == 0) {
                    return;
                }
                String optString = jSONObject.optString("message");
                throw new AMapException(optString, 2, optString, Integer.parseInt("1".concat(String.valueOf(optInt))));
            }
        } catch (JSONException e4) {
            i(e4, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }

    public static Date n(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HHmm").parse(str);
        } catch (ParseException e4) {
            i(e4, "CoreUtil", "parseString2Time");
            return null;
        }
    }

    public static Date o(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HH:mm").parse(str);
        } catch (ParseException e4) {
            i(e4, "CoreUtil", "parseTime");
            return null;
        }
    }
}
