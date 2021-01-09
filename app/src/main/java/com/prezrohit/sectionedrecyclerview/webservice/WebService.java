package com.prezrohit.sectionedrecyclerview.webservice;

import com.prezrohit.sectionedrecyclerview.dto.TopHeadline;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {

	@GET("top-headlines?language=en")
	Call<TopHeadline> getTopHeadlines(@Query("pageSize") String noOfResults, @Query("apiKey") String apiKey);

}
