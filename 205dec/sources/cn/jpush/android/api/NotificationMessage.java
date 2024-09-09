package cn.jpush.android.api;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class NotificationMessage {
    public String _webPagePath;
    public String appId;
    public String appkey;
    public Context context;
    public String deeplink;
    public String developerArg0;
    public String displayForeground;
    public int failedAction;
    public String failedLink;
    public String inAppClickAction;
    public String inAppExtras;
    public String inAppShowTarget;
    public int inAppType;
    public boolean isRichPush;
    public String msgId;
    public int notificationAlertType;
    public String notificationBigPicPath;
    public String notificationBigText;
    public int notificationBuilderId;
    public String notificationCategory;
    public String notificationChannelId;
    public String notificationContent;
    public String notificationExtras;
    public int notificationId;
    public int notificationImportance;
    public String notificationInbox;
    public String notificationLargeIcon;
    public String notificationNormalSmallIcon;
    public int notificationPriority;
    public String notificationSmallIcon;
    public int notificationStyle;
    public JSONArray notificationTargetEvent;
    public String notificationTitle;
    public int notificationType;
    public int richType;
    public String sspWmOriginId;
    public int sspWmType;
    public String sspWxAppId;
    public String targetPkgName;
    public int platform = 0;
    public ArrayList<String> showResourceList = new ArrayList<>();
    public boolean isWmDeepLink = false;
    public int inAppMsgType = 1;
    public int inAppMsgShowType = 2;
    public int inAppMsgShowPos = 0;
    public String inAppMsgTitle = "";
    public String inAppMsgContentBody = "";

    public String toString() {
        return "NotificationMessage{notificationId=" + this.notificationId + ", msgId='" + this.msgId + "', appkey='" + this.appkey + "', notificationContent='" + this.notificationContent + "', notificationAlertType=" + this.notificationAlertType + ", notificationTitle='" + this.notificationTitle + "', notificationSmallIcon='" + this.notificationSmallIcon + "', notificationLargeIcon='" + this.notificationLargeIcon + "', notificationExtras='" + this.notificationExtras + "', notificationStyle=" + this.notificationStyle + ", notificationBuilderId=" + this.notificationBuilderId + ", notificationBigText='" + this.notificationBigText + "', notificationBigPicPath='" + this.notificationBigPicPath + "', notificationInbox='" + this.notificationInbox + "', notificationPriority=" + this.notificationPriority + ", notificationImportance=" + this.notificationImportance + ", notificationCategory='" + this.notificationCategory + "', developerArg0='" + this.developerArg0 + "', platform=" + this.platform + ", notificationChannelId='" + this.notificationChannelId + "', displayForeground='" + this.displayForeground + "', notificationType=" + this.notificationType + "', inAppMsgType=" + this.inAppMsgType + "', inAppMsgShowType=" + this.inAppMsgShowType + "', inAppMsgShowPos=" + this.inAppMsgShowPos + "', inAppMsgTitle=" + this.inAppMsgTitle + ", inAppMsgContentBody=" + this.inAppMsgContentBody + ", inAppType=" + this.inAppType + ", inAppShowTarget=" + this.inAppShowTarget + ", inAppClickAction=" + this.inAppClickAction + ", inAppExtras=" + this.inAppExtras + '}';
    }
}
