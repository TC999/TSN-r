package cn.bluemobi.dylan.http;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MessageManager {
    private static volatile MessageManager messageManager;
    private boolean useEnglishLanguage = false;
    private MessageModel showMessageModel = MessageModel.OTHER_STATUS;
    private String errorMessage = "网络繁忙";

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum MessageModel {
        All,
        OTHER_STATUS,
        NO
    }

    private MessageManager() {
    }

    public static MessageManager getMessageManager() {
        if (messageManager == null) {
            synchronized (MessageManager.class) {
                if (messageManager == null) {
                    messageManager = new MessageManager();
                }
            }
        }
        return messageManager;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public MessageModel getShowMessageModel() {
        return this.showMessageModel;
    }

    public boolean isUseEnglishLanguage() {
        return this.useEnglishLanguage;
    }

    public MessageManager setErrorMessage(String str) {
        this.errorMessage = str;
        return this;
    }

    public MessageManager setShowMessageModel(MessageModel messageModel) {
        this.showMessageModel = messageModel;
        return messageManager;
    }

    public MessageManager setUseEnglishLanguage(boolean z) {
        this.useEnglishLanguage = z;
        return messageManager;
    }
}
