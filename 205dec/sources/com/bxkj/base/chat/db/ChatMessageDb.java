package com.bxkj.base.chat.db;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ChatMessageDb {
    private String createTime;
    private String fromUserId;
    private String fromUserName;
    private String groupId;
    private int id;
    private String messageId;
    private String msg;
    private String photo;
    private String toUserId;
    private String toUserName;
    private String type;

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

    public int getId() {
        return this.id;
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

    public void setId(int i4) {
        this.id = i4;
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
        return "ChatMessageDb{id=" + this.id + ", createTime=" + this.createTime + ", messageId='" + this.messageId + "', toUserId='" + this.toUserId + "', toUserName='" + this.toUserName + "', fromUserId='" + this.fromUserId + "', fromUserName='" + this.fromUserName + "', photo='" + this.photo + "', msg='" + this.msg + "', type='" + this.type + "', groupId='" + this.groupId + "'}";
    }
}
