package task.managementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность комментария
 */
@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Comments")
public class Comment {
    /**
     * id  комментария
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * Дата и время комментария
     */
    @Column(name="created_at")
    private long createdAt;

    /**
     * Текст комментария
     */
    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}