package model;

import java.util.ArrayList;

public class MemberHandler {
	private ArrayList<Member> MemberList;
	private int NumOfMember;
	
	public MemberHandler() {
		this.MemberList = new ArrayList<Member>();
		this.NumOfMember = 0;
	}
	
	public void PrintMemberList() {
		int Index = 1;
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
			this.NumOfMember++;
			return true;
		}
		return false;
	}

	// TargetIndex is 1 ~ this.NumOfMember.
	// TempMember is data to be modified.
	public boolean ModifyMember(int TargetIndex, Member TempMember) {
		if (TargetIndex > 0 && TargetIndex <= this.NumOfMember) {
			Member TargetMember = MemberList.get(TargetIndex);
			TargetMember.initMember(TargetMember.getOriginNo(), TempMember.getName(), TempMember.getAge(), TempMember.getPhone(), TempMember.getAddress());
			return true;
		}
		
		return false;
	}
	
	// TargetIndex is 1 ~ this.NumOfMember.
	public boolean DeleteMember(int TargetIndex) {
		if (TargetIndex > 0 && TargetIndex <= this.NumOfMember) {
			MemberList.remove(TargetIndex);
			this.NumOfMember--;
			return true;
		}
		return false;
	}
	
	public void ALLDeleteMember() {
		for (Member CurrentMember : MemberList) {
			MemberList.remove(CurrentMember);
		}
	}
}
