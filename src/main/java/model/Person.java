package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NonNull
    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "maiden_name")
    protected String maidenName;

    @NonNull
    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne
    @JoinColumn (name = "mother_id")
    private Person mother;


    @ManyToOne
    @JoinColumn (name = "father_id")
    private Person father;
}
