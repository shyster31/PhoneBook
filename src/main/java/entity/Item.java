package entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

@Entity
@Table(name = "phone_book_items")
public class Item {

    @Id
    private final String id = UUID.randomUUID().toString();
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String patronymic;
    private String login;
    private String phone;
    @Column(name = "home_phone")
    private String homePhone;
    private String adress;
    private String email;
}
