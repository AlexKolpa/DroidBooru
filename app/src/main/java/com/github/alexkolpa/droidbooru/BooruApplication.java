package com.github.alexkolpa.droidbooru;

import android.app.Application;
import lombok.Getter;

public class BooruApplication extends Application {

	@Getter
	private BooruComponent booruComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		booruComponent = DaggerBooruComponent.builder()
                .booruModule(new BooruModule("https://api.github.com"))
                .build();
	}
}
