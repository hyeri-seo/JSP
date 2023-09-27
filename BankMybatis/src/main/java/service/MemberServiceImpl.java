package service;

import bean.Member;
import dao.MemberDAO;
import dao.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDAOImpl();
	}

	@Override
	public Member login(String id, String password) throws Exception {
		Member member = memberDao.selectMember(id);
		if(member==null) throw new Exception("회원이 존재하지 않습니다.");
		if(!(member.getPassword().equals(password))) throw new Exception("비밀번호가 틀립니다.");
		return member;
	}

	@Override
	public void join(Member member) throws Exception {
		memberDao.insertMember(member);
	}
}
