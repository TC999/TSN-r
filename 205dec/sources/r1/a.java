package r1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tsn.chat.model.ChatModel;
import com.tsn.chat.model.ResponseMessage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: HandlerProcessing.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a {
    public static void a(ResponseMessage responseMessage) {
        byte controlType = responseMessage.getControlType();
        if (controlType == 50) {
            q1.a.a().k();
        }
        if (controlType == 51) {
            q1.a.a().j(((JSONObject) JSON.parse(responseMessage.getDatas())).getString("messageId"));
        }
        if (controlType == 52) {
            ChatModel chatModel = new ChatModel();
            JSONObject jSONObject = (JSONObject) JSON.parse(responseMessage.getDatas());
            try {
                chatModel.setCreateTime(com.tsn.chat.utils.a.c());
                chatModel.setSchoolId(jSONObject.getString("schoolId"));
                chatModel.setToUserId(jSONObject.getString("toUserId"));
                chatModel.setToUserName(jSONObject.getString("toUserName"));
                chatModel.setFromUserId(jSONObject.getString("fromUserId"));
                chatModel.setFromUserName(jSONObject.getString("fromUserName"));
                chatModel.setMsg(jSONObject.getString("msg"));
                chatModel.setType(jSONObject.getString("type"));
                chatModel.setPhoto(jSONObject.getString("photo"));
                if ("1".equals(jSONObject.getString("type"))) {
                    q1.a.a().f(chatModel);
                } else {
                    chatModel.setGroupId(jSONObject.getString("groupId"));
                    q1.a.a().a(chatModel);
                }
            } catch (Exception unused) {
                System.out.println("\u63a5\u6536\u5230\u9519\u8bef\u683c\u5f0f\u6d88\u606f\uff0c\u5df2\u5c4f\u853d");
            }
        }
        if (controlType == 53) {
            q1.a.a().d();
        }
    }
}
