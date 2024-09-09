package com.bxkj.base.chat;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ReportChatActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J(\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/base/chat/ReportChatActivity$initData$1", "Lcn/bluemobi/dylan/base/adapter/common/recyclerview/CommonAdapter;", "", "", "", "Lcn/bluemobi/dylan/base/adapter/common/ViewHolder;", "holder", "stringObjectMap", "Lkotlin/f1;", "n", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class ReportChatActivity$initData$1 extends CommonAdapter<Map<String, Object>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ReportChatActivity$initData$1(Context context, int i4, List<? extends Map<String, Object>> list) {
        super(context, i4, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Map map, CompoundButton compoundButton, boolean z3) {
        if (map == null) {
            return;
        }
        map.put("isChecked", Boolean.valueOf(z3));
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: n */
    public void c(@Nullable ViewHolder viewHolder, @Nullable final Map<String, Object> map) {
        CheckBox checkBox;
        if (viewHolder != null) {
            viewHolder.s(R.id.iv_head, JsonParse.getString(map, "photo"));
        }
        if (viewHolder != null) {
            viewHolder.J(R.id.tv_msg, JsonParse.getString(map, "msg"));
        }
        if (viewHolder != null) {
            viewHolder.J(R.id.tv_user, JsonParse.getString(map, "userName"));
        }
        if (viewHolder != null) {
            viewHolder.J(R.id.tv_date, JsonParse.getString(map, "createTime"));
        }
        if (viewHolder == null || (checkBox = (CheckBox) viewHolder.h(R.id.cb)) == null) {
            return;
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.base.chat.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                ReportChatActivity$initData$1.o(map, compoundButton, z3);
            }
        });
    }
}
