package com.tencent.ams.a.a.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.plugin.i0.k;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.v0;
import com.tencent.ams.a.a.b.g;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static g f50688a;

    private static boolean a(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        long a4 = d.a(context, "cn.com.mma.mobile.tracking.other", AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_UPDATE_TIME_KEY);
        com.tencent.ams.a.b.a.a("mma_config lastUpdateTimeStamp:" + a4);
        boolean z3 = true;
        boolean z4 = a.b(context) && currentTimeMillis - a4 >= 7200000;
        boolean z5 = a.a(context) && currentTimeMillis - a4 >= 21600000;
        if (!z4 && !z5) {
            z3 = false;
        }
        com.tencent.ams.a.b.a.a("mma_config File need Update\uff1a" + z3);
        return z3;
    }

    public static g b(Context context, String str) {
        g a4;
        List<com.tencent.ams.a.a.b.b> list;
        if (!a(context) || (a4 = a(context, str)) == null || (list = a4.f50677b) == null || list.size() <= 0) {
            return null;
        }
        return a4;
    }

    public static void c(Context context, String str) {
        g b4 = b(context, str);
        if (b4 != null) {
            f50688a = b4;
            a(b4);
        }
    }

    public static g b(Context context) {
        try {
            String b4 = d.b(context, "cn.com.mma.mobile.tracking.sdkconfig", "trackingConfig");
            if (b4 != null) {
                return e.a(new ByteArrayInputStream(b4.getBytes()));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(Context context) {
        List<com.tencent.ams.a.a.b.b> list;
        List<com.tencent.ams.a.a.b.b> list2;
        g b4 = b(context);
        if ((b4 == null || (list2 = b4.f50677b) == null || list2.size() == 0) && ((b4 = e.a(new ByteArrayInputStream(Base64.decode("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KCjwhLS3lqpLkvZPlubPlj7Dnm7jlhbPphY3nva4tLT4KPGNvbmZpZyB4bWxuczp4c2k9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hLWluc3RhbmNlIiB4c2k6bm9OYW1lc3BhY2VTY2hlbWFMb2NhdGlvbj0iU0RLU2NoZW1hLnhzZCI+CiAgPCEtLee8k+WtmOmYn+WIl+iuvue9ri0tPgogIDxvZmZsaW5lQ2FjaGU+CiAgICA8IS0t5bu66K6uIGxlbmd0aCAqIHRpbWVvdXQgPD1pdGVyYXRpb24gLS0+CiAgICA8IS0tcXVldWXplb/luqbvvIw+PWxlbmd0aFZhbHVl56uL5Yi75o+Q5LqkLS0+CiAgICA8bGVuZ3RoPjA8L2xlbmd0aD4KICAgIDwhLS0g5q+P5qyh6K+75Y+W5a2Y5YKodXJs55qEU2hhcmVkcHJlZmVyZW5jZWTnmoTpl7TpmpTml7bpl7QgLS0+CiAgICA8cXVldWVFeHBpcmF0aW9uU2Vjcz4zNjAwPC9xdWV1ZUV4cGlyYXRpb25TZWNzPgogICAgPCEtLeWPkemAgei2heaXtuaXtumXtC0tPgogICAgPHRpbWVvdXQ+NjA8L3RpbWVvdXQ+CiAgPC9vZmZsaW5lQ2FjaGU+CiAgPGNvbXBhbmllcz4KICAgIDxjb21wYW55PgogICAgICA8bmFtZT5hZG1hc3RlcjwvbmFtZT4KICAgICAgPGVuY3J5cHRUeXBlPjA8L2VuY3J5cHRUeXBlPgogICAgICA8ZG9tYWluPgogICAgICAgIDx1cmw+YWRtYXN0ZXIuY29tLmNuPC91cmw+CiAgICAgIDwvZG9tYWluPgogICAgICA8IS0t562+5ZCN5Yqf6IO95YyF5omA55So55qE5Y+C5pWw77yM5aaC5pyq6K6+572u77yM5LiN5L2/55So562+5ZCN5Yqf6IO9LS0+CiAgICAgIDxzaWduYXR1cmU+CiAgICAgICAgPHB1YmxpY0tleT5aODM0NzZIZWw8L3B1YmxpY0tleT4KICAgICAgICA8cGFyYW1LZXk+c2lnbjwvcGFyYW1LZXk+CiAgICAgIDwvc2lnbmF0dXJlPgogICAgICA8c3dpdGNoPgogICAgICAgIDxpc1RyYWNrTG9jYXRpb24+ZmFsc2U8L2lzVHJhY2tMb2NhdGlvbj4KICAgICAgICA8IS0t5aSx5pWI5pe26Ze077yM5Y2V5L2N56eSLS0+CiAgICAgICAgPG9mZmxpbmVDYWNoZUV4cGlyYXRpb24+MjU5MjAwPC9vZmZsaW5lQ2FjaGVFeHBpcmF0aW9uPgogICAgICAgIDxlbmNyeXB0PgogICAgICAgICAgPE1BQz5tZDU8L01BQz4KICAgICAgICAgIDxJREE+bWQ1PC9JREE+CiAgICAgICAgICA8SU1FST5tZDU8L0lNRUk+CiAgICAgICAgICA8QU5EUk9JRElEPnJhdzwvQU5EUk9JRElEPgogICAgICAgIDwvZW5jcnlwdD4KICAgICAgPC9zd2l0Y2g+CiAgICAgIDxjb25maWc+CiAgICAgICAgPGFyZ3VtZW50cz4KICAgICAgICAgIDwhLS1hcmd1bWVudOeahOW/hemAieWSjOW4uOeUqOWPr+mAieWPguaVsCBrZXnpnIDnoa7lrpotLT4KICAgICAgICAgIDwhLS3lv4XpgInlh73mlbAtLT4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5PUzwva2V5PgogICAgICAgICAgICA8dmFsdWU+MGE8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+VFM8L2tleT4KICAgICAgICAgICAgPHZhbHVlPnQ8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+TUFDPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5uPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PklERkE8L2tleT4KICAgICAgICAgICAgPHZhbHVlPno8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+SU1FSTwva2V5PgogICAgICAgICAgICA8dmFsdWU+MGM8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+QU5EUk9JRElEPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT4wZDwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5XSUZJPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT53PC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PkFLRVk8L2tleT4KICAgICAgICAgICAgPHZhbHVlPng8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+QU5BTUU8L2tleT4KICAgICAgICAgICAgPHZhbHVlPnk8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8IS0t5Y+v6YCJ5Ye95pWwLS0+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+U0NXSDwva2V5PgogICAgICAgICAgICA8dmFsdWU+MGY8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+T1BFTlVESUQ8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm88L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+T0RJTjwva2V5PgogICAgICAgICAgICA8dmFsdWU+MGc8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+VEVSTTwva2V5PgogICAgICAgICAgICA8dmFsdWU+cjwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5PU1ZTPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5xPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PkxCUzwva2V5PgogICAgICAgICAgICA8dmFsdWU+bDwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD5mYWxzZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+TVVJRDwva2V5PgogICAgICAgICAgICA8dmFsdWU+MGg8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+TVVEUzwva2V5PgogICAgICAgICAgICA8dmFsdWU+MGk8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+ZmFsc2U8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PlJFRElSRUNUVVJMPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT51PC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgIDwvYXJndW1lbnRzPgogICAgICAgIDxldmVudHM+CiAgICAgICAgICA8ZXZlbnQ+CiAgICAgICAgICAgIDwhLS08bmFtZT5tMTwvbmFtZT4tLT4KICAgICAgICAgICAgPGtleT5zdGFydDwva2V5PgogICAgICAgICAgICA8dmFsdWU+bTIwMTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgPC9ldmVudD4KICAgICAgICAgIDxldmVudD4KICAgICAgICAgICAgPCEtLTxuYW1lPmUxPC9uYW1lPi0tPgogICAgICAgICAgICA8a2V5PmVuZDwva2V5PgogICAgICAgICAgICA8dmFsdWU+bTIwMzwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgPC9ldmVudD4KICAgICAgICA8L2V2ZW50cz4KICAgICAgPC9jb25maWc+CiAgICAgIDxzZXBhcmF0b3I+LDwvc2VwYXJhdG9yPgogICAgICA8IS0tPHNlcGFyYXRvcj4mYW1wOzwvc2VwYXJhdG9yPi0tPgogICAgICA8ZXF1YWxpemVyLz4KICAgICAgPCEtLeWmguaenOiuvue9rnRydWUgICB0aW1lU3RhbXBlcuS9v+eUqOenki0tPgogICAgICA8dGltZVN0YW1wVXNlU2Vjb25kPnRydWU8L3RpbWVTdGFtcFVzZVNlY29uZD4KICAgIDwvY29tcGFueT4KICAgIDwhLS3nsr7noZXmlrDln5/lkI0tLT4KICAgIDxjb21wYW55PgogICAgICA8bmFtZT5hZG1hc3Rlcl9pbmRhdGE8L25hbWU+CiAgICAgIDxlbmNyeXB0VHlwZT4wPC9lbmNyeXB0VHlwZT4KICAgICAgPGRvbWFpbj4KICAgICAgICA8dXJsPmluZGF0YS5jb208L3VybD4KICAgICAgPC9kb21haW4+CiAgICAgIDwhLS3nrb7lkI3lip/og73ljIXmiYDnlKjnmoTlj4LmlbDvvIzlpoLmnKrorr7nva7vvIzkuI3kvb/nlKjnrb7lkI3lip/og70tLT4KICAgICAgPHNpZ25hdHVyZT4KICAgICAgICA8cHVibGljS2V5Plo4MzQ3NkhlbDwvcHVibGljS2V5PgogICAgICAgIDxwYXJhbUtleT5zaWduPC9wYXJhbUtleT4KICAgICAgPC9zaWduYXR1cmU+CiAgICAgIDxzd2l0Y2g+CiAgICAgICAgPGlzVHJhY2tMb2NhdGlvbj5mYWxzZTwvaXNUcmFja0xvY2F0aW9uPgogICAgICAgIDwhLS0g5aSx5pWI5pe26Ze077yM5Y2V5L2N56eSIC0tPgogICAgICAgIDxvZmZsaW5lQ2FjaGVFeHBpcmF0aW9uPjI1OTIwMDwvb2ZmbGluZUNhY2hlRXhwaXJhdGlvbj4KICAgICAgICA8ZW5jcnlwdD4KICAgICAgICAgIDxNQUM+bWQ1PC9NQUM+CiAgICAgICAgICA8SURBPm1kNTwvSURBPgogICAgICAgICAgPElNRUk+bWQ1PC9JTUVJPgogICAgICAgICAgPEFORFJPSURJRD5yYXc8L0FORFJPSURJRD4KICAgICAgICA8L2VuY3J5cHQ+CiAgICAgIDwvc3dpdGNoPgogICAgICA8Y29uZmlnPgogICAgICAgIDxhcmd1bWVudHM+CiAgICAgICAgICA8IS0tYXJndW1lbnTnmoTlv4XpgInlkozluLjnlKjlj6/pgInlj4LmlbAga2V56ZyA56Gu5a6aLS0+CiAgICAgICAgICA8IS0t5b+F6YCJ5Ye95pWwLS0+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+T1M8L2tleT4KICAgICAgICAgICAgPHZhbHVlPjBhPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PlRTPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT50PC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5Pk1BQzwva2V5PgogICAgICAgICAgICA8dmFsdWU+bjwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5JREZBPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT56PC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PklNRUk8L2tleT4KICAgICAgICAgICAgPHZhbHVlPjBjPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PkFORFJPSURJRDwva2V5PgogICAgICAgICAgICA8dmFsdWU+MGQ8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+V0lGSTwva2V5PgogICAgICAgICAgICA8dmFsdWU+dzwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5BS0VZPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT54PC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PkFOQU1FPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT55PC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPCEtLeWPr+mAieWHveaVsC0tPgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PlNDV0g8L2tleT4KICAgICAgICAgICAgPHZhbHVlPjBmPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5Pk9QRU5VRElEPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5vPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5Pk9ESU48L2tleT4KICAgICAgICAgICAgPHZhbHVlPjBnPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PlRFUk08L2tleT4KICAgICAgICAgICAgPHZhbHVlPnI8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+T1NWUzwva2V5PgogICAgICAgICAgICA8dmFsdWU+cTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5MQlM8L2tleT4KICAgICAgICAgICAgPHZhbHVlPmw8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+ZmFsc2U8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5Pk1VSUQ8L2tleT4KICAgICAgICAgICAgPHZhbHVlPjBoPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5Pk1VRFM8L2tleT4KICAgICAgICAgICAgPHZhbHVlPjBpPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPmZhbHNlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5SRURJUkVDVFVSTDwva2V5PgogICAgICAgICAgICA8dmFsdWU+dTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICA8L2FyZ3VtZW50cz4KICAgICAgICA8ZXZlbnRzPgogICAgICAgICAgPGV2ZW50PgogICAgICAgICAgICA8IS0tPG5hbWU+bTE8L25hbWU+LS0+CiAgICAgICAgICAgIDxrZXk+c3RhcnQ8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm0yMDE8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgIDwvZXZlbnQ+CiAgICAgICAgICA8ZXZlbnQ+CiAgICAgICAgICAgIDwhLS08bmFtZT5lMTwvbmFtZT4tLT4KICAgICAgICAgICAgPGtleT5lbmQ8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm0yMDM8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgIDwvZXZlbnQ+CiAgICAgICAgPC9ldmVudHM+CiAgICAgIDwvY29uZmlnPgogICAgICA8c2VwYXJhdG9yPiw8L3NlcGFyYXRvcj4KICAgICAgPCEtLTxzZXBhcmF0b3I+JmFtcDs8L3NlcGFyYXRvcj4tLT4KICAgICAgPGVxdWFsaXplci8+CiAgICAgIDwhLS3lpoLmnpzorr7nva50cnVlICAgdGltZVN0YW1wZXLkvb/nlKjnp5ItLT4KICAgICAgPHRpbWVTdGFtcFVzZVNlY29uZD50cnVlPC90aW1lU3RhbXBVc2VTZWNvbmQ+CiAgICA8L2NvbXBhbnk+CiAgICA8IS0t5YW25LuW5qOA5rWL5YWs5Y+46YWN572uLS0+CiAgICA8IS0tPGNvbXBhbnk+LS0+CiAgICA8IS0tPG5hbWU+bWlhb3poZW48L25hbWU+LS0+CiAgICA8IS0tLi4uLi4tLT4KICAgIDwhLS08L2NvbXBhbnk+LS0+CiAgICA8Y29tcGFueT4KICAgICAgPG5hbWU+bWlhb3o8L25hbWU+CiAgICAgIDxlbmNyeXB0VHlwZT4wPC9lbmNyeXB0VHlwZT4KICAgICAgPGRvbWFpbj4KICAgICAgICA8dXJsPm1pYW96LmNvbS5jbjwvdXJsPgogICAgICA8L2RvbWFpbj4KICAgICAgPCEtLeetvuWQjeWKn+iDveWMheaJgOeUqOeahOWPguaVsO+8jOWmguacquiuvue9ru+8jOS4jeS9v+eUqOetvuWQjeWKn+iDvS0tPgogICAgICA8c2lnbmF0dXJlPgogICAgICAgIDxwdWJsaWNLZXk+WjgzNDc2SGVsPC9wdWJsaWNLZXk+CiAgICAgICAgPHBhcmFtS2V5PnNpZ248L3BhcmFtS2V5PgogICAgICA8L3NpZ25hdHVyZT4KICAgICAgPHN3aXRjaD4KICAgICAgICA8aXNUcmFja0xvY2F0aW9uPmZhbHNlPC9pc1RyYWNrTG9jYXRpb24+CiAgICAgICAgPG9mZmxpbmVDYWNoZUV4cGlyYXRpb24+MjU5MjAwPC9vZmZsaW5lQ2FjaGVFeHBpcmF0aW9uPgogICAgICAgIDxlbmNyeXB0PgogICAgICAgICAgPE1BQz5yYXc8L01BQz4KICAgICAgICAgIDxJREE+cmF3PC9JREE+CiAgICAgICAgICA8SU1FST5yYXc8L0lNRUk+CiAgICAgICAgICA8QU5EUk9JRElEPnJhdzwvQU5EUk9JRElEPgogICAgICAgIDwvZW5jcnlwdD4KICAgICAgPC9zd2l0Y2g+CiAgICAgIDxjb25maWc+CiAgICAgICAgPGFyZ3VtZW50cz4KICAgICAgICAgIDwhLS1hcmd1bWVudOeahOW/hemAieWSjOW4uOeUqOWPr+mAieWPguaVsCBrZXnpnIDnoa7lrpotLT4KICAgICAgICAgIDwhLS3lv4XpgInlh73mlbAtLT4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5PUzwva2V5PgogICAgICAgICAgICA8dmFsdWU+b3M8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+VFM8L2tleT4KICAgICAgICAgICAgPHZhbHVlPnQ8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+TUFDPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5uPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PklERkE8L2tleT4KICAgICAgICAgICAgPHZhbHVlPnE8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+SU1FSTwva2V5PgogICAgICAgICAgICA8dmFsdWU+aW1laTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5BTkRST0lESUQ8L2tleT4KICAgICAgICAgICAgPHZhbHVlPmFpZDwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5URVJNPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5yPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PldJRkk8L2tleT4KICAgICAgICAgICAgPHZhbHVlPnc8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+QUtFWTwva2V5PgogICAgICAgICAgICA8dmFsdWU+eDwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5BTkFNRTwva2V5PgogICAgICAgICAgICA8dmFsdWU+eTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDwhLS3lj6/pgInlh73mlbAtLT4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5TQ1dIPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5zY3doPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPmZhbHNlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5PUEVOVURJRDwva2V5PgogICAgICAgICAgICA8dmFsdWU+bzwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD5mYWxzZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+T0RJTjwva2V5PgogICAgICAgICAgICA8dmFsdWU+b2RpbjwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD5mYWxzZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+T1NWUzwva2V5PgogICAgICAgICAgICA8dmFsdWU+cTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD5mYWxzZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+TEJTPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5sPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPmZhbHNlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICA8L2FyZ3VtZW50cz4KICAgICAgICA8ZXZlbnRzPgogICAgICAgICAgPGV2ZW50PgogICAgICAgICAgICA8IS0tPG5hbWU+bTE8L25hbWU+LS0+CiAgICAgICAgICAgIDxrZXk+c3RhcnQ8L2tleT4KICAgICAgICAgICAgPHZhbHVlPjIwMTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgPC9ldmVudD4KICAgICAgICAgIDxldmVudD4KICAgICAgICAgICAgPCEtLTxuYW1lPmUxPC9uYW1lPi0tPgogICAgICAgICAgICA8a2V5PmVuZDwva2V5PgogICAgICAgICAgICA8dmFsdWU+MjAzPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICA8L2V2ZW50PgogICAgICAgIDwvZXZlbnRzPgogICAgICA8L2NvbmZpZz4KICAgICAgPHNlcGFyYXRvcj4mYW1wOzwvc2VwYXJhdG9yPgogICAgICA8IS0tPHNlcGFyYXRvcj4mYW1wOzwvc2VwYXJhdG9yPi0tPgogICAgICA8ZXF1YWxpemVyPj08L2VxdWFsaXplcj4KICAgIDwvY29tcGFueT4KCiAgICA8IS0tIOenkumSiOato+W8j+eOr+WigyAtLT4KICAgIDxjb21wYW55PgogICAgICA8bmFtZT5taWFvemhlbjwvbmFtZT4KICAgICAgPGVuY3J5cHRUeXBlPjA8L2VuY3J5cHRUeXBlPgogICAgICA8ZG9tYWluPgogICAgICAgIDx1cmw+Lm1pYW96aGVuLmNvbTwvdXJsPgogICAgICA8L2RvbWFpbj4KICAgICAgPHNpZ25hdHVyZT4KICAgICAgICA8cHVibGljS2V5PkRiWGlVbEVWTjwvcHVibGljS2V5PgogICAgICAgIDxwYXJhbUtleT5tZjwvcGFyYW1LZXk+CiAgICAgIDwvc2lnbmF0dXJlPgogICAgICA8c3dpdGNoPgogICAgICAgIDxpc1RyYWNrTG9jYXRpb24+ZmFsc2U8L2lzVHJhY2tMb2NhdGlvbj4KICAgICAgICA8b2ZmbGluZUNhY2hlRXhwaXJhdGlvbj4yNTkyMDA8L29mZmxpbmVDYWNoZUV4cGlyYXRpb24+CiAgICAgICAgPGVuY3J5cHQ+CiAgICAgICAgICA8TUFDPnJhdzwvTUFDPgogICAgICAgICAgPElEQT5yYXc8L0lEQT4KICAgICAgICAgIDxJTUVJPnJhdzwvSU1FST4KICAgICAgICAgIDxBTkRST0lESUQ+cmF3PC9BTkRST0lESUQ+CiAgICAgICAgPC9lbmNyeXB0PgogICAgICA8L3N3aXRjaD4KICAgICAgPGNvbmZpZz4KICAgICAgICA8YXJndW1lbnRzPgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5Pk9TPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5tbzwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5UUzwva2V5PgogICAgICAgICAgICA8dmFsdWU+bXQ8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+TUFDPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5tNmE8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+SURGQTwva2V5PgogICAgICAgICAgICA8dmFsdWU+bTU8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+SU1FSTwva2V5PgogICAgICAgICAgICA8dmFsdWU+bTI8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+QU5EUk9JRElEPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5tMWE8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+VEVSTTwva2V5PgogICAgICAgICAgICA8dmFsdWU+bWQ8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+V0lGSTwva2V5PgogICAgICAgICAgICA8dmFsdWU+bWs8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+QUtFWTwva2V5PgogICAgICAgICAgICA8dmFsdWU+bXA8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+QU5BTUU8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm1uPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PlNDV0g8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm1oPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5Pk9QRU5VRElEPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5tMDwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5PU1ZTPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5tZTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5MQlM8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm1tPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPmZhbHNlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICA8L2FyZ3VtZW50cz4KICAgICAgICA8ZXZlbnRzPgogICAgICAgICAgPGV2ZW50PgogICAgICAgICAgICA8a2V5PnN0YXJ0PC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5tYj1zdGFydDwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgPC9ldmVudD4KICAgICAgICAgIDxldmVudD4KICAgICAgICAgICAgPGtleT5lbmQ8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm1iPWVuZDwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgPC9ldmVudD4KICAgICAgICA8L2V2ZW50cz4KICAgICAgPC9jb25maWc+CiAgICAgIDxzZXBhcmF0b3I+JmFtcDs8L3NlcGFyYXRvcj4KICAgICAgPGVxdWFsaXplcj49PC9lcXVhbGl6ZXI+CiAgICAgIDx0aW1lU3RhbXBVc2VTZWNvbmQ+dHJ1ZTwvdGltZVN0YW1wVXNlU2Vjb25kPgogICAgPC9jb21wYW55PgoKICAgIDwhLS0gTmllbHNlbuWFrOWPuOmFjee9riAtLT4KICAgIDxjb21wYW55PgogICAgICA8bmFtZT5uaWVsc2VuPC9uYW1lPgogICAgICA8ZW5jcnlwdFR5cGU+MDwvZW5jcnlwdFR5cGU+CiAgICAgIDxkb21haW4+CiAgICAgICAgPHVybD5zLmNyLW5pZWxzZW4uY29tPC91cmw+CiAgICAgIDwvZG9tYWluPgogICAgICA8IS0tIOetvuWQjeWKn+iDveWMheaJgOeUqOeahOWPguaVsO+8jOWmguacquiuvue9ru+8jOS4jeS9v+eUqOetvuWQjeWKn+iDvSAtLT4KICAgICAgPHNpZ25hdHVyZT4KICAgICAgICA8cHVibGljS2V5Lz4KICAgICAgICA8cGFyYW1LZXk+cGs8L3BhcmFtS2V5PgogICAgICA8L3NpZ25hdHVyZT4KICAgICAgPHN3aXRjaD4KICAgICAgICA8aXNUcmFja0xvY2F0aW9uPmZhbHNlPC9pc1RyYWNrTG9jYXRpb24+CiAgICAgICAgPG9mZmxpbmVDYWNoZUV4cGlyYXRpb24+NjA0ODAwPC9vZmZsaW5lQ2FjaGVFeHBpcmF0aW9uPgogICAgICAgIDxlbmNyeXB0PgogICAgICAgICAgPE1BQz5yYXc8L01BQz4KICAgICAgICAgIDxJREE+cmF3PC9JREE+CiAgICAgICAgICA8SU1FST5yYXc8L0lNRUk+CiAgICAgICAgICA8QU5EUk9JRElEPnJhdzwvQU5EUk9JRElEPgogICAgICAgIDwvZW5jcnlwdD4KICAgICAgPC9zd2l0Y2g+CiAgICAgIDxjb25maWc+CiAgICAgICAgPGFyZ3VtZW50cz4KICAgICAgICAgIDwhLS0gYXJndW1lbnTnmoTlv4XpgInlkozluLjnlKjlj6/pgInlj4LmlbAga2V56ZyA56Gu5a6aIC0tPgogICAgICAgICAgPCEtLSDlv4XpgInlh73mlbAgLS0+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+T1M8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm9zPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PlRTPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT50czwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5NQUM8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm1hYzwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5JREZBPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5pZGZhPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PklNRUk8L2tleT4KICAgICAgICAgICAgPHZhbHVlPmltZWk8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+QU5EUk9JRElEPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5tMTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5XSUZJPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT53aWZpPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PkFLRVk8L2tleT4KICAgICAgICAgICAgPHZhbHVlPmFrZXk8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+QU5BTUU8L2tleT4KICAgICAgICAgICAgPHZhbHVlPmFuYW1lPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPCEtLeWPr+mAieWHveaVsC0tPgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PlNDV0g8L2tleT4KICAgICAgICAgICAgPHZhbHVlPnNjd2g8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+T1BFTlVESUQ8L2tleT4KICAgICAgICAgICAgPHZhbHVlPm0wPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICAgIDxpc1JlcXVpcmVkPnRydWU8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PkRVSUQ8L2tleT4KICAgICAgICAgICAgPHZhbHVlPmR1aWQ8L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+ZmFsc2U8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5Pk9ESU48L2tleT4KICAgICAgICAgICAgPHZhbHVlPm9kaW48L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+ZmFsc2U8L2lzUmVxdWlyZWQ+CiAgICAgICAgICA8L2FyZ3VtZW50PgogICAgICAgICAgPGFyZ3VtZW50PgogICAgICAgICAgICA8a2V5PlRFUk08L2tleT4KICAgICAgICAgICAgPHZhbHVlPnRlcm08L3ZhbHVlPgogICAgICAgICAgICA8dXJsRW5jb2RlPnRydWU8L3VybEVuY29kZT4KICAgICAgICAgICAgPGlzUmVxdWlyZWQ+dHJ1ZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+T1NWUzwva2V5PgogICAgICAgICAgICA8dmFsdWU+b3N2czwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICAgIDxhcmd1bWVudD4KICAgICAgICAgICAgPGtleT5MQlM8L2tleT4KICAgICAgICAgICAgPHZhbHVlPmxiczwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD5mYWxzZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+TVVJRDwva2V5PgogICAgICAgICAgICA8dmFsdWU+bXVpZDwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD5mYWxzZTwvaXNSZXF1aXJlZD4KICAgICAgICAgIDwvYXJndW1lbnQ+CiAgICAgICAgICA8YXJndW1lbnQ+CiAgICAgICAgICAgIDxrZXk+TVVEUzwva2V5PgogICAgICAgICAgICA8dmFsdWU+bXVkczwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgICA8aXNSZXF1aXJlZD50cnVlPC9pc1JlcXVpcmVkPgogICAgICAgICAgPC9hcmd1bWVudD4KICAgICAgICA8L2FyZ3VtZW50cz4KICAgICAgICA8ZXZlbnRzPgogICAgICAgICAgPGV2ZW50PgogICAgICAgICAgICA8IS0tIDxuYW1lPm0xPC9uYW1lPiAtLT4KICAgICAgICAgICAgPGtleT5zdGFydDwva2V5PgogICAgICAgICAgICA8dmFsdWU+bTIwMTwvdmFsdWU+CiAgICAgICAgICAgIDx1cmxFbmNvZGU+dHJ1ZTwvdXJsRW5jb2RlPgogICAgICAgICAgPC9ldmVudD4KICAgICAgICAgIDxldmVudD4KICAgICAgICAgICAgPCEtLSA8bmFtZT5lMTwvbmFtZT4gLS0+CiAgICAgICAgICAgIDxrZXk+ZW5kPC9rZXk+CiAgICAgICAgICAgIDx2YWx1ZT5tMjAzPC92YWx1ZT4KICAgICAgICAgICAgPHVybEVuY29kZT50cnVlPC91cmxFbmNvZGU+CiAgICAgICAgICA8L2V2ZW50PgogICAgICAgIDwvZXZlbnRzPgogICAgICA8L2NvbmZpZz4KICAgICAgPHNlcGFyYXRvcj4mYW1wOzwvc2VwYXJhdG9yPgogICAgICA8ZXF1YWxpemVyPj08L2VxdWFsaXplcj4KICAgICAgPCEtLSDlpoLmnpzorr7nva50cnVlICAgdGltZVN0YW1wZXLkvb/nlKjnp5IgLS0+CiAgICAgIDx0aW1lU3RhbXBVc2VTZWNvbmQ+ZmFsc2U8L3RpbWVTdGFtcFVzZVNlY29uZD4KICAgIDwvY29tcGFueT4KICA8L2NvbXBhbmllcz4KPC9jb25maWc+", 0)))) == null || (list = b4.f50677b) == null || list.size() <= 0)) {
            v.a(100172, (com.qq.e.comm.plugin.n0.c) null);
        }
        a(b4);
        f50688a = b4;
    }

    public static g a(Context context, String str) {
        g gVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String a4 = a(str);
        if (a4 != null) {
            try {
                gVar = e.a(new ByteArrayInputStream(a4.getBytes("UTF-8")));
                if (gVar != null && gVar.f50677b != null && gVar.f50677b.size() > 0) {
                    d.a(context, "cn.com.mma.mobile.tracking.other", AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_UPDATE_TIME_KEY, System.currentTimeMillis());
                    d.a(context, "cn.com.mma.mobile.tracking.sdkconfig", "trackingConfig", a4);
                    com.tencent.ams.a.b.a.a("mma_\u7f51\u7edc\u66f4\u65b0sdkconfig.xml\u6210\u529f");
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return gVar;
    }

    private static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestProperty(k.b(), k.a());
            InputStream inputStream = v0.a(httpURLConnection).getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                } else {
                    inputStream.close();
                    return stringBuffer.toString();
                }
            }
        } catch (MalformedURLException | IOException unused) {
            return null;
        }
    }

    private static void a(g gVar) {
        com.tencent.ams.a.b.a.a("mma_setSdk");
        if (gVar != null) {
            try {
                if (gVar.f50676a.f50673a != null && !"".equals(gVar.f50676a.f50673a)) {
                    com.tencent.ams.a.a.a.b.f50651a = Integer.parseInt(gVar.f50676a.f50673a);
                }
                if (gVar.f50676a.f50674b != null && !"".equals(gVar.f50676a.f50674b)) {
                    com.tencent.ams.a.a.a.b.f50652b = Integer.parseInt(gVar.f50676a.f50674b);
                }
                if (gVar.f50676a.f50675c == null || "".equals(gVar.f50676a.f50675c)) {
                    return;
                }
                com.tencent.ams.a.a.a.b.f50653c = Integer.parseInt(gVar.f50676a.f50675c);
            } catch (Exception unused) {
            }
        }
    }

    public static g a() {
        return f50688a;
    }
}