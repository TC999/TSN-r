package cn.bluemobi.dylan.http;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class MessageManager {
    private static volatile MessageManager messageManager;
    private boolean useEnglishLanguage = false;
    private MessageModel showMessageModel = MessageModel.OTHER_STATUS;
    private String errorMessage = "\u7f51\u7edc\u7e41\u5fd9";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
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

    public MessageManager setUseEnglishLanguage(boolean z3) {
        this.useEnglishLanguage = z3;
        return messageManager;
    }
}
