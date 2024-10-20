package com.grpc.accounts.repository;

import com.grpc.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    /**
     *
     * @param customerId
     * @return Optional of Accounts
     */
    Optional<Accounts> findByCustomerId(Long customerId);

    /**
     *
     * @param customerId
     */
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
