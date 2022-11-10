package com.joje.daisy.repository.auth;

import com.joje.daisy.model.entity.auth.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, String> {
}
