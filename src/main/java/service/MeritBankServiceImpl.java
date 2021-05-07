package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.AccountHolder;
import models.CDAccount;
import models.CDOffering;
import models.CheckingAccount;
import models.SavingsAccount;
import repository.AccountHolderRepository;
import repository.CDOfferingRepository;
@Service
public class MeritBankServiceImpl implements MeritBankService {
	@Autowired
	CDOfferingRepository cdOfferingRepository; 
	@Autowired
	AccountHolderRepository accountHolderRepository;
	
	@Override
	public void addAccountHolder(AccountHolder accountHolder) {
		accHolderList.add(accountHolder);
	}
	
	@Override
	public List<AccountHolder> getAccountHolders() {
		//AccountHolder[] accHolderArr = accHolderList.toArray(new AccountHolder[0]);
		return accHolderList;
	}
	
	@Override
	public AccountHolder getAccountHolderById(int accountHolderId) {
		return accountHolderRepository.findById(accountHolderId).orElse(null);
		//return accHolderList.get(accountHolderId - 1);
	}
	
	
	public List<CDOffering> getCDOfferings() {
		return offerings;
	}
	
	@Override
	public CDOffering getCDOfferingById(int cdOfferingId) {
		
		return cdOfferingRepository.findById(cdOfferingId).orElse(null);
	
	@Override
	public void clearCDOfferings() {
		offerings = null;
	}
	
	
	@Override
	public void setCDOfferings(List<CDOffering> offerings) {
		this.offerings = offerings; 
	}
	
	@Override
	public long getNextAccountNumber() {
		return nextAccNumber++;
	}

	@Override
	public Date getDate() {
		Date date = new Date();
		Format f = new SimpleDateFormat("dd/MM/yy");
		String strDate = f.format(date);
		date = new Date(strDate);
		return date;
	}
	
	@Override
	public double totalBalances() {
		List<AccountHolder> accountHolderArr = getAccountHolders();
		double totalBalance = 0;
		for (int i = 0; i < accountHolderArr.size(); i++) {
			totalBalance += accountHolderArr.get(i).getSavingsBalance() + accountHolderArr.get(i).getCheckingBalance()
					+ accountHolderArr.get(i).getCDBalance();
		}
		return totalBalance;
	}
	
	@Override
	public double futureValue(double presentValue, double interestRate, int term) {
		double futureVal = presentValue * Math.pow((1 + interestRate), term);
		return futureVal;
	}

	@Override
	public void setNextAccountNumber(long nextAccountNumber) {
		nextAccNumber = nextAccountNumber;
	}
	
	@Override
	public List<AccountHolder> sortAccountHolders() {
		Collections.sort(accHolderList); 
		return accHolderList; 
	}

	public ArrayList<AccountHolder> accHolderList = new ArrayList<AccountHolder>();
	private long nextAccNumber = 1;
	private List<CDOffering> offerings;

	private List<CDOffering> offeringsList = new ArrayList<>();
	
	@Override
	public void addCDOffering(CDOffering cdo) {
		offeringsList.add(cdo);
	}
	
	@Override
	public List<CDOffering> getCDOffering() {
		return offeringsList;
	}

	@Override
	public void setCDOfferings(CDOffering offerings) {
		// TODO Auto-generated method stub
		
	}
}