package cn.jpush.android.api;

import cn.jpush.android.helper.f;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CallBackParams implements Serializable {
    public int action;
    public String alias;
    public Map<String, Object> pros;
    public int protoType;
    private long sendTime;
    public int sequence;
    public TagAliasCallback tagAliasCallBack;
    public Set<String> tags;

    public CallBackParams(int i4, long j4, int i5, int i6) {
        this.sequence = i4;
        this.sendTime = j4;
        this.protoType = i5;
        this.action = i6;
    }

    public CallBackParams(int i4, String str, long j4, int i5, int i6) {
        this.sequence = i4;
        this.alias = str;
        this.sendTime = j4;
        this.protoType = i5;
        this.action = i6;
    }

    public CallBackParams(int i4, Map<String, Object> map, long j4, int i5, int i6) {
        this.sequence = i4;
        this.pros = map;
        this.sendTime = j4;
        this.protoType = i5;
        this.action = i6;
    }

    public CallBackParams(int i4, Set<String> set, long j4, int i5, int i6) {
        this.sequence = i4;
        this.tags = set;
        this.sendTime = j4;
        this.protoType = i5;
        this.action = i6;
    }

    public CallBackParams(String str, Set<String> set, TagAliasCallback tagAliasCallback, long j4, int i4, int i5) {
        this.alias = str;
        this.tags = set;
        this.tagAliasCallBack = tagAliasCallback;
        this.sendTime = j4;
        this.protoType = i4;
        this.action = i5;
        this.sequence = (int) f.a();
    }

    public boolean isTimeOut(long j4) {
        return this.protoType == 0 && System.currentTimeMillis() - this.sendTime > j4 + ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
    }

    public String toString() {
        return "CallBackParams{sendTime=" + this.sendTime + ", alias='" + this.alias + "', pros='" + this.pros + "', tags=" + this.tags + ", tagAliasCallBack=" + this.tagAliasCallBack + ", sequence=" + this.sequence + ", protoType=" + this.protoType + ", action=" + this.action + '}';
    }
}
