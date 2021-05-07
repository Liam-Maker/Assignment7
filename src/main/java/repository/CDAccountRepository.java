package repository;

import org.springframework.data.jpa.repository.JpaRepository;


import models.CDAccount;

public interface CDAccountRepository extends JpaRepository<CDAccount,Integer>{

}