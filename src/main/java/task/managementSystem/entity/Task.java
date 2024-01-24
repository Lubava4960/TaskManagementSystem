package task.managementSystem.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Сущность задачи.
 */
@Entity
@Data
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Task")

public class Task {
    /**
     * Id задачи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

    private int id;

    /**
     * Заголовок задачи
     */
    @Column(name="title")
    private String title;
    /**
     * Описание задачи
     */
    @Column(name="description")
    private String description;

    @Getter
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
