package com.joje.daisy.repository.auth;

import com.joje.daisy.model.entity.auth.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
