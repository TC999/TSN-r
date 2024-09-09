package com.bxkj.competition.signup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.R;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class StickyDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private TextPaint f19193a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f19194b;

    /* renamed from: c  reason: collision with root package name */
    private int f19195c;

    /* renamed from: d  reason: collision with root package name */
    private List<Map<String, Object>> f19196d;

    /* renamed from: e  reason: collision with root package name */
    private Context f19197e;

    /* renamed from: f  reason: collision with root package name */
    private final Resources f19198f;

    public StickyDecoration(Context context, List<Map<String, Object>> dataList) {
        this.f19196d = dataList;
        this.f19197e = context;
        Resources resources = context.getResources();
        this.f19198f = resources;
        Paint paint = new Paint();
        this.f19194b = paint;
        paint.setColor(resources.getColor(R.color.group_bg));
        TextPaint textPaint = new TextPaint();
        this.f19193a = textPaint;
        textPaint.setAntiAlias(true);
        this.f19193a.setTextSize(context.getResources().getDisplayMetrics().scaledDensity * 16.0f);
        this.f19193a.setColor(-16777216);
        this.f19195c = u.a(50.0f, context);
    }

    private boolean a(int position) {
        return position == 0 || position <= 0 || position >= this.f19196d.size() || !JsonParse.getString(this.f19196d.get(position), "groupName").equals(JsonParse.getString(this.f19196d.get(position - 1), "groupName"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        List<Map<String, Object>> list = this.f19196d;
        if (list == null || list.size() == 0) {
            return;
        }
        if (a(parent.getChildAdapterPosition(view))) {
            outRect.top = this.f19195c;
        } else {
            outRect.top = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c4, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c4, parent, state);
        List<Map<String, Object>> list = this.f19196d;
        if (list == null || list.size() == 0) {
            return;
        }
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = parent.getChildAt(i4);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            if (a(childAdapterPosition)) {
                String string = (childAdapterPosition <= 0 || childAdapterPosition >= this.f19196d.size()) ? "" : JsonParse.getString(this.f19196d.get(childAdapterPosition), "groupName");
                int top2 = childAt.getTop() - this.f19195c;
                int top3 = childAt.getTop();
                this.f19194b.setColor(this.f19197e.getResources().getColor(R.color.colorAccent));
                c4.drawRect(paddingLeft, top2, width, top3, this.f19194b);
                this.f19194b.setColor(this.f19198f.getColor(R.color.group_bg));
                Rect rect = new Rect(u.a(5.0f, this.f19197e) + paddingLeft, top2, width, top3);
                c4.drawRect(rect, this.f19194b);
                Paint.FontMetricsInt fontMetricsInt = this.f19193a.getFontMetricsInt();
                c4.drawText(string, paddingLeft + 30, (((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.f19193a);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c4, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c4, parent, state);
        List<Map<String, Object>> list = this.f19196d;
        if (list == null || list.size() == 0) {
            return;
        }
        int findFirstVisibleItemPosition = ((LinearLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        String string = JsonParse.getString(this.f19196d.get(findFirstVisibleItemPosition), "groupName");
        this.f19194b.setColor(this.f19197e.getResources().getColor(R.color.colorAccent));
        c4.drawRect(paddingLeft, 0.0f, width, this.f19195c, this.f19194b);
        this.f19194b.setColor(this.f19198f.getColor(R.color.group_bg));
        Rect rect = new Rect(paddingLeft + u.a(5.0f, this.f19197e), 0, width, this.f19195c);
        c4.drawRect(rect, this.f19194b);
        Paint.FontMetricsInt fontMetricsInt = this.f19193a.getFontMetricsInt();
        c4.drawText(string, 30.0f, (((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.f19193a);
    }
}
