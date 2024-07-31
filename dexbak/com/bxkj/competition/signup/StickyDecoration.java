package com.bxkj.competition.signup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.C4017R;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StickyDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private TextPaint f15663a;

    /* renamed from: b */
    private Paint f15664b;

    /* renamed from: c */
    private int f15665c;

    /* renamed from: d */
    private List<Map<String, Object>> f15666d;

    /* renamed from: e */
    private Context f15667e;

    /* renamed from: f */
    private final Resources f15668f;

    public StickyDecoration(Context context, List<Map<String, Object>> dataList) {
        this.f15666d = dataList;
        this.f15667e = context;
        Resources resources = context.getResources();
        this.f15668f = resources;
        Paint paint = new Paint();
        this.f15664b = paint;
        paint.setColor(resources.getColor(C4017R.C4019color.group_bg));
        TextPaint textPaint = new TextPaint();
        this.f15663a = textPaint;
        textPaint.setAntiAlias(true);
        this.f15663a.setTextSize(context.getResources().getDisplayMetrics().scaledDensity * 16.0f);
        this.f15663a.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f15665c = Tools.m57620a(50.0f, context);
    }

    /* renamed from: a */
    private boolean m43161a(int position) {
        return position == 0 || position <= 0 || position >= this.f15666d.size() || !JsonParse.getString(this.f15666d.get(position), "groupName").equals(JsonParse.getString(this.f15666d.get(position - 1), "groupName"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        List<Map<String, Object>> list = this.f15666d;
        if (list == null || list.size() == 0) {
            return;
        }
        if (m43161a(parent.getChildAdapterPosition(view))) {
            outRect.top = this.f15665c;
        } else {
            outRect.top = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        List<Map<String, Object>> list = this.f15666d;
        if (list == null || list.size() == 0) {
            return;
        }
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            if (m43161a(childAdapterPosition)) {
                String string = (childAdapterPosition <= 0 || childAdapterPosition >= this.f15666d.size()) ? "" : JsonParse.getString(this.f15666d.get(childAdapterPosition), "groupName");
                int top2 = childAt.getTop() - this.f15665c;
                int top3 = childAt.getTop();
                this.f15664b.setColor(this.f15667e.getResources().getColor(C4017R.C4019color.colorAccent));
                c.drawRect(paddingLeft, top2, width, top3, this.f15664b);
                this.f15664b.setColor(this.f15668f.getColor(C4017R.C4019color.group_bg));
                Rect rect = new Rect(Tools.m57620a(5.0f, this.f15667e) + paddingLeft, top2, width, top3);
                c.drawRect(rect, this.f15664b);
                Paint.FontMetricsInt fontMetricsInt = this.f15663a.getFontMetricsInt();
                c.drawText(string, paddingLeft + 30, (((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.f15663a);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        List<Map<String, Object>> list = this.f15666d;
        if (list == null || list.size() == 0) {
            return;
        }
        int findFirstVisibleItemPosition = ((LinearLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        String string = JsonParse.getString(this.f15666d.get(findFirstVisibleItemPosition), "groupName");
        this.f15664b.setColor(this.f15667e.getResources().getColor(C4017R.C4019color.colorAccent));
        c.drawRect(paddingLeft, 0.0f, width, this.f15665c, this.f15664b);
        this.f15664b.setColor(this.f15668f.getColor(C4017R.C4019color.group_bg));
        Rect rect = new Rect(paddingLeft + Tools.m57620a(5.0f, this.f15667e), 0, width, this.f15665c);
        c.drawRect(rect, this.f15664b);
        Paint.FontMetricsInt fontMetricsInt = this.f15663a.getFontMetricsInt();
        c.drawText(string, 30.0f, (((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.f15663a);
    }
}
