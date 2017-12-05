package co.rdig.swipe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;



public class SwipeAdapter extends RecyclerView.Adapter <SwipeAdapter.SwipeViewHolder> {

    Context context;

    SwipeActivity.InfoForSwipeItem info;

    Drawable drawable;

    @Override
    public SwipeAdapter.SwipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = layoutInflater.inflate(R.layout.swipe_item, parent, shouldAttachToParentImmediately);

        SwipeAdapter.SwipeViewHolder viewHolder = new SwipeViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SwipeAdapter.SwipeViewHolder holder, int position) {

        String content = info.content;
        String[] choices = info.choices;

        holder.bind(content, choices);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    void swap(SwipeActivity.InfoForSwipeItem infoForSwipeItem) {

        info = infoForSwipeItem;

        if (info != null) {
            this.notifyDataSetChanged();
        }
    }

    class SwipeViewHolder extends RecyclerView.ViewHolder {

        WebView webView;

        public SwipeViewHolder(View itemView) {
            super(itemView);

            webView = (WebView) itemView.findViewById(R.id.image_swipe_item);
        }

        public void bind(String content, String[] choices) {
            webView.loadData(content, "text/html", null);
        }
    }
}
