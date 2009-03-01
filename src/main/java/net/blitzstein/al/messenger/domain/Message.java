package net.blitzstein.al.messenger.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	private Integer id;
	private String content;
	private Timestamp insertedAt, updatedAt;
	public void setUser(User user) {
		this.user = user;
	}

	private User user;

	@Column(name = "inserted_at", nullable = false)
	public Timestamp getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(Timestamp insertedAt) {
		this.insertedAt = insertedAt;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	public User getUser() {
		return user;
	}

	@Column(name = "updated_at", nullable = false)
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
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

	@Column(name = "content", nullable = false, length = 400)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
