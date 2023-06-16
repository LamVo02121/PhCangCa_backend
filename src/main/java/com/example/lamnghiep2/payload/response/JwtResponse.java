package com.example.lamnghiep2.payload.response;

public class JwtResponse {
  private String accessToken;
  private String tokenType = "Bearer";
  private Integer id;
  private String username;


  public JwtResponse(String accessToken, Integer id, String username) {
    this.accessToken = accessToken;
    this.id = id;
    this.username = username;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
