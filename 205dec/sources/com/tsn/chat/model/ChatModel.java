package com.tsn.chat.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ChatModel {
    private String createTime;
    private String fromUserId;
    private String fromUserName;
    private String groupId;
    private String messageId;
    private String msg;
    private String photo;
    private String schoolId;
    private String toUserId;
    private String toUserName;
    private String type;

    public ChatModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.schoolId = str;
        this.toUserId = str2;
        this.fromUserId = str3;
        this.toUserName = str4;
        this.fromUserName = str5;
        this.createTime = str6;
        this.msg = str7;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getFromUserId() {
        return this.fromUserId;
    }

    public String getFromUserName() {
        return this.fromUserName;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getPhoto() {
        return this.photo;
    }

    public String getSchoolId() {
        return this.schoolId;
    }

    public String getToUserId() {
        return this.toUserId;
    }

    public String getToUserName() {
        return this.toUserName;
    }

    public String getType() {
        return this.type;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setFromUserId(String str) {
        this.fromUserId = str;
    }

    public void setFromUserName(String str) {
        this.fromUserName = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setPhoto(String str) {
        this.photo = str;
    }

    public void setSchoolId(String str) {
        this.schoolId = str;
    }

    public void setToUserId(String str) {
        this.toUserId = str;
    }

    public void setToUserName(String str) {
        this.toUserName = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "ChatModel [schoolId=" + this.schoolId + ", toUserId=" + this.toUserId + ", fromUserId=" + this.fromUserId + ", toUserName=" + this.toUserName + ", fromUserName=" + this.fromUserName + ", createTime=" + this.createTime + ", msg=" + this.msg + ", type=" + this.type + ", groupId=" + this.groupId + "]";
    }

    public ChatModel() {
    }
}
