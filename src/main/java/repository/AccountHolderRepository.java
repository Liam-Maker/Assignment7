package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.AccountHolder;


public interface AccountHolderRepository extends JpaRepository<AccountHolder,Integer> {

}