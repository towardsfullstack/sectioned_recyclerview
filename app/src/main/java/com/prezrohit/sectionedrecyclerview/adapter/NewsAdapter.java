package com.prezrohit.sectionedrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prezrohit.sectionedrecyclerview.R;
import com.prezrohit.sectionedrecyclerview.adapter.ui.NewsViewHolder;
import com.prezrohit.sectionedrecyclerview.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

	private final Context context;
	private final List<News> sourceList;

	public NewsAdapter(Context context, List<News> sourceList) {
		this.context = context;
		this.sourceList = sourceList;
	}

	@NonNull
	@Override
	public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.row_news, parent, false);
		return new NewsViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
		News news = sourceList.get(position);
		holder.setSourceName(news.getSourceName());
		HeadlineAdapter adapter = new HeadlineAdapter(context, news.getArticleList());
		holder.setupRecyclerView(context, adapter);
	}

	@Override
	public int getItemCount() {
		return sourceList == null ? 0 : sourceList.size();
	}
}
