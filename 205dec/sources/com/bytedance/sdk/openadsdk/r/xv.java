package com.bytedance.sdk.openadsdk.r;

import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.ux.gd;
import com.bytedance.sdk.component.ux.u;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements u {

    /* renamed from: c  reason: collision with root package name */
    private static int f36263c;
    private boolean sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private long f36264w = 0;
    private long xv;

    public xv() {
        f36263c++;
        this.ux = "image_request_" + f36263c;
    }

    private String xv(String str, gd gdVar) {
        com.bytedance.sdk.component.ux.xv.c fz;
        if (str != null) {
            char c4 = '\uffff';
            switch (str.hashCode()) {
                case -1867169789:
                    if (str.equals("success")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1584526165:
                    if (str.equals("raw_cache")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1442758754:
                    if (str.equals("image_type")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -1428113824:
                    if (str.equals("disk_cache")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -1335717394:
                    if (str.equals("decode")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case -1281977283:
                    if (str.equals("failed")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case -1076854124:
                    if (str.equals("check_duplicate")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 1017400004:
                    if (str.equals("memory_cache")) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 1478448621:
                    if (str.equals("net_request")) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case 1718821013:
                    if (str.equals("generate_key")) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case 2067979407:
                    if (str.equals("cache_policy")) {
                        c4 = '\n';
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    return "\u6210\u529f";
                case 1:
                    return "\u67e5\u8be2RAW\u5185\u5b58\u7f13\u5b58";
                case 2:
                    return "\u5224\u65ad\u56fe\u7247\u7c7b\u578b\uff1a";
                case 3:
                    return "\u67e5\u8be2\u6587\u4ef6\u7f13\u5b58";
                case 4:
                    return "\u89e3\u7801";
                case 5:
                    if (!(gdVar instanceof com.bytedance.sdk.component.ux.xv.xv) || (fz = ((com.bytedance.sdk.component.ux.xv.xv) gdVar).fz()) == null) {
                        return "\u5931\u8d25";
                    }
                    Throwable xv = fz.xv();
                    StringBuilder sb = new StringBuilder();
                    sb.append("\u5931\u8d25\uff1acode:");
                    sb.append(fz.c());
                    sb.append(", msg:");
                    sb.append(fz.w());
                    sb.append(", exception:");
                    sb.append(xv != null ? xv.getMessage() : "null \r\n");
                    return sb.toString();
                case 6:
                    return "\u68c0\u67e5\u91cd\u590d\u8bf7\u6c42";
                case 7:
                    return "\u67e5\u8be2Bitmap\u5185\u5b58\u7f13\u5b58";
                case '\b':
                    return "\u8bf7\u6c42\u7f51\u7edc";
                case '\t':
                    return "\u751f\u6210KEY:" + gdVar.r();
                case '\n':
                    return "\u67e5\u8be2\u7f13\u5b58\u7b56\u7565";
                default:
                    return str;
            }
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.ux.u
    @ATSMethod(1)
    public void c(String str, gd gdVar) {
        if (!this.sr) {
            a.w("ImageLoaderStep", "start " + this.ux + " request:" + gdVar.w() + ", width:" + gdVar.xv() + ",height:" + gdVar.sr());
            this.sr = true;
        }
        this.f36264w = System.currentTimeMillis();
        a.w("ImageLoaderStep", this.ux + " \u5f00\u59cb:" + xv(str, gdVar));
    }

    @Override // com.bytedance.sdk.component.ux.u
    @ATSMethod(2)
    public void w(String str, gd gdVar) {
        long currentTimeMillis = System.currentTimeMillis() - this.f36264w;
        this.xv += currentTimeMillis;
        a.w("ImageLoaderStep", this.ux + " \u7ed3\u675f:" + xv(str, gdVar) + ",\u8017\u65f6\uff1a" + currentTimeMillis + " ms\uff0c \u603b\u8ba1\uff1a" + this.xv + "\r\n");
    }
}
