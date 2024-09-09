package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AMapException.java */
/* renamed from: com.amap.api.col.3l.fc  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class fc extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f7736a;

    /* renamed from: b  reason: collision with root package name */
    private int f7737b;

    public fc(String str) {
        super(str);
        this.f7737b = 1000;
        this.f7736a = str;
        a(str);
    }

    public final String a() {
        return this.f7736a;
    }

    private void a(String str) {
        if ("\u7528\u6237\u7b7e\u540d\u672a\u901a\u8fc7".equals(str)) {
            this.f7737b = 1001;
        } else if ("\u7528\u6237key\u4e0d\u6b63\u786e\u6216\u8fc7\u671f".equals(str)) {
            this.f7737b = 1002;
        } else if ("\u8bf7\u6c42\u670d\u52a1\u4e0d\u5b58\u5728".equals(str)) {
            this.f7737b = 1003;
        } else if ("\u8bbf\u95ee\u5df2\u8d85\u51fa\u65e5\u8bbf\u95ee\u91cf".equals(str)) {
            this.f7737b = 1004;
        } else if ("\u7528\u6237\u8bbf\u95ee\u8fc7\u4e8e\u9891\u7e41".equals(str)) {
            this.f7737b = 1005;
        } else if ("\u7528\u6237IP\u65e0\u6548".equals(str)) {
            this.f7737b = 1006;
        } else if ("\u7528\u6237\u57df\u540d\u65e0\u6548".equals(str)) {
            this.f7737b = 1007;
        } else if ("\u7528\u6237MD5\u5b89\u5168\u7801\u672a\u901a\u8fc7".equals(str)) {
            this.f7737b = 1008;
        } else if ("\u8bf7\u6c42key\u4e0e\u7ed1\u5b9a\u5e73\u53f0\u4e0d\u7b26".equals(str)) {
            this.f7737b = 1009;
        } else if ("IP\u8bbf\u95ee\u8d85\u9650".equals(str)) {
            this.f7737b = 1010;
        } else if ("\u670d\u52a1\u4e0d\u652f\u6301https\u8bf7\u6c42".equals(str)) {
            this.f7737b = 1011;
        } else if ("\u6743\u9650\u4e0d\u8db3\uff0c\u670d\u52a1\u8bf7\u6c42\u88ab\u62d2\u7edd".equals(str)) {
            this.f7737b = 1012;
        } else if ("\u5f00\u53d1\u8005\u5220\u9664\u4e86key\uff0ckey\u88ab\u5220\u9664\u540e\u65e0\u6cd5\u6b63\u5e38\u4f7f\u7528".equals(str)) {
            this.f7737b = 1013;
        } else if ("\u8bf7\u6c42\u670d\u52a1\u54cd\u5e94\u9519\u8bef".equals(str)) {
            this.f7737b = 1100;
        } else if ("\u5f15\u64ce\u8fd4\u56de\u6570\u636e\u5f02\u5e38".equals(str)) {
            this.f7737b = 1101;
        } else if ("\u670d\u52a1\u7aef\u8bf7\u6c42\u94fe\u63a5\u8d85\u65f6".equals(str)) {
            this.f7737b = 1102;
        } else if ("\u8bfb\u53d6\u670d\u52a1\u7ed3\u679c\u8d85\u65f6".equals(str)) {
            this.f7737b = 1103;
        } else if ("\u8bf7\u6c42\u53c2\u6570\u975e\u6cd5".equals(str)) {
            this.f7737b = 1200;
        } else if ("\u7f3a\u5c11\u5fc5\u586b\u53c2\u6570".equals(str)) {
            this.f7737b = 1201;
        } else if ("\u8bf7\u6c42\u534f\u8bae\u975e\u6cd5".equals(str)) {
            this.f7737b = 1202;
        } else if ("\u5176\u4ed6\u672a\u77e5\u9519\u8bef".equals(str)) {
            this.f7737b = 1203;
        } else if ("\u534f\u8bae\u89e3\u6790\u9519\u8bef - ProtocolException".equals(str)) {
            this.f7737b = 1801;
        } else if ("socket \u8fde\u63a5\u8d85\u65f6 - SocketTimeoutException".equals(str)) {
            this.f7737b = 1802;
        } else if ("url\u5f02\u5e38 - MalformedURLException".equals(str)) {
            this.f7737b = 1803;
        } else if ("\u672a\u77e5\u4e3b\u673a - UnKnowHostException".equals(str)) {
            this.f7737b = 1804;
        } else if ("\u672a\u77e5\u9519\u8bef".equals(str)) {
            this.f7737b = 1900;
        } else if ("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException".equals(str)) {
            this.f7737b = 1901;
        } else if ("http\u6216socket\u8fde\u63a5\u5931\u8d25 - ConnectionException".equals(str)) {
            this.f7737b = 1806;
        } else if ("IO \u64cd\u4f5c\u5f02\u5e38 - IOException".equals(str)) {
            this.f7737b = 1902;
        } else if ("\u7a7a\u6307\u9488\u5f02\u5e38 - NullPointException".equals(str)) {
            this.f7737b = 1903;
        } else {
            this.f7737b = 1800;
        }
    }

    public fc() {
        this.f7736a = "";
        this.f7737b = 1000;
    }
}
