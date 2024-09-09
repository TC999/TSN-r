package xyz.adscope.common.network;

import android.text.TextUtils;
import java.net.HttpCookie;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.network.util.ListMap;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Headers extends ListMap<String, String> {
    public static final String KEY_ACCEPT = "Accept";
    public static final String KEY_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String KEY_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String KEY_ACCEPT_RANGE = "Accept-Range";
    public static final String KEY_CACHE_CONTROL = "Cache-Control";
    public static final String KEY_CONNECTION = "Connection";
    public static final String KEY_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String KEY_CONTENT_ENCODING = "Content-Encoding";
    public static final String KEY_CONTENT_LENGTH = "Content-Length";
    public static final String KEY_CONTENT_RANGE = "Content-Range";
    public static final String KEY_CONTENT_TYPE = "Content-Type";
    public static final String KEY_COOKIE = "Cookie";
    public static final String KEY_DATE = "Date";
    public static final String KEY_EXPIRES = "Expires";
    public static final String KEY_E_TAG = "ETag";
    public static final String KEY_HOST = "Host";
    public static final String KEY_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String KEY_IF_NONE_MATCH = "If-None-Match";
    public static final String KEY_LAST_MODIFIED = "Last-Modified";
    public static final String KEY_LOCATION = "Location";
    public static final String KEY_RANGE = "Range";
    public static final String KEY_SET_COOKIE = "Set-Cookie";
    public static final String KEY_USER_AGENT = "User-Agent";
    public static final String TIME_FORMAT_HTTP = "EEE, dd MMM y HH:mm:ss 'GMT'";
    public static final String VALUE_ACCEPT_ALL = "*/*";
    public static final String VALUE_ACCEPT_ENCODING = "gzip, deflate";
    public static final String VALUE_APPLICATION_FORM = "multipart/form-data";
    public static final String VALUE_APPLICATION_JSON = "application/json";
    public static final String VALUE_APPLICATION_STREAM = "application/octet-stream";
    public static final String VALUE_APPLICATION_URLENCODED = "application/x-www-form-urlencoded";
    public static final String VALUE_APPLICATION_XML = "application/xml";
    public static final String VALUE_CLOSE = "close";
    public static final String VALUE_KEEP_ALIVE = "keep-alive";
    public static final TimeZone TIME_ZONE_GMT = TimeZone.getTimeZone("GMT");
    public static final String VALUE_ACCEPT_LANGUAGE = getLanguage();
    public static final String VALUE_USER_AGENT = getUserAgent();

    public Headers() {
        super(new TreeMap(new Comparator<String>() { // from class: xyz.adscope.common.network.Headers.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        }));
    }

    public static long analysisCacheExpires(Headers headers) {
        long j4;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        String cacheControl = headers.getCacheControl();
        if (TextUtils.isEmpty(cacheControl)) {
            j4 = 0;
            j5 = 0;
        } else {
            StringTokenizer stringTokenizer = new StringTokenizer(cacheControl, ",");
            j4 = 0;
            j5 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String lowerCase = stringTokenizer.nextToken().trim().toLowerCase(Locale.getDefault());
                if (lowerCase.equals("no-cache") || lowerCase.equals("no-store")) {
                    return 0L;
                }
                if (lowerCase.startsWith("max-age=")) {
                    j4 = Long.parseLong(lowerCase.substring(8)) * 1000;
                } else if (lowerCase.startsWith("must-revalidate")) {
                    return 0L;
                } else {
                    if (lowerCase.startsWith("stale-while-revalidate=")) {
                        j5 = Long.parseLong(lowerCase.substring(23)) * 1000;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(cacheControl)) {
            long j6 = currentTimeMillis + j4;
            return j5 > 0 ? j6 + j5 : j6;
        }
        long expires = headers.getExpires();
        long date = headers.getDate();
        if (expires > date) {
            return (currentTimeMillis + expires) - date;
        }
        return 0L;
    }

    public static long formatGMTToMillis(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT_HTTP, Locale.US);
        simpleDateFormat.setTimeZone(TIME_ZONE_GMT);
        return simpleDateFormat.parse(str).getTime();
    }

    public static String formatKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.toLowerCase(Locale.ENGLISH).split("-");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            String substring = str2.substring(0, 1);
            String substring2 = str2.substring(1);
            sb.append(substring.toUpperCase(Locale.ENGLISH));
            sb.append(substring2);
            sb.append("-");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.lastIndexOf("-"));
        }
        return sb.toString();
    }

    public static String formatMillisToGMT(long j4) {
        Date date = new Date(j4);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT_HTTP, Locale.US);
        simpleDateFormat.setTimeZone(TIME_ZONE_GMT);
        return simpleDateFormat.format(date);
    }

    public static Headers fromJSONString(String str) {
        Headers headers = new Headers();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray jSONArray = new JSONArray(jSONObject.optString(next));
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                headers.add(next, jSONArray.optString(i4));
            }
        }
        return headers;
    }

    public static List<HttpCookie> getHttpCookieList(Headers headers) {
        ArrayList arrayList = new ArrayList();
        for (String str : headers.keySet()) {
            if (str.equalsIgnoreCase("Set-Cookie")) {
                for (String str2 : headers.get(str)) {
                    arrayList.addAll(HttpCookie.parse(str2));
                }
            }
        }
        return arrayList;
    }

    public static String getLanguage() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        if (!TextUtils.isEmpty(country)) {
            sb.append('-');
            sb.append(country);
            sb.append(',');
            sb.append(language);
        }
        return sb.toString();
    }

    public static Map<String, String> getRequestHeaders(Headers headers) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            linkedHashMap.put(entry.getKey(), TextUtils.join("; ", entry.getValue()));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getUserAgent() {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = android.os.Build.VERSION.RELEASE
            r0.append(r1)
            java.lang.String r1 = "; "
            r0.append(r1)
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = r2.getLanguage()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L38
            java.lang.String r3 = r3.toLowerCase(r2)
            r0.append(r3)
            java.lang.String r3 = r2.getCountry()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L3d
            java.lang.String r4 = "-"
            r0.append(r4)
            java.lang.String r2 = r3.toLowerCase(r2)
            goto L3a
        L38:
            java.lang.String r2 = "en"
        L3a:
            r0.append(r2)
        L3d:
            java.lang.String r2 = android.os.Build.VERSION.CODENAME
            java.lang.String r3 = "REL"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L55
            java.lang.String r2 = android.os.Build.MODEL
            int r3 = r2.length()
            if (r3 <= 0) goto L55
            r0.append(r1)
            r0.append(r2)
        L55:
            java.lang.String r1 = android.os.Build.ID
            int r1 = r1.length()
            if (r1 <= 0) goto L67
            java.lang.String r1 = " Api/"
            r0.append(r1)
            java.lang.String r1 = android.os.Build.ID
            r0.append(r1)
        L67:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r0
            r0 = 1
            java.lang.String r2 = "Mobile "
            r1[r0] = r2
            java.lang.String r0 = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/534.30 (KHTML, like Gecko) Version/5.0 %sSafari/534.30"
            java.lang.String r0 = java.lang.String.format(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.network.Headers.getUserAgent():java.lang.String");
    }

    public static String parseSubValue(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str3;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf > 0 && str2.equalsIgnoreCase(nextToken.substring(0, indexOf).trim())) {
                return nextToken.substring(indexOf + 1).trim();
            }
        }
        return str3;
    }

    public static String toJSONString(Headers headers) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), new JSONArray((Collection) entry.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject.toString();
    }

    public final long a(String str) {
        String first = getFirst(str);
        if (TextUtils.isEmpty(first)) {
            return 0L;
        }
        try {
            return formatGMTToMillis(first);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public void add(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        super.add((Headers) formatKey(str), str2);
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public void add(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list.isEmpty()) {
            return;
        }
        super.add((Headers) formatKey(str), (List) list);
    }

    public void add(Headers headers) {
        try {
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                for (String str : entry.getValue()) {
                    add(key, str);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public boolean containsKey(String str) {
        return super.containsKey((Headers) formatKey(str));
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public List<String> get(String str) {
        return super.get((Headers) formatKey(str));
    }

    public String getCacheControl() {
        List<String> list = get("Cache-Control");
        if (list == null) {
            list = Collections.emptyList();
        }
        return TextUtils.join(",", list);
    }

    public String getContentDisposition() {
        return getFirst(KEY_CONTENT_DISPOSITION);
    }

    public String getContentEncoding() {
        return getFirst("Content-Encoding");
    }

    public long getContentLength() {
        String first = getFirst("Content-Length");
        if (TextUtils.isEmpty(first)) {
            first = "0";
        }
        return Long.parseLong(first);
    }

    public String getContentRange() {
        return getFirst("Content-Range");
    }

    public String getContentType() {
        return getFirst("Content-Type");
    }

    public long getDate() {
        return a("Date");
    }

    public String getETag() {
        return getFirst("ETag");
    }

    public long getExpires() {
        return a("Expires");
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public String getFirst(String str) {
        return (String) super.getFirst((Headers) formatKey(str));
    }

    public long getLastModified() {
        return a("Last-Modified");
    }

    public String getLocation() {
        return getFirst("Location");
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public List<String> remove(String str) {
        return super.remove((Headers) formatKey(str));
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public void set(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        super.set((Headers) formatKey(str), str2);
    }

    @Override // xyz.adscope.common.network.util.ListMap
    public void set(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list.isEmpty()) {
            return;
        }
        super.set((Headers) formatKey(str), (List) list);
    }

    public void set(Headers headers) {
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            set(entry.getKey(), entry.getValue());
        }
    }
}
