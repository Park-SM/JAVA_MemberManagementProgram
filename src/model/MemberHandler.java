package model;

import java.util.ArrayList;

import memberDA.MemberDAO;

public class MemberHandler {
	public MemberDAO MemDAO;
	private ArrayList<Member> MemberList;
	private int NumOfMember;
	
	public MemberHandler() {
		this.MemDAO = new MemberDAO("smparkworld.com", "61655", "parksapp", "park#godqhr1!");
		this.MemberList = new ArrayList<Member>();
		this.NumOfMember = this.MemDAO.LoadDatabase(this.MemberList);
	}
	
	public int getNumOfMember() {
		return this.NumOfMember;
	}
	
	public void PrintMemberList() {
		int Index = 1;
		this.NumOfMember = this.MemDAO.LoadDatabase(this.MemberList);
		if (this.NumOfMember > 0) {
			for(Member CurrentMember : MemberList) {
				System.out.print(">> No." + Index++);
				CurrentMember.PrintInfo();
			}
		} else System.out.println(">> No data..");
	}
	
	public boolean CreateMember(Member TempMember) {
		if (TempMember.getName().length() < 16 && TempMember.getPhone().length() < 12 && TempMember.getAddress().length() < 128) {
			Member NewMember = new Member();
			NewMember.initMember(0, TempMember.getName(), TempMember.getAge(), TempMember.getPhone(), TempMember.getAddress());
			MemberList.add(NewMember);
			this.MemDAO.InsertMember(TempMember.getName(), TempMember.getAge(), TempMember.getPhone(), TempMember.getAddress());
			this.NumOfMember = this.MemDAO.LoadDatabase(MemberList);
			return true;
		}
		
		return false;
	}

	// TargetIndex is 1 ~ this.NumOfMember.
	// TempMember is data to be modified.
	public boolean ModifyMember(int TargetIndex, Member TempMember) {
		if (TargetIndex > 0 && TargetIndex <= this.NumOfMember) {
			Member TargetMember = MemberList.get(TargetIndex - 1);	// Have to -1, because ArrayList's entry index is 0.
			TargetMember.initMember(TargetMember.getOriginNo(), TempMember.getName(), TempMember.getAge(), TempMember.getPhone(), TempMember.getAddress());
			
			this.MemDAO.LoadDatabase(MemberList);
			return true;
		}
		
		return false;
	}
	
	// TargetIndex is 1 ~ this.NumOfMember.
	public boolean DeleteMember(int TargetIndex) {
		if (TargetIndex > 0 && TargetIndex <= this.NumOfMember) {
			MemberList.remove(TargetIndex - 1);	// Have to -1, because ArrayList's entry index is 0.
			this.NumOfMember = this.MemDAO.LoadDatabase(MemberList);
			return true;
		}
		return false;
	}
	
	public void ALLDeleteMember() {
		this.MemberList.clear();
		this.NumOfMember = 0;
	}
}
