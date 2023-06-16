package com.example.lamnghiep2.service;

import com.example.lamnghiep2.model.LN_Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "LN_Account")
public class UserDetailsImpl implements UserDetails {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "username",unique = true, nullable = false, length = 50)
  private String username;

  @Column(name = "email",unique = true, nullable = false, length = 50)
  private String email;

  @Column(name = "firstname", nullable = false, length = 25)
  private String firstname;

  @Column(name = "lastname", nullable = false, length = 25)
  private String lastname;

  @Column(name = "password", nullable = false, length = 30)
  private String password;


  @JsonIgnore
  @Transient
  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl() {
  }

  public UserDetailsImpl(int id, String username, String email, String firstname,
                         String lastname, String password, Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(LN_Account taiKhoan) {
    List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

    return new UserDetailsImpl(
            taiKhoan.getId(),
            taiKhoan.getUsername(),
            taiKhoan.getEmail(),
            taiKhoan.getFirstname(),
            taiKhoan.getLastname(),
            taiKhoan.getPassword(),
            authorities);
  }


  public int getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
