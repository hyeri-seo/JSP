package service;

import java.util.List;

import dao.AccountDAO;
import dto.Account;

public class AccountService {
	private AccountDAO dao = new AccountDAO();
	
	public void makeAccount(Account acc) throws Exception {
		Account sacc = dao.selectAccount(acc.getId());
		if(sacc!=null) throw new Exception("계좌번호가 중복됩니다.");
		dao.insertAccount(acc);
	}
	
	public Account accountInfo(String id) throws Exception {
		Account sacc = dao.selectAccount(id);
		if(sacc==null) throw new Exception("계좌가 존재하지 않습니다.");
		return sacc;
	}
	
	public List<Account> allAccountInfo() {
	    // AccountDAO 클래스에서 모든 계좌 정보를 가져오는 메소드를 호출
	    List<Account> accs = dao.selectAllAccounts();
	    return accs;
	}

	
	public Account deposit(String id, Integer money) throws Exception {
	    // 1. 해당 ID로 계좌 정보를 조회
	    Account sacc = dao.selectAccount(id);

	    if (sacc == null) {
	        throw new Exception("계좌가 존재하지 않습니다.");
	    }

	    // 2. 조회된 계좌 정보에 돈을 입금
	    sacc.setBalance(sacc.getBalance() + money);

	    // 3. 업데이트된 계좌 정보를 데이터베이스에 저장
	    dao.updateAccount(sacc);

	    // 4. 업데이트된 계좌 정보를 반환
	    return sacc;
	}
	
	public Account withdraw(String id, Integer money) throws Exception {
	    // 1. 해당 ID로 계좌 정보를 조회
	    Account sacc = dao.selectAccount(id);

	    if (sacc == null) {
	        throw new Exception("계좌가 존재하지 않습니다.");
	    }

	    // 2. 조회된 계좌 정보에 돈을 입금
	    sacc.setBalance(sacc.getBalance() - money);

	    // 3. 업데이트된 계좌 정보를 데이터베이스에 저장
	    dao.updateAccount(sacc);

	    // 4. 업데이트된 계좌 정보를 반환
	    return sacc;
	}

} 
