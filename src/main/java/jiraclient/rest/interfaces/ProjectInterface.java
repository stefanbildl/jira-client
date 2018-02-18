package jiraclient.rest.interfaces;


import jiraclient.Project;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ProjectInterface {
    @GET("project")
    Call<List<Project>> getProjects();
}
