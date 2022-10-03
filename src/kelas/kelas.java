package kelas;

import java.util.Random;


public class kelas {
	private String kelasName;
	private int kelasNumber;
	
	public kelas(String kelasName, int kelasNumber)
	{
		this.kelasName = kelasName;
		this.kelasNumber = kelasNumber;
	}

	public String getKelasName() {
		return kelasName;
	}

	public void setKelasName(String kelasName) {
		this.kelasName = kelasName;
	}

	public int getKelasNumber() {
		return kelasNumber;
	}

	public void setKelasNumber(int kelasNumber) {
		this.kelasNumber = kelasNumber;
	}
	
	
}
