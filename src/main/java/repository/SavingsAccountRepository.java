package repository;

import org.springframework.data.jpa.repository.JpaRepository;


import models.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount,Integer>{

}