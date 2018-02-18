package jiraclient.rest;

import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BasicAuthRetrofitProvider implements RetrofitProvider {

    private final String password;
    private final String baseUrl;
    private final String user;

    public BasicAuthRetrofitProvider(String baseUrl, String user, String password) {
        this.baseUrl = baseUrl;
        this.user = user;
        this.password = password;
    }

    @Override
    public Retrofit getRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(user, password))
                .build();

        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(client)
                .build();
    }
}
