package jiraclient;

import jiraclient.rest.interfaces.ProjectInterface;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class Project {
    private String expand, self, key, name, projectTypeKey;
    private int id;
    private TreeMap<String, String> avatarUrls;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectTypeKey() {
        return projectTypeKey;
    }

    public void setProjectTypeKey(String projectTypeKey) {
        this.projectTypeKey = projectTypeKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TreeMap<String, String> getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(TreeMap<String, String> avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    @Override
    public String toString() {
        return "Project{" +
                "expand='" + expand + '\'' +
                ", self='" + self + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", projectTypeKey='" + projectTypeKey + '\'' +
                ", id=" + id +
                ", avatarUrls=" + avatarUrls +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return id == project.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public static List<Project> getAllProjects(JiraClient client) throws IOException {
        Response<List<Project>> response = client.projectInterface.getProjects().execute();
        if(response.isSuccessful())
            return response.body();
        throw new IOException(response.errorBody().string());
    }
}
