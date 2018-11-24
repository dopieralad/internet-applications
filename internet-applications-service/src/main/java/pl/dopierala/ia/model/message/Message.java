package pl.dopierala.ia.model.message;

import java.util.Set;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import pl.dopierala.ia.model.person.user.User;

/**
 * JPA {@link Entity} representing a {@link Message}
 * sent by a specific sender {@link User} to
 * a group of recipient {@link User Users}.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String body;
    @ManyToOne
    private User sender;
    @ManyToMany
    private Set<User> recipients;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Set<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<User> recipients) {
        this.recipients = recipients;
    }
}
