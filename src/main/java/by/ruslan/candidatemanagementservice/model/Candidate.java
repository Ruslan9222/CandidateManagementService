package by.ruslan.candidatemanagementservice.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "db_candidate")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String description;
    private String cv;
    @Lob
    private String photo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Direction> directions;




}
