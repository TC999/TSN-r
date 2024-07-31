package com.p521ss.android.socialbase.downloader.p556q;

import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.baidu.mobads.sdk.internal.C2640by;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.p518qq.p519e.comm.adevent.AdEventType;
import okhttp3.internal.http.StatusLine;

/* renamed from: com.ss.android.socialbase.downloader.q.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12666a {
    /* renamed from: ok */
    public static String m16733ok(int i) {
        if (i != 449) {
            if (i != 451) {
                if (i != 600) {
                    if (i != 509) {
                        if (i != 510) {
                            switch (i) {
                                case 100:
                                    return "Continue";
                                case 101:
                                    return "Switching Protocols";
                                case 102:
                                    return "Processing";
                                default:
                                    switch (i) {
                                        case 200:
                                            return C2640by.f8773k;
                                        case 201:
                                            return "Created";
                                        case 202:
                                            return "Accepted";
                                        case 203:
                                            return "Non-Authoritative Information";
                                        case AdEventType.VIDEO_PAUSE /* 204 */:
                                            return "No Content";
                                        case AdEventType.VIDEO_STOP /* 205 */:
                                            return "Reset Content";
                                        case AdEventType.VIDEO_COMPLETE /* 206 */:
                                            return "Partial Content";
                                        case AdEventType.VIDEO_ERROR /* 207 */:
                                            return "Multi-Status";
                                        default:
                                            switch (i) {
                                                case 300:
                                                    return "Multiple Choices";
                                                case 301:
                                                    return "Moved Permanently";
                                                case 302:
                                                    return "Move Temporarily";
                                                case 303:
                                                    return "See Other";
                                                case AdEventType.COMPLAIN_SUCCESS /* 304 */:
                                                    return "Not Modified";
                                                case 305:
                                                    return "Use Proxy";
                                                case 306:
                                                    return "Switch Proxy";
                                                case 307:
                                                    return "Temporary Redirect";
                                                default:
                                                    switch (i) {
                                                        case FontStyle.WEIGHT_NORMAL /* 400 */:
                                                            return "Bad Request";
                                                        case 401:
                                                            return "Unauthorized";
                                                        case 402:
                                                            return "Payment Required";
                                                        case 403:
                                                            return "Forbidden";
                                                        case 404:
                                                            return "Not Found";
                                                        case 405:
                                                            return "Method Not Allowed";
                                                        case 406:
                                                            return "Not Acceptable";
                                                        case 407:
                                                            return "Proxy Authentication Required";
                                                        case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                                                            return "Request Timeout";
                                                        case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                                            return "Conflict";
                                                        case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                                                            return "Gone";
                                                        case TTAdConstant.IMAGE_CODE /* 411 */:
                                                            return "Length Required";
                                                        case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                                                            return "Precondition Failed";
                                                        case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                                            return "Request Entity Too Large";
                                                        case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                                            return "Request-URI Too Long";
                                                        case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                                            return "Unsupported Media Type";
                                                        case TTAdConstant.LIVE_AD_CODE /* 416 */:
                                                            return "Requested Range Not Satisfiable";
                                                        case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                                                            return "Expectation Failed";
                                                        case TTAdConstant.DEEPLINK_FALL_BACK_CODE /* 418 */:
                                                            return "I'm a teapot";
                                                        default:
                                                            switch (i) {
                                                                case StatusLine.HTTP_MISDIRECTED_REQUEST /* 421 */:
                                                                    return "Too Many Connections";
                                                                case 422:
                                                                    return "Unprocessable Entity";
                                                                case 423:
                                                                    return "Locked";
                                                                case 424:
                                                                    return "Failed Dependency";
                                                                case 425:
                                                                    return "Unordered Collection";
                                                                case 426:
                                                                    return "Upgrade Required";
                                                                default:
                                                                    switch (i) {
                                                                        case 500:
                                                                            return "Internal Server Error";
                                                                        case 501:
                                                                            return "Not Implemented";
                                                                        case 502:
                                                                            return "Bad Gateway";
                                                                        case 503:
                                                                            return "Service Unavailable";
                                                                        case 504:
                                                                            return "Gateway Timeout";
                                                                        case 505:
                                                                            return "HTTP Version Not Supported";
                                                                        case 506:
                                                                            return "Variant Also Negotiates";
                                                                        case 507:
                                                                            return "Insufficient Storage";
                                                                        default:
                                                                            return "";
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                        }
                        return "Not Extended";
                    }
                    return "Bandwidth Limit Exceeded";
                }
                return "Unparseable Response Headers";
            }
            return "Unavailable For Legal Reasons";
        }
        return "Retry With";
    }
}
