package com.umeng.socialize.bean;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.p518qq.p519e.comm.managers.setting.GlobalSetting;
import com.tencent.connect.common.Constants;
import com.tencent.p562mm.opensdk.constants.ConstantsAPI;
import com.umeng.socialize.shareboard.SnsPlatform;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public enum SHARE_MEDIA {
    GENERIC,
    SMS,
    EMAIL,
    SINA,
    QZONE,
    QQ,
    WEIXIN,
    WEIXIN_CIRCLE,
    WEIXIN_FAVORITE,
    WXWORK,
    DOUBAN,
    FACEBOOK,
    FACEBOOK_MESSAGER,
    TWITTER,
    YIXIN,
    YIXIN_CIRCLE,
    INSTAGRAM,
    PINTEREST,
    EVERNOTE,
    POCKET,
    LINKEDIN,
    FOURSQUARE,
    YNOTE,
    WHATSAPP,
    LINE,
    FLICKR,
    TUMBLR,
    ALIPAY,
    KAKAO,
    BYTEDANCE,
    BYTEDANCE_PUBLISH,
    BYTEDANCE_FRIENDS,
    DROPBOX,
    VKONTAKTE,
    DINGTALK,
    HONOR,
    MORE;

    public static SHARE_MEDIA convertToEmun(String str) {
        SHARE_MEDIA[] values;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("wxtimeline")) {
            return WEIXIN_CIRCLE;
        }
        if (str.equals("wxsession")) {
            return WEIXIN;
        }
        for (SHARE_MEDIA share_media : values()) {
            if (share_media.toString().trim().equals(str)) {
                return share_media;
            }
        }
        return null;
    }

    public static SnsPlatform createSnsPlatform(String str, String str2, String str3, String str4, int i) {
        SnsPlatform snsPlatform = new SnsPlatform();
        snsPlatform.mShowWord = str;
        snsPlatform.mIcon = str3;
        snsPlatform.mGrayIcon = str4;
        snsPlatform.mIndex = i;
        snsPlatform.mKeyword = str2;
        return snsPlatform;
    }

    public String getName() {
        return toString().equals("WEIXIN") ? "wxsession" : toString().equals("WEIXIN_CIRCLE") ? "wxtimeline" : toString().equals("WEIXIN_FAVORITE") ? "wxfavorite" : toString().toLowerCase();
    }

    public String getauthstyle(boolean z) {
        if (toString().equals(Constants.SOURCE_QQ)) {
            return "sso";
        }
        if (toString().equals("SINA")) {
            return z ? "sso" : "cloudy third";
        } else if (toString().equals("QZONE")) {
            return "sso";
        } else {
            if (toString().equals("RENREN")) {
                return "cloudy self";
            }
            if (toString().equals("WEIXIN") || toString().equals("WXWORK")) {
                return "sso";
            }
            if (toString().equals(GlobalSetting.FACEBOOK_SDK_WRAPPER)) {
                return z ? "sso" : "cloudy third";
            } else if (toString().equals("TENCENT")) {
                return "cloudy self";
            } else {
                if (toString().equals("YIXIN") || toString().equals("TWITTER") || toString().equals("LAIWANG") || toString().equals("LINE")) {
                    return "sso";
                }
                if (toString().equals("DOUBAN") || toString().equals("TWITTER") || toString().equals("LINKEDIN")) {
                    return "cloudy self";
                }
                return null;
            }
        }
    }

    public String getsharestyle(boolean z) {
        return toString().equals(Constants.SOURCE_QQ) ? "sso" : toString().equals("SINA") ? z ? "sso" : "cloudy third" : toString().equals(GlobalSetting.FACEBOOK_SDK_WRAPPER) ? z ? "sso" : "cloudy third" : (toString().equals("RENREN") || toString().equals("DOUBAN") || toString().equals("TENCENT") || toString().equals("TWITTER") || toString().equals("LINKEDIN")) ? "cloudy self" : "sso";
    }

    public SnsPlatform toSnsPlatform() {
        SnsPlatform snsPlatform = new SnsPlatform();
        if (toString().equals(Constants.SOURCE_QQ)) {
            snsPlatform.mShowWord = PlatformName.f39400QQ;
            snsPlatform.mIcon = "umeng_socialize_qq";
            snsPlatform.mGrayIcon = "umeng_socialize_qq";
            snsPlatform.mIndex = 0;
            snsPlatform.mKeyword = "qq";
        } else if (toString().equals("SMS")) {
            snsPlatform.mShowWord = PlatformName.SMS;
            snsPlatform.mIcon = "umeng_socialize_sms";
            snsPlatform.mGrayIcon = "umeng_socialize_sms";
            snsPlatform.mIndex = 1;
            snsPlatform.mKeyword = "sms";
        } else if (toString().equals("BYTEDANCE")) {
            snsPlatform.mShowWord = PlatformName.BYTEDANCE;
            snsPlatform.mIcon = "umeng_socialize_bytedance";
            snsPlatform.mGrayIcon = "umeng_socialize_bytedance";
            snsPlatform.mIndex = 0;
            snsPlatform.mKeyword = "bytedance";
        } else if (toString().equals("BYTEDANCE_PUBLISH")) {
            snsPlatform.mShowWord = PlatformName.BYTEDANCE_PUBLISH;
            snsPlatform.mIcon = "umeng_socialize_bytedance_publish";
            snsPlatform.mGrayIcon = "umeng_socialize_bytedance_publish";
            snsPlatform.mIndex = 0;
            snsPlatform.mKeyword = "bytedance_publish";
        } else if (toString().equals("BYTEDANCE_FRIENDS")) {
            snsPlatform.mShowWord = PlatformName.BYTEDANCE_FRIENDS;
            snsPlatform.mIcon = "umeng_socialize_bytedance_friends";
            snsPlatform.mGrayIcon = "umeng_socialize_bytedance_friends";
            snsPlatform.mIndex = 0;
            snsPlatform.mKeyword = "bytedance_friends";
        } else if (!toString().equals("GENERIC")) {
            if (toString().equals("EMAIL")) {
                snsPlatform.mShowWord = PlatformName.EMAIL;
                snsPlatform.mIcon = "umeng_socialize_gmail";
                snsPlatform.mGrayIcon = "umeng_socialize_gmail";
                snsPlatform.mIndex = 2;
                snsPlatform.mKeyword = NotificationCompat.CATEGORY_EMAIL;
            } else if (toString().equals("SINA")) {
                snsPlatform.mShowWord = PlatformName.SINA;
                snsPlatform.mIcon = "umeng_socialize_sina";
                snsPlatform.mGrayIcon = "umeng_socialize_sina";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "sina";
            } else if (toString().equals("QZONE")) {
                snsPlatform.mShowWord = PlatformName.QZONE;
                snsPlatform.mIcon = "umeng_socialize_qzone";
                snsPlatform.mGrayIcon = "umeng_socialize_qzone";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = Constants.SOURCE_QZONE;
            } else if (toString().equals("WEIXIN")) {
                snsPlatform.mShowWord = PlatformName.WEIXIN;
                snsPlatform.mIcon = "umeng_socialize_wechat";
                snsPlatform.mGrayIcon = "umeng_socialize_weichat";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE;
            } else if (toString().equals("WEIXIN_CIRCLE")) {
                snsPlatform.mShowWord = PlatformName.WEIXIN_CIRCLE;
                snsPlatform.mIcon = "umeng_socialize_wxcircle";
                snsPlatform.mGrayIcon = "umeng_socialize_wxcircle";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "wxcircle";
            } else if (toString().equals("WEIXIN_FAVORITE")) {
                snsPlatform.mShowWord = PlatformName.WEIXIN_FAVORITE;
                snsPlatform.mIcon = "umeng_socialize_fav";
                snsPlatform.mGrayIcon = "umeng_socialize_fav";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "wechatfavorite";
            } else if (toString().equals("WXWORK")) {
                snsPlatform.mShowWord = PlatformName.WXWORK;
                snsPlatform.mIcon = "umeng_socialize_wxwork";
                snsPlatform.mGrayIcon = "umeng_socialize_wxwork";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "wxwork";
            } else if (toString().equals(GlobalSetting.FACEBOOK_SDK_WRAPPER)) {
                snsPlatform.mShowWord = PlatformName.FACEBOOK;
                snsPlatform.mIcon = "umeng_socialize_facebook";
                snsPlatform.mGrayIcon = "umeng_socialize_facebook";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "facebook";
            } else if (toString().equals("FACEBOOK_MESSAGER")) {
                snsPlatform.mShowWord = PlatformName.FACEBOOK_MESSAGER;
                snsPlatform.mIcon = "umeng_socialize_fbmessage";
                snsPlatform.mGrayIcon = "umeng_socialize_fbmessage";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "facebook_messager";
            } else if (toString().equals("YIXIN")) {
                snsPlatform.mShowWord = PlatformName.YIXIN;
                snsPlatform.mIcon = "umeng_socialize_yixin";
                snsPlatform.mGrayIcon = "umeng_socialize_yixin";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "yinxin";
            } else if (toString().equals("TWITTER")) {
                snsPlatform.mShowWord = PlatformName.TWITTER;
                snsPlatform.mIcon = "umeng_socialize_twitter";
                snsPlatform.mGrayIcon = "umeng_socialize_twitter";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "twitter";
            } else if (toString().equals("INSTAGRAM")) {
                snsPlatform.mShowWord = PlatformName.INSTAGRAM;
                snsPlatform.mIcon = "umeng_socialize_instagram";
                snsPlatform.mGrayIcon = "umeng_socialize_instagram";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "instagram";
            } else if (toString().equals("YIXIN_CIRCLE")) {
                snsPlatform.mShowWord = PlatformName.YIXIN_CIRCLE;
                snsPlatform.mIcon = "umeng_socialize_yixin_circle";
                snsPlatform.mGrayIcon = "umeng_socialize_yixin_circle";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "yinxincircle";
            } else if (toString().equals("PINTEREST")) {
                snsPlatform.mShowWord = PlatformName.PINTEREST;
                snsPlatform.mIcon = "umeng_socialize_pinterest";
                snsPlatform.mGrayIcon = "umeng_socialize_pinterest";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "pinterest";
            } else if (toString().equals("EVERNOTE")) {
                snsPlatform.mShowWord = PlatformName.EVERNOTE;
                snsPlatform.mIcon = "umeng_socialize_evernote";
                snsPlatform.mGrayIcon = "umeng_socialize_evernote";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "evernote";
            } else if (toString().equals("POCKET")) {
                snsPlatform.mShowWord = PlatformName.POCKET;
                snsPlatform.mIcon = "umeng_socialize_pocket";
                snsPlatform.mGrayIcon = "umeng_socialize_pocket";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "pocket";
            } else if (toString().equals("LINKEDIN")) {
                snsPlatform.mShowWord = PlatformName.LINKEDIN;
                snsPlatform.mIcon = "umeng_socialize_linkedin";
                snsPlatform.mGrayIcon = "umeng_socialize_linkedin";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "linkedin";
            } else if (toString().equals("FOURSQUARE")) {
                snsPlatform.mShowWord = PlatformName.FOURSQUARE;
                snsPlatform.mIcon = "umeng_socialize_foursquare";
                snsPlatform.mGrayIcon = "umeng_socialize_foursquare";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "foursquare";
            } else if (toString().equals("YNOTE")) {
                snsPlatform.mShowWord = PlatformName.YNOTE;
                snsPlatform.mIcon = "umeng_socialize_ynote";
                snsPlatform.mGrayIcon = "umeng_socialize_ynote";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "ynote";
            } else if (toString().equals("WHATSAPP")) {
                snsPlatform.mShowWord = PlatformName.WHATSAPP;
                snsPlatform.mIcon = "umeng_socialize_whatsapp";
                snsPlatform.mGrayIcon = "umeng_socialize_whatsapp";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "whatsapp";
            } else if (toString().equals("LINE")) {
                snsPlatform.mShowWord = PlatformName.LINE;
                snsPlatform.mIcon = "umeng_socialize_line";
                snsPlatform.mGrayIcon = "umeng_socialize_line";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "line";
            } else if (toString().equals("FLICKR")) {
                snsPlatform.mShowWord = PlatformName.FLICKR;
                snsPlatform.mIcon = "umeng_socialize_flickr";
                snsPlatform.mGrayIcon = "umeng_socialize_flickr";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "flickr";
            } else if (toString().equals("TUMBLR")) {
                snsPlatform.mShowWord = PlatformName.TUMBLR;
                snsPlatform.mIcon = "umeng_socialize_tumblr";
                snsPlatform.mGrayIcon = "umeng_socialize_tumblr";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "tumblr";
            } else if (toString().equals("KAKAO")) {
                snsPlatform.mShowWord = PlatformName.KAKAO;
                snsPlatform.mIcon = "umeng_socialize_kakao";
                snsPlatform.mGrayIcon = "umeng_socialize_kakao";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "kakao";
            } else if (toString().equals("DOUBAN")) {
                snsPlatform.mShowWord = PlatformName.DOUBAN;
                snsPlatform.mIcon = "umeng_socialize_douban";
                snsPlatform.mGrayIcon = "umeng_socialize_douban";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "douban";
            } else if (toString().equals("ALIPAY")) {
                snsPlatform.mShowWord = PlatformName.ALIPAY;
                snsPlatform.mIcon = "umeng_socialize_alipay";
                snsPlatform.mGrayIcon = "umeng_socialize_alipay";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "alipay";
            } else if (toString().equals("MORE")) {
                snsPlatform.mShowWord = PlatformName.MORE;
                snsPlatform.mIcon = "umeng_socialize_more";
                snsPlatform.mGrayIcon = "umeng_socialize_more";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "more";
            } else if (toString().equals("DINGTALK")) {
                snsPlatform.mShowWord = PlatformName.DINGTALK;
                snsPlatform.mIcon = "umeng_socialize_ding";
                snsPlatform.mGrayIcon = "umeng_socialize_ding";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "ding";
            } else if (toString().equals("VKONTAKTE")) {
                snsPlatform.mShowWord = PlatformName.VKONTAKTE;
                snsPlatform.mIcon = "vk_icon";
                snsPlatform.mGrayIcon = "vk_icon";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "vk";
            } else if (toString().equals("DROPBOX")) {
                snsPlatform.mShowWord = PlatformName.DROPBOX;
                snsPlatform.mIcon = "umeng_socialize_dropbox";
                snsPlatform.mGrayIcon = "umeng_socialize_dropbox";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "dropbox";
            } else if (toString().equals("HONOR")) {
                snsPlatform.mShowWord = PlatformName.HONOR;
                snsPlatform.mIcon = "umeng_socialize_honor";
                snsPlatform.mGrayIcon = "umeng_socialize_honor";
                snsPlatform.mIndex = 0;
                snsPlatform.mKeyword = "honor";
            }
        }
        snsPlatform.mPlatform = this;
        return snsPlatform;
    }

    @Override // java.lang.Enum
    public String toString() {
        return super.toString();
    }
}
