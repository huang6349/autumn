package org.autumn.repository;

import org.autumn.domain.ValidateCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidateCodeRepository extends JpaRepository<ValidateCode, Long> {

    ValidateCode findByClientId(String clientId);
}
