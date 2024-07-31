package p663z0;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tsn.chat.model.ChatModel;
import com.tsn.chat.model.ResponseMessage;
import com.tsn.chat.utils.DateHelp;
import p660y0.BaseApplication;

/* renamed from: z0.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class HandlerProcessing {
    /* renamed from: a */
    public static void m8a(ResponseMessage responseMessage) {
        byte controlType = responseMessage.getControlType();
        if (controlType == 50) {
            BaseApplication.m38a().mo23k();
        }
        if (controlType == 51) {
            BaseApplication.m38a().mo24j(((JSONObject) JSON.parse(responseMessage.getDatas())).getString("messageId"));
        }
        if (controlType == 52) {
            ChatModel chatModel = new ChatModel();
            JSONObject jSONObject = (JSONObject) JSON.parse(responseMessage.getDatas());
            try {
                chatModel.setCreateTime(DateHelp.m14863c());
                chatModel.setSchoolId(jSONObject.getString("schoolId"));
                chatModel.setToUserId(jSONObject.getString("toUserId"));
                chatModel.setToUserName(jSONObject.getString("toUserName"));
                chatModel.setFromUserId(jSONObject.getString("fromUserId"));
                chatModel.setFromUserName(jSONObject.getString("fromUserName"));
                chatModel.setMsg(jSONObject.getString("msg"));
                chatModel.setType(jSONObject.getString("type"));
                chatModel.setPhoto(jSONObject.getString("photo"));
                if ("1".equals(jSONObject.getString("type"))) {
                    BaseApplication.m38a().mo25f(chatModel);
                } else {
                    chatModel.setGroupId(jSONObject.getString("groupId"));
                    BaseApplication.m38a().mo28a(chatModel);
                }
            } catch (Exception unused) {
                System.out.println("接收到错误格式消息，已屏蔽");
            }
        }
        if (controlType == 53) {
            BaseApplication.m38a().mo26d();
        }
    }
}
