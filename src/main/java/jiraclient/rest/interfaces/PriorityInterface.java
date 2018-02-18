package jiraclient.rest.interfaces;

import jiraclient.Priority;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;


public interface PriorityInterface {
    @GET("priority")
    Call<List<Priority>> getPriorities();
}
