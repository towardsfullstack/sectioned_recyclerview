package com.prezrohit.sectionedrecyclerview.webservice;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceClient {

	public static Retrofit getClient() {

		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor()
				.setLevel(HttpLoggingInterceptor.Level.BODY)).build();

		return new Retrofit.Builder()
				.baseUrl("http://newsapi.org/v2/")
				.addConverterFactory(GsonConverterFactory.create())
				.client(client)
				.build();
	}

}
