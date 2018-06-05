package com.jojonarte.ournews.data;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NewsService {
    @GET("/v2/top-headlines?country=ph&apiKey=61cda85510504e58b8715c5e001c8eb2")
    Single<NewsApiResponse> getNews();
}
