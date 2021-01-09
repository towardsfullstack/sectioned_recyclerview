package com.prezrohit.sectionedrecyclerview.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prezrohit.sectionedrecyclerview.R;
import com.prezrohit.sectionedrecyclerview.adapter.NewsAdapter;
import com.prezrohit.sectionedrecyclerview.dto.Article;
import com.prezrohit.sectionedrecyclerview.dto.TopHeadline;
import com.prezrohit.sectionedrecyclerview.model.News;
import com.prezrohit.sectionedrecyclerview.util.Helper;
import com.prezrohit.sectionedrecyclerview.webservice.WebService;
import com.prezrohit.sectionedrecyclerview.webservice.WebServiceClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	private RecyclerView rvNews;
	private ProgressBar progressBar;

	private List<News> newsList;

	private NewsAdapter adapter;

	private Map<String, List<Article>> sourceNewsMap;

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
		getNews();
	}

	private void init() {
		newsList = new ArrayList<>();
		sourceNewsMap = new HashMap<>();
		rvNews = findViewById(R.id.rv_news);
		progressBar = findViewById(R.id.progress_bar);
	}

	private void setRecyclerView() {
		rvNews.setLayoutManager(new LinearLayoutManager(this));
		rvNews.setAdapter(adapter);
	}

	private void getNews() {
		WebService webService = WebServiceClient.getClient().create(WebService.class);
		Call<TopHeadline> call = webService.getTopHeadlines("100", Helper.API_KEY);
		call.enqueue(new Callback<TopHeadline>() {
			@Override
			public void onResponse(Call<TopHeadline> call, Response<TopHeadline> response) {
				progressBar.setVisibility(View.GONE);
				Log.d(TAG, "onResponse: " + response.code());
				assert response.body() != null : "Response Body Empty";
				for (Article article : response.body().getArticleList()) {
					String sourceId = article.getSource().getId();
					if (sourceId != null && !sourceId.equals("null") && !sourceId.equals("")) {
						List<Article> value = sourceNewsMap.get(sourceId);
						if (value == null) value = new ArrayList<>();

						value.add(article);
						sourceNewsMap.put(sourceId, value);
					}
				}

				for (Map.Entry<String, List<Article>> entry : sourceNewsMap.entrySet()) {
					if (entry.getValue().size() > 4)
						newsList.add(new News(entry.getValue().get(0).getSource().getName(), entry.getValue()));
				}

				adapter = new NewsAdapter(MainActivity.this, newsList);
				setRecyclerView();
			}

			@Override
			public void onFailure(Call<TopHeadline> call, Throwable t) {
				Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
				progressBar.setVisibility(View.GONE);
			}
		});
	}
}