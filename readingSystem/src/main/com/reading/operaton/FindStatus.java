package com.reading.operaton;

public class FindStatus {

	int totalFees = 1000;// from Fixed fees table
	int totalFeesPaid = 667;// from fees table
	double feesPerMonth;
	double feesToCompare;
	int month;
	int admissionType = 3;// from student table
	String joinDate = "20-10-2018";// from student table
	FindMonth fm = new FindMonth();

	public String getStatus() {
		month = fm.getMonth(joinDate);
		try {
			if (month != 0) {

				feesPerMonth = (totalFees / admissionType);

				feesToCompare = totalFeesPaid / ((month + 1) * feesPerMonth);
				if (feesToCompare > 1) {
					return "CLEAR";
				} else {
					return "PENDING";
				}
			} else {
				feesPerMonth = (totalFees / admissionType);
				if (feesPerMonth <= totalFeesPaid) {
					return "CLEAR";
				} else {
					return "PENDING";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	public static void main(String[] args) {
//		FindStatus f = new FindStatus();
//		System.out.println(f.getStatus());
//	}
}
