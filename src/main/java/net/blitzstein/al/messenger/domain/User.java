package net.blitzstein.al.messenger.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	private Integer id;
	private String username;
	private Timestamp insertedAt, updatedAt;
	private List<Message> messages;
    private List<User> subscriptions;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "subscriptions",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="subscriber_id"))
    public List<User> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<User> subscriptions) {
        this.subscriptions = subscriptions;
    }

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
	@OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
	@OrderBy("updatedAt")
    public List<Message> getMessages() {
        return messages;
    }

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "inserted_at", nullable = false)
	public Timestamp getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(Timestamp insertedAt) {
		this.insertedAt = insertedAt;
	}

	@Column(name = "updated_at", nullable = false)
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}
