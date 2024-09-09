package com.bykv.vk.openvk.component.video.c.w.ux;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.component.video.c.w.gd;
import java.io.InputStream;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    List<gd.w> f25139c;

    /* renamed from: w  reason: collision with root package name */
    ux f25140w;

    public abstract int c();

    /* JADX INFO: Access modifiers changed from: protected */
    public gd.w c(String str) {
        List<gd.w> list;
        if (str != null && (list = this.f25139c) != null && list.size() > 0) {
            for (gd.w wVar : this.f25139c) {
                if (str.equals(wVar.f25101c)) {
                    return wVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(int i4) {
        switch (i4) {
            case 200:
                return "OK";
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i4) {
                    case 300:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case 302:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO /* 305 */:
                        return "Use Proxy";
                    default:
                        switch (i4) {
                            case 400:
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
                            case 408:
                                return "Request Time-Out";
                            case 409:
                                return "Conflict";
                            case 410:
                                return "Gone";
                            case 411:
                                return "Length Required";
                            case 412:
                                return "Precondition Failed";
                            case 413:
                                return "Request Entity Too Large";
                            case 414:
                                return "Request-URI Too Large";
                            case 415:
                                return "Unsupported Media Type";
                            default:
                                switch (i4) {
                                    case 500:
                                        return "Internal Server Error";
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE /* 501 */:
                                        return "Not Implemented";
                                    case 502:
                                        return "Bad Gateway";
                                    case 503:
                                        return "Service Unavailable";
                                    case 504:
                                        return "Gateway Timeout";
                                    case 505:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public abstract String c(String str, String str2);

    public abstract String f();

    public ux r() {
        return this.f25140w;
    }

    public abstract InputStream sr();

    public abstract String ux();

    public abstract boolean w();

    public abstract List<gd.w> xv();
}
