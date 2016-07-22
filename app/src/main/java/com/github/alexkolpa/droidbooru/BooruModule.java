package com.github.alexkolpa.droidbooru;

import javax.inject.Singleton;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class BooruModule {

	String baseUrl;

	public BooruModule(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@Provides
	@Singleton
	Gson provideGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		return gsonBuilder.create();
	}

	@Provides
	@Singleton
	Retrofit provideRetrofit(Gson gson) {
		return new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create(gson))
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.baseUrl(baseUrl)
				.build();
	}

	@Provides
	@Singleton
	BooruApi providesBooruApi(Retrofit retrofit) {
		return retrofit.create(BooruApi.class);
	}
}
