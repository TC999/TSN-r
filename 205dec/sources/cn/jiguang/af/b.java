package cn.jiguang.af;

import android.content.Context;
import cn.jiguang.ah.a;
import cn.jiguang.ao.i;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f2119a = "";

    /* renamed from: b  reason: collision with root package name */
    private static final String f2120b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f2121c;

    /* renamed from: d  reason: collision with root package name */
    private static LinkedList<String> f2122d;

    static {
        String b4 = cn.jiguang.ao.c.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 106, 124, 100, 67, 69, 107, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, 31, 86, 43, 39, 119, 97, 64, 65, 110, 105, 125, 116, 31, 83, 109, 105, 98, 100, 67});
        f2120b = b4;
        String b5 = cn.jiguang.ao.c.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 123, 98, 99, 98, 85, 82, 52, 97, 102, 103, 6, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 103, 2, 15, 120, 120, 102, 112, 71, 65, 114, 109, 57, 98, 68, 65, 109, 125, 101});
        f2121c = b5;
        LinkedList<String> linkedList = new LinkedList<>();
        f2122d = linkedList;
        linkedList.clear();
        f2122d.add(b4);
        f2122d.add(b5);
    }

    private static long a(long j4) {
        Date date = new Date();
        Date date2 = new Date(j4);
        date.setHours(date2.getHours());
        date.setMinutes(date2.getMinutes());
        date.setSeconds(date2.getSeconds());
        return (date.getTime() / 1000) * 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0123 A[Catch: JSONException -> 0x03b4, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x03b4, blocks: (B:5:0x0018, B:8:0x0022, B:10:0x0030, B:12:0x003c, B:13:0x0043, B:15:0x004d, B:16:0x0050, B:18:0x005a, B:19:0x005d, B:21:0x0067, B:22:0x006f, B:24:0x0079, B:25:0x007c, B:27:0x0086, B:28:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a0, B:34:0x00a3, B:36:0x00ad, B:37:0x00b0, B:39:0x00ba, B:42:0x00c2, B:48:0x00e7, B:50:0x00ef, B:55:0x00fa, B:59:0x0105, B:62:0x0123, B:64:0x012e, B:66:0x0134, B:76:0x0163, B:80:0x018b, B:82:0x0192, B:84:0x019f, B:86:0x01a7, B:88:0x020a, B:81:0x018f, B:89:0x0217, B:91:0x0221, B:93:0x022b, B:95:0x025a, B:96:0x026a, B:98:0x0270, B:100:0x02a3, B:102:0x02c0, B:103:0x02c2, B:105:0x02ce, B:106:0x02d0, B:108:0x02dc, B:109:0x02de, B:111:0x02ea, B:112:0x02ec, B:114:0x02fa, B:116:0x030f, B:115:0x030c, B:117:0x0313, B:118:0x031b, B:120:0x0321, B:121:0x0334, B:123:0x033a, B:124:0x0346, B:125:0x0348, B:129:0x035b, B:133:0x036c, B:137:0x037d, B:141:0x039c, B:145:0x03a9, B:52:0x00f4, B:46:0x00ca, B:47:0x00cd), top: B:150:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019f A[Catch: JSONException -> 0x03b4, TryCatch #0 {JSONException -> 0x03b4, blocks: (B:5:0x0018, B:8:0x0022, B:10:0x0030, B:12:0x003c, B:13:0x0043, B:15:0x004d, B:16:0x0050, B:18:0x005a, B:19:0x005d, B:21:0x0067, B:22:0x006f, B:24:0x0079, B:25:0x007c, B:27:0x0086, B:28:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a0, B:34:0x00a3, B:36:0x00ad, B:37:0x00b0, B:39:0x00ba, B:42:0x00c2, B:48:0x00e7, B:50:0x00ef, B:55:0x00fa, B:59:0x0105, B:62:0x0123, B:64:0x012e, B:66:0x0134, B:76:0x0163, B:80:0x018b, B:82:0x0192, B:84:0x019f, B:86:0x01a7, B:88:0x020a, B:81:0x018f, B:89:0x0217, B:91:0x0221, B:93:0x022b, B:95:0x025a, B:96:0x026a, B:98:0x0270, B:100:0x02a3, B:102:0x02c0, B:103:0x02c2, B:105:0x02ce, B:106:0x02d0, B:108:0x02dc, B:109:0x02de, B:111:0x02ea, B:112:0x02ec, B:114:0x02fa, B:116:0x030f, B:115:0x030c, B:117:0x0313, B:118:0x031b, B:120:0x0321, B:121:0x0334, B:123:0x033a, B:124:0x0346, B:125:0x0348, B:129:0x035b, B:133:0x036c, B:137:0x037d, B:141:0x039c, B:145:0x03a9, B:52:0x00f4, B:46:0x00ca, B:47:0x00cd), top: B:150:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x025a A[Catch: JSONException -> 0x03b4, TryCatch #0 {JSONException -> 0x03b4, blocks: (B:5:0x0018, B:8:0x0022, B:10:0x0030, B:12:0x003c, B:13:0x0043, B:15:0x004d, B:16:0x0050, B:18:0x005a, B:19:0x005d, B:21:0x0067, B:22:0x006f, B:24:0x0079, B:25:0x007c, B:27:0x0086, B:28:0x0089, B:30:0x0093, B:31:0x0096, B:33:0x00a0, B:34:0x00a3, B:36:0x00ad, B:37:0x00b0, B:39:0x00ba, B:42:0x00c2, B:48:0x00e7, B:50:0x00ef, B:55:0x00fa, B:59:0x0105, B:62:0x0123, B:64:0x012e, B:66:0x0134, B:76:0x0163, B:80:0x018b, B:82:0x0192, B:84:0x019f, B:86:0x01a7, B:88:0x020a, B:81:0x018f, B:89:0x0217, B:91:0x0221, B:93:0x022b, B:95:0x025a, B:96:0x026a, B:98:0x0270, B:100:0x02a3, B:102:0x02c0, B:103:0x02c2, B:105:0x02ce, B:106:0x02d0, B:108:0x02dc, B:109:0x02de, B:111:0x02ea, B:112:0x02ec, B:114:0x02fa, B:116:0x030f, B:115:0x030c, B:117:0x0313, B:118:0x031b, B:120:0x0321, B:121:0x0334, B:123:0x033a, B:124:0x0346, B:125:0x0348, B:129:0x035b, B:133:0x036c, B:137:0x037d, B:141:0x039c, B:145:0x03a9, B:52:0x00f4, B:46:0x00ca, B:47:0x00cd), top: B:150:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jiguang.ad.a a(android.content.Context r29, org.json.JSONObject r30) {
        /*
            Method dump skipped, instructions count: 974
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.af.b.a(android.content.Context, org.json.JSONObject):cn.jiguang.ad.a");
    }

    private static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance(cn.jiguang.ap.b.f2348a).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b4 : digest) {
                int i4 = b4 & 255;
                if (i4 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i4));
            }
            return sb.toString();
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakeConfigHelper", "get md5 throwable:" + th.getMessage());
            return "";
        }
    }

    private static List<String> a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                arrayList.add(optJSONArray.get(i4).toString());
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x020b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0132 A[Catch: all -> 0x02f3, TRY_ENTER, TryCatch #0 {all -> 0x02f3, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0015, B:9:0x001f, B:11:0x0025, B:13:0x002f, B:15:0x0035, B:17:0x003f, B:19:0x0045, B:20:0x0053, B:22:0x0059, B:24:0x009a, B:26:0x00a4, B:28:0x00b2, B:29:0x00b7, B:31:0x00c5, B:32:0x00ca, B:34:0x00d0, B:35:0x00d5, B:37:0x00db, B:38:0x00e0, B:40:0x00e6, B:41:0x00eb, B:43:0x00f1, B:44:0x00f6, B:56:0x0132, B:57:0x0137, B:59:0x0143, B:60:0x014c, B:62:0x0152, B:63:0x015c, B:64:0x0162, B:66:0x016d, B:68:0x017e, B:71:0x0187, B:73:0x0191, B:74:0x019e, B:75:0x01a3, B:78:0x01ab, B:79:0x01b7, B:80:0x01bc, B:84:0x020d, B:88:0x0231, B:92:0x0255, B:94:0x02c0, B:96:0x02c6, B:98:0x02d0), top: B:106:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0143 A[Catch: all -> 0x02f3, TryCatch #0 {all -> 0x02f3, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0015, B:9:0x001f, B:11:0x0025, B:13:0x002f, B:15:0x0035, B:17:0x003f, B:19:0x0045, B:20:0x0053, B:22:0x0059, B:24:0x009a, B:26:0x00a4, B:28:0x00b2, B:29:0x00b7, B:31:0x00c5, B:32:0x00ca, B:34:0x00d0, B:35:0x00d5, B:37:0x00db, B:38:0x00e0, B:40:0x00e6, B:41:0x00eb, B:43:0x00f1, B:44:0x00f6, B:56:0x0132, B:57:0x0137, B:59:0x0143, B:60:0x014c, B:62:0x0152, B:63:0x015c, B:64:0x0162, B:66:0x016d, B:68:0x017e, B:71:0x0187, B:73:0x0191, B:74:0x019e, B:75:0x01a3, B:78:0x01ab, B:79:0x01b7, B:80:0x01bc, B:84:0x020d, B:88:0x0231, B:92:0x0255, B:94:0x02c0, B:96:0x02c6, B:98:0x02d0), top: B:106:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016d A[Catch: all -> 0x02f3, TryCatch #0 {all -> 0x02f3, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0015, B:9:0x001f, B:11:0x0025, B:13:0x002f, B:15:0x0035, B:17:0x003f, B:19:0x0045, B:20:0x0053, B:22:0x0059, B:24:0x009a, B:26:0x00a4, B:28:0x00b2, B:29:0x00b7, B:31:0x00c5, B:32:0x00ca, B:34:0x00d0, B:35:0x00d5, B:37:0x00db, B:38:0x00e0, B:40:0x00e6, B:41:0x00eb, B:43:0x00f1, B:44:0x00f6, B:56:0x0132, B:57:0x0137, B:59:0x0143, B:60:0x014c, B:62:0x0152, B:63:0x015c, B:64:0x0162, B:66:0x016d, B:68:0x017e, B:71:0x0187, B:73:0x0191, B:74:0x019e, B:75:0x01a3, B:78:0x01ab, B:79:0x01b7, B:80:0x01bc, B:84:0x020d, B:88:0x0231, B:92:0x0255, B:94:0x02c0, B:96:0x02c6, B:98:0x02d0), top: B:106:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x020d A[Catch: all -> 0x02f3, TryCatch #0 {all -> 0x02f3, blocks: (B:3:0x0009, B:5:0x000f, B:7:0x0015, B:9:0x001f, B:11:0x0025, B:13:0x002f, B:15:0x0035, B:17:0x003f, B:19:0x0045, B:20:0x0053, B:22:0x0059, B:24:0x009a, B:26:0x00a4, B:28:0x00b2, B:29:0x00b7, B:31:0x00c5, B:32:0x00ca, B:34:0x00d0, B:35:0x00d5, B:37:0x00db, B:38:0x00e0, B:40:0x00e6, B:41:0x00eb, B:43:0x00f1, B:44:0x00f6, B:56:0x0132, B:57:0x0137, B:59:0x0143, B:60:0x014c, B:62:0x0152, B:63:0x015c, B:64:0x0162, B:66:0x016d, B:68:0x017e, B:71:0x0187, B:73:0x0191, B:74:0x019e, B:75:0x01a3, B:78:0x01ab, B:79:0x01b7, B:80:0x01bc, B:84:0x020d, B:88:0x0231, B:92:0x0255, B:94:0x02c0, B:96:0x02c6, B:98:0x02d0), top: B:106:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.af.b.a(android.content.Context):org.json.JSONObject");
    }

    public static void a(Context context, String str) {
        if (str != null) {
            cn.jiguang.w.a.b("JWakeConfigHelper", "write wakeConfigJson:" + str);
            cn.jiguang.ao.e.a(context, "bwc.catch", str);
        }
    }

    public static void a(LinkedList<String> linkedList) {
        if (!a.C0049a.f2212a || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        cn.jiguang.w.a.b("JWakeConfigHelper", "setTestUrls use wake url :" + linkedList);
        f2122d.clear();
        f2122d.addAll(linkedList);
    }

    public static cn.jiguang.ad.a b(Context context) {
        cn.jiguang.ad.a aVar = null;
        try {
            String c4 = cn.jiguang.ao.e.c(context, "bwc.catch");
            if (c4 != null) {
                aVar = a(context, new JSONObject(i.a(c4)));
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakeConfigHelper", "read config json from cache failed !! error:" + th);
        }
        return aVar == null ? new cn.jiguang.ad.a() : aVar;
    }
}
