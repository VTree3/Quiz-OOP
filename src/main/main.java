package main;
import java.util.Scanner;
import java.util.Random;
import teacher.teacher;
import kelas.kelas;
import java.util.Vector;
public class main {
	Scanner scan = new Scanner(System.in);
	Vector<teacher> teacherVec = new Vector<teacher>();
	Vector<kelas> kelasVec = new Vector<kelas>();
	Random rand = new Random();
	
	void addTeacher(Vector<teacher> teacherVec)
	{
		String newTeacherName;
		String newTeacherStatus;
		int newTeacherYear;
		int errFlag=0;
		do
		{
			System.out.println("Input teacher's name [Min 2 Words]: ");
			newTeacherName = scan.nextLine();
		}while(!newTeacherName.contains(" "));
		do
		{
			System.out.println("Input teacher's status [Part-time|Full-time]: ");
			newTeacherStatus = scan.nextLine();
		}while(!newTeacherStatus.equals("Part-time") && !newTeacherStatus.equals("Full-time"));
		do
		{
			System.out.println("Input how long has the teacher teached[At least 1 year]:");
			try {
				newTeacherYear = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				newTeacherYear = 0;
				scan.nextLine();
			}
		}while(newTeacherYear<1);
		System.out.println("Data inserted!");
		teacher currTeacher = new teacher(newTeacherName, newTeacherStatus, newTeacherYear, 0);
		teacherVec.addElement(currTeacher);
	}
	
	void viewTeacher(Vector<teacher> teacherVec)
	{
		if(teacherVec.isEmpty())
		{
			System.out.println("No teacher yet!");
		}
		int indx=1;
		for(teacher Teacher: teacherVec)
		{
			if(Teacher.noKelas(kelasVec) == 0)
			{
				System.out.println("No class yet!");
			}
			System.out.println(indx + ". Name: "+Teacher.getTeacherName());
			System.out.println("Teacher year: " +Teacher.getTeacherYear());
			System.out.println("Teacher status: "+Teacher.getTeacherStatus());
			Teacher.viewKelas();
			indx++;
			
		}
	}
	
	void addKelas2(Vector<kelas> kelasVec, teacher currTeacher, int indx)
	{
		int menu3;
		viewTeacher(teacherVec);
		do
		{
			System.out.printf("Please insert the teacher you want to add class [1 - %d]\n", teacherVec.size());
			try {
				menu3 = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				menu3 = 0;
				scan.nextLine();
			}
		}while(menu3<1 || menu3>teacherVec.size());
//		if(indx == menu3)
//		{
			String newKelasName;
			int newKelasNumber;
			newKelasNumber = rand.nextInt(15, 31);
			do
			{
				System.out.println("Input class name[length 5-20]: ");
				newKelasName = scan.nextLine();
			}while(newKelasName.length()<5 || newKelasName.length()>20);
			currTeacher.addKelas(newKelasName, newKelasNumber);
			
//		}
		
		
	}
	
	void add(Vector<teacher>teacherVec, Vector<kelas>kelasVec)
	{
		String newTeacherName;
		String newTeacherStatus;
		int indx=0;
		int newTeacherYear;
		int errFlag=0;
		int menu2=0;
		teacher currTeacher = new teacher("", "", 0, 0);
		do {
			if(errFlag==1)
			{
				System.out.println("1 and 2 Only!");
			}
			System.out.println("1. Add Teacher");
			System.out.println("2. Add Class");
			try {
				menu2 = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				menu2 = 0;
				scan.nextLine();
			}
			errFlag=1;
		}while(menu2<1 || menu2>2);
		errFlag=0;
		switch(menu2)
		{
		case 1:{
			addTeacher(teacherVec);
		}
		break;
		case 2:{
			addKelas2(kelasVec, currTeacher, indx);
		}
		break;
		
		}
	}
	
	public void deleteTeacher(Vector<teacher>teacherVec)
	{
		int delete;
		do
		{
			System.out.println("Pick the teacher to be deleted.");
			try {
				delete = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				delete = 0;
				scan.nextLine();
			}
		}while(delete<1 || delete>teacherVec.size());
		System.out.println("delete successful!");
		teacherVec.remove(delete-1);
	}
	
	
	public main()
	{
		int errFlag=0;
		int menu;
		do {
			errFlag=0;
			do{
				if(errFlag==1)
				{
					System.out.println("Error! Input number between 1 and 4!");
				}
				System.out.println("==============");
				System.out.println("   Teach Me!  ");
				System.out.println("==============");
				System.out.println("1. View");
				System.out.println("2. Add");
				System.out.println("3. Delete");
				System.out.println("4. Exit");
				System.out.println(">> ");
				try {
					menu = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					menu = 0;
					scan.nextLine();
				}
				errFlag=1;
			}while(menu<1 || menu>4);
			switch(menu)
			{
			case 1:{
				viewTeacher(teacherVec);
			}
			break;
			case 2:{
				add(teacherVec, kelasVec);
			}
			break;
			case 3:{
				deleteTeacher(teacherVec);
			}
			break;
			}
		}while(menu!=4);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}

}
