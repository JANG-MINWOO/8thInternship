package com.sparta.internship.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;

	private String nickname;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	private User(String username, String password, String nickname, UserRole userRole) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.userRole = userRole;
	}

	public static User createOf(String username, String password, String nickname, UserRole userRole) {
		return new User(username, password, nickname, userRole);
	}
}
