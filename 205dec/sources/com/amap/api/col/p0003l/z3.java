package com.amap.api.col.p0003l;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bytedance.msdk.api.AdError;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CoreUtil.java */
/* renamed from: com.amap.api.col.3l.z3  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z3 {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f9582a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    public static int a(List<LatLng> list) {
        int i4 = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i5 = 0;
        while (i4 < list.size() - 1) {
            LatLng latLng = list.get(i4);
            i4++;
            LatLng latLng2 = list.get(i4);
            if (latLng == null || latLng2 == null) {
                break;
            }
            i5 = (int) (i5 + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return i5;
    }

    private static void b(int i4, String str) throws fc {
        if (i4 != 0) {
            switch (i4) {
                case 10000:
                    return;
                case 10001:
                    throw new fc("\u7528\u6237key\u4e0d\u6b63\u786e\u6216\u8fc7\u671f");
                case 10002:
                    throw new fc("\u8bf7\u6c42\u670d\u52a1\u4e0d\u5b58\u5728");
                case 10003:
                    throw new fc("\u8bbf\u95ee\u5df2\u8d85\u51fa\u65e5\u8bbf\u95ee\u91cf");
                case 10004:
                    throw new fc("\u7528\u6237\u8bbf\u95ee\u8fc7\u4e8e\u9891\u7e41");
                case 10005:
                    throw new fc("\u7528\u6237IP\u65e0\u6548");
                case 10006:
                    throw new fc("\u7528\u6237\u57df\u540d\u65e0\u6548");
                case 10007:
                    throw new fc("\u7528\u6237\u7b7e\u540d\u672a\u901a\u8fc7");
                case 10008:
                    throw new fc("\u7528\u6237MD5\u5b89\u5168\u7801\u672a\u901a\u8fc7");
                case 10009:
                    throw new fc("\u8bf7\u6c42key\u4e0e\u7ed1\u5b9a\u5e73\u53f0\u4e0d\u7b26");
                case 10010:
                    throw new fc("IP\u8bbf\u95ee\u8d85\u9650");
                case 10011:
                    throw new fc("\u670d\u52a1\u4e0d\u652f\u6301https\u8bf7\u6c42");
                case 10012:
                    throw new fc("\u6743\u9650\u4e0d\u8db3\uff0c\u670d\u52a1\u8bf7\u6c42\u88ab\u62d2\u7edd");
                case 10013:
                    throw new fc("\u5f00\u53d1\u8005\u5220\u9664\u4e86key\uff0ckey\u88ab\u5220\u9664\u540e\u65e0\u6cd5\u6b63\u5e38\u4f7f\u7528");
                default:
                    switch (i4) {
                        case 20000:
                            throw new fc("\u8bf7\u6c42\u53c2\u6570\u975e\u6cd5");
                        case 20001:
                            throw new fc("\u7f3a\u5c11\u5fc5\u586b\u53c2\u6570");
                        case 20002:
                            throw new fc("\u8bf7\u6c42\u534f\u8bae\u975e\u6cd5");
                        case 20003:
                            throw new fc("\u5176\u4ed6\u672a\u77e5\u9519\u8bef");
                        default:
                            switch (i4) {
                                case 30000:
                                    throw new fc("\u8bf7\u6c42\u670d\u52a1\u54cd\u5e94\u9519\u8bef");
                                case AdError.ERROR_CODE_THIRD_SDK_NOT_INIT /* 30001 */:
                                    throw new fc("\u5f15\u64ce\u8fd4\u56de\u6570\u636e\u5f02\u5e38");
                                case AdError.ERROR_CODE_THIRD_SDK_PARARM_ERROR /* 30002 */:
                                    throw new fc("\u670d\u52a1\u7aef\u8bf7\u6c42\u94fe\u63a5\u8d85\u65f6");
                                case AdError.ERROR_CODE_THIRD_SDK_FILE_IO_ERROR /* 30003 */:
                                    throw new fc("\u8bfb\u53d6\u670d\u52a1\u7ed3\u679c\u8d85\u65f6");
                                default:
                                    throw new fc(str);
                            }
                    }
            }
        }
    }

    public static void c(String str) throws fc {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                b(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has("status") && jSONObject.has("infocode")) {
                String string = jSONObject.getString("status");
                int i4 = jSONObject.getInt("infocode");
                if ("1".equals(string)) {
                    return;
                }
                String string2 = jSONObject.getString("info");
                if ("0".equals(string)) {
                    b(i4, string2);
                }
            }
        } catch (JSONException unused) {
            throw new fc("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException");
        }
    }
}
