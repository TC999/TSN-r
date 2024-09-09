package cn.jpush.android.api;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CustomMessage {
    public String appId;
    public String contentType;
    public String extra;
    public String message;
    public String messageId;
    public byte platform;
    public String senderId;
    public String title;

    public String toString() {
        return "CustomMessage{messageId='" + this.messageId + "', extra='" + this.extra + "', message='" + this.message + "', contentType='" + this.contentType + "', title='" + this.title + "', senderId='" + this.senderId + "', appId='" + this.appId + "', platform='" + ((int) this.platform) + "'}";
    }
}
