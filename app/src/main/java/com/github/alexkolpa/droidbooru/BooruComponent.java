package com.github.alexkolpa.droidbooru;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={BooruModule.class})
public interface BooruComponent {
	void inject(MainActivity activity);
}
