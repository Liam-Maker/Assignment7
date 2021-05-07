package repository;

import org.springframework.data.jpa.repository.JpaRepository;


import models.CheckingAccount;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount,Integer>{

}