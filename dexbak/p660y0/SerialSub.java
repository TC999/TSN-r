package p660y0;

import android.content.ComponentName;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.sqlitelibrary.SQLiteDbUtil;
import com.bxkj.base.chat.heart.AlarmChatService;
import com.bxkj.base.chat.heart.ChatBroadcastActionType;
import com.bxkj.base.chat.p084db.ChatMessageDb;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3919y;
import com.bxkj.student.C4229c;
import com.orhanobut.logger.C11792j;
import com.tsn.chat.model.ChatModel;
import p013a1.SerialImpl;

/* renamed from: y0.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SerialSub extends SerialImpl {
    @Override // p013a1.SerialImpl, p660y0.Serial
    /* renamed from: a */
    public void mo28a(ChatModel chatModel) {
        C11792j.m20470c("接收到群聊信息:" + chatModel.toString());
        LocalBroadcastManager.getInstance(SerialImpl.f51a).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE).putExtra("chatType", 2).putExtra("userId", chatModel.getFromUserId()).putExtra("userName", chatModel.getFromUserName()).putExtra("toUserName", chatModel.getToUserName()).putExtra("photo", chatModel.getPhoto()).putExtra("createTime", chatModel.getCreateTime()).putExtra("groupId", chatModel.getGroupId()).putExtra("msg", chatModel.getMsg()));
    }

    @Override // p013a1.SerialImpl, p660y0.Serial
    /* renamed from: b */
    public void mo27b() {
        C11792j.m20470c("客户端离线回调");
    }

    @Override // p013a1.SerialImpl, p660y0.Serial
    /* renamed from: d */
    public void mo26d() {
        LocalBroadcastManager.getInstance(SerialImpl.f51a).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_HEART_CALLBACK_SUCCESS));
        mo36e();
        LoginUser.getLoginUser().setLogin(false);
        LoginUser.getLoginUser().setToken("");
        LoginUser.getLoginUser().setUserId("");
        AppManager.m57776n().m57780j();
        if (LoginUser.getLoginUser().getUserType() == 1) {
            SerialImpl.f51a.startActivity(new Intent().setComponent(new ComponentName(C4229c.f16086b, "com.bxkj.student.MainActivity")).setFlags(335544320));
            SerialImpl.f51a.startActivity(new Intent().setComponent(new ComponentName(C4229c.f16086b, "com.bxkj.student.personal.login.LoginActivity")).setFlags(268435456));
        } else {
            SerialImpl.f51a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.teacher", "com.bxkj.teacher.login.LoginActivity")).setFlags(335544320));
        }
        if (C3919y.m44006a(SerialImpl.f51a, AlarmChatService.class.getName())) {
            C11792j.m20470c("AlarmChatService----------isServiceRunning");
            SerialImpl.f51a.stopService(new Intent(SerialImpl.f51a, AlarmChatService.class));
        }
    }

    @Override // p013a1.SerialImpl, p660y0.Serial
    /* renamed from: f */
    public void mo25f(ChatModel chatModel) {
        C11792j.m20470c("接收到聊天信息:" + chatModel.toString());
        LocalBroadcastManager.getInstance(SerialImpl.f51a).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE).putExtra("chatType", 1).putExtra("userId", chatModel.getFromUserId()).putExtra("userName", chatModel.getFromUserName()).putExtra("toUserName", chatModel.getToUserName()).putExtra("photo", chatModel.getPhoto()).putExtra("createTime", chatModel.getCreateTime()).putExtra("msg", chatModel.getMsg()));
    }

    @Override // p013a1.SerialImpl, p660y0.Serial
    /* renamed from: j */
    public void mo24j(String str) {
        SQLiteDbUtil.m57474h().delete(ChatMessageDb.class, "messageId=?", new String[]{str});
        C11792j.m20470c("消息发送回调" + str);
        Intent intent = new Intent(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS);
        intent.putExtra("messageId", str);
        LocalBroadcastManager.getInstance(SerialImpl.f51a).sendBroadcast(intent);
        super.mo24j(str);
    }

    @Override // p013a1.SerialImpl, p660y0.Serial
    /* renamed from: k */
    public void mo23k() {
        C11792j.m20470c("心跳响应" + SerialImpl.f51a);
        LocalBroadcastManager.getInstance(SerialImpl.f51a).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_HEART_CALLBACK_SUCCESS));
    }
}
