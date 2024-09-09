package s1;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tsn.chat.model.ChatModel;
import com.tsn.chat.model.RequestMessage;
import com.tsn.chat.utils.c;
import com.tsn.chat.utils.d;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import q1.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SerialImpl.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f64370a;

    public static void p() {
        ChatModel chatModel = new ChatModel();
        chatModel.setCreateTime(com.tsn.chat.utils.a.c());
        chatModel.setFromUserId("47932");
        chatModel.setFromUserName("\u90ed\u6e05\u679d");
        chatModel.setToUserId("47932,39850,39858,40125,40209,40223,40232,40236,42127,41446,45897,44998,47297,47712,47719,47723,40231,40240,40341,40351,40356,40805,42034,42070,42114,42318,40559,47370,47415,43931,44735,44747,45315,46760,46764,47304,47305,47314,46769,46853,47022,47089");
        chatModel.setToUserName("wangmazi");
        chatModel.setSchoolId("wgydx");
        chatModel.setMsg("as");
        chatModel.setGroupId("638");
        chatModel.setMessageId("c5ef9a84-c3fc-4ca2-88f3-bb1affcc88e0");
        chatModel.setPhoto("");
        q1.a.a().o(chatModel);
    }

    @Override // q1.b
    public void a(ChatModel chatModel) {
    }

    @Override // q1.b
    public void b() {
    }

    @Override // q1.b
    public void c() {
        HashMap hashMap = new HashMap();
        hashMap.put("schoolId", com.tsn.chat.utils.b.f52407e);
        hashMap.put("userId", com.tsn.chat.utils.b.f52406d);
        hashMap.put(CampaignEx.JSON_KEY_HB, "chat");
        String jSONString = JSON.toJSONString(hashMap);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 2, jSONString);
        if (com.tsn.chat.utils.b.f52403a.size() > 0) {
            c.a(requestMessage);
        }
    }

    @Override // q1.b
    public void d() {
    }

    @Override // q1.b
    public void e() {
        com.tsn.chat.utils.b.f52406d = "";
        com.tsn.chat.utils.b.f52407e = "";
        com.tsn.chat.utils.b.f52403a.close();
    }

    @Override // q1.b
    public void f(ChatModel chatModel) {
    }

    @Override // q1.b
    public int g(String str, String str2, String str3, String str4) {
        e();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new d(str3, Integer.parseInt(str4), countDownLatch).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        if (com.tsn.chat.utils.b.f52403a.size() == 0) {
            return 2;
        }
        com.tsn.chat.utils.b.f52406d = str;
        com.tsn.chat.utils.b.f52407e = str2;
        q1.a.a().n(str, str2);
        return 1;
    }

    @Override // q1.b
    public void h() {
    }

    @Override // q1.b
    public void i() {
        HashMap hashMap = new HashMap();
        hashMap.put("schoolId", com.tsn.chat.utils.b.f52407e);
        hashMap.put("userId", com.tsn.chat.utils.b.f52406d);
        hashMap.put(CampaignEx.JSON_KEY_HB, "back");
        String jSONString = JSON.toJSONString(hashMap);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 2, jSONString);
        if (com.tsn.chat.utils.b.f52403a.size() > 0) {
            c.a(requestMessage);
        }
    }

    @Override // q1.b
    public void j(String str) {
    }

    @Override // q1.b
    public void k() {
    }

    @Override // q1.b
    public void l(Context context) {
        f64370a = context;
    }

    @Override // q1.b
    public void m(ChatModel chatModel) {
        chatModel.setType("2");
        String jSONString = JSON.toJSONString(chatModel);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 3, jSONString);
        if (com.tsn.chat.utils.b.f52403a.size() > 0) {
            c.a(requestMessage);
        }
    }

    @Override // q1.b
    public void n(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", str);
        hashMap.put("schoolId", str2);
        String jSONString = JSON.toJSONString(hashMap);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 1, jSONString);
        if (com.tsn.chat.utils.b.f52403a.size() > 0) {
            c.a(requestMessage);
        }
    }

    @Override // q1.b
    public void o(ChatModel chatModel) {
        chatModel.setType("1");
        String jSONString = JSON.toJSONString(chatModel);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 3, jSONString);
        if (com.tsn.chat.utils.b.f52403a.size() > 0) {
            c.a(requestMessage);
        }
    }
}
