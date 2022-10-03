package teacher;

import java.util.Vector;


import kelas.kelas;
public class teacher {
	private String teacherName;
	private String teacherStatus;
	private int teacherYear;
	private int teacherSalary;
	private Vector<kelas> kelasVec;
	
	public teacher(String teacherName, String teacherStatus, int teacherYear, int teacherSalary)
	{
		this.teacherName=teacherName;
		this.teacherStatus=teacherStatus;
		this.teacherYear=teacherYear;
		this.teacherSalary=teacherSalary;
		kelasVec = new Vector<kelas>();
	}
	public void addKelas(String kelasName, int kelasNumber)
	{
		kelasVec.addElement(new kelas(kelasName, kelasNumber));
	}
	public int noKelas(Vector<kelas> kelasVec)
	{
		if(kelasVec.isEmpty())
		{
			return 0;
		}
		return 1;
	}
	
	public void viewKelas()
	{
		int sum=0;
		int sum2=0;
		if(kelasVec.isEmpty())
		{
			System.out.println("No class inserted yet!");
		}
		int idx=0;
		for(kelas Kelas: kelasVec)
		{
			System.out.println("Total Students: "+Kelas.getKelasNumber());
			sum +=Kelas.getKelasNumber();
			if(this.teacherStatus.equals("Part-time"))
			{
				sum2 = sum*15000;
			}
			if(this.teacherStatus.equals("Full-time"))
			{
				if(this.teacherYear <2)
				{
					sum2 = sum*30000;
				}
				if(this.teacherYear>=2)
				{
					sum2 = sum*40000;
				}
			}
			System.out.println("Total Salary: " + sum2);
		}
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherStatus() {
		return teacherStatus;
	}
	public void setTeacherStatus(String teacherStatus) {
		this.teacherStatus = teacherStatus;
	}
	public int getTeacherYear() {
		return teacherYear;
	}
	public void setTeacherYear(int teacherYear) {
		this.teacherYear = teacherYear;
	}
	public int getTeacherSalary() {
		return teacherSalary;
	}
	public void setTeacherSalary(int teacherSalary) {
		this.teacherSalary = teacherSalary;
	}
	
}
