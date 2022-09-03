package by.tms.hackathonserver.dto.response;

import by.tms.hackathonserver.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProductResponse {
    private long id;

    private String title;

    private String description;

    private String creatorUsername;

    private String location;

    private String category;

    private long price;

    private String namePicture;

    private String dateCreating;

    private User user;
}
