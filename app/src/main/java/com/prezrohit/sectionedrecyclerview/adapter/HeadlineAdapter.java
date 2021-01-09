package com.prezrohit.sectionedrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prezrohit.sectionedrecyclerview.R;
import com.prezrohit.sectionedrecyclerview.adapter.ui.HeadlineViewHolder;
import com.prezrohit.sectionedrecyclerview.dto.Article;
import com.prezrohit.sectionedrecyclerview.util.DateTimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HeadlineAdapter extends RecyclerView.Adapter<HeadlineViewHolder> {

	private final Context context;
	private final List<Article> articleList;

	private static final String TAG = "HeadlineAdapter";

	public HeadlineAdapter(Context context, List<Article> articleList) {
		this.context = context;
		this.articleList = articleList;
	}

	@NonNull
	@Override
	public HeadlineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.row_headline, parent, false);
		return new HeadlineViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull HeadlineViewHolder holder, int position) {
		Article article = articleList.get(position);
		holder.setSourceName(article.getSource().getName());
		holder.setTitle(article.getTitle());
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(article.getPublishedAt());
			holder.setDate(DateTimeUtil.getDate(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		holder.setThumbnail(context, article.getUrlToImage());
	}

	@Override
	public int getItemCount() {
		return articleList == null ? 0 : articleList.size();
	}
}
