package jiraclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jiraclient.rest.interfaces.PriorityInterface;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Priority {
    private String statusColor, description, name, self, iconUrl;
    private int id;

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "statusColor='" + statusColor + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority = (Priority) o;
        return id == priority.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getIconUrl() {
        return iconUrl;
    }


    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public static List<Priority> getPriorityLevels(JiraClient client) throws IOException {
        Response<List<Priority>> response = client.priorityInterface.getPriorities().execute();
        if(response.isSuccessful())
            return response.body();
        throw new IOException(response.errorBody().string());
    }

    public static Priority getPriority(JiraClient client, int id) throws IOException {
        Response<Priority> response = client.priorityInterface.getPriority(id).execute();
        if(response.isSuccessful())
            return response.body();
        throw new IOException(response.errorBody().string());
    }

    public static final int HIGHEST = 1;
    public static final int HIGH = 2;
    public static final int MEDIUM = 3;
    public static final int LOW = 4;
    public static final int LOWEST = 5;
}


