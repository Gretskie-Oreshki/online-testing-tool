package org.testingTool.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.testingTool.model.GuestEntity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class MyGuestDetails implements UserDetails {

  private GuestEntity guest;

  public MyGuestDetails(GuestEntity guest) {
    this.guest = guest;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public String getPassword() {
    return guest.getPassword();
  }

  @Override
  public String getUsername() {
    return String.valueOf(guest.getGuest_id());
  }

  @Override
  public boolean isAccountNonExpired() {
    return !LocalDateTime.now().isAfter(guest.getAccountExpirationDate());
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
}
