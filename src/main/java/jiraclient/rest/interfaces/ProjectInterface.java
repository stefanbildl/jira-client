package jiraclient.rest.interfaces;


import jiraclient.Project;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ProjectInterface {
    @GET("project")
    Call<List<Project>> getProjects();

    @GET("project/{key}")
    Call<Project> getProjectByKey(@Path("key") String key);
}
