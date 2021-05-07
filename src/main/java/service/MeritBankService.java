package service;

import java.util.Date;
import java.util.List;

import models.AccountHolder;
import models.CDOffering;

public interface MeritBankService {
	
		public void addAccountHolder(AccountHolder accountHolder);
	
		public List<AccountHolder> getAccountHolders();
	
		public AccountHolder getAccountHolderById(int accountHolderId);
	
		public List<CDOffering> getCDOfferings();
	
		public CDOffering getCDOfferingById(int cdOfferingId);

		public void clearCDOfferings();
	
		public void setCDOfferings(CDOffering offerings);
	
		public long getNextAccountNumber();
	
		public Date getDate();
	
		public double totalBalances();
	
		public double futureValue(double presentValue, double interestRate, int term);
	
		public void setNextAccountNumber(long nextAccountNumber);
	
		public List<AccountHolder> sortAccountHolders();
	
		public List<CDOffering> getCDOffering();
	
		public void addCDOffering(CDOffering cdo);
	
		void setCDOfferings(List<CDOffering> cdo);
}
© 2021 GitHub, Inc.