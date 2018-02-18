package jiraclient.rest.interfaces;

import jiraclient.Priority;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;


public interface PriorityInterface {
    @GET("priority")
    Call<List<Priority>> getPriorities();

    @GET("priority/{id}")
    Call<Priority> getPriority(@Path("id") int id);
}
