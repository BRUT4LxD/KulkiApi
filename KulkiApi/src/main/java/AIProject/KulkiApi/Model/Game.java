package AIProject.KulkiApi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Game")
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;

    @Column(name = "result", nullable = false)
    private int result;

    @Column(name="time")
    private Integer time;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false, updatable = false)
    @CreatedDate
    private Date date;
}
